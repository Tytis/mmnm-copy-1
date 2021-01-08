package xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.objectives;

import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntitySniperTarget extends EntityMob implements IQuestObjective {
  private EntityPlayer owner;
  
  private boolean active = false;
  
  public EntitySniperTarget(World world) {
    super(world);
    this.experienceValue = 0;
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
  }
  
  protected void entityInit() {
    super.entityInit();
  }
  
  protected boolean isAIEnabled() {
    return false;
  }
  
  public void onEntityUpdate() {
    this.motionY /= 1.5D + this.worldObj.rand.nextDouble();
    this.fallDistance = 0.0F;
    if (this.onGround && !this.worldObj.isRemote)
      setDead(); 
    if (isInWater() || isInsideOfMaterial(Material.lava))
      setDead(); 
    super.onEntityUpdate();
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
