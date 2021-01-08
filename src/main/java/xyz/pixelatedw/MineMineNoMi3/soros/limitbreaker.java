package xyz.pixelatedw.MineMineNoMi3.soros;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityProperties;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class limitbreaker extends Item {
  public float getPercent(float pj) {
    return 0.25F * pj + pj;
  }
  
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
    AbilityProperties abilityProps = AbilityProperties.get(player);
    if (!world.isRemote && 
      props.hasDevilFruit()) {
      for (int i = 0; i < (abilityProps.getDevilFruitAbilities()).length - 1; i++) {
        if (abilityProps.getDevilFruitAbilities()[i] != null)
          if (abilityProps.getDevilFruitAbilities()[i].getAttribute().hasProjectile()) {
            abilityProps.getDevilFruitAbilities()[i].getAttribute().setProjectileDamage(abilityProps.getDevilFruitAbilities()[i].getAttribute().getProjectileDamage());
          } else if (abilityProps.getDevilFruitAbilities()[i].getAttribute().isPunch()) {
            abilityProps.getDevilFruitAbilities()[i].getAttribute().setAbilityPunch(abilityProps.getDevilFruitAbilities()[i].getAttribute().getPunchDamage());
          }  
      } 
      itemStack.stackSize--;
    } 
    return itemStack;
  }
}
