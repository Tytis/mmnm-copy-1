package xyz.pixelatedw.MineMineNoMi3.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class BlockSkyblock extends Block {
  public BlockSkyblock() {
    super(Material.ground);
    setLightOpacity(0);
  }
  
  public int quantityDropped(Random random) {
    return 1 + random.nextInt(1);
  }
  
  public int damageDropped(int meta) {
    return meta;
  }
  
  public Item getItemDropped(int metadata, Random rand, int fortune) {
    if (metadata == 1)
      return null; 
    Item[] dials = { ListMisc.DialAxe, ListMisc.DialBreath, ListMisc.DialEisen, ListMisc.DialFire, ListMisc.DialFlash, ListMisc.DialImpact, ListMisc.DialMilky };
    if (rand.nextDouble() < 0.25D)
      return dials[rand.nextInt(dials.length)]; 
    return Item.getItemFromBlock(this);
  }
  
  @SideOnly(Side.CLIENT)
  public void getSubBlocks(Item item, CreativeTabs tab, List list) {
    list.add(new ItemStack(item, 1, 0));
    list.add(new ItemStack(item, 1, 1));
  }
}
