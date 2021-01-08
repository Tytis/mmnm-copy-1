package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ito;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectKumoNoSugaki extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    double offsetX = 0.0D;
    double offsetZ = 0.0D;
    switch (WyHelper.get4Directions((Entity)player)) {
      case NORTH:
        offsetZ = -1.5D;
        break;
      case SOUTH:
        offsetZ = 1.5D;
        break;
      case EAST:
        offsetX = 1.5D;
        break;
      case WEST:
        offsetX = -1.5D;
        break;
    } 
    MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_ITO, posX + offsetX, posY + 1.0D, posZ + offsetZ, 0.0D, 0.0D, 0.0D))
        
        .setParticleScale(30.0F).setParticleGravity(0.0F).setParticleAge(10));
  }
}
