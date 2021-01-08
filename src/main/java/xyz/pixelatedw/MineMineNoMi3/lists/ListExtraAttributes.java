package xyz.pixelatedw.MineMineNoMi3.lists;

import java.awt.Color;
import net.minecraft.client.model.ModelBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelCube;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.ModelSphere;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.EffectType;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelArrow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelBazooka;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelFist;

public class ListExtraAttributes {
  public static final AbilityAttribute WEATHER_CLOUD = (new AbilityAttribute("Weather Cloud")).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.0D, 0.0D, 0.0D).setProjectileColor(Color.WHITE).setProjectileAlpha(150.0F).setProjectileTicks(200).setProjectileCollisionSizes(65.0D, 5.0D, 65.0D).setProjectileMoveThroughBlocks(true);
  
  public static final AbilityAttribute LIBERATION_BLOCK = (new AbilityAttribute("Liberation Block")).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor(Color.BLACK).setProjectileDamage(20.0F).setProjectileSize(3.0D, 3.0D, 3.0D);
  
  public static final AbilityAttribute METEOR = (new AbilityAttribute("Meteor")).setProjectileTicks(500).setProjectileModel((ModelBase)new ModelSphere()).setProjectileSize(20.0D, 20.0D, 20.0D).setProjectileColor("56494B").setProjectileExplosion(13);
  
  public static final AbilityAttribute EL_THOR_THUNDER = (new AbilityAttribute("El Thor Thunder")).setProjectileTicks(500).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(60.0D, 10.0D, 10.0D).setProjectileColor("77abff").setProjectileExplosion(2);
  
  public static final AbilityAttribute TSUNOTOKAGE_PILLAR = (new AbilityAttribute("Tsuno-Tokage Pillar")).setProjectileDamage(20.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(4.0D, 4.0D, 20.0D).setProjectileColor(Color.BLACK).setProjectileTicks(5);
  
  public static final AbilityAttribute GOMU_GOMU_NO_PISTOL = (new AbilityAttribute("Gomu Gomu no Pistol")).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("gomugomunopistol").setProjectileSize(3.0D, 3.0D, 3.0D).setModelOffsets(0.0D, 1.0D, 0.0D).setProjectileDamage(20.0F).setProjectilePhysical();
  
  public static final AbilityAttribute GOMU_GOMU_NO_JET_PISTOL = (new AbilityAttribute("Gomu Gomu no Jet Pistol")).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("gomugomunojetpistol").setProjectileSize(3.0D, 3.0D, 3.0D).setModelOffsets(0.0D, 1.0D, 0.0D).setProjectileSpeed(4.0F).setProjectileDamage(35.0F).setProjectilePhysical();
  
  public static final AbilityAttribute GOMU_GOMU_NO_ELEPHANT_GUN = (new AbilityAttribute("Gomu Gomu no Elephant Gun")).setProjectileTicks(40).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("gomugomunoelephantgun").setProjectileSize(15.0D, 15.0D, 13.0D).setModelOffsets(-1.0D, 5.0D, 0.0D).setProjectileDamage(65.0F).setProjectileMoveThroughBlocks(true).setProjectileExplosion(2, false).setProjectileCollisionSizes(1.0D, 1.0D, 1.0D).setProjectilePhysical();
  
  public static final AbilityAttribute GOMU_GOMU_NO_KONG_GUN = (new AbilityAttribute("Gomu Gomu no Kong Gun")).setProjectileTicks(30).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("gomugomunokonggun").setProjectileSize(15.0D, 15.0D, 13.0D).setModelOffsets(-1.0D, 5.0D, 0.0D).setProjectileDamage(175.0F).setProjectileMoveThroughBlocks(true).setProjectileExplosion(2, false).setProjectileCollisionSizes(1.0D, 1.0D, 1.0D).setProjectilePhysical();
  
  public static final AbilityAttribute GOMU_GOMU_NO_BAZOOKA = (new AbilityAttribute("Gomu Gomu no Bazooka")).setProjectileModel((ModelBase)new ModelBazooka()).setProjectileTexture("gomugomunobazooka").setProjectileSize(3.0D, 3.0D, 3.0D).setModelOffsets(0.0D, 1.0D, 0.0D).setProjectileDamage(25.0F).setProjectileCollisionSizes(0.75D, 0.3D, 0.75D).setProjectilePhysical();
  
  public static final AbilityAttribute GOMU_GOMU_NO_JET_BAZOOKA = (new AbilityAttribute("Gomu Gomu no Jet Bazooka")).setProjectileModel((ModelBase)new ModelBazooka()).setProjectileTexture("gomugomunojetbazooka").setProjectileSize(3.0D, 3.0D, 3.0D).setModelOffsets(0.0D, 1.0D, 0.0D).setProjectileSpeed(4.0F).setProjectileCollisionSizes(0.75D, 0.3D, 0.75D).setProjectileDamage(50.0F).setProjectilePhysical();
  
  public static final AbilityAttribute GOMU_GOMU_NO_GRIZZLY_MAGNUM = (new AbilityAttribute("Gomu Gomu no Grizzly Magnum")).setProjectileTicks(40).setProjectileModel((ModelBase)new ModelBazooka()).setProjectileTexture("gomugomunogrizzlymagnum").setProjectileSize(15.0D, 15.0D, 13.0D).setModelOffsets(-1.0D, 5.0D, 0.0D).setProjectileDamage(75.0F).setProjectileCollisionSizes(1.75D, 0.8D, 1.75D).setProjectilePhysical();
  
  public static final AbilityAttribute GOMU_GOMU_NO_LEO_BAZOOKA = (new AbilityAttribute("Gomu Gomu no Leo Bazooka")).setProjectileTicks(30).setProjectileModel((ModelBase)new ModelBazooka()).setProjectileTexture("gomugomunoleobazooka").setProjectileSize(15.0D, 15.0D, 13.0D).setModelOffsets(-1.0D, 5.0D, 0.0D).setProjectileDamage(160.0F).setProjectileCollisionSizes(1.75D, 0.8D, 1.75D).setProjectilePhysical();
  
  public static final AbilityAttribute GOMU_GOMU_NO_GATLING = (new AbilityAttribute("Gomu Gomu no Gatling")).setProjectileTicks(5).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("gomugomunopistol").setProjectileSize(3.0D, 3.0D, 3.0D).setModelOffsets(0.0D, 1.0D, 0.0D).setProjectileDamage(6.0F).setProjectilePhysical().setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute GOMU_GOMU_NO_JET_GATLING = (new AbilityAttribute("Gomu Gomu no Jet Gatling")).setProjectileTicks(5).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("gomugomunojetpistol").setProjectileSize(3.0D, 3.0D, 3.0D).setModelOffsets(0.0D, 1.0D, 0.0D).setProjectileSpeed(4.0F).setProjectileDamage(12.0F).setProjectilePhysical().setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute GOMU_GOMU_NO_ELEPHANT_GATLING = (new AbilityAttribute("Gomu Gomu no Elephant Gatling")).setProjectileTicks(5).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("gomugomunoelephantgun").setProjectileSize(15.0D, 15.0D, 13.0D).setModelOffsets(-1.0D, 5.0D, 0.0D).setProjectileDamage(20.0F).setProjectileMoveThroughBlocks(true)
    .setProjectileExplosion(2, false).setProjectileCollisionSizes(1.0D, 1.0D, 1.0D)
    .setProjectilePhysical().setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute GOMU_GOMU_NO_KONG_ORGAN = (new AbilityAttribute("Gomu Gomu no Kong Organ"))
    .setProjectileTicks(5).setProjectileModel((ModelBase)new ModelFist())
    .setProjectileTexture("gomugomunokonggun").setProjectileSize(15.0D, 15.0D, 13.0D)
    .setModelOffsets(-1.0D, 5.0D, 0.0D).setProjectileDamage(30.0F)
    .setProjectileMoveThroughBlocks(true).setProjectileExplosion(2, false).setProjectileCollisionSizes(1.0D, 1.0D, 1.0D)
    .setProjectilePhysical().setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute MOCHIGATLING = (new AbilityAttribute("Mochi Gatling")).setProjectileTicks(5).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("mochinopistol").setProjectileSize(15.0D, 15.0D, 13.0D).setModelOffsets(-1.0D, 5.0D, 0.0D).setProjectileDamage(20.0F).setProjectileMoveThroughBlocks(true).setProjectileExplosion(2, false).setProjectileCollisionSizes(1.0D, 1.0D, 1.0D).setProjectilePhysical().setProjectileColor(Color.white.hashCode());
  
  public static final AbilityAttribute VOLT_VARI_5_MILLION = (new AbilityAttribute("5 Million Volt Vari"))
    .setProjectileTicks(10).setProjectileModel((ModelBase)new ModelSphere()).setProjectileModel((ModelBase)new ModelSphere())
    .setProjectileSize(1.0D, 1.0D, 1.0D).setProjectileDamage(2.0F).setProjectileColor("92c1e5").setProjectileDamage(30.0F);
  
  public static final AbilityAttribute VOLT_VARI_20_MILLION = (new AbilityAttribute("20 Million Volt Vari"))
    .setProjectileTicks(20).setProjectileModel((ModelBase)new ModelSphere())
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileSize(3.0D, 3.0D, 3.0D)
    .setProjectileDamage(35.0F).setProjectileColor("7CB9E8");
  
  public static final AbilityAttribute VOLT_VARI_60_MILLION = (new AbilityAttribute("60 Million Volt Vari"))
    .setProjectileTicks(30)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileModel((ModelBase)new ModelSphere())
    .setProjectileSize(5.0D, 5.0D, 5.0D).setProjectileDamage(37.0F).setProjectileColor("6bb0e5");
  
  public static final AbilityAttribute VOLT_VARI_200_MILLION = (new AbilityAttribute("200 Million Volt Vari"))
    .setProjectileTicks(50).setProjectileModel((ModelBase)new ModelSphere())
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileSize(7.0D, 7.0D, 7.0D).setProjectileDamage(40.0F)
    .setProjectileExplosion(3, false).setProjectileColor("3170a0");
  
  public static final AbilityAttribute GRAVITO = (new AbilityAttribute("Gravito")).setProjectileModel((ModelBase)new ModelCube()).setProjectileDamage(5.0F).setProjectileSize(6.0D, 0.4D, 1.5D).setProjectileTicks(100).setProjectileColor("E590DF").setProjectileAlpha(50.0F).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 550, 1), new PotionEffect(Potion.weakness.id, 550, 1) });
  
  public static final AbilityAttribute NORMAL_BULLET = (new AbilityAttribute("Bullet")).setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(4.0F).setProjectileSize(0.5D, 0.5D, 0.5D).setProjectileTicks(100).setProjectileColor("#878787").setProjectileSpeed(2.0F);
  
  public static final AbilityAttribute KAIROSEKI_BULLET = (new AbilityAttribute("Kairoseki Bullet")).setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(6.0F).setProjectileSize(0.5D, 0.5D, 0.5D).setProjectileTicks(100).setProjectileColor("#F3F3F3").setProjectileSpeed(2.0F);
  
  public static final AbilityAttribute POP_GREEN = (new AbilityAttribute("Pop Green")).setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(2.0F).setProjectileSize(0.5D, 0.5D, 0.5D).setProjectileTicks(100).setProjectileColor("#7ccc6a");
  
  public static final AbilityAttribute KUJA_ARROW = (new AbilityAttribute("Kuja Arrow")).setProjectileModel((ModelBase)new ModelArrow()).setProjectileTexture("kujaarrow").setProjectileDamage(4.0F).setProjectileSize(1.25D, 1.25D, 1.25D).setProjectileTicks(100).setProjectileSpeed(5.0F).setProjectileCollisionSizes(0.5D);
  
  public static final AbilityAttribute DIAL_AXE = (new AbilityAttribute("Axe Dial")).setProjectileModel((ModelBase)new ModelCube()).setProjectileDamage(5.0F).setProjectileSize(6.0D, 0.4D, 1.5D).setProjectileTicks(100).setProjectileColor("69E3FF");
  
  public static final AbilityAttribute DIAL_MILKY = (new AbilityAttribute("Milky Dial")).setProjectileModel((ModelBase)new ModelSphere()).setProjectileSize(0.1D, 0.1D, 0.1D).setProjectileTicks(40).setProjectileColor("69E3FF").setProjectileMoveThroughBlocks(true);
  
  public static final AbilityAttribute CANNON_BALL = (new AbilityAttribute("Cannon Ball")).setProjectileModel((ModelBase)new ModelSphere()).setProjectileSize(3.0D, 3.0D, 3.0D).setProjectileTicks(100).setProjectileColor("0B2D41").setProjectileExplosion(3, false);
  
  public static final AbilityAttribute EXNUMAGATLING = (new AbilityAttribute("Numa no Gatling")).setProjectileTicks(5).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("numanopistol").setProjectileSize(3.0D, 3.0D, 3.0D).setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileDamage(6.0F).setProjectilePhysical();
}
