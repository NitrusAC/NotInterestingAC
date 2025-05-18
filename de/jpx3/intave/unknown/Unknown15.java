package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.WrappedBlockData;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import org.bukkit.Material;
import org.bukkit.block.Block;

public final class Unknown15 {
   private static final boolean a = MinecraftVersion.V_1_13.atOrAbove();
   private static final String d;

   public static Object a(Block var0) {
      return Unknown410.b().c(var0);
   }

   public static int a(WrappedBlockData var0) {
      if (!a) {
         return var0.getData();
      } else {
         Material var4 = var0.getType();
         Object var5 = var0.getHandle();
         int var6 = Unknown129.a(var4, var5);
         if (var6 < 0) {
            throw new IllegalStateException("Invalid block data update: " + var4 + "/" + var5);
         } else {
            return var6;
         }
      }
   }

   @Deprecated
   public static int b(Block var0) {
      return Unknown410.b().a(var0);
   }

   public static void c() {
   }
}
