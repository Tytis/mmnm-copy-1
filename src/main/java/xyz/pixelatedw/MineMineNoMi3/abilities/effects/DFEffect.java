package xyz.pixelatedw.MineMineNoMi3.abilities.effects;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public abstract class DFEffect {
  protected String effect;
  
  protected ExtendedEntityData props;
  
  protected EntityLivingBase entity;
  
  protected Update updateThread;
  
  protected int timer;
  
  public DFEffect(EntityLivingBase entity, int timer, String effect) {
    this(entity, timer, effect, true);
  }
  
  public DFEffect(EntityLivingBase entity, int timer, String effect, boolean check) {
    this.entity = entity;
    this.effect = effect;
    this.timer = timer;
    this.props = ExtendedEntityData.get(entity);
    if (check && !this.props.hasExtraEffects(effect)) {
      this.props.addExtraEffect(effect);
      if (entity instanceof EntityPlayerMP)
        WyNetworkHelper.sendTo((IMessage)new PacketSync(this.props), (EntityPlayerMP)entity); 
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(entity.getEntityId(), this.props));
      this.updateThread = new Update(this.props, timer);
      this.updateThread.start();
    } 
  }
  
  public abstract void onEffectStart(EntityLivingBase paramEntityLivingBase);
  
  public abstract void onEffectEnd(EntityLivingBase paramEntityLivingBase);
  
  public void forceStop() {
    try {
      this.updateThread.timer = -1;
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  class Update extends Thread {
    private ExtendedEntityData props;
    
    public int timer;
    
    public Update(ExtendedEntityData props, int timer) {
      setName("Update Thread for " + DFEffect.this.effect.toUpperCase() + " effect");
      this.props = props;
      this.timer = timer * 2 + 100;
    }
    
    public void updateTimer(int time) {
      this.timer = time;
    }
    
    public void run() {
      DFEffect.this.onEffectStart(DFEffect.this.entity);
      while (this.timer > 0) {
        try {
          this.timer--;
          Thread.sleep(20L);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } 
      } 
      this.props.removeExtraEffects(DFEffect.this.effect);
      if (DFEffect.this.entity instanceof EntityPlayerMP)
        WyNetworkHelper.sendTo((IMessage)new PacketSync(this.props), (EntityPlayerMP)DFEffect.this.entity); 
      WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(DFEffect.this.entity.getEntityId(), this.props));
      DFEffect.this.onEffectEnd(DFEffect.this.entity);
    }
  }
}
