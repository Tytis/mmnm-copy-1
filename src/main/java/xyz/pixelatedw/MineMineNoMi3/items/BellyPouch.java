package xyz.pixelatedw.MineMineNoMi3.items;

import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class BellyPouch extends Item {
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    if (!world.isRemote) {
      int amount = 0;
      if (!itemStack.hasTagCompound()) {
        amount = (int)WyMathHelper.randomWithRange(5, 100);
      } else {
        amount = itemStack.getTagCompound().getInteger("belly");
      } 
      if (props.getBelly() <= 999999999 - amount) {
        props.alterBelly(amount);
        WyHelper.sendMsgToPlayer(player, "You've obtained " + amount + " belly !");
      } else {
        props.setBelly(999999999);
      } 
      if (!player.capabilities.isCreativeMode)
        WyTelemetry.addMiscStat("bellyEarnedFromPouches", "Belly Earned From Pouches", amount); 
      itemStack.stackSize--;
    } 
    return itemStack;
  }
  
  public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
    if (itemStack.hasTagCompound())
      list.add("Belly: " + itemStack.getTagCompound().getInteger("belly")); 
  }
}
