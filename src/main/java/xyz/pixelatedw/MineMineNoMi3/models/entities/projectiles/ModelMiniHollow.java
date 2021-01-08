package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMiniHollow extends ModelBase {
  public ModelRenderer head;
  
  public ModelRenderer body;
  
  public ModelRenderer rightarm;
  
  public ModelRenderer leftarm;
  
  public ModelRenderer rightleg;
  
  public ModelRenderer rightleg_1;
  
  public ModelMiniHollow() {
    this.textureWidth = 64;
    this.textureHeight = 32;
    this.rightleg_1 = new ModelRenderer(this, 19, 0);
    this.rightleg_1.setRotationPoint(0.6F, 10.1F, 0.5F);
    this.rightleg_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    setRotateAngle(this.rightleg_1, 0.0F, -0.0F, -0.61086524F);
    this.rightarm = new ModelRenderer(this, 14, 0);
    this.rightarm.setRotationPoint(0.5F, 7.7F, 0.5F);
    this.rightarm.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.rightarm, 0.0F, -0.0F, 0.9424778F);
    this.body = new ModelRenderer(this, 9, 0);
    this.body.setRotationPoint(0.5F, 8.0F, 0.5F);
    this.body.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.head = new ModelRenderer(this, 0, 0);
    this.head.setRotationPoint(0.0F, 6.0F, 0.0F);
    this.head.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
    this.rightleg = new ModelRenderer(this, 19, 0);
    this.rightleg.setRotationPoint(0.6F, 9.5F, 0.5F);
    this.rightleg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    setRotateAngle(this.rightleg, 0.0F, -0.0F, 0.61086524F);
    this.leftarm = new ModelRenderer(this, 14, 0);
    this.leftarm.setRotationPoint(1.0F, 8.5F, 0.5F);
    this.leftarm.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.leftarm, 0.0F, -0.0F, -0.9424778F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.rightleg_1.render(f5);
    this.rightarm.render(f5);
    this.body.render(f5);
    this.head.render(f5);
    this.rightleg.render(f5);
    this.leftarm.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
