package xyz.pixelatedw.MineMineNoMi3.helpers;

import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans.RenderZoanMorph;

public class HandRendererHelper {
  private static HashMap<String, Object[][]> handEffectsMap = (HashMap)new HashMap<>();
  
  public static HashMap<String, Object[][]> getMap() {
    return handEffectsMap;
  }
  
  static {
    handEffectsMap.put("baribari", new Object[][] { { "power", "" } });
  }
  
  public static void renderHand(EntityClientPlayerMP player) {
    Minecraft mc = Minecraft.getMinecraft();
    GL11.glMatrixMode(5889);
    GL11.glLoadIdentity();
    Project.gluPerspective(mc.gameSettings.fovSetting, mc.displayWidth / mc.displayHeight, 0.2F, (mc.gameSettings.renderDistanceChunks * 16) * 2.0F);
    GL11.glMatrixMode(5888);
    GL11.glLoadIdentity();
    if (mc.gameSettings.viewBobbing)
      setupViewBobbing(0.07F); 
    RenderHelper.enableStandardItemLighting();
    (Minecraft.getMinecraft()).entityRenderer.enableLightmap(0.0D);
    int i2 = mc.theWorld.getLightBrightnessForSkyBlocks(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ), 0);
    int j = i2 % 65536;
    int k = i2 / 65536;
    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    if (mc.gameSettings.thirdPersonView == 0 && !mc.renderViewEntity.isPlayerSleeping() && !mc.gameSettings.hideGUI)
      if (player.inventory.getCurrentItem() != null) {
        (Minecraft.getMinecraft()).entityRenderer.itemRenderer.renderItemInFirstPerson(0.07F);
      } else {
        renderCustomHand(player);
      }  
    (Minecraft.getMinecraft()).entityRenderer.disableLightmap(0.0D);
    RenderHelper.disableStandardItemLighting();
  }
  
  private static void renderCustomHand(EntityClientPlayerMP player) {
    Minecraft mc = Minecraft.getMinecraft();
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)player);
    Ability hotBoilingSpecial = abilityProps.getAbilityFromName(ListAttributes.HOT_BOILING_SPECIAL.getAttributeName());
    boolean hasHotBoilingSpecial = (hotBoilingSpecial != null && hotBoilingSpecial.isPassiveActive());
    Ability mechArm = abilityProps.getAbilityFromName(ListAttributes.MechArm.getAttributeName());
    boolean hasMechArm = (mechArm != null && mechArm.isPassiveActive());
    Ability mochiwheel = abilityProps.getAbilityFromName(ListAttributes.WHEELDASH.getAttributeName());
    Ability hardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_HARDENING.getAttributeName());
    boolean hasHardeningBuso = (hardeningBuso != null && hardeningBuso.isPassiveActive());
    Ability fullBodyHardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_FULL_BODY_HARDENING.getAttributeName());
    boolean hasFullBodyHardeningBuso = (fullBodyHardeningBuso != null && fullBodyHardeningBuso.isPassiveActive());
    GL11.glPushMatrix();
    float f13 = 0.8F;
    float f5 = player.getSwingProgress(0.0F);
    float f6 = MathHelper.sin(f5 * 3.1415927F);
    float f7 = MathHelper.sin(MathHelper.sqrt_float(f5) * 3.1415927F);
    GL11.glTranslatef(-f7 * 0.3F, MathHelper.sin(MathHelper.sqrt_float(f5) * 3.1415927F * 2.0F) * 0.4F, -f6 * 0.4F);
    GL11.glTranslatef(0.8F * f13, -0.75F * f13 - 0.0F, -0.9F * f13);
    GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
    GL11.glEnable(32826);
    f5 = player.getSwingProgress(0.0F);
    f6 = MathHelper.sin(f5 * f5 * 3.1415927F);
    f7 = MathHelper.sin(MathHelper.sqrt_float(f5) * 3.1415927F);
    GL11.glRotatef(f7 * 70.0F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(-f6 * 20.0F, 0.0F, 0.0F, 1.0F);
    if (hasHardeningBuso || hasFullBodyHardeningBuso) {
      mc.getTextureManager().bindTexture(ID.HANDTEXTURE_ZOANMORPH_BUSO);
    } else if (hasHotBoilingSpecial) {
      mc.getTextureManager().bindTexture(ID.HANDTEXTURE_ZOANMORPH_HOTBOILINGSPECIAL);
    } else if (hasMechArm) {
      mc.getTextureManager().bindTexture(ID.HANDTEXTURE_MECH);
    } else {
      mc.getTextureManager().bindTexture(getTextureFromMorph(player));
    } 
    GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
    GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
    GL11.glScalef(1.0F, 1.0F, 1.0F);
    GL11.glTranslatef(5.6F, 0.0F, 0.0F);
    Render render = null;
    if (props.getZoanPoint().toLowerCase().equals("n/a")) {
      render = RenderManager.instance.getEntityRenderObject((Entity)mc.thePlayer);
      RenderPlayer renderplayer = (RenderPlayer)render;
      float i = 1.0F;
      GL11.glScalef(i, i, i);
      renderplayer.renderFirstPersonArm((EntityPlayer)mc.thePlayer);
    } else {
      if (MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
        for (Object[] x : (Object[][])MorphsHelper.getMorphsMap().get(props.getUsedFruit())) {
          if (props.getZoanPoint().equalsIgnoreCase((String)x[0]))
            render = (RenderZoanMorph)x[1]; 
        }  
      RenderZoanMorph renderZoan = (RenderZoanMorph) render;
      float i = 1.0F;
      GL11.glScalef(i, i, i);
      GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(0.2F, 0.0F, -0.5F);
      renderZoan.renderFirstPersonArm((EntityPlayer)mc.thePlayer);
    } 
    GL11.glPopMatrix();
    GL11.glDisable(32826);
  }
  
  private static ResourceLocation getTextureFromMorph(EntityClientPlayerMP player) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    RenderZoanMorph render = null;
    if (MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
      for (Object[] x : (Object[][])MorphsHelper.getMorphsMap().get(props.getUsedFruit())) {
        if (props.getZoanPoint().equalsIgnoreCase((String)x[0])) {
          render = (RenderZoanMorph)x[1];
          break;
        } 
      }  
    if (render != null)
      return render.getEntityTexture(null); 
    return player.getLocationSkin();
  }
  
  public static void setupViewBobbing(float swing) {
    Minecraft mc = Minecraft.getMinecraft();
    if (mc.renderViewEntity instanceof EntityPlayer) {
      EntityPlayer entityplayer = (EntityPlayer)mc.renderViewEntity;
      float f1 = entityplayer.distanceWalkedModified - entityplayer.prevDistanceWalkedModified;
      float f2 = -(entityplayer.distanceWalkedModified + f1 * swing);
      float f3 = entityplayer.prevCameraYaw + (entityplayer.cameraYaw - entityplayer.prevCameraYaw) * swing;
      float f4 = entityplayer.prevCameraPitch + (entityplayer.cameraPitch - entityplayer.prevCameraPitch) * swing;
      GL11.glTranslatef(MathHelper.sin(f2 * 3.1415927F) * f3 * 0.5F, -Math.abs(MathHelper.cos(f2 * 3.1415927F) * f3), 0.0F);
      GL11.glRotatef(MathHelper.sin(f2 * 3.1415927F) * f3 * 3.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(Math.abs(MathHelper.cos(f2 * 3.1415927F - 0.2F) * f3) * 5.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(f4, 1.0F, 0.0F, 0.0F);
    } 
  }
}
