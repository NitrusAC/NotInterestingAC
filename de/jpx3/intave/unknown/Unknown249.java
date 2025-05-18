package de.jpx3.intave.unknown;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Unknown249 {
   private static final Map a = new ConcurrentHashMap();

   private static String getString(int moveForward, int moveStrafe) {
      String var5 = "";
      if (moveForward == 1) {
         var5 = var5 + "W";
      } else if (moveForward == -1) {
         var5 = var5 + "S";
      }

      if (moveStrafe == 1) {
         var5 = var5 + "A";
      } else if (moveStrafe == -1) {
         var5 = var5 + "D";
      }

      return var5;
   }

   private static long a(Long var0) {
      return var0;
   }

   public static Map b() {
      HashMap var0 = new HashMap();
      long var1 = a.values().stream().mapToLong(Unknown249::a).sum();
      a.forEach(Unknown249::b);
      return var0;
   }

   public static void logMoveKeys(int moveForward, int moveStrafe) {
      String var2 = getString(moveForward, moveStrafe);
      a.put(var2, a.getOrDefault(var2, 0L) + 1L);
   }

   private static void b(Map var0, long var1, String var3, Long var4) {
      Double var10000 = (Double)var0.put(var3, (double)var4.longValue() / (double)var1);
   }

   public static Map a() {
      return a;
   }
}
