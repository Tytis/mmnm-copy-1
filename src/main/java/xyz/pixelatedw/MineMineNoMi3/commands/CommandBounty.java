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

public class CommandBounty extends CommandBase {
  public void processCommand(ICommandSender sender, String[] str) {
    EntityPlayerMP entityPlayerMP;
    if (str.length < 2)
      throw new WrongUsageException(getCommandUsage(sender), new Object[0]); 
    EntityPlayer target = null;
    long value = 0L;
    if (sender instanceof EntityPlayer) {
      if (str.length == 3 && MainConfig.commandPermissionBounty != 1) {
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
      value = 100000000000L;
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
  
  private void equal(EntityPlayer target, long value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (value <= 100000000000L) {
      props.setBountyFromCommand(value);
      props.setBounty(value);
      if (WyDebug.isDebug())
        WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] " + target.getCommandSenderName() + " now has " + value + " bounty"); 
    } 
  }
  
  private void subtract(EntityPlayer target, long value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (props.getBounty() - value <= 0L) {
      props.setBounty(0L);
      if (props.getBountyFromCommand() - value > 0L) {
        props.alterBountyFromCommand(-(props.getBountyFromCommand() - value));
      } else {
        props.setBountyFromCommand(0L);
      } 
    } else {
      props.alterBounty(-value);
      if (props.getBountyFromCommand() - value > 0L) {
        props.alterBountyFromCommand(-(props.getBountyFromCommand() - value));
      } else {
        props.setBountyFromCommand(0L);
      } 
    } 
    if (WyDebug.isDebug())
      WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Subtracted " + value + " bounty from " + target.getCommandSenderName()); 
  }
  
  private void add(EntityPlayer target, long value) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)target);
    if (value + props.getBounty() <= 100000000000L) {
      props.alterBounty(value);
      if (props.getBountyFromCommand() + value <= 100000000000L)
        props.alterBountyFromCommand(value); 
    } else {
      props.setBounty(100000000000L);
      props.alterBountyFromCommand(100000000000L - value);
    } 
    if (WyDebug.isDebug())
      WyHelper.sendMsgToPlayer(target, EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + "[DEBUG] Added " + value + " bounty to " + target.getCommandSenderName()); 
  }
  
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    if (!(sender instanceof EntityPlayer))
      return true; 
    EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(entityPlayerMP.getGameProfile());
    if ((MainConfig.commandPermissionBounty == 2 && flag) || MainConfig.commandPermissionBounty < 2)
      return true; 
    return false;
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/bounty <+|-|=> <amount> [player]";
  }
  
  public String getCommandName() {
    return "bounty";
  }
}
