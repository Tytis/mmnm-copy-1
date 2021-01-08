package xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.swordsman;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAICooldown;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class EntityAIOTasumaki extends EntityAICooldown {
  private EntityNewMob entity;
  
  private double damage;
  
  public EntityAIOTasumaki(EntityNewMob entity) {
    super(entity, 80, entity.getRNG().nextInt(20));
    this.entity = entity;
    this.damage = this.entity.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
  }
  
  public boolean shouldExecute() {
    ItemStack itemStack = this.entity.getHeldItem();
    if (itemStack == null || this.entity.getAttackTarget() == null)
      return false; 
    if (this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget()) > 3.0F || this.entity.getDistanceToEntity((Entity)this.entity.getAttackTarget()) < 2.0F)
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
    for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)this.entity, 4.0D)) {
      e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.entity), (float)this.damage);
      e.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 1, true));
    } 
    WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("kokuteiCross", (EntityLivingBase)this.entity), this.entity.dimension, this.entity.posX, this.entity.posY, this.entity.posZ, 128.0D);
    this.entity.setCurrentAI((EntityAIBase)this);
    setOnCooldown(true);
  }
}
