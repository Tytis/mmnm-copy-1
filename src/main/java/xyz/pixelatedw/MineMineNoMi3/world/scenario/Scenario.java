package xyz.pixelatedw.MineMineNoMi3.world.scenario;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class Scenario {
  protected String scenarioName;
  
  public int scenarioXPos;
  
  public int scenarioYPos;
  
  public int scenarioZPos;
  
  protected int spawnXPos;
  
  protected int spawnYPos;
  
  protected int spawnZPos;
  
  protected int scenarioXSize;
  
  protected int scenarioYSize;
  
  protected int scenarioZSize;
  
  public abstract void load(EntityPlayer paramEntityPlayer, World paramWorld);
  
  public abstract void unload(EntityPlayer paramEntityPlayer, World paramWorld);
  
  public String getScenarioId() {
    return this.scenarioName + "" + this.scenarioXPos + "" + this.scenarioYPos + "" + this.scenarioZPos;
  }
  
  public int getOriginX() {
    return this.scenarioXPos;
  }
  
  public int getOriginY() {
    return this.scenarioYPos;
  }
  
  public int getOriginZ() {
    return this.scenarioZPos;
  }
}
