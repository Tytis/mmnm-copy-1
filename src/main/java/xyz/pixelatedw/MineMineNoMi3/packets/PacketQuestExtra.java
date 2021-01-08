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
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.quests.ITimedQuest;

public class PacketQuestExtra implements IMessage {
  public int questId;
  
  public PacketQuestExtra() {}
  
  public PacketQuestExtra(int questId) {
    this.questId = questId;
  }
  
  public void fromBytes(ByteBuf buffer) {
    this.questId = buffer.readInt();
  }
  
  public void toBytes(ByteBuf buffer) {
    buffer.writeInt(this.questId);
  }
  
  public static class ClientHandler implements IMessageHandler<PacketQuestExtra, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(PacketQuestExtra message, MessageContext ctx) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
      QuestProperties props = QuestProperties.get((EntityPlayer)entityClientPlayerMP);
      try {
        ((ITimedQuest)props.getQuestIndexFromTracker(message.questId)).onTimePassEvent((EntityPlayer)entityClientPlayerMP);
      } catch (Exception e) {
        System.err.println("Checking different objects to check for nulls \nQuest Props - " + props + "\nQuest - " + props
            
            .getQuestIndexFromTracker(message.questId) + "\nPlayer - " + entityClientPlayerMP
            .getDisplayName() + "\n");
      } 
      return null;
    }
  }
  
  public static class ServerHandler implements IMessageHandler<PacketQuestExtra, IMessage> {
    public IMessage onMessage(PacketQuestExtra message, MessageContext ctx) {
      EntityPlayer player = MainMod.proxy.getPlayerEntity(ctx);
      QuestProperties props = QuestProperties.get(player);
      try {
        ((ITimedQuest)props.getQuestIndexFromTracker(message.questId)).onTimePassEvent(player);
      } catch (Exception e) {
        System.err.println("Checking different objects to check for nulls \nQuest Props - " + props + "\nQuest - " + props
            
            .getQuestIndexFromTracker(message.questId) + "\nPlayer - " + player
            .getDisplayName() + "\n");
      } 
      return null;
    }
  }
}
