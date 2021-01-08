package xyz.pixelatedw.MineMineNoMi3.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class SakeCup extends ItemFood {
  private IIcon filledIcon;
  
  public SakeCup() {
    super(0, false);
    setMaxStackSize(1);
  }
  
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    if (itemStack.getTagCompound() != null && itemStack.getTagCompound().getBoolean("IsFilled"))
      player.setItemInUse(itemStack, 32); 
    return itemStack;
  }
  
  public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
    if (!world.isRemote) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (!player.capabilities.isCreativeMode)
        WyTelemetry.addMiscStat("sakeCupsDrank", "Sake Cups Drank", 1); 
      itemStack.getTagCompound().setBoolean("IsFilled", false);
    } 
    return itemStack;
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister ir) {
    this.itemIcon = ir.registerIcon("mineminenomi:" + getUnlocalizedName().substring(5));
    try {
      Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("mineminenomi:textures/items/" + getUnlocalizedName().substring(5) + "_filled.png"));
    } catch (Exception e) {
      this.filledIcon = this.itemIcon;
    } 
    if (this.filledIcon != this.itemIcon)
      this.filledIcon = ir.registerIcon("mineminenomi:" + getUnlocalizedName().substring(5) + "_filled"); 
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIconIndex(ItemStack stack) {
    if (stack.getTagCompound() != null && stack.getTagCompound().getBoolean("IsFilled"))
      return this.filledIcon; 
    return this.itemIcon;
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
    if (stack.getTagCompound() != null && stack.getTagCompound().getBoolean("IsFilled"))
      return this.filledIcon; 
    return this.itemIcon;
  }
}
