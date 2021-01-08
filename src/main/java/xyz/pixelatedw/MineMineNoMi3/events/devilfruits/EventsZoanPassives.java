package xyz.pixelatedw.MineMineNoMi3.events.devilfruits;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class EventsZoanPassives {
  @SubscribeEvent
  public void onEntityAttack(LivingHurtEvent event) {
    if (event.source.getSourceOfDamage() instanceof EntityPlayer) {
      EntityPlayer attacker = (EntityPlayer)event.source.getSourceOfDamage();
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)attacker);
      AbilityProperties abilityProps = AbilityProperties.get(attacker);
      EntityLivingBase attacked = event.entityLiving;
      if (props.getUsedFruit().equalsIgnoreCase("ushiushibison") && props.getZoanPoint().equalsIgnoreCase("power"))
        event.ammount += 3.0F; 
      if (props.getUsedFruit().equalsIgnoreCase("zouzou") && props.getZoanPoint().equalsIgnoreCase("hybrid"))
        event.ammount += 3.0F; 
      if (props.getUsedFruit().equalsIgnoreCase("mogumogu") && props.getZoanPoint().equalsIgnoreCase("power"))
        event.ammount += 3.0F; 
    } 
  }
  
  @SubscribeEvent
  public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
    if (event.entityLiving instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)event.entityLiving;
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      AbilityProperties abilityProps = AbilityProperties.get(player);
      ItemStack heldItem = player.getHeldItem();
      if (props.getUsedFruit().equalsIgnoreCase("mogumogu") && props.getZoanPoint().equalsIgnoreCase("power"))
        if (!player.worldObj.isRemote && player.worldObj.getBlockLightValue((int)player.posX, (int)player.posY, (int)player.posZ) < 7)
          player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 300, 1, true));  
      if (props.getZoanPoint().equals("buddha")) {
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 1, true));
        player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 1, true));
        if (player.hurtTime == player.maxHurtTime && player.maxHurtTime > 0) {
          player.motionX *= 0.20000000298023224D;
          player.motionY *= 0.20000000298023224D;
          player.motionZ *= 0.20000000298023224D;
        } 
      } 
      if (props.getZoanPoint().equals("nue"))
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 1, true)); 
      if (props.getZoanPoint().equals("bisupoint")) {
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 1, true));
        player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 300, 2, true));
        if (player.hurtTime == player.maxHurtTime && player.maxHurtTime > 0) {
          player.motionX *= 0.20000000298023224D;
          player.motionY *= 0.20000000298023224D;
          player.motionZ *= 0.20000000298023224D;
        } 
      } 
      if (props.getZoanPoint().equals("wheel"))
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 8, true)); 
      if (props.getZoanPoint().equals("leopard")) {
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 5, true));
        player.addPotionEffect(new PotionEffect(Potion.jump.id, 40, 0, true));
      } 
      if (props.getZoanPoint().equals("ptera")) {
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 6, true));
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 0, true));
      } 
      if (props.getZoanPoint().equals("hybridleopard")) {
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 5, true));
        player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 40, 2, true));
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 0, true));
      } 
      if (props.getZoanPoint().equals("mamouth")) {
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 1, true));
        player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 0, true));
        if (player.hurtTime == player.maxHurtTime && player.maxHurtTime > 0) {
          player.motionX *= 0.20000000298023224D;
          player.motionY *= 0.20000000298023224D;
          player.motionZ *= 0.20000000298023224D;
        } 
      } 
      if (props.getUsedFruit().equals("zouzou")) {
        if (props.getZoanPoint().equals("full")) {
          player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 1, true));
          player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 0, true));
        } 
        if (props.getZoanPoint().equals("hybrid"))
          player.addPotionEffect(new PotionEffect(Potion.resistance.id, 40, 0, true)); 
      } 
      if (props.getUsedFruit().equalsIgnoreCase("ushiushigiraffe"))
        if (props.getZoanPoint().equalsIgnoreCase("speed")) {
          player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 1, true));
          player.addPotionEffect(new PotionEffect(Potion.jump.id, 40, 1, true));
        }  
      if (props.getUsedFruit().equals("ushiushibison"))
        if (props.getZoanPoint().equals("speed")) {
          player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 1, true));
          double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
          double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
          double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
          mX /= f2;
          mZ /= f2;
          mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
          mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
          mX *= 2.0D;
          mZ *= 2.0D;
          for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 0.5D)) {
            e.attackEntityFrom(DamageSource.causePlayerDamage(player), 2.0F);
            e.motionX = mX;
            e.motionZ = mZ;
          } 
        } else {
          player.removePotionEffect(Potion.moveSpeed.id);
        }  
    } 
  }
}
