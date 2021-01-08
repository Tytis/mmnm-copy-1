package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.projectile.EntityThrowable;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class EntityAIGeppo extends EntityAICooldown {
  private EntityNewMob entity;
  
  public EntityAIGeppo(EntityNewMob entity) {
    super(entity, 80, (int)WyMathHelper.randomWithRange(2, 7));
    this.entity = entity;
  }
  
  public boolean shouldExecute() {
    this.entity.fallDistance = 0.0F;
    if (WyHelper.getEntitiesNear((Entity)this.entity, 7.0D, new Class[] { EntityThrowable.class }).size() > 0) {
      if (this.cooldown > this.maxCooldown / 2 && this.cooldown < this.maxCooldown)
        return false; 
      execute();
      return true;
    } 
    if (isOnCooldown()) {
      countDownCooldown();
      return false;
    } 
    if (this.entity.getAttackTarget() == null)
      return false; 
    float distance = this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget());
    if (distance > 5.0F && this.entity.getHealth() > this.entity.getMaxHealth() / 4.0F)
      return false; 
    execute();
    return true;
  }
  
  public void endCooldown() {
    super.endCooldown();
    this.entity.setCurrentAI(null);
    this.entity.setPreviousAI((EntityAIBase)this);
  }
  
  public void execute() {
    this.entity.motionY = 1.3D;
    WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("geppo", this.entity.posX, this.entity.posY, this.entity.posZ), this.entity.dimension, this.entity.posX, this.entity.posY, this.entity.posZ, 128.0D);
    this.entity.setCurrentAI((EntityAIBase)this);
    setOnCooldown(true);
  }
}
