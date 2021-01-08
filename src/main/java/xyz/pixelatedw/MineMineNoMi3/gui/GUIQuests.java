package xyz.pixelatedw.MineMineNoMi3.gui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.gui.extra.GUIButtonNoTexture;

public class GUIQuests extends GuiScreen {
  private EntityPlayer player;
  
  private RenderItem renderItem;
  
  private ExtendedEntityData props;
  
  private QuestProperties questProps;
  
  private int questIndex = 0;
  
  public GUIQuests(EntityPlayer player) {
    this.player = player;
    this.props = ExtendedEntityData.get((EntityLivingBase)player);
    this.questProps = QuestProperties.get(player);
  }
  
  public void drawScreen(int x, int y, float f) {
    drawDefaultBackground();
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_BLANK);
    GL11.glPushMatrix();
    double scale = 1.4D;
    GL11.glTranslated((posX + 55), (posY + 115), 0.0D);
    GL11.glTranslated(256.0D, 256.0D, 0.0D);
    GL11.glScaled(scale, scale, 0.0D);
    GL11.glTranslated(-256.0D, -256.0D, 0.0D);
    drawTexturedModalRect(0, 0, 0, 0, 256, 256);
    Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);
    drawTexturedModalRect(-20, 30, 0, 92, 25, 100);
    drawTexturedModalRect(232, 30, 26, 92, 30, 100);
    GL11.glPopMatrix();
    String currentQuest = (this.questProps.getQuestIndexFromTracker(this.questIndex) != null) ? this.questProps.getQuestIndexFromTracker(this.questIndex).getQuestName() : "None";
    double currentProgress = (this.questProps.getQuestIndexFromTracker(this.questIndex) != null) ? (this.questProps.getQuestIndexFromTracker(this.questIndex).getProgress() / this.questProps.getQuestIndexFromTracker(this.questIndex).getMaxProgress() * 100.0D) : -1.0D;
    List<String> currentDescription = (this.questProps.getQuestIndexFromTracker(this.questIndex) != null) ? (List<String>)Arrays.<String>stream(this.questProps.getQuestIndexFromTracker(this.questIndex).getQuestDescription()).filter(line -> !line.isEmpty()).collect(Collectors.toList()) : null;
    if (this.questProps.getQuestIndexFromTracker(this.questIndex) != null) {
      GL11.glPushMatrix();
      double d = 1.2156D;
      GL11.glTranslated((posX + 12), (posY + 90), 0.0D);
      GL11.glTranslated(256.0D, 256.0D, 0.0D);
      GL11.glScaled(d, d, 0.0D);
      GL11.glTranslated(-256.0D, -256.0D, 0.0D);
      GL11.glRotated(-12.0D, 0.0D, 0.0D, 1.0D);
      if (this.questProps.getQuestIndexFromTracker(this.questIndex).isPrimary()) {
        GL11.glColor3f(1.0F, 1.0F, 0.0F);
      } else {
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
      } 
      drawTexturedModalRect(0, 0, 103, 200, 12, 33);
      GL11.glPopMatrix();
    } 
    GL11.glPushMatrix();
    double d1 = 1.30056D;
    GL11.glTranslated((posX + 55), (posY + 120), 0.0D);
    GL11.glTranslated(256.0D, 256.0D, 0.0D);
    GL11.glScaled(d1, d1, 0.0D);
    GL11.glTranslated(-256.0D, -256.0D, 0.0D);
    String questTitleToRender = (this.questProps.getQuestIndexFromTracker(this.questIndex) != null) ? this.questProps.getQuestIndexFromTracker(this.questIndex).getQuestID() : "none";
    this.mc.fontRenderer.drawString(EnumChatFormatting.BOLD + "" + EnumChatFormatting.UNDERLINE + I18n.format("quest." + questTitleToRender + ".name", new Object[0]), 0, 0, WyHelper.hexToRGB("#161616").getRGB());
    GL11.glPopMatrix();
    if (currentProgress != -1.0D)
      this.mc.fontRenderer.drawString(EnumChatFormatting.BOLD + I18n.format("gui.quests.progress.name", new Object[0]) + " : " + String.format("%.1f", new Object[] { Double.valueOf(currentProgress) }) + "%", posX + 5, posY + 65, WyHelper.hexToRGB("#161616").getRGB()); 
    if (currentDescription != null) {
      int i = 18;
      for (int l = 0; l < currentDescription.size(); l++) {
        this.mc.fontRenderer.drawString(I18n.format("quest." + this.questProps.getQuestIndexFromTracker(this.questIndex).getQuestID() + ".desc." + l, new Object[0]), posX - 20, posY + 65 + i, WyHelper.hexToRGB("#161616").getRGB());
        i += 16;
      } 
    } 
    super.drawScreen(x, y, f);
  }
  
  public void initGui() {
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    this.buttonList.add(new GUIButtonNoTexture(100, posX - 65, posY + 60, 24, 125, ""));
    this.buttonList.add(new GUIButtonNoTexture(101, posX + 290, posY + 60, 24, 125, ""));
  }
  
  public void actionPerformed(GuiButton button) {
    switch (button.id) {
      case 100:
        if (this.questIndex > 0) {
          this.questIndex--;
          break;
        } 
        this.questIndex = 3;
        break;
      case 101:
        if (this.questIndex < 3) {
          this.questIndex++;
          break;
        } 
        this.questIndex = 0;
        break;
    } 
  }
  
  public boolean doesGuiPauseGame() {
    return false;
  }
  
  private void drawItemStack(ItemStack itemStack, int x, int y, String string) {
    GL11.glTranslatef(0.0F, 0.0F, 32.0F);
    this.zLevel = 200.0F;
    itemRender.zLevel = 200.0F;
    FontRenderer font = null;
    if (itemStack != null)
      font = itemStack.getItem().getFontRenderer(itemStack); 
    if (font == null)
      font = this.fontRendererObj; 
    itemRender.renderItemAndEffectIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y);
    itemRender.renderItemOverlayIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y - 0, string);
    this.zLevel = 0.0F;
    itemRender.zLevel = 0.0F;
  }
}
