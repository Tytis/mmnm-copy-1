package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBrickBat extends ModelBase {
  public ModelRenderer body1;
  
  public ModelRenderer body2;
  
  public ModelRenderer body3;
  
  public ModelRenderer body4;
  
  public ModelRenderer rightear;
  
  public ModelRenderer leftear;
  
  public ModelRenderer rightWing1;
  
  public ModelRenderer leftWing1;
  
  public ModelRenderer rightWing2;
  
  public ModelRenderer leftWing2;
  
  public ModelBrickBat() {
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.body1 = new ModelRenderer(this, 0, 0);
    this.body1.setRotationPoint(0.0F, 7.0F, 0.0F);
    this.body1.addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
    this.leftear = new ModelRenderer(this, 0, 11);
    this.leftear.setRotationPoint(1.9F, 4.6F, 0.0F);
    this.leftear.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.leftear, 0.0F, -0.0F, 0.5235988F);
    this.rightWing2 = new ModelRenderer(this, 93, 0);
    this.rightWing2.setRotationPoint(-6.0F, 0.0F, 0.0F);
    this.rightWing2.addBox(-5.0F, 0.0F, 0.0F, 5, 4, 0, 0.0F);
    setRotateAngle(this.rightWing2, 0.0F, -0.40142572F, 0.0F);
    this.body2 = new ModelRenderer(this, 21, 0);
    this.body2.setRotationPoint(0.0F, 7.0F, 0.0F);
    this.body2.addBox(-3.0F, -2.0F, -2.0F, 6, 4, 4, 0.0F);
    this.body3 = new ModelRenderer(this, 42, 0);
    this.body3.setRotationPoint(0.0F, 7.0F, 0.0F);
    this.body3.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 6, 0.0F);
    this.leftWing2 = new ModelRenderer(this, 93, 5);
    this.leftWing2.setRotationPoint(6.0F, 0.0F, 0.0F);
    this.leftWing2.addBox(0.0F, 0.0F, 0.0F, 5, 4, 0, 0.0F);
    setRotateAngle(this.leftWing2, 0.0F, 0.40142572F, 0.0F);
    this.rightWing1 = new ModelRenderer(this, 80, 0);
    this.rightWing1.setRotationPoint(-1.0F, 6.0F, -1.0F);
    this.rightWing1.addBox(-6.0F, 0.0F, 0.0F, 6, 4, 0, 0.0F);
    setRotateAngle(this.rightWing1, 0.87266463F, -0.0F, 0.43633232F);
    this.leftWing1 = new ModelRenderer(this, 80, 5);
    this.leftWing1.setRotationPoint(1.0F, 6.0F, -1.0F);
    this.leftWing1.addBox(0.0F, 0.0F, 0.0F, 6, 4, 0, 0.0F);
    setRotateAngle(this.leftWing1, 0.87266463F, -0.0F, -0.43633232F);
    this.rightear = new ModelRenderer(this, 0, 11);
    this.rightear.setRotationPoint(-1.9F, 4.6F, 0.0F);
    this.rightear.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
    setRotateAngle(this.rightear, 0.0F, -0.0F, -0.5235988F);
    this.body4 = new ModelRenderer(this, 63, 0);
    this.body4.setRotationPoint(0.0F, 7.0F, 0.0F);
    this.body4.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4, 0.0F);
    this.rightWing1.addChild(this.rightWing2);
    this.leftWing1.addChild(this.leftWing2);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    double[] animationWingMovement = { 
        25.0D, 30.0D, 35.0D, 40.0D, 45.0D, 50.0D, 55.0D, 50.0D, 45.0D, 40.0D, 
        35.0D, 30.0D, 25.0D, 20.0D, 15.0D, 10.0D, 5.0D, 0.0D, -5.0D, -10.0D, 
        -15.0D, -10.0D, -5.0D, 0.0D, 5.0D, 10.0D, 15.0D, 20.0D, 25.0D };
    int cycleIndexFly = (int)(ent.ticksExisted * 1.75D % animationWingMovement.length);
    if (!Minecraft.getMinecraft().isGamePaused()) {
      this.rightWing1.rotateAngleZ = degToRad(animationWingMovement[cycleIndexFly]);
      this.leftWing1.rotateAngleZ = degToRad(animationWingMovement[cycleIndexFly]) * -1.0F;
    } 
  }
  
  protected float degToRad(double degrees) {
    return (float)(degrees * Math.PI / 180.0D);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.body1.render(f5);
    this.leftear.render(f5);
    this.body2.render(f5);
    this.body3.render(f5);
    this.rightWing1.render(f5);
    this.leftWing1.render(f5);
    this.rightear.render(f5);
    this.body4.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
