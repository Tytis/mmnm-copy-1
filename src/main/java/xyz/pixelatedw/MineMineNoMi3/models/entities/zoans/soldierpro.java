package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class soldierpro extends ModelZoanMorph {
  private final ModelRenderer bone;
  
  private final ModelRenderer cube_r1;
  
  private final ModelRenderer cube_r2;
  
  private final ModelRenderer cube_r3;
  
  private final ModelRenderer cube_r4;
  
  private final ModelRenderer cube_r5;
  
  private final ModelRenderer cube_r6;
  
  private final ModelRenderer cube_r7;
  
  private final ModelRenderer cube_r8;
  
  private final ModelRenderer cube_r9;
  
  private final ModelRenderer cube_r10;
  
  private final ModelRenderer cube_r11;
  
  private final ModelRenderer cube_r12;
  
  private final ModelRenderer cube_r13;
  
  private final ModelRenderer cube_r14;
  
  private final ModelRenderer cube_r15;
  
  private final ModelRenderer cube_r16;
  
  private final ModelRenderer cube_r17;
  
  private final ModelRenderer arm;
  
  private final ModelRenderer leftarm;
  
  private final ModelRenderer cube_r18;
  
  private final ModelRenderer bone2;
  
  private final ModelRenderer cube_r19;
  
  private final ModelRenderer bone3;
  
  private final ModelRenderer cube_r20;
  
  private final ModelRenderer cube_r21;
  
  private final ModelRenderer rightarm;
  
  private final ModelRenderer cube_r22;
  
  private final ModelRenderer bone4;
  
  private final ModelRenderer cube_r23;
  
  private final ModelRenderer bone5;
  
  private final ModelRenderer cube_r24;
  
  private final ModelRenderer cube_r25;
  
  private final ModelRenderer cube_r26;
  
  private final ModelRenderer cube_r27;
  
  public soldierpro() {
    this.textureWidth = 240;
    this.textureHeight = 240;
    this.bone = new ModelRenderer(this);
    this.bone.setRotationPoint(-8.0F, 24.0F, 0.0F);
    this.bone.setTextureOffset(106, 186).addBox(14.0F, -16.0F, -2.0F, 5, 16, 4, 0.0F);
    this.bone.setTextureOffset(106, 186).addBox(-3.0F, -16.0F, -2.0F, 5, 16, 4, 0.0F);
    this.bone.setTextureOffset(101, 158).addBox(14.0F, -3.0F, -7.0F, 5, 3, 4, 0.6F);
    this.bone.setTextureOffset(101, 158).addBox(-3.0F, -3.0F, -7.0F, 5, 3, 4, 0.6F);
    this.bone.setTextureOffset(47, 0).addBox(14.0F, -10.0F, -2.0F, 5, 10, 4, 0.6F);
    this.bone.setTextureOffset(47, 0).addBox(-3.0F, -10.0F, -2.0F, 5, 10, 4, 0.6F);
    this.bone.setTextureOffset(148, 184).addBox(14.0F, -32.0F, -2.0F, 5, 16, 4, 0.0F);
    this.bone.setTextureOffset(148, 184).addBox(-3.0F, -32.0F, -2.0F, 5, 16, 4, 0.0F);
    this.bone.setTextureOffset(0, 106).addBox(-9.0F, -48.0F, -9.0F, 34, 16, 17, 0.0F);
    this.bone.setTextureOffset(115, 52).addBox(-9.0F, -33.0F, -9.0F, 34, 8, 17, 0.1F);
    this.bone.setTextureOffset(85, 138).addBox(-9.0F, -36.0F, -9.0F, 34, 3, 17, 0.3F);
    this.bone.setTextureOffset(51, 51).addBox(5.0F, -36.0F, -10.0F, 6, 6, 1, 0.0F);
    this.bone.setTextureOffset(102, 106).addBox(-8.0F, -64.0F, -8.0F, 32, 16, 16, 0.0F);
    this.bone.setTextureOffset(0, 139).addBox(-7.0F, -65.0F, -5.0F, 30, 1, 13, 0.0F);
    this.bone.setTextureOffset(0, 69).addBox(-15.0F, -64.0F, -5.0F, 46, 21, 16, 0.0F);
    this.bone.setTextureOffset(67, 0).addBox(-16.0F, -43.0F, -5.0F, 48, 34, 16, 0.0F);
    this.bone.setTextureOffset(0, 49).addBox(4.0F, -78.0F, -10.0F, 8, 7, 9, 0.0F);
    this.bone.setTextureOffset(67, 50).addBox(4.0F, -80.0F, -10.0F, 8, 2, 9, 0.1F);
    this.bone.setTextureOffset(67, 51).addBox(4.0F, -78.5F, -10.0F, 8, 1, 9, 0.1F);
    this.bone.setTextureOffset(124, 186).addBox(12.0F, -80.0F, -9.0F, 1, 9, 8, 0.1F);
    this.bone.setTextureOffset(77, 11).addBox(13.0F, -77.0F, -6.0F, 1, 2, 2, 0.2F);
    this.bone.setTextureOffset(67, 54).addBox(2.0F, -77.0F, -6.0F, 1, 2, 2, 0.2F);
    this.bone.setTextureOffset(76, 181).addBox(3.0F, -80.0F, -9.0F, 1, 9, 8, 0.1F);
    this.bone.setTextureOffset(11, 12).addBox(12.0F, -80.0F, -10.0F, 1, 1, 1, 0.1F);
    this.bone.setTextureOffset(10, 9).addBox(3.0F, -80.0F, -10.0F, 1, 1, 1, 0.1F);
    this.bone.setTextureOffset(75, 139).addBox(4.0F, -80.0F, -1.0F, 8, 9, 1, 0.1F);
    this.bone.setTextureOffset(124, 97).addBox(4.0F, -82.0F, -9.0F, 8, 2, 7, 0.0F);
    this.bone.setTextureOffset(25, 49).addBox(5.0F, -84.0F, -8.0F, 6, 2, 5, 0.0F);
    this.bone.setTextureOffset(11, 0).addBox(7.5F, -75.0F, -11.0F, 1, 2, 1, 0.0F);
    this.bone.setTextureOffset(0, 153).addBox(1.0F, -71.0F, -11.0F, 14, 7, 11, 0.0F);
    this.bone.setTextureOffset(108, 77).addBox(1.0F, -67.0F, -11.0F, 14, 5, 1, 0.1F);
    this.bone.setTextureOffset(0, 69).addBox(5.0F, -62.0F, -11.0F, 6, 9, 2, 0.1F);
    this.bone.setTextureOffset(0, 17).addBox(5.5F, -53.0F, -11.0F, 5, 9, 1, 0.1F);
    this.bone.setTextureOffset(0, 34).addBox(6.0F, -44.0F, -11.0F, 4, 9, 1, 0.1F);
    this.bone.setTextureOffset(0, 49).addBox(7.0F, -35.0F, -11.0F, 2, 7, 1, 0.1F);
    this.bone.setTextureOffset(0, 34).addBox(-2.0F, -66.0F, -10.0F, 20, 4, 11, 0.1F);
    this.cube_r1 = new ModelRenderer(this);
    this.cube_r1.setRotationPoint(30.0F, -62.0F, 4.0F);
    this.bone.addChild(this.cube_r1);
    setRotationAngle(this.cube_r1, 0.1309F, -0.0436F, 0.2618F);
    this.cube_r1.setTextureOffset(0, 0).addBox(-14.0F, -2.0F, -14.0F, 16, 2, 15, 0.0F);
    this.cube_r2 = new ModelRenderer(this);
    this.cube_r2.setRotationPoint(-14.0F, -62.0F, 4.0F);
    this.bone.addChild(this.cube_r2);
    setRotationAngle(this.cube_r2, 0.1309F, 0.0436F, -0.2618F);
    this.cube_r2.setTextureOffset(0, 17).addBox(-2.0F, -2.0F, -14.0F, 16, 2, 15, 0.0F);
    this.cube_r3 = new ModelRenderer(this);
    this.cube_r3.setRotationPoint(8.0F, -80.4583F, 0.9501F);
    this.bone.addChild(this.cube_r3);
    setRotationAngle(this.cube_r3, -1.7453F, 0.0F, 0.0F);
    this.cube_r3.setTextureOffset(132, 158).addBox(-1.0F, -20.0F, 2.0F, 2, 20, 8, 0.0F);
    this.cube_r4 = new ModelRenderer(this);
    this.cube_r4.setRotationPoint(10.0F, -85.1329F, -0.1619F);
    this.bone.addChild(this.cube_r4);
    setRotationAngle(this.cube_r4, -1.5272F, 0.0F, 0.0F);
    this.cube_r4.setTextureOffset(62, 173).addBox(-3.0F, -20.0F, 6.0F, 2, 20, 5, 0.0F);
    this.cube_r5 = new ModelRenderer(this);
    this.cube_r5.setRotationPoint(8.0F, -87.3709F, -1.5255F);
    this.bone.addChild(this.cube_r5);
    setRotationAngle(this.cube_r5, -1.3963F, 0.0F, 0.0F);
    this.cube_r5.setTextureOffset(152, 158).addBox(-1.0F, -20.0F, 2.0F, 2, 17, 9, 0.0F);
    this.cube_r6 = new ModelRenderer(this);
    this.cube_r6.setRotationPoint(8.0F, -85.8398F, -4.9935F);
    this.bone.addChild(this.cube_r6);
    setRotationAngle(this.cube_r6, -0.9599F, 0.0F, 0.0F);
    this.cube_r6.setTextureOffset(0, 171).addBox(-1.0F, -21.0F, 2.0F, 2, 16, 9, 0.0F);
    this.cube_r7 = new ModelRenderer(this);
    this.cube_r7.setRotationPoint(8.0F, -84.4261F, -6.1705F);
    this.bone.addChild(this.cube_r7);
    setRotationAngle(this.cube_r7, -0.5236F, 0.0F, 0.0F);
    this.cube_r7.setTextureOffset(88, 158).addBox(-1.0F, -20.0F, 2.0F, 2, 22, 9, 0.0F);
    this.cube_r8 = new ModelRenderer(this);
    this.cube_r8.setRotationPoint(10.0F, -84.2751F, -10.24F);
    this.bone.addChild(this.cube_r8);
    setRotationAngle(this.cube_r8, -0.2618F, 0.0F, 0.0F);
    this.cube_r8.setTextureOffset(22, 171).addBox(-3.0F, -20.0F, 2.0F, 2, 15, 9, 0.0F);
    this.cube_r9 = new ModelRenderer(this);
    this.cube_r9.setRotationPoint(-1.0F, -84.8856F, 3.122F);
    this.bone.addChild(this.cube_r9);
    setRotationAngle(this.cube_r9, 0.1745F, 0.0F, 0.0F);
    this.cube_r9.setTextureOffset(110, 158).addBox(8.0F, -19.0F, -12.0F, 2, 19, 9, 0.0F);
    this.cube_r10 = new ModelRenderer(this);
    this.cube_r10.setRotationPoint(-2.9442F, -78.4737F, -1.0F);
    this.bone.addChild(this.cube_r10);
    setRotationAngle(this.cube_r10, 0.0F, 0.0F, 0.3927F);
    this.cube_r10.setTextureOffset(0, 9).addBox(-6.0F, 1.0F, -5.0F, 4, 2, 2, 0.0F);
    this.cube_r11 = new ModelRenderer(this);
    this.cube_r11.setRotationPoint(18.9442F, -78.4737F, -1.0F);
    this.bone.addChild(this.cube_r11);
    setRotationAngle(this.cube_r11, 0.0F, 0.0F, -0.3927F);
    this.cube_r11.setTextureOffset(51, 38).addBox(2.0F, 1.0F, -5.0F, 4, 2, 2, 0.0F);
    this.cube_r12 = new ModelRenderer(this);
    this.cube_r12.setRotationPoint(0.6844F, -77.5243F, -1.0F);
    this.bone.addChild(this.cube_r12);
    setRotationAngle(this.cube_r12, 0.0F, 0.0F, 0.3054F);
    this.cube_r12.setTextureOffset(0, 27).addBox(-6.0F, 1.0F, -5.0F, 4, 2, 2, 0.0F);
    this.cube_r13 = new ModelRenderer(this);
    this.cube_r13.setRotationPoint(15.3156F, -77.5243F, -1.0F);
    this.bone.addChild(this.cube_r13);
    setRotationAngle(this.cube_r13, 0.0F, 0.0F, -0.3054F);
    this.cube_r13.setTextureOffset(34, 56).addBox(2.0F, 1.0F, -5.0F, 4, 2, 2, 0.0F);
    this.cube_r14 = new ModelRenderer(this);
    this.cube_r14.setRotationPoint(4.0F, -78.0F, -1.0F);
    this.bone.addChild(this.cube_r14);
    setRotationAngle(this.cube_r14, 0.0F, 0.0F, 0.0436F);
    this.cube_r14.setTextureOffset(51, 34).addBox(-6.0F, 1.0F, -5.0F, 4, 2, 2, 0.0F);
    this.cube_r15 = new ModelRenderer(this);
    this.cube_r15.setRotationPoint(12.0F, -78.0F, -1.0F);
    this.bone.addChild(this.cube_r15);
    setRotationAngle(this.cube_r15, 0.0F, 0.0F, -0.0436F);
    this.cube_r15.setTextureOffset(51, 58).addBox(2.0F, 1.0F, -5.0F, 4, 2, 2, 0.0F);
    this.cube_r16 = new ModelRenderer(this);
    this.cube_r16.setRotationPoint(-24.1443F, -83.6987F, -15.8F);
    this.bone.addChild(this.cube_r16);
    setRotationAngle(this.cube_r16, 0.0F, 0.0F, -0.9163F);
    this.cube_r16.setTextureOffset(203, 221).addBox(-8.0F, 25.0F, 8.0F, 2, 3, 17, 0.2F);
    this.cube_r17 = new ModelRenderer(this);
    this.cube_r17.setRotationPoint(8.3831F, -58.7395F, -16.2F);
    this.bone.addChild(this.cube_r17);
    setRotationAngle(this.cube_r17, 0.0F, 0.0F, -0.9163F);
    this.cube_r17.setTextureOffset(50, 153).addBox(-8.0F, 25.0F, 8.0F, 2, 3, 17, 0.2F);
    this.cube_r17.setTextureOffset(0, 211).addBox(-8.0F, -7.0F, 8.0F, 2, 1, 1, 0.5F);
    this.cube_r17.setTextureOffset(87, 61).addBox(-9.0F, -8.0F, 8.0F, 4, 3, 1, 0.3F);
    this.cube_r17.setTextureOffset(0, 211).addBox(-8.0F, -1.0F, 8.0F, 2, 1, 1, 0.5F);
    this.cube_r17.setTextureOffset(0, 80).addBox(-9.0F, -2.0F, 8.0F, 4, 3, 1, 0.3F);
    this.cube_r17.setTextureOffset(166, 184).addBox(-8.0F, -16.0F, 8.0F, 2, 24, 1, 0.2F);
    this.cube_r17.setTextureOffset(0, 211).addBox(-8.0F, 9.0F, 7.0F, 2, 1, 1, 0.5F);
    this.cube_r17.setTextureOffset(77, 61).addBox(-9.0F, 8.0F, 7.0F, 4, 3, 1, 0.3F);
    this.cube_r17.setTextureOffset(0, 211).addBox(-8.0F, 15.0F, 7.0F, 2, 1, 1, 0.5F);
    this.cube_r17.setTextureOffset(67, 61).addBox(-9.0F, 14.0F, 7.0F, 4, 3, 1, 0.3F);
    this.cube_r17.setTextureOffset(0, 211).addBox(-8.0F, 21.0F, 7.0F, 2, 1, 1, 0.5F);
    this.cube_r17.setTextureOffset(67, 11).addBox(-9.0F, 20.0F, 7.0F, 4, 3, 1, 0.3F);
    this.cube_r17.setTextureOffset(142, 186).addBox(-8.0F, 8.0F, 7.0F, 2, 20, 1, 0.2F);
    this.arm = new ModelRenderer(this);
    this.arm.setRotationPoint(-20.0F, -62.0F, -3.0F);
    this.bone.addChild(this.arm);
    this.leftarm = new ModelRenderer(this);
    this.leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.arm.addChild(this.leftarm);
    this.cube_r18 = new ModelRenderer(this);
    this.cube_r18.setRotationPoint(39.4685F, 0.1131F, 4.0F);
    this.leftarm.addChild(this.cube_r18);
    setRotationAngle(this.cube_r18, 0.0F, 0.0F, -0.4363F);
    this.cube_r18.setTextureOffset(174, 174).addBox(1.0F, 0.0F, -3.0F, 4, 16, 5, 0.0F);
    this.bone2 = new ModelRenderer(this);
    this.bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.leftarm.addChild(this.bone2);
    this.cube_r19 = new ModelRenderer(this);
    this.cube_r19.setRotationPoint(45.8804F, 13.5831F, 4.0F);
    this.bone2.addChild(this.cube_r19);
    setRotationAngle(this.cube_r19, 0.0F, 0.0F, -0.2182F);
    this.cube_r19.setTextureOffset(170, 138).addBox(1.0F, 0.0F, -3.0F, 4, 9, 5, 0.0F);
    this.bone3 = new ModelRenderer(this);
    this.bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone2.addChild(this.bone3);
    this.cube_r20 = new ModelRenderer(this);
    this.cube_r20.setRotationPoint(45.3632F, 28.345F, 4.7F);
    this.bone3.addChild(this.cube_r20);
    setRotationAngle(this.cube_r20, 0.0F, 0.0F, -0.2182F);
    this.cube_r20.setTextureOffset(85, 106).addBox(3.0F, 0.0F, -5.0F, 6, 6, 7, 0.0F);
    this.cube_r21 = new ModelRenderer(this);
    this.cube_r21.setRotationPoint(47.179F, 19.4409F, 4.0F);
    this.bone3.addChild(this.cube_r21);
    setRotationAngle(this.cube_r21, 0.0F, 0.0F, -0.2182F);
    this.cube_r21.setTextureOffset(179, 0).addBox(1.0F, 3.0F, -3.0F, 4, 6, 5, 0.3F);
    this.rightarm = new ModelRenderer(this);
    this.rightarm.setRotationPoint(12.0F, 1.0F, 3.0F);
    this.arm.addChild(this.rightarm);
    setRotationAngle(this.rightarm, -0.4363F, 0.0F, 0.0F);
    this.cube_r22 = new ModelRenderer(this);
    this.cube_r22.setRotationPoint(4.5315F, -0.8869F, 1.0F);
    this.rightarm.addChild(this.cube_r22);
    setRotationAngle(this.cube_r22, 0.0F, 0.0F, 0.4363F);
    this.cube_r22.setTextureOffset(44, 173).addBox(-5.0F, 0.0F, -3.0F, 4, 16, 5, 0.0F);
    this.bone4 = new ModelRenderer(this);
    this.bone4.setRotationPoint(-5.8804F, 11.5831F, 3.0F);
    this.rightarm.addChild(this.bone4);
    setRotationAngle(this.bone4, -0.3491F, -0.1309F, 0.0F);
    this.cube_r23 = new ModelRenderer(this);
    this.cube_r23.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone4.addChild(this.cube_r23);
    setRotationAngle(this.cube_r23, 0.0F, 0.0F, 0.2182F);
    this.cube_r23.setTextureOffset(71, 153).addBox(-0.8784F, 0.1105F, -5.0F, 4, 9, 5, 0.0F);
    this.bone5 = new ModelRenderer(this);
    this.bone5.setRotationPoint(-0.1196F, 8.4169F, -3.0F);
    this.bone4.addChild(this.bone5);
    setRotationAngle(this.bone5, -0.829F, 0.0F, 0.0F);
    this.cube_r24 = new ModelRenderer(this);
    this.cube_r24.setRotationPoint(5.0229F, 7.063F, 1.6837F);
    this.bone5.addChild(this.cube_r24);
    setRotationAngle(this.cube_r24, 0.0F, 0.0F, 0.2182F);
    this.cube_r24.setTextureOffset(67, 50).addBox(-7.316F, 3.3588F, 8.0163F, 2, 2, 2, 0.4F);
    this.cube_r24.setTextureOffset(154, 97).addBox(-10.316F, 0.3588F, -5.9837F, 8, 8, 1, 0.0F);
    this.cube_r24.setTextureOffset(0, 0).addBox(-6.9159F, 2.3588F, -70.9837F, 1, 4, 65, 0.0F);
    this.cube_r24.setTextureOffset(34, 49).addBox(-7.316F, 3.3588F, -4.9837F, 2, 2, 13, 0.0F);
    this.cube_r25 = new ModelRenderer(this);
    this.cube_r25.setRotationPoint(4.6368F, 7.345F, 1.7F);
    this.bone5.addChild(this.cube_r25);
    setRotationAngle(this.cube_r25, 0.0F, 0.0F, 0.2182F);
    this.cube_r25.setTextureOffset(101, 50).addBox(-9.0F, 0.0F, -5.0F, 6, 6, 7, 0.0F);
    this.cube_r26 = new ModelRenderer(this);
    this.cube_r26.setRotationPoint(2.821F, -1.5591F, 1.0F);
    this.bone5.addChild(this.cube_r26);
    setRotationAngle(this.cube_r26, 0.0F, 0.0F, 0.2182F);
    this.cube_r26.setTextureOffset(39, 153).addBox(-5.0F, 3.0F, -3.0F, 4, 6, 5, 0.3F);
    this.cube_r27 = new ModelRenderer(this);
    this.cube_r27.setRotationPoint(2.8224F, -2.2251F, 1.2219F);
    this.bone5.addChild(this.cube_r27);
    setRotationAngle(this.cube_r27, 0.0436F, -0.1745F, 0.1309F);
    this.cube_r27.setTextureOffset(0, 0).addBox(-5.1984F, 1.012F, -1.0932F, 4, 6, 3, 0.0F);
    this.bone.offsetY = (float)(this.bone.offsetY + 1.5D);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {}
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.bone.render(f5);
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
