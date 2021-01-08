package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.medic;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectMedicBagExplosion extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    double t = 0.0D;
    Random rand = player.getRNG();
    while (t < 1.0D) {
      t += 1.5707963267948966D;
      double theta;
      for (theta = 0.0D; theta <= 12.566370614359172D; theta += 0.09817477042468103D) {
        double x = t * Math.cos(theta);
        double y = 0.2D + rand.nextInt(1);
        double z = t * Math.sin(theta);
        double motionX = x / 4.0D;
        double motionY = 0.05D + player.worldObj.rand.nextDouble() / 7.0D;
        double motionZ = z / 4.0D;
        EntityParticleFX p1 = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, posX + x * 0.75D, posY + y, posZ + z * 0.75D, motionX, motionY, motionZ)).setParticleScale(2.0F).setParticleAge(4);
        p1.setRBGColorF(0.0F, 0.8F, 0.0F);
        EntityParticleFX p2 = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, posX + x * 2.0D, posY + y, posZ + z * 2.0D, motionX, motionY, motionZ)).setParticleScale(2.5F).setParticleAge(7);
        p2.setRBGColorF(0.0F, 0.8F, 0.0F);
        EntityParticleFX p3 = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_YUKI, posX + x * 3.75D, posY + y, posZ + z * 3.75D, motionX, motionY * 2.25D, motionZ)).setParticleScale(4.5F).setParticleAge(10);
        p3.setRBGColorF(0.0F, 0.8F, 0.0F);
        MainMod.proxy.spawnCustomParticles((Entity)player, p1);
        MainMod.proxy.spawnCustomParticles((Entity)player, p2);
        MainMod.proxy.spawnCustomParticles((Entity)player, p3);
      } 
    } 
  }
}
