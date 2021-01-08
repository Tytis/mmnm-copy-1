package xyz.pixelatedw.MineMineNoMi3.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class BlockPoison extends Block {
  protected static final AxisAlignedBB CARPET_AABB = AxisAlignedBB.getBoundingBox(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
  
  private int ticks = 200;
  
  public BlockPoison() {
    super(Material.iron);
    setTickRandomly(true);
    setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
  }
  
  public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
    return CARPET_AABB;
  }
  
  public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
    return CARPET_AABB;
  }
  
  public boolean isOpaqueCube() {
    return false;
  }
  
  @SideOnly(Side.CLIENT)
  public int getRenderBlockPass() {
    return 1;
  }
  
  public boolean renderAsNormalBlock() {
    return false;
  }
  
  public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
    return true;
  }
  
  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    if (entity instanceof EntityLivingBase) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entity);
      if (!props.getUsedFruit().equals("dokudoku")) {
        if (!((EntityLivingBase)entity).isPotionActive(Potion.poison.id))
          ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 300, 1)); 
      } else if (!((EntityLivingBase)entity).isPotionActive(Potion.regeneration.id)) {
        ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 50, 0));
      } 
    } 
  }
  
  public void onBlockAdded(World world, int x, int y, int z) {
    world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
    super.onBlockAdded(world, x, y, z);
  }
  
  public int tickRate(World p_149738_1_) {
    return 1;
  }
  
  public void updateTick(World world, int x, int y, int z, Random rand) {
    if (world.getBlock(x, y - 1, z) == Blocks.air || world.getBlock(x, y - 1, z) instanceof net.minecraft.block.BlockBush)
      world.setBlock(x, y, z, Blocks.air); 
    if (this.ticks > 0) {
      this.ticks--;
    } else {
      world.setBlock(x, y, z, Blocks.air);
      this.ticks = 200 + rand.nextInt(50);
    } 
    world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
  }
}
