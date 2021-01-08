package xyz.pixelatedw.MineMineNoMi3.api.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketShounenScream;

public class Ability {
  protected AbilityProjectile projectile;
  
  protected String originalDisplayName = "n/a";
  
  protected AbilityAttribute attr;
  
  protected boolean isOnCooldown = false;
  
  protected boolean isCharging = false;
  
  protected boolean isRepeating = false;
  
  protected boolean passiveActive = false;
  
  protected boolean isDisabled = false;
  
  private int ticksForCooldown;
  
  private int ticksForCharge;
  
  private int ticksForRepeater;
  
  private int ticksForRepeaterFreq;
  
  private int currentSpawn = 0;
  
  public Ability(AbilityAttribute attr) {
    this.attr = new AbilityAttribute(attr);
    this.ticksForCooldown = this.attr.getAbilityCooldown();
    this.ticksForCharge = this.attr.getAbilityCharges();
    this.ticksForRepeater = this.attr.getAbilityCooldown();
    this.ticksForRepeaterFreq = this.attr.getAbilityRepeaterFrequency();
    this.originalDisplayName = this.attr.getAbilityDisplayName();
  }
  
  public AbilityAttribute getAttribute() {
    return this.attr;
  }
  
  public void use(EntityPlayer player) {
    if (!this.isOnCooldown) {
      if (this.projectile != null)
        if (this.attr.isRepeater()) {
          startRepeater(player);
        } else {
          player.worldObj.spawnEntityInWorld((Entity)this.projectile);
        }  
      if (this.attr.getPotionEffectsForUser() != null)
        for (PotionEffect p : this.attr.getPotionEffectsForUser())
          player.addPotionEffect(new PotionEffect(p));  
      if (this.attr.getPotionEffectsForAoE() != null)
        for (PotionEffect p : this.attr.getPotionEffectsForAoE()) {
          for (EntityLivingBase l : WyHelper.getEntitiesNear((Entity)player, this.attr.getEffectRadius()))
            l.addPotionEffect(new PotionEffect(p)); 
        }  
      if (this.attr.getAbilityCharges() <= 0 && this.attr.getAbilityExplosionPower() > 0) {
        AbilityExplosion explosion = WyHelper.newExplosion((Entity)player, player.posX, player.posY, player.posZ, this.attr.getAbilityExplosionPower());
        explosion.setDamageOwner(false);
        explosion.setFireAfterExplosion(this.attr.canAbilityExplosionSetFire());
        explosion.setDestroyBlocks(this.attr.canAbilityExplosionDestroyBlocks());
        explosion.doExplosion();
      } 
      if (!player.capabilities.isCreativeMode)
        WyTelemetry.addAbilityStat(getAttribute().getAbilityTexture(), getAttribute().getAttributeName(), 1); 
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      AbilityProperties abilityProps = AbilityProperties.get(player);
      props.setTempPreviousAbility(WyHelper.getFancyName(this.attr.getAttributeName()));
      if (!this.attr.isPassive())
        sendShounenScream(player); 
      duringRepeater(player);
      startCooldown();
      WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(abilityProps), (EntityPlayerMP)player);
      (new Update(player, this.attr)).start();
    } 
  }
  
  public void duringRepeater(EntityPlayer player) {
    if (this.isRepeating) {
      try {
        if (!player.worldObj.isRemote && this.currentSpawn % this.ticksForRepeaterFreq == 0)
          player.worldObj.spawnEntityInWorld(this.projectile.getClass().getDeclaredConstructor(new Class[] { World.class, EntityLivingBase.class, AbilityAttribute.class }).newInstance(new Object[] { player.worldObj, player, this.attr })); 
      } catch (Exception e) {
        e.printStackTrace();
      } 
      this.currentSpawn++;
    } 
  }
  
  protected void startRepeater(EntityPlayer player) {
    this.isRepeating = true;
  }
  
  public boolean isRepeating() {
    return this.isRepeating;
  }
  
  public void passive(EntityPlayer player) {
    if (!this.isOnCooldown)
      if (this.passiveActive) {
        this.passiveActive = false;
        WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player);
        if (this.attr.getPotionEffectsForUser() != null)
          for (PotionEffect p : this.attr.getPotionEffectsForUser())
            player.removePotionEffect(p.getPotionID());  
        endPassive(player);
      } else {
        this.passiveActive = true;
        WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player);
        if (this.attr.getPotionEffectsForUser() != null)
          for (PotionEffect p : this.attr.getPotionEffectsForUser())
            player.addPotionEffect(new PotionEffect(p.getPotionID(), 2147483647, p.getAmplifier(), true));  
        sendShounenScream(player);
        startPassive(player);
        (new Update(player, this.attr)).start();
      }  
  }
  
  public boolean isDisabled() {
    return this.isDisabled;
  }
  
  public void disable(EntityPlayer player, boolean bool) {
    this.isDisabled = bool;
    WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player);
  }
  
  public void endPassive(EntityPlayer player) {
    if (this.attr.getPotionEffectsForUser() != null)
      for (PotionEffect p : this.attr.getPotionEffectsForUser())
        player.removePotionEffect(p.getPotionID());  
  }
  
  public void startPassive(EntityPlayer player) {}
  
  public void duringPassive(EntityPlayer player, int passiveTimer) {}
  
  public boolean isPassiveActive() {
    return this.passiveActive;
  }
  
  public void setPassiveActive(boolean b) {
    this.passiveActive = b;
  }
  
  public void setChargeActive(boolean b) {
    this.isCharging = b;
  }
  
  public void setCooldownActive(boolean b) {
    this.isOnCooldown = b;
  }
  
  public void duringCharging(EntityPlayer player, int currentCharge) {}
  
  public void startCharging(EntityPlayer player) {
    if (!this.isOnCooldown) {
      sendShounenScream(player, 1);
      this.isCharging = true;
      WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player);
      (new Update(player, this.attr)).start();
    } 
  }
  
  public void endCharging(EntityPlayer player) {
    this.isCharging = false;
    this.isOnCooldown = true;
    if (player instanceof EntityPlayerMP)
      WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player); 
    if (this.projectile != null)
      if (this.attr.isRepeater()) {
        startRepeater(player);
      } else {
        player.worldObj.spawnEntityInWorld((Entity)this.projectile);
      }  
    sendShounenScream(player, 2);
    if (this.attr.getAbilityExplosionPower() > 0)
      player.worldObj.newExplosion((Entity)player, player.posX, player.posY, player.posZ, this.attr.getAbilityExplosionPower(), this.attr.canAbilityExplosionSetFire(), MainConfig.enableGriefing ? this.attr.canAbilityExplosionDestroyBlocks() : false); 
    if (!WyHelper.isDevBuild() && !player.capabilities.isCreativeMode)
      WyTelemetry.addAbilityStat(getAttribute().getAbilityTexture(), getAttribute().getAttributeName(), 1); 
    (new Update(player, this.attr)).start();
  }
  
  public boolean isCharging() {
    return this.isCharging;
  }
  
  public boolean isOnCooldown() {
    return this.isOnCooldown;
  }
  
  public void duringCooldown(EntityPlayer player, int currentCooldown) {}
  
  public void hitEntity(EntityPlayer player, EntityLivingBase target) {
    if (player == target)
      return; 
    if (this.attr.getPotionEffectsForHit() != null)
      for (PotionEffect p : this.attr.getPotionEffectsForHit())
        target.addPotionEffect(new PotionEffect(p.getPotionID(), p.getDuration(), p.getAmplifier(), true));  
    if (this.attr.getAbilityExplosionPower() > 0)
      player.worldObj.newExplosion((Entity)target, target.posX, target.posY, target.posZ, this.attr.getAbilityExplosionPower(), this.attr.canAbilityExplosionSetFire(), MainConfig.enableGriefing ? this.attr.canAbilityExplosionDestroyBlocks() : false); 
    this.passiveActive = false;
    startCooldown();
    WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player);
    target.attackEntityFrom(DamageSource.causePlayerDamage(player), this.attr.getPunchDamage() * ExtendedEntityData.get((EntityLivingBase)player).getDamageMultiplier());
    (new Update(player, this.attr)).start();
  }
  
  protected void startCooldown() {
    this.isOnCooldown = true;
  }
  
  protected void startExtUpdate(EntityPlayer player) {
    WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player);
    (new Update(player, this.attr)).start();
  }
  
  public void startUpdate(EntityPlayer player) {
    setCooldownActive(true);
    if (player instanceof EntityPlayerMP)
      WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(player)), (EntityPlayerMP)player); 
    (new Update(player, this.attr)).start();
  }
  
  protected void sendShounenScream(EntityPlayer player) {
    sendShounenScream(player, 0);
  }
  
  protected void sendShounenScream(EntityPlayer player, int part) {
    if (MainConfig.enableAnimeScreaming)
      WyNetworkHelper.sendToAllAround((IMessage)new PacketShounenScream(player.getCommandSenderName(), this.attr.getAbilityDisplayName(), part), player.dimension, player.posX, player.posY, player.posZ, 15.0D); 
  }
  
  public void reset() {
    this.isOnCooldown = false;
    this.isCharging = false;
    this.isRepeating = false;
    this.passiveActive = false;
  }
  
  class ResetDisable extends Thread {
    private EntityPlayer player;
    
    private ExtendedEntityData props;
    
    private AbilityAttribute attr;
    
    public ResetDisable(EntityPlayer user, AbilityAttribute attribute) {
      this.player = user;
      this.props = ExtendedEntityData.get((EntityLivingBase)this.player);
      this.attr = attribute;
      setName("ResetThread Thread for " + this.attr.getAttributeName());
    }
    
    public void run() {
      while (Ability.this.isDisabled) {
        if (!DevilFruitsHelper.isNearbyKairoseki(this.player)) {
          Ability.this.disable(this.player, false);
          Ability.this.setCooldownActive(false);
          return;
        } 
        try {
          while (true)
            Thread.sleep(24L); 
        } catch (Exception e) {
          e.printStackTrace();
        } 
      } 
    }
    
    private boolean abilityCounterpart(String ablNameForCheck) {
      return WyHelper.getFancyName(this.attr.getAttributeName()).equals(WyHelper.getFancyName(ablNameForCheck));
    }
  }
  
  class Update extends Thread {
    private EntityPlayer player;
    
    private AbilityAttribute attr;
    
    public Update(EntityPlayer user, AbilityAttribute attribute) {
      this.player = user;
      this.attr = attribute;
      setName("Update Thread for " + this.attr.getAttributeName());
      Ability.this.ticksForCooldown = this.attr.getAbilityCooldown();
      Ability.this.ticksForCharge = this.attr.getAbilityCharges();
    }
    
    public void run() {
      if (Ability.this.passiveActive) {
        int passiveTimer = 0;
        while (Ability.this.passiveActive) {
          Ability.this.duringPassive(this.player, passiveTimer++);
          try {
            Thread.sleep(20L);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } 
        } 
      } 
      if (Ability.this.isOnCooldown) {
        while (Ability.this.isOnCooldown) {
          if (Ability.this.ticksForCooldown > 0) {
            Ability.this.ticksForCooldown--;
            if (Ability.this.isRepeating) {
              Ability.this.ticksForRepeater--;
              if (Ability.this.ticksForRepeater <= this.attr.getAbilityCooldown() - this.attr.getAbilityCooldown() / this.attr.getAbilityRepeaterTime() || Ability.this.projectile == null) {
                Ability.this.isRepeating = false;
                Ability.this.ticksForRepeater = this.attr.getAbilityCooldown();
              } 
            } 
            Ability.this.duringCooldown(this.player, Ability.this.ticksForCooldown);
            try {
              Thread.sleep(20L);
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
            continue;
          } 
          Ability.this.ticksForCooldown = this.attr.getAbilityCooldown();
          Ability.this.currentSpawn = 0;
          Ability.this.isOnCooldown = false;
          if (this.player instanceof EntityPlayerMP)
            WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(AbilityProperties.get(this.player)), (EntityPlayerMP)this.player); 
          return;
        } 
      } else if (Ability.this.isCharging) {
        while (Ability.this.isCharging) {
          if (Ability.this.ticksForCharge > 0) {
            Ability.this.ticksForCharge--;
            Ability.this.duringCharging(this.player, Ability.this.ticksForCharge);
            try {
              Thread.sleep(20L);
            } catch (InterruptedException e) {
              e.printStackTrace();
            } 
            continue;
          } 
          Ability.this.ticksForCharge = this.attr.getAbilityCharges();
          Ability.this.endCharging(this.player);
        } 
      } 
    }
  }
}
