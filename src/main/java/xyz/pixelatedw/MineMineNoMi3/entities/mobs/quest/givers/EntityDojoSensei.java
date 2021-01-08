package xyz.pixelatedw.MineMineNoMi3.entities.mobs.quest.givers;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.IQuestGiver;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIGapCloser;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.EntityAIHakiCombat;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.swordsman.EntityAIOTasumaki;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.swordsman.EntityAIYakkodori;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;
import xyz.pixelatedw.MineMineNoMi3.quests.EnumQuestlines;

public class EntityDojoSensei extends EntityNewMob implements IQuestGiver {
  private ItemStack swordStack;
  
  public EntityDojoSensei(World worldIn) {
    super(worldIn, new String[] { "dojosensei1", "dojosensei2", "dojosensei3" });
    this.tasks.addTask(0, (EntityAIBase)new EntityAIHakiCombat(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIYakkodori(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIOTasumaki(this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIGapCloser(this));
    this.tasks.addTask(0, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, false));
    this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
    this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0D));
    this.tasks.addTask(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
    this.tasks.addTask(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
  }
  
  public void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
    setDoriki(50 + this.worldObj.rand.nextInt(5));
    setBelly(10 + this.worldObj.rand.nextInt(50));
    if (!this.worldObj.isRemote) {
      Item[] randomSword = { (Item)ListMisc.NidaiKitetsu, (Item)ListMisc.SandaiKitetsu, (Item)ListMisc.Shusui, (Item)ListMisc.Jitte, (Item)ListMisc.Kikoku, (Item)ListMisc.WadoIchimonji };
      setBusoHaki(true);
      Item sword = randomSword[this.rand.nextInt(randomSword.length)];
      if (sword != null) {
        this.swordStack = new ItemStack(sword);
        this.swordStack.setTagCompound(new NBTTagCompound());
        this.swordStack.stackTagCompound.setInteger("metadata", 1);
      } 
    } 
  }
  
  protected void addRandomArmor() {
    if (this.swordStack != null)
      setCurrentItemOrArmor(0, this.swordStack); 
  }
  
  protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {}
  
  public double[] itemOffset() {
    return new double[] { 0.0D, -0.05D, -0.1D };
  }
  
  protected boolean canDespawn() {
    return true;
  }
  
  public EnumQuestlines getQuestline() {
    return EnumQuestlines.SWORDSMAN_PROGRESSION;
  }
}
