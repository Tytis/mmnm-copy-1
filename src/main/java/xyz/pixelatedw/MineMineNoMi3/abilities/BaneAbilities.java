package xyz.pixelatedw.MineMineNoMi3.abilities;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BaneProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class BaneAbilities {
  static {
    Values.abilityWebAppExtraParams.put("springhopper", new String[] { "desc", "Turning the userps legs into springs, which launches them into the air." });
    Values.abilityWebAppExtraParams.put("springdeathknock", new String[] { "desc", "By turning the user's arm into a spring and compressing it, they can launch a powerful punch." });
    Values.abilityWebAppExtraParams.put("springsnipe", new String[] { "desc", "Turning the user's forelegs into springs, they can launch themselves directly at the opponent." });
  }
  
  public static Ability[] abilitiesArray = new Ability[] { new SpringDeathKnock(), new SpringSnipe(), new SpringHopper() };
  
  public static class SpringDeathKnock extends Ability {
    public SpringDeathKnock() {
      super(ListAttributes.SPRING_DEATH_KNOCK);
    }
    
    public void use(EntityPlayer player) {
      this.projectile = (AbilityProjectile)new BaneProjectiles.SpringDeathKnock(player.worldObj, (EntityLivingBase)player, this.attr);
      super.use(player);
    }
  }
  
  public static class SpringSnipe extends Ability {
    public SpringSnipe() {
      super(ListAttributes.SPRING_SNIPE);
    }
    
    public void endCharging(EntityPlayer player) {
      double mX = (-MathHelper.sin(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
      double mZ = (MathHelper.cos(player.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(player.rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
      double mY = -MathHelper.sin((player.rotationPitch + 0.0F) / 180.0F * 3.1415927F) * 0.4D;
      double f2 = MathHelper.sqrt_double(mX * mX + mY * mY + mZ * mZ);
      mX /= f2;
      mY /= f2;
      mZ /= f2;
      mX += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
      mY += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
      mZ += player.worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
      mX *= 8.0D;
      mY *= 3.0D;
      mZ *= 8.0D;
      BaneAbilities.motion("=", mX, mY, mZ, player);
      super.endCharging(player);
    }
    
    public void duringCooldown(EntityPlayer player, int currentCooldown) {
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (currentCooldown / 20 > ListAttributes.SPRING_SNIPE.getAbilityCooldown() / 20 - 3)
        for (EntityLivingBase e : WyHelper.getEntitiesNear((Entity)player, 1.6D))
          e.attackEntityFrom(DamageSource.causePlayerDamage(player), 8.0F * props.getDamageMultiplier());  
    }
  }
  
  public static class SpringHopper extends Ability {
    public SpringHopper() {
      super(ListAttributes.SPRING_HOPPER);
    }
    
    public void endCharging(EntityPlayer player) {
      WyHelper.Direction dir = WyHelper.get8Directions((Entity)player);
      if (player.onGround) {
        BaneAbilities.motion("+", 0.0D, 1.7D, 0.0D, player);
      } else {
        BaneAbilities.motion("+", 0.0D, 1.502857142857143D, 0.0D, player);
      } 
      if (dir == WyHelper.Direction.NORTH)
        BaneAbilities.motion("-", 0.0D, 0.0D, 1.9D, player); 
      if (dir == WyHelper.Direction.NORTH_WEST)
        BaneAbilities.motion("-", 1.9D, 0.0D, 1.9D, player); 
      if (dir == WyHelper.Direction.SOUTH)
        BaneAbilities.motion("+", 0.0D, 0.0D, 1.9D, player); 
      if (dir == WyHelper.Direction.NORTH_EAST) {
        BaneAbilities.motion("-", 0.0D, 0.0D, 1.9D, player);
        BaneAbilities.motion("+", 1.9D, 0.0D, 0.0D, player);
      } 
      if (dir == WyHelper.Direction.WEST)
        BaneAbilities.motion("-", 1.9D, 0.0D, 0.0D, player); 
      if (dir == WyHelper.Direction.SOUTH_WEST) {
        BaneAbilities.motion("+", 0.0D, 0.0D, 1.9D, player);
        BaneAbilities.motion("-", 1.9D, 0.0D, 0.0D, player);
      } 
      if (dir == WyHelper.Direction.EAST)
        BaneAbilities.motion("+", 1.9D, 0.0D, 0.0D, player); 
      if (dir == WyHelper.Direction.SOUTH_EAST)
        BaneAbilities.motion("+", 1.9D, 0.0D, 1.9D, player); 
      super.endCharging(player);
    }
  }
  
  private static void motion(String c, double x, double y, double z, EntityPlayer p) {
    WyNetworkHelper.sendTo((IMessage)new PacketPlayer("motion" + c, x, y, z), (EntityPlayerMP)p);
  }
}
