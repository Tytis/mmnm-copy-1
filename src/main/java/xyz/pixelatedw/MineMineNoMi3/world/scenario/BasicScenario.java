package xyz.pixelatedw.MineMineNoMi3.world.scenario;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;

public class BasicScenario extends Scenario {
  public void load(EntityPlayer player, World world) {
    WyDebug.info("Load " + player.dimension);
    double dx = this.scenarioXPos;
    double dy = this.scenarioYPos;
    double dz = this.scenarioZPos;
    this.scenarioXSize = 20;
    this.scenarioYSize = 1;
    this.scenarioZSize = 20;
    player.motionX = player.motionY = player.motionZ = 0.0D;
    player.setPositionAndUpdate(dx, dy + 2.0D, dz);
    for (int x = 0; x < this.scenarioXSize; x++) {
      for (int z = 0; z < this.scenarioZSize; z++)
        world.setBlock((int)dx + x, (int)dy, (int)dz + z, Blocks.stone); 
    } 
    WyDebug.info("Build Done In Dimension " + player.dimension);
  }
  
  public void unload(EntityPlayer player, World world) {
    WyDebug.info("Unload");
    double dx = this.scenarioXPos;
    double dy = this.scenarioYPos;
    double dz = this.scenarioZPos;
    for (int x = 0; x < this.scenarioXSize; x++) {
      for (int y = 0; y < this.scenarioYSize; y++) {
        for (int z = 0; z < this.scenarioZSize; z++) {
          if (world.getBlock((int)dx + x, (int)dy + y, (int)dz + z) != Blocks.air)
            world.setBlock((int)dx + x, (int)dy + y, (int)dz + z, Blocks.air); 
        } 
      } 
    } 
    player.motionX = player.motionY = player.motionZ = 0.0D;
    player.setPositionAndUpdate(dx, dy + 2.0D, dz);
  }
}
