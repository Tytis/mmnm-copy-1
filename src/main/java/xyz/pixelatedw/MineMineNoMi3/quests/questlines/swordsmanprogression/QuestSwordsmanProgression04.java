package xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.abilities.SwordsmanAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.quests.IHitCounterQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IProgressionQuest;

public class QuestSwordsmanProgression04 extends Quest implements IHitCounterQuest, IProgressionQuest {
  public String getQuestID() {
    return "swordsmanprogression04";
  }
  
  public String getQuestName() {
    return "The Fruits of Training";
  }
  
  public String[] getQuestDescription() {
    return new String[] { " For my last test I need to deal 25 critical hits.", "I need to focus on my movement and the enemy to", "successfully deal them.", "", "", "", "" };
  }
  
  public void startQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".started", new Object[0]));
    super.startQuest(player);
  }
  
  public void finishQuest(EntityPlayer player) {
    WyHelper.sendMsgToPlayer(player, I18n.format("quest." + getQuestID() + ".completed", new Object[0]));
    AbilityProperties abilityProps = AbilityProperties.get(player);
    if (MainConfig.enableQuestProgression)
      abilityProps.addRacialAbility(SwordsmanAbilities.SANBYAKUROKUJU_POUND_HO); 
    super.finishQuest(player);
  }
  
  public boolean canStart(EntityPlayer player) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    QuestProperties questProps = QuestProperties.get(player);
    boolean flag1 = (!props.isSwordsman() || !questProps.hasQuestCompleted(ListQuests.swordsmanProgression03));
    if (flag1)
      return false; 
    return true;
  }
  
  public double getMaxProgress() {
    return 25.0D;
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
  
  public boolean checkHit(EntityPlayer player, EntityLivingBase target, DamageSource source) {
    ItemStack heldItem = player.getHeldItem();
    boolean flag = (player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isRiding() && heldItem != null && (heldItem.getItem() instanceof xyz.pixelatedw.MineMineNoMi3.items.weapons.ItemCoreWeapon || heldItem.getItem() instanceof net.minecraft.item.ItemSword));
    if (flag)
      return true; 
    return false;
  }
}
