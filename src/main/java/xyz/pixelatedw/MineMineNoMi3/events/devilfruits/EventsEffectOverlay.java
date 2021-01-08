package xyz.pixelatedw.MineMineNoMi3.events.devilfruits;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.MainKeys;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;
import xyz.pixelatedw.MineMineNoMi3.models.effects.ModelCandleLock;
import xyz.pixelatedw.MineMineNoMi3.models.effects.ModelChains;
import xyz.pixelatedw.MineMineNoMi3.renderers.effects.RenderCandleLock;
import xyz.pixelatedw.MineMineNoMi3.renderers.effects.RenderChains;

public class EventsEffectOverlay {
  public boolean init = false;
  
  public String usedFruit = "n/a";
  
  public volatile boolean isOk = false;
  
  private RenderCandleLock candleLock = new RenderCandleLock((ModelBase)new ModelCandleLock());
  
  private RenderChains oriBind = new RenderChains((ModelBase)new ModelChains());
  
  public HashMap<Integer, Ability> abSlot = new HashMap<>();
  
  @SubscribeEvent
  @SideOnly(Side.CLIENT)
  public void onTick(TickEvent.PlayerTickEvent event) {
    if ((Minecraft.getMinecraft()).theWorld != null) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)(Minecraft.getMinecraft()).thePlayer);
      AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)(Minecraft.getMinecraft()).thePlayer);
      if (props.hasDevilFruit() && !this.init) {
        this.usedFruit = props.getUsedFruit();
        this.init = true;
      } else if (!this.usedFruit.equalsIgnoreCase("n/a")) {
        int i;
        for (i = 0; i < abilityProps.hotbarAbilities.length - 1; i++) {
          abilityProps.getAbilityFromSlot(i);
          this.abSlot.put(Integer.valueOf(i), abilityProps.getAbilityFromSlot(i));
        } 
        for (KeyBinding key : MainKeys.keyBindsCombatbar) {
          if (key != null && 
            key.isPressed() && (Minecraft.getMinecraft()).currentScreen instanceof xyz.pixelatedw.MineMineNoMi3.gui.GUISelectHotbarAbilities) {
            this.abSlot.clear();
            this.init = false;
            this.usedFruit = "n/a";
            this.isOk = false;
            break;
          } 
        } 
        if (!this.abSlot.isEmpty())
          for (i = 0; i < this.abSlot.size() + 1; i++) {
            Ability ok = this.abSlot.get(Integer.valueOf(i));
            if (ok != null) {
              ItemStack df = DevilFruitsHelper.getDevilFruitItem(props.getUsedFruit());
              for (Ability a : ((AkumaNoMi)df.getItem()).abilities) {
                if (a == ok) {
                  this.isOk = true;
                  break;
                } 
              } 
              if (!this.isOk)
                abilityProps.setAbilityInSlot(i, ok); 
            } 
          }  
      } 
    } 
  }
  
  @SubscribeEvent
  public void onEntityDeath(LivingDeathEvent event) {
    if (event.entity instanceof EntityPlayer && 
      event.entity == (Minecraft.getMinecraft()).thePlayer) {
      this.usedFruit = "n/a";
      this.isOk = false;
    } 
  }
  
  @SubscribeEvent
  public void onEntityRendered(RenderLivingEvent.Pre event) {
    ExtendedEntityData props = ExtendedEntityData.get(event.entity);
    if (props.hasExtraEffects("mero")) {
      GL11.glPushMatrix();
      Color c = WyHelper.hexToRGB("#5d6060");
      GL11.glColor3d(c.getRed() / 255.0D, c.getGreen() / 255.0D, c.getBlue() / 255.0D);
      GL11.glPopMatrix();
    } else if (props.hasExtraEffects("logiaOff")) {
      GL11.glPushMatrix();
      Color c = WyHelper.hexToRGB("#011F4B");
      GL11.glColor3d(c.getRed() / 255.0D, c.getGreen() / 255.0D, c.getBlue() / 255.0D);
      GL11.glPopMatrix();
    } else if (props.hasExtraEffects("hie")) {
      GL11.glPushMatrix();
      Color c = WyHelper.hexToRGB("#1be2e2");
      GL11.glPopMatrix();
    } else if (props.hasExtraEffects("noro")) {
      GL11.glPushMatrix();
      Color c = WyHelper.hexToRGB("#ce83d3");
      GL11.glColor3d(c.getRed() / 255.0D, c.getGreen() / 255.0D, c.getBlue() / 255.0D);
      GL11.glPopMatrix();
    } else if (props.hasExtraEffects("doruLock")) {
      this.candleLock.doRender((Entity)event.entity, event.x, event.y, event.z, 0.0F, 0.0625F);
    } else if (props.hasExtraEffects("rustOverlay")) {
      GL11.glPushMatrix();
      Color c = WyHelper.hexToRGB("#a04921");
      GL11.glColor3d(c.getRed() / 255.0D, c.getGreen() / 255.0D, c.getBlue() / 255.0D);
      GL11.glPopMatrix();
    } else if (props.hasExtraEffects("spiderOverlay")) {
      GL11.glPushMatrix();
      Color c = WyHelper.hexToRGB("#606875");
      GL11.glColor3d(c.getRed() / 255.0D, c.getGreen() / 255.0D, c.getBlue() / 255.0D);
      GL11.glPopMatrix();
    } else if (props.hasExtraEffects("oriBind")) {
      this.oriBind.doRender((Entity)event.entity, event.x, event.y, event.z, 0.0F, 0.0625F);
    } 
  }
  
  @SubscribeEvent
  public void onRenderTick(TickEvent.RenderTickEvent event) {
    Minecraft mc = Minecraft.getMinecraft();
    EntityClientPlayerMP entityClientPlayerMP = mc.thePlayer;
    if (entityClientPlayerMP == null)
      return; 
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityClientPlayerMP);
    ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
    if (props.hasExtraEffects("mero")) {
      WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#5d6060").getRGB(), 100, 0.0D, 0.0D, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200.0D);
    } else if (props.hasExtraEffects("hie")) {
      WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#1be2e2").getRGB(), 100, 0.0D, 0.0D, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200.0D);
    } else if (props.hasExtraEffects("noro")) {
      WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#ce83d3").getRGB(), 100, 0.0D, 0.0D, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200.0D);
    } else if (props.hasExtraEffects("rustOverlay")) {
      WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#a04921").getRGB(), 100, 0.0D, 0.0D, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200.0D);
    } else if (props.hasExtraEffects("spiderOverlay")) {
      WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#3e4247").getRGB(), 100, 0.0D, 0.0D, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200.0D);
    } else if (props.hasExtraEffects("haoHaki")) {
      if (entityClientPlayerMP.isPotionActive(Potion.blindness.id)) {
        WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#000000").getRGB(), 240, 0.0D, 0.0D, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200.0D);
      } else {
        WyRenderHelper.drawColourOnScreen(WyHelper.hexToRGB("#72399d").getRGB(), 100, 0.0D, 0.0D, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200.0D);
      } 
    } 
    if (props.isInAirWorld())
      WyRenderHelper.drawColourOnScreen(0, 50, 0, 100, 0.0D, 0.0D, sr.getScaledWidth_double(), sr.getScaledHeight_double(), 200.0D); 
  }
}
