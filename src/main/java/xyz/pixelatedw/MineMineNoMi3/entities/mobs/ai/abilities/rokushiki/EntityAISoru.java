package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki;

import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;

public class EntityAISoru extends EntityAICooldown {
  private EntityNewMob entity;
  
  private UUID soruSpeedUUID = UUID.fromString("4929edc3-45e7-4763-aecc-d478f5eadc3b");
  
  private AttributeModifier speedModifier;
  
  public EntityAISoru(EntityNewMob entity) {
    super(entity, 40, (int)WyMathHelper.randomWithRange(5, 10));
    this.entity = entity;
  }
  
  public boolean shouldExecute() {
    if (isOnCooldown()) {
      IAttributeInstance soruSpeed = this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
      if (this.cooldown < this.maxCooldown / 2 && soruSpeed.getModifier(this.soruSpeedUUID) != null)
        soruSpeed.removeModifier(this.speedModifier); 
      countDownCooldown();
      return false;
    } 
    if (isOnCooldown()) {
      countDownCooldown();
      return false;
    } 
    if (this.entity.getAttackTarget() == null)
      return false; 
    float distance = this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget());
    if (distance > 15.0F && distance <= 25.0F) {
      execute(0.3D);
      return true;
    } 
    if (distance > 25.0F) {
      execute(0.4D);
      return true;
    } 
    return false;
  }
  
  public void endCooldown() {
    super.endCooldown();
    this.entity.setCurrentAI(null);
    this.entity.setPreviousAI((EntityAIBase)this);
  }
  
  public void execute(double level) {
    IAttributeInstance soruSpeed = this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
    if (soruSpeed.getModifier(this.soruSpeedUUID) != null && this.speedModifier != null)
      soruSpeed.removeModifier(this.speedModifier); 
    this.speedModifier = new AttributeModifier(this.soruSpeedUUID, "Soru Speed", level, 0);
    this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(this.speedModifier);
    this.entity.setCurrentAI((EntityAIBase)this);
    setOnCooldown(true);
  }
}
