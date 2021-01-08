package xyz.pixelatedw.MineMineNoMi3.api.quests;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;

public class QuestProperties implements IExtendedEntityProperties {
  public static final String EXT_QUESTPROP_NAME = "mineminenomi_QuestIEEP";
  
  private final EntityPlayer thePlayer;
  
  private boolean hasPrimaryActive = false;
  
  private Quest[] questsList = new Quest[4];
  
  private Quest[] completedQuests = new Quest[2048];
  
  public QuestProperties(EntityPlayer entity) {
    this.thePlayer = entity;
  }
  
  public static final void register(EntityPlayer entity) {
    entity.registerExtendedProperties("mineminenomi_QuestIEEP", new QuestProperties(entity));
  }
  
  public static final QuestProperties get(EntityPlayer entity) {
    return (QuestProperties)entity.getExtendedProperties("mineminenomi_QuestIEEP");
  }
  
  public void saveNBTData(NBTTagCompound compound) {
    NBTTagCompound props = new NBTTagCompound();
    props.setBoolean("hasPrimaryActive", this.hasPrimaryActive);
    int i;
    for (i = 0; i < this.questsList.length; i++) {
      if (this.questsList[i] != null) {
        props.setString("inProgressQuest_" + i, this.questsList[i].getQuestID());
        props.setDouble("progressForQuest_" + i, this.questsList[i].getProgress());
        if ((this.questsList[i]).extraData != null)
          props.setTag("extraData_" + i, (NBTBase)(this.questsList[i]).extraData); 
      } 
    } 
    for (i = 0; i < this.completedQuests.length; i++) {
      if (this.completedQuests[i] != null)
        props.setString("completedQuest_" + i, this.completedQuests[i].getQuestID()); 
    } 
    compound.setTag("mineminenomi_QuestIEEP", (NBTBase)props);
  }
  
  public void loadNBTData(NBTTagCompound compound) {
    NBTTagCompound props = (NBTTagCompound)compound.getTag("mineminenomi_QuestIEEP");
    this.hasPrimaryActive = props.getBoolean("hasPrimaryActive");
    try {
      for (int j = 0; j < this.questsList.length; j++) {
        this.questsList[j] = (!props.getString("inProgressQuest_" + j).isEmpty() || QuestManager.instance().getQuestByNameFromList(ListQuests.allQuests, props.getString("inProgressQuest_" + j)) != null) ? (Quest)QuestManager.instance().getQuestByNameFromList(ListQuests.allQuests, props.getString("inProgressQuest_" + j)).getClass().newInstance() : null;
        if (this.questsList[j] != null) {
          this.questsList[j].setProgress(this.thePlayer, props.getDouble("progressForQuest_" + j));
          (this.questsList[j]).extraData = (NBTTagCompound)props.getTag("extraData_" + j);
        } 
      } 
    } catch (Exception e) {
      Logger.getGlobal().log(Level.SEVERE, "Quest is not registered correctly or could not be found in the master list !");
      e.printStackTrace();
    } 
    for (int i = 0; i < this.completedQuests.length; i++)
      this.completedQuests[i] = (!props.getString("completedQuest_" + i).isEmpty() || QuestManager.instance().getQuestByNameFromList(ListQuests.allQuests, props.getString("completedQuest_" + i)) != null) ? QuestManager.instance().getQuestByNameFromList(ListQuests.allQuests, props.getString("completedQuest_" + i)) : null; 
  }
  
  public void init(Entity entity, World world) {}
  
  public boolean addQuestInTracker(Quest quest) {
    if ((quest.isPrimary() && !this.hasPrimaryActive) || !quest.isPrimary())
      for (int i = 0; i < this.questsList.length; i++) {
        if (this.questsList[i] == null && !hasQuestInTracker(quest)) {
          if (quest.isPrimary())
            this.hasPrimaryActive = true; 
          this.questsList[i] = quest;
          return true;
        } 
      }  
    return false;
  }
  
  public boolean addCompletedQuest(Quest quest) {
    for (int i = 0; i < this.completedQuests.length; i++) {
      if (this.completedQuests[i] == null && !hasQuestCompleted(quest)) {
        this.completedQuests[i] = quest;
        return true;
      } 
    } 
    return false;
  }
  
  public void removeQuestFromTracker(Quest questTemplate) {
    for (int i = 0; i < this.questsList.length; i++) {
      if (this.questsList[i] != null && this.questsList[i].getQuestID().toLowerCase().equals(questTemplate.getQuestID().toLowerCase())) {
        if (questTemplate.isPrimary())
          this.hasPrimaryActive = false; 
        this.questsList[i] = null;
        break;
      } 
    } 
  }
  
  public boolean hasQuestInTracker(Quest questTemplate) {
    for (int i = 0; i < this.questsList.length; i++) {
      if (this.questsList[i] != null && this.questsList[i].getQuestID().toLowerCase().equals(questTemplate.getQuestID().toLowerCase()))
        return true; 
    } 
    return false;
  }
  
  public boolean hasQuestCompleted(Quest questTemplate) {
    for (int i = 0; i < this.completedQuests.length; i++) {
      if (this.completedQuests[i] != null && this.completedQuests[i].getQuestID().toLowerCase().equals(questTemplate.getQuestID().toLowerCase()))
        return true; 
    } 
    return false;
  }
  
  public Quest getQuestFromTracker(Quest questTemplate) {
    for (int i = 0; i < this.questsList.length; i++) {
      if (this.questsList[i] != null && this.questsList[i].getQuestID().toLowerCase().equals(questTemplate.getQuestID().toLowerCase()))
        return this.questsList[i]; 
    } 
    return null;
  }
  
  public Quest getQuestIndexFromTracker(int index) {
    if (this.questsList[index] != null)
      return this.questsList[index]; 
    return null;
  }
  
  public Quest getPrimaryQuestFromTracker() {
    if (this.hasPrimaryActive)
      for (int i = 0; i < this.questsList.length; i++) {
        if (this.questsList[i] != null && this.questsList[i].isPrimary())
          return this.questsList[i]; 
      }  
    return null;
  }
  
  public void alterQuestProgress(Quest questTemplate, double progress) {
    for (int i = 0; i < this.questsList.length; i++) {
      if (this.questsList[i] != null && this.questsList[i].getQuestID().toLowerCase().equals(questTemplate.getQuestID().toLowerCase())) {
        this.questsList[i].alterProgress(this.thePlayer, progress);
        break;
      } 
    } 
  }
  
  public boolean hasPrimary() {
    return this.hasPrimaryActive;
  }
  
  public int questsInProgress() {
    int inProgress = 0;
    for (int i = 0; i < this.questsList.length; i++) {
      if (this.questsList[i] != null)
        inProgress++; 
    } 
    return inProgress;
  }
  
  public void clearQuestTracker() {
    for (int i = 0; i < this.questsList.length; i++) {
      if (this.questsList[i] != null) {
        if (this.questsList[i].isPrimary())
          this.hasPrimaryActive = false; 
        this.questsList[i] = null;
      } 
    } 
  }
  
  public void clearCompletedQuests() {
    for (int i = 0; i < this.completedQuests.length; i++) {
      if (this.completedQuests[i] != null)
        this.completedQuests[i] = null; 
    } 
  }
}
