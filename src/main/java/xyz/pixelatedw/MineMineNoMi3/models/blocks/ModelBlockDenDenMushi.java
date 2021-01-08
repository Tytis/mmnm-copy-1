package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelBlockDenDenMushi extends ModelBase {
  ModelRenderer Shape1;
  
  ModelRenderer Shape2;
  
  ModelRenderer Shape3;
  
  ModelRenderer Shape4;
  
  ModelRenderer Shape5;
  
  ModelRenderer Shape6;
  
  ModelRenderer Shape7;
  
  ModelRenderer Shape8;
  
  ModelRenderer Shape9;
  
  ModelRenderer Shape10;
  
  public ModelBlockDenDenMushi() {
    this.textureWidth = 64;
    this.textureHeight = 64;
    this.Shape1 = new ModelRenderer(this, 0, 0);
    this.Shape1.addBox(-2.0F, 0.0F, -3.0F, 5, 1, 9);
    this.Shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape1.setTextureSize(64, 64);
    this.Shape1.mirror = true;
    setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
    this.Shape2 = new ModelRenderer(this, 21, 11);
    this.Shape2.addBox(-1.0F, -3.0F, -3.0F, 3, 3, 3);
    this.Shape2.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape2.setTextureSize(64, 64);
    this.Shape2.mirror = true;
    setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
    this.Shape3 = new ModelRenderer(this, 0, 11);
    this.Shape3.addBox(-2.0F, -5.0F, 0.0F, 5, 5, 5);
    this.Shape3.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape3.setTextureSize(64, 64);
    this.Shape3.mirror = true;
    setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
    this.Shape4 = new ModelRenderer(this, 29, 0);
    this.Shape4.addBox(-1.0F, -5.0F, -2.0F, 1, 2, 1);
    this.Shape4.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape4.setTextureSize(64, 64);
    this.Shape4.mirror = true;
    setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
    this.Shape5 = new ModelRenderer(this, 34, 3);
    this.Shape5.addBox(-1.666667F, -7.0F, -2.5F, 2, 2, 2);
    this.Shape5.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape5.setTextureSize(64, 64);
    this.Shape5.mirror = true;
    setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
    this.Shape6 = new ModelRenderer(this, 29, 0);
    this.Shape6.addBox(1.0F, -5.0F, -2.0F, 1, 2, 1);
    this.Shape6.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape6.setTextureSize(64, 64);
    this.Shape6.mirror = true;
    setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
    this.Shape7 = new ModelRenderer(this, 34, 3);
    this.Shape7.addBox(0.7F, -7.0F, -2.5F, 2, 2, 2);
    this.Shape7.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape7.setTextureSize(64, 64);
    this.Shape7.mirror = true;
    setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
    this.Shape8 = new ModelRenderer(this, 48, 0);
    this.Shape8.addBox(-3.0F, -4.0F, 1.0F, 1, 3, 3);
    this.Shape8.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape8.setTextureSize(64, 64);
    this.Shape8.mirror = true;
    setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
    this.Shape9 = new ModelRenderer(this, 48, 7);
    this.Shape9.addBox(-2.0F, -6.0F, 1.5F, 5, 1, 2);
    this.Shape9.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape9.setTextureSize(64, 64);
    this.Shape9.mirror = true;
    setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
    this.Shape10 = new ModelRenderer(this, 43, 0);
    this.Shape10.addBox(-3.0F, -6.0F, 2.0F, 1, 2, 1);
    this.Shape10.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.Shape10.setTextureSize(64, 64);
    this.Shape10.mirror = true;
    setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
  }
  
  public void render() {
    this.Shape1.render(0.0625F);
    this.Shape2.render(0.0625F);
    this.Shape3.render(0.0625F);
    this.Shape4.render(0.0625F);
    this.Shape5.render(0.0625F);
    this.Shape6.render(0.0625F);
    this.Shape7.render(0.0625F);
    this.Shape8.render(0.0625F);
    this.Shape9.render(0.0625F);
    this.Shape10.render(0.0625F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
