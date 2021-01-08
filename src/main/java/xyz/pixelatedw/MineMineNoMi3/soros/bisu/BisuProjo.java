package xyz.pixelatedw.MineMineNoMi3.soros.bisu;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class BisuProjo {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { Trunk.class, ListAttributes.BisuShotBarrage });
    abilitiesClassesArray.add(new Object[] { Fire.class, ListAttributes.BisuShot });
    abilitiesClassesArray.add(new Object[] { Light.class, ListAttributes.BisuHei });
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
  }
  
  public static class Fire extends AbilityProjectile {
    private Random r = new Random();
    
    public Fire(World world) {
      super(world);
    }
    
    public Fire(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Fire(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class Light extends AbilityProjectile {
    private Random r = new Random();
    
    public Light(World world) {
      super(world);
    }
    
    public Light(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Light(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
}
