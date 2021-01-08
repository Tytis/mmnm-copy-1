package xyz.pixelatedw.MineMineNoMi3.entities.zoan;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

public class EntityRendererZoanEyes extends EntityRenderer {
  private final Minecraft mc;
  
  private double offsetY;
  
  public EntityRendererZoanEyes(Minecraft mc, double height) {
    super(mc, mc.getResourceManager());
    this.mc = mc;
    this.offsetY = height;
  }
  
  public void updateCameraAndRender(float partialTick) {
    if (this.mc.thePlayer == null || this.mc.thePlayer.isPlayerSleeping()) {
      super.updateCameraAndRender(partialTick);
      return;
    } 
    this.mc.thePlayer.yOffset = (float)(this.mc.thePlayer.yOffset - this.offsetY);
    super.updateCameraAndRender(partialTick);
    this.mc.thePlayer.yOffset = 1.62F;
  }
  
  public void getMouseOver(float partialTick) {
    if (this.mc.thePlayer == null || this.mc.thePlayer.isPlayerSleeping()) {
      super.getMouseOver(partialTick);
      return;
    } 
    this.mc.thePlayer.posY += this.offsetY;
    this.mc.thePlayer.prevPosY += this.offsetY;
    this.mc.thePlayer.lastTickPosY += this.offsetY;
    super.getMouseOver(partialTick);
    this.mc.thePlayer.posY -= this.offsetY;
    this.mc.thePlayer.prevPosY -= this.offsetY;
    this.mc.thePlayer.lastTickPosY -= this.offsetY;
  }
}
