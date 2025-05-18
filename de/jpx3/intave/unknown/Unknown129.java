package de.jpx3.intave.unknown;

import de.jpx3.intave.f0;
import de.jpx3.intave.l;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import java.util.EnumMap;
import java.util.Map;
import org.bukkit.Material;

public final class Unknown129 {
   private static final boolean b = MinecraftVersion.V_1_13.atOrAbove();
   private static final Map d = new EnumMap(Material.class);
   private static final Map a = new EnumMap(Material.class);
   private static final Map c = new EnumMap(Material.class);

   public static void a() {
      for(Material var6 : Material.values()) {
         if (var6.isBlock()) {
            Unknown50.b(var6, d::put, c::put);
         }
      }

   }

   static boolean b() {
      return b;
   }

   public static int a(Material var0, Object var1) {
      Map var5 = (Map)d.get(var0);
      Integer var6 = (Integer)var5.get(var1);
      return var6 == null ? -1 : var6;
   }

   public static Object a(Material var0, int var1) {
      try {
         return ((Map)c.get(var0)).get(var1);
      } catch (Exception var5) {
         Logger.getLogger().print("[Intave] Failed to correctly emulate data structure of block type " + var0 + " (requested variant " + var1 + ")");
         var5.printStackTrace();
         return ((Map)c.get(var0)).get(0);
      }
   }

   public static l b(Material var0, int var1) {
      return (l)((Map)a.computeIfAbsent(var0, Unknown129::b)).get(var1);
   }

   private static Map b(Material var0) {
      return f0.a(var0, (Map)c.get(var0));
   }

   static {
      Unknown152.a(IntavePlugin.class.getClassLoader(), "de.jpx3.intave.unknown.Unknown50");
   }
}
