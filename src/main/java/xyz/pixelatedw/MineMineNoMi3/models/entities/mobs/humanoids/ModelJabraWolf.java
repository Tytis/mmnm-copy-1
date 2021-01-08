package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelJabraWolf extends ModelBiped {
  ModelRenderer head;
  
  ModelRenderer muzzle;
  
  ModelRenderer hairclip_1;
  
  ModelRenderer hair_1;
  
  ModelRenderer hairclip_2;
  
  ModelRenderer hair_2;
  
  ModelRenderer hairclip_3;
  
  ModelRenderer hair_3;
  
  ModelRenderer hairclip_4;
  
  ModelRenderer hair_4;
  
  ModelRenderer hairclip_5;
  
  ModelRenderer hair_5;
  
  ModelRenderer hairclip_6;
  
  ModelRenderer hair_6;
  
  ModelRenderer hairclip_7;
  
  ModelRenderer hair_7;
  
  ModelRenderer body_1;
  
  ModelRenderer body_2;
  
  ModelRenderer body_3;
  
  ModelRenderer right_beard;
  
  ModelRenderer left_beard;
  
  ModelRenderer right_foot_1;
  
  ModelRenderer right_foot_2;
  
  ModelRenderer leftl_foot_1;
  
  ModelRenderer left_foot_2;
  
  ModelRenderer tail_1;
  
  ModelRenderer tail_2;
  
  ModelRenderer tail_3;
  
  ModelRenderer right_arm_1;
  
  ModelRenderer right_arm_2;
  
  ModelRenderer right_hand_1;
  
  ModelRenderer right_hand_2;
  
  ModelRenderer left_arm_1;
  
  ModelRenderer left_arm_2;
  
  ModelRenderer left_hand_1;
  
  ModelRenderer left_hand_2;
  
  ModelRenderer right_ear;
  
  ModelRenderer left_ear;
  
  ModelRenderer right_foot_3;
  
  ModelRenderer left_foot_3;
  
  ModelRenderer right_foot_4;
  
  ModelRenderer left_foot_4;
  
  public ModelJabraWolf() {
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
    this.head = new ModelRenderer((ModelBase)this, 80, 0);
    this.head.addBox(0.0F, 0.0F, 0.0F, 5, 5, 6);
    this.head.setRotationPoint(-2.5F, -10.0F, -1.0F);
    this.head.setTextureSize(128, 64);
    this.head.mirror = true;
    setRotation(this.head, 0.0F, 0.0F, 0.0F);
    this.muzzle = new ModelRenderer((ModelBase)this, 65, 0);
    this.muzzle.addBox(0.0F, 0.0F, 0.0F, 3, 2, 4);
    this.muzzle.setRotationPoint(-1.5F, -7.0F, -5.0F);
    this.muzzle.setTextureSize(128, 64);
    this.muzzle.mirror = true;
    setRotation(this.muzzle, 0.0F, 0.0F, 0.0F);
    this.hairclip_1 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_1.setRotationPoint(-0.5F, -8.5F, 5.0F);
    this.hairclip_1.setTextureSize(128, 64);
    this.hairclip_1.mirror = true;
    setRotation(this.hairclip_1, -0.2617994F, 0.0F, 0.0F);
    this.hair_1 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_1.setRotationPoint(-1.0F, -8.7F, 5.7F);
    this.hair_1.setTextureSize(128, 64);
    this.hair_1.mirror = true;
    setRotation(this.hair_1, -0.418879F, 0.0F, 0.0F);
    this.hairclip_2 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_2.setRotationPoint(-0.5F, -7.3F, 7.2F);
    this.hairclip_2.setTextureSize(128, 64);
    this.hairclip_2.mirror = true;
    setRotation(this.hairclip_2, -0.837758F, 0.0F, 0.0F);
    this.hair_2 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_2.setRotationPoint(-1.0F, -7.0F, 8.5F);
    this.hair_2.setTextureSize(128, 64);
    this.hair_2.mirror = true;
    setRotation(this.hair_2, -1.082104F, 0.0F, 0.0F);
    this.hairclip_3 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_3.setRotationPoint(-0.5F, -5.2F, 8.8F);
    this.hairclip_3.setTextureSize(128, 64);
    this.hairclip_3.mirror = true;
    setRotation(this.hairclip_3, -1.047198F, 0.0F, 0.0F);
    this.hair_3 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_3.setRotationPoint(-1.0F, -4.5F, 9.8F);
    this.hair_3.setTextureSize(128, 64);
    this.hair_3.mirror = true;
    setRotation(this.hair_3, -1.43117F, 0.0F, 0.0F);
    this.hairclip_4 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_4.setRotationPoint(-0.5F, -2.7F, 8.6F);
    this.hairclip_4.setTextureSize(128, 64);
    this.hairclip_4.mirror = true;
    setRotation(this.hairclip_4, 0.0F, 0.0F, 0.0F);
    this.hair_4 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_4.setRotationPoint(-1.0F, -2.0F, 8.1F);
    this.hair_4.setTextureSize(128, 64);
    this.hair_4.mirror = true;
    setRotation(this.hair_4, 0.0F, 0.0F, 0.0F);
    this.hairclip_5 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_5.setRotationPoint(-0.5F, -0.3F, 8.6F);
    this.hairclip_5.setTextureSize(128, 64);
    this.hairclip_5.mirror = true;
    setRotation(this.hairclip_5, 0.0F, 0.0F, 0.0F);
    this.hair_5 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_5.setRotationPoint(-1.0F, 0.5F, 8.1F);
    this.hair_5.setTextureSize(128, 64);
    this.hair_5.mirror = true;
    setRotation(this.hair_5, 0.0F, 0.0F, 0.0F);
    this.hairclip_6 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_6.setRotationPoint(-0.5F, 2.2F, 8.6F);
    this.hairclip_6.setTextureSize(128, 64);
    this.hairclip_6.mirror = true;
    setRotation(this.hairclip_6, 0.0F, 0.0F, 0.0F);
    this.hair_6 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_6.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_6.setRotationPoint(-1.0F, 3.0F, 8.1F);
    this.hair_6.setTextureSize(128, 64);
    this.hair_6.mirror = true;
    setRotation(this.hair_6, 0.0F, 0.0F, 0.0F);
    this.hairclip_7 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_7.setRotationPoint(-0.5F, 4.7F, 8.6F);
    this.hairclip_7.setTextureSize(128, 64);
    this.hairclip_7.mirror = true;
    setRotation(this.hairclip_7, 0.0F, 0.0F, 0.0F);
    this.hair_7 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_7.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_7.setRotationPoint(-1.0F, 5.1F, 9.1F);
    this.hair_7.setTextureSize(128, 64);
    this.hair_7.mirror = true;
    setRotation(this.hair_7, -0.7853982F, 0.0F, 0.0F);
    this.body_1 = new ModelRenderer((ModelBase)this, 0, 0);
    this.body_1.addBox(0.0F, 0.0F, 0.0F, 9, 17, 5);
    this.body_1.setRotationPoint(-4.5F, -5.0F, 0.0F);
    this.body_1.setTextureSize(128, 64);
    this.body_1.mirror = true;
    setRotation(this.body_1, 0.0F, 0.0F, 0.0F);
    this.body_2 = new ModelRenderer((ModelBase)this, 0, 46);
    this.body_2.addBox(0.0F, 0.0F, 0.0F, 9, 12, 5);
    this.body_2.setRotationPoint(2.5F, -7.0F, 0.0F);
    this.body_2.setTextureSize(128, 64);
    this.body_2.mirror = true;
    setRotation(this.body_2, 0.0F, 0.0F, 0.5235988F);
    this.body_3 = new ModelRenderer((ModelBase)this, 0, 28);
    this.body_3.addBox(0.0F, 0.0F, 0.0F, 9, 12, 5);
    this.body_3.setRotationPoint(-10.3F, -2.7F, 0.0F);
    this.body_3.setTextureSize(128, 64);
    this.body_3.mirror = true;
    setRotation(this.body_3, 0.0F, 0.0F, -0.5235988F);
    this.right_beard = new ModelRenderer((ModelBase)this, 44, 0);
    this.right_beard.addBox(0.0F, 0.0F, 0.0F, 1, 6, 0);
    this.right_beard.setRotationPoint(-2.5F, -6.0F, -4.1F);
    this.right_beard.setTextureSize(128, 64);
    this.right_beard.mirror = true;
    setRotation(this.right_beard, 0.0F, 0.0F, 0.0F);
    this.left_beard = new ModelRenderer((ModelBase)this, 47, 0);
    this.left_beard.addBox(0.0F, 0.0F, 0.0F, 1, 6, 0);
    this.left_beard.setRotationPoint(1.5F, -6.0F, -4.1F);
    this.left_beard.setTextureSize(128, 64);
    this.left_beard.mirror = true;
    setRotation(this.left_beard, 0.0F, 0.0F, 0.0F);
    this.right_foot_1 = new ModelRenderer((ModelBase)this, 34, 10);
    this.right_foot_1.addBox(0.5F, 12.0F, -3.5F, 2, 1, 3);
    this.right_foot_1.setRotationPoint(-4.5F, 11.0F, 1.2F);
    this.right_foot_1.setTextureSize(128, 64);
    this.right_foot_1.mirror = true;
    setRotation(this.right_foot_1, 0.0F, 0.0F, 0.0F);
    this.right_foot_2 = new ModelRenderer((ModelBase)this, 34, 15);
    this.right_foot_2.addBox(0.5F, 7.5F, 5.0F, 2, 4, 1);
    this.right_foot_2.setRotationPoint(-4.5F, 11.0F, 1.2F);
    this.right_foot_2.setTextureSize(128, 64);
    this.right_foot_2.mirror = true;
    setRotation(this.right_foot_2, -0.5235988F, 0.0F, 0.0F);
    this.leftl_foot_1 = new ModelRenderer((ModelBase)this, 34, 10);
    this.leftl_foot_1.addBox(0.5F, 12.0F, -3.5F, 2, 1, 3);
    this.leftl_foot_1.setRotationPoint(1.5F, 11.0F, 1.2F);
    this.leftl_foot_1.setTextureSize(128, 64);
    this.leftl_foot_1.mirror = true;
    setRotation(this.leftl_foot_1, 0.0F, 0.0F, 0.0F);
    this.left_foot_2 = new ModelRenderer((ModelBase)this, 34, 15);
    this.left_foot_2.addBox(0.5F, 7.5F, 5.0F, 2, 4, 1);
    this.left_foot_2.setRotationPoint(1.5F, 11.0F, 1.2F);
    this.left_foot_2.setTextureSize(128, 64);
    this.left_foot_2.mirror = true;
    setRotation(this.left_foot_2, -0.5235988F, 0.0F, 0.0F);
    this.tail_1 = new ModelRenderer((ModelBase)this, 34, 21);
    this.tail_1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 15);
    this.tail_1.setRotationPoint(-1.5F, 8.0F, 5.0F);
    this.tail_1.setTextureSize(128, 64);
    this.tail_1.mirror = true;
    setRotation(this.tail_1, -0.6108652F, 0.0F, 0.0F);
    this.tail_2 = new ModelRenderer((ModelBase)this, 34, 40);
    this.tail_2.addBox(0.0F, 0.0F, 0.0F, 4, 4, 11);
    this.tail_2.setRotationPoint(-2.0F, 9.6F, 8.0F);
    this.tail_2.setTextureSize(128, 64);
    this.tail_2.mirror = true;
    setRotation(this.tail_2, -0.6108652F, 0.0F, 0.0F);
    this.tail_3 = new ModelRenderer((ModelBase)this, 71, 21);
    this.tail_3.addBox(0.0F, 0.0F, 0.0F, 5, 5, 9);
    this.tail_3.setRotationPoint(-2.5F, 9.8F, 9.0F);
    this.tail_3.setTextureSize(128, 64);
    this.tail_3.mirror = true;
    setRotation(this.tail_3, -0.6108652F, 0.0F, 0.0F);
    this.right_arm_1 = new ModelRenderer((ModelBase)this, 103, 0);
    this.right_arm_1.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3);
    this.right_arm_1.setRotationPoint(-9.0F, -1.0F, 1.0F);
    this.right_arm_1.setTextureSize(128, 64);
    this.right_arm_1.mirror = true;
    setRotation(this.right_arm_1, 0.0F, 0.0F, 0.1745329F);
    this.right_arm_2 = new ModelRenderer((ModelBase)this, 103, 0);
    this.right_arm_2.addBox(-2.3F, 7.0F, 0.0F, 3, 7, 3);
    this.right_arm_2.setRotationPoint(-9.0F, -1.0F, 1.0F);
    this.right_arm_2.setTextureSize(128, 64);
    this.right_arm_2.mirror = true;
    setRotation(this.right_arm_2, 0.0F, 0.0F, -0.1745329F);
    this.right_hand_1 = new ModelRenderer((ModelBase)this, 52, 11);
    this.right_hand_1.addBox(-2.3F, 14.0F, 1.0F, 3, 3, 1);
    this.right_hand_1.setRotationPoint(-9.0F, -1.0F, 1.0F);
    this.right_hand_1.setTextureSize(128, 64);
    this.right_hand_1.mirror = true;
    setRotation(this.right_hand_1, 0.0F, 0.0F, -0.1745329F);
    this.right_hand_2 = new ModelRenderer((ModelBase)this, 55, 16);
    this.right_hand_2.addBox(-5.0F, 13.0F, 1.0F, 1, 2, 1);
    this.right_hand_2.setRotationPoint(-9.0F, -1.0F, 1.0F);
    this.right_hand_2.setTextureSize(128, 64);
    this.right_hand_2.mirror = true;
    setRotation(this.right_hand_2, 0.0F, 0.0F, -0.5235988F);
    this.left_arm_1 = new ModelRenderer((ModelBase)this, 103, 0);
    this.left_arm_1.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3);
    this.left_arm_1.setRotationPoint(6.0F, 0.0F, 1.0F);
    this.left_arm_1.setTextureSize(128, 64);
    this.left_arm_1.mirror = true;
    setRotation(this.left_arm_1, 0.0F, 0.0F, -0.1745329F);
    this.left_arm_2 = new ModelRenderer((ModelBase)this, 103, 0);
    this.left_arm_2.addBox(2.3F, 6.0F, 0.0F, 3, 7, 3);
    this.left_arm_2.setRotationPoint(6.0F, 0.0F, 1.0F);
    this.left_arm_2.setTextureSize(128, 64);
    this.left_arm_2.mirror = true;
    setRotation(this.left_arm_2, 0.0F, 0.0F, 0.1745329F);
    this.left_hand_1 = new ModelRenderer((ModelBase)this, 52, 11);
    this.left_hand_1.addBox(2.3F, 13.0F, 1.0F, 3, 3, 1);
    this.left_hand_1.setRotationPoint(6.0F, 0.0F, 1.0F);
    this.left_hand_1.setTextureSize(128, 64);
    this.left_hand_1.mirror = true;
    setRotation(this.left_hand_1, 0.0F, 0.0F, 0.1745329F);
    this.left_hand_2 = new ModelRenderer((ModelBase)this, 55, 16);
    this.left_hand_2.addBox(6.3F, 11.0F, 1.0F, 1, 2, 1);
    this.left_hand_2.setRotationPoint(6.0F, 0.0F, 1.0F);
    this.left_hand_2.setTextureSize(128, 64);
    this.left_hand_2.mirror = true;
    setRotation(this.left_hand_2, 0.0F, 0.0F, 0.5235988F);
    this.right_ear = new ModelRenderer((ModelBase)this, 65, 16);
    this.right_ear.addBox(0.0F, 0.0F, 0.0F, 1, 2, 0);
    this.right_ear.setRotationPoint(-3.0F, -11.5F, 0.0F);
    this.right_ear.setTextureSize(128, 64);
    this.right_ear.mirror = true;
    setRotation(this.right_ear, 0.0F, 0.0F, -0.3490659F);
    this.left_ear = new ModelRenderer((ModelBase)this, 65, 16);
    this.left_ear.addBox(0.0F, 0.0F, 0.0F, 1, 2, 0);
    this.left_ear.setRotationPoint(2.0F, -11.7F, 0.0F);
    this.left_ear.setTextureSize(128, 64);
    this.left_ear.mirror = true;
    setRotation(this.left_ear, 0.0F, 0.0F, 0.3490659F);
    this.right_foot_3 = new ModelRenderer((ModelBase)this, 41, 15);
    this.right_foot_3.addBox(0.5F, 7.0F, -1.0F, 2, 3, 2);
    this.right_foot_3.setRotationPoint(-4.5F, 11.0F, 1.2F);
    this.right_foot_3.setTextureSize(128, 64);
    this.right_foot_3.mirror = true;
    setRotation(this.right_foot_3, 0.1396263F, 0.0F, 0.0F);
    this.left_foot_3 = new ModelRenderer((ModelBase)this, 41, 15);
    this.left_foot_3.addBox(0.5F, 7.0F, -1.0F, 2, 3, 2);
    this.left_foot_3.setRotationPoint(1.5F, 11.0F, 1.2F);
    this.left_foot_3.setTextureSize(128, 64);
    this.left_foot_3.mirror = true;
    setRotation(this.left_foot_3, 0.1396263F, 0.0F, 0.0F);
    this.right_foot_4 = new ModelRenderer((ModelBase)this, 52, 0);
    this.right_foot_4.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3);
    this.right_foot_4.setRotationPoint(-4.5F, 11.0F, 1.2F);
    this.right_foot_4.setTextureSize(128, 64);
    this.right_foot_4.mirror = true;
    setRotation(this.right_foot_4, -0.1047198F, 0.0F, 0.0F);
    this.left_foot_4 = new ModelRenderer((ModelBase)this, 52, 0);
    this.left_foot_4.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3);
    this.left_foot_4.setRotationPoint(1.5F, 11.0F, 1.2F);
    this.left_foot_4.setTextureSize(128, 64);
    this.left_foot_4.mirror = true;
    setRotation(this.left_foot_4, -0.1047198F, 0.0F, 0.0F);
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
    this.muzzle.render(f5);
    this.hairclip_1.render(f5);
    this.hair_1.render(f5);
    this.hairclip_2.render(f5);
    this.hair_2.render(f5);
    this.hairclip_3.render(f5);
    this.hair_3.render(f5);
    this.hairclip_4.render(f5);
    this.hair_4.render(f5);
    this.hairclip_5.render(f5);
    this.hair_5.render(f5);
    this.hairclip_6.render(f5);
    this.hair_6.render(f5);
    this.hairclip_7.render(f5);
    this.hair_7.render(f5);
    this.body_1.render(f5);
    this.body_2.render(f5);
    this.body_3.render(f5);
    this.right_beard.render(f5);
    this.left_beard.render(f5);
    this.right_foot_1.render(f5);
    this.right_foot_2.render(f5);
    this.leftl_foot_1.render(f5);
    this.left_foot_2.render(f5);
    this.tail_1.render(f5);
    this.tail_2.render(f5);
    this.tail_3.render(f5);
    this.right_arm_1.render(f5);
    this.right_arm_2.render(f5);
    this.right_hand_1.render(f5);
    this.right_hand_2.render(f5);
    this.left_arm_1.render(f5);
    this.left_arm_2.render(f5);
    this.left_hand_1.render(f5);
    this.left_hand_2.render(f5);
    this.right_ear.render(f5);
    this.left_ear.render(f5);
    this.right_foot_3.render(f5);
    this.left_foot_3.render(f5);
    this.right_foot_4.render(f5);
    this.left_foot_4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, null);
    this.leftl_foot_1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.left_foot_2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 + 5.8F;
    this.left_foot_3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 + 6.31F;
    this.left_foot_4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 + 6.1F;
    this.left_arm_1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.left_arm_2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.left_hand_1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.left_hand_2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.right_foot_1.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    this.right_foot_2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1 + 5.8F;
    this.right_foot_3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1 + 6.31F;
    this.right_foot_4.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1 + 6.1F;
    this.right_arm_1.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    this.right_arm_2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    this.right_hand_1.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
    this.right_hand_2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1;
  }
}
