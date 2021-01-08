package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class HieAbilities {
  static {
    Values.abilityWebAppExtraParams.put("iceblockpartisan", new String[] { "desc", "Creates several spears of ice that the user hurls at the enemy." });
    Values.abilityWebAppExtraParams.put("iceball", new String[] { "desc", "Creates a sphere of ice that surrounds the opponent." });
    Values.abilityWebAppExtraParams.put("iceage", new String[] { "desc", "Freezes a large area around the user and everyone inside of it." });
    Values.abilityWebAppExtraParams.put("icetimecapsule", new String[] { "desc", "A wave of ice is sent along the ground and freezes every enemy it hits." });
    Values.abilityWebAppExtraParams.put("iceblockpheasant", new String[] { "desc", "Releases a massive wave of ice in the shape of a pheasant." });
    Values.abilityWebAppExtraParams.put("icesaber", new String[] { "desc", "Creates a sharp blade made of solid ice." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new IceBlockPartisan(), new IceSaber(), new IceAge(), new IceBall(), new IceTimeCapsule(), new IceBlockPheasant() };
  
  public static class IceSaber extends Ability {
    public IceSaber() {
      super(ListAttributes.ICE_SABER);
    }
    
    public void startPassive(EntityPlayer player) {
      if (player.inventory.getCurrentItem() == null) {
        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack((Item)ListMisc.IceSaber));
      } else {
        WyHelper.sendMsgToPlayer(player, "Cannot equip " + getAttribute().getAttributeName() + " while holding another item in hand !");
        passive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      player.inventory.clearInventory((Item)ListMisc.IceSaber, -1);
    }
  }
  
  public static class IceBlockPartisan extends Ability {
    public IceBlockPartisan() {
      super(ListAttributes.ICE_BLOCK_PARTISAN);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new HieProjectiles.IceBlockPartisan(player.worldObj, (EntityLivingBase)player, ListAttributes.ICE_BLOCK_PARTISAN);
      super.use(player);
    }
  }
  
  public static class IceAge extends Ability {
    public IceAge() {
      super(ListAttributes.ICE_AGE);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        World world = player.worldObj;
        for (EntityLivingBase target : WyHelper.getEntitiesNear((Entity)player, 15.0D)) {
          target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600));
          target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 600));
        } 
        super.use(player);
      } 
    }
  }
  
  public static class IceBall extends Ability {
    public IceBall() {
      super(ListAttributes.ICE_BALL);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new HieProjectiles.IceBall(player.worldObj, (EntityLivingBase)player, ListAttributes.ICE_BALL);
      super.use(player);
    }
  }
  
  public static class IceTimeCapsule extends Ability {
    public IceTimeCapsule() {
      super(ListAttributes.ICE_TIME_CAPSULE);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        if (MainConfig.enableGriefing)
          for (EntityLivingBase l : WyHelper.getEntitiesNear((Entity)player, 25.0D)) {
            WyHelper.createFilledCube((Entity)l, new int[] { 2, 4, 2 }, Blocks.packed_ice, new String[] { "air", "foliage" });
          }  
        super.use(player);
      } 
    }
  }
  
  public static class IceBlockPheasant extends Ability {
    public IceBlockPheasant() {
      super(ListAttributes.ICE_BLOCK_PHEASANT);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new HieProjectiles.IceBlockPheasant(player.worldObj, (EntityLivingBase)player, ListAttributes.ICE_BLOCK_PHEASANT);
      super.use(player);
    }
  }
}
