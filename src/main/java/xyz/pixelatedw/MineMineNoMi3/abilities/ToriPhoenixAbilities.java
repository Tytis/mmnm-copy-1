package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ToriPhoenixProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class ToriPhoenixAbilities {
  static {
    Values.abilityWebAppExtraParams.put("hybridpoint", new String[] { "desc", "The user transforms into a phoenix-human hybrid, which allows them to fly. Allows the user to use 'Phoenix Goen' " });
    Values.abilityWebAppExtraParams.put("phoenixpoint", new String[] { "desc", "The user fully transforms into a phoenix, allowing them to fly at great speed. Allows the user to use both 'Phoenix Goen' and 'Tensei no Soen'" });
    Values.abilityWebAppExtraParams.put("phoenixgoen", new String[] { "desc", "Launches a powerful fiery shockwave made of blue flames at the target." });
    Values.abilityWebAppExtraParams.put("tenseinosoen", new String[] { "desc", "While in the air, the user amasses spiraling flames, then slams into the ground, releasing a massive shockwave." });
    Values.abilityWebAppExtraParams.put("blueflamesofresurrection", new String[] { "desc", "Blue phoenix flames grant the user regeneration." });
    Values.abilityWebAppExtraParams.put("flameofrestoration", new String[] { "desc", "Uses the blue flames to heal the target." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new PhoenixPoint(), new HybridPoint(), new BlueFlamesOfResurrection(), new FlameOfRestoration(), new PhoenixGoen(), new TenseiNoSoen() };
  
  public static class HybridPoint extends Ability {
    public HybridPoint() {
      super(ListAttributes.PHOENIX_HYBRID_POINT);
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
      props.setZoanPoint("hybrid");
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
  
  public static class TenseiNoSoen extends Ability {
    private int particlesSpawned = 0;
    
    public TenseiNoSoen() {
      super(ListAttributes.TENSEI_NO_SOEN);
    }
    
    public void startCharging(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      this.particlesSpawned = 0;
      if (props.getZoanPoint().equals("full") && !this.isOnCooldown) {
        if (!player.onGround) {
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("tenseiNoSoen1", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          super.startCharging(player);
        } else {
          WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while airborne !");
        } 
      } else if (!props.getZoanPoint().equals("full")) {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Phoenix Point is active !");
      } 
    }
    
    public void endCharging(EntityPlayer player) {
      player.fallDistance = 0.0F;
      ToriPhoenixAbilities.motion("=", 0.0D, -100.0D, 0.0D, player);
      super.endCharging(player);
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      if (currentCooldown > 560) {
        if (player.onGround && this.particlesSpawned < 10) {
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("tenseiNoSoen2", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          this.particlesSpawned++;
        } 
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 20.0D)) {
          if (e.posY >= player.posY)
            e.attackEntityFrom(DamageSource.causePlayerDamage(player), 30.0F); 
        } 
      } 
    }
  }
  
  public static class PhoenixGoen extends Ability {
    public PhoenixGoen() {
      super(ListAttributes.PHOENIX_GOEN);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if ((props.getZoanPoint().equals("full") || props.getZoanPoint().equals("hybrid")) && !this.isOnCooldown) {
        for (int i = 0; i < 100; i++) {
          double offsetX = ((new Random()).nextInt(20) + 1.0D - 5.0D) / 5.0D;
          double offsetY = ((new Random()).nextInt(20) + 1.0D - 20.0D) / 10.0D;
          double offsetZ = ((new Random()).nextInt(20) + 1.0D - 5.0D) / 5.0D;
          this.projectile = (AbilityProjectile)new ToriPhoenixProjectiles.PhoenixGoen(player.worldObj, (EntityLivingBase)player, this.attr);
          this.projectile.setLocationAndAngles(player.posX - 1.0D + offsetX, player.posY + 2.0D + offsetY, player.posZ + offsetZ, player.cameraPitch, player.cameraYaw);
          player.worldObj.spawnEntityInWorld((Entity)this.projectile);
        } 
        WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
        super.use(player);
      } else if (!props.getZoanPoint().equals("full") && !props.getZoanPoint().equals("hybrid")) {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Phoenix Point or Hybrid Point is active !");
      } 
    }
  }
  
  public static class FlameOfRestoration extends Ability {
    public FlameOfRestoration() {
      super(ListAttributes.FLAME_OF_RESTORATION);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      super.hitEntity(player, target);
      if (target.getHealth() + 6.0F < target.getMaxHealth()) {
        target.setHealth(target.getHealth() + 6.0F);
      } else {
        target.setHealth(target.getMaxHealth());
      } 
      WyNetworkHelper.sendTo((IMessage)new PacketParticles("blueFlames", (EntityLivingBase)player), (EntityPlayerMP)player);
    }
  }
  
  public static class BlueFlamesOfResurrection extends Ability {
    public BlueFlamesOfResurrection() {
      super(ListAttributes.BLUE_FLAMES_OF_RESURRECTION);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown)
        WyNetworkHelper.sendTo((IMessage)new PacketParticles("blueFlames", (EntityLivingBase)player), (EntityPlayerMP)player); 
      super.use(player);
    }
  }
  
  public static class PhoenixPoint extends Ability {
    public PhoenixPoint() {
      super(ListAttributes.PHOENIX_FULL_POINT);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("full")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("full");
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
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
