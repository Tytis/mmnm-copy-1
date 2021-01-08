package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

@SideOnly(Side.CLIENT)
public class EventsCombatMode extends Gui {
  private Minecraft mc;
  
  protected static final RenderItem itemRenderer = new RenderItem();
  
  private int trackDistance = 15;
  
  private EntityLivingBase trackMob = null;
  
  public EventsCombatMode(Minecraft mc) {
    this.mc = mc;
  }
  
  @SubscribeEvent(priority = EventPriority.NORMAL)
  public void onRenderUI(RenderGameOverlayEvent event) {
    EntityClientPlayerMP entityClientPlayerMP = this.mc.thePlayer;
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityClientPlayerMP);
    AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)entityClientPlayerMP);
    int posX = event.resolution.getScaledWidth();
    int posY = event.resolution.getScaledHeight();
    GuiIngameForge.left_height++;
    if (event.type == RenderGameOverlayEvent.ElementType.FOOD && props.getUsedFruit().equalsIgnoreCase("yomiyomi") && props.getZoanPoint().equalsIgnoreCase("yomi"))
      event.setCanceled(true); 
    if (event.type == RenderGameOverlayEvent.ElementType.HEALTH) {
      event.setCanceled(true);
      double maxHealth = entityClientPlayerMP.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
      double health = entityClientPlayerMP.getHealth();
      drawCenteredString(this.mc.fontRenderer, (int)health + "", posX / 2 - 20, posY - 39, Color.RED.getRGB());
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.getTextureManager().bindTexture(icons);
      double f2 = entityClientPlayerMP.getAbsorptionAmount();
      int i;
      for (i = MathHelper.ceiling_double_int(maxHealth / 2.0D) - 1; i >= 0; i--) {
        int k = posX / 2 - 91 + i % 10 * 6;
        drawTexturedModalRect(k, posY - 39, 16, 0, 9, 9);
      } 
      for (i = 0; i < (100.0D - (maxHealth - health) / maxHealth * 100.0D) / 10.0D; i++) {
        int k = posX / 2 - 91 + i % 10 * 6;
        drawTexturedModalRect(k, posY - 39, 52, 0, 9, 9);
      } 
    } 
    if (props.isInCombatMode() && event.type == RenderGameOverlayEvent.ElementType.HOTBAR) {
      event.setCanceled(true);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(2896);
      this.mc.getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);
      int i;
      for (i = 0; i < 8; i++) {
        GL11.glEnable(3042);
        if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isOnCooldown() && !abilityProps.getAbilityFromSlot(i).isDisabled()) {
          drawTexturedModalRect((posX - 200 + i * 50) / 2, posY - 23, 24, 0, 23, 23);
        } else if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isCharging()) {
          drawTexturedModalRect((posX - 200 + i * 50) / 2, posY - 23, 72, 0, 23, 23);
        } else if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isPassiveActive()) {
          drawTexturedModalRect((posX - 200 + i * 50) / 2, posY - 23, 48, 0, 23, 23);
        } else if (abilityProps.getAbilityFromSlot(i) != null && abilityProps.getAbilityFromSlot(i).isDisabled()) {
          drawTexturedModalRect((posX - 200 + i * 50) / 2, posY - 23, 96, 0, 23, 23);
        } else {
          drawTexturedModalRect((posX - 200 + i * 50) / 2, posY - 23, 0, 0, 23, 23);
        } 
      } 
      if (props.isCyborg()) {
        drawTexturedModalRect((posX - 260) / 2, posY - 42, 0, 52, 23, 40);
        int barHeight = (int)(props.getCola() / props.getMaxCola() * 30.0F) + 23;
        if (barHeight > 0 && barHeight < 24) {
          barHeight = 24;
        } else if (barHeight > 52) {
          barHeight = 52;
        } 
        drawTexturedModalRect((posX - 252) / 2, posY - 42, 32, barHeight, 16, 32);
        drawCenteredString(this.mc.fontRenderer, props.getCola() + "", (posX - 237) / 2, posY - 12, Color.WHITE.getRGB());
      } 
      for (i = 0; i < 8; i++) {
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        if (abilityProps.getAbilityFromSlot(i) != null) {
          AbilityAttribute attr = abilityProps.getAbilityFromSlot(i).getAttribute();
          WyRenderHelper.drawAbilityIcon(WyHelper.getFancyName(attr.getAbilityTexture()), (posX - 192 + i * 50) / 2, posY - 19, 16, 16);
        } 
      } 
      int trackDistance = 15;
      if (props.hasKenHakiActive()) {
        List<EntityLivingBase> nearbyEnemies = WyHelper.getEntitiesNear((Entity)entityClientPlayerMP, 15.0D);
        for (EntityLivingBase elb : nearbyEnemies) {
          if (this.trackMob == null) {
            this.trackMob = elb;
            continue;
          } 
          if (entityClientPlayerMP.getDistanceToEntity((Entity)elb) <= entityClientPlayerMP.getDistanceToEntity((Entity)this.trackMob)) {
            this.trackMob = elb;
          } else if (this.trackMob.getHealth() <= 0.0F || !this.trackMob.isEntityAlive()) {
            this.trackMob = null;
          } 
          if (this.trackMob != null && entityClientPlayerMP.getDistanceToEntity((Entity)this.trackMob) < trackDistance) {
            trackDistance = (int)entityClientPlayerMP.getDistanceToEntity((Entity)this.trackMob);
            float angle = (float)Math.toDegrees(Math.atan2(this.trackMob.posZ - ((EntityPlayer)entityClientPlayerMP).posZ, this.trackMob.posX - ((EntityPlayer)entityClientPlayerMP).posX));
            String text = "";
            text = text + trackDistance + " blocks";
            Minecraft.getMinecraft().getTextureManager().bindTexture(ID.ICON_HARROW);
            GL11.glPushMatrix();
            int posX2 = (posX - 256) / 2;
            int posY2 = posY - 256;
            GL11.glTranslated((posX2 + 190), (posY2 + 60), 0.0D);
            GL11.glTranslated(128.0D, 128.0D, 128.0D);
            GL11.glScaled(0.2D, 0.2D, 0.0D);
            WyHelper.Direction playerDir = WyHelper.get8Directions((Entity)entityClientPlayerMP);
            if (playerDir == WyHelper.Direction.SOUTH) {
              GL11.glRotated((angle - 90.0F), 0.0D, 0.0D, 1.0D);
            } else if (playerDir == WyHelper.Direction.SOUTH_EAST) {
              GL11.glRotated((angle - 45.0F), 0.0D, 0.0D, 1.0D);
            } 
            if (playerDir == WyHelper.Direction.EAST) {
              GL11.glRotated(angle, 0.0D, 0.0D, 1.0D);
            } else if (playerDir == WyHelper.Direction.NORTH_EAST) {
              GL11.glRotated((angle + 45.0F), 0.0D, 0.0D, 1.0D);
            } else if (playerDir == WyHelper.Direction.NORTH) {
              GL11.glRotated((angle + 90.0F), 0.0D, 0.0D, 1.0D);
            } else if (playerDir == WyHelper.Direction.NORTH_WEST) {
              GL11.glRotated((angle + 135.0F), 0.0D, 0.0D, 1.0D);
            } else if (playerDir == WyHelper.Direction.WEST) {
              GL11.glRotated((angle + 180.0F), 0.0D, 0.0D, 1.0D);
            } else if (playerDir == WyHelper.Direction.SOUTH_WEST) {
              GL11.glRotated((angle + 225.0F), 0.0D, 0.0D, 1.0D);
            } 
            GL11.glTranslated(-128.0D, -128.0D, -128.0D);
            drawTexturedModalRect(0, 0, 0, 0, 256, 256);
            GL11.glPopMatrix();
            WyRenderHelper.drawEntityOnScreen((posX + 320) / 2, posY - 42, 40, 40.0F, 0.0F, this.trackMob);
            drawCenteredString(this.mc.fontRenderer, text, (posX + 320) / 2, posY - 32, Color.WHITE.getRGB());
          } 
        } 
      } 
      GL11.glDisable(3042);
    } 
  }
  
  @SubscribeEvent
  public void updateFOV(FOVUpdateEvent event) {
    if (!MainConfig.enableFOVModifier) {
      if (event.entity.isPotionActive(Potion.moveSlowdown))
        event.newfov = 1.0F; 
      if (event.entity.isPotionActive(Potion.moveSpeed))
        event.newfov = 1.0F; 
      if (event.entity.isPotionActive(Potion.moveSpeed) && event.entity.isSprinting())
        event.newfov = 1.1F; 
    } 
  }
}
