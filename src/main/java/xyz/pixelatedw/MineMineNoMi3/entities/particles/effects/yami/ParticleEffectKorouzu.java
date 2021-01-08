package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectKorouzu extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    for (int i = 0; i < 30; i++) {
      double offsetX = WyMathHelper.randomWithRange(-2, 2) + player.worldObj.rand.nextDouble();
      double offsetY = WyMathHelper.randomWithRange(-2, 2) + player.worldObj.rand.nextDouble();
      double offsetZ = WyMathHelper.randomWithRange(-2, 2) + player.worldObj.rand.nextDouble();
      MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DARKNESS, posX + offsetX, posY + offsetY, posZ + offsetZ, 0.0D, 0.0D, 0.0D))
          
          .setParticleScale(3.0F).setParticleGravity(0.0F).setParticleAge(1));
    } 
  }
}
