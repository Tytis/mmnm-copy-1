package xyz.pixelatedw.MineMineNoMi3.gui;

import java.text.DecimalFormat;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class GUIWantedPoster extends GuiScreen {
  private NBTTagCompound wantedData;
  
  private RenderItem renderItem;
  
  public GUIWantedPoster(NBTTagCompound nbtTagCompound) {
    this.wantedData = nbtTagCompound;
  }
  
  public void drawScreen(int x, int y, float f) {
    drawDefaultBackground();
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    GL11.glTranslated((posX + 60), (posY + 10), 0.0D);
    GL11.glTranslated(128.0D, 128.0D, 512.0D);
    GL11.glScaled(1.0D, 0.9D, 0.0D);
    GL11.glTranslated(-128.0D, -128.0D, -512.0D);
    this.mc.renderEngine.bindTexture(ID.TEXTURE_BOUNTYPOSTER_LARGE);
    drawTexturedModalRect(0, 0, 0, 0, 220, 250);
    GL11.glTranslated(67.0D, 150.0D, 0.0D);
    GL11.glTranslated(128.0D, 128.0D, 512.0D);
    GL11.glScaled(1.5D, 1.6D, 0.0D);
    GL11.glTranslated(-128.0D, -128.0D, -512.0D);
    String name = this.wantedData.getString("Name");
    String background = this.wantedData.getString("Background");
    GL11.glPushMatrix();
    ResourceLocation rs = new ResourceLocation("mineminenomi", "textures/gui/wantedposters/backgrounds/" + background + ".png");
    this.mc.renderEngine.bindTexture(rs);
    GL11.glScaled(0.34D, 0.245D, 0.0D);
    drawTexturedModalRect(23, -57, 0, 0, 256, 256);
    GL11.glDisable(3042);
    rs = AbstractClientPlayer.locationStevePng;
    EntityPlayer player = this.mc.theWorld.getPlayerEntityByName(name);
    if (player != null)
      rs = ((AbstractClientPlayer)player).getLocationSkin(); 
    this.mc.renderEngine.bindTexture(rs);
    GL11.glScaled(4.25D, 3.25D, 0.0D);
    drawTexturedModalRect(21, -5, 32, 64, 32, 64);
    GL11.glPopMatrix();
    this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
    drawTexturedModalRect(-2, 63, 0, 0, 32, 32);
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    if (name.length() > 13)
      name = name.substring(0, 10) + "..."; 
    this.mc.fontRenderer.drawString(EnumChatFormatting.BOLD + name, 47 - this.mc.fontRenderer.getStringWidth(name) / 2, 62, WyHelper.hexToRGB("513413").getRGB());
    String bounty = decimalFormat.format(this.wantedData.getLong("Bounty"));
    boolean flag = (bounty.length() > 10);
    if (flag) {
      GL11.glPushMatrix();
      GL11.glTranslated(-21.0D, -5.0D, 0.0D);
      GL11.glTranslated(128.0D, 128.0D, 512.0D);
      GL11.glScaled(0.82D, 0.89D, 0.0D);
      GL11.glTranslated(-128.0D, -128.0D, -512.0D);
    } 
    this.mc.fontRenderer.drawString(EnumChatFormatting.BOLD + bounty, 22, 76, WyHelper.hexToRGB("513413").getRGB());
    if (flag)
      GL11.glPopMatrix(); 
    GL11.glTranslated(-24.0D, -2.0D, 0.0D);
    GL11.glTranslated(128.0D, 128.0D, 512.0D);
    GL11.glScaled(0.78D, 0.92D, 0.0D);
    GL11.glTranslated(-128.0D, -128.0D, -512.0D);
    this.mc.fontRenderer.drawString(EnumChatFormatting.BOLD + this.wantedData.getString("Date"), 36 - this.mc.fontRenderer.getStringWidth(this.wantedData.getString("Date")) / 2, 90, WyHelper.hexToRGB("513413").getRGB());
    super.drawScreen(x, y, f);
  }
  
  public void initGui() {
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
  }
  
  public void actionPerformed(GuiButton button) {}
  
  public boolean doesGuiPauseGame() {
    return false;
  }
}
