package xyz.pixelatedw.MineMineNoMi3.soros.buddha;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketNewAABB;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class BudhaBudha {
  static {
    Values.abilityWebAppExtraParams.put("Buddha Point", new String[] { "desc", "Turns you into a Buddha." });
    Values.abilityWebAppExtraParams.put("Impact Wave", new String[] { "desc", "send a big Golden Ball" });
    Values.abilityWebAppExtraParams.put("Impact Wave barrage", new String[] { "desc", "sends 3 impact wave ." });
    Values.abilityWebAppExtraParams.put("Buddha Punch", new String[] { "desc", " a punch move " });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new BuddhaPoint(), new ImpactWave(), new ImpactWaveBarage(), new BuddhaPunch() };
  
  public static class BuddhaPoint extends Ability {
    public BuddhaPoint() {
      super(ListAttributes.BUDDHAPOINT);
    }
    
    public void use(EntityPlayer player) {
      super.use(player);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("buddha")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(1.5F, 2.5F), (EntityPlayerMP)player);
      props.setZoanPoint("buddha");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void endPassive(EntityPlayer player) {
      player.removePotionEffect(Potion.resistance.id);
      player.removePotionEffect(Potion.moveSlowdown.id);
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(0.6F, 1.8F), (EntityPlayerMP)player);
      props.setZoanPoint("n/a");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
  }
  
  public static class ImpactWave extends Ability {
    public ImpactWave() {
      super(ListAttributes.ImpactWaveA);
    }
    
    public void startCharging(EntityPlayer player) {
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("buddha") && !this.isOnCooldown) {
        this.projectile = new BudhaBudhaProjo.ImpactWaveA(player.worldObj, (EntityLivingBase)player, ListAttributes.ImpactWaveA);
        super.endCharging(player);
      } 
    }
  }
  
  public static class ImpactWaveBarage extends Ability {
    public ImpactWaveBarage() {
      super(ListAttributes.ImpactWaveB);
    }
    
    public void startCharging(EntityPlayer player) {
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("buddha") && !this.isOnCooldown) {
        this.projectile = new BudhaBudhaProjo.ImpactWaveB(player.worldObj, (EntityLivingBase)player, ListAttributes.ImpactWaveB);
        super.endCharging(player);
      } 
    }
  }
  
  public static class BuddhaPunch extends Ability {
    public BuddhaPunch() {
      super(ListAttributes.BuddhaPunch);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      super.hitEntity(player, target);
      target.attackEntityFrom(DamageSource.causePlayerDamage(player), 100.0F * props.getDamageMultiplier());
      AbilityExplosion explosion = WyHelper.newExplosion((Entity)player, target.posX, target.posY, target.posZ, 3.0D);
      explosion.setDamageOwner(false);
      explosion.setSmokeParticles("");
      explosion.doExplosion();
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("buddha", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
    }
  }
}
