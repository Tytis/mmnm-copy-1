package xyz.pixelatedw.MineMineNoMi3.blocks;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketWorld;

public class BlockKage extends Block {
  private int ticks = 500;
  
  public BlockKage() {
    super(Material.iron);
    setTickRandomly(true);
  }
  
  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    if (entity instanceof EntityLivingBase) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entity);
      if (!props.getUsedFruit().equals("kagekage") || !props.hasYamiPower())
        entity.setInWeb(); 
    } else {
      entity.setInWeb();
    } 
  }
  
  public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity) {
    if (entity instanceof EntityLivingBase) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entity);
      if (props.getUsedFruit().equals("kagekage") || props.hasYamiPower()) {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
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
      WyNetworkHelper.sendToServer((IMessage)new PacketWorld(x, y, z, Block.getIdFromBlock(Blocks.air))); 
    if (this.ticks > 0) {
      this.ticks--;
    } else {
      WyNetworkHelper.sendToServer((IMessage)new PacketWorld(x, y, z, Block.getIdFromBlock(Blocks.air)));
      this.ticks = 500 + rand.nextInt(10);
    } 
    world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
  }
}
