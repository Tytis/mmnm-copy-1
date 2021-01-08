package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.text.DecimalFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelWantedPoster;

@SideOnly(Side.CLIENT)
public class RenderBlockWantedPoster extends TileEntitySpecialRenderer {
  private static final ResourceLocation texture = new ResourceLocation("mineminenomi:textures/models/wantedposter.png");
  
  private ModelWantedPoster posterModel = new ModelWantedPoster();
  
  public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
    ExtendedWorldData worldData = ExtendedWorldData.get(te.getWorldObj());
    TileEntityWantedPoster te2 = (TileEntityWantedPoster)te;
    int rawRot = te2.getBlockMetadata();
    double posterX = 0.0D, textX = 0.0D, pictureX = 0.0D;
    double posterY = 0.0D, textY = 0.0D, pictureY = 0.0D;
    double posterZ = 0.0D, textZ = 0.0D, pictureZ = 0.0D;
    int posterRotation = 90, textRotation = 90;
    if (rawRot == 2) {
      posterX = 0.9D;
      posterZ = 0.16D;
      posterRotation = 180;
      pictureX = 0.25D;
      pictureZ = 0.7D;
      textX = 0.38D;
      textZ = 0.55D;
      textRotation = 0;
    } else if (rawRot == 3) {
      posterX = 0.18D;
      posterZ = -0.9D;
      posterRotation = 0;
      pictureX = 0.71D;
      pictureZ = -0.25D;
      textX = 0.57D;
      textY = 0.01D;
      textZ = -0.41D;
      textRotation = 180;
    } else if (rawRot == 5) {
      posterX = 1.1D;
      posterZ = -0.74D;
      posterRotation = -90;
      pictureX = 0.97D;
      pictureZ = 0.44D;
      textX = 0.98D;
      textY = 0.005D;
      textZ = 0.165D;
      textRotation = -90;
    } 
    bindTexture(texture);
    GL11.glPushMatrix();
    GL11.glDepthMask(false);
    GL11.glTranslated(posX + 1.05D, posY + 1.2D, posZ + 0.87D);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
    GL11.glPushMatrix();
    GL11.glTranslated(posterX, posterY, posterZ);
    GL11.glRotatef(posterRotation, 0.0F, 1.0F, 0.0F);
    GL11.glScaled(0.6D, 0.6D, 1.0D);
    this.posterModel.render();
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glDepthMask(true);
    GL11.glTranslated(pictureX + 0.06D, pictureY + 0.3D, pictureZ - 0.6D);
    GL11.glRotatef(-textRotation, 0.0F, 1.0F, 0.0F);
    GL11.glScalef(2.2F, 2.0F, 1.6F);
    String name = te2.getEntityName();
    Minecraft minecraft = Minecraft.getMinecraft();
    if (name == null || name.isEmpty())
      return; 
    ResourceLocation rs = AbstractClientPlayer.locationStevePng;
    EntityPlayer player = minecraft.theWorld.getPlayerEntityByName(name);
    if (player != null)
      rs = ((AbstractClientPlayer)player).getLocationSkin(); 
    bindTexture(rs);
    int x = 0;
    int y = 0;
    double u = 0.2D;
    double v = 0.2D;
    Tessellator tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    tessellator.addVertexWithUV(x, y + v, 0.0D, 0.125D, 0.5D);
    tessellator.addVertexWithUV(x + u, y + v, 0.0D, 0.25D, 0.5D);
    tessellator.addVertexWithUV(x + u, y, 0.0D, 0.25D, 0.25D);
    tessellator.addVertexWithUV(x, y, 0.0D, 0.125D, 0.25D);
    tessellator.draw();
    ResourceLocation background = new ResourceLocation("mineminenomi", "textures/gui/wantedposters/backgrounds/" + te2.getBackground() + ".png");
    bindTexture(background);
    GL11.glTranslated(-0.059D, -0.04D, 0.001D);
    GL11.glScalef(1.02F, 1.25F, 1.0F);
    u = 0.3D;
    v = 0.2D;
    tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    tessellator.addVertexWithUV(x, y + v, 0.0D, 0.0D, 1.0D);
    tessellator.addVertexWithUV(x + u, y + v, 0.0D, 1.0D, 1.0D);
    tessellator.addVertexWithUV(x + u, y, 0.0D, 1.0D, 0.0D);
    tessellator.addVertexWithUV(x, y, 0.0D, 0.0D, 0.0D);
    tessellator.draw();
    GL11.glDepthMask(false);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glNormal3f(0.0F, 1.0F, -1.0F);
    GL11.glTranslated(textX + 0.065D, textY + 0.83D, textZ - 0.45D);
    GL11.glRotatef(-textRotation, 0.0F, 1.0F, 0.0F);
    GL11.glScalef(0.007F, 0.007F, 0.007F);
    name = te2.getEntityName();
    if (name.length() > 13)
      name = name.substring(0, 10) + "..."; 
    (Minecraft.getMinecraft()).fontRenderer.drawString(EnumChatFormatting.BOLD + name, 3 - (Minecraft.getMinecraft()).fontRenderer.getStringWidth(name) / 2, 0, WyHelper.hexToRGB("513413").getRGB());
    GL11.glScalef(1.2F, 1.2F, 1.2F);
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    if (te2.getPosterBounty() == null)
      te2.setPosterBounty("0"); 
    String bounty = "0";
    try {
      bounty = decimalFormat.format(Long.parseLong(te2.getPosterBounty().replace("L", "")));
    } catch (Exception e) {
      bounty = "0";
      e.printStackTrace();
    } 
    boolean flag = (bounty.length() > 10);
    if (flag) {
      GL11.glPushMatrix();
      GL11.glTranslated(-40.0D, -13.5D, 0.0D);
      GL11.glTranslated(128.0D, 128.0D, 512.0D);
      GL11.glScaled(0.72D, 0.89D, 1.005D);
      GL11.glTranslated(-128.0D, -128.0D, -512.0D);
    } 
    (Minecraft.getMinecraft()).fontRenderer.drawString(EnumChatFormatting.BOLD + bounty, -20, 13, WyHelper.hexToRGB("#513413").getRGB());
    if (flag)
      GL11.glPopMatrix(); 
    GL11.glScalef(0.7F, 0.9F, 0.8F);
    (Minecraft.getMinecraft()).fontRenderer.drawString(EnumChatFormatting.BOLD + te2.getIssuedDate(), -40, 30, WyHelper.hexToRGB("#513413").getRGB());
    GL11.glPopMatrix();
    GL11.glDepthMask(true);
    GL11.glPopMatrix();
  }
  
  public void drawTexturedModalRect(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_) {
    int zLevel = 1;
    float f = 0.00390625F;
    float f1 = 0.00390625F;
    Tessellator tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    tessellator.addVertexWithUV((p_73729_1_ + 0), (p_73729_2_ + p_73729_6_), zLevel, ((p_73729_3_ + 0) * f), ((p_73729_4_ + p_73729_6_) * f1));
    tessellator.addVertexWithUV((p_73729_1_ + p_73729_5_), (p_73729_2_ + p_73729_6_), zLevel, ((p_73729_3_ + p_73729_5_) * f), ((p_73729_4_ + p_73729_6_) * f1));
    tessellator.addVertexWithUV((p_73729_1_ + p_73729_5_), (p_73729_2_ + 0), zLevel, ((p_73729_3_ + p_73729_5_) * f), ((p_73729_4_ + 0) * f1));
    tessellator.addVertexWithUV((p_73729_1_ + 0), (p_73729_2_ + 0), zLevel, ((p_73729_3_ + 0) * f), ((p_73729_4_ + 0) * f1));
    tessellator.draw();
  }
}
