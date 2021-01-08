package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHattori extends ModelBiped {
  ModelRenderer Shape1;
  
  ModelRenderer Shape2;
  
  ModelRenderer Shape4;
  
  ModelRenderer Shape5;
  
  ModelRenderer Shape6;
  
  ModelRenderer Shape3;
  
  public ModelHattori() {
    this.textureWidth = 64;
    this.textureHeight = 64;
    this.bipedHeadwear = new ModelRenderer((ModelBase)this, 1, 1);
    this.bipedHeadwear.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0);
    this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedHeadwear.setTextureSize(64, 32);
    this.bipedHeadwear.mirror = true;
    setRotation(this.bipedHeadwear, 0.0F, 0.0F, 0.0F);
    this.bipedHead = new ModelRenderer((ModelBase)this, 1, 1);
    this.bipedHead.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0);
    this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedHead.setTextureSize(64, 32);
    this.bipedHead.mirror = true;
    setRotation(this.bipedHead, 0.0F, 0.0F, 0.0F);
    this.Shape1 = new ModelRenderer((ModelBase)this, 0, 0);
    this.Shape1.addBox(0.0F, 0.0F, 0.0F, 5, 6, 4);
    this.Shape1.setRotationPoint(-3.0F, 0.0F, -1.0F);
    this.Shape1.setTextureSize(64, 32);
    this.Shape1.mirror = true;
    setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
    this.Shape2 = new ModelRenderer((ModelBase)this, 18, 0);
    this.Shape2.addBox(-6.0F, 0.0F, -1.0F, 6, 0, 3);
    this.Shape2.setRotationPoint(-3.0F, 1.0F, 0.5F);
    this.Shape2.setTextureSize(64, 32);
    this.Shape2.mirror = true;
    setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
    this.Shape4 = new ModelRenderer((ModelBase)this, 6, 10);
    this.Shape4.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
    this.Shape4.setRotationPoint(-2.0F, -3.0F, -0.5F);
    this.Shape4.setTextureSize(64, 32);
    this.Shape4.mirror = true;
    setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
    this.Shape5 = new ModelRenderer((ModelBase)this, 0, 10);
    this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
    this.Shape5.setRotationPoint(-2.0F, 6.0F, 0.0F);
    this.Shape5.setTextureSize(64, 32);
    this.Shape5.mirror = true;
    setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
    this.Shape6 = new ModelRenderer((ModelBase)this, 0, 10);
    this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
    this.Shape6.setRotationPoint(0.0F, 6.0F, 0.0F);
    this.Shape6.setTextureSize(64, 32);
    this.Shape6.mirror = true;
    setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
    this.Shape3 = new ModelRenderer((ModelBase)this, 18, 0);
    this.Shape3.addBox(0.0F, 0.0F, 0.0F, 6, 0, 3);
    this.Shape3.setRotationPoint(2.0F, 1.0F, -0.5F);
    this.Shape3.setTextureSize(64, 32);
    this.Shape3.mirror = true;
    setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.Shape1.render(f5);
    this.Shape2.render(f5);
    this.Shape4.render(f5);
    this.Shape5.render(f5);
    this.Shape6.render(f5);
    this.Shape3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, null);
    this.Shape2.rotateAngleZ = MathHelper.cos(f2 * 0.6662F + 3.1415927F) * 2.0F * f3 * 0.5F;
    this.Shape3.rotateAngleZ = MathHelper.cos(f2 * 0.6662F + 3.1415927F) * 2.0F * f3 * 0.5F;
  }
}
