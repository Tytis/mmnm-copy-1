package xyz.pixelatedw.MineMineNoMi3.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class BlockDenDenMushi extends BlockContainer {
  public BlockDenDenMushi() {
    super(Material.dragonEgg);
    setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 0.625F, 0.85F);
  }
  
  public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack) {
    int rotation = MathHelper.floor_double((entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3;
    world.setBlock(posX, posY, posZ, ListMisc.DenDenMushi, rotation, 2);
  }
  
  public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
    return true;
  }
  
  public boolean isOpaqueCube() {
    return false;
  }
  
  public int getRenderType() {
    return -1;
  }
  
  public boolean renderAsNormalBlock() {
    return false;
  }
  
  public TileEntity createNewTileEntity(World wolrd, int i) {
    return (TileEntity)new TileEntityDenDenMushi();
  }
}
