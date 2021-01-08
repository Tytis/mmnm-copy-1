package xyz.pixelatedw.MineMineNoMi3.items.dials;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ExtraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class DialAxe extends Item {
  public DialAxe() {
    setMaxStackSize(16);
    setMaxDamage(2);
  }
  
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    if (!world.isRemote)
      if (!player.isSneaking()) {
        ExtraProjectiles.AxeDialProjectile proj = new ExtraProjectiles.AxeDialProjectile(player.worldObj, (EntityLivingBase)player, ListExtraAttributes.DIAL_AXE);
        world.spawnEntityInWorld((Entity)proj);
        if (!player.capabilities.isCreativeMode)
          WyTelemetry.addMiscStat("axeDialsUsed", "Axe Dials Used", 1); 
        itemStack.damageItem(2, (EntityLivingBase)player);
      }  
    return itemStack;
  }
  
  public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int i1, int i2, int i3, int i4, float f1, float f2, float f3) {
    if (!world.isRemote && player.isSneaking()) {
      world.setBlock(i1, i2 + 1, i3, ListMisc.DialAxeBlock);
      itemStack.stackSize--;
    } 
    return false;
  }
}
