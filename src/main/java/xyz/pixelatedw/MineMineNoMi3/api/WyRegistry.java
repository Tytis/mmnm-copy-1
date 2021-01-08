package xyz.pixelatedw.MineMineNoMi3.api;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.HashMap;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import org.apache.commons.lang3.ArrayUtils;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockSakeFeast;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class WyRegistry {
  private static int entityID = 200;
  
  private static int packetID = 0;
  
  protected static HashMap lang = new HashMap<>();
  
  protected static HashMap items = new HashMap<>();
  
  public static HashMap getLangMap() {
    return lang;
  }
  
  public static HashMap getItemsMap() {
    return items;
  }
  
  public static void registerName(String key, String localizedName) {
    if (WyDebug.isDebug())
      getLangMap().put(key, localizedName); 
  }
  
  public static void registerBlock(Block block, String localizedName, float hard, CreativeTabs tab, Class<? extends TileEntity> tile) {
    registerBlock(block, null, localizedName, hard, tab, tile);
  }
  
  public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlock, String localizedName, float hard, CreativeTabs tab, Class<? extends TileEntity> tile) {
    String truename = WyHelper.getFancyName(localizedName);
    block.setBlockName(truename).setBlockTextureName("mineminenomi:" + truename).setHardness(hard).setResistance(hard);
    if (itemBlock == null) {
      GameRegistry.registerBlock(block, truename);
    } else if (block == ListMisc.SakeBottleBlock) {
      BlockSakeFeast blk = (BlockSakeFeast)block;
      GameRegistry.registerBlock((Block)blk, itemBlock, truename);
    } 
    if (tab != null)
      block.setCreativeTab(tab); 
    if (tile != null)
      GameRegistry.registerTileEntity(tile, truename); 
    getItemsMap().put(block, localizedName);
    registerName("tile." + truename + ".name", localizedName);
  }
  
  public static void registerItem(Item item, String localizedName) {
    registerItem(item, localizedName, null);
  }
  
  public static void registerItem(Item item, String localizedName, CreativeTabs tab) {
    String truename = WyHelper.getFancyName(localizedName);
    item.setUnlocalizedName(truename).setTextureName("mineminenomi:" + truename);
    if (tab != null)
      item.setCreativeTab(tab); 
    GameRegistry.registerItem(item, truename);
    getItemsMap().put(item, localizedName);
    registerName("item." + truename + ".name", localizedName);
  }
  
  public static void registerMob(String name, Class<? extends Entity> entity) {
    registerMob(name, entity, -1, -1);
  }
  
  public static void registerMob(String name, Class<? extends Entity> entity, int color1, int color2) {
    EntityRegistry.registerModEntity(entity, name, entityID++, MainMod.getMineMineNoMi(), 128, 3, true);
    if (color1 != -1 && color2 != -1)
      EntityList.addMapping(entity, name, entityID++, color1, color2); 
    registerName("entity." + name + ".name", name);
  }
  
  public static void registerSpawnBiomesFor(Class<? extends EntityLiving> entity, int rarity, int min, int max, BiomeDictionary.Type... biomeTypes) {
    BiomeGenBase[] biomes = new BiomeGenBase[0];
    for (BiomeDictionary.Type t : biomeTypes)
      biomes = (BiomeGenBase[])ArrayUtils.addAll((Object[])biomes, (Object[])BiomeDictionary.getBiomesForType(t)); 
    EntityRegistry.addSpawn(entity, rarity, min, max, EnumCreatureType.creature, biomes);
  }
  
  public static void registerEnchantment(Enchantment enc, String name) {
    String truename = WyHelper.getFancyName(name);
    enc.setName(truename);
    registerName("enchantment." + truename, name);
  }
}
