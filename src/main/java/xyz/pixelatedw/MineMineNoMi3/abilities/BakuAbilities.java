package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BakuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class BakuAbilities {
  public static Ability[] abilitiesArray = new Ability[] { new BakuMunch(), new BeroCannon(), new BakuTsuiho() };
  
  private static Block[] bakuPermittedBlocks = new Block[] { 
      (Block)Blocks.grass, Blocks.dirt, (Block)Blocks.leaves, (Block)Blocks.leaves2, Blocks.planks, Blocks.log, Blocks.log2, Blocks.stone, Blocks.cobblestone, (Block)Blocks.sand, 
      Blocks.sandstone, Blocks.gravel, Blocks.packed_ice, Blocks.clay, Blocks.hardened_clay, Blocks.cactus, (Block)Blocks.deadbush };
  
  public static class BakuBakuFactory extends Ability {
    public BakuBakuFactory() {
      super(ListAttributes.BAKU_BAKU_FACTORY);
    }
    
    public void use(EntityPlayer player) {
      super.use(player);
    }
  }
  
  public static class BakuTsuiho extends Ability {
    private List<ItemStack> projectiles = new ArrayList<>();
    
    private List<Block> loadedProjectiles = new ArrayList<>();
    
    public BakuTsuiho() {
      super(ListAttributes.BAKU_TSUIHO);
    }
    
    public void startCharging(EntityPlayer player) {
      this.loadedProjectiles.clear();
      this.projectiles.clear();
      for (ItemStack item : player.inventory.mainInventory) {
        if (item != null && item.getItem() instanceof ItemBlock && Arrays.<Block>stream(BakuAbilities.bakuPermittedBlocks).anyMatch(p -> (p == ((ItemBlock)item.getItem()).field_150939_a)))
          this.projectiles.add(item); 
      } 
      if (!this.projectiles.isEmpty()) {
        super.startCharging(player);
      } else {
        WyHelper.sendMsgToPlayer(player, "You don't have any blocks to use");
      } 
    }
    
    public void duringCharging(EntityPlayer player, int chargeTime) {
      if (!this.projectiles.isEmpty()) {
        if (chargeTime % 20 == 0) {
          ItemStack s = this.projectiles.stream().findAny().orElse(null);
          if (s != null) {
            if (s.stackSize > 1) {
              s.stackSize--;
            } else {
              WyHelper.removeStackFromInventory(player, s);
              this.projectiles.remove(s);
            } 
            this.loadedProjectiles.add(((ItemBlock)s.getItem()).field_150939_a);
          } 
        } 
      } else {
        endCharging(player);
      } 
    }
    
    public void endCharging(EntityPlayer player) {
      for (int j = 0; j < this.loadedProjectiles.size(); j++) {
        BakuProjectiles.BeroCannon beroCannon = new BakuProjectiles.BeroCannon(player.worldObj, (EntityLivingBase)player, ListAttributes.BERO_CANNON);
        int distanceBetweenProjectiles = this.loadedProjectiles.size() / 7;
        beroCannon.setLocationAndAngles(player.posX + 
            WyMathHelper.randomWithRange(-distanceBetweenProjectiles, distanceBetweenProjectiles) + player.worldObj.rand.nextDouble(), player.posY + 0.3D + 
            WyMathHelper.randomWithRange(0, distanceBetweenProjectiles) + player.worldObj.rand.nextDouble(), player.posZ + 
            WyMathHelper.randomWithRange(-distanceBetweenProjectiles, distanceBetweenProjectiles) + player.worldObj.rand.nextDouble(), 0.0F, 0.0F);
        player.worldObj.spawnEntityInWorld((Entity)beroCannon);
      } 
      super.endCharging(player);
    }
  }
  
  public static class BeroCannon extends Ability {
    public BeroCannon() {
      super(ListAttributes.BERO_CANNON);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        List<ItemStack> projectiles = new ArrayList<>();
        for (ItemStack item : player.inventory.mainInventory) {
          if (item != null && item.getItem() instanceof ItemBlock && Arrays.<Block>stream(BakuAbilities.bakuPermittedBlocks).anyMatch(p -> (p == ((ItemBlock)item.getItem()).field_150939_a)))
            projectiles.add(item); 
        } 
        if (!projectiles.isEmpty()) {
          this.projectile = (AbilityProjectile)new BakuProjectiles.BeroCannon(player.worldObj, (EntityLivingBase)player, this.attr);
          ItemStack s = projectiles.stream().findFirst().orElse(null);
          if (s.stackSize > 1) {
            s.stackSize--;
          } else {
            WyHelper.removeStackFromInventory(player, s);
          } 
          super.use(player);
        } else {
          WyHelper.sendMsgToPlayer(player, "You don't have any blocks to use");
        } 
      } 
    }
  }
  
  public static class BakuMunch extends Ability {
    public BakuMunch() {
      super(ListAttributes.BAKU_MUNCH);
    }
    
    public void use(EntityPlayer player) {
      if (!this.isOnCooldown) {
        MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)player);
        if (mop != null && player.getDistance(mop.blockX, mop.blockY, mop.blockZ) < 5.0D)
          if (MainConfig.enableGriefing) {
            int i = 0;
            for (int x = -2; x < 2; x++) {
              for (int y = 0; y < 3; y++) {
                for (int z = -2; z < 2; z++) {
                  int posX = mop.blockX + x;
                  int posY = mop.blockY - y;
                  int posZ = mop.blockZ + z;
                  Block tempBlock = player.worldObj.getBlock(posX, posY, posZ);
                  if (DevilFruitsHelper.placeBlockIfAllowed(player.worldObj, posX, posY, posZ, Blocks.air, new String[] { "all", "restricted", "ignore liquids" })) {
                    player.inventory.addItemStackToInventory(new ItemStack(tempBlock));
                    WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("bakuMunch", posX, posY, posZ), player.dimension, posX, posY, posZ, 128.0D);
                  } 
                } 
              } 
            } 
            super.use(player);
          }  
      } 
    }
  }
}
