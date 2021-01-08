package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntitySakeFeast;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelSakeBottle;
import xyz.pixelatedw.MineMineNoMi3.models.blocks.ModelSakeCup;

@SideOnly(Side.CLIENT)
public class RenderBlockSakeFeast extends TileEntitySpecialRenderer {
  private ModelBase bottleModel;
  
  private ModelBase cupModel;
  
  private ResourceLocation bottleTexture;
  
  private ResourceLocation cupTexture;
  
  private double[] cupPositions = new double[] { 
      0.06D, 0.0D, -0.4D, 0.36D, 0.0D, -0.26D, 0.5D, 0.0D, 0.06D, 0.5D, 
      0.0D, 0.06D };
  
  public RenderBlockSakeFeast() {
    this.bottleModel = (ModelBase)new ModelSakeBottle();
    this.cupModel = (ModelBase)new ModelSakeCup();
    this.bottleTexture = new ResourceLocation("mineminenomi", "textures/models/blocks/sakebottle.png");
    this.cupTexture = new ResourceLocation("mineminenomi", "textures/models/blocks/sakecup.png");
  }
  
  public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
    TileEntitySakeFeast sakeFeast = (TileEntitySakeFeast)te;
    GL11.glPushMatrix();
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 771);
    bindTexture(this.bottleTexture);
    GL11.glTranslated(posX + 0.6D, posY + 1.5D, posZ + 0.4D);
    GL11.glScalef(1.0F, 1.0F, 1.0F);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    GL11.glPushMatrix();
    this.bottleModel.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    GL11.glPopMatrix();
    GL11.glPopMatrix();
  }
}
