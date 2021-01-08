package xyz.pixelatedw.MineMineNoMi3.soros;

import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class RyuRyuNoMiProjectiles {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { FireBall.class, ListAttributes.FIRE_BREATH });
    abilitiesClassesArray.add(new Object[] { BoroBreath.class, ListAttributes.BOROBREATH });
    abilitiesClassesArray.add(new Object[] { ThunderStorm.class, ListAttributes.ThunderStorm });
    abilitiesClassesArray.add(new Object[] { kamaitachi.class, ListAttributes.kamaitachi });
  }
  
  public static class kamaitachi extends AbilityProjectile {
    public kamaitachi(World world) {
      super(world);
    }
    
    public kamaitachi(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public kamaitachi(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class FireBall extends AbilityProjectile {
    public FireBall(World world) {
      super(world);
    }
    
    public FireBall(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public FireBall(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class BoroBreath extends AbilityProjectile {
    public BoroBreath(World world) {
      super(world);
    }
    
    public BoroBreath(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public BoroBreath(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class ThunderStorm extends AbilityProjectile {
    public ThunderStorm(World world) {
      super(world);
    }
    
    public ThunderStorm(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public ThunderStorm(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
}
