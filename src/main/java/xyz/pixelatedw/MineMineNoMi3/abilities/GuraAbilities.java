package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GuraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class GuraAbilities {
  static {
    Values.abilityWebAppExtraParams.put("kaishin", new String[] { "desc", "The user cracks the air, which launches a small but powerful explosion towards the opponent." });
    Values.abilityWebAppExtraParams.put("kabutowari", new String[] { "desc", "The user punches the air and creates a massive explosion around themselves." });
    Values.abilityWebAppExtraParams.put("shimayurashi", new String[] { "desc", "Launches a powerful explosion which spreads towards the opponent." });
    Values.abilityWebAppExtraParams.put("gekishin", new String[] { "desc", "The user creates a tremor while punching the enemy, inflicting massive damage." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new Kaishin(), new Kabutowari(), new ShimaYurashi(), new Gekishin() };
  
  public static class Gekishin extends Ability {
    public Gekishin() {
      super(ListAttributes.GEKISHIN);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      super.hitEntity(player, target);
      target.attackEntityFrom(DamageSource.causePlayerDamage(player), 200.0F * props.getDamageMultiplier());
      AbilityExplosion explosion = WyHelper.newExplosion((Entity)player, target.posX, target.posY, target.posZ, 3.0D);
      explosion.setDamageOwner(false);
      explosion.setSmokeParticles("");
      explosion.doExplosion();
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("gekishin", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
    }
  }
  
  public static class Kaishin extends Ability {
    public Kaishin() {
      super(ListAttributes.KAISHIN);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new GuraProjectiles.Kaishin(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class Kabutowari extends Ability {
    public Kabutowari() {
      super(ListAttributes.KABUTOWARI);
    }
    
    public void use(EntityPlayer player) {
      super.use(player);
    }
  }
  
  public static class ShimaYurashi extends Ability {
    public ShimaYurashi() {
      super(ListAttributes.SHIMA_YURASHI);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new GuraProjectiles.ShimaYurashi(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
}
