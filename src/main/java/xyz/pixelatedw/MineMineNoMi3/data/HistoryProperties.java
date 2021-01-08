package xyz.pixelatedw.MineMineNoMi3.data;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class HistoryProperties implements IExtendedEntityProperties {
  private static final String NAME = "mineminenomi_HistoryIEEP";
  
  private EntityPlayer player;
  
  private List<String> unlockedChallenges = new ArrayList<>();
  
  private List<String> completedChallenges = new ArrayList<>();
  
  public HistoryProperties(EntityPlayer player) {
    this.player = player;
  }
  
  public static final void register(EntityPlayer player) {
    player.registerExtendedProperties("mineminenomi_HistoryIEEP", new HistoryProperties(player));
  }
  
  public static final HistoryProperties get(EntityPlayer player) {
    return (HistoryProperties)player.getExtendedProperties("mineminenomi_HistoryIEEP");
  }
  
  public EntityPlayer getEntity() {
    return this.player;
  }
  
  public void saveNBTData(NBTTagCompound compound) {
    NBTTagCompound unlockedChallengesTag = new NBTTagCompound();
    if (this.unlockedChallenges.size() > 0)
      this.unlockedChallenges.stream().forEach(x -> unlockedChallengesTag.setBoolean(x, true)); 
    compound.setTag("unlockedChallenges", (NBTBase)unlockedChallengesTag);
    NBTTagCompound completedChallengesTag = new NBTTagCompound();
    if (this.completedChallenges.size() > 0)
      this.completedChallenges.stream().forEach(x -> completedChallengesTag.setBoolean(x, true)); 
    compound.setTag("completedChallenges", (NBTBase)completedChallengesTag);
  }
  
  public void loadNBTData(NBTTagCompound compound) {
    NBTTagCompound unlockedChallenges = compound.getCompoundTag("unlockedChallenges");
    this.unlockedChallenges.clear();
    unlockedChallenges.func_150296_c().stream().forEach(x -> this.unlockedChallenges.add((String)x));
    NBTTagCompound completedChallenges = compound.getCompoundTag("completedChallenges");
    this.completedChallenges.clear();
    completedChallenges.func_150296_c().stream().forEach(x -> this.completedChallenges.add((String)x));
  }
  
  public void init(Entity entity, World world) {}
  
  public boolean addCompletedChallenge(String entry) {
    if (!hasCompletedChallenge(entry)) {
      this.completedChallenges.add(entry);
      return true;
    } 
    return false;
  }
  
  public boolean removeCompletedChallenge(String entry) {
    if (hasCompletedChallenge(entry)) {
      this.completedChallenges.remove(entry);
      return true;
    } 
    return false;
  }
  
  public boolean hasCompletedChallenge(String entry) {
    return this.completedChallenges.contains(entry);
  }
  
  public boolean addUnlockedChallenge(String entry) {
    if (!hasUnlockedChallenge(entry)) {
      this.unlockedChallenges.add(entry);
      return true;
    } 
    return false;
  }
  
  public boolean removeUnlockedChallenge(String entry) {
    if (hasUnlockedChallenge(entry)) {
      this.unlockedChallenges.remove(entry);
      return true;
    } 
    return false;
  }
  
  public boolean hasUnlockedChallenge(String entry) {
    return this.unlockedChallenges.contains(entry);
  }
}
