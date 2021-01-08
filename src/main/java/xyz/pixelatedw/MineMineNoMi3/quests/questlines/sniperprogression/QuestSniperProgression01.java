package xyz.pixelatedw.MineMineNoMi3.quests.questlines.sniperprogression;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives.EntitySniperTarget;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketQuestObjectiveSpawn;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.quests.IInteractQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IKillQuest;
import xyz.pixelatedw.MineMineNoMi3.quests.IProgressionQuest;

public class QuestSniperProgression01 extends Quest implements IProgressionQuest, IInteractQuest, IKillQuest {
  private int questState = 0;
  
  public String getQuestID() {
    return "sniperprogression01";
  }
  
  public String getQuestName() {
    return "Crack Shot";
  }
  
  public String[] getQuestDescription() {
    return new String[] { "", "", "", "", "", "", "" };
  }
  
  public boolean isFinished(EntityPlayer player) {
    boolean flagQuestStateInteract = (this.questState == 0);
    boolean flagQuestComplete = (getProgress() < getMaxProgress());
    boolean flagQuestFailed = (this.questState == 1 && flagQuestComplete && WyHelper.getEntitiesNear((Entity)player, 50.0D, new Class[] { EntitySniperTarget.class }).size() <= 0);
    if (flagQuestStateInteract || flagQuestFailed) {
      if (!player.worldObj.isRemote)
        WyHelper.sendMsgToPlayer(player, "<Sniper Master> Just watch the sky and destroy the targets !"); 
      setProgress(player, 0.0D);
      for (int i = 0; i < 6; i++) {
        EntitySniperTarget target = new EntitySniperTarget(player.worldObj);
        double posX = player.posX + WyMathHelper.randomWithRange(-10, 10);
        double posY = player.posY + 30.0D;
        double posZ = player.posZ + WyMathHelper.randomWithRange(-10, 10);
        target.setLocationAndAngles(posX, posY, posZ, 0.0F, 0.0F);
        target.setOwner(player);
        target.setActive(true);
        if (!player.worldObj.isRemote)
          player.worldObj.spawnEntityInWorld((Entity)target); 
      } 
      WyNetworkHelper.sendToAll((IMessage)new PacketQuestObjectiveSpawn(player.getEntityId()));
      this.questState = 1;
      return super.isFinished(player);
    } 
    if (!flagQuestStateInteract && !flagQuestComplete)
      return true; 
    return false;
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
    if (flagSniper)
      return true; 
    return false;
  }
  
  public double getMaxProgress() {
    return 6.0D;
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
    if (this.questState == 0) {
      boolean flagMob = target instanceof xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.givers.EntityDojoSensei;
      if (flagMob)
        return true; 
    } else {
      ItemStack heldItem = player.getHeldItem();
      boolean flagMob = target instanceof EntitySniperTarget;
      boolean flagBow = ItemsHelper.isBow(heldItem);
      if (flagMob && flagBow)
        return true; 
    } 
    return false;
  }
}
