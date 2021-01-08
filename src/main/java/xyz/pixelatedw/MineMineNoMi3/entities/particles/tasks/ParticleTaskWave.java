package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import java.util.Random;
import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

public class ParticleTaskWave extends TimerTask {
  private EntityLivingBase player;
  
  private Object particle;
  
  private double posX;
  
  private double posY;
  
  private double posZ;
  
  private double radius;
  
  public static ParticleTaskWave Create(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius) {
    return new ParticleTaskWave(player, posX, posY, posZ, particle, radius);
  }
  
  private ParticleTaskWave(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius) {
    this.player = player;
    this.particle = particle;
    this.posX = posX;
    this.posY = posY;
    this.posZ = posZ;
    this.radius = radius;
  }
  
  public void run() {
    double t = 0.0D;
    Random rand = this.player.getRNG();
    while (t < this.radius) {
      t += 1.5707963267948966D;
      double theta;
      for (theta = 0.0D; theta <= 12.566370614359172D; theta += 0.19634954084936207D) {
        double x = t * Math.cos(theta);
        double y = rand.nextInt(1);
        double z = t * Math.sin(theta);
        try {
          if (this.particle instanceof EntityParticleFX) {
            EntityParticleFX clone = ((EntityParticleFX)this.particle).clone(this.posX + WyMathHelper.randomWithRange(-3, 3) + x, this.posY + 1.0D + y, this.posZ + WyMathHelper.randomWithRange(-3, 3) + z);
            (Minecraft.getMinecraft()).effectRenderer.addEffect((EntityFX)clone);
          } else {
            this.player.worldObj.spawnParticle((String)this.particle, this.posX + WyMathHelper.randomWithRange(-3, 3) + x, this.posY + y, this.posZ + WyMathHelper.randomWithRange(-3, 3) + z, 0.0D, 0.0D, 0.0D);
          } 
          Thread.sleep(1L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
      } 
    } 
  }
}
