package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MokuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class MokuAbilities {
  static {
    Values.abilityWebAppExtraParams.put("whiteout", new String[] { "desc", "Shoots clouds of smoke to engulf the opponent and trap them." });
    Values.abilityWebAppExtraParams.put("whitesnake", new String[] { "desc", "Launches a long dense smoke cloud in the shape of a snake to grab the opponent and damage them." });
    Values.abilityWebAppExtraParams.put("whitelauncher", new String[] { "desc", "Transforms the user into smoke and launches them forward." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new WhiteOut(), new WhiteSnake(), new WhiteLauncher(), new WhiteStrike() };
  
  public static class WhiteStrike extends Ability {
    public WhiteStrike() {
      super(ListAttributes.WHITE_STRIKE);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown())
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("whiteStrike", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D); 
      super.use(player);
    }
  }
  
  public static class WhiteLauncher extends Ability {
    public WhiteLauncher() {
      super(ListAttributes.WHITE_LAUNCHER);
    }
    
    public void endCharging(EntityPlayer player) {
      double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
      double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
      double mY = -MathHelper.sin((player.rotationPitch + 0.0F) / 180.0F * 3.1415927F) * 0.4D;
      double f2 = MathHelper.sqrt_double(mX * mX + mY * mY + mZ * mZ);
      mX /= f2;
      mY /= f2;
      mZ /= f2;
      mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
      mY += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
      mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
      mX *= 5.0D;
      mY *= 1.5D;
      mZ *= 5.0D;
      MokuAbilities.motion("=", mX, mY, mZ, player);
      super.endCharging(player);
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown / 20 > ListAttributes.WHITE_LAUNCHER.getAbilityCooldown() / 20 - 3) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 1.6D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 2.0F * props.getDamageMultiplier()); 
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("whiteLauncher", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      } 
    }
  }
  
  public static class WhiteSnake extends Ability {
    public WhiteSnake() {
      super(ListAttributes.WHITE_SNAKE);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new MokuProjectiles.WhiteSnake(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class WhiteOut extends Ability {
    public WhiteOut() {
      super(ListAttributes.WHITE_OUT);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new MokuProjectiles.WhiteOut(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
