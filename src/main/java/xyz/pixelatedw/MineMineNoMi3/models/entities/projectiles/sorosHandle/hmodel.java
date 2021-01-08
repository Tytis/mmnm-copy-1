package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class hmodel extends ModelBase {
  private final ModelRenderer bone;
  
  private final ModelRenderer cube_r1;
  
  private final ModelRenderer cube_r2;
  
  private final ModelRenderer bone2;
  
  private final ModelRenderer cube_r3;
  
  private final ModelRenderer cube_r4;
  
  private final ModelRenderer bone3;
  
  private final ModelRenderer cube_r5;
  
  private final ModelRenderer cube_r6;
  
  private final ModelRenderer bone4;
  
  private final ModelRenderer bone5;
  
  private final ModelRenderer bone6;
  
  private final ModelRenderer bone7;
  
  private final ModelRenderer cube_r7;
  
  private final ModelRenderer cube_r8;
  
  private final ModelRenderer bb_main;
  
  public hmodel() {
    this.textureWidth = 256;
    this.textureHeight = 256;
    this.bone = new ModelRenderer(this);
    this.bone.setRotationPoint(4.0F, 14.0F, 0.0F);
    this.cube_r1 = new ModelRenderer(this);
    this.cube_r1.setRotationPoint(0.0F, 0.0F, 1.0F);
    this.bone.addChild(this.cube_r1);
    setRotationAngle(this.cube_r1, 0.0F, 0.0F, 1.0908F);
    this.cube_r1.cubeList.add(new ModelBox(this.cube_r1, 0, 0, -2.0F, -1.0F, 0.0F, 2, 2, 1, 0.0F));
    this.cube_r2 = new ModelRenderer(this);
    this.cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone.addChild(this.cube_r2);
    setRotationAngle(this.cube_r2, 0.0F, 0.0F, 0.4363F);
    this.cube_r2.cubeList.add(new ModelBox(this.cube_r2, 0, 0, -1.0F, -1.0F, -1.0F, 1, 1, 2, 0.0F));
    this.bone2 = new ModelRenderer(this);
    this.bone2.setRotationPoint(-1.0F, 15.0F, -4.0F);
    this.cube_r3 = new ModelRenderer(this);
    this.cube_r3.setRotationPoint(0.0F, 0.0F, 1.0F);
    this.bone2.addChild(this.cube_r3);
    setRotationAngle(this.cube_r3, 0.0F, 0.0F, 1.0908F);
    this.cube_r3.cubeList.add(new ModelBox(this.cube_r3, 0, 0, -2.0F, -1.0F, 0.0F, 2, 2, 1, 0.0F));
    this.cube_r4 = new ModelRenderer(this);
    this.cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone2.addChild(this.cube_r4);
    setRotationAngle(this.cube_r4, 0.0F, 0.0F, 0.4363F);
    this.cube_r4.cubeList.add(new ModelBox(this.cube_r4, 0, 0, -1.0F, -1.0F, -1.0F, 1, 1, 2, 0.0F));
    this.bone3 = new ModelRenderer(this);
    this.bone3.setRotationPoint(-3.0F, 9.0F, -7.0F);
    setRotationAngle(this.bone3, 3.1416F, 0.0F, 0.0F);
    this.cube_r5 = new ModelRenderer(this);
    this.cube_r5.setRotationPoint(0.0F, 0.0F, 1.0F);
    this.bone3.addChild(this.cube_r5);
    setRotationAngle(this.cube_r5, 0.0F, 0.0F, 1.0908F);
    this.cube_r5.cubeList.add(new ModelBox(this.cube_r5, 0, 0, -2.0F, -1.0F, 0.0F, 2, 2, 1, 0.0F));
    this.cube_r6 = new ModelRenderer(this);
    this.cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone3.addChild(this.cube_r6);
    setRotationAngle(this.cube_r6, 0.0F, 0.0F, 0.4363F);
    this.cube_r6.cubeList.add(new ModelBox(this.cube_r6, 0, 0, -1.0F, -1.0F, -1.0F, 1, 1, 2, 0.0F));
    this.bone4 = new ModelRenderer(this);
    this.bone4.setRotationPoint(-3.0F, 18.0F, -2.0F);
    this.bone4.cubeList.add(new ModelBox(this.bone4, 130, 96, -1.0F, -2.0F, 1.0F, 1, 3, 1, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 60, 80, -1.0F, -1.0F, 2.0F, 1, 1, 2, 0.0F));
    this.bone4.cubeList.add(new ModelBox(this.bone4, 131, 64, -1.0F, -1.0F, -4.0F, 1, 1, 5, 0.0F));
    this.bone5 = new ModelRenderer(this);
    this.bone5.setRotationPoint(6.0F, 10.0F, -2.0F);
    setRotationAngle(this.bone5, 0.0F, 0.0F, -0.9599F);
    this.bone5.cubeList.add(new ModelBox(this.bone5, 82, 85, -1.0F, -2.0F, 1.0F, 1, 3, 1, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 66, 125, -1.0F, -1.0F, 2.0F, 1, 1, 2, 0.0F));
    this.bone5.cubeList.add(new ModelBox(this.bone5, 82, 85, -1.0F, -1.0F, -4.0F, 1, 1, 5, 0.0F));
    this.bone6 = new ModelRenderer(this);
    this.bone6.setRotationPoint(2.0F, 17.0F, -10.0F);
    setRotationAngle(this.bone6, 0.0436F, 0.1309F, -2.3562F);
    this.bone6.cubeList.add(new ModelBox(this.bone6, 82, 85, -1.0F, -2.0F, 1.0F, 1, 3, 1, 0.0F));
    this.bone6.cubeList.add(new ModelBox(this.bone6, 60, 80, -1.0F, -1.0F, 2.0F, 1, 1, 2, 0.0F));
    this.bone6.cubeList.add(new ModelBox(this.bone6, 128, 43, -1.0F, -1.0F, -4.0F, 1, 1, 5, 0.0F));
    this.bone7 = new ModelRenderer(this);
    this.bone7.setRotationPoint(6.0F, 18.0F, -9.0F);
    this.cube_r7 = new ModelRenderer(this);
    this.cube_r7.setRotationPoint(0.0F, 0.0F, 1.0F);
    this.bone7.addChild(this.cube_r7);
    setRotationAngle(this.cube_r7, 0.0F, 0.0F, 1.0908F);
    this.cube_r7.cubeList.add(new ModelBox(this.cube_r7, 0, 0, -2.0F, -1.0F, 0.0F, 2, 2, 1, 0.0F));
    this.cube_r8 = new ModelRenderer(this);
    this.cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bone7.addChild(this.cube_r8);
    setRotationAngle(this.cube_r8, 0.0F, 0.0F, 0.4363F);
    this.cube_r8.cubeList.add(new ModelBox(this.cube_r8, 0, 0, -1.0F, -1.0F, -1.0F, 1, 1, 2, 0.0F));
    this.bb_main = new ModelRenderer(this);
    this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -1.0F, -14.0F, -1.0F, 2, 2, 2, 0.0F));
    this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, 2.0F, -14.0F, -6.0F, 2, 2, 2, 0.0F));
    this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, 2.0F, -9.0F, -5.0F, 2, 2, 2, 0.0F));
    this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -2.0F, -9.0F, -11.0F, 2, 2, 2, 0.0F));
    this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -6.0F, -11.0F, -15.0F, 2, 2, 2, 0.0F));
    this.bone.offsetY--;
    this.bone2.offsetY--;
    this.bone3.offsetY--;
    this.bone4.offsetY--;
    this.bone5.offsetY--;
    this.bone6.offsetY--;
    this.bone7.offsetY--;
    this.bb_main.offsetY--;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.bone.render(f5);
    this.bone2.render(f5);
    this.bone3.render(f5);
    this.bone4.render(f5);
    this.bone5.render(f5);
    this.bone6.render(f5);
    this.bone7.render(f5);
    this.bb_main.render(f5);
  }
  
  public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
