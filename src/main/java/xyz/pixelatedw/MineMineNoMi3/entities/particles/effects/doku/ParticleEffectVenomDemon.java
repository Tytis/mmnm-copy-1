package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.doku;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectVenomDemon extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    for (int i = 0; i < 3; i++) {
      double offsetX = WyMathHelper.randomWithRange(-2, 1) + player.worldObj.rand.nextDouble();
      double offsetY = WyMathHelper.randomWithRange(-2, 0) + player.worldObj.rand.nextDouble();
      double offsetZ = WyMathHelper.randomWithRange(-2, 1) + player.worldObj.rand.nextDouble();
      EntityParticleFX clone = (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_DOKU, posX + offsetX, posY + 2.5D + offsetY, posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleScale(0.5F).setParticleAge(1 + player.worldObj.rand.nextInt(4));
      clone.setRBGColorF(1.0F, 0.0F, 0.0F);
      MainMod.proxy.spawnCustomParticles((Entity)player, clone);
    } 
  }
}
