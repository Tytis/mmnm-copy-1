package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMilkyDial extends ModelBase {
  public ModelRenderer shellA1;
  
  public ModelRenderer shellA2;
  
  public ModelRenderer shellA3;
  
  public ModelRenderer shellA4;
  
  public ModelRenderer shellA5;
  
  public ModelRenderer shellA6;
  
  public ModelRenderer shellB1;
  
  public ModelRenderer shellB2;
  
  public ModelRenderer shellB3;
  
  public ModelRenderer shellB4;
  
  public ModelMilkyDial() {
    this.textureWidth = 50;
    this.textureHeight = 25;
    this.shellA5 = new ModelRenderer(this, 0, 17);
    this.shellA5.setRotationPoint(-1.6F, 23.4F, 0.5F);
    this.shellA5.addBox(-2.0F, -1.0F, -2.5F, 4, 2, 5, 0.0F);
    setRotateAngle(this.shellA5, 0.23765174F, 0.34354183F, 0.18548633F);
    this.shellB1 = new ModelRenderer(this, 19, 0);
    this.shellB1.setRotationPoint(0.0F, 21.8F, 3.5F);
    this.shellB1.addBox(-2.5F, -1.0F, -1.0F, 5, 3, 2, 0.0F);
    setRotateAngle(this.shellB1, -0.34906584F, -0.0F, 0.0F);
    this.shellA1 = new ModelRenderer(this, 0, 0);
    this.shellA1.setRotationPoint(0.0F, 23.4F, 1.0F);
    this.shellA1.addBox(-2.0F, -1.0F, -2.0F, 4, 2, 4, 0.0F);
    setRotateAngle(this.shellA1, 0.17453292F, -0.0F, 0.0F);
    this.shellA4 = new ModelRenderer(this, 0, 12);
    this.shellA4.setRotationPoint(1.5F, 23.5F, -2.9F);
    this.shellA4.addBox(0.0F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
    setRotateAngle(this.shellA4, -0.15707964F, -0.29670596F, 0.0F);
    this.shellB2 = new ModelRenderer(this, 19, 6);
    this.shellB2.setRotationPoint(0.0F, 21.6F, 1.1F);
    this.shellB2.addBox(-2.0F, -1.0F, -2.5F, 4, 1, 5, 0.0F);
    setRotateAngle(this.shellB2, 0.17453292F, -0.0F, 0.0F);
    this.shellB4 = new ModelRenderer(this, 19, 13);
    this.shellB4.setRotationPoint(-2.1F, 21.6F, 0.9F);
    this.shellB4.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 4, 0.0F);
    setRotateAngle(this.shellB4, 0.19246194F, 0.34238675F, -0.20397833F);
    this.shellA3 = new ModelRenderer(this, 0, 12);
    this.shellA3.setRotationPoint(-1.5F, 23.5F, -2.9F);
    this.shellA3.addBox(-3.0F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
    setRotateAngle(this.shellA3, -0.15707964F, 0.29670596F, 0.0F);
    this.shellA6 = new ModelRenderer(this, 0, 17);
    this.shellA6.setRotationPoint(1.6F, 23.4F, 0.5F);
    this.shellA6.addBox(-2.0F, -1.0F, -2.5F, 4, 2, 5, 0.0F);
    setRotateAngle(this.shellA6, 2.903941F, 0.34354192F, 2.9561064F);
    this.shellA2 = new ModelRenderer(this, 0, 7);
    this.shellA2.setRotationPoint(0.0F, 23.5F, -2.9F);
    this.shellA2.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
    setRotateAngle(this.shellA2, -0.15707964F, -0.0F, 0.0F);
    this.shellB3 = new ModelRenderer(this, 19, 13);
    this.shellB3.setRotationPoint(2.1F, 21.6F, 0.9F);
    this.shellB3.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 4, 0.0F);
    setRotateAngle(this.shellB3, 2.9491308F, 0.34238684F, -2.9376142F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.shellA5.render(f5);
    this.shellB1.render(f5);
    this.shellA1.render(f5);
    this.shellA4.render(f5);
    this.shellB2.render(f5);
    this.shellB4.render(f5);
    this.shellA3.render(f5);
    this.shellA6.render(f5);
    this.shellA2.render(f5);
    this.shellB3.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
