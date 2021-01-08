package xyz.pixelatedw.MineMineNoMi3.soros;

import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class JishakuJishakuNoMiProjectiles {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { MetalPieces.class, ListAttributes.JISHAKUMETAL });
    abilitiesClassesArray.add(new Object[] { PULL.class, ListAttributes.MagnetPUll });
    abilitiesClassesArray.add(new Object[] { REPELL.class, ListAttributes.Repell });
    abilitiesClassesArray.add(new Object[] { HREPELL.class, ListAttributes.HeavyRepell });
  }
  
  public static class MetalPieces extends AbilityProjectile {
    public MetalPieces(World world) {
      super(world);
    }
    
    public MetalPieces(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public MetalPieces(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {}
  }
  
  public static class PULL extends AbilityProjectile {
    public PULL(World world) {
      super(world);
    }
    
    public PULL(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public PULL(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void onUpdate() {
      if (this.worldObj.isRemote)
        for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(5); i++) {
          double offsetX = WyMathHelper.randomDouble();
          double offsetY = WyMathHelper.randomDouble();
          double offsetZ = WyMathHelper.randomDouble();
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_PULL, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(15).setParticleScale(3.0F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        }  
      super.onUpdate();
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      if (hit.entityHit != null && !hit.entityHit.isDead)
        ((EntityLivingBase)hit.entityHit).setPosition((getThrower()).posX, (getThrower()).posY, (getThrower()).posZ); 
    }
  }
  
  public static class REPELL extends AbilityProjectile {
    public REPELL(World world) {
      super(world);
    }
    
    public REPELL(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public REPELL(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      if (hit.entityHit != null && !hit.entityHit.isDead)
        ((EntityLivingBase)hit.entityHit).setPosition(hit.entityHit.posX + 10.0D, hit.entityHit.posY + 5.0D, hit.entityHit.posZ + 10.0D); 
    }
  }
  
  public static class HREPELL extends AbilityProjectile {
    public HREPELL(World world) {
      super(world);
    }
    
    public HREPELL(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public HREPELL(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
}
