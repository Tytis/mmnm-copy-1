package xyz.pixelatedw.MineMineNoMi3.quests.questlines.sniperprogression;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.quests.IKillQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IProgressionQuest;

public class QuestSniperProgression02 extends Quest implements IProgressionQuest, IKillQuest {
  public String getQuestID() {
    return "sniperprogression02";
  }
  
  public String getQuestName() {
    return "Emerging Power";
  }
  
  public String[] getQuestDescription() {
    return new String[] { " Test Description1", "Test Description2", "Test Description3", "", "", "", "" };
  }
  
  public void startQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".started", new Object[0]));
    super.startQuest(player);
  }
  
  public void finishQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".completed", new Object[0]));
    super.finishQuest(player);
  }
  
  public boolean canStart(EntityPlayer player) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    QuestProperties questProps = QuestProperties.get(player);
    boolean flagSniper = props.isSniper();
    boolean flagPrevQuest = questProps.hasQuestCompleted(ListQuests.sniperProgression01);
    if (flagSniper && flagPrevQuest)
      return true; 
    return false;
  }
  
  public double getMaxProgress() {
    return 5.0D;
  }
  
  public boolean isPrimary() {
    return true;
  }
  
  public EnumQuestlines getQuestLine() {
    return EnumQuestlines.SNIPER_PROGRESSION;
  }
  
  public boolean isRepeatable() {
    return false;
  }
  
  public boolean isTarget(EntityPlayer player, EntityLivingBase target) {
    BiomeGenBase biome = player.worldObj.getBiomeGenForCoordsBody((int)player.posX, (int)player.posZ);
    ItemStack heldItem = player.getHeldItem();
    boolean flagMob = target instanceof net.minecraft.entity.monster.EntityMob;
    boolean flagBow = ItemsHelper.isBow(heldItem);
    boolean flagDistance = (player.getDistanceToEntity((Entity)target) >= 35.0F);
    if (flagMob && flagBow && flagDistance)
      return true; 
    return false;
  }
}
