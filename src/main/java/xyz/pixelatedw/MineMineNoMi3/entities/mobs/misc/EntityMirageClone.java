package xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class EntityMirageClone extends EntityMob {
  private EntityPlayer owner;
  
  public EntityMirageClone(World worldIn, EntityPlayer owner) {
    this(worldIn);
    setOwner(owner);
    this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
    this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0D));
    this.tasks.addTask(3, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
    this.tasks.addTask(4, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
  }
  
  public EntityMirageClone(World worldIn) {
    super(worldIn);
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
    getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10.0D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
  }
  
  public boolean isAIEnabled() {
    return true;
  }
  
  public void setDead() {
    if (!this.worldObj.isRemote)
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("kemuriBoshi", this.posX, this.posY, this.posZ), this.dimension, this.posX, this.posY, this.posZ, 128.0D); 
    super.setDead();
  }
  
  public void onEntityUpdate() {
    if (!this.worldObj.isRemote && this.owner == null)
      setDead(); 
    setRevengeTarget((EntityLivingBase)this.owner);
    if (this.ticksExisted > 200)
      setDead(); 
    super.onEntityUpdate();
  }
  
  private void setOwner(EntityPlayer player) {
    this.owner = player;
  }
  
  public EntityPlayer getOwner() {
    return this.owner;
  }
}
