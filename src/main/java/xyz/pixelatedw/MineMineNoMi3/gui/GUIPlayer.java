package xyz.pixelatedw.MineMineNoMi3.gui;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;

public class GUIPlayer extends GuiScreen {
  private EntityPlayer player;
  
  private RenderItem renderItem;
  
  private ExtendedEntityData props;
  
  private EntityNewMob testEntity;
  
  public GUIPlayer(EntityPlayer player) {
    this.player = player;
    this.props = ExtendedEntityData.get((EntityLivingBase)player);
  }
  
  public void drawScreen(int x, int y, float f) {
    drawDefaultBackground();
    GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    String factionGUI = I18n.format("gui.faction.name", new Object[0]);
    String raceGUI = I18n.format("gui.race.name", new Object[0]);
    String styleGUI = I18n.format("gui.style.name", new Object[0]);
    String factionActual = I18n.format("faction." + WyHelper.getFancyName(this.props.getFaction().toLowerCase()) + ".name", new Object[0]);
    String raceActual = I18n.format("race." + this.props.getRace().toLowerCase() + ".name", new Object[0]);
    String styleActual = I18n.format("style." + this.props.getFightStyle().toLowerCase() + ".name", new Object[0]);
    if (this.props.isCyborg())
      this.mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + "COLA: " + EnumChatFormatting.RESET + this.props.getCola() + " / " + this.props.getMaxCola(), posX - 30, posY + 50, -1); 
    this.mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + "DORIKI: " + EnumChatFormatting.RESET + this.props.getDoriki(), posX - 30, posY + 70, -1);
    this.mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + factionGUI + ": " + EnumChatFormatting.RESET + factionActual, posX - 30, posY + 90, -1);
    this.mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + raceGUI + ": " + EnumChatFormatting.RESET + raceActual, posX - 30, posY + 110, -1);
    this.mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + styleGUI + ": " + EnumChatFormatting.RESET + styleActual, posX - 30, posY + 130, -1);
    if (this.props.getBelly() > 0) {
      this.mc.fontRenderer.drawStringWithShadow("" + this.props.getBelly(), posX + 215, posY + 72, -1);
      this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
      drawTexturedModalRect(posX + 190, posY + 60, 0, 32, 32, 64);
    } 
    if (this.props.getExtol() > 0) {
      this.mc.fontRenderer.drawStringWithShadow("" + this.props.getExtol(), posX + 215, posY + 102, -1);
      this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
      drawTexturedModalRect(posX + 190, posY + 90, 34, 32, 64, 86);
    } 
    if (!this.props.getUsedFruit().equalsIgnoreCase("n/a") && !this.props.getUsedFruit().equals("null")) {
      ItemStack yamiFruit = new ItemStack(GameRegistry.findItem("mineminenomi", "yamiyaminomi"));
      if (!this.props.getUsedFruit().equals("yamidummy")) {
        ItemStack df = DevilFruitsHelper.getDevilFruitItem(this.props.getUsedFruit());
        if (df == null)
          return; 
        if (this.props.hasYamiPower()) {
          this.mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + yamiFruit.getDisplayName() + " + " + df.getDisplayName(), posX - 28, posY + 194, -1);
        } else if (df.getDisplayName() != null) {
          this.mc.fontRenderer.drawStringWithShadow(df.getDisplayName(), posX - 28, posY + 194, -1);
        } 
        if (this.props.hasYamiPower())
          drawItemStack(yamiFruit, posX - 56, posY + 187, ""); 
        drawItemStack(df, posX - 50, posY + 190, "");
      } else {
        this.mc.fontRenderer.drawStringWithShadow(EnumChatFormatting.BOLD + yamiFruit.getDisplayName(), posX - 28, posY + 194, -1);
        drawItemStack(yamiFruit, posX - 50, posY + 190, "");
      } 
    } 
    RenderHelper.disableStandardItemLighting();
    super.drawScreen(x, y, f);
  }
  
  public void initGui() {
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    this.buttonList.add(new GuiButton(1, posX - 20, posY + 210, 50, 20, I18n.format("gui.abilities.name", new Object[0])));
    if (MainConfig.enableQuests)
      this.buttonList.add(new GuiButton(2, posX + 40, posY + 210, 50, 20, I18n.format("gui.quests.name", new Object[0]))); 
  }
  
  public void actionPerformed(GuiButton button) {
    switch (button.id) {
      case 1:
        this.player.openGui(MainMod.getMineMineNoMi(), 4, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
        break;
      case 2:
        this.player.openGui(MainMod.getMineMineNoMi(), 5, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
        break;
      case 3:
        this.player.openGui(MainMod.getMineMineNoMi(), 6, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
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
