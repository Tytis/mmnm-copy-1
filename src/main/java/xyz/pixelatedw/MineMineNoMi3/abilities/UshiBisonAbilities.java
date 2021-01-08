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
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketNewAABB;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class UshiBisonAbilities {
  static {
    Values.abilityWebAppExtraParams.put("bisonpowerpoint", new String[] { "desc", "The user transforms into a half-bison hybrid, which focuses on strength, Allows the user to use 'Kokutei Cross' and 'Fiddle Banff'" });
    Values.abilityWebAppExtraParams.put("bisonspeedpoint", new String[] { "desc", "" });
    Values.abilityWebAppExtraParams.put("kokuteicross", new String[] { "desc", "The transformed user crosses their hooves to hit the opponent." });
    Values.abilityWebAppExtraParams.put("fiddlebanff", new String[] { "desc", "The transformed user dashes towards the opponent to crash against them with great power." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new PowerPoint(), new SpeedPoint(), new FiddleBanff(), new KokuteiCross() };
  
  public static class PowerPoint extends Ability {
    public PowerPoint() {
      super(ListAttributes.BISON_POWER_POINT);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("power")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(1.5F, 2.5F), (EntityPlayerMP)player);
      props.setZoanPoint("power");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(0.6F, 1.8F), (EntityPlayerMP)player);
      props.setZoanPoint("n/a");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
  }
  
  public static class SpeedPoint extends Ability {
    public SpeedPoint() {
      super(ListAttributes.BISON_SPEED_POINT);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("speed")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("speed");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setZoanPoint("n/a");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
  }
  
  public static class FiddleBanff extends Ability {
    public FiddleBanff() {
      super(ListAttributes.FIDDLE_BANFF);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if ((props.getZoanPoint().equals("power") || props.getZoanPoint().equals("speed")) && !this.isOnCooldown) {
        double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
        mX /= f2;
        mZ /= f2;
        mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mX *= 5.0D;
        mZ *= 5.0D;
        UshiBisonAbilities.motion("=", mX, player.motionY, mZ, player);
        super.use(player);
      } else if (!props.getZoanPoint().equals("power") && !props.getZoanPoint().equals("speed")) {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Power Point or Speed Point is active !");
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      if (currentCooldown > 110)
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 1.6D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 6.0F);  
    }
  }
  
  public static class KokuteiCross extends Ability {
    public KokuteiCross() {
      super(ListAttributes.KOKUTEI_CROSS);
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      AbilityProperties abilityProps = AbilityProperties.get(player);
      if (!props.getZoanPoint().equals("power")) {
        setPassiveActive(false);
        WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(abilityProps), (EntityPlayerMP)player);
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Power Point is active !");
      } 
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("power")) {
        super.hitEntity(player, target);
        target.attackEntityFrom(DamageSource.causePlayerDamage(player), 20.0F);
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("kokuteiCross", target), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
        mX /= f2;
        mZ /= f2;
        mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mX *= -0.7D;
        mZ *= -0.7D;
        UshiBisonAbilities.motion("=", mX, player.motionY, mZ, player);
      } else {
        setPassiveActive(false);
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Power Point is active !");
      } 
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
