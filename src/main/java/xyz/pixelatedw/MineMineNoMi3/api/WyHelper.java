package xyz.pixelatedw.MineMineNoMi3.api;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.math.ISphere;
import xyz.pixelatedw.MineMineNoMi3.api.math.Sphere;
import xyz.pixelatedw.MineMineNoMi3.api.telemetry.WyTelemetry;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;

public class WyHelper {
  public enum Direction {
    SOUTH, SOUTH_EAST, EAST, NORTH, NORTH_EAST, NORTH_WEST, WEST, SOUTH_WEST;
  }
  
  public static AxisAlignedBB NULL_AABB = AxisAlignedBB.getBoundingBox(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
  
  public static EntityLivingBase getEntityByUUID(World world, UUID uuid) {
    List<EntityLivingBase> entities = (List<EntityLivingBase>)world.loadedEntityList.stream().filter(x -> x instanceof EntityLivingBase).collect(Collectors.toList());
    for (EntityLivingBase entity : entities) {
      if (entity.getUniqueID().equals(uuid))
        return entity; 
    } 
    return null;
  }
  
  public static boolean afterDate(String date) {
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    Calendar target = null;
    try {
      target = Calendar.getInstance();
      target.setTime(df.parse(date));
    } catch (ParseException e) {
      e.printStackTrace();
      return false;
    } 
    Calendar now = Calendar.getInstance();
    return now.after(target);
  }
  
  public static boolean isNullOrEmpty(String str) {
    if (str != null && !str.isEmpty())
      return false; 
    return true;
  }
  
  public static AbilityExplosion newExplosion(Entity entity, double posX, double posY, double posZ, double size) {
    AbilityExplosion explosion = new AbilityExplosion(entity, posX, posY, posZ, size);
    return explosion;
  }
  
  public static void doExplosion(Entity entity, double posX, double posY, double posZ, double size) {
    AbilityExplosion explosion = new AbilityExplosion(entity, posX, posY, posZ, size);
    explosion.doExplosion();
  }
  
  public static boolean isBlockNearby(EntityLivingBase player, int radius, Block... blocks) {
    for (Block b : blocks) {
      for (int x = -radius; x < radius; x++) {
        for (int y = -radius; y < radius; y++) {
          for (int z = -radius; z < radius; z++) {
            if (player.worldObj.getBlock((int)player.posX + x, (int)player.posY + y, (int)player.posZ + z) == b)
              return true; 
          } 
        } 
      } 
    } 
    return false;
  }
  
  public static Block getBlockNearby(EntityLivingBase entity, int radius, Block block) {
    for (int x = -radius; x < radius; x++) {
      for (int y = -radius; y < radius; y++) {
        for (int z = -radius; z < radius; z++) {
          if (entity.worldObj.getBlock((int)entity.posX + x, (int)entity.posY + y, (int)entity.posZ + z) == block)
            return entity.worldObj.getBlock((int)entity.posX + x, (int)entity.posY + y, (int)entity.posZ + z); 
        } 
      } 
    } 
    return null;
  }
  
  public static List<int[]> getBlockLocationsNearby(EntityLivingBase entity, int[] radius) {
    List<int[]> nearbyBlocks = (List)new ArrayList<>();
    for (int x = -radius[0]; x < radius[0]; x++) {
      for (int y = -radius[1]; y < radius[1]; y++) {
        for (int z = -radius[2]; z < radius[2]; z++) {
          nearbyBlocks.add(new int[] { (int)entity.posX + x, (int)entity.posY + y, (int)entity.posZ + z });
        } 
      } 
    } 
    return nearbyBlocks;
  }
  
  public static List<int[]> getBlockLocationsNearby(EntityLivingBase entity, int radius) {
    List<int[]> nearbyBlocks = (List)new ArrayList<>();
    for (int x = -radius; x < radius; x++) {
      for (int y = -radius; y < radius; y++) {
        for (int z = -radius; z < radius; z++) {
          nearbyBlocks.add(new int[] { (int)entity.posX + x, (int)entity.posY + y, (int)entity.posZ + z });
        } 
      } 
    } 
    return nearbyBlocks;
  }
  
  public static <K extends Comparable, V extends Comparable> Map<K, V> sortAlphabetically(Map<K, V> map) {
    List<Map.Entry<K, V>> entries = new LinkedList<>(map.entrySet());
    Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
          public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
            return ((Comparable)o1.getKey()).compareTo(o2.getKey());
          }
        });
    Map<K, V> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<K, V> entry : entries)
      sortedMap.put(entry.getKey(), entry.getValue()); 
    return sortedMap;
  }
  
  public static void generateLangFiles() {
    Map<String, String> sorted = sortAlphabetically(WyRegistry.getLangMap());
    Set<Map.Entry<String, String>> set = sorted.entrySet();
    Iterator<Map.Entry<String, String>> i = set.iterator();
    Map.Entry prevEntry = null;
    File langFolder = new File(Values.RESOURCES_FOLDER + "/assets/" + "mineminenomi" + "/lang/");
    langFolder.mkdirs();
    if (langFolder.exists())
      try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Values.RESOURCES_FOLDER + "/assets/" + "mineminenomi" + "/lang/en_US.lang"), "UTF-8"))) {
        while (i.hasNext()) {
          Map.Entry entry = i.next();
          if (prevEntry != null)
            if (!((String)prevEntry.getKey()).substring(0, 2).equals(((String)entry.getKey()).substring(0, 2)))
              writer.write("\n");  
          writer.write((new StringBuilder()).append(entry.getKey()).append("=").append(entry.getValue()).append("\n").toString());
          prevEntry = entry;
        } 
        writer.close();
      } catch (Exception e) {
        e.getStackTrace();
      }  
  }
  
  public static void setEntityFlag(Entity player, int id, boolean bool) {
    byte b0 = player.getDataWatcher().getWatchableObjectByte(0);
    if (bool) {
      player.getDataWatcher().updateObject(0, Byte.valueOf((byte)(b0 | 1 << id)));
    } else {
      player.getDataWatcher().updateObject(0, Byte.valueOf((byte)(b0 & (1 << id ^ 0xFFFFFFFF))));
    } 
  }
  
  public static Color hslToColor(float h, float s, float l) {
    float[] hsl = { h, s, l };
    if (s < 0.0F || s > 100.0F) {
      String message = "Color parameter outside of expected range - Saturation";
      throw new IllegalArgumentException(message);
    } 
    if (l < 0.0F || l > 100.0F) {
      String message = "Color parameter outside of expected range - Luminance";
      throw new IllegalArgumentException(message);
    } 
    h %= 360.0F;
    h /= 360.0F;
    s /= 100.0F;
    l /= 100.0F;
    float q = 0.0F;
    if (l < 0.5D) {
      q = l * (1.0F + s);
    } else {
      q = l + s - s * l;
    } 
    float p = 2.0F * l - q;
    float r = Math.max(0.0F, hueToRGB(p, q, h + 0.33333334F));
    float g = Math.max(0.0F, hueToRGB(p, q, h));
    float b = Math.max(0.0F, hueToRGB(p, q, h - 0.33333334F));
    r = Math.min(r, 1.0F);
    g = Math.min(g, 1.0F);
    b = Math.min(b, 1.0F);
    return new Color(r, g, b);
  }
  
  private static float hueToRGB(float p, float q, float h) {
    if (h < 0.0F)
      h++; 
    if (h > 1.0F)
      h--; 
    if (6.0F * h < 1.0F)
      return p + (q - p) * 6.0F * h; 
    if (2.0F * h < 1.0F)
      return q; 
    if (3.0F * h < 2.0F)
      return p + (q - p) * 6.0F * (0.6666667F - h); 
    return p;
  }
  
  public static Color hexToRGB(String hexColor) {
    if (hexColor.startsWith("#"))
      return Color.decode(hexColor); 
    return Color.decode("#" + hexColor);
  }
  
  public static String formatBytes(long bytes) {
    int unit = 1024;
    if (bytes < unit)
      return bytes + " B"; 
    int exp = (int)(Math.log(bytes) / Math.log(unit));
    String pre = "KMGTPE".charAt(exp - 1) + "";
    return String.format("%.1f %sB", new Object[] { Double.valueOf(bytes / Math.pow(unit, exp)), pre });
  }
  
  public static void sendMsgToPlayer(EntityPlayer player, String text) {
    player.addChatComponentMessage((IChatComponent)new ChatComponentText(text));
  }
  
  public static String upperCaseFirst(String text) {
    return Character.toUpperCase(text.charAt(0)) + text.substring(1) + " ";
  }
  
  public static String getFancyName(String text) {
    return text.replaceAll("\\s+", "").toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll(":", "").replaceAll("#", "").replace(",", "");
  }
  
  public static String getFancyNameNoLowerCase(String text) {
    return text.replaceAll("\\s+", "").replaceAll("'", "").replaceAll("-", "").replaceAll(":", "").replaceAll("#", "").replace(",", "");
  }
  
  public static List<EntityLivingBase> getEntitiesNear(int x, int y, int z, World world, double radius) {
    return getEntitiesNear(x, y, z, world, radius, (Class)EntityLivingBase.class);
  }
  
  public static List<EntityLivingBase> getEntitiesNear(int x, int y, int z, World world, double radius, Class<? extends Entity> classEntity) {
    AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(x, y, z, (x + 1), (y + 1), (z + 1)).expand(radius, radius, radius);
    List<EntityLivingBase> list = world.getEntitiesWithinAABB(classEntity, aabb);
    return list;
  }
  
  public static List<EntityLivingBase> getEntitiesNear(Entity e, double radius) {
    return getEntitiesNear(e, radius, (Class<? extends Entity>[])new Class[] { EntityLivingBase.class });
  }
  
  public static List<EntityLivingBase> getEntitiesNear(Entity e, double radius, Class<? extends Entity>... classEntities) {
    try {
      AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(e.posX, e.posY, e.posZ, e.posX + 1.0D, e.posY + 1.0D, e.posZ + 1.0D).expand(radius, radius, radius);
      List<EntityLivingBase> list = new ArrayList();
      for (Class<? extends Entity> clz : classEntities)
        list.addAll(e.worldObj.getEntitiesWithinAABB(clz, aabb)); 
      list.remove(e);
      return list;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static <T> List<T> getEntitiesNear(Entity e, double[] radius, Class<? extends T>... classEntities) {
    try {
      AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(e.posX, e.posY, e.posZ, e.posX + 1.0D, e.posY + 1.0D, e.posZ + 1.0D).expand(radius[0], radius[1], radius[2]);
      List<T> list = new ArrayList<>();
      for (Class<? extends T> clz : classEntities)
        list.addAll(e.worldObj.getEntitiesWithinAABB(clz, aabb)); 
      list.remove(e);
      return list;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static List<EntityLivingBase> getEntitiesNear(TileEntity e, double radius) {
    return getEntitiesNear(e, radius, (Class)EntityLivingBase.class);
  }
  
  public static List<EntityLivingBase> getEntitiesNear(TileEntity e, double radius, Class<? extends Entity> classEntity) {
    AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(e.xCoord, e.yCoord, e.zCoord, (e.xCoord + 1), (e.yCoord + 1), (e.zCoord + 1)).expand(radius, radius, radius);
    List<EntityLivingBase> list = e.getWorldObj().getEntitiesWithinAABB(classEntity, aabb);
    return list;
  }
  
  public static Direction get4Directions(Entity e) {
    switch (MathHelper.floor_double((e.rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3) {
      case 0:
        return Direction.SOUTH;
      case 1:
        return Direction.WEST;
      case 2:
        return Direction.NORTH;
      case 3:
        return Direction.EAST;
    } 
    return null;
  }
  
  public static Direction get8Directions(Entity e) {
    switch (MathHelper.floor_double((e.rotationYaw * 8.0F / 360.0F) + 0.5D) & 0x7) {
      case 0:
        return Direction.SOUTH;
      case 1:
        return Direction.SOUTH_WEST;
      case 2:
        return Direction.WEST;
      case 3:
        return Direction.NORTH_WEST;
      case 4:
        return Direction.NORTH;
      case 5:
        return Direction.NORTH_EAST;
      case 6:
        return Direction.EAST;
      case 7:
        return Direction.SOUTH_EAST;
    } 
    return null;
  }
  
  public static MovingObjectPosition rayTraceBlocks(Entity e) {
    float f = 1.0F;
    float f1 = e.prevRotationPitch + (e.rotationPitch - e.prevRotationPitch) * f;
    float f2 = e.prevRotationYaw + (e.rotationYaw - e.prevRotationYaw) * f;
    double d = e.prevPosX + (e.posX - e.prevPosX) * f;
    double d1 = e.prevPosY + (e.posY - e.prevPosY) * f + 1.62D - e.getYOffset();
    double d2 = e.prevPosZ + (e.posZ - e.prevPosZ) * f;
    Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
    float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
    float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
    float f5 = -MathHelper.cos(-f1 * 0.01745329F);
    float f6 = MathHelper.sin(-f1 * 0.01745329F);
    float f7 = f4 * f5;
    float f9 = f3 * f5;
    double d3 = 5000.0D;
    Vec3 vec3 = vec3d.addVector(f7 * d3, f6 * d3, f9 * d3);
    MovingObjectPosition ray = e.worldObj.rayTraceBlocks(vec3d, vec3, false);
    return ray;
  }
  
  public static List<int[]> createEmptyCube(Entity entity, int[] sizes, Block blockToPlace, String... blockRules) {
    return createEmptyCube(entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ, sizes, blockToPlace, blockRules);
  }
  
  public static List<int[]> createEmptyCube(World world, double posX, double posY, double posZ, int[] sizes, Block blockToPlace, String... blockRules) {
    List<int[]> blocks = (List)new ArrayList<>();
    for (int x = sizes[0] * 0 - sizes[0]; x <= sizes[0]; x++) {
      for (int y = sizes[1] * 0 - sizes[1]; y <= sizes[1]; y++) {
        for (int z = sizes[2] * 0 - sizes[2]; z <= sizes[2]; z++) {
          if (x == -sizes[0] || x == sizes[0] || y == -sizes[1] || y == sizes[1] || z == -sizes[2] || z == sizes[2]) {
            DevilFruitsHelper.placeBlockIfAllowed(world, (int)posX + x, (int)posY + y, (int)posZ + z, blockToPlace, blockRules);
            blocks.add(new int[] { (int)posX + x, (int)posY + y, (int)posZ + z });
          } 
        } 
      } 
    } 
    return blocks;
  }
  
  public static List<int[]> createFilledCube(Entity entity, int[] sizes, Block blockToPlace, String... blockRules) {
    return createFilledCube(entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ, sizes, blockToPlace, blockRules);
  }
  
  public static List<int[]> createFilledCube(World world, double posX, double posY, double posZ, int[] sizes, Block blockToPlace, String... blockRules) {
    List<int[]> blocks = (List)new ArrayList<>();
    for (int x = sizes[0] * 0 - sizes[0]; x <= sizes[0]; x++) {
      for (int y = sizes[1] * 0 - sizes[1]; y <= sizes[1]; y++) {
        for (int z = sizes[2] * 0 - sizes[2]; z <= sizes[2]; z++) {
          DevilFruitsHelper.placeBlockIfAllowed(world, (int)posX + x, (int)posY + y, (int)posZ + z, blockToPlace, blockRules);
          blocks.add(new int[] { (int)posX + x, (int)posY + y, (int)posZ + z });
        } 
      } 
    } 
    return blocks;
  }
  
  public static List<int[]> createEmptySphere(final World world, final int posX, final int posY, final int posZ, final int size, final Block block, String... blockRules) {
    final List<int[]> blocks = (List)new ArrayList<>();
    try {
      Thread sphereGenerator = new Thread("Sphere Generator") {
          public void run() {
            Sphere.generate(posX, posY, posZ, size, new ISphere() {
                  public void call(int x, int y, int z) {
                    DevilFruitsHelper.placeBlockIfAllowed(world, x, y, z, block, blockRules);
                    blocks.add(new int[] { x, y, z });
                  }
                });
          }
        };
      sphereGenerator.start();
      sphereGenerator.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    return blocks;
  }
  
  public static List<int[]> createFilledSphere(final World world, final int posX, final int posY, final int posZ, final int size, final Block block, String... blockRules) {
    final List<int[]> blocks = (List)new ArrayList<>();
    try {
      Thread sphereGenerator = new Thread("Sphere Generator") {
          public void run() {
            Sphere.generateFilled(posX, posY, posZ, size, new ISphere() {
                  public void call(int x, int y, int z) {
                    DevilFruitsHelper.placeBlockIfAllowed(world, x, y, z, block, blockRules);
                    blocks.add(new int[] { x, y, z });
                  }
                });
          }
        };
      sphereGenerator.start();
      sphereGenerator.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    return blocks;
  }
  
  public static void removeStackFromArmorSlots(EntityPlayer player, ItemStack stack) {
    int x = player.inventory.mainInventory.length;
    for (int i = x; i < x + player.inventory.armorInventory.length; i++) {
      if (stack == player.inventory.getStackInSlot(i)) {
        player.inventory.setInventorySlotContents(i, null);
        break;
      } 
    } 
  }
  
  public static void removeStackFromInventory(EntityPlayer player, ItemStack stack) {
    for (int i = 0; i < player.inventory.mainInventory.length; i++) {
      if (stack == player.inventory.getStackInSlot(i)) {
        player.inventory.setInventorySlotContents(i, null);
        break;
      } 
    } 
  }
  
  public static void removeStackFromSlot(EntityPlayer player, int index) {
    if (player.inventory.mainInventory[index] != null)
      player.inventory.mainInventory[index] = null; 
  }
  
  public static int getPatreonLevel(EntityPlayer player) {
    boolean flag = false;
    String apiURL = "/patreon?uuid=" + player.getUniqueID().toString();
    String result = WyTelemetry.sendGET(apiURL);
    if (!isNullOrEmpty(result)) {
      int patreonLevel = Integer.parseInt(result);
      return patreonLevel;
    } 
    return 1;
  }
  
  public static boolean isCelestialDragon(EntityPlayer player) {
    return (getPatreonLevel(player) == 4);
  }
  
  public static boolean isSupernova(EntityPlayer player) {
    return (getPatreonLevel(player) == 3);
  }
  
  public static boolean isRookie(EntityPlayer player) {
    return (getPatreonLevel(player) == 2);
  }
  
  public static boolean isDevBuild() {
    return "RELEASE".equalsIgnoreCase("DEV");
  }
  
  public static boolean isEarlyAccessBuild() {
    return "RELEASE".equalsIgnoreCase("EARLY_ACCESS");
  }
  
  public static boolean isReleaseBuild() {
    return "RELEASE".equalsIgnoreCase("RELEASE");
  }
  
  public static boolean hasPatreonAccess(EntityPlayer player) {
    int patreon = getPatreonLevel(player);
    if (isDevBuild() && WyDebug.isDebug())
      return true; 
    if (isDevBuild() && patreon >= 4)
      return true; 
    if (isEarlyAccessBuild() && patreon >= 3)
      return true; 
    return false;
  }
}
