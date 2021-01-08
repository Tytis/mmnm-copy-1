package xyz.pixelatedw.MineMineNoMi3.entities.particles.tasks;

import java.util.TimerTask;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;

public class ParticleTaskSparks extends TimerTask {
  private EntityLivingBase player;
  
  private double posX;
  
  private double posY;
  
  private double posZ;
  
  private int rangeX;
  
  private int rangeY;
  
  private int rangeZ;
  
  private int density;
  
  public static ParticleTaskSparks Create(EntityLivingBase player, double posX, double posY, double posZ, int rangeX, int rangeY, int rangeZ) {
    return new ParticleTaskSparks(player, posX, posY, posZ, rangeX, rangeY, rangeZ);
  }
  
  private ParticleTaskSparks(EntityLivingBase player, double posX, double posY, double posZ, int rangeX, int rangeY, int rangeZ) {
    this.player = player;
    this.posX = posX;
    this.posY = posY;
    this.posZ = posZ;
    this.rangeX = rangeX;
    this.rangeY = rangeY;
    this.rangeZ = rangeZ;
  }
  
  public void run() {
    for (int i = 0; i < 256; i++) {
      double offsetX = WyMathHelper.randomWithRange(-this.rangeX, this.rangeX);
      double offsetY = WyMathHelper.randomWithRange(-this.rangeY, this.rangeY);
      double offsetZ = WyMathHelper.randomWithRange(-this.rangeZ, this.rangeZ);
      ResourceLocation particleToUse = ID.PARTICLE_ICON_GORO;
      try {
        for (int j = 0; j < 7; j++) {
          if (j % 2 == 0) {
            particleToUse = ID.PARTICLE_ICON_GORO2;
          } else {
            particleToUse = ID.PARTICLE_ICON_GORO;
          } 
          MainMod.proxy.spawnCustomParticles((Entity)this.player, (new EntityParticleFX(this.player.worldObj, particleToUse, this.posX + offsetX + this.player.worldObj.rand
                
                .nextDouble() * 3.0D, this.posY + offsetY + this.player.worldObj.rand
                .nextDouble() * 3.0D, this.posZ + offsetZ + this.player.worldObj.rand
                .nextDouble() * 3.0D, 0.0D, 0.0D, 0.0D))
              
              .setParticleScale(10.0F).setParticleAge((int)(3.0D + 0.2D * j)));
        } 
        Thread.sleep(15L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
    } 
  }
}
