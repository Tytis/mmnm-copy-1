package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.yami;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectBlackWorld extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    for (int i = 0; i < 4096; i++) {
      double offsetX = ((new Random()).nextInt(40) + 1.0D - 20.0D) / 2.0D;
      double offsetY = ((new Random()).nextInt(40) + 1.0D - 20.0D) / 35.0D;
      double offsetZ = ((new Random()).nextInt(40) + 1.0D - 20.0D) / 2.0D;
      MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DARKNESS, posX + offsetX + (new Random())
            
            .nextInt(5), posY + offsetY, posZ + offsetZ + (new Random())
            
            .nextInt(5), 0.0D, 0.0D, 0.0D))
          
          .setParticleScale(1.2F).setParticleGravity((-1 + player.worldObj.rand.nextInt(2) * -1)).setParticleAge(30 + player.worldObj.rand.nextInt(10)));
      MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DARKNESS, posX + offsetX + (new Random())
            
            .nextInt(5), posY + 1.5D + offsetY, posZ + offsetZ + (new Random())
            
            .nextInt(5), 0.0D, 0.0D, 0.0D))
          
          .setParticleScale(1.2F).setParticleGravity((-1 + player.worldObj.rand.nextInt(2) * -1)).setParticleAge(30 + player.worldObj.rand.nextInt(10)));
      MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DARKNESS, posX + offsetX + (new Random())
            
            .nextInt(5), posY + 2.5D + offsetY, posZ + offsetZ + (new Random())
            
            .nextInt(5), 0.0D, 0.0D, 0.0D))
          
          .setParticleScale(1.2F).setParticleGravity((-1 + player.worldObj.rand.nextInt(2) * -1)).setParticleAge(30 + player.worldObj.rand.nextInt(10)));
    } 
  }
}
