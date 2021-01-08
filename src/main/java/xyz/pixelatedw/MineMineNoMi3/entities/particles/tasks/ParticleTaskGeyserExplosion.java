package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import java.util.TimerTask;
import net.minecraft.entity.EntityLivingBase;

public class ParticleTaskGeyserExplosion extends TimerTask {
  private EntityLivingBase player;
  
  private String fxName;
  
  private double posX;
  
  private double posY;
  
  private double posZ;
  
  public ParticleTaskGeyserExplosion(EntityLivingBase player, double posX, double posY, double posZ, String fxName) {
    this.player = player;
    this.fxName = fxName;
    this.posX = posX;
    this.posY = posY;
    this.posZ = posZ;
  }
  
  public void run() {
    double t = 0.0D;
    while (t < 10.0D) {
      t += 0.47123889803846897D;
      double theta;
      for (theta = 0.0D; theta <= 6.283185307179586D; theta += 0.09817477042468103D) {
        double x = t * Math.cos(theta);
        double y = Math.exp(t) * Math.sin(t / 2.0D);
        double z = t * Math.sin(theta);
        try {
          Thread.sleep(1L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
      } 
    } 
  }
}
