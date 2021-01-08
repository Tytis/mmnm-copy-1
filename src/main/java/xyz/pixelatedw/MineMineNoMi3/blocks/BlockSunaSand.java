package xyz.pixelatedw.MineMineNoMi3.blocks;

import java.util.List;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class BlockSunaSand extends BlockFalling {
  public BlockSunaSand() {
    super(Material.sand);
  }
  
  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    if (entity instanceof EntityLivingBase) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entity);
      if (!props.getUsedFruit().equals("sunasuna"))
        entity.setInWeb(); 
    } else {
      entity.setInWeb();
    } 
  }
  
  public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity) {
    if (entity instanceof EntityLivingBase) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entity);
      if (props.getUsedFruit().equals("sunasuna")) {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
      } 
    } else if (entity instanceof net.minecraft.entity.item.EntityFallingBlock) {
      setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
    } 
  }
}
