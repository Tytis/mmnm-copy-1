package xyz.pixelatedw.MineMineNoMi3.soros.ptero;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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

public class Pteranodon {
  static {
    Values.abilityWebAppExtraParams.put("Smilodon Point", new String[] { "desc", "turns you into a pteranodon " });
    Values.abilityWebAppExtraParams.put("Pounce", new String[] { "desc", "possible make you go farther" });
    Values.abilityWebAppExtraParams.put("Smilodon Chomp", new String[] { "desc", "shigan" });
    Values.abilityWebAppExtraParams.put("Smilodon Stalk", new String[] { "desc", "akes everyone in a 20 block radius slow 3 for 10 seconds  " });
    Values.abilityWebAppExtraParams.put("Smilodon Leap", new String[] { "desc", "Make you jump" });
    Values.abilityWebAppExtraParams.put("Smilodon Claw Slash", new String[] { "desc", "Sends slash projectiles at enemies that does 20 damage each" });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new PteranodonPoint(), new Peck(), new WingedTornado(), new BeakRush(), new SmilodonClaw(), new SmilodonStalk() };
  
  public static class BeakRush extends Ability {
    private int initialY;
    
    public BeakRush() {
      super(ListAttributes.BeakRush);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("ptera")) {
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
        Pteranodon.motion("=", mX, player.motionY, mZ, player);
        super.use(player);
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown > 180 && player.posY >= this.initialY) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 3.0D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 70.0F); 
        for (int[] location : WyHelper.getBlockLocationsNearby((EntityLivingBase)player, 5)) {
          if (location[1] >= player.posY)
            if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, new String[] { "core", "foliage" }))
              WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], 128.0D);  
        } 
      } 
    }
  }
  
  public static class SmilodonClaw extends Ability {
    public SmilodonClaw() {
      super(ListAttributes.SmilodonClaw);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new PteranodonProjo.Trunk(player.worldObj, (EntityLivingBase)player, ListAttributes.SmilodonClaw);
      super.use(player);
    }
  }
  
  public static class SmilodonStalk extends Ability {
    public SmilodonStalk() {
      super(ListAttributes.SmilodonStalk);
    }
    
    public void use(EntityPlayer player) {
      if (isOnCooldown())
        return; 
      for (EntityLivingBase ent : WyHelper.getEntitiesNear((Entity)player, 20.0D))
        ent.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 160, 10)); 
      super.use(player);
    }
  }
  
  public static class PteranodonPoint extends Ability {
    public PteranodonPoint() {
      super(ListAttributes.PteranodonPoint);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("ptera")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("ptera");
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
  
  public static class Peck extends Ability {
    public Peck() {
      super(ListAttributes.Peck);
    }
    
    public void endCharging(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      WyHelper.Direction dir = WyHelper.get8Directions((Entity)player);
      if (!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("ptera")) {
        if (player.onGround) {
          Pteranodon.motion("+", 0.0D, 1.5333333333333332D, 0.0D, player);
        } else {
          Pteranodon.motion("+", 0.0D, 1.485D, 0.0D, player);
        } 
        if (dir == WyHelper.Direction.NORTH)
          Pteranodon.motion("-", 0.0D, 0.0D, 1.9D, player); 
        if (dir == WyHelper.Direction.NORTH_WEST)
          Pteranodon.motion("-", 1.9D, 0.0D, 1.9D, player); 
        if (dir == WyHelper.Direction.SOUTH)
          Pteranodon.motion("+", 0.0D, 0.0D, 1.9D, player); 
        if (dir == WyHelper.Direction.NORTH_EAST) {
          Pteranodon.motion("-", 0.0D, 0.0D, 1.9D, player);
          Pteranodon.motion("+", 1.9D, 0.0D, 0.0D, player);
        } 
        if (dir == WyHelper.Direction.WEST)
          Pteranodon.motion("-", 1.9D, 0.0D, 0.0D, player); 
        if (dir == WyHelper.Direction.SOUTH_WEST) {
          Pteranodon.motion("+", 0.0D, 0.0D, 1.9D, player);
          Pteranodon.motion("-", 1.9D, 0.0D, 0.0D, player);
        } 
        if (dir == WyHelper.Direction.EAST)
          Pteranodon.motion("+", 1.9D, 0.0D, 0.0D, player); 
        if (dir == WyHelper.Direction.SOUTH_EAST)
          Pteranodon.motion("+", 1.9D, 0.0D, 1.9D, player); 
      } 
      super.endCharging(player);
    }
  }
  
  public static class WingedTornado extends Ability {
    private int particlesSpawned = 0;
    
    public WingedTornado() {
      super(ListAttributes.WingedTornado);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      super.hitEntity(player, target);
      target.attackEntityFrom(DamageSource.causePlayerDamage(player), 70.0F);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
