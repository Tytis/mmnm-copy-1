package xyz.pixelatedw.MineMineNoMi3.soros.eo;

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
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class Leopard {
  static {
    Values.abilityWebAppExtraParams.put("Leopard Point", new String[] { "desc", "Turns you into a leopard." });
    Values.abilityWebAppExtraParams.put("Hybrid Leopard Point", new String[] { "desc", " Turns you into the hybrid" });
    Values.abilityWebAppExtraParams.put("Rankyaku Hyobi", new String[] { "desc", "Basically a spam of the already existing Rankyaku" });
    Values.abilityWebAppExtraParams.put("Sai Dai Rin: Rokuogan ", new String[] { "desc", "does Huge knock back " });
    Values.abilityWebAppExtraParams.put("Leopard Mawl", new String[] { "desc", "Send a projectile to entity" });
    Values.abilityWebAppExtraParams.put("Leopard Spring Jump", new String[] { "desc", "Just a copy of spring hopper from bane bane no mi but less height on the jump like 8 blocks less" });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new LeopardPoint(), new HybridPoint(), new Rankyaku(), new Sai(), new Mawl(), new LSpringHopper() };
  
  public static class LSpringHopper extends Ability {
    public LSpringHopper() {
      super(ListAttributes.LEOPARD_SPRING_HOPPER);
    }
    
    public void endCharging(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      WyHelper.Direction dir = WyHelper.get8Directions((Entity)player);
      if ((!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("leopard")) || (props.getZoanPoint().equals("hybridleopard") && !this.isOnCooldown)) {
        if (player.onGround) {
          Leopard.motion("+", 0.0D, 1.5333333333333332D, 0.0D, player);
        } else {
          Leopard.motion("+", 0.0D, 1.485D, 0.0D, player);
        } 
        if (dir == WyHelper.Direction.NORTH)
          Leopard.motion("-", 0.0D, 0.0D, 1.9D, player); 
        if (dir == WyHelper.Direction.NORTH_WEST)
          Leopard.motion("-", 1.9D, 0.0D, 1.9D, player); 
        if (dir == WyHelper.Direction.SOUTH)
          Leopard.motion("+", 0.0D, 0.0D, 1.9D, player); 
        if (dir == WyHelper.Direction.NORTH_EAST) {
          Leopard.motion("-", 0.0D, 0.0D, 1.9D, player);
          Leopard.motion("+", 1.9D, 0.0D, 0.0D, player);
        } 
        if (dir == WyHelper.Direction.WEST)
          Leopard.motion("-", 1.9D, 0.0D, 0.0D, player); 
        if (dir == WyHelper.Direction.SOUTH_WEST) {
          Leopard.motion("+", 0.0D, 0.0D, 1.9D, player);
          Leopard.motion("-", 1.9D, 0.0D, 0.0D, player);
        } 
        if (dir == WyHelper.Direction.EAST)
          Leopard.motion("+", 1.9D, 0.0D, 0.0D, player); 
        if (dir == WyHelper.Direction.SOUTH_EAST)
          Leopard.motion("+", 1.9D, 0.0D, 1.9D, player); 
      } 
      super.endCharging(player);
    }
  }
  
  public static class LeopardPoint extends Ability {
    public LeopardPoint() {
      super(ListAttributes.LeopardPoint);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("leopard")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("leopard");
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
  
  public static class HybridPoint extends Ability {
    public HybridPoint() {
      super(ListAttributes.LeopardHybridPoint);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("hybridleopard")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("hybridleopard");
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
  
  public static class Rankyaku extends Ability {
    public Rankyaku() {
      super(ListAttributes.RankyakuHyobi);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if ((!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("leopard")) || (props.getZoanPoint().equals("hybridleopard") && !this.isOnCooldown))
        this.projectile = new LeopardProjo.Rankyaku(player.worldObj, (EntityLivingBase)player, ListAttributes.RankyakuHyobi); 
      super.use(player);
    }
  }
  
  public static class Sai extends Ability {
    public Sai() {
      super(ListAttributes.SaiDaiRinRokuogan);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      super.hitEntity(player, target);
      target.attackEntityFrom(DamageSource.causePlayerDamage(player), 60.0F);
      target.knockBack((Entity)target, 20.0F, 20.0D, 20.0D);
    }
  }
  
  public static class Mawl extends Ability {
    private int initialY;
    
    public Mawl() {
      super(ListAttributes.LeopardMawl);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if ((!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("leopard")) || (props.getZoanPoint().equals("hybridleopard") && !this.isOnCooldown)) {
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
        Leopard.motion("=", mX, player.motionY, mZ, player);
        super.use(player);
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown > 180 && player.posY >= this.initialY) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 3.0D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 50.0F); 
        for (int[] location : WyHelper.getBlockLocationsNearby((EntityLivingBase)player, 5)) {
          if (location[1] >= player.posY)
            if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, new String[] { "core", "foliage" }))
              WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], 128.0D);  
        } 
      } 
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
