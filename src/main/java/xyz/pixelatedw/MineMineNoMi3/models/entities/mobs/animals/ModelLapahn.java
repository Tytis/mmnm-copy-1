package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.animals;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityLapahn;

public class ModelLapahn extends ModelBiped {
  public ModelRenderer leftLeg1;
  
  public ModelRenderer leftLeg2;
  
  public ModelRenderer leftFoot;
  
  public ModelRenderer head;
  
  public ModelRenderer body1;
  
  public ModelRenderer body2;
  
  public ModelRenderer body3;
  
  public ModelRenderer body4;
  
  public ModelRenderer body5;
  
  public ModelRenderer tail;
  
  public ModelRenderer rightLeg1;
  
  public ModelRenderer rightArm1;
  
  public ModelRenderer leftArm1;
  
  public ModelRenderer wiskers;
  
  public ModelRenderer rightEar;
  
  public ModelRenderer leftEar;
  
  public ModelRenderer rightLeg2;
  
  public ModelRenderer rightFoot;
  
  public ModelRenderer rightArm2;
  
  public ModelRenderer leftArm2;
  
  public ModelLapahn() {
    this.textureWidth = 140;
    this.textureHeight = 70;
    this.wiskers = new ModelRenderer((ModelBase)this, 92, 44);
    this.wiskers.setRotationPoint(0.0F, -8.0F, -0.1F);
    this.wiskers.addBox(-4.5F, -6.0F, -3.0F, 9, 9, 0, 0.0F);
    this.leftEar = new ModelRenderer((ModelBase)this, 25, 0);
    this.leftEar.setRotationPoint(1.7F, -4.5F, 0.0F);
    this.leftEar.addBox(-1.0F, -6.0F, -0.5F, 2, 6, 1, 0.0F);
    setRotateAngle(this.leftEar, 0.071907565F, -0.1738348F, 0.08866273F);
    this.body4 = new ModelRenderer((ModelBase)this, 35, 54);
    this.body4.setRotationPoint(0.0F, -5.0F, 0.0F);
    this.body4.addBox(-7.0F, 0.0F, -5.0F, 14, 5, 10, 0.0F);
    this.leftFoot = new ModelRenderer((ModelBase)this, 0, 37);
    this.leftFoot.setRotationPoint(0.0F, 3.0F, 0.7F);
    this.leftFoot.addBox(-2.5F, 0.0F, -8.0F, 5, 2, 10, 0.0F);
    setRotateAngle(this.leftFoot, -0.034906585F, 0.0F, 0.0F);
    this.leftLeg1 = new ModelRenderer((ModelBase)this, 0, 13);
    this.leftLeg1.setRotationPoint(4.8F, 14.9F, -2.2F);
    this.leftLeg1.addBox(-4.0F, -1.0F, -4.0F, 8, 6, 9, 0.0F);
    setRotateAngle(this.leftLeg1, -0.2443461F, -0.0F, 0.0F);
    this.body1 = new ModelRenderer((ModelBase)this, 35, 0);
    this.body1.setRotationPoint(0.0F, 16.0F, 0.0F);
    this.body1.addBox(-8.0F, 0.0F, -5.5F, 16, 1, 11, 0.0F);
    this.rightEar = new ModelRenderer((ModelBase)this, 25, 0);
    this.rightEar.setRotationPoint(-1.7F, -4.5F, 0.0F);
    this.rightEar.addBox(-1.0F, -6.0F, -0.5F, 2, 6, 1, 0.0F);
    setRotateAngle(this.rightEar, 0.071907565F, 0.1738348F, -0.08866273F);
    this.body3 = new ModelRenderer((ModelBase)this, 35, 36);
    this.body3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.body3.addBox(-8.0F, 0.0F, -5.5F, 16, 6, 11, 0.0F);
    this.rightLeg1 = new ModelRenderer((ModelBase)this, 0, 13);
    this.rightLeg1.setRotationPoint(-4.8F, 14.9F, -2.2F);
    this.rightLeg1.addBox(-4.0F, -1.0F, -4.0F, 8, 6, 9, 0.0F);
    setRotateAngle(this.rightLeg1, -0.2443461F, -0.0F, 0.0F);
    this.body2 = new ModelRenderer((ModelBase)this, 35, 13);
    this.body2.setRotationPoint(0.0F, 6.0F, 0.0F);
    this.body2.addBox(-8.5F, 0.0F, -6.0F, 17, 10, 12, 0.0F);
    this.leftLeg2 = new ModelRenderer((ModelBase)this, 0, 29);
    this.leftLeg2.setRotationPoint(0.0F, 3.3F, 3.0F);
    this.leftLeg2.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
    setRotateAngle(this.leftLeg2, 0.33161256F, -0.0F, 0.0F);
    this.rightFoot = new ModelRenderer((ModelBase)this, 0, 37);
    this.rightFoot.setRotationPoint(0.0F, 3.0F, 0.7F);
    this.rightFoot.addBox(-2.5F, 0.0F, -8.0F, 5, 2, 10, 0.0F);
    setRotateAngle(this.rightFoot, -0.034906585F, 0.0F, 0.0F);
    this.body5 = new ModelRenderer((ModelBase)this, 90, 0);
    this.body5.setRotationPoint(0.0F, -7.0F, 0.0F);
    this.body5.addBox(-6.5F, 0.0F, -4.5F, 13, 2, 9, 0.0F);
    this.tail = new ModelRenderer((ModelBase)this, 0, 50);
    this.tail.setRotationPoint(0.0F, 13.0F, 5.8F);
    this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
    setRotateAngle(this.tail, -0.10471976F, -0.0F, 0.0F);
    this.rightLeg2 = new ModelRenderer((ModelBase)this, 0, 29);
    this.rightLeg2.setRotationPoint(0.0F, 3.3F, 3.0F);
    this.rightLeg2.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
    setRotateAngle(this.rightLeg2, 0.33161256F, -0.0F, 0.0F);
    this.head = new ModelRenderer((ModelBase)this, 0, 0);
    this.head.setRotationPoint(0.0F, -8.0F, 0.0F);
    this.head.addBox(-3.0F, -5.0F, -3.0F, 6, 6, 6, 0.0F);
    this.leftArm2 = new ModelRenderer((ModelBase)this, 94, 27);
    this.leftArm2.setRotationPoint(2.5F, 5.5F, 0.0F);
    this.leftArm2.addBox(-2.5F, 0.0F, -2.5F, 5, 9, 5, 0.0F);
    setRotateAngle(this.leftArm2, 0.0F, -0.0F, 0.12217305F);
    this.rightArm1 = new ModelRenderer((ModelBase)this, 94, 13);
    this.rightArm1.setRotationPoint(-6.5F, -3.0F, 0.0F);
    this.rightArm1.addBox(-5.0F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
    setRotateAngle(this.rightArm1, 0.0F, -0.0F, 0.2617994F);
    this.leftArm1 = new ModelRenderer((ModelBase)this, 94, 13);
    this.leftArm1.setRotationPoint(6.5F, -3.0F, 0.0F);
    this.leftArm1.addBox(0.0F, -2.0F, -2.5F, 5, 8, 5, 0.0F);
    setRotateAngle(this.leftArm1, 0.0F, -0.0F, -0.2617994F);
    this.rightArm2 = new ModelRenderer((ModelBase)this, 94, 27);
    this.rightArm2.setRotationPoint(-2.5F, 5.5F, 0.0F);
    this.rightArm2.addBox(-2.5F, 0.0F, -2.5F, 5, 9, 5, 0.0F);
    setRotateAngle(this.rightArm2, 0.0F, -0.0F, -0.12217305F);
    this.head.addChild(this.leftEar);
    this.leftLeg2.addChild(this.leftFoot);
    this.head.addChild(this.rightEar);
    this.leftLeg1.addChild(this.leftLeg2);
    this.rightLeg2.addChild(this.rightFoot);
    this.rightLeg1.addChild(this.rightLeg2);
    this.leftArm1.addChild(this.leftArm2);
    this.rightArm1.addChild(this.rightArm2);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    EntityLapahn lapahn = (EntityLapahn)entity;
    if (lapahn.isEnraged())
      Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("mineminenomi", "textures/models/lapahnangry.png")); 
    this.wiskers.render(f5);
    this.tail.render(f5);
    this.head.render(f5);
    this.body3.render(f5);
    this.body4.render(f5);
    this.body1.render(f5);
    this.leftLeg1.render(f5);
    this.body5.render(f5);
    this.rightArm1.render(f5);
    this.rightLeg1.render(f5);
    this.leftArm1.render(f5);
    this.body2.render(f5);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    boolean flagTempEntity = ent instanceof xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityLapahn;
    if (Minecraft.getMinecraft().isGamePaused() || flagTempEntity)
      return; 
    EntityLapahn entity = (EntityLapahn)ent;
    if (ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) > 0.0D) {
      this.rightLeg1.rotateAngleX = 0.7F * (-0.2F + MathHelper.cos(ageInTicks * 0.45F));
      this.leftLeg1.rotateAngleX = 0.7F * (-0.2F + MathHelper.cos(ageInTicks * 0.45F));
      this.rightArm1.rotateAngleX = -0.4F * (-0.2F + MathHelper.sin(ageInTicks * 0.45F));
      this.leftArm1.rotateAngleX = -0.4F * (-0.2F + MathHelper.sin(ageInTicks * 0.45F));
      float formula = 0.0F - 0.9F + MathHelper.cos(ageInTicks * 0.45F);
      this.leftArm1.offsetY = formula;
      this.rightArm1.offsetY = formula;
      this.head.offsetY = formula;
      this.wiskers.offsetY = formula;
      this.body1.offsetY = formula;
      this.body2.offsetY = formula;
      this.body3.offsetY = formula;
      this.body4.offsetY = formula;
      this.body5.offsetY = formula;
      this.leftLeg1.offsetY = formula;
      this.rightLeg1.offsetY = formula;
      this.tail.offsetY = formula;
    } else {
      this.rightLeg1.rotateAngleX = WyMathHelper.degToRad(-17.0D);
      this.leftLeg1.rotateAngleX = WyMathHelper.degToRad(-17.0D);
      this.rightArm1.rotateAngleX = WyMathHelper.degToRad(0.0D);
      this.leftArm1.rotateAngleX = WyMathHelper.degToRad(0.0D);
      float formula = 0.0F;
      this.leftArm1.offsetY = formula;
      this.rightArm1.offsetY = formula;
      this.head.offsetY = formula;
      this.wiskers.offsetY = formula;
      this.body1.offsetY = formula;
      this.body2.offsetY = formula;
      this.body3.offsetY = formula;
      this.body4.offsetY = formula;
      this.body5.offsetY = formula;
      this.leftLeg1.offsetY = formula;
      this.rightLeg1.offsetY = formula;
      this.tail.offsetY = formula;
      if (ageInTicks % 300.0F > 0.0F && ageInTicks % 300.0F < 100.0F) {
        this.leftEar.rotateAngleX = 0.1F * (0.3F + MathHelper.cos(ageInTicks * 0.55F));
      } else {
        this.leftEar.rotateAngleX = WyMathHelper.degToRad(0.0D);
      } 
    } 
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
