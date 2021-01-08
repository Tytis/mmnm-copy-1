package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelVenomDemon extends ModelZoanMorph {
  public ModelRenderer base1;
  
  public ModelRenderer base2;
  
  public ModelRenderer waist;
  
  public ModelRenderer body1;
  
  public ModelRenderer body2;
  
  public ModelRenderer body3;
  
  public ModelRenderer body4;
  
  public ModelRenderer body5;
  
  public ModelRenderer body6;
  
  public ModelRenderer rightwing;
  
  public ModelRenderer leftwing;
  
  public ModelRenderer rightforearm;
  
  public ModelRenderer rightarm;
  
  public ModelRenderer leftforearm;
  
  public ModelRenderer leftarm;
  
  public ModelRenderer neck;
  
  public ModelRenderer head1;
  
  public ModelRenderer head2;
  
  public ModelRenderer jaw;
  
  public ModelRenderer righthand;
  
  public ModelRenderer finger11;
  
  public ModelRenderer finger12;
  
  public ModelRenderer finger21;
  
  public ModelRenderer finger22;
  
  public ModelRenderer finger31;
  
  public ModelRenderer finger32;
  
  public ModelRenderer finger41;
  
  public ModelRenderer finger42;
  
  public ModelRenderer finger51;
  
  public ModelRenderer finger52;
  
  public ModelRenderer lefthand;
  
  public ModelRenderer finger11_1;
  
  public ModelRenderer finger12_1;
  
  public ModelRenderer finger21_1;
  
  public ModelRenderer finger22_1;
  
  public ModelRenderer finger31_1;
  
  public ModelRenderer finger32_1;
  
  public ModelRenderer finger41_1;
  
  public ModelRenderer finger42_1;
  
  public ModelRenderer finger51_1;
  
  public ModelRenderer finger52_1;
  
  public ModelRenderer righthorn1;
  
  public ModelRenderer righthorn2;
  
  public ModelRenderer righthorn3;
  
  public ModelRenderer lefthorn1;
  
  public ModelRenderer lefthorn2;
  
  public ModelRenderer lefthorn3;
  
  public ModelRenderer spine1;
  
  public ModelRenderer spine2;
  
  public ModelRenderer vertebrae1;
  
  public ModelRenderer vertebrae2;
  
  public ModelVenomDemon() {
    this.textureWidth = 256;
    this.textureHeight = 256;
    this.lefthorn3 = new ModelRenderer(this, 252, 1);
    this.lefthorn3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.lefthorn3.addBox(-1.6F, -2.5F, 1.9F, 1, 3, 1, 0.0F);
    setRotateAngle(this.lefthorn3, -0.29670596F, 0.05235988F, 0.0F);
    this.righthand = new ModelRenderer(this, 232, 37);
    this.righthand.setRotationPoint(0.0F, 14.7F, 0.0F);
    this.righthand.addBox(-6.0F, 0.0F, -6.0F, 6, 2, 6, 0.0F);
    setRotateAngle(this.righthand, -0.017453292F, -0.008726646F, -0.034906585F);
    this.finger11_1 = new ModelRenderer(this, 225, 33);
    this.finger11_1.setRotationPoint(18.8F, 3.0F, -19.5F);
    this.finger11_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger11_1, -0.22426562F, -0.20892176F, 0.07136761F);
    this.finger22_1 = new ModelRenderer(this, 225, 29);
    this.finger22_1.setRotationPoint(17.4F, 2.1F, -22.1F);
    this.finger22_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger22_1, 0.10532921F, 0.034901265F, 0.017463928F);
    this.body2 = new ModelRenderer(this, 0, 73);
    this.body2.setRotationPoint(-8.0F, 3.0F, 6.5F);
    this.body2.addBox(0.0F, 0.0F, -15.0F, 16, 5, 15, 0.0F);
    setRotateAngle(this.body2, 0.05235988F, -0.0F, 0.0F);
    this.leftforearm = new ModelRenderer(this, 180, 0);
    this.leftforearm.setRotationPoint(8.0F, -17.0F, 0.0F);
    this.leftforearm.addBox(0.0F, 0.0F, -6.0F, 6, 15, 6, 0.0F);
    setRotateAngle(this.leftforearm, -0.5235988F, -0.5235988F, 0.0F);
    this.lefthand = new ModelRenderer(this, 232, 28);
    this.lefthand.setRotationPoint(12.0F, 6.0F, -16.0F);
    this.lefthand.addBox(0.0F, 0.0F, -6.0F, 6, 2, 6, 0.0F);
    setRotateAngle(this.lefthand, -0.96907586F, -0.0867872F, 0.10511684F);
    this.base2 = new ModelRenderer(this, 0, 17);
    this.base2.setRotationPoint(-6.5F, 19.0F, -6.5F);
    this.base2.addBox(0.0F, 0.0F, 0.0F, 13, 3, 13, 0.0F);
    this.base1 = new ModelRenderer(this, 0, 0);
    this.base1.setRotationPoint(-7.0F, 22.0F, -7.0F);
    this.base1.addBox(0.0F, 0.0F, 0.0F, 14, 2, 14, 0.0F);
    this.spine1 = new ModelRenderer(this, 233, 9);
    this.spine1.setRotationPoint(-0.5F, -23.2F, -10.6F);
    this.spine1.addBox(0.0F, 0.0F, 0.0F, 1, 17, 1, 0.0F);
    setRotateAngle(this.spine1, 1.4835298F, -0.0F, 0.0F);
    this.finger31 = new ModelRenderer(this, 225, 42);
    this.finger31.setRotationPoint(-2.5F, 1.5F, -6.0F);
    this.finger31.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger31, 0.75049156F, -0.034906585F, -0.034906585F);
    this.finger12_1 = new ModelRenderer(this, 225, 29);
    this.finger12_1.setRotationPoint(19.3F, 2.5F, -21.6F);
    this.finger12_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger12_1, 0.20210795F, -0.104463734F, 0.070196465F);
    this.leftarm = new ModelRenderer(this, 205, 0);
    this.leftarm.setRotationPoint(12.0F, -4.0F, -5.0F);
    this.leftarm.addBox(0.0F, 0.0F, -6.0F, 6, 15, 6, 0.0F);
    setRotateAngle(this.leftarm, -0.90327394F, -0.17185475F, 0.1771698F);
    this.rightarm = new ModelRenderer(this, 205, 0);
    this.rightarm.setRotationPoint(-1.1F, 14.9F, 0.5F);
    this.rightarm.addBox(-6.0F, 0.0F, -6.0F, 6, 15, 6, 0.0F);
    setRotateAngle(this.rightarm, -0.27925268F, -0.27314404F, -0.3642502F);
    this.lefthorn2 = new ModelRenderer(this, 241, 0);
    this.lefthorn2.setRotationPoint(0.0F, 0.0F, 2.8F);
    this.lefthorn2.addBox(-2.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
    setRotateAngle(this.lefthorn2, -0.43633232F, 0.12217305F, 0.0F);
    this.finger11 = new ModelRenderer(this, 225, 42);
    this.finger11.setRotationPoint(-6.0F, 1.5F, -6.0F);
    this.finger11.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger11, 0.75049156F, -0.034906585F, -0.034906585F);
    this.neck = new ModelRenderer(this, 189, 49);
    this.neck.setRotationPoint(-2.0F, -23.0F, -12.8F);
    this.neck.addBox(0.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F);
    setRotateAngle(this.neck, -0.05235988F, -0.0F, 0.0F);
    this.finger12 = new ModelRenderer(this, 225, 38);
    this.finger12.setRotationPoint(0.0F, 0.0F, -2.0F);
    this.finger12.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger12, 0.19198622F, 0.034906585F, -0.034906585F);
    this.finger22 = new ModelRenderer(this, 225, 38);
    this.finger22.setRotationPoint(0.0F, 0.0F, -2.0F);
    this.finger22.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger22, 0.19198622F, -0.034906585F, 0.0F);
    this.righthorn2 = new ModelRenderer(this, 241, 0);
    this.righthorn2.setRotationPoint(0.0F, 0.0F, 2.8F);
    this.righthorn2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
    setRotateAngle(this.righthorn2, -0.43633232F, 0.12217305F, 0.0F);
    this.waist = new ModelRenderer(this, 0, 34);
    this.waist.setRotationPoint(-6.0F, 11.0F, -6.0F);
    this.waist.addBox(0.0F, 0.0F, 0.0F, 12, 8, 12, 0.0F);
    this.body4 = new ModelRenderer(this, 0, 116);
    this.body4.setRotationPoint(-10.0F, -10.0F, 6.5F);
    this.body4.addBox(0.0F, 0.0F, -17.0F, 20, 8, 17, 0.0F);
    setRotateAngle(this.body4, 0.06981317F, -0.0F, 0.0F);
    this.finger21_1 = new ModelRenderer(this, 225, 33);
    this.finger21_1.setRotationPoint(17.3F, 2.5F, -20.0F);
    this.finger21_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger21_1, -0.21309528F, -0.052232217F, 0.06990866F);
    this.jaw = new ModelRenderer(this, 240, 49);
    this.jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.jaw.addBox(0.5F, 7.0F, -2.5F, 4, 2, 4, 0.0F);
    setRotateAngle(this.jaw, 0.43633232F, -0.0F, 0.0F);
    this.head1 = new ModelRenderer(this, 202, 46);
    this.head1.setRotationPoint(-2.5F, -24.0F, -17.5F);
    this.head1.addBox(0.0F, 0.0F, 0.0F, 5, 4, 5, 0.0F);
    this.head2 = new ModelRenderer(this, 223, 49);
    this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.head2.addBox(0.5F, 3.9F, 0.6F, 4, 2, 4, 0.0F);
    this.rightwing = new ModelRenderer(this, 151, 0);
    this.rightwing.setRotationPoint(-6.0F, -20.0F, 6.0F);
    this.rightwing.addBox(-14.0F, 0.0F, 0.0F, 14, 9, 0, 0.0F);
    setRotateAngle(this.rightwing, 0.20299472F, 0.22606447F, 0.53873914F);
    this.leftwing = new ModelRenderer(this, 151, 10);
    this.leftwing.setRotationPoint(6.0F, -20.0F, 6.0F);
    this.leftwing.addBox(0.0F, 0.0F, 0.0F, 14, 9, 0, 0.0F);
    setRotateAngle(this.leftwing, 0.20299472F, -0.22606447F, -0.53873914F);
    this.finger32_1 = new ModelRenderer(this, 225, 29);
    this.finger32_1.setRotationPoint(15.4F, 1.7F, -22.5F);
    this.finger32_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger32_1, 0.13962634F, -0.0F, 0.05235988F);
    this.vertebrae1 = new ModelRenderer(this, 243, 7);
    this.vertebrae1.setRotationPoint(0.0F, -24.1F, -10.5F);
    this.vertebrae1.addBox(0.0F, 0.0F, 0.0F, 0, 17, 3, 0.0F);
    setRotateAngle(this.vertebrae1, 1.4835298F, -0.0F, 0.0F);
    this.vertebrae2 = new ModelRenderer(this, 250, 6);
    this.vertebrae2.setRotationPoint(0.0F, -22.0F, 7.0F);
    this.vertebrae2.addBox(0.0F, 0.0F, 0.0F, 0, 18, 3, 0.0F);
    setRotateAngle(this.vertebrae2, 0.034906585F, -0.0F, 0.0F);
    this.lefthorn1 = new ModelRenderer(this, 230, 0);
    this.lefthorn1.setRotationPoint(1.5F, -23.0F, -14.0F);
    this.lefthorn1.addBox(-2.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
    setRotateAngle(this.lefthorn1, 0.87266463F, 0.9599311F, 0.12217305F);
    this.righthorn1 = new ModelRenderer(this, 230, 0);
    this.righthorn1.setRotationPoint(-1.5F, -23.0F, -14.0F);
    this.righthorn1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
    setRotateAngle(this.righthorn1, 0.87266463F, -0.9599311F, -0.12217305F);
    this.rightforearm = new ModelRenderer(this, 180, 0);
    this.rightforearm.setRotationPoint(-8.0F, -17.0F, 0.0F);
    this.rightforearm.addBox(-6.0F, 0.0F, -6.0F, 6, 15, 6, 0.0F);
    setRotateAngle(this.rightforearm, -0.5235988F, 0.5235988F, 0.0F);
    this.finger42 = new ModelRenderer(this, 225, 38);
    this.finger42.setRotationPoint(0.0F, 0.0F, -2.0F);
    this.finger42.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger42, 0.19198622F, -0.0F, 0.0F);
    this.body1 = new ModelRenderer(this, 0, 55);
    this.body1.setRotationPoint(-7.0F, 8.0F, 6.5F);
    this.body1.addBox(0.0F, 0.0F, -14.0F, 14, 3, 14, 0.0F);
    setRotateAngle(this.body1, 0.05235988F, -0.0F, 0.0F);
    this.finger31_1 = new ModelRenderer(this, 225, 33);
    this.finger31_1.setRotationPoint(15.4F, 2.0F, -20.5F);
    this.finger31_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger31_1, -0.13962634F, -0.0F, 0.05235988F);
    this.finger21 = new ModelRenderer(this, 225, 42);
    this.finger21.setRotationPoint(-4.3F, 1.5F, -6.0F);
    this.finger21.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger21, 0.75049156F, -0.034906585F, -0.034906585F);
    this.righthorn3 = new ModelRenderer(this, 252, 1);
    this.righthorn3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.righthorn3.addBox(0.4F, -2.5F, 1.9F, 1, 3, 1, 0.0F);
    setRotateAngle(this.righthorn3, -0.29670596F, 0.05235988F, 0.0F);
    this.body3 = new ModelRenderer(this, 0, 94);
    this.body3.setRotationPoint(-9.0F, -2.0F, 6.5F);
    this.body3.addBox(0.0F, 0.0F, -16.0F, 18, 5, 16, 0.0F);
    setRotateAngle(this.body3, 0.06981317F, -0.0F, 0.0F);
    this.finger51_1 = new ModelRenderer(this, 218, 33);
    this.finger51_1.setRotationPoint(13.0F, 5.0F, -19.0F);
    this.finger51_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger51_1, 0.2940721F, 0.36599314F, -0.056077477F);
    this.finger51 = new ModelRenderer(this, 218, 42);
    this.finger51.setRotationPoint(-0.5F, 1.9F, -2.3F);
    this.finger51.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger51, 1.134464F, -0.36651915F, -0.43633232F);
    this.finger41 = new ModelRenderer(this, 225, 42);
    this.finger41.setRotationPoint(-1.0F, 1.5F, -6.0F);
    this.finger41.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger41, 0.75049156F, -0.034906585F, -0.10471976F);
    this.body5 = new ModelRenderer(this, 0, 142);
    this.body5.setRotationPoint(-10.0F, -19.5F, 6.5F);
    this.body5.addBox(0.0F, 0.0F, -18.0F, 20, 10, 18, 0.0F);
    setRotateAngle(this.body5, 0.05235988F, -0.0F, 0.0F);
    this.finger42_1 = new ModelRenderer(this, 225, 29);
    this.finger42_1.setRotationPoint(13.7F, 1.7F, -22.5F);
    this.finger42_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger42_1, 0.17453292F, -0.0F, 0.05235988F);
    this.finger32 = new ModelRenderer(this, 225, 38);
    this.finger32.setRotationPoint(0.0F, 0.0F, -2.0F);
    this.finger32.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger32, 0.19198622F, -0.0F, 0.0F);
    this.body6 = new ModelRenderer(this, 0, 171);
    this.body6.setRotationPoint(-9.5F, -21.5F, 6.1F);
    this.body6.addBox(0.0F, 0.0F, -17.0F, 19, 5, 17, 0.0F);
    setRotateAngle(this.body6, -0.10471976F, -0.0F, 0.0F);
    this.spine2 = new ModelRenderer(this, 238, 7);
    this.spine2.setRotationPoint(-0.5F, -22.2F, 6.0F);
    this.spine2.addBox(0.0F, 0.0F, 0.0F, 1, 19, 1, 0.0F);
    setRotateAngle(this.spine2, 0.034906585F, -0.0F, 0.0F);
    this.finger41_1 = new ModelRenderer(this, 225, 33);
    this.finger41_1.setRotationPoint(13.7F, 2.0F, -20.5F);
    this.finger41_1.addBox(-1.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
    setRotateAngle(this.finger41_1, -0.13962634F, -0.0F, 0.05235988F);
    this.lefthorn2.addChild(this.lefthorn3);
    this.rightarm.addChild(this.righthand);
    this.righthand.addChild(this.finger31);
    this.rightforearm.addChild(this.rightarm);
    this.lefthorn1.addChild(this.lefthorn2);
    this.righthand.addChild(this.finger11);
    this.finger11.addChild(this.finger12);
    this.finger21.addChild(this.finger22);
    this.righthorn1.addChild(this.righthorn2);
    this.head1.addChild(this.jaw);
    this.head1.addChild(this.head2);
    this.finger41.addChild(this.finger42);
    this.righthand.addChild(this.finger21);
    this.righthorn2.addChild(this.righthorn3);
    this.righthand.addChild(this.finger51);
    this.righthand.addChild(this.finger41);
    this.finger31.addChild(this.finger32);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.finger11_1.render(f5);
    this.finger22_1.render(f5);
    this.body2.render(f5);
    this.leftforearm.render(f5);
    this.lefthand.render(f5);
    this.base2.render(f5);
    this.base1.render(f5);
    this.spine1.render(f5);
    this.finger12_1.render(f5);
    this.leftarm.render(f5);
    this.neck.render(f5);
    this.waist.render(f5);
    this.body4.render(f5);
    this.finger21_1.render(f5);
    this.head1.render(f5);
    this.rightwing.render(f5);
    this.leftwing.render(f5);
    this.finger32_1.render(f5);
    this.vertebrae1.render(f5);
    this.vertebrae2.render(f5);
    this.lefthorn1.render(f5);
    this.righthorn1.render(f5);
    this.rightforearm.render(f5);
    this.body1.render(f5);
    this.finger31_1.render(f5);
    this.body3.render(f5);
    this.finger51_1.render(f5);
    this.body5.render(f5);
    this.finger42_1.render(f5);
    this.body6.render(f5);
    this.spine2.render(f5);
    this.finger41_1.render(f5);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    EntityLivingBase entity = (EntityLivingBase)ent;
    if (!Minecraft.getMinecraft().isGamePaused())
      if (entity.isSwingInProgress) {
        this.rightforearm.rotateAngleX = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * 1.2F;
        this.rightforearm.rotateAngleY = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * -0.2F;
        this.rightforearm.rotateAngleZ = -MathHelper.cos(entity.swingProgress * 4.0F + 3.1415927F) * 0.5F;
      } else {
        this.rightforearm.rotateAngleX = -0.523F;
        this.rightforearm.rotateAngleY = 0.523F;
        this.rightforearm.rotateAngleZ = 0.0F;
      }  
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public ModelRenderer getHandRenderer() {
    GL11.glScaled(1.2D, 1.2D, 1.0D);
    GL11.glTranslated(0.2D, 0.2D, 0.5D);
    GL11.glRotated(45.0D, 1.0D, 0.0D, 0.0D);
    return this.rightforearm;
  }
}
