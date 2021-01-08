package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class CommandGetWantedPoster extends CommandBase {
  public void processCommand(ICommandSender sender, String[] str) {
    EntityPlayerMP entityPlayerMP;
    EntityPlayer player = null;
    if (str.length == 1) {
      entityPlayerMP = CommandBase.getPlayer(sender, str[0]);
    } else {
      entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    } 
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityPlayerMP);
    ExtendedWorldData worldData = ExtendedWorldData.get(((EntityPlayer)entityPlayerMP).worldObj);
    worldData.issueBounty(entityPlayerMP.getCommandSenderName(), props.getBounty());
    ItemStack posterStack = new ItemStack((Item)ListMisc.WantedPoster);
    posterStack.setTagCompound(ItemsHelper.setWantedData(entityPlayerMP.getCommandSenderName(), worldData.getBounty(entityPlayerMP.getCommandSenderName())));
    ((EntityPlayer)entityPlayerMP).inventory.addItemStackToInventory(posterStack);
  }
  
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    if (!(sender instanceof EntityPlayer))
      return true; 
    EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(entityPlayerMP.getGameProfile());
    if ((MainConfig.commandPermissionGetWantedPoster == 2 && flag) || MainConfig.commandPermissionGetWantedPoster < 2)
      return true; 
    return false;
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/getwantedposter";
  }
  
  public String getCommandName() {
    return "getwantedposter";
  }
}
