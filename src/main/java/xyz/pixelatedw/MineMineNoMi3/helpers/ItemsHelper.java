package xyz.pixelatedw.MineMineNoMi3.helpers;

import com.google.common.collect.Multimap;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedWorldData;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class ItemsHelper {
  private static String[] wantedPostersBackgrounds = new String[] { 
      "forest1", "forest2", "jungle1", "jungle2", "hills1", "hills2", "hills3", "plains1", "plains2", "plains3", 
      "taiga1", "taiga2" };
  
  public static void dropWantedPosters(World world, int posX, int posY, int posZ) {
    ExtendedWorldData worldData = ExtendedWorldData.get(world);
    List<Map.Entry<String, Long>> bountiesInPackage = new ArrayList<>();
    if (!WyHelper.getEntitiesNear(posX, posY, posZ, world, 10.0D).isEmpty())
      WyHelper.getEntitiesNear(posX, posY, posZ, world, 10.0D).stream().filter(x -> 
          
          (x instanceof EntityPlayer && (ExtendedEntityData.get(x).isPirate() || ExtendedEntityData.get(x).isRevolutionary()) && worldData.getBounty(x.getCommandSenderName()) != 0L))
        .forEach(x -> {
            AbstractMap.SimpleEntry<String, Long> se = new AbstractMap.SimpleEntry<>(x.getCommandSenderName(), Long.valueOf(worldData.getBounty(x.getCommandSenderName())));
            bountiesInPackage.add(se);
          }); 
    if (5 + world.rand.nextInt(2) - bountiesInPackage.size() > 0)
      bountiesInPackage.addAll((Collection<? extends Map.Entry<String, Long>>)worldData.getAllBounties().entrySet().stream().filter(x -> !bountiesInPackage.contains(x)).limit((5 + world.rand.nextInt(2) - bountiesInPackage.size())).collect(Collectors.toList())); 
    bountiesInPackage.stream().forEach(x -> {
          ItemStack stack = new ItemStack((Item)ListMisc.WantedPoster);
          stack.setTagCompound(setWantedData((String)x.getKey(), ((Long)x.getValue()).longValue()));
          world.spawnEntityInWorld((Entity)new EntityItem(world, posX, (posY + 1), posZ, stack));
        });
  }
  
  public static NBTTagCompound setWantedData(String entityName, long bounty) {
    NBTTagCompound data = null;
    data = new NBTTagCompound();
    data.setString("Name", entityName);
    data.setLong("Bounty", bounty);
    int randomBg = (int)WyMathHelper.randomWithRange(0, wantedPostersBackgrounds.length - 1);
    data.setString("Background", wantedPostersBackgrounds[randomBg]);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = format.format(new Date());
    data.setString("Date", dateString);
    return data;
  }
  
  public static int getClimaTactLevel(Item item) {
    if (item == ListMisc.ClimaTact)
      return 1; 
    if (item == ListMisc.PerfectClimaTact)
      return 2; 
    if (item == ListMisc.SorceryClimaTact)
      return 3; 
    return 0;
  }
  
  public static boolean isBow(ItemStack itemStack) {
    if (itemStack == null)
      return false; 
    if (itemStack.getItemUseAction() == EnumAction.bow)
      return true; 
    return false;
  }
  
  public static boolean isSword(ItemStack itemStack) {
    if (itemStack == null)
      return false; 
    if (itemStack.getItem() instanceof net.minecraft.item.ItemSword)
      return true; 
    Multimap multimap = itemStack.getAttributeModifiers();
    if (multimap.containsKey(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()))
      return true; 
    return false;
  }
  
  public static boolean hasKairosekiItem(EntityPlayer player) {
    for (Item itm : Values.KAIROSEKI_ITEMS) {
      if (player.inventory.hasItem(itm))
        return true; 
    } 
    return false;
  }
}
