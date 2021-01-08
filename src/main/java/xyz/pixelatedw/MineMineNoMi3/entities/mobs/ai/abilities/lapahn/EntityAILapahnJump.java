package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.lapahn;

import net.minecraft.entity.Entity;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityLapahn;

public class EntityAILapahnJump extends EntityAICooldown {
  private EntityLapahn entity;
  
  private int hitCount;
  
  private int maxCount;
  
  private float prevHealth;
  
  private double speed;
  
  public EntityAILapahnJump(EntityLapahn entity) {
    super((EntityNewMob)entity, 40, 5);
    this.entity = entity;
    this.speed = 1.5D;
    this.maxCount = 2;
    this.prevHealth = this.entity.getHealth();
  }
  
  public boolean shouldExecute() {
    if (this.entity.getAttackTarget() == null)
      return false; 
    if (this.entity.getHealth() < this.prevHealth) {
      this.hitCount++;
      this.prevHealth = this.entity.getHealth();
    } 
    float distance = this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget());
    if (distance > 10.0F && distance < 2.0F)
      return false; 
    if (this.hitCount < this.maxCount)
      return false; 
    execute();
    return true;
  }
  
  public void execute() {
    this.entity.motionY = 2.0D;
    this.hitCount = 0;
  }
}
