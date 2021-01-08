package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFist extends ModelBase {
  public ModelRenderer rightarm;
  
  public ModelRenderer righthand1;
  
  public ModelRenderer righthand2;
  
  public ModelRenderer rightfinger10;
  
  public ModelRenderer rightfinger11;
  
  public ModelRenderer rightfinger20;
  
  public ModelRenderer rightfinger21;
  
  public ModelRenderer rightfinger30;
  
  public ModelRenderer rightfinger31;
  
  public ModelRenderer rightfinger40;
  
  public ModelRenderer rightfinger41;
  
  public ModelRenderer rightfinger50;
  
  public ModelFist() {
    this.textureWidth = 64;
    this.textureHeight = 32;
    this.rightfinger41 = new ModelRenderer(this, 17, 10);
    this.rightfinger41.setRotationPoint(-1.3F, 7.0F, -14.0F);
    this.rightfinger41.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger41, 1.8849556F, -0.08726646F, 0.0F);
    this.rightfinger50 = new ModelRenderer(this, 17, 14);
    this.rightfinger50.setRotationPoint(0.1F, 6.3F, -12.7F);
    this.rightfinger50.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger50, 0.0640987F, 0.9545175F, 1.6946307F);
    this.rightfinger10 = new ModelRenderer(this, 17, 6);
    this.rightfinger10.setRotationPoint(-3.3F, 5.3F, -14.0F);
    this.rightfinger10.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger10, 0.0F, 0.08726646F, 0.0F);
    this.rightfinger30 = new ModelRenderer(this, 17, 6);
    this.rightfinger30.setRotationPoint(-2.3F, 5.3F, -14.1F);
    this.rightfinger30.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger30, 0.0F, -0.05235988F, 0.0F);
    this.rightarm = new ModelRenderer(this, 0, 0);
    this.rightarm.setRotationPoint(-2.3F, 6.0F, -0.1F);
    this.rightarm.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
    setRotateAngle(this.rightarm, -1.5707964F, -0.0F, 0.0F);
    this.righthand1 = new ModelRenderer(this, 17, 0);
    this.righthand1.setRotationPoint(-2.3F, 5.3F, -9.4F);
    this.righthand1.addBox(-2.0F, 0.0F, -0.5F, 4, 5, 1, 0.0F);
    setRotateAngle(this.righthand1, -1.5707964F, -0.0F, 0.0F);
    this.rightfinger31 = new ModelRenderer(this, 17, 10);
    this.rightfinger31.setRotationPoint(-2.3F, 7.0F, -14.1F);
    this.rightfinger31.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger31, 1.8849556F, -0.05235988F, 0.0F);
    this.rightfinger40 = new ModelRenderer(this, 17, 6);
    this.rightfinger40.setRotationPoint(-1.3F, 5.3F, -14.0F);
    this.rightfinger40.addBox(0.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger40, 0.0F, -0.08726646F, 0.0F);
    this.rightfinger11 = new ModelRenderer(this, 17, 10);
    this.rightfinger11.setRotationPoint(-3.3F, 7.0F, -14.0F);
    this.rightfinger11.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger11, 1.8675023F, 0.08726646F, 0.0F);
    this.rightfinger21 = new ModelRenderer(this, 17, 10);
    this.rightfinger21.setRotationPoint(-2.3F, 7.0F, -14.1F);
    this.rightfinger21.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger21, 1.8675023F, 0.05235988F, 0.0F);
    this.righthand2 = new ModelRenderer(this, 28, 0);
    this.righthand2.setRotationPoint(-1.4F, 5.4F, -10.3F);
    this.righthand2.addBox(0.0F, 0.0F, -0.5F, 1, 2, 2, 0.0F);
    setRotateAngle(this.righthand2, -1.5707964F, -0.43633232F, 0.0F);
    this.rightfinger20 = new ModelRenderer(this, 17, 6);
    this.rightfinger20.setRotationPoint(-2.3F, 5.3F, -14.1F);
    this.rightfinger20.addBox(-1.0F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightfinger20, 0.0F, 0.05235988F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.rightfinger41.render(f5);
    this.rightfinger50.render(f5);
    this.rightfinger10.render(f5);
    this.rightfinger30.render(f5);
    this.rightarm.render(f5);
    this.righthand1.render(f5);
    this.rightfinger31.render(f5);
    this.rightfinger40.render(f5);
    this.rightfinger11.render(f5);
    this.rightfinger21.render(f5);
    this.righthand2.render(f5);
    this.rightfinger20.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
