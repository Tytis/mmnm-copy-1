package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class smilodon extends ModelZoanMorph {
  public final ModelRenderer lowerBody;
  
  public final ModelRenderer leftFrontThigh;
  
  public final ModelRenderer rightFrontThigh;
  
  public final ModelRenderer rightHindThigh;
  
  public final ModelRenderer leftHindThigh;
  
  public final ModelRenderer upperBody;
  
  public final ModelRenderer tail;
  
  public final ModelRenderer neck;
  
  public final ModelRenderer head;
  
  public final ModelRenderer upperJaw;
  
  public final ModelRenderer lowerJaw;
  
  public final ModelRenderer leftEar;
  
  public final ModelRenderer rightEar;
  
  public final ModelRenderer nose;
  
  public final ModelRenderer upperRightFang;
  
  public final ModelRenderer upperLeftFang;
  
  public final ModelRenderer leftFrontLeg;
  
  public final ModelRenderer rightFrontLeg;
  
  public final ModelRenderer rightHindLeg;
  
  public final ModelRenderer leftHindLeg;
  
  public smilodon() {
    this.textureWidth = 64;
    this.textureHeight = 32;
    this.lowerJaw = new ModelRenderer(this, 17, 10);
    this.lowerJaw.setRotationPoint(0.0F, 1.2F, -2.4F);
    this.lowerJaw.addBox(-1.0F, 0.5F, -3.0F, 2, 1, 3, 0.0F);
    this.neck = new ModelRenderer(this, 20, 16);
    this.neck.setRotationPoint(0.0F, -0.4F, -6.5F);
    this.neck.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4, 0.0F);
    setRotationAngle(this.neck, -0.13665928F, -0.0F, 0.0F);
    this.leftEar = new ModelRenderer(this, 6, 8);
    this.leftEar.setRotationPoint(2.1F, -1.2F, -0.5F);
    this.leftEar.addBox(-0.5F, -1.0F, -1.0F, 1, 1, 2, 0.0F);
    setRotationAngle(this.leftEar, -0.05235988F, -0.0F, 0.0F);
    this.leftHindThigh = new ModelRenderer(this, 42, 0);
    this.leftHindThigh.setRotationPoint(-1.5F, 14.0F, 5.8F);
    this.leftHindThigh.addBox(-2.0F, -1.0F, -1.5F, 2, 6, 3, 0.0F);
    this.rightEar = new ModelRenderer(this, 6, 8);
    this.rightEar.mirror = true;
    this.rightEar.setRotationPoint(-2.1F, -1.2F, -0.5F);
    this.rightEar.addBox(-0.5F, -1.0F, -1.0F, 1, 1, 2, 0.0F);
    setRotationAngle(this.rightEar, -0.05235988F, -0.0F, 0.0F);
    this.rightHindLeg = new ModelRenderer(this, 34, 8);
    this.rightHindLeg.setRotationPoint(1.0F, 4.0F, 0.8F);
    this.rightHindLeg.addBox(-1.1F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rightFrontThigh = new ModelRenderer(this, 52, 0);
    this.rightFrontThigh.mirror = true;
    this.rightFrontThigh.setRotationPoint(-2.0F, 12.5F, -4.5F);
    this.rightFrontThigh.addBox(-2.0F, -1.0F, -1.5F, 2, 7, 3, 0.0F);
    this.rightFrontLeg = new ModelRenderer(this, 34, 0);
    this.rightFrontLeg.mirror = true;
    this.rightFrontLeg.setRotationPoint(-0.9F, 5.5F, -0.4F);
    this.rightFrontLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.upperBody = new ModelRenderer(this, 30, 19);
    this.upperBody.setRotationPoint(0.0F, 2.4F, 1.5F);
    this.upperBody.addBox(-3.0F, -2.5F, -7.0F, 6, 6, 7, 0.0F);
    setRotationAngle(this.upperBody, -0.04171337F, -0.0F, 0.0F);
    this.rightHindThigh = new ModelRenderer(this, 42, 0);
    this.rightHindThigh.setRotationPoint(1.5F, 14.0F, 5.8F);
    this.rightHindThigh.addBox(0.0F, -1.0F, -1.5F, 2, 6, 3, 0.0F);
    this.nose = new ModelRenderer(this, 18, 0);
    this.nose.setRotationPoint(0.0F, -1.7F, -0.2F);
    this.nose.addBox(-1.0F, -0.5F, -3.0F, 2, 2, 3, 0.0F);
    setRotationAngle(this.nose, 0.13665928F, -0.0F, 0.0F);
    this.head = new ModelRenderer(this, 0, 0);
    this.head.setRotationPoint(0.0F, -0.4F, -3.3F);
    this.head.addBox(-2.5F, -1.5F, -3.0F, 5, 4, 3, 0.0F);
    setRotationAngle(this.head, 0.4553564F, -0.0F, 0.0F);
    this.upperLeftFang = new ModelRenderer(this, 45, 14);
    this.upperLeftFang.setRotationPoint(1.0F, 1.0F, -2.12F);
    this.upperLeftFang.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotationAngle(this.upperLeftFang, 0.004537856F, -0.0F, 0.0F);
    this.leftFrontThigh = new ModelRenderer(this, 52, 0);
    this.leftFrontThigh.setRotationPoint(2.0F, 12.5F, -4.5F);
    this.leftFrontThigh.addBox(0.0F, -1.0F, -1.5F, 2, 7, 3, 0.0F);
    this.tail = new ModelRenderer(this, 44, 9);
    this.tail.setRotationPoint(0.0F, 0.4F, 8.1F);
    this.tail.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
    setRotationAngle(this.tail, -0.63739425F, 3.1415927F, 0.0F);
    this.upperRightFang = new ModelRenderer(this, 45, 14);
    this.upperRightFang.mirror = true;
    this.upperRightFang.setRotationPoint(-1.0F, 1.0F, -2.12F);
    this.upperRightFang.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotationAngle(this.upperRightFang, 0.004537856F, 0.0F, 0.0F);
    this.upperJaw = new ModelRenderer(this, 18, 5);
    this.upperJaw.setRotationPoint(0.0F, 0.9F, -2.6F);
    this.upperJaw.addBox(-2.0F, -1.0F, -3.0F, 4, 2, 3, 0.0F);
    setRotationAngle(this.upperJaw, 0.039444443F, -0.0F, 0.0F);
    this.lowerBody = new ModelRenderer(this, 0, 18);
    this.lowerBody.setRotationPoint(0.0F, 12.0F, -1.0F);
    this.lowerBody.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 9, 0.0F);
    setRotationAngle(this.lowerBody, 0.008726646F, -0.0F, 0.0F);
    this.leftFrontLeg = new ModelRenderer(this, 34, 0);
    this.leftFrontLeg.setRotationPoint(0.9F, 5.5F, -0.4F);
    this.leftFrontLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.leftHindLeg = new ModelRenderer(this, 34, 8);
    this.leftHindLeg.mirror = true;
    this.leftHindLeg.setRotationPoint(-1.0F, 4.0F, 0.8F);
    this.leftHindLeg.addBox(-0.9F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.head.addChild(this.lowerJaw);
    this.upperBody.addChild(this.neck);
    this.head.addChild(this.leftEar);
    this.head.addChild(this.rightEar);
    this.rightHindThigh.addChild(this.rightHindLeg);
    this.rightFrontThigh.addChild(this.rightFrontLeg);
    this.lowerBody.addChild(this.upperBody);
    this.upperJaw.addChild(this.nose);
    this.neck.addChild(this.head);
    this.upperJaw.addChild(this.upperLeftFang);
    this.lowerBody.addChild(this.tail);
    this.upperJaw.addChild(this.upperRightFang);
    this.head.addChild(this.upperJaw);
    this.leftFrontThigh.addChild(this.leftFrontLeg);
    this.leftHindThigh.addChild(this.leftHindLeg);
    this.leftHindThigh.offsetY = (float)(this.leftHindThigh.offsetY - 0.5D);
    this.rightFrontThigh.offsetY = (float)(this.rightFrontThigh.offsetY - 0.5D);
    this.rightHindThigh.offsetY = (float)(this.rightHindThigh.offsetY - 0.5D);
    this.leftFrontThigh.offsetY = (float)(this.leftFrontThigh.offsetY - 0.5D);
    this.lowerBody.offsetY = (float)(this.lowerBody.offsetY - 0.5D);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.leftHindThigh.render(f5);
    this.rightFrontThigh.render(f5);
    this.rightHindThigh.render(f5);
    this.leftFrontThigh.render(f5);
    this.lowerBody.render(f5);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    EntityLivingBase entity = (EntityLivingBase)ent;
    this.head.rotateAngleY = headYaw / 85.943665F;
    this.head.rotateAngleX = headPitch / 114.59155F;
    if (ent.onGround) {
      this.leftFrontThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
      this.rightFrontThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.3F * limbSwingAmount;
      this.leftHindThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
      this.rightHindThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
    } 
  }
  
  protected float degToRad(double degrees) {
    return (float)(degrees * Math.PI / 180.0D);
  }
  
  public ModelRenderer getHandRenderer() {
    return null;
  }
}
