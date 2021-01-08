package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectFlash extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_PIKA, posX, posY + 3.5D, posZ, 0.0D, 0.0D, 0.0D))
        
        .setParticleScale(50.0F).setParticleGravity(0.0F).setParticleAge(10).setHasZoom());
  }
}
