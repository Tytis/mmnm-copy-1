package xyz.pixelatedw.MineMineNoMi3.entities.mobs.baroqueWorks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;

public class EntityMr0 extends PirateData {
  public EntityMr0(World worldIn) {
    super(worldIn);
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(55.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
    ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)this);
    props.setUsedFruit("sunasuna");
    props.setIsLogia(true);
    setDoriki(500 + this.worldObj.rand.nextInt(50));
    setBelly(1000 + this.worldObj.rand.nextInt(100));
  }
}
