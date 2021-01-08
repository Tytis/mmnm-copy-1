package xyz.pixelatedw.MineMineNoMi3.blocks.tileentities;

import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class TileEntityOpe extends TileEntity {
  public void updateEntity() {
    if (!this.worldObj.isRemote) {
      List<EntityLivingBase> nearbyPlayers = (List<EntityLivingBase>)WyHelper.getEntitiesNear(this, 28.0D).stream().filter(x -> (x instanceof net.minecraft.entity.player.EntityPlayer && ExtendedEntityData.get(x).getUsedFruit().equalsIgnoreCase("opeope"))).collect(Collectors.toList());
      if (nearbyPlayers.isEmpty())
        clearRoom(); 
    } 
  }
  
  public void clearRoom() {
    World world = this.worldObj;
    for (int i = -22; i < 22; i++) {
      for (int k = -21; k < 21; k++) {
        for (int j = -22; j < 22; j++) {
          if (world.getBlock(this.xCoord + i, this.yCoord + k, this.zCoord + j) == ListMisc.Ope)
            world.setBlock(this.xCoord + i, this.yCoord + k, this.zCoord + j, Blocks.air); 
        } 
      } 
    } 
    world.setBlock(this.xCoord, this.yCoord, this.zCoord, Blocks.air);
  }
}
