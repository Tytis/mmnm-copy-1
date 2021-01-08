package xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelDojoSensei extends ModelBiped {
  public ModelRenderer head;
  
  public ModelRenderer rightleg;
  
  public ModelRenderer leftleg;
  
  public ModelRenderer sheath1;
  
  public ModelRenderer sheath2;
  
  public ModelRenderer Slipper3;
  
  public ModelRenderer Slipper4;
  
  public ModelRenderer Slipper1;
  
  public ModelRenderer Slipper2;
  
  public ModelRenderer hat1;
  
  public ModelRenderer hat2;
  
  public ModelRenderer hat3;
  
  public ModelRenderer hat4;
  
  public ModelRenderer hat5;
  
  public ModelRenderer hat6;
  
  public ModelRenderer hat7;
  
  public ModelRenderer hat8;
  
  public ModelRenderer hat9;
  
  public ModelRenderer hat10;
  
  public ModelRenderer hat11;
  
  public ModelRenderer hat12;
  
  public ModelRenderer hat13;
  
  public ModelRenderer hat14;
  
  public ModelRenderer hat15;
  
  public ModelRenderer hat16;
  
  public ModelRenderer hat17;
  
  public ModelRenderer hat18;
  
  public ModelRenderer hat19;
  
  public ModelRenderer hat20;
  
  public ModelRenderer hat21;
  
  public ModelRenderer hat22;
  
  public ModelRenderer hat23;
  
  public ModelRenderer hat24;
  
  public ModelRenderer hat25;
  
  public ModelRenderer hat26;
  
  public ModelRenderer hat27;
  
  public ModelRenderer hat28;
  
  public ModelRenderer hat29;
  
  public ModelRenderer hat30;
  
  public ModelRenderer hat31;
  
  public ModelRenderer hat32;
  
  public ModelRenderer hat33;
  
  public ModelRenderer hat34;
  
  public ModelRenderer hat35;
  
  public ModelRenderer hat36;
  
  public ModelRenderer hat37;
  
  public ModelRenderer hat38;
  
  public ModelRenderer hat39;
  
  public ModelRenderer hat40;
  
  public ModelRenderer hat41;
  
  public ModelRenderer hat42;
  
  public ModelRenderer hat43;
  
  public ModelRenderer hat44;
  
  public ModelRenderer hat45;
  
  public ModelRenderer hat46;
  
  public ModelDojoSensei() {
    super(0.0F, 0.0F, 128, 128);
    this.textureWidth = 128;
    this.textureHeight = 128;
    this.bipedBody.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.Slipper2 = new ModelRenderer((ModelBase)this, 33, 0);
    this.Slipper2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Slipper2.addBox(-2.0F, 12.0F, 0.5F, 4, 1, 1, 0.0F);
    this.hat10 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat10.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat10.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat10, -0.60578215F, -1.2207227F, 0.4736315F);
    this.hat16 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat16.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat16.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat16, -3.0340729F, -1.0262514F, 2.8348234F);
    this.hat23 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat23.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat23.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat23, 3.017752F, -0.20682323F, 2.9810631F);
    this.hat2 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat2.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat2.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat2, -0.17906153F, -0.13789625F, 0.15859771F);
    this.hat41 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat41.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat41.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat41, 0.02723575F, 0.85811776F, 0.24158989F);
    this.hat26 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat26.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat26.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat26, 2.9569364F, 0.17236258F, 2.9821303F);
    this.hat3 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat3.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat3.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat3, -0.20190644F, -0.27572414F, 0.16330002F);
    this.hat36 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat36.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat36.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat36, 1.4137169F, 1.4137167F, 1.5707966F);
    this.hat22 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat22.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat22.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat22, 3.017752F, -0.20682323F, 2.9810631F);
    this.hat27 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat27.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat27.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat27, 2.933728F, 0.3101616F, 2.9765718F);
    this.leftleg = new ModelRenderer((ModelBase)this, 0, 17);
    this.leftleg.setRotationPoint(2.0F, 11.0F, 0.0F);
    this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    this.hat21 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat21.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat21.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat21, 3.0413892F, -0.3445885F, 2.974613F);
    this.Slipper4 = new ModelRenderer((ModelBase)this, 33, 0);
    this.Slipper4.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Slipper4.addBox(-2.0F, 12.0F, 0.5F, 4, 1, 1, 0.0F);
    this.hat6 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat6.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat6.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat6, -0.28759754F, -0.6878452F, 0.2038834F);
    this.hat24 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat24.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat24.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat24, 2.9954515F, -0.06895228F, 2.9841356F);
    this.Slipper3 = new ModelRenderer((ModelBase)this, 33, 0);
    this.Slipper3.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Slipper3.addBox(-2.0F, 12.0F, -1.5F, 4, 1, 1, 0.0F);
    this.hat7 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat7.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat7.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat7, -0.32910064F, -0.82418644F, 0.23242413F);
    this.hat25 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat25.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat25.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat25, 2.9790502F, 0.034476608F, 2.9844189F);
    this.hat8 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat8.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat8.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat8, -0.38497424F, -0.95937115F, 0.2760084F);
    this.hat12 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat12.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat12.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat12, -1.5082475F, -1.4099162F, 1.3539153F);
    this.hat15 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat15.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat15.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat15, -2.9292586F, -1.1574173F, 2.7415853F);
    this.hat30 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat30.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat30.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat30, 2.8445795F, 0.72200745F, 2.9316072F);
    this.hat40 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat40.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat40.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat40, 0.088226035F, 0.9928882F, 0.29043272F);
    this.hat44 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat44.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat44.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat44, -0.08092899F, 0.44778952F, 0.17442805F);
    this.hat39 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat39.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat39.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat39, 0.18080412F, 1.125071F, 0.37133777F);
    this.hat31 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat31.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat31.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat31, 2.8001976F, 0.8581177F, 2.9000027F);
    this.sheath2 = new ModelRenderer((ModelBase)this, 62, 18);
    this.sheath2.setRotationPoint(4.5F, 16.3F, 1.5F);
    this.sheath2.addBox(-0.5F, -7.0F, -0.5F, 1, 14, 1, 0.0F);
    setRotateAngle(this.sheath2, 0.61086524F, -0.0F, 0.0F);
    this.hat4 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat4.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat4.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat4, -0.22661646F, -0.41340417F, 0.17166692F);
    this.sheath1 = new ModelRenderer((ModelBase)this, 62, 18);
    this.sheath1.setRotationPoint(4.5F, 16.8F, 0.5F);
    this.sheath1.addBox(-0.5F, -7.0F, -0.5F, 1, 14, 1, 0.0F);
    setRotateAngle(this.sheath1, 0.61086524F, -0.0F, 0.0F);
    this.hat19 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat19.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat19.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat19, 3.0976837F, -0.6194023F, 2.948264F);
    this.hat43 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat43.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat43.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat43, -0.05195226F, 0.58513063F, 0.18877146F);
    this.hat45 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat45.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat45.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat45, -0.1062947F, 0.31016156F, 0.16502082F);
    this.hat18 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat18.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat18.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat18, 3.1344464F, -0.75612295F, 2.9248703F);
    this.hat17 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat17.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat17.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat17, -3.1010585F, -0.8919682F, 2.8897939F);
    this.hat32 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat32.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat32.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat32, 2.7392075F, 0.9928881F, 2.85116F);
    this.hat9 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat9.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat9.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat9, -0.46745205F, -1.0923871F, 0.34670785F);
    this.hat28 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat28.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat28.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat28, 2.9083624F, 0.4477895F, 2.9671645F);
    this.hat11 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat11.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat11.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat11, -0.88276863F, -1.3365223F, 0.7394598F);
    this.hat38 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat38.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat38.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat38, 0.342342F, 1.2514058F, 0.5215423F);
    this.hat14 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat14.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat14.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat14, -2.7383316F, -1.2811669F, 2.5619256F);
    this.head = new ModelRenderer((ModelBase)this, 0, 0);
    this.head.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    this.Slipper1 = new ModelRenderer((ModelBase)this, 33, 0);
    this.Slipper1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Slipper1.addBox(-2.0F, 12.0F, -1.5F, 4, 1, 1, 0.0F);
    this.hat20 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat20.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat20.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat20, 3.0674996F, -0.4821573F, 2.964099F);
    this.hat42 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat42.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat42.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat42, -0.01714598F, 0.7220074F, 0.20998551F);
    this.hat34 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat34.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat34.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat34, 2.4850914F, 1.2514058F, 2.6200502F);
    this.hat33 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat33.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat33.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat33, 2.6466293F, 1.1250709F, 2.7702549F);
    this.rightleg = new ModelRenderer((ModelBase)this, 0, 17);
    this.rightleg.setRotationPoint(-2.0F, 11.0F, 0.0F);
    this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    this.hat1 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat1.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat1.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat1, -0.15707964F, 0.0F, 0.15707964F);
    this.hat35 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat35.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat35.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat35, 2.1456473F, 1.3610138F, 2.2917204F);
    this.hat46 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat46.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat46.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat46, -0.12950301F, 0.17236246F, 0.15946227F);
    this.hat37 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat37.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat37.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat37, 0.6817859F, 1.3610138F, 0.8498721F);
    this.hat13 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat13.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat13.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat13, -2.3194752F, -1.3822497F, 2.1541464F);
    this.hat29 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat29.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat29.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat29, 2.8793857F, 0.5851306F, 2.9528213F);
    this.hat5 = new ModelRenderer((ModelBase)this, 0, 34);
    this.hat5.setRotationPoint(0.0F, -10.0F, 0.0F);
    this.hat5.addBox(0.0F, 0.0F, -0.5F, 7, 1, 1, 0.1F);
    setRotateAngle(this.hat5, -0.25452116F, -0.5508305F, 0.18463638F);
    this.leftleg.addChild(this.Slipper2);
    this.rightleg.addChild(this.Slipper4);
    this.rightleg.addChild(this.Slipper3);
    this.leftleg.addChild(this.Slipper1);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.bipedLeftLeg.isHidden = true;
    this.bipedRightLeg.isHidden = true;
    this.bipedHead.isHidden = true;
    this.bipedHeadwear.isHidden = true;
    this.bipedBody.isHidden = false;
    this.hat10.render(f5);
    this.hat16.render(f5);
    this.hat23.render(f5);
    this.hat2.render(f5);
    this.hat41.render(f5);
    this.hat26.render(f5);
    this.hat3.render(f5);
    this.hat36.render(f5);
    this.hat22.render(f5);
    this.hat27.render(f5);
    this.leftleg.render(f5);
    this.hat21.render(f5);
    this.hat6.render(f5);
    this.hat24.render(f5);
    this.hat7.render(f5);
    this.hat25.render(f5);
    this.hat8.render(f5);
    this.hat12.render(f5);
    this.hat15.render(f5);
    this.hat30.render(f5);
    this.hat40.render(f5);
    this.hat44.render(f5);
    this.hat39.render(f5);
    this.hat31.render(f5);
    this.sheath2.render(f5);
    this.hat4.render(f5);
    this.sheath1.render(f5);
    this.hat19.render(f5);
    this.hat43.render(f5);
    this.hat45.render(f5);
    this.hat18.render(f5);
    this.hat17.render(f5);
    this.hat32.render(f5);
    this.hat9.render(f5);
    this.hat28.render(f5);
    this.hat11.render(f5);
    this.hat38.render(f5);
    this.hat14.render(f5);
    this.head.render(f5);
    this.hat20.render(f5);
    this.hat42.render(f5);
    this.hat34.render(f5);
    this.hat33.render(f5);
    this.rightleg.render(f5);
    this.hat1.render(f5);
    this.hat35.render(f5);
    this.hat46.render(f5);
    this.hat37.render(f5);
    this.hat13.render(f5);
    this.hat29.render(f5);
    this.hat5.render(f5);
  }
  
  public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {}
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent) {
    super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scaleFactor, ent);
    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.0F * limbSwingAmount;
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
}
