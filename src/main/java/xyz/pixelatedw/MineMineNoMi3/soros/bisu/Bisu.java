package xyz.pixelatedw.MineMineNoMi3.soros.bisu;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class Bisu {
  static {
    Values.abilityWebAppExtraParams.put("Bisu Hei", new String[] { "desc", "Sends a Biscuit Soldier out as a projectile" });
    Values.abilityWebAppExtraParams.put("Bisu Hei Transformation", new String[] { "desc", "You turn into a biscuit soldier and gain res 3 and slowness 2 for 15 seconds and knock back resistance" });
    Values.abilityWebAppExtraParams.put("Bisu Shot", new String[] { "desc", "Throws a Biscuit as a projectile" });
    Values.abilityWebAppExtraParams.put("Bisu Shot Barrage", new String[] { "desc", "Throws multiple Biscuit projectiles" });
    Values.abilityWebAppExtraParams.put("Bisu Thrust", new String[] { "desc", "Thrusts you forward and deals AoE damage to whatever is in front of you. (Copy of ivory dart from Zou Zou)" });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new BisuHei(), new BisuHeiTransformation(), new BisuShot(), new BisuShotBarrage(), new BisuThrust() };
  
  public static class BisuShotBarrage extends Ability {
    public BisuShotBarrage() {
      super(ListAttributes.BisuShotBarrage);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new BisuProjo.Trunk(player.worldObj, (EntityLivingBase)player, ListAttributes.BisuShotBarrage);
      super.use(player);
    }
  }
  
  public static class BisuHei extends Ability {
    public BisuHei() {
      super(ListAttributes.BisuHei);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new BisuProjo.Light(player.worldObj, (EntityLivingBase)player, ListAttributes.BisuHei);
      super.use(player);
    }
  }
  
  public static class BisuThrust extends Ability {
    private int initialY;
    
    public BisuThrust() {
      super(ListAttributes.BisuThrust);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown) {
        double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        this.initialY = (int)player.posY;
        double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
        mX /= f2;
        mZ /= f2;
        mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mX *= 6.0D;
        mZ *= 6.0D;
        Bisu.motion("=", mX, player.motionY, mZ, player);
        super.use(player);
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown > 180) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 6.0D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 40.0F); 
        for (int[] location : WyHelper.getBlockLocationsNearby((EntityLivingBase)player, 3)) {
          if (location[1] >= player.posY)
            if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, new String[] { "core", "foliage" }))
              WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], 128.0D);  
        } 
      } 
    }
  }
  
  public static class BisuHeiTransformation extends Ability {
    public BisuHeiTransformation() {
      super(ListAttributes.BisuHeiPoint);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("bisupoint")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("bisupoint");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void endPassive(EntityPlayer player) {
      player.removePotionEffect(Potion.resistance.id);
      player.removePotionEffect(Potion.moveSlowdown.id);
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setZoanPoint("n/a");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
  }
  
  public static class BisuShot extends Ability {
    public BisuShot() {
      super(ListAttributes.BisuShot);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new BisuProjo.Fire(player.worldObj, (EntityLivingBase)player, ListAttributes.BisuShot);
      super.use(player);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
