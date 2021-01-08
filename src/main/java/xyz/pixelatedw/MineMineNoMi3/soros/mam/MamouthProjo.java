package xyz.pixelatedw.MineMineNoMi3.soros.mam;

import java.util.ArrayList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class MamouthProjo {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { Trunk.class, ListAttributes.AncientTrunkShot });
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
