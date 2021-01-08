package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

public class ParticleTaskTornado extends TimerTask {
  private EntityLivingBase player;
  
  private Object particle;
  
  private double radius;
  
  private double opening;
  
  private double posX;
  
  private double posY;
  
  private double posZ;
  
  private double height;
  
  private int density;
  
  private int repeats;
  
  public static ParticleTaskTornado Create(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density, double opening, double height) {
    return new ParticleTaskTornado(player, posX, posY, posZ, particle, radius, density, opening, height);
  }
  
  private ParticleTaskTornado(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density, double opening, double height) {
    this.player = player;
    this.particle = particle;
    this.radius = radius;
    this.density = density;
    this.opening = opening;
    this.height = height;
    this.posX = posX;
    this.posY = posY;
    this.posZ = posZ;
  }
  
  public void run() {
    double phi = 0.0D;
    while (phi < Math.PI * this.density) {
      phi += 0.19634954084936207D;
      double t;
      for (t = 0.0D; t <= 6.283185307179586D; t += 0.19634954084936207D) {
        double i;
        for (i = 0.0D; i <= 1.0D; i++) {
          double x = this.opening * (this.radius * Math.PI + t) * Math.cos(t * phi + i * Math.PI);
          double y = this.height * t;
          double z = this.opening * (this.radius * Math.PI + t) * Math.sin(t * phi - i * Math.PI);
          try {
            if (this.particle instanceof EntityParticleFX) {
              EntityParticleFX clone = ((EntityParticleFX)this.particle).clone(this.posX + x, this.posY + y, this.posZ + z);
              (Minecraft.getMinecraft()).effectRenderer.addEffect((EntityFX)clone);
            } else {
              this.player.worldObj.spawnParticle((String)this.particle, this.posX + x, this.posY + y, this.posZ + z, 0.0D, 0.0D, 0.0D);
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
