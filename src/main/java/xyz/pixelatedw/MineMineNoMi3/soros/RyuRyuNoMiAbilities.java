package xyz.pixelatedw.MineMineNoMi3.soros;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class RyuRyuNoMiAbilities {
  public static boolean isDragon = false;
  
  static {
    Values.abilityWebAppExtraParams.put("Dragon Point", new String[] { "desc", "Turns you into a dragon." });
    Values.abilityWebAppExtraParams.put("Boro Breath", new String[] { "desc", "Sends a large Laser beam out of the dragons mouth" });
    Values.abilityWebAppExtraParams.put("Fire Breath", new String[] { "desc", "sends 3 fire balls ." });
    Values.abilityWebAppExtraParams.put("Dragon Scale", new String[] { "desc", "Gives Resistance 3 for 10 seconds." });
    Values.abilityWebAppExtraParams.put("Thunder Storm", new String[] { "desc", "Makes a bunch of thunder  rain from the sky." });
    Values.abilityWebAppExtraParams.put("kamaitachi", new String[] { "desc", "Makes a bunch of thunder  rain from the sky." });
  }
  
  public static final Ability DragonPoint = new DragonPoint();
  
  public static final Ability BoroBreath = new BoroBreathClass();
  
  public static final Ability FireBreath = new FireBreath();
  
  public static final Ability ThunderStorm = new ThunderStorm();
  
  public static final Ability kamaitachi = new kamaitachi();
  
  public static Ability[] abilitiesArray = new Ability[] { DragonPoint, BoroBreath, FireBreath, ThunderStorm, kamaitachi };
  
  public static class DragonPoint extends Ability {
    public DragonPoint() {
      super(ListAttributes.DRAGONPOINT);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("dragon")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("dragon");
      RyuRyuNoMiAbilities.isDragon = true;
      player.capabilities.allowFlying = true;
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setZoanPoint("n/a");
      RyuRyuNoMiAbilities.isDragon = false;
      player.capabilities.allowFlying = false;
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
  }
  
  public static class BoroBreathClass extends Ability {
    public static boolean renderLaser = false;
    
    public BoroBreathClass() {
      super(ListAttributes.BOROBREATH);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("dragon") && !this.isOnCooldown) {
        this.projectile = new RyuRyuNoMiProjectiles.BoroBreath(player.worldObj, (EntityLivingBase)player, ListAttributes.BOROBREATH);
        super.use(player);
      } 
    }
  }
  
  public static class kamaitachi extends Ability {
    public static boolean renderLaser = false;
    
    public kamaitachi() {
      super(ListAttributes.kamaitachi);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("dragon") && !this.isOnCooldown) {
        this.projectile = new RyuRyuNoMiProjectiles.kamaitachi(player.worldObj, (EntityLivingBase)player, ListAttributes.kamaitachi);
        super.use(player);
      } 
    }
  }
  
  public static class FireBreath extends Ability {
    public FireBreath() {
      super(ListAttributes.FIRE_BREATH);
    }
    
    public void startCharging(EntityPlayer player) {
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equals("dragon") && !this.isOnCooldown) {
        this.projectile = new RyuRyuNoMiProjectiles.FireBall(player.worldObj, (EntityLivingBase)player, ListAttributes.FIRE_BREATH);
        super.endCharging(player);
      } 
    }
  }
  
  public static class ThunderStorm extends Ability {
    public ThunderStorm() {
      super(ListAttributes.ThunderStorm);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().equalsIgnoreCase("dragon") && !this.isOnCooldown)
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
