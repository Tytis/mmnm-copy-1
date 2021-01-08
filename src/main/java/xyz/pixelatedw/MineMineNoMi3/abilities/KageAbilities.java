package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.KageProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityDoppelman;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;

public class KageAbilities {
  static {
    Values.abilityWebAppExtraParams.put("brickbat", new String[] { "desc", "Launches bats created from the user's shadow at the the opponent." });
    Values.abilityWebAppExtraParams.put("blackbox", new String[] { "desc", "Encases and suffocates the opponent in a box made of shadows." });
    Values.abilityWebAppExtraParams.put("tsunotokage", new String[] { "desc", "The user creates a lizard-like shadow under his opponent, which pierces them from below." });
    Values.abilityWebAppExtraParams.put("doppelman", new String[] { "desc", "Creates a living version of the user's shadow to help them fight." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new Doppelman(), new Kagemusha(), new BrickBat(), new BlackBox(), new Tsunotokage() };
  
  public static class BrickBat extends Ability {
    public BrickBat() {
      super(ListAttributes.BRICK_BAT);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new KageProjectiles.BrickBat(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class Kagemusha extends Ability {
    public Kagemusha() {
      super(ListAttributes.KAGEMUSHA);
    }
    
    public void use(EntityPlayer player) {
      if (!WyHelper.getEntitiesNear((Entity)player, 20.0D, new Class[] { EntityDoppelman.class }).isEmpty()) {
        EntityDoppelman dopp = (EntityDoppelman) WyHelper.getEntitiesNear((Entity)player, 20.0D, new Class[] { EntityDoppelman.class }).stream().findFirst().orElse(null);
        if (dopp != null) {
          int[] auxPos = { (int)player.posX, (int)player.posY, (int)player.posZ };
          player.setPositionAndUpdate(dopp.posX, dopp.posY, dopp.posZ);
          dopp.setPositionAndUpdate(auxPos[0], auxPos[1], auxPos[2]);
        } 
      } else {
        WyHelper.sendMsgToPlayer(player, "Your Doppelman is too far away");
      } 
      super.use(player);
    }
  }
  
  public static class Doppelman extends Ability {
    private EntityDoppelman doppelman;
    
    public Doppelman() {
      super(ListAttributes.DOPPELMAN);
    }
    
    public void passive(EntityPlayer player) {
      if (this.passiveActive && player.isSneaking() && this.doppelman != null) {
        this.doppelman.isAggressive = !this.doppelman.isAggressive;
        WyHelper.sendMsgToPlayer(player, "Your Doppelman is now " + (this.doppelman.isAggressive ? "aggressive" : "defensive"));
      } else {
        super.passive(player);
      } 
    }
    
    public void startPassive(EntityPlayer player) {
      this.doppelman = new EntityDoppelman(player.worldObj, player);
      this.doppelman.setPositionAndRotation(player.posX, player.posY, player.posZ, 180.0F, 0.0F);
      player.worldObj.spawnEntityInWorld((Entity)this.doppelman);
    }
    
    public void endPassive(EntityPlayer player) {
      if (!WyHelper.getEntitiesNear((Entity)player, 20.0D, new Class[] { EntityDoppelman.class }).isEmpty())
        WyHelper.getEntitiesNear((Entity)player, 20.0D, new Class[] { EntityDoppelman.class }).forEach(x -> ((Entity) x).setDead()); 
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class BlackBox extends Ability {
    public BlackBox() {
      super(ListAttributes.BLACK_BOX);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new KageProjectiles.BlackBox(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class Tsunotokage extends Ability {
    public Tsunotokage() {
      super(ListAttributes.TSUNOTOKAGE);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
        if (mop != null) {
          double i = mop.blockX;
          double j = mop.blockY;
          double k = mop.blockZ;
          KageProjectiles.TsunotokagePillar pillar = new KageProjectiles.TsunotokagePillar(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.TSUNOTOKAGE_PILLAR);
          pillar.setLocationAndAngles(i, j + 1.0D, k, 0.0F, 0.0F);
          pillar.motionX = 0.0D;
          pillar.motionZ = 0.0D;
          pillar.motionY = 0.7D;
          player.worldObj.spawnEntityInWorld((Entity)pillar);
        } 
        super.use(player);
      } 
    }
  }
}
