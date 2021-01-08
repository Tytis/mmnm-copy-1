package xyz.pixelatedw.MineMineNoMi3.soros;

import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class NumaNumaNoMiProjectiles {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { NumaSprayBall.class, ListAttributes.NUMASPRAY });
    abilitiesClassesArray.add(new Object[] { NumaSprayBall.class, ListAttributes.NUMAGATLING });
  }
  
  public static class NumaSprayBall extends AbilityProjectile {
    public NumaSprayBall(World world) {
      super(world);
    }
    
    public NumaSprayBall(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public NumaSprayBall(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
}
