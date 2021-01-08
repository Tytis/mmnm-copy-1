package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class leopard extends ModelZoanMorph {
  ModelRenderer body;
  
  ModelRenderer ass;
  
  ModelRenderer face;
  
  ModelRenderer nose;
  
  ModelRenderer orelhaE;
  
  ModelRenderer orelhaD;
  
  ModelRenderer coxaE;
  
  ModelRenderer tibiaE;
  
  ModelRenderer peE;
  
  ModelRenderer armE;
  
  ModelRenderer bracoE;
  
  ModelRenderer handE;
  
  ModelRenderer nailE1;
  
  ModelRenderer nailE2;
  
  ModelRenderer nailE3;
  
  ModelRenderer armD;
  
  ModelRenderer bracoD;
  
  ModelRenderer handD;
  
  ModelRenderer nailD1;
  
  ModelRenderer nailD2;
  
  ModelRenderer nailD3;
  
  ModelRenderer coxaD;
  
  ModelRenderer tibiaD;
  
  ModelRenderer peD;
  
  ModelRenderer tailbase;
  
  ModelRenderer tail1;
  
  ModelRenderer tail2;
  
  ModelRenderer tail3;
  
  ModelRenderer tail4;
  
  ModelRenderer mouth;
  
  ModelRenderer nailBE1;
  
  ModelRenderer nailBE2;
  
  ModelRenderer nailBE3;
  
  ModelRenderer nailBD1;
  
  ModelRenderer nailBD2;
  
  ModelRenderer nailBD3;
  
  public leopard() {
    this.textureWidth = 128;
    this.textureHeight = 128;
    (this.body = new ModelRenderer(this, 3, 3)).addBox(0.0F, 0.0F, 0.0F, 8, 9, 12);
    this.body.setRotationPoint(-4.0F, 9.0F, -6.0F);
    this.body.setTextureSize(128, 128);
    this.body.mirror = true;
    setRotation(this.body, 0.0F, 0.0F, 0.0F);
    (this.ass = new ModelRenderer(this, 3, 30)).addBox(0.0F, 0.0F, 0.0F, 6, 8, 8);
    this.ass.setRotationPoint(-3.0F, 9.5F, 6.0F);
    this.ass.setTextureSize(128, 128);
    this.ass.mirror = true;
    setRotation(this.ass, -0.1745329F, 0.0F, 0.0F);
    (this.face = new ModelRenderer(this, 3, 73)).addBox(-4.0F, -3.0F, -5.0F, 7, 7, 5);
    this.face.setRotationPoint(0.5F, 10.0F, -6.0F);
    this.face.setTextureSize(128, 128);
    this.face.mirror = true;
    setRotation(this.face, 0.0872665F, 0.0F, 0.0F);
    (this.nose = new ModelRenderer(this, 3, 87)).addBox(-2.5F, -2.0F, -8.0F, 4, 3, 4);
    this.nose.setRotationPoint(0.5F, 10.0F, -6.0F);
    this.nose.setTextureSize(128, 128);
    this.nose.mirror = true;
    setRotation(this.nose, 0.2617994F, 0.0F, 0.0F);
    (this.orelhaE = new ModelRenderer(this, 30, 78)).addBox(1.0F, -2.5F, -4.0F, 2, 2, 1);
    this.orelhaE.setRotationPoint(0.5F, 10.0F, -6.0F);
    this.orelhaE.setTextureSize(128, 128);
    this.orelhaE.mirror = true;
    setRotation(this.orelhaE, -0.4363323F, -0.4363323F, 0.0F);
    (this.orelhaD = new ModelRenderer(this, 30, 73)).addBox(-4.0F, -2.5F, -4.0F, 2, 2, 1);
    this.orelhaD.setRotationPoint(0.5F, 10.0F, -6.0F);
    this.orelhaD.setTextureSize(128, 128);
    this.orelhaD.mirror = true;
    setRotation(this.orelhaD, -0.4363323F, 0.4363323F, 0.0F);
    (this.coxaE = new ModelRenderer(this, 54, 51)).addBox(0.0F, 0.0F, -2.0F, 2, 8, 4);
    this.coxaE.setRotationPoint(2.0F, 12.0F, 13.0F);
    this.coxaE.setTextureSize(128, 128);
    this.coxaE.mirror = true;
    setRotation(this.coxaE, -0.5061455F, 0.0F, 0.0F);
    (this.tibiaE = new ModelRenderer(this, 56, 67)).addBox(0.0F, 6.0F, 2.0F, 2, 5, 2);
    this.tibiaE.setRotationPoint(2.0F, 12.0F, 13.0F);
    this.tibiaE.setTextureSize(128, 128);
    this.tibiaE.mirror = true;
    setRotation(this.tibiaE, -0.5061455F, 0.0F, 0.0F);
    (this.peE = new ModelRenderer(this, 54, 78)).addBox(-0.5F, 10.0F, -5.0F, 3, 2, 3);
    this.peE.setRotationPoint(2.0F, 12.0F, 13.0F);
    this.peE.setTextureSize(128, 128);
    this.peE.mirror = true;
    setRotation(this.peE, 0.0F, 0.0F, 0.0F);
    (this.armE = new ModelRenderer(this, 53, 3)).addBox(0.3F, 0.0F, -2.0F, 3, 8, 4);
    this.armE.setRotationPoint(1.0F, 11.0F, -6.0F);
    this.armE.setTextureSize(128, 128);
    this.armE.mirror = true;
    setRotation(this.armE, 0.1745329F, 0.0F, 0.0F);
    (this.bracoE = new ModelRenderer(this, 54, 17)).addBox(0.2F, 7.0F, 0.0F, 3, 5, 3);
    this.bracoE.setRotationPoint(1.0F, 11.0F, -6.0F);
    this.bracoE.setTextureSize(128, 128);
    this.bracoE.mirror = true;
    setRotation(this.bracoE, -0.1047198F, 0.0F, 0.0F);
    (this.handE = new ModelRenderer(this, 52, 28)).addBox(-0.3F, 11.0F, -2.0F, 4, 2, 4);
    this.handE.setRotationPoint(1.0F, 11.0F, -6.0F);
    this.handE.setTextureSize(128, 128);
    this.handE.mirror = true;
    setRotation(this.handE, 0.0F, 0.0F, 0.0F);
    (this.nailE1 = new ModelRenderer(this, 52, 38)).addBox(0.0F, 11.0F, 2.0F, 1, 2, 1);
    this.nailE1.setRotationPoint(1.0F, 11.0F, -6.0F);
    this.nailE1.setTextureSize(128, 128);
    this.nailE1.mirror = true;
    setRotation(this.nailE1, -0.3490659F, 0.0F, 0.0F);
    (this.nailE2 = new ModelRenderer(this, 58, 38)).addBox(1.2F, 11.0F, 2.0F, 1, 2, 1);
    this.nailE2.setRotationPoint(1.0F, 11.0F, -6.0F);
    this.nailE2.setTextureSize(128, 128);
    this.nailE2.mirror = true;
    setRotation(this.nailE2, -0.3490659F, 0.0F, 0.0F);
    (this.nailE3 = new ModelRenderer(this, 64, 38)).addBox(2.4F, 11.0F, 2.0F, 1, 2, 1);
    this.nailE3.setRotationPoint(1.0F, 11.0F, -6.0F);
    this.nailE3.setTextureSize(128, 128);
    this.nailE3.mirror = true;
    setRotation(this.nailE3, -0.3490659F, 0.0F, 0.0F);
    (this.armD = new ModelRenderer(this, 75, 3)).addBox(-3.3F, -0.06666667F, -2.0F, 3, 8, 4);
    this.armD.setRotationPoint(-1.0F, 11.0F, -6.0F);
    this.armD.setTextureSize(128, 128);
    this.armD.mirror = true;
    setRotation(this.armD, 0.1745329F, 0.0F, 0.0F);
    (this.bracoD = new ModelRenderer(this, 76, 17)).addBox(-3.2F, 7.0F, 0.0F, 3, 5, 3);
    this.bracoD.setRotationPoint(-1.0F, 11.0F, -6.0F);
    this.bracoD.setTextureSize(128, 128);
    this.bracoD.mirror = true;
    setRotation(this.bracoD, -0.1047198F, 0.0F, 0.0F);
    (this.handD = new ModelRenderer(this, 74, 28)).addBox(-3.7F, 11.0F, -2.0F, 4, 2, 4);
    this.handD.setRotationPoint(-1.0F, 11.0F, -6.0F);
    this.handD.setTextureSize(128, 128);
    this.handD.mirror = true;
    setRotation(this.handD, 0.0F, 0.0F, 0.0F);
    (this.nailD1 = new ModelRenderer(this, 74, 38)).addBox(-3.4F, 11.0F, 2.0F, 1, 2, 1);
    this.nailD1.setRotationPoint(-1.0F, 11.0F, -6.0F);
    this.nailD1.setTextureSize(128, 128);
    this.nailD1.mirror = true;
    setRotation(this.nailD1, -0.3490659F, 0.0F, 0.0F);
    (this.nailD2 = new ModelRenderer(this, 80, 38)).addBox(-2.2F, 11.0F, 2.0F, 1, 2, 1);
    this.nailD2.setRotationPoint(-1.0F, 11.0F, -6.0F);
    this.nailD2.setTextureSize(128, 128);
    this.nailD2.mirror = true;
    setRotation(this.nailD2, -0.3490659F, 0.0F, 0.0F);
    (this.nailD3 = new ModelRenderer(this, 86, 38)).addBox(-1.0F, 11.0F, 2.0F, 1, 2, 1);
    this.nailD3.setRotationPoint(-1.0F, 11.0F, -6.0F);
    this.nailD3.setTextureSize(128, 128);
    this.nailD3.mirror = true;
    setRotation(this.nailD3, -0.3490659F, 0.0F, 0.0F);
    (this.coxaD = new ModelRenderer(this, 75, 51)).addBox(-2.0F, 0.0F, -2.0F, 2, 8, 4);
    this.coxaD.setRotationPoint(-2.0F, 12.0F, 13.0F);
    this.coxaD.setTextureSize(128, 128);
    this.coxaD.mirror = true;
    setRotation(this.coxaD, -0.5061455F, 0.0F, 0.0F);
    (this.tibiaD = new ModelRenderer(this, 77, 67)).addBox(-2.0F, 6.0F, 2.0F, 2, 5, 2);
    this.tibiaD.setRotationPoint(-2.0F, 12.0F, 13.0F);
    this.tibiaD.setTextureSize(128, 128);
    this.tibiaD.mirror = true;
    setRotation(this.tibiaD, -0.5061455F, 0.0F, 0.0F);
    (this.peD = new ModelRenderer(this, 75, 78)).addBox(-2.5F, 10.0F, -5.0F, 3, 2, 3);
    this.peD.setRotationPoint(-2.0F, 12.0F, 13.0F);
    this.peD.setTextureSize(128, 128);
    this.peD.mirror = true;
    setRotation(this.peD, 0.0F, 0.0F, 0.0F);
    (this.tailbase = new ModelRenderer(this, 5, 110)).addBox(-1.0F, -1.0F, -0.5F, 2, 2, 3);
    this.tailbase.setRotationPoint(0.0F, 12.0F, 13.0F);
    this.tailbase.setTextureSize(128, 128);
    this.tailbase.mirror = true;
    setRotation(this.tailbase, -0.2617994F, 0.0F, 0.0F);
    (this.tail1 = new ModelRenderer(this, 17, 110)).addBox(-1.0F, -1.5F, 2.0F, 2, 2, 3);
    this.tail1.setRotationPoint(0.0F, 12.0F, 13.0F);
    this.tail1.setTextureSize(128, 128);
    this.tail1.mirror = true;
    setRotation(this.tail1, -0.5235988F, 0.0F, 0.0F);
    (this.tail2 = new ModelRenderer(this, 29, 110)).addBox(-1.0F, -2.5F, 4.0F, 2, 2, 3);
    this.tail2.setRotationPoint(0.0F, 12.0F, 13.0F);
    this.tail2.setTextureSize(128, 128);
    this.tail2.mirror = true;
    setRotation(this.tail2, -0.7504916F, 0.0F, 0.0F);
    (this.tail3 = new ModelRenderer(this, 41, 110)).addBox(-1.0F, -3.5F, 6.0F, 2, 2, 3);
    this.tail3.setRotationPoint(0.0F, 12.0F, 13.0F);
    this.tail3.setTextureSize(128, 128);
    this.tail3.mirror = true;
    setRotation(this.tail3, -0.9250245F, 0.0F, 0.0F);
    (this.tail4 = new ModelRenderer(this, 53, 110)).addBox(-1.0F, -2.0F, 9.0F, 2, 2, 3);
    this.tail4.setRotationPoint(0.0F, 12.0F, 13.0F);
    this.tail4.setTextureSize(128, 128);
    this.tail4.mirror = true;
    setRotation(this.tail4, -0.7504916F, 0.0F, 0.0F);
    (this.mouth = new ModelRenderer(this, 20, 88)).addBox(-2.5F, 1.5F, -7.5F, 4, 1, 3);
    this.mouth.setRotationPoint(0.5F, 10.0F, -6.0F);
    this.mouth.setTextureSize(128, 128);
    this.mouth.mirror = true;
    setRotation(this.mouth, 0.2617994F, 0.0F, 0.0F);
    (this.nailBE1 = new ModelRenderer(this, 52, 42)).addBox(-0.7F, 11.2F, -1.5F, 1, 2, 1);
    this.nailBE1.setRotationPoint(2.0F, 12.0F, 13.0F);
    this.nailBE1.setTextureSize(128, 128);
    this.nailBE1.mirror = true;
    setRotation(this.nailBE1, -0.3490659F, 0.0F, 0.0F);
    (this.nailBE2 = new ModelRenderer(this, 58, 42)).addBox(0.5F, 11.2F, -1.5F, 1, 2, 1);
    this.nailBE2.setRotationPoint(2.0F, 12.0F, 13.0F);
    this.nailBE2.setTextureSize(128, 128);
    this.nailBE2.mirror = true;
    setRotation(this.nailBE2, -0.3490659F, 0.0F, 0.0F);
    (this.nailBE3 = new ModelRenderer(this, 64, 42)).addBox(1.7F, 11.2F, -1.5F, 1, 2, 1);
    this.nailBE3.setRotationPoint(2.0F, 12.0F, 13.0F);
    this.nailBE3.setTextureSize(128, 128);
    this.nailBE3.mirror = true;
    setRotation(this.nailBE3, -0.3490659F, 0.0F, 0.0F);
    (this.nailBD1 = new ModelRenderer(this, 74, 42)).addBox(-2.7F, 11.2F, -1.5F, 1, 2, 1);
    this.nailBD1.setRotationPoint(-2.0F, 12.0F, 13.0F);
    this.nailBD1.setTextureSize(128, 128);
    this.nailBD1.mirror = true;
    setRotation(this.nailBD1, -0.3490659F, 0.0F, 0.0F);
    (this.nailBD2 = new ModelRenderer(this, 80, 42)).addBox(-1.5F, 11.2F, -1.5F, 1, 2, 1);
    this.nailBD2.setRotationPoint(-2.0F, 12.0F, 13.0F);
    this.nailBD2.setTextureSize(128, 128);
    this.nailBD2.mirror = true;
    setRotation(this.nailBD2, -0.3490659F, 0.0F, 0.0F);
    (this.nailBD3 = new ModelRenderer(this, 86, 42)).addBox(-0.3F, 11.2F, -1.5F, 1, 2, 1);
    this.nailBD3.setRotationPoint(-2.0F, 12.0F, 13.0F);
    this.nailBD3.setTextureSize(128, 128);
    this.nailBD3.mirror = true;
    setRotation(this.nailBD3, -0.3490659F, 0.0F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.body.render(f5);
    this.ass.render(f5);
    this.face.render(f5);
    this.nose.render(f5);
    this.orelhaE.render(f5);
    this.orelhaD.render(f5);
    this.coxaE.render(f5);
    this.tibiaE.render(f5);
    this.peE.render(f5);
    this.armE.render(f5);
    this.bracoE.render(f5);
    this.handE.render(f5);
    this.nailE1.render(f5);
    this.nailE2.render(f5);
    this.nailE3.render(f5);
    this.armD.render(f5);
    this.bracoD.render(f5);
    this.handD.render(f5);
    this.nailD1.render(f5);
    this.nailD2.render(f5);
    this.nailD3.render(f5);
    this.coxaD.render(f5);
    this.tibiaD.render(f5);
    this.peD.render(f5);
    this.tailbase.render(f5);
    this.tail1.render(f5);
    this.tail2.render(f5);
    this.tail3.render(f5);
    this.tail4.render(f5);
    this.mouth.render(f5);
    this.nailBE1.render(f5);
    this.nailBE2.render(f5);
    this.nailBE3.render(f5);
    this.nailBD1.render(f5);
    this.nailBD2.render(f5);
    this.nailBD3.render(f5);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    this.face.rotateAngleY = headYaw / 57.295776F;
    this.face.rotateAngleX = headPitch / 57.295776F + 0.0872665F;
    this.nose.rotateAngleY = headYaw / 57.295776F;
    this.nose.rotateAngleX = headPitch / 57.295776F + 0.2617994F;
    this.orelhaE.rotateAngleY = headYaw / 57.295776F - 0.4363323F;
    this.orelhaE.rotateAngleX = headPitch / 57.295776F - 0.4363323F;
    this.orelhaD.rotateAngleY = headYaw / 57.295776F + 0.4363323F;
    this.orelhaD.rotateAngleX = headPitch / 57.295776F - 0.4363323F;
    this.mouth.rotateAngleY = headYaw / 57.295776F;
    this.mouth.rotateAngleX = headPitch / 57.295776F + 0.2617994F;
    this.tailbase.rotateAngleZ = headYaw / 57.295776F;
    this.tail1.rotateAngleZ = headYaw / 57.295776F;
    this.tail2.rotateAngleZ = headYaw / 57.295776F;
    this.tail3.rotateAngleZ = headYaw / 57.295776F;
    this.tail4.rotateAngleZ = headYaw / 57.295776F;
    if (ent.isSneaking()) {
      this.body.rotateAngleX = -0.2094395F;
      this.ass.setRotationPoint(-3.0F, 11.5F, 5.0F);
      this.ass.rotateAngleX = -0.4363323F;
      this.face.rotateAngleX = -0.0872665F;
      this.nose.rotateAngleX = 0.0872665F;
      this.mouth.rotateAngleX = 0.0872665F;
      this.coxaE.setRotationPoint(2.0F, 16.0F, 13.0F);
      this.coxaE.rotateAngleX = -0.7853982F;
      this.tibiaE.setRotationPoint(2.0F, 16.0F, 13.0F);
      this.tibiaE.rotateAngleX = -1.117011F;
      this.peE.setRotationPoint(2.0F, 12.0F, 8.0F);
      this.peE.rotateAngleX = 0.0F;
      this.nailBE1.setRotationPoint(2.0F, 12.0F, 8.0F);
      this.nailBE1.rotateAngleX = -0.3490659F;
      this.nailBE2.setRotationPoint(2.0F, 12.0F, 8.0F);
      this.nailBE2.rotateAngleX = -0.3490659F;
      this.nailBE3.setRotationPoint(2.0F, 12.0F, 8.0F);
      this.nailBE3.rotateAngleX = -0.3490659F;
      this.coxaD.setRotationPoint(-2.0F, 16.0F, 13.0F);
      this.coxaD.rotateAngleX = -0.7853982F;
      this.tibiaD.setRotationPoint(-2.0F, 16.0F, 13.0F);
      this.tibiaD.rotateAngleX = -1.117011F;
      this.peD.setRotationPoint(-2.0F, 12.0F, 8.0F);
      this.peD.rotateAngleX = 0.0F;
      this.nailBD1.setRotationPoint(-2.0F, 12.0F, 8.0F);
      this.nailBD1.rotateAngleX = -0.3490659F;
      this.nailBD2.setRotationPoint(-2.0F, 12.0F, 8.0F);
      this.nailBD2.rotateAngleX = -0.3490659F;
      this.nailBD3.setRotationPoint(-2.0F, 12.0F, 8.0F);
      this.nailBD3.rotateAngleX = -0.3490659F;
      this.armE.rotateAngleX = 0.1745329F;
      this.bracoE.rotateAngleX = -0.1047198F;
      this.handE.rotateAngleX = 0.0F;
      this.nailE1.rotateAngleX = -0.3490659F;
      this.nailE2.rotateAngleX = -0.3490659F;
      this.nailE3.rotateAngleX = -0.3490659F;
      this.armD.rotateAngleX = 0.1745329F;
      this.bracoD.rotateAngleX = -0.1047198F;
      this.handD.rotateAngleX = 0.0F;
      this.nailD1.rotateAngleX = -0.3490659F;
      this.nailD2.rotateAngleX = -0.3490659F;
      this.nailD3.rotateAngleX = -0.3490659F;
      this.tailbase.setRotationPoint(0.0F, 17.0F, 11.0F);
      this.tailbase.rotateAngleX = -0.5061455F;
      this.tail1.setRotationPoint(0.0F, 17.0F, 11.0F);
      this.tail1.rotateAngleX = -0.7679449F;
      this.tail2.setRotationPoint(0.0F, 17.0F, 11.0F);
      this.tail2.rotateAngleX = -1.012291F;
      this.tail3.setRotationPoint(0.0F, 19.5F, 10.0F);
      this.tail3.rotateAngleX = -0.8028515F;
      this.tail4.setRotationPoint(0.0F, 23.5F, 8.0F);
      this.tail4.rotateAngleX = -0.0698132F;
    } else {
      this.body.rotateAngleX = 0.0F;
      this.ass.setRotationPoint(-3.0F, 9.5F, 6.0F);
      this.ass.rotateAngleX = -0.1745329F;
      this.armE.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount + 0.1745329F;
      this.bracoE.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.1047198F;
      this.handE.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
      this.nailE1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.nailE2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.nailE3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.armD.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount + 0.1745329F;
      this.bracoD.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.1047198F;
      this.handD.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount;
      this.nailD1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.nailD2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.nailD3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.coxaE.setRotationPoint(2.0F, 12.0F, 13.0F);
      this.tibiaE.setRotationPoint(2.0F, 12.0F, 13.0F);
      this.peE.setRotationPoint(2.0F, 12.0F, 13.0F);
      this.nailBE1.setRotationPoint(2.0F, 12.0F, 13.0F);
      this.nailBE2.setRotationPoint(2.0F, 12.0F, 13.0F);
      this.nailBE3.setRotationPoint(2.0F, 12.0F, 13.0F);
      this.coxaE.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.5061455F;
      this.tibiaE.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.5061455F;
      this.peE.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
      this.nailBE1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.nailBE2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.nailBE3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.coxaD.setRotationPoint(-2.0F, 12.0F, 13.0F);
      this.tibiaD.setRotationPoint(-2.0F, 12.0F, 13.0F);
      this.peD.setRotationPoint(-2.0F, 12.0F, 13.0F);
      this.nailBD1.setRotationPoint(-2.0F, 12.0F, 13.0F);
      this.nailBD2.setRotationPoint(-2.0F, 12.0F, 13.0F);
      this.nailBD3.setRotationPoint(-2.0F, 12.0F, 13.0F);
      this.coxaD.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.5061455F;
      this.tibiaD.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.5061455F;
      this.peD.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount;
      this.nailBD1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.nailBD2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.nailBD3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.2F * limbSwingAmount - 0.3490659F;
      this.tailbase.setRotationPoint(0.0F, 12.0F, 13.0F);
      this.tailbase.rotateAngleX = -0.2617994F;
      this.tail1.setRotationPoint(0.0F, 12.0F, 13.0F);
      this.tail1.rotateAngleX = -0.5235988F;
      this.tail2.setRotationPoint(0.0F, 12.0F, 13.0F);
      this.tail2.rotateAngleX = -0.7504916F;
      this.tail3.setRotationPoint(0.0F, 12.0F, 13.0F);
      this.tail3.rotateAngleX = -0.9250245F;
      this.tail4.setRotationPoint(0.0F, 12.0F, 13.0F);
      this.tail4.rotateAngleX = -0.7504916F;
    } 
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public ModelRenderer getHandRenderer() {
    return null;
  }
}
