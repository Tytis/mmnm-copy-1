package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class dragon extends ModelZoanMorph {
  private final ModelRenderer neck;
  
  private final ModelRenderer neck_r1;
  
  private final ModelRenderer neck2;
  
  private final ModelRenderer neck2_r1;
  
  private final ModelRenderer neck3;
  
  private final ModelRenderer neck3_r1;
  
  private final ModelRenderer neck4;
  
  private final ModelRenderer neck4_r1;
  
  private final ModelRenderer neck5;
  
  private final ModelRenderer neck5_r1;
  
  private final ModelRenderer head;
  
  private final ModelRenderer head_r1;
  
  private final ModelRenderer head_r2;
  
  private final ModelRenderer head_r3;
  
  private final ModelRenderer head_r4;
  
  private final ModelRenderer head_r5;
  
  private final ModelRenderer right_horn;
  
  private final ModelRenderer right_horn2;
  
  private final ModelRenderer right_horn3;
  
  private final ModelRenderer right_horn4;
  
  private final ModelRenderer right_horn5;
  
  private final ModelRenderer right_horn6;
  
  private final ModelRenderer right_horn7;
  
  private final ModelRenderer right_horn8;
  
  private final ModelRenderer left_horn;
  
  private final ModelRenderer left_horn2;
  
  private final ModelRenderer left_horn3;
  
  private final ModelRenderer left_horn4;
  
  private final ModelRenderer left_horn5;
  
  private final ModelRenderer left_horn6;
  
  private final ModelRenderer left_horn7;
  
  private final ModelRenderer left_horn8;
  
  private final ModelRenderer upper_jaw;
  
  private final ModelRenderer upper_jaw_r1;
  
  private final ModelRenderer upper_jaw_r2;
  
  private final ModelRenderer upper_jaw_r3;
  
  private final ModelRenderer upper_jaw_r4;
  
  private final ModelRenderer lower_jaw;
  
  private final ModelRenderer body;
  
  private final ModelRenderer body_r1;
  
  private final ModelRenderer fwd_right_leg;
  
  private final ModelRenderer fwd_right_knee;
  
  private final ModelRenderer fwd_right_wrist;
  
  private final ModelRenderer fwd_right_hand;
  
  private final ModelRenderer fwd_right_claw;
  
  private final ModelRenderer fwd_right_claw_r1;
  
  private final ModelRenderer fwd_right_claw2;
  
  private final ModelRenderer fwd_right_claw2_r1;
  
  private final ModelRenderer fwd_right_claw3;
  
  private final ModelRenderer fwd_right_claw3_r1;
  
  private final ModelRenderer fwd_right_claw4;
  
  private final ModelRenderer fwd_right_claw4_r1;
  
  private final ModelRenderer fwd_left_leg;
  
  private final ModelRenderer fwd_left_knee;
  
  private final ModelRenderer fwd_left_wrist;
  
  private final ModelRenderer fwd_left_hand;
  
  private final ModelRenderer fwd_left_claw;
  
  private final ModelRenderer fwd_left_claw_r1;
  
  private final ModelRenderer fwd_left_claw2;
  
  private final ModelRenderer fwd_left_claw2_r1;
  
  private final ModelRenderer fwd_left_claw3;
  
  private final ModelRenderer fwd_left_claw3_r1;
  
  private final ModelRenderer fwd_left_claw4;
  
  private final ModelRenderer fwd_left_claw4_r1;
  
  private final ModelRenderer body2;
  
  private final ModelRenderer body2_r1;
  
  private final ModelRenderer body3;
  
  private final ModelRenderer body3_r1;
  
  private final ModelRenderer tail;
  
  private final ModelRenderer tail_r1;
  
  private final ModelRenderer tail2;
  
  private final ModelRenderer tail2_r1;
  
  private final ModelRenderer tail3;
  
  private final ModelRenderer tail3_r1;
  
  private final ModelRenderer tail4;
  
  private final ModelRenderer tail4_r1;
  
  private final ModelRenderer rear_right_leg;
  
  private final ModelRenderer rear_right_knee;
  
  private final ModelRenderer rear_right_wrist;
  
  private final ModelRenderer rear_right_hand;
  
  private final ModelRenderer rear_right_claw;
  
  private final ModelRenderer rear_right_claw_r1;
  
  private final ModelRenderer rear_right_claw2;
  
  private final ModelRenderer rear_right_claw2_r1;
  
  private final ModelRenderer rear_right_claw3;
  
  private final ModelRenderer rear_right_claw3_r1;
  
  private final ModelRenderer rear_right_claw4;
  
  private final ModelRenderer rear_right_claw4_r1;
  
  private final ModelRenderer rear_left_leg;
  
  private final ModelRenderer rear_left_knee;
  
  private final ModelRenderer rear_left_wrist;
  
  private final ModelRenderer rear_left_hand;
  
  private final ModelRenderer rear_left_claw;
  
  private final ModelRenderer rear_left_claw_r1;
  
  private final ModelRenderer rear_left_claw2;
  
  private final ModelRenderer rear_left_claw2_r1;
  
  private final ModelRenderer rear_left_claw3;
  
  private final ModelRenderer rear_left_claw3_r1;
  
  private final ModelRenderer rear_left_claw4;
  
  private final ModelRenderer rear_left_claw4_r1;
  
  private final ModelRenderer tail5;
  
  private final ModelRenderer tail5_r1;
  
  private final ModelRenderer tail6;
  
  private final ModelRenderer tail6_r1;
  
  private final ModelRenderer tail7;
  
  private final ModelRenderer tail7_r1;
  
  private final ModelRenderer tail8;
  
  private final ModelRenderer tail8_r1;
  
  private final ModelRenderer tail9;
  
  private final ModelRenderer tail9_r1;
  
  private final ModelRenderer tail10;
  
  private final ModelRenderer tail10_r1;
  
  private final ModelRenderer tail11;
  
  private final ModelRenderer tail11_r1;
  
  private final ModelRenderer tail12;
  
  private final ModelRenderer tail12_r1;
  
  private final ModelRenderer tail13;
  
  private final ModelRenderer tail13_r1;
  
  private final ModelRenderer tail14;
  
  private final ModelRenderer tail14_r1;
  
  private final ModelRenderer tail15;
  
  private final ModelRenderer tail15_r1;
  
  private final ModelRenderer tail16;
  
  private final ModelRenderer tail16_r1;
  
  public dragon() {
    this.textureWidth = 256;
    this.textureHeight = 256;
    this.neck = new ModelRenderer(this);
    this.neck.setRotationPoint(0.0F, 14.5F, -8.0F);
    setRotationAngle(this.neck, -0.1309F, 0.0F, 0.0F);
    this.neck.setTextureOffset(72, 28).addBox(-9.0F, -8.5F, -10.0F, 18, 17, 11, 0.0F);
    this.neck_r1 = new ModelRenderer(this);
    this.neck_r1.setRotationPoint(-5.0F, -10.5F, -50.0F);
    this.neck.addChild(this.neck_r1);
    setRotationAngle(this.neck_r1, 0.0F, -1.5708F, 0.0F);
    this.neck_r1.setTextureOffset(189, 66).addBox(40.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.neck2 = new ModelRenderer(this);
    this.neck2.setRotationPoint(0.0F, -0.5F, -10.0F);
    this.neck.addChild(this.neck2);
    setRotationAngle(this.neck2, 0.0873F, 0.0F, 0.0F);
    this.neck2.setTextureOffset(111, 111).addBox(-8.0F, -8.0F, -10.0F, 16, 16, 11, 0.0F);
    this.neck2_r1 = new ModelRenderer(this);
    this.neck2_r1.setRotationPoint(-5.0F, -10.0F, -40.0F);
    this.neck2.addChild(this.neck2_r1);
    setRotationAngle(this.neck2_r1, 0.0F, -1.5708F, 0.0F);
    this.neck2_r1.setTextureOffset(200, 77).addBox(30.0F, -3.0F, -5.005F, 10, 5, 0, 0.0F);
    this.neck3 = new ModelRenderer(this);
    this.neck3.setRotationPoint(0.0F, -0.5F, -10.0F);
    this.neck2.addChild(this.neck3);
    setRotationAngle(this.neck3, -0.0873F, 0.0F, 0.0F);
    this.neck3.setTextureOffset(130, 0).addBox(-7.0F, -7.5F, -10.0F, 14, 15, 11, 0.0F);
    this.neck3_r1 = new ModelRenderer(this);
    this.neck3_r1.setRotationPoint(-5.0F, -9.5F, -30.0F);
    this.neck3.addChild(this.neck3_r1);
    setRotationAngle(this.neck3_r1, 0.0F, -1.5708F, 0.0F);
    this.neck3_r1.setTextureOffset(200, 82).addBox(20.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.neck4 = new ModelRenderer(this);
    this.neck4.setRotationPoint(0.0F, -0.5F, -10.0F);
    this.neck3.addChild(this.neck4);
    setRotationAngle(this.neck4, -0.1745F, 0.0F, 0.0F);
    this.neck4.setTextureOffset(154, 93).addBox(-6.0F, -7.0F, -10.0F, 12, 14, 11, 0.0F);
    this.neck4_r1 = new ModelRenderer(this);
    this.neck4_r1.setRotationPoint(-5.0F, -9.0F, -20.0F);
    this.neck4.addChild(this.neck4_r1);
    setRotationAngle(this.neck4_r1, 0.0F, -1.5708F, 0.0F);
    this.neck4_r1.setTextureOffset(192, 216).addBox(10.0F, -3.0F, -5.005F, 10, 5, 0, 0.0F);
    this.neck5 = new ModelRenderer(this);
    this.neck5.setRotationPoint(0.0F, -0.5F, -10.0F);
    this.neck4.addChild(this.neck5);
    setRotationAngle(this.neck5, 0.1309F, 0.0F, 0.0F);
    this.neck5.setTextureOffset(75, 164).addBox(-5.0F, -6.5F, -11.0F, 10, 13, 12, 0.0F);
    this.neck5_r1 = new ModelRenderer(this);
    this.neck5_r1.setRotationPoint(-5.0F, -8.5F, -10.0F);
    this.neck5.addChild(this.neck5_r1);
    setRotationAngle(this.neck5_r1, 0.0F, -1.5708F, 0.0F);
    this.neck5_r1.setTextureOffset(216, 40).addBox(0.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.head = new ModelRenderer(this);
    this.head.setRotationPoint(0.0F, -2.0F, -10.0F);
    this.neck5.addChild(this.head);
    setRotationAngle(this.head, 0.1745F, 0.0F, 0.0F);
    this.head.setTextureOffset(0, 72).addBox(-8.0F, -8.5F, -18.0F, 16, 17, 18, 0.0F);
    this.head.setTextureOffset(112, 74).addBox(-6.5F, 8.5F, -17.0F, 13, 3, 16, 0.0F);
    this.head_r1 = new ModelRenderer(this);
    this.head_r1.setRotationPoint(8.0F, 0.0F, -11.5F);
    this.head.addChild(this.head_r1);
    setRotationAngle(this.head_r1, 0.0F, -1.0472F, 0.0F);
    this.head_r1.setTextureOffset(200, 91).addBox(0.0F, -8.5F, 0.0F, 16, 17, 0, 0.0F);
    this.head_r2 = new ModelRenderer(this);
    this.head_r2.setRotationPoint(-8.0F, 0.0F, -11.5F);
    this.head.addChild(this.head_r2);
    setRotationAngle(this.head_r2, 0.0F, 1.0472F, 0.0F);
    this.head_r2.setTextureOffset(203, 176).addBox(-16.0F, -8.5F, 0.0F, 16, 17, 0, 0.0F);
    this.head_r3 = new ModelRenderer(this);
    this.head_r3.setRotationPoint(-5.0F, -6.5F, 0.0F);
    this.head.addChild(this.head_r3);
    setRotationAngle(this.head_r3, 0.0F, -1.5708F, 0.0F);
    this.head_r3.setTextureOffset(158, 44).addBox(-18.0F, -7.0F, -5.0F, 18, 5, 0, 0.0F);
    this.head_r4 = new ModelRenderer(this);
    this.head_r4.setRotationPoint(0.0F, -8.5F, -9.5F);
    this.head.addChild(this.head_r4);
    setRotationAngle(this.head_r4, -1.2217F, 0.0F, 0.0F);
    this.head_r4.setTextureOffset(191, 158).addBox(-9.0F, -18.0F, 0.0F, 18, 18, 0, 0.0F);
    this.head_r5 = new ModelRenderer(this);
    this.head_r5.setRotationPoint(0.0F, 8.5F, -11.5F);
    this.head.addChild(this.head_r5);
    setRotationAngle(this.head_r5, 1.2217F, 0.0F, 0.0F);
    this.head_r5.setTextureOffset(122, 93).addBox(-8.0F, 0.0F, 0.0F, 16, 18, 0, 0.0F);
    this.right_horn = new ModelRenderer(this);
    this.right_horn.setRotationPoint(-5.5F, -8.5F, -10.0F);
    this.head.addChild(this.right_horn);
    setRotationAngle(this.right_horn, -0.9163F, 0.0F, 0.0F);
    this.right_horn.setTextureOffset(0, 155).addBox(-2.0F, -5.0F, -2.0F, 4, 8, 4, 0.0F);
    this.right_horn2 = new ModelRenderer(this);
    this.right_horn2.setRotationPoint(0.0F, -5.0F, 0.0F);
    this.right_horn.addChild(this.right_horn2);
    setRotationAngle(this.right_horn2, 0.0F, 0.0F, 0.0873F);
    this.right_horn2.setTextureOffset(0, 179).addBox(-1.5F, -12.0F, -1.5F, 3, 12, 3, 0.0F);
    this.right_horn3 = new ModelRenderer(this);
    this.right_horn3.setRotationPoint(0.0F, -12.0F, 0.0F);
    this.right_horn2.addChild(this.right_horn3);
    setRotationAngle(this.right_horn3, -0.2182F, 0.0F, 0.0F);
    this.right_horn3.setTextureOffset(101, 118).addBox(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
    this.right_horn4 = new ModelRenderer(this);
    this.right_horn4.setRotationPoint(-0.5F, -5.5F, 0.0F);
    this.right_horn2.addChild(this.right_horn4);
    setRotationAngle(this.right_horn4, 0.0F, 0.0F, -0.5236F);
    this.right_horn4.setTextureOffset(93, 118).addBox(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
    this.right_horn5 = new ModelRenderer(this);
    this.right_horn5.setRotationPoint(0.0F, -8.0F, 0.0F);
    this.right_horn4.addChild(this.right_horn5);
    setRotationAngle(this.right_horn5, 0.0F, 0.0F, 0.2182F);
    this.right_horn5.setTextureOffset(12, 5).addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.125F);
    this.right_horn6 = new ModelRenderer(this);
    this.right_horn6.setRotationPoint(-9.0F, -6.0F, -9.5F);
    this.head.addChild(this.right_horn6);
    setRotationAngle(this.right_horn6, -0.7418F, 0.0F, -1.4835F);
    this.right_horn6.setTextureOffset(0, 134).addBox(-2.0F, -5.0F, -2.0F, 4, 8, 4, 0.0F);
    this.right_horn7 = new ModelRenderer(this);
    this.right_horn7.setRotationPoint(0.0F, -5.0F, 0.0F);
    this.right_horn6.addChild(this.right_horn7);
    setRotationAngle(this.right_horn7, 0.0F, 0.0F, 0.3491F);
    this.right_horn7.setTextureOffset(56, 34).addBox(-1.5F, -12.0F, -1.5F, 3, 13, 3, 0.0F);
    this.right_horn8 = new ModelRenderer(this);
    this.right_horn8.setRotationPoint(0.0F, -12.0F, 0.0F);
    this.right_horn7.addChild(this.right_horn8);
    setRotationAngle(this.right_horn8, -0.2182F, 0.0F, 0.6545F);
    this.right_horn8.setTextureOffset(68, 90).addBox(-1.0F, -8.0F, -1.0F, 2, 9, 2, 0.0F);
    this.left_horn = new ModelRenderer(this);
    this.left_horn.setRotationPoint(5.5F, -8.5F, -10.0F);
    this.head.addChild(this.left_horn);
    setRotationAngle(this.left_horn, -0.9163F, 0.0F, 0.0F);
    this.left_horn.setTextureOffset(35, 134).addBox(-2.0F, -5.0F, -2.0F, 4, 8, 4, 0.0F);
    this.left_horn2 = new ModelRenderer(this);
    this.left_horn2.setRotationPoint(0.0F, -5.0F, 0.0F);
    this.left_horn.addChild(this.left_horn2);
    setRotationAngle(this.left_horn2, 0.0F, 0.0F, -0.0873F);
    this.left_horn2.setTextureOffset(159, 159).addBox(-1.5F, -12.0F, -1.5F, 3, 12, 3, 0.0F);
    this.left_horn3 = new ModelRenderer(this);
    this.left_horn3.setRotationPoint(0.0F, -12.0F, 0.0F);
    this.left_horn2.addChild(this.left_horn3);
    setRotationAngle(this.left_horn3, -0.2182F, 0.0F, 0.0F);
    this.left_horn3.setTextureOffset(54, 117).addBox(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
    this.left_horn4 = new ModelRenderer(this);
    this.left_horn4.setRotationPoint(0.5F, -5.5F, 0.0F);
    this.left_horn2.addChild(this.left_horn4);
    setRotationAngle(this.left_horn4, 0.0F, 0.0F, 0.5236F);
    this.left_horn4.setTextureOffset(0, 107).addBox(-1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F);
    this.left_horn5 = new ModelRenderer(this);
    this.left_horn5.setRotationPoint(0.0F, -8.0F, 0.0F);
    this.left_horn4.addChild(this.left_horn5);
    setRotationAngle(this.left_horn5, 0.0F, 0.0F, -0.2182F);
    this.left_horn5.setTextureOffset(12, 0).addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.125F);
    this.left_horn6 = new ModelRenderer(this);
    this.left_horn6.setRotationPoint(9.0F, -6.0F, -9.5F);
    this.head.addChild(this.left_horn6);
    setRotationAngle(this.left_horn6, -0.7418F, 0.0F, 1.4835F);
    this.left_horn6.setTextureOffset(0, 34).addBox(-2.0F, -5.0F, -2.0F, 4, 8, 4, 0.0F);
    this.left_horn7 = new ModelRenderer(this);
    this.left_horn7.setRotationPoint(0.0F, -5.0F, 0.0F);
    this.left_horn6.addChild(this.left_horn7);
    setRotationAngle(this.left_horn7, 0.0F, 0.0F, -0.3491F);
    this.left_horn7.setTextureOffset(0, 0).addBox(-1.5F, -12.0F, -1.5F, 3, 13, 3, 0.0F);
    this.left_horn8 = new ModelRenderer(this);
    this.left_horn8.setRotationPoint(0.0F, -12.0F, 0.0F);
    this.left_horn7.addChild(this.left_horn8);
    setRotationAngle(this.left_horn8, -0.2182F, 0.0F, -0.6545F);
    this.left_horn8.setTextureOffset(72, 28).addBox(-1.0F, -8.0F, -1.0F, 2, 9, 2, 0.0F);
    this.upper_jaw = new ModelRenderer(this);
    this.upper_jaw.setRotationPoint(0.0F, 5.5F, -18.0F);
    this.head.addChild(this.upper_jaw);
    setRotationAngle(this.upper_jaw, 0.1745F, 0.0F, 0.0F);
    this.upper_jaw.setTextureOffset(0, 134).addBox(-4.5F, -4.0F, -16.0F, 9, 4, 17, 0.0F);
    this.upper_jaw.setTextureOffset(170, 73).addBox(-3.5F, 0.0F, -15.0F, 7, 2, 16, 0.0F);
    this.upper_jaw_r1 = new ModelRenderer(this);
    this.upper_jaw_r1.setRotationPoint(4.5F, -2.5F, -7.5F);
    this.upper_jaw.addChild(this.upper_jaw_r1);
    setRotationAngle(this.upper_jaw_r1, -1.5708F, 0.0F, 0.0F);
    this.upper_jaw_r1.setTextureOffset(161, 191).addBox(0.0F, -7.5F, 0.0F, 20, 16, 0, 0.0F);
    this.upper_jaw_r1.setTextureOffset(191, 142).addBox(-29.0F, -7.5F, 0.0F, 20, 16, 0, 0.0F);
    this.upper_jaw_r2 = new ModelRenderer(this);
    this.upper_jaw_r2.setRotationPoint(0.0F, -6.0F, -13.5F);
    this.upper_jaw.addChild(this.upper_jaw_r2);
    setRotationAngle(this.upper_jaw_r2, -0.0873F, 0.0F, 0.0F);
    this.upper_jaw_r2.setTextureOffset(128, 138).addBox(-4.0F, 0.0F, 0.0F, 8, 3, 6, 0.0F);
    this.upper_jaw_r3 = new ModelRenderer(this);
    this.upper_jaw_r3.setRotationPoint(0.0F, -6.0F, -13.5F);
    this.upper_jaw.addChild(this.upper_jaw_r3);
    setRotationAngle(this.upper_jaw_r3, 0.4363F, 0.0F, 0.0F);
    this.upper_jaw_r3.setTextureOffset(56, 0).addBox(-4.0F, 0.0F, -4.0F, 8, 3, 4, 0.0F);
    this.upper_jaw_r4 = new ModelRenderer(this);
    this.upper_jaw_r4.setRotationPoint(0.0F, -5.2459F, -8.7591F);
    this.upper_jaw.addChild(this.upper_jaw_r4);
    setRotationAngle(this.upper_jaw_r4, 0.1745F, 0.0F, 0.0F);
    this.upper_jaw_r4.setTextureOffset(200, 63).addBox(-4.0F, -0.0304F, 0.6527F, 8, 4, 10, 0.0F);
    this.lower_jaw = new ModelRenderer(this);
    this.lower_jaw.setRotationPoint(0.0F, 5.5F, -18.0F);
    this.head.addChild(this.lower_jaw);
    setRotationAngle(this.lower_jaw, 0.6109F, 0.0F, 0.0F);
    this.lower_jaw.setTextureOffset(139, 139).addBox(-4.5F, 0.0F, -16.0F, 9, 3, 17, 0.0F);
    this.lower_jaw.setTextureOffset(0, 155).addBox(-3.5F, -2.0F, -15.0F, 7, 8, 16, 0.0F);
    this.body = new ModelRenderer(this);
    this.body.setRotationPoint(0.0F, 15.0F, -8.0F);
    setRotationAngle(this.body, 0.0873F, 0.0F, 0.0F);
    this.body.setTextureOffset(56, 56).addBox(-10.0F, -9.0F, 0.0F, 20, 18, 16, 0.125F);
    this.body.setTextureOffset(123, 159).addBox(-5.0F, -11.0F, 0.0F, 10, 2, 16, 0.0F);
    this.body_r1 = new ModelRenderer(this);
    this.body_r1.setRotationPoint(-5.0F, -11.0F, -50.0F);
    this.body.addChild(this.body_r1);
    setRotationAngle(this.body_r1, 0.0F, -1.5708F, 0.0F);
    this.body_r1.setTextureOffset(154, 82).addBox(50.0F, -4.0F, -5.0F, 16, 4, 0, 0.0F);
    this.fwd_right_leg = new ModelRenderer(this);
    this.fwd_right_leg.setRotationPoint(-7.0F, 2.0F, 6.5F);
    this.body.addChild(this.fwd_right_leg);
    setRotationAngle(this.fwd_right_leg, 0.0F, 0.0F, 0.9163F);
    this.fwd_right_leg.setTextureOffset(168, 14).addBox(-4.0F, -4.0F, -6.0F, 8, 14, 12, 0.0F);
    this.fwd_right_knee = new ModelRenderer(this);
    this.fwd_right_knee.setRotationPoint(0.0F, 10.0F, 1.0F);
    this.fwd_right_leg.addChild(this.fwd_right_knee);
    setRotationAngle(this.fwd_right_knee, -0.3491F, 0.0F, 0.0F);
    this.fwd_right_knee.setTextureOffset(127, 200).addBox(-3.0F, -2.0F, -4.0F, 6, 16, 8, 0.0F);
    this.fwd_right_wrist = new ModelRenderer(this);
    this.fwd_right_wrist.setRotationPoint(0.0F, 14.0F, 1.0F);
    this.fwd_right_knee.addChild(this.fwd_right_wrist);
    setRotationAngle(this.fwd_right_wrist, -1.0472F, 0.0F, 0.0F);
    this.fwd_right_wrist.setTextureOffset(55, 211).addBox(-2.0F, -2.0F, -3.5F, 4, 16, 6, 0.0F);
    this.fwd_right_hand = new ModelRenderer(this);
    this.fwd_right_hand.setRotationPoint(0.0F, 14.0F, -0.5F);
    this.fwd_right_wrist.addChild(this.fwd_right_hand);
    setRotationAngle(this.fwd_right_hand, 0.0F, 0.0F, 0.6109F);
    this.fwd_right_hand.setTextureOffset(213, 193).addBox(-2.0F, 0.0F, -4.0F, 4, 6, 8, 0.0F);
    this.fwd_right_claw = new ModelRenderer(this);
    this.fwd_right_claw.setRotationPoint(0.0F, 4.0F, 3.0F);
    this.fwd_right_hand.addChild(this.fwd_right_claw);
    setRotationAngle(this.fwd_right_claw, 0.3491F, 0.0F, -0.4363F);
    this.fwd_right_claw.setTextureOffset(189, 91).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.fwd_right_claw_r1 = new ModelRenderer(this);
    this.fwd_right_claw_r1.setRotationPoint(-1.0F, 6.0F, 0.0F);
    this.fwd_right_claw.addChild(this.fwd_right_claw_r1);
    setRotationAngle(this.fwd_right_claw_r1, 0.0F, 0.0F, 0.6981F);
    this.fwd_right_claw_r1.setTextureOffset(88, 193).addBox(0.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.fwd_right_claw2 = new ModelRenderer(this);
    this.fwd_right_claw2.setRotationPoint(0.0F, 4.0F, 1.0F);
    this.fwd_right_hand.addChild(this.fwd_right_claw2);
    setRotationAngle(this.fwd_right_claw2, 0.0873F, 0.0F, -0.4363F);
    this.fwd_right_claw2.setTextureOffset(189, 0).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.fwd_right_claw2_r1 = new ModelRenderer(this);
    this.fwd_right_claw2_r1.setRotationPoint(-1.0F, 6.0F, 0.0F);
    this.fwd_right_claw2.addChild(this.fwd_right_claw2_r1);
    setRotationAngle(this.fwd_right_claw2_r1, 0.0F, 0.0F, 0.6981F);
    this.fwd_right_claw2_r1.setTextureOffset(88, 189).addBox(0.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.fwd_right_claw3 = new ModelRenderer(this);
    this.fwd_right_claw3.setRotationPoint(0.0F, 4.0F, -1.0F);
    this.fwd_right_hand.addChild(this.fwd_right_claw3);
    setRotationAngle(this.fwd_right_claw3, -0.0873F, 0.0F, -0.4363F);
    this.fwd_right_claw3.setTextureOffset(26, 184).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.fwd_right_claw3_r1 = new ModelRenderer(this);
    this.fwd_right_claw3_r1.setRotationPoint(-1.0F, 6.0F, 0.0F);
    this.fwd_right_claw3.addChild(this.fwd_right_claw3_r1);
    setRotationAngle(this.fwd_right_claw3_r1, 0.0F, 0.0F, 0.6981F);
    this.fwd_right_claw3_r1.setTextureOffset(182, 40).addBox(0.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.fwd_right_claw4 = new ModelRenderer(this);
    this.fwd_right_claw4.setRotationPoint(0.0F, 4.0F, -3.0F);
    this.fwd_right_hand.addChild(this.fwd_right_claw4);
    setRotationAngle(this.fwd_right_claw4, -0.3491F, 0.0F, -0.4363F);
    this.fwd_right_claw4.setTextureOffset(182, 142).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.fwd_right_claw4_r1 = new ModelRenderer(this);
    this.fwd_right_claw4_r1.setRotationPoint(-1.0F, 6.0F, 0.0F);
    this.fwd_right_claw4.addChild(this.fwd_right_claw4_r1);
    setRotationAngle(this.fwd_right_claw4_r1, 0.0F, 0.0F, 0.6981F);
    this.fwd_right_claw4_r1.setTextureOffset(180, 10).addBox(0.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.fwd_left_leg = new ModelRenderer(this);
    this.fwd_left_leg.setRotationPoint(7.0F, 2.0F, 6.5F);
    this.body.addChild(this.fwd_left_leg);
    setRotationAngle(this.fwd_left_leg, 0.0F, 0.0F, -0.9163F);
    this.fwd_left_leg.setTextureOffset(163, 165).addBox(-4.0F, -4.0F, -6.0F, 8, 14, 12, 0.0F);
    this.fwd_left_knee = new ModelRenderer(this);
    this.fwd_left_knee.setRotationPoint(0.0F, 10.0F, 1.0F);
    this.fwd_left_leg.addChild(this.fwd_left_knee);
    setRotationAngle(this.fwd_left_knee, -0.3491F, 0.0F, 0.0F);
    this.fwd_left_knee.setTextureOffset(99, 192).addBox(-3.0F, -2.0F, -4.0F, 6, 16, 8, 0.0F);
    this.fwd_left_wrist = new ModelRenderer(this);
    this.fwd_left_wrist.setRotationPoint(0.0F, 14.0F, 1.0F);
    this.fwd_left_knee.addChild(this.fwd_left_wrist);
    setRotationAngle(this.fwd_left_wrist, -1.0472F, 0.0F, 0.0F);
    this.fwd_left_wrist.setTextureOffset(0, 210).addBox(-2.0F, -2.0F, -3.5F, 4, 16, 6, 0.0F);
    this.fwd_left_hand = new ModelRenderer(this);
    this.fwd_left_hand.setRotationPoint(0.0F, 14.0F, -0.5F);
    this.fwd_left_wrist.addChild(this.fwd_left_hand);
    setRotationAngle(this.fwd_left_hand, 0.0F, 0.0F, -0.6109F);
    this.fwd_left_hand.setTextureOffset(75, 211).addBox(-2.0F, 0.0F, -4.0F, 4, 6, 8, 0.0F);
    this.fwd_left_claw = new ModelRenderer(this);
    this.fwd_left_claw.setRotationPoint(0.0F, 4.0F, 3.0F);
    this.fwd_left_hand.addChild(this.fwd_left_claw);
    setRotationAngle(this.fwd_left_claw, 0.3491F, 0.0F, 0.4363F);
    this.fwd_left_claw.setTextureOffset(150, 177).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.fwd_left_claw_r1 = new ModelRenderer(this);
    this.fwd_left_claw_r1.setRotationPoint(1.0F, 6.0F, 0.0F);
    this.fwd_left_claw.addChild(this.fwd_left_claw_r1);
    setRotationAngle(this.fwd_left_claw_r1, 0.0F, 0.0F, -0.6981F);
    this.fwd_left_claw_r1.setTextureOffset(60, 175).addBox(-4.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.fwd_left_claw2 = new ModelRenderer(this);
    this.fwd_left_claw2.setRotationPoint(0.0F, 4.0F, 1.0F);
    this.fwd_left_hand.addChild(this.fwd_left_claw2);
    setRotationAngle(this.fwd_left_claw2, 0.0873F, 0.0F, 0.4363F);
    this.fwd_left_claw2.setTextureOffset(119, 177).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.fwd_left_claw2_r1 = new ModelRenderer(this);
    this.fwd_left_claw2_r1.setRotationPoint(1.0F, 6.0F, 0.0F);
    this.fwd_left_claw2.addChild(this.fwd_left_claw2_r1);
    setRotationAngle(this.fwd_left_claw2_r1, 0.0F, 0.0F, -0.6981F);
    this.fwd_left_claw2_r1.setTextureOffset(174, 150).addBox(-4.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.fwd_left_claw3 = new ModelRenderer(this);
    this.fwd_left_claw3.setRotationPoint(0.0F, 4.0F, -1.0F);
    this.fwd_left_hand.addChild(this.fwd_left_claw3);
    setRotationAngle(this.fwd_left_claw3, -0.0873F, 0.0F, 0.4363F);
    this.fwd_left_claw3.setTextureOffset(174, 142).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.fwd_left_claw3_r1 = new ModelRenderer(this);
    this.fwd_left_claw3_r1.setRotationPoint(1.0F, 6.0F, 0.0F);
    this.fwd_left_claw3.addChild(this.fwd_left_claw3_r1);
    setRotationAngle(this.fwd_left_claw3_r1, 0.0F, 0.0F, -0.6981F);
    this.fwd_left_claw3_r1.setTextureOffset(127, 168).addBox(-4.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.fwd_left_claw4 = new ModelRenderer(this);
    this.fwd_left_claw4.setRotationPoint(0.0F, 4.0F, -3.0F);
    this.fwd_left_hand.addChild(this.fwd_left_claw4);
    setRotationAngle(this.fwd_left_claw4, -0.3491F, 0.0F, 0.4363F);
    this.fwd_left_claw4.setTextureOffset(165, 128).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.fwd_left_claw4_r1 = new ModelRenderer(this);
    this.fwd_left_claw4_r1.setRotationPoint(1.0F, 6.0F, 0.0F);
    this.fwd_left_claw4.addChild(this.fwd_left_claw4_r1);
    setRotationAngle(this.fwd_left_claw4_r1, 0.0F, 0.0F, -0.6981F);
    this.fwd_left_claw4_r1.setTextureOffset(0, 167).addBox(-4.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.body2 = new ModelRenderer(this);
    this.body2.setRotationPoint(0.0F, 0.0F, 16.0F);
    this.body.addChild(this.body2);
    setRotationAngle(this.body2, -0.0436F, 0.0F, 0.0F);
    this.body2.setTextureOffset(0, 34).addBox(-10.0F, -9.0F, 0.0F, 20, 18, 16, 0.0F);
    this.body2.setTextureOffset(153, 55).addBox(-5.0F, -11.0F, 0.0F, 10, 2, 16, 0.0F);
    this.body2_r1 = new ModelRenderer(this);
    this.body2_r1.setRotationPoint(-5.0F, -11.0F, -66.0F);
    this.body2.addChild(this.body2_r1);
    setRotationAngle(this.body2_r1, 0.0F, -1.5708F, 0.0F);
    this.body2_r1.setTextureOffset(32, 68).addBox(66.0F, -4.0F, -5.0F, 16, 4, 0, 0.0F);
    this.body3 = new ModelRenderer(this);
    this.body3.setRotationPoint(0.0F, 0.0F, 16.0F);
    this.body2.addChild(this.body3);
    setRotationAngle(this.body3, -0.0873F, 0.0F, 0.0F);
    this.body3.setTextureOffset(0, 0).addBox(-10.0F, -9.0F, 0.0F, 20, 18, 16, -0.125F);
    this.body3.setTextureOffset(130, 26).addBox(-5.0F, -11.0F, 0.0F, 10, 2, 16, 0.0F);
    this.body3_r1 = new ModelRenderer(this);
    this.body3_r1.setRotationPoint(-5.0F, -11.0F, -82.0F);
    this.body3.addChild(this.body3_r1);
    setRotationAngle(this.body3_r1, 0.0F, -1.5708F, 0.0F);
    this.body3_r1.setTextureOffset(0, 68).addBox(82.0F, -4.0F, -5.0F, 16, 4, 0, 0.0F);
    this.tail = new ModelRenderer(this);
    this.tail.setRotationPoint(0.0F, -0.5F, 16.0F);
    this.body3.addChild(this.tail);
    setRotationAngle(this.tail, -0.0873F, 0.0F, 0.0F);
    this.tail.setTextureOffset(72, 0).addBox(-9.0F, -8.5F, -1.0F, 18, 17, 11, 0.0F);
    this.tail_r1 = new ModelRenderer(this);
    this.tail_r1.setRotationPoint(-5.0F, -10.5F, -98.0F);
    this.tail.addChild(this.tail_r1);
    setRotationAngle(this.tail_r1, 0.0F, -1.5708F, 0.0F);
    this.tail_r1.setTextureOffset(189, 61).addBox(98.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail2 = new ModelRenderer(this);
    this.tail2.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail.addChild(this.tail2);
    setRotationAngle(this.tail2, 0.0873F, 0.0F, 0.0F);
    this.tail2.setTextureOffset(68, 90).addBox(-8.0F, -8.5F, -1.0F, 16, 17, 11, 0.0F);
    this.tail2_r1 = new ModelRenderer(this);
    this.tail2_r1.setRotationPoint(-5.0F, -10.5F, -108.0F);
    this.tail2.addChild(this.tail2_r1);
    setRotationAngle(this.tail2_r1, 0.0F, -1.5708F, 0.0F);
    this.tail2_r1.setTextureOffset(12, 179).addBox(108.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail3 = new ModelRenderer(this);
    this.tail3.setRotationPoint(0.0F, -0.5F, 10.0F);
    this.tail2.addChild(this.tail3);
    setRotationAngle(this.tail3, 0.0873F, 0.0F, 0.0F);
    this.tail3.setTextureOffset(0, 107).addBox(-8.0F, -8.0F, -1.0F, 16, 16, 11, -0.125F);
    this.tail3_r1 = new ModelRenderer(this);
    this.tail3_r1.setRotationPoint(-5.0F, -10.0F, -118.0F);
    this.tail3.addChild(this.tail3_r1);
    setRotationAngle(this.tail3_r1, 0.0F, -1.5708F, 0.0F);
    this.tail3_r1.setTextureOffset(171, 159).addBox(118.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail4 = new ModelRenderer(this);
    this.tail4.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail3.addChild(this.tail4);
    setRotationAngle(this.tail4, 0.1745F, 0.0F, 0.0F);
    this.tail4.setTextureOffset(54, 118).addBox(-7.0F, -8.0F, -1.0F, 14, 16, 11, 0.0F);
    this.tail4_r1 = new ModelRenderer(this);
    this.tail4_r1.setRotationPoint(-5.0F, -10.0F, -128.0F);
    this.tail4.addChild(this.tail4_r1);
    setRotationAngle(this.tail4_r1, 0.0F, -1.5708F, 0.0F);
    this.tail4_r1.setTextureOffset(60, 170).addBox(128.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.rear_right_leg = new ModelRenderer(this);
    this.rear_right_leg.setRotationPoint(-5.5F, 3.0F, 4.0F);
    this.tail4.addChild(this.rear_right_leg);
    setRotationAngle(this.rear_right_leg, 0.3491F, 0.0F, 0.5672F);
    this.rear_right_leg.setTextureOffset(0, 184).addBox(-3.5F, -4.0F, -6.0F, 7, 14, 12, 0.0F);
    this.rear_right_knee = new ModelRenderer(this);
    this.rear_right_knee.setRotationPoint(0.0F, 10.0F, 1.5F);
    this.rear_right_leg.addChild(this.rear_right_knee);
    setRotationAngle(this.rear_right_knee, -0.2618F, 0.0F, 0.2618F);
    this.rear_right_knee.setTextureOffset(208, 19).addBox(-2.5F, -1.0F, -3.5F, 5, 14, 7, 0.0F);
    this.rear_right_wrist = new ModelRenderer(this);
    this.rear_right_wrist.setRotationPoint(0.0F, 13.0F, 0.5F);
    this.rear_right_knee.addChild(this.rear_right_wrist);
    setRotationAngle(this.rear_right_wrist, -1.0036F, 0.0F, 0.0F);
    this.rear_right_wrist.setTextureOffset(179, 216).addBox(-2.0F, -1.0F, -2.5F, 4, 12, 5, 0.0F);
    this.rear_right_hand = new ModelRenderer(this);
    this.rear_right_hand.setRotationPoint(0.0F, 11.0F, -0.5F);
    this.rear_right_wrist.addChild(this.rear_right_hand);
    setRotationAngle(this.rear_right_hand, 0.0F, 0.0F, 0.8727F);
    this.rear_right_hand.setTextureOffset(99, 216).addBox(-2.0F, 0.0F, -3.0F, 4, 6, 7, 0.0F);
    this.rear_right_claw = new ModelRenderer(this);
    this.rear_right_claw.setRotationPoint(0.0F, 4.0F, 3.0F);
    this.rear_right_hand.addChild(this.rear_right_claw);
    setRotationAngle(this.rear_right_claw, 0.829F, 0.0F, -0.4363F);
    this.rear_right_claw.setTextureOffset(30, 163).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rear_right_claw_r1 = new ModelRenderer(this);
    this.rear_right_claw_r1.setRotationPoint(-1.0F, 6.0F, 0.0F);
    this.rear_right_claw.addChild(this.rear_right_claw_r1);
    setRotationAngle(this.rear_right_claw_r1, 0.0F, 0.0F, 0.6981F);
    this.rear_right_claw_r1.setTextureOffset(127, 164).addBox(0.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.rear_right_claw2 = new ModelRenderer(this);
    this.rear_right_claw2.setRotationPoint(0.0F, 4.0F, 1.0F);
    this.rear_right_hand.addChild(this.rear_right_claw2);
    setRotationAngle(this.rear_right_claw2, 0.2618F, 0.0F, -0.4363F);
    this.rear_right_claw2.setTextureOffset(30, 155).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rear_right_claw2_r1 = new ModelRenderer(this);
    this.rear_right_claw2_r1.setRotationPoint(-1.0F, 6.0F, 0.0F);
    this.rear_right_claw2.addChild(this.rear_right_claw2_r1);
    setRotationAngle(this.rear_right_claw2_r1, 0.0F, 0.0F, 0.6981F);
    this.rear_right_claw2_r1.setTextureOffset(154, 86).addBox(0.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.rear_right_claw3 = new ModelRenderer(this);
    this.rear_right_claw3.setRotationPoint(0.0F, 4.0F, -0.5F);
    this.rear_right_hand.addChild(this.rear_right_claw3);
    setRotationAngle(this.rear_right_claw3, -0.2618F, 0.0F, -0.4363F);
    this.rear_right_claw3.setTextureOffset(154, 93).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rear_right_claw3_r1 = new ModelRenderer(this);
    this.rear_right_claw3_r1.setRotationPoint(-1.0F, 6.0F, 0.0F);
    this.rear_right_claw3.addChild(this.rear_right_claw3_r1);
    setRotationAngle(this.rear_right_claw3_r1, 0.0F, 0.0F, 0.6981F);
    this.rear_right_claw3_r1.setTextureOffset(35, 146).addBox(0.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.rear_right_claw4 = new ModelRenderer(this);
    this.rear_right_claw4.setRotationPoint(0.0F, 4.0F, -2.0F);
    this.rear_right_hand.addChild(this.rear_right_claw4);
    setRotationAngle(this.rear_right_claw4, -0.7854F, 0.0F, -0.4363F);
    this.rear_right_claw4.setTextureOffset(147, 147).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rear_right_claw4_r1 = new ModelRenderer(this);
    this.rear_right_claw4_r1.setRotationPoint(-1.0F, 6.0F, 0.0F);
    this.rear_right_claw4.addChild(this.rear_right_claw4_r1);
    setRotationAngle(this.rear_right_claw4_r1, 0.0F, 0.0F, 0.6981F);
    this.rear_right_claw4_r1.setTextureOffset(0, 146).addBox(0.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.rear_left_leg = new ModelRenderer(this);
    this.rear_left_leg.setRotationPoint(5.5F, 3.0F, 4.0F);
    this.tail4.addChild(this.rear_left_leg);
    setRotationAngle(this.rear_left_leg, 0.3491F, 0.0F, -0.5672F);
    this.rear_left_leg.setTextureOffset(34, 170).addBox(-3.5F, -4.0F, -6.0F, 7, 14, 12, 0.0F);
    this.rear_left_knee = new ModelRenderer(this);
    this.rear_left_knee.setRotationPoint(0.0F, 10.0F, 1.5F);
    this.rear_left_leg.addChild(this.rear_left_knee);
    setRotationAngle(this.rear_left_knee, -0.2618F, 0.0F, -0.2618F);
    this.rear_left_knee.setTextureOffset(155, 207).addBox(-2.5F, -1.0F, -3.5F, 5, 14, 7, 0.0F);
    this.rear_left_wrist = new ModelRenderer(this);
    this.rear_left_wrist.setRotationPoint(0.0F, 13.0F, 0.5F);
    this.rear_left_knee.addChild(this.rear_left_wrist);
    setRotationAngle(this.rear_left_wrist, -1.0036F, 0.0F, 0.0F);
    this.rear_left_wrist.setTextureOffset(0, 72).addBox(-2.0F, -1.0F, -2.5F, 4, 12, 5, 0.0F);
    this.rear_left_hand = new ModelRenderer(this);
    this.rear_left_hand.setRotationPoint(0.0F, 11.0F, -0.5F);
    this.rear_left_wrist.addChild(this.rear_left_hand);
    setRotationAngle(this.rear_left_hand, 0.0F, 0.0F, -0.8727F);
    this.rear_left_hand.setTextureOffset(123, 26).addBox(-2.0F, 0.0F, -3.0F, 4, 6, 7, 0.0F);
    this.rear_left_claw = new ModelRenderer(this);
    this.rear_left_claw.setRotationPoint(0.0F, 4.0F, 3.0F);
    this.rear_left_hand.addChild(this.rear_left_claw);
    setRotationAngle(this.rear_left_claw, 0.829F, 0.0F, 0.4363F);
    this.rear_left_claw.setTextureOffset(139, 147).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rear_left_claw_r1 = new ModelRenderer(this);
    this.rear_left_claw_r1.setRotationPoint(1.0F, 6.0F, 0.0F);
    this.rear_left_claw.addChild(this.rear_left_claw_r1);
    setRotationAngle(this.rear_left_claw_r1, 0.0F, 0.0F, -0.6981F);
    this.rear_left_claw_r1.setTextureOffset(84, 145).addBox(-4.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.rear_left_claw2 = new ModelRenderer(this);
    this.rear_left_claw2.setRotationPoint(0.0F, 4.0F, 1.0F);
    this.rear_left_hand.addChild(this.rear_left_claw2);
    setRotationAngle(this.rear_left_claw2, 0.2618F, 0.0F, 0.4363F);
    this.rear_left_claw2.setTextureOffset(76, 145).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rear_left_claw2_r1 = new ModelRenderer(this);
    this.rear_left_claw2_r1.setRotationPoint(1.0F, 6.0F, 0.0F);
    this.rear_left_claw2.addChild(this.rear_left_claw2_r1);
    setRotationAngle(this.rear_left_claw2_r1, 0.0F, 0.0F, -0.6981F);
    this.rear_left_claw2_r1.setTextureOffset(109, 118).addBox(-4.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.rear_left_claw3 = new ModelRenderer(this);
    this.rear_left_claw3.setRotationPoint(0.0F, 4.0F, -0.5F);
    this.rear_left_hand.addChild(this.rear_left_claw3);
    setRotationAngle(this.rear_left_claw3, -0.2618F, 0.0F, 0.4363F);
    this.rear_left_claw3.setTextureOffset(111, 93).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rear_left_claw3_r1 = new ModelRenderer(this);
    this.rear_left_claw3_r1.setRotationPoint(1.0F, 6.0F, 0.0F);
    this.rear_left_claw3.addChild(this.rear_left_claw3_r1);
    setRotationAngle(this.rear_left_claw3_r1, 0.0F, 0.0F, -0.6981F);
    this.rear_left_claw3_r1.setTextureOffset(64, 7).addBox(-4.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.rear_left_claw4 = new ModelRenderer(this);
    this.rear_left_claw4.setRotationPoint(0.0F, 4.0F, -2.0F);
    this.rear_left_hand.addChild(this.rear_left_claw4);
    setRotationAngle(this.rear_left_claw4, -0.7854F, 0.0F, 0.4363F);
    this.rear_left_claw4.setTextureOffset(56, 7).addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
    this.rear_left_claw4_r1 = new ModelRenderer(this);
    this.rear_left_claw4_r1.setRotationPoint(1.0F, 6.0F, 0.0F);
    this.rear_left_claw4.addChild(this.rear_left_claw4_r1);
    setRotationAngle(this.rear_left_claw4_r1, 0.0F, 0.0F, -0.6981F);
    this.rear_left_claw4_r1.setTextureOffset(0, 46).addBox(-4.0F, -2.0F, -1.0F, 4, 2, 2, -0.125F);
    this.tail5 = new ModelRenderer(this);
    this.tail5.setRotationPoint(0.0F, -3.0F, 10.0F);
    this.tail4.addChild(this.tail5);
    setRotationAngle(this.tail5, -0.0873F, 0.0F, 0.0F);
    this.tail5.setTextureOffset(119, 45).addBox(-7.0F, -5.0F, -1.0F, 14, 15, 11, -0.125F);
    this.tail5_r1 = new ModelRenderer(this);
    this.tail5_r1.setRotationPoint(-5.0F, -7.0F, -138.0F);
    this.tail5.addChild(this.tail5_r1);
    setRotationAngle(this.tail5_r1, 0.0F, -1.5708F, 0.0F);
    this.tail5_r1.setTextureOffset(169, 5).addBox(138.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail6 = new ModelRenderer(this);
    this.tail6.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail5.addChild(this.tail6);
    setRotationAngle(this.tail6, -0.1309F, 0.0F, 0.0F);
    this.tail6.setTextureOffset(93, 138).addBox(-6.0F, -5.0F, -1.0F, 12, 15, 11, 0.0F);
    this.tail6_r1 = new ModelRenderer(this);
    this.tail6_r1.setRotationPoint(-5.0F, -7.0F, -148.0F);
    this.tail6.addChild(this.tail6_r1);
    setRotationAngle(this.tail6_r1, 0.0F, -1.5708F, 0.0F);
    this.tail6_r1.setTextureOffset(169, 0).addBox(148.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail7 = new ModelRenderer(this);
    this.tail7.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail6.addChild(this.tail7);
    setRotationAngle(this.tail7, 0.1309F, 0.0F, 0.0F);
    this.tail7.setTextureOffset(41, 145).addBox(-6.0F, -5.0F, -1.0F, 12, 14, 11, -0.125F);
    this.tail7_r1 = new ModelRenderer(this);
    this.tail7_r1.setRotationPoint(-5.0F, -7.0F, -158.0F);
    this.tail7.addChild(this.tail7_r1);
    setRotationAngle(this.tail7_r1, 0.0F, -1.5708F, 0.0F);
    this.tail7_r1.setTextureOffset(107, 169).addBox(158.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail8 = new ModelRenderer(this);
    this.tail8.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail7.addChild(this.tail8);
    setRotationAngle(this.tail8, 0.1309F, 0.0F, 0.0F);
    this.tail8.setTextureOffset(174, 118).addBox(-5.0F, -5.0F, -1.0F, 10, 13, 11, 0.0F);
    this.tail8_r1 = new ModelRenderer(this);
    this.tail8_r1.setRotationPoint(-5.0F, -7.0F, -168.0F);
    this.tail8.addChild(this.tail8_r1);
    setRotationAngle(this.tail8_r1, 0.0F, -1.5708F, 0.0F);
    this.tail8_r1.setTextureOffset(165, 123).addBox(168.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail9 = new ModelRenderer(this);
    this.tail9.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail8.addChild(this.tail9);
    setRotationAngle(this.tail9, -0.0873F, 0.0F, 0.0F);
    this.tail9.setTextureOffset(119, 177).addBox(-5.0F, -5.0F, -1.0F, 10, 12, 11, -0.125F);
    this.tail9_r1 = new ModelRenderer(this);
    this.tail9_r1.setRotationPoint(-5.0F, -7.0F, -168.0F);
    this.tail9.addChild(this.tail9_r1);
    setRotationAngle(this.tail9_r1, 0.0F, -1.5708F, 0.0F);
    this.tail9_r1.setTextureOffset(165, 118).addBox(168.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail10 = new ModelRenderer(this);
    this.tail10.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail9.addChild(this.tail10);
    setRotationAngle(this.tail10, -0.0873F, 0.0F, 0.0F);
    this.tail10.setTextureOffset(61, 189).addBox(-4.0F, -5.0F, -1.0F, 8, 11, 11, 0.0F);
    this.tail10_r1 = new ModelRenderer(this);
    this.tail10_r1.setRotationPoint(-5.0F, -7.0F, -168.0F);
    this.tail10.addChild(this.tail10_r1);
    setRotationAngle(this.tail10_r1, 0.0F, -1.5708F, 0.0F);
    this.tail10_r1.setTextureOffset(107, 164).addBox(168.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail11 = new ModelRenderer(this);
    this.tail11.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail10.addChild(this.tail11);
    setRotationAngle(this.tail11, -0.1745F, 0.0F, 0.0F);
    this.tail11.setTextureOffset(189, 40).addBox(-4.0F, -5.0F, -1.0F, 8, 10, 11, -0.125F);
    this.tail11_r1 = new ModelRenderer(this);
    this.tail11_r1.setRotationPoint(-5.0F, -7.0F, -168.0F);
    this.tail11.addChild(this.tail11_r1);
    setRotationAngle(this.tail11_r1, 0.0F, -1.5708F, 0.0F);
    this.tail11_r1.setTextureOffset(158, 49).addBox(168.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail12 = new ModelRenderer(this);
    this.tail12.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail11.addChild(this.tail12);
    setRotationAngle(this.tail12, -0.0873F, 0.0F, 0.0F);
    this.tail12.setTextureOffset(190, 196).addBox(-3.0F, -5.0F, -1.0F, 6, 9, 11, 0.0F);
    this.tail12_r1 = new ModelRenderer(this);
    this.tail12_r1.setRotationPoint(-5.0F, -7.0F, -168.0F);
    this.tail12.addChild(this.tail12_r1);
    setRotationAngle(this.tail12_r1, 0.0F, -1.5708F, 0.0F);
    this.tail12_r1.setTextureOffset(119, 5).addBox(168.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail13 = new ModelRenderer(this);
    this.tail13.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail12.addChild(this.tail13);
    setRotationAngle(this.tail13, -0.1309F, 0.0F, 0.0F);
    this.tail13.setTextureOffset(196, 0).addBox(-3.0F, -5.0F, -1.0F, 6, 8, 11, -0.125F);
    this.tail13_r1 = new ModelRenderer(this);
    this.tail13_r1.setRotationPoint(-5.0F, -7.0F, -168.0F);
    this.tail13.addChild(this.tail13_r1);
    setRotationAngle(this.tail13_r1, 0.0F, -1.5708F, 0.0F);
    this.tail13_r1.setTextureOffset(119, 0).addBox(168.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail14 = new ModelRenderer(this);
    this.tail14.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail13.addChild(this.tail14);
    setRotationAngle(this.tail14, -0.0873F, 0.0F, 0.0F);
    this.tail14.setTextureOffset(27, 199).addBox(-3.0F, -5.0F, -1.0F, 6, 7, 11, -0.125F);
    this.tail14_r1 = new ModelRenderer(this);
    this.tail14_r1.setRotationPoint(-5.0F, -7.0F, -168.0F);
    this.tail14.addChild(this.tail14_r1);
    setRotationAngle(this.tail14_r1, 0.0F, -1.5708F, 0.0F);
    this.tail14_r1.setTextureOffset(43, 112).addBox(168.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail15 = new ModelRenderer(this);
    this.tail15.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail14.addChild(this.tail15);
    setRotationAngle(this.tail15, -0.0873F, 0.0F, 0.0F);
    this.tail15.setTextureOffset(205, 108).addBox(-2.0F, -5.0F, -1.0F, 4, 6, 11, 0.0F);
    this.tail15_r1 = new ModelRenderer(this);
    this.tail15_r1.setRotationPoint(-5.0F, -7.0F, -168.0F);
    this.tail15.addChild(this.tail15_r1);
    setRotationAngle(this.tail15_r1, 0.0F, -1.5708F, 0.0F);
    this.tail15_r1.setTextureOffset(43, 107).addBox(168.0F, -3.0F, -5.0F, 10, 5, 0, 0.0F);
    this.tail16 = new ModelRenderer(this);
    this.tail16.setRotationPoint(0.0F, 0.0F, 10.0F);
    this.tail15.addChild(this.tail16);
    setRotationAngle(this.tail16, -0.0436F, 0.0F, 0.0F);
    this.tail16.setTextureOffset(215, 215).addBox(-1.5F, -5.0F, -1.0F, 3, 5, 9, 0.0F);
    this.tail16_r1 = new ModelRenderer(this);
    this.tail16_r1.setRotationPoint(0.0F, -12.0F, 3.0F);
    this.tail16.addChild(this.tail16_r1);
    setRotationAngle(this.tail16_r1, 0.0F, -1.5708F, 0.0F);
    this.tail16_r1.setTextureOffset(154, 73).addBox(-3.0F, 2.0F, 0.0F, 16, 9, 0, 0.0F);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    this.head.rotateAngleY = headYaw / 85.943665F;
    this.head.rotateAngleX = headPitch / 114.59155F;
    this.head_r1.rotateAngleY = headYaw / 85.943665F;
    this.head_r1.rotateAngleX = headPitch / 114.59155F;
    this.head_r2.rotateAngleY = headYaw / 85.943665F;
    this.head_r2.rotateAngleX = headPitch / 114.59155F;
    this.head_r3.rotateAngleY = headYaw / 85.943665F;
    this.head_r3.rotateAngleX = headPitch / 114.59155F;
    this.head_r4.rotateAngleY = headYaw / 85.943665F;
    this.head_r4.rotateAngleX = headPitch / 114.59155F;
    this.head_r5.rotateAngleY = headYaw / 85.943665F;
    this.head_r5.rotateAngleX = headPitch / 114.59155F;
    if (!ent.onGround) {
      this.body.rotateAngleX = MathHelper.cos(ageInTicks * 0.1F) * 0.3F;
      this.tail.rotateAngleZ = MathHelper.cos(ageInTicks * 0.1F) * 0.3F;
      this.tail2.rotateAngleZ = MathHelper.cos(ageInTicks * 0.1F + 3.1415927F) * 0.3F;
      this.tail2_r1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.2F) * 0.4F;
      this.tail3_r1.rotateAngleZ = MathHelper.cos(ageInTicks * 0.3F + 3.1415927F) * 0.4F;
      this.tail3.rotateAngleX = 0.5F * MathHelper.cos(ageInTicks * 0.4F) * 0.3F;
      this.tail4.rotateAngleX = 0.5F * MathHelper.cos(ageInTicks * 0.4F + 3.1415927F) * 0.3F;
      this.tail4_r1.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.5F) * 0.8F;
      this.tail5.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.5F + 3.1415927F) * 0.8F;
      this.tail5_r1.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.5F + 3.1415927F) * 0.8F;
      this.tail6.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.6F + 3.1415927F) * 0.8F;
      this.tail6_r1.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.6F + 3.1415927F) * 0.8F;
      this.tail7.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.7F + 3.1415927F) * 0.8F;
      this.tail7_r1.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.7F + 3.1415927F) * 0.8F;
      this.tail8.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.8F + 3.1415927F) * 0.8F;
      this.tail8_r1.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.9F + 3.1415927F) * 0.8F;
      this.tail9.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.1F + 3.1415927F) * 0.8F;
      this.tail9_r1.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.11F + 3.1415927F) * 0.8F;
      this.tail10.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.12F + 3.1415927F) * 0.8F;
      this.tail11_r1.rotateAngleX = 0.2F * MathHelper.cos(ageInTicks * 0.13F + 3.1415927F) * 0.8F;
    } else {
      this.fwd_left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
      this.rear_left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
      this.fwd_right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
      this.rear_right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
    } 
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.neck.render(f5);
    this.body.render(f5);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public ModelRenderer getHandRenderer() {
    return null;
  }
}
