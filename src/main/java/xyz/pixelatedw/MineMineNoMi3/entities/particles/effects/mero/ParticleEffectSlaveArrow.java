package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.mero;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectSlaveArrow extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    double motionX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.05D;
    double motionZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.05D;
    double motionY = (-MathHelper.sin(player.rotationPitch / 180.0F * 3.1415927F) * 0.0F);
    EntityParticleFX heartParticle = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_MERO, posX, posY + 1.5D, posZ, motionX, motionY, motionZ)).setParticleScale(10.0F).setParticleGravity(0.0F).setParticleAge(50);
    heartParticle.setAlphaF(0.5F);
    MainMod.proxy.spawnCustomParticles((Entity)player, heartParticle);
  }
}
