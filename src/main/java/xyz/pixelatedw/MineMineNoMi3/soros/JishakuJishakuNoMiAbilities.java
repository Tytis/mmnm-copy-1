package xyz.pixelatedw.MineMineNoMi3.soros;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class JishakuJishakuNoMiAbilities {
  static {
    Values.abilityWebAppExtraParams.put("Magnet Pull", new String[] { "desc", "Pulls a target toward you." });
    Values.abilityWebAppExtraParams.put("Repell", new String[] { "desc", "Sends enemies 15 blocks away." });
    Values.abilityWebAppExtraParams.put("Mecha Arm", new String[] { "desc", "Makes metal accumulate on your right arm and gives you strength 4." });
    Values.abilityWebAppExtraParams.put("Mecha Arm Discharge", new String[] { "desc", "Sends 6 Metal Pieces out to opponents." });
  }
  
  public static final Ability MagnetPull = new MagnetPull();
  
  public static final Ability Repell = new Repell();
  
  public static final Ability MechaArm = new MechArm();
  
  public static final Ability ArmDischarge = new ArmDischarge();
  
  public static Ability[] abilitiesArray = new Ability[] { MagnetPull, Repell, MechaArm, ArmDischarge, new HRepell() };
  
  public static class ArmDischarge extends Ability {
    public ArmDischarge() {
      super(ListAttributes.JISHAKUMETAL);
    }
    
    public void use(EntityPlayer player) {
      super.use(player);
      ExtendedEntityData data = new ExtendedEntityData((EntityLivingBase)player);
      AbilityProperties.get(player).getAbilityFromName(ListAttributes.MechArm.getAttributeName()).disable(player, true);
      this.projectile = new JishakuJishakuNoMiProjectiles.MetalPieces(player.worldObj, (EntityLivingBase)player, ListAttributes.JISHAKUMETAL);
    }
  }
  
  public static class Repell extends Ability {
    public Repell() {
      super(ListAttributes.Repell);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        for (EntityLivingBase ent : WyHelper.getEntitiesNear((Entity)player, 15.0D))
          ent.knockBack((Entity)ent, 200.0F, player.posX - ent.posX, player.posZ - ent.posZ); 
        super.use(player);
      } 
    }
  }
  
  public static class HRepell extends Ability {
    public HRepell() {
      super(ListAttributes.HeavyRepell);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        this.projectile = new JishakuJishakuNoMiProjectiles.HREPELL(player.worldObj, (EntityLivingBase)player, ListAttributes.Inugami);
        super.use(player);
      } 
    }
  }
  
  public static class MechArm extends Ability {
    public MechArm() {
      super(ListAttributes.MechArm);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown)
        return; 
      super.use(player);
    }
  }
  
  public static class MagnetPull extends Ability {
    public MagnetPull() {
      super(ListAttributes.MagnetPUll);
    }
    
    public void use(EntityPlayer player) {
      super.use(player);
      this.projectile = new JishakuJishakuNoMiProjectiles.PULL(player.worldObj, (EntityLivingBase)player, this.attr);
    }
  }
}
