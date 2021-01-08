package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class buddha extends ModelZoanMorph {
  private final ModelRenderer Body;
  
  private final ModelRenderer chest;
  
  private final ModelRenderer neck;
  
  private final ModelRenderer RightArm;
  
  private final ModelRenderer subarm;
  
  private final ModelRenderer hand;
  
  private final ModelRenderer thumb;
  
  private final ModelRenderer fingers;
  
  private final ModelRenderer LeftArm;
  
  private final ModelRenderer subarm2;
  
  private final ModelRenderer hand2;
  
  private final ModelRenderer thumb2;
  
  private final ModelRenderer fingers2;
  
  private final ModelRenderer Head;
  
  private final ModelRenderer nose;
  
  private final ModelRenderer afro;
  
  private final ModelRenderer RightLeg;
  
  private final ModelRenderer LeftLeg;
  
  public buddha() {
    this.textureWidth = 256;
    this.textureHeight = 256;
    this.Body = new ModelRenderer(this);
    this.Body.setRotationPoint(1.0F, 24.0F, 0.0F);
    this.Body.cubeList.add(new ModelBox(this.Body, 0, 112, -21.0F, -91.0F, -9.0F, 40, 24, 24, 0.0F));
    this.Body.cubeList.add(new ModelBox(this.Body, 140, 80, -8.0F, -96.0F, -3.0F, 14, 5, 5, 0.0F));
    this.Body.cubeList.add(new ModelBox(this.Body, 0, 50, -21.0F, -67.0F, -15.0F, 40, 32, 30, 0.0F));
    this.Body.cubeList.add(new ModelBox(this.Body, 0, 0, -23.0F, -40.0F, -17.0F, 44, 15, 35, 0.0F));
    this.Body.offsetY++;
    this.chest = new ModelRenderer(this);
    this.chest.setRotationPoint(-1.0F, -67.0F, -15.0F);
    this.Body.addChild(this.chest);
    setRotationAngle(this.chest, -0.2443F, 0.0F, 0.0F);
    this.chest.cubeList.add(new ModelBox(this.chest, 110, 50, -20.0F, -24.0F, 0.0F, 40, 24, 6, 0.0F));
    this.neck = new ModelRenderer(this);
    this.neck.setRotationPoint(-1.0F, -91.0F, 13.0F);
    this.Body.addChild(this.neck);
    setRotationAngle(this.neck, 0.3927F, 0.0F, 0.0F);
    this.neck.cubeList.add(new ModelBox(this.neck, 149, 182, -7.0F, -10.3827F, -9.9239F, 14, 10, 5, 0.0F));
    this.RightArm = new ModelRenderer(this);
    this.RightArm.setRotationPoint(-21.0F, -91.0F, 2.0F);
    this.Body.addChild(this.RightArm);
    setRotationAngle(this.RightArm, 0.0F, 0.0F, -0.7854F);
    this.RightArm.cubeList.add(new ModelBox(this.RightArm, 123, 0, -28.0F, 0.0F, -7.0F, 28, 14, 14, 0.0F));
    this.subarm = new ModelRenderer(this);
    this.subarm.setRotationPoint(-28.0F, 0.0F, 0.0F);
    this.RightArm.addChild(this.subarm);
    setRotationAngle(this.subarm, 0.0F, 0.0F, -0.5236F);
    this.subarm.cubeList.add(new ModelBox(this.subarm, 122, 94, -27.0F, 0.0F, -9.0F, 27, 17, 18, 0.0F));
    this.hand = new ModelRenderer(this);
    this.hand.setRotationPoint(-27.0F, 4.0F, 0.0F);
    this.subarm.addChild(this.hand);
    setRotationAngle(this.hand, 0.0F, 0.0F, -0.3927F);
    this.hand.cubeList.add(new ModelBox(this.hand, 0, 160, -14.0F, 0.0F, -10.0F, 14, 8, 19, 0.0F));
    this.thumb = new ModelRenderer(this);
    this.thumb.setRotationPoint(-1.0F, 5.0F, -10.0F);
    this.hand.addChild(this.thumb);
    setRotationAngle(this.thumb, 0.0F, 0.8727F, -0.4363F);
    this.thumb.cubeList.add(new ModelBox(this.thumb, 0, 50, -4.0F, -2.0F, -8.0F, 4, 4, 9, 0.0F));
    this.fingers = new ModelRenderer(this);
    this.fingers.setRotationPoint(-14.0F, 3.0F, -0.5F);
    this.hand.addChild(this.fingers);
    setRotationAngle(this.fingers, 0.0F, 0.0F, -0.7854F);
    this.fingers.cubeList.add(new ModelBox(this.fingers, 0, 23, -9.0F, 0.0F, -9.5F, 9, 4, 4, 0.0F));
    this.fingers.cubeList.add(new ModelBox(this.fingers, 0, 23, -9.0F, 0.0F, -4.5F, 9, 4, 4, 0.0F));
    this.fingers.cubeList.add(new ModelBox(this.fingers, 0, 23, -9.0F, 0.0F, 0.5F, 9, 4, 4, 0.0F));
    this.fingers.cubeList.add(new ModelBox(this.fingers, 0, 23, -9.0F, 0.0F, 5.5F, 9, 4, 4, 0.0F));
    this.LeftArm = new ModelRenderer(this);
    this.LeftArm.setRotationPoint(19.0F, -91.0F, 2.0F);
    this.Body.addChild(this.LeftArm);
    setRotationAngle(this.LeftArm, 0.0F, 0.0F, 0.7854F);
    this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 123, 0, 0.0F, 0.0F, -7.0F, 28, 14, 14, 0.0F));
    this.subarm2 = new ModelRenderer(this);
    this.subarm2.setRotationPoint(28.0F, 0.0F, 0.0F);
    this.LeftArm.addChild(this.subarm2);
    setRotationAngle(this.subarm2, 0.0F, 0.0F, 0.5236F);
    this.subarm2.cubeList.add(new ModelBox(this.subarm2, 122, 94, 0.0F, 0.0F, -9.0F, 27, 17, 18, 0.0F));
    this.hand2 = new ModelRenderer(this);
    this.hand2.setRotationPoint(27.0F, 4.0F, 0.0F);
    this.subarm2.addChild(this.hand2);
    setRotationAngle(this.hand2, 0.0F, 0.0F, 0.3927F);
    this.hand2.cubeList.add(new ModelBox(this.hand2, 0, 160, 0.0F, 0.0F, -10.0F, 14, 8, 19, 0.0F));
    this.thumb2 = new ModelRenderer(this);
    this.thumb2.setRotationPoint(1.0F, 5.0F, -10.0F);
    this.hand2.addChild(this.thumb2);
    setRotationAngle(this.thumb2, 0.4363F, -0.8727F, 0.0F);
    this.thumb2.cubeList.add(new ModelBox(this.thumb2, 0, 50, 0.0F, -2.0F, -8.0F, 4, 4, 9, 0.0F));
    this.fingers2 = new ModelRenderer(this);
    this.fingers2.setRotationPoint(14.0F, 3.0F, -0.5F);
    this.hand2.addChild(this.fingers2);
    setRotationAngle(this.fingers2, 0.0F, 0.0F, 0.7854F);
    this.fingers2.cubeList.add(new ModelBox(this.fingers2, 0, 23, 0.0F, 0.0F, -9.5F, 9, 4, 4, 0.0F));
    this.fingers2.cubeList.add(new ModelBox(this.fingers2, 0, 23, 0.0F, 0.0F, -4.5F, 9, 4, 4, 0.0F));
    this.fingers2.cubeList.add(new ModelBox(this.fingers2, 0, 23, 0.0F, 0.0F, 0.5F, 9, 4, 4, 0.0F));
    this.fingers2.cubeList.add(new ModelBox(this.fingers2, 0, 23, 0.0F, 0.0F, 5.5F, 9, 4, 4, 0.0F));
    this.Head = new ModelRenderer(this);
    this.Head.setRotationPoint(0.0F, -72.0F, 1.0F);
    setRotationAngle(this.Head, 0.2618F, 0.0F, 0.0F);
    this.Head.cubeList.add(new ModelBox(this.Head, 114, 165, -5.0F, -10.0F, -9.0F, 10, 12, 10, 0.0F));
    this.Head.cubeList.add(new ModelBox(this.Head, 98, 64, -0.5F, -8.0F, -9.05F, 1, 1, 0, 0.0F));
    this.Head.cubeList.add(new ModelBox(this.Head, 154, 165, -6.0F, -10.0F, -6.5F, 12, 10, 7, 0.0F));
    this.Head.offsetY++;
    this.nose = new ModelRenderer(this);
    this.nose.setRotationPoint(0.0F, -5.0F, -9.0F);
    this.Head.addChild(this.nose);
    setRotationAngle(this.nose, -0.3927F, 0.0F, 0.0F);
    this.nose.cubeList.add(new ModelBox(this.nose, 47, 71, -1.0F, -1.0F, -0.5F, 2, 4, 2, 0.0F));
    this.afro = new ModelRenderer(this);
    this.afro.setRotationPoint(0.0F, -9.0F, 5.0F);
    this.Head.addChild(this.afro);
    setRotationAngle(this.afro, 0.7854F, 0.0F, 0.0F);
    this.afro.cubeList.add(new ModelBox(this.afro, 128, 129, -9.0F, -13.0F, -10.0F, 18, 18, 18, 0.0F));
    this.RightLeg = new ModelRenderer(this);
    this.RightLeg.setRotationPoint(-12.0F, -11.0F, 3.0F);
    setRotationAngle(this.RightLeg, 0.0F, 0.3927F, 0.0F);
    this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 66, 160, -6.0F, 0.0F, -6.0F, 12, 18, 12, 0.0F));
    this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 0, 0, -4.0F, 16.0F, -5.9F, 8, 15, 8, 0.0F));
    this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 158, 28, -5.0F, 31.0F, -15.0F, 10, 4, 18, 0.0F));
    this.LeftLeg = new ModelRenderer(this);
    this.LeftLeg.setRotationPoint(12.0F, -11.0F, 3.0F);
    setRotationAngle(this.LeftLeg, 0.0F, -0.3927F, 0.0F);
    this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 66, 160, -6.0F, 0.0F, -6.0F, 12, 18, 12, 0.0F));
    this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 0, 0, -4.0F, 16.0F, -5.9F, 8, 15, 8, 0.0F));
    this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 158, 28, -5.0F, 31.0F, -15.0F, 10, 4, 18, 0.0F));
    this.LeftLeg.offsetY = (float)(this.LeftLeg.offsetY + 0.9D);
    this.RightLeg.offsetY = (float)(this.RightLeg.offsetY + 0.9D);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.Body.render(f5);
    this.Head.render(f5);
    this.RightLeg.render(f5);
    this.LeftLeg.render(f5);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public boolean isMoving() {
    return ((Minecraft.getMinecraft()).gameSettings.keyBindForward.isPressed() || 
      (Minecraft.getMinecraft()).gameSettings.keyBindBack.isPressed() || 
      (Minecraft.getMinecraft()).gameSettings.keyBindLeft.isPressed() || 
      (Minecraft.getMinecraft()).gameSettings.keyBindRight.isPressed() || 
      (Minecraft.getMinecraft()).thePlayer.movementInput.moveForward != 0.0F || 
      (Minecraft.getMinecraft()).thePlayer.movementInput.moveStrafe != 0.0F);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    EntityLivingBase entity = (EntityLivingBase)ent;
    this.Head.rotateAngleY = headYaw / 85.943665F;
    this.Head.rotateAngleX = headPitch / 114.59155F;
    if (ent.onGround && isMoving()) {
      this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6F) * 0.8F * limbSwingAmount;
      this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6F + 3.1415927F) * 0.8F * limbSwingAmount;
      this.LeftArm.rotateAngleX = degToRad(65.0D);
      this.RightArm.rotateAngleX = degToRad(65.0D);
      this.LeftArm.rotateAngleZ = degToRad(57.0D);
      this.RightArm.rotateAngleZ = degToRad(-57.0D);
      this.RightArm.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
      this.LeftArm.rotateAngleY = -MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.4F * limbSwingAmount;
    } 
    if (entity.isSwingInProgress) {
      this.RightArm.rotateAngleY = MathHelper.sin(entity.swingProgress * 3.0F + 3.1415927F) * 1.2F;
      this.RightArm.rotateAngleZ = -MathHelper.cos(entity.swingProgress * 4.0F + 3.1415927F) * 0.2F;
    } 
    if (ent.getDistance(ent.prevPosX, ent.prevPosY, ent.prevPosZ) <= 0.10000000149011612D && !entity.isSwingInProgress && ent.onGround) {
      this.RightArm.rotateAngleX = 1.134F;
      this.RightArm.rotateAngleY = -0.261F;
      this.RightArm.rotateAngleZ = -0.994F;
    } 
  }
  
  protected float degToRad(double degrees) {
    return (float)(degrees * Math.PI / 180.0D);
  }
  
  public ModelRenderer getHandRenderer() {
    return this.RightArm;
  }
}
