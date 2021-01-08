package xyz.pixelatedw.MineMineNoMi3.entities.mobs.animals;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.INBTEntity;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketEntityNBTSync;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketParticles;

public class EntityKungFuDugong extends EntityMob implements INBTEntity, IEntityOwnable {
  private Item[] food = new Item[] { Items.cooked_beef, Items.cooked_chicken, Items.cooked_fished, Items.cooked_porkchop };
  
  private boolean isHappy;
  
  private boolean isTamed;
  
  private boolean isWaiting;
  
  private boolean isEnraged;
  
  private boolean isTraining;
  
  private EntityPlayer owner;
  
  private UUID ownerUUID;
  
  public EntityKungFuDugong(World world) {
    super(world);
    this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
    this.tasks.addTask(0, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, false));
    this.tasks.addTask(1, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
    this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    this.tasks.addTask(2, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0D));
    this.tasks.addTask(3, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
    this.targetTasks.addTask(0, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
  }
  
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
  }
  
  public void onEntityUpdate() {
    super.onEntityUpdate();
    if (!this.worldObj.isRemote) {
      boolean flagOwner = (getOwner() != null && getDistanceToEntity((Entity)getOwner()) < 10.0F);
      boolean flagTamed = isTamed();
      boolean flagHasNoTarget = (getAttackTarget() == null);
      boolean flagWaiting = (flagHasNoTarget && isWaiting());
      boolean flagHealth = (getHealth() > getMaxHealth() / 3.0F);
      if (flagOwner && flagTamed && flagWaiting && flagHealth) {
        this.isHappy = true;
      } else {
        this.isHappy = false;
      } 
      if (flagHasNoTarget && this.ticksExisted % 250 == 0) {
        this.isTraining = !this.isTraining;
        updateNBT();
      } 
      if (this.ticksExisted % 100 == 0)
        updateNBT(); 
      if (flagWaiting || isTraining())
        getNavigator().clearPathEntity(); 
      if (getAttackTarget() == this.owner)
        setAttackTarget(null); 
      if (this.owner != null) {
        if (getDistanceToEntity((Entity)this.owner) > 10.0F)
          getNavigator().tryMoveToEntityLiving((Entity)this.owner, 1.5D); 
        if (getDistanceToEntity((Entity)this.owner) > 80.0F)
          setPositionAndUpdate(this.owner.posX, this.owner.posY, this.owner.posZ); 
      } 
    } 
  }
  
  public boolean isAIEnabled() {
    return true;
  }
  
  public void updateNBT() {
    NBTTagCompound nbtClone = new NBTTagCompound();
    writeEntityToNBT(nbtClone);
    if (!this.worldObj.isRemote)
      WyNetworkHelper.sendToAll((IMessage)new PacketEntityNBTSync(getEntityId(), nbtClone)); 
  }
  
  public void writeEntityToNBT(NBTTagCompound nbt) {
    super.writeEntityToNBT(nbt);
    nbt.setBoolean("IsTamed", this.isTamed);
    nbt.setBoolean("IsWaiting", this.isWaiting);
    nbt.setBoolean("IsHappy", this.isHappy);
    nbt.setBoolean("IsEnraged", this.isEnraged);
    nbt.setBoolean("IsTraining", this.isTraining);
    nbt.setString("OwnerUUID", (this.ownerUUID != null) ? this.ownerUUID.toString() : "");
  }
  
  public void readEntityFromExtraNBT(NBTTagCompound nbt) {
    readEntityFromNBT(nbt);
  }
  
  public void readEntityFromNBT(NBTTagCompound nbt) {
    super.readEntityFromNBT(nbt);
    this.isTamed = nbt.getBoolean("IsTamed");
    this.isWaiting = nbt.getBoolean("IsWaiting");
    this.isHappy = nbt.getBoolean("IsHappy");
    this.isEnraged = nbt.getBoolean("IsEnraged");
    this.isTraining = nbt.getBoolean("IsTraining");
    String uuid = nbt.getString("OwnerUUID");
    if (!WyHelper.isNullOrEmpty(uuid)) {
      this.ownerUUID = UUID.fromString(uuid);
      this.owner = this.worldObj.func_152378_a(this.ownerUUID);
      this.isTamed = true;
    } 
  }
  
  public boolean attackEntityFrom(DamageSource damageSource, float amount) {
    super.attackEntityFrom(damageSource, amount);
    Entity entity = damageSource.getEntity();
    if (isTamed())
      return true; 
    if (entity instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)entity;
      IAttributeInstance attackDamage = getEntityAttribute(SharedMonsterAttributes.attackDamage);
      UUID rageModeUUID = UUID.fromString("d760dc58-8275-4ef6-ae34-d197a879c099");
      AttributeModifier attributeModifier = new AttributeModifier(rageModeUUID, "Rage Mode", 8.0D, 0);
      if (player.getHeldItem() != null) {
        if (attackDamage.getModifier(rageModeUUID) == null) {
          attackDamage.applyModifier(attributeModifier);
          this.isEnraged = true;
          updateNBT();
        } 
        WyNetworkHelper.sendToAll((IMessage)new PacketParticles("aboveHeadAngry", this.posX, this.posY + 1.0D, this.posZ));
      } else if (!isEnraged() && getHealth() < getMaxHealth() / 2.0F) {
        WyNetworkHelper.sendToAll((IMessage)new PacketParticles("aboveHeadHappy", this.posX, this.posY + 0.5D, this.posZ));
        setOwner(player);
        updateNBT();
      } 
    } 
    return true;
  }
  
  public boolean interact(EntityPlayer player) {
    ItemStack heldStack = player.getHeldItem();
    if (isTamed() && player == this.owner) {
      if (heldStack != null && getHealth() < getMaxHealth()) {
        Optional<Item> foodItem = Arrays.<Item>stream(this.food).filter(x -> (heldStack.getItem() == x)).findFirst();
        if (foodItem != null) {
          heldStack.stackSize--;
          heal(4.0F);
          for (int i = 0; i < 5; i++) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(EnumParticleTypes.HEART.getParticleName(), this.posX + (this.rand.nextFloat() * this.width * 2.0F) - this.width, this.posY + 0.5D + (this.rand.nextFloat() * this.height), this.posZ + (this.rand.nextFloat() * this.width * 2.0F) - this.width, d0, d1, d2);
          } 
          return true;
        } 
      } 
      this.isWaiting = !this.isWaiting;
      updateNBT();
    } 
    return false;
  }
  
  protected void dropFewItems(boolean flag, int looting) {
    int j = (int)(1.0D + WyMathHelper.randomWithRange(0 + looting, 1 + looting));
    for (int k = 0; k < j; k++) {
      if (isBurning()) {
        dropItem(Items.cooked_fished, 1);
      } else {
        dropItem(Items.fish, 1);
      } 
    } 
  }
  
  public boolean isHappy() {
    return this.isHappy;
  }
  
  public boolean isTamed() {
    return this.isTamed;
  }
  
  public boolean isWaiting() {
    return this.isWaiting;
  }
  
  public boolean isEnraged() {
    return this.isEnraged;
  }
  
  public boolean isTraining() {
    return this.isTraining;
  }
  
  private void setOwner(EntityPlayer player) {
    this.owner = player;
    this.ownerUUID = player.getPersistentID();
    this.isTamed = true;
  }
  
  public EntityPlayer getOwner() {
    return this.owner;
  }
  
  protected boolean canDespawn() {
    if (isTamed())
      return false; 
    return true;
  }
  
  public String func_152113_b() {
    if (this.ownerUUID != null)
      return this.ownerUUID.toString(); 
    return "";
  }
}
