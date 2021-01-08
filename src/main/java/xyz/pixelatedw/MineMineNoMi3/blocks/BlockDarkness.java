package xyz.pixelatedw.MineMineNoMi3.blocks;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class BlockDarkness extends Block {
  public BlockDarkness() {
    super(Material.iron);
  }
  
  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    if (entity instanceof EntityLivingBase) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entity);
      if (!props.getUsedFruit().equals("yamiyami") || !props.hasYamiPower())
        entity.setInWeb(); 
    } else {
      entity.setInWeb();
    } 
  }
  
  public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity) {
    if (entity instanceof EntityLivingBase) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entity);
      if (props.getUsedFruit().equals("yamiyami") || props.hasYamiPower()) {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
      } 
    } else if (entity instanceof net.minecraft.entity.item.EntityFallingBlock) {
      entity.setDead();
    } 
  }
  
  public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
    world.spawnParticle(EnumParticleTypes.TOWN_AURA.getParticleName(), x + rand.nextDouble(), y, z + rand.nextDouble(), 0.0D, 4.0D, 0.0D);
  }
}
