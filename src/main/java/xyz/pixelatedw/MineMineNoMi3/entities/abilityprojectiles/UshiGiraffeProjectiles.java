package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class UshiGiraffeProjectiles {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { Bigan.class, ListAttributes.BIGAN });
    abilitiesClassesArray.add(new Object[] { Rankyaku.class, ListAttributes.RankyakuHyobiGiraf });
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
  
  public static class Bigan extends AbilityProjectile {
    public Bigan(World world) {
      super(world);
    }
    
    public Bigan(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Bigan(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
}
