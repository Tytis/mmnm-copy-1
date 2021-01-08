package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectSpiderOverlay;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SupaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class SupaAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new Spider(), new SparClaw(), new AtomicSpurt(), new SpiralHollow(), new SparklingDaisy() };
  
  public static class SparklingDaisy extends Ability {
    private int initialY;
    
    public SparklingDaisy() {
      super(ListAttributes.SPARKLING_DAISY);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
        double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        this.initialY = (int)player.posY;
        double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
        mX /= f2;
        mZ /= f2;
        mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mX *= 3.0D;
        mZ *= 3.0D;
        SupaAbilities.motion("=", mX, player.motionY, mZ, player);
        super.use(player);
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      if (currentCooldown > 180 && player.posY >= this.initialY) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 1.6D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 18.0F); 
        for (int[] location : WyHelper.getBlockLocationsNearby((EntityLivingBase)player, 4)) {
          if (location[1] >= player.posY)
            if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, new String[] { "core", "foliage", "ores" }))
              WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], 128.0D);  
        } 
      } 
    }
  }
  
  public static class SpiralHollow extends Ability {
    public SpiralHollow() {
      super(ListAttributes.SPIRAL_HOLLOW);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new SupaProjectiles.SpiralHollow(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class AtomicSpurt extends Ability {
    public AtomicSpurt() {
      super(ListAttributes.ATOMIC_SPURT);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTime) {
      if (passiveTime > 1000) {
        setPassiveActive(false);
        startCooldown();
        startExtUpdate(player);
        super.endPassive(player);
      } 
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("atomicSpurt", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
    }
    
    public void endPassive(EntityPlayer player) {
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class SparClaw extends Ability {
    public SparClaw() {
      super(ListAttributes.SPAR_CLAW);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      super.hitEntity(player, target);
    }
  }
  
  public static class Spider extends Ability {
    private int threshold = 300;
    
    public Spider() {
      super(ListAttributes.SPIDER);
    }
    
    public void startPassive(EntityPlayer player) {
      new DFEffectSpiderOverlay((EntityLivingBase)player, 30);
      WyNetworkHelper.sendTo((IMessage)new PacketSync(ExtendedEntityData.get((EntityLivingBase)player)), (EntityPlayerMP)player);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (passiveTimer > 2400 || this.threshold <= 0) {
        setPassiveActive(false);
        startCooldown();
        startExtUpdate(player);
        endPassive(player);
      } 
      if (player.hurtTime > 0)
        this.threshold--; 
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData.get((EntityLivingBase)player).removeExtraEffects("spiderOverlay");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(ExtendedEntityData.get((EntityLivingBase)player)), (EntityPlayerMP)player);
      super.endPassive(player);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
