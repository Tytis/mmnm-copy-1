package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.RokushikiProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class RokushikiAbilities {
  static {
    Values.abilityWebAppExtraParams.put("soru", new String[] { "desc", "Allows the user to move at an extremely high speed.", "dorikiRequiredForHumans", "500" });
    Values.abilityWebAppExtraParams.put("tekkai", new String[] { "desc", "Hardens the user's body to protect themselves, but they're unable to move.", "dorikiRequiredForHumans", "1500" });
    Values.abilityWebAppExtraParams.put("geppo", new String[] { "desc", "The user kicks the air beneath them to launch themselves into the air.", "dorikiRequiredForHumans", "4500" });
    Values.abilityWebAppExtraParams.put("rankyaku", new String[] { "desc", "By kicking at a very high speed, the user launches an air blade at the opponent.", "dorikiRequiredForHumans", "8500" });
    Values.abilityWebAppExtraParams.put("shigan", new String[] { "desc", "The user thrusts their finger at the opponent, to pierce them.", "dorikiRequiredForHumans", "3000" });
    Values.abilityWebAppExtraParams.put("kamie", new String[] { "desc", "Maked the user's body flexible in order to avoid attacks.", "dorikiRequiredForHumans", "6000" });
  }
  
  public static final Ability SORU = new Soru();
  
  public static final Ability TEKKAI = new Tekkai();
  
  public static final Ability GEPPO = new Geppo();
  
  public static final Ability RANKYAKU = new Rankyaku();
  
  public static final Ability SHIGAN = new Shigan();
  
  public static final Ability KAMIE = new Kamie();
  
  public static Ability[] abilitiesArray = new Ability[] { SORU, TEKKAI, GEPPO, RANKYAKU, SHIGAN, KAMIE };
  
  public static class Soru extends Ability {
    public Soru() {
      super(ListAttributes.SORU);
    }
  }
  
  public static class Tekkai extends Ability {
    private int threshold = 300;
    
    public Tekkai() {
      super(ListAttributes.TEKKAI);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (passiveTimer > 2400 || this.threshold <= 0) {
        setPassiveActive(false);
        startCooldown();
        startExtUpdate(player);
        endPassive(player);
      } 
      if (player.hurtTime > 0)
        this.threshold--; 
    }
    
    public void endPassive(EntityPlayer player) {
      startCooldown();
      startExtUpdate(player);
      this.threshold = 300;
      super.endPassive(player);
    }
  }
  
  public static class Geppo extends Ability {
    public Geppo() {
      super(ListAttributes.GEPPO);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        WyHelper.Direction dir = WyHelper.get8Directions((Entity)player);
        double mX = 0.0D;
        double mY = 0.0D;
        double mZ = 0.0D;
        if (player.onGround) {
          mY += 1.7D;
        } else {
          mY += 1.86D;
        } 
        if (dir == WyHelper.Direction.NORTH)
          mZ--; 
        if (dir == WyHelper.Direction.NORTH_WEST) {
          mZ--;
          mX--;
        } 
        if (dir == WyHelper.Direction.SOUTH)
          mZ++; 
        if (dir == WyHelper.Direction.NORTH_EAST) {
          mZ--;
          mX++;
        } 
        if (dir == WyHelper.Direction.WEST)
          mX--; 
        if (dir == WyHelper.Direction.SOUTH_WEST) {
          mZ++;
          mX--;
        } 
        if (dir == WyHelper.Direction.EAST)
          mX++; 
        if (dir == WyHelper.Direction.SOUTH_EAST) {
          mZ++;
          mX++;
        } 
        RokushikiAbilities.motion("=", mX, mY, mZ, player);
        WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("geppo", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
        super.use(player);
      } 
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
  
  public static class Rankyaku extends Ability {
    public Rankyaku() {
      super(ListAttributes.RANKYAKU);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new RokushikiProjectiles.Rankyaku(player.worldObj, (EntityLivingBase)player, ListAttributes.RANKYAKU);
      super.use(player);
    }
  }
  
  public static class Shigan extends Ability {
    public Shigan() {
      super(ListAttributes.SHIGAN);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      super.hitEntity(player, target);
      target.attackEntityFrom(DamageSource.causePlayerDamage(player), 20.0F);
    }
  }
  
  public static class Kamie extends Ability {
    public Kamie() {
      super(ListAttributes.KAMIE);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (passiveTimer > 400) {
        setPassiveActive(false);
        startCooldown();
        startExtUpdate(player);
        super.endPassive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      startCooldown();
      startExtUpdate(player);
    }
  }
}
