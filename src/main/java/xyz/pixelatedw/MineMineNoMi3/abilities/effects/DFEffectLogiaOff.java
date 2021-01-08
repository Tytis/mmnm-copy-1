package xyz.pixelatedw.MineMineNoMi3.abilities.effects;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;

public class DFEffectLogiaOff extends DFEffect {
  public DFEffectLogiaOff(EntityLivingBase entity, int timer) {
    super(entity, timer, "logiaOff");
  }
  
  public void onEffectStart(EntityLivingBase entity) {
    ExtendedEntityData.get(entity).setIsLogia(false);
  }
  
  public void onEffectEnd(EntityLivingBase entity) {
    ExtendedEntityData props = ExtendedEntityData.get(entity);
    if (!props.isLogia())
      Values.logias.forEach(x -> {
            String name = WyHelper.getFancyName((new ItemStack((Item)x)).getDisplayName());
            if (name.equalsIgnoreCase(props.getUsedFruit() + "nomi") && !props.getUsedFruit().equalsIgnoreCase("yamiyami")) {
              System.out.println("###");
              props.setIsLogia(true);
            } 
          }); 
  }
}
