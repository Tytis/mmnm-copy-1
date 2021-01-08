package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.OpeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.items.devilfruitextras.Heart;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class OpeAbilities {
  static {
    Values.abilityWebAppExtraParams.put("room", new String[] { "desc", "Creates a spherical space around the user, in which they can manipulate anything with other skills." });
    Values.abilityWebAppExtraParams.put("countershock", new String[] { "desc", "Releases a strong electrical current, which shocks the opponent." });
    Values.abilityWebAppExtraParams.put("mes", new String[] { "desc", "Removes the heart of the user's target, which they can then damage to hurt the opponent." });
    Values.abilityWebAppExtraParams.put("gammaknife", new String[] { "desc", "Creates a blade of gamma radiation, which massively damages the opponent's organs" });
    Values.abilityWebAppExtraParams.put("shambles", new String[] { "desc", "The user swaps place with the closest entity within the ROOM." });
    Values.abilityWebAppExtraParams.put("takt", new String[] { "desc", "Lifts all entities inside ROOM, making them unable to move." });
    Values.abilityWebAppExtraParams.put("injectionshot", new String[] { "desc", "While holding a weapon, the user charges at the enemy, leaving them poisoned and confused." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new Room(), new Mes(), new CounterShock(), new GammaKnife(), new Takt(), new Shambles(), new InjectionShot() };
  
  public static class InjectionShot extends Ability {
    public InjectionShot() {
      super(ListAttributes.INJECTION_SHOT);
    }
    
    public void use(EntityPlayer player) {
      if (DevilFruitsHelper.isEntityInRoom((EntityLivingBase)player)) {
        if (!ItemsHelper.isSword(player.getHeldItem())) {
          WyHelper.sendMsgToPlayer(player, "You need a sword to use this ability !");
          return;
        } 
        if (!this.isOnCooldown) {
          double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
          double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
          double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
          mX /= f2;
          mZ /= f2;
          mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
          mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
          mX *= 3.0D;
          mZ *= 3.0D;
          OpeAbilities.motion("=", mX, player.motionY, mZ, player);
          if (player.worldObj instanceof WorldServer)
            ((WorldServer)player.worldObj).getEntityTracker().func_151248_b((Entity)player, (Packet)new S0BPacketAnimation((Entity)player, 0)); 
        } 
        super.use(player);
      } else {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used inside ROOM !");
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      if (currentCooldown > 260)
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 1.6D)) {
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20.0F);
          e.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
          e.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
        }  
    }
  }
  
  public static class Takt extends Ability {
    private HashMap<EntityLivingBase, Double> entitiesInRoom = new HashMap<>();
    
    public Takt() {
      super(ListAttributes.TAKT);
    }
    
    public void passive(EntityPlayer player) {
      if (!isPassiveActive()) {
        if (DevilFruitsHelper.isEntityInRoom((EntityLivingBase)player)) {
          for (EntityLivingBase entity : WyHelper.getEntitiesNear((Entity)player, 40.0D)) {
            if (DevilFruitsHelper.isEntityInRoom(entity) && !entity.equals(player))
              this.entitiesInRoom.put(entity, Double.valueOf(entity.posY + 3.0D)); 
          } 
          super.passive(player);
        } else {
          WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used inside ROOM !");
        } 
      } else {
        super.passive(player);
      } 
    }
    
    public void duringPassive(EntityPlayer player, int passiveTimer) {
      if (!DevilFruitsHelper.isEntityInRoom((EntityLivingBase)player)) {
        setPassiveActive(false);
        setCooldownActive(true);
        endPassive(player);
      } 
      if (passiveTimer >= 160) {
        setPassiveActive(false);
        setCooldownActive(true);
        endPassive(player);
      } 
      Iterator<Map.Entry<EntityLivingBase, Double>> it = this.entitiesInRoom.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry<EntityLivingBase, Double> pair = it.next();
        ((EntityLivingBase)pair.getKey()).setPositionAndUpdate(((EntityLivingBase)pair.getKey()).posX, ((Double)pair.getValue()).doubleValue(), ((EntityLivingBase)pair.getKey()).posZ);
        ((EntityLivingBase)pair.getKey()).fallDistance = 0.0F;
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      startCooldown();
      startExtUpdate(player);
      this.entitiesInRoom.clear();
    }
  }
  
  public static class Shambles extends Ability {
    public Shambles() {
      super(ListAttributes.SHAMBLES);
    }
    
    public void use(EntityPlayer player) {
      if (DevilFruitsHelper.isEntityInRoom((EntityLivingBase)player)) {
        if (!this.isOnCooldown) {
          MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
          if (mop != null) {
            double i = mop.blockX;
            double j = mop.blockY;
            double k = mop.blockZ;
            List<EntityLivingBase> entityList = WyHelper.getEntitiesNear((int)i, (int)j, (int)k, player.worldObj, 4.0D, EntityLivingBase.class);
            if (entityList.size() <= 0)
              return; 
            EntityLivingBase target = entityList.get(0);
            double[] beforeCoords = { player.posX, player.posY, player.posZ };
            player.setPositionAndRotation(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
            player.setPositionAndUpdate(target.posX, target.posY, target.posZ);
            target.setPositionAndUpdate(beforeCoords[0], beforeCoords[1], beforeCoords[2]);
          } 
        } 
        super.use(player);
      } else {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used inside ROOM !");
      } 
    }
  }
  
  public static class GammaKnife extends Ability {
    public GammaKnife() {
      super(ListAttributes.GAMMA_KNIFE);
    }
    
    public void use(EntityPlayer player) {
      if (DevilFruitsHelper.isEntityInRoom((EntityLivingBase)player)) {
        this.projectile = (AbilityProjectile)new OpeProjectiles.GammaKnife(player.worldObj, (EntityLivingBase)player, this.attr);
        super.use(player);
      } else {
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used inside ROOM !");
      } 
    }
  }
  
  public static class Mes extends Ability {
    public Mes() {
      super(ListAttributes.MES);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      ExtendedEntityData targetprops = ExtendedEntityData.get(target);
      if (targetprops.hasHeart()) {
        ItemStack heart = new ItemStack(ListMisc.Heart);
        ((Heart)heart.getItem()).setHeartOwner(heart, target);
        heart.setStackDisplayName(target.getCommandSenderName() + "'s Heart");
        player.inventory.addItemStackToInventory(heart);
        targetprops.setHasHeart(false);
      } 
      super.hitEntity(player, target);
    }
  }
  
  public static class CounterShock extends Ability {
    public CounterShock() {
      super(ListAttributes.COUNTER_SHOCK);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      super.hitEntity(player, target);
      WyNetworkHelper.sendTo((IMessage)new PacketParticles("elThor", target.posX, target.posY, target.posZ), (EntityPlayerMP)player);
    }
  }
  
  public static class Room extends Ability {
    private List<int[]> blockList = (List)new ArrayList<>();
    
    public Room() {
      super(ListAttributes.ROOM);
    }
    
    public void passive(EntityPlayer player) {
      if (!this.isOnCooldown) {
        if (this.blockList.isEmpty()) {
          this.blockList.addAll(WyHelper.createEmptySphere(player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, 20, ListMisc.Ope, new String[] { "air", "foliage", "liquids", "nogrief" }));
          player.worldObj.setBlock((int)player.posX, (int)player.posY, (int)player.posZ, ListMisc.OpeMid);
          this.blockList.add(new int[] { (int)player.posX, (int)player.posY, (int)player.posZ });
        } 
        super.passive(player);
      } 
    }
    
    public void endPassive(EntityPlayer player) {
      for (int[] blockPos : this.blockList) {
        if (player.worldObj.getBlock(blockPos[0], blockPos[1], blockPos[2]) == ListMisc.Ope || player.worldObj.getBlock(blockPos[0], blockPos[1], blockPos[2]) == ListMisc.OpeMid)
          player.worldObj.setBlock(blockPos[0], blockPos[1], blockPos[2], Blocks.air); 
      } 
      this.blockList = (List)new ArrayList<>();
      startCooldown();
      startExtUpdate(player);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
