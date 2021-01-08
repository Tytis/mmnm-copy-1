package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class hybridleopard extends ModelZoanMorph {
  private final ModelRenderer head;
  
  private final ModelRenderer cube_r1;
  
  private final ModelRenderer cube_r2;
  
  private final ModelRenderer cube_r3;
  
  private final ModelRenderer cube_r4;
  
  private final ModelRenderer cube_r5;
  
  private final ModelRenderer cube_r7;
  
  private final ModelRenderer cube_r6;
  
  private final ModelRenderer cube_r8;
  
  private final ModelRenderer body;
  
  private final ModelRenderer cube_r9;
  
  private final ModelRenderer legs;
  
  private final ModelRenderer leftleg;
  
  private final ModelRenderer bone2;
  
  private final ModelRenderer cube_r10;
  
  private final ModelRenderer bone3;
  
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
  
  private final ModelRenderer rightleg;
  
  private final ModelRenderer bone8;
  
  private final ModelRenderer cube_r21;
  
  private final ModelRenderer bone9;
  
  private final ModelRenderer cube_r22;
  
  private final ModelRenderer cube_r23;
  
  private final ModelRenderer cube_r24;
  
  private final ModelRenderer cube_r25;
  
  private final ModelRenderer cube_r26;
  
  private final ModelRenderer cube_r27;
  
  private final ModelRenderer cube_r28;
  
  private final ModelRenderer cube_r29;
  
  private final ModelRenderer cube_r30;
  
  private final ModelRenderer cube_r31;
  
  private final ModelRenderer arm;
  
  private final ModelRenderer armleft;
  
  private final ModelRenderer bone5;
  
  private final ModelRenderer bone6;
  
  private final ModelRenderer cube_r32;
  
  private final ModelRenderer cube_r33;
  
  private final ModelRenderer cube_r34;
  
  private final ModelRenderer cube_r35;
  
  private final ModelRenderer armright;
  
  private final ModelRenderer bone4;
  
  private final ModelRenderer bone7;
  
  private final ModelRenderer cube_r36;
  
  private final ModelRenderer cube_r37;
  
  private final ModelRenderer cube_r38;
  
  private final ModelRenderer cube_r39;
  
  private final ModelRenderer tail;
  
  private final ModelRenderer cube_r40;
  
  private final ModelRenderer bone10;
  
  private final ModelRenderer cube_r41;
  
  private final ModelRenderer bone11;
  
  private final ModelRenderer cube_r42;
  
  private final ModelRenderer bone12;
  
  private final ModelRenderer cube_r43;
  
  private final ModelRenderer cube_r44;
  
  private final ModelRenderer cube_r45;
  
  private final ModelRenderer cube_r46;
  
  private final ModelRenderer cube_r47;
  
  public hybridleopard() {
    this.textureWidth = 128;
    this.textureHeight = 128;
    this.head = new ModelRenderer(this);
    this.head.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.head.cubeList.add(new ModelBox(this.head, 76, 4, -3.0F, -55.0F, -8.0F, 6, 7, 8, 0.0F));
    this.head.cubeList.add(new ModelBox(this.head, 0, 62, -3.0F, -57.0F, -3.0F, 6, 17, 9, 0.0F));
    this.head.cubeList.add(new ModelBox(this.head, 102, 16, -3.0F, -51.0F, -11.0F, 6, 2, 3, 0.0F));
    this.head.cubeList.add(new ModelBox(this.head, 85, 75, -1.0F, -52.0F, -11.0F, 2, 1, 3, 0.0F));
    this.cube_r1 = new ModelRenderer(this);
    this.cube_r1.setRotationPoint(0.0F, -52.4045F, -0.0443F);
    this.head.addChild(this.cube_r1);
    setRotationAngle(this.cube_r1, 0.2182F, 0.0F, 0.0F);
    this.cube_r1.cubeList.add(new ModelBox(this.cube_r1, 76, 0, -3.0F, -1.0F, -11.0F, 6, 1, 3, 0.0F));
    this.cube_r2 = new ModelRenderer(this);
    this.cube_r2.setRotationPoint(0.0F, -49.0F, -8.0F);
    this.head.addChild(this.cube_r2);
    setRotationAngle(this.cube_r2, 0.0873F, 0.0F, 0.0F);
    this.cube_r2.cubeList.add(new ModelBox(this.cube_r2, 15, 88, -2.0F, 0.0F, -3.0F, 4, 1, 3, 0.0F));
    this.cube_r3 = new ModelRenderer(this);
    this.cube_r3.setRotationPoint(-2.2383F, -48.5517F, 0.4466F);
    this.head.addChild(this.cube_r3);
    setRotationAngle(this.cube_r3, 0.0F, 0.0873F, -0.6109F);
    this.cube_r3.cubeList.add(new ModelBox(this.cube_r3, 48, 0, -6.0F, -4.0F, -8.0F, 10, 4, 8, 0.0F));
    this.cube_r4 = new ModelRenderer(this);
    this.cube_r4.setRotationPoint(-2.2383F, -52.5517F, 4.4466F);
    this.head.addChild(this.cube_r4);
    setRotationAngle(this.cube_r4, 0.0F, 0.0873F, -0.6109F);
    this.cube_r4.cubeList.add(new ModelBox(this.cube_r4, 0, 40, -8.0F, -3.0F, -7.0F, 12, 14, 8, 0.0F));
    this.cube_r5 = new ModelRenderer(this);
    this.cube_r5.setRotationPoint(2.2383F, -52.5517F, 4.4466F);
    this.head.addChild(this.cube_r5);
    setRotationAngle(this.cube_r5, 0.0F, -0.0873F, 0.6109F);
    this.cube_r5.cubeList.add(new ModelBox(this.cube_r5, 40, 40, -4.0F, -3.0F, -7.0F, 12, 14, 8, 0.0F));
    this.cube_r7 = new ModelRenderer(this);
    this.cube_r7.setRotationPoint(1.2679F, -54.0F, 0.0F);
    this.head.addChild(this.cube_r7);
    setRotationAngle(this.cube_r7, 0.0F, 0.0F, 0.5236F);
    this.cube_r7.cubeList.add(new ModelBox(this.cube_r7, 48, 4, -1.0F, -3.0F, -5.0F, 3, 3, 1, 0.0F));
    this.cube_r6 = new ModelRenderer(this);
    this.cube_r6.setRotationPoint(2.2383F, -48.5517F, 0.4466F);
    this.head.addChild(this.cube_r6);
    setRotationAngle(this.cube_r6, 0.0F, -0.0873F, 0.6109F);
    this.cube_r6.cubeList.add(new ModelBox(this.cube_r6, 30, 62, -4.0F, -4.0F, -8.0F, 10, 4, 8, 0.0F));
    this.cube_r8 = new ModelRenderer(this);
    this.cube_r8.setRotationPoint(-1.2679F, -54.0F, 0.0F);
    this.head.addChild(this.cube_r8);
    setRotationAngle(this.cube_r8, 0.0F, 0.0F, -0.5236F);
    this.cube_r8.cubeList.add(new ModelBox(this.cube_r8, 0, 62, -2.0F, -3.0F, -5.0F, 3, 3, 1, 0.0F));
    this.body = new ModelRenderer(this);
    this.body.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.body.cubeList.add(new ModelBox(this.body, 0, 0, -9.0F, -48.0F, -7.0F, 18, 9, 12, 0.0F));
    this.body.cubeList.add(new ModelBox(this.body, 0, 21, -8.0F, -39.0F, -5.0F, 16, 10, 9, 0.0F));
    this.body.cubeList.add(new ModelBox(this.body, 50, 21, -7.0F, -29.0F, -5.0F, 14, 4, 9, 0.0F));
    this.cube_r9 = new ModelRenderer(this);
    this.cube_r9.setRotationPoint(-7.0F, -25.0F, 5.0F);
    this.body.addChild(this.cube_r9);
    setRotationAngle(this.cube_r9, 0.4363F, 0.0F, 0.0F);
    this.cube_r9.cubeList.add(new ModelBox(this.cube_r9, 0, 124, 0.0F, -0.4226F, -4.2942F, 14, -2, 3, 0.0F));
    this.legs = new ModelRenderer(this);
    this.legs.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.leftleg = new ModelRenderer(this);
    this.leftleg.setRotationPoint(-4.0F, -24.0F, -3.0F);
    this.legs.addChild(this.leftleg);
    setRotationAngle(this.leftleg, 0.1309F, 0.0F, 0.1309F);
    this.leftleg.cubeList.add(new ModelBox(this.leftleg, 80, 34, -3.0F, -2.0F, -2.0F, 7, 13, 6, 0.0F));
    this.bone2 = new ModelRenderer(this);
    this.bone2.setRotationPoint(6.0F, 23.7389F, 1.0171F);
    this.leftleg.addChild(this.bone2);
    this.bone2.cubeList.add(new ModelBox(this.bone2, 96, 0, -9.0F, -17.7389F, 2.9829F, 6, 5, 3, 0.0F));
    this.cube_r10 = new ModelRenderer(this);
    this.cube_r10.setRotationPoint(-8.6043F, -17.322F, 6.5493F);
    this.bone2.addChild(this.cube_r10);
    setRotationAngle(this.cube_r10, -0.3491F, 0.0F, -0.0436F);
    this.cube_r10.cubeList.add(new ModelBox(this.cube_r10, 99, 78, -0.3762F, 16.7451F, -0.6956F, 5, 2, 4, 0.0F));
    this.cube_r10.cubeList.add(new ModelBox(this.cube_r10, 22, 92, -0.3762F, -0.2549F, -0.6956F, 5, 17, 4, 0.0F));
    this.bone3 = new ModelRenderer(this);
    this.bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone2.addChild(this.bone3);
    this.cube_r11 = new ModelRenderer(this);
    this.cube_r11.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r11);
    setRotationAngle(this.cube_r11, -0.1309F, 0.0F, -0.1309F);
    this.cube_r11.cubeList.add(new ModelBox(this.cube_r11, 68, 35, -8.1963F, -1.0552F, -1.0511F, 5, 1, 4, 0.0F));
    this.cube_r12 = new ModelRenderer(this);
    this.cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r12);
    setRotationAngle(this.cube_r12, 0.3927F, 0.2618F, -0.1309F);
    this.cube_r12.cubeList.add(new ModelBox(this.cube_r12, 0, 105, -7.7306F, -3.5504F, -3.283F, 2, 3, 5, 0.0F));
    this.cube_r12.cubeList.add(new ModelBox(this.cube_r12, 55, 26, -7.0F, -3.7389F, -4.8431F, 1, 1, 1, 0.0F));
    this.cube_r13 = new ModelRenderer(this);
    this.cube_r13.setRotationPoint(0.534F, -0.1555F, -0.0584F);
    this.bone3.addChild(this.cube_r13);
    setRotationAngle(this.cube_r13, -0.0873F, 0.2618F, -0.1309F);
    this.cube_r13.cubeList.add(new ModelBox(this.cube_r13, 0, 26, -8.0037F, -1.5875F, -3.5905F, 2, 2, 2, 0.0F));
    this.cube_r14 = new ModelRenderer(this);
    this.cube_r14.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r14);
    setRotationAngle(this.cube_r14, -0.0873F, 0.2618F, -0.1309F);
    this.cube_r14.cubeList.add(new ModelBox(this.cube_r14, 0, 26, -7.4576F, -1.6792F, -5.5123F, 2, 2, 2, 0.0F));
    this.cube_r15 = new ModelRenderer(this);
    this.cube_r15.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r15);
    setRotationAngle(this.cube_r15, 0.2618F, -0.0436F, -0.1309F);
    this.cube_r15.cubeList.add(new ModelBox(this.cube_r15, 98, 53, -6.6623F, -3.2837F, -2.8997F, 2, 3, 6, 0.0F));
    this.cube_r16 = new ModelRenderer(this);
    this.cube_r16.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r16);
    setRotationAngle(this.cube_r16, 0.3927F, -0.0436F, -0.1309F);
    this.cube_r16.cubeList.add(new ModelBox(this.cube_r16, 60, 12, -6.1955F, -3.1056F, -3.4846F, 1, 1, 1, 0.0F));
    this.cube_r17 = new ModelRenderer(this);
    this.cube_r17.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r17);
    setRotationAngle(this.cube_r17, 0.3927F, -0.4363F, -0.1309F);
    this.cube_r17.cubeList.add(new ModelBox(this.cube_r17, 60, 14, -4.873F, -2.2389F, -1.5171F, 1, 1, 1, 0.0F));
    this.cube_r18 = new ModelRenderer(this);
    this.cube_r18.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r18);
    setRotationAngle(this.cube_r18, -0.1745F, -0.0436F, -0.1309F);
    this.cube_r18.cubeList.add(new ModelBox(this.cube_r18, 106, 37, -6.6623F, -1.7505F, -4.0158F, 2, 2, 5, 0.0F));
    this.cube_r19 = new ModelRenderer(this);
    this.cube_r19.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r19);
    setRotationAngle(this.cube_r19, 0.3927F, -0.3927F, -0.1309F);
    this.cube_r19.cubeList.add(new ModelBox(this.cube_r19, 66, 83, -5.9043F, -2.2733F, 0.0604F, 3, 2, 3, 0.0F));
    this.cube_r20 = new ModelRenderer(this);
    this.cube_r20.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r20);
    setRotationAngle(this.cube_r20, -0.1745F, -0.3927F, -0.1309F);
    this.cube_r20.cubeList.add(new ModelBox(this.cube_r20, 106, 44, -5.268F, -1.9171F, -2.1014F, 2, 2, 5, 0.0F));
    this.rightleg = new ModelRenderer(this);
    this.rightleg.setRotationPoint(4.0F, -24.0F, -3.0F);
    this.legs.addChild(this.rightleg);
    setRotationAngle(this.rightleg, 0.1309F, 0.0F, -0.1309F);
    this.rightleg.cubeList.add(new ModelBox(this.rightleg, 79, 79, -4.0F, -2.0F, -2.0F, 7, 13, 6, 0.0F));
    this.bone8 = new ModelRenderer(this);
    this.bone8.setRotationPoint(-6.0F, 23.7389F, 1.0171F);
    this.rightleg.addChild(this.bone8);
    this.bone8.cubeList.add(new ModelBox(this.bone8, 87, 19, 3.0F, -17.7389F, 2.9829F, 6, 5, 3, 0.0F));
    this.cube_r21 = new ModelRenderer(this);
    this.cube_r21.setRotationPoint(8.6043F, -17.322F, 6.5493F);
    this.bone8.addChild(this.cube_r21);
    setRotationAngle(this.cube_r21, -0.3491F, 0.0F, 0.0436F);
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 98, 62, -4.6238F, 16.7451F, -0.6956F, 5, 2, 4, 0.0F));
    this.cube_r21.cubeList.add(new ModelBox(this.cube_r21, 80, 53, -4.6238F, -0.2549F, -0.6956F, 5, 17, 4, 0.0F));
    this.bone9 = new ModelRenderer(this);
    this.bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone8.addChild(this.bone9);
    this.cube_r22 = new ModelRenderer(this);
    this.cube_r22.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r22);
    setRotationAngle(this.cube_r22, -0.1309F, 0.0F, 0.1309F);
    this.cube_r22.cubeList.add(new ModelBox(this.cube_r22, 50, 35, 2.9996F, -1.0552F, -1.0511F, 5, 1, 4, 0.0F));
    this.cube_r23 = new ModelRenderer(this);
    this.cube_r23.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r23);
    setRotationAngle(this.cube_r23, 0.3927F, -0.2618F, 0.1309F);
    this.cube_r23.cubeList.add(new ModelBox(this.cube_r23, 104, 8, 5.7306F, -3.5504F, -3.283F, 2, 3, 5, 0.0F));
    this.cube_r23.cubeList.add(new ModelBox(this.cube_r23, 42, 40, 6.0F, -3.7389F, -4.8431F, 1, 1, 1, 0.0F));
    this.cube_r24 = new ModelRenderer(this);
    this.cube_r24.setRotationPoint(-0.534F, -0.025F, 0.9331F);
    this.bone9.addChild(this.cube_r24);
    setRotationAngle(this.cube_r24, -0.0873F, -0.2618F, 0.1309F);
    this.cube_r24.cubeList.add(new ModelBox(this.cube_r24, 48, 0, 5.7306F, -1.6333F, -4.5514F, 2, 2, 2, 0.0F));
    this.cube_r25 = new ModelRenderer(this);
    this.cube_r25.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r25);
    setRotationAngle(this.cube_r25, -0.0873F, -0.2618F, 0.1309F);
    this.cube_r25.cubeList.add(new ModelBox(this.cube_r25, 48, 0, 5.4576F, -1.6792F, -5.5123F, 2, 2, 2, 0.0F));
    this.cube_r26 = new ModelRenderer(this);
    this.cube_r26.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r26);
    setRotationAngle(this.cube_r26, 0.2618F, 0.0436F, 0.1309F);
    this.cube_r26.cubeList.add(new ModelBox(this.cube_r26, 60, 12, 4.6361F, -3.2837F, -2.8997F, 2, 3, 6, 0.0F));
    this.cube_r27 = new ModelRenderer(this);
    this.cube_r27.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r27);
    setRotationAngle(this.cube_r27, 0.3927F, 0.0436F, 0.1309F);
    this.cube_r27.cubeList.add(new ModelBox(this.cube_r27, 32, 44, 5.1955F, -3.1056F, -3.4846F, 1, 1, 1, 0.0F));
    this.cube_r28 = new ModelRenderer(this);
    this.cube_r28.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r28);
    setRotationAngle(this.cube_r28, 0.3927F, 0.4363F, 0.1309F);
    this.cube_r28.cubeList.add(new ModelBox(this.cube_r28, 50, 35, 3.873F, -2.2389F, -1.5171F, 1, 1, 1, 0.0F));
    this.cube_r29 = new ModelRenderer(this);
    this.cube_r29.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r29);
    setRotationAngle(this.cube_r29, -0.1745F, 0.0436F, 0.1309F);
    this.cube_r29.cubeList.add(new ModelBox(this.cube_r29, 105, 84, 4.6623F, -1.7505F, -4.0158F, 2, 2, 5, 0.0F));
    this.cube_r30 = new ModelRenderer(this);
    this.cube_r30.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r30);
    setRotationAngle(this.cube_r30, 0.3927F, 0.3927F, 0.1309F);
    this.cube_r30.cubeList.add(new ModelBox(this.cube_r30, 0, 6, 2.9043F, -2.2733F, 0.0604F, 3, 2, 3, 0.0F));
    this.cube_r31 = new ModelRenderer(this);
    this.cube_r31.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone9.addChild(this.cube_r31);
    setRotationAngle(this.cube_r31, -0.1745F, 0.3927F, 0.1309F);
    this.cube_r31.cubeList.add(new ModelBox(this.cube_r31, 40, 106, 3.268F, -1.9171F, -2.1014F, 2, 2, 5, 0.0F));
    this.arm = new ModelRenderer(this);
    this.arm.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.armleft = new ModelRenderer(this);
    this.armleft.setRotationPoint(-8.0F, -43.0F, 0.0F);
    this.arm.addChild(this.armleft);
    setRotationAngle(this.armleft, -0.0873F, 0.0F, 0.0F);
    this.armleft.cubeList.add(new ModelBox(this.armleft, 30, 74, -6.0F, -5.0F, -5.0F, 5, 9, 9, 0.0F));
    this.bone5 = new ModelRenderer(this);
    this.bone5.setRotationPoint(-4.0F, 4.0F, 0.0F);
    this.armleft.addChild(this.bone5);
    setRotationAngle(this.bone5, -0.1745F, 0.0F, -0.0873F);
    this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 88, -2.0F, -1.0F, -4.0F, 4, 10, 7, 0.0F));
    this.bone6 = new ModelRenderer(this);
    this.bone6.setRotationPoint(0.0F, 8.0F, 0.0F);
    this.bone5.addChild(this.bone6);
    setRotationAngle(this.bone6, -0.3927F, 0.0F, -0.1309F);
    this.bone6.cubeList.add(new ModelBox(this.bone6, 87, 98, -2.0F, 0.0F, -3.0F, 4, 10, 6, 0.0F));
    this.bone6.cubeList.add(new ModelBox(this.bone6, 40, 96, -2.0F, 10.0F, -3.0F, 2, 4, 6, 0.0F));
    this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 40, -1.0F, 10.0F, -4.0F, 2, 3, 2, 0.0F));
    this.cube_r32 = new ModelRenderer(this);
    this.cube_r32.setRotationPoint(1.0F, 12.0F, 5.0F);
    this.bone6.addChild(this.cube_r32);
    setRotationAngle(this.cube_r32, 0.0F, 0.0F, -0.2618F);
    this.cube_r32.cubeList.add(new ModelBox(this.cube_r32, 4, 45, -2.1907F, 0.4483F, -9.0F, 1, 2, 1, 0.0F));
    this.cube_r33 = new ModelRenderer(this);
    this.cube_r33.setRotationPoint(1.0F, 14.0F, 5.0F);
    this.bone6.addChild(this.cube_r33);
    setRotationAngle(this.cube_r33, 0.0F, 0.0F, -0.7854F);
    this.cube_r33.cubeList.add(new ModelBox(this.cube_r33, 55, 24, -2.0F, 0.0885F, -9.0F, 1, 1, 1, 0.0F));
    this.cube_r34 = new ModelRenderer(this);
    this.cube_r34.setRotationPoint(0.0F, 13.0F, 10.0F);
    this.bone6.addChild(this.cube_r34);
    setRotationAngle(this.cube_r34, 0.0F, 0.0F, -1.0036F);
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 52, 23, -3.3032F, 1.5115F, -8.0F, 1, 1, 1, 0.0F));
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 52, 25, -3.3032F, 1.5115F, -10.0F, 1, 1, 1, 0.0F));
    this.cube_r34.cubeList.add(new ModelBox(this.cube_r34, 55, 22, -3.3032F, 1.5115F, -12.0F, 1, 1, 1, 0.0F));
    this.cube_r35 = new ModelRenderer(this);
    this.cube_r35.setRotationPoint(0.0F, 13.0F, 10.0F);
    this.bone6.addChild(this.cube_r35);
    setRotationAngle(this.cube_r35, 0.0F, 0.0F, -0.5236F);
    this.cube_r35.cubeList.add(new ModelBox(this.cube_r35, 44, 24, -2.2321F, -0.134F, -8.0F, 1, 3, 1, 0.0F));
    this.cube_r35.cubeList.add(new ModelBox(this.cube_r35, 42, 42, -2.2321F, -0.134F, -10.0F, 1, 3, 1, 0.0F));
    this.cube_r35.cubeList.add(new ModelBox(this.cube_r35, 41, 21, -2.2321F, -0.134F, -12.0F, 1, 3, 1, 0.0F));
    this.armright = new ModelRenderer(this);
    this.armright.setRotationPoint(8.0F, -43.0F, 0.0F);
    this.arm.addChild(this.armright);
    setRotationAngle(this.armright, -0.0873F, 0.0F, 0.0F);
    this.armright.cubeList.add(new ModelBox(this.armright, 57, 65, 1.0F, -5.0F, -5.0F, 5, 9, 9, 0.0F));
    this.bone4 = new ModelRenderer(this);
    this.bone4.setRotationPoint(4.0F, 4.0F, 0.0F);
    this.armright.addChild(this.bone4);
    setRotationAngle(this.bone4, -0.1745F, 0.0F, 0.0873F);
    this.bone4.cubeList.add(new ModelBox(this.bone4, 51, 85, -2.0F, -1.0F, -4.0F, 4, 10, 7, 0.0F));
    this.bone7 = new ModelRenderer(this);
    this.bone7.setRotationPoint(0.0F, 8.0F, 0.0F);
    this.bone4.addChild(this.bone7);
    setRotationAngle(this.bone7, -0.3927F, 0.0F, 0.1309F);
    this.bone7.cubeList.add(new ModelBox(this.bone7, 67, 98, -2.0F, 0.0F, -3.0F, 4, 10, 6, 0.0F));
    this.bone7.cubeList.add(new ModelBox(this.bone7, 92, 68, 0.0F, 10.0F, -3.0F, 2, 4, 6, 0.0F));
    this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 21, -1.0F, 10.0F, -4.0F, 2, 3, 2, 0.0F));
    this.cube_r36 = new ModelRenderer(this);
    this.cube_r36.setRotationPoint(-1.0F, 12.0F, 5.0F);
    this.bone7.addChild(this.cube_r36);
    setRotationAngle(this.cube_r36, 0.0F, 0.0F, 0.2618F);
    this.cube_r36.cubeList.add(new ModelBox(this.cube_r36, 0, 45, 1.0F, 0.4483F, -9.0F, 1, 2, 1, 0.0F));
    this.cube_r37 = new ModelRenderer(this);
    this.cube_r37.setRotationPoint(-1.0F, 14.0F, 5.0F);
    this.bone7.addChild(this.cube_r37);
    setRotationAngle(this.cube_r37, 0.0F, 0.0F, 0.7854F);
    this.cube_r37.cubeList.add(new ModelBox(this.cube_r37, 50, 37, 1.0F, 0.0885F, -9.0F, 1, 1, 1, 0.0F));
    this.cube_r38 = new ModelRenderer(this);
    this.cube_r38.setRotationPoint(0.0F, 13.0F, 10.0F);
    this.bone7.addChild(this.cube_r38);
    setRotationAngle(this.cube_r38, 0.0F, 0.0F, 1.0036F);
    this.cube_r38.cubeList.add(new ModelBox(this.cube_r38, 52, 21, 2.3032F, 1.5115F, -8.0F, 1, 1, 1, 0.0F));
    this.cube_r38.cubeList.add(new ModelBox(this.cube_r38, 52, 21, 2.3032F, 1.5115F, -10.0F, 1, 1, 1, 0.0F));
    this.cube_r38.cubeList.add(new ModelBox(this.cube_r38, 52, 21, 2.3032F, 1.5115F, -12.0F, 1, 1, 1, 0.0F));
    this.cube_r39 = new ModelRenderer(this);
    this.cube_r39.setRotationPoint(0.0F, 13.0F, 10.0F);
    this.bone7.addChild(this.cube_r39);
    setRotationAngle(this.cube_r39, 0.0F, 0.0F, 0.5236F);
    this.cube_r39.cubeList.add(new ModelBox(this.cube_r39, 0, 0, 1.0F, -0.134F, -8.0F, 1, 3, 1, 0.0F));
    this.cube_r39.cubeList.add(new ModelBox(this.cube_r39, 8, 0, 1.0F, -0.134F, -10.0F, 1, 3, 1, 0.0F));
    this.cube_r39.cubeList.add(new ModelBox(this.cube_r39, 32, 40, 1.0F, -0.134F, -12.0F, 1, 3, 1, 0.0F));
    this.tail = new ModelRenderer(this);
    this.tail.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.cube_r40 = new ModelRenderer(this);
    this.cube_r40.setRotationPoint(-7.0F, -26.0F, 6.0F);
    this.tail.addChild(this.cube_r40);
    setRotationAngle(this.cube_r40, -0.2618F, 0.0F, 0.0F);
    this.cube_r40.cubeList.add(new ModelBox(this.cube_r40, 50, 102, 6.0F, 1.0F, -6.0F, 2, 2, 6, 0.0F));
    this.bone10 = new ModelRenderer(this);
    this.bone10.setRotationPoint(0.0F, -24.0F, 5.0F);
    this.tail.addChild(this.bone10);
    setRotationAngle(this.bone10, 0.0F, -1.2654F, 0.0F);
    this.cube_r41 = new ModelRenderer(this);
    this.cube_r41.setRotationPoint(-0.229F, 1.0F, -0.8727F);
    this.bone10.addChild(this.cube_r41);
    setRotationAngle(this.cube_r41, -0.2618F, 0.5236F, 0.0F);
    this.cube_r41.cubeList.add(new ModelBox(this.cube_r41, 41, 21, -1.0F, -2.1566F, 0.1895F, 2, 2, 7, 0.0F));
    this.bone11 = new ModelRenderer(this);
    this.bone11.setRotationPoint(0.0F, 2.0F, 7.0F);
    this.bone10.addChild(this.bone11);
    this.cube_r42 = new ModelRenderer(this);
    this.cube_r42.setRotationPoint(3.6944F, -1.0F, -2.7534F);
    this.bone11.addChild(this.cube_r42);
    setRotationAngle(this.cube_r42, -0.2618F, -0.4363F, 0.0F);
    this.cube_r42.cubeList.add(new ModelBox(this.cube_r42, 101, 92, -1.0F, -0.3449F, 0.428F, 2, 2, 6, 0.0F));
    this.bone12 = new ModelRenderer(this);
    this.bone12.setRotationPoint(0.0F, 2.0F, 7.0F);
    this.bone11.addChild(this.bone12);
    this.cube_r43 = new ModelRenderer(this);
    this.cube_r43.setRotationPoint(-37.404F, 21.6802F, 20.0737F);
    this.bone12.addChild(this.cube_r43);
    setRotationAngle(this.cube_r43, 2.8362F, -0.8727F, 0.0F);
    this.cube_r43.cubeList.add(new ModelBox(this.cube_r43, 0, 0, 5.4476F, -4.6242F, 39.5807F, 2, 2, 4, 0.3F));
    this.cube_r44 = new ModelRenderer(this);
    this.cube_r44.setRotationPoint(-34.654F, -7.8184F, 7.9466F);
    this.bone12.addChild(this.cube_r44);
    setRotationAngle(this.cube_r44, -2.7489F, -0.8727F, 0.0F);
    this.cube_r44.cubeList.add(new ModelBox(this.cube_r44, 32, 40, 12.9698F, -9.1427F, 28.672F, 2, 2, 6, 0.0F));
    this.cube_r45 = new ModelRenderer(this);
    this.cube_r45.setRotationPoint(-8.861F, -14.4003F, -13.6963F);
    this.bone12.addChild(this.cube_r45);
    setRotationAngle(this.cube_r45, -1.5272F, -0.8727F, 0.0F);
    this.cube_r45.cubeList.add(new ModelBox(this.cube_r45, 21, 62, 12.9698F, -9.5353F, 19.6806F, 2, 2, 6, 0.0F));
    this.cube_r46 = new ModelRenderer(this);
    this.cube_r46.setRotationPoint(0.0458F, -5.9882F, -14.156F);
    this.bone12.addChild(this.cube_r46);
    setRotationAngle(this.cube_r46, -0.7418F, -0.8727F, 0.0F);
    this.cube_r46.cubeList.add(new ModelBox(this.cube_r46, 99, 21, 7.5968F, -3.8374F, 13.4624F, 2, 2, 6, 0.0F));
    this.cube_r47 = new ModelRenderer(this);
    this.cube_r47.setRotationPoint(1.3704F, -1.25F, -4.0452F);
    this.bone12.addChild(this.cube_r47);
    setRotationAngle(this.cube_r47, -0.2618F, -0.8727F, 0.0F);
    this.cube_r47.cubeList.add(new ModelBox(this.cube_r47, 100, 29, -1.0F, -0.3449F, 0.428F, 2, 2, 6, 0.0F));
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.head.render(f5);
    this.body.render(f5);
    this.legs.render(f5);
    this.arm.render(f5);
    this.tail.render(f5);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    EntityLivingBase entity = (EntityLivingBase)ent;
    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.8F * limbSwingAmount;
    if (entity.isSwingInProgress)
      this.armright.rotateAngleY = MathHelper.sin(entity.swingProgress * 30.0F + 3.1415927F) * -0.2F; 
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
    GL11.glScaled(1.2D, 1.2D, 1.0D);
    GL11.glTranslated(-0.1D, -0.25D, 0.05D);
    GL11.glRotated(-5.0D, 1.0D, 0.0D, 0.0D);
    GL11.glRotated(1.0D, 0.0D, 0.0D, 1.0D);
    return this.armright;
  }
}
