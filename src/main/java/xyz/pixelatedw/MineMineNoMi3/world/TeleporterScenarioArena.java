package xyz.pixelatedw.MineMineNoMi3.world;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;

public class TeleporterScenarioArena extends Teleporter {
  private final WorldServer worldServerInstance;
  
  private Random random;
  
  public TeleporterScenarioArena(WorldServer ws) {
    super(ws);
    this.worldServerInstance = ws;
    this.random = new Random(ws.getSeed());
  }
  
  public void teleport(Entity entity, String scenarioName) {
    EntityPlayerMP playerMP = (EntityPlayerMP)entity;
    playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, ID.DIMENSION_ID_SCENARIOARENA, this);
    playerMP.setPositionAndUpdate(-20000.0D, 64.0D, -20000.0D);
  }
  
  public void endScenario(Entity entity, String scenarioName) {
    EntityPlayerMP playerMP = (EntityPlayerMP)entity;
    playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, this);
  }
  
  public void placeInPortal(Entity entity, double x, double y, double z, double f) {
    if (this.worldServerInstance.provider.getDimensionName().equals("scenarioarena")) {
      entity.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, 0.0F);
      entity.motionX = 0.0D;
      entity.motionY = 0.0D;
      entity.motionZ = 0.0D;
      if (entity instanceof EntityPlayer) {
        EntityPlayer player = (EntityPlayer)entity;
        if (player.worldObj.isRemote)
          if (player.dimension == ID.DIMENSION_ID_SCENARIOARENA)
            WyHelper.sendMsgToPlayer(player, "TEST MESSAGE");  
      } 
    } 
  }
  
  public boolean placeInExistingPortal(Entity entityIn, double x, double y, double z, float f) {
    return false;
  }
  
  public boolean makePortal(Entity entityIn) {
    return false;
  }
}
