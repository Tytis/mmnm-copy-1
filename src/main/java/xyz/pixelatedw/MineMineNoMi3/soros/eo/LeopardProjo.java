package xyz.pixelatedw.MineMineNoMi3.soros.eo;

import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class LeopardProjo {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { Rankyaku.class, ListAttributes.RankyakuHyobi });
    abilitiesClassesArray.add(new Object[] { Trunk.class, ListAttributes.LeopardMawl });
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
    public Trunk(World world) {
      super(world);
    }
    
    public Trunk(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Trunk(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
}
