package de.jpx3.intave.anticheat.block;

import de.jpx3.intave.anticheat.block.impl.AnvilBlock;
import de.jpx3.intave.anticheat.block.impl.BambooBlock;
import de.jpx3.intave.anticheat.block.impl.CarpetBlock;
import de.jpx3.intave.anticheat.block.impl.CauldronBlock;
import de.jpx3.intave.anticheat.block.impl.DoorBlock;
import de.jpx3.intave.anticheat.block.impl.DripStoneBlock;
import de.jpx3.intave.anticheat.block.impl.FenceGateBlock;
import de.jpx3.intave.anticheat.block.impl.GlassPaneBlock;
import de.jpx3.intave.anticheat.block.impl.HopperBlock;
import de.jpx3.intave.anticheat.block.impl.LadderBlock;
import de.jpx3.intave.anticheat.block.impl.PortalFrameBlock;
import de.jpx3.intave.anticheat.block.impl.SoilBlock;
import de.jpx3.intave.anticheat.block.impl.WaterLilyBlock;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class BlockManager {
   private static final Map a = new HashMap();
   private static final String c;

   private static void add(Block var0) {
      List var1 = (List)Arrays.stream(Material.values()).filter(var0::isMaterial).collect(Collectors.toList());
      if (var1.isEmpty()) {
      }

      var1.forEach(BlockManager::b);
   }

   private static void b(Block var0, Material var1) {
      Block var10000 = (Block)a.put(var1, var0);
   }

   private static void addBlock(Class var0) {
      try {
         add((Block)var0.newInstance());
      } catch (Error | Exception var4) {
         Logger.getLogger().info("Failed to load bounding box patch (" + var0 + ")");
         var4.printStackTrace();
      }

   }

   private static List a(List var0, int var1, int var2, int var3) {
      if (var0.isEmpty()) {
         return var0;
      } else {
         var0 = new ArrayList(var0);

         for(int var7 = 0; var7 < var0.size(); ++var7) {
            Box var8 = (Box)var0.get(var7);
            if (var8.d()) {
               var0.set(var7, var8.add((double)var1, (double)var2, (double)var3));
            }
         }

         return var0;
      }
   }

   public static void initBlocks() {
      addBlock(DoorBlock.class);
      addBlock(AnvilBlock.class);
      addBlock(LadderBlock.class);
      addBlock(WaterLilyBlock.class);
      addBlock(FenceGateBlock.class);
      addBlock(SoilBlock.class);
      addBlock(BambooBlock.class);
      addBlock(GlassPaneBlock.class);
      addBlock(PortalFrameBlock.class);
      addBlock(CauldronBlock.class);
      addBlock(DripStoneBlock.class);
      addBlock(CarpetBlock.class);
      addBlock(HopperBlock.class);
   }

   public static Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      Block var11 = (Block)a.get(material);
      if (var11 == null) {
         return box;
      } else {
         Boxable var12 = translate(var11, box, x, y, z);
         Boxable var13 = var11.getBounding(world, player, x, y, z, material, data, var12);
         return translate(var13, x, y, z);
      }
   }

   private static Boxable translate(Boxable box, int x, int y, int z) {
      return box.a() ? box : box.b(x, y, z);
   }

   private static Boxable translate(Block block, Boxable box, int x, int y, int z) {
      return block.a() && !box.a() ? box.a(x, y, z) : box;
   }
}
