package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.DoruProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class DoruAbilities {
  static {
    Values.abilityWebAppExtraParams.put("candlewall", new String[] { "desc", "Creates a wax wall to protect the user." });
    Values.abilityWebAppExtraParams.put("candlehouse", new String[] { "desc", "Creates a big house-like structure made of wax, to protect the user." });
    Values.abilityWebAppExtraParams.put("dorudoruartsmori", new String[] { "desc", "The user fires a harpoon made of wax at the opponent." });
    Values.abilityWebAppExtraParams.put("dorudoruartsken", new String[] { "desc", "The user uses hardened wax to create a sword." });
    Values.abilityWebAppExtraParams.put("candlelock", new String[] { "desc", "Traps the opponent's feet in hardened wax, which makes them unable to move." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new DoruDoruArtsMori(), new DoruDoruArtsKen(), new CandleWall(), new CandleHouse(), new CandleLock() };
  
  public static class CandleLock extends Ability {
    public CandleLock() {
      super(ListAttributes.CANDLE_LOCK);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new DoruProjectiles.CandleLock(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class DoruDoruArtsKen extends Ability {
    public DoruDoruArtsKen() {
      super(ListAttributes.DORU_DORU_ARTS_KEN);
    }
    
    public void startPassive(EntityPlayer player) {
      if (player.inventory.getCurrentItem() == null) {
        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack((Item)ListMisc.DoruDoruArtsKen));
      } else {
        WyHelper.sendMsgToPlayer(player, "Cannot equip " + getAttribute().getAttributeName() + " while holding another item in hand !");
        passive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      player.inventory.clearInventory((Item)ListMisc.DoruDoruArtsKen, -1);
    }
  }
  
  public static class CandleHouse extends Ability {
    public CandleHouse() {
      super(ListAttributes.CANDLE_HOUSE);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (MainConfig.enableGriefing) {
          for (int y = 0; y <= 3; y++) {
            int i;
            for (i = 0; i < 1; i++) {
              for (int z = -5; z < 5; z++)
                player.worldObj.setBlock((int)player.posX + 6 - i, (int)player.posY + y, (int)player.posZ - z, ListMisc.WaxBlock); 
            } 
            for (i = 0; i < 1; i++) {
              for (int z = -5; z < 5; z++)
                player.worldObj.setBlock((int)player.posX - 5 - i, (int)player.posY + y, (int)player.posZ - z, ListMisc.WaxBlock); 
            } 
            for (i = -5; i < 5; i++) {
              for (int z = 0; z < 1; z++)
                player.worldObj.setBlock((int)player.posX - i, (int)player.posY + y, (int)player.posZ + 6 - z, ListMisc.WaxBlock); 
            } 
            for (i = -5; i < 5; i++) {
              for (int z = 0; z < 1; z++)
                player.worldObj.setBlock((int)player.posX - i, (int)player.posY + y, (int)player.posZ - 5 - z, ListMisc.WaxBlock); 
            } 
          } 
          for (int x = -5; x < 5; x++) {
            for (int i = 0; i < 1; i++) {
              for (int z = -5; z < 5; z++)
                player.worldObj.setBlock((int)player.posX - x, (int)player.posY + 4 + i, (int)player.posZ - z, ListMisc.WaxBlock); 
            } 
          } 
        } 
        super.use(player);
      } 
    }
  }
  
  public static class CandleWall extends Ability {
    public CandleWall() {
      super(ListAttributes.CANDLE_WALL);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (MainConfig.enableGriefing) {
          if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.NORTH)
            WyHelper.createFilledCube(player.worldObj, player.posX, player.posY, player.posZ - 3.0D, new int[] { 3, 4, 1 }, ListMisc.WaxBlock, new String[] { "air", "foliage" }); 
          if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.SOUTH)
            WyHelper.createFilledCube(player.worldObj, player.posX, player.posY, player.posZ + 3.0D, new int[] { 3, 4, 1 }, ListMisc.WaxBlock, new String[] { "air", "foliage" }); 
          if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.EAST)
            WyHelper.createFilledCube(player.worldObj, player.posX + 3.0D, player.posY, player.posZ, new int[] { 1, 4, 3 }, ListMisc.WaxBlock, new String[] { "air", "foliage" }); 
          if (WyHelper.get4Directions((Entity)player) == WyHelper.Direction.WEST)
            WyHelper.createFilledCube(player.worldObj, player.posX - 3.0D, player.posY, player.posZ, new int[] { 1, 4, 3 }, ListMisc.WaxBlock, new String[] { "air", "foliage" }); 
        } 
        super.use(player);
      } 
    }
  }
  
  public static class DoruDoruArtsMori extends Ability {
    public DoruDoruArtsMori() {
      super(ListAttributes.DORU_DORU_ARTS_MORI);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new DoruProjectiles.DoruDoruArtsMori(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
}
