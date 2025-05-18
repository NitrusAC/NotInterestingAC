package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.MinecraftVersion;
import org.bukkit.Location;
import org.bukkit.World;

public final class Unknown169 {
   private static Unknown91 a = new Unknown157();
   private static final String d;

   public static void c() {
      if (MinecraftVersion.V_1_13.atOrAbove()) {
         a = new Unknown157();
      } else {
         ClassLoader var3 = Unknown169.class.getClassLoader();
         Unknown152.a(var3, "de.jpx3.intave.unknown.Unknown352");
         a = new Unknown352();
      }

      a = new Unknown128(a);
   }

   public static double a(World var0) {
      return a.b(var0);
   }

   public static Location b(World var0) {
      return a.a(var0);
   }
}
