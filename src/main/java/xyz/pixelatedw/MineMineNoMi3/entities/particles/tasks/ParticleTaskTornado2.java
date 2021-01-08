package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

public class ParticleTaskTornado2 extends TimerTask {
  private EntityLivingBase player;
  
  private Object particle;
  
  private double radius;
  
  private double posX;
  
  private double posY;
  
  private double posZ;
  
  private int density;
  
  public static ParticleTaskTornado2 Create(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density) {
    return new ParticleTaskTornado2(player, posX, posY, posZ, particle, radius, density);
  }
  
  private ParticleTaskTornado2(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density) {
    this.player = player;
    this.particle = particle;
    this.radius = radius;
    this.density = density;
    this.posX = posX;
    this.posY = posY;
    this.posZ = posZ;
  }
  
  public void run() {
    double phi = 0.0D;
    while (phi < this.density * Math.PI) {
      phi += 0.7853981633974483D;
      double t;
      for (t = 0.0D; t <= 6.283185307179586D; t += 0.19634954084936207D) {
        double i;
        for (i = 0.0D; i <= 1.0D; i++) {
          double x = 0.5D * (this.radius * phi + t) * Math.cos(t * phi + i);
          double y = 0.1D * (t * 3.0D + this.radius * Math.PI);
          double z = 0.5D * (this.radius * phi + t) * Math.sin(t * phi + i);
          try {
            if (this.particle instanceof EntityParticleFX) {
              EntityParticleFX clone = ((EntityParticleFX)this.particle).clone(this.posX + x, this.posY + y, this.posZ + z);
              (Minecraft.getMinecraft()).effectRenderer.addEffect((EntityFX)clone);
            } else {
              this.player.worldObj.spawnParticle((String)this.particle, this.posX + x, this.posY - 0.7D + y, this.posZ + z, 0.0D, 0.0D, 0.0D);
            } 
            Thread.sleep(1L);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } 
        } 
      } 
    } 
  }
}
