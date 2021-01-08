package xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class EntityMorgan extends MarineData {
  private SpecialAttack currentAttack;
  
  private SpecialAttack previousAttack;
  
  public EntityMorgan(World world) {
    super(world);
    this.tasks.addTask(0, new EntityAIMorganChop(this));
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
  }
  
  public int getDorikiPower() {
    return this.worldObj.rand.nextInt(5) + 30;
  }
  
  public int getBellyInPockets() {
    return this.worldObj.rand.nextInt(20) + 100;
  }
  
  public void setCurrentAttackState(SpecialAttack state) {
    this.currentAttack = state;
  }
  
  public SpecialAttack getCurrentAttackState() {
    return this.currentAttack;
  }
  
  public void setPreviousAttackState(SpecialAttack state) {
    this.previousAttack = state;
  }
  
  public SpecialAttack getPreviousAttackState() {
    return this.previousAttack;
  }
  
  public boolean attackEntityAsMob(Entity ent) {
    int i = 2;
    return ent.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), i);
  }
  
  enum SpecialAttack {
    WAIT, CHOP, FISSURE;
  }
  
  class EntityAIMorganChop extends EntityAIBase {
    private EntityMorgan theEntity;
    
    private boolean canUseAttack = true;
    
    private final int ATTACK_MAX_TIMER = 50;
    
    private int attackTimer = 50;
    
    private int whileAttackTimer;
    
    private double[] posToCharge;
    
    public EntityAIMorganChop(EntityMorgan e) {
      this.theEntity = e;
    }
    
    public boolean shouldExecute() {
      if (this.theEntity.getAttackTarget() != null && this.theEntity.getCurrentAttackState() == null && this.theEntity.getDistanceToEntity((Entity)this.theEntity.getAttackTarget()) < 6.0F) {
        if (!this.canUseAttack) {
          if (this.attackTimer > 0) {
            this.attackTimer--;
            return false;
          } 
          return prevAttackCalc();
        } 
        return prevAttackCalc();
      } 
      return false;
    }
    
    public boolean prevAttackCalc() {
      if (this.theEntity.getPreviousAttackState() == EntityMorgan.SpecialAttack.CHOP) {
        if (this.theEntity.rand.nextFloat() <= 0.5F)
          return true; 
        return false;
      } 
      return true;
    }
    
    public boolean continueExecuting() {
      boolean flag = this.canUseAttack;
      if (!flag) {
        this.theEntity.setPreviousAttackState(this.theEntity.getCurrentAttackState());
        this.theEntity.setCurrentAttackState((EntityMorgan.SpecialAttack)null);
      } 
      return flag;
    }
    
    public void startExecuting() {
      this.canUseAttack = true;
      this.attackTimer = 50;
      this.whileAttackTimer = 0;
      this.theEntity.setCurrentAttackState(EntityMorgan.SpecialAttack.CHOP);
    }
    
    public void updateTask() {
      if (this.theEntity.getAttackTarget() != null && this.canUseAttack) {
        this.whileAttackTimer++;
        System.out.println("chop - " + this.whileAttackTimer);
        for (Entity t : WyHelper.getEntitiesNear((Entity)this.theEntity, 1.8D)) {
          t.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.theEntity), 10.0F);
          System.out.println("CHOP ATTACK");
        } 
        if (this.whileAttackTimer > 12)
          this.canUseAttack = false; 
      } 
    }
  }
}
