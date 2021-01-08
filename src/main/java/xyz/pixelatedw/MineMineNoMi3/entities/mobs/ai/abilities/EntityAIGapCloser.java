package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;

public class EntityAIGapCloser extends EntityAIBase {
  private EntityNewMob entity;
  
  private int hitCount;
  
  private int maxCount;
  
  private float prevHealth;
  
  private double speed;
  
  public EntityAIGapCloser(EntityNewMob entity) {
    this.entity = entity;
    this.speed = 1.5D;
    this.maxCount = 3;
    this.prevHealth = this.entity.getHealth();
  }
  
  public EntityAIGapCloser setSpeed(double speed) {
    this.speed = speed;
    return this;
  }
  
  public EntityAIGapCloser setMaxCounter(int counter) {
    this.maxCount = counter;
    return this;
  }
  
  public boolean shouldExecute() {
    if (this.entity.getAttackTarget() == null)
      return false; 
    if (this.entity.getHealth() < this.prevHealth) {
      this.hitCount++;
      this.prevHealth = this.entity.getHealth();
    } 
    float distance = this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget());
    if (distance > 14.0F && distance < 2.0F)
      return false; 
    if (this.hitCount < this.maxCount)
      return false; 
    execute();
    return true;
  }
  
  public void execute() {
    double mX = (-MathHelper.sin(this.entity.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.entity.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
    double mZ = (MathHelper.cos(this.entity.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.entity.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
    double f2 = MathHelper.sqrt_double(mX * mX + this.entity.motionY * this.entity.motionY + mZ * mZ);
    mX /= f2;
    mZ /= f2;
    mX += this.entity.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
    mZ += this.entity.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
    mX *= this.speed;
    mZ *= this.speed;
    this.entity.motionX = mX;
    this.entity.motionZ = mZ;
    this.hitCount = 0;
  }
}
