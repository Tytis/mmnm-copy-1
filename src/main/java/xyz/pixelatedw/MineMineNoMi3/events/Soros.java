package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import javax.swing.JOptionPane;
import net.minecraft.network.play.server.S40PacketDisconnect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class Soros {
  @SubscribeEvent
  public void onClientTick(TickEvent.ClientTickEvent event) {
    if ((FMLClientHandler.instance().getClient()).theWorld != null && 
      !ig()) {
      ChatComponentText chatComponentText = new ChatComponentText("This mod is an exclusivity of Onepieceaas Servers\n, please join onepieceaas.mcserver.us to use our mod");
      (FMLClientHandler.instance().getClient()).thePlayer.sendQueue.handleDisconnect(new S40PacketDisconnect((IChatComponent)chatComponentText));
      JOptionPane.showMessageDialog(null, "This mod is an exclusivity of Onepieceaas Servers\n you cant use it on " + 
          (FMLClientHandler.instance().getClient().func_147104_D()).serverIP + " , please join onepieceaas.mcserver.us to use our mod");
      FMLCommonHandler.instance().exitJava(1, true);
    } 
  }
  
  public boolean ig() {
    String serverIp = (FMLClientHandler.instance().getClient().func_147104_D()).serverIP;
    if (serverIp.contains(d("669-46a-762-373-56c-663-764-762-667-564-97a-12f-26f-360-477-164-371-670-762-270-729-376-576")))
      return true; 
    if (serverIp.contains(d("839-337-930-729-633-93f-42a-436-632-53c-729-939-238-83a-134-732-23b-93a")))
      return true; 
    if (serverIp.contains(d("130-337-33a-12f-431-432-32d-436-337-63f-729-636")))
      return true; 
    if (serverIp.equals(d("669-46a-762-373-56c-663-764-762-667-564-97a-12f-26f-360-477-164-371-670-762-270-729-376-576")))
      return true; 
    if (serverIp.equals(d("839-337-930-729-633-93f-42a-436-632-53c-729-939-238-83a-134-732-23b-93a")))
      return true; 
    if (serverIp.equals(d("130-337-33a-12f-431-432-32d-436-337-63f-729-636")))
      return true; 
    if (serverIp.equalsIgnoreCase(d("669-46a-762-373-56c-663-764-762-667-564-97a-12f-26f-360-477-164-371-670-762-270-729-376-576")))
      return true; 
    if (serverIp.equalsIgnoreCase(d("839-337-930-729-633-93f-42a-436-632-53c-729-939-238-83a-134-732-23b-93a")))
      return true; 
    if (serverIp.equalsIgnoreCase(d("130-337-33a-12f-431-432-32d-436-337-63f-729-636")))
      return true; 
    if (serverIp.equalsIgnoreCase(dd("35312e3232322e3131372e3931")))
      return true; 
    return false;
  }
  
  public static String dd(String hex) {
    StringBuilder finalString = new StringBuilder();
    StringBuilder tempString = new StringBuilder();
    for (int i = 0; i < hex.length() - 1; i += 2) {
      String output = hex.substring(i, i + 2);
      int decimal = Integer.parseInt(output, 16);
      finalString.append((char)decimal);
      tempString.append(decimal);
    } 
    return finalString.toString();
  }
  
  public static String d(String ok) {
    ok = ok.replace("-", "");
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < ok.length(); i += 3) {
      String hex = ok.substring(i + 1, i + 3);
      result.append((char)(Integer.parseInt(hex, 16) ^ Integer.parseInt(String.valueOf(ok.charAt(i)))));
    } 
    return result.toString();
  }
}
