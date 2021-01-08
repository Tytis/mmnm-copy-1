package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.RokushikiProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class EntityAIRankyaku extends EntityAICooldown {
  private EntityNewMob entity;
  
  public EntityAIRankyaku(EntityNewMob entity) {
    super(entity, 120, entity.getRNG().nextInt(10));
    this.entity = entity;
  }
  
  public boolean shouldExecute() {
    ItemStack itemStack = this.entity.getHeldItem();
    if (this.entity.getAttackTarget() == null)
      return false; 
    if (this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget()) < 5.0F)
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
    double d0 = this.entity.getDistanceSqToEntity((Entity)this.entity.getAttackTarget());
    float f = MathHelper.sqrt_float(MathHelper.sqrt_double(d0));
    double d1 = (this.entity.getAttackTarget()).posX - this.entity.posX;
    double d2 = (this.entity.getAttackTarget()).boundingBox.minY + ((this.entity.getAttackTarget()).height / 2.0F) - this.entity.posY + (this.entity.height / 2.0F);
    double d3 = (this.entity.getAttackTarget()).posZ - this.entity.posZ;
    RokushikiProjectiles.Rankyaku projectile = new RokushikiProjectiles.Rankyaku(this.entity.worldObj, (EntityLivingBase)this.entity, ListAttributes.RANKYAKU);
    projectile.posY = this.entity.posY + (this.entity.height / 2.0F) + 0.5D;
    projectile.setThrowableHeading(d1 + this.entity.getRNG().nextGaussian(), d2, d3 + this.entity.getRNG().nextGaussian(), 1.0F, 0.0F);
    this.entity.worldObj.spawnEntityInWorld((Entity)projectile);
    this.entity.setCurrentAI((EntityAIBase)this);
    setOnCooldown(true);
  }
}
