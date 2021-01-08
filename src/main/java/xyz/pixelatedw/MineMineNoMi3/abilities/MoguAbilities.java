package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.block.Block;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketEntityVelocity;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketNewAABB;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class MoguAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new PowerPoint(), new MoguraBanana(), new MoguraTonpo() };
  
  public static class MoguraTonpo extends Ability {
    private int initialY;
    
    private boolean breakBlocks;
    
    public MoguraTonpo() {
      super(ListAttributes.MOGURA_TONPO);
    }
    
    public void use(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown)
        if (MainConfig.enableGriefing)
          if (props.getZoanPoint().equals("power")) {
            if (player.isSneaking()) {
              int i = 0;
              for (int x = -1; x < 1; x++) {
                for (int y = 0; y < 10; y++) {
                  for (int z = -1; z < 1; z++) {
                    int posX = (int)player.posX + x;
                    int posY = (int)player.posY - y;
                    int posZ = (int)player.posZ + z;
                    player.addPotionEffect(new PotionEffect(Potion.resistance.id, 50, 100, true));
                    player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 400, 2, true));
                    Block tempBlock = player.worldObj.getBlock(posX, posY, posZ);
                    if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, Blocks.air, new String[] { "all", "restricted", "ignore liquid" })) {
                      player.inventory.addItemStackToInventory(new ItemStack(tempBlock));
                      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", posX, posY, posZ), player.dimension, posX, posY, posZ, 128.0D);
                    } 
                  } 
                } 
              } 
              this.attr.setAbilityCooldown(2.0D);
            } else {
              double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
              double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
              this.initialY = (int)player.posY;
              this.breakBlocks = true;
              double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
              mX /= f2;
              mZ /= f2;
              mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
              mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
              mX *= 4.0D;
              mZ *= 4.0D;
              MoguAbilities.motion("=", mX, player.motionY, mZ, player);
              this.attr.setAbilityCooldown(10.0D);
            } 
            super.use(player);
          } else {
            WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Mole Point is active !");
          }   
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown > 100 && player.posY >= this.initialY && props.getZoanPoint().equals("power")) {
        for (int[] location : WyHelper.getBlockLocationsNearby((EntityLivingBase)player, 2)) {
          if (location[1] >= player.posY) {
            Block tempBlock = player.worldObj.getBlock(location[0], location[1], location[2]);
            if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, location[0], location[1], location[2], Blocks.air, new String[] { "core", "foliage" })) {
              player.inventory.addItemStackToInventory(new ItemStack(tempBlock));
              WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", location[0], location[1], location[2]), player.dimension, location[0], location[1], location[2], 128.0D);
              if (player.worldObj instanceof WorldServer)
                ((WorldServer)player.worldObj).getEntityTracker().func_151248_b((Entity)player, (Packet)new S0BPacketAnimation((Entity)player, 0)); 
            } 
          } 
        } 
      } else if (currentCooldown < 10) {
        this.breakBlocks = false;
      } 
    }
  }
  
  public static class MoguraBanana extends Ability {
    public MoguraBanana() {
      super(ListAttributes.MOGURA_BANANA);
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      AbilityProperties abilityProps = AbilityProperties.get(player);
      if (!props.getZoanPoint().equals("power")) {
        setPassiveActive(false);
        WyNetworkHelper.sendTo((IMessage)new PacketAbilitySync(abilityProps), (EntityPlayerMP)player);
        WyHelper.sendMsgToPlayer(player, "" + getAttribute().getAttributeName() + " can only be used while Power Point is active !");
      } 
    }
    
    public void hitEntity(EntityPlayer player, EntityLivingBase target) {
      double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
      double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
      double f2 = MathHelper.sqrt_double(mX * mX + player.motionY * player.motionY + mZ * mZ);
      mX /= f2;
      mZ /= f2;
      mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
      mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
      mX *= 2.5D;
      mZ *= 2.5D;
      WyNetworkHelper.sendToAll((IMessage)new PacketEntityVelocity(target.getEntityId(), mX, 0.1D, mZ));
      super.hitEntity(player, target);
    }
  }
  
  public static class PowerPoint extends Ability {
    public PowerPoint() {
      super(ListAttributes.MOGU_POWER_POINT);
    }
    
    public void passive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!this.isOnCooldown && (props.getZoanPoint().equalsIgnoreCase("n/a") || props.getZoanPoint().equalsIgnoreCase("power")))
        super.passive(player); 
    }
    
    public void startPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.getZoanPoint().isEmpty())
        props.setZoanPoint("n/a"); 
      player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 2147483647, 3, true));
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(0.5F, 1.5F), (EntityPlayerMP)player);
      props.setZoanPoint("power");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
    
    public void endPassive(EntityPlayer player) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      player.removePotionEffect(Potion.digSpeed.id);
      WyNetworkHelper.sendTo((IMessage)new PacketNewAABB(0.6F, 1.8F), (EntityPlayerMP)player);
      props.setZoanPoint("n/a");
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(player.getDisplayName(), props));
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
