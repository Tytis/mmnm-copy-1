package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffect;
import xyz.pixelatedw.MineMineNoMi3.abilities.effects.DFEffectZushiAbareHimatsuri;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.JuryoProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class JuryoAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new SagariNoRyusei(), new Juryoku(), new Moko(), new AbareHimatsuri() };
  
  public static class AbareHimatsuri extends Ability {
    private DFEffect extra = null;
    
    public AbareHimatsuri() {
      super(ListAttributes.ABARE_HIMATSURI);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!player.capabilities.isFlying && player.onGround) {
        if (this.extra == null) {
          this.extra = (DFEffect)new DFEffectZushiAbareHimatsuri((EntityLivingBase)player, 99999);
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
  
  public static class Moko extends Ability {
    public Moko() {
      super(ListAttributes.MOKO);
    }
    
    public void use(EntityPlayer player) {
      if (!isOnCooldown()) {
        if (!ItemsHelper.isSword(player.getHeldItem())) {
          WyHelper.sendMsgToPlayer(player, "You need a sword to use this ability !");
          return;
        } 
        for (int j = 0; j < 50; j++) {
          JuryoProjectiles.Moko moko = new JuryoProjectiles.Moko(player.worldObj, (EntityLivingBase)player, ListAttributes.MOKO);
          moko.setLocationAndAngles(player.posX + 
              WyMathHelper.randomWithRange(-5, 5) + player.worldObj.rand.nextDouble(), player.posY + 0.3D + 
              WyMathHelper.randomWithRange(0, 5) + player.worldObj.rand.nextDouble(), player.posZ + 
              WyMathHelper.randomWithRange(-5, 5) + player.worldObj.rand.nextDouble(), 0.0F, 0.0F);
          player.worldObj.spawnEntityInWorld((Entity)moko);
        } 
        if (player.worldObj instanceof WorldServer)
          ((WorldServer)player.worldObj).getEntityTracker().func_151248_b((Entity)player, (Packet)new S0BPacketAnimation((Entity)player, 0)); 
        super.use(player);
      } 
    }
  }
  
  public static class Juryoku extends Ability {
    public Juryoku() {
      super(ListAttributes.JURYOKU);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (passiveTimer > 400) {
        setPassiveActive(false);
        startCooldown();
        startExtUpdate(player);
      } 
      for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)player, 10.0D)) {
        entity.motionX = 0.0D;
        entity.motionZ = 0.0D;
        entity.motionY -= 5.0D;
        entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 10));
        if (++passiveTimer % 100 == 0) {
          entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 8.0F * props.getDamageMultiplier());
          if (MainConfig.enableGriefing)
            for (int x = -2; x < 2; x++) {
              for (int z = -2; z < 2; z++) {
                int posX = (int)entity.posX + x;
                int posY = (int)entity.posY - 1;
                int posZ = (int)entity.posZ + z;
                DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, Blocks.air, new String[] { "all", "restricted", "ignore liquid" });
              } 
            }  
        } 
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class SagariNoRyusei extends Ability {
    public SagariNoRyusei() {
      super(ListAttributes.SAGARI_NO_RYUSEI);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
        if (mop != null) {
          double x = mop.blockX;
          double y = mop.blockY;
          double z = mop.blockZ;
          JuryoProjectiles.SagariNoRyusei sagariNoRyusei = new JuryoProjectiles.SagariNoRyusei(player.worldObj, (EntityLivingBase)player, ListAttributes.SAGARI_NO_RYUSEI);
          sagariNoRyusei.setLocationAndAngles(x, y + 90.0D, z, 0.0F, 0.0F);
          ((AbilityProjectile)sagariNoRyusei).motionX = 0.0D;
          ((AbilityProjectile)sagariNoRyusei).motionZ = 0.0D;
          ((AbilityProjectile)sagariNoRyusei).motionY = -2.4D;
          player.worldObj.spawnEntityInWorld((Entity)sagariNoRyusei);
        } 
      } 
      super.use(player);
    }
  }
}
