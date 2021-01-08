package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class CommandPouch extends CommandBase {
  public void processCommand(ICommandSender sender, String[] str) {
    EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    if (str.length < 1)
      throw new WrongUsageException(getCommandUsage(sender), new Object[0]); 
    int amount = Integer.parseInt(str[0]);
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityPlayerMP);
    if (amount <= 0)
      return; 
    if (props.getBelly() - amount >= 0) {
      props.alterBelly(-amount);
    } else {
      amount = props.getBelly();
      props.alterBelly(-amount);
    } 
    if (!((EntityPlayer)entityPlayerMP).capabilities.isCreativeMode)
      WyTelemetry.addMiscStat("bellyEarnedFromPouches", "Belly Earned From Pouches", -amount); 
    ItemStack pouch = new ItemStack(ListMisc.BellyPouch);
    pouch.setTagCompound(new NBTTagCompound());
    pouch.getTagCompound().setInteger("belly", amount);
    ((EntityPlayer)entityPlayerMP).inventory.addItemStackToInventory(pouch);
    WyNetworkHelper.sendTo((IMessage)new PacketSync(props), entityPlayerMP);
    WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(entityPlayerMP.getDisplayName(), props));
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/pouch [amount]";
  }
  
  public String getCommandName() {
    return "pouch";
  }
}
