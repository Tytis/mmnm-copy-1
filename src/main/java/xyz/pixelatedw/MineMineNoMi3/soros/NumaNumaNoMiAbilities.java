package xyz.pixelatedw.MineMineNoMi3.soros;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class NumaNumaNoMiAbilities {
  static {
    Values.abilityWebAppExtraParams.put("Numa Numa No Gatling", new String[] { "desc", "A bunch Bullets just start shooting out of the player around 20 bullets." });
    Values.abilityWebAppExtraParams.put("Swamp Slide", new String[] { "desc", "A forward dash with swampy particles at the feet as if theyâ€™re running on ice." });
    Values.abilityWebAppExtraParams.put("Numa Spray", new String[] { "desc", "5 brown balls spraying and giving slowness and dealing damage." });
    Values.abilityWebAppExtraParams.put("Swamp Land", new String[] { "desc", "creates a big circle of swamp particles at the users feet with a 20 block radius and makes everyone in the circle unable to move." });
  }
  
  public static final Ability NoGatling = new NoGatling();
  
  public static final Ability SWAMP_SLIDE = new SwampSlide();
  
  public static final Ability NUMA_SPRAY = new NumaSpray();
  
  public static final Ability SWAMP_LAND = new SwampLand();
  
  public static Ability[] abilitiesArray = new Ability[] { NoGatling, SWAMP_SLIDE, NUMA_SPRAY, SWAMP_LAND };
  
  public static class SwampLand extends Ability {
    public SwampLand() {
      super(ListAttributes.SWAMPLAND);
    }
    
    public void use(EntityPlayer player) {
      if (isOnCooldown())
        return; 
      for (EntityLivingBase ent : WyHelper.getEntitiesNear((Entity)player, 20.0D)) {
        ent.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 160, 10));
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("particle_numa.png", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("particle_numa.png", ent), ent.dimension, ent.posX, ent.posY, ent.posZ, 128.0D);
      } 
      super.use(player);
    }
  }
  
  public static class SwampSlide extends Ability {
    public SwampSlide() {
      super(ListAttributes.SWAMPSLIDE);
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
      NumaNumaNoMiAbilities.motion("=", mX, mY, mZ, player);
      super.endCharging(player);
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown / 20 > ListAttributes.SWAMPSLIDE.getAbilityCooldown() / 20 - 3) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 1.6D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 2.0F * props.getDamageMultiplier()); 
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("particle_numa.png", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      } 
    }
  }
  
  public static class NumaSpray extends Ability {
    public NumaSpray() {
      super(ListAttributes.NUMASPRAY);
    }
    
    public void use(EntityPlayer player) {
      super.use(player);
      this.projectile = new NumaNumaNoMiProjectiles.NumaSprayBall(player.worldObj, (EntityLivingBase)player, ListAttributes.NUMASPRAY);
    }
  }
  
  public static class NoGatling extends Ability {
    public NoGatling() {
      super(ListAttributes.NUMAGATLING);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new NumaNumaNoMiProjectiles.NumaSprayBall(player.worldObj, (EntityLivingBase)player, ListAttributes.NUMAGATLING);
      super.use(player);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
