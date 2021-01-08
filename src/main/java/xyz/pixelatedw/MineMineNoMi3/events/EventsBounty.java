package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarine;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarineCaptain;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.misc.EntityWantedPostersPackage;
import xyz.pixelatedw.MineMineNoMi3.helpers.BountyHelper;

public class EventsBounty {
  private HashMap<EntityPlayer, double[]> cachedPositions = (HashMap)new HashMap<>();
  
  private void spawnAmbush(EntityPlayer player, int repeats, Class<? extends EntityNewMob> clz) {
    for (int i = 0; i < repeats; i++) {
      int posX = (int)(player.posX + WyMathHelper.randomWithRange(-20, 20));
      int posZ = (int)(player.posZ + WyMathHelper.randomWithRange(-20, 20));
      if (player.getDistance(posX, player.posY, posZ) < 5.0D) {
        posX = 5;
        posZ = 5;
      } 
      try {
        EntityNewMob mobToSpawn = clz.getDeclaredConstructor(new Class[] { World.class }).newInstance(new Object[] { player.worldObj });
        mobToSpawn.setAttackTarget((EntityLivingBase)player);
        mobToSpawn.onSpawnWithEgg((IEntityLivingData)null);
        mobToSpawn.setPositionAndRotation(posX, player.posY, posZ, 180.0F, 0.0F);
        player.worldObj.spawnEntityInWorld((Entity)mobToSpawn);
      } catch (Exception e) {
        e.printStackTrace();
      } 
    } 
  }
  
  @SubscribeEvent
  public void onPlayerTick(TickEvent.PlayerTickEvent event) {
    if (event.phase == TickEvent.Phase.END && event.side == Side.SERVER) {
      EntityPlayer player = event.player;
      ExtendedEntityData props = ExtendedEntityData.get((EntityLivingBase)player);
      if (MainConfig.enableAmbushes) {
        boolean canBeAmbushed = false;
        int bountyLevel = (int)(props.getBounty() / 100000L);
        if (props.isPirate() || (props.isRevolutionary() && bountyLevel > 0))
          if (player.worldObj.isDaytime()) {
            float lightLevel = player.getBrightness(0.0F);
            boolean canSeeSky = player.worldObj.canBlockSeeTheSky((int)player.posX, (int)player.posY, (int)player.posZ);
            if (player.ticksExisted % MainConfig.rateAmbushesSpawn == 0.0D && lightLevel > 0.9D && canSeeSky) {
              boolean spawnType = player.worldObj.rand.nextBoolean();
              if (bountyLevel <= 6) {
                if (spawnType) {
                  int lowLevelMobs = (bountyLevel < 4) ? (bountyLevel * 3) : (bountyLevel * 2);
                  spawnAmbush(player, lowLevelMobs, (Class)EntityMarine.class);
                } 
              } else if (bountyLevel > 6) {
                if (spawnType) {
                  int lowLevelMobs = (bountyLevel < 9) ? (player.worldObj.rand.nextInt(10) + 5) : (player.worldObj.rand.nextInt(10) + 10);
                  spawnAmbush(player, lowLevelMobs, (Class)EntityMarine.class);
                  int mediumLevelMobs = (bountyLevel < 9) ? 1 : (player.worldObj.rand.nextInt(2) + 1);
                  spawnAmbush(player, mediumLevelMobs, (Class)EntityMarineCaptain.class);
                } 
              } 
            } 
          }  
      } 
      if (MainConfig.enableWantedPostersPackages) {
        double currentPosX = player.posX;
        double currentPosZ = player.posZ;
        if (player.ticksExisted % MainConfig.rateWantedPostersPackagesSpawn == 0.0D)
          if (!this.cachedPositions.containsKey(player)) {
            this.cachedPositions.put(player, new double[] { currentPosX, currentPosZ });
          } else {
            double[] positions = this.cachedPositions.get(player);
            double cachedPosX = positions[0];
            double cachedPosZ = positions[1];
            boolean flagPosX = (Math.abs(currentPosX - cachedPosX) > 100.0D);
            boolean flagPosZ = (Math.abs(currentPosZ - cachedPosZ) > 100.0D);
            if (flagPosX || flagPosZ) {
              if (BountyHelper.issueBountyForPlayer(event.player)) {
                EntityWantedPostersPackage pkg = new EntityWantedPostersPackage(player.worldObj);
                pkg.setLocationAndAngles(player.posX + WyMathHelper.randomWithRange(-10, 10), player.posY + 30.0D, player.posZ + WyMathHelper.randomWithRange(-10, 10), 0.0F, 0.0F);
                player.worldObj.spawnEntityInWorld((Entity)pkg);
              } 
              this.cachedPositions.remove(player);
              this.cachedPositions.put(player, new double[] { currentPosX, currentPosZ });
            } 
          }  
      } 
    } 
  }
}
