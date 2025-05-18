package de.jpx3.intave.unknown;

import de.jpx3.intave.ef;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import org.bukkit.World;

public final class Unknown239 {
   private static final boolean a = MinecraftVersion.V_1_9.atOrAbove();

   public static void a() {
      String var4;
      if (a) {
         var4 = "de.jpx3.intave.ef";
      } else {
         var4 = "de.jpx3.intave.unknown.Unknown273";
      }

      ClassLoader var5 = Unknown239.class.getClassLoader();
      Unknown152.a(var5, var4);
   }

   public static Object a(World var0) {
      return a ? ef.a(var0) : Unknown273.b(var0);
   }
}
