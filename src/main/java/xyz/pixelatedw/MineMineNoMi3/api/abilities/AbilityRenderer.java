package xyz.pixelatedw.MineMineNoMi3.api.abilities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class AbilityRenderer extends Render {
  private double scaleX;
  
  private double scaleY;
  
  private double scaleZ;
  
  private double rotAngle;
  
  private double rotX;
  
  private double rotY;
  
  private double rotZ;
  
  private double red;
  
  private double blue;
  
  private double green;
  
  private double renderPosX;
  
  private double renderPosY;
  
  private double renderPosZ;
  
  private float alpha;
  
  private ModelBase model;
  
  private AbilityAttribute ablAttr;
  
  private ResourceLocation texture;
  
  public AbilityRenderer(AbilityAttribute attr) {
    this.ablAttr = attr;
    this.texture = this.ablAttr.getProjectileTexture();
  }
  
  public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9) {
    this.scaleX = this.ablAttr.getProjectileSize()[0];
    this.scaleY = this.ablAttr.getProjectileSize()[1];
    this.scaleZ = this.ablAttr.getProjectileSize()[2];
    this.red = this.ablAttr.getProjectileColor().getRed();
    this.green = this.ablAttr.getProjectileColor().getGreen();
    this.blue = this.ablAttr.getProjectileColor().getBlue();
    this.alpha = this.ablAttr.getProjectileAlpha();
    this.rotX = this.ablAttr.getProjectileXRotation();
    this.rotY = this.ablAttr.getProjectileYRotation();
    this.rotZ = this.ablAttr.getProjectileZRotation();
    this.renderPosX = this.ablAttr.getModelOffsets()[0];
    this.renderPosY = this.ablAttr.getModelOffsets()[1];
    this.renderPosZ = this.ablAttr.getModelOffsets()[2];
    this.model = this.ablAttr.getProjectileModel();
    GL11.glPushMatrix();
    GL11.glTranslated(par2 + this.renderPosX, par4 + this.renderPosY, par6 + this.renderPosZ);
    if (this.texture == null)
      GL11.glDisable(3553); 
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 771);
    GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    if (this.rotX != 0.0D)
      GL11.glRotated(this.rotX, 1.0D, 0.0D, 0.0D); 
    if (this.rotY != 0.0D)
      GL11.glRotated(this.rotY, 0.0D, 1.0D, 0.0D); 
    if (this.rotZ != 0.0D)
      GL11.glRotated(this.rotZ, 0.0D, 0.0D, 1.0D); 
    GL11.glColor4f((float)this.red / 255.0F, (float)this.green / 255.0F, (float)this.blue / 255.0F, this.alpha / 255.0F);
    GL11.glScaled(this.scaleX, this.scaleY, this.scaleZ);
    if (this.texture != null)
      (Minecraft.getMinecraft()).renderEngine.bindTexture(getEntityTexture(entity)); 
    if (this.model != null)
      this.model.render(entity, (float)par2, (float)par4, (float)par6, 0.0F, 0.0F, 0.0625F); 
    GL11.glDisable(3042);
    if (this.texture == null)
      GL11.glEnable(3553); 
    GL11.glPopMatrix();
  }
  
  protected ResourceLocation getEntityTexture(Entity entity) {
    return this.texture;
  }
}
