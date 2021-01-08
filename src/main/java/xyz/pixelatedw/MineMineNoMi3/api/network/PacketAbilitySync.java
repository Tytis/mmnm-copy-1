package xyz.pixelatedw.MineMineNoMi3.api.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;

public class PacketAbilitySync implements IMessage {
  public NBTTagCompound data;
  
  public PacketAbilitySync() {}
  
  public PacketAbilitySync(AbilityProperties props) {
    this.data = new NBTTagCompound();
    props.saveNBTData(this.data);
  }
  
  public void fromBytes(ByteBuf buffer) {
    this.data = ByteBufUtils.readTag(buffer);
  }
  
  public void toBytes(ByteBuf buffer) {
    ByteBufUtils.writeTag(buffer, this.data);
  }
  
  public static class ClientHandler implements IMessageHandler<PacketAbilitySync, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(PacketAbilitySync message, MessageContext ctx) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
      AbilityProperties props = AbilityProperties.get((EntityPlayer)entityClientPlayerMP);
      props.loadNBTData(message.data);
      return null;
    }
  }
  
  public static class ServerHandler implements IMessageHandler<PacketAbilitySync, IMessage> {
    public IMessage onMessage(PacketAbilitySync message, MessageContext ctx) {
      EntityPlayerMP entityPlayerMP = (ctx.getServerHandler()).playerEntity;
      AbilityProperties props = AbilityProperties.get((EntityPlayer)entityPlayerMP);
      props.loadNBTData(message.data);
      return null;
    }
  }
}
