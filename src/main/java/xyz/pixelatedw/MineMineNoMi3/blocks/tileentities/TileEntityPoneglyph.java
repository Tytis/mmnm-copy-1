package xyz.pixelatedw.MineMineNoMi3.blocks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPoneglyph extends TileEntity {
  private String entryType = "";
  
  private String entryName = "";
  
  public String getEntryType() {
    return this.entryType;
  }
  
  public void setEntryType(String entryType) {
    this.entryType = entryType;
  }
  
  public String getEntryName() {
    return this.entryName;
  }
  
  public void setEntryName(String entryName) {
    this.entryName = entryName;
  }
  
  public void writeToNBT(NBTTagCompound nbt) {
    super.writeToNBT(nbt);
    if (this.entryType == null || this.entryName == null)
      return; 
    nbt.setString("EntryType", this.entryType);
    nbt.setString("EntryName", this.entryName);
  }
  
  public void readFromNBT(NBTTagCompound nbt) {
    super.readFromNBT(nbt);
    this.entryType = nbt.getString("EntryType");
    this.entryName = nbt.getString("EntryName");
  }
  
  public Packet getDescriptionPacket() {
    NBTTagCompound nbttagcompound = new NBTTagCompound();
    writeToNBT(nbttagcompound);
    return (Packet)new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbttagcompound);
  }
  
  public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
    readFromNBT(pkt.func_148857_g());
    this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
  }
}
