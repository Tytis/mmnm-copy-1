package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelLaser extends ModelBase {
  private static final ResourceLocation texture = new ResourceLocation("textures/entity/beacon_beam.png");
  
  private final ModelRenderer body;
  
  public ModelLaser() {
    this.textureWidth = 64;
    this.textureHeight = 64;
    this.body = new ModelRenderer(this, 0, 0);
    this.body.addBox(-0.5F, 0.0F, -5.0F, 10, 1, 10, 0.0F);
  }
  
  public void render(Entity entity, float d0, float d1, float d2, float f, float f1, float f5s) {
    this.body.render(f5s);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
