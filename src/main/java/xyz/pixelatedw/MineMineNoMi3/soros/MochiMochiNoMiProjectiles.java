package xyz.pixelatedw.MineMineNoMi3.soros;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;

public class MochiMochiNoMiProjectiles {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { MochiBall.class, ListAttributes.MOCHIBALL });
    abilitiesClassesArray.add(new Object[] { BuzzMochi.class, ListAttributes.BuzzMochi });
    abilitiesClassesArray.add(new Object[] { MochiRocket.class, ListAttributes.MOCHIROCKET });
    abilitiesClassesArray.add(new Object[] { MochiGatling.class, ListExtraAttributes.MOCHIGATLING });
    abilitiesClassesArray.add(new Object[] { ChikaraMochi.class, ListAttributes.ChikaraMochi });
    abilitiesClassesArray.add(new Object[] { YAKI.class, ListAttributes.YakiMochi });
  }
  
  public static class YAKI extends AbilityProjectile {
    public YAKI(World world) {
      super(world);
    }
    
    public YAKI(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public YAKI(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      if (hit.entityHit instanceof EntityLivingBase)
        hit.entityHit.setFire(10); 
    }
  }
  
  public static class MochiBall extends AbilityProjectile {
    public MochiBall(World world) {
      super(world);
    }
    
    public MochiBall(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public MochiBall(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      if (hit.entityHit instanceof EntityLivingBase) {
        ((EntityLivingBase)hit.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600));
        ((EntityLivingBase)hit.entityHit).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 600));
      } 
    }
  }
  
  public static class BuzzMochi extends AbilityProjectile {
    public BuzzMochi(World world) {
      super(world);
    }
    
    public BuzzMochi(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public BuzzMochi(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class MochiGatling extends AbilityProjectile {
    public MochiGatling(World world) {
      super(world);
    }
    
    public MochiGatling(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public MochiGatling(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
  }
  
  public static class MochiRocket extends AbilityProjectile {
    public MochiRocket(World world) {
      super(world);
    }
    
    public MochiRocket(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public MochiRocket(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      if (hit.entityHit instanceof EntityLivingBase) {
        ((EntityLivingBase)hit.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600));
        ((EntityLivingBase)hit.entityHit).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 600));
      } 
    }
  }
  
  public static class ChikaraMochi extends AbilityProjectile {
    private Random r = new Random();
    
    public ChikaraMochi(World world) {
      super(world);
    }
    
    public ChikaraMochi(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public ChikaraMochi(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void onUpdate() {
      if (this.worldObj.isRemote) {
        int i;
        for (i = 0; i < DevilFruitsHelper.getParticleSettingModifier(25); i++) {
          double offsetX = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetY = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetZ = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOCHI, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(10).setParticleScale(1.3F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        } 
        for (i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++) {
          double offsetX = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetY = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetZ = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOCHI, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(7).setParticleScale(1.2F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        } 
      } 
      super.onUpdate();
    }
  }
}
