package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.goro;

import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks.ParticleTaskSparks;

public class ParticleEffectKari extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    Timer timer = new Timer(true);
    timer.schedule((TimerTask)ParticleTaskSparks.Create((EntityLivingBase)player, player.posX, player.posY, player.posZ, 25, 5, 25), 0L);
  }
}
