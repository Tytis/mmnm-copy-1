package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.haki;

import java.util.Random;
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
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskTornado2;

public class ParticleEffectHaoshokuHaki extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    Timer timer = new Timer(true);
    EntityParticleFX particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MOKU, posX * 1.25D, posY + 0.5D, posZ * 1.25D, 0.0D, 0.0D, 0.0D);
    particle.setRBGColorF(0.7F, 0.0F, 0.7F);
    particle.setParticleScale(0.8F);
    particle.setParticleAge(-3);
    timer.schedule((TimerTask)ParticleTaskTornado2.Create((EntityLivingBase)player, posX, posY, posZ, particle, 3.2D, 2), 0L);
    double t = 0.0D;
    Random rand = player.getRNG();
    for (int i = 0; i < 25; i++) {
      while (t < 1.0D) {
        t += 0.031415926535897934D;
        double theta;
        for (theta = 0.0D; theta <= 12.566370614359172D; theta += 0.09817477042468103D) {
          double x = t * Math.cos(theta);
          double z = t * Math.sin(theta);
          double motionX = x / 8.0D + WyMathHelper.randomDouble();
          double motionZ = z / 8.0D + WyMathHelper.randomDouble();
          particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MOKU, posX + x * 1.25D, posY + 0.5D, posZ + z * 1.25D, motionX, 0.0D, motionZ);
          particle.setRBGColorF(0.7F, 0.0F, 0.7F);
          particle.setParticleScale(0.8F);
          particle.setParticleAge(2);
          MainMod.proxy.spawnCustomParticles((Entity)player, particle);
          double motionY = x / 12.0D + WyMathHelper.randomDouble();
          particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, posX + x * 1.25D, posY + 1.5D, posZ + z * 1.25D, motionX * 1.5D, motionY * 1.5D, motionZ * 1.5D);
          particle.setRBGColorF(0.7F, 0.0F, 0.7F);
          particle.setParticleScale(1.2F);
          particle.setParticleAge(5);
          MainMod.proxy.spawnCustomParticles((Entity)player, particle);
        } 
      } 
    } 
  }
}
