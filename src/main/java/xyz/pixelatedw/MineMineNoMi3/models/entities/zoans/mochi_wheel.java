package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class mochi_wheel extends ModelZoanMorph {
  private final ModelRenderer mochi_wheel;
  
  private final ModelRenderer half1;
  
  private final ModelRenderer quarter1;
  
  private final ModelRenderer side1;
  
  private final ModelRenderer side2;
  
  private final ModelRenderer side3;
  
  private final ModelRenderer side4;
  
  private final ModelRenderer quarter2;
  
  private final ModelRenderer side5;
  
  private final ModelRenderer side6;
  
  private final ModelRenderer side7;
  
  private final ModelRenderer side8;
  
  private final ModelRenderer half2;
  
  private final ModelRenderer quarter3;
  
  private final ModelRenderer side9;
  
  private final ModelRenderer side10;
  
  private final ModelRenderer side11;
  
  private final ModelRenderer side12;
  
  private final ModelRenderer quarter4;
  
  private final ModelRenderer side13;
  
  private final ModelRenderer side14;
  
  private final ModelRenderer side15;
  
  private final ModelRenderer side16;
  
  public mochi_wheel() {
    this.textureWidth = 256;
    this.textureHeight = 256;
    this.mochi_wheel = new ModelRenderer(this);
    this.mochi_wheel.setRotationPoint(-10.0F, 1.5F, 0.5F);
    this.mochi_wheel.offsetY = (float)(this.mochi_wheel.offsetY + 1.5D);
    this.half1 = new ModelRenderer(this);
    this.half1.setRotationPoint(0.0F, 22.5F, 3.5F);
    this.mochi_wheel.addChild(this.half1);
    this.quarter1 = new ModelRenderer(this);
    this.quarter1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.half1.addChild(this.quarter1);
    this.side1 = new ModelRenderer(this);
    this.side1.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter1.addChild(this.side1);
    this.side1.setTextureOffset(162, 63).addBox(-26.0F, -12.0F, 0.0F, 24, 12, 9, 0.0F);
    this.side2 = new ModelRenderer(this);
    this.side2.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter1.addChild(this.side2);
    setRotationAngle(this.side2, -0.3927F, 0.0F, 0.0F);
    this.side2.setTextureOffset(0, 156).addBox(-26.0F, -12.0F, -9.0F, 24, 12, 9, 0.0F);
    this.side3 = new ModelRenderer(this);
    this.side3.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter1.addChild(this.side3);
    setRotationAngle(this.side3, -0.7854F, 0.0F, 0.0F);
    this.side3.setTextureOffset(90, 144).addBox(-26.0F, -8.5558F, -17.3149F, 24, 12, 9, 0.0F);
    this.side4 = new ModelRenderer(this);
    this.side4.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter1.addChild(this.side4);
    setRotationAngle(this.side4, -1.1781F, 0.0F, 0.0F);
    this.side4.setTextureOffset(0, 135).addBox(-26.0F, -2.1919F, -23.6789F, 24, 12, 9, 0.0F);
    this.quarter2 = new ModelRenderer(this);
    this.quarter2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.half1.addChild(this.quarter2);
    setRotationAngle(this.quarter2, -1.5708F, 0.0F, 0.0F);
    this.side5 = new ModelRenderer(this);
    this.side5.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter2.addChild(this.side5);
    this.side5.setTextureOffset(90, 123).addBox(-26.0F, 14.123F, -19.123F, 24, 12, 9, 0.0F);
    this.side6 = new ModelRenderer(this);
    this.side6.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter2.addChild(this.side6);
    setRotationAngle(this.side6, -0.3927F, 0.0F, 0.0F);
    this.side6.setTextureOffset(0, 114).addBox(-26.0F, 19.4526F, -16.6705F, 24, 12, 9, 0.0F);
    this.side7 = new ModelRenderer(this);
    this.side7.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter2.addChild(this.side7);
    setRotationAngle(this.side7, -0.7854F, 0.0F, 0.0F);
    this.side7.setTextureOffset(90, 102).addBox(-26.0F, 23.4379F, -12.3652F, 24, 12, 9, 0.0F);
    this.side8 = new ModelRenderer(this);
    this.side8.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter2.addChild(this.side8);
    setRotationAngle(this.side8, -1.1781F, 0.0F, 0.0F);
    this.side8.setTextureOffset(0, 93).addBox(-26.0F, 25.4723F, -6.8624F, 24, 12, 9, 0.0F);
    this.half2 = new ModelRenderer(this);
    this.half2.setRotationPoint(0.0F, 22.5F, 3.5F);
    this.mochi_wheel.addChild(this.half2);
    setRotationAngle(this.half2, 3.1416F, 0.0F, 0.0F);
    this.quarter3 = new ModelRenderer(this);
    this.quarter3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.half2.addChild(this.quarter3);
    this.side9 = new ModelRenderer(this);
    this.side9.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter3.addChild(this.side9);
    this.side9.setTextureOffset(90, 42).addBox(-26.0F, 33.2461F, 7.0F, 24, 12, 9, 0.0F);
    this.side10 = new ModelRenderer(this);
    this.side10.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter3.addChild(this.side10);
    setRotationAngle(this.side10, -0.3927F, 0.0F, 0.0F);
    this.side10.setTextureOffset(90, 21).addBox(-26.0F, 27.1231F, 14.7821F, 24, 12, 9, 0.0F);
    this.side11 = new ModelRenderer(this);
    this.side11.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter3.addChild(this.side11);
    setRotationAngle(this.side11, -0.7854F, 0.0F, 0.0F);
    this.side11.setTextureOffset(90, 0).addBox(-26.0F, 18.4882F, 19.6286F, 24, 12, 9, 0.0F);
    this.side12 = new ModelRenderer(this);
    this.side12.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter3.addChild(this.side12);
    setRotationAngle(this.side12, -1.1781F, 0.0F, 0.0F);
    this.side12.setTextureOffset(81, 81).addBox(-26.0F, 8.6559F, 20.8018F, 24, 12, 9, 0.0F);
    this.quarter4 = new ModelRenderer(this);
    this.quarter4.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.half2.addChild(this.quarter4);
    setRotationAngle(this.quarter4, -1.5708F, 0.0F, 0.0F);
    this.side13 = new ModelRenderer(this);
    this.side13.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter4.addChild(this.side13);
    this.side13.setTextureOffset(0, 63).addBox(-26.0F, 7.123F, 26.123F, 24, 12, 9, 0.0F);
    this.side14 = new ModelRenderer(this);
    this.side14.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter4.addChild(this.side14);
    setRotationAngle(this.side14, -0.3927F, 0.0F, 0.0F);
    this.side14.setTextureOffset(0, 42).addBox(-26.0F, -4.3295F, 22.4526F, 24, 12, 9, 0.0F);
    this.side15 = new ModelRenderer(this);
    this.side15.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter4.addChild(this.side15);
    setRotationAngle(this.side15, -0.7854F, 0.0F, 0.0F);
    this.side15.setTextureOffset(0, 21).addBox(-26.0F, -13.5056F, 14.6789F, 24, 12, 9, 0.0F);
    this.side16 = new ModelRenderer(this);
    this.side16.setRotationPoint(24.0F, 0.0F, -8.0F);
    this.quarter4.addChild(this.side16);
    setRotationAngle(this.side16, -1.1781F, 0.0F, 0.0F);
    this.side16.setTextureOffset(0, 0).addBox(-26.0F, -19.0084F, 3.9853F, 24, 12, 9, 0.0F);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    this.mochi_wheel.rotateAngleX = MathHelper.cos(ageInTicks * 0.1F) * 0.3F;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.mochi_wheel.render(f5);
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
