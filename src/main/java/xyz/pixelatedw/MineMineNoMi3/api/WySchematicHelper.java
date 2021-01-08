package xyz.pixelatedw.MineMineNoMi3.api;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class WySchematicHelper {
  public static Schematic load(String name) {
    try {
      InputStream is = WySchematicHelper.class.getClassLoader().getResourceAsStream("assets/mineminenomi/schematics/" + name + ".schematic");
      NBTTagCompound nbt = CompressedStreamTools.readCompressed(is);
      short width = nbt.getShort("Width");
      short height = nbt.getShort("Height");
      short length = nbt.getShort("Length");
      byte[] blocks = nbt.getByteArray("Blocks");
      byte[] data = nbt.getByteArray("Data");
      NBTTagList tiles = nbt.getTagList("TileEntities", 10);
      is.close();
      return new Schematic(name, tiles, width, height, length, blocks, data);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  public static void build(Schematic sch, World world, int posX, int posY, int posZ) {
    build(sch, world, posX, posY, posZ, null);
  }
  
  public static void build(Schematic sch, World world, int posX, int posY, int posZ, Block airReplacement) {
    try {
      int i = 0;
      List<TileEntity> tiles = new ArrayList<>();
      for (int sy = 0; sy < sch.getHeight(); sy++) {
        for (int sz = 0; sz < sch.getLength(); sz++) {
          for (int sx = 0; sx < sch.getWidth(); sx++) {
            Block b = Block.getBlockById(UnsignedBytes.toInt(sch.getBlocks()[i]));
            if (b != Blocks.air)
              if (world.getBlock(posX + sx, posY + sy, posZ + sz) != b) {
                if (b != airReplacement) {
                  world.setBlock(posX + sx, posY + sy, posZ + sz, b, sch.getData()[i], 2);
                } else {
                  world.setBlock(posX + sx, posY + sy, posZ + sz, Blocks.air);
                } 
                if (world.getBlock(posX + sx, posY + sy, posZ + sz) == Blocks.water || world.getBlock(posX + sx, posY + sy, posZ + sz) == Blocks.flowing_water)
                  world.markBlockForUpdate(posX + sx, posY + sy, posZ + sz); 
              }  
            i++;
          } 
        } 
      } 
    } catch (Exception e) {
      System.out.println("[ERROR] The .schematic could not be built due to : " + e.toString());
      e.printStackTrace();
    } 
  }
}
