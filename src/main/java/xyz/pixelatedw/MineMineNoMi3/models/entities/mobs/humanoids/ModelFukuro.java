package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFukuro extends ModelBiped {
  ModelRenderer head;
  
  ModelRenderer body;
  
  ModelRenderer body_2;
  
  ModelRenderer rightarm;
  
  ModelRenderer leftarm;
  
  ModelRenderer rightleg;
  
  ModelRenderer leftleg;
  
  ModelRenderer zipper;
  
  ModelRenderer zipper_2;
  
  public ModelFukuro() {
    this.textureWidth = 128;
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
    this.head = new ModelRenderer((ModelBase)this, 0, 0);
    this.head.addBox(-4.0F, -8.0F, -4.0F, 12, 7, 8);
    this.head.setRotationPoint(-2.0F, -2.0F, -0.5F);
    this.head.setTextureSize(64, 32);
    this.head.mirror = true;
    setRotation(this.head, 0.0F, 0.0F, 0.0F);
    this.body = new ModelRenderer((ModelBase)this, 0, 16);
    this.body.addBox(-4.0F, 0.0F, -2.0F, 16, 18, 9);
    this.body.setRotationPoint(-4.0F, -3.0F, -3.0F);
    this.body.setTextureSize(64, 32);
    this.body.mirror = true;
    setRotation(this.body, 0.0F, 0.0F, 0.0F);
    this.body_2 = new ModelRenderer((ModelBase)this, 51, 16);
    this.body_2.addBox(0.0F, 0.0F, 0.0F, 15, 17, 10);
    this.body_2.setRotationPoint(-7.5F, -2.5F, -5.5F);
    this.body_2.setTextureSize(64, 32);
    this.body_2.mirror = true;
    setRotation(this.body_2, 0.0F, 0.0F, 0.0F);
    this.rightarm = new ModelRenderer((ModelBase)this, 102, 0);
    this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
    this.rightarm.setRotationPoint(-9.0F, -1.0F, 0.0F);
    this.rightarm.setTextureSize(64, 32);
    this.rightarm.mirror = true;
    setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
    this.leftarm = new ModelRenderer((ModelBase)this, 102, 0);
    this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
    this.leftarm.setRotationPoint(9.0F, -1.0F, 0.0F);
    this.leftarm.setTextureSize(64, 32);
    this.leftarm.mirror = true;
    setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
    this.rightleg = new ModelRenderer((ModelBase)this, 41, 0);
    this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
    this.rightleg.setRotationPoint(-3.0F, 15.0F, 0.0F);
    this.rightleg.setTextureSize(64, 32);
    this.rightleg.mirror = true;
    setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
    this.leftleg = new ModelRenderer((ModelBase)this, 41, 0);
    this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
    this.leftleg.setRotationPoint(3.0F, 15.0F, 0.0F);
    this.leftleg.setTextureSize(64, 32);
    this.leftleg.mirror = true;
    setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
    this.zipper = new ModelRenderer((ModelBase)this, 58, 0);
    this.zipper.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.zipper.setRotationPoint(4.0F, -6.0F, -5.0F);
    this.zipper.setTextureSize(64, 32);
    this.zipper.mirror = true;
    setRotation(this.zipper, 0.0F, 0.0F, 0.0F);
    this.zipper_2 = new ModelRenderer((ModelBase)this, 58, 3);
    this.zipper_2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 0);
    this.zipper_2.setRotationPoint(4.0F, -5.5F, -4.8F);
    this.zipper_2.setTextureSize(64, 32);
    this.zipper_2.mirror = true;
    setRotation(this.zipper_2, 0.0F, 0.0F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.bipedLeftLeg.isHidden = true;
    this.bipedRightLeg.isHidden = true;
    this.bipedLeftArm.isHidden = true;
    this.bipedRightArm.isHidden = true;
    this.head.render(f5);
    this.body.render(f5);
    this.body_2.render(f5);
    this.rightarm.render(f5);
    this.leftarm.render(f5);
    this.rightleg.render(f5);
    this.leftleg.render(f5);
    this.zipper.render(f5);
    this.zipper_2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, null);
    this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
    this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
    this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
  }
}
