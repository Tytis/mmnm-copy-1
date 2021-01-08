package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelGiraffePower extends ModelZoanMorph {
  public ModelRenderer leftleg4;
  
  public ModelRenderer leftleg3;
  
  public ModelRenderer leftleg2;
  
  public ModelRenderer leftleg1;
  
  public ModelRenderer lefthull3;
  
  public ModelRenderer lefthull4;
  
  public ModelRenderer neck;
  
  public ModelRenderer body1;
  
  public ModelRenderer rightarm1;
  
  public ModelRenderer leftarm1;
  
  public ModelRenderer rightleg4;
  
  public ModelRenderer tail1;
  
  public ModelRenderer neck2;
  
  public ModelRenderer mane2;
  
  public ModelRenderer head1;
  
  public ModelRenderer mane;
  
  public ModelRenderer horn1;
  
  public ModelRenderer horn2;
  
  public ModelRenderer rightear;
  
  public ModelRenderer leftear;
  
  public ModelRenderer head2;
  
  public ModelRenderer body2;
  
  public ModelRenderer body3;
  
  public ModelRenderer rightarm2;
  
  public ModelRenderer righthull1;
  
  public ModelRenderer righthull2;
  
  public ModelRenderer leftarm2;
  
  public ModelRenderer lefthull1;
  
  public ModelRenderer lefthull2;
  
  public ModelRenderer rightleg3;
  
  public ModelRenderer rightleg2;
  
  public ModelRenderer rightleg1;
  
  public ModelRenderer righthull3;
  
  public ModelRenderer righthull4;
  
  public ModelRenderer tail2;
  
  public ModelRenderer tail3;
  
  public ModelGiraffePower() {
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.horn2 = new ModelRenderer(this, 60, 20);
    this.horn2.setRotationPoint(-1.5F, -6.0F, -0.5F);
    this.horn2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.body2 = new ModelRenderer(this, 47, 0);
    this.body2.mirror = true;
    this.body2.setRotationPoint(-0.5F, 7.5F, -1.9F);
    this.body2.addBox(0.0F, 0.0F, 0.0F, 9, 7, 5, 0.0F);
    setRotateAngle(this.body2, 0.0F, -0.0F, -0.9599311F);
    this.lefthull4 = new ModelRenderer(this, 65, 20);
    this.lefthull4.setRotationPoint(-1.0F, 0.0F, -2.5F);
    this.lefthull4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.lefthull4, -0.12112585F, -0.48834312F, -0.039444443F);
    this.rightleg4 = new ModelRenderer(this, 10, 30);
    this.rightleg4.setRotationPoint(-2.0F, 11.6F, 1.0F);
    this.rightleg4.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
    setRotateAngle(this.rightleg4, -0.34906584F, -0.0F, 0.0F);
    this.neck2 = new ModelRenderer(this, 79, 14);
    this.neck2.setRotationPoint(0.5F, -7.0F, -0.5F);
    this.neck2.addBox(0.0F, 0.0F, 0.0F, 4, 8, 4, 0.0F);
    setRotateAngle(this.neck2, 0.13962634F, -0.0F, 0.0F);
    this.leftleg3 = new ModelRenderer(this, 10, 41);
    this.leftleg3.setRotationPoint(0.5F, 5.0F, 0.0F);
    this.leftleg3.addBox(-2.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
    setRotateAngle(this.leftleg3, 1.7453293F, -0.0F, 0.0F);
    this.rightarm2 = new ModelRenderer(this, 23, 39);
    this.rightarm2.setRotationPoint(0.0F, 6.0F, 0.0F);
    this.rightarm2.addBox(0.0F, 0.0F, 0.1F, 2, 6, 2, 0.0F);
    setRotateAngle(this.rightarm2, 0.0F, -0.0F, -0.41887903F);
    this.rightleg2 = new ModelRenderer(this, 0, 30);
    this.rightleg2.setRotationPoint(0.0F, 5.8F, -0.5F);
    this.rightleg2.addBox(-2.0F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.rightleg2, -1.9198622F, -0.0F, 0.0F);
    this.head1 = new ModelRenderer(this, 32, 18);
    this.head1.setRotationPoint(2.0F, 0.5F, 1.5F);
    this.head1.addBox(-2.0F, -4.0F, -6.0F, 4, 3, 8, 0.0F);
    setRotateAngle(this.head1, -0.31415927F, -0.0F, 0.0F);
    this.leftleg1 = new ModelRenderer(this, 0, 41);
    this.leftleg1.setRotationPoint(0.0F, 5.0F, -0.5F);
    this.leftleg1.addBox(-2.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
    setRotateAngle(this.leftleg1, 0.5235988F, -0.0F, 0.0F);
    this.rightear = new ModelRenderer(this, 32, 0);
    this.rightear.setRotationPoint(-2.0F, -3.5F, 0.0F);
    this.rightear.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 0, 0.0F);
    setRotateAngle(this.rightear, 0.0F, -0.0F, -0.2617994F);
    this.righthull2 = new ModelRenderer(this, 65, 20);
    this.righthull2.setRotationPoint(1.0F, 6.1F, 0.8F);
    this.righthull2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.righthull2, 0.17453292F, -0.0F, -0.9599311F);
    this.head2 = new ModelRenderer(this, 31, 29);
    this.head2.setRotationPoint(-2.0F, -1.0F, 0.5F);
    this.head2.addBox(0.01F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
    this.lefthull1 = new ModelRenderer(this, 65, 24);
    this.lefthull1.setRotationPoint(0.0F, 5.5F, 0.5F);
    this.lefthull1.addBox(-2.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
    setRotateAngle(this.lefthull1, 0.17453292F, -0.0F, -0.13962634F);
    this.mane = new ModelRenderer(this, 76, 0);
    this.mane.setRotationPoint(2.0F, -2.0F, 3.5F);
    this.mane.addBox(0.0F, 0.0F, 0.0F, 0, 10, 1, 0.0F);
    setRotateAngle(this.mane, 0.034906585F, -0.0F, 0.0F);
    this.rightleg1 = new ModelRenderer(this, 0, 41);
    this.rightleg1.setRotationPoint(0.0F, 5.0F, -0.5F);
    this.rightleg1.addBox(-2.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
    setRotateAngle(this.rightleg1, 0.5235988F, -0.0F, 0.0F);
    this.body1 = new ModelRenderer(this, 0, 0);
    this.body1.setRotationPoint(-0.5F, -4.0F, 0.0F);
    this.body1.addBox(-4.0F, 0.0F, -2.0F, 10, 16, 5, 0.0F);
    this.horn1 = new ModelRenderer(this, 60, 20);
    this.horn1.setRotationPoint(0.5F, -6.0F, -0.5F);
    this.horn1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.lefthull3 = new ModelRenderer(this, 65, 20);
    this.lefthull3.setRotationPoint(-2.0F, 0.0F, -2.0F);
    this.lefthull3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.lefthull3, -0.12112585F, 0.48834312F, 0.039444443F);
    this.leftear = new ModelRenderer(this, 32, 0);
    this.leftear.mirror = true;
    this.leftear.setRotationPoint(2.0F, -3.5F, 0.0F);
    this.leftear.addBox(0.0F, 0.0F, 0.0F, 3, 2, 0, 0.0F);
    setRotateAngle(this.leftear, 0.0F, -0.0F, 0.2617994F);
    this.tail3 = new ModelRenderer(this, 60, 13);
    this.tail3.setRotationPoint(-0.5F, -0.5F, 3.5F);
    this.tail3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
    setRotateAngle(this.tail3, 0.20943952F, -0.0F, 0.0F);
    this.body3 = new ModelRenderer(this, 47, 0);
    this.body3.setRotationPoint(2.5F, 7.4F, -1.91F);
    this.body3.addBox(0.0F, -7.5F, 0.0F, 9, 7, 5, 0.0F);
    setRotateAngle(this.body3, 0.0F, -0.0F, -2.268928F);
    this.lefthull2 = new ModelRenderer(this, 65, 20);
    this.lefthull2.setRotationPoint(-1.1F, 6.1F, 0.8F);
    this.lefthull2.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.lefthull2, 0.17453292F, -0.0F, 0.9599311F);
    this.rightarm1 = new ModelRenderer(this, 23, 30);
    this.rightarm1.setRotationPoint(-8.0F, 1.0F, -1.0F);
    this.rightarm1.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.rightarm1, 0.0F, -0.0F, 0.27925268F);
    this.leftarm2 = new ModelRenderer(this, 23, 39);
    this.leftarm2.setRotationPoint(0.0F, 6.0F, 0.0F);
    this.leftarm2.addBox(-2.0F, 0.0F, 0.1F, 2, 6, 2, 0.0F);
    setRotateAngle(this.leftarm2, 0.0F, -0.0F, 0.41887903F);
    this.righthull4 = new ModelRenderer(this, 65, 20);
    this.righthull4.setRotationPoint(-1.0F, 0.0F, -2.5F);
    this.righthull4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.righthull4, -0.12112585F, -0.48834312F, -0.039444443F);
    this.neck = new ModelRenderer(this, 79, 0);
    this.neck.setRotationPoint(-2.0F, -11.0F, -3.5F);
    this.neck.addBox(0.0F, 0.0F, 0.0F, 5, 8, 5, 0.0F);
    setRotateAngle(this.neck, 0.17453292F, -0.0F, 0.0F);
    this.leftarm1 = new ModelRenderer(this, 23, 30);
    this.leftarm1.setRotationPoint(9.0F, 1.0F, -1.0F);
    this.leftarm1.addBox(-2.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.leftarm1, 0.0F, -0.0F, -0.27925268F);
    this.tail1 = new ModelRenderer(this, 31, 3);
    this.tail1.setRotationPoint(0.0F, 10.0F, 3.0F);
    this.tail1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
    setRotateAngle(this.tail1, -0.7330383F, -0.0F, 0.0F);
    this.mane2 = new ModelRenderer(this, 76, 0);
    this.mane2.setRotationPoint(2.5F, 0.0F, 4.6F);
    this.mane2.addBox(0.0F, 0.0F, 0.0F, 0, 8, 1, 0.0F);
    setRotateAngle(this.mane2, 0.017453292F, -0.0F, 0.0F);
    this.tail2 = new ModelRenderer(this, 31, 10);
    this.tail2.setRotationPoint(0.0F, 0.0F, 4.5F);
    this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
    setRotateAngle(this.tail2, 0.4712389F, -0.0F, 0.0F);
    this.leftleg2 = new ModelRenderer(this, 0, 30);
    this.leftleg2.setRotationPoint(0.0F, 5.8F, -0.5F);
    this.leftleg2.addBox(-2.0F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.leftleg2, -1.9198622F, -0.0F, 0.0F);
    this.leftleg4 = new ModelRenderer(this, 10, 30);
    this.leftleg4.setRotationPoint(4.0F, 11.6F, 1.0F);
    this.leftleg4.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
    setRotateAngle(this.leftleg4, -0.34906584F, -0.0F, 0.0F);
    this.rightleg3 = new ModelRenderer(this, 10, 41);
    this.rightleg3.setRotationPoint(0.5F, 5.0F, 0.0F);
    this.rightleg3.addBox(-2.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
    setRotateAngle(this.rightleg3, 1.7453293F, -0.0F, 0.0F);
    this.righthull3 = new ModelRenderer(this, 65, 20);
    this.righthull3.setRotationPoint(-2.0F, 0.0F, -2.0F);
    this.righthull3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.righthull3, -0.12112585F, 0.48834312F, 0.039444443F);
    this.righthull1 = new ModelRenderer(this, 65, 24);
    this.righthull1.setRotationPoint(0.0F, 5.5F, 0.5F);
    this.righthull1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
    setRotateAngle(this.righthull1, 0.17453292F, -0.0F, 0.13962634F);
    this.head1.addChild(this.horn2);
    this.body1.addChild(this.body2);
    this.leftleg1.addChild(this.lefthull4);
    this.neck.addChild(this.neck2);
    this.leftleg4.addChild(this.leftleg3);
    this.rightarm1.addChild(this.rightarm2);
    this.rightleg3.addChild(this.rightleg2);
    this.neck2.addChild(this.head1);
    this.leftleg2.addChild(this.leftleg1);
    this.head1.addChild(this.rightear);
    this.rightarm2.addChild(this.righthull2);
    this.head1.addChild(this.head2);
    this.leftarm2.addChild(this.lefthull1);
    this.neck2.addChild(this.mane);
    this.rightleg2.addChild(this.rightleg1);
    this.head1.addChild(this.horn1);
    this.leftleg1.addChild(this.lefthull3);
    this.head1.addChild(this.leftear);
    this.tail2.addChild(this.tail3);
    this.body1.addChild(this.body3);
    this.leftarm2.addChild(this.lefthull2);
    this.leftarm1.addChild(this.leftarm2);
    this.rightleg1.addChild(this.righthull4);
    this.neck.addChild(this.mane2);
    this.tail1.addChild(this.tail2);
    this.leftleg3.addChild(this.leftleg2);
    this.rightleg4.addChild(this.rightleg3);
    this.rightleg1.addChild(this.righthull3);
    this.rightarm2.addChild(this.righthull1);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.rightleg4.render(f5);
    this.body1.render(f5);
    this.rightarm1.render(f5);
    this.neck.render(f5);
    this.leftarm1.render(f5);
    this.tail1.render(f5);
    this.leftleg4.render(f5);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    EntityLivingBase entity = (EntityLivingBase)ent;
    this.head1.rotateAngleY = headYaw / 85.943665F;
    this.head1.rotateAngleX = headPitch / 114.59155F;
    this.leftleg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
    this.rightleg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.8F * limbSwingAmount;
    this.rightarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
    this.leftarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
    if (entity.isSwingInProgress) {
      this.rightarm1.rotateAngleX = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * 1.2F;
      this.rightarm1.rotateAngleY = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * -0.2F;
      this.rightarm1.rotateAngleZ = -MathHelper.cos(entity.swingProgress * 4.0F + 3.1415927F) * 0.5F;
    } 
    if (ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) <= 0.05000000074505806D && !entity.isSwingInProgress) {
      this.rightarm1.rotateAngleX = 0.0F;
      this.rightarm1.rotateAngleY = 0.0F;
      this.rightarm1.rotateAngleZ = 0.209F;
    } else if (!entity.isSwingInProgress && ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) > 0.0D) {
      this.rightarm1.rotateAngleY = 0.0F;
      this.rightarm1.rotateAngleZ = 0.209F;
    } 
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public ModelRenderer getHandRenderer() {
    GL11.glScaled(1.2D, 1.2D, 1.0D);
    GL11.glTranslated(-0.1D, -0.1D, 0.05D);
    GL11.glRotated(-7.0D, 1.0D, 0.0D, 0.0D);
    GL11.glRotated(7.0D, 0.0D, 0.0D, 1.0D);
    return this.rightarm2;
  }
}
