package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;

public class EntityAIKnockback extends EntityAICooldown {
  private EntityNewMob entity;
  
  public EntityAIKnockback(EntityNewMob entity) {
    super(entity, 100, entity.getRNG().nextInt(20));
    this.entity = entity;
  }
  
  public boolean shouldExecute() {
    ItemStack itemStack = this.entity.getHeldItem();
    if (itemStack != null || this.entity.getAttackTarget() == null)
      return false; 
    if (this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget()) > 3.0F)
      return false; 
    if (isOnCooldown()) {
      countDownCooldown();
      return false;
    } 
    execute();
    return true;
  }
  
  public void endCooldown() {
    super.endCooldown();
    this.entity.setCurrentAI(null);
    this.entity.setPreviousAI((EntityAIBase)this);
  }
  
  public void execute() {
    double mX = (-MathHelper.sin(this.entity.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.entity.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
    double mZ = (MathHelper.cos(this.entity.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.entity.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
    double f2 = MathHelper.sqrt_double(mX * mX + this.entity.motionY * this.entity.motionY + mZ * mZ);
    mX /= f2;
    mZ /= f2;
    mX += this.entity.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
    mZ += this.entity.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
    mX *= 4.0D;
    mZ *= 4.0D;
    (this.entity.getAttackTarget()).motionX = mX;
    (this.entity.getAttackTarget()).motionZ = mZ;
    this.entity.setCurrentAI((EntityAIBase)this);
    setOnCooldown(true);
  }
}
