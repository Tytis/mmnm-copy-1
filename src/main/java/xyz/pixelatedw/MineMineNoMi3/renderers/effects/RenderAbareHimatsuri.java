package xyz.pixelatedw.MineMineNoMi3.renderers.effects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.models.effects.ModelAbareHimatsuri;

public class RenderAbareHimatsuri extends Render {
  private ResourceLocation texture = new ResourceLocation("minecraft:textures/blocks/dirt.png");
  
  private int blockTint;
  
  private ModelAbareHimatsuri model;
  
  private double scale;
  
  public RenderAbareHimatsuri(ModelBase model) {
    this.shadowSize = 0.0F;
    this.model = (ModelAbareHimatsuri)model;
    this.scale = 1.0D;
  }
  
  public void doRender(Entity entity, double x, double y, double z, float u, float v) {
    GL11.glPushMatrix();
    GL11.glTranslatef((float)x, (float)y, (float)z);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * v - 180.0F, 0.0F, 1.0F, 0.0F);
    GL11.glScaled(1.5D, 1.0D, 1.5D);
    float red = (this.blockTint >> 16 & 0xFF) / 255.0F;
    float green = (this.blockTint >> 8 & 0xFF) / 255.0F;
    float blue = (this.blockTint & 0xFF) / 255.0F;
    GL11.glColor3d(red, green, blue);
    (Minecraft.getMinecraft()).renderEngine.bindTexture(this.texture);
    this.model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    GL11.glColor3d(1.0D, 1.0D, 1.0D);
    GL11.glPopMatrix();
  }
  
  public void setTextureAndTint(String texture, int tint) {
    this.texture = new ResourceLocation("minecraft:textures/blocks/" + texture + ".png");
    this.blockTint = tint;
  }
  
  public ResourceLocation getEntityTexture(Entity entity) {
    return this.texture;
  }
}
