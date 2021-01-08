package xyz.pixelatedw.MineMineNoMi3;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.command.ICommand;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandAbilityProtection;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandBelly;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandBounty;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandDamageMultiplier;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandDoriki;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandExtol;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandFG;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandGetWantedPoster;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandIssueBounty;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandPouch;
import xyz.pixelatedw.MineMineNoMi3.commands.CommandRemoveDF;
import xyz.pixelatedw.MineMineNoMi3.events.Soros;
import xyz.pixelatedw.MineMineNoMi3.gui.GUIHandler;
import xyz.pixelatedw.MineMineNoMi3.helpers.WebAppHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListBiomes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListCraftingRecipes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListCreativeTabs;
import xyz.pixelatedw.MineMineNoMi3.lists.ListDevilFruits;
import xyz.pixelatedw.MineMineNoMi3.lists.ListEffects;
import xyz.pixelatedw.MineMineNoMi3.lists.ListEntities;
import xyz.pixelatedw.MineMineNoMi3.lists.ListForge;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.lists.ListPackets;
import xyz.pixelatedw.MineMineNoMi3.lists.ListQuests;
import xyz.pixelatedw.MineMineNoMi3.proxy.CommonProxy;
import xyz.pixelatedw.MineMineNoMi3.world.MainWorldGen;

@Mod(modid = "mineminenomi", name = "One Piece CAAS", version = "0.6.1", acceptedMinecraftVersions = "[1.7.10]")
public class MainMod {
  @Instance("mineminenomi")
  private static MainMod instance;
  
  @SidedProxy(clientSide = "xyz.pixelatedw.MineMineNoMi3.proxy.ClientProxy", serverSide = "xyz.pixelatedw.MineMineNoMi3.proxy.CommonProxy")
  public static CommonProxy proxy;
  
  public static SimpleNetworkWrapper dispatcher;
  
  public static Item limitbreakerItem;
  
  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel("mineminenomi");
    MainConfig.init(event.getSuggestedConfigurationFile());
    ListPackets.init();
    ListEntities.init();
    ListBiomes.init();
    proxy.preInit();
  }
  
  @EventHandler
  public void init(FMLInitializationEvent event) {
    NetworkRegistry.INSTANCE.registerGuiHandler(instance, (IGuiHandler)new GUIHandler());
    GameRegistry.registerWorldGenerator((IWorldGenerator)new MainWorldGen(), 1);
    //MinecraftForge.EVENT_BUS.register(new Soros());
    //FMLCommonHandler.instance().bus().register(new Soros());
    ListDevilFruits.init();
    ListMisc.init();
    ListEffects.init();
    ListCreativeTabs.init();
    ListCraftingRecipes.init();
    ListForge.init();
    ListQuests.init();
    proxy.init();
    if (WyDebug.isDebug() && FMLCommonHandler.instance().getEffectiveSide().isClient()) {
      String basicPath = MainMod.class.getResource("MainMod.class").toString();
      Values.RESOURCES_FOLDER = basicPath.substring(0, basicPath.indexOf("/bin")).replace("file:/", "").replace("%20", " ") + "/src/main/resources";
      WyHelper.generateLangFiles();
      WebAppHelper.generateWebAppJSONs();
    } 
  }
  
  public static void addITEM(Item item, String localizedName) {
    WyRegistry.registerItem(item, localizedName, ListCreativeTabs.tabWeapons);
  }
  
  @EventHandler
  public void postInit(FMLPostInitializationEvent evt) {}
  
  @EventHandler
  public void serverInit(FMLServerStartingEvent event) {
    if (WyHelper.isDevBuild() || WyHelper.isEarlyAccessBuild() || WyDebug.isDebug())
      event.registerServerCommand((ICommand)new CommandFG()); 
    event.registerServerCommand((ICommand)new CommandDoriki());
    event.registerServerCommand((ICommand)new CommandBelly());
    event.registerServerCommand((ICommand)new CommandBounty());
    event.registerServerCommand((ICommand)new CommandExtol());
    event.registerServerCommand((ICommand)new CommandRemoveDF());
    event.registerServerCommand((ICommand)new CommandIssueBounty());
    event.registerServerCommand((ICommand)new CommandGetWantedPoster());
    event.registerServerCommand((ICommand)new CommandAbilityProtection());
    event.registerServerCommand((ICommand)new CommandDamageMultiplier());
    event.registerServerCommand((ICommand)new CommandPouch());
  }
  
  public static MainMod getMineMineNoMi() {
    return instance;
  }
}
