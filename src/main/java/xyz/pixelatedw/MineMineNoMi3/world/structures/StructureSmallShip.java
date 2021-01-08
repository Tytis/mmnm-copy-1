package xyz.pixelatedw.MineMineNoMi3.world.structures;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.items.weapons.ItemCoreWeapon;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.world.MainWorldGen;

public class StructureSmallShip extends Structure {
  public static boolean build(Schematic sch, World world, int posX, int posY, int posZ, BiomeGenBase biome) {
    boolean flagBiome = (biome != BiomeGenBase.ocean && biome != BiomeGenBase.deepOcean);
    boolean flagSpecialCheck = !MainWorldGen.checkForWaterSpawn(sch, world, posX, posY, posZ);
    if (flagBiome || flagSpecialCheck)
      return false; 
    WySchematicHelper.build(sch, world, posX, posY, posZ);
    populate(posX, posY, posZ, world, sch.getName());
    return true;
  }
  
  private static void populate(int posX, int posY, int posZ, World world, String faction) {
    String trashWithSword, trashWithGun;
    ItemCoreWeapon itemCoreWeapon;
    if (faction.equals("marineShip")) {
      trashWithSword = "mineminenomi.Marine with Sword";
      trashWithGun = "mineminenomi.Marine with Gun";
      itemCoreWeapon = ListMisc.MarineSword;
    } else {
      trashWithSword = "mineminenomi.Pirate with Sword";
      trashWithGun = "mineminenomi.Pirate with Gun";
      itemCoreWeapon = ListMisc.PirateCutlass;
    } 
    TileEntityCustomSpawner spawnTrash01 = (new TileEntityCustomSpawner()).setSpawnerMob(trashWithGun).setSpawnerLimit(5);
    TileEntityCustomSpawner spawnTrash02 = (new TileEntityCustomSpawner()).setSpawnerMob(trashWithSword).setSpawnerLimit(5);
    TileEntityCustomSpawner spawnTrash03 = (new TileEntityCustomSpawner()).setSpawnerMob(trashWithSword).setSpawnerLimit(2);
    world.setBlock(posX + 10, posY + 2, posZ + 32, (Block)ListMisc.CustomSpawner);
    world.setTileEntity(posX + 10, posY + 2, posZ + 32, (TileEntity)spawnTrash01);
    world.setBlock(posX + 10, posY + 2, posZ + 43, (Block)ListMisc.CustomSpawner);
    world.setTileEntity(posX + 10, posY + 2, posZ + 43, (TileEntity)spawnTrash02);
    world.setBlock(posX + 10, posY + 7, posZ + 45, (Block)ListMisc.CustomSpawner);
    world.setTileEntity(posX + 10, posY + 7, posZ + 45, (TileEntity)spawnTrash03);
    world.setBlock(posX + 12, posY + 2, posZ + 32, Blocks.torch);
    world.setBlock(posX + 12, posY + 2, posZ + 38, Blocks.torch);
    world.setBlock(posX + 12, posY + 2, posZ + 43, Blocks.torch);
    TileEntityChest combatChest = new TileEntityChest();
    world.setTileEntity(posX + 11, posY + 2, posZ + 25, (TileEntity)combatChest);
    addChestLoot(world, combatChest, 100.0D, ListMisc.Bullets, 5, 10);
    addChestLoot(world, combatChest, 100.0D, ListMisc.Bullets, 3, 8);
    addChestLoot(world, combatChest, 65.0D, ListMisc.Flintlock, 0, 1);
    addChestLoot(world, combatChest, 65.0D, ListMisc.BellyPouch, 2, 5);
    addChestLoot(world, combatChest, 50.0D, ListMisc.KairosekiBullets, 2, 5);
    addChestLoot(world, combatChest, 50.0D, Items.boat, 1, 0);
    addChestLoot(world, combatChest, 45.0D, (Item)itemCoreWeapon, 0, 1);
    addChestLoot(world, combatChest, 35.0D, ListMisc.BellyPouch, 3, 6);
    addChestLoot(world, combatChest, 15.0D, ListMisc.Box1, 1, 0);
    addChestLoot(world, combatChest, 5.0D, ListMisc.Box2, 1, 0);
    TileEntityChest foodChest = new TileEntityChest();
    world.setTileEntity(posX + 8, posY + 2, posZ + 25, (TileEntity)foodChest);
    addChestLoot(world, foodChest, 100.0D, Items.bread, 4, 6);
    addChestLoot(world, foodChest, 100.0D, Items.bread, 2, 3);
    addChestLoot(world, foodChest, 100.0D, Items.potato, 1, 5);
    addChestLoot(world, foodChest, 85.0D, Items.apple, 1, 4);
    addChestLoot(world, foodChest, 45.0D, Items.baked_potato, 1, 5);
    if (getRandomChance(world) <= 70.0D)
      addChestLoot(world, foodChest, 45.0D, Items.bread, 1, 3); 
    addChestLoot(world, foodChest, 20.0D, ListMisc.Cola, 1, 3);
    if (getRandomChance(world) <= 50.0D) {
      addChestLoot(world, foodChest, 60.0D, Items.cooked_chicken, 3, 4);
    } else {
      addChestLoot(world, foodChest, 10.0D, Items.cooked_beef, 5, 6);
    } 
    addChestLoot(world, foodChest, 10.0D, ListMisc.Cola, 1, 5);
    world.setBlock(posX + 11, posY + 2, posZ + 24, Blocks.air);
    world.setBlock(posX + 8, posY + 2, posZ + 24, Blocks.air);
    world.setBlock(posX + 11, posY + 2, posZ + 22, Blocks.air);
    world.setBlock(posX + 8, posY + 2, posZ + 22, Blocks.air);
    world.setBlock(posX + 11, posY + 2, posZ + 21, Blocks.air);
    world.setBlock(posX + 8, posY + 2, posZ + 21, Blocks.air);
  }
}
