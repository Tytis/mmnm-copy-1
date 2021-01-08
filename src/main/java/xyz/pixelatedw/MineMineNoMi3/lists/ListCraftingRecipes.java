package xyz.pixelatedw.MineMineNoMi3.lists;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ListCraftingRecipes {
  public static void init() {
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.SakeCup, 1), new Object[] { "...", "X.X", ".X.", 
          Character.valueOf('X'), Items.clay_ball });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Cannon, 1), new Object[] { "...", "XXX", ".YY", 
          Character.valueOf('X'), Blocks.iron_block, Character.valueOf('Y'), Blocks.planks });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.CannonBall, 1), new Object[] { "...", ".XX", ".XX", 
          Character.valueOf('X'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.CannonBall, 1), new Object[] { ".XX", ".XX", "...", 
          Character.valueOf('X'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.CannonBall, 1), new Object[] { "XX.", "XX.", "...", 
          Character.valueOf('X'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.CannonBall, 1), new Object[] { "...", "XX.", "XX.", 
          Character.valueOf('X'), Items.iron_ingot });
    GameRegistry.addShapelessRecipe(new ItemStack(ListMisc.VivreCard, 1), new Object[] { Items.paper });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.MedicBag, 1), new Object[] { "Y.Y", "XZX", "XXX", 
          Character.valueOf('X'), Items.leather, Character.valueOf('Y'), Items.string, Character.valueOf('Z'), new ItemStack(Items.dye, 1, 4) });
    GameRegistry.addShapedRecipe(new ItemStack((Item)ListMisc.ClimaTact, 1), new Object[] { "YXY", "YXY", "YXY", 
          Character.valueOf('X'), Items.stick, Character.valueOf('Y'), new ItemStack(Items.dye, 1, 4) });
    GameRegistry.addShapedRecipe(new ItemStack((Item)ListMisc.PerfectClimaTact, 1), new Object[] { 
          "EME", "BXI", "EFE", 
          Character.valueOf('X'), ListMisc.ClimaTact, Character.valueOf('E'), ListMisc.DialEisen, Character.valueOf('F'), ListMisc.DialFlash, Character.valueOf('I'), 
          ListMisc.DialFire, Character.valueOf('B'), ListMisc.DialBreath, Character.valueOf('M'), ListMisc.DialMilky });
    GameRegistry.addShapedRecipe(new ItemStack((Item)ListMisc.Mace, 1), new Object[] { ".X.", ".X.", ".Y.", 
          Character.valueOf('X'), Blocks.iron_block, Character.valueOf('Y'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBars, 16), new Object[] { "...", "XXX", "XXX", 
          Character.valueOf('X'), ListMisc.DenseKairoseki });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBars, 16), new Object[] { "XXX", "XXX", "...", 
          Character.valueOf('X'), ListMisc.DenseKairoseki });
    GameRegistry.addShapedRecipe(new ItemStack((Item)ListMisc.Umbrella), new Object[] { "OOO", ".X.", ".X.", 
          Character.valueOf('X'), Items.stick, Character.valueOf('O'), Blocks.wool });
    GameRegistry.addShapedRecipe(new ItemStack((Item)ListMisc.Scissors), new Object[] { ".OO", "XOO", "XX.", 
          Character.valueOf('X'), Blocks.cobblestone, Character.valueOf('O'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.ColaBackpack), new Object[] { "X.X", "XOX", "X.X", 
          Character.valueOf('X'), ListMisc.UltraCola, Character.valueOf('O'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Key), new Object[] { ".X.", ".X.", ".X.", 
          Character.valueOf('X'), Items.gold_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Cola), new Object[] { ".O.", ".O.", ".X.", 
          Character.valueOf('O'), Items.sugar, Character.valueOf('X'), Items.glass_bottle });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.UltraCola), new Object[] { "OOO", "OOO", "OXO", 
          Character.valueOf('O'), Items.sugar, Character.valueOf('X'), ListMisc.Cola });
    GameRegistry.addShapelessRecipe(new ItemStack(ListMisc.Kairoseki, 9), new Object[] { ListMisc.KairosekiBlock });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBlock), new Object[] { "XXX", "XXX", "XXX", 
          Character.valueOf('X'), ListMisc.Kairoseki });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] { "#$.", "$#.", "...", 
          Character.valueOf('#'), ListMisc.Kairoseki, Character.valueOf('$'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] { "$#.", "#$.", "...", 
          Character.valueOf('#'), ListMisc.Kairoseki, Character.valueOf('$'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] { ".$#", ".#$", "...", 
          Character.valueOf('#'), ListMisc.Kairoseki, Character.valueOf('$'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] { ".#$", ".$#", "...", 
          Character.valueOf('#'), ListMisc.Kairoseki, Character.valueOf('$'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] { "...", "$#.", "#$.", 
          Character.valueOf('#'), ListMisc.Kairoseki, Character.valueOf('$'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] { "...", "#$.", "$#.", 
          Character.valueOf('#'), ListMisc.Kairoseki, Character.valueOf('$'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] { "...", ".#$", ".$#", 
          Character.valueOf('#'), ListMisc.Kairoseki, Character.valueOf('$'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.DenseKairoseki), new Object[] { "...", ".$#", ".#$", 
          Character.valueOf('#'), ListMisc.Kairoseki, Character.valueOf('$'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.BlackMetal), new Object[] { "...", "XXX", "XXX", 
          Character.valueOf('X'), ListMisc.DenseKairoseki });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.BlackMetal), new Object[] { "XXX", "XXX", "...", 
          Character.valueOf('X'), ListMisc.DenseKairoseki });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Bullets, 16), new Object[] { "XX.", "XX.", "...", 
          Character.valueOf('X'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Bullets, 16), new Object[] { "...", "XX.", "XX.", 
          Character.valueOf('X'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Bullets, 16), new Object[] { ".XX", ".XX", "...", 
          Character.valueOf('X'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.Bullets, 16), new Object[] { "...", ".XX", ".XX", 
          Character.valueOf('X'), Items.iron_ingot });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBullets, 8), new Object[] { "XX.", "XX.", "...", 
          Character.valueOf('X'), ListMisc.DenseKairoseki });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBullets, 8), new Object[] { "...", "XX.", "XX.", 
          Character.valueOf('X'), ListMisc.DenseKairoseki });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBullets, 8), new Object[] { ".XX", ".XX", "...", 
          Character.valueOf('X'), ListMisc.DenseKairoseki });
    GameRegistry.addShapedRecipe(new ItemStack(ListMisc.KairosekiBullets, 8), new Object[] { "...", ".XX", ".XX", 
          Character.valueOf('X'), ListMisc.DenseKairoseki });
  }
}
