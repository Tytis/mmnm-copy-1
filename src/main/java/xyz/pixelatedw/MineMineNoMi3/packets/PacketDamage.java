package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.MainMod;

public class PacketDamage implements IMessage {
  protected int damage = 0;
  
  protected int ent;
  
  public PacketDamage() {}
  
  public PacketDamage(int damage, int entity) {
    this.damage = damage;
    this.ent = entity;
  }
  
  public void fromBytes(ByteBuf buf) {
    this.damage = buf.readInt();
    this.ent = buf.readInt();
  }
  
  public void toBytes(ByteBuf buf) {
    buf.writeInt(this.damage);
    buf.writeInt(this.ent);
  }
  
  public static class ClientHandler implements IMessageHandler<PacketDamage, IMessage> {
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(PacketDamage message, MessageContext ctx) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
      if (message.ent != 0)
        for (Object e : ((EntityPlayer)entityClientPlayerMP).worldObj.loadedEntityList) {
          if (e instanceof EntityLivingBase)
            if (((EntityLivingBase)e).getEntityId() == message.ent) {
              ((EntityLivingBase)e).setHealth(((EntityLivingBase)e).getHealth() - message.damage);
              break;
            }  
        }  
      return message;
    }
  }
  
  public static class ServerHandler implements IMessageHandler<PacketDamage, IMessage> {
    public IMessage onMessage(PacketDamage message, MessageContext ctx) {
      EntityPlayer player = MainMod.proxy.getPlayerEntity(ctx);
      if (message.ent != 0)
        for (Object e : player.worldObj.loadedEntityList) {
          if (e instanceof EntityLivingBase)
            if (((EntityLivingBase)e).getEntityId() == message.ent) {
              ((EntityLivingBase)e).setHealth(((EntityLivingBase)e).getHealth() - message.damage);
              break;
            }  
        }  
      return null;
    }
  }
}
