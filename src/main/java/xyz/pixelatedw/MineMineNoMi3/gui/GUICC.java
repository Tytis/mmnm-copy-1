package xyz.pixelatedw.MineMineNoMi3.gui;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.gui.extra.GUIButtonNoTexture;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

@SideOnly(Side.CLIENT)
public class GUICC extends GuiScreen {
  private EntityPlayer player;
  
  private int page = 0;
  
  private int selectedOpt = 0;
  
  private int maxOpt;
  
  private int lastFac = 0;
  
  private int lastRace = 0;
  
  private int lastFStyle = 0;
  
  private FontRenderer onePieceFontRenderer;
  
  public GUICC(EntityPlayer player) {
    this.player = player;
  }
  
  public void drawScreen(int x, int y, float f) {
    drawDefaultBackground();
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)this.player);
    GL11.glTranslated(20.0D, -10.0D, 0.0D);
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_BLANK);
    drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
    Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);
    drawTexturedModalRect(posX + 15, posY + 75, 0, 92, 25, 100);
    drawTexturedModalRect(posX + 200, posY + 73, 26, 92, 30, 100);
    drawTexturedModalRect(posX - 80, posY + 70, 0, 196, 96, 49);
    drawTexturedModalRect(posX - 80, posY + 112, 0, 196, 96, 49);
    drawTexturedModalRect(posX - 80, posY + 154, 0, 196, 96, 49);
    drawTexturedModalRect(posX + 75, posY + 200, 0, 196, 96, 49);
    drawCategory("Faction", posX + 70, posY + 225, 2.1D);
    drawCategory("Race", posX + 82, posY + 267, 2.1D);
    drawCategory("Fighting", posX - 5, posY + 227, 1.5D);
    drawCategory("Style", posX + 25, posY + 242, 1.5D);
    drawCategory("Create", posX + 225, posY + 356, 2.1D);
    if (this.page == 0)
      if (this.selectedOpt == 0) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_PIRATE);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Pirate", posX + 337, posY + 315, 3.0D);
      } else if (this.selectedOpt == 1) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_MARINE);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Marine", posX + 337, posY + 315, 3.0D);
      } else if (this.selectedOpt == 2) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_BOUNTYHUNTER);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Bounty", posX + 275, posY + 275, 2.7D);
        drawCategory("Hunter", posX + 330, posY + 300, 2.7D);
      } else if (this.selectedOpt == 3) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_REVOLUTIONARY);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Revolutionary", posX + 210, posY + 230, 2.3D);
        drawCategory("Army", posX + 300, posY + 255, 2.3D);
      }  
    if (this.page == 1)
      if (this.selectedOpt == 0) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_HUMAN);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Human", posX + 337, posY + 315, 3.0D);
      } else if (this.selectedOpt == 1) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_FISHMAN);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Fishman", posX + 328, posY + 315, 3.0D);
      } else if (this.selectedOpt == 2) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_CYBORG);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Cyborg", posX + 328, posY + 315, 3.0D);
      }  
    if (this.page == 2)
      if (this.selectedOpt == 0) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_SWORDSMAN);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Swordsman", posX + 300, posY + 315, 3.0D);
      } else if (this.selectedOpt == 1) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_SNIPER);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Sniper", posX + 335, posY + 315, 3.0D);
      } else if (this.selectedOpt == 2) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_MEDIC);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Doctor", posX + 340, posY + 315, 3.0D);
      } else if (this.selectedOpt == 3) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_ARTOFWEATHER);
        drawTexturedModalRect(posX - 2, posY + 10, 0, 0, 256, 256);
        drawCategory("Art of Weather", posX + 200, posY + 220, 2.2D);
      }  
    super.drawScreen(x, y, f);
  }
  
  public void initGui() {
    int posX = (this.width - 256) / 2;
    int posY = (this.height - 256) / 2;
    this.buttonList.add(new GUIButtonNoTexture(100, posX - 58, posY + 63, 90, 36, ""));
    this.buttonList.add(new GUIButtonNoTexture(101, posX - 58, (int)(posY + 100.80000000000001D), 90, 36, ""));
    this.buttonList.add(new GUIButtonNoTexture(102, posX - 58, (int)(posY + 136.4D), 90, 36, ""));
    this.buttonList.add(new GUIButtonNoTexture(103, posX + 35, posY + 75, 24, 100, ""));
    this.buttonList.add(new GUIButtonNoTexture(104, posX + 230, posY + 73, 24, 100, ""));
    this.buttonList.add(new GUIButtonNoTexture(105, posX + 97, posY + 195, 90, 35, ""));
  }
  
  public void updateScreen() {
    if (this.page == 0)
      this.maxOpt = 4; 
    if (this.page == 1)
      this.maxOpt = 3; 
    if (this.page == 2)
      this.maxOpt = 4; 
  }
  
  public void actionPerformed(GuiButton button) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)this.player);
    if (button.id >= 0 && button.id < 10)
      props.setFaction(button.displayString); 
    if (button.id >= 10 && button.id < 20)
      props.setRace(button.displayString); 
    if (button.id >= 20 && button.id < 30)
      props.setFightStyle(button.displayString); 
    switch (button.id) {
      case 104:
        if (this.selectedOpt + 1 < this.maxOpt) {
          this.selectedOpt++;
          break;
        } 
        this.selectedOpt = 0;
        break;
      case 103:
        if (this.selectedOpt - 1 > -1) {
          this.selectedOpt--;
          break;
        } 
        this.selectedOpt = this.maxOpt - 1;
        break;
      case 105:
        if (this.lastFac == 0) {
          props.setFaction("Pirate");
        } else if (this.lastFac == 1) {
          props.setFaction("Marine");
        } else if (this.lastFac == 2) {
          props.setFaction("Bounty Hunter");
        } else if (this.lastFac == 3) {
          props.setFaction("Revolutionary");
        } 
        if (this.lastRace == 0) {
          props.setRace("Human");
        } else if (this.lastRace == 1) {
          props.setRace("Fishman");
        } else if (this.lastRace == 2) {
          props.setRace("Cyborg");
        } 
        if (this.lastFStyle == 0) {
          props.setFightStyle("Swordsman");
        } else if (this.lastFStyle == 1) {
          props.setFightStyle("Sniper");
        } else if (this.lastFStyle == 2) {
          props.setFightStyle("Doctor");
        } else if (this.lastFStyle == 3) {
          props.setFightStyle("Art of Weather");
        } 
        switch (this.page) {
          case 0:
            switch (this.selectedOpt) {
              case 0:
                props.setFaction("Pirate");
                break;
              case 1:
                props.setFaction("Marine");
                break;
              case 2:
                props.setFaction("Bounty Hunter");
                break;
              case 3:
                props.setFaction("Revolutionary");
                break;
            } 
            break;
          case 1:
            switch (this.selectedOpt) {
              case 0:
                props.setRace("Human");
                break;
              case 1:
                props.setRace("Fishman");
                break;
              case 2:
                props.setRace("Cyborg");
                break;
            } 
            break;
          case 2:
            switch (this.selectedOpt) {
              case 0:
                props.setFightStyle("Swordsman");
                break;
              case 1:
                props.setFightStyle("Sniper");
                break;
              case 2:
                props.setFightStyle("Doctor");
                break;
              case 3:
                props.setFightStyle("Art of Weather");
                break;
            } 
            break;
        } 
        if (!props.getRace().equals("N/A") && !props.getFaction().equals("N/A") && !props.getFightStyle().equals("N/A")) {
          this.mc.displayGuiScreen((GuiScreen)null);
          WyNetworkHelper.sendToServer((IMessage)new PacketSync(props));
          WyNetworkHelper.sendToServer((IMessage)new PacketPlayer("delete_book"));
        } 
        break;
      case 100:
        if (this.page == 0)
          this.lastFac = this.selectedOpt; 
        if (this.page == 1)
          this.lastRace = this.selectedOpt; 
        if (this.page == 2)
          this.lastFStyle = this.selectedOpt; 
        this.page = 0;
        if (this.page == 0)
          this.selectedOpt = this.lastFac; 
        if (this.page == 1)
          this.selectedOpt = this.lastRace; 
        if (this.page == 2)
          this.selectedOpt = this.lastFStyle; 
        this.mc.displayGuiScreen(this);
        break;
      case 101:
        if (this.page == 0) {
          this.lastFac = this.selectedOpt;
        } else if (this.page == 1) {
          this.lastRace = this.selectedOpt;
        } else if (this.page == 2) {
          this.lastFStyle = this.selectedOpt;
        } 
        this.page = 1;
        if (this.page == 0)
          this.selectedOpt = this.lastFac; 
        if (this.page == 1)
          this.selectedOpt = this.lastRace; 
        if (this.page == 2)
          this.selectedOpt = this.lastFStyle; 
        this.mc.displayGuiScreen(this);
        break;
      case 102:
        if (this.page == 0) {
          this.lastFac = this.selectedOpt;
        } else if (this.page == 1) {
          this.lastRace = this.selectedOpt;
        } else if (this.page == 2) {
          this.lastFStyle = this.selectedOpt;
        } 
        this.page = 2;
        if (this.page == 0)
          this.selectedOpt = this.lastFac; 
        if (this.page == 1)
          this.selectedOpt = this.lastRace; 
        if (this.page == 2)
          this.selectedOpt = this.lastFStyle; 
        this.mc.displayGuiScreen(this);
        break;
    } 
  }
  
  public boolean doesGuiPauseGame() {
    return false;
  }
  
  private void drawCategory(String text, int posX, int posY, double scale) {
    GL11.glPushMatrix();
    GL11.glTranslated(posX, posY, 0.0D);
    GL11.glTranslated(128.0D, 128.0D, 0.0D);
    GL11.glScaled(scale, scale, scale);
    GL11.glTranslated(-128.0D, -128.0D, 0.0D);
    WyRenderHelper.drawStringWithBorder(text, 0, 0, WyHelper.hexToRGB("#FFFFFF").getRGB());
    GL11.glPopMatrix();
  }
}
