package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class DoaAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new AirDoor(), new Door() };
  
  public static class AirDoor extends Ability {
    public AirDoor() {
      super(ListAttributes.AIR_DOOR);
    }
    
    public void passive(EntityPlayer player) {
      if (!isOnCooldown()) {
        ExtendedEntityData propz = ExtendedEntityData.get((EntityLivingBase)player);
        propz.setInAirWorld(true);
        WyNetworkHelper.sendTo((IMessage)new PacketSync(propz), (EntityPlayerMP)player);
        WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getEntityId(), propz));
        super.passive(player);
      } 
    }
    
    public void duringPassive(EntityPlayer player, int timer) {
      if (timer > 360) {
        setPassiveActive(false);
        setCooldownActive(true);
        endPassive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      startCooldown();
      startExtUpdate(player);
      ExtendedEntityData propz = ExtendedEntityData.get((EntityLivingBase)player);
      propz.setInAirWorld(false);
      WyNetworkHelper.sendTo((IMessage)new PacketSync(propz), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getEntityId(), propz));
    }
  }
  
  public static class Door extends Ability {
    public Door() {
      super(ListAttributes.DOOR);
    }
    
    public static boolean isBlock(int[] coords, EntityPlayer player) {
      if (player.getEntityWorld().getBlock(coords[0], coords[1], coords[2]) == Blocks.air && player.getEntityWorld().getBlock(coords[0], coords[1] + 1, coords[2]) == Blocks.air)
        return true; 
      return false;
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        MovingObjectPosition MOP = WyHelper.rayTraceBlocks((Entity)player);
        if (MOP != null && MOP.blockY >= player.posY + 1.0D) {
          int checkX = MOP.blockX - (int)player.posX;
          int checkZ = MOP.blockZ - (int)player.posZ;
          if (checkX > -3 && checkX < 3 && checkZ > -3 && checkZ < 3) {
            int[] coords = { MOP.blockX, (int)player.posY, MOP.blockZ };
            int timer = 0;
            while (!isBlock(coords, player)) {
              coords = WyMathHelper.moveAway(player, coords);
              timer++;
              if (timer >= 100)
                break; 
            } 
            WyMathHelper.moveAway(player, coords);
            if (timer < 100) {
              player.setPositionAndUpdate(coords[0], coords[1], coords[2]);
              super.use(player);
            } 
          } 
        } 
      } 
    }
  }
}
