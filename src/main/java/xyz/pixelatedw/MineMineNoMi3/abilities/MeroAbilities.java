package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MeroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class MeroAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new MeroMeroMellow(), new PistolKiss(), new SlaveArrow(), new PerfumeFemur() };
  
  public static class PerfumeFemur extends Ability {
    public PerfumeFemur() {
      super(ListAttributes.PERFUME_FEMUR);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      super.hitEntity(player, target);
      if (target != null) {
        target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600));
        target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 600));
        AbilityExplosion explosion = WyHelper.newExplosion((Entity)player, target.posX, target.posY, target.posZ, 2.0D);
        explosion.setExplosionSound(false);
        explosion.setDamageOwner(false);
        explosion.setDestroyBlocks(false);
        explosion.setSmokeParticles("perfumeFemur");
        explosion.doExplosion();
      } 
    }
  }
  
  public static class SlaveArrow extends Ability {
    public SlaveArrow() {
      super(ListAttributes.SLAVE_ARROW);
    }
    
    public void startCharging(EntityPlayer player) {
      if (!this.isOnCooldown)
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("slaveArrow", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D); 
      super.startCharging(player);
    }
    
    public void endCharging(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new MeroProjectiles.SlaveArrow(player.worldObj, (EntityLivingBase)player, this.attr);
      super.endCharging(player);
    }
  }
  
  public static class PistolKiss extends Ability {
    public PistolKiss() {
      super(ListAttributes.PISTOL_KISS);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new MeroProjectiles.PistolKiss(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class MeroMeroMellow extends Ability {
    public MeroMeroMellow() {
      super(ListAttributes.MERO_MERO_MELLOW);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new MeroProjectiles.MeroMeroMellow(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
}
