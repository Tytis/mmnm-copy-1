package xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAISharpshooter;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityMarineWithGun extends MarineData {
  public EntityMarineWithGun(World world) {
    super(world, new String[] { "marinegun1", "marinegun2", "marinegun3", "marinegun4", "marinegun5" });
    this.tasks.removeTask(this.entityAIMeleeAttack);
    this.entityAIMeleeAttack = (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 0.0D, false);
    this.tasks.addTask(0, this.entityAIMeleeAttack);
    this.tasks.addTask(0, (EntityAIBase)new EntityAISharpshooter(this, 1.5F, 0));
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
    setDoriki(10 + this.worldObj.rand.nextInt(3));
    setBelly(5 + this.worldObj.rand.nextInt(10));
  }
  
  protected void dropRareDrop(int i) {
    switch (this.rand.nextInt(4)) {
      case 0:
        dropItem(ListMisc.MarineHelm, 1);
        break;
      case 1:
        dropItem(ListMisc.MarineChestplate, 1);
        break;
      case 2:
        dropItem(ListMisc.MarineLeggings, 1);
        break;
      case 3:
        dropItem(ListMisc.MarineBoots, 1);
        break;
    } 
  }
}
