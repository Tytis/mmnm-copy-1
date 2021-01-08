package xyz.pixelatedw.MineMineNoMi3.api.abilities.extra;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;

public class AbilityProperties implements IExtendedEntityProperties {
  public static final String EXT_ABILITYPROP_NAME = "mineminenomi_AbilityIEEP";
  
  private final EntityPlayer thePlayer;
  
  public Ability[] hotbarAbilities = new Ability[8];
  
  private Ability[] devilFruitAbilities = new Ability[32];
  
  private Ability[] racialAbilities = new Ability[32];
  
  private Ability[] styleAbilities = new Ability[32];
  
  private Ability[] hakiAbilities = new Ability[16];
  
  public AbilityProperties(EntityPlayer entity) {
    this.thePlayer = entity;
  }
  
  public static final void register(EntityPlayer entity) {
    entity.registerExtendedProperties("mineminenomi_AbilityIEEP", new AbilityProperties(entity));
  }
  
  public static final AbilityProperties get(EntityPlayer entity) {
    return (AbilityProperties)entity.getExtendedProperties("mineminenomi_AbilityIEEP");
  }
  
  public void saveNBTData(NBTTagCompound compound) {
    NBTTagCompound props = new NBTTagCompound();
    int i;
    for (i = 0; i < this.hotbarAbilities.length; i++) {
      if (this.hotbarAbilities[i] != null)
        props.setTag("hotbar_ability_" + i, (NBTBase)saveNLOBData(this.hotbarAbilities[i])); 
    } 
    for (i = 0; i < this.devilFruitAbilities.length; i++) {
      if (this.devilFruitAbilities[i] != null)
        props.setTag("devilfruits_ability_" + i, (NBTBase)saveNLOBData(this.devilFruitAbilities[i])); 
    } 
    for (i = 0; i < this.racialAbilities.length; i++) {
      if (this.racialAbilities[i] != null)
        props.setTag("racial_ability_" + i, (NBTBase)saveNLOBData(this.racialAbilities[i])); 
    } 
    for (i = 0; i < this.styleAbilities.length; i++) {
      if (this.styleAbilities[i] != null)
        props.setTag("style_ability_" + i, (NBTBase)saveNLOBData(this.styleAbilities[i])); 
    } 
    for (i = 0; i < this.hakiAbilities.length; i++) {
      if (this.hakiAbilities[i] != null)
        props.setTag("haki_ability_" + i, (NBTBase)saveNLOBData(this.hakiAbilities[i])); 
    } 
    compound.setTag("mineminenomi_AbilityIEEP", (NBTBase)props);
  }
  
  private NBTTagCompound saveNLOBData(Ability abl) {
    NBTTagCompound data = new NBTTagCompound();
    data.setString("name", abl.getAttribute().getAttributeName());
    data.setBoolean("isOnCooldown", abl.isOnCooldown());
    data.setBoolean("isCharging", abl.isCharging());
    data.setBoolean("isPassiveActive", abl.isPassiveActive());
    return data;
  }
  
  public void loadNBTData(NBTTagCompound compound) {
    NBTTagCompound props = (NBTTagCompound)compound.getTag("mineminenomi_AbilityIEEP");
    try {
      int i;
      for (i = 0; i < this.hotbarAbilities.length; i++)
        this.hotbarAbilities[i] = loadAbilityFromNLOB((NBTTagCompound)props.getTag("hotbar_ability_" + i)); 
      for (i = 0; i < this.devilFruitAbilities.length; i++)
        this.devilFruitAbilities[i] = loadAbilityFromNLOB((NBTTagCompound)props.getTag("devilfruits_ability_" + i)); 
      for (i = 0; i < this.racialAbilities.length; i++)
        this.racialAbilities[i] = loadAbilityFromNLOB((NBTTagCompound)props.getTag("racial_ability_" + i)); 
      for (i = 0; i < this.styleAbilities.length; i++)
        this.styleAbilities[i] = loadAbilityFromNLOB((NBTTagCompound)props.getTag("style_ability_" + i)); 
      for (i = 0; i < this.hakiAbilities.length; i++)
        this.hakiAbilities[i] = loadAbilityFromNLOB((NBTTagCompound)props.getTag("haki_ability_" + i)); 
    } catch (Exception e) {
      Logger.getGlobal().log(Level.SEVERE, "Ability is not registered correctly or could not be found in the master list !");
      e.printStackTrace();
    } 
  }
  
  private Ability loadAbilityFromNLOB(NBTTagCompound props) {
    if (props == null)
      return null; 
    String ablName = props.getString("name");
    Ability ability = null;
    try {
      if (AbilityManager.instance().getAbilityByName(WyHelper.getFancyName(ablName)) != null) {
        ability = (Ability)AbilityManager.instance().getAbilityByName(WyHelper.getFancyName(ablName)).getClass().newInstance();
        ability.setCooldownActive(props.getBoolean("isOnCooldown"));
        ability.setChargeActive(props.getBoolean("isCharging"));
        ability.setPassiveActive(props.getBoolean("isPassiveActive"));
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return ability;
  }
  
  public void init(Entity entity, World world) {}
  
  public boolean addDevilFruitAbility(Ability abl) {
    for (int i = 0; i < this.devilFruitAbilities.length; i++) {
      if (this.devilFruitAbilities[i] == null && !hasDevilFruitAbility(abl)) {
        this.devilFruitAbilities[i] = abl;
        return true;
      } 
    } 
    return false;
  }
  
  public void removeDevilFruitAbility(Ability ablTemplate) {
    for (int i = 0; i < this.devilFruitAbilities.length; i++) {
      if (this.devilFruitAbilities[i] != null && this.devilFruitAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName())) {
        this.devilFruitAbilities[i] = null;
        break;
      } 
    } 
  }
  
  public boolean hasDevilFruitAbility(Ability ablTemplate) {
    for (int i = 0; i < this.devilFruitAbilities.length; i++) {
      if (this.devilFruitAbilities[i] != null && this.devilFruitAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName()))
        return true; 
    } 
    return false;
  }
  
  public Ability[] getDevilFruitAbilities() {
    return this.devilFruitAbilities;
  }
  
  public void clearDevilFruitAbilities() {
    for (int i = 0; i < this.devilFruitAbilities.length; i++) {
      if (this.devilFruitAbilities[i] != null)
        this.devilFruitAbilities[i] = null; 
    } 
  }
  
  public boolean addRacialAbility(Ability abl) {
    for (int i = 0; i < this.racialAbilities.length; i++) {
      if (this.racialAbilities[i] == null && !hasRacialAbility(abl)) {
        this.racialAbilities[i] = abl;
        return true;
      } 
    } 
    return false;
  }
  
  public void removeRacialAbility(Ability ablTemplate) {
    for (int i = 0; i < this.racialAbilities.length; i++) {
      if (this.racialAbilities[i] != null && this.racialAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName())) {
        this.racialAbilities[i] = null;
        break;
      } 
    } 
  }
  
  public boolean hasRacialAbility(Ability ablTemplate) {
    if (ablTemplate != null)
      for (int i = 0; i < this.racialAbilities.length; i++) {
        if (this.racialAbilities[i] != null && this.racialAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName()))
          return true; 
      }  
    return false;
  }
  
  public Ability[] getRacialAbilities() {
    return this.racialAbilities;
  }
  
  public void clearRacialAbilities() {
    for (int i = 0; i < this.racialAbilities.length; i++) {
      if (this.racialAbilities[i] != null)
        this.racialAbilities[i] = null; 
    } 
  }
  
  public boolean addHakiAbility(Ability abl) {
    for (int i = 0; i < this.hakiAbilities.length; i++) {
      if (this.hakiAbilities[i] == null && !hasHakiAbility(abl)) {
        this.hakiAbilities[i] = abl;
        return true;
      } 
    } 
    return false;
  }
  
  public void removeHakiAbility(Ability ablTemplate) {
    for (int i = 0; i < this.hakiAbilities.length; i++) {
      if (this.hakiAbilities[i] != null && this.hakiAbilities[i].getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName())) {
        this.hakiAbilities[i] = null;
        break;
      } 
    } 
  }
  
  public boolean hasHakiAbility(Ability ablTemplate) {
    return (Arrays.<Ability>stream(this.hakiAbilities).filter(x -> (x != null && x.getAttribute().getAttributeName().equalsIgnoreCase(ablTemplate.getAttribute().getAttributeName()))).findFirst().orElse(null) != null);
  }
  
  public Ability[] getHakiAbilities() {
    return this.hakiAbilities;
  }
  
  public void clearHakiAbilities() {
    for (int i = 0; i < this.hakiAbilities.length; i++) {
      if (this.hakiAbilities[i] != null)
        this.hakiAbilities[i] = null; 
    } 
  }
  
  public Ability[] getAbilitiesInHotbar() {
    return this.hotbarAbilities;
  }
  
  public boolean hasAbilityInHotbar(Ability ability) {
    return hasAbilityInHotbar(ability.getAttribute().getAttributeName());
  }
  
  public boolean hasAbilityInHotbar(String abilityName) {
    return (Arrays.<Ability>stream(this.hotbarAbilities).filter(x -> (x != null && x.getAttribute().getAttributeName().equalsIgnoreCase(abilityName))).findFirst().orElse(null) != null);
  }
  
  public void setAbilityInSlot(int slot, Ability abl) {
    this.hotbarAbilities[slot] = abl;
  }
  
  public Ability getAbilityFromSlot(int slot) {
    return this.hotbarAbilities[slot];
  }
  
  public Ability getAbilityFromName(String name) {
    return Arrays.<Ability>stream(getAbilitiesInHotbar()).filter(x -> 
        
        (x != null && x.getAttribute() != null && x.getAttribute().getAttributeName().equalsIgnoreCase(name)))
      .findFirst().orElse(null);
  }
  
  public int countAbilitiesInHotbar() {
    return this.hotbarAbilities.length;
  }
  
  public void clearHotbar() {
    for (int i = 0; i < this.hotbarAbilities.length; i++) {
      if (this.hotbarAbilities[i] != null) {
        if (this.hotbarAbilities[i].isPassiveActive())
          this.hotbarAbilities[i].endPassive(this.thePlayer); 
        this.hotbarAbilities[i] = null;
      } 
    } 
  }
}
