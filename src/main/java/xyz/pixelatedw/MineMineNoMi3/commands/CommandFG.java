package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.abilities.HakiAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.Schematic;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WySchematicHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestManager;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.data.HistoryProperties;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.baroqueWorks.EntityMr0;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMorgan;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityDugong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityDummy;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityLapahn;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityYagaraBull;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.world.TeleporterScenarioArena;
import xyz.pixelatedw.MineMineNoMi3.world.structures.StructureBanditSmallBase;
import xyz.pixelatedw.MineMineNoMi3.world.structures.StructureLargeShip;
import xyz.pixelatedw.MineMineNoMi3.world.structures.StructureMarineLargeBase;

public class CommandFG extends CommandBase {
  private Quest[] questsPool = new Quest[] { ListQuests.bountyLowLevel01, ListQuests.bountyLowLevel02, ListQuests.bountyLowLevel03 };
  
  public void processCommand(ICommandSender sender, String[] str) {
    if (str.length >= 1) {
      EntityWantedPostersPackage entityWantedPostersPackage;
      EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityPlayerMP);
      AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)entityPlayerMP);
      QuestProperties questProps = QuestProperties.get((EntityPlayer)entityPlayerMP);
      HistoryProperties historyProps = HistoryProperties.get((EntityPlayer)entityPlayerMP);
      Entity toSpawn = null;
      if (str[0].equalsIgnoreCase("dummy")) {
        TempEntityDummy tempEntityDummy = new TempEntityDummy(((EntityPlayer)entityPlayerMP).worldObj);
      } else if (str[0].equalsIgnoreCase("mr0")) {
        EntityMr0 entityMr0 = new EntityMr0(((EntityPlayer)entityPlayerMP).worldObj);
      } else if (str[0].equalsIgnoreCase("morgan")) {
        EntityMorgan entityMorgan = new EntityMorgan(((EntityPlayer)entityPlayerMP).worldObj);
      } else if (str[0].equalsIgnoreCase("dugong")) {
        TempEntityDugong tempEntityDugong = new TempEntityDugong(((EntityPlayer)entityPlayerMP).worldObj);
      } else if (str[0].equalsIgnoreCase("lapahn")) {
        TempEntityLapahn tempEntityLapahn = new TempEntityLapahn(((EntityPlayer)entityPlayerMP).worldObj);
      } else if (str[0].equalsIgnoreCase("yagarabull")) {
        TempEntityYagaraBull tempEntityYagaraBull = new TempEntityYagaraBull(((EntityPlayer)entityPlayerMP).worldObj);
      } 
      if (str[0].equalsIgnoreCase("package")) {
        entityWantedPostersPackage = new EntityWantedPostersPackage(((EntityPlayer)entityPlayerMP).worldObj);
        entityWantedPostersPackage.setLocationAndAngles(((EntityPlayer)entityPlayerMP).posX + WyMathHelper.randomWithRange(-10, 10), ((EntityPlayer)entityPlayerMP).posY + 30.0D, ((EntityPlayer)entityPlayerMP).posZ + WyMathHelper.randomWithRange(-10, 10), 0.0F, 0.0F);
        ((EntityPlayer)entityPlayerMP).worldObj.spawnEntityInWorld((Entity)entityWantedPostersPackage);
        return;
      } 
      if (str[0].equalsIgnoreCase("randBounties")) {
        ExtendedWorldData worldData = ExtendedWorldData.get(((EntityPlayer)entityPlayerMP).worldObj);
        for (int i = 1; i < 10; i++)
          worldData.issueBounty("Test Name #" + i, (i * 100 + ((EntityPlayer)entityPlayerMP).worldObj.rand.nextInt(1000))); 
      } else if (str[0].equalsIgnoreCase("monsterspawner")) {
        String toSpawn1 = "mineminenomi.Marine with Sword";
        TileEntityCustomSpawner spw1 = (new TileEntityCustomSpawner()).setSpawnerMob(toSpawn1).setSpawnerLimit(5);
        ((EntityPlayer)entityPlayerMP).worldObj.setBlock((int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posY + 1, (int)((EntityPlayer)entityPlayerMP).posZ, (Block)ListMisc.CustomSpawner);
        ((EntityPlayer)entityPlayerMP).worldObj.setTileEntity((int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posY + 1, (int)((EntityPlayer)entityPlayerMP).posZ, (TileEntity)spw1);
      } else if (str[0].equalsIgnoreCase("scenario")) {
        if (str[1].equalsIgnoreCase("start")) {
          if (!((EntityPlayer)entityPlayerMP).worldObj.isRemote)
            (new TeleporterScenarioArena((WorldServer)((EntityPlayer)entityPlayerMP).worldObj)).teleport((Entity)entityPlayerMP, "scenario_cptmorgan"); 
        } else if (str[1].equalsIgnoreCase("end")) {
          if (!((EntityPlayer)entityPlayerMP).worldObj.isRemote)
            (new TeleporterScenarioArena((WorldServer)((EntityPlayer)entityPlayerMP).worldObj)).endScenario((Entity)entityPlayerMP, "scenario_cptmorgan"); 
        } 
      } else if (str[0].equalsIgnoreCase("maxcola")) {
        if (!props.hasColaBackpack()) {
          props.setMaxCola(250);
        } else {
          props.setMaxCola(450);
        } 
      } else if (str[0].equalsIgnoreCase("fillcola")) {
        props.setCola(props.getMaxCola());
      } else if (str[0].equalsIgnoreCase("rngquest")) {
        QuestManager.instance().startQuest((EntityPlayer)entityPlayerMP, ListQuests.bountyLowLevel01);
        WyNetworkHelper.sendTo((IMessage)new PacketQuestSync(questProps), entityPlayerMP);
      } else if (str[0].equalsIgnoreCase("questprogress")) {
        Quest[] questline = null;
        if (str.length < 3)
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Incorrect syntax"); 
        if (str[1].equalsIgnoreCase("swordsman")) {
          questline = EnumQuestlines.SWORDSMAN_PROGRESSION.getQuests();
        } else if (str[1].equalsIgnoreCase("sniper")) {
          questline = EnumQuestlines.SNIPER_PROGRESSION.getQuests();
        } 
        int questNo = Integer.parseInt(str[2]);
        if (questline == null)
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Incorrect Questline"); 
        for (int i = 0; i < questNo; i++) {
          try {
            Quest nQuest = (Quest)questline[i].getClass().newInstance();
            questProps.addQuestInTracker(nQuest);
            questProps.getQuestIndexFromTracker(0).startQuest((EntityPlayer)entityPlayerMP);
            questProps.getQuestIndexFromTracker(0).finishQuest((EntityPlayer)entityPlayerMP);
            WyNetworkHelper.sendTo((IMessage)new PacketQuestSync(questProps), entityPlayerMP);
          } catch (InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
          } 
        } 
      } else if (str[0].equalsIgnoreCase("resetquests")) {
        questProps.clearQuestTracker();
        questProps.clearCompletedQuests();
        WyNetworkHelper.sendTo((IMessage)new PacketQuestSync(questProps), entityPlayerMP);
      } else if (str[0].equalsIgnoreCase("marinebase")) {
        StructureMarineLargeBase.build(WySchematicHelper.load("marineLargeBase"), ((EntityPlayer)entityPlayerMP).worldObj, (int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posY, (int)((EntityPlayer)entityPlayerMP).posZ, ((EntityPlayer)entityPlayerMP).worldObj.getBiomeGenForCoordsBody((int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posZ));
      } else if (str[0].equalsIgnoreCase("banditbase")) {
        StructureBanditSmallBase.build(WySchematicHelper.load("banditBase"), ((EntityPlayer)entityPlayerMP).worldObj, (int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posY, (int)((EntityPlayer)entityPlayerMP).posZ, ((EntityPlayer)entityPlayerMP).worldObj.getBiomeGenForCoordsBody((int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posZ));
      } else if (str[0].equalsIgnoreCase("marineShip")) {
        Schematic sch = WySchematicHelper.load("marineLargeShip");
        WySchematicHelper.build(sch, ((EntityPlayer)entityPlayerMP).worldObj, (int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posY, (int)((EntityPlayer)entityPlayerMP).posZ);
        StructureLargeShip.populate((int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posY, (int)((EntityPlayer)entityPlayerMP).posZ, ((EntityPlayer)entityPlayerMP).worldObj, sch.getName());
      } else if (str[0].equalsIgnoreCase("pirateShip")) {
        Schematic sch = WySchematicHelper.load("pyrateLargeShip");
        WySchematicHelper.build(sch, ((EntityPlayer)entityPlayerMP).worldObj, (int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posY, (int)((EntityPlayer)entityPlayerMP).posZ);
        StructureLargeShip.populate((int)((EntityPlayer)entityPlayerMP).posX, (int)((EntityPlayer)entityPlayerMP).posY, (int)((EntityPlayer)entityPlayerMP).posZ, ((EntityPlayer)entityPlayerMP).worldObj, sch.getName());
      } else if (str[0].equalsIgnoreCase("reset_history")) {
        historyProps.removeUnlockedChallenge("crocodile");
      } else if (str[0].equalsIgnoreCase("haki")) {
        if (str[1].equalsIgnoreCase("aura")) {
          abilityProps.addHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_AURA);
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Kenbunshoku Haki: Aura Unlocked");
        } else if (str[1].equalsIgnoreCase("futuresight")) {
          abilityProps.addHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_FUTURE_SIGHT);
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Kenbunshoku Haki: Future Sight Unlocked");
        } else if (str[1].equalsIgnoreCase("hardening")) {
          abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_HARDENING);
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Busoshoku Haki: Hardening Unlocked");
        } else if (str[1].equalsIgnoreCase("fullbody")) {
          abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_FULL_BODY_HARDENING);
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Busoshoku Haki: Full Body Hardening Unlocked");
        } else if (str[1].equalsIgnoreCase("imbuing")) {
          abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_IMBUING);
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Busoshoku Haki: Imbuing Unlocked");
        } else if (str[1].equalsIgnoreCase("hao")) {
          abilityProps.addHakiAbility(HakiAbilities.HAOSHOKU_HAKI);
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Haoshoku Haki");
        } else if (str[1].equalsIgnoreCase("all")) {
          abilityProps.addHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_AURA);
          abilityProps.addHakiAbility(HakiAbilities.KENBUNSHOKU_HAKI_FUTURE_SIGHT);
          abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_HARDENING);
          abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_FULL_BODY_HARDENING);
          abilityProps.addHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_IMBUING);
          abilityProps.addHakiAbility(HakiAbilities.HAOSHOKU_HAKI);
          WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, "Unlocked All Haki Types");
        } 
      } 
    } 
  }
  
  public boolean canCommandSenderUseCommand(ICommandSender cmd) {
    return true;
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/fg <entity>";
  }
  
  public String getCommandName() {
    return "fg";
  }
}
