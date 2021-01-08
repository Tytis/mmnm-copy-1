package xyz.pixelatedw.MineMineNoMi3.soros;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class MochiMochiNoMiAbilities {
  static {
    Values.abilityWebAppExtraParams.put("Mochi Boru", new String[] { "desc", "Give slowness to the target." });
    Values.abilityWebAppExtraParams.put("Mochi San-Boru", new String[] { "desc", "Same as Mochi ball but send 3 balls." });
    Values.abilityWebAppExtraParams.put("Sutorimu Mochi", new String[] { "desc", "sends a continuous line of mochi balls for 4-5 seconds." });
    Values.abilityWebAppExtraParams.put("Kaku Mochi", new String[] { "desc", "Sends 1 large white mochi balls into the opponent." });
    Values.abilityWebAppExtraParams.put("Mochi Gatling", new String[] { "desc", "Sends 1 large white mochi balls into the opponent." });
    Values.abilityWebAppExtraParams.put("Chikara Mochi", new String[] { "desc", "Sends 1 large mochif fist." });
    Values.abilityWebAppExtraParams.put("Wheel Dash", new String[] { "desc", "Turn to a wheel and dash" });
  }
  
  public static final Ability MochiBall = new MochiBall();
  
  public static final Ability MochiStream = new MochiStream();
  
  public static final Ability Rocket = new Rocket();
  
  public static final Ability Gatling = new MochiNoGatling();
  
  public static final Ability Chikara = new ChikaraMochi();
  
  public static final Ability Wheel = new WheelDash();
  
  public static final Ability YakiMochi = new YakiMochi();
  
  public static Ability[] abilitiesArray = new Ability[] { Wheel, MochiBall, MochiStream, Rocket, Gatling, Chikara, YakiMochi };
  
  public static class YakiMochi extends Ability {
    public YakiMochi() {
      super(ListAttributes.YakiMochi);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new MochiMochiNoMiProjectiles.YAKI(player.worldObj, (EntityLivingBase)player, ListAttributes.YakiMochi);
      super.use(player);
    }
  }
  
  public static class MochiBall extends Ability {
    public MochiBall() {
      super(ListAttributes.MOCHIBALL);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new MochiMochiNoMiProjectiles.MochiBall(player.worldObj, (EntityLivingBase)player, ListAttributes.MOCHIBALL);
      super.use(player);
    }
  }
  
  public static class Barrage extends Ability {
    public int repeater = 0;
    
    public Barrage() {
      super(ListAttributes.MOCHIBARAGE);
    }
    
    public void duringRepeater(EntityPlayer player) {
      super.duringRepeater(player);
      if (this.repeater % 2 == 0) {
        player.rotationYaw += 10.0F;
      } else {
        player.rotationYaw -= 20.0F;
      } 
      this.repeater++;
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new MochiMochiNoMiProjectiles.MochiBall(player.worldObj, player.posX, player.posY, player.posZ);
      this.projectile = new MochiMochiNoMiProjectiles.MochiBall(player.worldObj, player.posX + 7.0D, player.posY, player.posZ + 7.0D);
      this.projectile = new MochiMochiNoMiProjectiles.MochiBall(player.worldObj, player.posX - 7.0D, player.posY, player.posZ - 7.0D);
      super.use(player);
    }
  }
  
  public static class MochiStream extends Ability {
    public MochiStream() {
      super(ListAttributes.BuzzMochi);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new MochiMochiNoMiProjectiles.BuzzMochi(player.worldObj, (EntityLivingBase)player, ListAttributes.BuzzMochi);
      super.use(player);
    }
  }
  
  public static class Rocket extends Ability {
    public Rocket() {
      super(ListAttributes.MOCHIROCKET);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new MochiMochiNoMiProjectiles.MochiRocket(player.worldObj, (EntityLivingBase)player, ListAttributes.MOCHIROCKET);
      super.use(player);
    }
  }
  
  public static class MochiNoGatling extends Ability {
    public MochiNoGatling() {
      super(ListAttributes.MOCHIGATLING);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
        int type = 1;
        int projectileSpace = 3;
        if (MainConfig.enableAnimeScreaming)
          this.attr.setAbilityDisplayName("Mochi Gatling"); 
        this.attr.setAbilityCooldown(2.0D);
        for (int j = 0; j < 25; j++) {
          AbilityProjectile proj = new MochiMochiNoMiProjectiles.MochiGatling(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.MOCHIGATLING);
          proj.setLocationAndAngles(player.posX + 
              WyMathHelper.randomWithRange(-projectileSpace, projectileSpace) + player.worldObj.rand.nextDouble(), player.posY + 0.3D + 
              WyMathHelper.randomWithRange(0, projectileSpace) + player.worldObj.rand.nextDouble(), player.posZ + 
              WyMathHelper.randomWithRange(-projectileSpace, projectileSpace) + player.worldObj.rand.nextDouble(), 0.0F, 0.0F);
          player.worldObj.spawnEntityInWorld((Entity)proj);
        } 
        super.use(player);
      } 
    }
  }
  
  public static class WheelDash extends Ability {
    public WheelDash() {
      super(ListAttributes.WHEELDASH);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("wheel")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("wheel");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setZoanPoint("n/a");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
  }
  
  public static class ChikaraMochi extends Ability {
    public ChikaraMochi() {
      super(ListAttributes.ChikaraMochi);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = new MochiMochiNoMiProjectiles.ChikaraMochi(player.worldObj, (EntityLivingBase)player, ListAttributes.ChikaraMochi);
      super.use(player);
    }
  }
}
