package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ZouProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketEntityVelocity;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketNewAABB;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class ZouAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new ZouPoint(), new HybridPoint(), new IvoryDart(), new IvoryStomp(), new GreatStomp(), new TrunkShot() };
  
  public static class TrunkShot extends Ability {
    public TrunkShot() {
      super(ListAttributes.TRUNK_SHOT);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!props.getZoanPoint().equals("full") && !props.getZoanPoint().equals("hybrid")) {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Zou Point or Hybrid Point are active !");
        return;
      } 
      this.projectile = (AbilityProjectile)new ZouProjectiles.TrunkShot(player.worldObj, (EntityLivingBase)player, ListAttributes.TRUNK_SHOT);
      super.use(player);
    }
  }
  
  public static class GreatStomp extends Ability {
    public GreatStomp() {
      super(ListAttributes.GREAT_STOMP);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!props.getZoanPoint().equals("full")) {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Zou Point is active !");
        return;
      } 
      if (!this.isOnCooldown) {
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("greatStomp", player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)player, 10.0D)) {
          entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 10.0F * props.getDamageMultiplier());
          entity.setPositionAndUpdate(entity.posX, entity.posY + 3.0D, entity.posZ);
        } 
        super.use(player);
      } 
    }
  }
  
  public static class IvoryStomp extends Ability {
    public IvoryStomp() {
      super(ListAttributes.IVORY_STOMP);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!props.getZoanPoint().equals("hybrid")) {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Hybrid Point is active !");
      } else {
        super.passive(player);
      } 
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("hybrid")) {
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
      } else {
        setPassiveActive(false);
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Hybrid Point is active !");
      } 
    }
  }
  
  public static class IvoryDart extends Ability {
    private int initialY;
    
    public IvoryDart() {
      super(ListAttributes.IVORY_DART);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("full") && !this.isOnCooldown) {
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
        ZouAbilities.motion("=", mX, player.motionY, mZ, player);
        super.use(player);
      } else if (!props.getZoanPoint().equals("full")) {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Zou Point is active !");
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
  
  public static class ZouPoint extends Ability {
    public ZouPoint() {
      super(ListAttributes.ZOU_FULL_POINT);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("full")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(1.5F, 2.5F), (EntityPlayerMP)player);
      props.setZoanPoint("full");
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
  
  public static class HybridPoint extends Ability {
    public HybridPoint() {
      super(ListAttributes.ZOU_HYBRID_POINT);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("hybrid")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(1.5F, 2.5F), (EntityPlayerMP)player);
      props.setZoanPoint("hybrid");
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
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
