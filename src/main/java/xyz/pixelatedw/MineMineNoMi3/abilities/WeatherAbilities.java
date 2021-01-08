package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.WeatherProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityMirageClone;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.ClimaTact;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class WeatherAbilities {
  public static final Ability HEAT_BALL = new HeatBall();
  
  public static final Ability COOL_BALL = new CoolBall();
  
  public static final Ability THUNDER_BALL = new ThunderBall();
  
  public static final Ability GUST_SWORD = new GustSword();
  
  public static final Ability WEATHER_EGG = new WeatherEgg();
  
  public static Ability[] abilitiesArray = new Ability[] { HEAT_BALL, COOL_BALL, THUNDER_BALL, GUST_SWORD, WEATHER_EGG };
  
  public static class WeatherEgg extends Ability {
    public WeatherEgg() {
      super(ListAttributes.WEATHER_EGG);
    }
    
    public void use(EntityPlayer player) {
      if (player.inventory.getCurrentItem() == null || (player.inventory.getCurrentItem() != null && ItemsHelper.getClimaTactLevel(player.inventory.getCurrentItem().getItem()) < 3)) {
        WyHelper.sendMsgToPlayer(player, "Cannot use " + getAttribute().getAttributeName() + " without a Sorcery or better Clima Tact in hand!");
        return;
      } 
      this.projectile = (AbilityProjectile)new WeatherProjectiles.WeatherEgg(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class GustSword extends Ability {
    public GustSword() {
      super(ListAttributes.GUST_SWORD);
    }
    
    public void use(EntityPlayer player) {
      if (player.inventory.getCurrentItem() == null || (player.inventory.getCurrentItem() != null && ItemsHelper.getClimaTactLevel(player.inventory.getCurrentItem().getItem()) < 3)) {
        WyHelper.sendMsgToPlayer(player, "Cannot use " + getAttribute().getAttributeName() + " without a Sorcery or better Clima Tact in hand!");
        return;
      } 
      this.projectile = (AbilityProjectile)new WeatherProjectiles.GustSword(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class ThunderBall extends Ability {
    public ThunderBall() {
      super(ListAttributes.THUNDER_BALL);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        ItemStack stack = player.getHeldItem();
        if (stack == null || !(stack.getItem() instanceof ClimaTact)) {
          WyHelper.sendMsgToPlayer(player, "Cannot use " + getAttribute().getAttributeName() + " without a Clima Tact in hand!");
          return;
        } 
        ClimaTact climaTact = (ClimaTact)stack.getItem();
        if (player.isSneaking()) {
          climaTact.chargeWeatherBall(stack, "T");
        } else {
          WeatherProjectiles.ThunderBall proj = new WeatherProjectiles.ThunderBall(player.worldObj, (EntityLivingBase)player, ListAttributes.THUNDER_BALL);
          proj.setLocationAndAngles(player.posX, player.posY + player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
          player.worldObj.spawnEntityInWorld((Entity)proj);
        } 
        if (climaTact.checkCharge(stack).length() == 3) {
          String tempo = climaTact.checkCharge(stack);
          if (tempo.equalsIgnoreCase("TTT")) {
            List<WeatherProjectiles.EntityWeatherCloud> targets = WyHelper.getEntitiesNear((Entity)player, new double[] { 15.0D, 80.0D, 15.0D }, new Class[] { WeatherProjectiles.EntityWeatherCloud.class });
            if (targets.size() > 0) {
              WeatherProjectiles.EntityWeatherCloud target = targets.get(0);
              if (target != null && target.isSuperCharged())
                climaTact.setDamage(20.0D); 
            } 
            climaTact.emptyCharge(stack);
            super.use(player);
            DevilFruitsHelper.sendShounenScream(player, "Thunder Lance Tempo", 0);
            return;
          } 
          WyHelper.sendMsgToPlayer(player, "Failed Tempo");
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("commonExplosion", player.posX, player.posY - 1.0D, player.posZ), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          climaTact.emptyCharge(stack);
          super.use(player);
          return;
        } 
        super.use(player);
      } 
    }
  }
  
  public static class CoolBall extends Ability {
    public CoolBall() {
      super(ListAttributes.COOL_BALL);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        ItemStack stack = player.getHeldItem();
        if (stack == null || !(stack.getItem() instanceof ClimaTact)) {
          WyHelper.sendMsgToPlayer(player, "Cannot use " + getAttribute().getAttributeName() + " without a Clima Tact in hand!");
          return;
        } 
        ClimaTact climaTact = (ClimaTact)stack.getItem();
        if (player.isSneaking()) {
          climaTact.chargeWeatherBall(stack, "C");
        } else {
          WeatherProjectiles.CoolBall proj = new WeatherProjectiles.CoolBall(player.worldObj, (EntityLivingBase)player, ListAttributes.COOL_BALL);
          proj.setLocationAndAngles(player.posX, player.posY + player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
          player.worldObj.spawnEntityInWorld((Entity)proj);
        } 
        if (climaTact.checkCharge(stack).length() == 3) {
          String tempo = climaTact.checkCharge(stack);
          if (tempo.equalsIgnoreCase("HHC")) {
            WeatherProjectiles.EntityMirageTempoCloud smokeCloud = new WeatherProjectiles.EntityMirageTempoCloud(player.worldObj);
            smokeCloud.setLife(70);
            smokeCloud.setLocationAndAngles(player.posX, player.posY + 1.0D, player.posZ, 0.0F, 0.0F);
            smokeCloud.motionX = 0.0D;
            smokeCloud.motionZ = 0.0D;
            smokeCloud.motionY = 0.0D;
            smokeCloud.setThrower(player);
            player.worldObj.spawnEntityInWorld((Entity)smokeCloud);
            for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)player, 10.0D))
              entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 1)); 
            climaTact.emptyCharge(stack);
            super.use(player);
            DevilFruitsHelper.sendShounenScream(player, "Fog Tempo", 0);
            return;
          } 
          WyHelper.sendMsgToPlayer(player, "Failed Tempo");
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("commonExplosion", player.posX, player.posY - 1.0D, player.posZ), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          climaTact.emptyCharge(stack);
          super.use(player);
          return;
        } 
        super.use(player);
      } 
    }
  }
  
  public static class HeatBall extends Ability {
    public HeatBall() {
      super(ListAttributes.HEAT_BALL);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        ItemStack stack = player.getHeldItem();
        if (stack == null || !(stack.getItem() instanceof ClimaTact)) {
          WyHelper.sendMsgToPlayer(player, "Cannot use " + getAttribute().getAttributeName() + " without a Clima Tact in hand!");
          return;
        } 
        ClimaTact climaTact = (ClimaTact)stack.getItem();
        if (player.isSneaking()) {
          climaTact.chargeWeatherBall(stack, "H");
        } else {
          WeatherProjectiles.HeatBall proj = new WeatherProjectiles.HeatBall(player.worldObj, (EntityLivingBase)player, ListAttributes.HEAT_BALL);
          proj.setLocationAndAngles(player.posX, player.posY + player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
          player.worldObj.spawnEntityInWorld((Entity)proj);
        } 
        if (climaTact.checkCharge(stack).length() == 3) {
          String tempo = climaTact.checkCharge(stack);
          if (tempo.equalsIgnoreCase("CCH")) {
            WeatherProjectiles.EntityMirageTempoCloud smokeCloud = new WeatherProjectiles.EntityMirageTempoCloud(player.worldObj);
            smokeCloud.setLife(50);
            smokeCloud.setLocationAndAngles(player.posX, player.posY + 1.0D, player.posZ, 0.0F, 0.0F);
            smokeCloud.motionX = 0.0D;
            smokeCloud.motionZ = 0.0D;
            smokeCloud.motionY = 0.0D;
            smokeCloud.setThrower(player);
            player.worldObj.spawnEntityInWorld((Entity)smokeCloud);
            for (int i = 0; i < 5; i++) {
              EntityMirageClone mirageClone = new EntityMirageClone(player.worldObj, player);
              mirageClone.setPositionAndRotation(player.posX, player.posY, player.posZ, 180.0F, 0.0F);
              player.worldObj.spawnEntityInWorld((Entity)mirageClone);
            } 
            climaTact.emptyCharge(stack);
            super.use(player);
            DevilFruitsHelper.sendShounenScream(player, "Mirage Tempo", 0);
            return;
          } 
          WyHelper.sendMsgToPlayer(player, "Failed Tempo");
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("commonExplosion", player.posX, player.posY - 1.0D, player.posZ), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          climaTact.emptyCharge(stack);
          super.use(player);
          return;
        } 
        super.use(player);
      } 
    }
  }
}
