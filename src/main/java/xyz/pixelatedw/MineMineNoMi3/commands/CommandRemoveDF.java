package xyz.pixelatedw.MineMineNoMi3.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class CommandRemoveDF extends CommandBase {
  public void processCommand(ICommandSender sender, String[] str) {
    EntityPlayerMP entityPlayerMP;
    EntityPlayer player = null;
    if (str.length == 1) {
      entityPlayerMP = CommandBase.getPlayer(sender, str[0]);
    } else {
      entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    } 
    boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(entityPlayerMP.getGameProfile());
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityPlayerMP);
    AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)entityPlayerMP);
    ExtendedWorldData worldProps = ExtendedWorldData.get(((EntityPlayer)entityPlayerMP).worldObj);
    worldProps.removeDevilFruitFromWorld(props.getUsedFruit());
    props.setUsedFruit("N/A");
    props.setYamiPower(false);
    props.setIsLogia(false);
    props.triggerActiveHaki(false);
    props.triggerBusoHaki(false);
    props.triggerKenHaki(false);
    abilityProps.clearHotbar();
    abilityProps.clearDevilFruitAbilities();
    entityPlayerMP.clearActivePotions();
    props.setZoanPoint("n/a");
    entityPlayerMP.clearActivePotions();
    WyNetworkHelper.sendTo((IMessage)new PacketSync(props), entityPlayerMP);
    WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(entityPlayerMP.getDisplayName(), props));
    WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(abilityProps), entityPlayerMP);
  }
  
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    if (!(sender instanceof EntityPlayer))
      return true; 
    EntityPlayerMP entityPlayerMP = CommandBase.getCommandSenderAsPlayer(sender);
    boolean flag = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152596_g(entityPlayerMP.getGameProfile());
    if ((MainConfig.commandPermissionRemoveDF == 2 && flag) || MainConfig.commandPermissionRemoveDF < 2)
      return true; 
    return false;
  }
  
  public String getCommandUsage(ICommandSender icommandsender) {
    return "/removedf [player]";
  }
  
  public String getCommandName() {
    return "removedf";
  }
}
