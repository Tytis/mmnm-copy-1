package xyz.pixelatedw.MineMineNoMi3.renderers.entities.mobs.humanoids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import xyz.pixelatedw.MineMineNoMi3.data.ExtendedEntityData;
import xyz.pixelatedw.MineMineNoMi3.models.entities.mobs.humanoids.ModelMarine;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.MobRenderer;

@SideOnly(Side.CLIENT)
public class RenderDoppelman extends MobRenderer {
  public RenderDoppelman() {
    super((ModelBiped)new ModelMarine(), "doppelman");
  }
  
  protected void preRenderCallback(EntityLivingBase livingBase, float f) {
    float scale = 1.0F + ExtendedEntityData.get(livingBase).getDoriki() / 7.0F;
    if (scale < 1.0F)
      scale = 1.0F; 
    GL11.glScalef(scale, scale, scale);
  }
}
