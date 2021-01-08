package xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives.IQuestObjective;

public class BanditData extends EntityNewMob implements IQuestObjective {
  protected EntityAIBase entityAIMeleeAttack = (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, false);
  
  private EntityAIBase entityAIAttackNonMarine = (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true);
  
  private EntityPlayer owner;
  
  private boolean active = false;
  
  public BanditData(World world) {
    this(world, (String[])null);
  }
  
  public BanditData(World world, String[] textures) {
    super(world, textures);
    getNavigator().setBreakDoors(true);
    getNavigator().setAvoidsWater(true);
    this.tasks.addTask(0, this.entityAIMeleeAttack);
    this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
    this.tasks.addTask(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
    this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
    this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, PirateData.class, 0, true));
    this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, MarineData.class, 0, true));
  }
  
  public void onEntityUpdate() {
    if (getAttackTarget() == null) {
      this.targetTasks.removeTask(this.entityAIAttackNonMarine);
      for (EntityLivingBase target : WyHelper.getEntitiesNear((Entity)this, 20.0D)) {
        if (target instanceof EntityPlayer) {
          EntityPlayer targetP = (EntityPlayer)target;
          ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)targetP);
          setTarget((Entity)targetP);
          this.targetTasks.addTask(1, this.entityAIAttackNonMarine);
        } 
      } 
    } 
    super.onEntityUpdate();
  }
  
  protected boolean isValidLightLevel() {
    return true;
  }
  
  protected boolean canDespawn() {
    return true;
  }
  
  public boolean isAIEnabled() {
    return true;
  }
  
  public boolean getCanSpawnHere() {
    return true;
  }
  
  public void setOwner(EntityPlayer player) {
    this.owner = player;
  }
  
  public EntityPlayer getOwner() {
    return this.owner;
  }
  
  public boolean isActive() {
    return this.active;
  }
  
  public void setActive(boolean active) {
    this.active = active;
  }
}
