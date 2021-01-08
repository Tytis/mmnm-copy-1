package xyz.pixelatedw.MineMineNoMi3.api.abilities.extra;

import java.util.LinkedHashMap;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;

public class AbilityManager {
  private static AbilityManager instance;
  
  public static AbilityManager instance() {
    if (instance == null)
      instance = new AbilityManager(); 
    return instance;
  }
  
  private LinkedHashMap<String, Ability> registeredAbilities = new LinkedHashMap<>();
  
  public void registerAbility(Ability ab) {
    if (this.registeredAbilities.containsKey(WyHelper.getFancyName(ab.getAttribute().getAttributeName()))) {
      WyDebug.info(ab.getAttribute().getAttributeName() + " ability is already registered ! Ignoring request.");
    } else {
      this.registeredAbilities.put(WyHelper.getFancyName(ab.getAttribute().getAttributeName()), ab);
      WyRegistry.registerName("ability." + WyHelper.getFancyName(ab.getAttribute().getAttributeName()) + ".name", ab.getAttribute().getAbilityDisplayName());
    } 
  }
  
  public Ability getAbilityByName(String key) {
    if (this.registeredAbilities.containsKey(key))
      return this.registeredAbilities.get(key); 
    return null;
  }
  
  public LinkedHashMap<String, Ability> getHashMap() {
    return this.registeredAbilities;
  }
  
  public int getSize() {
    return this.registeredAbilities.size();
  }
}
