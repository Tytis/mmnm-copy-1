package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class PacketSyncInfo implements IMessage {
  public NBTTagCompound data;
  
  public String user = "";
  
  public int entityId;
  
  public PacketSyncInfo() {}
  
  public PacketSyncInfo(int id, ExtendedEntityData props) {
    this.data = new NBTTagCompound();
    this.entityId = id;
    props.saveNBTData(this.data);
  }
  
  public PacketSyncInfo(String user, ExtendedEntityData props) {
    this.data = new NBTTagCompound();
    this.user = user;
    props.saveNBTData(this.data);
  }
  
  public PacketSyncInfo(ExtendedEntityData props) {
    this.data = new NBTTagCompound();
    props.saveNBTData(this.data);
  }
  
  public void fromBytes(ByteBuf buffer) {
    this.data = ByteBufUtils.readTag(buffer);
    this.user = ByteBufUtils.readUTF8String(buffer);
    this.entityId = buffer.readInt();
  }
  
  public void toBytes(ByteBuf buffer) {
    ByteBufUtils.writeTag(buffer, this.data);
    ByteBufUtils.writeUTF8String(buffer, this.user);
    buffer.writeInt(this.entityId);
  }
  
  public static class ClientHandler implements IMessageHandler<PacketSyncInfo, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(PacketSyncInfo message, MessageContext ctx) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityClientPlayerMP);
      int entityID = message.entityId;
      if (message.user != null && !message.user.isEmpty()) {
        EntityPlayer target = null;
        for (Object o : (Minecraft.getMinecraft()).theWorld.playerEntities) {
          EntityPlayer t = (EntityPlayer)o;
          if (t.getDisplayName().equalsIgnoreCase(message.user)) {
            target = t;
            break;
          } 
        } 
        if (target != null && !target.equals(entityClientPlayerMP)) {
          ExtendedEntityData propz = ExtendedEntityData.get((EntityLivingBase)target);
          propz.loadNBTData(message.data);
        } 
      } else if (entityID != 0) {
        Entity target = null;
        for (Object e : ((EntityPlayer)entityClientPlayerMP).worldObj.loadedEntityList) {
          if (e instanceof EntityLivingBase)
            if (((EntityLivingBase)e).getEntityId() == entityID) {
              target = (Entity)e;
              break;
            }  
        } 
        if (target != null && target instanceof EntityLivingBase && !target.equals(entityClientPlayerMP)) {
          ExtendedEntityData propz = ExtendedEntityData.get((EntityLivingBase)target);
          propz.loadNBTData(message.data);
        } 
      } 
      return null;
    }
  }
}
