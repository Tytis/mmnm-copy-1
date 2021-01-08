package xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityDenDenMushi extends EntityAnimal {
  public EntityDenDenMushi(World world) {
    super(world);
    setSize(0.3F, 0.3F);
    this.tasks.addTask(1, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
    this.tasks.addTask(2, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 2.0D));
    this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
  }
  
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.12D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0D);
  }
  
  public boolean interact(EntityPlayer player) {
    ItemStack heldItem = player.inventory.getCurrentItem();
    if (heldItem != null && heldItem.getItem() == Items.iron_ingot) {
      player.inventory.addItemStackToInventory(new ItemStack(ListMisc.DenDenMushi));
      heldItem.stackSize--;
      setDead();
      return true;
    } 
    return false;
  }
  
  protected void entityInit() {
    super.entityInit();
  }
  
  protected boolean canDespawn() {
    return true;
  }
  
  public boolean getCanSpawnHere() {
    return true;
  }
  
  public EntityAgeable createChild(EntityAgeable p_90011_1_) {
    return null;
  }
}
