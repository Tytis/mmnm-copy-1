package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami;

import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskTornado;

public class ParticleEffectDarkMatter extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    Timer timer = new Timer(true);
    EntityParticleFX particle = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DARKNESS, posX, posY + 1.0D, posZ, 0.0D, 0.0D, 0.0D)).setParticleGravity(-1.25F + player.worldObj.rand.nextFloat()).setParticleScale((player.worldObj.rand.nextInt(3) + 1));
    timer.schedule((TimerTask)ParticleTaskTornado.Create((EntityLivingBase)player, posX, posY, posZ, particle, 8.0D, 2, 0.15D, 0.5D), 0L);
  }
}
