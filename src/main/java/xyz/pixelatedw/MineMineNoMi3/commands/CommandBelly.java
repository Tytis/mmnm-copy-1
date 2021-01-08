package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumChatFormatting;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class CommandBelly extends CommandBase {
  public void processCommand(ICommandSender sender, String[] str) {
    EntityPlayerMP entityPlayerMP;
    if (str.length < 2)
      throw new WrongUsageException(getCommandUsage(sender), new Object[0]); 
    EntityPlayer target = null;
    int value = 0;
    if (sender instanceof EntityPlayer) {
      if (str.length == 3 && MainConfig.commandPermissionBelly != 1) {
        entityPlayerMP = CommandBase.getPlayer(sender, str[2]);
      } else {
        entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
      } 
    } else if (str.length == 3) {
      entityPlayerMP = CommandBase.getPlayer(sender, str[2]);
    } else {
      WyDebug.error("A player must be provided when the command is not used by a player !");
      return;
    } 
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityPlayerMP);
    if (str[1].equalsIgnoreCase("inf") || str[1].equalsIgnoreCase("max")) {
      value = 999999999;
    } else {
      value = Integer.decode(str[1]).intValue();
    } 
    switch (str[0]) {
      case "+":
        add((EntityPlayer)entityPlayerMP, value);
        break;
      case "-":
        subtract((EntityPlayer)entityPlayerMP, value);
        break;
      case "=":
        equal((EntityPlayer)entityPlayerMP, value);
        break;
    } 
    WyNetworkHelper.sendTo((IMessage)new PacketSync(props), entityPlayerMP);
  }
  
  private void equal(EntityPlayer target, int value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (value <= 999999999) {
      props.setBellyFromCommand(value);
      props.setBelly(value);
      if (WyDebug.isDebug())
        WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] " + target.getCommandSenderName() + " now has " + value + " belly"); 
    } 
  }
  
  private void subtract(EntityPlayer target, int value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (props.getBelly() - value <= 0) {
      props.setBelly(0);
      if (props.getBellyFromCommand() - value > 0) {
        props.alterBellyFromCommand(-(props.getBellyFromCommand() - value));
      } else {
        props.setBellyFromCommand(0);
      } 
    } else {
      props.alterBelly(-value);
      if (props.getBellyFromCommand() - value > 0) {
        props.alterBellyFromCommand(-(props.getBellyFromCommand() - value));
      } else {
        props.setBellyFromCommand(0);
      } 
    } 
    if (WyDebug.isDebug())
      WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Subtracted " + value + " belly from " + target.getCommandSenderName()); 
  }
  
  private void add(EntityPlayer target, int value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (value + props.getBelly() <= 999999999) {
      props.alterBelly(value);
      if (props.getBellyFromCommand() + value <= 999999999)
        props.alterBellyFromCommand(value); 
    } else {
      props.setBelly(999999999);
      props.alterBellyFromCommand(999999999 - value);
    } 
    if (WyDebug.isDebug())
      WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Added " + value + " belly to " + target.getCommandSenderName()); 
  }
  
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    if (!(sender instanceof EntityPlayer))
      return true; 
    EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(entityPlayerMP.getGameProfile());
    if ((MainConfig.commandPermissionBelly == 2 && flag) || MainConfig.commandPermissionBelly < 2)
      return true; 
    return false;
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/belly <+|-|=> <amount> [player]";
  }
  
  public String getCommandName() {
    return "belly";
  }
}
