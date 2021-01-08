package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.pika;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectAmaterasu extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    double motionX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F) * 1.0F);
    double motionZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F) * 1.0F);
    double motionY = (-MathHelper.sin(player.rotationPitch / 180.0F * 3.1415927F) * 1.0F);
    MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_PIKA, posX, posY, posZ, motionX, motionY + 0.2D, motionZ))
        
        .setParticleScale(50.0F).setParticleGravity(0.0F).setParticleAge(10).setHasZoom());
  }
}
