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
import net.minecraft.item.ItemStack;

public class PacketBrokenItemParticles implements IMessage {
  private ItemStack itemStack;
  
  public PacketBrokenItemParticles() {}
  
  public PacketBrokenItemParticles(ItemStack itemStack) {
    this.itemStack = itemStack;
  }
  
  public void fromBytes(ByteBuf buf) {
    this.itemStack = ByteBufUtils.readItemStack(buf);
  }
  
  public void toBytes(ByteBuf buf) {
    ByteBufUtils.writeItemStack(buf, this.itemStack);
  }
  
  public static class ClientHandler implements IMessageHandler<PacketBrokenItemParticles, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(PacketBrokenItemParticles message, MessageContext ctx) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
      entityClientPlayerMP.renderBrokenItemStack(message.itemStack);
      return null;
    }
  }
}
