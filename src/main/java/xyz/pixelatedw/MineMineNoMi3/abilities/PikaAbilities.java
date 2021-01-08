package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.PikaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class PikaAbilities {
  static {
    Values.abilityWebAppExtraParams.put("yasakaninomagatama", new String[] { "desc", "Fires a torrent of deadly light particles, causing huge destruction." });
    Values.abilityWebAppExtraParams.put("yatanokagami", new String[] { "desc", "Uses light to instantly teleport the user to their desired location." });
    Values.abilityWebAppExtraParams.put("amaterasu", new String[] { "desc", "Creates an immense beam of light, which causes massive damage." });
    Values.abilityWebAppExtraParams.put("flash", new String[] { "desc", "The user creates a bright flash of light, blinding their opponents." });
    Values.abilityWebAppExtraParams.put("amanomurakumo", new String[] { "desc", "Focuses light in the user's hand to create a sword." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new YataNoKagami(), new AmaNoMurakumo(), new YasakaniNoMagatama(), new Amaterasu(), new Flash() };
  
  public static class Flash extends Ability {
    public Flash() {
      super(ListAttributes.FLASH);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown)
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("flash", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D); 
      super.use(player);
    }
  }
  
  public static class AmaNoMurakumo extends Ability {
    public AmaNoMurakumo() {
      super(ListAttributes.AMA_NO_MURAKUMO);
    }
    
    public void startPassive(EntityPlayer player) {
      if (player.inventory.getCurrentItem() == null) {
        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack((Item)ListMisc.AmaNoMurakumo));
      } else {
        WyHelper.sendMsgToPlayer(player, "Cannot equip " + getAttribute().getAttributeName() + " while holding another item in hand !");
        passive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      player.inventory.clearInventory((Item)ListMisc.AmaNoMurakumo, -1);
    }
  }
  
  public static class Amaterasu extends Ability {
    public Amaterasu() {
      super(ListAttributes.AMATERASU);
    }
    
    public void startCharging(EntityPlayer player) {
      if (!this.isOnCooldown)
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("amaterasu", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D); 
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new PikaProjectiles.Amaterasu(player.worldObj, (EntityLivingBase)player, this.attr);
      super.endCharging(player);
    }
  }
  
  public static class YasakaniNoMagatama extends Ability {
    public YasakaniNoMagatama() {
      super(ListAttributes.YASAKANI_NO_MAGATAMA);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new PikaProjectiles.YasakaniNoMagatama(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class YataNoKagami extends Ability {
    public YataNoKagami() {
      super(ListAttributes.YATA_NO_KAGAMI);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (WyHelper.rayTraceBlocks((Entity)player) != null) {
          MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
          int x = mop.blockX;
          int y = mop.blockY;
          int z = mop.blockZ;
          if (player.isRiding())
            player.mountEntity((Entity)null); 
          EnderTeleportEvent event = new EnderTeleportEvent((EntityLivingBase)player, x, y, z, 5.0F);
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("yatanNoKagami", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          player.setPositionAndUpdate(event.targetX, event.targetY + 1.0D, event.targetZ);
          WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("yatanNoKagami", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
          player.fallDistance = 0.0F;
        } 
        super.use(player);
      } 
    }
  }
}
