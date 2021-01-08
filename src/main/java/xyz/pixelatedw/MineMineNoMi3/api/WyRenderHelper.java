package xyz.pixelatedw.MineMineNoMi3.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class WyRenderHelper {
  public static void drawStringWithBorder(String text, int posX, int posY, int color) {
    FontRenderer font = (Minecraft.getMinecraft()).fontRenderer;
    font.drawString(text, posX, posY - 1, 1);
    font.drawString(text, posX, posY + 1, 1);
    font.drawString(text, posX + 1, posY, 1);
    font.drawString(text, posX - 1, posY, 1);
    font.drawString(text, posX, posY, color);
  }
  
  public static double[] generateAnimationArray(double startPos, double minPos, double maxPos, double frameSkip, int framesPerSlot) {
    int framesCount = 0;
    double currentFrame = startPos;
    boolean hasReachedMaxPos = false;
    boolean hasReachedMinPos = false;
    double i;
    for (i = startPos; i <= maxPos; i += frameSkip)
      framesCount++; 
    for (i = maxPos; i > minPos; i -= frameSkip)
      framesCount++; 
    for (i = minPos; i <= startPos; i += frameSkip)
      framesCount++; 
    framesCount *= framesPerSlot;
    framesCount -= 1 * framesPerSlot;
    double[] animation = new double[framesCount];
    for (int j = 0; j < framesCount; j++) {
      for (int k = 0; k < framesPerSlot; k++) {
        if (j + 1 < framesCount) {
          if (k > 0)
            j++; 
          animation[j] = currentFrame;
        } 
      } 
      if (!hasReachedMaxPos && currentFrame < maxPos) {
        currentFrame += frameSkip;
      } else if (!hasReachedMinPos && hasReachedMaxPos && currentFrame > minPos) {
        currentFrame -= frameSkip;
      } else if (hasReachedMinPos && currentFrame < startPos) {
        currentFrame += frameSkip;
      } 
      if (currentFrame >= maxPos)
        hasReachedMaxPos = true; 
      if (currentFrame <= minPos)
        hasReachedMinPos = true; 
    } 
    return animation;
  }
  
  public static void drawColourOnScreen(int colour, int alpha, double posX, double posY, double width, double height, double zLevel) {
    int r = colour >> 16 & 0xFF;
    int g = colour >> 8 & 0xFF;
    int b = colour & 0xFF;
    drawColourOnScreen(r, g, b, alpha, posX, posY, width, height, zLevel);
  }
  
  public static void drawColourOnScreen(int r, int g, int b, int alpha, double posX, double posY, double width, double height, double zLevel) {
    if (width <= 0.0D || height <= 0.0D)
      return; 
    GL11.glPushMatrix();
    GL11.glColorMask(true, true, true, true);
    GL11.glDisable(3553);
    Tessellator tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    tessellator.setColorRGBA(r, g, b, alpha);
    tessellator.addVertex(posX, posY + height, zLevel);
    tessellator.addVertex(posX + width, posY + height, zLevel);
    tessellator.addVertex(posX + width, posY, zLevel);
    tessellator.addVertex(posX, posY, zLevel);
    tessellator.draw();
    GL11.glEnable(3553);
    GL11.glPopMatrix();
  }
  
  public static void renderTestStencil() {
    Minecraft mc = Minecraft.getMinecraft();
    ScaledResolution reso = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
    EntityClientPlayerMP entityClientPlayerMP = mc.thePlayer;
    GL11.glEnable(2960);
    GL11.glColorMask(false, false, false, false);
    GL11.glDepthMask(false);
    GL11.glStencilFunc(512, 1, 255);
    GL11.glStencilOp(7681, 7680, 7680);
    GL11.glStencilMask(255);
    GL11.glClear(1024);
    GL11.glColor3d(255.0D, 0.0D, 0.0D);
    drawEntityOnScreen((int)reso.getScaledWidth_double() / 2, (int)reso.getScaledHeight_double() / 2, 64, 0.0F, 0.0F, (EntityLivingBase)mc.thePlayer);
    GL11.glColorMask(true, true, true, true);
    GL11.glDepthMask(true);
    GL11.glStencilMask(0);
    GL11.glStencilFunc(514, 0, 255);
    GL11.glStencilFunc(514, 1, 255);
    GL11.glColor3d(255.0D, 0.0D, 0.0D);
    drawEntityOnScreen((int)reso.getScaledWidth_double() / 2, (int)reso.getScaledHeight_double() / 2, 64, 0.0F, 0.0F, (EntityLivingBase)mc.thePlayer);
    GL11.glDisable(2960);
  }
  
  public static void drawAbilityIcon(String iconName, int x, int y, int u, int v) {
    Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("mineminenomi", "textures/abilities/" + WyHelper.getFancyName(iconName) + ".png"));
    Tessellator tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    tessellator.addVertexWithUV(x, (y + v), 0.0D, 0.0D, 1.0D);
    tessellator.addVertexWithUV((x + u), (y + v), 0.0D, 1.0D, 1.0D);
    tessellator.addVertexWithUV((x + u), y, 0.0D, 1.0D, 0.0D);
    tessellator.addVertexWithUV(x, y, 0.0D, 0.0D, 0.0D);
    tessellator.draw();
  }
  
  public static void drawDevilFruitIcon(String iconName, int x, int y, int u, int v) {
    Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("mineminenomi", "textures/items/" + WyHelper.getFancyName(iconName) + ".png"));
    Tessellator tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    tessellator.addVertexWithUV(x, (y + v), 0.0D, 0.0D, 1.0D);
    tessellator.addVertexWithUV((x + u), (y + v), 0.0D, 1.0D, 1.0D);
    tessellator.addVertexWithUV((x + u), y, 0.0D, 1.0D, 0.0D);
    tessellator.addVertexWithUV(x, y, 0.0D, 0.0D, 0.0D);
    tessellator.draw();
  }
  
  public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase entity) {
    GL11.glEnable(2903);
    GL11.glPushMatrix();
    GL11.glTranslatef(posX, posY, 50.0F);
    GL11.glScalef(-scale, scale, scale);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    float f2 = entity.renderYawOffset;
    float f3 = entity.rotationYaw;
    float f4 = entity.rotationPitch;
    float f5 = entity.prevRotationYawHead;
    float f6 = entity.rotationYawHead;
    GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
    RenderHelper.enableStandardItemLighting();
    GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(-((float)Math.atan((mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
    entity.renderYawOffset = (float)Math.atan((mouseX / 40.0F)) * 20.0F;
    entity.rotationYaw = (float)Math.atan((mouseX / 40.0F)) * 40.0F;
    entity.rotationPitch = -((float)Math.atan((mouseY / 40.0F))) * 20.0F;
    entity.rotationYawHead = entity.rotationYaw;
    entity.prevRotationYawHead = entity.rotationYaw;
    GL11.glTranslatef(0.0F, entity.yOffset, 0.0F);
    RenderManager.instance.playerViewY = 180.0F;
    RenderManager.instance.renderEntityWithPosYaw((Entity)entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
    entity.renderYawOffset = f2;
    entity.rotationYaw = f3;
    entity.rotationPitch = f4;
    entity.prevRotationYawHead = f5;
    entity.rotationYawHead = f6;
    GL11.glPopMatrix();
    RenderHelper.disableStandardItemLighting();
    GL11.glDisable(32826);
    OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
    GL11.glDisable(3553);
    OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
  }
  
  public static void startGlScissor(int x, int y, int width, int height) {
    Minecraft mc = Minecraft.getMinecraft();
    ScaledResolution scaledRes = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
    double scaleW = mc.displayWidth / scaledRes.getScaledWidth_double();
    double scaleH = mc.displayHeight / scaledRes.getScaledHeight_double();
    if (width <= 0 || height <= 0)
      return; 
    if (x < 0)
      x = 0; 
    if (y < 0)
      y = 0; 
    GL11.glEnable(3089);
    GL11.glScissor((int)Math.floor(x * scaleW), (int)Math.floor(mc.displayHeight - (y + height) * scaleH), (int)Math.floor((x + width) * scaleW) - (int)Math.floor(x * scaleW), (int)Math.floor(mc.displayHeight - y * scaleH) - (int)Math.floor(mc.displayHeight - (y + height) * scaleH));
  }
  
  public static void endGlScissor() {
    GL11.glDisable(3089);
  }
}
