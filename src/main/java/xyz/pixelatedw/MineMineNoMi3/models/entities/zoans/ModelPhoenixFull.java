package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;

public class ModelPhoenixFull extends ModelZoanMorph {
  public ModelRenderer Fire2;
  
  public ModelRenderer head1;
  
  public ModelRenderer head2;
  
  public ModelRenderer head3;
  
  public ModelRenderer neck1;
  
  public ModelRenderer beak1;
  
  public ModelRenderer beak2;
  
  public ModelRenderer beak3;
  
  public ModelRenderer beak4;
  
  public ModelRenderer body1;
  
  public ModelRenderer body2;
  
  public ModelRenderer body3;
  
  public ModelRenderer body4;
  
  public ModelRenderer Fire;
  
  public ModelRenderer RightArm1;
  
  public ModelRenderer LeftArm1;
  
  public ModelRenderer RightLeg1;
  
  public ModelRenderer RightLeg2;
  
  public ModelRenderer RightFoot1;
  
  public ModelRenderer LeftLeg1;
  
  public ModelRenderer LeftLeg2;
  
  public ModelRenderer LeftFoot1;
  
  public ModelRenderer Tails1;
  
  public ModelRenderer Tails2;
  
  public ModelRenderer RightWing1;
  
  public ModelRenderer RightWing2;
  
  public ModelRenderer LeftWing1;
  
  public ModelRenderer LeftWing2;
  
  public ModelRenderer Tails11;
  
  public ModelRenderer Tails22;
  
  private double[] wingAnimationArray;
  
  private double[] tailAnimationArray;
  
  public ModelPhoenixFull() {
    this.wingAnimationArray = WyRenderHelper.generateAnimationArray(0.0D, -20.0D, 20.0D, 0.9D, 1);
    this.tailAnimationArray = WyRenderHelper.generateAnimationArray(0.0D, -5.0D, 5.0D, 0.5D, 1);
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.RightWing1 = new ModelRenderer(this, 65, 20);
    this.RightWing1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.RightWing1.addBox(-13.0F, 0.5F, 0.0F, 13, 0, 10, 0.0F);
    this.LeftWing2 = new ModelRenderer(this, 86, 31);
    this.LeftWing2.setRotationPoint(12.0F, 0.0F, 0.0F);
    this.LeftWing2.addBox(0.0F, 0.5F, 0.0F, 15, 0, 12, 0.0F);
    setRotateAngle(this.LeftWing2, 0.0F, 0.05235988F, 0.0F);
    this.body2 = new ModelRenderer(this, 23, 19);
    this.body2.setRotationPoint(-4.5F, 5.0F, -7.5F);
    this.body2.addBox(0.0F, 0.0F, 0.0F, 9, 15, 4, 0.0F);
    setRotateAngle(this.body2, 1.5707964F, -0.0F, 0.0F);
    this.RightFoot1 = new ModelRenderer(this, 118, 50);
    this.RightFoot1.setRotationPoint(-3.5F, 9.4F, 5.8F);
    this.RightFoot1.addBox(0.0F, 0.0F, 0.0F, 3, 0, 4, 0.0F);
    setRotateAngle(this.RightFoot1, 0.6981317F, -0.0F, 0.0F);
    this.RightWing2 = new ModelRenderer(this, 55, 31);
    this.RightWing2.setRotationPoint(-12.0F, 0.0F, 0.0F);
    this.RightWing2.addBox(-15.0F, 0.5F, 0.0F, 15, 0, 12, 0.0F);
    setRotateAngle(this.RightWing2, 0.0F, -0.06981317F, 0.0F);
    this.Tails2 = new ModelRenderer(this, 110, 55);
    this.Tails2.setRotationPoint(0.0F, 3.0F, 11.0F);
    this.Tails2.addBox(-2.5F, 0.0F, 0.0F, 2, 0, 9, 0.0F);
    setRotateAngle(this.Tails2, 0.0F, -0.08726646F, 0.0F);
    this.LeftArm1 = new ModelRenderer(this, 100, 17);
    this.LeftArm1.setRotationPoint(4.0F, 2.0F, -7.0F);
    this.LeftArm1.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1, 0.0F);
    setRotateAngle(this.LeftArm1, 0.0F, 0.06981317F, 0.0F);
    this.Tails1 = new ModelRenderer(this, 110, 55);
    this.Tails1.setRotationPoint(0.0F, 3.0F, 11.0F);
    this.Tails1.addBox(0.5F, 0.0F, 0.0F, 2, 0, 9, 0.0F);
    setRotateAngle(this.Tails1, 0.0F, 0.08726646F, 0.0F);
    this.LeftLeg1 = new ModelRenderer(this, 115, 44);
    this.LeftLeg1.setRotationPoint(3.0F, 5.0F, 4.0F);
    this.LeftLeg1.addBox(-2.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
    setRotateAngle(this.LeftLeg1, 0.6981317F, -0.0F, 0.0F);
    this.LeftLeg2 = new ModelRenderer(this, 124, 46);
    this.LeftLeg2.setRotationPoint(2.5F, 6.8F, 5.8F);
    this.LeftLeg2.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.LeftLeg2, 0.6981317F, -0.0F, 0.0F);
    this.RightArm1 = new ModelRenderer(this, 71, 17);
    this.RightArm1.setRotationPoint(-4.0F, 2.0F, -7.0F);
    this.RightArm1.addBox(-13.0F, 0.0F, 0.0F, 13, 1, 1, 0.0F);
    setRotateAngle(this.RightArm1, 0.0F, -0.06981317F, 0.0F);
    this.head2 = new ModelRenderer(this, 0, 4);
    this.head2.setRotationPoint(-1.5F, 1.2F, -16.0F);
    this.head2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
    setRotateAngle(this.head2, 0.05235988F, -0.0F, 0.0F);
    this.beak3 = new ModelRenderer(this, 33, 9);
    this.beak3.setRotationPoint(-0.5F, 3.0F, -17.0F);
    this.beak3.addBox(-1.0F, 0.0F, -3.0F, 1, 1, 3, 0.0F);
    setRotateAngle(this.beak3, 0.0F, -0.2617994F, 0.0F);
    this.LeftWing1 = new ModelRenderer(this, 92, 20);
    this.LeftWing1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.LeftWing1.addBox(0.0F, 0.5F, 0.0F, 13, 0, 10, 0.0F);
    this.head1 = new ModelRenderer(this, 0, 0);
    this.head1.setRotationPoint(-1.5F, 2.3F, -17.7F);
    this.head1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
    setRotateAngle(this.head1, 0.55850536F, -0.0F, 0.0F);
    this.Fire2 = new ModelRenderer(this, 78, -12);
    this.Fire2.setRotationPoint(0.0F, -3.0F, -9.0F);
    this.Fire2.addBox(0.0F, 0.0F, 0.0F, 0, 3, 18, 0.0F);
    this.body1 = new ModelRenderer(this, 0, 18);
    this.body1.setRotationPoint(-2.5F, 6.0F, -9.0F);
    this.body1.addBox(0.0F, 0.0F, 0.0F, 5, 18, 6, 0.0F);
    setRotateAngle(this.body1, 1.5707964F, -0.0F, 0.0F);
    this.beak1 = new ModelRenderer(this, 33, 0);
    this.beak1.setRotationPoint(-1.0F, 3.0F, -19.0F);
    this.beak1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    this.beak2 = new ModelRenderer(this, 33, 4);
    this.beak2.setRotationPoint(0.5F, 3.0F, -17.0F);
    this.beak2.addBox(0.0F, 0.0F, -3.0F, 1, 1, 3, 0.0F);
    setRotateAngle(this.beak2, 0.0F, 0.2617994F, 0.0F);
    this.body3 = new ModelRenderer(this, 0, 43);
    this.body3.setRotationPoint(-3.5F, 5.5F, -8.0F);
    this.body3.addBox(0.0F, 0.0F, 0.0F, 7, 16, 5, 0.0F);
    setRotateAngle(this.body3, 1.5707964F, -0.0F, 0.0F);
    this.neck1 = new ModelRenderer(this, 11, 0);
    this.neck1.setRotationPoint(-1.0F, 2.0F, -14.0F);
    this.neck1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5, 0.0F);
    setRotateAngle(this.neck1, 0.017453292F, -0.0F, 0.0F);
    this.head3 = new ModelRenderer(this, 0, 10);
    this.head3.setRotationPoint(-1.5F, 2.2F, -17.7F);
    this.head3.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
    setRotateAngle(this.head3, 0.034906585F, -0.0F, 0.0F);
    this.beak4 = new ModelRenderer(this, 33, 14);
    this.beak4.setRotationPoint(0.0F, 3.0F, -20.8F);
    this.beak4.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    setRotateAngle(this.beak4, 0.0F, 0.7853982F, 0.0F);
    this.RightLeg2 = new ModelRenderer(this, 124, 46);
    this.RightLeg2.setRotationPoint(-2.5F, 6.8F, 5.8F);
    this.RightLeg2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.RightLeg2, 0.6981317F, -0.0F, 0.0F);
    this.RightLeg1 = new ModelRenderer(this, 115, 44);
    this.RightLeg1.setRotationPoint(-3.0F, 5.0F, 4.0F);
    this.RightLeg1.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
    setRotateAngle(this.RightLeg1, 0.6981317F, -0.0F, 0.0F);
    this.LeftFoot1 = new ModelRenderer(this, 118, 50);
    this.LeftFoot1.setRotationPoint(3.5F, 9.4F, 5.8F);
    this.LeftFoot1.addBox(-3.0F, 0.0F, 0.0F, 3, 0, 4, 0.0F);
    setRotateAngle(this.LeftFoot1, 0.6981317F, -0.0F, 0.0F);
    this.body4 = new ModelRenderer(this, 25, 39);
    this.body4.setRotationPoint(-2.0F, 5.0F, -10.0F);
    this.body4.addBox(0.0F, 0.0F, 0.0F, 4, 21, 4, 0.0F);
    setRotateAngle(this.body4, 1.5707964F, -0.0F, 0.0F);
    this.Tails11 = new ModelRenderer(this, 117, 57);
    this.Tails11.setRotationPoint(0.6F, 0.0F, 8.5F);
    this.Tails11.addBox(0.0F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
    setRotateAngle(this.Tails11, 0.0F, -0.08726646F, 0.0F);
    this.Tails22 = new ModelRenderer(this, 117, 57);
    this.Tails22.setRotationPoint(0.0F, 0.0F, 8.5F);
    this.Tails22.addBox(-2.5F, 0.0F, 0.0F, 2, 0, 7, 0.0F);
    setRotateAngle(this.Tails22, 0.0F, 0.08726646F, 0.0F);
    this.Fire = new ModelRenderer(this, 78, 3);
    this.Fire.setRotationPoint(0.0F, -1.0F, -16.0F);
    this.Fire.addBox(0.0F, 0.0F, 0.0F, 0, 3, 7, 0.0F);
    this.RightArm1.addChild(this.RightWing1);
    this.LeftArm1.addChild(this.LeftWing2);
    this.RightArm1.addChild(this.RightWing2);
    this.LeftArm1.addChild(this.LeftWing1);
    this.Tails1.addChild(this.Tails11);
    this.Tails2.addChild(this.Tails22);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.body1.render(f5);
    this.LeftArm1.render(f5);
    this.RightFoot1.render(f5);
    this.body4.render(f5);
    this.Fire2.render(f5);
    this.RightLeg2.render(f5);
    this.LeftLeg2.render(f5);
    this.body3.render(f5);
    this.head1.render(f5);
    this.RightArm1.render(f5);
    this.head2.render(f5);
    this.RightLeg1.render(f5);
    this.neck1.render(f5);
    this.body2.render(f5);
    this.beak3.render(f5);
    this.Fire.render(f5);
    this.LeftLeg1.render(f5);
    this.beak1.render(f5);
    this.Tails1.render(f5);
    this.Tails2.render(f5);
    this.beak2.render(f5);
    this.beak4.render(f5);
    this.LeftFoot1.render(f5);
    this.head3.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    this.LeftArm1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F) * 0.3F;
    this.RightArm1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F + 3.1415927F) * 0.3F;
    this.LeftWing2.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F) * 0.4F;
    this.RightWing2.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F + 3.1415927F) * 0.4F;
    this.Tails1.rotateAngleX = 0.5F * MathHelper.cos(ageInTicks * 0.4F) * 0.3F;
    this.Tails2.rotateAngleX = 0.5F * MathHelper.cos(ageInTicks * 0.4F + 3.1415927F) * 0.3F;
    this.Tails11.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.5F) * 0.8F;
    this.Tails22.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.5F + 3.1415927F) * 0.8F;
  }
  
  protected float degToRad(double degrees) {
    return (float)(degrees * Math.PI / 180.0D);
  }
  
  public ModelRenderer getHandRenderer() {
    return null;
  }
}
