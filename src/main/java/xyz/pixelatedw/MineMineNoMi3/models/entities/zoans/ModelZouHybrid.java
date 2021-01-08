package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelZouHybrid extends ModelZoanMorph {
  public ModelRenderer body1;
  
  public ModelRenderer body2;
  
  public ModelRenderer rightleg1;
  
  public ModelRenderer rightleg2;
  
  public ModelRenderer leftleg1;
  
  public ModelRenderer leftleg2;
  
  public ModelRenderer rightarm1;
  
  public ModelRenderer rightarm2;
  
  public ModelRenderer leftarm1;
  
  public ModelRenderer leftarm2;
  
  public ModelRenderer tail1;
  
  public ModelRenderer tail2;
  
  public ModelRenderer head;
  
  public ModelRenderer rightear;
  
  public ModelRenderer leftear;
  
  public ModelRenderer snout;
  
  public ModelRenderer snout2;
  
  public ModelRenderer snout3;
  
  public ModelRenderer tuskA1;
  
  public ModelRenderer tuskA2;
  
  public ModelRenderer tuskB1;
  
  public ModelRenderer tuskB2;
  
  public ModelZouHybrid() {
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.leftleg1 = new ModelRenderer(this, 42, 46);
    this.leftleg1.setRotationPoint(5.0F, 11.1F, 1.0F);
    this.leftleg1.addBox(-2.5F, 0.0F, -2.5F, 5, 7, 5, 0.0F);
    setRotateAngle(this.leftleg1, -0.05235988F, -0.0F, 0.0F);
    this.body1 = new ModelRenderer(this, 35, 0);
    this.body1.setRotationPoint(0.0F, -2.6F, 2.7F);
    this.body1.addBox(-9.0F, -10.0F, -7.0F, 18, 14, 10, 0.0F);
    setRotateAngle(this.body1, 0.08726646F, 0.0F, 0.0F);
    this.snout = new ModelRenderer(this, 112, 35);
    this.snout.setRotationPoint(-2.0F, -1.5F, -4.5F);
    this.snout.addBox(0.0F, 0.0F, 0.0F, 4, 7, 4, 0.0F);
    setRotateAngle(this.snout, -0.20943952F, -0.0F, 0.0F);
    this.head = new ModelRenderer(this, 0, 0);
    this.head.setRotationPoint(0.0F, -12.2F, -3.0F);
    this.head.addBox(-4.0F, -9.0F, -4.5F, 8, 9, 9, 0.0F);
    setRotateAngle(this.head, 0.05235988F, -0.0F, 0.0F);
    this.tail2 = new ModelRenderer(this, 119, 0);
    this.tail2.setRotationPoint(0.0F, 5.5F, 0.0F);
    this.tail2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
    this.leftear = new ModelRenderer(this, 0, 19);
    this.leftear.mirror = true;
    this.leftear.setRotationPoint(3.5F, -3.8F, -0.0F);
    this.leftear.addBox(0.0F, -6.0F, 0.0F, 6, 8, 1, 0.0F);
    setRotateAngle(this.leftear, -0.23649211F, -1.0306169F, 0.27401668F);
    this.tuskB1 = new ModelRenderer(this, 15, 19);
    this.tuskB1.setRotationPoint(2.3F, -1.0F, -3.5F);
    this.tuskB1.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
    setRotateAngle(this.tuskB1, -0.34906584F, -0.17453292F, 0.0F);
    this.rightarm1 = new ModelRenderer(this, 0, 46);
    this.rightarm1.setRotationPoint(-9.0F, -9.6F, 1.0F);
    this.rightarm1.addBox(-5.0F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
    setRotateAngle(this.rightarm1, 0.0F, -0.0F, 0.034906585F);
    this.tuskA1 = new ModelRenderer(this, 15, 19);
    this.tuskA1.setRotationPoint(-2.3F, -1.0F, -3.5F);
    this.tuskA1.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
    setRotateAngle(this.tuskA1, -0.34906584F, 0.17453292F, 0.0F);
    this.rightleg1 = new ModelRenderer(this, 42, 46);
    this.rightleg1.setRotationPoint(-5.0F, 11.1F, 1.0F);
    this.rightleg1.addBox(-2.5F, 0.0F, -2.5F, 5, 7, 5, 0.0F);
    setRotateAngle(this.rightleg1, -0.05235988F, -0.0F, 0.0F);
    this.leftarm1 = new ModelRenderer(this, 0, 46);
    this.leftarm1.setRotationPoint(9.0F, -9.6F, 1.0F);
    this.leftarm1.addBox(0.0F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
    setRotateAngle(this.leftarm1, 0.0F, -0.0F, -0.034906585F);
    this.snout2 = new ModelRenderer(this, 116, 47);
    this.snout2.setRotationPoint(0.5F, 7.0F, 0.5F);
    this.snout2.addBox(0.0F, 0.0F, 0.0F, 3, 6, 3, 0.0F);
    setRotateAngle(this.snout2, 0.20943952F, -0.0F, 0.0F);
    this.rightarm2 = new ModelRenderer(this, 21, 46);
    this.rightarm2.setRotationPoint(-2.5F, 7.8F, 0.0F);
    this.rightarm2.addBox(-2.5F, 0.0F, -2.5F, 5, 10, 5, 0.0F);
    setRotateAngle(this.rightarm2, 0.0F, -0.0F, -0.034906585F);
    this.tuskB2 = new ModelRenderer(this, 15, 25);
    this.tuskB2.setRotationPoint(0.0F, 3.8F, 0.0F);
    this.tuskB2.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
    setRotateAngle(this.tuskB2, -0.17453292F, -0.017453292F, 0.0F);
    this.rightleg2 = new ModelRenderer(this, 63, 46);
    this.rightleg2.setRotationPoint(0.0F, 6.8F, 0.0F);
    this.rightleg2.addBox(-2.5F, 0.0F, -2.5F, 5, 6, 5, 0.0F);
    setRotateAngle(this.rightleg2, 0.05235988F, -0.0F, 0.0F);
    this.tuskA2 = new ModelRenderer(this, 15, 25);
    this.tuskA2.setRotationPoint(0.0F, 3.9F, 0.0F);
    this.tuskA2.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
    setRotateAngle(this.tuskA2, -0.17453292F, 0.017453292F, 0.0F);
    this.leftarm2 = new ModelRenderer(this, 21, 46);
    this.leftarm2.setRotationPoint(2.5F, 7.8F, 0.0F);
    this.leftarm2.addBox(-2.5F, 0.0F, -2.5F, 5, 10, 5, 0.0F);
    setRotateAngle(this.leftarm2, 0.0F, -0.0F, 0.034906585F);
    this.tail1 = new ModelRenderer(this, 114, 0);
    this.tail1.setRotationPoint(0.0F, -2.5F, 2.0F);
    this.tail1.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1, 0.0F);
    setRotateAngle(this.tail1, 0.43633232F, -0.0F, 0.0F);
    this.body2 = new ModelRenderer(this, 35, 25);
    this.body2.setRotationPoint(0.0F, 11.2F, 3.0F);
    this.body2.addBox(-8.5F, -10.0F, -7.0F, 17, 10, 10, 0.0F);
    this.snout3 = new ModelRenderer(this, 120, 57);
    this.snout3.setRotationPoint(0.5F, 5.5F, 0.5F);
    this.snout3.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.snout3, 0.20943952F, -0.0F, 0.0F);
    this.leftleg2 = new ModelRenderer(this, 63, 46);
    this.leftleg2.setRotationPoint(0.0F, 6.8F, 0.0F);
    this.leftleg2.addBox(-2.5F, 0.0F, -2.5F, 5, 6, 5, 0.0F);
    setRotateAngle(this.leftleg2, 0.05235988F, -0.0F, 0.0F);
    this.rightear = new ModelRenderer(this, 0, 19);
    this.rightear.setRotationPoint(-3.5F, -3.8F, -1.0F);
    this.rightear.addBox(-6.0F, -6.0F, 0.0F, 6, 8, 1, 0.0F);
    setRotateAngle(this.rightear, -0.23649211F, 1.0306169F, -0.27401668F);
    this.head.addChild(this.snout);
    this.tail1.addChild(this.tail2);
    this.head.addChild(this.leftear);
    this.head.addChild(this.tuskB1);
    this.head.addChild(this.tuskA1);
    this.snout.addChild(this.snout2);
    this.rightarm1.addChild(this.rightarm2);
    this.tuskB1.addChild(this.tuskB2);
    this.rightleg1.addChild(this.rightleg2);
    this.tuskA1.addChild(this.tuskA2);
    this.leftarm1.addChild(this.leftarm2);
    this.body2.addChild(this.tail1);
    this.snout2.addChild(this.snout3);
    this.leftleg1.addChild(this.leftleg2);
    this.head.addChild(this.rightear);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.leftleg1.render(f5);
    this.body1.render(f5);
    this.head.render(f5);
    this.rightarm1.render(f5);
    this.rightleg1.render(f5);
    this.leftarm1.render(f5);
    this.body2.render(f5);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    EntityLivingBase entity = (EntityLivingBase)ent;
    this.head.rotateAngleY = headYaw / 85.943665F;
    this.head.rotateAngleX = headPitch / 114.59155F;
    this.leftleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
    this.rightleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.8F * limbSwingAmount;
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
      this.rightarm1.rotateAngleZ = 0.025F;
    } else if (!entity.isSwingInProgress && ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) > 0.0D) {
      this.rightarm1.rotateAngleY = 0.0F;
      this.rightarm1.rotateAngleZ = 0.025F;
    } 
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public ModelRenderer getHandRenderer() {
    GL11.glScaled(1.2D, 1.2D, 1.0D);
    GL11.glTranslated(-0.1D, -0.25D, 0.05D);
    GL11.glRotated(-5.0D, 1.0D, 0.0D, 0.0D);
    GL11.glRotated(1.0D, 0.0D, 0.0D, 1.0D);
    return this.rightarm2;
  }
}
