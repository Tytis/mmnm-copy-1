package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKumadori extends ModelBiped {
  ModelRenderer head;
  
  ModelRenderer body;
  
  ModelRenderer body_2;
  
  ModelRenderer body_3;
  
  ModelRenderer body_4;
  
  ModelRenderer rightarm;
  
  ModelRenderer leftarm;
  
  ModelRenderer rightleg;
  
  ModelRenderer leftleg;
  
  ModelRenderer Hair_1;
  
  ModelRenderer Hair_2;
  
  ModelRenderer Hair_3;
  
  ModelRenderer Hair_4;
  
  ModelRenderer Hair_5;
  
  ModelRenderer Hair_6;
  
  ModelRenderer right_hair;
  
  ModelRenderer right_hair_2;
  
  ModelRenderer left_hair;
  
  ModelRenderer left_hair_2;
  
  ModelRenderer staff;
  
  ModelRenderer ring_1;
  
  ModelRenderer ring_2;
  
  ModelRenderer ring_3;
  
  public ModelKumadori() {
    this.textureWidth = 128;
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
    this.head.setRotationPoint(0.0F, -8.0F, 0.0F);
    this.head.setTextureSize(64, 32);
    this.head.mirror = true;
    setRotation(this.head, 0.0F, 0.0F, 0.0F);
    this.body = new ModelRenderer((ModelBase)this, -1, 17);
    this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 14, 4);
    this.body.setRotationPoint(0.0F, -2.0F, 0.0F);
    this.body.setTextureSize(64, 32);
    this.body.mirror = true;
    setRotation(this.body, 0.0F, 0.0F, 0.0F);
    this.body_2 = new ModelRenderer((ModelBase)this, 0, 36);
    this.body_2.addBox(0.0F, 0.0F, 0.0F, 6, 14, 4);
    this.body_2.setRotationPoint(-8.0F, -4.0F, -2.0F);
    this.body_2.setTextureSize(64, 32);
    this.body_2.mirror = true;
    setRotation(this.body_2, 0.0F, 0.0F, -0.296706F);
    this.body_3 = new ModelRenderer((ModelBase)this, 0, 36);
    this.body_3.addBox(0.0F, 0.0F, 0.0F, 6, 14, 4);
    this.body_3.setRotationPoint(2.3F, -5.6F, -2.0F);
    this.body_3.setTextureSize(64, 32);
    this.body_3.mirror = true;
    setRotation(this.body_3, 0.0F, 0.0F, 0.296706F);
    this.body_4 = new ModelRenderer((ModelBase)this, 88, 53);
    this.body_4.addBox(0.0F, 0.0F, 0.0F, 16, 6, 4);
    this.body_4.setRotationPoint(-8.0F, -8.0F, -2.0F);
    this.body_4.setTextureSize(64, 32);
    this.body_4.mirror = true;
    setRotation(this.body_4, 0.0F, 0.0F, 0.0F);
    this.rightarm = new ModelRenderer((ModelBase)this, 46, 0);
    this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 15, 4);
    this.rightarm.setRotationPoint(-9.0F, -6.0F, 0.0F);
    this.rightarm.setTextureSize(64, 32);
    this.rightarm.mirror = true;
    setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
    this.leftarm = new ModelRenderer((ModelBase)this, 46, 0);
    this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 15, 4);
    this.leftarm.setRotationPoint(9.0F, -6.0F, 0.0F);
    this.leftarm.setTextureSize(64, 32);
    this.leftarm.mirror = true;
    setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
    this.rightleg = new ModelRenderer((ModelBase)this, 63, 0);
    this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
    this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
    this.rightleg.setTextureSize(64, 32);
    this.rightleg.mirror = true;
    setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
    this.leftleg = new ModelRenderer((ModelBase)this, 63, 0);
    this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
    this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
    this.leftleg.setTextureSize(64, 32);
    this.leftleg.mirror = true;
    setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
    this.Hair_1 = new ModelRenderer((ModelBase)this, 80, 0);
    this.Hair_1.addBox(0.0F, 0.0F, 0.0F, 14, 5, 10);
    this.Hair_1.setRotationPoint(-7.0F, -21.0F, -3.0F);
    this.Hair_1.setTextureSize(64, 32);
    this.Hair_1.mirror = true;
    setRotation(this.Hair_1, -0.1745329F, 0.0F, 0.0F);
    this.Hair_2 = new ModelRenderer((ModelBase)this, 83, 17);
    this.Hair_2.addBox(0.0F, 0.0F, 0.0F, 13, 7, 10);
    this.Hair_2.setRotationPoint(-6.5F, -19.0F, 6.0F);
    this.Hair_2.setTextureSize(64, 32);
    this.Hair_2.mirror = true;
    setRotation(this.Hair_2, -1.117011F, 0.0F, 0.0F);
    this.Hair_3 = new ModelRenderer((ModelBase)this, 84, 35);
    this.Hair_3.addBox(0.0F, 0.0F, 0.0F, 12, 7, 9);
    this.Hair_3.setRotationPoint(-6.0F, -10.0F, 10.0F);
    this.Hair_3.setTextureSize(64, 32);
    this.Hair_3.mirror = true;
    setRotation(this.Hair_3, -1.570796F, 0.0F, 0.0F);
    this.Hair_4 = new ModelRenderer((ModelBase)this, 43, 49);
    this.Hair_4.addBox(0.0F, 0.0F, 0.0F, 11, 6, 8);
    this.Hair_4.setRotationPoint(-5.5F, -1.0F, 9.5F);
    this.Hair_4.setTextureSize(64, 32);
    this.Hair_4.mirror = true;
    setRotation(this.Hair_4, -1.570796F, 0.0F, 0.0F);
    this.Hair_5 = new ModelRenderer((ModelBase)this, 43, 35);
    this.Hair_5.addBox(0.0F, 0.0F, 0.0F, 10, 5, 8);
    this.Hair_5.setRotationPoint(-5.0F, 7.0F, 9.0F);
    this.Hair_5.setTextureSize(64, 32);
    this.Hair_5.mirror = true;
    setRotation(this.Hair_5, -1.570796F, 0.0F, 0.0F);
    this.Hair_6 = new ModelRenderer((ModelBase)this, 43, 24);
    this.Hair_6.addBox(0.0F, 0.0F, 0.0F, 6, 4, 6);
    this.Hair_6.setRotationPoint(0.0F, 10.2F, 8.5F);
    this.Hair_6.setTextureSize(64, 32);
    this.Hair_6.mirror = true;
    setRotation(this.Hair_6, -1.570796F, 0.0F, 0.7853982F);
    this.right_hair = new ModelRenderer((ModelBase)this, 24, 17);
    this.right_hair.addBox(0.0F, 0.0F, 0.0F, 3, 9, 3);
    this.right_hair.setRotationPoint(-7.0F, -17.0F, -3.5F);
    this.right_hair.setTextureSize(64, 32);
    this.right_hair.mirror = true;
    setRotation(this.right_hair, -0.1745329F, 0.0F, 0.0F);
    this.right_hair_2 = new ModelRenderer((ModelBase)this, 24, 30);
    this.right_hair_2.addBox(0.0F, 0.0F, 0.0F, 3, 15, 3);
    this.right_hair_2.setRotationPoint(-7.0F, -8.2F, -5.0F);
    this.right_hair_2.setTextureSize(64, 32);
    this.right_hair_2.mirror = true;
    setRotation(this.right_hair_2, 0.0F, 0.0F, 0.0F);
    this.left_hair = new ModelRenderer((ModelBase)this, 24, 17);
    this.left_hair.addBox(0.0F, 0.0F, 0.0F, 3, 9, 3);
    this.left_hair.setRotationPoint(4.0F, -17.0F, -3.5F);
    this.left_hair.setTextureSize(64, 32);
    this.left_hair.mirror = true;
    setRotation(this.left_hair, -0.1745329F, 0.0F, 0.0F);
    this.left_hair_2 = new ModelRenderer((ModelBase)this, 24, 30);
    this.left_hair_2.addBox(0.0F, 0.0F, 0.0F, 3, 15, 3);
    this.left_hair_2.setRotationPoint(4.0F, -8.2F, -5.0F);
    this.left_hair_2.setTextureSize(64, 32);
    this.left_hair_2.mirror = true;
    setRotation(this.left_hair_2, 0.0F, 0.0F, 0.0F);
    this.staff = new ModelRenderer((ModelBase)this, 37, 0);
    this.staff.addBox(0.0F, 0.0F, 0.0F, 1, 45, 1);
    this.staff.setRotationPoint(-14.0F, -25.0F, 8.0F);
    this.staff.setTextureSize(64, 32);
    this.staff.mirror = true;
    setRotation(this.staff, 0.0F, 0.0F, -0.6108652F);
    this.ring_1 = new ModelRenderer((ModelBase)this, 0, 59);
    this.ring_1.addBox(0.0F, 0.0F, 0.0F, 4, 4, 1);
    this.ring_1.setRotationPoint(-17.3F, -27.3F, 8.0F);
    this.ring_1.setTextureSize(64, 32);
    this.ring_1.mirror = true;
    setRotation(this.ring_1, 0.0F, 0.0F, -0.6108652F);
    this.ring_2 = new ModelRenderer((ModelBase)this, 12, 59);
    this.ring_2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
    this.ring_2.setRotationPoint(-17.5F, -22.5F, 6.5F);
    this.ring_2.setTextureSize(64, 32);
    this.ring_2.mirror = true;
    setRotation(this.ring_2, 0.0F, 0.0F, -1.134464F);
    this.ring_3 = new ModelRenderer((ModelBase)this, 12, 59);
    this.ring_3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
    this.ring_3.setRotationPoint(-19.0F, -24.5F, 6.5F);
    this.ring_3.setTextureSize(64, 32);
    this.ring_3.mirror = true;
    setRotation(this.ring_3, 0.0F, 0.0F, -0.5759587F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.bipedLeftLeg.isHidden = true;
    this.bipedRightLeg.isHidden = true;
    this.bipedLeftArm.isHidden = true;
    this.bipedRightArm.isHidden = true;
    this.bipedBody.isHidden = true;
    this.bipedHead.isHidden = true;
    this.head.render(f5);
    this.body.render(f5);
    this.body_2.render(f5);
    this.body_3.render(f5);
    this.body_4.render(f5);
    this.rightarm.render(f5);
    this.leftarm.render(f5);
    this.rightleg.render(f5);
    this.leftleg.render(f5);
    this.Hair_1.render(f5);
    this.Hair_2.render(f5);
    this.Hair_3.render(f5);
    this.Hair_4.render(f5);
    this.Hair_5.render(f5);
    this.Hair_6.render(f5);
    this.right_hair.render(f5);
    this.right_hair_2.render(f5);
    this.left_hair.render(f5);
    this.left_hair_2.render(f5);
    this.staff.render(f5);
    this.ring_1.render(f5);
    this.ring_2.render(f5);
    this.ring_3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, null);
    this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
    this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
    this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
  }
}
