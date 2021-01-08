package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class ChiyuAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new HealingTouch(), new Chiyupopo() };
  
  public static class Chiyupopo extends Ability {
    public Chiyupopo() {
      super(ListAttributes.CHIYUPOPO);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)player, 20.0D))
          entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0)); 
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("chiyupopo", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        super.use(player);
      } 
    }
  }
  
  public static class HealingTouch extends Ability {
    public HealingTouch() {
      super(ListAttributes.HEALING_TOUCH);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      target.setHealth(target.getHealth() + 20.0F);
      target.addPotionEffect(new PotionEffect(Potion.regeneration.id, 400, 1));
      super.hitEntity(player, target);
      AbilityExplosion explosion = WyHelper.newExplosion((Entity)player, target.posX, target.posY, target.posZ, 2.0D);
      explosion.setExplosionSound(false);
      explosion.setDamageOwner(false);
      explosion.setDestroyBlocks(false);
      explosion.setDamageEntities(false);
      explosion.setSmokeParticles("healingTouch");
      explosion.doExplosion();
      this.passiveActive = false;
      startCooldown();
      startExtUpdate(player);
    }
  }
}
