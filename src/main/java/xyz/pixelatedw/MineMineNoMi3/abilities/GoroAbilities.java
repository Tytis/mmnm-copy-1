package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class GoroAbilities {
  static {
    Values.abilityWebAppExtraParams.put("elthor", new String[] { "desc", "Focuses the user's electricity to strike the opponent with lightning from above." });
    Values.abilityWebAppExtraParams.put("voltvari", new String[] { "desc", "Creates a concentrated ball of lightning, which varies in power." });
    Values.abilityWebAppExtraParams.put("raigo", new String[] { "desc", "Creates a huge cloud filled with electricity, which causes massive damage." });
    Values.abilityWebAppExtraParams.put("kari", new String[] { "desc", "Creates an electrical current around the user, which then explodes." });
    Values.abilityWebAppExtraParams.put("sango", new String[] { "desc", "Launches a huge concentrated chunk of electricity at the opponent." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new ElThor(), new VoltVari(), new Raigo(), new Kari(), new Sango(), new SparkStep() };
  
  public static class ElThor extends Ability {
    public ElThor() {
      super(ListAttributes.EL_THOR);
    }
    
    public void startCharging(EntityPlayer player) {
      if (GoroAbilities.hasTomoeDrumsEquipped(player)) {
        this.attr.setAbilityDisplayName("Mamaragan");
        this.attr.setAbilityCooldown(20.0D);
      } 
      super.startCharging(player);
    }
    
    public void duringCharging(EntityPlayer player, int currentCharge) {
      MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
      if (mop != null) {
        double i = mop.blockX;
        double j = mop.blockY;
        double k = mop.blockZ;
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("elThor", i, j, k), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      } 
    }
    
    public void endCharging(EntityPlayer player) {
      MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
      if (mop != null) {
        double i = mop.blockX;
        double j = mop.blockY;
        double k = mop.blockZ;
        if (GoroAbilities.hasTomoeDrumsEquipped(player)) {
          for (int t = 0; t < 5; t++) {
            i += WyMathHelper.randomWithRange(-15, 15);
            k += WyMathHelper.randomWithRange(-15, 15);
            WyNetworkHelper.sendTo((IMessage)new PacketPlayer("ElThorThunder", i, j, k), (EntityPlayerMP)player);
            AbilityExplosion exp = WyHelper.newExplosion((Entity)player, i, j, k, 10.0D);
            exp.setFireAfterExplosion(true);
            exp.doExplosion();
          } 
        } else {
          WyNetworkHelper.sendTo((IMessage)new PacketPlayer("ElThorThunder", i, j, k), (EntityPlayerMP)player);
          AbilityExplosion exp = WyHelper.newExplosion((Entity)player, i, j, k, 10.0D);
          exp.setFireAfterExplosion(true);
          exp.doExplosion();
        } 
      } 
      super.endCharging(player);
      this.attr.setAbilityDisplayName("El Thor");
      this.attr.setAbilityCooldown(8.0D);
    }
  }
  
  public static class VoltVari extends Ability {
    private int power = 0;
    
    public VoltVari() {
      super(ListAttributes.VOLT_VARI);
    }
    
    public void startCharging(EntityPlayer player) {
      if (!this.isOnCooldown) {
        this.isCharging = true;
        startExtUpdate(player);
      } 
    }
    
    public void duringCharging(EntityPlayer player, int currentCharge) {
      this.power = currentCharge;
      double truePower = Math.abs(this.power - this.attr.getAbilityCharges());
      if (truePower % 25.0D == 0.0D && MainConfig.enableAnimeScreaming) {
        int voltVariType = (int)Math.floor(truePower / 25.0D);
        switch (voltVariType) {
          case 1:
            this.attr.setAbilityDisplayName("1 Million Volt Vari");
            break;
          case 2:
            this.attr.setAbilityDisplayName("5 Million Volt Vari");
            break;
          case 3:
            this.attr.setAbilityDisplayName("10 Million Volt Vari");
            break;
          case 4:
            this.attr.setAbilityDisplayName("20 Million Volt Vari");
            break;
          case 5:
            this.attr.setAbilityDisplayName("50 Million Volt Vari");
            break;
          case 6:
            this.attr.setAbilityDisplayName("60 Million Volt Vari");
            break;
          case 7:
            this.attr.setAbilityDisplayName("100 Million Volt Vari");
            break;
        } 
        if (voltVariType < 8)
          sendShounenScream(player); 
      } 
    }
    
    public void endCharging(EntityPlayer player) {
      double truePower = Math.abs(this.power - this.attr.getAbilityCharges());
      double trueCooldown = truePower / 20.0D * 3.0D;
      if (truePower > 0.0D && truePower <= 50.0D) {
        if (MainConfig.enableAnimeScreaming)
          if (truePower > 0.0D && truePower <= 25.0D) {
            this.attr.setAbilityDisplayName("1 Million Volt Vari");
          } else {
            this.attr.setAbilityDisplayName("5 Million Volt Vari");
          }  
        this.projectile = (AbilityProjectile)new GoroProjectiles.VoltVari5Million(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.VOLT_VARI_5_MILLION);
      } else if (truePower > 50.0D && truePower <= 100.0D) {
        if (MainConfig.enableAnimeScreaming)
          if (truePower > 50.0D && truePower <= 75.0D) {
            this.attr.setAbilityDisplayName("10 Million Volt Vari");
          } else {
            this.attr.setAbilityDisplayName("20 Million Volt Vari");
          }  
        this.projectile = (AbilityProjectile)new GoroProjectiles.VoltVari20Million(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.VOLT_VARI_20_MILLION);
      } else if (truePower > 100.0D && truePower <= 150.0D) {
        if (MainConfig.enableAnimeScreaming)
          if (truePower > 100.0D && truePower <= 125.0D) {
            this.attr.setAbilityDisplayName("50 Million Volt Vari");
          } else {
            this.attr.setAbilityDisplayName("60 Million Volt Vari");
          }  
        this.projectile = (AbilityProjectile)new GoroProjectiles.VoltVari60Million(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.VOLT_VARI_60_MILLION);
      } else if (truePower > 150.0D && truePower <= 200.0D) {
        if (MainConfig.enableAnimeScreaming)
          if (truePower > 150.0D && truePower <= 175.0D) {
            this.attr.setAbilityDisplayName("100 Million Volt Vari");
          } else {
            this.attr.setAbilityDisplayName("Max 200 Million Volt Vari");
          }  
        this.projectile = (AbilityProjectile)new GoroProjectiles.VoltVari200Million(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.VOLT_VARI_200_MILLION);
      } 
      sendShounenScream(player);
      this.attr.setAbilityCooldown(trueCooldown);
      this.isCharging = false;
      this.isOnCooldown = true;
      WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player);
      if (!player.capabilities.isCreativeMode)
        WyTelemetry.addAbilityStat(getAttribute().getAbilityTexture(), getAttribute().getAttributeName(), 1); 
      if (this.projectile != null)
        player.worldObj.spawnEntityInWorld((Entity)this.projectile); 
      startExtUpdate(player);
    }
  }
  
  public static class Raigo extends Ability {
    public Raigo() {
      super(ListAttributes.RAIGO);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
        if (mop != null) {
          double x = mop.blockX;
          double y = mop.blockY;
          double z = mop.blockZ;
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("raigo", x, player.posY, z), player.dimension, x, y, z, 128.0D);
          GoroProjectiles.Raigo raigo = new GoroProjectiles.Raigo(player.worldObj, (EntityLivingBase)player, ListAttributes.RAIGO);
          raigo.setLocationAndAngles(x, y + 90.0D, z, 0.0F, 0.0F);
          ((AbilityProjectile)raigo).motionX = 0.0D;
          ((AbilityProjectile)raigo).motionZ = 0.0D;
          ((AbilityProjectile)raigo).motionY = -1.4D;
          player.worldObj.spawnEntityInWorld((Entity)raigo);
        } 
      } 
      super.use(player);
    }
  }
  
  public static class Kari extends Ability {
    public Kari() {
      super(ListAttributes.KARI);
    }
    
    public void startCharging(EntityPlayer player) {
      if (!this.isOnCooldown)
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("kari", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D); 
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      super.endCharging(player);
    }
  }
  
  public static class Sango extends Ability {
    public Sango() {
      super(ListAttributes.SANGO);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new GoroProjectiles.Sango(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class SparkStep extends Ability {
    public SparkStep() {
      super(ListAttributes.SPARK_STEP);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (WyHelper.rayTraceBlocks((Entity)player) != null) {
          MovingObjectPosition blockTracer = WyHelper.rayTraceBlocks((Entity)player);
          int[] blockLocation = { blockTracer.blockX, blockTracer.blockY, blockTracer.blockZ };
          while (player.getEntityWorld().getBlock(blockLocation[0], blockLocation[1], blockLocation[2]) != Blocks.air)
            blockLocation[1] = blockLocation[1] + 1; 
          EnderTeleportEvent event = new EnderTeleportEvent((EntityLivingBase)player, blockLocation[0], blockLocation[1], blockLocation[2], 0.0F);
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("elThor", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          player.setPositionAndUpdate(event.targetX, event.targetY + 1.0D, event.targetZ);
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("elThor", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          player.fallDistance = 0.0F;
        } 
        super.use(player);
      } 
    }
  }
  
  private static boolean hasTomoeDrumsEquipped(EntityPlayer player) {
    return (player.getEquipmentInSlot(3) != null && player.getEquipmentInSlot(3).getItem() == ListMisc.TomoeDrums);
  }
}
