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
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelBrickBat;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelFist;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelHeart;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelHydra;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelMeigo;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelMiniHollow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelNegativeHollow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelNoroNoroBeam;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelPaw;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelPheasant;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelShark;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelSolar;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelSpear;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelTokuHollow;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelTrident;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.ModelYukiRabi;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.Kamaitachi;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.boro;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.buzzmochi;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.everwhite;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.flapThread;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.godthreat;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.hmodel;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.inugami;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.nuprojo;
import xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle.yaki;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.biskit;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.soldierpro;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.thundercloud;

public class ListAttributes {
  public static final AbilityAttribute MINI_MINI_NO_FULL_REBOUND = (new AbilityAttribute("Mini Mini no Full Rebound"))
    
    .setAbilityCooldown(3.0D).setAbilityPassive(true);
  
  public static final AbilityAttribute BIGAN = (new AbilityAttribute("Bigan")).setAbilityCooldown(8.0D)
    .setProjectileDamage(40.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("#6D5E24").setProjectileSize(1.0D, 1.0D, 2.4D).setProjectileTicks(10).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.weakness.id, 600, 0), new PotionEffect(Potion.moveSlowdown.id, 600, 2) }).setModelOffsets(0.0D, 1.5D, 0.0D);
  
  public static final AbilityAttribute GIRAFFE_SPEED_POINT = (new AbilityAttribute("Giraffe Speed Point")).setAbilityDisplayName("Speed Point").setAbilityTexture("giraffefull").setAbilityCooldown(1.0D).setAbilityPassive(true);
  
  public static final AbilityAttribute GIRAFFE_POWER_POINT = (new AbilityAttribute("Giraffe Power Point")).setAbilityDisplayName("Power Point").setAbilityTexture("giraffehybrid").setAbilityCooldown(1.0D).setAbilityPassive(true);
  
  public static final AbilityAttribute MOGURA_TONPO = (new AbilityAttribute("Mogura Tonpo: Mogugyo")).setAbilityCooldown(10.0D).setAbilityTexture("moguratonpo");
  
  public static final AbilityAttribute MOGURA_BANANA = (new AbilityAttribute("Mogura Banana"))
    .setAbilityCooldown(12.0D).setAbilityPunch(25.0F);
  
  public static final AbilityAttribute MOGU_POWER_POINT = (new AbilityAttribute("Mogu Power Point")).setAbilityDisplayName("Mole Point").setAbilityTexture("molepoint").setAbilityCooldown(1.0D).setAbilityPassive(true);
  
  public static final AbilityAttribute GANMEN_SEICHO_HORMONE = (new AbilityAttribute("Ganmen Seicho Hormone")).setAbilityCooldown(5.0D).setAbilityPunch();
  
  public static final AbilityAttribute TENSION_HORMONE = (new AbilityAttribute("Tension Hormone")).setAbilityCooldown(40.0D).setAbilityPunch();
  
  public static final AbilityAttribute CHIYU_HORMONE = (new AbilityAttribute("Chiyu Hormone")).setAbilityCooldown(20.0D).setAbilityPunch();
  
  public static final AbilityAttribute ONNA_HORMONE = (new AbilityAttribute("Onna Hormone")).setAbilityCooldown(15.0D).setAbilityPunch();
  
  public static final AbilityAttribute CHIYUPOPO = (new AbilityAttribute("Chiyupopo")).setAbilityCooldown(10.0D);
  
  public static final AbilityAttribute HEALING_TOUCH = (new AbilityAttribute("Healing Touch")).setAbilityCooldown(15.0D).setAbilityPunch();
  
  public static final AbilityAttribute ZOU_HYBRID_POINT = (new AbilityAttribute("Zou Hybrid Point")).setAbilityCooldown(1.0D).setAbilityDisplayName("Hybrid Point")
    .setAbilityTexture("zouhybrid").setAbilityPassive(true);
  
  public static final AbilityAttribute ZOU_FULL_POINT = (new AbilityAttribute("Zou Point")).setAbilityTexture("zoufull").setAbilityCooldown(1.0D).setAbilityPassive(true);
  
  public static final AbilityAttribute IVORY_DART = (new AbilityAttribute("Ivory Dart"))
    .setAbilityCooldown(10.0D).setProjectileDamage(50.0F);
  
  public static final AbilityAttribute GREAT_STOMP = (new AbilityAttribute("Great Stomp")).setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute IVORY_STOMP = (new AbilityAttribute("Ivory Stomp")).setAbilityCooldown(8.0D).setAbilityPunch().setAbilityPunch(40.0F);
  
  public static final AbilityAttribute TRUNK_SHOT = (new AbilityAttribute("Trunk Shot")).setAbilityCooldown(7.0D)
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileTexture("zouskin")
    .setProjectileSize(2.5D, 2.5D, 4.0D).setProjectileColor("838993").setProjectileDamage(30.0F).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.weakness.id, 100) }).setProjectilePhysical();
  
  public static final AbilityAttribute SOUL_PARADE = (new AbilityAttribute("Soul Parade")).addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100) }).setAbilityCooldown(5.0D).setAbilityPassive();
  
  public static final AbilityAttribute KASURIUTA_FUBUKI_GIRI = (new AbilityAttribute("Kasuriuta: Fubuki Giri")).setAbilityCooldown(10.0D);
  
  public static final AbilityAttribute BAKU_BAKU_FACTORY = new AbilityAttribute("Baku Baku Factory");
  
  public static final AbilityAttribute BAKU_TSUIHO = (new AbilityAttribute("Baku Tsuiho"))
    .setAbilityCooldown(10.0D).setAbilityCharges(200)
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(2.0D, 2.0D, 2.0D)
    .setProjectileColor("E3E3E3").setProjectileDamage(50.0F);
  
  public static final AbilityAttribute BERO_CANNON = (new AbilityAttribute("Bero Cannon"))
    .setAbilityCooldown(5.0D)
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(2.0D, 2.0D, 2.0D)
    .setProjectileColor("E3E3E3").setProjectileDamage(35.0F);
  
  public static final AbilityAttribute BAKU_MUNCH = (new AbilityAttribute("Baku Munch")).setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute PHOENIX_HYBRID_POINT = (new AbilityAttribute("Phoenix Hybrid Point"))
    .setAbilityCooldown(1.0D).setAbilityDisplayName("Hybrid Point").setAbilityTexture("phoenixhybrid")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute PHOENIX_FULL_POINT = (new AbilityAttribute("Phoenix Point")).setAbilityTexture("phoenixfull").setAbilityCooldown(1.0D).setAbilityPassive(true);
  
  public static final AbilityAttribute BLUE_FLAMES_OF_RESURRECTION = (new AbilityAttribute("Blue Flames of Resurrection")).setAbilityCooldown(20.0D)
    .addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.regeneration.id, 60, 4) });
  
  public static final AbilityAttribute FLAME_OF_RESTORATION = (new AbilityAttribute("Flame of Restoration")).setAbilityCooldown(3.0D).setAbilityPassive().setAbilityPunch();
  
  public static final AbilityAttribute PHOENIX_GOEN = (new AbilityAttribute("Phoenix Goen")).setAbilityCooldown(10.0D).setProjectileDamage(12.0F);
  
  public static final AbilityAttribute TENSEI_NO_SOEN = (new AbilityAttribute("Tensei no Soen"))
    .setAbilityCooldown(30.0D).setAbilityCharges(100);
  
  public static final AbilityAttribute BISON_POWER_POINT = (new AbilityAttribute("Bison Power Point")).setAbilityCooldown(1.0D).setAbilityDisplayName("Hybrid Point").setAbilityTexture("bisonhybrid").setAbilityPassive(true);
  
  public static final AbilityAttribute BISON_SPEED_POINT = (new AbilityAttribute("Bison Speed Point")).setAbilityCooldown(1.0D).setAbilityDisplayName("Bison Point").setAbilityTexture("bisonfull").setAbilityPassive(true);
  
  public static final AbilityAttribute FIDDLE_BANFF = (new AbilityAttribute("Fiddle Banff")).setAbilityCooldown(7.0D);
  
  public static final AbilityAttribute KOKUTEI_CROSS = (new AbilityAttribute("Kokutei Cross"))
    .setAbilityCooldown(7.0D).setAbilityPassive().setAbilityPunch(35.0F);
  
  public static final AbilityAttribute SAGARI_NO_RYUSEI = (new AbilityAttribute("Sagari no Ryusei"))
    .setAbilityCooldown(20.0D).setProjectileTicks(256)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("51585B")
    .setProjectileSize(50.0D, 50.0D, 50.0D).setProjectileDamage(100.0F).setProjectileExplosion(20, false).setProjectileCollisionSizes(2.0D, 2.0D, 2.0D);
  
  public static final AbilityAttribute MOKO = (new AbilityAttribute("Moko")).setProjectileDamage(35.0F).setAbilityCooldown(12.0D).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(new double[] { 0.0D, 0.0D, 0.0D }).setProjectileMoveThroughBlocks(true);
  
  public static final AbilityAttribute ABARE_HIMATSURI = (new AbilityAttribute("Abare Himatsuri")).setAbilityCooldown(10.0D).setAbilityPassive();
  
  public static final AbilityAttribute JURYOKU = (new AbilityAttribute("Juryoku")).setAbilityDisplayName("Jigoku Tabi").setAbilityCooldown(12.0D).setAbilityPassive();
  
  public static final AbilityAttribute LightningRide = (new AbilityAttribute("Lightning Ride"))
    .setAbilityCooldown(10.0D).setAbilityTexture("lride").setAbilityPassive();
  
  public static final AbilityAttribute BLACK_WORLD = (new AbilityAttribute("Black World")).setAbilityCooldown(25.0D).addEffects(EffectType.AOE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 200, 100), new PotionEffect(Potion.digSlowdown.id, 200, 100), new PotionEffect(Potion.blindness.id, 200, 2) }).setEffectRadius(20);
  
  public static final AbilityAttribute DARK_MATTER = (new AbilityAttribute("Dark Matter"))
    .setAbilityCooldown(12.0D).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("000000")
    .setProjectileSize(7.0D, 7.0D, 7.0D).setProjectileDamage(50.0F);
  
  public static final AbilityAttribute KUROUZU = (new AbilityAttribute("Kurouzu")).setAbilityCooldown(10.0D).setAbilityCharges(60);
  
  public static final AbilityAttribute LIBERATION = (new AbilityAttribute("Liberation")).setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute BLACKHOLE = (new AbilityAttribute("Black Hole")).setAbilityCooldown(7.0D);
  
  public static final AbilityAttribute TODOROKI = (new AbilityAttribute("Todoroki"))
    .setAbilityCooldown(20.0D).setProjectileModel((ModelBase)new ModelCube())
    .setProjectileColor("#87CEFA").setProjectileSize(2.0D, 2.0D, 4.0D).setProjectileDamage(40.0F).setAbilityRepeater(20, 3);
  
  public static final AbilityAttribute PERFUME_FEMUR = (new AbilityAttribute("Perfume Femur")).setAbilityCooldown(10.0D).setAbilityPunch(10.0F);
  
  public static final AbilityAttribute SLAVE_ARROW = (new AbilityAttribute("Slave Arrow")).setAbilityCooldown(10.0D)
    .setProjectileModel((ModelBase)new ModelArrow()).setProjectileColor("#FF69B4")
    .setProjectileSize(1.0D, 1.0D, 2.0D).setProjectileDamage(20.0F).setAbilityRepeater().setAbilityCharges(140);
  
  public static final AbilityAttribute PISTOL_KISS = (new AbilityAttribute("Pistol Kiss")).setAbilityCooldown(5.0D)
    .setProjectileModel((ModelBase)new ModelHeart()).setProjectileSize(0.5D, 0.5D, 0.5D)
    .setProjectileTexture("meromeromellow").setProjectileDamage(15.0F).setModelOffsets(0.0D, -0.5D, 0.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 100, 5), new PotionEffect(Potion.digSlowdown.id, 100, 5) });
  
  public static final AbilityAttribute MERO_MERO_MELLOW = (new AbilityAttribute("Mero Mero Mellow"))
    .setAbilityCooldown(20.0D).setProjectileModel((ModelBase)new ModelHeart())
    .setProjectileSize(3.0D, 3.0D, 3.0D).setProjectileTexture("meromeromellow")
    .setProjectileDamage(25.0F).setModelOffsets(0.0D, -1.0D, 0.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 400, 100), new PotionEffect(Potion.digSlowdown.id, 400, 100) }).setProjectileCollisionSizes(1.25D, 1.25D, 1.25D);
  
  public static final AbilityAttribute SPARKLING_DAISY = (new AbilityAttribute("Sparkling Daisy")).setAbilityCooldown(12.0D);
  
  public static final AbilityAttribute SPIRAL_HOLLOW = (new AbilityAttribute("Spiral Hollow")).setAbilityCooldown(10.0D).setProjectileDamage(20.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("#F8F8FF").setProjectileSize(3.0D, 3.0D, 5.0D).setProjectileTicks(3).setProjectilePhysical();
  
  public static final AbilityAttribute ATOMIC_SPURT = (new AbilityAttribute("Atomic Spurt")).setAbilityCooldown(25.0D).setAbilityPassive();
  
  public static final AbilityAttribute SPAR_CLAW = (new AbilityAttribute("Spar Claw")).setAbilityCooldown(5.0D).setAbilityPassive(true).setAbilityPunch(10.0F);
  
  public static final AbilityAttribute SPIDER = (new AbilityAttribute("Spider")).addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100), new PotionEffect(Potion.digSlowdown.id, 30, 5), new PotionEffect(Potion.jump.id, 30, -100) }).setAbilityPassive();
  
  public static final AbilityAttribute NEGATIVE_HOLLOW = (new AbilityAttribute("Negative Hollow")).setAbilityCooldown(6.0D).setProjectileModel((ModelBase)new ModelNegativeHollow())
    .setProjectileTexture("negativehollow").setProjectileAlpha(150.0F)
    .setProjectileSize(2.0D, 2.0D, 2.0D).setProjectileDamage(25.0F).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.confusion.id, 200, 1), new PotionEffect(Potion.moveSlowdown.id, 200, 1) });
  
  public static final AbilityAttribute MINI_HOLLOW = (new AbilityAttribute("Mini Hollow")).setAbilityCooldown(3.0D).setProjectileModel((ModelBase)new ModelMiniHollow()).setProjectileSize(0.4D, 0.4D, 0.4D).setProjectileColor("#F8F8FF").setProjectileAlpha(150.0F).setProjectileDamage(2.0F).setProjectileExplosion(2, false).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.confusion.id, 120, 0), new PotionEffect(Potion.moveSlowdown.id, 120, 0) }).setAbilityRepeater();
  
  public static final AbilityAttribute TOKU_HOLLOW = (new AbilityAttribute("Toku Hollow"))
    .setAbilityCooldown(10.0D).setProjectileModel((ModelBase)new ModelTokuHollow()).setProjectileTexture("tokuhollow")
    .setProjectileAlpha(150.0F).setProjectileSize(4.0D, 4.0D, 4.0D).setProjectileDamage(45.0F).setProjectileExplosion(7, false).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.confusion.id, 400, 1), new PotionEffect(Potion.moveSlowdown.id, 400, 1) }).setProjectileCollisionSizes(1.5D, 1.5D, 1.5D);
  
  public static final AbilityAttribute BLACK_KNIGHT = (new AbilityAttribute("Black Knight")).setAbilityCooldown(15.0D).setAbilityPassive();
  
  public static final AbilityAttribute KUMO_NO_SUGAKI = (new AbilityAttribute("Kumo no Sugaki")).setAbilityCooldown(10.0D).addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100), new PotionEffect(Potion.digSlowdown.id, 30, 5), new PotionEffect(Potion.jump.id, 30, -100) }).setAbilityPassive();
  
  public static final AbilityAttribute TORIKAGO = (new AbilityAttribute("Torikago")).setAbilityCooldown(2.0D).setAbilityPassive(true);
  
  public static final AbilityAttribute TAMAITO = (new AbilityAttribute("Tamaito")).setAbilityCooldown(5.0D).setProjectileDamage(45.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.5D, 0.5D, 1.0D).setProjectileColor("#dee1e5");
  
  public static final AbilityAttribute OVERHEAT = (new AbilityAttribute("Overheat")).setAbilityCooldown(8.0D).setProjectileDamage(70.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(1.0D, 1.0D, 5.0D).setProjectileExplosion(3, false).setProjectileColor("#f77c25");
  
  public static final AbilityAttribute SORA_NO_MICHI = (new AbilityAttribute("Sora no Michi")).setAbilityCooldown(1.0D);
  
  public static final AbilityAttribute PARASITE = (new AbilityAttribute("Parasite")).setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute BARRIERBILITY_STAIRS = (new AbilityAttribute("Barrierbility Stairs")).setProjectileTicks(60).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.0D, 0.0D, 0.0D).setProjectileMoveThroughBlocks(true).setAbilityPassive();
  
  public static final AbilityAttribute BARI_BARI_NO_PISTOL = (new AbilityAttribute("Bari Bari no Pistol")).setAbilityCooldown(5.0D).setAbilityPassive().setAbilityPunch();
  
  public static final AbilityAttribute BARRIER_BALL = (new AbilityAttribute("Barrier Ball")).setAbilityCooldown(0.5D).setAbilityPassive();
  
  public static final AbilityAttribute BARRIER_CRASH = (new AbilityAttribute("Barrier Crash")).setAbilityCooldown(5.0D).setProjectileTicks(60).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("#87CEFA").setProjectileSize(9.0D, 9.0D, 0.3D).setProjectileDamage(15.0F).setProjectileCollisionSizes(1.5D, 2.0D, 1.5D);
  
  public static final AbilityAttribute BARRIER = (new AbilityAttribute("Barrier")).setAbilityPassive();
  
  public static final AbilityAttribute YUKI_GAKI = (new AbilityAttribute("Yuki Gaki")).setAbilityCooldown(8.0D);
  
  public static final AbilityAttribute FUBUKI = (new AbilityAttribute("Fubuki")).setAbilityCooldown(12.0D).setProjectileDamage(35.0F);
  
  public static final AbilityAttribute TABIRA_YUKI = (new AbilityAttribute("Tabira Yuki")).setAbilityPassive(true);
  
  public static final AbilityAttribute KAMAKURA_JUSSOSHI = (new AbilityAttribute("Kamakura Jussoshi")).setAbilityCooldown(18.0D);
  
  public static final AbilityAttribute YUKI_RABI = (new AbilityAttribute("Yuki Rabi")).setAbilityCooldown(2.0D)
    .setProjectileColor(Color.WHITE).setProjectileDamage(25.0F).setProjectileModel((ModelBase)new ModelYukiRabi()).setProjectileTexture("yukirabi").setProjectileSize(1.0D, 1.0D, 1.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 50, 1) }).setAbilityRepeater(2, 2);
  
  public static final AbilityAttribute KAMAKURA = (new AbilityAttribute("Kamakura")).setAbilityCooldown(6.0D);
  
  public static final AbilityAttribute KARAKUNI = (new AbilityAttribute("Karakuni")).setAbilityCooldown(20.0D);
  
  public static final AbilityAttribute BLUE_SWORD = (new AbilityAttribute("Blue Sword")).setAbilityPassive(true);
  
  public static final AbilityAttribute GASTANET = (new AbilityAttribute("Gastanet")).setAbilityCooldown(6.0D)
    .setAbilityExplosion(5, false);
  
  public static final AbilityAttribute GASTILLE = (new AbilityAttribute("Gastille")).setAbilityCooldown(7.0D).setProjectileSpeed(2.0F).setProjectileDamage(10.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("324AB2").setProjectileSize(1.0D, 1.0D, 2.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.poison.id, 200, 1) }).setAbilityRepeater().setProjectileExplosion(1, false);
  
  public static final AbilityAttribute GAS_ROBE = (new AbilityAttribute("Gas Robe"))
    .setAbilityCooldown(6.0D).setProjectileSpeed(2.0F).setProjectileDamage(50.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.0D, 0.0D, 0.0D).setAbilityRepeater();
  
  public static final AbilityAttribute DOKU_GUMO = (new AbilityAttribute("Doku Gumo")).setAbilityCooldown(30.0D).setAbilityPassive();
  
  public static final AbilityAttribute DOKU_FUGU = (new AbilityAttribute("Doku Fugu"))
    .setAbilityCooldown(8.0D).setProjectileDamage(20.0F).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("A020F0").setProjectileSize(5.0D, 5.0D, 5.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.poison.id, 240, 1) }).setAbilityRepeater(10, 3);
  
  public static final AbilityAttribute VENOM_DEMON = (new AbilityAttribute("Venom Demon")).setAbilityCooldown(40.0D).setAbilityPassive(true);
  
  public static final AbilityAttribute VENOM_ROAD = (new AbilityAttribute("Venom Road"))
    .setAbilityCooldown(8.0D).setProjectileDamage(40.0F).setProjectileModel((ModelBase)new ModelHydra()).setProjectileTexture("hydra").setProjectileSize(2.0D, 2.0D, 2.4D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.poison.id, 500, 1) });
  
  public static final AbilityAttribute CHLORO_BALL = (new AbilityAttribute("Chloro Ball"))
    .setAbilityCooldown(6.0D).setProjectileDamage(35.0F).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("A020F0").setProjectileSize(5.0D, 5.0D, 5.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.poison.id, 240, 1) });
  
  public static final AbilityAttribute HYDRA = (new AbilityAttribute("Hydra")).setAbilityCooldown(8.0D).setProjectileDamage(30.0F).setProjectileModel((ModelBase)new ModelHydra()).setProjectileTexture("hydra").setProjectileSize(2.0D, 2.0D, 2.4D).setProjectileTicks(10).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.poison.id, 500, 1) });
  
  public static final AbilityAttribute CANDLE_LOCK = (new AbilityAttribute("Candle Lock"))
    .setAbilityCooldown(15.0D).setProjectileDamage(15.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("A2ADD0").setProjectileSize(0.5D, 0.5D, 1.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 400, 100), new PotionEffect(Potion.digSlowdown.id, 400, 100), new PotionEffect(Potion.jump.id, 400, -1) });
  
  public static final AbilityAttribute CANDLE_HOUSE = (new AbilityAttribute("Candle House")).setAbilityCooldown(30.0D);
  
  public static final AbilityAttribute CANDLE_WALL = (new AbilityAttribute("Candle Wall")).setAbilityCooldown(4.0D);
  
  public static final AbilityAttribute DORU_DORU_ARTS_KEN = (new AbilityAttribute("Doru Doru Arts : Ken"))
    .setAbilityPassive(true);
  
  public static final AbilityAttribute DORU_DORU_ARTS_MORI = (new AbilityAttribute("Doru Doru Arts : Mori"))
    .setAbilityCooldown(3.0D).setProjectileDamage(25.0F).setProjectileModel((ModelBase)new ModelSpear())
    .setProjectileTexture("dorudoruartsmori").setProjectileSize(2.0D, 2.0D, 2.0D).setModelOffsets(0.0D, 1.0D, 0.0D);
  
  public static final AbilityAttribute BAKURETSU_KAZAN = (new AbilityAttribute("Bakuretsu Kazan")).setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute RYUSEI_KAZAN = (new AbilityAttribute("Ryusei Kazan"))
    .setAbilityCooldown(12.0D).setProjectileDamage(35.0F).setAbilityRepeater();
  
  public static final AbilityAttribute MEIGO = (new AbilityAttribute("Meigo")).setAbilityCooldown(10.0D)
    .setProjectileDamage(50.0F).setProjectileModel((ModelBase)new ModelMeigo()).setProjectileTexture("meigo")
    .setProjectileSize(4.0D, 4.0D, 4.0D).setModelOffsets(0.0D, 1.2D, 0.0D).setProjectileTicks(3);
  
  public static final AbilityAttribute DAI_FUNKA = (new AbilityAttribute("Dai Funka")).setAbilityCooldown(8.0D).setProjectileDamage(55.0F)
    .setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("daifunka")
    .setProjectileSize(4.0D, 4.0D, 4.0D).setModelOffsets(0.0D, 1.0D, 0.0D);
  
  public static final AbilityAttribute DESERT_GIRASOLE = (new AbilityAttribute("Desert Girasole")).setAbilityCooldown(25.0D).setAbilityCharges(100);
  
  public static final AbilityAttribute DESERT_ENCIERRO = (new AbilityAttribute("Desert Encierro"))
    .setAbilityCooldown(10.0D).setAbilityPunch(50.0F)
    .addEffects(EffectType.HIT, new PotionEffect[] { new PotionEffect(Potion.hunger.id, 100, 1), new PotionEffect(Potion.weakness.id, 100, 1), new PotionEffect(Potion.moveSlowdown.id, 100, 1), new PotionEffect(Potion.digSlowdown.id, 100, 1) });
  
  public static final AbilityAttribute GROUND_DEATH = (new AbilityAttribute("Ground Death")).setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute BARJAN = (new AbilityAttribute("Barjan")).setAbilityCooldown(5.0D)
    .setProjectileDamage(30.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("967117").setProjectileSize(6.0D, 0.4D, 1.5D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.hunger.id, 500, 1) }).setProjectileMoveThroughBlocks(true).setProjectileCollisionSizes(1.25D, 0.3D, 1.25D);
  
  public static final AbilityAttribute SABLES = (new AbilityAttribute("Sables")).setAbilityCooldown(3.0D)
    .setAbilityPassive().setAbilityPunch(40.0F);
  
  public static final AbilityAttribute SABLESPESADO = (new AbilityAttribute("SablesPesado")).setAbilityCooldown(3.0D)
    .setAbilityPassive().setAbilityPunch(60.0F);
  
  public static final AbilityAttribute DESERT_SPADA = (new AbilityAttribute("Desert Spada")).setAbilityCooldown(10.0D);
  
  public static final AbilityAttribute TSUNOTOKAGE = (new AbilityAttribute("Tsuno-Tokage"))
    .setAbilityCooldown(10.0D);
  
  public static final AbilityAttribute BLACK_BOX = (new AbilityAttribute("Black Box"))
    .setAbilityCooldown(6.0D).setProjectileModel((ModelBase)new ModelCube())
    .setProjectileColor(Color.black).setProjectileSize(2.0D, 2.0D, 2.0D).setProjectileDamage(60.0F);
  
  public static final AbilityAttribute KAGEMUSHA = (new AbilityAttribute("Kagemusha")).setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute DOPPELMAN = (new AbilityAttribute("Doppelman")).setAbilityCooldown(15.0D).setAbilityPassive();
  
  public static final AbilityAttribute BRICK_BAT = (new AbilityAttribute("Brick Bat"))
    .setAbilityCooldown(4.0D)
    .setProjectileDamage(35.0F).setProjectileModel((ModelBase)new ModelBrickBat()).setProjectileSize(1.0D, 1.0D, 1.0D)
    .setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileTexture("brickbat")
    .setAbilityRepeater(3, 2);
  
  public static final AbilityAttribute GEKISHIN = (new AbilityAttribute("Gekishin")).setAbilityCooldown(15.0D)
    .setAbilityPassive().setAbilityPunch().setProjectileDamage(200.0F);
  
  public static final AbilityAttribute SHIMA_YURASHI = (new AbilityAttribute("Shima Yurashi")).setAbilityCooldown(15.0D).setProjectileDamage(20.0F).setProjectileExplosion(5, false).setProjectileMoveThroughBlocks(true);
  
  public static final AbilityAttribute KABUTOWARI = (new AbilityAttribute("Kabutowari")).setAbilityCooldown(7.0D).setProjectileDamage(150.0F)
    .setAbilityExplosion(5, false);
  
  public static final AbilityAttribute KAISHIN = (new AbilityAttribute("Kaishin")).setAbilityCooldown(7.0D)
    .setProjectileDamage(150.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.0D, 0.0D, 0.0D)
    .setProjectileExplosion(3, false, false).setProjectileDamage(150.0F);
  
  public static final AbilityAttribute KICK_BOMB = (new AbilityAttribute("Kick Bomb")).setAbilityCooldown(7.0D).setAbilityExplosion(7, false);
  
  public static final AbilityAttribute NOSE_FANCY_CANNON = (new AbilityAttribute("Nose Fancy Cannon"))
    .setAbilityCooldown(3.0D).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("3D2B1F")
    .setProjectileSize(0.4D, 0.4D, 0.8D).setProjectileDamage(15.0F).setProjectileExplosion(3, false);
  
  public static final AbilityAttribute URSUS_SHOCK = (new AbilityAttribute("Ursus Shock")).setAbilityCooldown(15.0D).setProjectileModel((ModelBase)new ModelPaw()).setProjectileColor("F8F8FF").setProjectileAlpha(80.0F).setProjectileSize(3.5D, 3.5D, 3.5D).setProjectileDamage(50.0F).setProjectileExplosion(8, false, true).setAbilityCharges(40).setProjectileCollisionSizes(1.5D, 1.5D, 1.5D);
  
  public static final AbilityAttribute PAD_HO = (new AbilityAttribute("Pad Ho")).setAbilityCooldown(8.0D).setProjectileModel((ModelBase)new ModelPaw()).setProjectileColor("F8F8FF").setProjectileAlpha(80.0F).setProjectileSize(1.0D, 1.0D, 1.0D).setProjectileDamage(10.0F).setProjectileExplosion(1, false, true);
  
  public static final AbilityAttribute TSUPPARI_PAD_HO = (new AbilityAttribute("Tsuppari Pad Ho")).setAbilityCooldown(10.0D).setProjectileDamage(15.0F).setProjectileExplosion(1, false, true).setAbilityRepeater(5, 7);
  
  public static final AbilityAttribute HANPATSU = (new AbilityAttribute("Hanpatsu")).setAbilityCooldown(4.0D).setAbilityPassive().setAbilityPunch();
  
  public static final AbilityAttribute WHITE_STRIKE = (new AbilityAttribute("White Strike")).setAbilityCooldown(35.0D).addEffects(EffectType.AOE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 300, 1), new PotionEffect(Potion.digSlowdown.id, 300, 1), new PotionEffect(Potion.jump.id, 300, -10) }).setEffectRadius(30);
  
  public static final AbilityAttribute WHITE_LAUNCHER = (new AbilityAttribute("White Launcher"))
    .setAbilityCooldown(5.0D).setAbilityCharges(20);
  
  public static final AbilityAttribute WHITE_SNAKE = (new AbilityAttribute("White Snake")).setAbilityCooldown(5.0D).setProjectileTicks(120).setProjectileModel((ModelBase)new ModelCube()).setProjectileSpeed(5.0F).setProjectileSize(0.0D, 0.0D, 0.0D).setProjectileDamage(30.0F).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.poison.id, 120, 0) });
  
  public static final AbilityAttribute WHITE_OUT = (new AbilityAttribute("White Out"))
    .setAbilityCooldown(4.0D).setProjectileModel((ModelBase)new ModelCube()).setProjectileSpeed(5.0F)
    .setProjectileSize(0.0D, 0.0D, 0.0D).setProjectileDamage(5.0F)
    .addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 240, 1), new PotionEffect(Potion.digSlowdown.id, 240, 1), new PotionEffect(Potion.jump.id, 240, -10) });
  
  public static final AbilityAttribute SANGO = (new AbilityAttribute("Sango")).setAbilityCooldown(10.0D)
    .setProjectileTicks(128).setProjectileModel((ModelBase)new ModelCube())
    .setProjectileSize(0.0D, 0.0D, 0.0D)
    .setProjectileColor("7CB9E8").setProjectileDamage(25.0F).setAbilityRepeater();
  
  public static final AbilityAttribute KARI = (new AbilityAttribute("Kari")).setAbilityCharges(140).setAbilityCooldown(15.0D).setAbilityExplosion(10, false, false);
  
  public static final AbilityAttribute RAIGO = (new AbilityAttribute("Raigo")).setAbilityCooldown(45.0D).setProjectileTicks(256).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("5D8AA8").setProjectileSize(50.0D, 50.0D, 50.0D).setProjectileDamage(120.0F).setProjectileExplosion(30, false).setProjectileCollisionSizes(2.0D);
  
  public static final AbilityAttribute VOLT_VARI = (new AbilityAttribute("Volt Vari")).setAbilityCooldown(3.0D)
    .setAbilityCharges(200, true);
  
  public static final AbilityAttribute EL_THOR = (new AbilityAttribute("El Thor")).setAbilityCooldown(8.0D)
    .setAbilityCharges(120);
  
  public static final AbilityAttribute SPARK_STEP = (new AbilityAttribute("Spark Step")).setAbilityCooldown(3.0D);
  
  public static final AbilityAttribute INJECTION_SHOT = (new AbilityAttribute("Injection Shot")).setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute SHAMBLES = (new AbilityAttribute("Shambles")).setAbilityCooldown(8.0D);
  
  public static final AbilityAttribute TAKT = (new AbilityAttribute("Takt")).setAbilityCooldown(10.0D).setAbilityPassive();
  
  public static final AbilityAttribute GAMMA_KNIFE = (new AbilityAttribute("Gamma Knife")).setAbilityCooldown(30.0D).setProjectileTicks(20).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("00AB66").setProjectileDamage(100.0F).setProjectileSize(1.0D, 1.0D, 5.0D);
  
  public static final AbilityAttribute MES = (new AbilityAttribute("Mes")).setAbilityCooldown(5.0D).setAbilityPassive().setAbilityPunch(1.0F);
  
  public static final AbilityAttribute COUNTER_SHOCK = (new AbilityAttribute("Counter Shock")).setAbilityCooldown(10.0D).setAbilityPassive().setAbilityPunch(40.0F).setAbilityExplosion(1, false);
  
  public static final AbilityAttribute ROOM = (new AbilityAttribute("Room")).setAbilityCooldown(1.0D)
    .setAbilityPassive(true);
  
  public static final AbilityAttribute NORO_NORO_BEAM = (new AbilityAttribute("Noro Noro Beam"))
    .setAbilityCooldown(5.0D)
    .setProjectileTicks(10).setProjectileModel((ModelBase)new ModelNoroNoroBeam())
    .setProjectileTexture("noronorobeam").setProjectileSize(5.0D, 5.0D, 5.0D)
    .setProjectileSpeed(1.6F);
  
  public static final AbilityAttribute KYUBI_RUSH = (new AbilityAttribute("Kyubi Rush")).setAbilityCooldown(7.0D).setAbilityPassive().setAbilityPunch();
  
  public static final AbilityAttribute NORO_NORO_BEAM_SWORD = (new AbilityAttribute("Noro Noro Beam Sword")).setAbilityPassive(true);
  
  public static final AbilityAttribute AIR_DOOR = (new AbilityAttribute("Air Door")).setAbilityPassive(true).setAbilityCooldown(40.0D);
  
  public static final AbilityAttribute DOOR = (new AbilityAttribute("Door")).setAbilityCooldown(8.0D);
  
  public static final AbilityAttribute SUKE_PUNCH = (new AbilityAttribute("Suke Punch")).setAbilityPassive().setAbilityPunch();
  
  public static final AbilityAttribute SHISHA_NO_TE = (new AbilityAttribute("Shisha no Te")).setAbilityCooldown(3.0D).setProjectileDamage(5.0F).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.0D, 0.0D, 0.0D).setProjectileExplosion(3, false);
  
  public static final AbilityAttribute SKATTING = (new AbilityAttribute("Skatting")).addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.invisibility.id, 30, 5) }).setAbilityPassive();
  
  public static final AbilityAttribute GEAR_SECOND = (new AbilityAttribute("Gear Second")).setAbilityCooldown(60.0D).setAbilityPassive();
  
  public static final AbilityAttribute GEAR_THIRD = (new AbilityAttribute("Gear Third")).setAbilityCooldown(90.0D).setAbilityPassive();
  
  public static final AbilityAttribute GEAR_FOURTH = (new AbilityAttribute("Gear Fourth"))
    .setAbilityCooldown(300.0D).setAbilityPassive();
  
  public static final AbilityAttribute GOMU_GOMU_NO_ROCKET = (new AbilityAttribute("Gomu Gomu no Rocket"))
    .setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("gomugomunopistol")
    .setProjectileSize(3.0D, 3.0D, 3.0D).setModelOffsets(0.0D, 1.0D, 0.0D)
    .setProjectileDamage(25.0F).setAbilityCooldown(8.0D).setProjectilePhysical()
    .setProjectileSpeed(2.5F);
  
  public static final AbilityAttribute GOMU_GOMU_NO_BAZOOKA = (new AbilityAttribute("Gomu Gomu no Bazooka"))
    .setAbilityCharges(10);
  
  public static final AbilityAttribute GOMU_GOMU_NO_GATLING = (new AbilityAttribute("Gomu Gomu no Gatling"))
    .setProjectileTicks(10)
    .setAbilityCooldown(5.0D);
  
  public static final AbilityAttribute GOMU_GOMU_NO_PISTOL = new AbilityAttribute("Gomu Gomu no Pistol");
  
  public static final AbilityAttribute FLASH = (new AbilityAttribute("Flash")).setAbilityCooldown(5.0D).addEffects(EffectType.AOE, new PotionEffect[] { new PotionEffect(Potion.blindness.id, 140, 3), new PotionEffect(Potion.moveSlowdown.id, 140, 1) }).setEffectRadius(10);
  
  public static final AbilityAttribute AMA_NO_MURAKUMO = (new AbilityAttribute("Ama no Murakumo")).setAbilityPassive(true);
  
  public static final AbilityAttribute AMATERASU = (new AbilityAttribute("Amaterasu"))
    .setAbilityCooldown(15.0D).setProjectileTicks(150).setProjectileModel((ModelBase)new ModelCube())
    .setProjectileSize(1.0D, 1.0D, 1.0D).setProjectileColor("FFFF00")
    .setProjectileSpeed(5.0F).setProjectileDamage(50.0F).setProjectileExplosion(6, false).setAbilityCharges(40);
  
  public static final AbilityAttribute YASAKANI_NO_MAGATAMA = (new AbilityAttribute("Yasakani no Magatama"))
    .setAbilityCooldown(25.0D)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileSize(0.5D, 0.5D, 0.5D)
    .setProjectileColor("FFFF00").setAbilityRepeater(2)
    .setProjectileDamage(5.0F).setProjectileExplosion(1, false).setProjectileSpeed(5.0F);
  
  public static final AbilityAttribute YATA_NO_KAGAMI = (new AbilityAttribute("Yata no Kagami")).setAbilityCooldown(4.0D);
  
  public static final AbilityAttribute SPRING_DEATH_KNOCK = (new AbilityAttribute("Spring Death Knock"))
    .setAbilityCooldown(6.0D).setProjectileDamage(60.0F).setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("springdeathknock").setModelOffsets(-1.0D, 1.5D, 0.0D).setProjectileSize(7.0D, 5.0D, 5.0D).setProjectileTicks(3).setProjectilePhysical();
  
  public static final AbilityAttribute SPRING_SNIPE = (new AbilityAttribute("Spring Snipe"))
    .setAbilityCooldown(5.0D).setAbilityCharges(20).setAbilityPunch(35.0F);
  
  public static final AbilityAttribute SPRING_HOPPER = (new AbilityAttribute("Spring Hopper"))
    .setAbilityCooldown(0.6D).setAbilityCharges(10);
  
  public static final AbilityAttribute ICE_TIME_CAPSULE = (new AbilityAttribute("Ice Time Capsule")).setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute ICE_SABER = (new AbilityAttribute("Ice Saber"))
    .setAbilityPassive(true);
  
  public static final AbilityAttribute ICE_BALL = (new AbilityAttribute("Ice Ball"))
    .setAbilityCooldown(6.0D).setProjectileDamage(15.0F).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("00FFFF").setProjectileSize(5.0D, 5.0D, 5.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 100, 0), new PotionEffect(Potion.digSlowdown.id, 100, 0) });
  
  public static final AbilityAttribute ICE_AGE = (new AbilityAttribute("Ice Age")).setAbilityCooldown(15.0D).addEffects(EffectType.AOE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 200, 100), new PotionEffect(Potion.digSlowdown.id, 200, 100) }).setEffectRadius(20);
  
  public static final AbilityAttribute ICE_BLOCK_PARTISAN = (new AbilityAttribute("Ice Block : Partisan"))
    .setAbilityCooldown(7.0D).setProjectileDamage(25.0F)
    .setProjectileModel((ModelBase)new ModelTrident()).setProjectileTexture("iceblockpartisan")
    .setProjectileSize(1.5D, 1.5D, 1.5D).setModelOffsets(0.0D, 1.0D, 0.0D)
    .setAbilityRepeater()
    .addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 100, 0), new PotionEffect(Potion.digSlowdown.id, 100, 0) });
  
  public static final AbilityAttribute ICE_BLOCK_PHEASANT = (new AbilityAttribute("Ice Block : Pheasant"))
    .setAbilityCooldown(20.0D)
    .setProjectileDamage(75.0F).setProjectileModel((ModelBase)new ModelPheasant()).setProjectileTexture("iceblockpheasant").setProjectileSize(5.0D, 5.0D, 5.0D).setModelOffsets(0.0D, 2.5D, 0.0D).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 200, 100), new PotionEffect(Potion.digSlowdown.id, 200, 100) }).setProjectileCollisionSizes(1.75D, 1.5D, 1.75D);
  
  public static final AbilityAttribute ENJOMO = (new AbilityAttribute("Enjomo")).setAbilityCooldown(10.0D);
  
  public static final AbilityAttribute JUJIKA = (new AbilityAttribute("Jujika")).setAbilityCooldown(6.0D)
    .setProjectileDamage(20.0F).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("FF0000").setProjectileSize(0.2D, 0.2D, 0.2D);
  
  public static final AbilityAttribute HIDARUMA = (new AbilityAttribute("Hidaruma")).setAbilityCooldown(6.0D)
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.0D, 0.0D, 0.0D).setProjectileDamage(35.0F);
  
  public static final AbilityAttribute DAI_ENKAI_ENTEI = (new AbilityAttribute("Dai Enkai : Entei"))
    .setAbilityCooldown(25.0D)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(65.0F).setProjectileColor("FF0000")
    .setProjectileSize(9.0D, 9.0D, 9.0D).setProjectileExplosion(7).setAbilityCharges(80)
    .setProjectileCollisionSizes(2.0D);
  
  public static final AbilityAttribute HIGAN = (new AbilityAttribute("Higan"))
    .setAbilityCooldown(4.0D).setProjectileModel((ModelBase)new ModelCube()).setProjectileDamage(45.0F).setProjectileColor("FF0000").setProjectileSize(0.3D, 0.3D, 0.3D).setAbilityRepeater(4);
  
  public static final AbilityAttribute HIKEN = (new AbilityAttribute("Hiken")).setAbilityCooldown(8.0D)
    .setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("hiken")
    .setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileDamage(40.0F).setProjectileSize(1.5D, 1.5D, 1.5D).setProjectileExplosion(2);
  
  public static final AbilityAttribute JISHAKUMETAL = (new AbilityAttribute("Jishaku Metal"))
    .setProjectileModel((ModelBase)new ModelArrow()).setProjectileColor((new Color(0, 0, 0, 136)).getRGB())
    .setModelOffsets(0.0D, 0.5D, 0.0D).setAbilityRepeater(2).setProjectileDamage(25.0F)
    .setProjectileSize(1.5D, 1.5D, 1.5D).setAbilityCooldown(6.0D);
  
  public static final AbilityAttribute Repell = (new AbilityAttribute("Jishaku Repell"))
    .setAbilityCooldown(2.0D).setProjectileModel((ModelBase)new ModelCube()).setProjectileSpeed(5.0F)
    .setProjectileSize(0.0D, 0.0D, 0.0D).setProjectileDamage(1.0F);
  
  public static final AbilityAttribute HeavyRepell = (new AbilityAttribute("Jishaku Heavy Repell"))
    .setAbilityCooldown(7.0D).setProjectileModel((ModelBase)new hmodel()).setProjectileTexture("heavyrepel")
    .setProjectileSize(4.0D, 4.0D, 4.0D)
    .setProjectileDamage(100.0F)
    .setAbilityTexture("h");
  
  public static final AbilityAttribute MagnetPUll = (new AbilityAttribute("Jishaku Magnet Pull"))
    .setAbilityCooldown(5.0D).setProjectileModel((ModelBase)new ModelCube()).setProjectileSpeed(5.0F)
    .setProjectileSize(0.0D, 0.0D, 0.0D).setProjectileDamage(5.0F);
  
  public static final AbilityAttribute NUMAGATLING = (new AbilityAttribute("Numa Gatling"))
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor((new Color(110, 59, 28, 242)).hashCode()).setProjectileTicks(10)
    .setProjectileDamage(50.0F).setAbilityCooldown(16.0D).setAbilityRepeater(12);
  
  public static final AbilityAttribute SWAMPLAND = (new AbilityAttribute("Swamp Land"))
    .setProjectileTicks(10).setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute SWAMPSLIDE = (new AbilityAttribute("Swamp Slide"))
    .setAbilityCooldown(5.0D).setAbilityCharges(20);
  
  public static final AbilityAttribute NUMASPRAY = (new AbilityAttribute("Numa Ball"))
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor((new Color(110, 64, 26)).getRGB())
    .addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 600), new PotionEffect(Potion.digSlowdown.id, 600), new PotionEffect(Potion.damageBoost.id, 600) }).setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileDamage(20.0F)
    .setProjectileSize(5.0D, 5.0D, 5.0D).setAbilityCooldown(6.0D);
  
  public static final AbilityAttribute MOCHIBALL = (new AbilityAttribute("Mochi Ball"))
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor(Color.white)
    .setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileDamage(20.0F)
    .setProjectileSize(3.0D, 3.0D, 3.0D).setAbilityCooldown(6.0D);
  
  public static final AbilityAttribute ImpactWave = (new AbilityAttribute("Impact Wave"))
    .setAbilityCooldown(25.0D)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(100.0F)
    .setProjectileColor(Color.yellow.getRGB()).setProjectileSize(9.0D, 9.0D, 9.0D).setProjectileExplosion(7)
    .setAbilityCharges(80).setProjectileCollisionSizes(2.0D);
  
  public static final AbilityAttribute MOCHIBARAGE = (new AbilityAttribute("Mochi Barage"))
    .setAbilityCooldown(20.0D).setAbilityRepeater(5).setProjectileDamage(2.0F)
    .setModelOffsets(0.0D, -1.0D, 0.0D);
  
  public static final AbilityAttribute MOCHIROCKET = (new AbilityAttribute("Mochi Rocket"))
    .setProjectileModel((ModelBase)new ModelFist()).setProjectileTexture("mochinopistol").setProjectileDamage(100.0F)
    .setProjectileSize(6.0D, 6.0D, 6.0D).setModelOffsets(0.0D, 1.0D, 0.0D).setAbilityCooldown(18.0D)
    .setProjectileSpeed(2.5F).setProjectilePhysical();
  
  public static final AbilityAttribute MOCHIGATLING = (new AbilityAttribute("Mochi Gatling"))
    .setProjectileTicks(10);
  
  public static final AbilityAttribute ChikaraMochi = (new AbilityAttribute("Chikara Mochi"))
    .setAbilityCooldown(8.0D)
    .setProjectileModel((ModelBase)new ModelFist())
    .setProjectileTexture("chikara")
    .setProjectileColor(Color.white)
    .setModelOffsets(0.0D, 0.5D, 0.0D)
    .setProjectileDamage(35.0F)
    .setProjectileSize(3.0D, 3.0D, 3.0D)
    .setProjectileExplosion(2).setAbilityRepeater(6, 1);
  
  public static final AbilityAttribute GREAT_CAGE = (new AbilityAttribute("Great Cage")).setAbilityCooldown(20.0D);
  
  public static final AbilityAttribute PRISON_BREAK = (new AbilityAttribute("Prison Break")).setAbilityCooldown(3.0D).setAbilityPassive();
  
  public static final AbilityAttribute AWASE_BAORI = (new AbilityAttribute("Awase Baori")).setAbilityCooldown(12.0D).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("000000").setProjectileSize(7.0D, 7.0D, 7.0D);
  
  public static final AbilityAttribute BIND = (new AbilityAttribute("Bind")).setAbilityCooldown(10.0D).setAbilityPassive().setAbilityPunch();
  
  public static final AbilityAttribute SORU = (new AbilityAttribute("Soru"))
    .addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.moveSpeed.id, 30, 6) }).setAbilityPassive();
  
  public static final AbilityAttribute TEKKAI = (new AbilityAttribute("Tekkai")).setAbilityCooldown(10.0D).addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.resistance.id, 30, 100), new PotionEffect(Potion.moveSlowdown.id, 30, 100), new PotionEffect(Potion.digSlowdown.id, 30, 5), new PotionEffect(Potion.jump.id, 30, -100) }).setAbilityPassive();
  
  public static final AbilityAttribute GEPPO = (new AbilityAttribute("Geppo")).setAbilityCooldown(0.9D);
  
  public static final AbilityAttribute RANKYAKU = (new AbilityAttribute("Rankyaku"))
    .setAbilityCooldown(9.0D).setProjectileTicks(100)
    .setProjectileModel((ModelBase)new ModelCube())
    .setProjectileSize(6.0D, 0.4D, 1.5D)
    .setProjectileColor("69E3FF").setProjectileDamage(20.0F)
    .setProjectileExplosion(2, false)
    .setProjectileCollisionSizes(1.5D, 0.3D, 1.5D).setProjectileMoveThroughBlocks(true);
  
  public static final AbilityAttribute SHIGAN = (new AbilityAttribute("Shigan"))
    .setAbilityCooldown(5.0D).setAbilityPassive().setAbilityPunch();
  
  public static final AbilityAttribute FangSting = (new AbilityAttribute("Fang Sting"))
    .setAbilityCooldown(5.0D).setAbilityPassive().setAbilityPunch()
    .addEffects(EffectType.HIT, new PotionEffect[] { new PotionEffect(Potion.poison.id, 160, 1) });
  
  public static final AbilityAttribute KAMIE = (new AbilityAttribute("Kamie")).setAbilityCooldown(10.0D).addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.resistance.id, 20, 100) }).setAbilityPassive();
  
  public static final AbilityAttribute MechArm = (new AbilityAttribute("Jishaku MechArm"))
    .setAbilityPassive()
    .setAbilityPunch(90.0F)
    .setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute HOT_BOILING_SPECIAL = (new AbilityAttribute("Hot Boiling Special"))
    .setAbilityPassive()
    .setAbilityPunch(10.0F).setAbilityCooldown(7.0D);
  
  public static final AbilityAttribute EVAPORATE = (new AbilityAttribute("Evaporate")).setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute WEIGHTLESS = (new AbilityAttribute("Weightless")).setAbilityPassive(true);
  
  public static final AbilityAttribute KICK_OFF_JUMP = (new AbilityAttribute("Kick Off Jump")).setAbilityPassive().setAbilityCooldown(4.0D);
  
  public static final AbilityAttribute HEAVY_PUNCH = (new AbilityAttribute("Heavy Punch")).setAbilityCooldown(20.0D).setAbilityPassive().setAbilityPunch(20.0F);
  
  public static final AbilityAttribute KILO_PRESS = (new AbilityAttribute("Kilo Press")).setAbilityCooldown(10.0D).setAbilityPassive();
  
  public static final AbilityAttribute RUST_TOUCH = (new AbilityAttribute("Rust Touch")).setAbilityCooldown(19.0D).setAbilityPunch().setAbilityPassive();
  
  public static final AbilityAttribute FAILED_EXPERIMENT = (new AbilityAttribute("Failed Experiment")).setAbilityCooldown(7.0D).setAbilityCharges(40);
  
  public static final AbilityAttribute MEDIC_BAG_EXPLOSION = (new AbilityAttribute("Medic Bag Explosion")).setAbilityCooldown(30.0D);
  
  public static final AbilityAttribute FIRST_AID = (new AbilityAttribute("First Aid")).setAbilityCooldown(10.0D).setAbilityPunch();
  
  public static final AbilityAttribute WEATHER_EGG = (new AbilityAttribute("Weather Egg")).setAbilityCooldown(10.0D).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("#BEBEBE").setProjectileAlpha(150.0F).setProjectileSize(1.5D, 1.5D, 1.5D);
  
  public static final AbilityAttribute GUST_SWORD = (new AbilityAttribute("Gust Sword")).setAbilityCooldown(8.0D).setProjectileTicks(5).setProjectileSize(0.01D, 0.01D, 0.01D).setAbilityRepeater(3).setProjectileDamage(2.0F).setProjectileSpeed(5.0F);
  
  public static final AbilityAttribute THUNDER_BALL = (new AbilityAttribute("Thunder Ball")).setAbilityCooldown(5.0D).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("FFFF00").setProjectileAlpha(150.0F).setProjectileSize(1.5D, 1.5D, 1.5D).setProjectileTicks(300);
  
  public static final AbilityAttribute COOL_BALL = (new AbilityAttribute("Cool Ball")).setAbilityCooldown(5.0D).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("0000FF").setProjectileAlpha(150.0F).setProjectileSize(1.5D, 1.5D, 1.5D).setProjectileTicks(300);
  
  public static final AbilityAttribute HEAT_BALL = (new AbilityAttribute("Heat Ball")).setAbilityCooldown(5.0D).setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor("FF0000").setProjectileAlpha(150.0F).setProjectileSize(1.5D, 1.5D, 1.5D).setProjectileTicks(300);
  
  public static final AbilityAttribute UCHIMIZU = (new AbilityAttribute("Uchimizu")).setAbilityCooldown(5.0D).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("00CED1").setProjectileSize(0.5D, 0.5D, 1.0D).setProjectileDamage(5.0F).setAbilityRepeater(3, 2);
  
  public static final AbilityAttribute MURASAME = (new AbilityAttribute("Murasame")).setAbilityCooldown(8.0D).setProjectileModel((ModelBase)new ModelShark()).setProjectileTexture("murasame").setProjectileSize(0.8D, 0.8D, 1.2D).setProjectileDamage(25.0F);
  
  public static final AbilityAttribute KACHIAGE_HAISOKU = (new AbilityAttribute("Kachiage Haisoku")).setAbilityCooldown(15.0D).setAbilityPassive().setAbilityPunch();
  
  public static final AbilityAttribute SAMEHADA_SHOTEI = (new AbilityAttribute("Samehada Shotei")).setAbilityCooldown(10.0D).addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.resistance.id, 10, 120), new PotionEffect(Potion.moveSlowdown.id, 10, 120), new PotionEffect(Potion.jump.id, 30, -100) }).setAbilityPassive();
  
  public static final AbilityAttribute KARAKUSAGAWARA_SEIKEN = (new AbilityAttribute("Karakusagawara Seiken")).setAbilityCooldown(25.0D);
  
  public static final AbilityAttribute KAEN_BOSHI = (new AbilityAttribute("Kaen Boshi"))
    .setAbilityCooldown(10.0D).setAbilityPassive()
    
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(15.0F).setProjectileSize(0.5D, 0.5D, 0.5D).setProjectileTicks(100).setProjectileColor("#D3D3D3");
  
  public static final AbilityAttribute KEMURI_BOSHI = (new AbilityAttribute("Kemuri Boshi")).setAbilityCooldown(10.0D).setAbilityPassive().setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(6.0F).setProjectileSize(0.5D, 0.5D, 0.5D).setProjectileTicks(100).setProjectileColor("#8741A8");
  
  public static final AbilityAttribute RENPATSU_NAMARI_BOSHI = (new AbilityAttribute("Renpatsu Namari Boshi"))
    .setAbilityCooldown(15.0D).setAbilityPassive()
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(12.0F).setProjectileSize(0.5D, 0.5D, 0.5D).setProjectileTicks(100).setProjectileExplosion(1, false).setProjectileColor("#D3D3D3").setAbilityRepeater(10, 3);
  
  public static final AbilityAttribute SAKURETSU_SABOTEN_BOSHI = (new AbilityAttribute("Sakuretsu Saboten Boshi"))
    .setAbilityCooldown(12.0D).setAbilityPassive()
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(30.0F).setProjectileExplosion(2, false, false).setProjectileSize(0.5D, 0.5D, 0.5D).setProjectileTicks(100).setProjectileColor("#D3D3D3");
  
  public static final AbilityAttribute SHI_SHISHI_SONSON = (new AbilityAttribute("Shi Shishi Sonson")).setAbilityCooldown(7.0D);
  
  public static final AbilityAttribute SANBYAKUROKUJU_POUND_HO = (new AbilityAttribute("Sanbyakurokuju Pound Ho")).setAbilityCooldown(5.0D).setProjectileTicks(100).setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(6.0D, 0.4D, 1.5D).setProjectileColor("bbf7b4").setProjectileDamage(18.0F).setProjectileExplosion(3, false);
  
  public static final AbilityAttribute YAKKODORI = (new AbilityAttribute("Yakkodori"))
    .setAbilityCooldown(3.0D).setAbilityCooldown(5.0D).setProjectileTicks(20)
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.4D, 6.0D, 0.4D).setProjectileColor("bbf7b4")
    .setProjectileDamage(10.0F).setProjectileExplosion(1, false)
    .setProjectileMoveThroughBlocks(true);
  
  public static final AbilityAttribute O_TATSUMAKI = (new AbilityAttribute("O Tatsumaki")).setAbilityCooldown(7.0D);
  
  public static final AbilityAttribute FRESH_FIRE = (new AbilityAttribute("Fresh Fire")).setAbilityCooldown(1.5D)
    .setProjectileTicks(7).setProjectileSize(0.01D, 0.01D, 0.01D).setProjectileDamage(30.0F);
  
  public static final AbilityAttribute COLA_OVERDRIVE = (new AbilityAttribute("Cola Overdrive")).setAbilityCooldown(7.0D).addEffects(EffectType.USER, new PotionEffect[] { new PotionEffect(Potion.moveSpeed.id, 200, 0), new PotionEffect(Potion.damageBoost.id, 200, 1) });
  
  public static final AbilityAttribute RADICAL_BEAM = (new AbilityAttribute("Radical Beam"))
    .setAbilityCooldown(10.0D).setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("FFFF00")
    .setProjectileSize(0.5D, 0.5D, 1.0D).setProjectileDamage(35.0F).setProjectileExplosion(4, false);
  
  public static final AbilityAttribute STRONG_RIGHT = (new AbilityAttribute("Strong Right")).setAbilityCooldown(2.5D)
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileColor("F5DEB3").setProjectileTicks(5)
    .setProjectileSize(1.0D, 1.0D, 1.5D).setProjectileDamage(25.0F);
  
  public static final AbilityAttribute COUP_DE_VENT = (new AbilityAttribute("Coup de Vent")).setAbilityCooldown(10.0D).setProjectileTicks(7).setProjectileSize(0.01D, 0.01D, 0.01D).setProjectileDamage(10.0F).setAbilityCharges(30);
  
  public static final AbilityAttribute KENBUNSHOKU_HAKI_AURA = (new AbilityAttribute("Kenbunshoku Haki: Aura")).setAbilityPassive(true);
  
  public static final AbilityAttribute KENBUNSHOKU_HAKI_FUTURE_SIGHT = (new AbilityAttribute("Kenbunshoku Haki: Future Sight")).setAbilityPassive(true).setAbilityCooldown(60.0D);
  
  public static final AbilityAttribute BUSOSHOKU_HAKI_HARDENING = (new AbilityAttribute("Busoshoku Haki: Hardening")).setAbilityPassive(true);
  
  public static final AbilityAttribute BUSOSHOKU_HAKI_FULL_BODY_HARDENING = (new AbilityAttribute("Busoshoku Haki: Full-Body Hardening")).setAbilityPassive(true);
  
  public static final AbilityAttribute BUSOSHOKU_HAKI_IMBUING = (new AbilityAttribute("Busoshoku Haki: Imbuing")).setAbilityPassive(true);
  
  public static final AbilityAttribute HAOSHOKU_HAKI = (new AbilityAttribute("Haoshoku Haki")).setAbilityCharges(60).setAbilityCooldown(90.0D);
  
  public static final AbilityAttribute BOROBREATH = (new AbilityAttribute("Boro Breath"))
    .setAbilityCooldown(20.0D).setProjectileDamage(500.0F)
    .setProjectileModel((ModelBase)new boro()).setProjectileSize(5.0D, 5.0D, 10.0D)
    .setProjectileTexture("borobreath").setProjectileExplosion(1);
  
  public static final AbilityAttribute kamaitachi = (new AbilityAttribute("Kamai Tachi"))
    .setAbilityCooldown(20.0D).setProjectileDamage(15.0F)
    .setProjectileModel((ModelBase)new Kamaitachi()).setProjectileSize(6.0D, 6.0D, 6.0D)
    .setAbilityRepeater(3).setProjectileTexture("kamaitachi")
    .setProjectileExplosion(1).setAbilityTexture("rankyakuhyobi");
  
  public static final AbilityAttribute DRAGONSCALE = (new AbilityAttribute("Dragon Scale")).setAbilityCooldown(30.0D);
  
  public static final AbilityAttribute FIRE_BREATH = (new AbilityAttribute("Fire Breath"))
    .setAbilityCooldown(20.0D)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(45.0F).setProjectileColor(Color.red)
    
    .setProjectileSize(9.0D, 9.0D, 9.0D).setProjectileExplosion(7)
    .setAbilityCharges(80).setProjectileCollisionSizes(2.0D).setAbilityRepeater(3);
  
  public static final AbilityAttribute DRAGONPOINT = (new AbilityAttribute("Dragon Point"))
    .setAbilityCooldown(1.0D).setAbilityDisplayName("Dragon Point").setAbilityTexture("dragonpoint")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute WHEELDASH = (new AbilityAttribute("Wheel Dash"))
    .setAbilityCooldown(1.0D).setAbilityDisplayName("Wheel Dash").setAbilityTexture("wheelpoint")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute ThunderStorm = (new AbilityAttribute("Thunder Storm"))
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.0D, 0.0D, 0.0D).setAbilityCooldown(40.0D);
  
  public static final AbilityAttribute lightningRage = (new AbilityAttribute("Lightning Rage")).setAbilityTexture("lrage")
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileSize(0.0D, 0.0D, 0.0D).setAbilityCooldown(40.0D);
  
  public static final AbilityAttribute BUDDHAPOINT = (new AbilityAttribute("Buddha Point"))
    .setAbilityCooldown(1.0D).setAbilityDisplayName("Buddha Point").setAbilityTexture("buddha")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute ImpactWaveB = (new AbilityAttribute("Impact Wave Barrage"))
    .setAbilityCooldown(25.0D)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(20.0F)
    .setProjectileColor(Color.yellow.getRGB()).setProjectileSize(9.0D, 9.0D, 9.0D).setProjectileExplosion(7)
    .setAbilityCharges(80).setProjectileCollisionSizes(2.0D).setAbilityRepeater(3, 2);
  
  public static final AbilityAttribute FireSpit = (new AbilityAttribute("Fire Spit"))
    .setAbilityCooldown(25.0D)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileColor(Color.red)
    .setModelOffsets(0.0D, 0.5D, 0.0D)
    .setProjectileSize(3.0D, 3.0D, 3.0D).setAbilityCooldown(6.0D).setAbilityRepeater(5).setProjectileDamage(25.0F)
    .setModelOffsets(0.0D, -1.0D, 0.0D).setAbilityTexture("fspit");
  
  public static final AbilityAttribute ImpactWaveA = (new AbilityAttribute("Impact Wave"))
    .setAbilityCooldown(25.0D)
    .setProjectileModel((ModelBase)new ModelSphere()).setProjectileDamage(100.0F)
    .setProjectileColor(Color.yellow.getRGB()).setProjectileSize(9.0D, 9.0D, 9.0D).setProjectileExplosion(7)
    .setAbilityCharges(80).setProjectileCollisionSizes(2.0D);
  
  public static final AbilityAttribute BuddhaPunch = (new AbilityAttribute("Buddha Punch")).setAbilityCooldown(15.0D)
    .setAbilityPassive().setAbilityPunch(100.0F);
  
  public static final AbilityAttribute SoulSteal = (new AbilityAttribute("Soul Steal")).setAbilityCooldown(15.0D)
    .setAbilityTexture("soulsteal").setAbilityPassive().setAbilityPunch(40.0F).addEffects(EffectType.HIT, new PotionEffect[] { new PotionEffect(Potion.wither.id, 2, 300) });
  
  public static final AbilityAttribute MamouthPoint = (new AbilityAttribute("Mamouth Point"))
    .setAbilityDisplayName("Mamouth Point").setAbilityTexture("mfull")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute AncientRush = (new AbilityAttribute("Ancient Rush"))
    .setAbilityCooldown(20.0D).setAbilityRepeater(5).setProjectileDamage(50.0F).setAbilityTexture("mdart")
    .setModelOffsets(0.0D, -1.0D, 0.0D);
  
  public static final AbilityAttribute AncientBlowDamage = (new AbilityAttribute("Ancient Blow Damage"))
    .setAbilityCooldown(8.0D).setAbilityPunch(40.0F).setAbilityTexture("mivory");
  
  public static final AbilityAttribute AncientStomp = (new AbilityAttribute("Ancient Stomp"))
    .setAbilityTexture("mstomp").setAbilityCooldown(15.0D);
  
  public static final AbilityAttribute AncientTrunkShot = (new AbilityAttribute("Ancient Trunk SHot"))
    .setAbilityTexture("mshot").setAbilityCooldown(7.0D)
    .setProjectileModel((ModelBase)new ModelCube()).setProjectileTexture("zouskin")
    .setProjectileSize(2.5D, 2.5D, 4.0D).setProjectileColor((new Color(110, 44, 0)).getRGB())
    .setProjectileDamage(50.0F)
    .addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.weakness.id, 100) }).setProjectilePhysical();
  
  public static final AbilityAttribute NuePoint = (new AbilityAttribute("Nue Point"))
    .setAbilityDisplayName("Nue Point").setAbilityTexture("npoint")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute Slice = (new AbilityAttribute("Slice"))
    
    .setAbilityCooldown(10.0D).setProjectileDamage(70.0F)
    .addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 0, 100) });
  
  public static final AbilityAttribute NUECLAWSLASH = (new AbilityAttribute("Nue Claw Slash"))
    .setAbilityCooldown(10.0D)
    .setProjectileModel((ModelBase)new nuprojo()).setProjectileTexture("nueclawslash")
    .setProjectileSize(6.0D, 6.0D, 6.0D)
    .setProjectileDamage(150.0F).setProjectileExplosion(2);
  
  public static final AbilityAttribute NuesCurse = (new AbilityAttribute("Nues Curse"))
    .setAbilityCooldown(10.0D);
  
  public static final AbilityAttribute LeopardPoint = (new AbilityAttribute("Leopard Point"))
    .setAbilityDisplayName("Leopard Point").setAbilityTexture("lpoint")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute LeopardHybridPoint = (new AbilityAttribute("Leopard Hybrid Point"))
    .setAbilityDisplayName("Leopard Hybrid Point")
    .setAbilityTexture("hlpoint")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute RankyakuHyobi = (new AbilityAttribute("Rankyaku Hyobi"))
    .setAbilityCooldown(9.0D).setProjectileTicks(100)
    .setProjectileModel((ModelBase)new ModelCube())
    .setProjectileSize(6.0D, 0.4D, 1.5D)
    .setProjectileColor("69E3FF").setProjectileDamage(60.0F)
    .setProjectileExplosion(2, false)
    .setProjectileCollisionSizes(1.5D, 0.3D, 1.5D)
    .setProjectileMoveThroughBlocks(true)
    .setAbilityRepeater(5, 2).setAbilityTexture("rankyakuhyobi");
  
  public static final AbilityAttribute RankyakuHyobiGiraf = (new AbilityAttribute("Rankyaku Hyobi Giraf"))
    .setAbilityCooldown(9.0D).setProjectileTicks(100)
    .setProjectileModel((ModelBase)new ModelCube())
    .setProjectileSize(6.0D, 0.4D, 1.5D)
    .setProjectileColor("69E3FF").setProjectileDamage(20.0F)
    .setProjectileExplosion(2, false)
    .setProjectileCollisionSizes(1.5D, 0.3D, 1.5D)
    .setProjectileMoveThroughBlocks(true)
    .setAbilityRepeater(5, 2).setAbilityTexture("rankyakuhyobi");
  
  public static final AbilityAttribute SaiDaiRinRokuogan = (new AbilityAttribute("Sai Dai Rin: Rokuogan"))
    
    .setAbilityCooldown(5.0D).setAbilityPassive().setAbilityPunch().setAbilityTexture("saidairin");
  
  public static final AbilityAttribute LeopardMawl = (new AbilityAttribute("Leopard Mawl"))
    .setAbilityTexture("leopardmawl").setAbilityCooldown(10.0D).setProjectileDamage(50.0F);
  
  public static final AbilityAttribute LEOPARD_SPRING_HOPPER = (new AbilityAttribute("Leopard Spring Hopper"))
    
    .setAbilityCooldown(2.0D).setAbilityCharges(10).setAbilityTexture("springjump");
  
  public static final AbilityAttribute PteranodonPoint = (new AbilityAttribute("Smilodon Point"))
    .setAbilityDisplayName("Smilodon Point")
    .setAbilityTexture("pfull")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute BeakRush = (new AbilityAttribute("Pounce"))
    
    .setAbilityTexture("beakrush").setAbilityCooldown(10.0D).setProjectileDamage(70.0F)
    .addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 100, 0) });
  
  public static final AbilityAttribute Peck = (new AbilityAttribute("Smilodon Leap"))
    
    .setAbilityTexture("peck").setAbilityCooldown(2.0D).setAbilityCharges(10);
  
  public static final AbilityAttribute WingedTornado = (new AbilityAttribute("Smilodon Chomp"))
    
    .setAbilityCooldown(5.0D).setAbilityPassive().setAbilityPunch(50.0F)
    .setAbilityTexture("chomp").addEffects(EffectType.HIT, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 1, 100) });
  
  public static final AbilityAttribute SmilodonStalk = (new AbilityAttribute("Smilodon Stalk"))
    .setAbilityTexture("smilodonstalk").setAbilityCooldown(30.0D);
  
  public static final AbilityAttribute SmilodonClaw = (new AbilityAttribute("Smilodon Claw Slash"))
    .setAbilityCooldown(8.0D)
    .setProjectileModel((ModelBase)new ModelSphere())
    .setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileDamage(40.0F)
    .setProjectileSize(0.0D, 0.0D, 0.0D).setAbilityTexture("smiladonclaw");
  
  public static final AbilityAttribute SolarLauncher = (new AbilityAttribute("Solar Launcher"))
    .setAbilityCooldown(8.0D)
    .setProjectileModel((ModelBase)new ModelSolar())
    .setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileDamage(250.0F).setAbilityTexture("slaunch")
    .setProjectileSize(5.0D, 5.0D, 5.0D).setProjectileTexture("fireball").setProjectileExplosion(1);
  
  public static final AbilityAttribute LightningEngulfment = (new AbilityAttribute("Lightning Engulfment"))
    .setAbilityCooldown(8.0D)
    .setProjectileModel((ModelBase)new thundercloud()).setAbilityTexture("leng")
    .setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileDamage(250.0F)
    .setProjectileSize(2.0D, 2.0D, 2.0D).setProjectileTexture("thundercloud").setProjectileExplosion(2, false, false);
  
  public static final AbilityAttribute BisuHei = (new AbilityAttribute("Bisu Hei"))
    .setAbilityCooldown(8.0D)
    .setProjectileModel((ModelBase)new soldierpro())
    .setModelOffsets(0.0D, 0.5D, 0.0D).setProjectileDamage(100.0F)
    .setProjectileTexture("soldier1").setAbilityTexture("bhei").setProjectileExplosion(2, false, false);
  
  public static final AbilityAttribute BisuHeiPoint = (new AbilityAttribute("Bisu Hei Point"))
    .setAbilityDisplayName("Bisu Hei Transformation")
    .setAbilityTexture("bpoint")
    .setAbilityPassive(true);
  
  public static final AbilityAttribute BisuShot = (new AbilityAttribute("Bisu Shot"))
    .setAbilityCooldown(8.0D)
    .setProjectileModel((ModelBase)new biskit())
    .setModelOffsets(0.0D, 1.5D, 0.0D).setProjectileDamage(40.0F)
    .setProjectileSize(3.0D, 3.0D, 3.0D).setProjectileTexture("biskit").setAbilityTexture("bshot");
  
  public static final AbilityAttribute BisuShotBarrage = (new AbilityAttribute("Bisu Shot Barrage"))
    .setAbilityCooldown(8.0D)
    .setProjectileModel((ModelBase)new biskit())
    .setModelOffsets(0.0D, 1.5D, 0.0D).setProjectileDamage(40.0F).setAbilityRepeater(5)
    .setProjectileSize(3.0D, 3.0D, 3.0D).setProjectileTexture("biskit")
    .setAbilityTexture("bshotb").setProjectileExplosion(2, false, false);
  
  public static final AbilityAttribute BisuThrust = (new AbilityAttribute("Bisu Thrust"))
    .setAbilityCooldown(10.0D).setProjectileDamage(70.0F)
    .addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 100, 0) }).setAbilityTexture("btust");
  
  public static final AbilityAttribute GodThreat = (new AbilityAttribute("God Threat"))
    .setAbilityCooldown(12.0D).setProjectileDamage(15.0F).setProjectileModel((ModelBase)new godthreat())
    
    .addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 100, 2) }).setProjectileTexture("6holystring").setProjectileSize(7.0D, 7.0D, 7.0D);
  
  public static final AbilityAttribute YakiMochi = (new AbilityAttribute("Yaki Mochi"))
    .setAbilityCooldown(7.0D).setProjectileDamage(70.0F).setProjectileModel((ModelBase)new yaki())
    .setProjectileTexture("yakimochu").setProjectileSize(6.0D, 6.0D, 6.0D).setProjectileExplosion(2);
  
  public static final AbilityAttribute FlapThread = (new AbilityAttribute("Flap Thread"))
    .setAbilityCooldown(7.0D).setProjectileDamage(75.0F).setProjectileModel((ModelBase)new flapThread())
    .setProjectileTexture("flapthread").setProjectileSize(6.0D, 6.0D, 6.0D);
  
  public static final AbilityAttribute BuzzMochi = (new AbilityAttribute("Buzz Mochi"))
    .setAbilityCooldown(7.0D).setProjectileDamage(110.0F).setProjectileModel((ModelBase)new buzzmochi())
    .setProjectileTexture("buzzcutmochi").setAbilityTexture("buzzcut").setProjectileSize(6.0D, 6.0D, 6.0D).setProjectileExplosion(2);
  
  public static final AbilityAttribute Everwhite = (new AbilityAttribute("Ever White"))
    .setAbilityCooldown(10.0D).setProjectileDamage(100.0F).setProjectileModel((ModelBase)new everwhite())
    .setProjectileTexture("everwhite").setAbilityTexture("everwhite").setProjectileSize(6.0D, 6.0D, 6.0D)
    .setProjectileExplosion(2).addEffects(EffectType.PROJECTILE, new PotionEffect[] { new PotionEffect(Potion.moveSlowdown.id, 100, 5) });
  
  public static final AbilityAttribute Inugami = (new AbilityAttribute("Inugami"))
    .setAbilityCooldown(10.0D).setProjectileDamage(110.0F)
    .setProjectileModel((ModelBase)new inugami()).setProjectileTexture("ig")
    .setProjectileSize(4.0D, 4.0D, 4.0D)
    .setAbilityTexture("ig");
}
