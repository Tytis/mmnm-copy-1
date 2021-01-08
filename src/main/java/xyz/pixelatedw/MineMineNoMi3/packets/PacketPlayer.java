package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.gui.GUIWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;

public class PacketPlayer implements IMessage {
  private String cmd;
  
  private boolean ablState = false;
  
  private NBTTagCompound nbt;
  
  private double mX;
  
  private double mY;
  
  private double mZ;
  
  public PacketPlayer(String cmd) {
    this.cmd = cmd;
  }
  
  public PacketPlayer(String cmd, boolean bool) {
    this.cmd = cmd;
    this.ablState = bool;
  }
  
  public PacketPlayer(String cmd, ItemStack stack) {
    this.cmd = cmd;
    this.nbt = stack.getTagCompound();
  }
  
  public PacketPlayer(String cmd, double mX, double mY, double mZ) {
    this.cmd = cmd;
    this.mX = mX;
    this.mY = mY;
    this.mZ = mZ;
  }
  
  public void fromBytes(ByteBuf buf) {
    this.cmd = ByteBufUtils.readUTF8String(buf);
    this.ablState = buf.readBoolean();
    this.mX = buf.readDouble();
    this.mY = buf.readDouble();
    this.mZ = buf.readDouble();
    this.nbt = ByteBufUtils.readTag(buf);
  }
  
  public void toBytes(ByteBuf buf) {
    ByteBufUtils.writeUTF8String(buf, this.cmd);
    buf.writeBoolean(this.ablState);
    buf.writeDouble(this.mX);
    buf.writeDouble(this.mY);
    buf.writeDouble(this.mZ);
    ByteBufUtils.writeTag(buf, this.nbt);
  }
  
  public PacketPlayer() {}
  
  public static class ClientHandler implements IMessageHandler<PacketPlayer, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(PacketPlayer message, MessageContext ctx) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityClientPlayerMP);
      AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)entityClientPlayerMP);
      boolean canAnimate = true;
      double frame = 0.0D;
      if (message.cmd.equals("guiWantedPoster"))
        Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GUIWantedPoster(message.nbt)); 
      if (message.cmd.equals("ChangeRotation")) {
        float initialRotation = ((EntityPlayer)entityClientPlayerMP).rotationYaw;
        ((EntityPlayer)entityClientPlayerMP).rotationYaw = initialRotation + 10.0F;
      } 
      if (message.cmd.equals("ElThorThunder")) {
        int i = (int)message.mX;
        int j = (int)message.mY;
        int k = (int)message.mZ;
        ((EntityPlayer)entityClientPlayerMP).worldObj.spawnEntityInWorld((Entity)new EntityLightningBolt(((EntityPlayer)entityClientPlayerMP).worldObj, (i + 1), j, k));
        ((EntityPlayer)entityClientPlayerMP).worldObj.spawnEntityInWorld((Entity)new EntityLightningBolt(((EntityPlayer)entityClientPlayerMP).worldObj, i, j, (k + 1)));
        ((EntityPlayer)entityClientPlayerMP).worldObj.spawnEntityInWorld((Entity)new EntityLightningBolt(((EntityPlayer)entityClientPlayerMP).worldObj, (i - 1), j, k));
        ((EntityPlayer)entityClientPlayerMP).worldObj.spawnEntityInWorld((Entity)new EntityLightningBolt(((EntityPlayer)entityClientPlayerMP).worldObj, i, j, (k - 1)));
      } 
      if (message.cmd.equals("ECLAIR")) {
        int i = (int)message.mX;
        int j = (int)message.mY;
        int k = (int)message.mZ;
        ((EntityPlayer)entityClientPlayerMP).worldObj.spawnEntityInWorld((Entity)new EntityLightningBolt(((EntityPlayer)entityClientPlayerMP).worldObj, i, j, k));
      } 
      if (message.cmd.contains("motion+")) {
        ((EntityPlayer)entityClientPlayerMP).motionX += message.mX;
        ((EntityPlayer)entityClientPlayerMP).motionY += message.mY;
        ((EntityPlayer)entityClientPlayerMP).motionZ += message.mZ;
      } 
      if (message.cmd.contains("motion-")) {
        ((EntityPlayer)entityClientPlayerMP).motionX -= message.mX;
        ((EntityPlayer)entityClientPlayerMP).motionY -= message.mY;
        ((EntityPlayer)entityClientPlayerMP).motionZ -= message.mZ;
      } 
      if (message.cmd.contains("motion=")) {
        ((EntityPlayer)entityClientPlayerMP).motionX = message.mX;
        ((EntityPlayer)entityClientPlayerMP).motionY = message.mY;
        ((EntityPlayer)entityClientPlayerMP).motionZ = message.mZ;
      } 
      if (message.cmd.contains("motion*")) {
        ((EntityPlayer)entityClientPlayerMP).motionX *= message.mX;
        ((EntityPlayer)entityClientPlayerMP).motionY *= message.mY;
        ((EntityPlayer)entityClientPlayerMP).motionZ *= message.mZ;
      } 
      if (message.cmd.contains("pos"))
        entityClientPlayerMP.setPositionAndRotation(message.mX, message.mY, message.mZ, ((EntityPlayer)entityClientPlayerMP).rotationYaw, ((EntityPlayer)entityClientPlayerMP).rotationPitch); 
      return null;
    }
  }
  
  public static class ServerHandler implements IMessageHandler<PacketPlayer, IMessage> {
    public IMessage onMessage(PacketPlayer message, MessageContext ctx) {
      EntityPlayerMP entityPlayerMP = (ctx.getServerHandler()).playerEntity;
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityPlayerMP);
      AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)entityPlayerMP);
      if (message.cmd.equals("delete_book")) {
        abilityProps.clearHotbar();
        abilityProps.clearRacialAbilities();
        DevilFruitsHelper.validateRacialMoves((EntityPlayer)entityPlayerMP);
        DevilFruitsHelper.validateStyleMoves((EntityPlayer)entityPlayerMP);
        if (props.isCyborg()) {
          props.setMaxCola(100);
          props.setCola(props.getMaxCola());
        } 
        for (ItemStack is : ((EntityPlayer)entityPlayerMP).inventory.mainInventory) {
          if (is != null && is.getItem() instanceof xyz.pixelatedw.MineMineNoMi3.items.CharacterCreator)
            WyHelper.removeStackFromInventory((EntityPlayer)entityPlayerMP, is); 
        } 
        WyNetworkHelper.sendTo(new PacketSync(props), entityPlayerMP);
        WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(abilityProps), entityPlayerMP);
      } 
      if (message.cmd.equals("forcesync")) {
        WyNetworkHelper.sendTo(new PacketSync(props), entityPlayerMP);
        WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(abilityProps), entityPlayerMP);
      } 
      if (message.cmd.contains("msg"))
        WyHelper.sendMsgToPlayer((EntityPlayer)entityPlayerMP, message.cmd.replace("msg", "")); 
      if (message.cmd.equals("enterCombatMode"))
        props.setCombatMode(!props.isInCombatMode()); 
      return null;
    }
  }
}
