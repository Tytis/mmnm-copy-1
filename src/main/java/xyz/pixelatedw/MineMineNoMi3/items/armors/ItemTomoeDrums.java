package xyz.pixelatedw.MineMineNoMi3.items.armors;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.models.armors.ModelTomoeDrums;

public class ItemTomoeDrums extends ItemArmor {
  public ItemTomoeDrums() {
    super(ItemArmor.ArmorMaterial.CHAIN, 1, 1);
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot) {
    ModelTomoeDrums model = new ModelTomoeDrums();
    return (ModelBiped)model;
  }
  
  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
    return String.format("%s:textures/armor/tomoe_drums.png", new Object[] { "mineminenomi" });
  }
}
