package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class KiloAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new Weightless(), new KickOffJump(), new HeavyPunch(), new KiloPress() };
  
  private static boolean hasStrength(EntityPlayer player) {
    Object[] effects = player.getActivePotionEffects().toArray();
    for (int i = 0; i < effects.length; i++) {
      PotionEffect currentEffect = (PotionEffect)effects[i];
      if (currentEffect.getPotionID() == 5 && currentEffect.getAmplifier() == 8)
        return true; 
    } 
    return false;
  }
  
  private static void movePlayer(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
  
  public static class Weightless extends Ability {
    public Weightless() {
      super(ListAttributes.WEIGHTLESS);
    }
    
    public void passive(EntityPlayer player) {
      if (!this.isOnCooldown)
        super.passive(player); 
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (player.onGround) {
        replaceUmbrella(player);
        setPassiveActive(false);
        setCooldownActive(true);
        endPassive(player);
      } else if (player.getHeldItem() != null && player.getHeldItem().getItem() == ListMisc.UmbrellaOpen) {
        double mZ = 0.0D;
        double mX = 0.0D;
        WyHelper.Direction dir = WyHelper.get8Directions((Entity)player);
        if (dir == WyHelper.Direction.NORTH)
          mZ -= 0.25D; 
        if (dir == WyHelper.Direction.NORTH_WEST) {
          mZ -= 0.2D;
          mX -= 0.2D;
        } 
        if (dir == WyHelper.Direction.SOUTH)
          mZ += 0.25D; 
        if (dir == WyHelper.Direction.NORTH_EAST) {
          mZ -= 0.2D;
          mX += 0.2D;
        } 
        if (dir == WyHelper.Direction.WEST)
          mX -= 0.25D; 
        if (dir == WyHelper.Direction.SOUTH_WEST) {
          mZ += 0.2D;
          mX -= 0.2D;
        } 
        if (dir == WyHelper.Direction.EAST)
          mX += 0.25D; 
        if (dir == WyHelper.Direction.SOUTH_EAST) {
          mZ += 0.2D;
          mX += 0.2D;
        } 
        player.fallDistance = 0.0F;
        KiloAbilities.movePlayer("=", mX, -0.1D, mZ, player);
      } else if (player.getHeldItem() != null && player.getHeldItem().getItem() == ListMisc.Umbrella) {
        int slot = player.inventory.currentItem;
        player.inventory.setInventorySlotContents(slot, new ItemStack((Item)ListMisc.UmbrellaOpen));
      } else {
        replaceUmbrella(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      setPassiveActive(false);
      replaceUmbrella(player);
    }
    
    public void replaceUmbrella(EntityPlayer player) {
      for (int count = 0; count < player.inventory.getSizeInventory(); count++) {
        if (player.inventory.getStackInSlot(count) != null && player.inventory.getStackInSlot(count).getItem() == ListMisc.UmbrellaOpen)
          player.inventory.setInventorySlotContents(count, new ItemStack((Item)ListMisc.Umbrella)); 
      } 
    }
  }
  
  public static class KickOffJump extends Ability {
    private double initialY = 255.0D;
    
    private boolean isFlying = false;
    
    private int countDoon = 0;
    
    public KickOffJump() {
      super(ListAttributes.KICK_OFF_JUMP);
    }
    
    public void passive(EntityPlayer player) {
      if (!this.isOnCooldown) {
        this.initialY = player.posY;
        super.passive(player);
      } 
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (!this.isFlying && player.posY > this.initialY) {
        this.isFlying = true;
      } else if (this.isFlying && this.countDoon <= 10) {
        KiloAbilities.movePlayer("=", player.motionX, 2.5D, player.motionZ, player);
        this.countDoon++;
      } else if (this.isFlying && this.countDoon >= 4) {
        setPassiveActive(false);
        setCooldownActive(true);
        endPassive(player);
      } else if (player.onGround) {
        this.initialY = player.posY;
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      this.countDoon = 0;
      this.isFlying = false;
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class HeavyPunch extends Ability {
    public HeavyPunch() {
      super(ListAttributes.HEAVY_PUNCH);
    }
  }
  
  public static class KiloPress extends Ability {
    private double initialY;
    
    public KiloPress() {
      super(ListAttributes.KILO_PRESS);
    }
    
    public void passive(EntityPlayer player) {
      if (!this.isOnCooldown) {
        AbilityProperties abilityProps = AbilityProperties.get(player);
        KiloAbilities.Weightless weightless = (KiloAbilities.Weightless)abilityProps.getAbilityFromName(ListAttributes.WEIGHTLESS.getAttributeName());
        if (weightless != null && weightless.isPassiveActive()) {
          weightless.endPassive(player);
          WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(abilityProps), (EntityPlayerMP)player);
        } 
        this.initialY = player.posY;
        super.passive(player);
      } 
    }
    
    public void duringPassive(EntityPlayer player, int timer) {
      if (player.onGround) {
        setPassiveActive(false);
        setCooldownActive(true);
        endPassive(player);
      } else {
        KiloAbilities.movePlayer("=", 0.0D, -2.0D, 0.0D, player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      double damage = this.initialY - player.posY;
      if (damage > 0.0D)
        for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)player, 5.0D))
          entity.attackEntityFrom(DamageSource.causePlayerDamage(player), (float)(damage * 0.75D));  
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("kiloPress", player.posX, player.posY, player.posZ), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      startExtUpdate(player);
    }
  }
}
