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
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;

public class PacketQuestSync implements IMessage {
  public NBTTagCompound data;
  
  public PacketQuestSync() {}
  
  public PacketQuestSync(QuestProperties props) {
    this.data = new NBTTagCompound();
    props.saveNBTData(this.data);
  }
  
  public void fromBytes(ByteBuf buffer) {
    this.data = ByteBufUtils.readTag(buffer);
  }
  
  public void toBytes(ByteBuf buffer) {
    ByteBufUtils.writeTag(buffer, this.data);
  }
  
  public static class ClientHandler implements IMessageHandler<PacketQuestSync, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(PacketQuestSync message, MessageContext ctx) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
      QuestProperties props = QuestProperties.get((EntityPlayer)entityClientPlayerMP);
      props.loadNBTData(message.data);
      return null;
    }
  }
  
  public static class ServerHandler implements IMessageHandler<PacketQuestSync, IMessage> {
    public IMessage onMessage(PacketQuestSync message, MessageContext ctx) {
      EntityPlayer player = MainMod.proxy.getPlayerEntity(ctx);
      QuestProperties props = QuestProperties.get(player);
      props.loadNBTData(message.data);
      return new PacketQuestSync(props);
    }
  }
}
