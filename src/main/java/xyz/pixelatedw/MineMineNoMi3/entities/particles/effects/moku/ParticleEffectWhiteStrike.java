package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.moku;

import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskWave;

public class ParticleEffectWhiteStrike extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    Timer timer = new Timer(true);
    EntityParticleFX particle = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MOKU, posX, posY - 0.8D, posZ, 0.0D, 0.0D, 0.0D)).setParticleScale(4.0F);
    timer.schedule((TimerTask)ParticleTaskWave.Create((EntityLivingBase)player, particle.posX, particle.posY, particle.posZ, particle, 15.0D), 0L);
  }
}
