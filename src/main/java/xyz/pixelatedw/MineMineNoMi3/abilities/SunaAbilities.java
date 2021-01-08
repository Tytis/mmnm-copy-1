package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SunaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class SunaAbilities {
  static {
    Values.abilityWebAppExtraParams.put("barjan", new String[] { "desc", "Launches a crescent-shaped wave of sand at the opponent, that dehydrates them." });
    Values.abilityWebAppExtraParams.put("grounddeath", new String[] { "desc", "Dries out the surroundings and suffucates all nearby opponents in sand." });
    Values.abilityWebAppExtraParams.put("sables", new String[] { "desc", "The user launches a compressed sandstorm at the opponent, which sends them flying." });
    Values.abilityWebAppExtraParams.put("sablespesado", new String[] { "desc", "The user launches a compressed sandstorm at the opponent, which sends them flying." });
    Values.abilityWebAppExtraParams.put("desertspada", new String[] { "desc", "The user extends their sand along the ground, splitting it and suffocating everything it its path. " });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new Barjan(), new Sables(), new SablesPesado(), new GroundDeath(), new DesertSpada(), new DesertEncierro(), new DesertGirasole() };
  
  public static class DesertGirasole extends Ability {
    public DesertGirasole() {
      super(ListAttributes.DESERT_GIRASOLE);
    }
    
    public void startCharging(EntityPlayer player) {
      if (!this.isOnCooldown)
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("desertGirasole", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D); 
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (MainConfig.enableGriefing) {
          for (int i = -15; i < 15; i++) {
            for (int j = -5; j < 5; j++) {
              for (int k = -15; k < 15; k++) {
                int posX = (int)(player.posX + i + ((i < -WyMathHelper.randomWithRange(8, 12) || i > WyMathHelper.randomWithRange(8, 12)) ? WyMathHelper.randomWithRange(-5, 5) : 0.0D));
                int posY = (int)player.posY + j;
                int posZ = (int)(player.posZ + k + ((k < -WyMathHelper.randomWithRange(8, 12) || k > WyMathHelper.randomWithRange(8, 12)) ? WyMathHelper.randomWithRange(-5, 5) : 0.0D));
                DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, 2, new String[] { "core" });
              } 
            } 
          } 
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("desertGirasole2", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        } 
        super.endCharging(player);
      } 
    }
  }
  
  public static class DesertEncierro extends Ability {
    public DesertEncierro() {
      super(ListAttributes.DESERT_ENCIERRO);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("desertEncierro", target), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      super.hitEntity(player, target);
    }
  }
  
  public static class Barjan extends Ability {
    public Barjan() {
      super(ListAttributes.BARJAN);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new SunaProjectiles.Barjan(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class Sables extends Ability {
    public Sables() {
      super(ListAttributes.SABLES);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      double newPosX = 0.0D, newPosY = 0.0D, newPosZ = 0.0D;
      newPosY += 25.0D;
      target.addPotionEffect(new PotionEffect(Potion.hunger.id, 500, 1));
      WyHelper.Direction dir = WyHelper.get4Directions((Entity)player);
      if (dir == WyHelper.Direction.SOUTH) {
        newPosX += WyMathHelper.randomWithRange(-10, 10);
      } else if (dir == WyHelper.Direction.EAST) {
        newPosX -= WyMathHelper.randomWithRange(-10, 10);
      } else if (dir == WyHelper.Direction.NORTH) {
        newPosZ += WyMathHelper.randomWithRange(-10, 10);
      } else if (dir == WyHelper.Direction.WEST) {
        newPosZ -= WyMathHelper.randomWithRange(-10, 10);
      } 
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("sables", target), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      target.setPositionAndUpdate(target.posX + newPosX, target.posY + newPosY, target.posZ + newPosZ);
      super.hitEntity(player, target);
    }
  }
  
  public static class SablesPesado extends Ability {
    public SablesPesado() {
      super(ListAttributes.SABLESPESADO);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      double newPosX = 0.0D, newPosY = 0.0D, newPosZ = 0.0D;
      newPosY += 35.0D;
      target.addPotionEffect(new PotionEffect(Potion.hunger.id, 500, 1));
      WyHelper.Direction dir = WyHelper.get4Directions((Entity)player);
      if (dir == WyHelper.Direction.SOUTH) {
        newPosX += WyMathHelper.randomWithRange(-20, 20);
      } else if (dir == WyHelper.Direction.EAST) {
        newPosX -= WyMathHelper.randomWithRange(-20, 20);
      } else if (dir == WyHelper.Direction.NORTH) {
        newPosZ += WyMathHelper.randomWithRange(-20, 20);
      } else if (dir == WyHelper.Direction.WEST) {
        newPosZ -= WyMathHelper.randomWithRange(-20, 20);
      } 
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("sables", target), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      target.setPositionAndUpdate(target.posX + newPosX, target.posY + newPosY, target.posZ + newPosZ);
      super.hitEntity(player, target);
    }
  }
  
  public static class GroundDeath extends Ability {
    public GroundDeath() {
      super(ListAttributes.GROUND_DEATH);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        if (MainConfig.enableGriefing) {
          for (EntityLivingBase entityLivingBase : WyHelper.getEntitiesNear((Entity)player, 25.0D)) {
            WyHelper.createFilledCube((Entity)entityLivingBase, new int[] { 2, 2, 2 }, (Block)Blocks.sand, new String[] { "air", "foliage" });
          } 
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("groundDeath", player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        } 
        super.use(player);
      } 
    }
  }
  
  public static class DesertSpada extends Ability {
    public DesertSpada() {
      super(ListAttributes.DESERT_SPADA);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (MainConfig.enableGriefing) {
          if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.NORTH) {
            for (int i = -4; i < 6; i++) {
              for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 30; k++) {
                  int posX = (int)player.posX + i;
                  int posY = (int)player.posY - j + 1;
                  int posZ = (int)player.posZ - k + 2;
                  DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, new String[] { "core" });
                } 
              } 
            } 
          } else if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.SOUTH) {
            for (int i = -4; i < 6; i++) {
              for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 30; k++) {
                  int posX = (int)player.posX + i;
                  int posY = (int)player.posY - j + 1;
                  int posZ = (int)player.posZ + k + 2;
                  DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, new String[] { "core" });
                } 
              } 
            } 
          } else if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.EAST) {
            for (int i = 0; i < 30; i++) {
              for (int j = 0; j < 5; j++) {
                for (int k = -4; k < 6; k++) {
                  int posX = (int)player.posX + i + 2;
                  int posY = (int)player.posY - j + 1;
                  int posZ = (int)player.posZ + k;
                  DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, new String[] { "core" });
                } 
              } 
            } 
          } else if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.WEST) {
            for (int i = 0; i < 30; i++) {
              for (int j = 0; j < 5; j++) {
                for (int k = -4; k < 6; k++) {
                  int posX = (int)player.posX - i + 2;
                  int posY = (int)player.posY - j + 1;
                  int posZ = (int)player.posZ + k;
                  DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, ListMisc.SunaSand, new String[] { "core" });
                } 
              } 
            } 
          } 
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("desertSpada", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        } 
        super.use(player);
      } 
    }
  }
}
