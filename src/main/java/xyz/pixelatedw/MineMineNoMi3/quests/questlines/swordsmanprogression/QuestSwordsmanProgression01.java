package xyz.pixelatedw.MineMineNoMi3.quests.questlines.swordsmanprogression;

import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.quests.IInteractQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IProgressionQuest;

public class QuestSwordsmanProgression01 extends Quest implements IInteractQuest, IProgressionQuest {
  public String getQuestID() {
    return "swordsmanprogression01";
  }
  
  public String getQuestName() {
    return "Road to becoming the Best Swordsman";
  }
  
  public String[] getQuestDescription() {
    return new String[] { " I'm starting my journey to become the best swordsman", "in the world. Proving the Master that  I'm ready won't", "be easy but I need to start somewhere.", "", "", "", "" };
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
    return props.isSwordsman();
  }
  
  public double getMaxProgress() {
    return 1.0D;
  }
  
  public void setProgress(EntityPlayer player, double progress) {
    super.setProgress(player, progress);
  }
  
  public void alterProgress(EntityPlayer player, double progress) {
    super.alterProgress(player, progress);
    if (isFinished(player))
      finishQuest(player); 
  }
  
  public boolean isPrimary() {
    return true;
  }
  
  public boolean isTarget(EntityPlayer player, EntityLivingBase target) {
    ItemStack heldItem = player.getHeldItem();
    QuestProperties questProps = QuestProperties.get(player);
    if (!(target instanceof xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.givers.EntityDojoSensei))
      return false; 
    if (heldItem != null && (heldItem.getItem() instanceof net.minecraft.item.ItemSword || heldItem.getItem() instanceof xyz.pixelatedw.MineMineNoMi3.items.weapons.ItemCoreWeapon)) {
      Iterator<Map.Entry> iterator = heldItem.getAttributeModifiers().entries().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (entry.getKey().equals(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName())) {
          AttributeModifier attrmodif = (AttributeModifier)entry.getValue();
          double damage = attrmodif.getAmount();
          if (damage >= 7.0D)
            return true; 
          WyHelper.sendMsgToPlayer(player, "<Swordsman Master> That sword of yours is way too weak, you won't get anywhere with that excuse of a sword.");
          return false;
        } 
      } 
    } 
    return false;
  }
  
  public EnumQuestlines getQuestLine() {
    return EnumQuestlines.SWORDSMAN_PROGRESSION;
  }
  
  public boolean isRepeatable() {
    return false;
  }
}
