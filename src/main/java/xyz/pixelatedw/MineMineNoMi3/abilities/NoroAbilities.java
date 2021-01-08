package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.NoroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class NoroAbilities {
  static {
    Values.abilityWebAppExtraParams.put("noronorobeam", new String[] { "desc", "Shoots a beam of photons at the opponent, completely slowing them down." });
    Values.abilityWebAppExtraParams.put("noronorobeamsword", new String[] { "desc", "Focuses photons inside a hilt to create a sword." });
    Values.abilityWebAppExtraParams.put("kyubirush", new String[] { "desc", "While the opponent is slowed, the user delivers a series of punches, which hits the opponent all at once." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new NoroNoroBeam(), new NoroNoroBeamSword(), new KyubiRush() };
  
  public static class NoroNoroBeamSword extends Ability {
    public NoroNoroBeamSword() {
      super(ListAttributes.NORO_NORO_BEAM_SWORD);
    }
    
    public void startPassive(EntityPlayer player) {
      if (player.inventory.getCurrentItem() == null) {
        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack((Item)ListMisc.NoroNoroBeamSword));
      } else {
        WyHelper.sendMsgToPlayer(player, "Cannot equip " + getAttribute().getAttributeName() + " while holding another item in hand !");
        passive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      player.inventory.clearInventory((Item)ListMisc.NoroNoroBeamSword, -1);
    }
  }
  
  public static class KyubiRush extends Ability {
    public KyubiRush() {
      super(ListAttributes.KYUBI_RUSH);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      float damageFromSlowness = 0.0F;
      if (target.isPotionActive(Potion.moveSlowdown.id)) {
        damageFromSlowness = (float)(Math.sqrt(target.getActivePotionEffect(Potion.moveSlowdown).getDuration()) / 2.0D);
        int newTime = target.getActivePotionEffect(Potion.moveSlowdown).getDuration() / 2;
        int newAmplifier = target.getActivePotionEffect(Potion.moveSlowdown).getAmplifier() - 5;
        target.removePotionEffect(Potion.moveSlowdown.id);
        target.removePotionEffect(Potion.digSlowdown.id);
        target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, newTime, newAmplifier));
        target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, newTime, newAmplifier));
      } else {
        damageFromSlowness = 2.0F;
      } 
      super.hitEntity(player, target);
      target.attackEntityFrom(DamageSource.causePlayerDamage(player), damageFromSlowness);
    }
  }
  
  public static class NoroNoroBeam extends Ability {
    public NoroNoroBeam() {
      super(ListAttributes.NORO_NORO_BEAM);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new NoroProjectiles.NoroNoroBeam(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
}
