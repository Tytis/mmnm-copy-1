package xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits.BanditData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits.EntityBandit;
import xyz.pixelatedw.MineMineNoMi3.helpers.QuestLogicHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketQuestObjectiveSpawn;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.quests.IInteractQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IKillQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IProgressionQuest;

public class QuestSwordsmanProgression05 extends Quest implements IInteractQuest, IKillQuest, IProgressionQuest {
  private int questPhase = 0;
  
  private String lore1 = "Transport Content :";
  
  private String lore2 = "* 100 TNT Blocks";
  
  private String lore3 = "* 50 Gunpowder";
  
  private String lore4 = "";
  
  private String lore5 = "Delivered to :";
  
  private String lore6 = "X:0 Y:0 Z:0";
  
  private String lore7 = "- Simple Text Name";
  
  public String getQuestID() {
    return "swordsmanprogression05";
  }
  
  public String getQuestName() {
    return "Mysterious Note";
  }
  
  public String[] getQuestDescription() {
    return new String[] { "", "", "", "", "", "", "" };
  }
  
  public void startQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".started", new Object[0]));
    for (int i = 0; i < 6; i++) {
      EntityBandit target = new EntityBandit(player.worldObj);
      double posX = player.posX + WyMathHelper.randomWithRange(-20, 20);
      double posZ = player.posZ + WyMathHelper.randomWithRange(-20, 20);
      target.setLocationAndAngles(posX, player.posY, posZ, 0.0F, 0.0F);
      target.setOwner(player);
      target.setActive(true);
      if (!player.worldObj.isRemote)
        player.worldObj.spawnEntityInWorld((Entity)target); 
    } 
    WyNetworkHelper.sendToAll((IMessage)new PacketQuestObjectiveSpawn(player.getEntityId()));
    this.extraData = new NBTTagCompound();
    this.extraData.setInteger("phase", this.questPhase);
    super.startQuest(player);
  }
  
  public boolean canStart(EntityPlayer player) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    QuestProperties questProps = QuestProperties.get(player);
    boolean flagSwordsman = props.isSwordsman();
    boolean flagPrevQuest = questProps.hasQuestCompleted(ListQuests.swordsmanProgression04);
    if (flagSwordsman && flagPrevQuest)
      return true; 
    return false;
  }
  
  public void finishQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".completed", new Object[0]));
    ItemStack itemStack = QuestLogicHelper.getQuestItemStack(player.inventory, getQuestID());
    WyHelper.removeStackFromInventory(player, itemStack);
    super.finishQuest(player);
  }
  
  public boolean isFinished(EntityPlayer player) {
    this.questPhase = this.extraData.getInteger("phase");
    boolean flagQuestStateKill = (this.questPhase == 0);
    boolean flagNearbyMobs = (WyHelper.getEntitiesNear((Entity)player, 20.0D, new Class[] { BanditData.class }).size() > 0);
    boolean flagQuestComplete = (getProgress() >= getMaxProgress());
    boolean flagQuestStateInteract = (this.questPhase == 1);
    if (flagNearbyMobs) {
      if (!player.worldObj.isRemote)
        WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".dialogue.01", new Object[0])); 
      return false;
    } 
    if (flagQuestStateKill && !flagQuestComplete) {
      if (!player.worldObj.isRemote)
        WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".dialogue.02", new Object[0])); 
      ItemStack mysteriousNote = new ItemStack(ListMisc.Note);
      mysteriousNote.setStackDisplayName("Mysterious Note");
      mysteriousNote.getTagCompound().setString("ForQuest", getQuestID());
      NBTTagCompound questLore = new NBTTagCompound();
      questLore.setString("lore1", WyMathHelper.shuffleArray(this.lore1));
      questLore.setString("lore2", WyMathHelper.shuffleArray(this.lore2));
      questLore.setString("lore3", WyMathHelper.shuffleArray(this.lore3));
      questLore.setString("lore4", this.lore4);
      questLore.setString("lore5", WyMathHelper.shuffleArray(this.lore5));
      questLore.setString("lore6", WyMathHelper.shuffleArray(this.lore6));
      questLore.setString("lore7", WyMathHelper.shuffleArray(this.lore7));
      mysteriousNote.getTagCompound().setTag("QuestLore", (NBTBase)questLore);
      player.inventory.addItemStackToInventory(mysteriousNote);
      this.extraData.setInteger("phase", 1);
    } else if (flagQuestStateInteract && flagQuestComplete) {
      if (!player.worldObj.isRemote) {
        ItemStack itemStack = QuestLogicHelper.getQuestItemStack(player.inventory, getQuestID());
        if (itemStack != null && itemStack.hasTagCompound()) {
          NBTTagCompound questLore = (NBTTagCompound)itemStack.getTagCompound().getTag("QuestLore");
          if (questLore == null)
            return false; 
          itemStack.setStackDisplayName("Deciphered Note");
          questLore.setString("lore1", this.lore1);
          questLore.setString("lore2", this.lore2);
          questLore.setString("lore3", this.lore3);
          questLore.setString("lore4", this.lore4);
          questLore.setString("lore5", this.lore5);
          questLore.setString("lore6", this.lore6);
          questLore.setString("lore7", this.lore7);
          itemStack.getTagCompound().setTag("QuestLore", (NBTBase)questLore);
        } 
      } 
      return true;
    } 
    return false;
  }
  
  public double getMaxProgress() {
    return 6.0D;
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
  
  public boolean isTarget(EntityPlayer player, EntityLivingBase target) {
    this.questPhase = this.extraData.getInteger("phase");
    if (this.questPhase == 0) {
      boolean flagMob = target instanceof BanditData;
      boolean flagCompletion = (getProgress() < getMaxProgress() - 1.0D);
      if (flagMob && flagCompletion)
        return true; 
    } else if (this.questPhase == 1) {
      boolean flagMob = target instanceof EntityVillager;
      boolean flagLibrarian = (flagMob && ((EntityVillager)target).getProfession() == 1);
      boolean flagIncomplete = (getProgress() < getMaxProgress());
      if (flagMob && flagLibrarian && flagIncomplete) {
        setProgress(player, getMaxProgress());
        WyNetworkHelper.sendTo((IMessage)new PacketQuestSync(QuestProperties.get(player)), (EntityPlayerMP)player);
        target.playSound("mob.villager.yes", 1.0F, 1.0F);
        isFinished(player);
        return true;
      } 
    } 
    return false;
  }
}
