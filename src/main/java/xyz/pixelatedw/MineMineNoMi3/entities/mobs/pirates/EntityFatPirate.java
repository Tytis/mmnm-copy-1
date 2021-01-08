package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIGapCloser;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIHakiCombat;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIKnockback;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.brawler.EntityAIHakaiHo;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityFatPirate extends PirateData {
  private ItemStack swordStack;
  
  public EntityFatPirate(World world) {
    super(world, new String[] { "fatpirate1", "fatpirate2" });
    setSize(0.7F, 2.5F);
    this.tasks.addTask(0, (EntityAIBase)new EntityAIHakiCombat(this));
    this.tasks.addTask(1, (EntityAIBase)(new EntityAIGapCloser(this)).setSpeed(1.1D).setMaxCounter(5));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIKnockback(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIHakaiHo(this));
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
    setDoriki(15 + this.worldObj.rand.nextInt(15));
    setBelly(10 + this.worldObj.rand.nextInt(20));
    if (!this.worldObj.isRemote) {
      Item[] randomSword = { (Item)ListMisc.MarineSword, null };
      if (this.rand.nextInt(100) <= 20) {
        setBusoHaki(true);
        Item sword = randomSword[this.rand.nextInt(randomSword.length)];
        if (sword != null) {
          this.swordStack = new ItemStack(sword);
          this.swordStack.setTagCompound(new NBTTagCompound());
          this.swordStack.stackTagCompound.setInteger("metadata", 1);
        } 
      } else {
        Item sword = randomSword[this.rand.nextInt(randomSword.length)];
        if (sword != null)
          this.swordStack = new ItemStack(sword); 
      } 
    } 
  }
  
  protected void addRandomArmor() {
    if (this.rand.nextInt(10) <= 2)
      setCurrentItemOrArmor(0, new ItemStack((Item)ListMisc.Mace)); 
  }
  
  public double[] itemOffset() {
    return new double[] { -0.2D, 0.0D, -0.1D };
  }
}
