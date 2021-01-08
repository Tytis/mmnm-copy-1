package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelJabra extends ModelBiped {
  ModelRenderer head;
  
  ModelRenderer body;
  
  ModelRenderer rightarm;
  
  ModelRenderer leftarm;
  
  ModelRenderer rightleg;
  
  ModelRenderer leftleg;
  
  ModelRenderer hairclip_1;
  
  ModelRenderer hair_1;
  
  ModelRenderer hairclip_2;
  
  ModelRenderer hair_2;
  
  ModelRenderer hairclip_3;
  
  ModelRenderer hair_3;
  
  ModelRenderer hairclip_4;
  
  ModelRenderer hair_4;
  
  ModelRenderer hairclip_5;
  
  ModelRenderer hair_5;
  
  ModelRenderer hairclip_6;
  
  ModelRenderer hair_6;
  
  ModelRenderer hairclip_7;
  
  ModelRenderer hair_7;
  
  ModelRenderer Right_Beard;
  
  ModelRenderer Left_Beard;
  
  public ModelJabra() {
    this.textureWidth = 64;
    this.textureHeight = 32;
    this.bipedHeadwear = new ModelRenderer((ModelBase)this, 1, 1);
    this.bipedHeadwear.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0);
    this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedHeadwear.setTextureSize(64, 32);
    this.bipedHeadwear.mirror = true;
    setRotation(this.bipedHeadwear, 0.0F, 0.0F, 0.0F);
    this.bipedHead = new ModelRenderer((ModelBase)this, 1, 1);
    this.bipedHead.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0);
    this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedHead.setTextureSize(64, 32);
    this.bipedHead.mirror = true;
    setRotation(this.bipedHead, 0.0F, 0.0F, 0.0F);
    this.head = new ModelRenderer((ModelBase)this, 0, 0);
    this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
    this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.head.setTextureSize(64, 32);
    this.head.mirror = true;
    setRotation(this.head, 0.0F, 0.0F, 0.0F);
    this.body = new ModelRenderer((ModelBase)this, 16, 16);
    this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
    this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.body.setTextureSize(64, 32);
    this.body.mirror = true;
    setRotation(this.body, 0.0F, 0.0F, 0.0F);
    this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
    this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
    this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
    this.rightarm.setTextureSize(64, 32);
    this.rightarm.mirror = true;
    setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
    this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
    this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
    this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
    this.leftarm.setTextureSize(64, 32);
    this.leftarm.mirror = true;
    setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
    this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
    this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
    this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
    this.rightleg.setTextureSize(64, 32);
    this.rightleg.mirror = true;
    setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
    this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
    this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
    this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
    this.leftleg.setTextureSize(64, 32);
    this.leftleg.mirror = true;
    setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
    this.hairclip_1 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_1.setRotationPoint(-0.5F, -6.5F, 4.0F);
    this.hairclip_1.setTextureSize(64, 32);
    this.hairclip_1.mirror = true;
    setRotation(this.hairclip_1, -0.2617994F, 0.0F, 0.0F);
    this.hair_1 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_1.setRotationPoint(-1.0F, -6.7F, 4.7F);
    this.hair_1.setTextureSize(64, 32);
    this.hair_1.mirror = true;
    setRotation(this.hair_1, -0.418879F, 0.0F, 0.0F);
    this.hairclip_2 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_2.setRotationPoint(-0.5F, -5.3F, 6.2F);
    this.hairclip_2.setTextureSize(64, 32);
    this.hairclip_2.mirror = true;
    setRotation(this.hairclip_2, -0.837758F, 0.0F, 0.0F);
    this.hair_2 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_2.setRotationPoint(-1.0F, -5.0F, 7.5F);
    this.hair_2.setTextureSize(64, 32);
    this.hair_2.mirror = true;
    setRotation(this.hair_2, -1.082104F, 0.0F, 0.0F);
    this.hairclip_3 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_3.setRotationPoint(-0.5F, -3.2F, 7.8F);
    this.hairclip_3.setTextureSize(64, 32);
    this.hairclip_3.mirror = true;
    setRotation(this.hairclip_3, -1.047198F, 0.0F, 0.0F);
    this.hair_3 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_3.setRotationPoint(-1.0F, -2.5F, 8.8F);
    this.hair_3.setTextureSize(64, 32);
    this.hair_3.mirror = true;
    setRotation(this.hair_3, -1.43117F, 0.0F, 0.0F);
    this.hairclip_4 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_4.setRotationPoint(-0.5F, -0.7F, 7.6F);
    this.hairclip_4.setTextureSize(64, 32);
    this.hairclip_4.mirror = true;
    setRotation(this.hairclip_4, 0.0F, 0.0F, 0.0F);
    this.hair_4 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_4.setRotationPoint(-1.0F, 0.0F, 7.1F);
    this.hair_4.setTextureSize(64, 32);
    this.hair_4.mirror = true;
    setRotation(this.hair_4, 0.0F, 0.0F, 0.0F);
    this.hairclip_5 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_5.setRotationPoint(-0.5F, 1.7F, 7.6F);
    this.hairclip_5.setTextureSize(64, 32);
    this.hairclip_5.mirror = true;
    setRotation(this.hairclip_5, 0.0F, 0.0F, 0.0F);
    this.hair_5 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_5.setRotationPoint(-1.0F, 2.5F, 7.1F);
    this.hair_5.setTextureSize(64, 32);
    this.hair_5.mirror = true;
    setRotation(this.hair_5, 0.0F, 0.0F, 0.0F);
    this.hairclip_6 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_6.setRotationPoint(-0.5F, 4.2F, 7.6F);
    this.hairclip_6.setTextureSize(64, 32);
    this.hairclip_6.mirror = true;
    setRotation(this.hairclip_6, 0.0F, 0.0F, 0.0F);
    this.hair_6 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_6.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_6.setRotationPoint(-1.0F, 5.0F, 7.1F);
    this.hair_6.setTextureSize(64, 32);
    this.hair_6.mirror = true;
    setRotation(this.hair_6, 0.0F, 0.0F, 0.0F);
    this.hairclip_7 = new ModelRenderer((ModelBase)this, 34, 0);
    this.hairclip_7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.hairclip_7.setRotationPoint(-0.5F, 6.7F, 7.6F);
    this.hairclip_7.setTextureSize(64, 32);
    this.hairclip_7.mirror = true;
    setRotation(this.hairclip_7, 0.0F, 0.0F, 0.0F);
    this.hair_7 = new ModelRenderer((ModelBase)this, 34, 4);
    this.hair_7.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
    this.hair_7.setRotationPoint(-1.0F, 7.1F, 8.1F);
    this.hair_7.setTextureSize(64, 32);
    this.hair_7.mirror = true;
    setRotation(this.hair_7, -0.7853982F, 0.0F, 0.0F);
    this.Right_Beard = new ModelRenderer((ModelBase)this, 44, 0);
    this.Right_Beard.addBox(0.0F, 0.0F, 0.0F, 1, 6, 0);
    this.Right_Beard.setRotationPoint(-2.5F, -3.0F, -4.1F);
    this.Right_Beard.setTextureSize(64, 32);
    this.Right_Beard.mirror = true;
    setRotation(this.Right_Beard, 0.0F, 0.0F, 0.0F);
    this.Left_Beard = new ModelRenderer((ModelBase)this, 47, 0);
    this.Left_Beard.addBox(0.0F, 0.0F, 0.0F, 1, 6, 0);
    this.Left_Beard.setRotationPoint(1.5F, -3.0F, -4.1F);
    this.Left_Beard.setTextureSize(64, 32);
    this.Left_Beard.mirror = true;
    setRotation(this.Left_Beard, 0.0F, 0.0F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.bipedLeftLeg.isHidden = true;
    this.bipedRightLeg.isHidden = true;
    this.bipedLeftArm.isHidden = true;
    this.bipedRightArm.isHidden = true;
    this.head.render(f5);
    this.body.render(f5);
    this.rightarm.render(f5);
    this.leftarm.render(f5);
    this.rightleg.render(f5);
    this.leftleg.render(f5);
    this.hairclip_1.render(f5);
    this.hair_1.render(f5);
    this.hairclip_2.render(f5);
    this.hair_2.render(f5);
    this.hairclip_3.render(f5);
    this.hair_3.render(f5);
    this.hairclip_4.render(f5);
    this.hair_4.render(f5);
    this.hairclip_5.render(f5);
    this.hair_5.render(f5);
    this.hairclip_6.render(f5);
    this.hair_6.render(f5);
    this.hairclip_7.render(f5);
    this.hair_7.render(f5);
    this.Right_Beard.render(f5);
    this.Left_Beard.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5, null);
    this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
    this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
    this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.0F * f1;
  }
}
