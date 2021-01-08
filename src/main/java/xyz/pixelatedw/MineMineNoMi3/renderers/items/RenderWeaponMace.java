package xyz.pixelatedw.MineMineNoMi3.renderers.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.models.items.ModelWeaponMace;

public class RenderWeaponMace implements IItemRenderer {
  private ModelWeaponMace model = new ModelWeaponMace();
  
  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
    switch (type) {
      case EQUIPPED:
        return true;
      case EQUIPPED_FIRST_PERSON:
        return true;
    } 
    return false;
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
    return false;
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... data) {
    TextureManager texturemanager;
    float f4;
    float f5;
    float f6;
    boolean isFirstPerson;
    switch (type) {
      case EQUIPPED:
        GL11.glPushMatrix();
        GL11.glPopMatrix();
      case EQUIPPED_FIRST_PERSON:
        GL11.glPushMatrix();
        texturemanager = Minecraft.getMinecraft().getTextureManager();
        texturemanager.bindTexture(new ResourceLocation("mineminenomi", "textures/models/items/mace.png"));
        f4 = 0.0F;
        f5 = 0.3F;
        GL11.glEnable(32826);
        GL11.glTranslatef(-f4, -f5, 0.0F);
        f6 = 0.11F;
        GL11.glScalef(f6, f6, f6);
        GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(270.0F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(4.0F, 2.0F, 1.5F);
        this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
        isFirstPerson = false;
        if (data[1] != null && data[1] instanceof EntityPlayer)
          if ((EntityPlayer)data[1] != (Minecraft.getMinecraft()).renderViewEntity || (Minecraft.getMinecraft()).gameSettings.thirdPersonView != 0 || (((Minecraft.getMinecraft()).currentScreen instanceof net.minecraft.client.gui.inventory.GuiInventory || (Minecraft.getMinecraft()).currentScreen instanceof net.minecraft.client.gui.inventory.GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F)) {
            GL11.glTranslatef(-0.01F, 0.01F, 0.0F);
          } else {
            GL11.glTranslatef(0.15F, 0.11F, -0.05F);
            GL11.glScalef(0.6F, 0.6F, 0.6F);
            isFirstPerson = true;
          }  
        GL11.glPopMatrix();
        break;
    } 
  }
}
