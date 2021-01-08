package xyz.pixelatedw.MineMineNoMi3.helpers;

import cpw.mods.fml.common.registry.GameRegistry;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.CyborgAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.FishKarateAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.HakiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.SniperAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.SwordsmanAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.WeatherAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;

public class WebAppHelper {
  public static void generateWebAppJSONs() {
    writeFancyAbilitiesList();
    File folder = new File(Values.RESOURCES_FOLDER + "/assets/" + "mineminenomi" + "/EXTRA_BOT_FILES/");
    folder.mkdirs();
    if (folder.exists()) {
      writeDevilFruitsJSON();
      writeSpecialAbilitiesJSON();
    } 
  }
  
  private static void writeDevilFruitsJSON() {
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Values.RESOURCES_FOLDER + "/assets/" + "mineminenomi" + "/EXTRA_BOT_FILES/devilfruits.json"), "UTF-8"))) {
      writer.write("{\n");
      writer.write("\"devilfruits\" : [");
      for (Item f : Values.devilfruits) {
        AkumaNoMi fruit = (AkumaNoMi)f;
        ItemStack itemStack = new ItemStack(GameRegistry.findItem("mineminenomi", fruit.getUnlocalizedName().substring(5)));
        Map<String, Object> devilFruitElements = new LinkedHashMap<>();
        devilFruitElements.put("name", "\"" + itemStack.getDisplayName() + "\"");
        devilFruitElements.put("type", "\"" + fruit.getType().getName() + "\"");
        devilFruitElements.put("abilities", "[ " + generateAbilitiesString(fruit.abilities) + " ]");
        writer.write("{ ");
        for (String devilFruitKey : devilFruitElements.keySet()) {
          Object key = devilFruitElements.get(devilFruitKey);
          if (key instanceof String)
            writer.write("\"" + devilFruitKey + "\": " + key + ", "); 
        } 
        writer.write("},\n");
      } 
      writer.write("]}");
      writer.close();
    } catch (Exception e) {
      e.getStackTrace();
    } 
  }
  
  private static void writeSpecialAbilitiesJSON() {
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Values.RESOURCES_FOLDER + "/assets/" + "mineminenomi" + "/EXTRA_BOT_FILES/specialabilities.json"), "UTF-8"))) {
      writer.write("{\n");
      writer.write("\"specialabilities\" : [");
      Ability[] humanAbilities = (Ability[])Stream.<Ability[]>of(new Ability[][] { RokushikiAbilities.abilitiesArray, HakiAbilities.abilitiesArray }).flatMap(Stream::of).toArray(x$0 -> new Ability[x$0]);
      writer.write("{ \"name\": \"Human\", \"type\": \"n/a\", \"abilities\": [ " + generateAbilitiesString(humanAbilities) + " ]},\n");
      Ability[] fishmanAbilities = (Ability[])Stream.<Ability[]>of(new Ability[][] { FishKarateAbilities.abilitiesArray, HakiAbilities.abilitiesArray }).flatMap(Stream::of).toArray(x$0 -> new Ability[x$0]);
      writer.write("{ \"name\": \"Fishman\", \"type\": \"n/a\", \"abilities\": [ " + generateAbilitiesString(fishmanAbilities) + " ]},\n");
      Ability[] cyborgAbilities = (Ability[])Stream.<Ability[]>of(new Ability[][] { CyborgAbilities.abilitiesArray, HakiAbilities.abilitiesArray }).flatMap(Stream::of).toArray(x$0 -> new Ability[x$0]);
      writer.write("{ \"name\": \"Cyborg\", \"type\": \"n/a\", \"abilities\": [ " + generateAbilitiesString(cyborgAbilities) + " ]},\n");
      writer.write("{ \"name\": \"Swordsman\", \"type\": \"n/a\", \"abilities\": [ " + generateAbilitiesString(SwordsmanAbilities.abilitiesArray) + " ]},\n");
      writer.write("{ \"name\": \"Sniper\", \"type\": \"n/a\", \"abilities\": [ " + generateAbilitiesString(SniperAbilities.abilitiesArray) + " ]},\n");
      writer.write("{ \"name\": \"Art of Weather\", \"type\": \"n/a\", \"abilities\": [ " + generateAbilitiesString(WeatherAbilities.abilitiesArray) + " ]},\n");
      writer.write("]}");
      writer.close();
    } catch (Exception e) {
      e.getStackTrace();
    } 
  }
  
  private static void writeFancyAbilitiesList() {
    File folder = new File(Values.RESOURCES_FOLDER + "/assets/" + "mineminenomi" + "/EXTRA_BOT_FILES/");
    folder.mkdirs();
    if (folder.exists())
      try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Values.RESOURCES_FOLDER + "/assets/" + "mineminenomi" + "/EXTRA_BOT_FILES/fancylist.txt"), "UTF-8"))) {
        for (AkumaNoMi devilFruit : Values.devilfruits) {
          writer.write(devilFruit.getItemStackDisplayName(new ItemStack((Item)devilFruit)) + "\n");
          for (Ability ability : devilFruit.abilities)
            writer.write("> " + ability.getAttribute().getAbilityDisplayName() + "\n"); 
          writer.write("\n");
        } 
      } catch (Exception e) {
        e.getStackTrace();
      }  
  }
  
  private static String generateAbilitiesString(Ability[] abilities) {
    StringBuilder abilitiesString = new StringBuilder();
    for (Ability ability : abilities) {
      boolean hasDescription = false;
      StringBuilder abilityString = new StringBuilder();
      abilityString.append("{ ");
      Map<String, Object> loadedParams = new LinkedHashMap<>();
      AbilityAttribute abilityAttribute = ability.getAttribute();
      loadedParams.put("name", abilityAttribute.getAbilityDisplayName());
      loadedParams.put("texture", WyHelper.getFancyName(abilityAttribute.getAbilityTexture()));
      if (abilityAttribute.getAbilityCooldown() > 0)
        loadedParams.put("cooldown", Integer.valueOf(abilityAttribute.getAbilityCooldown() / 20)); 
      if (abilityAttribute.getAbilityCharges() > 0)
        loadedParams.put("chargeTime", Integer.valueOf(abilityAttribute.getAbilityCharges() / 20)); 
      if (abilityAttribute.getProjectileDamage() > 1.0F)
        loadedParams.put("projectileDamage", Float.valueOf(abilityAttribute.getProjectileDamage())); 
      if (abilityAttribute.hasProjectile() && abilityAttribute.isRepeater())
        loadedParams.put("projectileNumber", Integer.valueOf(abilityAttribute.getAbilityCooldown() / abilityAttribute.getAbilityRepeaterTime() / abilityAttribute.getAbilityRepeaterTime())); 
      if (abilityAttribute.getProjectileExplosionPower() > 0)
        loadedParams.put("projectileExplosion", Integer.valueOf(abilityAttribute.getProjectileExplosionPower())); 
      if (abilityAttribute.getPotionEffectsForAoE() != null && (abilityAttribute.getPotionEffectsForAoE()).length > 0)
        loadedParams.put("aoeEffects", "[" + getPotionEffectsFor(abilityAttribute.getPotionEffectsForAoE()) + "]"); 
      if (abilityAttribute.getPotionEffectsForProjectile() != null && (abilityAttribute.getPotionEffectsForProjectile()).length > 0)
        loadedParams.put("onHitEffects", "[" + getPotionEffectsFor(abilityAttribute.getPotionEffectsForProjectile()) + "]"); 
      if (abilityAttribute.getPotionEffectsForUser() != null && (abilityAttribute.getPotionEffectsForUser()).length > 0)
        loadedParams.put("selfEffects", "[" + getPotionEffectsFor(abilityAttribute.getPotionEffectsForUser()) + "]"); 
      for (String manualParamKey : Values.abilityWebAppExtraParams.keySet()) {
        if (WyHelper.getFancyName(abilityAttribute.getAttributeName()).equalsIgnoreCase(manualParamKey)) {
          String[] params = (String[])Values.abilityWebAppExtraParams.get(manualParamKey);
          for (int j = 0; j < params.length; j++) {
            String param = params[j];
            Object paramValue = params[++j];
            if (param.equalsIgnoreCase("desc"))
              hasDescription = true; 
            try {
              paramValue = Integer.valueOf(Integer.parseInt((String)paramValue));
            } catch (Exception exception) {}
            if (loadedParams.containsKey(param)) {
              loadedParams.replace(param, paramValue);
            } else {
              loadedParams.put(param, paramValue);
            } 
          } 
        } 
      } 
      for (String loadedParamKey : loadedParams.keySet()) {
        Object key = loadedParams.get(loadedParamKey);
        if (key instanceof Integer || key instanceof Double || key instanceof Float || loadedParamKey.equalsIgnoreCase("aoeEffects") || loadedParamKey.equalsIgnoreCase("onHitEffects") || loadedParamKey.equalsIgnoreCase("selfEffects")) {
          abilityString.append("\"" + loadedParamKey + "\": " + key + ",");
          continue;
        } 
        if (loadedParams.get(loadedParamKey) instanceof String)
          abilityString.append("\"" + loadedParamKey + "\": \"" + key + "\","); 
      } 
      abilityString.append("},");
      abilitiesString.append(abilityString.toString());
      if (!hasDescription)
        System.out.println("Ability without description : " + ability.getAttribute().getAbilityDisplayName()); 
    } 
    return abilitiesString.toString();
  }
  
  private static String getPotionEffectsFor(PotionEffect[] pe) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < pe.length; i++) {
      double d = Math.ceil(pe[i].getDuration() / 24.0D);
      if (i < pe.length - 1) {
        builder.append("\"" + I18n.format(pe[i].getEffectName(), new Object[0]) + " " + String.format("%.0f", new Object[] { Double.valueOf(d) }) + " " + ((d == 1.0D) ? "second" : "seconds") + " (" + ((pe[i].getAmplifier() > 0) ? "+" : "-") + ")\", ");
      } else {
        builder.append("\"" + I18n.format(pe[i].getEffectName(), new Object[0]) + " " + String.format("%.0f", new Object[] { Double.valueOf(d) }) + " " + ((d == 1.0D) ? "second" : "seconds") + " (" + ((pe[i].getAmplifier() > 0) ? "+" : "-") + ")\"");
      } 
    } 
    String potionList = builder.toString();
    return potionList;
  }
}
