package xyz.pixelatedw.MineMineNoMi3.abilities.effects;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSyncInfo;

public class DFEffectSakeDrunk extends DFEffect {
  private int stacks = 0;
  
  public DFEffectSakeDrunk(EntityLivingBase entity, int timer) {
    super(entity, timer, "sakeDrunk", false);
    this.props.addExtraEffect(this.effect);
    if (entity instanceof EntityPlayerMP)
      WyNetworkHelper.sendTo((IMessage)new PacketSync(this.props), (EntityPlayerMP)entity); 
    WyNetworkHelper.sendToAll((IMessage)new PacketSyncInfo(entity.getEntityId(), this.props));
    this.updateThread = (new Update(this.props, timer));
    this.updateThread.start();
    for (String str : this.props.getExtraEffects()) {
      if (!WyHelper.isNullOrEmpty(str) && str.equalsIgnoreCase("sakeDrunk"))
        this.stacks++; 
    } 
  }
  
  public void onEffectStart(EntityLivingBase entity) {
    if (this.stacks >= 3)
      entity.addPotionEffect(new PotionEffect(Potion.confusion.id, this.timer, 1)); 
  }
  
  public void onEffectEnd(EntityLivingBase entity) {
    System.out.println("#####");
    for (String str : this.props.getExtraEffects()) {
      if (!WyHelper.isNullOrEmpty(str) && str.equalsIgnoreCase("sakeDrunk"))
        this.props.removeExtraEffects("sakeDrunk"); 
    } 
  }
}
