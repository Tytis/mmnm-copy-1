package xyz.pixelatedw.MineMineNoMi3.soros.nu;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class Nu {
  static {
    Values.abilityWebAppExtraParams.put("Nue Point", new String[] { "desc", "Turns you into a Nue." });
    Values.abilityWebAppExtraParams.put("Nue Curse", new String[] { "desc", "gives everyone in 10 block radius poison 2  and slowness 5 for 10 seconds" });
    Values.abilityWebAppExtraParams.put("Nue Claw Slash", new String[] { "desc", "Projectile with a model Iâ€™d make" });
    Values.abilityWebAppExtraParams.put("Nue Slice And Dice", new String[] { "desc", "Copy of Pounce from Smilodon fruit but with 70 Damage" });
    Values.abilityWebAppExtraParams.put("Fang Sting", new String[] { "desc", "A Punch move like Shigan that does 60 damage and poison 2 for 8 seconds" });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new NuePoint(), new NUECLAWSLASH(), new FangSting(), new NuesCurse(), new Slice() };
  
  public static class Slice extends Ability {
    private int initialY;
    
    public Slice() {
      super(ListAttributes.Slice);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("nue")) {
        double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        this.initialY = (int)player.posY;
        double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
        mX /= f2;
        mZ /= f2;
        mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mX *= 6.0D;
        mZ *= 6.0D;
        Nu.motion("=", mX, player.motionY, mZ, player);
        super.use(player);
      } 
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown > 180 && player.posY >= this.initialY) {
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 3.0D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 70.0F); 
        for (int[] location : WyHelper.getBlockLocationsNearby((EntityLivingBase)player, 5)) {
          if (location[1] >= player.posY)
            if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, new String[] { "core", "foliage" }))
              WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], 128.0D);  
        } 
      } 
    }
  }
  
  public static class NuePoint extends Ability {
    public NuePoint() {
      super(ListAttributes.NuePoint);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props
        .getZoanPoint().equalsIgnoreCase("nue")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      props.setZoanPoint("nue");
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
  
  public static class NUECLAWSLASH extends Ability {
    public NUECLAWSLASH() {
      super(ListAttributes.NUECLAWSLASH);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("nue"))
        this.projectile = new NuProjo.Rankyaku(player.worldObj, (EntityLivingBase)player, ListAttributes.NUECLAWSLASH); 
      super.use(player);
    }
  }
  
  public static class FangSting extends Ability {
    public FangSting() {
      super(ListAttributes.FangSting);
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      super.hitEntity(player, target);
      target.attackEntityFrom(DamageSource.causePlayerDamage(player), 60.0F);
    }
  }
  
  public static class NuesCurse extends Ability {
    public NuesCurse() {
      super(ListAttributes.NuesCurse);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && props.getZoanPoint().equalsIgnoreCase("nue"))
        for (Entity entity : WyHelper.getEntitiesNear((Entity)player, 10.0D)) {
          if (entity instanceof EntityLivingBase && 
            !entity.isDead) {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 4));
          } 
        }  
      super.use(player);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
