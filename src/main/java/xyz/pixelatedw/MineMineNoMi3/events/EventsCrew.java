package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class EventsCrew {
  @SubscribeEvent
  public void onEntityAttack(LivingHurtEvent event) {
    if (event.source.getSourceOfDamage() instanceof EntityPlayer) {
      EntityPlayer attacker = (EntityPlayer)event.source.getSourceOfDamage();
      EntityLivingBase attacked = event.entityLiving;
      List<EntityLivingBase> crewMembers = (List<EntityLivingBase>)WyHelper.getEntitiesNear((Entity)attacker, 20.0D, new Class[] { EntityMob.class }).stream().collect(Collectors.toList());
      if (crewMembers.size() > 0)
        crewMembers.stream().forEach(x -> {
              if (x instanceof IEntityOwnable && x instanceof EntityMob) {
                IEntityOwnable ownableComponent = (IEntityOwnable)x;
                EntityMob mobComponent = (EntityMob)x;
                if (ownableComponent.getOwner() == attacker)
                  mobComponent.setAttackTarget(attacked); 
              } 
            }); 
    } 
  }
}
