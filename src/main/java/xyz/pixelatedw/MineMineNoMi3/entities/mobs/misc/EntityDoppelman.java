package xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class EntityDoppelman extends EntityMob {
  private EntityPlayer owner;
  
  public boolean isAggressive = true;
  
  public List<EntityLivingBase> forcedTargets = new ArrayList<>();
  
  public EntityDoppelman(World worldIn, EntityPlayer owner) {
    this(worldIn);
    setOwner(owner);
    this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, true));
    this.tasks.addTask(2, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
    this.tasks.addTask(3, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0D));
    this.tasks.addTask(4, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
    this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    this.tasks.addTask(6, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
    this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, MarineData.class, 8.0F));
    this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, PirateData.class, 8.0F));
    this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
  }
  
  public EntityDoppelman(World worldIn) {
    super(worldIn);
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
    getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10.0D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
  }
  
  public boolean attackEntityFrom(DamageSource damageSource, float damageValue) {
    if (damageSource.getEntity() != null && damageSource.getEntity() instanceof EntityPlayer && damageSource.getEntity() == this.owner)
      return false; 
    return super.attackEntityFrom(damageSource, damageValue);
  }
  
  public boolean isAIEnabled() {
    return true;
  }
  
  public void onEntityUpdate() {
    if (!this.worldObj.isRemote && this.owner == null)
      setDead(); 
    if (!this.worldObj.isRemote && this.owner != null) {
      if (getDistanceToEntity((Entity)this.owner) > 10.0F)
        getNavigator().tryMoveToEntityLiving((Entity)this.owner, 1.5D); 
      if (getDistanceToEntity((Entity)this.owner) > 80.0F)
        setPositionAndUpdate(this.owner.posX, this.owner.posY, this.owner.posZ); 
      ExtendedEntityData ownerProps = ExtendedEntityData.get((EntityLivingBase)this.owner);
      List<EntityLivingBase> doppelmanAttackList = this.isAggressive ? WyHelper.getEntitiesNear((Entity)this, 10.0D, new Class[] { EntityPlayer.class, MarineData.class, PirateData.class }) : (!this.forcedTargets.isEmpty() ? this.forcedTargets : new ArrayList<>());
      if (!ownerProps.getUsedFruit().equalsIgnoreCase("kagekage"))
        setDead(); 
      if (!doppelmanAttackList.isEmpty()) {
        if (doppelmanAttackList.contains(this.owner))
          doppelmanAttackList.remove(this.owner); 
        if (ownerProps.isMarine())
          doppelmanAttackList = (List<EntityLivingBase>)doppelmanAttackList.stream().filter(x -> !(x instanceof MarineData)).collect(Collectors.toList()); 
        EntityLivingBase target = doppelmanAttackList.stream().findFirst().orElse(null);
        if (target != null)
          setAttackTarget(target); 
      } 
      if (!this.forcedTargets.isEmpty()) {
        Iterator<EntityLivingBase> it = this.forcedTargets.iterator();
        while (it.hasNext()) {
          EntityLivingBase forcedTarget = it.next();
          if (forcedTarget == null || !forcedTarget.isEntityAlive())
            it.remove(); 
        } 
      } 
    } 
    super.onEntityUpdate();
  }
  
  public boolean attackEntityAsMob(Entity target) {
    float f = (float)getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() + (ExtendedEntityData.get((EntityLivingBase)this).getDoriki() * 4);
    int i = 0;
    if (target instanceof EntityLivingBase) {
      f += EnchantmentHelper.getEnchantmentModifierLiving((EntityLivingBase)this, (EntityLivingBase)target);
      i += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)target);
    } 
    boolean flag = target.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), f);
    if (flag)
      if (i > 0) {
        target.addVelocity((-MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F) * i * 0.5F), 0.1D, (MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F) * i * 0.5F));
        this.motionX *= 0.6D;
        this.motionZ *= 0.6D;
      }  
    return flag;
  }
  
  public boolean interact(EntityPlayer player) {
    if (player == this.owner) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)this);
      ItemStack heldItem = player.getHeldItem();
      if (heldItem != null && heldItem.getItem() == ListMisc.Shadow && heldItem.stackSize >= 10 && props.getDoriki() < 6) {
        heldItem.stackSize -= 10;
        props.alterDoriki(1);
        WyNetworkHelper.sendToAllAround((IMessage)new PacketSyncInfo(getEntityId(), props), this.dimension, this.posX, this.posY, this.posZ, 128.0D);
      } 
    } 
    return false;
  }
  
  private void setOwner(EntityPlayer player) {
    this.owner = player;
  }
  
  public EntityPlayer getOwner() {
    return this.owner;
  }
}
