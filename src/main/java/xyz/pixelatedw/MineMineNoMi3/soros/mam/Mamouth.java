package xyz.pixelatedw.MineMineNoMi3.soros.mam;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketEntityVelocity;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class Mamouth {
  static {
    Values.abilityWebAppExtraParams.put("Mamouth Point", new String[] { "desc", "Turns you into a Mammoth." });
    Values.abilityWebAppExtraParams.put("Ancient Rush", new String[] { "desc", "Make you faster" });
    Values.abilityWebAppExtraParams.put("Ancient Blow", new String[] { "desc", "Blow Entity ." });
    Values.abilityWebAppExtraParams.put("Ancient Stomp", new String[] { "desc", "Stomp entity " });
    Values.abilityWebAppExtraParams.put("Ancient Trunk Shot", new String[] { "desc", "Send a projectile to entity" });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new MamouthPoint(), new AncientRush(), new AncientBlow(), new AncientStomp(), new AncientTrunkShot() };
  
  public static class MamouthPoint extends Ability {
    public MamouthPoint() {
      super(ListAttributes.MamouthPoint);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("mamouth")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("mamouth");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setZoanPoint("n/a");
      player.capabilities.allowFlying = false;
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
  }
  
  public static class AncientRush extends Ability {
    private int initialY;
    
    public AncientRush() {
      super(ListAttributes.AncientRush);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("mamouth") && !this.isOnCooldown) {
        double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        this.initialY = (int)player.posY;
        double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
        mX /= f2;
        mZ /= f2;
        mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mX *= 4.0D;
        mZ *= 4.0D;
        Mamouth.motion("=", mX, player.motionY, mZ, player);
        super.use(player);
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown > 180 && player.posY >= this.initialY) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 1.6D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 12.0F * props.getDamageMultiplier()); 
        for (int[] location : WyHelper.getBlockLocationsNearby((EntityLivingBase)player, 3)) {
          if (location[1] >= player.posY)
            if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, new String[] { "core", "foliage" }))
              WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], 128.0D);  
        } 
      } 
    }
  }
  
  public static class AncientBlow extends Ability {
    public AncientBlow() {
      super(ListAttributes.AncientBlowDamage);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      super.passive(player);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("mamouth")) {
        super.hitEntity(player, target);
        target.attackEntityFrom(DamageSource.causePlayerDamage(player), 20.0F * props.getDamageMultiplier());
        AbilityExplosion explosion = WyHelper.newExplosion((Entity)target, target.posX, target.posY, target.posZ, 1.0D);
        explosion.setExplosionSound(false);
        explosion.setDamageOwner(false);
        explosion.setDestroyBlocks(false);
        explosion.doExplosion();
        double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
        mX /= f2;
        mZ /= f2;
        mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mX *= -2.7D;
        mZ *= -2.7D;
        WyNetworkHelper.sendToAll((IMessage)new PacketEntityVelocity(target.getEntityId(), mX, 0.1D, mZ));
      } 
    }
  }
  
  public static class AncientStomp extends Ability {
    public AncientStomp() {
      super(ListAttributes.AncientStomp);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("mamouth")) {
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("greatStomp", player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)player, 10.0D)) {
          entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 40.0F);
          entity.setPositionAndUpdate(entity.posX, entity.posY + 3.0D, entity.posZ);
        } 
        super.use(player);
      } 
    }
  }
  
  public static class AncientTrunkShot extends Ability {
    public AncientTrunkShot() {
      super(ListAttributes.AncientTrunkShot);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!props.getZoanPoint().equals("mamouth"))
        return; 
      this.projectile = new MamouthProjo.Trunk(player.worldObj, (EntityLivingBase)player, ListAttributes.AncientTrunkShot);
      super.use(player);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
