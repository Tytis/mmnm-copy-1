package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIGapCloser;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIHakiCombat;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.brawler.EntityAIHakaiHo;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.swordsman.EntityAIOTasumaki;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.swordsman.EntityAIYakkodori;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class EntityPirateCaptain extends PirateData {
  private ItemStack swordStack;
  
  public EntityPirateCaptain(World world) {
    super(world, new String[] { "piratec1", "piratec2", "piratec3", "piratec4", "piratec5" });
    this.tasks.addTask(0, (EntityAIBase)new EntityAIHakiCombat(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIYakkodori(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIOTasumaki(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIGapCloser(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIHakaiHo(this));
    addRokushikiAbilities(2);
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
    if (!this.worldObj.isRemote) {
      Item[] randomSword = { (Item)ListMisc.PirateCutlass, null };
      if (this.rand.nextInt(100) <= 60) {
        setBusoHaki(true);
        this.threat += 20;
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
    if (this.swordStack != null)
      setCurrentItemOrArmor(0, this.swordStack); 
    if (!this.worldObj.isRemote) {
      setDoriki(15 + this.worldObj.rand.nextInt(50) + this.threat);
      setBelly(20 + this.worldObj.rand.nextInt(20) + this.threat / 2);
    } 
  }
  
  public double[] itemOffset() {
    return new double[] { 0.0D, 0.0D, -0.1D };
  }
}
