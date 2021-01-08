package xyz.pixelatedw.MineMineNoMi3.events.devilfruits;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.Arrays;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSpecialFlying;

public class EventsSpecialFlying {
  @SubscribeEvent
  public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {
    if (event.entityLiving instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)event.entityLiving;
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      AbilityProperties abilityProps = AbilityProperties.get(player);
      Ability abareHimatsuri = abilityProps.getAbilityFromName(ListAttributes.ABARE_HIMATSURI.getAttributeName());
      boolean hasAbareHimatsuri = (props.getUsedFruit().equalsIgnoreCase("zushizushi") && abareHimatsuri != null && abareHimatsuri.isPassiveActive());
      Ability ride = abilityProps.getAbilityFromName(ListAttributes.LightningRide.getAttributeName());
      boolean hasRide = (ride != null && ride.isPassiveActive());
      Ability nupoint = abilityProps.getAbilityFromName(ListAttributes.NuePoint.getAttributeName());
      boolean hasNu = (nupoint != null && nupoint.isPassiveActive());
      boolean hasToriFruit = (props.getUsedFruit().equalsIgnoreCase("toritoriphoenix") && !props.getZoanPoint().toLowerCase().equals("n/a"));
      boolean hasRyuFruit = ((props.getUsedFruit().equalsIgnoreCase("ryuryunomi") && !props.getZoanPoint().toLowerCase().equals("n/a")) || props.getZoanPoint().equalsIgnoreCase("dragon"));
      boolean hasFlyingFruit = Arrays.<String>stream(DevilFruitsHelper.flyingFruits).anyMatch(p -> props.getUsedFruit().equalsIgnoreCase(p));
      if (!player.capabilities.isCreativeMode) {
        if (!event.entityLiving.worldObj.isRemote)
          if ((MainConfig.enableSpecialFlying && hasFlyingFruit && !DevilFruitsHelper.isNearbyKairoseki(player)) || hasRyuFruit || hasToriFruit || hasRide || hasAbareHimatsuri || hasNu) {
            WyNetworkHelper.sendTo((IMessage)new PacketSpecialFlying(true), (EntityPlayerMP)player);
            player.fallDistance = 0.0F;
          } else {
            WyNetworkHelper.sendTo((IMessage)new PacketSpecialFlying(false), (EntityPlayerMP)player);
          }  
        if (player.capabilities.isFlying && player.worldObj.isRemote) {
          double extraOffset = 0.0D;
          ResourceLocation particleToUse = null;
          if (props.getUsedFruit().equalsIgnoreCase("mokumoku")) {
            particleToUse = ID.PARTICLE_ICON_MOKU;
          } else if (props.getUsedFruit().equalsIgnoreCase("gasugasu")) {
            particleToUse = ID.PARTICLE_ICON_GASU;
          } else if (props.getUsedFruit().equalsIgnoreCase("sunasuna")) {
            particleToUse = ID.PARTICLE_ICON_SUNA2;
          } else if (props.getUsedFruit().equalsIgnoreCase("toritoriphoenix")) {
            particleToUse = ID.PARTICLE_ICON_BLUEFLAME;
            extraOffset = 1.0D;
          } 
          if (particleToUse != null)
            for (int i = 0; i < 5; i++) {
              double offsetX = 0.5D - player.worldObj.rand.nextDouble();
              double offsetY = player.worldObj.rand.nextDouble();
              double offsetZ = 0.5D - player.worldObj.rand.nextDouble();
              MainMod.proxy.spawnCustomParticles((Entity)player, (new EntityParticleFX(player.worldObj, particleToUse, player.posX + offsetX, player.posY - 2.0D + offsetY + extraOffset, player.posZ + offsetZ, 0.0D, 0.0D, 0.0D))
                  
                  .setParticleScale(1.3F).setParticleGravity(-0.05F).setParticleAge(5));
            }  
        } 
      } 
    } 
  }
}
