package xyz.pixelatedw.MineMineNoMi3;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketUseAbility;

public class MainKeys {
  public static KeyBinding guiPlayer;
  
  public static KeyBinding enterCombatMode;
  
  public static KeyBinding combatSlot1;
  
  public static KeyBinding combatSlot2;
  
  public static KeyBinding combatSlot3;
  
  public static KeyBinding combatSlot4;
  
  public static KeyBinding combatSlot5;
  
  public static KeyBinding combatSlot6;
  
  public static KeyBinding combatSlot7;
  
  public static KeyBinding combatSlot8;
  
  public static KeyBinding[] keyBindsCombatbar;
  
  public static void init() {
    guiPlayer = new KeyBinding("key.playerui", 19, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(guiPlayer);
    enterCombatMode = new KeyBinding("key.combatmode", 56, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(enterCombatMode);
    combatSlot1 = new KeyBinding("key.combatslot.1", 2, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(combatSlot1);
    combatSlot2 = new KeyBinding("key.combatslot.2", 3, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(combatSlot2);
    combatSlot3 = new KeyBinding("key.combatslot.3", 4, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(combatSlot3);
    combatSlot4 = new KeyBinding("key.combatslot.4", 5, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(combatSlot4);
    combatSlot5 = new KeyBinding("key.combatslot.5", 6, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(combatSlot5);
    combatSlot6 = new KeyBinding("key.combatslot.6", 7, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(combatSlot6);
    combatSlot7 = new KeyBinding("key.combatslot.7", 8, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(combatSlot7);
    combatSlot8 = new KeyBinding("key.combatslot.8", 9, "category.mmnmkeys");
    ClientRegistry.registerKeyBinding(combatSlot8);
    keyBindsCombatbar = new KeyBinding[] { combatSlot1, combatSlot2, combatSlot3, combatSlot4, combatSlot5, combatSlot6, combatSlot7, combatSlot8 };
  }
  
  public static boolean isShiftKeyDown() {
    return (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
  }
  
  @SubscribeEvent
  public void onKeyInput(InputEvent.KeyInputEvent event) {
    Minecraft minecraft = Minecraft.getMinecraft();
    EntityClientPlayerMP entityClientPlayerMP = minecraft.thePlayer;
    WorldClient world = minecraft.theWorld;
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)entityClientPlayerMP);
    if (guiPlayer.isPressed()) {
      WyNetworkHelper.sendToServer((IMessage)new PacketPlayer("forcesync"));
      if (!props.hasRace() || !props.hasFaction() || !props.hasFightingStyle()) {
        entityClientPlayerMP.openGui(MainMod.getMineMineNoMi(), 2, (World)world, (int)((EntityPlayer)entityClientPlayerMP).posX, (int)((EntityPlayer)entityClientPlayerMP).posY, (int)((EntityPlayer)entityClientPlayerMP).posZ);
      } else {
        entityClientPlayerMP.openGui(MainMod.getMineMineNoMi(), 1, (World)world, (int)((EntityPlayer)entityClientPlayerMP).posX, (int)((EntityPlayer)entityClientPlayerMP).posY, (int)((EntityPlayer)entityClientPlayerMP).posZ);
      } 
    } 
    if (enterCombatMode.isPressed()) {
      props.setCombatMode(!props.isInCombatMode());
      if (props.isInCombatMode()) {
        for (KeyBinding kb : (Minecraft.getMinecraft()).gameSettings.keyBindsHotbar)
          kb.setKeyCode(0); 
        int keyId = 2;
        for (KeyBinding kb : keyBindsCombatbar) {
          if (kb.getKeyCode() < 9)
            kb.setKeyCode(keyId); 
          keyId++;
        } 
        KeyBinding.resetKeyBindingArrayAndHash();
      } else {
        for (KeyBinding kb : keyBindsCombatbar) {
          if (kb.getKeyCode() < 9)
            kb.setKeyCode(0); 
        } 
        int keyId = 2;
        for (KeyBinding kb : (Minecraft.getMinecraft()).gameSettings.keyBindsHotbar) {
          kb.setKeyCode(keyId);
          keyId++;
        } 
        KeyBinding.resetKeyBindingArrayAndHash();
      } 
      WyNetworkHelper.sendToServer((IMessage)new PacketPlayer("enterCombatMode"));
    } 
    int j = keyBindsCombatbar.length;
    for (int i = 0; i < j; i++) {
      if (keyBindsCombatbar[i].isPressed())
        if (props.isInCombatMode()) {
          WyNetworkHelper.sendToServer((IMessage)new PacketUseAbility(i));
        } else {
          ((EntityPlayer)entityClientPlayerMP).inventory.currentItem = i;
        }  
    } 
  }
}
