package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKalifa extends ModelBiped {
  ModelRenderer head;
  
  ModelRenderer body;
  
  ModelRenderer rightarm;
  
  ModelRenderer leftarm;
  
  ModelRenderer rightleg;
  
  ModelRenderer leftleg;
  
  ModelRenderer hair_1;
  
  ModelRenderer right_hair;
  
  ModelRenderer left_hair;
  
  ModelRenderer bust;
  
  ModelRenderer glasses_front;
  
  public ModelKalifa() {
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
    this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.head.setTextureSize(64, 32);
    this.head.mirror = true;
    setRotation(this.head, 0.0F, 0.0F, 0.0F);
    this.body = new ModelRenderer((ModelBase)this, 16, 16);
    this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
    this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.body.setTextureSize(64, 32);
    this.body.mirror = true;
    setRotation(this.body, 0.0F, 0.0F, 0.0F);
    this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
    this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
    this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
    this.rightarm.setTextureSize(64, 32);
    this.rightarm.mirror = true;
    setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
    this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
    this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
    this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
    this.leftarm.setTextureSize(64, 32);
    this.leftarm.mirror = true;
    setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
    this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
    this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
    this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
    this.rightleg.setTextureSize(64, 32);
    this.rightleg.mirror = true;
    setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
    this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
    this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
    this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
    this.leftleg.setTextureSize(64, 32);
    this.leftleg.mirror = true;
    setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
    this.hair_1 = new ModelRenderer((ModelBase)this, 33, 0);
    this.hair_1.addBox(0.0F, 0.0F, 0.0F, 8, 7, 0);
    this.hair_1.setRotationPoint(-4.0F, 0.0F, 4.0F);
    this.hair_1.setTextureSize(64, 32);
    this.hair_1.mirror = true;
    setRotation(this.hair_1, 0.0F, 0.0F, 0.0F);
    this.right_hair = new ModelRenderer((ModelBase)this, 33, 7);
    this.right_hair.addBox(0.0F, 0.0F, 0.0F, 0, 7, 1);
    this.right_hair.setRotationPoint(-4.1F, -1.0F, -3.0F);
    this.right_hair.setTextureSize(64, 32);
    this.right_hair.mirror = true;
    setRotation(this.right_hair, 0.0F, 0.0F, 0.0F);
    this.left_hair = new ModelRenderer((ModelBase)this, 33, 7);
    this.left_hair.addBox(0.0F, 0.0F, 0.0F, 0, 7, 1);
    this.left_hair.setRotationPoint(4.1F, -1.0F, -3.0F);
    this.left_hair.setTextureSize(64, 32);
    this.left_hair.mirror = true;
    setRotation(this.left_hair, 0.0F, 0.0F, 0.0F);
    this.bust = new ModelRenderer((ModelBase)this, 36, 10);
    this.bust.addBox(0.0F, 0.0F, 0.0F, 8, 3, 2);
    this.bust.setRotationPoint(-4.0F, 2.0F, -3.5F);
    this.bust.setTextureSize(64, 32);
    this.bust.mirror = true;
    setRotation(this.bust, 0.0F, 0.0F, 0.0F);
    this.glasses_front = new ModelRenderer((ModelBase)this, 36, 8);
    this.glasses_front.addBox(0.0F, 0.0F, 0.0F, 8, 1, 0);
    this.glasses_front.setRotationPoint(-4.0F, -5.0F, -4.1F);
    this.glasses_front.setTextureSize(64, 32);
    this.glasses_front.mirror = true;
    setRotation(this.glasses_front, 0.0F, 0.0F, 0.0F);
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
    this.rightarm.render(f5);
    this.leftarm.render(f5);
    this.rightleg.render(f5);
    this.leftleg.render(f5);
    this.hair_1.render(f5);
    this.right_hair.render(f5);
    this.left_hair.render(f5);
    this.bust.render(f5);
    this.glasses_front.render(f5);
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
