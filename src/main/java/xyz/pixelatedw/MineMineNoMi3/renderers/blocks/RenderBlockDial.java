package xyz.pixelatedw.MineMineNoMi3.renderers.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBlockDial extends TileEntitySpecialRenderer {
  private ModelBase model;
  
  private ResourceLocation texture;
  
  public RenderBlockDial(ModelBase model, String textureName) {
    this.model = model;
    this.texture = new ResourceLocation("mineminenomi", "textures/models/blocks/" + textureName + ".png");
  }
  
  public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
    int rotation = 0;
    if (te.getWorldObj() != null)
      rotation = te.getBlockMetadata(); 
    bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glTranslated(posX + 0.5D, posY + 1.5D, posZ + 0.5D);
    GL11.glScalef(1.0F, 1.0F, 1.0F);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    if (this.texture.getResourcePath().contains("impactdial") || this.texture.getResourcePath().contains("flashdial") || this.texture.getResourcePath().contains("axedial")) {
      GL11.glTranslated(1.25D, 1.45D, 0.0D);
      GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
    } 
    GL11.glPushMatrix();
    GL11.glRotatef((rotation * 90), 0.0F, 1.0F, 0.0F);
    this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    GL11.glPopMatrix();
    GL11.glPopMatrix();
  }
}
