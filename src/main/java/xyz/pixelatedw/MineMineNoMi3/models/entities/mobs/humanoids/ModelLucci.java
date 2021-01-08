package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelLucci extends ModelBiped {
  ModelRenderer head;
  
  ModelRenderer body;
  
  ModelRenderer rightarm;
  
  ModelRenderer leftarm;
  
  ModelRenderer rightleg;
  
  ModelRenderer leftleg;
  
  ModelRenderer hat2;
  
  ModelRenderer hat1;
  
  ModelRenderer pi1;
  
  ModelRenderer pi2;
  
  ModelRenderer pi3;
  
  ModelRenderer pi4;
  
  ModelRenderer pi5;
  
  ModelRenderer pi6;
  
  ModelRenderer pi7;
  
  ModelRenderer pi8;
  
  public ModelLucci() {
    this.textureWidth = 64;
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
    this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
    this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.head.setTextureSize(64, 64);
    this.head.mirror = true;
    setRotation(this.head, 0.0F, 0.0F, 0.0F);
    this.body = new ModelRenderer((ModelBase)this, 16, 16);
    this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
    this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.body.setTextureSize(64, 64);
    this.body.mirror = true;
    setRotation(this.body, 0.0F, 0.0F, 0.0F);
    this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
    this.rightarm.addBox(-5.0F, -2.0F, -2.0F, 5, 12, 4);
    this.rightarm.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.rightarm.setTextureSize(64, 64);
    this.rightarm.mirror = true;
    setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
    this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
    this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 5, 12, 4);
    this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
    this.leftarm.setTextureSize(64, 64);
    this.leftarm.mirror = true;
    setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
    this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
    this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
    this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
    this.rightleg.setTextureSize(64, 64);
    this.rightleg.mirror = true;
    setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
    this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
    this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
    this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
    this.leftleg.setTextureSize(64, 64);
    this.leftleg.mirror = true;
    setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
    this.hat2 = new ModelRenderer((ModelBase)this, 0, 44);
    this.hat2.addBox(-3.0F, -17.0F, -3.0F, 6, 8, 6);
    this.hat2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.hat2.setTextureSize(64, 64);
    this.hat2.mirror = true;
    setRotation(this.hat2, 0.0F, 0.0F, 0.0F);
    this.hat1 = new ModelRenderer((ModelBase)this, 0, 33);
    this.hat1.addBox(-5.0F, -9.0F, -5.0F, 10, 1, 10);
    this.hat1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.hat1.setTextureSize(64, 64);
    this.hat1.mirror = true;
    setRotation(this.hat1, 0.0F, 0.0F, 0.0F);
    this.pi1 = new ModelRenderer((ModelBase)this, 32, 13);
    this.pi1.addBox(-5.0F, -3.0F, -1.0F, 1, 1, 2);
    this.pi1.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.pi1.setTextureSize(64, 64);
    this.pi1.mirror = true;
    setRotation(this.pi1, 0.0F, 0.0F, 0.0F);
    this.pi2 = new ModelRenderer((ModelBase)this, 32, 13);
    this.pi2.addBox(-3.0F, -3.0F, -1.0F, 1, 1, 2);
    this.pi2.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.pi2.setTextureSize(64, 64);
    this.pi2.mirror = true;
    setRotation(this.pi2, 0.0F, 0.0F, 0.0F);
    this.pi3 = new ModelRenderer((ModelBase)this, 40, 5);
    this.pi3.addBox(-5.0F, -6.0F, 0.0F, 3, 3, 2);
    this.pi3.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.pi3.setTextureSize(64, 64);
    this.pi3.mirror = true;
    setRotation(this.pi3, 0.0F, 0.0F, 0.0F);
    this.pi4 = new ModelRenderer((ModelBase)this, 40, 14);
    this.pi4.addBox(-4.0F, -3.0F, 2.0F, 1, 0, 2);
    this.pi4.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.pi4.setTextureSize(64, 64);
    this.pi4.mirror = true;
    setRotation(this.pi4, 0.0F, 0.0F, 0.0F);
    this.pi5 = new ModelRenderer((ModelBase)this, 40, 10);
    this.pi5.addBox(-4.5F, -8.0F, 0.0F, 2, 2, 2);
    this.pi5.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.pi5.setTextureSize(64, 64);
    this.pi5.mirror = true;
    setRotation(this.pi5, 0.0F, 0.0F, 0.0F);
    this.pi6 = new ModelRenderer((ModelBase)this, 32, 9);
    this.pi6.addBox(-4.0F, -7.0F, -1.0F, 1, 1, 2);
    this.pi6.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.pi6.setTextureSize(64, 64);
    this.pi6.mirror = true;
    setRotation(this.pi6, 0.0F, 0.0F, 0.0F);
    this.pi7 = new ModelRenderer((ModelBase)this, 32, 2);
    this.pi7.addBox(-5.5F, -6.0F, 0.5F, 1, 3, 2);
    this.pi7.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.pi7.setTextureSize(64, 64);
    this.pi7.mirror = true;
    setRotation(this.pi7, 0.0F, 0.0F, 0.0F);
    this.pi8 = new ModelRenderer((ModelBase)this, 32, 2);
    this.pi8.addBox(-2.5F, -6.0F, 0.5F, 1, 3, 2);
    this.pi8.setRotationPoint(-4.0F, 2.0F, 0.0F);
    this.pi8.setTextureSize(64, 64);
    this.pi8.mirror = true;
    setRotation(this.pi8, 0.0F, 0.0F, 0.0F);
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
    this.rightarm.render(f5);
    this.leftarm.render(f5);
    this.rightleg.render(f5);
    this.leftleg.render(f5);
    this.hat2.render(f5);
    this.hat1.render(f5);
    this.pi1.render(f5);
    this.pi2.render(f5);
    this.pi3.render(f5);
    this.pi4.render(f5);
    this.pi5.render(f5);
    this.pi6.render(f5);
    this.pi7.render(f5);
    this.pi8.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
    this.leftleg.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.0F * par3;
    this.rightleg.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 1.0F * par3;
    this.leftarm.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.0F * par3;
    this.rightarm.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 1.0F * par3;
    this.pi1.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 2.0F * par3 * 0.5F;
    this.pi2.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 2.0F * par3 * 0.5F;
    this.pi3.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 2.0F * par3 * 0.5F;
    this.pi4.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 2.0F * par3 * 0.5F;
    this.pi5.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 2.0F * par3 * 0.5F;
    this.pi6.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 2.0F * par3 * 0.5F;
    this.pi7.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 2.0F * par3 * 0.5F;
    this.pi8.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 2.0F * par3 * 0.5F;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }
}
