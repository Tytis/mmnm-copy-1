package xyz.pixelatedw.MineMineNoMi3.entities.mobs;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki.EntityAIGeppo;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki.EntityAIRankyaku;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki.EntityAISoru;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki.EntityAITekkai;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketEntityNBTSync;

public class EntityNewMob extends EntityMob implements IDynamicRenderer, INBTEntity {
  protected String[] textures;
  
  private int doriki;
  
  private int belly;
  
  private int textureId;
  
  private int state;
  
  private boolean hasBusoHaki;
  
  private EntityAIBase currentAI;
  
  private EntityAIBase previousAI;
  
  protected int threat;
  
  public EntityNewMob(World worldIn) {
    this(worldIn, (String[])null);
  }
  
  public EntityNewMob(World worldIn, String[] textures) {
    super(worldIn);
    addRandomArmor();
    this.textures = textures;
  }
  
  protected void addRandomArmor() {}
  
  public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
    super.onSpawnWithEgg(data);
    addRandomArmor();
    if (this.textures != null && this.textures.length > 0)
      setTexture(this.rand.nextInt(this.textures.length)); 
    return data;
  }
  
  protected void entityInit() {
    super.entityInit();
    this.dataWatcher.addObject(15, Integer.valueOf(this.textureId));
  }
  
  public void writeEntityToNBT(NBTTagCompound nbt) {
    super.writeEntityToNBT(nbt);
    nbt.setInteger("Texture", getTextureId());
    nbt.setInteger("Doriki", this.doriki);
    nbt.setInteger("Belly", this.belly);
    nbt.setBoolean("HasBusoHaki", this.hasBusoHaki);
  }
  
  public void readEntityFromExtraNBT(NBTTagCompound nbt) {
    readEntityFromNBT(nbt);
  }
  
  public void readEntityFromNBT(NBTTagCompound nbt) {
    super.readEntityFromNBT(nbt);
    setTexture(nbt.getInteger("Texture"));
    this.doriki = nbt.getInteger("Doriki");
    this.belly = nbt.getInteger("Belly");
    this.hasBusoHaki = nbt.getBoolean("HasBusoHaki");
  }
  
  public void updateNBT() {
    NBTTagCompound nbtClone = new NBTTagCompound();
    writeEntityToNBT(nbtClone);
    if (!this.worldObj.isRemote)
      WyNetworkHelper.sendToAll((IMessage)new PacketEntityNBTSync(getEntityId(), nbtClone)); 
  }
  
  protected boolean isValidLightLevel() {
    return true;
  }
  
  protected boolean canDespawn() {
    return true;
  }
  
  public boolean isAIEnabled() {
    return true;
  }
  
  public boolean getCanSpawnHere() {
    return true;
  }
  
  public String getTexture() {
    return this.textures[getTextureId()];
  }
  
  public int getTextureId() {
    return this.dataWatcher.getWatchableObjectInt(15);
  }
  
  protected void setTexture(int texture) {
    this.dataWatcher.updateObject(15, Integer.valueOf(texture));
  }
  
  public int getDoriki() {
    return this.doriki;
  }
  
  public void setDoriki(int value) {
    this.doriki = value;
  }
  
  public int getBelly() {
    return this.belly;
  }
  
  public void setBelly(int value) {
    this.belly = value;
  }
  
  public boolean hasBusoHaki() {
    return this.hasBusoHaki;
  }
  
  public void setBusoHaki(boolean value) {
    this.hasBusoHaki = value;
  }
  
  public EntityAIBase getCurrentAI() {
    return this.currentAI;
  }
  
  public EntityAIBase getPreviousAI() {
    return this.previousAI;
  }
  
  public void setCurrentAI(EntityAIBase ai) {
    this.currentAI = ai;
  }
  
  public void setPreviousAI(EntityAIBase ai) {
    this.previousAI = ai;
  }
  
  public void addRokushikiAbilities(int max) {
    if (this.worldObj.isRemote)
      return; 
    int rokushikiCount = 0;
    boolean hasSoru = false;
    boolean hasTekkai = false;
    boolean hasRankyaku = false;
    boolean hasGeppo = false;
    while (rokushikiCount < max) {
      if (!hasSoru && WyMathHelper.randomWithRange(1, 10) >= 8.0D) {
        this.tasks.addTask(1, (EntityAIBase)new EntityAISoru(this));
        this.threat += 2;
        rokushikiCount++;
        hasSoru = true;
        continue;
      } 
      if (!hasTekkai && WyMathHelper.randomWithRange(1, 10) >= 8.0D) {
        this.tasks.addTask(1, (EntityAIBase)new EntityAITekkai(this));
        this.threat += 5;
        rokushikiCount++;
        hasTekkai = true;
        continue;
      } 
      if (!hasRankyaku && WyMathHelper.randomWithRange(1, 10) >= 5.0D) {
        this.tasks.addTask(1, (EntityAIBase)new EntityAIRankyaku(this));
        this.threat += 20;
        rokushikiCount++;
        hasRankyaku = true;
        continue;
      } 
      if (!hasGeppo && WyMathHelper.randomWithRange(1, 10) >= 5.0D) {
        this.tasks.addTask(1, (EntityAIBase)new EntityAIGeppo(this));
        this.threat += 10;
        rokushikiCount++;
        hasGeppo = true;
        continue;
      } 
      rokushikiCount++;
    } 
    if (WyDebug.isDebug()) {
      System.out.println("Soru : " + hasSoru);
      System.out.println("Tekkai : " + hasTekkai);
      System.out.println("Rankyaku : " + hasRankyaku);
      System.out.println("Geppo : " + hasGeppo);
    } 
  }
  
  public String getMobTexture() {
    return getTexture();
  }
  
  public double[] itemOffset() {
    return new double[] { 0.0D, 0.0D, 0.0D };
  }
  
  public double[] itemScale() {
    return new double[] { 1.0D, 1.0D, 1.0D };
  }
}
