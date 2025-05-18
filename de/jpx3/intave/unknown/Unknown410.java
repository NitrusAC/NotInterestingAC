package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.MinecraftVersion;

public final class Unknown410 {
   private static Unknown252 a;

   public static void a() {
      String var4 = "de.jpx3.intave.unknown.Unknown395";
      if (MinecraftVersion.V_1_9.atOrAbove()) {
         var4 = "de.jpx3.intave.dj";
      }

      if (MinecraftVersion.V_1_13.atOrAbove()) {
         var4 = "de.jpx3.intave.fR";
      }

      if (MinecraftVersion.V_1_14.atOrAbove()) {
         var4 = "de.jpx3.intave.l4";
      }

      ClassLoader var5 = IntavePlugin.class.getClassLoader();
      Unknown152.a(var5, var4);
      a = (Unknown252)a(var4);
   }

   public static Unknown252 b() {
      return a;
   }

   private static Object a(String var0) {
      try {
         return Class.forName(var0).newInstance();
      } catch (IllegalAccessException | ClassNotFoundException | InstantiationException var2) {
         throw new IntaveInternalException(var2);
      }
   }
}
