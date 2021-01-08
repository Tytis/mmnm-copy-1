package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

public class ParticleTaskSphere extends TimerTask {
  private EntityLivingBase player;
  
  private Object particle;
  
  private int density;
  
  private int repeats;
  
  private double radius;
  
  private double posX;
  
  private double posY;
  
  private double posZ;
  
  public static ParticleTaskSphere Create(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density, int repeats) {
    return new ParticleTaskSphere(player, posX, posY, posZ, particle, radius, density, repeats);
  }
  
  private ParticleTaskSphere(EntityLivingBase player, double posX, double posY, double posZ, Object particle, double radius, int density, int repeats) {
    this.player = player;
    this.posX = posX;
    this.posY = posY;
    this.posZ = posZ;
    this.particle = particle;
    this.radius = radius;
    this.density = density;
    this.repeats = repeats;
  }
  
  public void run() {
    double phi = 0.0D;
    while (phi < this.repeats * Math.PI) {
      phi += Math.PI / this.density;
      for (double theta = 0.0D; theta <= 6.283185307179586D; theta += Math.PI / this.density) {
        double r = this.radius;
        double x = r * Math.cos(theta) * Math.sin(phi);
        double y = r * Math.cos(phi) + 1.5D;
        double z = r * Math.sin(theta) * Math.sin(phi);
        try {
          if (this.particle instanceof EntityParticleFX) {
            EntityParticleFX clone = ((EntityParticleFX)this.particle).clone(this.posX + x, this.posY + y, this.posZ + z);
            (Minecraft.getMinecraft()).effectRenderer.addEffect((EntityFX)clone);
          } else {
            this.player.worldObj.spawnParticle((String)this.particle, this.posX + x, this.posY + y, this.posZ + z, 0.0D, 0.0D, 0.0D);
          } 
          Thread.sleep(2L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
      } 
    } 
  }
}
