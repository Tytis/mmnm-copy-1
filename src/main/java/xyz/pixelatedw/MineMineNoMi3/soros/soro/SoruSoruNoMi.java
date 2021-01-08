package xyz.pixelatedw.MineMineNoMi3.soros.soro;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffect;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.DFESoru;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class SoruSoruNoMi {
  static {
    Values.abilityWebAppExtraParams.put("Zeus: Lightning Ride", new String[] { "desc", "Lets you fly on the thunder cloud(I have sent the model for it), basically a copy of the move Abare Himatsuri from the zushi zushi no mi but with the cloud instead of a block" });
    Values.abilityWebAppExtraParams.put("Soul Steal", new String[] { "desc", "a copy of buddha punch with the particle i sent that does 40 damage and wither 3 for 15 seconds" });
    Values.abilityWebAppExtraParams.put("Prometheus: Solar Launcher", new String[] { "desc", "Sends Prometheus (Fireball model) at a player and hits them for 250 damage fire for 10 seconds" });
    Values.abilityWebAppExtraParams.put("Zeus: Lightning Rage", new String[] { "desc", "lightning strike on enemies close like thunder storm from ryu" });
    Values.abilityWebAppExtraParams.put("Zeus : Lightning Engulfment", new String[] { "desc", "Sends the thunder cloud model at a player and does 100 damage and gives them slowness 5 for 10 seconds" });
    Values.abilityWebAppExtraParams.put("Prometheus: Fire Spit", new String[] { "desc", "Sends a spam small red spheres at target that do 5 damage each and fire for 5 seconds" });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new SoulSteal(), new SolarLauncher(), new lightningRage(), new LightningEngulfment(), new FireSpit(), new LightningRide() };
  
  public static class LightningEngulfment extends Ability {
    public LightningEngulfment() {
      super(ListAttributes.LightningEngulfment);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new SoruSoruNoMiProjo.Light(player.worldObj, (EntityLivingBase)player, ListAttributes.LightningEngulfment);
      super.use(player);
    }
  }
  
  public static class SoulSteal extends Ability {
    public SoulSteal() {
      super(ListAttributes.SoulSteal);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      super.hitEntity(player, target);
      target.addPotionEffect(new PotionEffect(Potion.wither.id, 2, 300));
      target.attackEntityFrom(DamageSource.causePlayerDamage(player), 50.0F);
      AbilityExplosion explosion = WyHelper.newExplosion((Entity)player, target.posX, target.posY, target.posZ, 3.0D);
      explosion.setDamageOwner(false);
      explosion.setSmokeParticles("");
      explosion.doExplosion();
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("soru", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      player.setHealth(player.getHealth() + 35.0F);
    }
  }
  
  public static class FireSpit extends Ability {
    public FireSpit() {
      super(ListAttributes.FireSpit);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new SoruSoruNoMiProjo.Fire(player.worldObj, (EntityLivingBase)player, ListAttributes.FireSpit);
      super.use(player);
    }
  }
  
  public static class LightningRide extends Ability {
    private DFEffect extra = null;
    
    public LightningRide() {
      super(ListAttributes.LightningRide);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!player.capabilities.isFlying && player.onGround) {
        if (this.extra == null) {
          this.extra = (DFEffect)new DFESoru((EntityLivingBase)player, 99999);
        } else {
          this.extra.forceStop();
          this.extra = null;
        } 
        super.passive(player);
      } else if (!player.onGround) {
        if (this.extra != null) {
          this.extra.forceStop();
          this.extra = null;
        } 
        super.passive(player);
      } 
    }
    
    public void startPassive(EntityPlayer player) {}
    
    public void endPassive(EntityPlayer player) {}
  }
  
  public static class SolarLauncher extends Ability {
    public SolarLauncher() {
      super(ListAttributes.SolarLauncher);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new SoruSoruNoMiProjo.Trunk(player.worldObj, (EntityLivingBase)player, ListAttributes.SolarLauncher);
      super.use(player);
    }
  }
  
  public static class lightningRage extends Ability {
    private int particlesSpawned = 0;
    
    public lightningRage() {
      super(ListAttributes.lightningRage);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown)
        for (EntityLivingBase ent : WyHelper.getEntitiesNear((Entity)player, 30.0D)) {
          WyNetworkHelper.sendToAll((IMessage)new PacketPlayer("ECLAIR", ent.posX, ent.posY, ent.posZ));
          AbilityExplosion explosion = WyHelper.newExplosion((Entity)ent, ent.posX, ent.posY, ent.posZ, 5.0D);
          explosion.setDamageOwner(false);
          explosion.setFireAfterExplosion(true);
          explosion.setDestroyBlocks(true);
          explosion.doExplosion();
        }  
      super.use(player);
    }
  }
}
