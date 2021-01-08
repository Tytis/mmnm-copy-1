package xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.suna;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.effects.ParticleEffect;

public class ParticleEffectDesertSpada extends ParticleEffect {
  public void spawn(EntityPlayer player, double posX, double posY, double posZ) {
    Random rand = player.getRNG();
    for (int i = 0; i < 200; i++) {
      double x = 0.0D;
      double z = 0.0D;
      double motionX = 0.0D;
      double motionY = 0.05D + WyMathHelper.randomDouble() / 50.0D;
      double motionZ = 0.0D;
      if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.NORTH) {
        x = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
        z = -i * 0.2D;
      } else if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.EAST) {
        x = i * 0.2D;
        z = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
      } else if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.SOUTH) {
        x = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
        z = i * 0.2D;
      } else if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.WEST) {
        x = -i * 0.2D;
        z = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
      } 
      MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, ID.PARTICLE_ICON_SUNA, posX + x, posY + 0.1D, posZ + z, motionX, motionY, motionZ))
          
          .setParticleScale(5.0F).setParticleAge(10));
    } 
  }
}
