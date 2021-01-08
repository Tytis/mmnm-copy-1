package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectLogiaOff;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilityReset;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.YamiProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class YamiAbilities {
  static {
    Values.abilityWebAppExtraParams.put("darkmatter", new String[] { "desc", "Launches a ball of darkness that engulfs the opponent." });
    Values.abilityWebAppExtraParams.put("kurouzu", new String[] { "desc", "Creates a strong gravitational force, that pulls the opponent towards the user." });
    Values.abilityWebAppExtraParams.put("blackhole", new String[] { "desc", "The user spreads darkness over the target area, which engulfs anyone and anything inside of it." });
    Values.abilityWebAppExtraParams.put("liberation", new String[] { "desc", "The user expells everything sucked up by the 'Black Hole' at the target location." });
    Values.abilityWebAppExtraParams.put("blackworld", new String[] { "desc", "The user spreads darkness to the surroundings, blinding enemies and creating pillars made of Darkness." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new Kurouzu(), new DarkMatter(), new Liberation(), new BlackHole(), new BlackWorld() };
  
  public static class BlackWorld extends Ability {
    public BlackWorld() {
      super(ListAttributes.BLACK_WORLD);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("blackWorld", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        if (MainConfig.enableGriefing)
          for (int i = 0; i < 8; i++) {
            int a1 = player.getRNG().nextInt(20) - 10;
            int a2 = player.getRNG().nextInt(20) - 10;
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 1, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 2, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 3, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 4, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 1, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 2, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 3, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 4, (int)player.posZ + a2, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 1, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 2, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 3, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1, (int)player.posY + 4, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 1, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 2, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 3, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + a1 + 1, (int)player.posY + 4, (int)player.posZ + a2 + 1, ListMisc.Darkness, new String[] { "core", "foliage", "liquid", "air" });
          }  
        super.use(player);
      } 
    }
  }
  
  public static class BlackHole extends Ability {
    public BlackHole() {
      super(ListAttributes.BLACKHOLE);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (MainConfig.enableGriefing) {
          WyHelper.createFilledSphere(player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, 10, ListMisc.Darkness, new String[] { "core", "foliage", "liquids", "ores" });
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("blackHole", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        } 
        super.use(player);
      } 
    }
  }
  
  public static class Liberation extends Ability {
    public int liberationCount = 0;
    
    public Liberation() {
      super(ListAttributes.LIBERATION);
    }
    
    public void use(EntityPlayer player) {
      int libCount = 0;
      if (!this.isOnCooldown) {
        if (this.liberationCount > 0) {
          MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
          if (mop != null) {
            double x = mop.blockX;
            double y = mop.blockY;
            double z = mop.blockZ;
            while (this.liberationCount > 0) {
              YamiProjectiles.Liberation liberation = new YamiProjectiles.Liberation(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.LIBERATION_BLOCK);
              liberation.setLocationAndAngles(x + WyMathHelper.randomWithRange(-3, 3), y + 14.0D + WyMathHelper.randomWithRange(0, 4), z + WyMathHelper.randomWithRange(-3, 3), 0.0F, 0.0F);
              ((AbilityProjectile)liberation).motionX = 0.0D;
              ((AbilityProjectile)liberation).motionZ = 0.0D;
              ((AbilityProjectile)liberation).motionY = -0.7D - player.worldObj.rand.nextDouble();
              player.worldObj.spawnEntityInWorld((Entity)liberation);
              this.liberationCount--;
            } 
          } 
        } else {
          for (int x = -40; x < 40; x++) {
            for (int y = -40; y < 40; y++) {
              for (int z = -40; z < 40; z++) {
                if (player.worldObj.getBlock((int)player.posX + x, (int)player.posY + y, (int)player.posZ + z) == ListMisc.Darkness) {
                  player.worldObj.setBlockToAir((int)player.posX + x, (int)player.posY + y, (int)player.posZ + z);
                  libCount++;
                  if (libCount % 10 == 0)
                    this.liberationCount++; 
                } 
              } 
            } 
          } 
        } 
        super.use(player);
      } 
    }
  }
  
  public static class Kurouzu extends Ability {
    private List<EntityLivingBase> entities = new ArrayList<>();
    
    public Kurouzu() {
      super(ListAttributes.KUROUZU);
    }
    
    public void startCharging(EntityPlayer player) {
      super.startCharging(player);
    }
    
    public void duringCharging(EntityPlayer player, int currentCharge) {
      MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
      this.entities.clear();
      if (mop != null) {
        double i = mop.blockX;
        double j = mop.blockY;
        double k = mop.blockZ;
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("korouzu", i, j, k), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        for (EntityLivingBase target : WyHelper.getEntitiesNear((int)i, (int)j, (int)k, player.worldObj, 5.0D))
          this.entities.add(target); 
      } 
    }
    
    public void endCharging(EntityPlayer player) {
      if (this.entities.contains(player))
        this.entities.remove(player); 
      for (EntityLivingBase target : this.entities) {
        target.setPositionAndUpdate(player.posX, player.posY, player.posZ);
        target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
        target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 100, 5));
        target.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 5));
        new DFEffectLogiaOff(target, 100);
        if (target instanceof EntityPlayer) {
          EntityPlayer playerTarget = (EntityPlayer)target;
          WyNetworkHelper.sendTo((IMessage)new PacketAbilityReset(false), (EntityPlayerMP)playerTarget);
        } 
      } 
      super.endCharging(player);
    }
  }
  
  public static class DarkMatter extends Ability {
    public DarkMatter() {
      super(ListAttributes.DARK_MATTER);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new YamiProjectiles.DarkMatter(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
}
