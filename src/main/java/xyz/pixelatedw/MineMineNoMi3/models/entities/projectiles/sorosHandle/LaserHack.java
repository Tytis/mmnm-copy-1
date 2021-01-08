package xyz.pixelatedw.MineMineNoMi3.models.entities.projectiles.sorosHandle;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityExplosion;
import xyz.pixelatedw.MineMineNoMi3.soros.RyuRyuNoMiAbilities;

public class LaserHack {
  EntityPlayer pl = (EntityPlayer)(Minecraft.getMinecraft()).thePlayer;
  
  Minecraft mc = Minecraft.getMinecraft();
  
  double x;
  
  double y;
  
  double z;
  
  public boolean doThatTouchBlockOrEntities() {
    for (Object e : this.mc.theWorld.loadedEntityList) {
      Entity ent = (Entity)e;
      if (ent != null && 
        ent.posX == this.x && ent.posY == this.y && ent.posZ == this.z)
        return false; 
    } 
    if (this.mc.theWorld.getBlock((int)this.x, (int)this.y, (int)this.z) != Blocks.air)
      return false; 
    return true;
  }
  
  @SubscribeEvent
  public void rwl(RenderWorldLastEvent event) {
    if (this.pl != null && 
      isSendingSomeLaser())
      for (int i = 0; i < this.mc.theWorld.loadedEntityList.size(); i++) {
        if (this.mc.theWorld.loadedEntityList.get(i) instanceof Entity && 
          !this.mc.theWorld.loadedEntityList.get(i).equals(this.pl)) {
          Entity p = (Entity) this.mc.theWorld.loadedEntityList.get(i);
          if (p.isInvisible())
            return; 
          double renderPosX = RenderManager.renderPosX;
          double renderPosY = RenderManager.renderPosY;
          double renderPosZ = RenderManager.renderPosZ;
          double xPos = p.lastTickPosX - renderPosX;
          double yPos = p.lastTickPosY - renderPosY;
          double zPos = p.lastTickPosZ - renderPosZ;
          this.mc.gameSettings.viewBobbing = false;
          GL11.glEnable(2848);
          GL11.glDisable(3553);
          GL11.glEnable(2884);
          GL11.glDisable(2929);
          GL11.glPushMatrix();
          GL11.glDisable(2896);
          Color a = Color.red;
          MovingObjectPosition mop = WyHelper.rayTraceBlocks((Entity)this.pl);
          double is = mop.blockX;
          double j = mop.blockY;
          double k = mop.blockZ;
          this.x = is;
          this.y = j;
          this.z = k;
          drawline(p, is, j, k, a.getRed() / 255.0F, a.getGreen() / 255.0F, a.getBlue() / 255.0F);
          GL11.glEnable(2896);
          GL11.glPopMatrix();
          GL11.glDisable(2848);
          GL11.glEnable(2929);
          GL11.glEnable(3553);
          GL11.glDisable(2848);
        } 
      }  
  }
  
  private boolean isSendingSomeLaser() {
    return RyuRyuNoMiAbilities.BoroBreathClass.renderLaser;
  }
  
  private void drawline(Entity p, double xPos, double yPos, double zPos, float r, float g, float b) {
    GL11.glLineWidth(0.2F);
    GL11.glColor4f(r, g, b, 1.0F);
    GL11.glBegin(1);
    Vec3 eyes = this.pl.getLookVec();
    GL11.glVertex3d(eyes.xCoord, this.pl.getEyeHeight() + eyes.yCoord - 0.10000000149011612D, eyes.zCoord);
    for (int i = (int)this.pl.posX; i < xPos; i++) {
      if (doThatTouchBlockOrEntities()) {
        AbilityExplosion exp = WyHelper.newExplosion(p, xPos, yPos, zPos, 10.0D);
        exp.setFireAfterExplosion(true);
        exp.doExplosion();
      } else {
        GL11.glVertex3d(p.boundingBox.minX - p.posX + i, p.boundingBox.minY - p.posY + yPos + 0.949999988079071D, p.boundingBox.minZ - p.posZ + zPos);
        GL11.glEnd();
      } 
    } 
  }
}
