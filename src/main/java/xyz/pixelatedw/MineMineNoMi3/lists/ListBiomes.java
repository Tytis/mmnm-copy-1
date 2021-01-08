package xyz.pixelatedw.MineMineNoMi3.lists;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import xyz.pixelatedw.MineMineNoMi3.world.biome.BiomeGenScenarioArena;

public class ListBiomes {
  public static BiomeGenBase biomeScenarioArena;
  
  public static void init() {
    biomeScenarioArena = (new BiomeGenScenarioArena(137)).setBiomeName("Scenario Arena");
    BiomeDictionary.registerBiomeType(biomeScenarioArena, new BiomeDictionary.Type[] { BiomeDictionary.Type.END });
  }
}
