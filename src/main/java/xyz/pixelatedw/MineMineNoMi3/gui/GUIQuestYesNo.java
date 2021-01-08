package xyz.pixelatedw.MineMineNoMi3.gui;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
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
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketQuestSync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.api.quests.Quest;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestManager;
import xyz.pixelatedw.MineMineNoMi3.api.quests.QuestProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.gui.extra.GUIButtonNoTexture;
import xyz.pixelatedw.MineMineNoMi3.helpers.QuestLogicHelper;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;

public class GUIQuestYesNo extends GuiScreen {
  private EntityPlayer player;
  
  private RenderItem renderItem;
  
  private ExtendedEntityData props;
  
  private QuestProperties questProps;
  
  private Quest currentQuestToDisplay;
  
  public GUIQuestYesNo(EntityPlayer player, int x, int y, int z, EnumQuestlines quesstline) {
    this.player = player;
    this.props = ExtendedEntityData.get((EntityLivingBase)player);
    this.questProps = QuestProperties.get(player);
    this.currentQuestToDisplay = QuestLogicHelper.getQuestlineCurrentQuest(quesstline.getQuests(), this.questProps);
  }
  
  public void drawScreen(int x, int y, float f) {
    drawDefaultBackground();
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_BLANK);
    if (this.currentQuestToDisplay == null)
      return; 
    GL11.glPushMatrix();
    double scale = 1.4D;
    GL11.glTranslated((posX + 55), (posY + 115), 0.0D);
    GL11.glTranslated(256.0D, 256.0D, 0.0D);
    GL11.glScaled(scale, scale, 0.0D);
    GL11.glTranslated(-256.0D, -256.0D, 0.0D);
    drawTexturedModalRect(0, 0, 0, 0, 256, 256);
    GL11.glPopMatrix();
    String currentQuest = this.currentQuestToDisplay.getQuestName();
    this.mc.fontRenderer.drawString(I18n.format("gui.quests.accepttext.name", new Object[0]), posX - 20, posY + 75, WyHelper.hexToRGB("#161616").getRGB());
    GL11.glPushMatrix();
    double d1 = 1.30056D;
    GL11.glTranslated((posX + 55), (posY + 180), 0.0D);
    GL11.glTranslated(256.0D, 256.0D, 0.0D);
    GL11.glScaled(d1, d1, 0.0D);
    GL11.glTranslated(-256.0D, -256.0D, 0.0D);
    this.mc.fontRenderer.drawString(EnumChatFormatting.BOLD + "" + I18n.format("quest." + this.currentQuestToDisplay.getQuestID() + ".name", new Object[0]), 0, 0, WyHelper.hexToRGB("#161616").getRGB());
    GL11.glPopMatrix();
    Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    drawTexturedModalRect(posX + 10, posY + 140, 0, 196, 96, 49);
    drawTexturedModalRect(posX + 150, posY + 140, 0, 196, 96, 49);
    this.mc.fontRenderer.drawString(I18n.format("gui.quests.accept.name", new Object[0]), posX + 21, posY + 159, WyHelper.hexToRGB("#12e557").getRGB());
    this.mc.fontRenderer.drawString(I18n.format("gui.quests.accept.name", new Object[0]), posX + 20, posY + 158, WyHelper.hexToRGB("#161616").getRGB());
    this.mc.fontRenderer.drawString(I18n.format("gui.quests.decline.name", new Object[0]), posX + 161, posY + 159, WyHelper.hexToRGB("#cc1010").getRGB());
    this.mc.fontRenderer.drawString(I18n.format("gui.quests.decline.name", new Object[0]), posX + 160, posY + 158, WyHelper.hexToRGB("#161616").getRGB());
    super.drawScreen(x, y, f);
  }
  
  public void initGui() {
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    this.buttonList.add(new GUIButtonNoTexture(0, posX + 12, posY + 143, 90, 37, ""));
    this.buttonList.add(new GUIButtonNoTexture(1, posX + 152, posY + 143, 90, 37, ""));
  }
  
  public void actionPerformed(GuiButton button) {
    switch (button.id) {
      case 0:
        Minecraft.getMinecraft().displayGuiScreen((GuiScreen)null);
        QuestManager.instance().startQuest(this.player, this.currentQuestToDisplay);
        WyNetworkHelper.sendToServer((IMessage)new PacketQuestSync(this.questProps));
        break;
      case 1:
        Minecraft.getMinecraft().displayGuiScreen((GuiScreen)null);
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
