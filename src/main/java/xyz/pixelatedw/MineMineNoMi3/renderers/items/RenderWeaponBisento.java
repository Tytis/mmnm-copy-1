package xyz.pixelatedw.MineMineNoMi3.renderers.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderWeaponBisento implements IItemRenderer {
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
    IIcon iicon;
    Tessellator tessellator;
    float f;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    boolean isFirstPerson;
    switch (type) {
      case EQUIPPED:
        GL11.glPushMatrix();
        texturemanager = Minecraft.getMinecraft().getTextureManager();
        iicon = (Minecraft.getMinecraft()).thePlayer.getItemIcon(itemStack, 0);
        if (iicon == null) {
          GL11.glPopMatrix();
          return;
        } 
        texturemanager.bindTexture(texturemanager.getResourceLocation(itemStack.getItemSpriteNumber()));
        TextureUtil.func_152777_a(false, false, 1.0F);
        tessellator = Tessellator.instance;
        f = iicon.getMinU();
        f1 = iicon.getMaxU();
        f2 = iicon.getMinV();
        f3 = iicon.getMaxV();
        f4 = 0.0F;
        f5 = 0.3F;
        GL11.glEnable(32826);
        GL11.glTranslatef(-f4, -f5, 0.0F);
        f6 = 1.8F;
        GL11.glScalef(f6, f6, f6);
        GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(345.0F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-0.47F, 0.15F, 0.0F);
        GL11.glDisable(32826);
        texturemanager.bindTexture(texturemanager.getResourceLocation(itemStack.getItemSpriteNumber()));
        TextureUtil.func_147945_b();
        GL11.glPopMatrix();
      case EQUIPPED_FIRST_PERSON:
        GL11.glPushMatrix();
        texturemanager = Minecraft.getMinecraft().getTextureManager();
        iicon = (Minecraft.getMinecraft()).thePlayer.getItemIcon(itemStack, 0);
        if (iicon == null) {
          GL11.glPopMatrix();
          return;
        } 
        texturemanager.bindTexture(texturemanager.getResourceLocation(itemStack.getItemSpriteNumber()));
        TextureUtil.func_152777_a(false, false, 1.0F);
        tessellator = Tessellator.instance;
        f = iicon.getMinU();
        f1 = iicon.getMaxU();
        f2 = iicon.getMinV();
        f3 = iicon.getMaxV();
        f4 = 0.0F;
        f5 = 0.3F;
        GL11.glEnable(32826);
        GL11.glTranslatef(-f4, -f5, 0.0F);
        f6 = 2.2F;
        GL11.glScalef(f6 + 0.5F, f6, f6);
        GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(395.0F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-0.25F, -0.35F, 0.0F);
        isFirstPerson = false;
        if (data[1] != null && data[1] instanceof EntityPlayer)
          if ((EntityPlayer)data[1] != (Minecraft.getMinecraft()).renderViewEntity || (Minecraft.getMinecraft()).gameSettings.thirdPersonView != 0 || (((Minecraft.getMinecraft()).currentScreen instanceof net.minecraft.client.gui.inventory.GuiInventory || (Minecraft.getMinecraft()).currentScreen instanceof net.minecraft.client.gui.inventory.GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F)) {
            GL11.glTranslatef(-0.01F, 0.01F, 0.0F);
          } else {
            GL11.glRotatef(300.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.6F, 0.5F, -0.1F);
            GL11.glScalef(0.6F, 0.6F, 0.6F);
            isFirstPerson = true;
          }  
        ItemRenderer.renderItemIn2D(tessellator, f1, f2, f, f3, iicon.getIconWidth(), iicon.getIconHeight(), 0.0625F);
        GL11.glPopMatrix();
        break;
    } 
  }
}
