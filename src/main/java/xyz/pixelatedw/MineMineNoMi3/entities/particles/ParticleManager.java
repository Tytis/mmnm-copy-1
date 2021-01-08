package xyz.pixelatedw.MineMineNoMi3.entities.particles;

import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleNuma;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.baku.ParticleEffectBakuMunch;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.chiyu.ParticleEffectChiyupopo;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.chiyu.ParticleEffectHealingTouch;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.common.ParticleEffectAboveHead;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.common.ParticleEffectCommonExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.common.ParticleEffectWaterExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku.ParticleEffectChloroBall;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku.ParticleEffectChloroBallCloud;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku.ParticleEffectDokuGumo;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku.ParticleEffectVenomDemon;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.fishkarate.ParticleEffectSamehada;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.gomu.ParticleEffectGearSecond;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro.ParticleEffectElThor;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro.ParticleEffectKari;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro.ParticleEffectRaigo;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.gura.ParticleEffectGekishin;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.haki.ParticleEffectHaoshokuHaki;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.hie.ParticleEffectIceAge;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ito.ParticleEffectKumoNoSugaki;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.kachi.ParticleEffectEvaporate;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.kilo.ParticleEffectHeavyPunch;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.kilo.ParticleEffectKiloPress;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.medic.ParticleEffectFirstAid;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.medic.ParticleEffectMedicBagExplosion;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mera.ParticleEffectDaiEnkai;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mera.ParticleEffectDaiEnkai2;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mero.ParticleEffectPerfumeFemur;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mero.ParticleEffectSlaveArrow;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.moku.ParticleEffectWhiteLauncher;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.moku.ParticleEffectWhiteStrike;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika.ParticleEffectAmaterasu;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika.ParticleEffectFlash;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika.ParticleEffectYataNoKagami;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.rokushiki.ParticleEffectGeppo;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.sabi.ParticleEffectRustTouch;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.sniper.ParticleEffectKemuriBoshi;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectDesertEncierro;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectDesertGirasole;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectDesertGirasole2;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectDesertSpada;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectGroundDeath;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna.ParticleEffectSables;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.supa.ParticleEffectAtomicSpurt;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.toriphoenix.ParticleEffectBlueFlames;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.toriphoenix.ParticleEffectTenseiNoSoen;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.toriphoenix.ParticleEffectTenseiNoSoen2;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ushibison.ParticleEffectKokuteiCross;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami.ParticleEffectBlackHole;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami.ParticleEffectBlackWorld;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami.ParticleEffectDarkMatter;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami.ParticleEffectKorouzu;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yomi.ParticleEffectKasuriutaFubukiGiri1;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yomi.ParticleEffectSoulParade;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yuki.ParticleEffectFubuki;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.zou.ParticleEffectGreatStomp;

public class ParticleManager {
  private static ParticleManager instance;
  
  public static ParticleManager getInstance() {
    if (instance == null)
      instance = new ParticleManager(); 
    return instance;
  }
  
  private HashMap<String, ParticleEffect> particleEffects = createMap();
  
  private HashMap<String, ParticleEffect> createMap() {
    HashMap<String, ParticleEffect> map = new HashMap<>();
    map.put("commonExplosion", new ParticleEffectCommonExplosion());
    map.put("waterExplosion", new ParticleEffectWaterExplosion());
    map.put("aboveHeadAngry", new ParticleEffectAboveHead(EnumParticleTypes.VILLAGER_ANGRY.getParticleName()));
    map.put("aboveHeadHappy", new ParticleEffectAboveHead(EnumParticleTypes.VILLAGER_HAPPY.getParticleName()));
    map.put("aboveHeadHeart", new ParticleEffectAboveHead(EnumParticleTypes.HEART.getParticleName()));
    map.put("haoshokuHaki", new ParticleEffectHaoshokuHaki());
    map.put("rustTouch", new ParticleEffectRustTouch());
    map.put("evaporate", new ParticleEffectEvaporate());
    map.put("chiyupopo", new ParticleEffectChiyupopo());
    map.put("healingTouch", new ParticleEffectHealingTouch());
    map.put("slaveArrow", new ParticleEffectSlaveArrow());
    map.put("perfumeFemur", new ParticleEffectPerfumeFemur());
    map.put("firstAid", new ParticleEffectFirstAid());
    map.put("medicBagExplosion", new ParticleEffectMedicBagExplosion());
    map.put("atomicSpurt", new ParticleEffectAtomicSpurt());
    map.put("greatStomp", new ParticleEffectGreatStomp());
    map.put("bakuMunch", new ParticleEffectBakuMunch());
    map.put("daiEnkai1", new ParticleEffectDaiEnkai());
    map.put("daiEnkai2", new ParticleEffectDaiEnkai2());
    map.put("dokuGumo", new ParticleEffectDokuGumo());
    map.put("venomDemon", new ParticleEffectVenomDemon());
    map.put("chloroBall", new ParticleEffectChloroBall());
    map.put("chloroBallCloud", new ParticleEffectChloroBallCloud());
    map.put("fubuki", new ParticleEffectFubuki());
    map.put("whiteLauncher", new ParticleEffectWhiteLauncher());
    map.put("whiteStrike", new ParticleEffectWhiteStrike());
    map.put("samehada", new ParticleEffectSamehada());
    map.put("sables", new ParticleEffectSables());
    map.put("groundDeath", new ParticleEffectGroundDeath());
    map.put("desertGirasole", new ParticleEffectDesertGirasole());
    map.put("desertGirasole2", new ParticleEffectDesertGirasole2());
    map.put("desertEncierro", new ParticleEffectDesertEncierro());
    map.put("desertSpada", new ParticleEffectDesertSpada());
    map.put("kokuteiCross", new ParticleEffectKokuteiCross());
    map.put("gearSecond", new ParticleEffectGearSecond());
    map.put("tenseiNoSoen1", new ParticleEffectTenseiNoSoen());
    map.put("tenseiNoSoen2", new ParticleEffectTenseiNoSoen2());
    map.put("blueFlames", new ParticleEffectBlueFlames());
    map.put("blackHole", new ParticleEffectBlackHole());
    map.put("blackWorld", new ParticleEffectBlackWorld());
    map.put("darkMatter", new ParticleEffectDarkMatter());
    map.put("korouzu", new ParticleEffectKorouzu());
    map.put("yatanNoKagami", new ParticleEffectYataNoKagami());
    map.put("amaterasu", new ParticleEffectAmaterasu());
    map.put("flash", new ParticleEffectFlash());
    map.put("kumoNoSugaki", new ParticleEffectKumoNoSugaki());
    map.put("gekishin", new ParticleEffectGekishin());
    map.put("buddha", new ParticleEffectBudha());
    map.put("soru", new ParticleEffectSoru());
    map.put("elThor", new ParticleEffectElThor());
    map.put("kari", new ParticleEffectKari());
    map.put("raigo", new ParticleEffectRaigo());
    map.put("kemuriBoshi", new ParticleEffectKemuriBoshi());
    map.put("geppo", new ParticleEffectGeppo());
    map.put("iceAge", new ParticleEffectIceAge());
    map.put("kilo", new ParticleEffectHeavyPunch());
    map.put("kiloPress", new ParticleEffectKiloPress());
    map.put("kasuriutaFubukiGiri", new ParticleEffectKasuriutaFubukiGiri1());
    map.put("soulParade", new ParticleEffectSoulParade());
    map.put("particle_numa.png", new ParticleNuma());
    return map;
  }
  
  public boolean spawnFX(EntityPlayer player, double posX, double posY, double posZ, String id) {
    if (Math.abs((Minecraft.getMinecraft()).gameSettings.particleSetting - 2) == 0)
      return false; 
    if (this.particleEffects.containsKey(id)) {
      ((ParticleEffect)this.particleEffects.get(id)).spawn(player, posX, posY, posZ);
      return true;
    } 
    return false;
  }
  
  public HashMap<String, ParticleEffect> getParticleEffectsMap() {
    return this.particleEffects;
  }
}
