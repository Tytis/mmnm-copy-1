package xyz.pixelatedw.MineMineNoMi3.lists;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.thundercloud;

public class RenderSoru extends Render {
  private ResourceLocation texture = new ResourceLocation("mineminenomi", "textures/models/zoanmorph/thundercloud.png");
  
  private thundercloud model;
  
  private double scale;
  
  public RenderSoru(ModelBase model) {
    this.shadowSize = 0.0F;
    this.model = (thundercloud)model;
    this.scale = 1.0D;
  }
  
  public void doRender(Entity entity, double x, double y, double z, float u, float v) {
    GL11.glPushMatrix();
    GL11.glTranslatef((float)x, (float)y, (float)z);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * v - 180.0F, 0.0F, 1.0F, 0.0F);
    GL11.glScaled(1.5D, 1.0D, 1.5D);
    (Minecraft.getMinecraft()).renderEngine.bindTexture(this.texture);
    this.model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    GL11.glPopMatrix();
  }
  
  public ResourceLocation getEntityTexture(Entity entity) {
    return this.texture;
  }
}
