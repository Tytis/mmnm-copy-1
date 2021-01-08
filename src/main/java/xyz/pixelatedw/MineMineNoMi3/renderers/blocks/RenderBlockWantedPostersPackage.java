package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelWantedPostersPackage;

@SideOnly(Side.CLIENT)
public class RenderBlockWantedPostersPackage extends TileEntitySpecialRenderer {
  private static final ResourceLocation texture = new ResourceLocation("mineminenomi:textures/models/wantedposterspackage.png");
  
  private ModelWantedPostersPackage model = new ModelWantedPostersPackage();
  
  public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
    bindTexture(texture);
    GL11.glPushMatrix();
    GL11.glTranslated(posX + 0.5D, posY + 1.6D, posZ + 0.5D);
    GL11.glScalef(1.0F, 1.0F, 1.0F);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    this.model.parachute.isHidden = true;
    this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    GL11.glPopMatrix();
  }
}
