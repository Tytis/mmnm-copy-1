package xyz.pixelatedw.MineMineNoMi3.soros.buddha;

import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class BudhaBudhaProjo {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { ImpactWaveB.class, ListAttributes.ImpactWaveB });
    abilitiesClassesArray.add(new Object[] { ImpactWaveA.class, ListAttributes.ImpactWaveA });
  }
  
  public static class ImpactWave extends AbilityProjectile {
    public ImpactWave(World world) {
      super(world);
    }
    
    public ImpactWave(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public ImpactWave(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class ImpactWaveB extends AbilityProjectile {
    public ImpactWaveB(World world) {
      super(world);
    }
    
    public ImpactWaveB(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public ImpactWaveB(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class ImpactWaveA extends AbilityProjectile {
    public ImpactWaveA(World world) {
      super(world);
    }
    
    public ImpactWaveA(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public ImpactWaveA(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      AbilityExplosion explosion = WyHelper.newExplosion((Entity)this, this.posX, this.posY, this.posZ, 5.0D);
      explosion.setDamageOwner(false);
      explosion.setFireAfterExplosion(false);
      explosion.setDestroyBlocks(false);
      explosion.doExplosion();
      super.tasksImapct(hit);
    }
  }
}
