package xyz.pixelatedw.MineMineNoMi3.blocks.tileentities;

import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class TileEntityCustomSpawner extends TileEntity {
  private String entityToSpawn = "Pig";
  
  private int spawnLimit = 5;
  
  private ArrayList<EntityLivingBase> spawnedEntities = new ArrayList<>();
  
  public TileEntityCustomSpawner setSpawnerMob(String toSpawn) {
    this.entityToSpawn = toSpawn;
    return this;
  }
  
  public TileEntityCustomSpawner setSpawnerLimit(int limit) {
    this.spawnLimit = limit;
    return this;
  }
  
  public void updateEntity() {
    if (!this.worldObj.isRemote) {
      boolean flag = false;
      if (!WyHelper.getEntitiesNear(this, 30.0D, EntityPlayer.class).isEmpty()) {
        EntityLivingBase e = WyHelper.getEntitiesNear(this, 30.0D, EntityPlayer.class).get(0);
        if (e != null && e instanceof EntityPlayer) {
          EntityPlayer player = (EntityPlayer)e;
          if (this.spawnedEntities.size() < this.spawnLimit) {
            EntityLivingBase newSpawn = (EntityLivingBase)EntityList.createEntityByName(this.entityToSpawn, this.worldObj);
            if (newSpawn != null) {
              newSpawn.setLocationAndAngles(this.xCoord, this.yCoord, this.zCoord, 0.0F, 0.0F);
              ((EntityLiving)newSpawn).onSpawnWithEgg((IEntityLivingData)null);
              this.worldObj.spawnEntityInWorld((Entity)newSpawn);
              this.spawnedEntities.add(newSpawn);
            } 
          } 
        } 
      } else if (this.spawnedEntities.size() == this.spawnLimit) {
        flag = true;
      } 
      if (flag) {
        for (EntityLivingBase elb : this.spawnedEntities)
          elb.setDead(); 
        this.spawnedEntities.clear();
        flag = false;
      } 
    } 
  }
  
  public void readFromNBT(NBTTagCompound nbtTag) {
    super.readFromNBT(nbtTag);
    this.entityToSpawn = nbtTag.getString("entityToSpawn");
    this.spawnLimit = nbtTag.getInteger("spawnLimit");
  }
  
  public void writeToNBT(NBTTagCompound nbtTag) {
    super.writeToNBT(nbtTag);
    nbtTag.setInteger("spawnLimit", this.spawnLimit);
    nbtTag.setString("entityToSpawn", this.entityToSpawn);
  }
}
