package xyz.pixelatedw.MineMineNoMi3.models.entities.zoans;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class thundercloud extends ModelBase {
  private final ModelRenderer bone;
  
  private final ModelRenderer bone2;
  
  public thundercloud() {
    this.textureWidth = 336;
    this.textureHeight = 336;
    this.bone = new ModelRenderer(this);
    this.bone.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -25.0F, -32.0F, -24.0F, 48, 32, 48, 0.8F));
    this.bone.cubeList.add(new ModelBox(this.bone, 0, 80, -25.0F, -32.0F, -24.0F, 48, 32, 48, 0.3F));
    this.bone2 = new ModelRenderer(this);
    this.bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.bone2.cubeList.add(new ModelBox(this.bone2, 148, 148, -23.0F, -28.0F, -22.0F, 44, 26, 44, 0.5F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 96, 210, 8.0F, -30.0F, -9.0F, 15, 10, 13, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 207, 94, 8.0F, -5.0F, -9.0F, 15, 5, 13, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 144, 0, -11.0F, -31.0F, -9.0F, 20, 10, 18, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 144, 80, -11.0F, -5.0F, -9.0F, 20, 5, 18, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 207, 15, -26.0F, -30.0F, -9.0F, 15, 10, 13, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 207, 94, -26.0F, -4.0F, -9.0F, 15, 5, 13, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 213, 8.0F, -30.0F, 11.0F, 14, 10, 13, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 204, 218, 8.0F, -5.0F, 11.0F, 14, 5, 13, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 152, 218, -25.0F, -30.0F, 11.0F, 13, 10, 13, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 204, 218, -26.0F, -5.0F, 11.0F, 14, 5, 13, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 55, 179, 8.0F, -31.0F, -24.0F, 16, 10, 15, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 202, 74, 8.0F, -5.0F, -24.0F, 16, 5, 15, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 160, -11.0F, -32.0F, -25.0F, 19, 8, 16, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -3.0F, -16.0F, -24.0F, 3, 3, 16, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 70, 160, -11.0F, -4.0F, -25.0F, 19, 3, 16, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 144, 103, -12.0F, -32.0F, 9.0F, 20, 9, 16, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 144, 28, -12.0F, -5.0F, 9.0F, 20, 4, 16, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 189, -26.0F, -31.0F, -24.0F, 16, 9, 15, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 47, 204, -26.0F, -5.0F, -24.0F, 16, 4, 15, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 125, 164, 7.0F, -31.0F, 4.0F, 16, 11, 15, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 201, 113, 7.0F, -6.0F, 4.0F, 16, 6, 15, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 192, 48, -26.0F, -31.0F, 4.0F, 15, 11, 15, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 201, 113, -27.0F, -5.0F, 4.0F, 16, 6, 15, 0.0F));
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.bone.render(f5);
    this.bone2.render(f5);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
