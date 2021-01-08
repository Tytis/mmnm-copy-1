package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSolar extends ModelBase {
  private final ModelRenderer bone6;
  
  private final ModelRenderer bone5;
  
  private final ModelRenderer bone4;
  
  private final ModelRenderer bone3;
  
  private final ModelRenderer bone2;
  
  private final ModelRenderer bone;
  
  private final ModelRenderer cube_r1;
  
  private final ModelRenderer cube_r2;
  
  private final ModelRenderer cube_r3;
  
  private final ModelRenderer cube_r4;
  
  private final ModelRenderer cube_r5;
  
  private final ModelRenderer cube_r6;
  
  public ModelSolar() {
    this.textureWidth = 288;
    this.textureHeight = 288;
    this.bone6 = new ModelRenderer(this);
    this.bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.bone5 = new ModelRenderer(this);
    this.bone5.setRotationPoint(0.0F, -1.0F, 17.0F);
    this.bone6.addChild(this.bone5);
    setRotationAngle(this.bone5, 1.5708F, 0.0F, 0.0F);
    this.bone5.cubeList.add(new ModelBox(this.bone5, 218, 218, -12.0F, -28.0F, -3.0F, 24, 24, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 232, 119, -11.0F, -4.0F, -3.0F, 22, 1, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 66, -12.0F, -3.0F, -2.0F, 24, 1, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 63, -13.0F, -31.0F, -1.0F, 26, 1, 2, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 60, -13.0F, -2.0F, -1.0F, 26, 1, 2, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 232, 117, -11.0F, -29.0F, -3.0F, 22, 1, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 150, 239, 12.0F, -27.0F, -3.0F, 1, 22, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 144, 0, 13.0F, -28.0F, -2.0F, 1, 24, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 60, 28, 14.0F, -29.0F, -1.0F, 1, 26, 2, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 60, 0, -15.0F, -29.0F, -1.0F, 1, 26, 2, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 36, 100, -14.0F, -28.0F, -2.0F, 1, 24, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 54, 204, -13.0F, -27.0F, -3.0F, 1, 22, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 0, -14.0F, -30.0F, -1.0F, 28, 28, 2, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 60, 174, -13.0F, -29.0F, -2.0F, 26, 26, 1, 0.0F));
    this.bone4 = new ModelRenderer(this);
    this.bone4.setRotationPoint(-14.0F, -11.0F, 16.0F);
    this.bone6.addChild(this.bone4);
    setRotationAngle(this.bone4, 0.0F, 1.5708F, 0.0F);
    this.bone4.cubeList.add(new ModelBox(this.bone4, 168, 210, 3.0F, -17.0F, -4.0F, 24, 24, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 232, 123, 4.0F, 7.0F, -4.0F, 22, 1, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 218, 210, 3.0F, 8.0F, -3.0F, 24, 1, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 132, 66, 3.0F, -19.0F, -3.0F, 24, 1, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 132, 57, 2.0F, -20.0F, -2.0F, 26, 1, 2, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 112, 130, 2.0F, 9.0F, -2.0F, 26, 1, 2, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 232, 121, 4.0F, -18.0F, -4.0F, 22, 1, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 158, 239, 27.0F, -16.0F, -4.0F, 1, 22, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 152, 0, 28.0F, -17.0F, -3.0F, 1, 24, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 100, 29.0F, -18.0F, -2.0F, 1, 26, 2, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 100, 0.0F, -18.0F, -2.0F, 1, 26, 2, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 148, 0, 1.0F, -17.0F, -3.0F, 1, 24, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 154, 239, 2.0F, -16.0F, -4.0F, 1, 22, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 30, 1.0F, -19.0F, -2.0F, 28, 28, 2, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 200, 57, 2.0F, -18.0F, -3.0F, 26, 26, 1, 0.0F));
    this.bone3 = new ModelRenderer(this);
    this.bone3.setRotationPoint(14.0F, -11.0F, -14.0F);
    this.bone6.addChild(this.bone3);
    setRotationAngle(this.bone3, 0.0F, -1.5708F, 0.0F);
    this.bone3.cubeList.add(new ModelBox(this.bone3, 54, 228, 3.0F, -17.0F, -4.0F, 24, 24, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 232, 127, 4.0F, 7.0F, -4.0F, 22, 1, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 218, 214, 3.0F, 8.0F, -3.0F, 24, 1, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 218, 212, 3.0F, -19.0F, -3.0F, 24, 1, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 132, 63, 2.0F, -20.0F, -2.0F, 26, 1, 2, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 132, 60, 2.0F, 9.0F, -2.0F, 26, 1, 2, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 232, 125, 4.0F, -18.0F, -4.0F, 22, 1, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 166, 239, 27.0F, -16.0F, -4.0F, 1, 22, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 214, 235, 28.0F, -17.0F, -3.0F, 1, 24, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 100, 29.0F, -18.0F, -2.0F, 1, 26, 2, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 12, 100, 0.0F, -18.0F, -2.0F, 1, 26, 2, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 156, 0, 1.0F, -17.0F, -3.0F, 1, 24, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 162, 239, 2.0F, -16.0F, -4.0F, 1, 22, 1, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 112, 100, 1.0F, -19.0F, -2.0F, 28, 28, 2, 0.0F));
    this.bone3.cubeList.add(new ModelBox(this.bone3, 60, 201, 2.0F, -18.0F, -3.0F, 26, 26, 1, 0.0F));
    this.bone2 = new ModelRenderer(this);
    this.bone2.setRotationPoint(0.0F, -31.0F, -15.0F);
    this.bone6.addChild(this.bone2);
    setRotationAngle(this.bone2, -1.5708F, 0.0F, 0.0F);
    this.bone2.cubeList.add(new ModelBox(this.bone2, 228, 130, -12.0F, -28.0F, -3.0F, 24, 24, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 104, 237, -11.0F, -4.0F, -3.0F, 22, 1, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 228, 168, -12.0F, -3.0F, -2.0F, 24, 1, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 218, 216, -12.0F, -30.0F, -2.0F, 24, 1, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 166, 131, -13.0F, -31.0F, -1.0F, 26, 1, 2, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 112, 133, -13.0F, -2.0F, -1.0F, 26, 1, 2, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 168, 235, -11.0F, -29.0F, -3.0F, 22, 1, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 174, 239, 12.0F, -27.0F, -3.0F, 1, 22, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 200, 237, 13.0F, -28.0F, -2.0F, 1, 24, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 30, 100, 14.0F, -29.0F, -1.0F, 1, 26, 2, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 100, -15.0F, -29.0F, -1.0F, 1, 26, 2, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 196, 237, -14.0F, -28.0F, -2.0F, 1, 24, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 170, 239, -13.0F, -27.0F, -3.0F, 1, 22, 1, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 172, 100, -14.0F, -30.0F, -1.0F, 28, 28, 2, 0.0F));
    this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 204, -13.0F, -29.0F, -2.0F, 26, 26, 1, 0.0F));
    this.bone = new ModelRenderer(this);
    this.bone.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone6.addChild(this.bone);
    this.bone.cubeList.add(new ModelBox(this.bone, 132, 0, -14.0F, -30.0F, -13.0F, 28, 28, 29, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 217, 0, -12.0F, -28.0F, -17.0F, 24, 24, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 59, 59, -1.0F, -17.0F, -18.0F, 3, 3, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 104, 239, -11.0F, -4.0F, -17.0F, 22, 1, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 228, 172, -12.0F, -3.0F, -16.0F, 24, 1, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 228, 170, -12.0F, -30.0F, -16.0F, 24, 1, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 217, 25, -13.0F, -31.0F, -15.0F, 26, 1, 2, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 166, 134, -13.0F, -2.0F, -15.0F, 26, 1, 2, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 150, 237, -11.0F, -29.0F, -17.0F, 22, 1, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 182, 239, 12.0F, -27.0F, -17.0F, 1, 22, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 208, 237, 13.0F, -28.0F, -16.0F, 1, 24, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 138, 0, 14.0F, -29.0F, -15.0F, 1, 26, 2, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 132, 0, -15.0F, -29.0F, -15.0F, 1, 26, 2, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 204, 237, -14.0F, -28.0F, -16.0F, 1, 24, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 178, 239, -13.0F, -27.0F, -17.0F, 1, 22, 1, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 0, 174, -14.0F, -30.0F, -15.0F, 28, 28, 2, 0.0F));
    this.bone.cubeList.add(new ModelBox(this.bone, 114, 210, -13.0F, -29.0F, -16.0F, 26, 26, 1, 0.0F));
    this.cube_r1 = new ModelRenderer(this);
    this.cube_r1.setRotationPoint(4.0F, -18.0F, -17.0F);
    this.bone.addChild(this.cube_r1);
    setRotationAngle(this.cube_r1, 0.0F, 0.1309F, -0.1309F);
    this.cube_r1.cubeList.add(new ModelBox(this.cube_r1, 0, 231, -3.0F, -3.0F, 0.0F, 15, 8, 12, 0.0F));
    this.cube_r2 = new ModelRenderer(this);
    this.cube_r2.setRotationPoint(-3.0F, -18.0F, -17.0F);
    this.bone.addChild(this.cube_r2);
    setRotationAngle(this.cube_r2, 0.0F, -0.1309F, 0.1309F);
    this.cube_r2.cubeList.add(new ModelBox(this.cube_r2, 232, 84, -13.0F, -3.0F, 0.0F, 15, 8, 12, 0.0F));
    this.cube_r3 = new ModelRenderer(this);
    this.cube_r3.setRotationPoint(1.0F, -23.0F, -16.0F);
    this.bone.addChild(this.cube_r3);
    setRotationAngle(this.cube_r3, 0.0F, -0.1309F, -0.6109F);
    this.cube_r3.cubeList.add(new ModelBox(this.cube_r3, 228, 155, -0.1369F, -2.0F, -3.0884F, 16, 3, 10, 0.0F));
    this.cube_r4 = new ModelRenderer(this);
    this.cube_r4.setRotationPoint(-1.0F, -23.0F, -18.0F);
    this.bone.addChild(this.cube_r4);
    setRotationAngle(this.cube_r4, 0.0F, 0.1309F, 0.6109F);
    this.cube_r4.cubeList.add(new ModelBox(this.cube_r4, 232, 104, -16.0F, -2.0F, -1.0F, 16, 3, 10, 0.0F));
    this.cube_r5 = new ModelRenderer(this);
    this.cube_r5.setRotationPoint(4.0F, -8.0F, -7.0F);
    this.bone.addChild(this.cube_r5);
    setRotationAngle(this.cube_r5, 0.1309F, 0.0F, 0.0F);
    this.cube_r5.cubeList.add(new ModelBox(this.cube_r5, 0, 0, -20.0F, -24.0F, 19.0F, 32, 32, 68, 0.0F));
    this.cube_r6 = new ModelRenderer(this);
    this.cube_r6.setRotationPoint(4.0F, -8.0F, -9.0F);
    this.bone.addChild(this.cube_r6);
    setRotationAngle(this.cube_r6, 0.1309F, 0.0F, 0.0F);
    this.cube_r6.cubeList.add(new ModelBox(this.cube_r6, 0, 100, -22.0F, -25.0F, 19.0F, 36, 34, 40, 0.0F));
    this.cube_r6.cubeList.add(new ModelBox(this.cube_r6, 115, 137, -23.0F, -26.0F, 0.0F, 38, 36, 37, 0.0F));
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.bone6.render(f5);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
