package xyz.pixelatedw.MineMineNoMi3.api.telemetry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;

public class WyTelemetry {
  private static StatDataCompound structuresDataCompound = new StatDataCompound();
  
  private static StatDataCompound killsDataCompound = new StatDataCompound();
  
  private static StatDataCompound abilitiesDataCompound = new StatDataCompound();
  
  private static StatDataCompound miscDataCompound = new StatDataCompound();
  
  private static StatDataCompound devilFruitsDataCompound = new StatDataCompound();
  
  public static void addStructureStat(String id, String name, int value) {
    structuresDataCompound.put(id, name, value);
  }
  
  public static void addKillStat(String id, String name, int value) {
    killsDataCompound.put(id, name, value);
  }
  
  public static void addAbilityStat(String id, String name, int value) {
    abilitiesDataCompound.put(id, name, value);
  }
  
  public static void addMiscStat(String id, String name, int value) {
    miscDataCompound.put(id, name, value);
  }
  
  public static void addDevilFruitStat(String id, String name, int value) {
    devilFruitsDataCompound.put(id, name, value);
  }
  
  public static void sendAllData() {
    Thread httpThread = new Thread() {
        public void run() {
          Object[][] paths = { { "/stats/structure", WyTelemetry.structuresDataCompound }, { "/stats/kill", WyTelemetry.killsDataCompound }, { "/stats/ability", WyTelemetry.abilitiesDataCompound }, { "/stats/misc", WyTelemetry.miscDataCompound }, { "/stats/devil-fruit", WyTelemetry.devilFruitsDataCompound } };
          for (Object[] o : paths) {
            String apiURL = (String)o[0];
            WyTelemetry.StatDataCompound compound = (WyTelemetry.StatDataCompound)o[1];
            if (!compound.data.isEmpty()) {
              String json = Values.gson.toJson(compound);
              String result = WyTelemetry.sendPOST(apiURL, json);
              WyDebug.debug("Path: " + apiURL + "Result: " + (result.isEmpty() ? "Success" : result));
              compound.empty();
            } 
          } 
        }
      };
    httpThread.setName("Mine Mine no Mi - Stats POST");
    httpThread.start();
  }
  
  public static void sendAllDataSync() {
    Object[][] paths = { { "/stats/structure", structuresDataCompound }, { "/stats/kill", killsDataCompound }, { "/stats/ability", abilitiesDataCompound }, { "/stats/misc", miscDataCompound }, { "/stats/devil-fruit", devilFruitsDataCompound } };
    for (Object[] o : paths) {
      String apiURL = (String)o[0];
      StatDataCompound compound = (StatDataCompound)o[1];
      if (!compound.data.isEmpty()) {
        String json = Values.gson.toJson(compound);
        String result = sendPOST(apiURL, json);
        WyDebug.debug("Path: " + apiURL + "Result: " + (result.isEmpty() ? "Success" : result));
        compound.empty();
      } 
    } 
  }
  
  public static String sendPOST(String sendUrl, String object) {
    BufferedReader reader = null;
    String result = "";
    try {
      String json = object;
      URL url = new URL(Values.urlConnection + "" + sendUrl);
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setUseCaches(false);
      connection.setDoOutput(true);
      connection.connect();
      OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
      writer.write(json);
      writer.flush();
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder stringBuilder = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null)
        stringBuilder.append(line); 
      result = stringBuilder.toString();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null)
          reader.close(); 
      } catch (IOException e) {
        e.printStackTrace();
      } 
    } 
    return result;
  }
  
  public static String sendGET(String sendUrl) {
    String result = "";
    try {
      URL url = new URL(Values.urlConnection + "" + sendUrl);
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();
      if (responseCode == 200) {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
          response.append(inputLine); 
        in.close();
        result = response.toString();
      } else {
        WyDebug.error("GET Request failed!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return result;
  }
  
  private static void debugJSON(StatDataCompound compound) {
    String json = Values.gson.toJson(compound);
    String size = WyHelper.formatBytes((json.getBytes()).length);
    WyDebug.debug("\n JSON: " + json + "\n Size: " + size);
  }
  
  private static class StatDataCompound {
    private String mcVersion;
    
    private String modVersion;
    
    private int source;
    
    private HashMap<String, WyTelemetry.StatData> data = new HashMap<>();
    
    public StatDataCompound() {
      this.mcVersion = "1.7.10";
      this.modVersion = "0.6.1";
      this.source = 0;
    }
    
    public void put(String id, String name, int value) {
      if (this.data.containsKey(id)) {
        WyTelemetry.StatData statData = this.data.get(id);
        statData.value = statData.value + value;
      } else {
        WyTelemetry.StatData newData = new WyTelemetry.StatData(name, value);
        this.data.put(id, newData);
      } 
    }
    
    public void empty() {
      this.data = new HashMap<>();
    }
  }
  
  private static class StatData {
    private String name;
    
    private int value;
    
    public StatData(String name, int value) {
      this.name = name;
      this.value = value;
    }
  }
}
