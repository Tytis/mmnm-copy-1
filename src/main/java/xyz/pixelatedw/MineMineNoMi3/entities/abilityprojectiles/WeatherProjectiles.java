package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.particles.EntityParticleFX;
import xyz.pixelatedw.MineMineNoMi3.helpers.DevilFruitsHelper;
import xyz.pixelatedw.MineMineNoMi3.helpers.ItemsHelper;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class WeatherProjectiles {
  public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
  
  static {
    abilitiesClassesArray.add(new Object[] { HeatBall.class, ListAttributes.HEAT_BALL });
    abilitiesClassesArray.add(new Object[] { CoolBall.class, ListAttributes.COOL_BALL });
    abilitiesClassesArray.add(new Object[] { ThunderBall.class, ListAttributes.THUNDER_BALL });
    abilitiesClassesArray.add(new Object[] { GustSword.class, ListAttributes.GUST_SWORD });
    abilitiesClassesArray.add(new Object[] { WeatherEgg.class, ListAttributes.WEATHER_EGG });
    abilitiesClassesArray.add(new Object[] { EntityWeatherCloud.class, ListExtraAttributes.WEATHER_CLOUD });
  }
  
  public static class WeatherEgg extends WeatherBall {
    public WeatherEgg(World world) {
      super(world);
    }
    
    public WeatherEgg(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public WeatherEgg(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
      this.weaponUsed = (player.getHeldItem() != null) ? player.getHeldItem().getItem() : null;
    }
    
    public void setDead() {
      if (!this.worldObj.isRemote) {
        WeatherProjectiles.EntityWeatherCloud weatherCloud = new WeatherProjectiles.EntityWeatherCloud(this.worldObj);
        weatherCloud.setLife(200);
        weatherCloud.setThrower((EntityPlayer)getThrower());
        weatherCloud.setPositionAndRotation(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
        this.worldObj.spawnEntityInWorld(weatherCloud);
      } 
      super.setDead();
    }
  }
  
  public static class GustSword extends AbilityProjectile {
    public GustSword(World world) {
      super(world);
    }
    
    public GustSword(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public GustSword(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void onUpdate() {
      if (this.worldObj.isRemote)
        for (int i = 0; i < DevilFruitsHelper.getParticleSettingModifier(5); i++) {
          double offsetX = WyMathHelper.randomDouble() / 4.0D;
          double offsetY = WyMathHelper.randomDouble() / 4.0D;
          double offsetZ = WyMathHelper.randomDouble() / 4.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU2, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.009999999776482582D, 0.0D)).setParticleAge(2).setParticleScale(1.0F);
          particle.setAlphaF(0.5F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
          particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.009999999776482582D, 0.0D)).setParticleAge(2).setParticleScale(1.0F);
          particle.setAlphaF(0.7F);
          MainMod.proxy.spawnCustomParticles((Entity)this, particle);
        }  
      super.onUpdate();
    }
    
    public void tasksImapct(MovingObjectPosition hit) {
      if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase) {
        double mX = (-MathHelper.sin((getThrower()).rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos((getThrower()).rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double mZ = (MathHelper.cos((getThrower()).rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos((getThrower()).rotationPitch / 180.0F * 3.1415927F)) * 0.4D;
        double f2 = MathHelper.sqrt_double(mX * mX + (getThrower()).motionY * (getThrower()).motionY + mZ * mZ);
        mX /= f2;
        mZ /= f2;
        mX += (getThrower()).worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mZ += (getThrower()).worldObj.rand.nextGaussian() * 0.007499999832361937D * 1.0D;
        mX *= 2.0D;
        mZ *= 2.0D;
        hit.entityHit.motionX = mX;
        hit.entityHit.motionZ = mZ;
      } 
    }
  }
  
  public static class ThunderBall extends WeatherBall {
    public ThunderBall(World world) {
      super(world);
    }
    
    public ThunderBall(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public ThunderBall(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
      this.weaponUsed = (player.getHeldItem() != null) ? player.getHeldItem().getItem() : null;
    }
  }
  
  public static class CoolBall extends WeatherBall {
    public CoolBall(World world) {
      super(world);
    }
    
    public CoolBall(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public CoolBall(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
      this.weaponUsed = (player.getHeldItem() != null) ? player.getHeldItem().getItem() : null;
    }
    
    public void onUpdate() {
      super.onUpdate();
      if (!this.worldObj.isRemote) {
        List weatherBallsNear = WyHelper.getEntitiesNear((Entity)this, new double[] { 4.0D, 1.0D, 4.0D }, new Class[] { WeatherProjectiles.WeatherBall.class });
        if (weatherBallsNear.size() > 0 && this.ticksExisted > 100) {
          List<WeatherProjectiles.HeatBall> heatBalls = (List<WeatherProjectiles.HeatBall>)weatherBallsNear.stream().filter(x -> {
                WeatherProjectiles.WeatherBall ball = (WeatherProjectiles.WeatherBall)x;
                return ball instanceof WeatherProjectiles.HeatBall;
              }).collect(Collectors.toList());
          if (heatBalls.size() > 0) {
            WeatherProjectiles.EntityWeatherCloud weatherCloud = new WeatherProjectiles.EntityWeatherCloud(this.worldObj);
            weatherCloud.setThrower((EntityPlayer)getThrower());
            weatherCloud.setPositionAndRotation(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
            weatherCloud.addWeatherBall(this);
            for (WeatherProjectiles.HeatBall hb : heatBalls) {
              weatherCloud.addWeatherBall(hb);
              hb.setDead();
            } 
            this.worldObj.spawnEntityInWorld(weatherCloud);
            if (getThrower() != null)
              DevilFruitsHelper.sendShounenScream((EntityPlayer)getThrower(), "Thunderbolt Tempo", 0); 
            setDead();
          } 
        } 
      } 
    }
  }
  
  public static class HeatBall extends WeatherBall {
    public HeatBall(World world) {
      super(world);
    }
    
    public HeatBall(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public HeatBall(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
      this.weaponUsed = (player.getHeldItem() != null) ? player.getHeldItem().getItem() : null;
    }
  }
  
  public static class WeatherBall extends AbilityProjectile {
    protected Item weaponUsed;
    
    public WeatherBall(World world) {
      super(world);
    }
    
    public WeatherBall(World world, double x, double y, double z) {
      super(world, x, y, z);
    }
    
    public WeatherBall(World world, EntityLivingBase player, AbilityAttribute attr) {
      super(world, player, attr);
    }
    
    public void onUpdate() {
      super.onUpdate();
      this.motionX /= 1.5D;
      this.motionZ /= 1.5D;
      if (this.ticksExisted < 100) {
        this.motionY = 0.25D;
      } else {
        this.motionY = 0.0D;
      } 
    }
    
    public Item getWeaponUsed() {
      return this.weaponUsed;
    }
  }
  
  public static class EntityMirageTempoCloud extends ExtraProjectiles.EntityCloud {
    public EntityMirageTempoCloud(World world) {
      super(world);
    }
    
    public void onUpdate() {
      super.onUpdate();
      WyNetworkHelper.sendToAllAround((IMessage)new PacketParticles("kemuriBoshi", this.posX, this.posY, this.posZ), this.dimension, this.posX, this.posY, this.posZ, 128.0D);
    }
  }
  
  public static class EntityWeatherCloud extends Entity {
    private int life = 300;
    
    private EntityPlayer thrower;
    
    private List<WeatherProjectiles.WeatherBall> weatherBalls = new ArrayList<>();
    
    private boolean charged = false;
    
    private boolean superCharged = false;
    
    public EntityWeatherCloud(World world) {
      super(world);
    }
    
    public void onUpdate() {
      if (this.worldObj.isRemote)
        for (int i = 0; i < 100; i++) {
          double offsetX = WyMathHelper.randomWithRange(-12, 12) + WyMathHelper.randomDouble() * 7.0D;
          double offsetY = WyMathHelper.randomWithRange(-2, 0) + WyMathHelper.randomDouble();
          double offsetZ = WyMathHelper.randomWithRange(-12, 12) + WyMathHelper.randomDouble() * 7.0D;
          EntityParticleFX particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_GORO2, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.0D, 0.0D)).setParticleAge(20 + (new Random()).nextInt(5)).setParticleScale(15.0F).setParticleGravity(-0.75F);
          MainMod.proxy.spawnCustomParticles(this, particle);
          particle = (new EntityParticleFX(this.worldObj, ID.PARTICLE_ICON_MOKU2, this.posX + offsetX + WyMathHelper.randomDouble(), this.posY + offsetY + WyMathHelper.randomDouble(), this.posZ + offsetZ + WyMathHelper.randomDouble(), 0.0D, 0.0D, 0.0D)).setParticleAge(25 + (new Random()).nextInt(5)).setParticleScale(15.0F).setParticleGravity(-0.75F);
          MainMod.proxy.spawnCustomParticles(this, particle);
        }  
      super.onUpdate();
      if (!this.worldObj.isRemote) {
        if (this.life <= 0 || getThrower() == null)
          setDead(); 
        this.life--;
        if (this.charged) {
          List<EntityLivingBase> targets = WyHelper.getEntitiesNear(this, new double[] { 15.0D, 50.0D, 15.0D }, new Class[] { EntityLivingBase.class });
          targets.remove(getThrower());
          int thunderTimer = this.superCharged ? 30 : 50;
          for (EntityLivingBase entity : targets) {
            if (entity.posY <= this.posY)
              if (this.ticksExisted % thunderTimer == 0) {
                WyNetworkHelper.sendTo((IMessage)new PacketPlayer("ElThorThunder", entity.posX, entity.posY, entity.posZ), (EntityPlayerMP)getThrower());
                EntityLightningBolt thunder = new EntityLightningBolt(this.worldObj, entity.posX, entity.posY, entity.posZ);
                AbilityExplosion exp = WyHelper.newExplosion(this, entity.posX, entity.posY, entity.posZ, 1.0D);
                exp.setFireAfterExplosion(false);
                exp.setDestroyBlocks(false);
                exp.setSmokeParticles("");
                exp.doExplosion();
                this.worldObj.spawnEntityInWorld((Entity)thunder);
                if (!this.superCharged)
                  break; 
              }  
          } 
        } 
        int perfectThunderBallsIn = (int)this.weatherBalls.stream().filter(x -> (x instanceof WeatherProjectiles.ThunderBall && ItemsHelper.getClimaTactLevel(x.getWeaponUsed()) >= 2)).count();
        if (perfectThunderBallsIn >= 2 && !this.superCharged) {
          this.superCharged = true;
          DevilFruitsHelper.sendShounenScream(getThrower(), "Thunderstorm Tempo", 0);
        } 
        List weatherBallsNear = WyHelper.getEntitiesNear(this, new double[] { 15.0D, 6.0D, 15.0D }, new Class[] { WeatherProjectiles.WeatherBall.class });
        if (weatherBallsNear.size() > 0) {
          List<WeatherProjectiles.ThunderBall> thunderBalls = (List<WeatherProjectiles.ThunderBall>)weatherBallsNear.stream().filter(x -> {
                WeatherProjectiles.WeatherBall ball = (WeatherProjectiles.WeatherBall)x;
                return ball instanceof WeatherProjectiles.ThunderBall;
              }).collect(Collectors.toList());
          if (thunderBalls.size() > 0)
            for (WeatherProjectiles.ThunderBall tb : thunderBalls) {
              this.life += 50;
              this.weatherBalls.add(tb);
              this.charged = true;
              tb.setDead();
            }  
          List<WeatherProjectiles.CoolBall> coolBalls = (List<WeatherProjectiles.CoolBall>)weatherBallsNear.stream().filter(x -> {
                WeatherProjectiles.WeatherBall ball = (WeatherProjectiles.WeatherBall)x;
                return (ball instanceof WeatherProjectiles.CoolBall && ItemsHelper.getClimaTactLevel(ball.getWeaponUsed()) >= 2);
              }).collect(Collectors.toList());
          if (coolBalls.size() >= 2) {
            DevilFruitsHelper.sendShounenScream(getThrower(), "Rain Tempo", 0);
            WorldInfo worldinfo = (MinecraftServer.getServer()).worldServers[0].getWorldInfo();
            worldinfo.setRaining(true);
            for (WeatherProjectiles.CoolBall cb : coolBalls) {
              this.life += 100;
              cb.setDead();
            } 
            setDead();
          } 
        } 
      } 
    }
    
    public boolean isCharged() {
      return this.charged;
    }
    
    public boolean isSuperCharged() {
      return this.superCharged;
    }
    
    public void addWeatherBall(WeatherProjectiles.WeatherBall ball) {
      this.weatherBalls.add(ball);
    }
    
    public EntityPlayer getThrower() {
      return this.thrower;
    }
    
    public void setThrower(EntityPlayer player) {
      this.thrower = player;
    }
    
    public int getLife() {
      return this.life;
    }
    
    public void setLife(int life) {
      this.life = life;
    }
    
    protected void entityInit() {}
    
    protected void readEntityFromNBT(NBTTagCompound nbt) {}
    
    protected void writeEntityToNBT(NBTTagCompound nbt) {}
  }
}
