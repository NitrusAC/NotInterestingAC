package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.qd;
import java.lang.reflect.Field;
import org.bukkit.Bukkit;
import org.bukkit.Server;

public final class TPSUtil {
   private static double[] a;

   public static double[] c() {
      return a;
   }

   public static String a() {
      return MathUtil2.getStringRounded(a[1], 5);
   }

   public static void b() {
      try {
         Server var2 = Bukkit.getServer();
         Class var9 = var2.getClass();
         String var12 = qd.c(var9, "console");
         String var10002 = "console";
         Field var8 = var9.getDeclaredField(var12);
         var8.setAccessible(true);
         Object var4 = var8.get(var2);
         var9 = var4.getClass().getSuperclass();
         var12 = qd.c(var9, "recentTps");
         var10002 = "recentTps";
         Field var5 = var9.getDeclaredField(var12);
         var5.setAccessible(true);
         a = (double[])var5.get(var4);
      } catch (NoSuchFieldException | IllegalAccessException var7) {
         try {
            Server var3 = Bukkit.getServer();
            Class var10000 = var3.getClass();
            Class[] var10003 = new Class[0];
            a = (double[])var10000.getMethod(qd.b("getTPS", var10000, var10003), var10003).invoke(var3);
            return;
         } catch (Exception var6) {
            var7.printStackTrace();
            var6.printStackTrace();
            a = new double[]{20.0, 20.0, 20.0};
         }
      }

   }
}
