package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class CommandDamageMultiplier extends CommandBase {
  public void processCommand(ICommandSender sender, String[] str) {
    EntityPlayerMP entityPlayerMP;
    if (str.length < 1)
      throw new WrongUsageException(getCommandUsage(sender), new Object[0]); 
    EntityPlayer target = null;
    float multiplier = 0.0F;
    if (sender instanceof EntityPlayer) {
      if (str.length == 3) {
        entityPlayerMP = CommandBase.getPlayer(sender, str[1]);
      } else {
        entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
      } 
    } else if (str.length == 3) {
      entityPlayerMP = CommandBase.getPlayer(sender, str[1]);
    } else {
      WyDebug.error("A player must be provided when the command is not used by a player !");
      return;
    } 
    multiplier = Float.parseFloat(str[0]);
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityPlayerMP);
    props.setDamageMultiplier(multiplier);
  }
  
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    if (!(sender instanceof EntityPlayer))
      return true; 
    EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(entityPlayerMP.getGameProfile());
    if (flag)
      return true; 
    return false;
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/damagem <amount> [player]";
  }
  
  public String getCommandName() {
    return "damagem";
  }
}
