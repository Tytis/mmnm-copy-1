package xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.quests.IProgressionQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.ITimedQuest;

public class QuestSwordsmanProgression02 extends Quest implements ITimedQuest, IProgressionQuest {
  public String getQuestID() {
    return "swordsmanprogression02";
  }
  
  public String getQuestName() {
    return "Staying Alive";
  }
  
  public String[] getQuestDescription() {
    return new String[] { " He agreed to train me, the following days will ", "be spent training my strength, stamina and how to ", "focus my power in my blade.", "But first...I need to survive this night.", "", "", "" };
  }
  
  public void startQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".started", new Object[0]));
    this.extraData = new NBTTagCompound();
    this.extraData.setLong("currentDays", (int)player.worldObj.getWorldTime());
    super.startQuest(player);
  }
  
  public void finishQuest(EntityPlayer player) {
    boolean extraDays = ((int)player.worldObj.getWorldTime() >= this.extraData.getLong("currentDays") + 72000L);
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".completed", new Object[0]));
    super.finishQuest(player);
  }
  
  public boolean canStart(EntityPlayer player) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    QuestProperties questProps = QuestProperties.get(player);
    boolean flag1 = (!props.isSwordsman() || !questProps.hasQuestCompleted(ListQuests.swordsmanProgression01));
    if (flag1)
      return false; 
    if (!player.worldObj.isDaytime()) {
      WyHelper.sendMsgToPlayer(player, "<Swordsman Master> There is no point in starting this trial now it's too late, come back in the morning and we'll talk then.");
      return false;
    } 
    return true;
  }
  
  public double getMaxProgress() {
    return 24000.0D;
  }
  
  public boolean isFinished(EntityPlayer player) {
    try {
      if ((int)player.worldObj.getWorldTime() >= this.extraData.getLong("currentDays") + 24000L)
        return true; 
    } catch (Exception e) {
      WyHelper.sendMsgToPlayer(player, "There was a major problem with this quest, please contact the mod owner asap, it has been completed however so enjoy the rest of the storyline !");
      System.err.println("Checking different objects to check for nulls \nExtra Data, Stored as NBT - " + this.extraData + "\nPlayer - " + player
          
          .getDisplayName() + "\nLogic done on - " + (player.worldObj.isRemote ? "Client" : "Server") + "\n");
      e.printStackTrace();
      return true;
    } 
    return false;
  }
  
  public void alterProgress(EntityPlayer player, double progress) {
    super.alterProgress(player, progress);
    if (isFinished(player))
      finishQuest(player); 
  }
  
  public boolean isPrimary() {
    return true;
  }
  
  public EnumQuestlines getQuestLine() {
    return EnumQuestlines.SWORDSMAN_PROGRESSION;
  }
  
  public boolean isRepeatable() {
    return false;
  }
  
  public void onTimePassEvent(EntityPlayer player) {
    if (!isFinished(player))
      setProgress(player, (player.worldObj.getWorldTime() - this.extraData.getLong("currentDays"))); 
  }
}
