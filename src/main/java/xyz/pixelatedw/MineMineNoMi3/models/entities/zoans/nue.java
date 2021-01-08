package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class nue extends ModelZoanMorph {
  private final ModelRenderer bone;
  
  private final ModelRenderer cube_r1;
  
  private final ModelRenderer cube_r2;
  
  private final ModelRenderer cube_r3;
  
  private final ModelRenderer cube_r4;
  
  private final ModelRenderer cube_r5;
  
  private final ModelRenderer cube_r6;
  
  private final ModelRenderer cube_r7;
  
  private final ModelRenderer cube_r8;
  
  private final ModelRenderer v_r1;
  
  private final ModelRenderer v_r2;
  
  private final ModelRenderer cube_r9;
  
  private final ModelRenderer cube_r10;
  
  private final ModelRenderer cube_r11;
  
  private final ModelRenderer cube_r12;
  
  private final ModelRenderer cube_r13;
  
  private final ModelRenderer cube_r14;
  
  private final ModelRenderer cube_r15;
  
  private final ModelRenderer cube_r16;
  
  private final ModelRenderer cube_r17;
  
  private final ModelRenderer cube_r18;
  
  private final ModelRenderer cube_r19;
  
  private final ModelRenderer cube_r20;
  
  private final ModelRenderer mouthfinal;
  
  private final ModelRenderer mouth;
  
  private final ModelRenderer cube_r21;
  
  private final ModelRenderer bone2;
  
  private final ModelRenderer cube_r22;
  
  private final ModelRenderer cube_r23;
  
  private final ModelRenderer cube_r24;
  
  private final ModelRenderer cube_r25;
  
  private final ModelRenderer cube_r26;
  
  private final ModelRenderer cube_r27;
  
  private final ModelRenderer cube_r28;
  
  private final ModelRenderer cube_r29;
  
  private final ModelRenderer face;
  
  private final ModelRenderer cube_r30;
  
  private final ModelRenderer cube_r31;
  
  private final ModelRenderer cube_r32;
  
  private final ModelRenderer cube_r33;
  
  private final ModelRenderer cube_r34;
  
  private final ModelRenderer cube_r35;
  
  private final ModelRenderer cube_r36;
  
  private final ModelRenderer cube_r37;
  
  private final ModelRenderer cube_r38;
  
  private final ModelRenderer cube_r39;
  
  private final ModelRenderer cube_r40;
  
  private final ModelRenderer cube_r41;
  
  private final ModelRenderer cube_r42;
  
  private final ModelRenderer cube_r43;
  
  private final ModelRenderer cube_r44;
  
  private final ModelRenderer cube_r45;
  
  private final ModelRenderer cube_r46;
  
  private final ModelRenderer cube_r47;
  
  private final ModelRenderer cube_r48;
  
  private final ModelRenderer cube_r49;
  
  private final ModelRenderer cube_r50;
  
  private final ModelRenderer ssvv_r1;
  
  private final ModelRenderer ssvv_r2;
  
  private final ModelRenderer ssvv_r3;
  
  private final ModelRenderer ssvv_r4;
  
  private final ModelRenderer ssvv_r5;
  
  private final ModelRenderer ssvv_r6;
  
  private final ModelRenderer cube_r51;
  
  private final ModelRenderer cube_r52;
  
  private final ModelRenderer main;
  
  private final ModelRenderer cube_r53;
  
  private final ModelRenderer arm;
  
  private final ModelRenderer armright;
  
  private final ModelRenderer cube_r54;
  
  private final ModelRenderer cube_r55;
  
  private final ModelRenderer cube_r56;
  
  private final ModelRenderer cube_r57;
  
  private final ModelRenderer cube_r58;
  
  private final ModelRenderer cube_r59;
  
  private final ModelRenderer cube_r60;
  
  private final ModelRenderer cube_r61;
  
  private final ModelRenderer cube_r62;
  
  private final ModelRenderer cube_r63;
  
  private final ModelRenderer bone3;
  
  private final ModelRenderer cube_r64;
  
  private final ModelRenderer cube_r65;
  
  private final ModelRenderer cube_r66;
  
  private final ModelRenderer bone4;
  
  private final ModelRenderer cube_r67;
  
  private final ModelRenderer cube_r68;
  
  private final ModelRenderer cube_r69;
  
  private final ModelRenderer armleft;
  
  private final ModelRenderer cube_r70;
  
  private final ModelRenderer cube_r71;
  
  private final ModelRenderer cube_r72;
  
  private final ModelRenderer cube_r73;
  
  private final ModelRenderer cube_r74;
  
  private final ModelRenderer cube_r75;
  
  private final ModelRenderer cube_r76;
  
  private final ModelRenderer cube_r77;
  
  private final ModelRenderer cube_r78;
  
  private final ModelRenderer cube_r79;
  
  private final ModelRenderer cube_r80;
  
  private final ModelRenderer bone5;
  
  private final ModelRenderer cube_r81;
  
  private final ModelRenderer cube_r82;
  
  private final ModelRenderer cube_r83;
  
  private final ModelRenderer bone6;
  
  private final ModelRenderer cube_r84;
  
  private final ModelRenderer cube_r85;
  
  private final ModelRenderer cube_r86;
  
  private final ModelRenderer leg;
  
  private final ModelRenderer legright;
  
  private final ModelRenderer cube_r87;
  
  private final ModelRenderer cube_r88;
  
  private final ModelRenderer bone9;
  
  private final ModelRenderer cube_r89;
  
  private final ModelRenderer cube_r90;
  
  private final ModelRenderer cube_r91;
  
  private final ModelRenderer cube_r92;
  
  private final ModelRenderer cube_r93;
  
  private final ModelRenderer cube_r94;
  
  private final ModelRenderer cube_r95;
  
  private final ModelRenderer cube_r96;
  
  private final ModelRenderer cube_r97;
  
  private final ModelRenderer cube_r98;
  
  private final ModelRenderer cube_r99;
  
  private final ModelRenderer cube_r100;
  
  private final ModelRenderer cube_r101;
  
  private final ModelRenderer cube_r102;
  
  private final ModelRenderer bone10;
  
  private final ModelRenderer legleft;
  
  private final ModelRenderer cube_r103;
  
  private final ModelRenderer cube_r104;
  
  private final ModelRenderer cube_r105;
  
  private final ModelRenderer bone7;
  
  private final ModelRenderer cube_r106;
  
  private final ModelRenderer cube_r107;
  
  private final ModelRenderer cube_r108;
  
  private final ModelRenderer cube_r109;
  
  private final ModelRenderer cube_r110;
  
  private final ModelRenderer cube_r111;
  
  private final ModelRenderer cube_r112;
  
  private final ModelRenderer cube_r113;
  
  private final ModelRenderer cube_r114;
  
  private final ModelRenderer cube_r115;
  
  private final ModelRenderer cube_r116;
  
  private final ModelRenderer cube_r117;
  
  private final ModelRenderer cube_r118;
  
  private final ModelRenderer cube_r119;
  
  private final ModelRenderer bone8;
  
  public nue() {
    this.textureWidth = 224;
    this.textureHeight = 224;
    this.bone = new ModelRenderer(this);
    this.bone.setRotationPoint(-2.0F, 6.0F, -6.0F);
    this.bone.cubeList.add(new ModelBox(this.bone, 68, 87, -7.0F, -20.6055F, 21.9391F, 18, 20, 16, 0.0F));
    this.cube_r1 = new ModelRenderer(this);
    this.cube_r1.setRotationPoint(30.2539F, -5.6809F, 72.8347F);
    this.bone.addChild(this.cube_r1);
    setRotationAngle(this.cube_r1, 0.0F, 2.4871F, 0.0F);
    this.cube_r1.cubeList.add(new ModelBox(this.cube_r1, 17, 78, -3.0F, 0.0F, 3.0F, 5, 2, 5, 0.0F));
    this.cube_r1.cubeList.add(new ModelBox(this.cube_r1, 20, 23, 1.7461F, 2.0F, 3.0F, 0, 2, 5, 0.0F));
    this.cube_r1.cubeList.add(new ModelBox(this.cube_r1, 0, 18, -2.7539F, 2.0F, 8.0F, 4, 1, 0, 0.0F));
    this.cube_r1.cubeList.add(new ModelBox(this.cube_r1, 70, 37, -2.7539F, 2.0F, 3.0F, 0, 2, 5, 0.0F));
    this.cube_r2 = new ModelRenderer(this);
    this.cube_r2.setRotationPoint(30.4653F, -7.6506F, 72.5592F);
    this.bone.addChild(this.cube_r2);
    setRotationAngle(this.cube_r2, -0.1745F, 2.4871F, 0.0F);
    this.cube_r2.cubeList.add(new ModelBox(this.cube_r2, 85, 38, -3.0F, 0.0F, 3.0F, 5, 2, 5, 0.0F));
    this.cube_r2.cubeList.add(new ModelBox(this.cube_r2, 111, 57, -4.0F, 0.0F, 0.0F, 7, 2, 3, 0.0F));
    this.cube_r3 = new ModelRenderer(this);
    this.cube_r3.setRotationPoint(27.2101F, -7.6809F, 76.8015F);
    this.bone.addChild(this.cube_r3);
    setRotationAngle(this.cube_r3, 0.0F, 2.4871F, 0.0F);
    this.cube_r3.cubeList.add(new ModelBox(this.cube_r3, 52, 98, -4.0F, 2.0F, 5.0F, 7, 2, 3, 0.0F));
    this.cube_r4 = new ModelRenderer(this);
    this.cube_r4.setRotationPoint(27.4215F, -7.6506F, 76.526F);
    this.bone.addChild(this.cube_r4);
    setRotationAngle(this.cube_r4, 0.0F, 2.4871F, 0.0F);
    this.cube_r4.cubeList.add(new ModelBox(this.cube_r4, 96, 47, -4.0F, 0.0F, 0.0F, 7, 5, 5, 0.0F));
    this.cube_r5 = new ModelRenderer(this);
    this.cube_r5.setRotationPoint(19.1512F, -10.353F, 88.9467F);
    this.bone.addChild(this.cube_r5);
    setRotationAngle(this.cube_r5, -0.1745F, 2.4871F, 0.0F);
    this.cube_r5.cubeList.add(new ModelBox(this.cube_r5, 136, 20, -5.0F, -6.0F, 10.0F, 11, 11, 0, 0.0F));
    this.cube_r5.cubeList.add(new ModelBox(this.cube_r5, 169, 132, -2.0F, 0.0F, 0.0F, 5, 5, 16, 0.0F));
    this.cube_r6 = new ModelRenderer(this);
    this.cube_r6.setRotationPoint(5.2153F, -13.1313F, 86.7986F);
    this.bone.addChild(this.cube_r6);
    setRotationAngle(this.cube_r6, -0.1745F, 1.4835F, 0.0F);
    this.cube_r6.cubeList.add(new ModelBox(this.cube_r6, 0, 199, -7.0F, -8.0F, 11.0F, 19, 26, 0, 0.0F));
    this.cube_r6.cubeList.add(new ModelBox(this.cube_r6, 173, 36, -2.0F, 0.0F, 0.0F, 5, 6, 16, 0.0F));
    this.cube_r7 = new ModelRenderer(this);
    this.cube_r7.setRotationPoint(1.6955F, -15.9097F, 74.0816F);
    this.bone.addChild(this.cube_r7);
    setRotationAngle(this.cube_r7, -0.1745F, 0.3927F, 0.0F);
    this.cube_r7.cubeList.add(new ModelBox(this.cube_r7, 172, 0, -3.0F, 0.0F, 0.0F, 6, 8, 16, 0.0F));
    this.cube_r8 = new ModelRenderer(this);
    this.cube_r8.setRotationPoint(2.0F, -18.6881F, 59.8554F);
    this.bone.addChild(this.cube_r8);
    setRotationAngle(this.cube_r8, -0.1745F, 0.0F, 0.0F);
    this.cube_r8.cubeList.add(new ModelBox(this.cube_r8, 164, 96, -4.0F, 0.0F, 0.0F, 8, 10, 16, 0.0F));
    this.cube_r8.cubeList.add(new ModelBox(this.cube_r8, 0, 32, -10.0F, -6.0F, 11.0F, 20, 20, 0, 0.0F));
    this.v_r1 = new ModelRenderer(this);
    this.v_r1.setRotationPoint(0.0F, -20.6055F, 37.9391F);
    this.bone.addChild(this.v_r1);
    setRotationAngle(this.v_r1, -0.0873F, 0.0F, 0.0F);
    this.v_r1.cubeList.add(new ModelBox(this.v_r1, 38, 45, -7.0F, 0.0F, 0.0F, 18, 20, 22, 0.0F));
    this.v_r2 = new ModelRenderer(this);
    this.v_r2.setRotationPoint(0.0F, -22.0F, 8.0F);
    this.bone.addChild(this.v_r2);
    setRotationAngle(this.v_r2, -0.0873F, 0.0F, 0.0F);
    this.v_r2.cubeList.add(new ModelBox(this.v_r2, 0, 87, -7.0F, 0.0F, 0.0F, 18, 21, 16, 0.0F));
    this.cube_r9 = new ModelRenderer(this);
    this.cube_r9.setRotationPoint(0.0F, -31.0688F, 49.2791F);
    this.bone.addChild(this.cube_r9);
    setRotationAngle(this.cube_r9, 0.7854F, 0.0F, 0.0F);
    this.cube_r9.cubeList.add(new ModelBox(this.cube_r9, 116, 22, -8.0F, 0.0F, -17.0F, 20, 14, 16, 0.0F));
    this.cube_r10 = new ModelRenderer(this);
    this.cube_r10.setRotationPoint(0.0F, -31.0688F, 35.2791F);
    this.bone.addChild(this.cube_r10);
    setRotationAngle(this.cube_r10, 0.7854F, 0.0F, 0.0F);
    this.cube_r10.cubeList.add(new ModelBox(this.cube_r10, 116, 22, -8.0F, 0.0F, -17.0F, 20, 14, 16, 0.0F));
    this.cube_r11 = new ModelRenderer(this);
    this.cube_r11.setRotationPoint(0.0F, -31.0688F, 24.2791F);
    this.bone.addChild(this.cube_r11);
    setRotationAngle(this.cube_r11, 0.7854F, 0.0F, 0.0F);
    this.cube_r11.cubeList.add(new ModelBox(this.cube_r11, 116, 22, -8.0F, 0.0F, -17.0F, 20, 14, 16, 0.0F));
    this.cube_r12 = new ModelRenderer(this);
    this.cube_r12.setRotationPoint(0.0F, -31.0688F, 14.2791F);
    this.bone.addChild(this.cube_r12);
    setRotationAngle(this.cube_r12, 0.7854F, 0.0F, 0.0F);
    this.cube_r12.cubeList.add(new ModelBox(this.cube_r12, 116, 22, -8.0F, 0.0F, -17.0F, 20, 14, 16, 0.0F));
    this.cube_r13 = new ModelRenderer(this);
    this.cube_r13.setRotationPoint(1.0F, -27.0688F, 18.2791F);
    this.bone.addChild(this.cube_r13);
    setRotationAngle(this.cube_r13, 0.7854F, 0.0F, 0.0F);
    this.cube_r13.cubeList.add(new ModelBox(this.cube_r13, 0, 0, 1.0F, -10.0F, -1.0F, 0, 37, 30, 0.0F));
    this.cube_r14 = new ModelRenderer(this);
    this.cube_r14.setRotationPoint(0.0F, -19.0688F, 47.2791F);
    this.bone.addChild(this.cube_r14);
    setRotationAngle(this.cube_r14, 0.7854F, 0.0F, 0.0F);
    this.cube_r14.cubeList.add(new ModelBox(this.cube_r14, 83, 195, -5.0F, 2.0F, -8.0F, 14, 12, 18, 0.0F));
    this.cube_r15 = new ModelRenderer(this);
    this.cube_r15.setRotationPoint(0.0F, -30.0688F, 42.2791F);
    this.bone.addChild(this.cube_r15);
    setRotationAngle(this.cube_r15, 0.7854F, 0.0F, 0.0F);
    this.cube_r15.cubeList.add(new ModelBox(this.cube_r15, 118, 118, -5.0F, 2.0F, -8.0F, 14, 12, 18, 0.0F));
    this.cube_r16 = new ModelRenderer(this);
    this.cube_r16.setRotationPoint(0.0F, -30.0688F, 28.2791F);
    this.bone.addChild(this.cube_r16);
    setRotationAngle(this.cube_r16, 0.7854F, 0.0F, 0.0F);
    this.cube_r16.cubeList.add(new ModelBox(this.cube_r16, 118, 118, -5.0F, 2.0F, -8.0F, 14, 12, 18, 0.0F));
    this.cube_r17 = new ModelRenderer(this);
    this.cube_r17.setRotationPoint(0.0F, -30.0688F, 15.2791F);
    this.bone.addChild(this.cube_r17);
    setRotationAngle(this.cube_r17, 0.7854F, 0.0F, 0.0F);
    this.cube_r17.cubeList.add(new ModelBox(this.cube_r17, 118, 118, -5.0F, 2.0F, -8.0F, 14, 12, 18, 0.0F));
    this.cube_r18 = new ModelRenderer(this);
    this.cube_r18.setRotationPoint(0.0F, -30.0688F, 3.2791F);
    this.bone.addChild(this.cube_r18);
    setRotationAngle(this.cube_r18, 0.7854F, 0.0F, 0.0F);
    this.cube_r18.cubeList.add(new ModelBox(this.cube_r18, 118, 118, -5.0F, 2.0F, -8.0F, 14, 12, 18, 0.0F));
    this.cube_r19 = new ModelRenderer(this);
    this.cube_r19.setRotationPoint(0.0F, -31.0688F, 4.2791F);
    this.bone.addChild(this.cube_r19);
    setRotationAngle(this.cube_r19, 0.7854F, 0.0F, 0.0F);
    this.cube_r19.cubeList.add(new ModelBox(this.cube_r19, 116, 22, -8.0F, 0.0F, -17.0F, 20, 14, 16, 0.0F));
    this.cube_r20 = new ModelRenderer(this);
    this.cube_r20.setRotationPoint(0.0F, -22.0F, 9.0F);
    this.bone.addChild(this.cube_r20);
    setRotationAngle(this.cube_r20, 0.1745F, 0.0F, 0.0F);
    this.cube_r20.cubeList.add(new ModelBox(this.cube_r20, 60, 0, -8.0F, 0.0F, -17.0F, 20, 22, 16, 0.0F));
    this.mouthfinal = new ModelRenderer(this);
    this.mouthfinal.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone.addChild(this.mouthfinal);
    this.mouth = new ModelRenderer(this);
    this.mouth.setRotationPoint(30.8627F, -3.6809F, 73.0414F);
    this.mouthfinal.addChild(this.mouth);
    setRotationAngle(this.mouth, 0.48F, -0.0436F, 0.3491F);
    this.cube_r21 = new ModelRenderer(this);
    this.cube_r21.setRotationPoint(0.0F, 0.0F, -1.0F);
    this.mouth.addChild(this.cube_r21);
    setRotationAngle(this.cube_r21, 0.0F, 2.4871F, 0.0F);
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 13, 0, -3.6627F, -1.0F, -2.0F, 0, 2, 3, 0.0F));
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 30, 23, -2.6627F, -1.0F, 1.7586F, 0, 2, 5, 0.0F));
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 26, 73, 2.6373F, -1.0F, -1.0F, 0, 2, 3, 0.0F));
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 26, 69, 1.6373F, -1.0F, 1.7586F, 0, 2, 5, 0.0F));
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 105, 63, -2.6627F, -1.0F, 6.7586F, 4, 2, 0, 0.0F));
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 96, 57, -3.0F, 0.0F, 2.0F, 5, 1, 5, 0.0F));
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 0, 83, -4.0F, 0.0F, -1.0F, 7, 1, 3, 0.0F));
    this.bone2 = new ModelRenderer(this);
    this.bone2.setRotationPoint(30.8627F, -3.6809F, 72.0414F);
    this.mouthfinal.addChild(this.bone2);
    this.cube_r22 = new ModelRenderer(this);
    this.cube_r22.setRotationPoint(5.5664F, 3.405F, 4.6505F);
    this.bone2.addChild(this.cube_r22);
    setRotationAngle(this.cube_r22, -0.1309F, -0.48F, 0.2618F);
    this.cube_r22.cubeList.add(new ModelBox(this.cube_r22, 10, 10, -2.4617F, -0.154F, -0.1265F, 3, 0, 3, 0.0F));
    this.cube_r23 = new ModelRenderer(this);
    this.cube_r23.setRotationPoint(6.9943F, 3.3823F, 2.0123F);
    this.bone2.addChild(this.cube_r23);
    setRotationAngle(this.cube_r23, -0.1309F, -0.48F, 0.2618F);
    this.cube_r23.cubeList.add(new ModelBox(this.cube_r23, 10, 0, -2.4617F, -0.154F, -0.1265F, 3, 0, 3, 0.0F));
    this.cube_r24 = new ModelRenderer(this);
    this.cube_r24.setRotationPoint(8.4225F, 3.3585F, -0.6259F);
    this.bone2.addChild(this.cube_r24);
    setRotationAngle(this.cube_r24, -0.1309F, -0.48F, 0.2618F);
    this.cube_r24.cubeList.add(new ModelBox(this.cube_r24, 66, 0, -2.4617F, -0.154F, -0.1265F, 3, 0, 3, 0.0F));
    this.cube_r25 = new ModelRenderer(this);
    this.cube_r25.setRotationPoint(8.0386F, 2.8503F, -3.2028F);
    this.bone2.addChild(this.cube_r25);
    setRotationAngle(this.cube_r25, -0.1309F, 0.1745F, 0.2618F);
    this.cube_r25.cubeList.add(new ModelBox(this.cube_r25, 66, 8, -2.4617F, -0.154F, -0.1265F, 3, 0, 3, 0.0F));
    this.cube_r26 = new ModelRenderer(this);
    this.cube_r26.setRotationPoint(5.3769F, 2.2234F, -5.3352F);
    this.bone2.addChild(this.cube_r26);
    setRotationAngle(this.cube_r26, -0.2618F, 1.7453F, 0.0F);
    this.cube_r26.cubeList.add(new ModelBox(this.cube_r26, 18, 67, -2.4617F, -0.154F, -0.1265F, 3, 0, 3, 0.0F));
    this.cube_r27 = new ModelRenderer(this);
    this.cube_r27.setRotationPoint(3.9171F, 1.6946F, -4.0545F);
    this.bone2.addChild(this.cube_r27);
    setRotationAngle(this.cube_r27, -0.1745F, 2.0508F, 0.0F);
    this.cube_r27.cubeList.add(new ModelBox(this.cube_r27, 29, 76, -2.0F, 0.0F, -1.0F, 3, 0, 3, 0.0F));
    this.cube_r28 = new ModelRenderer(this);
    this.cube_r28.setRotationPoint(1.6539F, 1.1736F, -2.1554F);
    this.bone2.addChild(this.cube_r28);
    setRotationAngle(this.cube_r28, -0.1745F, 2.2689F, 0.0F);
    this.cube_r28.cubeList.add(new ModelBox(this.cube_r28, 29, 79, -2.0F, 0.0F, -1.0F, 3, 0, 3, 0.0F));
    this.cube_r29 = new ModelRenderer(this);
    this.cube_r29.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone2.addChild(this.cube_r29);
    setRotationAngle(this.cube_r29, -0.5236F, 2.4871F, 0.0F);
    this.cube_r29.cubeList.add(new ModelBox(this.cube_r29, 57, 42, -3.0F, 0.0F, -1.0F, 5, 0, 3, 0.0F));
    this.face = new ModelRenderer(this);
    this.face.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone.addChild(this.face);
    this.cube_r30 = new ModelRenderer(this);
    this.cube_r30.setRotationPoint(7.0F, -10.0F, -9.0F);
    this.face.addChild(this.cube_r30);
    setRotationAngle(this.cube_r30, 0.1745F, 0.0F, 0.5236F);
    this.cube_r30.cubeList.add(new ModelBox(this.cube_r30, 57, 0, 0.0F, -2.7224F, -0.537F, 4, 4, 4, 0.0F));
    this.cube_r31 = new ModelRenderer(this);
    this.cube_r31.setRotationPoint(2.0F, -3.0F, -9.0F);
    this.face.addChild(this.cube_r31);
    setRotationAngle(this.cube_r31, 0.1745F, 0.0F, 0.0F);
    this.cube_r31.cubeList.add(new ModelBox(this.cube_r31, 0, 0, -4.0F, -2.7224F, -0.537F, 4, 4, 5, 0.0F));
    this.cube_r31.cubeList.add(new ModelBox(this.cube_r31, 0, 9, 0.0F, -2.7224F, -0.537F, 4, 4, 5, 0.0F));
    this.cube_r32 = new ModelRenderer(this);
    this.cube_r32.setRotationPoint(7.0F, 0.0F, -13.0F);
    this.face.addChild(this.cube_r32);
    setRotationAngle(this.cube_r32, 0.1745F, 0.0F, 0.0F);
    this.cube_r32.cubeList.add(new ModelBox(this.cube_r32, 78, 42, -4.0F, -1.7224F, 3.0F, 1, 1, 2, 0.0F));
    this.cube_r32.cubeList.add(new ModelBox(this.cube_r32, 10, 87, -7.0F, -1.7224F, 3.0F, 1, 1, 2, 0.0F));
    this.cube_r33 = new ModelRenderer(this);
    this.cube_r33.setRotationPoint(6.0F, 0.0F, -12.0F);
    this.face.addChild(this.cube_r33);
    setRotationAngle(this.cube_r33, 0.1745F, 0.0F, 0.0F);
    this.cube_r33.cubeList.add(new ModelBox(this.cube_r33, 73, 87, -5.0F, -2.7224F, 1.463F, 2, 2, 3, 0.0F));
    this.cube_r34 = new ModelRenderer(this);
    this.cube_r34.setRotationPoint(-7.0F, 7.0F, -9.0F);
    this.face.addChild(this.cube_r34);
    setRotationAngle(this.cube_r34, 0.1745F, 0.0F, 0.0F);
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 0, 163, 2.0F, -6.7224F, 1.463F, 1, 4, 3, 0.0F));
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 0, 4, 15.0F, -7.7224F, 2.463F, 2, 1, 0, 0.0F));
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 73, 3, 3.0F, -6.7224F, 2.463F, 1, 4, 0, 0.0F));
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 73, 11, 14.0F, -6.7224F, 2.463F, 1, 4, 0, 0.0F));
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 8, 163, 15.0F, -6.7224F, 1.463F, 1, 4, 3, 0.0F));
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 60, 38, 3.0F, -2.7224F, 1.463F, 12, 1, 3, 0.0F));
    this.cube_r35 = new ModelRenderer(this);
    this.cube_r35.setRotationPoint(1.1983F, 6.445F, -9.0F);
    this.face.addChild(this.cube_r35);
    setRotationAngle(this.cube_r35, 0.1745F, 0.0F, -0.2182F);
    this.cube_r35.cubeList.add(new ModelBox(this.cube_r35, 72, 98, -6.0F, -11.7224F, 1.463F, 3, 1, 3, 0.0F));
    this.cube_r35.cubeList.add(new ModelBox(this.cube_r35, 13, 9, -6.0F, -10.7224F, 2.463F, 3, 1, 0, 0.0F));
    this.cube_r36 = new ModelRenderer(this);
    this.cube_r36.setRotationPoint(2.8017F, 6.445F, -9.0F);
    this.face.addChild(this.cube_r36);
    setRotationAngle(this.cube_r36, 0.1745F, 0.0F, 0.2182F);
    this.cube_r36.cubeList.add(new ModelBox(this.cube_r36, 102, 42, 3.0F, -11.7224F, 1.463F, 3, 1, 3, 0.0F));
    this.cube_r36.cubeList.add(new ModelBox(this.cube_r36, 0, 29, 3.0F, -10.7224F, 2.463F, 3, 1, 0, 0.0F));
    this.cube_r37 = new ModelRenderer(this);
    this.cube_r37.setRotationPoint(-2.1098F, 8.6322F, -9.0F);
    this.face.addChild(this.cube_r37);
    setRotationAngle(this.cube_r37, 0.1745F, 0.0F, 0.3054F);
    this.cube_r37.cubeList.add(new ModelBox(this.cube_r37, 13, 13, -6.0F, -10.7224F, 2.463F, 3, 1, 0, 0.0F));
    this.cube_r37.cubeList.add(new ModelBox(this.cube_r37, 96, 63, -6.0F, -11.7224F, 1.463F, 3, 1, 3, 0.0F));
    this.cube_r38 = new ModelRenderer(this);
    this.cube_r38.setRotationPoint(6.1098F, 8.6322F, -9.0F);
    this.face.addChild(this.cube_r38);
    setRotationAngle(this.cube_r38, 0.1745F, 0.0F, -0.3054F);
    this.cube_r38.cubeList.add(new ModelBox(this.cube_r38, 8, 18, 3.0F, -10.7224F, 2.463F, 3, 1, 0, 0.0F));
    this.cube_r38.cubeList.add(new ModelBox(this.cube_r38, 118, 81, 3.0F, -11.7224F, 1.463F, 3, 1, 3, 0.0F));
    this.cube_r39 = new ModelRenderer(this);
    this.cube_r39.setRotationPoint(-2.0F, 8.0F, -9.0F);
    this.face.addChild(this.cube_r39);
    setRotationAngle(this.cube_r39, 0.1745F, 0.0F, 0.0F);
    this.cube_r39.cubeList.add(new ModelBox(this.cube_r39, 113, 145, -6.0F, -11.7224F, 1.463F, 1, 4, 3, 0.0F));
    this.cube_r39.cubeList.add(new ModelBox(this.cube_r39, 160, 103, 13.0F, -11.7224F, 1.463F, 1, 4, 3, 0.0F));
    this.cube_r39.cubeList.add(new ModelBox(this.cube_r39, 100, 38, -6.0F, -7.7224F, 1.463F, 3, 1, 3, 0.0F));
    this.cube_r39.cubeList.add(new ModelBox(this.cube_r39, 128, 96, 11.0F, -7.7224F, 1.463F, 3, 1, 3, 0.0F));
    this.cube_r40 = new ModelRenderer(this);
    this.cube_r40.setRotationPoint(-2.0F, 6.7793F, -7.0938F);
    this.face.addChild(this.cube_r40);
    setRotationAngle(this.cube_r40, 0.48F, 0.0F, 0.0F);
    this.cube_r40.cubeList.add(new ModelBox(this.cube_r40, 57, 0, -5.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r40.cubeList.add(new ModelBox(this.cube_r40, 80, 87, 12.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r41 = new ModelRenderer(this);
    this.cube_r41.setRotationPoint(-2.0F, 0.1234F, -12.4667F);
    this.face.addChild(this.cube_r41);
    setRotationAngle(this.cube_r41, 0.0436F, 0.0F, 0.0F);
    this.cube_r41.cubeList.add(new ModelBox(this.cube_r41, 56, 18, -5.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r41.cubeList.add(new ModelBox(this.cube_r41, 34, 67, 12.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r42 = new ModelRenderer(this);
    this.cube_r42.setRotationPoint(-2.0F, 2.1215F, -12.3795F);
    this.face.addChild(this.cube_r42);
    setRotationAngle(this.cube_r42, 0.0436F, 0.0F, 0.0F);
    this.cube_r42.cubeList.add(new ModelBox(this.cube_r42, 56, 21, -5.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r42.cubeList.add(new ModelBox(this.cube_r42, 0, 87, 12.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r43 = new ModelRenderer(this);
    this.cube_r43.setRotationPoint(-2.0F, 4.1787F, -10.5819F);
    this.face.addChild(this.cube_r43);
    setRotationAngle(this.cube_r43, 0.2618F, 0.0F, 0.0F);
    this.cube_r43.cubeList.add(new ModelBox(this.cube_r43, 56, 24, -5.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r43.cubeList.add(new ModelBox(this.cube_r43, 52, 87, 12.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r44 = new ModelRenderer(this);
    this.cube_r44.setRotationPoint(-2.0F, 4.3572F, -5.6745F);
    this.face.addChild(this.cube_r44);
    setRotationAngle(this.cube_r44, 0.8727F, 0.0F, 0.0F);
    this.cube_r44.cubeList.add(new ModelBox(this.cube_r44, 56, 27, -5.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r44.cubeList.add(new ModelBox(this.cube_r44, 0, 95, 12.0F, -7.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r45 = new ModelRenderer(this);
    this.cube_r45.setRotationPoint(6.0F, 6.0F, -9.0F);
    this.face.addChild(this.cube_r45);
    setRotationAngle(this.cube_r45, 0.1745F, 0.0F, 0.0F);
    this.cube_r45.cubeList.add(new ModelBox(this.cube_r45, 0, 28, -9.0F, -2.7224F, 2.463F, 10, 1, 0, 0.0F));
    this.cube_r46 = new ModelRenderer(this);
    this.cube_r46.setRotationPoint(-2.0F, 4.1481F, -11.6248F);
    this.face.addChild(this.cube_r46);
    setRotationAngle(this.cube_r46, -0.2182F, 0.0F, 0.0F);
    this.cube_r46.cubeList.add(new ModelBox(this.cube_r46, 0, 0, 0.0F, -2.7224F, 1.463F, 1, 3, 1, 0.0F));
    this.cube_r46.cubeList.add(new ModelBox(this.cube_r46, 0, 9, 7.0F, -2.7224F, 1.463F, 1, 3, 1, 0.0F));
    this.cube_r47 = new ModelRenderer(this);
    this.cube_r47.setRotationPoint(-2.0F, 2.7496F, -11.6611F);
    this.face.addChild(this.cube_r47);
    setRotationAngle(this.cube_r47, -0.4363F, 0.0F, 0.0F);
    this.cube_r47.cubeList.add(new ModelBox(this.cube_r47, 0, 70, 0.0F, -2.7224F, 1.463F, 1, 1, 1, 0.0F));
    this.cube_r47.cubeList.add(new ModelBox(this.cube_r47, 21, 70, 7.0F, -2.7224F, 1.463F, 1, 1, 1, 0.0F));
    this.cube_r48 = new ModelRenderer(this);
    this.cube_r48.setRotationPoint(-2.0F, 1.6607F, -11.3129F);
    this.face.addChild(this.cube_r48);
    setRotationAngle(this.cube_r48, -0.5236F, 0.0F, 0.0F);
    this.cube_r48.cubeList.add(new ModelBox(this.cube_r48, 57, 8, 0.0F, -3.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r48.cubeList.add(new ModelBox(this.cube_r48, 0, 67, 7.0F, -3.7224F, 1.463F, 1, 2, 1, 0.0F));
    this.cube_r49 = new ModelRenderer(this);
    this.cube_r49.setRotationPoint(-2.0F, 2.0F, -11.0F);
    this.face.addChild(this.cube_r49);
    setRotationAngle(this.cube_r49, 0.1745F, 0.0F, 0.0F);
    this.cube_r49.cubeList.add(new ModelBox(this.cube_r49, 20, 85, 0.0F, -2.7224F, 2.463F, 4, 2, 0, 0.0F));
    this.cube_r49.cubeList.add(new ModelBox(this.cube_r49, 28, 85, 4.0F, -2.7224F, 2.463F, 4, 2, 0, 0.0F));
    this.cube_r50 = new ModelRenderer(this);
    this.cube_r50.setRotationPoint(6.0F, 1.0F, -11.0F);
    this.face.addChild(this.cube_r50);
    setRotationAngle(this.cube_r50, 0.1745F, 0.0F, 0.0F);
    this.cube_r50.cubeList.add(new ModelBox(this.cube_r50, 0, 78, -8.0F, -2.7224F, 1.463F, 8, 2, 3, 0.0F));
    this.ssvv_r1 = new ModelRenderer(this);
    this.ssvv_r1.setRotationPoint(-3.669F, -1.0969F, -10.0469F);
    this.face.addChild(this.ssvv_r1);
    setRotationAngle(this.ssvv_r1, 0.5672F, 0.0436F, -1.1781F);
    this.ssvv_r1.cubeList.add(new ModelBox(this.ssvv_r1, 78, 92, -2.0F, -0.7072F, -0.3633F, 2, 1, 1, 0.0F));
    this.ssvv_r2 = new ModelRenderer(this);
    this.ssvv_r2.setRotationPoint(7.669F, -1.0969F, -10.0469F);
    this.face.addChild(this.ssvv_r2);
    setRotationAngle(this.ssvv_r2, 0.5672F, -0.0436F, 1.1781F);
    this.ssvv_r2.cubeList.add(new ModelBox(this.ssvv_r2, 10, 95, 0.0F, -0.7072F, -0.3633F, 2, 1, 1, 0.0F));
    this.ssvv_r3 = new ModelRenderer(this);
    this.ssvv_r3.setRotationPoint(-2.5368F, -1.9494F, -9.3869F);
    this.face.addChild(this.ssvv_r3);
    setRotationAngle(this.ssvv_r3, 0.4363F, -0.3927F, -0.7418F);
    this.ssvv_r3.cubeList.add(new ModelBox(this.ssvv_r3, 78, 94, -2.0F, -0.7072F, -0.3633F, 2, 1, 1, 0.0F));
    this.ssvv_r4 = new ModelRenderer(this);
    this.ssvv_r4.setRotationPoint(6.5368F, -1.9494F, -9.3869F);
    this.face.addChild(this.ssvv_r4);
    setRotationAngle(this.ssvv_r4, 0.4363F, 0.3927F, 0.7418F);
    this.ssvv_r4.cubeList.add(new ModelBox(this.ssvv_r4, 78, 96, 0.0F, -0.7072F, -0.3633F, 2, 1, 1, 0.0F));
    this.ssvv_r5 = new ModelRenderer(this);
    this.ssvv_r5.setRotationPoint(-2.0F, -2.0F, -9.0F);
    this.face.addChild(this.ssvv_r5);
    setRotationAngle(this.ssvv_r5, 0.1745F, -0.6109F, -0.2618F);
    this.ssvv_r5.cubeList.add(new ModelBox(this.ssvv_r5, 26, 69, -1.0F, -0.7072F, -0.3633F, 1, 1, 1, 0.0F));
    this.ssvv_r6 = new ModelRenderer(this);
    this.ssvv_r6.setRotationPoint(6.0F, -2.0F, -9.0F);
    this.face.addChild(this.ssvv_r6);
    setRotationAngle(this.ssvv_r6, 0.1745F, 0.6109F, 0.2618F);
    this.ssvv_r6.cubeList.add(new ModelBox(this.ssvv_r6, 52, 90, 0.0F, -0.7072F, -0.3633F, 1, 1, 1, 0.0F));
    this.cube_r51 = new ModelRenderer(this);
    this.cube_r51.setRotationPoint(6.0F, -7.0F, -9.0F);
    this.face.addChild(this.cube_r51);
    setRotationAngle(this.cube_r51, 0.1745F, 0.0F, 0.0F);
    this.cube_r51.cubeList.add(new ModelBox(this.cube_r51, 0, 87, -4.0F, -2.7224F, -0.537F, 3, 4, 4, 0.0F));
    this.cube_r51.cubeList.add(new ModelBox(this.cube_r51, 0, 95, -7.0F, -2.7224F, -0.537F, 3, 4, 4, 0.0F));
    this.cube_r52 = new ModelRenderer(this);
    this.cube_r52.setRotationPoint(-3.0F, -10.0F, -9.0F);
    this.face.addChild(this.cube_r52);
    setRotationAngle(this.cube_r52, 0.1745F, 0.0F, -0.5236F);
    this.cube_r52.cubeList.add(new ModelBox(this.cube_r52, 57, 8, -4.0F, -2.7224F, -0.537F, 4, 4, 4, 0.0F));
    this.main = new ModelRenderer(this);
    this.main.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.face.addChild(this.main);
    this.cube_r53 = new ModelRenderer(this);
    this.cube_r53.setRotationPoint(2.0F, -7.2216F, -5.7569F);
    this.main.addChild(this.cube_r53);
    setRotationAngle(this.cube_r53, 0.1745F, -0.1309F, 0.7854F);
    this.cube_r53.cubeList.add(new ModelBox(this.cube_r53, 62, 147, -10.0F, -9.8177F, -1.9162F, 23, 23, 5, 0.4F));
    this.cube_r53.cubeList.add(new ModelBox(this.cube_r53, 118, 148, -10.0F, -9.8177F, -1.9162F, 23, 23, 5, 0.0F));
    this.arm = new ModelRenderer(this);
    this.arm.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone.addChild(this.arm);
    this.armright = new ModelRenderer(this);
    this.armright.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.arm.addChild(this.armright);
    this.cube_r54 = new ModelRenderer(this);
    this.cube_r54.setRotationPoint(12.0966F, 3.2316F, -15.1763F);
    this.armright.addChild(this.cube_r54);
    setRotationAngle(this.cube_r54, 0.3491F, 0.3491F, -0.1745F);
    this.cube_r54.cubeList.add(new ModelBox(this.cube_r54, 124, 124, 1.0F, 3.9036F, 2.7582F, 2, 3, 4, 0.0F));
    this.cube_r55 = new ModelRenderer(this);
    this.cube_r55.setRotationPoint(12.9754F, 4.0766F, -16.0671F);
    this.armright.addChild(this.cube_r55);
    setRotationAngle(this.cube_r55, 0.3491F, 0.1309F, -0.1745F);
    this.cube_r55.cubeList.add(new ModelBox(this.cube_r55, 52, 87, 3.0F, 0.9036F, 2.7582F, 8, 6, 5, 0.0F));
    this.cube_r56 = new ModelRenderer(this);
    this.cube_r56.setRotationPoint(6.2589F, 1.449F, -14.5558F);
    this.armright.addChild(this.cube_r56);
    setRotationAngle(this.cube_r56, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r56.cubeList.add(new ModelBox(this.cube_r56, 87, 38, 10.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r57 = new ModelRenderer(this);
    this.cube_r57.setRotationPoint(9.1861F, 0.2318F, -14.5809F);
    this.armright.addChild(this.cube_r57);
    setRotationAngle(this.cube_r57, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r57.cubeList.add(new ModelBox(this.cube_r57, 14, 90, 10.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r58 = new ModelRenderer(this);
    this.cube_r58.setRotationPoint(6.2589F, 0.449F, -15.5558F);
    this.armright.addChild(this.cube_r58);
    setRotationAngle(this.cube_r58, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r58.cubeList.add(new ModelBox(this.cube_r58, 43, 156, 9.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r59 = new ModelRenderer(this);
    this.cube_r59.setRotationPoint(9.1861F, -0.7682F, -15.5809F);
    this.armright.addChild(this.cube_r59);
    setRotationAngle(this.cube_r59, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r59.cubeList.add(new ModelBox(this.cube_r59, 51, 156, 9.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r60 = new ModelRenderer(this);
    this.cube_r60.setRotationPoint(6.7106F, 0.0154F, -11.6051F);
    this.armright.addChild(this.cube_r60);
    setRotationAngle(this.cube_r60, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r60.cubeList.add(new ModelBox(this.cube_r60, 56, 127, 9.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.cube_r61 = new ModelRenderer(this);
    this.cube_r61.setRotationPoint(9.6378F, -1.2019F, -11.6302F);
    this.armright.addChild(this.cube_r61);
    setRotationAngle(this.cube_r61, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r61.cubeList.add(new ModelBox(this.cube_r61, 100, 130, 9.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.cube_r62 = new ModelRenderer(this);
    this.cube_r62.setRotationPoint(14.7419F, 0.024F, 2.4924F);
    this.armright.addChild(this.cube_r62);
    setRotationAngle(this.cube_r62, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r62.cubeList.add(new ModelBox(this.cube_r62, 132, 0, 2.0F, -9.0964F, -1.2418F, 17, 21, 0, 0.0F));
    this.cube_r62.cubeList.add(new ModelBox(this.cube_r62, 155, 157, 3.0F, 0.9036F, -11.2418F, 8, 7, 19, 0.0F));
    this.cube_r63 = new ModelRenderer(this);
    this.cube_r63.setRotationPoint(12.0F, -17.0F, 1.0F);
    this.armright.addChild(this.cube_r63);
    setRotationAngle(this.cube_r63, 0.1745F, 0.0F, 0.829F);
    this.cube_r63.cubeList.add(new ModelBox(this.cube_r63, 120, 74, 0.0F, 0.9036F, -5.2418F, 21, 9, 13, 0.0F));
    this.bone3 = new ModelRenderer(this);
    this.bone3.setRotationPoint(23.0F, 2.0F, -14.0F);
    this.armright.addChild(this.bone3);
    setRotationAngle(this.bone3, 0.0F, -0.2182F, 0.0F);
    this.cube_r64 = new ModelRenderer(this);
    this.cube_r64.setRotationPoint(-10.8139F, -1.7682F, -0.5809F);
    this.bone3.addChild(this.cube_r64);
    setRotationAngle(this.cube_r64, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r64.cubeList.add(new ModelBox(this.cube_r64, 14, 92, 10.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r65 = new ModelRenderer(this);
    this.cube_r65.setRotationPoint(-10.8139F, -2.7682F, -1.5809F);
    this.bone3.addChild(this.cube_r65);
    setRotationAngle(this.cube_r65, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r65.cubeList.add(new ModelBox(this.cube_r65, 160, 96, 9.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r66 = new ModelRenderer(this);
    this.cube_r66.setRotationPoint(-10.3622F, -3.2019F, 2.3698F);
    this.bone3.addChild(this.cube_r66);
    setRotationAngle(this.cube_r66, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r66.cubeList.add(new ModelBox(this.cube_r66, 0, 131, 9.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.bone4 = new ModelRenderer(this);
    this.bone4.setRotationPoint(18.0F, 4.0F, -10.0F);
    this.armright.addChild(this.bone4);
    setRotationAngle(this.bone4, 0.0F, 0.4363F, 0.1745F);
    this.cube_r67 = new ModelRenderer(this);
    this.cube_r67.setRotationPoint(-11.5495F, -1.5143F, -0.7796F);
    this.bone4.addChild(this.cube_r67);
    setRotationAngle(this.cube_r67, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r67.cubeList.add(new ModelBox(this.cube_r67, 73, 87, 9.9745F, 8.9031F, -3.2583F, 1, 2, 0, 0.0F));
    this.cube_r68 = new ModelRenderer(this);
    this.cube_r68.setRotationPoint(-11.5495F, -2.5143F, -1.7796F);
    this.bone4.addChild(this.cube_r68);
    setRotationAngle(this.cube_r68, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r68.cubeList.add(new ModelBox(this.cube_r68, 35, 156, 8.9745F, 5.9031F, -3.2583F, 2, 5, 2, 0.0F));
    this.cube_r69 = new ModelRenderer(this);
    this.cube_r69.setRotationPoint(-11.0978F, -2.9479F, 2.1711F);
    this.bone4.addChild(this.cube_r69);
    setRotationAngle(this.cube_r69, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r69.cubeList.add(new ModelBox(this.cube_r69, 128, 131, 8.9745F, 5.9031F, -5.2583F, 2, 3, 2, 0.0F));
    this.armleft = new ModelRenderer(this);
    this.armleft.setRotationPoint(4.0F, 0.0F, 0.0F);
    this.arm.addChild(this.armleft);
    this.cube_r70 = new ModelRenderer(this);
    this.cube_r70.setRotationPoint(-12.0966F, 3.2316F, -15.1763F);
    this.armleft.addChild(this.cube_r70);
    setRotationAngle(this.cube_r70, 0.3491F, -0.3491F, 0.1745F);
    this.cube_r70.cubeList.add(new ModelBox(this.cube_r70, 24, 124, -3.0F, 3.9036F, 2.7582F, 2, 3, 4, 0.0F));
    this.cube_r71 = new ModelRenderer(this);
    this.cube_r71.setRotationPoint(-12.9754F, 4.0766F, -16.0671F);
    this.armleft.addChild(this.cube_r71);
    setRotationAngle(this.cube_r71, 0.3491F, -0.1309F, 0.1745F);
    this.cube_r71.cubeList.add(new ModelBox(this.cube_r71, 0, 67, -11.0F, 0.9036F, 2.7582F, 8, 6, 5, 0.0F));
    this.cube_r72 = new ModelRenderer(this);
    this.cube_r72.setRotationPoint(-6.2589F, 1.449F, -14.5558F);
    this.armleft.addChild(this.cube_r72);
    setRotationAngle(this.cube_r72, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r72.cubeList.add(new ModelBox(this.cube_r72, 10, 87, -11.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r73 = new ModelRenderer(this);
    this.cube_r73.setRotationPoint(-9.1861F, 0.2318F, -14.5809F);
    this.armleft.addChild(this.cube_r73);
    setRotationAngle(this.cube_r73, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r73.cubeList.add(new ModelBox(this.cube_r73, 14, 87, -11.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r74 = new ModelRenderer(this);
    this.cube_r74.setRotationPoint(-6.2589F, 0.449F, -15.5558F);
    this.armleft.addChild(this.cube_r74);
    setRotationAngle(this.cube_r74, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r74.cubeList.add(new ModelBox(this.cube_r74, 0, 156, -11.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r75 = new ModelRenderer(this);
    this.cube_r75.setRotationPoint(-9.1861F, -0.7682F, -15.5809F);
    this.armleft.addChild(this.cube_r75);
    setRotationAngle(this.cube_r75, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r75.cubeList.add(new ModelBox(this.cube_r75, 8, 156, -11.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r76 = new ModelRenderer(this);
    this.cube_r76.setRotationPoint(-6.7106F, 0.0154F, -11.6051F);
    this.armleft.addChild(this.cube_r76);
    setRotationAngle(this.cube_r76, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r76.cubeList.add(new ModelBox(this.cube_r76, 36, 124, -11.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.cube_r77 = new ModelRenderer(this);
    this.cube_r77.setRotationPoint(-9.6378F, -1.2019F, -11.6302F);
    this.armleft.addChild(this.cube_r77);
    setRotationAngle(this.cube_r77, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r77.cubeList.add(new ModelBox(this.cube_r77, 48, 124, -11.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.cube_r78 = new ModelRenderer(this);
    this.cube_r78.setRotationPoint(-14.7419F, 0.024F, 2.4924F);
    this.armleft.addChild(this.cube_r78);
    setRotationAngle(this.cube_r78, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r78.cubeList.add(new ModelBox(this.cube_r78, 0, 156, -11.0F, 0.9036F, -11.2418F, 8, 7, 19, 0.0F));
    this.cube_r79 = new ModelRenderer(this);
    this.cube_r79.setRotationPoint(-22.0F, -17.0F, 1.0F);
    this.armleft.addChild(this.cube_r79);
    setRotationAngle(this.cube_r79, 0.1745F, 0.0F, -0.829F);
    this.cube_r79.cubeList.add(new ModelBox(this.cube_r79, 0, 19, -21.0F, 0.9036F, -6.2418F, 21, 9, 0, 0.0F));
    this.cube_r80 = new ModelRenderer(this);
    this.cube_r80.setRotationPoint(-12.0F, -17.0F, 1.0F);
    this.armleft.addChild(this.cube_r80);
    setRotationAngle(this.cube_r80, 0.1745F, 0.0F, -0.829F);
    this.cube_r80.cubeList.add(new ModelBox(this.cube_r80, 118, 52, -21.0F, 0.9036F, -5.2418F, 21, 9, 13, 0.0F));
    this.bone5 = new ModelRenderer(this);
    this.bone5.setRotationPoint(-23.0F, 2.0F, -14.0F);
    this.armleft.addChild(this.bone5);
    setRotationAngle(this.bone5, 0.0F, 0.2182F, 0.0F);
    this.cube_r81 = new ModelRenderer(this);
    this.cube_r81.setRotationPoint(10.8139F, -1.7682F, -0.5809F);
    this.bone5.addChild(this.cube_r81);
    setRotationAngle(this.cube_r81, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r81.cubeList.add(new ModelBox(this.cube_r81, 36, 85, -11.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r82 = new ModelRenderer(this);
    this.cube_r82.setRotationPoint(10.8139F, -2.7682F, -1.5809F);
    this.bone5.addChild(this.cube_r82);
    setRotationAngle(this.cube_r82, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r82.cubeList.add(new ModelBox(this.cube_r82, 152, 110, -11.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r83 = new ModelRenderer(this);
    this.cube_r83.setRotationPoint(10.3622F, -3.2019F, 2.3698F);
    this.bone5.addChild(this.cube_r83);
    setRotationAngle(this.cube_r83, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r83.cubeList.add(new ModelBox(this.cube_r83, 12, 124, -11.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.bone6 = new ModelRenderer(this);
    this.bone6.setRotationPoint(-18.0F, 4.0F, -10.0F);
    this.armleft.addChild(this.bone6);
    setRotationAngle(this.bone6, 0.0F, -0.4363F, -0.1745F);
    this.cube_r84 = new ModelRenderer(this);
    this.cube_r84.setRotationPoint(11.5495F, -1.5143F, -0.7796F);
    this.bone6.addChild(this.cube_r84);
    setRotationAngle(this.cube_r84, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r84.cubeList.add(new ModelBox(this.cube_r84, 0, 83, -10.9745F, 8.9031F, -3.2583F, 1, 2, 0, 0.0F));
    this.cube_r85 = new ModelRenderer(this);
    this.cube_r85.setRotationPoint(11.5495F, -2.5143F, -1.7796F);
    this.bone6.addChild(this.cube_r85);
    setRotationAngle(this.cube_r85, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r85.cubeList.add(new ModelBox(this.cube_r85, 152, 103, -10.9745F, 5.9031F, -3.2583F, 2, 5, 2, 0.0F));
    this.cube_r86 = new ModelRenderer(this);
    this.cube_r86.setRotationPoint(11.0978F, -2.9479F, 2.1711F);
    this.bone6.addChild(this.cube_r86);
    setRotationAngle(this.cube_r86, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r86.cubeList.add(new ModelBox(this.cube_r86, 120, 131, -10.9745F, 5.9031F, -5.2583F, 2, 3, 2, 0.0F));
    this.leg = new ModelRenderer(this);
    this.leg.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone.addChild(this.leg);
    this.legright = new ModelRenderer(this);
    this.legright.setRotationPoint(0.0F, 0.0F, 43.0F);
    this.leg.addChild(this.legright);
    this.cube_r87 = new ModelRenderer(this);
    this.cube_r87.setRotationPoint(8.4761F, 0.8661F, 1.2671F);
    this.legright.addChild(this.cube_r87);
    setRotationAngle(this.cube_r87, -0.2182F, 0.1745F, -0.2182F);
    this.cube_r87.cubeList.add(new ModelBox(this.cube_r87, 0, 0, 3.0F, 6.9036F, -7.2418F, 19, 0, 19, 0.0F));
    this.cube_r87.cubeList.add(new ModelBox(this.cube_r87, 43, 175, 3.0F, -3.0964F, -3.2418F, 7, 15, 11, 0.0F));
    this.cube_r88 = new ModelRenderer(this);
    this.cube_r88.setRotationPoint(12.0F, -17.0F, 1.0F);
    this.legright.addChild(this.cube_r88);
    setRotationAngle(this.cube_r88, 0.1745F, 0.0F, 1.0472F);
    this.cube_r88.cubeList.add(new ModelBox(this.cube_r88, 53, 123, 0.0F, 0.9036F, -7.2418F, 16, 9, 15, 0.0F));
    this.bone9 = new ModelRenderer(this);
    this.bone9.setRotationPoint(19.0F, 9.0F, -8.0F);
    this.legright.addChild(this.bone9);
    this.cube_r89 = new ModelRenderer(this);
    this.cube_r89.setRotationPoint(-17.8332F, 0.1425F, 3.8056F);
    this.bone9.addChild(this.cube_r89);
    setRotationAngle(this.cube_r89, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r89.cubeList.add(new ModelBox(this.cube_r89, 40, 28, 9.9745F, 8.9031F, -3.2583F, 1, 2, 0, 0.0F));
    this.cube_r90 = new ModelRenderer(this);
    this.cube_r90.setRotationPoint(-17.8332F, -0.8575F, 2.8056F);
    this.bone9.addChild(this.cube_r90);
    setRotationAngle(this.cube_r90, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r90.cubeList.add(new ModelBox(this.cube_r90, 47, 131, 8.9745F, 5.9031F, -3.2583F, 2, 5, 2, 0.0F));
    this.cube_r91 = new ModelRenderer(this);
    this.cube_r91.setRotationPoint(-17.3815F, -1.2912F, 6.7563F);
    this.bone9.addChild(this.cube_r91);
    setRotationAngle(this.cube_r91, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r91.cubeList.add(new ModelBox(this.cube_r91, 120, 52, 8.9745F, 5.9031F, -5.2583F, 2, 3, 2, 0.0F));
    this.cube_r92 = new ModelRenderer(this);
    this.cube_r92.setRotationPoint(-10.8139F, -1.7682F, -0.5809F);
    this.bone9.addChild(this.cube_r92);
    setRotationAngle(this.cube_r92, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r92.cubeList.add(new ModelBox(this.cube_r92, 57, 16, 10.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r93 = new ModelRenderer(this);
    this.cube_r93.setRotationPoint(-10.8139F, -2.7682F, -1.5809F);
    this.bone9.addChild(this.cube_r93);
    setRotationAngle(this.cube_r93, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r93.cubeList.add(new ModelBox(this.cube_r93, 136, 100, 9.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r94 = new ModelRenderer(this);
    this.cube_r94.setRotationPoint(-10.3622F, -3.2019F, 2.3698F);
    this.bone9.addChild(this.cube_r94);
    setRotationAngle(this.cube_r94, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r94.cubeList.add(new ModelBox(this.cube_r94, 26, 67, 9.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.cube_r95 = new ModelRenderer(this);
    this.cube_r95.setRotationPoint(-10.9034F, 1.2316F, -1.1763F);
    this.bone9.addChild(this.cube_r95);
    setRotationAngle(this.cube_r95, 0.3491F, 0.3491F, -0.1745F);
    this.cube_r95.cubeList.add(new ModelBox(this.cube_r95, 116, 0, 1.0F, 3.9036F, 2.7582F, 2, 3, 4, 0.0F));
    this.cube_r96 = new ModelRenderer(this);
    this.cube_r96.setRotationPoint(-10.0246F, 2.0766F, -2.0671F);
    this.bone9.addChild(this.cube_r96);
    setRotationAngle(this.cube_r96, 0.1309F, 0.1309F, -0.1745F);
    this.cube_r96.cubeList.add(new ModelBox(this.cube_r96, 175, 61, 3.1722F, -0.0698F, 2.9092F, 8, 6, 13, 0.0F));
    this.cube_r97 = new ModelRenderer(this);
    this.cube_r97.setRotationPoint(-16.7411F, -0.551F, -0.5558F);
    this.bone9.addChild(this.cube_r97);
    setRotationAngle(this.cube_r97, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r97.cubeList.add(new ModelBox(this.cube_r97, 60, 38, 10.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r98 = new ModelRenderer(this);
    this.cube_r98.setRotationPoint(-13.8139F, -1.7682F, -0.5809F);
    this.bone9.addChild(this.cube_r98);
    setRotationAngle(this.cube_r98, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r98.cubeList.add(new ModelBox(this.cube_r98, 27, 67, 10.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r99 = new ModelRenderer(this);
    this.cube_r99.setRotationPoint(-16.7411F, -1.551F, -1.5558F);
    this.bone9.addChild(this.cube_r99);
    setRotationAngle(this.cube_r99, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r99.cubeList.add(new ModelBox(this.cube_r99, 136, 107, 9.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r100 = new ModelRenderer(this);
    this.cube_r100.setRotationPoint(-13.8139F, -2.7682F, -1.5809F);
    this.bone9.addChild(this.cube_r100);
    setRotationAngle(this.cube_r100, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r100.cubeList.add(new ModelBox(this.cube_r100, 0, 138, 9.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r101 = new ModelRenderer(this);
    this.cube_r101.setRotationPoint(-16.2894F, -1.9846F, 2.3949F);
    this.bone9.addChild(this.cube_r101);
    setRotationAngle(this.cube_r101, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r101.cubeList.add(new ModelBox(this.cube_r101, 116, 7, 9.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.cube_r102 = new ModelRenderer(this);
    this.cube_r102.setRotationPoint(-13.3622F, -3.2019F, 2.3698F);
    this.bone9.addChild(this.cube_r102);
    setRotationAngle(this.cube_r102, 0.0873F, 0.1309F, -0.1745F);
    this.cube_r102.cubeList.add(new ModelBox(this.cube_r102, 118, 74, 9.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.bone10 = new ModelRenderer(this);
    this.bone10.setRotationPoint(18.0F, 4.0F, -10.0F);
    this.legright.addChild(this.bone10);
    setRotationAngle(this.bone10, 0.0F, 0.4363F, 0.1745F);
    this.legleft = new ModelRenderer(this);
    this.legleft.setRotationPoint(4.0F, 0.0F, 43.0F);
    this.leg.addChild(this.legleft);
    this.cube_r103 = new ModelRenderer(this);
    this.cube_r103.setRotationPoint(-15.4761F, 0.8661F, 1.2671F);
    this.legleft.addChild(this.cube_r103);
    setRotationAngle(this.cube_r103, -0.2182F, -0.1745F, 0.2182F);
    this.cube_r103.cubeList.add(new ModelBox(this.cube_r103, 31, 19, -10.0F, 5.9036F, -3.2418F, 7, 0, 11, 0.0F));
    this.cube_r104 = new ModelRenderer(this);
    this.cube_r104.setRotationPoint(-8.4761F, 0.8661F, 1.2671F);
    this.legleft.addChild(this.cube_r104);
    setRotationAngle(this.cube_r104, -0.2182F, -0.1745F, 0.2182F);
    this.cube_r104.cubeList.add(new ModelBox(this.cube_r104, 79, 175, -10.0F, -3.0964F, -3.2418F, 7, 15, 11, 0.0F));
    this.cube_r105 = new ModelRenderer(this);
    this.cube_r105.setRotationPoint(-12.0F, -17.0F, 1.0F);
    this.legleft.addChild(this.cube_r105);
    setRotationAngle(this.cube_r105, 0.1745F, 0.0F, -1.0472F);
    this.cube_r105.cubeList.add(new ModelBox(this.cube_r105, 0, 132, -16.0F, 0.9036F, -7.2418F, 16, 9, 15, 0.0F));
    this.bone7 = new ModelRenderer(this);
    this.bone7.setRotationPoint(-19.0F, 9.0F, -8.0F);
    this.legleft.addChild(this.bone7);
    this.cube_r106 = new ModelRenderer(this);
    this.cube_r106.setRotationPoint(17.8332F, 0.1425F, 3.8056F);
    this.bone7.addChild(this.cube_r106);
    setRotationAngle(this.cube_r106, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r106.cubeList.add(new ModelBox(this.cube_r106, 36, 74, -10.9745F, 8.9031F, -3.2583F, 1, 2, 0, 0.0F));
    this.cube_r107 = new ModelRenderer(this);
    this.cube_r107.setRotationPoint(17.8332F, -0.8575F, 2.8056F);
    this.bone7.addChild(this.cube_r107);
    setRotationAngle(this.cube_r107, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r107.cubeList.add(new ModelBox(this.cube_r107, 144, 96, -10.9745F, 5.9031F, -3.2583F, 2, 5, 2, 0.0F));
    this.cube_r108 = new ModelRenderer(this);
    this.cube_r108.setRotationPoint(17.3815F, -1.2912F, 6.7563F);
    this.bone7.addChild(this.cube_r108);
    setRotationAngle(this.cube_r108, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r108.cubeList.add(new ModelBox(this.cube_r108, 112, 130, -10.9745F, 5.9031F, -5.2583F, 2, 3, 2, 0.0F));
    this.cube_r109 = new ModelRenderer(this);
    this.cube_r109.setRotationPoint(10.8139F, -1.7682F, -0.5809F);
    this.bone7.addChild(this.cube_r109);
    setRotationAngle(this.cube_r109, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r109.cubeList.add(new ModelBox(this.cube_r109, 0, 78, -11.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r110 = new ModelRenderer(this);
    this.cube_r110.setRotationPoint(10.8139F, -2.7682F, -1.5809F);
    this.bone7.addChild(this.cube_r110);
    setRotationAngle(this.cube_r110, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r110.cubeList.add(new ModelBox(this.cube_r110, 144, 103, -11.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r111 = new ModelRenderer(this);
    this.cube_r111.setRotationPoint(10.3622F, -3.2019F, 2.3698F);
    this.bone7.addChild(this.cube_r111);
    setRotationAngle(this.cube_r111, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r111.cubeList.add(new ModelBox(this.cube_r111, 120, 96, -11.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.cube_r112 = new ModelRenderer(this);
    this.cube_r112.setRotationPoint(10.9034F, 1.2316F, -1.1763F);
    this.bone7.addChild(this.cube_r112);
    setRotationAngle(this.cube_r112, 0.3491F, -0.3491F, 0.1745F);
    this.cube_r112.cubeList.add(new ModelBox(this.cube_r112, 100, 123, -3.0F, 3.9036F, 2.7582F, 2, 3, 4, 0.0F));
    this.cube_r113 = new ModelRenderer(this);
    this.cube_r113.setRotationPoint(10.0246F, 2.0766F, -2.0671F);
    this.bone7.addChild(this.cube_r113);
    setRotationAngle(this.cube_r113, 0.1309F, -0.1309F, 0.1745F);
    this.cube_r113.cubeList.add(new ModelBox(this.cube_r113, 115, 176, -11.1722F, -0.0698F, 2.9092F, 8, 6, 13, 0.0F));
    this.cube_r114 = new ModelRenderer(this);
    this.cube_r114.setRotationPoint(16.7411F, -0.551F, -0.5558F);
    this.bone7.addChild(this.cube_r114);
    setRotationAngle(this.cube_r114, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r114.cubeList.add(new ModelBox(this.cube_r114, 19, 78, -11.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r115 = new ModelRenderer(this);
    this.cube_r115.setRotationPoint(13.8139F, -1.7682F, -0.5809F);
    this.bone7.addChild(this.cube_r115);
    setRotationAngle(this.cube_r115, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r115.cubeList.add(new ModelBox(this.cube_r115, 82, 42, -11.0F, 7.9036F, -3.2418F, 1, 2, 0, 0.0F));
    this.cube_r116 = new ModelRenderer(this);
    this.cube_r116.setRotationPoint(16.7411F, -1.551F, -1.5558F);
    this.bone7.addChild(this.cube_r116);
    setRotationAngle(this.cube_r116, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r116.cubeList.add(new ModelBox(this.cube_r116, 144, 110, -11.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r117 = new ModelRenderer(this);
    this.cube_r117.setRotationPoint(13.8139F, -2.7682F, -1.5809F);
    this.bone7.addChild(this.cube_r117);
    setRotationAngle(this.cube_r117, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r117.cubeList.add(new ModelBox(this.cube_r117, 152, 96, -11.0F, 4.9036F, -3.2418F, 2, 5, 2, 0.0F));
    this.cube_r118 = new ModelRenderer(this);
    this.cube_r118.setRotationPoint(16.2894F, -1.9846F, 2.3949F);
    this.bone7.addChild(this.cube_r118);
    setRotationAngle(this.cube_r118, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r118.cubeList.add(new ModelBox(this.cube_r118, 112, 123, -11.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.cube_r119 = new ModelRenderer(this);
    this.cube_r119.setRotationPoint(13.3622F, -3.2019F, 2.3698F);
    this.bone7.addChild(this.cube_r119);
    setRotationAngle(this.cube_r119, 0.0873F, -0.1309F, 0.1745F);
    this.cube_r119.cubeList.add(new ModelBox(this.cube_r119, 0, 124, -11.0F, 4.9036F, -5.2418F, 2, 3, 4, 0.0F));
    this.bone8 = new ModelRenderer(this);
    this.bone8.setRotationPoint(-18.0F, 4.0F, -10.0F);
    this.legleft.addChild(this.bone8);
    setRotationAngle(this.bone8, 0.0F, -0.4363F, -0.1745F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.bone.render(f5);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    EntityLivingBase entity = (EntityLivingBase)ent;
    this.legleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
    this.legright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.8F * limbSwingAmount;
    this.armright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
    this.armleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
    if (entity.isSwingInProgress) {
      this.armright.rotateAngleX = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * 1.2F;
      this.armright.rotateAngleY = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * -0.2F;
      this.armright.rotateAngleZ = -MathHelper.cos(entity.swingProgress * 4.0F + 3.1415927F) * 0.5F;
    } 
    if (ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) <= 0.05000000074505806D && !entity.isSwingInProgress) {
      this.armright.rotateAngleX = 0.0F;
      this.armright.rotateAngleY = 0.0F;
      this.armright.rotateAngleZ = 0.025F;
    } else if (!entity.isSwingInProgress && ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) > 0.0D) {
      this.armright.rotateAngleY = 0.0F;
      this.armright.rotateAngleZ = 0.025F;
    } 
  }
  
  public ModelRenderer getHandRenderer() {
    return null;
  }
}
