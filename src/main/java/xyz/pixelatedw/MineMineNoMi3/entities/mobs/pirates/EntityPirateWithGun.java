package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.EntityAISharpshooter;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityPirateWithGun extends PirateData {
  public EntityPirateWithGun(World world) {
    super(world, new String[] { "pirategun1", "pirategun2", "pirategun3", "pirategun4", "pirategun5" });
    this.tasks.removeTask(this.entityAIMeleeAttack);
    this.entityAIMeleeAttack = (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 0.0D, false);
    this.tasks.addTask(0, this.entityAIMeleeAttack);
    this.tasks.addTask(0, (EntityAIBase)new EntityAISharpshooter(this, 1.7F, 0));
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
        dropItem(ListMisc.PirateChestplate, 1);
        break;
      case 1:
        dropItem(ListMisc.PirateLeggings, 1);
        break;
      case 2:
        dropItem(ListMisc.PirateBoots, 1);
        break;
    } 
  }
}
