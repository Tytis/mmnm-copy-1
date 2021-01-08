package xyz.pixelatedw.MineMineNoMi3.quests.poneglyphs;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.HistoryProperties;
import xyz.pixelatedw.MineMineNoMi3.helpers.QuestLogicHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.quests.IInteractQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.ITimedQuest;

public class QuestPoneglyphChallengeCrocodile extends Quest implements IInteractQuest, ITimedQuest {
  public String getQuestID() {
    return "poneglyph_challenge_crocodile";
  }
  
  public String getQuestName() {
    return "Decipher Poneglyph";
  }
  
  public String[] getQuestDescription() {
    return new String[] { "", "", "", "", "", "", "" };
  }
  
  public boolean canStart(EntityPlayer player) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    QuestProperties questProps = QuestProperties.get(player);
    HistoryProperties historyProps = HistoryProperties.get(player);
    boolean flagQuestAvailable = historyProps.hasUnlockedChallenge("crocodile");
    if (!flagQuestAvailable)
      return true; 
    return false;
  }
  
  public void startQuest(EntityPlayer player) {}
  
  public double getMaxProgress() {
    return 1.0D;
  }
  
  public boolean isPrimary() {
    return false;
  }
  
  public boolean isRepeatable() {
    return false;
  }
  
  public boolean isTarget(EntityPlayer player, EntityLivingBase target) {
    boolean flagMob = target instanceof EntityVillager;
    boolean flagLibrarian = (flagMob && ((EntityVillager)target).getProfession() == 1);
    System.out.println(flagMob + "; " + flagLibrarian);
    if (flagMob && flagLibrarian) {
      setProgress(player, getMaxProgress());
      WyNetworkHelper.sendTo((IMessage)new PacketQuestSync(QuestProperties.get(player)), (EntityPlayerMP)player);
      target.playSound("mob.villager.yes", 1.0F, 1.0F);
      isFinished(player);
      return true;
    } 
    return false;
  }
  
  public boolean isFinished(EntityPlayer player) {
    if (!player.worldObj.isRemote) {
      ItemStack itemStack = QuestLogicHelper.getQuestItemStack(player.inventory, getQuestID());
      HistoryProperties historyProps = HistoryProperties.get(player);
      boolean flagQuestComplete = (getProgress() >= getMaxProgress());
      if (flagQuestComplete && itemStack != null && itemStack.hasTagCompound()) {
        String entryName = itemStack.getTagCompound().getString("history_entry");
        historyProps.addUnlockedChallenge(entryName);
        return true;
      } 
    } 
    return false;
  }
  
  public void finishQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".completed", new Object[0]));
    ItemStack itemStack = QuestLogicHelper.getQuestItemStack(player.inventory, getQuestID());
    WyHelper.removeStackFromInventory(player, itemStack);
    super.finishQuest(player);
  }
  
  public void onTimePassEvent(EntityPlayer player) {
    if (!isFinished(player)) {
      ItemStack note = QuestLogicHelper.getQuestItemStack(player.inventory, getQuestID());
      QuestProperties questProps = QuestProperties.get(player);
      if (note == null)
        questProps.removeQuestFromTracker(ListQuests.poneglyphChallengeCrocodile); 
    } 
  }
}
