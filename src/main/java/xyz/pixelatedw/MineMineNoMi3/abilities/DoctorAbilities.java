package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketBrokenItemParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class DoctorAbilities {
  public static final Ability FIRST_AID = new FirstAid();
  
  public static final Ability MEDIC_BAG_EXPLOSION = new MedicBagExplosion();
  
  public static final Ability FAILED_EXPERIMENT = new FailedExperiment();
  
  public static Ability[] abilitiesArray = new Ability[] { FIRST_AID, MEDIC_BAG_EXPLOSION, FAILED_EXPERIMENT };
  
  public static class FailedExperiment extends Ability {
    public FailedExperiment() {
      super(ListAttributes.FAILED_EXPERIMENT);
    }
    
    public void startCharging(EntityPlayer player) {
      if (isOnCooldown())
        return; 
      if (player.getCurrentArmor(2) == null || player.getCurrentArmor(2).getItem() != ListMisc.MedicBag) {
        WyHelper.sendMsgToPlayer(player, "You need a medic bag equipped to use this ability !");
        return;
      } 
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      EntityPotion entitypotion = new EntityPotion(player.worldObj, (EntityLivingBase)player, 32732);
      entitypotion.rotationPitch -= -20.0F;
      int potionType = (int)WyMathHelper.randomWithRange(0, 3);
      switch (potionType) {
        case 0:
          entitypotion.setPotionDamage(32698);
          break;
        case 1:
          entitypotion.setPotionDamage(32660);
          break;
        case 2:
          entitypotion.setPotionDamage(32696);
          break;
      } 
      player.worldObj.spawnEntityInWorld((Entity)entitypotion);
      int damage = (player.getCurrentArmor(2).getItemDamage() + 10 <= player.getCurrentArmor(2).getMaxDamage()) ? 10 : (player.getCurrentArmor(2).getMaxDamage() - player.getCurrentArmor(2).getItemDamage());
      player.getCurrentArmor(2).damageItem(damage, (EntityLivingBase)player);
      if (player.getCurrentArmor(2).getItemDamage() >= player.getCurrentArmor(2).getMaxDamage()) {
        WyNetworkHelper.sendTo((IMessage)new PacketBrokenItemParticles(player.getCurrentArmor(2)), (EntityPlayerMP)player);
        WyHelper.removeStackFromArmorSlots(player, player.getCurrentArmor(2));
      } 
      super.endCharging(player);
    }
  }
  
  public static class MedicBagExplosion extends Ability {
    public MedicBagExplosion() {
      super(ListAttributes.MEDIC_BAG_EXPLOSION);
    }
    
    public void use(EntityPlayer player) {
      if (isOnCooldown())
        return; 
      if (player.getCurrentArmor(2) == null || player.getCurrentArmor(2).getItem() != ListMisc.MedicBag) {
        WyHelper.sendMsgToPlayer(player, "You need a medic bag equipped to use this ability !");
        return;
      } 
      player.setHealth(player.getMaxHealth());
      for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)player, 10.0D)) {
        int effect = (int)WyMathHelper.randomWithRange(0, 6);
        switch (effect) {
          case 0:
            entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 1));
          case 1:
            entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 1));
          case 2:
            entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200, 1));
          case 3:
            entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 1));
          case 4:
            entity.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1));
          case 5:
            entity.addPotionEffect(new PotionEffect(Potion.wither.id, 200, 1));
          case 6:
            entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 1));
        } 
      } 
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("medicBagExplosion", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      int damage = (player.getCurrentArmor(2).getItemDamage() + 100 <= player.getCurrentArmor(2).getMaxDamage()) ? 100 : (player.getCurrentArmor(2).getMaxDamage() - player.getCurrentArmor(2).getItemDamage());
      player.getCurrentArmor(2).damageItem(damage, (EntityLivingBase)player);
      if (player.getCurrentArmor(2).getItemDamage() >= player.getCurrentArmor(2).getMaxDamage()) {
        WyNetworkHelper.sendTo((IMessage)new PacketBrokenItemParticles(player.getCurrentArmor(2)), (EntityPlayerMP)player);
        WyHelper.removeStackFromArmorSlots(player, player.getCurrentArmor(2));
      } 
      super.use(player);
    }
  }
  
  public static class FirstAid extends Ability {
    public FirstAid() {
      super(ListAttributes.FIRST_AID);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      if (player.getCurrentArmor(2) == null || player.getCurrentArmor(2).getItem() != ListMisc.MedicBag) {
        WyHelper.sendMsgToPlayer(player, "You need a medic bag equipped to use this ability !");
        return;
      } 
      target.setHealth(target.getHealth() + 10.0F);
      AbilityExplosion explosion = WyHelper.newExplosion((Entity)player, target.posX, target.posY, target.posZ, 2.0D);
      explosion.setExplosionSound(false);
      explosion.setDamageOwner(false);
      explosion.setDestroyBlocks(false);
      explosion.setDamageEntities(false);
      explosion.setSmokeParticles("firstAid");
      explosion.doExplosion();
      int damage = (player.getCurrentArmor(2).getItemDamage() + 10 <= player.getCurrentArmor(2).getMaxDamage()) ? 10 : (player.getCurrentArmor(2).getMaxDamage() - player.getCurrentArmor(2).getItemDamage());
      player.getCurrentArmor(2).damageItem(damage, (EntityLivingBase)player);
      if (player.getCurrentArmor(2).getItemDamage() >= player.getCurrentArmor(2).getMaxDamage()) {
        WyNetworkHelper.sendTo((IMessage)new PacketBrokenItemParticles(player.getCurrentArmor(2)), (EntityPlayerMP)player);
        WyHelper.removeStackFromArmorSlots(player, player.getCurrentArmor(2));
      } 
      super.hitEntity(player, target);
    }
  }
}
