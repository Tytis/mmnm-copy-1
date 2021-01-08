package xyz.pixelatedw.MineMineNoMi3.helpers;

import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import xyz.pixelatedw.MineMineNoMi3.entities.zoan.EntityRendererZoanEyes;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelBisonPower;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelBisonSpeed;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelGiraffePower;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelGiraffeSpeed;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelMammoth;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelMoguPower;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelPhoenixFull;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelPhoenixHybrid;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelVenomDemon;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelYomi;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelZouFull;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.ModelZouHybrid;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.buddha;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.dragon;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.hybridleopard;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.leopard;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.luffy;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.mochi_wheel;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.nue;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.smilodon;
import xyz.pixelatedw.MineMineNoMi3.models.entities.zoans.soldier;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans.RenderMorphYomi;
import xyz.pixelatedw.MineMineNoMi3.renderers.entities.zoans.RenderZoanMorph;

public class MorphsHelper {
  private static HashMap<String, Object[][]> morphsMap = (HashMap)new HashMap<>();
  
  public static HashMap<String, Object[][]> getMorphsMap() {
    return morphsMap;
  }
  
  static {
    morphsMap.put("ushiushibison", new Object[][] { { "power", new RenderZoanMorph((ModelBase)new ModelBisonPower(), "bisonpower", 1.4D, new float[] { 0.0F, 0.7F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), 0.6D), null }, { "speed", new RenderZoanMorph((ModelBase)new ModelBisonSpeed(), "bisonspeed", 1.4D, new float[] { 0.0F, 0.8F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), -0.3D), null } });
    morphsMap.put("toritoriphoenix", new Object[][] { { "full", new RenderZoanMorph((ModelBase)new ModelPhoenixFull(), "phoenixfull", 1.3D, new float[] { 0.0F, 0.3F, 0.0F }), null, null }, { "hybrid", new RenderZoanMorph((ModelBase)new ModelPhoenixHybrid(), "phoenixhybrid", 1.0D, new float[] { 0.0F, 0.2F, 0.0F }), null, null } });
    morphsMap.put("ryuryu", new Object[][] { { "dragon", new RenderZoanMorph((ModelBase)new dragon(), "dragon", 0.7D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("pteranodonryuryunomi", new Object[][] { { "ptera", new RenderZoanMorph((ModelBase)new smilodon(), "smilodon_male", 1.7D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("pteranodonryuryu", new Object[][] { { "ptera", new RenderZoanMorph((ModelBase)new smilodon(), "smilodon_male", 1.7D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("ryuryunomi", new Object[][] { { "dragon", new RenderZoanMorph((ModelBase)new dragon(), "dragon", 0.7D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("budhabudhanomi", new Object[][] { { "buddha", new RenderZoanMorph((ModelBase)new buddha(), "goldensengoku", 0.7D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("budhabudha", new Object[][] { { "buddha", new RenderZoanMorph((ModelBase)new buddha(), "goldensengoku", 0.7D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("mochimochi", new Object[][] { { "wheel", new RenderZoanMorph((ModelBase)new mochi_wheel(), "mochi_wheel", 0.5D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("mochimochinomi", new Object[][] { { "wheel", new RenderZoanMorph((ModelBase)new mochi_wheel(), "mochi_wheel", 0.5D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("gomugomunomi", new Object[][] { { "luffy", new RenderZoanMorph((ModelBase)new luffy(), "luffy", 0.5D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("gomugomu", new Object[][] { { "luffy", new RenderZoanMorph((ModelBase)new luffy(), "luffy", 0.5D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("zouzou", new Object[][] { { "full", new RenderZoanMorph((ModelBase)new ModelZouFull(), "zoufull", 1.3D, new float[] { 0.0F, 0.65F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), 0.3D), null }, { "hybrid", new RenderZoanMorph((ModelBase)new ModelZouHybrid(), "zouhybrid", 1.0D, new float[] { 0.0F, 0.2F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), 0.8D), null } });
    morphsMap.put("mamouthmamouth", new Object[][] { { "mamouth", new RenderZoanMorph((ModelBase)new ModelMammoth(), "mammothMale1", 1.3D, new float[] { 0.0F, 0.65F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), 0.3D), null } });
    morphsMap.put("bisubisunomi", new Object[][] { { "bisupoint", new RenderZoanMorph((ModelBase)new soldier(), "soldier1", 0.8D, new float[] { 0.0F, 0.65F, 0.0F }), null } });
    morphsMap.put("bisubisu", new Object[][] { { "bisupoint", new RenderZoanMorph((ModelBase)new soldier(), "soldier1", 0.8D, new float[] { 0.0F, 0.65F, 0.0F }), null } });
    morphsMap.put("mamouthmamouthnomi", new Object[][] { { "mamouth", new RenderZoanMorph((ModelBase)new ModelMammoth(), "mammothMale1", 1.3D, new float[] { 0.0F, 0.65F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), 0.3D), null } });
    morphsMap.put("dokudoku", new Object[][] { { "venomDemon", new RenderZoanMorph((ModelBase)new ModelVenomDemon(), "venomdemon", 1.1D, new float[] { 0.0F, 0.5F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), 1.6D), null } });
    morphsMap.put("yomiyomi", new Object[][] { { "yomi", new RenderMorphYomi(new ModelYomi(), "skeleton", 1.1D, new float[] { 0.0F, 0.3F, 0.0F }), null, new float[] { -0.25F, 0.6F, -0.05F } } });
    morphsMap.put("mogumogu", new Object[][] { { "power", new RenderZoanMorph((ModelBase)new ModelMoguPower(), "mogu", 0.9D, new float[] { 0.0F, 0.1F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), -0.2D), null } });
    morphsMap.put("ushiushigiraffe", new Object[][] { { "power", new RenderZoanMorph((ModelBase)new ModelGiraffePower(), "giraffehybrid", 1.4D, new float[] { 0.0F, 0.7F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), 1.8D), null }, { "speed", new RenderZoanMorph((ModelBase)new ModelGiraffeSpeed(), "giraffefull", 1.55D, new float[] { 0.0F, 0.95F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), 1.9D), null } });
    morphsMap.put("minimini", new Object[][] { { "mini", new RenderZoanMorph((ModelBase)new ModelBiped(), "$playerskin", 0.15D, new float[] { 0.0F, -0.9F, 0.0F }), new EntityRendererZoanEyes(
              
              Minecraft.getMinecraft(), -0.8D), null } });
    morphsMap.put("nunu", new Object[][] { { "nue", new RenderZoanMorph((ModelBase)new nue(), "nue", 1.3D, new float[] { 0.0F, 0.3F, 0.0F }), null, null } });
    morphsMap.put("leopardleopard", new Object[][] { { "leopard", new RenderZoanMorph((ModelBase)new leopard(), "leopard", 1.3D, new float[] { 0.0F, 0.3F, 0.0F }), null, null }, { "hybridleopard", new RenderZoanMorph((ModelBase)new hybridleopard(), "leopardhybrid", 1.0D, new float[] { 0.0F, 0.2F, 0.0F }), null, null } });
  }
}
