package xyz.pixelatedw.MineMineNoMi3.entities.mobs.bandits;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityBandit extends BanditData {
  public EntityBandit(World world) {
    super(world, new String[] { "bandit1", "bandit2", "bandit3" });
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
    setDoriki(10 + this.worldObj.rand.nextInt(3));
    setBelly(5 + this.worldObj.rand.nextInt(10));
  }
  
  protected void addRandomArmor() {
    Item[] randomSword = { (Item)ListMisc.PirateCutlass, (Item)ListMisc.Knife3 };
    setCurrentItemOrArmor(0, new ItemStack(randomSword[this.rand.nextInt(randomSword.length)]));
  }
  
  public double[] itemOffset() {
    return new double[] { 0.0D, 0.0D, -0.1D };
  }
  
  public int getDorikiPower() {
    return this.worldObj.rand.nextInt(3) + 10;
  }
  
  public int getBellyInPockets() {
    return this.worldObj.rand.nextInt(10) + 1;
  }
  
  protected void dropRareDrop(int i) {
    dropItem(ListMisc.BellyPouch, 1);
  }
}
