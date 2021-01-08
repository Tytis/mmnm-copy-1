package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;

public class PacketSpecialFlying implements IMessage {
  public boolean specialFlying;
  
  public PacketSpecialFlying() {}
  
  public PacketSpecialFlying(boolean specialFlying) {
    this.specialFlying = specialFlying;
  }
  
  public void fromBytes(ByteBuf buffer) {
    this.specialFlying = buffer.readBoolean();
  }
  
  public void toBytes(ByteBuf buffer) {
    buffer.writeBoolean(this.specialFlying);
  }
  
  public static class ClientHandler implements IMessageHandler<PacketSpecialFlying, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(PacketSpecialFlying message, MessageContext ctx) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
      ((EntityPlayer)entityClientPlayerMP).capabilities.allowFlying = message.specialFlying;
      if (!message.specialFlying)
        ((EntityPlayer)entityClientPlayerMP).capabilities.isFlying = false; 
      return null;
    }
  }
  
  public static class ServerHandler implements IMessageHandler<PacketSpecialFlying, IMessage> {
    public IMessage onMessage(PacketSpecialFlying message, MessageContext ctx) {
      return null;
    }
  }
}
