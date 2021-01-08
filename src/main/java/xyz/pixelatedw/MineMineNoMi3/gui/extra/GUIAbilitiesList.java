package xyz.pixelatedw.MineMineNoMi3.gui.extra;

import cpw.mods.fml.client.GuiScrollingList;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.PacketAbilitySync;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.gui.GUISelectHotbarAbilities;

public class GUIAbilitiesList extends GuiScrollingList {
  private GUISelectHotbarAbilities parent;
  
  private AbilityProperties props;
  
  private List<Ability> availableAbilities = new ArrayList<>();
  
  public GUIAbilitiesList(GUISelectHotbarAbilities parent, AbilityProperties abilityProps, Ability[] abilities) {
    super(parent.mc, 220, 300, (parent.relativePosY - 200) / 2, (parent.relativePosY + 60) / 2, (parent.relativePosX - 220) / 2, 26);
    this.parent = parent;
    this.props = abilityProps;
    this.availableAbilities.clear();
    for (int i = 0; i < abilities.length - 1; i++) {
      if (abilities[i] != null)
        this.availableAbilities.add(abilities[i]); 
    } 
  }
  
  protected int getContentHeight() {
    return getSize() * 27 + 1;
  }
  
  protected int getSize() {
    return this.availableAbilities.size();
  }
  
  protected void elementClicked(int index, boolean doubleClick) {
    if (this.parent.slotSelected > -1) {
      boolean flag = true;
      for (int i = 0; i < this.props.countAbilitiesInHotbar(); i++) {
        if (this.props.getAbilityFromSlot(i) != null && this.props.getAbilityFromSlot(i).getAttribute().getAttributeName().equalsIgnoreCase(((Ability)this.availableAbilities.get(index)).getAttribute().getAttributeName()))
          flag = false; 
      } 
      if (flag) {
        this.props.setAbilityInSlot(this.parent.slotSelected, AbilityManager.instance().getAbilityByName(WyHelper.getFancyName(((Ability)this.availableAbilities.get(index)).getAttribute().getAttributeName())));
        WyNetworkHelper.sendToServer((IMessage)new PacketAbilitySync(this.props));
      } 
    } 
  }
  
  protected boolean isSelected(int index) {
    return false;
  }
  
  protected void drawBackground() {}
  
  protected void drawSlot(int slotIndex, int entryRight, int slotTop, int slotBuffer, Tessellator tess) {
    boolean flag = false;
    AbilityAttribute attr = ((Ability)this.availableAbilities.get(slotIndex)).getAttribute();
    for (int i = 0; i < this.props.countAbilitiesInHotbar(); i++) {
      if (this.props.getAbilityFromSlot(i) != null && this.props.getAbilityFromSlot(i).getAttribute().getAttributeName().equalsIgnoreCase(((Ability)this.availableAbilities.get(slotIndex)).getAttribute().getAttributeName()))
        flag = true; 
      (Minecraft.getMinecraft()).fontRenderer.drawStringWithShadow(I18n.format("ability." + WyHelper.getFancyName(((Ability)this.availableAbilities.get(slotIndex)).getAttribute().getAttributeName()) + ".name", new Object[0]), this.left + 40, slotTop + 7, flag ? 16711680 : 16777215);
    } 
    GL11.glPushMatrix();
    WyRenderHelper.drawAbilityIcon(WyHelper.getFancyName(attr.getAbilityTexture()), this.left + 10, slotTop + 2, 16, 16);
    GL11.glPopMatrix();
  }
}
