package xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.MorphsHelper;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelZoanMorph;

public class RenderZoanMorph extends Render {
  private ResourceLocation texture = new ResourceLocation("mineminenomi", "textures/models/null.png");
  
  private ModelBase model;
  
  private double scale;
  
  private float[] offset = new float[3];
  
  public RenderZoanMorph(ModelBase model, String texture) {
    this.shadowSize = 0.0F;
    this.model = model;
    this.scale = 1.0D;
    if (texture.contentEquals("$playerskin")) {
      ResourceLocation rs = AbstractClientPlayer.locationStevePng;
      Minecraft minecraft = Minecraft.getMinecraft();
      Map map = minecraft.func_152342_ad().func_152788_a(minecraft.thePlayer.getGameProfile());
      if (map.containsKey(MinecraftProfileTexture.Type.SKIN))
        rs = minecraft.func_152342_ad().func_152792_a((MinecraftProfileTexture)map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN); 
      this.texture = rs;
    } else {
      this.texture = new ResourceLocation("mineminenomi", "textures/models/zoanmorph/" + texture + ".png");
    } 
    this.offset = new float[] { 0.0F, 0.0F, 0.0F };
    this.renderManager = RenderManager.instance;
  }
  
  public RenderZoanMorph(ModelBase model, String texture, double scale) {
    this.shadowSize = 0.0F;
    this.model = model;
    this.scale = scale;
    if (texture.contentEquals("$playerskin")) {
      ResourceLocation rs = AbstractClientPlayer.locationStevePng;
      Minecraft minecraft = Minecraft.getMinecraft();
      Map map = minecraft.func_152342_ad().func_152788_a(minecraft.thePlayer.getGameProfile());
      if (map.containsKey(MinecraftProfileTexture.Type.SKIN))
        rs = minecraft.func_152342_ad().func_152792_a((MinecraftProfileTexture)map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN); 
      this.texture = rs;
    } else {
      this.texture = new ResourceLocation("mineminenomi", "textures/models/zoanmorph/" + texture + ".png");
    } 
    this.offset = new float[] { 0.0F, 0.0F, 0.0F };
    this.renderManager = RenderManager.instance;
  }
  
  public RenderZoanMorph(ModelBase model, String texture, double scale, float[] offset) {
    this.shadowSize = 0.0F;
    this.model = model;
    this.scale = scale;
    if (texture.contentEquals("$playerskin")) {
      ResourceLocation rs = AbstractClientPlayer.locationStevePng;
      Minecraft minecraft = Minecraft.getMinecraft();
      Map map = minecraft.func_152342_ad().func_152788_a(minecraft.thePlayer.getGameProfile());
      if (map.containsKey(MinecraftProfileTexture.Type.SKIN))
        rs = minecraft.func_152342_ad().func_152792_a((MinecraftProfileTexture)map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN); 
      this.texture = rs;
    } else {
      this.texture = new ResourceLocation("mineminenomi", "textures/models/zoanmorph/" + texture + ".png");
    } 
    this.offset = offset;
    this.renderManager = RenderManager.instance;
  }
  
  public void renderFirstPersonArm(EntityPlayer player) {
    float f = 1.0F;
    GL11.glColor3f(f, f, f);
    if (this.model instanceof ModelZoanMorph && ((ModelZoanMorph)this.model).getHandRenderer() != null)
      ((ModelZoanMorph)this.model).getHandRenderer().render(0.0625F); 
  }
  
  public void doRender(Entity entity, double x, double y, double z, float u, float v) {
    EntityLivingBase entityLiving = (EntityLivingBase)entity;
    GL11.glPushMatrix();
    GL11.glTranslatef((float)x + this.offset[0], (float)y + 1.3F + this.offset[1], (float)z + this.offset[2]);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
    GL11.glScaled(this.scale, this.scale, this.scale);
    float ageInTicks = entityLiving.ticksExisted + v;
    float headYawOffset = interpolateRotation(entityLiving.prevRenderYawOffset, entityLiving.renderYawOffset, v);
    float headYaw = interpolateRotation(entityLiving.prevRotationYawHead, entityLiving.rotationYawHead, v);
    float headPitch = entityLiving.prevRotationPitch + (entityLiving.rotationPitch - entityLiving.prevRotationPitch) * v;
    rotateCorpse(entityLiving, ageInTicks, headYawOffset, v);
    float limbSwingAmount = entityLiving.prevLimbSwingAmount + (entityLiving.limbSwingAmount - entityLiving.prevLimbSwingAmount) * v;
    float limbSwing = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - v);
    this.model.onGround = entityLiving.getSwingProgress(v);
    (Minecraft.getMinecraft()).renderEngine.bindTexture(getEntityTexture(entity));
    this.model.render((Entity)entityLiving, limbSwing, limbSwingAmount, ageInTicks, headYaw - headYawOffset, headPitch, 0.0625F);
    GL11.glPushMatrix();
    GL11.glDisable(2884);
    ModelRenderer hand = ((ModelZoanMorph)this.model).getHandRenderer();
    if (hand != null) {
      GL11.glRotated((hand.rotateAngleX * 50.0F), 1.0D, 0.0D, 0.0D);
      renderEquippedItems(entityLiving, v);
    } 
    GL11.glEnable(2884);
    GL11.glPopMatrix();
    GL11.glPopMatrix();
  }
  
  protected void renderEquippedItems(EntityLivingBase entity, float age) {
    GL11.glColor3f(1.0F, 1.0F, 1.0F);
    ItemStack itemstack = entity.getHeldItem();
    if (itemstack != null && itemstack.getItem() != null) {
      Item item = itemstack.getItem();
      GL11.glPushMatrix();
      ExtendedEntityData props = ExtendedEntityData.get(entity);
      if (props == null || props.getZoanPoint().equalsIgnoreCase("n/a"))
        return; 
      Optional<Object[]> opt = Arrays.<Object[]>stream((Object[][])MorphsHelper.getMorphsMap().get(props.getUsedFruit())).filter(x -> props.getZoanPoint().equalsIgnoreCase((String)x[0])).findFirst();
      if (!opt.isPresent() || ((Object[])opt.get())[3] == null) {
        GL11.glPopMatrix();
        return;
      } 
      float[] itemOffset = (float[])((Object[])opt.get())[3];
      GL11.glTranslatef(itemOffset[0], itemOffset[1], itemOffset[2]);
      IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
      boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D));
      if (item instanceof net.minecraft.item.ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType()))) {
        float f1 = 0.5F;
        GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
        f1 *= 0.75F;
        GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-f1, -f1, f1);
      } else if (item == Items.bow) {
        float f1 = 0.625F;
        GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
        GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(f1, -f1, f1);
        GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
      } else if (item.isFull3D()) {
        float f1 = 0.625F;
        if (item.shouldRotateAroundWhenRendering()) {
          GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
          GL11.glTranslatef(0.0F, -0.125F, 0.0F);
        } 
        GL11.glTranslatef(0.0F, 0.2F, 0.0F);
        GL11.glScalef(f1, -f1, f1);
        GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
      } else {
        float f1 = 0.375F;
        GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
        GL11.glScalef(f1, f1, f1);
        GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
      } 
      if (itemstack.getItem().requiresMultipleRenderPasses()) {
        for (int i = 0; i < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); i++) {
          int j = itemstack.getItem().getColorFromItemStack(itemstack, i);
          float f5 = (j >> 16 & 0xFF) / 255.0F;
          float f2 = (j >> 8 & 0xFF) / 255.0F;
          float f3 = (j & 0xFF) / 255.0F;
          GL11.glColor4f(f5, f2, f3, 1.0F);
          this.renderManager.itemRenderer.renderItem(entity, itemstack, i);
        } 
      } else {
        int i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
        float f4 = (i >> 16 & 0xFF) / 255.0F;
        float f5 = (i >> 8 & 0xFF) / 255.0F;
        float f2 = (i & 0xFF) / 255.0F;
        GL11.glColor4f(f4, f5, f2, 1.0F);
        this.renderManager.itemRenderer.renderItem(entity, itemstack, 0);
      } 
      GL11.glPopMatrix();
    } 
  }
  
  private float interpolateRotation(float lowerLimit, float upperLimit, float range) {
    float f3;
    for (f3 = upperLimit - lowerLimit; f3 < -180.0F; f3 += 360.0F);
    while (f3 >= 180.0F)
      f3 -= 360.0F; 
    return lowerLimit + range * f3;
  }
  
  protected void rotateCorpse(EntityLivingBase entityLiving, float ageInTicks, float headYawOffset, float v) {
    GL11.glRotatef(180.0F + headYawOffset, 0.0F, 1.0F, 0.0F);
    if (entityLiving.deathTime > 0) {
      float f3 = (entityLiving.deathTime + v - 1.0F) / 20.0F * 1.6F;
      f3 = MathHelper.sqrt_float(f3);
      if (f3 > 1.0F)
        f3 = 1.0F; 
    } 
  }
  
  public ResourceLocation getEntityTexture(Entity p_110775_1_) {
    return this.texture;
  }
}
