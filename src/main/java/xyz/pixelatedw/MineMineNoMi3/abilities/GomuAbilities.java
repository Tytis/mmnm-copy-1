package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GomuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class GomuAbilities {
  static {
    Values.abilityWebAppExtraParams.put("gomugomunopistol", new String[] { "desc", "The user stretches their arm to hit the opponent." });
    Values.abilityWebAppExtraParams.put("gomugomunobazooka", new String[] { "desc", "The user stretches their arms to send the opponent flying by hitting them with both palms" });
    Values.abilityWebAppExtraParams.put("gearsecond", new String[] { "desc", "By speding up their blood flow, the user gains strength, speed and mobility." });
    Values.abilityWebAppExtraParams.put("gearthird", new String[] { "desc", "By blowing air and inflating their body, the user's attacks get bigger and gain incredible strength." });
    Values.abilityWebAppExtraParams.put("gearforth", new String[] { "desc", "The user inflates their muscle structure to tremendously increase the power of their attacks." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new GomuGomuNoPistol(), new GomuGomuNoBazooka(), new GomuGomuNoRocket(), new GomuGomuNoGatling(), new GearSecond(), new GearThird(), new GearForth() };
  
  public static class GearForth extends Ability {
    public GearForth() {
      super(ListAttributes.GEAR_FOURTH);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      AbilityProperties abilityProps = AbilityProperties.get(player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("luffy"))) {
        if (!abilityProps.hasHakiAbility(HakiAbilities.BUSOSHOKU_HAKI_HARDENING)) {
          WyHelper.sendMsgToPlayer(player, "You must have Bososhoku Haki to use Gomu Gear 4");
          return;
        } 
        super.passive(player);
      } 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("luffy");
      props.setGear(4);
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      player.addPotionEffect(new PotionEffect(Potion.jump.id, 25, 2, false));
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("gearSecond", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      if (passiveTimer >= 1200) {
        props.setGear(1);
        props.setZoanPoint("n/a");
        WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
        WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
        setPassiveActive(false);
        use(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setZoanPoint("n/a");
      props.setGear(1);
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
      use(player);
    }
  }
  
  public static class GearThird extends Ability {
    public GearThird() {
      super(ListAttributes.GEAR_THIRD);
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setGear(3);
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (passiveTimer >= 1200) {
        props.setGear(1);
        WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
        setPassiveActive(false);
        use(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setGear(1);
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      use(player);
    }
  }
  
  public static class GearSecond extends Ability {
    public GearSecond() {
      super(ListAttributes.GEAR_SECOND);
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setGear(2);
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 6, false));
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("gearSecond", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      if (passiveTimer >= 1200) {
        props.setGear(1);
        WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
        setPassiveActive(false);
        use(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      props.setGear(1);
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      use(player);
    }
  }
  
  public static class GomuGomuNoGatling extends Ability {
    public GomuGomuNoGatling() {
      super(ListAttributes.GOMU_GOMU_NO_GATLING);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
        int type = 0;
        int projectileSpace = 3;
        switch (props.getGear()) {
          case 1:
            type = 0;
            if (MainConfig.enableAnimeScreaming)
              this.attr.setAbilityDisplayName("Gomu Gomu no Gatling"); 
            this.attr.setAbilityCooldown(5.0D);
            this.attr.setProjectileDamage(45.0F);
            break;
          case 2:
            type = 1;
            if (MainConfig.enableAnimeScreaming)
              this.attr.setAbilityDisplayName("Gomu Gomu no Jet Gatling"); 
            this.attr.setAbilityCooldown(5.0D);
            this.attr.setProjectileDamage(65.0F);
            break;
          case 3:
            type = 2;
            projectileSpace = 7;
            if (MainConfig.enableAnimeScreaming)
              this.attr.setAbilityDisplayName("Gomu Gomu no Elephant Gatling"); 
            this.attr.setAbilityCooldown(5.0D);
            this.attr.setProjectileDamage(100.0F);
            break;
          case 4:
            type = 3;
            projectileSpace = 7;
            if (MainConfig.enableAnimeScreaming)
              this.attr.setAbilityDisplayName("Gomu Gomu no Kong Organ"); 
            this.attr.setAbilityCooldown(5.0D);
            this.attr.setProjectileDamage(180.0F);
            break;
        } 
        for (int j = 0; j < 25; j++) {
			AbilityProjectile proj = null;
			if(type == 0)
				proj = new GomuProjectiles.GomuGomuNoGatling(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_GATLING);
			else if(type == 1)
				proj = new GomuProjectiles.GomuGomuNoJetGatling(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_JET_GATLING);
			else if(type == 2)
				proj = new GomuProjectiles.GomuGomuNoElephantGatling(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_ELEPHANT_GATLING);
			else if(type == 3)
				proj = new GomuProjectiles.GomuGomuNoKongOrgan(player.worldObj, player, ListExtraAttributes.GOMU_GOMU_NO_KONG_ORGAN);
			
			proj.setLocationAndAngles(
					player.posX + WyMathHelper.randomWithRange(-projectileSpace, projectileSpace) + player.worldObj.rand.nextDouble(), 
					(player.posY + 0.3) + WyMathHelper.randomWithRange(0, projectileSpace) + player.worldObj.rand.nextDouble(), 
					player.posZ + WyMathHelper.randomWithRange(-projectileSpace, projectileSpace) + player.worldObj.rand.nextDouble(), 
					0, 0);
			player.worldObj.spawnEntityInWorld(proj);
        } 
        super.use(player);
      } 
    }
  }
  
  public static class GomuGomuNoRocket extends Ability {
    public GomuGomuNoRocket() {
      super(ListAttributes.GOMU_GOMU_NO_ROCKET);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoRocket(player.worldObj, (EntityLivingBase)player, ListAttributes.GOMU_GOMU_NO_ROCKET);
      super.use(player);
    }
  }
  
  public static class GomuGomuNoBazooka extends Ability {
    public GomuGomuNoBazooka() {
      super(ListAttributes.GOMU_GOMU_NO_BAZOOKA);
    }
    
    public void startCharging(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (MainConfig.enableAnimeScreaming)
        switch (props.getGear()) {
          case 1:
            this.attr.setAbilityDisplayName("Gomu Gomu no Bazooka");
            break;
          case 2:
            this.attr.setAbilityDisplayName("Gomu Gomu no Jet Bazooka");
            this.attr.setProjectileDamage(60.0F);
            break;
          case 3:
            this.attr.setAbilityDisplayName("Gomu Gomu no Grizzly Magnum");
            this.attr.setProjectileDamage(75.0F);
            break;
          case 4:
            this.attr.setAbilityDisplayName("Gomu Gomu no Leo Bazooka");
            this.attr.setProjectileDamage(160.0F);
            break;
        }  
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      switch (props.getGear()) {
        case 1:
          this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoBazooka(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.GOMU_GOMU_NO_BAZOOKA);
          this.attr.setAbilityCooldown(12.0D);
          this.attr.setProjectileDamage(40.0F);
          this.attr.setAbilityCharges(18);
          break;
        case 2:
          this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoJetBazooka(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.GOMU_GOMU_NO_JET_BAZOOKA);
          this.attr.setAbilityCooldown(6.0D);
          this.attr.setAbilityCharges(13);
          this.attr.setProjectileDamage(40.0F);
          break;
        case 3:
          this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoGrizzlyMagnum(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.GOMU_GOMU_NO_GRIZZLY_MAGNUM);
          this.attr.setAbilityCooldown(20.0D);
          this.attr.setAbilityCharges(40);
          this.attr.setProjectileDamage(40.0F);
          break;
        case 4:
          this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoLeoBazooka(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.GOMU_GOMU_NO_LEO_BAZOOKA);
          this.attr.setAbilityCooldown(30.0D);
          this.attr.setProjectileDamage(40.0F);
          this.attr.setAbilityCharges(40);
          break;
      } 
      super.endCharging(player);
    }
  }
  
  public static class GomuGomuNoPistol extends Ability {
    public GomuGomuNoPistol() {
      super(ListAttributes.GOMU_GOMU_NO_PISTOL);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      switch (props.getGear()) {
        case 1:
          if (MainConfig.enableAnimeScreaming)
            this.attr.setAbilityDisplayName("Gomu Gomu no Pistol"); 
          this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoPistol(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.GOMU_GOMU_NO_PISTOL);
          this.attr.setAbilityCooldown(8.0D);
          this.attr.setProjectileDamage(20.0F);
          break;
        case 2:
          if (MainConfig.enableAnimeScreaming)
            this.attr.setAbilityDisplayName("Gomu Gomu no Jet Pistol"); 
          this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoJetPistol(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.GOMU_GOMU_NO_JET_PISTOL);
          this.attr.setAbilityCooldown(5.0D);
          this.attr.setProjectileDamage(40.0F);
          break;
        case 3:
          if (MainConfig.enableAnimeScreaming)
            this.attr.setAbilityDisplayName("Gomu Gomu no Elephant Gun"); 
          this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoElephantGun(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.GOMU_GOMU_NO_ELEPHANT_GUN);
          this.attr.setAbilityCooldown(15.0D);
          this.attr.setProjectileDamage(65.0F);
          break;
        case 4:
          if (MainConfig.enableAnimeScreaming)
            this.attr.setAbilityDisplayName("Gomu Gomu no Kong Gun"); 
          this.projectile = (AbilityProjectile)new GomuProjectiles.GomuGomuNoKongGun(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.GOMU_GOMU_NO_KONG_GUN);
          this.attr.setAbilityCooldown(30.0D);
          this.attr.setProjectileDamage(120.0F);
          break;
      } 
      super.use(player);
    }
  }
}
