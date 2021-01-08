package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yomi;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectKasuriutaFubukiGiri1 extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    for (int i = 0; i < 2; i++) {
      double offsetX = WyMathHelper.randomWithRange(-1, 1) + player.worldObj.rand.nextDouble();
      double offsetY = WyMathHelper.randomWithRange(-1, 1) + player.worldObj.rand.nextDouble();
      double offsetZ = WyMathHelper.randomWithRange(-1, 1) + player.worldObj.rand.nextDouble();
      MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_HIE, posX + offsetX, posY + 1.0D + offsetY, posZ + offsetZ, 0.0D, 0.0D, 0.0D))
          
          .setParticleScale(1.3F).setParticleGravity(0.0F).setParticleAge(20));
    } 
  }
}
