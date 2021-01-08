package xyz.pixelatedw.MineMineNoMi3.soros.ptero;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class PteranodonProjo {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { Rankyaku.class, ListAttributes.RankyakuHyobi });
    abilitiesClassesArray.add(new Object[] { Trunk.class, ListAttributes.SmilodonClaw });
  }
  
  public static class Rankyaku extends AbilityProjectile {
    public Rankyaku(World world) {
      super(world);
    }
    
    public Rankyaku(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Rankyaku(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class Trunk extends AbilityProjectile {
    private Random r = new Random();
    
    public Trunk(World world) {
      super(world);
    }
    
    public Trunk(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Trunk(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void onUpdate() {
      if (this.worldObj.isRemote) {
        int i;
        for (i = 0; i < DevilFruitsHelper.getParticleSettingModifier(25); i++) {
          double offsetX = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetY = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetZ = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_SMILODON, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(10).setParticleScale(1.3F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        } 
        for (i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++) {
          double offsetX = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetY = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetZ = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_SMILODON, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(7).setParticleScale(1.2F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        } 
      } 
      super.onUpdate();
    }
  }
}
