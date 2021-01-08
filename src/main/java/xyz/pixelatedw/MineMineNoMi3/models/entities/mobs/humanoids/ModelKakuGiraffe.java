package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKakuGiraffe extends ModelBiped {
  public ModelRenderer head1;
  
  public ModelRenderer head2;
  
  public ModelRenderer rightear;
  
  public ModelRenderer leftear;
  
  public ModelRenderer horn1;
  
  public ModelRenderer horn2;
  
  public ModelRenderer neck;
  
  public ModelRenderer neck2;
  
  public ModelRenderer mane;
  
  public ModelRenderer mane2;
  
  public ModelRenderer body1;
  
  public ModelRenderer body2;
  
  public ModelRenderer body3;
  
  public ModelRenderer rightarm1;
  
  public ModelRenderer rightarm2;
  
  public ModelRenderer leftarm1;
  
  public ModelRenderer leftarm2;
  
  public ModelRenderer rightleg1;
  
  public ModelRenderer rightleg2;
  
  public ModelRenderer rightleg3;
  
  public ModelRenderer rightleg4;
  
  public ModelRenderer leftleg1;
  
  public ModelRenderer leftleg2;
  
  public ModelRenderer leftleg3;
  
  public ModelRenderer leftleg4;
  
  public ModelRenderer righthull1;
  
  public ModelRenderer righthull2;
  
  public ModelRenderer righthull3;
  
  public ModelRenderer righthull4;
  
  public ModelRenderer lefthull1;
  
  public ModelRenderer lefthull2;
  
  public ModelRenderer lefthull3;
  
  public ModelRenderer lefthull4;
  
  public ModelRenderer tail1;
  
  public ModelRenderer tail2;
  
  public ModelRenderer tail3;
  
  public ModelKakuGiraffe() {
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.rightear = new ModelRenderer((ModelBase)this, 32, 0);
    this.rightear.setRotationPoint(-1.5F, -21.5F, -3.5F);
    this.rightear.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 0, 0.0F);
    setRotateAngle(this.rightear, 0.0F, -0.0F, -0.2617994F);
    this.rightleg3 = new ModelRenderer((ModelBase)this, 10, 41);
    this.rightleg3.setRotationPoint(-2.0F, 16.2F, -0.8F);
    this.rightleg3.addBox(-2.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
    setRotateAngle(this.rightleg3, 1.3962634F, -0.0F, 0.0F);
    this.lefthull4 = new ModelRenderer((ModelBase)this, 65, 20);
    this.lefthull4.setRotationPoint(3.0F, 22.0F, -1.5F);
    this.lefthull4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.lefthull4, -0.121072076F, -0.48836833F, -0.039529614F);
    this.rightleg2 = new ModelRenderer((ModelBase)this, 0, 30);
    this.rightleg2.setRotationPoint(-2.0F, 17.6F, 4.5F);
    this.rightleg2.addBox(-2.0F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.rightleg2, -0.5235988F, -0.0F, 0.0F);
    this.leftear = new ModelRenderer((ModelBase)this, 32, 0);
    this.leftear.setRotationPoint(2.5F, -21.5F, -3.5F);
    this.leftear.addBox(0.0F, 0.0F, 0.0F, 3, 2, 0, 0.0F);
    setRotateAngle(this.leftear, 0.0F, -0.0F, 0.2617994F);
    this.righthull3 = new ModelRenderer((ModelBase)this, 65, 20);
    this.righthull3.setRotationPoint(-4.0F, 22.0F, -1.0F);
    this.righthull3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.righthull3, -0.121072076F, 0.48836833F, 0.039529614F);
    this.righthull1 = new ModelRenderer((ModelBase)this, 65, 24);
    this.righthull1.setRotationPoint(-9.0F, 12.5F, -0.5F);
    this.righthull1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
    setRotateAngle(this.righthull1, 0.17453292F, -0.0F, 0.0F);
    this.leftleg1 = new ModelRenderer((ModelBase)this, 0, 41);
    this.leftleg1.setRotationPoint(4.0F, 22.0F, 1.0F);
    this.leftleg1.addBox(-2.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
    this.horn1 = new ModelRenderer((ModelBase)this, 60, 20);
    this.horn1.setRotationPoint(1.0F, -24.0F, -4.0F);
    this.horn1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.righthull2 = new ModelRenderer((ModelBase)this, 65, 20);
    this.righthull2.setRotationPoint(-8.0F, 12.5F, -0.5F);
    this.righthull2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.righthull2, 0.17453292F, -0.0F, -0.9599311F);
    this.leftleg2 = new ModelRenderer((ModelBase)this, 0, 30);
    this.leftleg2.setRotationPoint(4.0F, 17.6F, 4.5F);
    this.leftleg2.addBox(-2.0F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.leftleg2, -0.5235988F, -0.0F, 0.0F);
    this.neck2 = new ModelRenderer((ModelBase)this, 79, 14);
    this.neck2.setRotationPoint(-1.5F, -18.0F, -5.3F);
    this.neck2.addBox(0.0F, 0.0F, 0.0F, 4, 8, 4, 0.0F);
    setRotateAngle(this.neck2, 0.31415927F, -0.0F, 0.0F);
    this.lefthull2 = new ModelRenderer((ModelBase)this, 65, 20);
    this.lefthull2.setRotationPoint(9.0F, 12.5F, -0.5F);
    this.lefthull2.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.lefthull2, 0.17453292F, -0.0F, 0.9599311F);
    this.mane2 = new ModelRenderer((ModelBase)this, 76, 0);
    this.mane2.setRotationPoint(0.5F, -12.0F, 1.0F);
    this.mane2.addBox(0.0F, 0.0F, 0.0F, 0, 8, 1, 0.0F);
    setRotateAngle(this.mane2, 0.17453292F, -0.0F, 0.0F);
    this.rightleg4 = new ModelRenderer((ModelBase)this, 10, 30);
    this.rightleg4.setRotationPoint(-2.0F, 11.6F, 1.0F);
    this.rightleg4.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
    setRotateAngle(this.rightleg4, -0.34906584F, -0.0F, 0.0F);
    this.rightleg1 = new ModelRenderer((ModelBase)this, 0, 41);
    this.rightleg1.setRotationPoint(-2.0F, 22.0F, 1.0F);
    this.rightleg1.addBox(-2.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
    this.leftleg4 = new ModelRenderer((ModelBase)this, 10, 30);
    this.leftleg4.setRotationPoint(4.0F, 11.6F, 1.0F);
    this.leftleg4.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
    setRotateAngle(this.leftleg4, -0.34906584F, -0.0F, 0.0F);
    this.lefthull1 = new ModelRenderer((ModelBase)this, 65, 24);
    this.lefthull1.setRotationPoint(10.0F, 12.5F, -0.5F);
    this.lefthull1.addBox(-2.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
    setRotateAngle(this.lefthull1, 0.17453292F, -0.0F, 0.0F);
    this.head1 = new ModelRenderer((ModelBase)this, 32, 18);
    this.head1.setRotationPoint(0.5F, -18.0F, -3.5F);
    this.head1.addBox(-2.0F, -4.0F, -6.0F, 4, 3, 8, 0.0F);
    this.tail2 = new ModelRenderer((ModelBase)this, 31, 10);
    this.tail2.setRotationPoint(0.0F, 13.2F, 6.3F);
    this.tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
    setRotateAngle(this.tail2, -0.2617994F, -0.0F, 0.0F);
    this.rightarm1 = new ModelRenderer((ModelBase)this, 23, 30);
    this.rightarm1.setRotationPoint(-8.0F, 1.0F, -1.0F);
    this.rightarm1.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.rightarm1, 0.0F, -0.0F, 0.27925268F);
    this.body2 = new ModelRenderer((ModelBase)this, 47, 0);
    this.body2.setRotationPoint(-0.5F, 3.4F, -2.0F);
    this.body2.addBox(0.0F, 0.0F, 0.0F, 9, 7, 5, 0.0F);
    setRotateAngle(this.body2, 0.0F, -0.0F, -0.9599311F);
    this.head2 = new ModelRenderer((ModelBase)this, 32, 30);
    this.head2.setRotationPoint(0.5F, -15.0F, 0.0F);
    this.head2.addBox(-2.0F, -4.0F, -6.0F, 4, 2, 4, 0.0F);
    this.body1 = new ModelRenderer((ModelBase)this, 0, 0);
    this.body1.setRotationPoint(-0.5F, -4.0F, 0.0F);
    this.body1.addBox(-4.0F, 0.0F, -2.0F, 10, 16, 5, 0.0F);
    this.rightarm2 = new ModelRenderer((ModelBase)this, 23, 39);
    this.rightarm2.setRotationPoint(-9.7F, 7.0F, -1.0F);
    this.rightarm2.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.rightarm2, 0.0F, -0.0F, -0.13962634F);
    this.neck = new ModelRenderer((ModelBase)this, 79, 0);
    this.neck.setRotationPoint(-2.0F, -11.0F, -3.5F);
    this.neck.addBox(0.0F, 0.0F, 0.0F, 5, 8, 5, 0.0F);
    setRotateAngle(this.neck, 0.17453292F, -0.0F, 0.0F);
    this.righthull4 = new ModelRenderer((ModelBase)this, 65, 20);
    this.righthull4.setRotationPoint(-3.0F, 22.0F, -1.5F);
    this.righthull4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.righthull4, -0.121072076F, -0.48836833F, -0.039529614F);
    this.lefthull3 = new ModelRenderer((ModelBase)this, 65, 20);
    this.lefthull3.setRotationPoint(2.0F, 22.0F, -1.0F);
    this.lefthull3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    setRotateAngle(this.lefthull3, -0.121072076F, 0.48836833F, 0.039529614F);
    this.body3 = new ModelRenderer((ModelBase)this, 47, 0);
    this.body3.setRotationPoint(-3.5F, -4.0F, -2.0F);
    this.body3.addBox(0.0F, 0.0F, 0.0F, 9, 7, 5, 0.0F);
    setRotateAngle(this.body3, 0.0F, -0.0F, 0.9599311F);
    this.leftarm1 = new ModelRenderer((ModelBase)this, 23, 30);
    this.leftarm1.setRotationPoint(9.0F, 1.0F, -1.0F);
    this.leftarm1.addBox(-2.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.leftarm1, 0.0F, -0.0F, -0.27925268F);
    this.tail3 = new ModelRenderer((ModelBase)this, 60, 13);
    this.tail3.setRotationPoint(-0.5F, 13.5F, 10.0F);
    this.tail3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
    setRotateAngle(this.tail3, -0.2617994F, -0.0F, 0.0F);
    this.leftarm2 = new ModelRenderer((ModelBase)this, 23, 39);
    this.leftarm2.setRotationPoint(10.7F, 7.0F, -1.0F);
    this.leftarm2.addBox(-2.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
    setRotateAngle(this.leftarm2, 0.0F, -0.0F, 0.13962634F);
    this.tail1 = new ModelRenderer((ModelBase)this, 31, 3);
    this.tail1.setRotationPoint(0.0F, 10.0F, 3.0F);
    this.tail1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
    setRotateAngle(this.tail1, -0.7330383F, -0.0F, 0.0F);
    this.mane = new ModelRenderer((ModelBase)this, 76, 0);
    this.mane.setRotationPoint(0.5F, -21.0F, -2.5F);
    this.mane.addBox(0.0F, 0.0F, 0.0F, 0, 10, 1, 0.0F);
    setRotateAngle(this.mane, 0.31415927F, -0.0F, 0.0F);
    this.horn2 = new ModelRenderer((ModelBase)this, 60, 20);
    this.horn2.setRotationPoint(-1.0F, -24.0F, -4.0F);
    this.horn2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.leftleg3 = new ModelRenderer((ModelBase)this, 10, 41);
    this.leftleg3.setRotationPoint(4.0F, 16.2F, -0.8F);
    this.leftleg3.addBox(-2.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
    setRotateAngle(this.leftleg3, 1.3962634F, -0.0F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.rightear.render(f5);
    this.rightleg3.render(f5);
    this.lefthull4.render(f5);
    this.rightleg2.render(f5);
    this.leftear.render(f5);
    this.righthull3.render(f5);
    this.righthull1.render(f5);
    this.leftleg1.render(f5);
    this.horn1.render(f5);
    this.righthull2.render(f5);
    this.leftleg2.render(f5);
    this.neck2.render(f5);
    this.lefthull2.render(f5);
    this.mane2.render(f5);
    this.rightleg4.render(f5);
    this.rightleg1.render(f5);
    this.leftleg4.render(f5);
    this.lefthull1.render(f5);
    this.head1.render(f5);
    this.tail2.render(f5);
    this.rightarm1.render(f5);
    this.body2.render(f5);
    this.head2.render(f5);
    this.body1.render(f5);
    this.rightarm2.render(f5);
    this.neck.render(f5);
    this.righthull4.render(f5);
    this.lefthull3.render(f5);
    this.body3.render(f5);
    this.leftarm1.render(f5);
    this.tail3.render(f5);
    this.leftarm2.render(f5);
    this.tail1.render(f5);
    this.mane.render(f5);
    this.horn2.render(f5);
    this.leftleg3.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
