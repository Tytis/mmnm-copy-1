package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro;

import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskSparks;

public class ParticleEffectRaigo extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    for (int i = 0; i < 512; i++) {
      double offsetX = WyMathHelper.randomWithRange(-55, 55);
      double offsetY = WyMathHelper.randomWithRange(-5, 5);
      double offsetZ = WyMathHelper.randomWithRange(-55, 55);
      EntityParticleFX particle = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_GORO3, posX + offsetX + player.worldObj.rand.nextDouble() * 5.0D, posY + 40.0D + offsetY + player.worldObj.rand.nextDouble() * 5.0D, posZ + offsetZ + player.worldObj.rand.nextDouble() * 5.0D, 0.0D, 0.0D, 0.0D)).setParticleScale(100.0F).setParticleAge(100);
      if (i % 2 == 0) {
        particle.setRBGColorF(0.4F, 0.4F, 0.4F);
      } else {
        particle.setRBGColorF(0.3F, 0.3F, 0.3F);
      } 
      MainMod.proxy.spawnCustomParticles((Entity)player, particle);
    } 
    Timer timer = new Timer(true);
    timer.schedule((TimerTask)ParticleTaskSparks.Create((EntityLivingBase)player, posX, posY + 30.0D, posZ, 55, 5, 55), 0L);
  }
}
