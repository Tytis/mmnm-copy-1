package xyz.pixelatedw.MineMineNoMi3.world.scenario;

import java.util.HashMap;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;

public class ScenarioManager {
  public static HashMap<String, Scenario> scenarios = createDefaultMap();
  
  public static int instanceSpawnX = -20000;
  
  public static int instanceSpawnY = 64;
  
  public static int instanceSpawnZ = -20000;
  
  private static HashMap<String, Scenario> createDefaultMap() {
    HashMap<String, Scenario> scenarioMap = new HashMap<>();
    scenarioMap.put("scenario_cptmorgan", new BasicScenario());
    return scenarioMap;
  }
  
  public static boolean canSpawn(World world, int posX, int posY, int posZ) {
    WyDebug.info("Check coords : X:" + posX + " Y:" + posY + " Z:" + posZ);
    if (world.getBlock(posX, posY, posZ) == Blocks.air)
      return true; 
    return false;
  }
  
  public static int[] getSpawnPos(World world, int posX, int posY, int posZ) {
    WyDebug.info("Get coords : X:" + posX + " Y:" + posY + " Z:" + posZ);
    if (canSpawn(world, posX, posY, posZ))
      return new int[] { posX, posY, posZ }; 
    instanceSpawnX += 2000;
    return getSpawnPos(world, posX + 2000, posY, posZ);
  }
}
