package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBazooka extends ModelBase {
  public ModelRenderer rightarm;
  
  public ModelRenderer leftarm;
  
  public ModelRenderer righthand;
  
  public ModelRenderer rightfinger10;
  
  public ModelRenderer rightfinger11;
  
  public ModelRenderer rightfinger20;
  
  public ModelRenderer rightfinger21;
  
  public ModelRenderer rightfinger30;
  
  public ModelRenderer rightfinger31;
  
  public ModelRenderer rightfinger40;
  
  public ModelRenderer rightfinger41;
  
  public ModelRenderer rightfinger50;
  
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
  
  public ModelBazooka() {
    this.textureWidth = 64;
    this.textureHeight = 32;
    this.rightfinger20 = new ModelRenderer(this, 17, 6);
    this.rightfinger20.setRotationPoint(-3.9F, 7.5F, -10.4F);
    this.rightfinger20.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger20, -1.586163F, 0.17386198F, -0.0886057F);
    this.leftfinger21 = new ModelRenderer(this, 17, 10);
    this.leftfinger21.setRotationPoint(4.3F, 7.5F, -11.6F);
    this.leftfinger21.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.leftfinger21, -1.5551676F, 0.66025555F, 0.11057187F);
    this.leftfinger20 = new ModelRenderer(this, 17, 6);
    this.leftfinger20.setRotationPoint(3.9F, 7.5F, -10.4F);
    this.leftfinger20.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger20, -1.586163F, -0.17386198F, 0.0886057F);
    this.leftfinger10 = new ModelRenderer(this, 17, 6);
    this.leftfinger10.setRotationPoint(3.9F, 8.5F, -10.4F);
    this.leftfinger10.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger10, -1.5859874F, -0.08593739F, 0.17518608F);
    this.leftfinger31 = new ModelRenderer(this, 17, 10);
    this.leftfinger31.setRotationPoint(4.3F, 6.5F, -11.6F);
    this.leftfinger31.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.leftfinger31, -1.5709534F, 0.64393747F, -0.087335125F);
    this.rightfinger40 = new ModelRenderer(this, 17, 6);
    this.rightfinger40.setRotationPoint(-3.9F, 5.5F, -10.4F);
    this.rightfinger40.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger40, -1.5481565F, 0.08428574F, 0.2627541F);
    this.rightfinger41 = new ModelRenderer(this, 17, 10);
    this.rightfinger41.setRotationPoint(-4.3F, 5.4F, -11.6F);
    this.rightfinger41.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.rightfinger41, -1.5916333F, -0.78724486F, 0.24858259F);
    this.leftfinger50 = new ModelRenderer(this, 22, 6);
    this.leftfinger50.setRotationPoint(0.5F, 5.0F, -9.8F);
    this.leftfinger50.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger50, -2.0943952F, 0.08726646F, 0.0F);
    this.rightfinger21 = new ModelRenderer(this, 17, 10);
    this.rightfinger21.setRotationPoint(-4.3F, 7.5F, -11.6F);
    this.rightfinger21.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.rightfinger21, -1.5551676F, -0.66025555F, -0.11057187F);
    this.rightfinger50 = new ModelRenderer(this, 22, 6);
    this.rightfinger50.setRotationPoint(-0.5F, 5.0F, -9.8F);
    this.rightfinger50.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger50, -2.0943952F, -0.08726646F, 0.0F);
    this.lefthand = new ModelRenderer(this, 17, 0);
    this.lefthand.setRotationPoint(2.3F, 7.0F, -10.0F);
    this.lefthand.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
    setRotateAngle(this.lefthand, -1.5707964F, 0.17453292F, 0.0F);
    this.rightfinger30 = new ModelRenderer(this, 17, 6);
    this.rightfinger30.setRotationPoint(-3.9F, 6.5F, -10.4F);
    this.rightfinger30.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger30, -1.5554297F, 0.17386198F, 0.0886057F);
    this.leftfinger40 = new ModelRenderer(this, 17, 6);
    this.leftfinger40.setRotationPoint(3.9F, 5.5F, -10.4F);
    this.leftfinger40.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger40, -1.5481565F, -0.08428574F, -0.2627541F);
    this.rightarm = new ModelRenderer(this, 0, 0);
    this.rightarm.setRotationPoint(-2.3F, 7.0F, 0.0F);
    this.rightarm.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
    setRotateAngle(this.rightarm, -1.5707964F, -0.0F, 0.0F);
    this.leftarm = new ModelRenderer(this, 0, 0);
    this.leftarm.setRotationPoint(2.3F, 7.0F, 0.0F);
    this.leftarm.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
    setRotateAngle(this.leftarm, -1.5707964F, -0.0F, 0.0F);
    this.rightfinger31 = new ModelRenderer(this, 17, 10);
    this.rightfinger31.setRotationPoint(-4.3F, 6.5F, -11.6F);
    this.rightfinger31.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.rightfinger31, -1.5709534F, -0.64393747F, 0.087335125F);
    this.leftfinger30 = new ModelRenderer(this, 17, 6);
    this.leftfinger30.setRotationPoint(3.9F, 6.5F, -10.4F);
    this.leftfinger30.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftfinger30, -1.5554297F, -0.17386198F, -0.0886057F);
    this.righthand = new ModelRenderer(this, 17, 0);
    this.righthand.setRotationPoint(-2.3F, 7.0F, -10.0F);
    this.righthand.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
    setRotateAngle(this.righthand, -1.5707964F, -0.17453292F, 0.0F);
    this.rightfinger11 = new ModelRenderer(this, 17, 10);
    this.rightfinger11.setRotationPoint(-4.3F, 8.6F, -11.6F);
    this.rightfinger11.addBox(-1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.rightfinger11, -1.6060332F, -0.78160006F, -0.123102024F);
    this.rightfinger10 = new ModelRenderer(this, 17, 6);
    this.rightfinger10.setRotationPoint(-3.9F, 8.5F, -10.4F);
    this.rightfinger10.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger10, -1.5859874F, 0.08593739F, -0.17518608F);
    this.leftfinger41 = new ModelRenderer(this, 17, 10);
    this.leftfinger41.setRotationPoint(4.3F, 5.4F, -11.6F);
    this.leftfinger41.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.leftfinger41, -1.5916333F, 0.78724486F, -0.24858259F);
    this.leftfinger11 = new ModelRenderer(this, 17, 10);
    this.leftfinger11.setRotationPoint(4.3F, 8.6F, -11.6F);
    this.leftfinger11.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.leftfinger11, -1.6060332F, 0.78160006F, 0.123102024F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.rightfinger20.render(f5);
    this.leftfinger21.render(f5);
    this.leftfinger20.render(f5);
    this.leftfinger10.render(f5);
    this.leftfinger31.render(f5);
    this.rightfinger40.render(f5);
    this.rightfinger41.render(f5);
    this.leftfinger50.render(f5);
    this.rightfinger21.render(f5);
    this.rightfinger50.render(f5);
    this.lefthand.render(f5);
    this.rightfinger30.render(f5);
    this.leftfinger40.render(f5);
    this.rightarm.render(f5);
    this.leftarm.render(f5);
    this.rightfinger31.render(f5);
    this.leftfinger30.render(f5);
    this.righthand.render(f5);
    this.rightfinger11.render(f5);
    this.rightfinger10.render(f5);
    this.leftfinger41.render(f5);
    this.leftfinger11.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
