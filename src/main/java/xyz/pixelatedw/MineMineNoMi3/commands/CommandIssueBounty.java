package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;

public class CommandIssueBounty extends CommandBase {
  public void processCommand(ICommandSender sender, String[] str) {
    EntityPlayerMP entityPlayerMP;
    EntityPlayer player = null;
    boolean allFlag = false;
    if (str.length == 1) {
      if (str[0].equalsIgnoreCase("all")) {
        allFlag = true;
        entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
      } else {
        entityPlayerMP = CommandBase.getPlayer(sender, str[0]);
      } 
    } else {
      entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    } 
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityPlayerMP);
    ExtendedWorldData worldData = ExtendedWorldData.get(((EntityPlayer)entityPlayerMP).worldObj);
    if (!allFlag) {
      worldData.issueBounty(entityPlayerMP.getCommandSenderName(), props.getBounty());
    } else {
      ((EntityPlayer)entityPlayerMP).worldObj.loadedEntityList.stream().filter(x -> 
          
          (x instanceof EntityPlayer && (ExtendedEntityData.get((EntityLivingBase)x).isPirate() || ExtendedEntityData.get((EntityLivingBase)x).isRevolutionary()) && ExtendedEntityData.get((EntityLivingBase)x).getBounty() > 0L))
        .forEach(x -> {
            EntityPlayer pirate = (EntityPlayer)x;
            worldData.issueBounty(pirate.getCommandSenderName(), ExtendedEntityData.get((EntityLivingBase)pirate).getBounty());
          });
    } 
  }
  
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    if (!(sender instanceof EntityPlayer))
      return true; 
    EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(entityPlayerMP.getGameProfile());
    if ((MainConfig.commandPermissionIssueBounty == 2 && flag) || MainConfig.commandPermissionIssueBounty < 2)
      return true; 
    return false;
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/issuebounty <player>";
  }
  
  public String getCommandName() {
    return "issuebounty";
  }
}
