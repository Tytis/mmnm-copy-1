package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.toriphoenix;

import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskTornado;

public class ParticleEffectTenseiNoSoen extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    Timer timer = new Timer(true);
    EntityParticleFX particle = new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_BLUEFLAME, posX, posY + 4.0D, posZ, 0.0D, 0.0D, 0.0D);
    timer.schedule((TimerTask)ParticleTaskTornado.Create((EntityLivingBase)player, particle.posX, particle.posY, particle.posZ, particle, 4.0D, 1, 0.15D, -1.7D), 0L);
  }
}
