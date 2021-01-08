package xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals;

import java.util.UUID;
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
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.lapahn.EntityAILapahnJump;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.lapahn.EntityAILapahnRage;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits.BanditData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;

public class EntityLapahn extends EntityNewMob {
  private UUID rageModeUUID = UUID.randomUUID();
  
  private AttributeModifier rageModeModifier = new AttributeModifier(this.rageModeUUID, "Rage Mode", 10.0D, 0);
  
  private boolean isEnraged;
  
  public EntityLapahn(World world) {
    super(world);
    setSize(0.8F, 2.5F);
    this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
    this.tasks.addTask(0, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, false));
    this.tasks.addTask(0, (EntityAIBase)new EntityAILapahnJump(this));
    this.tasks.addTask(0, (EntityAIBase)new EntityAILapahnRage(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0D));
    this.tasks.addTask(3, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
    this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
    this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
    this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, PirateData.class, 0, true));
    this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, BanditData.class, 0, true));
    this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, MarineData.class, 0, true));
  }
  
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
  }
  
  public void onEntityUpdate() {
    super.onEntityUpdate();
    if (!this.worldObj.isRemote);
  }
  
  public void writeEntityToNBT(NBTTagCompound nbt) {
    super.writeEntityToNBT(nbt);
    nbt.setBoolean("IsEnraged", this.isEnraged);
  }
  
  public void readEntityFromExtraNBT(NBTTagCompound nbt) {
    readEntityFromNBT(nbt);
  }
  
  public void readEntityFromNBT(NBTTagCompound nbt) {
    super.readEntityFromNBT(nbt);
    this.isEnraged = nbt.getBoolean("IsEnraged");
  }
  
  public boolean isAIEnabled() {
    return true;
  }
  
  public boolean isEnraged() {
    return this.isEnraged;
  }
  
  public void setEnraged(boolean value) {
    this.isEnraged = value;
    IAttributeInstance attackAttribute = getEntityAttribute(SharedMonsterAttributes.attackDamage);
    if (value && attackAttribute.getModifier(this.rageModeUUID) == null) {
      attackAttribute.applyModifier(this.rageModeModifier);
    } else if (!value && attackAttribute.getModifier(this.rageModeUUID) != null) {
      attackAttribute.removeModifier(this.rageModeModifier);
    } 
  }
  
  protected void dropFewItems(boolean flag, int looting) {
    int j = (int)(2.0D + WyMathHelper.randomWithRange(3 + looting, 5 + looting));
    for (int k = 0; k < j; k++) {
      if (isBurning()) {
        dropItem(Items.cooked_beef, 1);
      } else {
        dropItem(Items.beef, 1);
      } 
    } 
  }
  
  protected boolean canDespawn() {
    return true;
  }
  
  public void fall(float distance) {
    if (distance > 5.0F) {
      if (this.worldObj.isRemote)
        for (int i = 0; i < 256; i++) {
          double posX = this.posX + WyMathHelper.randomWithRange(-5, 5) + WyMathHelper.randomDouble();
          double posZ = this.posZ + WyMathHelper.randomWithRange(-5, 5) + WyMathHelper.randomDouble();
          this.worldObj.spawnParticle("explode", posX, this.posY + 0.5D, posZ, 0.0D, 0.1D, 0.0D);
          this.worldObj.spawnParticle("smoke", posX, this.posY + 0.5D, posZ, 0.0D, 0.1D, 0.0D);
        }  
      for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)this, 5.0D)) {
        if (!(entity instanceof EntityLapahn)) {
          entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 6.0F);
          entity.motionY = 0.5D;
        } 
      } 
    } 
  }
}
