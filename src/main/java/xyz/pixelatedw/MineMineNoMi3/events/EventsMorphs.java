package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Arrays;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.helpers.HandRendererHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.MorphsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.RenderSoru;
import xyz.pixelatedw.MineMineNoMi3.models.effects.ModelAbareHimatsuri;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.thundercloud;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;
import xyz.pixelatedw.MineMineNoMi3.renderers.effects.RenderAbareHimatsuri;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans.RenderZoanMorph;

@SideOnly(Side.CLIENT)
public class EventsMorphs {
  private Minecraft mc;
  
  public int i = 0;
  
  private RenderAbareHimatsuri abareHimatsuri = new RenderAbareHimatsuri((ModelBase)new ModelAbareHimatsuri());
  
  private RenderSoru sorumove = new RenderSoru((ModelBase)new thundercloud());
  
  private EntityRenderer renderer;
  
  private EntityRenderer prevRenderer;
  
  private String prevZoanPoint;
  
  public EventsMorphs(Minecraft mc) {
    this.mc = mc;
  }
  
  @SubscribeEvent
  public void onArmorRendering(RenderPlayerEvent.SetArmorModel event) {
    EntityPlayer player = event.entityPlayer;
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    AbilityProperties abilityProps = AbilityProperties.get(player);
    Ability fullBodyHakiAbility = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_FULL_BODY_HARDENING.getAttributeName());
    if (fullBodyHakiAbility != null && fullBodyHakiAbility.isPassiveActive()) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(1, 775);
      float f2 = interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, event.partialRenderTick);
      float f3 = interpolateRotation(player.prevRotationYawHead, player.rotationYawHead, event.partialRenderTick);
      float f4 = handleRotationFloat((EntityLivingBase)player, event.partialRenderTick);
      float f6 = player.prevLimbSwingAmount + (player.limbSwingAmount - player.prevLimbSwingAmount) * event.partialRenderTick;
      float f7 = player.limbSwing - player.limbSwingAmount * (1.0F - event.partialRenderTick);
      float f13 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * event.partialRenderTick;
      ModelBiped fullBodyHakiModel = new ModelBiped(0.05F);
      GL11.glScaled(0.1D, 0.1D, 0.1D);
      Minecraft.getMinecraft().getTextureManager().bindTexture(ID.HANDTEXTURE_ZOANMORPH_BUSO);
      fullBodyHakiModel.bipedHead.isHidden = false;
      fullBodyHakiModel.bipedHeadwear.isHidden = false;
      fullBodyHakiModel.isSneak = player.isSneaking();
      fullBodyHakiModel.isChild = false;
      event.renderer.setRenderPassModel((ModelBase)fullBodyHakiModel);
      fullBodyHakiModel.render((Entity)player, f7, f6, f4, f3 - f2, f13, 0.625F);
      GL11.glPopMatrix();
    } 
  }
  
  protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_) {
    return p_77044_1_.ticksExisted + p_77044_2_;
  }
  
  private float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
    float f3;
    for (f3 = p_77034_2_ - p_77034_1_; f3 < -180.0F; f3 += 360.0F);
    while (f3 >= 180.0F)
      f3 -= 360.0F; 
    return p_77034_1_ + p_77034_3_ * f3;
  }
  
  @SubscribeEvent
  public void onRenderTick(TickEvent.RenderTickEvent event) {
    EntityClientPlayerMP entityClientPlayerMP = this.mc.thePlayer;
    if (entityClientPlayerMP == null)
      return; 
    AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)entityClientPlayerMP);
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)this.mc.thePlayer);
    Ability dragonPoint = abilityProps.getAbilityFromName(ListAttributes.DRAGONPOINT.getAttributeName());
    boolean hasDragonPoint = (dragonPoint != null && dragonPoint.isPassiveActive());
    if (this.prevRenderer != null && props.getZoanPoint().equalsIgnoreCase("n/a")) {
      this.mc.entityRenderer = this.prevRenderer;
    } else if (MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit())) {
      Object[][] forms = (Object[][])MorphsHelper.getMorphsMap().get(props.getUsedFruit());
      for (Object[] form : forms) {
        if (props.getZoanPoint().equalsIgnoreCase((String)form[0]) && (EntityRenderer)form[2] != null) {
          if (this.renderer == null || !props.getZoanPoint().equalsIgnoreCase(this.prevZoanPoint))
            this.renderer = (EntityRenderer)form[2]; 
          if (this.mc.entityRenderer != this.renderer) {
            this.prevRenderer = this.mc.entityRenderer;
            this.mc.entityRenderer = this.renderer;
            this.prevZoanPoint = props.getZoanPoint();
          } 
        } 
      } 
    } 
  }
  
  @SubscribeEvent
  public void onRenderPlayerEvent(RenderPlayerEvent.Pre event) {
    ExtendedEntityData propz = ExtendedEntityData.get((EntityLivingBase)event.entityPlayer);
    if (propz.isInAirWorld())
      event.setCanceled(true); 
  }
  
  @SubscribeEvent
  public void onEntityRendered(RenderLivingEvent.Pre event) {
    ExtendedEntityData props = ExtendedEntityData.get(event.entity);
    if (!props.getZoanPoint().toLowerCase().equals("n/a")) {
      if (event.entity.hurtTime > 0) {
        GL11.glPushMatrix();
        GL11.glColor3f(1.0F, 0.0F, 0.0F);
        GL11.glPopMatrix();
      } 
      event.setCanceled(true);
      if (MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
			Arrays.stream(MorphsHelper.getMorphsMap().get(props.getUsedFruit())).forEach(x ->
			{
				if (props.getZoanPoint().equalsIgnoreCase((String) x[0]))
				{
					this.doRenderZoanMorph((RenderZoanMorph) x[1], event.x, event.y, event.z, event.entity);
				}
			});
    } 
    if (props.getUsedFruit().equalsIgnoreCase("sukesuke") && event.entity.isInvisible())
      event.setCanceled(true); 
    if (event.entity instanceof EntityPlayer) {
      AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)event.entity);
      if (props.hasExtraEffects("abareHimatsuri")) {
        if (event.entity.onGround) {
          Block block = event.entity.worldObj.getBlock((int)event.entity.posX, (int)event.entity.posY - 2, (int)event.entity.posZ);
          String texture = Blocks.dirt.getIcon(1, 0).getIconName();
          int blockTint = event.entity.worldObj.getBlock((int)event.entity.posX, (int)event.entity.posY - 2, (int)event.entity.posZ).colorMultiplier((IBlockAccess)event.entity.worldObj, (int)event.entity.posX, (int)event.entity.posY - 2, (int)event.entity.posZ);
          if (block.getIcon(1, 0) != null)
            texture = block.getIcon(1, 0).getIconName(); 
          this.abareHimatsuri.setTextureAndTint(texture, blockTint);
        } 
        System.out.println(event.entity.onGround);
        if (!event.entity.onGround)
          this.abareHimatsuri.doRender((Entity)event.entity, event.x, event.y, event.z, 0.0F, 0.0625F); 
      } else if (props.hasExtraEffects("soru") && 
        event.entity != null && 
        this.mc.currentScreen == null && 
        !event.entity.onGround && abilityProps.getAbilityFromName(ListAttributes.LightningRide.getAttributeName()).isPassiveActive()) {
        this.sorumove.doRender((Entity)event.entity, event.x, event.y, event.z, 0.0F, 0.0625F);
      } 
    } 
  }
  
  private void doRenderZoanMorph(RenderZoanMorph render, double x, double y, double z, EntityLivingBase entity) {
    if ((Minecraft.getMinecraft()).thePlayer.equals(entity)) {
      render.doRender((Entity)entity, 0.0D, -1.625D, 0.0D, 0.0F, 0.0625F);
    } else {
      render.doRender((Entity)entity, x, y, z, 0.0F, 0.0625F);
    } 
  }
  
  @SubscribeEvent
  public void onEntityConstructing(EntityJoinWorldEvent event) {
    if (event.entity instanceof EntityPlayer) {
      EntityPlayer owner = (EntityPlayer)event.entity;
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)owner);
      if (!props.getZoanPoint().toLowerCase().equals("n/a") && !props.getZoanPoint().toLowerCase().equals("yomi")) {
        props.setZoanPoint("n/a");
        WyNetworkHelper.sendToServer((IMessage)new PacketSync(props));
        WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(owner.getDisplayName(), props));
      } 
    } 
  }
  
  @SubscribeEvent
  public void morphHandRendering(RenderHandEvent event) {
    EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityClientPlayerMP);
    AbilityProperties abilityProps = AbilityProperties.get((EntityPlayer)entityClientPlayerMP);
    boolean renderHandFlag = false;
    boolean renderHandEffectFlag = false;
    Ability hotBoilingSpecial = abilityProps.getAbilityFromName(ListAttributes.HOT_BOILING_SPECIAL.getAttributeName());
    Ability hardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_HARDENING.getAttributeName());
    Ability fullBodyHardeningBuso = abilityProps.getAbilityFromName(ListAttributes.BUSOSHOKU_HAKI_FULL_BODY_HARDENING.getAttributeName());
    Ability mechArm = abilityProps.getAbilityFromName(ListAttributes.MechArm.getAttributeName());
    Ability buddhapoint = abilityProps.getAbilityFromName(ListAttributes.BUDDHAPOINT.getAttributeName());
    Ability mochiwheel = abilityProps.getAbilityFromName(ListAttributes.WHEELDASH.getAttributeName());
    Ability luffy = abilityProps.getAbilityFromName(ListAttributes.GEAR_FOURTH.getAttributeName());
    boolean hasHotBoilingSpecial = (hotBoilingSpecial != null && hotBoilingSpecial.isPassiveActive());
    boolean hasHardeningBuso = (hardeningBuso != null && hardeningBuso.isPassiveActive());
    boolean hasFullBodyHardeningBuso = (fullBodyHardeningBuso != null && fullBodyHardeningBuso.isPassiveActive());
    boolean isLuffy4 = (luffy != null && luffy.isPassiveActive());
    boolean hasMechArm = (mechArm != null && mechArm.isPassiveActive());
    boolean hasmochiwheel = (mochiwheel != null && mochiwheel.isPassiveActive());
    Ability dragonPoint = abilityProps.getAbilityFromName(ListAttributes.DRAGONPOINT.getAttributeName());
    boolean hasDragonPoint = (dragonPoint != null && dragonPoint.isPassiveActive());
    boolean hasBuddha = (buddhapoint != null && buddhapoint.isPassiveActive());
    if (hasMechArm) {
      renderHandFlag = true;
      if (Mouse.isButtonDown(0) && this.mc.objectMouseOver.entityHit != null && 
        this.mc.objectMouseOver.entityHit instanceof EntityLivingBase && this.i == 0)
        this.i++; 
    } else if (isLuffy4) {
      if (((EntityPlayer)entityClientPlayerMP).onGround)
        entityClientPlayerMP.jump(); 
    } else if (hasDragonPoint) {
      ((EntityPlayer)entityClientPlayerMP).capabilities.allowFlying = true;
      ((EntityPlayer)entityClientPlayerMP).capabilities.isFlying = true;
      entityClientPlayerMP.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 1));
    } else if (entityClientPlayerMP.getHeldItem() == null && (hasFullBodyHardeningBuso || hasHardeningBuso || hasHotBoilingSpecial)) {
      renderHandFlag = true;
    } 
    if (MorphsHelper.getMorphsMap().containsKey(props.getUsedFruit()))
      for (Object[] arrayOfObject : (Object[][])MorphsHelper.getMorphsMap().get(props.getUsedFruit())) {
        if (props.getZoanPoint().equalsIgnoreCase((String)arrayOfObject[0])) {
          renderHandFlag = true;
          break;
        } 
      }  
    GL11.glPushMatrix();
    int x = 0, y = 0, u = 16;
    byte b = 16;
    GL11.glPopMatrix();
    if (renderHandFlag) {
      event.setCanceled(true);
      HandRendererHelper.renderHand(entityClientPlayerMP);
    } 
  }
  
  public float gg() {
    float y = this.mc.thePlayer.rotationYaw;
    float f = this.mc.thePlayer.moveForward;
    float s = this.mc.thePlayer.moveStrafing;
    if (s < 0.0F)
      y += (f == 0.0F) ? 90.0F : ((f < 0.0F) ? -45.0F : 45.0F); 
    if (s > 0.0F)
      y -= (f == 0.0F) ? 90.0F : ((f < 0.0F) ? -45.0F : 45.0F); 
    return y * 0.017453292F;
  }
  
  public void s(double s) {
    this.mc.thePlayer.motionX = -MathHelper.sin(gg()) * s;
    this.mc.thePlayer.motionZ = MathHelper.cos(gg()) * s;
  }
  
  public static float getDirection() {
    float var1 = (Minecraft.getMinecraft()).thePlayer.rotationYaw;
    if ((Minecraft.getMinecraft()).thePlayer.moveForward < 0.0F)
      var1 += 180.0F; 
    float forward = 1.0F;
    if ((Minecraft.getMinecraft()).thePlayer.moveForward < 0.0F) {
      forward = -0.5F;
    } else if ((Minecraft.getMinecraft()).thePlayer.moveForward > 0.0F) {
      forward = 0.5F;
    } else {
      forward = 1.0F;
    } 
    if ((Minecraft.getMinecraft()).thePlayer.moveStrafing > 0.0F)
      var1 -= 90.0F * forward; 
    if ((Minecraft.getMinecraft()).thePlayer.moveStrafing < 0.0F)
      var1 += 90.0F * forward; 
    var1 *= 0.017453292F;
    return var1;
  }
}
