package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna;

import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskTornado;

public class ParticleEffectDesertGirasole2 extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    Timer timer = new Timer(true);
    EntityParticleFX particle = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_SUNA, posX, posY - 1.0D, posZ, 0.0D, 0.0D, 0.0D)).setParticleScale(4.0F).setParticleGravity(-1.5F);
    timer.schedule((TimerTask)ParticleTaskTornado.Create((EntityLivingBase)player, particle.posX, particle.posY, particle.posZ, particle, 0.3D, 1, 4.0D, 0.8D), 0L);
  }
}
