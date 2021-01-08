package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.abilities.CyborgAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.FishKarateAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.events.customevents.EventBounty;
import xyz.pixelatedw.MineMineNoMi3.events.customevents.EventDoriki;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class EventsOnGain {
  @SubscribeEvent
  public void onDorikiGained(EventDoriki event) {
    if (event.props.isHuman()) {
      gainAbility(event.player, 500, RokushikiAbilities.SORU, false);
      gainAbility(event.player, 1500, RokushikiAbilities.TEKKAI, false);
      gainAbility(event.player, 3000, RokushikiAbilities.SHIGAN, false);
      gainAbility(event.player, 4500, RokushikiAbilities.GEPPO, false);
      gainAbility(event.player, 6000, RokushikiAbilities.KAMIE, false);
      gainAbility(event.player, 8500, RokushikiAbilities.RANKYAKU, false);
    } else if (event.props.isFishman()) {
      gainAbility(event.player, 800, FishKarateAbilities.UCHIMIZU, false);
      gainAbility(event.player, 2000, FishKarateAbilities.MURASAME, false);
      gainAbility(event.player, 2500, FishKarateAbilities.KACHIAGE_HAISOKU, false);
      gainAbility(event.player, 3000, FishKarateAbilities.SAMEHADA_SHOTEI, false);
      gainAbility(event.player, 7500, FishKarateAbilities.KARAKUSAGAWARA_SEIKEN, false);
    } else if (event.props.isCyborg()) {
      gainAbility(event.player, 0, CyborgAbilities.FRESH_FIRE, false);
      gainAbility(event.player, 0, CyborgAbilities.COLA_OVERDRIVE, false);
      gainAbility(event.player, 0, CyborgAbilities.STRONG_RIGHT, false);
      gainAbility(event.player, 0, CyborgAbilities.RADICAL_BEAM, false);
      gainAbility(event.player, 0, CyborgAbilities.COUP_DE_VENT, false);
    } 
    if (event.player != null && MainConfig.enableExtraHearts) {
      IAttributeInstance maxHp = event.player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
      if (event.props.getDoriki() / 100 <= 20) {
        event.player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
      } else {
        event.player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((event.props.getDoriki() / 100));
      } 
    } 
  }
  
  private void gainAbility(EntityPlayer player, int doriki, Ability ability, boolean isHaki) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    AbilityProperties abilityProps = AbilityProperties.get(player);
    if (isHaki) {
      if (props.getDoriki() >= doriki && !abilityProps.hasHakiAbility(ability) && !DevilFruitsHelper.verifyIfAbilityIsBanned(ability))
        abilityProps.addHakiAbility(ability); 
      if ((props.getDoriki() < doriki || DevilFruitsHelper.verifyIfAbilityIsBanned(ability)) && abilityProps.hasHakiAbility(ability))
        abilityProps.removeHakiAbility(ability); 
    } else {
      if (props.getDoriki() >= doriki && !abilityProps.hasRacialAbility(ability) && !DevilFruitsHelper.verifyIfAbilityIsBanned(ability))
        abilityProps.addRacialAbility(ability); 
      if ((props.getDoriki() < doriki || DevilFruitsHelper.verifyIfAbilityIsBanned(ability)) && abilityProps.hasRacialAbility(ability))
        abilityProps.removeRacialAbility(ability); 
    } 
  }
  
  @SubscribeEvent
  public void onEntityDeath(LivingDeathEvent event) {
    if (event.entity instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)event.entity;
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      AbilityProperties abilityProps = AbilityProperties.get(player);
      for (int i = 0; i < 8; i++) {
        if (abilityProps.getAbilityFromSlot(i) != null)
          abilityProps.getAbilityFromSlot(i).reset(); 
      } 
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
    } 
    if (event.source.getEntity() instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)event.source.getEntity();
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      EntityLivingBase target = event.entityLiving;
      IAttributeInstance attrAtk = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage);
      IAttributeInstance attrHP = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth);
      int rng = player.worldObj.rand.nextInt(3) + 1;
      int plusBelly = 0;
      long plusBounty = 0L;
      double plusDoriki = 0.0D;
      boolean targetPlayer = false;
      if (target instanceof EntityPlayer) {
        ExtendedEntityData targetprops = ExtendedEntityData.get(target);
        plusDoriki = (targetprops.getDoriki() / 4 + rng);
        plusBounty = targetprops.getBounty() / 2L + rng;
        plusBelly = targetprops.getBelly();
        targetPlayer = true;
      } else {
        if (props.isMarine() && target instanceof xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData)
          return; 
        if (target instanceof EntityNewMob) {
          EntityNewMob entity = (EntityNewMob)target;
          if (props.getDoriki() / 100 > entity.getDoriki()) {
            if (MainConfig.enableMinimumDorikiPerKill)
              plusDoriki = 1.0D; 
          } else {
            plusDoriki = entity.getDoriki();
          } 
          plusDoriki *= MainConfig.modifierDorikiReward;
          plusBounty = (entity.getDoriki() * 2 + rng);
          plusBelly = entity.getBelly() + rng;
          if (!player.worldObj.isRemote && !player.capabilities.isCreativeMode)
            WyTelemetry.addKillStat(WyHelper.getFancyName(target.getClass().getSimpleName()).replace("entity", ""), target.getClass().getSimpleName().replace("Entity", ""), 1); 
        } else if (attrAtk != null && attrHP != null) {
          double i = attrAtk.getAttributeValue();
          double j = attrHP.getAttributeValue();
          plusDoriki = ((int)Math.round((i + j) / 10.0D / Math.PI) + rng);
          plusBounty = ((int)Math.round((i + j) / 10.0D) + rng);
          plusBelly = 1;
          plusDoriki *= MainConfig.modifierDorikiReward;
        } else {
          plusDoriki = 0.0D;
          plusBounty = 0L;
          plusBelly = 1;
        } 
        if (plusDoriki > 0.0D)
          if (props.getDoriki() + plusDoriki <= 12500.0D) {
            props.alterDoriki((int)Math.round(plusDoriki));
            EventDoriki e = new EventDoriki(player);
            if (MinecraftForge.EVENT_BUS.post((Event)e))
              return; 
          }  
        if ((props.isPirate() || props.isRevolutionary()) && 
          plusBounty > 0L && 
          props.getBounty() + plusBounty < 999999999L) {
          props.alterBounty(plusBounty);
          EventBounty e = new EventBounty(player, plusBounty);
          if (MinecraftForge.EVENT_BUS.post((Event)e))
            return; 
        } 
        if (props.getBelly() + plusBelly < 999999999)
          props.alterBelly(plusBelly); 
      } 
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
    } 
  }
}
