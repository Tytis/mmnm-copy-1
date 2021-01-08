package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class YomiAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new KasuriutaFubukiGiri(), new SoulParade() };
  
  public static class SoulParade extends Ability {
    public SoulParade() {
      super(ListAttributes.SOUL_PARADE);
    }
    
    public void passive(EntityPlayer player) {
      if (ItemsHelper.isSword(player.getHeldItem())) {
        super.passive(player);
      } else {
        WyHelper.sendMsgToPlayer(player, "You need a sword to use this ability !");
      } 
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (passiveTimer > 400 || player.getHeldItem() == null || !ItemsHelper.isSword(player.getHeldItem())) {
        setPassiveActive(false);
        startCooldown();
        startExtUpdate(player);
        super.endPassive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class KasuriutaFubukiGiri extends Ability {
    public KasuriutaFubukiGiri() {
      super(ListAttributes.KASURIUTA_FUBUKI_GIRI);
    }
    
    public void use(EntityPlayer player) {
      if (ItemsHelper.isSword(player.getHeldItem())) {
        if (!this.isOnCooldown) {
          double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
          double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
          double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
          mX /= f2;
          mZ /= f2;
          mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
          mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
          mX *= 5.0D;
          mZ *= 5.0D;
          YomiAbilities.motion("=", mX, player.motionY, mZ, player);
          if (player.worldObj instanceof WorldServer)
            ((WorldServer)player.worldObj).getEntityTracker().func_151248_b((Entity)player, (Packet)new S0BPacketAnimation((Entity)player, 0)); 
        } 
        super.use(player);
      } else {
        WyHelper.sendMsgToPlayer(player, "You need a sword to use this ability !");
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown > 120) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 1.6D)) {
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 8.0F * props.getDamageMultiplier());
          e.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
          e.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 100, 5));
          AbilityExplosion explosion = WyHelper.newExplosion((Entity)player, e.posX, e.posY, e.posZ, 2.0D);
          explosion.setExplosionSound(false);
          explosion.setDamageOwner(false);
          explosion.setDestroyBlocks(false);
          explosion.setSmokeParticles("soulParade");
          explosion.doExplosion();
        } 
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("kasuriutaFubukiGiri", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      } 
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
