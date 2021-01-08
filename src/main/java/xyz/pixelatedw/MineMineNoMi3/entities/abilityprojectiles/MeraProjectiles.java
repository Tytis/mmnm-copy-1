package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class MeraProjectiles {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { Hiken.class, ListAttributes.HIKEN });
    abilitiesClassesArray.add(new Object[] { Higan.class, ListAttributes.HIGAN });
    abilitiesClassesArray.add(new Object[] { DaiEnkaiEntei.class, ListAttributes.DAI_ENKAI_ENTEI });
    abilitiesClassesArray.add(new Object[] { Hidaruma.class, ListAttributes.HIDARUMA });
    abilitiesClassesArray.add(new Object[] { Jujika.class, ListAttributes.JUJIKA });
  }
  
  public static class Hiken extends AbilityProjectile {
    private Random r = new Random();
    
    public Hiken(World world) {
      super(world);
    }
    
    public Hiken(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Hiken(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void onUpdate() {
      if (this.worldObj.isRemote) {
        int i;
        for (i = 0; i < DevilFruitsHelper.getParticleSettingModifier(25); i++) {
          double offsetX = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetY = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetZ = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MERA, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(10).setParticleScale(1.3F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        } 
        for (i = 0; i < DevilFruitsHelper.getParticleSettingModifier(2); i++) {
          double offsetX = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetY = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          double offsetZ = ((new Random()).nextInt(50) + 1.0D - 25.0D) / 30.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(7).setParticleScale(1.2F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        } 
      } 
      super.onUpdate();
    }
  }
  
  public static class Higan extends AbilityProjectile {
    public Higan(World world) {
      super(world);
    }
    
    public Higan(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Higan(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {}
    
    public void onUpdate() {
      if (this.worldObj.isRemote) {
        double posXOffset = this.worldObj.rand.nextGaussian() * 0.42D;
        double posYOffset = this.worldObj.rand.nextGaussian() * 0.22D;
        double posZOffset = this.worldObj.rand.nextGaussian() * 0.42D;
        EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MERA, this.posX + posXOffset, this.posY + posYOffset, this.posZ + posZOffset, 0.0D, 0.0D, 0.0D)).setParticleAge(6).setParticleScale(0.7F);
        MainMod.proxy.spawnCustomParticles((Entity)this, particle);
      } 
      super.onUpdate();
    }
  }
  
  public static class DaiEnkaiEntei extends AbilityProjectile {
    public DaiEnkaiEntei(World world) {
      super(world);
    }
    
    public DaiEnkaiEntei(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public DaiEnkaiEntei(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void onUpdate() {
      if (this.worldObj.isRemote) {
        int i;
        for (i = 0; i < DevilFruitsHelper.getParticleSettingModifier(75); i++) {
          double offsetX = ((new Random()).nextInt(40) + 2.0D - 20.0D) / 10.0D;
          double offsetY = ((new Random()).nextInt(40) + 2.0D - 20.0D) / 10.0D;
          double offsetZ = ((new Random()).nextInt(40) + 2.0D - 20.0D) / 10.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MERA, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(10).setParticleScale(1.3F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        } 
        for (i = 0; i < DevilFruitsHelper.getParticleSettingModifier(10); i++) {
          double offsetX = ((new Random()).nextInt(40) + 2.0D - 20.0D) / 10.0D;
          double offsetY = ((new Random()).nextInt(40) + 2.0D - 20.0D) / 10.0D;
          double offsetZ = ((new Random()).nextInt(40) + 2.0D - 20.0D) / 10.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(7).setParticleScale(1.1F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        } 
      } 
      super.onUpdate();
    }
  }
  
  public static class Hidaruma extends AbilityProjectile {
    public Hidaruma(World world) {
      super(world);
    }
    
    public Hidaruma(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Hidaruma(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      if (hit.entityHit != null)
        hit.entityHit.setFire(this.ticks); 
    }
    
    public void onUpdate() {
      for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(25); i++) {
        double offsetX = ((new Random()).nextInt(10) + 1.0D - 5.0D) / 10.0D;
        double offsetY = ((new Random()).nextInt(10) + 1.0D - 5.0D) / 10.0D;
        double offsetZ = ((new Random()).nextInt(10) + 1.0D - 5.0D) / 10.0D;
        this.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY.getParticleName(), this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.05D, 0.0D);
      } 
      super.onUpdate();
    }
  }
  
  public static class Jujika extends AbilityProjectile {
    public Jujika(World world) {
      super(world);
    }
    
    public Jujika(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public Jujika(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      if (hit.entityHit != null) {
        hit.entityHit.setFire(this.ticks);
        if (MainConfig.enableGriefing)
          for (int j = -2; j <= 2; j++) {
            int i;
            for (i = -5; i <= 5; i++) {
              if (this.worldObj.isAirBlock((int)hit.entityHit.posX + i, (int)hit.entityHit.posY + j, (int)hit.entityHit.posZ))
                this.worldObj.setBlock((int)hit.entityHit.posX + i, (int)hit.entityHit.posY + j, (int)hit.entityHit.posZ, (Block)Blocks.fire); 
            } 
            for (i = -5; i <= 5; i++) {
              if (this.worldObj.isAirBlock((int)hit.entityHit.posX, (int)hit.entityHit.posY + j, (int)hit.entityHit.posZ + i))
                this.worldObj.setBlock((int)hit.entityHit.posX, (int)hit.entityHit.posY + j, (int)hit.entityHit.posZ + i, (Block)Blocks.fire); 
            } 
          }  
      } 
      if (MainConfig.enableGriefing)
        for (int j = -2; j <= 2; j++) {
          int i;
          for (i = -5; i <= 5; i++) {
            if (this.worldObj.isAirBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ))
              this.worldObj.setBlock((int)this.posX + i, (int)this.posY + j, (int)this.posZ, (Block)Blocks.fire); 
          } 
          for (i = -5; i <= 5; i++) {
            if (this.worldObj.isAirBlock((int)this.posX, (int)this.posY + j, (int)this.posZ + i))
              this.worldObj.setBlock((int)this.posX, (int)this.posY + j, (int)this.posZ + i, (Block)Blocks.fire); 
          } 
        }  
    }
  }
}
