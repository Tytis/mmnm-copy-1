package xyz.pixelatedw.MineMineNoMi3.items;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class UltraCola extends ItemFood {
  public UltraCola() {
    super(0, false);
    this.maxStackSize = 16;
  }
  
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    player.setItemInUse(itemStack, 32);
    return itemStack;
  }
  
  public EnumAction getItemUseAction(ItemStack itemStack) {
    return EnumAction.drink;
  }
  
  public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
    if (!world.isRemote) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (props.isCyborg()) {
        if (props.getUltraColaConsumed() <= 9) {
          props.addUltraCola();
          props.setMaxCola(props.getMaxCola() + 15);
          if (props.getCola() + 10 > props.getMaxCola()) {
            props.setCola(props.getMaxCola());
          } else {
            props.alterCola(10);
          } 
        } else {
          player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 0));
          player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 0));
          player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 0));
          if (props.getCola() <= props.getMaxCola() - 30) {
            props.alterCola(30);
          } else {
            props.setCola(props.getMaxCola());
          } 
        } 
      } else {
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 250, 0));
      } 
      if (!player.capabilities.isCreativeMode)
        WyTelemetry.addMiscStat("bottlesOfUltraColaDrank", "Bottles of Ultra Cola Drank", 1); 
      WyNetworkHelper.sendTo((IMessage)new PacketSync(props), (EntityPlayerMP)player);
    } 
  }
}
