package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMeigo extends ModelBase {
  public ModelRenderer leftarm1;
  
  public ModelRenderer leftarm2;
  
  public ModelRenderer leftarm3;
  
  public ModelRenderer leftarm4;
  
  public ModelRenderer leftarm5;
  
  public ModelRenderer leftarm6;
  
  public ModelRenderer leftarm7;
  
  public ModelRenderer lefthand;
  
  public ModelRenderer leftfinger10;
  
  public ModelRenderer leftfinger11;
  
  public ModelRenderer leftfinger20;
  
  public ModelRenderer leftfinger21;
  
  public ModelRenderer leftfinger30;
  
  public ModelRenderer leftfinger31;
  
  public ModelRenderer leftfinger40;
  
  public ModelRenderer leftfinger41;
  
  public ModelRenderer leftfinger50;
  
  public ModelRenderer leftfinger51;
  
  public ModelMeigo() {
    this.textureWidth = 64;
    this.textureHeight = 32;
    this.leftarm5 = new ModelRenderer(this, 13, 21);
    this.leftarm5.setRotationPoint(2.3F, 7.0F, 4.0F);
    this.leftarm5.addBox(-0.9F, 5.4F, -2.1F, 3, 5, 3, 0.0F);
    setRotateAngle(this.leftarm5, -1.5707964F, -0.0F, 0.0F);
    this.leftfinger31 = new ModelRenderer(this, 17, 10);
    this.leftfinger31.setRotationPoint(1.9F, 4.0F, -11.9F);
    this.leftfinger31.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger31, -0.80285144F, -0.0F, -0.017453292F);
    this.leftfinger21 = new ModelRenderer(this, 17, 10);
    this.leftfinger21.setRotationPoint(2.5F, 4.0F, -11.9F);
    this.leftfinger21.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger21, -0.80285144F, -0.0F, 0.017453292F);
    this.lefthand = new ModelRenderer(this, 17, 0);
    this.lefthand.setRotationPoint(2.3F, 7.0F, -10.0F);
    this.lefthand.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
    setRotateAngle(this.lefthand, -1.4835298F, -0.0F, 0.0F);
    this.leftarm6 = new ModelRenderer(this, 26, 21);
    this.leftarm6.setRotationPoint(2.3F, 7.0F, 4.0F);
    this.leftarm6.addBox(-0.8F, 9.6F, -0.9F, 3, 4, 3, 0.0F);
    setRotateAngle(this.leftarm6, -1.5707964F, -0.0F, 0.0F);
    this.leftfinger20 = new ModelRenderer(this, 17, 6);
    this.leftfinger20.setRotationPoint(2.4F, 5.0F, -10.4F);
    this.leftfinger20.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger20, -1.9547688F, -0.034906585F, 0.0F);
    this.leftfinger51 = new ModelRenderer(this, 22, 10);
    this.leftfinger51.setRotationPoint(0.0F, 8.2F, -12.1F);
    this.leftfinger51.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.leftfinger51, -1.5707964F, -0.10471976F, 0.0F);
    this.leftarm1 = new ModelRenderer(this, 0, 0);
    this.leftarm1.setRotationPoint(2.3F, 7.0F, 6.0F);
    this.leftarm1.addBox(-2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
    setRotateAngle(this.leftarm1, -1.5707964F, -0.0F, 0.0F);
    this.leftarm3 = new ModelRenderer(this, 0, 21);
    this.leftarm3.setRotationPoint(2.3F, 7.0F, 4.0F);
    this.leftarm3.addBox(-0.8F, 1.0F, -0.9F, 3, 5, 3, 0.0F);
    setRotateAngle(this.leftarm3, -1.5707964F, -0.0F, 0.0F);
    this.leftfinger40 = new ModelRenderer(this, 17, 6);
    this.leftfinger40.setRotationPoint(0.7F, 5.0F, -10.4F);
    this.leftfinger40.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger40, -1.9153445F, -0.01685853F, -0.26183748F);
    this.leftarm2 = new ModelRenderer(this, 0, 21);
    this.leftarm2.setRotationPoint(2.3F, 7.0F, 4.0F);
    this.leftarm2.addBox(-2.2F, 0.0F, -2.1F, 3, 5, 3, 0.0F);
    setRotateAngle(this.leftarm2, -1.5707964F, -0.0F, 0.0F);
    this.leftfinger10 = new ModelRenderer(this, 17, 6);
    this.leftfinger10.setRotationPoint(3.4F, 5.0F, -10.4F);
    this.leftfinger10.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger10, -1.9225928F, -0.017238392F, 0.15710317F);
    this.leftfinger11 = new ModelRenderer(this, 17, 10);
    this.leftfinger11.setRotationPoint(3.6F, 4.0F, -11.9F);
    this.leftfinger11.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger11, -0.80285144F, -0.0F, 0.13962634F);
    this.leftfinger41 = new ModelRenderer(this, 17, 10);
    this.leftfinger41.setRotationPoint(0.5F, 4.2F, -11.9F);
    this.leftfinger41.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger41, -0.80285144F, -0.0F, -0.2617994F);
    this.leftfinger30 = new ModelRenderer(this, 17, 6);
    this.leftfinger30.setRotationPoint(1.8F, 5.0F, -10.4F);
    this.leftfinger30.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger30, -1.9547688F, -0.034906585F, 0.0F);
    this.leftarm4 = new ModelRenderer(this, 13, 21);
    this.leftarm4.setRotationPoint(2.3F, 7.0F, 4.0F);
    this.leftarm4.addBox(-2.3F, 4.0F, -1.6F, 3, 5, 3, 0.0F);
    setRotateAngle(this.leftarm4, -1.5707964F, -0.0F, 0.0F);
    this.leftarm7 = new ModelRenderer(this, 26, 21);
    this.leftarm7.setRotationPoint(2.3F, 7.0F, 4.0F);
    this.leftarm7.addBox(-2.1F, 9.3F, -2.2F, 3, 4, 3, 0.0F);
    setRotateAngle(this.leftarm7, -1.5707964F, -0.0F, 0.0F);
    this.leftfinger50 = new ModelRenderer(this, 22, 6);
    this.leftfinger50.setRotationPoint(0.7F, 8.2F, -10.5F);
    this.leftfinger50.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger50, -1.5707964F, 0.38397244F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.leftarm5.render(f5);
    this.leftfinger31.render(f5);
    this.leftfinger21.render(f5);
    this.lefthand.render(f5);
    this.leftarm6.render(f5);
    this.leftfinger20.render(f5);
    this.leftfinger51.render(f5);
    this.leftarm1.render(f5);
    this.leftarm3.render(f5);
    this.leftfinger40.render(f5);
    this.leftarm2.render(f5);
    this.leftfinger10.render(f5);
    this.leftfinger11.render(f5);
    this.leftfinger41.render(f5);
    this.leftfinger30.render(f5);
    this.leftarm4.render(f5);
    this.leftarm7.render(f5);
    this.leftfinger50.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
