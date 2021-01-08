package xyz.pixelatedw.MineMineNoMi3.api.debug;

import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WyDebug {
  public static boolean isDebug() {
    return (ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0);
  }
  
  public static void info(Object msg) {
    Logger.getGlobal().info("[WYPI] [" + "mineminenomi".toUpperCase() + "] " + String.valueOf(msg));
  }
  
  public static void warn(Object msg) {
    Logger.getGlobal().warning("[WYPI] [" + "mineminenomi".toUpperCase() + "] " + String.valueOf(msg));
  }
  
  public static void error(Object msg) {
    Logger.getGlobal().log(Level.SEVERE, "[WYPI] [" + "mineminenomi".toUpperCase() + "] " + String.valueOf(msg));
  }
  
  public static void debug(Object msg) {
    if (isDebug())
      Logger.getGlobal().log(Level.INFO, "[DEBUG] [WYPI] [" + "mineminenomi".toUpperCase() + "] " + String.valueOf(msg)); 
  }
}
