package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.brawler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;

public class EntityAIHakaiHo extends EntityAICooldown {
  private EntityNewMob entity;
  
  private double damage;
  
  public EntityAIHakaiHo(EntityNewMob entity) {
    super(entity, 90, entity.getRNG().nextInt(20));
    this.entity = entity;
    this.damage = this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
  }
  
  public boolean shouldExecute() {
    ItemStack itemStack = this.entity.getHeldItem();
    if (itemStack != null || this.entity.getAttackTarget() == null)
      return false; 
    if (this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget()) > 2.0F)
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
    AbilityExplosion explosion = WyHelper.newExplosion((Entity)this.entity, (this.entity.getAttackTarget()).posX, (this.entity.getAttackTarget()).posY, (this.entity.getAttackTarget()).posZ, 2.0D);
    explosion.setDamageOwner(false);
    explosion.setDestroyBlocks(false);
    explosion.doExplosion();
    this.entity.setCurrentAI((EntityAIBase)this);
    setOnCooldown(true);
  }
}
