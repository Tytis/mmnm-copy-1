package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class luffy extends ModelZoanMorph {
  private final ModelRenderer Head;
  
  private final ModelRenderer hair;
  
  private final ModelRenderer Body;
  
  private final ModelRenderer Shirt;
  
  private final ModelRenderer bone;
  
  private final ModelRenderer Hat;
  
  private final ModelRenderer neck;
  
  private final ModelRenderer back;
  
  private final ModelRenderer Arms;
  
  private final ModelRenderer RightArm;
  
  private final ModelRenderer subarm2;
  
  private final ModelRenderer subarm;
  
  private final ModelRenderer hand;
  
  private final ModelRenderer thumb;
  
  private final ModelRenderer fingers;
  
  private final ModelRenderer LeftArm;
  
  private final ModelRenderer subarm3;
  
  private final ModelRenderer subarm4;
  
  private final ModelRenderer hand2;
  
  private final ModelRenderer thumb2;
  
  private final ModelRenderer fingers2;
  
  private final ModelRenderer Legs;
  
  private final ModelRenderer cloththing;
  
  private final ModelRenderer RightLeg;
  
  private final ModelRenderer leg;
  
  private final ModelRenderer LeftLeg;
  
  private final ModelRenderer leg2;
  
  public luffy() {
    this.textureWidth = 256;
    this.textureHeight = 256;
    this.Head = new ModelRenderer(this);
    this.Head.setRotationPoint(0.0F, -52.0F, -5.0F);
    setRotationAngle(this.Head, 0.1745F, 0.1309F, 0.0F);
    this.Head.cubeList.add(new ModelBox(this.Head, 167, 167, -6.0F, -12.0F, -6.0F, 12, 12, 12, 0.0F));
    this.hair = new ModelRenderer(this);
    this.hair.setRotationPoint(0.0F, -5.0F, -1.0F);
    this.Head.addChild(this.hair);
    setRotationAngle(this.hair, 0.0F, -0.7854F, 0.0F);
    this.hair.cubeList.add(new ModelBox(this.hair, 114, 82, 0.5F, -11.0F, -10.0F, 0, 8, 21, 0.0F));
    this.hair.cubeList.add(new ModelBox(this.hair, 116, 51, -10.2071F, -10.0F, 0.7071F, 21, 8, 0, 0.0F));
    this.Body = new ModelRenderer(this);
    this.Body.setRotationPoint(0.0F, -7.0F, 1.0F);
    setRotationAngle(this.Body, 0.0F, -0.0873F, 0.0F);
    this.Body.cubeList.add(new ModelBox(this.Body, 98, 62, -19.0F, -41.0F, -12.0F, 38, 23, 18, 0.0F));
    this.Body.cubeList.add(new ModelBox(this.Body, 156, 20, -10.0F, -43.0F, -10.0F, 20, 3, 12, 0.0F));
    this.Body.cubeList.add(new ModelBox(this.Body, 78, 121, -5.0F, -45.0F, -9.0F, 10, 3, 5, 0.0F));
    this.Body.cubeList.add(new ModelBox(this.Body, 0, 80, -17.0F, -18.0F, -12.0F, 34, 18, 23, 0.0F));
    this.Shirt = new ModelRenderer(this);
    this.Shirt.setRotationPoint(10.5F, -21.5F, -13.5F);
    this.Body.addChild(this.Shirt);
    this.Shirt.cubeList.add(new ModelBox(this.Shirt, 0, 36, -30.0F, -23.0F, 1.0F, 39, 25, 19, 0.0F));
    this.Shirt.cubeList.add(new ModelBox(this.Shirt, 0, 0, -30.0F, 2.0F, 1.0F, 39, 12, 24, 0.0F));
    this.bone = new ModelRenderer(this);
    this.bone.setRotationPoint(-10.0F, 2.0F, 25.0F);
    this.Shirt.addChild(this.bone);
    setRotationAngle(this.bone, 0.2182F, 0.0F, 0.0F);
    this.bone.cubeList.add(new ModelBox(this.bone, 114, 114, -20.0F, -25.0F, -5.0F, 39, 25, 5, 0.0F));
    this.Hat = new ModelRenderer(this);
    this.Hat.setRotationPoint(0.0F, -45.0F, 9.0F);
    this.Body.addChild(this.Hat);
    setRotationAngle(this.Hat, -0.7854F, 0.0F, 0.0F);
    this.Hat.cubeList.add(new ModelBox(this.Hat, 164, 144, -5.5F, -1.5F, -5.5F, 11, 3, 11, 0.0F));
    this.Hat.cubeList.add(new ModelBox(this.Hat, 178, 0, -5.0F, -3.5F, -5.0F, 10, 2, 10, 0.0F));
    this.Hat.cubeList.add(new ModelBox(this.Hat, 60, 131, -9.0F, 1.5F, -9.0F, 18, 1, 18, 0.0F));
    this.neck = new ModelRenderer(this);
    this.neck.setRotationPoint(0.0F, -43.0F, 1.0F);
    this.Body.addChild(this.neck);
    setRotationAngle(this.neck, 0.5236F, 0.0F, 0.0F);
    this.neck.cubeList.add(new ModelBox(this.neck, 156, 103, -5.0F, -6.0F, -5.0F, 10, 6, 5, 0.0F));
    this.back = new ModelRenderer(this);
    this.back.setRotationPoint(0.0F, -16.0F, 10.0F);
    this.Body.addChild(this.back);
    setRotationAngle(this.back, 0.2182F, 0.0F, 0.0F);
    this.back.cubeList.add(new ModelBox(this.back, 0, 121, -17.0F, -24.9526F, -3.5671F, 34, 23, 5, 0.0F));
    this.Arms = new ModelRenderer(this);
    this.Arms.setRotationPoint(151.0F, -29.0F, -9.0F);
    this.Body.addChild(this.Arms);
    this.RightArm = new ModelRenderer(this);
    this.RightArm.setRotationPoint(-166.0F, -14.0F, 5.0F);
    this.Arms.addChild(this.RightArm);
    setRotationAngle(this.RightArm, -0.0873F, -1.0908F, -0.1309F);
    this.RightArm.cubeList.add(new ModelBox(this.RightArm, 109, 20, -15.0F, -7.0F, -8.5F, 15, 14, 17, 0.0F));
    this.subarm2 = new ModelRenderer(this);
    this.subarm2.setRotationPoint(-15.0F, 0.0F, 0.5F);
    this.RightArm.addChild(this.subarm2);
    setRotationAngle(this.subarm2, 1.4835F, 0.1309F, 0.0F);
    this.subarm2.cubeList.add(new ModelBox(this.subarm2, 0, 149, -16.0F, -6.0F, -7.0F, 16, 11, 13, 0.0F));
    this.subarm = new ModelRenderer(this);
    this.subarm.setRotationPoint(-16.0F, -6.0F, 0.0F);
    this.subarm2.addChild(this.subarm);
    setRotationAngle(this.subarm, 0.0F, 0.0F, 0.1309F);
    this.subarm.cubeList.add(new ModelBox(this.subarm, 117, 144, -16.0F, 0.0F, -8.0F, 16, 12, 15, 0.0F));
    this.hand = new ModelRenderer(this);
    this.hand.setRotationPoint(-15.077F, 4.3791F, 0.0656F);
    this.subarm.addChild(this.hand);
    setRotationAngle(this.hand, 0.0F, -0.1745F, 1.5272F);
    this.hand.cubeList.add(new ModelBox(this.hand, 58, 150, -4.8109F, 1.3566F, -6.9753F, 12, 5, 15, 0.0F));
    this.thumb = new ModelRenderer(this);
    this.thumb.setRotationPoint(-0.6853F, 0.2798F, -8.9552F);
    this.hand.addChild(this.thumb);
    setRotationAngle(this.thumb, 0.3927F, 1.6144F, 0.0436F);
    this.thumb.cubeList.add(new ModelBox(this.thumb, 45, 149, -5.3434F, 3.5933F, -2.4403F, 4, 4, 7, 0.0F));
    this.fingers = new ModelRenderer(this);
    this.fingers.setRotationPoint(-12.0F, -2.0F, 0.0F);
    this.hand.addChild(this.fingers);
    this.fingers.cubeList.add(new ModelBox(this.fingers, 0, 96, -0.8109F, 3.3566F, -6.9753F, 8, 3, 3, 0.0F));
    this.fingers.cubeList.add(new ModelBox(this.fingers, 0, 96, -0.8109F, 3.3566F, -2.9753F, 8, 3, 3, 0.0F));
    this.fingers.cubeList.add(new ModelBox(this.fingers, 0, 96, -0.8109F, 3.3566F, 1.0247F, 8, 3, 3, 0.0F));
    this.fingers.cubeList.add(new ModelBox(this.fingers, 0, 96, -0.8109F, 3.3566F, 5.0247F, 8, 3, 3, 0.0F));
    this.LeftArm = new ModelRenderer(this);
    this.LeftArm.setRotationPoint(-137.0F, -14.0F, 6.0F);
    this.Arms.addChild(this.LeftArm);
    setRotationAngle(this.LeftArm, -1.7017F, 0.0F, -0.3491F);
    this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 109, 20, 0.0F, -7.0F, -8.5F, 15, 14, 17, 0.0F));
    this.subarm3 = new ModelRenderer(this);
    this.subarm3.setRotationPoint(15.0F, 0.0F, 0.5F);
    this.LeftArm.addChild(this.subarm3);
    this.subarm3.cubeList.add(new ModelBox(this.subarm3, 0, 149, 0.0F, -6.9914F, -7.1305F, 16, 11, 13, 0.0F));
    this.subarm4 = new ModelRenderer(this);
    this.subarm4.setRotationPoint(16.0F, -0.342F, -0.9397F);
    this.subarm3.addChild(this.subarm4);
    setRotationAngle(this.subarm4, -2.8798F, 0.0F, 2.5744F);
    this.subarm4.cubeList.add(new ModelBox(this.subarm4, 117, 144, 0.0F, -6.0F, -8.0F, 16, 12, 15, 0.0F));
    this.hand2 = new ModelRenderer(this);
    this.hand2.setRotationPoint(16.0F, -2.0F, 0.0F);
    this.subarm4.addChild(this.hand2);
    setRotationAngle(this.hand2, 0.0F, 0.0F, 0.0873F);
    this.hand2.cubeList.add(new ModelBox(this.hand2, 58, 150, 0.0F, -2.0F, -8.0F, 12, 5, 15, 0.0F));
    this.thumb2 = new ModelRenderer(this);
    this.thumb2.setRotationPoint(1.5619F, 0.987F, -9.7767F);
    this.hand2.addChild(this.thumb2);
    setRotationAngle(this.thumb2, 2.3126F, -0.3927F, 0.0F);
    this.thumb2.cubeList.add(new ModelBox(this.thumb2, 45, 149, 0.0F, -2.0F, -8.0F, 4, 4, 7, 0.0F));
    this.fingers2 = new ModelRenderer(this);
    this.fingers2.setRotationPoint(12.0F, -2.0F, 0.0F);
    this.hand2.addChild(this.fingers2);
    setRotationAngle(this.fingers2, 0.0F, 0.0F, 1.9635F);
    this.fingers2.cubeList.add(new ModelBox(this.fingers2, 0, 96, 2.0F, -2.0F, -8.0F, 8, 3, 3, 0.0F));
    this.fingers2.cubeList.add(new ModelBox(this.fingers2, 0, 96, 2.0F, -2.0F, -4.0F, 8, 3, 3, 0.0F));
    this.fingers2.cubeList.add(new ModelBox(this.fingers2, 0, 96, 2.0F, -2.0F, 0.0F, 8, 3, 3, 0.0F));
    this.fingers2.cubeList.add(new ModelBox(this.fingers2, 0, 96, 2.0F, -2.0F, 4.0F, 8, 3, 3, 0.0F));
    this.Legs = new ModelRenderer(this);
    this.Legs.setRotationPoint(10.0F, -5.0F, -6.0F);
    this.Legs.cubeList.add(new ModelBox(this.Legs, 102, 0, -25.0F, -2.0F, -1.0F, 30, 4, 16, 0.0F));
    this.Legs.cubeList.add(new ModelBox(this.Legs, 0, 173, -13.0F, -2.0F, 1.0F, 6, 7, 12, 0.0F));
    this.Legs.cubeList.add(new ModelBox(this.Legs, 0, 36, 5.0F, -2.0F, 3.0F, 4, 4, 4, 0.0F));
    this.cloththing = new ModelRenderer(this);
    this.cloththing.setRotationPoint(7.0F, 0.0F, 5.0F);
    this.Legs.addChild(this.cloththing);
    setRotationAngle(this.cloththing, 0.0F, -0.7854F, 0.0F);
    this.cloththing.cubeList.add(new ModelBox(this.cloththing, 0, 0, 0.0F, -1.0F, 0.0F, 9, 24, 0, 0.0F));
    this.RightLeg = new ModelRenderer(this);
    this.RightLeg.setRotationPoint(-19.0F, 2.0F, 7.0F);
    this.Legs.addChild(this.RightLeg);
    this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 159, 37, -7.0F, 11.0F, -7.0F, 14, 3, 14, 0.0F));
    this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 46, 170, -6.0F, 0.0F, -6.0F, 12, 11, 12, 0.0F));
    this.leg = new ModelRenderer(this);
    this.leg.setRotationPoint(-1.0F, 14.0F, 0.0F);
    this.RightLeg.addChild(this.leg);
    setRotationAngle(this.leg, 0.0F, 0.3927F, 0.0F);
    this.leg.cubeList.add(new ModelBox(this.leg, 0, 80, -3.0F, -2.0F, -3.0F, 5, 11, 5, 0.0F));
    this.leg.cubeList.add(new ModelBox(this.leg, 125, 174, -3.5F, 9.0F, -10.0F, 6, 3, 13, 0.0F));
    this.leg.cubeList.add(new ModelBox(this.leg, 94, 171, -4.0F, 12.0F, -11.0F, 7, 1, 15, 0.0F));
    this.LeftLeg = new ModelRenderer(this);
    this.LeftLeg.setRotationPoint(-1.0F, 2.0F, 7.0F);
    this.Legs.addChild(this.LeftLeg);
    this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 159, 37, -7.0F, 11.0F, -7.0F, 14, 3, 14, 0.0F));
    this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 46, 170, -6.0F, 0.0F, -6.0F, 12, 11, 12, 0.0F));
    this.leg2 = new ModelRenderer(this);
    this.leg2.setRotationPoint(1.0F, 14.0F, 0.0F);
    this.LeftLeg.addChild(this.leg2);
    setRotationAngle(this.leg2, 0.0F, -0.3927F, 0.0F);
    this.leg2.cubeList.add(new ModelBox(this.leg2, 0, 80, -2.0F, -2.0F, -3.0F, 5, 11, 5, 0.0F));
    this.leg2.cubeList.add(new ModelBox(this.leg2, 125, 174, -2.5F, 9.0F, -10.0F, 6, 3, 13, 0.0F));
    this.leg2.cubeList.add(new ModelBox(this.leg2, 94, 171, -3.0F, 12.0F, -11.0F, 7, 1, 15, 0.0F));
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    this.Head.rotateAngleY = headYaw / 57.295776F;
    this.Head.rotateAngleX = headPitch / 57.295776F + 0.0872665F;
    this.hand2.rotateAngleX = MathHelper.cos(ageInTicks * 0.1F) * 0.4F;
    this.hand.rotateAngleX = MathHelper.cos(ageInTicks * 0.1F) * 0.4F;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.Head.render(f5);
    this.Body.render(f5);
    this.Legs.render(f5);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public ModelRenderer getHandRenderer() {
    return this.hand2;
  }
}
