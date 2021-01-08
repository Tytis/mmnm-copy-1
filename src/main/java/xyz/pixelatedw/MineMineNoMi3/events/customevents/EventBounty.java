package xyz.pixelatedw.MineMineNoMi3.events.customevents;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;

public class EventBounty extends EntityEvent {
  public EntityPlayer player;
  
  public ExtendedEntityData props;
  
  public long amount;
  
  public EventBounty(EntityPlayer entity) {
    this(entity, 0L);
  }
  
  public EventBounty(EntityPlayer entity, long plusBounty) {
    super((Entity)entity);
    this.player = entity;
    this.amount = plusBounty;
    this.props = ExtendedEntityData.get((EntityLivingBase)this.player);
  }
}
