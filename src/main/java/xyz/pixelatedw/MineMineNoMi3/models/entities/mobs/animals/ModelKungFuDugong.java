package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.animals;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityKungFuDugong;

public class ModelKungFuDugong extends ModelBiped {
  public ModelRenderer head;
  
  public ModelRenderer headShell;
  
  public ModelRenderer body1;
  
  public ModelRenderer body2;
  
  public ModelRenderer bodyShell;
  
  public ModelRenderer rightArm;
  
  public ModelRenderer leftArm;
  
  public ModelRenderer snout;
  
  public ModelRenderer tail1;
  
  public ModelRenderer tail2;
  
  public ModelRenderer tail3;
  
  public ModelRenderer tail4;
  
  public ModelRenderer leftTail1;
  
  public ModelRenderer rightTail1;
  
  public ModelKungFuDugong() {
    this.textureWidth = 100;
    this.textureHeight = 50;
    this.tail3 = new ModelRenderer((ModelBase)this, 48, 16);
    this.tail3.setRotationPoint(0.0F, 3.0F, 0.0F);
    this.tail3.addBox(-2.0F, 0.0F, -1.0F, 4, 2, 2, 0.0F);
    this.body2 = new ModelRenderer((ModelBase)this, 21, 14);
    this.body2.setRotationPoint(0.0F, 18.0F, -0.2F);
    this.body2.addBox(-3.5F, 0.0F, -2.0F, 7, 6, 4, 0.0F);
    setRotateAngle(this.body2, 0.43633232F, -0.0F, 0.0F);
    this.rightTail1 = new ModelRenderer((ModelBase)this, 48, 25);
    this.rightTail1.setRotationPoint(-0.5F, 0.0F, 0.0F);
    this.rightTail1.addBox(-3.0F, -2.0F, -0.5F, 3, 2, 1, 0.0F);
    setRotateAngle(this.rightTail1, 0.0F, -0.2268928F, 0.34906584F);
    this.rightArm = new ModelRenderer((ModelBase)this, 0, 24);
    this.rightArm.setRotationPoint(-4.5F, 12.3F, 0.0F);
    this.rightArm.addBox(-1.5F, -1.0F, -1.5F, 2, 7, 3, 0.0F);
    this.leftArm = new ModelRenderer((ModelBase)this, 0, 24);
    this.leftArm.setRotationPoint(4.5F, 12.3F, 0.0F);
    this.leftArm.addBox(-0.5F, -1.0F, -1.5F, 2, 7, 3, 0.0F);
    this.snout = new ModelRenderer((ModelBase)this, 0, 20);
    this.snout.setRotationPoint(0.0F, 1.0F, -2.7F);
    this.snout.addBox(-1.5F, -1.0F, -1.0F, 3, 2, 1, 0.0F);
    this.tail2 = new ModelRenderer((ModelBase)this, 48, 9);
    this.tail2.setRotationPoint(0.0F, 3.0F, -0.5F);
    this.tail2.addBox(-2.5F, 0.0F, -1.5F, 5, 3, 3, 0.0F);
    setRotateAngle(this.tail2, 0.6981317F, 0.0F, 0.0F);
    this.tail4 = new ModelRenderer((ModelBase)this, 48, 21);
    this.tail4.setRotationPoint(0.0F, 1.7F, -0.1F);
    this.tail4.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
    setRotateAngle(this.tail4, -2.9670596F, -0.0F, 0.0F);
    this.leftTail1 = new ModelRenderer((ModelBase)this, 48, 25);
    this.leftTail1.setRotationPoint(0.4F, 0.0F, -0.5F);
    this.leftTail1.addBox(0.0F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
    setRotateAngle(this.leftTail1, 0.0F, 0.2268928F, -0.34906584F);
    this.body1 = new ModelRenderer((ModelBase)this, 21, 0);
    this.body1.setRotationPoint(0.0F, 11.0F, 0.0F);
    this.body1.addBox(-4.0F, 0.0F, -2.5F, 8, 8, 5, 0.0F);
    this.head = new ModelRenderer((ModelBase)this, 0, 9);
    this.head.setRotationPoint(0.0F, 8.5F, -0.2F);
    this.head.addBox(-2.5F, -2.5F, -2.6F, 5, 5, 5, 0.0F);
    this.tail1 = new ModelRenderer((ModelBase)this, 48, 0);
    this.tail1.setRotationPoint(0.0F, 4.2F, -1.0F);
    this.tail1.addBox(-3.0F, 0.0F, -2.0F, 6, 4, 4, 0.0F);
    setRotateAngle(this.tail1, 1.134464F, -0.0F, 0.0F);
    this.bodyShell = new ModelRenderer((ModelBase)this, 21, 25);
    this.bodyShell.setRotationPoint(0.0F, 11.0F, 2.0F);
    this.bodyShell.addBox(-4.5F, -0.5F, -1.5F, 9, 9, 3, 0.0F);
    this.headShell = new ModelRenderer((ModelBase)this, 0, 0);
    this.headShell.setRotationPoint(0.0F, 8.2F, -0.5F);
    this.headShell.addBox(-3.0F, -2.5F, 0.0F, 6, 5, 3, 0.0F);
    this.tail2.addChild(this.tail3);
    this.tail4.addChild(this.rightTail1);
    this.head.addChild(this.snout);
    this.tail1.addChild(this.tail2);
    this.tail3.addChild(this.tail4);
    this.tail4.addChild(this.leftTail1);
    this.body2.addChild(this.tail1);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.body2.render(f5);
    this.rightArm.render(f5);
    this.leftArm.render(f5);
    this.body1.render(f5);
    this.head.render(f5);
    this.bodyShell.render(f5);
    this.headShell.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    boolean flagTempEntity = ent instanceof xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityDugong;
    if (Minecraft.getMinecraft().isGamePaused() || flagTempEntity)
      return; 
    EntityKungFuDugong entity = (EntityKungFuDugong)ent;
    if (entity.isHappy()) {
      this.tail2.rotateAngleX = 0.4F * (0.7F + MathHelper.cos(ageInTicks * 0.4F));
      this.tail3.rotateAngleX = 0.6F * this.tail2.rotateAngleX;
    } else {
      this.tail2.rotateAngleX = 0.69F;
      this.tail3.rotateAngleX = WyMathHelper.degToRad(0.0D);
      this.tail2.rotateAngleZ = MathHelper.cos(limbSwing * 0.4F + 3.1415927F) * 2.0F * limbSwingAmount * 0.3F;
      this.tail3.rotateAngleZ = MathHelper.cos(limbSwing * 0.4F + 3.1415927F) * 2.0F * limbSwingAmount * 0.3F;
    } 
    if (entity.isTraining()) {
      float rightArmMovement = MathHelper.cos(ageInTicks * 0.9F);
      float leftArmMovement = -MathHelper.cos(ageInTicks * 0.9F);
      if (leftArmMovement >= 0.4D || leftArmMovement <= -0.4D) {
        this.rightArm.rotateAngleX = WyMathHelper.degToRad(-90.0D);
        this.rightArm.offsetZ = 0.1F * (0.9F - rightArmMovement);
      } 
      if (rightArmMovement >= 0.4D || rightArmMovement <= -0.4D) {
        this.leftArm.rotateAngleX = WyMathHelper.degToRad(-90.0D);
        this.leftArm.offsetZ = 0.1F * (0.9F - leftArmMovement);
      } 
    } else {
      this.rightArm.offsetZ = 0.0F;
      this.leftArm.offsetZ = 0.0F;
      this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F;
      this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
    } 
  }
}
