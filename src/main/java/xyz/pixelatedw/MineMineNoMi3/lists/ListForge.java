package xyz.pixelatedw.MineMineNoMi3.lists;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import xyz.pixelatedw.MineMineNoMi3.MainKeys;
import xyz.pixelatedw.MineMineNoMi3.events.EventsBounty;
import xyz.pixelatedw.MineMineNoMi3.events.EventsCombatMode;
import xyz.pixelatedw.MineMineNoMi3.events.EventsCore;
import xyz.pixelatedw.MineMineNoMi3.events.EventsCrafting;
import xyz.pixelatedw.MineMineNoMi3.events.EventsCrew;
import xyz.pixelatedw.MineMineNoMi3.events.EventsDrops;
import xyz.pixelatedw.MineMineNoMi3.events.EventsEnchantments;
import xyz.pixelatedw.MineMineNoMi3.events.EventsHakiGain;
import xyz.pixelatedw.MineMineNoMi3.events.EventsMorphs;
import xyz.pixelatedw.MineMineNoMi3.events.EventsOnGain;
import xyz.pixelatedw.MineMineNoMi3.events.EventsQuestsProgress;
import xyz.pixelatedw.MineMineNoMi3.events.EventsSpecialEffects;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsAbilityValidation;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsDFWeaknesses;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsEffectOverlay;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsLogiaInvulnerability;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsOneDevilFruit;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsPassives;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsSpecialFlying;
import xyz.pixelatedw.MineMineNoMi3.events.devilfruits.EventsZoanPassives;

public class ListForge {
  public static void init() {
    MinecraftForge.EVENT_BUS.register(new EventsCore());
    FMLCommonHandler.instance().bus().register(new EventsCore());
    MinecraftForge.EVENT_BUS.register(new EventsCrew());
    MinecraftForge.EVENT_BUS.register(new EventsBounty());
    FMLCommonHandler.instance().bus().register(new EventsBounty());
    MinecraftForge.EVENT_BUS.register(new EventsDrops());
    MinecraftForge.EVENT_BUS.register(new EventsCrafting());
    MinecraftForge.EVENT_BUS.register(new EventsEnchantments());
    MinecraftForge.EVENT_BUS.register(new EventsOnGain());
    MinecraftForge.EVENT_BUS.register(new EventsHakiGain());
    MinecraftForge.EVENT_BUS.register(new EventsSpecialEffects());
    MinecraftForge.EVENT_BUS.register(new EventsQuestsProgress());
    MinecraftForge.EVENT_BUS.register(new EventsOneDevilFruit());
    MinecraftForge.EVENT_BUS.register(new EventsAbilityValidation());
    MinecraftForge.EVENT_BUS.register(new EventsDFWeaknesses());
    MinecraftForge.EVENT_BUS.register(new EventsSpecialFlying());
    MinecraftForge.EVENT_BUS.register(new EventsLogiaInvulnerability());
    MinecraftForge.EVENT_BUS.register(new EventsZoanPassives());
    MinecraftForge.EVENT_BUS.register(new EventsPassives());
    if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
      MinecraftForge.EVENT_BUS.register(new EventsEffectOverlay());
      FMLCommonHandler.instance().bus().register(new EventsEffectOverlay());
      MinecraftForge.EVENT_BUS.register(new EventsCombatMode(Minecraft.getMinecraft()));
      MinecraftForge.EVENT_BUS.register(new EventsMorphs(Minecraft.getMinecraft()));
      FMLCommonHandler.instance().bus().register(new EventsMorphs(Minecraft.getMinecraft()));
      FMLCommonHandler.instance().bus().register(new MainKeys());
      MainKeys.init();
    } 
  }
}
