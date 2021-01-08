package xyz.pixelatedw.MineMineNoMi3.api.quests;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;

public abstract class Quest {
  protected NBTTagCompound extraData;
  
  protected double questProgress;
  
  public abstract String getQuestID();
  
  public abstract String getQuestName();
  
  public abstract String[] getQuestDescription();
  
  public void startQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, EnumChatFormatting.GREEN + I18n.format("quest." + getQuestID() + ".name", new Object[0]) + " " + I18n.format("gui.quests.started", new Object[0]));
  }
  
  public abstract boolean isPrimary();
  
  public abstract boolean isRepeatable();
  
  public void finishQuest(EntityPlayer player) {
    QuestProperties questProps = QuestProperties.get(player);
    questProps.removeQuestFromTracker(this);
    questProps.addCompletedQuest(this);
    WyNetworkHelper.sendTo((IMessage)new PacketQuestSync(questProps), (EntityPlayerMP)player);
    WyHelper.sendMsgToPlayer(player, EnumChatFormatting.GREEN + I18n.format("quest." + getQuestID() + ".name", new Object[0]) + " " + I18n.format("gui.quests.completed", new Object[0]));
  }
  
  public abstract boolean canStart(EntityPlayer paramEntityPlayer);
  
  public boolean isFinished(EntityPlayer player) {
    if (this.questProgress >= getMaxProgress())
      return true; 
    return false;
  }
  
  public double getProgress() {
    return this.questProgress;
  }
  
  public double getMaxProgress() {
    return 1.0D;
  }
  
  public void setProgress(EntityPlayer player, double progress) {
    if (progress <= getMaxProgress()) {
      this.questProgress = progress;
    } else {
      this.questProgress = getMaxProgress();
    } 
  }
  
  public void alterProgress(EntityPlayer player, double progress) {
    if (this.questProgress + progress <= getMaxProgress()) {
      this.questProgress += progress;
    } else {
      this.questProgress = getMaxProgress();
    } 
  }
}
