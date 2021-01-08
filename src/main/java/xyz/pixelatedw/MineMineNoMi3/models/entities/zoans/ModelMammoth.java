package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMammoth extends ModelZoanMorph {
  public ModelRenderer LeftBackThigh;
  
  public ModelRenderer RightBackThigh;
  
  public ModelRenderer Waist;
  
  public ModelRenderer LeftBackCalf;
  
  public ModelRenderer LeftBackFoot;
  
  public ModelRenderer RightBackCalf;
  
  public ModelRenderer RightBackFoot;
  
  public ModelRenderer Tail;
  
  public ModelRenderer Chest;
  
  public ModelRenderer FurBackRightWaist;
  
  public ModelRenderer FurBackLeftWaist;
  
  public ModelRenderer Neck;
  
  public ModelRenderer RightFrontThigh1;
  
  public ModelRenderer LeftFrontThigh1;
  
  public ModelRenderer FurFrontLeftChest;
  
  public ModelRenderer FurFrontRightChest;
  
  public ModelRenderer FurJointChest;
  
  public ModelRenderer LowerHead;
  
  public ModelRenderer FurFrontRightNeck;
  
  public ModelRenderer FurFrontLeftNeck;
  
  public ModelRenderer FurJointNeck;
  
  public ModelRenderer Mouth;
  
  public ModelRenderer LeftEar;
  
  public ModelRenderer RightEar;
  
  public ModelRenderer Trunk1;
  
  public ModelRenderer UpperHead;
  
  public ModelRenderer LeftTusk1;
  
  public ModelRenderer RightTusk1;
  
  public ModelRenderer Trunk2;
  
  public ModelRenderer Trunk3;
  
  public ModelRenderer Trunk4;
  
  public ModelRenderer Trunk5;
  
  public ModelRenderer Trunk6;
  
  public ModelRenderer Trunk7;
  
  public ModelRenderer LeftTusk2;
  
  public ModelRenderer LeftTusk3;
  
  public ModelRenderer LeftTusk4;
  
  public ModelRenderer LeftTusk5;
  
  public ModelRenderer RightTusk2;
  
  public ModelRenderer RightTusk3;
  
  public ModelRenderer RightTusk4;
  
  public ModelRenderer RightTusk5;
  
  public ModelRenderer FurFrontMiddleNeck;
  
  public ModelRenderer RightFrontThigh2;
  
  public ModelRenderer RightFrontCalf;
  
  public ModelRenderer RightFrontFoot;
  
  public ModelRenderer LeftFrontThigh2;
  
  public ModelRenderer LeftFrontCalf;
  
  public ModelRenderer LeftFrontFoot;
  
  public ModelRenderer FurFrontMiddleChest;
  
  public ModelRenderer[] lefttuskparts;
  
  public ModelRenderer[] righttuskparts;
  
  public ModelRenderer[] trunkParts;
  
  public ModelMammoth() {
    this.textureWidth = 128;
    this.textureHeight = 128;
    (this.RightBackFoot = new ModelRenderer(this, 0, 59)).setRotationPoint(0.0F, 8.0F, 2.0F);
    this.RightBackFoot.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 6, 0.0F);
    setRotateAngle(this.RightBackFoot, -0.19198622F, -0.0F, 0.0F);
    (this.RightFrontCalf = new ModelRenderer(this, 0, 34)).setRotationPoint(0.0F, 5.7F, 3.7F);
    this.RightFrontCalf.addBox(-2.0F, 0.0F, -2.8F, 4, 7, 5, 0.0F);
    setRotateAngle(this.RightFrontCalf, -0.33161256F, -0.0F, 0.0F);
    (this.Chest = new ModelRenderer(this, 28, 1)).setRotationPoint(0.0F, -1.0F, -7.0F);
    this.Chest.addBox(-9.0F, -9.5F, -17.0F, 18, 19, 17, 0.0F);
    setRotateAngle(this.Chest, 0.2268928F, 0.0F, 0.0F);
    (this.Mouth = new ModelRenderer(this, 44, 115)).setRotationPoint(0.0F, 4.0F, -2.25F);
    this.Mouth.addBox(-3.5F, 0.0F, -7.0F, 7, 2, 7, 0.0F);
    setRotateAngle(this.Mouth, 0.33457962F, -0.0F, 0.0F);
    (this.Trunk6 = new ModelRenderer(this, 102, 2)).setRotationPoint(0.0F, 0.0F, -4.75F);
    this.Trunk6.addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6, 0.0F);
    setRotateAngle(this.Trunk6, 0.2617994F, 0.0F, 0.0F);
    (this.FurFrontRightChest = new ModelRenderer(this, 86, 73)).setRotationPoint(6.6F, 8.7F, -9.0F);
    this.FurFrontRightChest.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
    setRotateAngle(this.FurFrontRightChest, 0.0F, 0.08726646F, 0.0F);
    (this.LeftTusk2 = new ModelRenderer(this, 79, 39)).setRotationPoint(0.0F, 7.0F, 0.0F);
    this.LeftTusk2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.LeftTusk2, -0.2617994F, 0.0F, 0.017453292F);
    (this.LeftTusk5 = new ModelRenderer(this, 79, 39)).setRotationPoint(0.0F, 4.5F, 0.0F);
    this.LeftTusk5.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
    setRotateAngle(this.LeftTusk5, -0.5235988F, 0.08726646F, 0.017453292F);
    (this.RightTusk1 = new ModelRenderer(this, 79, 39)).setRotationPoint(-3.5F, 2.0F, -5.0F);
    this.RightTusk1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
    setRotateAngle(this.RightTusk1, -0.17453292F, 0.0F, 0.17453292F);
    (this.LeftFrontFoot = new ModelRenderer(this, 0, 48)).setRotationPoint(0.0F, 7.0F, -2.8F);
    this.LeftFrontFoot.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
    setRotateAngle(this.LeftFrontFoot, 0.12217305F, -0.0F, 0.0F);
    (this.LeftFrontCalf = new ModelRenderer(this, 0, 34)).setRotationPoint(0.0F, 5.7F, 3.7F);
    this.LeftFrontCalf.addBox(-2.0F, 0.0F, -2.8F, 4, 7, 5, 0.0F);
    setRotateAngle(this.LeftFrontCalf, -0.33161256F, -0.0F, 0.0F);
    (this.RightEar = new ModelRenderer(this, 114, 39)).setRotationPoint(-4.5F, -4.0F, -2.0F);
    this.RightEar.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
    setRotateAngle(this.RightEar, 0.13508849F, -0.61086524F, 0.0F);
    (this.Trunk4 = new ModelRenderer(this, 100, 53)).setRotationPoint(0.0F, 0.0F, -5.25F);
    this.Trunk4.addBox(-3.0F, -3.0F, -6.0F, 6, 6, 6, 0.0F);
    setRotateAngle(this.Trunk4, 0.17453292F, 0.0F, 0.0F);
    (this.LeftBackThigh = new ModelRenderer(this, 0, 87)).setRotationPoint(6.0F, 5.3F, 12.0F);
    this.LeftBackThigh.addBox(-3.0F, -2.5F, -2.7F, 6, 10, 8, 0.0F);
    setRotateAngle(this.LeftBackThigh, -0.13613568F, -0.0F, 0.0F);
    (this.Neck = new ModelRenderer(this, 92, 106)).setRotationPoint(0.0F, -2.5F, -15.2F);
    this.Neck.addBox(-6.0F, -7.0F, -4.0F, 12, 14, 4, 0.0F);
    setRotateAngle(this.Neck, 0.045553092F, -0.0F, 0.0F);
    (this.LeftTusk3 = new ModelRenderer(this, 79, 39)).setRotationPoint(0.0F, 5.0F, 0.0F);
    this.LeftTusk3.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.LeftTusk3, -0.43633232F, 0.08726646F, 0.017453292F);
    (this.UpperHead = new ModelRenderer(this, 0, 106)).setRotationPoint(0.0F, -4.0F, -1.0F);
    this.UpperHead.addBox(-4.5F, -4.5F, -6.5F, 9, 5, 12, 0.0F);
    setRotateAngle(this.UpperHead, -0.08726646F, 0.0F, 0.0F);
    (this.RightBackCalf = new ModelRenderer(this, 0, 71)).setRotationPoint(0.0F, 6.6F, -2.0F);
    this.RightBackCalf.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 6, 0.0F);
    setRotateAngle(this.RightBackCalf, 0.3281219F, -0.0F, 0.0F);
    (this.RightTusk4 = new ModelRenderer(this, 79, 39)).setRotationPoint(0.0F, 4.5F, 0.0F);
    this.RightTusk4.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.RightTusk4, -0.34906584F, -0.08726646F, -0.017453292F);
    (this.FurFrontLeftNeck = new ModelRenderer(this, 86, 73)).setRotationPoint(-6.0F, 6.3F, 4.0F);
    this.FurFrontLeftNeck.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
    (this.FurFrontMiddleChest = new ModelRenderer(this, 91, 78)).setRotationPoint(0.0F, 0.0F, 0.0F);
    this.FurFrontMiddleChest.addBox(0.0F, 0.0F, -6.0F, 0, 9, 12, 0.0F);
    setRotateAngle(this.FurFrontMiddleChest, 3.1415927F, 1.5707964F, 3.1415927F);
    (this.FurJointChest = new ModelRenderer(this, 0, 0)).setRotationPoint(0.0F, 8.7F, -17.0F);
    this.FurJointChest.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    (this.LeftFrontThigh2 = new ModelRenderer(this, 0, 19)).setRotationPoint(1.0F, 9.0F, 0.5F);
    this.LeftFrontThigh2.addBox(-2.5F, 0.0F, 0.0F, 5, 7, 6, 0.0F);
    setRotateAngle(this.LeftFrontThigh2, 0.15707964F, -0.0F, 0.0F);
    (this.Tail = new ModelRenderer(this, 23, 18)).setRotationPoint(-0.5F, -7.0F, 5.0F);
    this.Tail.addBox(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
    setRotateAngle(this.Tail, 0.4098033F, 0.0F, 0.0F);
    (this.RightFrontFoot = new ModelRenderer(this, 0, 48)).setRotationPoint(0.0F, 7.0F, -2.8F);
    this.RightFrontFoot.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
    setRotateAngle(this.RightFrontFoot, 0.12217305F, -0.0F, 0.0F);
    (this.FurBackLeftWaist = new ModelRenderer(this, 86, 73)).setRotationPoint(-7.9F, 8.0F, -5.5F);
    this.FurBackLeftWaist.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
    setRotateAngle(this.FurBackLeftWaist, 0.29670596F, 0.0F, 0.0F);
    (this.LeftFrontThigh1 = new ModelRenderer(this, 0, 0)).setRotationPoint(7.0F, -1.1F, -16.0F);
    this.LeftFrontThigh1.addBox(-2.0F, 0.0F, 0.0F, 6, 10, 7, 0.0F);
    setRotateAngle(this.LeftFrontThigh1, 0.13962634F, -0.0F, 0.0F);
    (this.RightTusk5 = new ModelRenderer(this, 79, 39)).setRotationPoint(0.0F, 4.5F, 0.0F);
    this.RightTusk5.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
    setRotateAngle(this.RightTusk5, -0.5235988F, -0.08726646F, -0.017453292F);
    (this.Trunk3 = new ModelRenderer(this, 100, 14)).setRotationPoint(0.0F, 0.0F, -3.5F);
    this.Trunk3.addBox(-3.5F, -3.5F, -7.0F, 7, 7, 7, 0.0F);
    setRotateAngle(this.Trunk3, 0.2617994F, 0.0F, 0.0F);
    (this.RightFrontThigh2 = new ModelRenderer(this, 0, 19)).setRotationPoint(-1.0F, 9.0F, 0.5F);
    this.RightFrontThigh2.addBox(-2.5F, 0.0F, 0.0F, 5, 7, 6, 0.0F);
    setRotateAngle(this.RightFrontThigh2, 0.15707964F, -0.0F, 0.0F);
    (this.FurJointNeck = new ModelRenderer(this, 0, 0)).setRotationPoint(0.0F, 6.3F, -3.9F);
    this.FurJointNeck.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    (this.LeftBackCalf = new ModelRenderer(this, 0, 71)).setRotationPoint(0.0F, 6.6F, -2.0F);
    this.LeftBackCalf.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 6, 0.0F);
    setRotateAngle(this.LeftBackCalf, 0.3281219F, -0.0F, 0.0F);
    (this.Trunk5 = new ModelRenderer(this, 91, 40)).setRotationPoint(0.0F, 0.0F, -4.75F);
    this.Trunk5.addBox(-2.5F, -2.5F, -6.0F, 5, 5, 6, 0.0F);
    setRotateAngle(this.Trunk5, 0.17453292F, 0.0F, 0.0F);
    (this.FurBackRightWaist = new ModelRenderer(this, 86, 73)).setRotationPoint(7.9F, 8.0F, -5.5F);
    this.FurBackRightWaist.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
    setRotateAngle(this.FurBackRightWaist, 0.27314404F, 0.0F, 0.0F);
    (this.LeftBackFoot = new ModelRenderer(this, 0, 59)).setRotationPoint(0.0F, 8.0F, 2.0F);
    this.LeftBackFoot.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 6, 0.0F);
    setRotateAngle(this.LeftBackFoot, -0.19198622F, -0.0F, 0.0F);
    (this.Trunk2 = new ModelRenderer(this, 43, 94)).setRotationPoint(0.0F, -1.25F, -3.5F);
    this.Trunk2.addBox(-4.0F, -4.5F, -5.0F, 8, 9, 6, 0.0F);
    setRotateAngle(this.Trunk2, 0.5235988F, 0.0F, 0.0F);
    (this.LeftEar = new ModelRenderer(this, 114, 39)).setRotationPoint(4.5F, -4.0F, -2.0F);
    this.LeftEar.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
    setRotateAngle(this.LeftEar, 0.13508849F, 0.61086524F, 0.0F);
    (this.RightBackThigh = new ModelRenderer(this, 0, 87)).setRotationPoint(-6.0F, 5.3F, 12.0F);
    this.RightBackThigh.addBox(-3.0F, -2.5F, -2.7F, 6, 10, 8, 0.0F);
    setRotateAngle(this.RightBackThigh, -0.13613568F, -0.0F, 0.0F);
    (this.LowerHead = new ModelRenderer(this, 29, 73)).setRotationPoint(0.0F, -2.5F, -4.0F);
    this.LowerHead.addBox(-5.5F, -6.0F, -8.0F, 11, 12, 8, 0.0F);
    (this.RightFrontThigh1 = new ModelRenderer(this, 0, 0)).setRotationPoint(-7.0F, -1.1F, -16.0F);
    this.RightFrontThigh1.addBox(-4.0F, 0.0F, 0.0F, 6, 10, 7, 0.0F);
    setRotateAngle(this.RightFrontThigh1, 0.13962634F, -0.0F, 0.0F);
    (this.Trunk1 = new ModelRenderer(this, 88, 73)).setRotationPoint(0.0F, 0.0F, -5.0F);
    this.Trunk1.addBox(-4.5F, -6.0F, -5.75F, 9, 11, 6, 0.0F);
    setRotateAngle(this.Trunk1, 0.5235988F, 0.0F, 0.0F);
    (this.LeftTusk4 = new ModelRenderer(this, 79, 39)).setRotationPoint(0.0F, 4.5F, 0.0F);
    this.LeftTusk4.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.LeftTusk4, -0.34906584F, 0.08726646F, 0.017453292F);
    (this.Waist = new ModelRenderer(this, 22, 38)).setRotationPoint(0.0F, 5.3F, 12.0F);
    this.Waist.addBox(-8.0F, -9.0F, -10.5F, 16, 18, 16, 0.0F);
    setRotateAngle(this.Waist, -0.31415927F, 0.0F, 0.0F);
    (this.RightTusk3 = new ModelRenderer(this, 79, 39)).setRotationPoint(0.0F, 5.0F, 0.0F);
    this.RightTusk3.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.RightTusk3, -0.43633232F, -0.08726646F, -0.017453292F);
    (this.FurFrontLeftChest = new ModelRenderer(this, 86, 73)).setRotationPoint(-6.6F, 8.7F, -9.0F);
    this.FurFrontLeftChest.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
    setRotateAngle(this.FurFrontLeftChest, 0.0F, -0.08726646F, 0.0F);
    (this.Trunk7 = new ModelRenderer(this, 107, 30)).setRotationPoint(0.0F, 0.0F, -4.75F);
    this.Trunk7.addBox(-1.5F, -1.5F, -5.0F, 3, 3, 5, 0.0F);
    setRotateAngle(this.Trunk7, 0.17453292F, 0.0F, 0.0F);
    (this.RightTusk2 = new ModelRenderer(this, 79, 39)).setRotationPoint(0.0F, 7.0F, 0.0F);
    this.RightTusk2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.RightTusk2, -0.2617994F, 0.0F, -0.017453292F);
    (this.LeftTusk1 = new ModelRenderer(this, 79, 39)).setRotationPoint(3.5F, 2.0F, -5.0F);
    this.LeftTusk1.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
    setRotateAngle(this.LeftTusk1, -0.17453292F, 0.0F, -0.17453292F);
    (this.FurFrontMiddleNeck = new ModelRenderer(this, 91, 78)).setRotationPoint(0.0F, 0.0F, 0.0F);
    this.FurFrontMiddleNeck.addBox(0.0F, 0.0F, -6.0F, 0, 9, 12, 0.0F);
    setRotateAngle(this.FurFrontMiddleNeck, 3.1415927F, 1.5707964F, 3.1415927F);
    (this.FurFrontRightNeck = new ModelRenderer(this, 86, 73)).setRotationPoint(6.0F, 6.3F, 4.0F);
    this.FurFrontRightNeck.addBox(0.0F, 0.0F, -8.0F, 0, 9, 17, 0.0F);
    this.RightBackCalf.addChild(this.RightBackFoot);
    this.RightFrontThigh2.addChild(this.RightFrontCalf);
    this.Waist.addChild(this.Chest);
    this.LowerHead.addChild(this.Mouth);
    this.Trunk5.addChild(this.Trunk6);
    this.Chest.addChild(this.FurFrontRightChest);
    this.LeftTusk1.addChild(this.LeftTusk2);
    this.LeftTusk4.addChild(this.LeftTusk5);
    this.LowerHead.addChild(this.RightTusk1);
    this.LeftFrontCalf.addChild(this.LeftFrontFoot);
    this.LeftFrontThigh2.addChild(this.LeftFrontCalf);
    this.LowerHead.addChild(this.RightEar);
    this.Trunk3.addChild(this.Trunk4);
    this.Chest.addChild(this.Neck);
    this.LeftTusk2.addChild(this.LeftTusk3);
    this.LowerHead.addChild(this.UpperHead);
    this.RightBackThigh.addChild(this.RightBackCalf);
    this.RightTusk3.addChild(this.RightTusk4);
    this.Neck.addChild(this.FurFrontLeftNeck);
    this.FurJointChest.addChild(this.FurFrontMiddleChest);
    this.Chest.addChild(this.FurJointChest);
    this.LeftFrontThigh1.addChild(this.LeftFrontThigh2);
    this.Waist.addChild(this.Tail);
    this.RightFrontCalf.addChild(this.RightFrontFoot);
    this.Waist.addChild(this.FurBackLeftWaist);
    this.Chest.addChild(this.LeftFrontThigh1);
    this.RightTusk4.addChild(this.RightTusk5);
    this.Trunk2.addChild(this.Trunk3);
    this.RightFrontThigh1.addChild(this.RightFrontThigh2);
    this.Neck.addChild(this.FurJointNeck);
    this.LeftBackThigh.addChild(this.LeftBackCalf);
    this.Trunk4.addChild(this.Trunk5);
    this.Waist.addChild(this.FurBackRightWaist);
    this.LeftBackCalf.addChild(this.LeftBackFoot);
    this.Trunk1.addChild(this.Trunk2);
    this.LowerHead.addChild(this.LeftEar);
    this.Neck.addChild(this.LowerHead);
    this.Chest.addChild(this.RightFrontThigh1);
    this.LowerHead.addChild(this.Trunk1);
    this.LeftTusk3.addChild(this.LeftTusk4);
    this.RightTusk2.addChild(this.RightTusk3);
    this.Chest.addChild(this.FurFrontLeftChest);
    this.Trunk6.addChild(this.Trunk7);
    this.RightTusk1.addChild(this.RightTusk2);
    this.LowerHead.addChild(this.LeftTusk1);
    this.FurJointNeck.addChild(this.FurFrontMiddleNeck);
    this.Neck.addChild(this.FurFrontRightNeck);
    this.trunkParts = new ModelRenderer[] { this.Trunk7, this.Trunk6, this.Trunk5, this.Trunk4, this.Trunk3, this.Trunk2, this.Trunk1 };
    this.lefttuskparts = new ModelRenderer[] { this.LeftTusk5, this.LeftTusk4, this.LeftTusk3, this.LeftTusk2, this.LeftTusk1 };
    this.righttuskparts = new ModelRenderer[] { this.RightTusk5, this.RightTusk4, this.RightTusk3, this.RightTusk2, this.RightTusk1 };
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.LeftBackThigh.render(f5);
    this.RightBackThigh.render(f5);
    this.Waist.render(f5);
  }
  
  private void setRotateAngle(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    this.UpperHead.rotateAngleY = headYaw / 85.943665F;
    this.UpperHead.rotateAngleX = headPitch / 114.59155F;
    this.LowerHead.rotateAngleY = headYaw / 85.943665F;
    this.LowerHead.rotateAngleX = headPitch / 114.59155F;
    this.LeftBackThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
    this.RightBackThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.3F * limbSwingAmount;
    this.LeftFrontThigh1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
    this.LeftFrontThigh2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
    this.RightFrontThigh1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
    this.RightFrontThigh2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
  }
  
  public ModelRenderer getHandRenderer() {
    return null;
  }
}
