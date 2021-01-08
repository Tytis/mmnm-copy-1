package xyz.pixelatedw.MineMineNoMi3.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;

public class ExtendedWorldData extends WorldSavedData {
  private static final String IDENTIFIER = "mineminenomi";
  
  private boolean isSwordsmanDojoSpawned = false;
  
  private int totalDojosSpawned;
  
  private HashMap<String, Long> issuedBounties = new HashMap<>();
  
  private List<String> devilFruitsInWorld = new ArrayList<>();
  
  private List<int[][]> protectedAreas = (List)new ArrayList<>();
  
  public ExtendedWorldData() {
    super("mineminenomi");
  }
  
  public ExtendedWorldData(String identifier) {
    super(identifier);
  }
  
  public static ExtendedWorldData get(World world) {
    ExtendedWorldData data = (ExtendedWorldData)world.loadItemData(ExtendedWorldData.class, "mineminenomi");
    if (data == null) {
      data = new ExtendedWorldData();
      world.setItemData("mineminenomi", data);
    } 
    return data;
  }
  
  public void readFromNBT(NBTTagCompound nbt) {
    this.isSwordsmanDojoSpawned = nbt.getBoolean("isSwordsmanDojoSpawned");
    this.totalDojosSpawned = nbt.getInteger("totalDojosSpawned");
    NBTTagCompound bounties = nbt.getCompoundTag("issuedBounties");
    this.issuedBounties.clear();
    bounties.func_150296_c().stream().forEach(x -> this.issuedBounties.put((String)x, Long.valueOf(bounties.getLong((String)x))));
    NBTTagCompound devilFruits = nbt.getCompoundTag("devilFruits");
    this.devilFruitsInWorld.clear();
    devilFruits.func_150296_c().stream().forEach(x -> this.devilFruitsInWorld.add((String)x));
    NBTTagCompound protectedAreas = nbt.getCompoundTag("protectedAreas");
    this.protectedAreas.clear();
    for (int i = 0; i <= protectedAreas.func_150296_c().size(); i++) {
      int[] minPos = protectedAreas.getIntArray("minPos_" + i);
      int[] maxPos = protectedAreas.getIntArray("maxPos_" + i);
      this.protectedAreas.add(new int[][] { minPos, maxPos });
    } 
  }
  
  public void writeToNBT(NBTTagCompound nbt) {
    nbt.setBoolean("isSwordsmanDojoSpawned", this.isSwordsmanDojoSpawned);
    nbt.setInteger("totalDojosSpawned", this.totalDojosSpawned);
    NBTTagCompound bounties = new NBTTagCompound();
    if (this.issuedBounties.size() > 0)
      this.issuedBounties.entrySet().stream().forEach(x -> bounties.setLong((String)x.getKey(), ((Long)x.getValue()).longValue())); 
    nbt.setTag("issuedBounties", (NBTBase)bounties);
    NBTTagCompound devilFruits = new NBTTagCompound();
    if (this.devilFruitsInWorld.size() > 0)
      this.devilFruitsInWorld.stream().forEach(x -> devilFruits.setBoolean(x, true)); 
    nbt.setTag("devilFruits", (NBTBase)devilFruits);
    NBTTagCompound protectedAreas = new NBTTagCompound();
    if (this.protectedAreas.size() > 0) {
      int i = 0;
      for (int[][] area : this.protectedAreas) {
        protectedAreas.setIntArray("minPos_" + i, area[0]);
        protectedAreas.setIntArray("maxPos_" + i, area[1]);
        i++;
      } 
    } 
    nbt.setTag("protectedAreas", (NBTBase)protectedAreas);
  }
  
  public boolean isInsideRestrictedArea(int posX, int posY, int posZ) {
    if (this.protectedAreas.size() <= 0)
      return false; 
    for (int[][] area : this.protectedAreas) {
      int[] minPos = area[0];
      int[] maxPos = area[1];
      if (minPos.length <= 0 || maxPos.length <= 0)
        continue; 
      if (posX > minPos[0] && posX < maxPos[0] && posY > minPos[1] && posY < maxPos[1] && posZ > minPos[2] && posZ < maxPos[2])
        return true; 
    } 
    return false;
  }
  
  public void addRestrictedArea(int[] minPos, int[] maxPos) {
    this.protectedAreas.add(new int[][] { minPos, maxPos });
    markDirty();
  }
  
  public void removeRestrictedArea(int midX, int midY, int midZ) {
    Iterator iterator = this.protectedAreas.iterator();
    while (iterator.hasNext()) {
      int[][] area = (int[][])iterator.next();
      int[] minPos = area[0];
      int[] maxPos = area[1];
      if (minPos.length <= 0 || maxPos.length <= 0)
        continue; 
      int possibleMidX = (minPos[0] + maxPos[0]) / 2;
      int possibleMidY = (minPos[1] + maxPos[1]) / 2;
      int possibleMidZ = (minPos[2] + maxPos[2]) / 2;
      if (midX == possibleMidX && midY == possibleMidY && midZ == possibleMidZ)
        iterator.remove(); 
    } 
    markDirty();
  }
  
  public List<int[][]> getAllRestrictions() {
    return this.protectedAreas;
  }
  
  public HashMap<String, Long> getAllBounties() {
    return this.issuedBounties;
  }
  
  public long getBounty(String name) {
    if (this.issuedBounties.containsKey(name.toLowerCase()))
      return ((Long)this.issuedBounties.get(name.toLowerCase())).longValue(); 
    return 0L;
  }
  
  public void issueBounty(String name, long bounty) {
    if (this.issuedBounties.containsKey(name.toLowerCase())) {
      this.issuedBounties.remove(name.toLowerCase());
      this.issuedBounties.put(name.toLowerCase(), Long.valueOf(bounty));
    } else {
      this.issuedBounties.put(name.toLowerCase(), Long.valueOf(bounty));
    } 
    markDirty();
  }
  
  public int getTotalDojosSpawned() {
    return this.totalDojosSpawned;
  }
  
  public void countUpDojoSpawned() {
    this.totalDojosSpawned++;
    if (this.totalDojosSpawned >= MainConfig.maxDojoSpawn)
      setSwordsmanDojoSpawned(true); 
    markDirty();
  }
  
  public void setDojoSpawned(int value) {
    this.totalDojosSpawned = value;
    if (this.totalDojosSpawned >= MainConfig.maxDojoSpawn)
      setSwordsmanDojoSpawned(true); 
    markDirty();
  }
  
  public boolean isSwordsmanDojoSpawned() {
    return this.isSwordsmanDojoSpawned;
  }
  
  public void setSwordsmanDojoSpawned(boolean value) {
    this.isSwordsmanDojoSpawned = value;
    markDirty();
  }
  
  public List<String> getDevilFruitsInWorld() {
    return this.devilFruitsInWorld;
  }
  
  public void removeDevilFruitFromWorld(AkumaNoMi fruit) {
    String name = fruit.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace(",", "").replace("model", "");
    if (this.devilFruitsInWorld.contains(name)) {
      this.devilFruitsInWorld.remove(name);
      markDirty();
    } 
  }
  
  public void removeDevilFruitFromWorld(String name) {
    if (this.devilFruitsInWorld.contains(name)) {
      this.devilFruitsInWorld.remove(name);
      markDirty();
    } 
  }
  
  public void addDevilFruitInWorld(AkumaNoMi fruit) {
    String name = fruit.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace(",", "").replace("model", "");
    if (!this.devilFruitsInWorld.contains(name)) {
      this.devilFruitsInWorld.add(name);
      markDirty();
    } 
  }
  
  public void addDevilFruitInWorld(String name) {
    if (!this.devilFruitsInWorld.contains(name)) {
      this.devilFruitsInWorld.add(name);
      markDirty();
    } 
  }
  
  public boolean isDevilFruitInWorld(String name) {
    return this.devilFruitsInWorld.contains(name);
  }
}
