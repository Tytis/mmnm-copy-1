package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelBisonPower extends ModelZoanMorph {
  public ModelRenderer rightarm1;
  
  public ModelRenderer leftarm1;
  
  public ModelRenderer rightleg4;
  
  public ModelRenderer leftleg4;
  
  public ModelRenderer body2;
  
  public ModelRenderer rightarm2;
  
  public ModelRenderer righthull1;
  
  public ModelRenderer leftarm2;
  
  public ModelRenderer lefthull1;
  
  public ModelRenderer rightleg3;
  
  public ModelRenderer rightleg2;
  
  public ModelRenderer rightleg1;
  
  public ModelRenderer leftleg3;
  
  public ModelRenderer leftleg2;
  
  public ModelRenderer leftleg1;
  
  public ModelRenderer body1;
  
  public ModelRenderer body3;
  
  public ModelRenderer body4;
  
  public ModelRenderer body5;
  
  public ModelRenderer body6;
  
  public ModelRenderer head;
  
  public ModelRenderer righthorn1;
  
  public ModelRenderer righthorn2;
  
  public ModelRenderer lefthorn1;
  
  public ModelRenderer lefthorn2;
  
  public ModelBisonPower() {
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.rightleg4 = new ModelRenderer(this, 9, 30);
    this.rightleg4.setRotationPoint(-3.0F, 11.6F, 0.5F);
    this.rightleg4.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
    setRotateAngle(this.rightleg4, -0.34906584F, -0.0F, 0.0F);
    this.rightleg1 = new ModelRenderer(this, 0, 39);
    this.rightleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.rightleg1.addBox(-1.0F, 10.5F, -0.5F, 2, 2, 2, 0.0F);
    setRotateAngle(this.rightleg1, 0.5235988F, -0.0F, 0.0F);
    this.body1 = new ModelRenderer(this, 17, 0);
    this.body1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.body1.addBox(-5.0F, 9.9F, -2.0F, 10, 8, 5, 0.0F);
    this.lefthull1 = new ModelRenderer(this, 0, 25);
    this.lefthull1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.lefthull1.addBox(2.0F, 12.0F, -3.0F, 3, 3, 1, 0.0F);
    setRotateAngle(this.lefthull1, 0.17453292F, -0.0F, 0.0F);
    this.rightleg2 = new ModelRenderer(this, 0, 30);
    this.rightleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.rightleg2.addBox(-1.0F, 3.1F, 4.8F, 2, 6, 2, 0.0F);
    setRotateAngle(this.rightleg2, -2.0071287F, -0.0F, 0.0F);
    this.righthull1 = new ModelRenderer(this, 0, 25);
    this.righthull1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.righthull1.addBox(-4.3F, 12.0F, -3.0F, 3, 3, 1, 0.0F);
    setRotateAngle(this.righthull1, 0.17453292F, 0.0F, 0.017453292F);
    this.leftleg2 = new ModelRenderer(this, 0, 30);
    this.leftleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.leftleg2.addBox(-1.5F, 3.3F, 4.4F, 2, 6, 2, 0.0F);
    setRotateAngle(this.leftleg2, -2.0071287F, -0.0F, 0.0F);
    this.leftleg1 = new ModelRenderer(this, 0, 39);
    this.leftleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.leftleg1.addBox(-1.5F, 10.5F, -1.0F, 2, 2, 2, 0.0F);
    setRotateAngle(this.leftleg1, 0.5235988F, -0.0F, 0.0F);
    this.leftleg3 = new ModelRenderer(this, 9, 41);
    this.leftleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.leftleg3.addBox(-1.5F, -1.5F, -6.8F, 2, 4, 2, 0.0F);
    setRotateAngle(this.leftleg3, 1.8151424F, -0.0F, 0.0F);
    this.lefthorn1 = new ModelRenderer(this, 115, 0);
    this.lefthorn1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.lefthorn1.addBox(1.0F, 1.0F, -6.0F, 2, 1, 1, 0.0F);
    setRotateAngle(this.lefthorn1, 0.0F, -0.0F, -0.7330383F);
    this.righthorn2 = new ModelRenderer(this, 122, 0);
    this.righthorn2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.righthorn2.addBox(-1.3F, 2.5F, -6.0F, 2, 1, 1, 0.0F);
    setRotateAngle(this.righthorn2, 0.0F, 0.0F, 1.9198622F);
    this.rightleg3 = new ModelRenderer(this, 9, 41);
    this.rightleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.rightleg3.addBox(-1.0F, -0.9F, -6.8F, 2, 4, 2, 0.0F);
    setRotateAngle(this.rightleg3, 1.8151424F, -0.0F, 0.0F);
    this.head = new ModelRenderer(this, 0, 0);
    this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.head.addBox(-2.0F, -1.0F, -7.0F, 4, 5, 4, 0.0F);
    this.leftarm2 = new ModelRenderer(this, 23, 42);
    this.leftarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.leftarm2.addBox(2.0F, 5.8F, -2.0F, 3, 7, 3, 0.0F);
    setRotateAngle(this.leftarm2, 0.0F, -0.0F, 0.27925268F);
    this.lefthorn2 = new ModelRenderer(this, 122, 0);
    this.lefthorn2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.lefthorn2.addBox(-0.7F, 2.5F, -6.0F, 2, 1, 1, 0.0F);
    setRotateAngle(this.lefthorn2, 0.0F, -0.0F, -1.9198622F);
    this.body6 = new ModelRenderer(this, 83, 24);
    this.body6.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.body6.addBox(-4.5F, 0.0F, -0.5F, 9, 10, 6, 0.0F);
    setRotateAngle(this.body6, 0.41887903F, -0.0F, 0.0F);
    this.body3 = new ModelRenderer(this, 83, 0);
    this.body3.setRotationPoint(-3.5F, 4.0F, 0.0F);
    this.body3.addBox(-3.0F, -3.0F, -2.0F, 6, 7, 4, 0.0F);
    setRotateAngle(this.body3, 0.0F, 0.0F, -0.2617994F);
    this.righthorn1 = new ModelRenderer(this, 115, 0);
    this.righthorn1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.righthorn1.addBox(-3.0F, 1.0F, -6.0F, 2, 1, 1, 0.0F);
    setRotateAngle(this.righthorn1, 0.0F, -0.0F, 0.7330383F);
    this.leftarm1 = new ModelRenderer(this, 23, 30);
    this.leftarm1.setRotationPoint(5.0F, -2.6F, 0.0F);
    this.leftarm1.addBox(0.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
    setRotateAngle(this.leftarm1, 0.0F, -0.0F, -0.20943952F);
    this.leftleg4 = new ModelRenderer(this, 9, 30);
    this.leftleg4.setRotationPoint(3.5F, 11.6F, 1.0F);
    this.leftleg4.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
    setRotateAngle(this.leftleg4, -0.34906584F, -0.0F, 0.0F);
    this.rightarm1 = new ModelRenderer(this, 23, 30);
    this.rightarm1.setRotationPoint(-5.0F, -2.6F, 0.0F);
    this.rightarm1.addBox(-4.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
    setRotateAngle(this.rightarm1, 0.0F, -0.0F, 0.20943952F);
    this.body2 = new ModelRenderer(this, 48, 0);
    this.body2.setRotationPoint(0.0F, -5.0F, 0.0F);
    this.body2.addBox(-5.5F, 0.0F, -2.5F, 11, 10, 6, 0.0F);
    this.body4 = new ModelRenderer(this, 83, 0);
    this.body4.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.body4.addBox(1.5F, 0.0F, -2.0F, 6, 7, 4, 0.0F);
    setRotateAngle(this.body4, 0.0F, -0.0F, 0.2617994F);
    this.rightarm2 = new ModelRenderer(this, 23, 42);
    this.rightarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.rightarm2.addBox(-4.5F, 5.5F, -2.0F, 3, 7, 3, 0.0F);
    setRotateAngle(this.rightarm2, 0.0F, -0.0F, -0.27925268F);
    this.body5 = new ModelRenderer(this, 83, 12);
    this.body5.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.body5.addBox(-3.5F, 0.0F, -5.0F, 7, 7, 4, 0.0F);
    setRotateAngle(this.body5, 0.4886922F, -0.0F, 0.0F);
    this.rightleg2.addChild(this.rightleg1);
    this.body2.addChild(this.body1);
    this.leftarm2.addChild(this.lefthull1);
    this.rightleg3.addChild(this.rightleg2);
    this.rightarm2.addChild(this.righthull1);
    this.leftleg3.addChild(this.leftleg2);
    this.leftleg2.addChild(this.leftleg1);
    this.leftleg4.addChild(this.leftleg3);
    this.head.addChild(this.lefthorn1);
    this.head.addChild(this.righthorn2);
    this.rightleg4.addChild(this.rightleg3);
    this.body2.addChild(this.head);
    this.leftarm1.addChild(this.leftarm2);
    this.head.addChild(this.lefthorn2);
    this.body2.addChild(this.body6);
    this.body2.addChild(this.body3);
    this.head.addChild(this.righthorn1);
    this.body2.addChild(this.body4);
    this.rightarm1.addChild(this.rightarm2);
    this.body2.addChild(this.body5);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    EntityLivingBase entity = (EntityLivingBase)ent;
    this.head.rotateAngleY = headYaw / 85.943665F;
    this.head.rotateAngleX = headPitch / 114.59155F;
    this.leftleg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
    this.rightleg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.8F * limbSwingAmount;
    this.rightarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
    this.leftarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
    if (entity.isSwingInProgress) {
      this.rightarm1.rotateAngleX = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * 1.2F;
      this.rightarm1.rotateAngleY = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * -0.2F;
      this.rightarm1.rotateAngleZ = -MathHelper.cos(entity.swingProgress * 4.0F + 3.1415927F) * 0.5F;
    } 
    if (ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) <= 0.05000000074505806D && !entity.isSwingInProgress) {
      this.rightarm1.rotateAngleX = 0.0F;
      this.rightarm1.rotateAngleY = 0.0F;
      this.rightarm1.rotateAngleZ = 0.209F;
    } else if (!entity.isSwingInProgress && ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) > 0.0D) {
      this.rightarm1.rotateAngleY = 0.0F;
      this.rightarm1.rotateAngleZ = 0.209F;
    } 
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.rightleg4.render(f5);
    this.leftarm1.render(f5);
    this.leftleg4.render(f5);
    this.rightarm1.render(f5);
    this.body2.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public ModelRenderer getHandRenderer() {
    GL11.glScaled(1.2D, 1.2D, 1.0D);
    GL11.glTranslated(-0.1D, -0.1D, 0.05D);
    GL11.glRotated(-7.0D, 1.0D, 0.0D, 0.0D);
    GL11.glRotated(7.0D, 0.0D, 0.0D, 1.0D);
    return this.rightarm2;
  }
}
