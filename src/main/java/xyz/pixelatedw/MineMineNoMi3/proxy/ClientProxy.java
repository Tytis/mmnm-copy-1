package xyz.pixelatedw.MineMineNoMi3.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityRenderer;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityAxeDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityBreathDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCannon;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityEisenDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityFlameDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityFlashDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityImpactDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityMilkyDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityRejectDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntitySakeFeast;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityKungFuDugong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityLapahn;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals.EntityYagaraBull;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.arlongPirates.EntityArlong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.arlongPirates.EntityChew;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.arlongPirates.EntityKuroobi;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits.EntityBandit;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.baroqueWorks.EntityMr0;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.kriegPirates.EntityDonKrieg;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.kriegPirates.EntityGin;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.kriegPirates.EntityPearl;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarine;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarineCaptain;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarineWithGun;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMorgan;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityBlackKnight;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityDoppelman;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityMirageClone;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityFatPirate;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirate;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirateCaptain;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirateWithGun;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.givers.EntityDojoSensei;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives.EntitySniperTarget;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives.models.ModelSniperTarget;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityDugong;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityLapahn;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.temp.TempEntityYagaraBull;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityBlueno;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityFukuro;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityJabra;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityJabraL;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityKaku;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityKakuL;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityKalifa;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityKumadori;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityLucci;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntityLucciL;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.EntitySpandam;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.gui.GUIQuestYesNo;
import xyz.pixelatedw.MineMineNoMi3.lists.ListDevilFruits;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelFlameDial;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelImpactDial;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelMilkyDial;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelRejectDial;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.animals.ModelDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.animals.ModelKungFuDugong;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.animals.ModelLapahn;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.animals.ModelYagaraBull;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelArlong;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelBlueno;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelChew;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelDojoSensei;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelFatPirate;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelFukuro;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelGin;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelJabra;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelJabraWolf;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelKaku;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelKakuGiraffe;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelKalifa;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelKrieg;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelKumadori;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelKuroobi;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelLucci;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelLucciLeopard;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelMarine;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelMarineCaptain;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelMarineWithGun;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelMorgan;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelMr0;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelPearl;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelSpandam;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;
import xyz.pixelatedw.MineMineNoMi3.renderers.blocks.RenderBlockCannon;
import xyz.pixelatedw.MineMineNoMi3.renderers.blocks.RenderBlockDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.renderers.blocks.RenderBlockDial;
import xyz.pixelatedw.MineMineNoMi3.renderers.blocks.RenderBlockSakeFeast;
import xyz.pixelatedw.MineMineNoMi3.renderers.blocks.RenderBlockWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.renderers.blocks.RenderBlockWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.MobRenderer;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.mobs.humanoids.RenderBlackKnight;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.mobs.humanoids.RenderDoppelman;
import xyz.pixelatedw.MineMineNoMi3.renderers.items.RenderCoreWeapon;
import xyz.pixelatedw.MineMineNoMi3.renderers.items.RenderCoreWeapon2;
import xyz.pixelatedw.MineMineNoMi3.renderers.items.RenderWeaponBisento;
import xyz.pixelatedw.MineMineNoMi3.renderers.items.RenderWeaponDurandal;
import xyz.pixelatedw.MineMineNoMi3.renderers.items.RenderWeaponKatana;
import xyz.pixelatedw.MineMineNoMi3.renderers.items.RenderWeaponKiribachi;
import xyz.pixelatedw.MineMineNoMi3.renderers.items.RenderWeaponMace;
import xyz.pixelatedw.MineMineNoMi3.renderers.items.RenderWeaponPipe;

public class ClientProxy extends CommonProxy {
  public void preInit() {}
  
  public void init() {
    for (int i = 0; i < ListDevilFruits.ALL_ENTITIES.length; i++) {
      for (int j = 0; j < ((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).size(); j++)
        RenderingRegistry.registerEntityRenderingHandler((Class)((Object[])((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).get(j))[0], (Render)new AbilityRenderer((AbilityAttribute)((Object[])((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).get(j))[1])); 
    } 
    RenderingRegistry.registerEntityRenderingHandler(EntityBandit.class, (Render)new MobRenderer((ModelBiped)new ModelMarine()));
    RenderingRegistry.registerEntityRenderingHandler(EntityMarine.class, (Render)new MobRenderer((ModelBiped)new ModelMarine()));
    RenderingRegistry.registerEntityRenderingHandler(EntityMarineWithGun.class, (Render)new MobRenderer((ModelBiped)new ModelMarineWithGun()));
    RenderingRegistry.registerEntityRenderingHandler(EntityMarineCaptain.class, (Render)new MobRenderer((ModelBiped)new ModelMarineCaptain()));
    RenderingRegistry.registerEntityRenderingHandler(EntityMorgan.class, (Render)new MobRenderer((ModelBiped)new ModelMorgan(), "morgan"));
    RenderingRegistry.registerEntityRenderingHandler(EntityLucci.class, (Render)new MobRenderer((ModelBiped)new ModelLucci(), "lucci"));
    RenderingRegistry.registerEntityRenderingHandler(EntityLucciL.class, (Render)new MobRenderer((ModelBiped)new ModelLucciLeopard(), "luccil"));
    RenderingRegistry.registerEntityRenderingHandler(EntityKaku.class, (Render)new MobRenderer((ModelBiped)new ModelKaku(), "kaku"));
    RenderingRegistry.registerEntityRenderingHandler(EntityKakuL.class, (Render)new MobRenderer((ModelBiped)new ModelKakuGiraffe(), "kakul"));
    RenderingRegistry.registerEntityRenderingHandler(EntityJabra.class, (Render)new MobRenderer((ModelBiped)new ModelJabra(), "jabra"));
    RenderingRegistry.registerEntityRenderingHandler(EntityJabraL.class, (Render)new MobRenderer((ModelBiped)new ModelJabraWolf(), "jabral"));
    RenderingRegistry.registerEntityRenderingHandler(EntityKalifa.class, (Render)new MobRenderer((ModelBiped)new ModelKalifa(), "kalifa"));
    RenderingRegistry.registerEntityRenderingHandler(EntityKumadori.class, (Render)new MobRenderer((ModelBiped)new ModelKumadori(), "kumadori"));
    RenderingRegistry.registerEntityRenderingHandler(EntityFukuro.class, (Render)new MobRenderer((ModelBiped)new ModelFukuro(), "fukuro"));
    RenderingRegistry.registerEntityRenderingHandler(EntityBlueno.class, (Render)new MobRenderer((ModelBiped)new ModelBlueno(), "blueno"));
    RenderingRegistry.registerEntityRenderingHandler(EntitySpandam.class, (Render)new MobRenderer((ModelBiped)new ModelSpandam(), "spandam"));
    RenderingRegistry.registerEntityRenderingHandler(EntityPirate.class, (Render)new MobRenderer((ModelBiped)new ModelMarine()));
    RenderingRegistry.registerEntityRenderingHandler(EntityPirateWithGun.class, (Render)new MobRenderer((ModelBiped)new ModelMarineWithGun()));
    RenderingRegistry.registerEntityRenderingHandler(EntityPirateCaptain.class, (Render)new MobRenderer((ModelBiped)new ModelMarine()));
    RenderingRegistry.registerEntityRenderingHandler(EntityFatPirate.class, (Render)new MobRenderer((ModelBiped)new ModelFatPirate(), 1.25F, null));
    RenderingRegistry.registerEntityRenderingHandler(EntityArlong.class, (Render)new MobRenderer((ModelBiped)new ModelArlong(), "arlong"));
    RenderingRegistry.registerEntityRenderingHandler(EntityChew.class, (Render)new MobRenderer((ModelBiped)new ModelChew(), "chew"));
    RenderingRegistry.registerEntityRenderingHandler(EntityKuroobi.class, (Render)new MobRenderer((ModelBiped)new ModelKuroobi(), "kuroobi"));
    RenderingRegistry.registerEntityRenderingHandler(EntityDonKrieg.class, (Render)new MobRenderer((ModelBiped)new ModelKrieg(), "krieg"));
    RenderingRegistry.registerEntityRenderingHandler(EntityGin.class, (Render)new MobRenderer((ModelBiped)new ModelGin(), "gin"));
    RenderingRegistry.registerEntityRenderingHandler(EntityPearl.class, (Render)new MobRenderer((ModelBiped)new ModelPearl(), "pearl"));
    RenderingRegistry.registerEntityRenderingHandler(EntityMr0.class, (Render)new MobRenderer((ModelBiped)new ModelMr0(), "mr0"));
    RenderingRegistry.registerEntityRenderingHandler(EntityDoppelman.class, (Render)new RenderDoppelman());
    RenderingRegistry.registerEntityRenderingHandler(EntityBlackKnight.class, (Render)new RenderBlackKnight());
    RenderingRegistry.registerEntityRenderingHandler(EntityMirageClone.class, (Render)new RenderBlackKnight());
    RenderingRegistry.registerEntityRenderingHandler(EntityDojoSensei.class, (Render)new MobRenderer((ModelBiped)new ModelDojoSensei()));
    RenderingRegistry.registerEntityRenderingHandler(EntityWantedPostersPackage.class, (Render)new MobRenderer((ModelBiped)new ModelWantedPostersPackage(), "wantedposterspackage"));
    RenderingRegistry.registerEntityRenderingHandler(EntitySniperTarget.class, (Render)new MobRenderer((ModelBiped)new ModelSniperTarget(), "snipertarget"));
    RenderingRegistry.registerEntityRenderingHandler(EntityDenDenMushi.class, (Render)new MobRenderer((ModelBiped)new ModelDenDenMushi(), "denden"));
    RenderingRegistry.registerEntityRenderingHandler(EntityKungFuDugong.class, (Render)new MobRenderer((ModelBiped)new ModelKungFuDugong(), "kungfudugong"));
    RenderingRegistry.registerEntityRenderingHandler(EntityLapahn.class, (Render)new MobRenderer((ModelBiped)new ModelLapahn(), "lapahn"));
    RenderingRegistry.registerEntityRenderingHandler(EntityYagaraBull.class, (Render)new MobRenderer((ModelBiped)new ModelYagaraBull(), 1.5F, null));
    RenderingRegistry.registerEntityRenderingHandler(TempEntityDugong.class, (Render)new MobRenderer((ModelBiped)new ModelKungFuDugong(), "kungfudugong"));
    RenderingRegistry.registerEntityRenderingHandler(TempEntityLapahn.class, (Render)new MobRenderer((ModelBiped)new ModelLapahn(), "lapahn"));
    RenderingRegistry.registerEntityRenderingHandler(TempEntityYagaraBull.class, (Render)new MobRenderer((ModelBiped)new ModelYagaraBull(), 2.0F, "yagarabull"));
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDenDenMushi.class, (TileEntitySpecialRenderer)new RenderBlockDenDenMushi());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWantedPoster.class, (TileEntitySpecialRenderer)new RenderBlockWantedPoster());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWantedPostersPackage.class, (TileEntitySpecialRenderer)new RenderBlockWantedPostersPackage());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCannon.class, (TileEntitySpecialRenderer)new RenderBlockCannon());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySakeFeast.class, (TileEntitySpecialRenderer)new RenderBlockSakeFeast());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAxeDial.class, (TileEntitySpecialRenderer)new RenderBlockDial((ModelBase)new ModelImpactDial(), "axedial"));
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEisenDial.class, (TileEntitySpecialRenderer)new RenderBlockDial((ModelBase)new ModelMilkyDial(), "eisendial"));
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlameDial.class, (TileEntitySpecialRenderer)new RenderBlockDial((ModelBase)new ModelFlameDial(), "flamedial"));
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityImpactDial.class, (TileEntitySpecialRenderer)new RenderBlockDial((ModelBase)new ModelImpactDial(), "impactdial"));
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMilkyDial.class, (TileEntitySpecialRenderer)new RenderBlockDial((ModelBase)new ModelMilkyDial(), "milkydial"));
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRejectDial.class, (TileEntitySpecialRenderer)new RenderBlockDial((ModelBase)new ModelRejectDial(), "rejectdial"));
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlashDial.class, (TileEntitySpecialRenderer)new RenderBlockDial((ModelBase)new ModelImpactDial(), "flashdial"));
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBreathDial.class, (TileEntitySpecialRenderer)new RenderBlockDial((ModelBase)new ModelMilkyDial(), "breathdial"));
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.MarineSword, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Scissors, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Yoru, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Hammer5t, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Hammer10t, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Hammer100t, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.SoulSolid, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.IceSaber, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.AmaNoMurakumo, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.NoroNoroBeamSword, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.DoruDoruArtsKen, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.BlueSword, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.TabiraYuki, (IItemRenderer)new RenderCoreWeapon());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.PirateCutlass, (IItemRenderer)new RenderCoreWeapon2());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Kikoku, (IItemRenderer)new RenderCoreWeapon2());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Jitte, (IItemRenderer)new RenderCoreWeapon2());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Biseto, (IItemRenderer)new RenderWeaponBisento());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.BoStick, (IItemRenderer)new RenderWeaponBisento());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.ClimaTact, (IItemRenderer)new RenderWeaponBisento());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.PerfectClimaTact, (IItemRenderer)new RenderWeaponBisento());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.SorceryClimaTact, (IItemRenderer)new RenderWeaponBisento());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.WadoIchimonji, (IItemRenderer)new RenderWeaponKatana());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.SandaiKitetsu, (IItemRenderer)new RenderWeaponKatana());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.NidaiKitetsu, (IItemRenderer)new RenderWeaponKatana());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Shusui, (IItemRenderer)new RenderWeaponKatana());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Pipe, (IItemRenderer)new RenderWeaponPipe());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Kiribachi, (IItemRenderer)new RenderWeaponKiribachi());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Durandal, (IItemRenderer)new RenderWeaponDurandal());
    MinecraftForgeClient.registerItemRenderer((Item)ListMisc.Mace, (IItemRenderer)new RenderWeaponMace());
  }
  
  public void spawnCustomParticles(Entity theEntity, EntityParticleFX particle) {
    (Minecraft.getMinecraft()).effectRenderer.addEffect((EntityFX)particle);
  }
  
  public void openQuestYesOrNoWorkaround(EntityPlayer player, EnumQuestlines questline) {
    Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GUIQuestYesNo(player, (int)player.posX, (int)player.posY, (int)player.posZ, questline));
  }
}