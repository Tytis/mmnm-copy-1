package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.medic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectFirstAid extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    for (int i = 0; i < 64; i++) {
      double motionX = WyMathHelper.randomWithRange(-3, 3) + player.worldObj.rand.nextDouble();
      double motionY = WyMathHelper.randomWithRange(-3, 3) + player.worldObj.rand.nextDouble();
      double motionZ = WyMathHelper.randomWithRange(-3, 3) + player.worldObj.rand.nextDouble();
      double middlePoint = 0.1D;
      middlePoint *= (player.worldObj.rand.nextFloat() * player.worldObj.rand.nextFloat() + 0.3F);
      motionX *= middlePoint / 2.0D;
      motionY *= middlePoint / 2.0D;
      motionZ *= middlePoint / 2.0D;
      EntityParticleFX p1 = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, posX, posY + 1.0D, posZ, motionX, motionY, motionZ)).setParticleScale(1.5F).setParticleAge(10);
      p1.setRBGColorF(0.0F, 0.8F, 0.0F);
      MainMod.proxy.spawnCustomParticles((Entity)player, p1);
    } 
  }
}
