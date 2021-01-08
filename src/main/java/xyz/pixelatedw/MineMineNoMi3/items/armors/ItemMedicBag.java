package xyz.pixelatedw.MineMineNoMi3.items.armors;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.models.armors.ModelMedicBag;

public class ItemMedicBag extends ItemArmor {
  public ItemMedicBag() {
    super(ItemArmor.ArmorMaterial.CHAIN, 1, 1);
    setMaxDamage(1000);
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot) {
    ModelMedicBag model = new ModelMedicBag();
    return (ModelBiped)model;
  }
  
  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
    return String.format("%s:textures/armor/medic_bag.png", new Object[] { "mineminenomi" });
  }
}
