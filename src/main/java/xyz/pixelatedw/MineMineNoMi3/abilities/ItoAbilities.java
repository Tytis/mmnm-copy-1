package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.ArrayList;
import java.util.List;
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
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ItoProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityBlackKnight;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class ItoAbilities {
  static {
    Values.abilityWebAppExtraParams.put("parasite", new String[] { "desc", "The user binds the opponent with a string that renders them immobile." });
    Values.abilityWebAppExtraParams.put("soranomichi", new String[] { "desc", "The user creates strings under their feet to launch themselves into the air." });
    Values.abilityWebAppExtraParams.put("overheat", new String[] { "desc", "The user shoots a rope made of heated strings at the opponent, exploding upon impact." });
    Values.abilityWebAppExtraParams.put("tamaito", new String[] { "desc", "The user shoots a small bundle of strings, acting like a bullet." });
    Values.abilityWebAppExtraParams.put("kumonosugaki", new String[] { "desc", "Creates a huge web that protects the user from any attack." });
    Values.abilityWebAppExtraParams.put("torikago", new String[] { "desc", "Creates an indestructible dome made of strings, that damage anyone who toches then" });
    Values.abilityWebAppExtraParams.put("godthreat", new String[] { "desc", "Creates an indestructible dome made of strings, that damage anyone who toches then" });
    Values.abilityWebAppExtraParams.put("flapthread", new String[] { "desc", "Creates an indestructible dome made of strings, that damage anyone who toches then" });
    Values.abilityWebAppExtraParams.put("everwhite", new String[] { "desc", "Creates an indestructible dome made of strings, that damage anyone who toches then" });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new Parasite(), new GodThreat(), new FlapThread(), new Everwhite(), new SoraNoMichi(), new Overheat(), new Tamaito(), new KumoNoSugaki(), new Torikago(), new BlackKnight() };
  
  public static class Everwhite extends Ability {
    public Everwhite() {
      super(ListAttributes.Everwhite);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new ItoProjectiles.Everwhite(player.worldObj, (EntityLivingBase)player, ListAttributes.Everwhite);
      super.use(player);
    }
  }
  
  public static class GodThreat extends Ability {
    public GodThreat() {
      super(ListAttributes.GodThreat);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new ItoProjectiles.GodThreat(player.worldObj, (EntityLivingBase)player, ListAttributes.GodThreat);
      super.use(player);
    }
  }
  
  public static class FlapThread extends Ability {
    public FlapThread() {
      super(ListAttributes.FlapThread);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new ItoProjectiles.FlapThread(player.worldObj, (EntityLivingBase)player, ListAttributes.FlapThread);
      super.use(player);
    }
  }
  
  public static class BlackKnight extends Ability {
    private EntityBlackKnight blackKnight;
    
    public BlackKnight() {
      super(ListAttributes.BLACK_KNIGHT);
    }
    
    public void passive(EntityPlayer player) {
      if (this.passiveActive && player.isSneaking() && this.blackKnight != null) {
        this.blackKnight.isAggressive = !this.blackKnight.isAggressive;
        WyHelper.sendMsgToPlayer(player, "Your Black Knight is now " + (this.blackKnight.isAggressive ? "aggressive" : "defensive"));
      } else {
        super.passive(player);
      } 
    }
    
    public void startPassive(EntityPlayer player) {
      this.blackKnight = new EntityBlackKnight(player.worldObj, player);
      this.blackKnight.setPositionAndRotation(player.posX, player.posY, player.posZ, 180.0F, 0.0F);
      player.worldObj.spawnEntityInWorld((Entity)this.blackKnight);
    }
    
    public void endPassive(EntityPlayer player) {
      if (!WyHelper.getEntitiesNear((Entity)player, 20.0D, new Class[] { EntityBlackKnight.class }).isEmpty())
        WyHelper.getEntitiesNear((Entity)player, 20.0D, new Class[] { EntityBlackKnight.class }).forEach(x -> ((Entity) x).setDead()); 
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class Torikago extends Ability {
    private List<int[]> blockList = (List)new ArrayList<>();
    
    public Torikago() {
      super(ListAttributes.TORIKAGO);
    }
    
    public void passive(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (this.blockList.isEmpty()) {
          this.blockList.addAll(WyHelper.createEmptySphere(player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, 20, ListMisc.StringWall, new String[] { "air", "foliage", "liquids", "nogrief" }));
          player.worldObj.setBlock((int)player.posX, (int)player.posY, (int)player.posZ, ListMisc.StringMid);
          this.blockList.add(new int[] { (int)player.posX, (int)player.posY, (int)player.posZ });
        } 
        super.passive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      for (int[] blockPos : this.blockList) {
        if (player.worldObj.getBlock(blockPos[0], blockPos[1], blockPos[2]) == ListMisc.StringWall || player.worldObj.getBlock(blockPos[0], blockPos[1], blockPos[2]) == ListMisc.StringMid)
          player.worldObj.setBlock(blockPos[0], blockPos[1], blockPos[2], Blocks.air); 
      } 
      this.blockList = (List)new ArrayList<>();
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  public static class KumoNoSugaki extends Ability {
    public KumoNoSugaki() {
      super(ListAttributes.KUMO_NO_SUGAKI);
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("kumoNoSugaki", (EntityLivingBase)player), player.dimension, player.posX, player.posY, player.posZ, 128.0D);
      if (passiveTimer >= 300) {
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
  
  public static class Tamaito extends Ability {
    public Tamaito() {
      super(ListAttributes.TAMAITO);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new ItoProjectiles.Tamaito(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class Overheat extends Ability {
    public Overheat() {
      super(ListAttributes.OVERHEAT);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new ItoProjectiles.Overheat(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class SoraNoMichi extends Ability {
    public SoraNoMichi() {
      super(ListAttributes.SORA_NO_MICHI);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        WyHelper.Direction dir = WyHelper.get8Directions((Entity)player);
        double mX = 0.0D;
        double mY = 0.0D;
        double mZ = 0.0D;
        if (player.onGround) {
          mY += 1.8D;
        } else {
          mY += 1.96D;
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
        ItoAbilities.motion("=", mX, mY, mZ, player);
        super.use(player);
      } 
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
  
  public static class Parasite extends Ability {
    public Parasite() {
      super(ListAttributes.PARASITE);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        for (EntityLivingBase l : WyHelper.getEntitiesNear((Entity)player, 20.0D)) {
          System.out.println(l);
          l.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 10));
          l.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 10));
          l.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200, 10));
          l.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 10));
        } 
        super.use(player);
      } 
    }
  }
}
