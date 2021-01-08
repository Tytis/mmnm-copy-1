package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.DokuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketNewAABB;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class DokuAbilities {
  static {
    Values.abilityWebAppExtraParams.put("hydra", new String[] { "desc", "Launches a dragon made out of liqiud poison at the opponent." });
    Values.abilityWebAppExtraParams.put("chloroball", new String[] { "desc", "The user spits a bubble made of poison towards the enemy, which leaves poison on the ground." });
    Values.abilityWebAppExtraParams.put("dokufugu", new String[] { "desc", "Shoots multiple poisonous bullets at the opponent." });
    Values.abilityWebAppExtraParams.put("dokugumo", new String[] { "desc", "Creates a dense cloud of poisonous smoke, which moves along with the user and poisons and blinds everyone inside." });
    Values.abilityWebAppExtraParams.put("venomroad", new String[] { "desc", "The user fires a Hydra at the target location and transports there through its path." });
    Values.abilityWebAppExtraParams.put("venomdemon", new String[] { "desc", "The user coats himself in layers of strong corrosive venom, becoming a Venom Demon and leaving a highly poisonou trail." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new Hydra(), new ChloroBall(), new DokuFugu(), new VenomRoad(), new DokuGumo(), new VenomDemon() };
  
  public static class DokuGumo extends Ability {
    public DokuGumo() {
      super(ListAttributes.DOKU_GUMO);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (passiveTimer > 400) {
        setPassiveActive(false);
        startCooldown();
        startExtUpdate(player);
      } 
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("dokuGumo", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      for (EntityLivingBase enemy : WyHelper.getEntitiesNear((Entity)player, 10.0D)) {
        if (!enemy.isPotionActive(Potion.blindness.id))
          enemy.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 0)); 
        if (!enemy.isPotionActive(Potion.poison.id))
          enemy.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1)); 
        if (!enemy.isPotionActive(Potion.weakness.id))
          enemy.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 1)); 
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class VenomDemon extends Ability {
    public VenomDemon() {
      super(ListAttributes.VENOM_DEMON);
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(1.5F, 3.5F), (EntityPlayerMP)player);
      props.setZoanPoint("venomDemon");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (passiveTimer >= 800) {
        setPassiveActive(false);
        setCooldownActive(true);
        endPassive(player);
      } 
      if (!WyHelper.isBlockNearby((EntityLivingBase)player, 2, new Block[] { Blocks.water, (Block)Blocks.flowing_water, ListMisc.KairosekiOre, ListMisc.KairosekiBlock, ListMisc.KairosekiBars }))
        for (int x = -1; x < 1; x++) {
          for (int z = -1; z < 1; z++) {
            DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, (int)player.posX + x, (int)player.posY, (int)player.posZ + z, ListMisc.DemonPoison, new String[] { "core", "foliage", "air" });
          } 
        }  
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("venomDemon", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(0.6F, 1.8F), (EntityPlayerMP)player);
      props.setZoanPoint("n/a");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class DokuFugu extends Ability {
    public DokuFugu() {
      super(ListAttributes.DOKU_FUGU);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new DokuProjectiles.ChloroBall(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class VenomRoad extends Ability {
    public VenomRoad() {
      super(ListAttributes.VENOM_ROAD);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new DokuProjectiles.VenomRoad(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class ChloroBall extends Ability {
    public ChloroBall() {
      super(ListAttributes.CHLORO_BALL);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new DokuProjectiles.ChloroBall(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class Hydra extends Ability {
    public Hydra() {
      super(ListAttributes.HYDRA);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new DokuProjectiles.Hydra(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
}
