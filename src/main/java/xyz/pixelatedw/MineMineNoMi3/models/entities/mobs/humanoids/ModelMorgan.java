package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMorgan extends ModelBiped {
  public ModelRenderer head;
  
  public ModelRenderer body;
  
  public ModelRenderer rightarm1;
  
  public ModelRenderer leftarm1;
  
  public ModelRenderer rightleg;
  
  public ModelRenderer leftleg;
  
  public ModelRenderer jaw;
  
  public ModelRenderer rightarm2;
  
  public ModelRenderer axe_hand;
  
  public ModelRenderer cable;
  
  public ModelRenderer axe1;
  
  public ModelRenderer axe2;
  
  public ModelRenderer axe4;
  
  public ModelRenderer axe41;
  
  public ModelRenderer axe5;
  
  public ModelRenderer axe51;
  
  public ModelRenderer axe6;
  
  public ModelRenderer axe61;
  
  public ModelRenderer leftarm2;
  
  private int cycleIndex;
  
  private boolean canAnimate = true;
  
  private double frame;
  
  public ModelMorgan() {
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.axe51 = new ModelRenderer((ModelBase)this, 105, 59);
    this.axe51.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe51.addBox(-1.5F, 12.1F, 5.8F, 1, 3, 2, 0.0F);
    setRotateAngle(this.axe51, -0.41887903F, -0.0F, 0.0F);
    this.axe2 = new ModelRenderer((ModelBase)this, 76, 53);
    this.axe2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe2.addBox(-2.0F, 10.0F, 9.5F, 2, 7, 4, 0.0F);
    setRotateAngle(this.axe2, -0.9599311F, 0.0F, 0.0F);
    this.jaw = new ModelRenderer((ModelBase)this, 25, 0);
    this.jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.jaw.addBox(-3.6F, -2.0F, -4.0F, 7, 2, 7, 0.0F);
    this.leftarm1 = new ModelRenderer((ModelBase)this, 21, 35);
    this.leftarm1.setRotationPoint(6.0F, -7.0F, 0.0F);
    this.leftarm1.addBox(-1.0F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
    setRotateAngle(this.leftarm1, 0.0F, -0.0F, -0.05235988F);
    this.body = new ModelRenderer((ModelBase)this, 54, 0);
    this.body.setRotationPoint(0.0F, -9.0F, 0.0F);
    this.body.addBox(-5.0F, 0.0F, -2.5F, 10, 16, 5, 0.0F);
    this.axe61 = new ModelRenderer((ModelBase)this, 112, 59);
    this.axe61.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe61.addBox(-1.5F, 7.4F, 19.9F, 1, 3, 2, 0.0F);
    setRotateAngle(this.axe61, -1.5358897F, -0.0F, 0.0F);
    this.axe41 = new ModelRenderer((ModelBase)this, 100, 54);
    this.axe41.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe41.addBox(-1.5F, 9.0F, 13.5F, 1, 9, 1, 0.0F);
    setRotateAngle(this.axe41, -0.9599311F, -0.0F, 0.0F);
    this.leftarm2 = new ModelRenderer((ModelBase)this, 21, 50);
    this.leftarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.leftarm2.addBox(-0.9F, 6.9F, -2.5F, 5, 9, 5, 0.0F);
    setRotateAngle(this.leftarm2, 0.0F, -0.0F, 0.017453292F);
    this.axe5 = new ModelRenderer((ModelBase)this, 105, 52);
    this.axe5.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe5.addBox(-2.0F, 12.1F, 2.5F, 2, 2, 4, 0.0F);
    setRotateAngle(this.axe5, -0.41887903F, -0.0F, 0.0F);
    this.head = new ModelRenderer((ModelBase)this, 0, 0);
    this.head.setRotationPoint(0.0F, -9.0F, 0.0F);
    this.head.addBox(-3.0F, -7.0F, -3.0F, 6, 7, 6, 0.0F);
    this.leftleg = new ModelRenderer((ModelBase)this, 0, 42);
    this.leftleg.setRotationPoint(2.5F, 7.0F, 0.0F);
    this.leftleg.addBox(-2.5F, 0.0F, -2.5F, 5, 17, 5, 0.0F);
    this.rightarm2 = new ModelRenderer((ModelBase)this, 21, 14);
    this.rightarm2.mirror = true;
    this.rightarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.rightarm2.addBox(-4.0F, 3.2F, 3.9F, 5, 7, 5, 0.0F);
    setRotateAngle(this.rightarm2, -0.9599311F, -0.0F, 0.0F);
    this.cable = new ModelRenderer((ModelBase)this, 42, 47);
    this.cable.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.cable.addBox(-2.5F, 0.0F, 5.5F, 2, 20, 2, 0.0F);
    setRotateAngle(this.cable, -0.9599311F, 0.0F, 0.0F);
    this.axe_hand = new ModelRenderer((ModelBase)this, 0, 0);
    this.axe_hand.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe_hand.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
    setRotateAngle(this.axe_hand, 0.9599311F, 0.0F, 0.0F);
    this.rightarm1 = new ModelRenderer((ModelBase)this, 0, 14);
    this.rightarm1.setRotationPoint(-6.0F, -7.0F, 0.0F);
    this.rightarm1.addBox(-4.0F, -2.0F, -2.5F, 5, 11, 5, 0.0F);
    this.axe1 = new ModelRenderer((ModelBase)this, 51, 51);
    this.axe1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe1.addBox(-4.5F, 10.0F, 3.5F, 6, 7, 6, 0.0F);
    setRotateAngle(this.axe1, -0.9599311F, -0.0F, 0.0F);
    this.axe6 = new ModelRenderer((ModelBase)this, 105, 52);
    this.axe6.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe6.addBox(-2.0F, 8.6F, 16.6F, 2, 2, 4, 0.0F);
    setRotateAngle(this.axe6, -1.5184364F, -0.0F, 0.0F);
    this.rightleg = new ModelRenderer((ModelBase)this, 0, 42);
    this.rightleg.setRotationPoint(-2.5F, 7.0F, 0.0F);
    this.rightleg.addBox(-2.5F, 0.0F, -2.5F, 5, 17, 5, 0.0F);
    this.axe4 = new ModelRenderer((ModelBase)this, 89, 52);
    this.axe4.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.axe4.addBox(-2.0F, 9.0F, 10.5F, 2, 9, 3, 0.0F);
    setRotateAngle(this.axe4, -0.9599311F, -0.0F, 0.0F);
    this.axe_hand.addChild(this.axe51);
    this.axe_hand.addChild(this.axe2);
    this.head.addChild(this.jaw);
    this.axe_hand.addChild(this.axe61);
    this.axe_hand.addChild(this.axe41);
    this.leftarm1.addChild(this.leftarm2);
    this.axe_hand.addChild(this.axe5);
    this.rightarm1.addChild(this.rightarm2);
    this.axe_hand.addChild(this.cable);
    this.rightarm2.addChild(this.axe_hand);
    this.axe_hand.addChild(this.axe1);
    this.axe_hand.addChild(this.axe6);
    this.axe_hand.addChild(this.axe4);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.leftarm1.render(f5);
    this.body.render(f5);
    this.head.render(f5);
    this.leftleg.render(f5);
    this.rightarm1.render(f5);
    this.rightleg.render(f5);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scaleFactor, ent);
    double[] animationChopX = { 
        0.0D, -28.0D, -45.0D, -65.0D, -80.0D, -106.0D, -120.0D, -120.0D, -106.0D, -80.0D, 
        -75.0D, -65.0D, -45.0D, -35.0D, -25.0D, 0.0D };
    double[] animationChopY = { 
        0.0D, 0.0D, 0.0D, 10.0D, 14.0D, 17.0D, 20.0D, 20.0D, 20.0D, 20.0D, 
        18.0D, 17.0D, 12.0D, 10.0D, 9.0D, 0.0D };
    double[] animationChopZ = { 
        0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -20.0D, -20.0D, -24.0D, -26.0D, 
        -24.0D, -22.0D, -22.0D, -20.0D, -20.0D, 0.0D };
    if (!Minecraft.getMinecraft().isGamePaused());
    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.0F * limbSwingAmount;
    this.leftarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
  }
  
  protected float degToRad(double degrees) {
    return (float)(degrees * Math.PI / 180.0D);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
