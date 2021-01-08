package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.events.customevents.EventDoriki;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class CommandDoriki extends CommandBase {
  public void processCommand(ICommandSender sender, String[] str) {
    EntityPlayerMP entityPlayerMP;
    if (str.length < 2)
      throw new WrongUsageException(getCommandUsage(sender), new Object[0]); 
    EntityPlayer target = null;
    int value = 0;
    if (sender instanceof EntityPlayer) {
      if (str.length == 3 && MainConfig.commandPermissionDoriki != 1) {
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
      value = 12500;
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
    EventDoriki e = new EventDoriki((EntityPlayer)entityPlayerMP);
    if (MinecraftForge.EVENT_BUS.post((Event)e))
      return; 
    WyNetworkHelper.sendTo((IMessage)new PacketSync(props), entityPlayerMP);
  }
  
  private void equal(EntityPlayer target, int value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (value <= 12500) {
      props.setDorikiFromCommand(value);
      props.setDoriki(value);
      if (WyDebug.isDebug())
        WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] " + target.getCommandSenderName() + " now has " + value + " doriki"); 
    } 
  }
  
  private void subtract(EntityPlayer target, int value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (props.getDoriki() - value <= 0) {
      props.setDoriki(0);
      if (props.getDorikiFromCommand() - value > 0) {
        props.alterDorikiFromCommand(-(props.getDorikiFromCommand() - value));
      } else {
        props.setDorikiFromCommand(0);
      } 
    } else {
      props.alterDoriki(-value);
      if (props.getDorikiFromCommand() - value > 0) {
        props.alterDorikiFromCommand(-(props.getDorikiFromCommand() - value));
      } else {
        props.setDorikiFromCommand(0);
      } 
    } 
    if (WyDebug.isDebug())
      WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Subtracted " + value + " doriki from " + target.getCommandSenderName()); 
  }
  
  private void add(EntityPlayer target, int value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (value + props.getDoriki() <= 12500) {
      props.alterDoriki(value);
      if (props.getDorikiFromCommand() + value <= 12500)
        props.alterDorikiFromCommand(value); 
    } else {
      props.setDoriki(12500);
      props.alterDorikiFromCommand(12500 - value);
    } 
    if (WyDebug.isDebug())
      WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Added " + value + " doriki to " + target.getCommandSenderName()); 
  }
  
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    if (!(sender instanceof EntityPlayer))
      return true; 
    EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(entityPlayerMP.getGameProfile());
    if ((MainConfig.commandPermissionDoriki == 2 && flag) || MainConfig.commandPermissionDoriki < 2)
      return true; 
    return false;
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/doriki <+|-|=> <amount> [player]";
  }
  
  public String getCommandName() {
    return "doriki";
  }
}
