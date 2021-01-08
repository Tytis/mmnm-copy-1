package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectRustOverlay;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class SabiAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new RustTouch() };
  
  public static class RustTouch extends Ability {
    public RustTouch() {
      super(ListAttributes.RUST_TOUCH);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      if (!isOnCooldown()) {
        target.addPotionEffect(new PotionEffect(2, 120, 2));
        target.addPotionEffect(new PotionEffect(4, 120, 4));
        target.addPotionEffect(new PotionEffect(20, 120, 1));
        new DFEffectRustOverlay(target, 120);
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("rustTouch", target), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        super.hitEntity(player, target);
      } 
    }
  }
}
