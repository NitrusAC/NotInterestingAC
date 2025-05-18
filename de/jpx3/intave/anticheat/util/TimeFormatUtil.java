package de.jpx3.intave.anticheat.util;

import java.util.concurrent.TimeUnit;

public final class TimeFormatUtil {
   public static String a(long var0) {
      if (var0 <= 0L) {
         return "invalid";
      } else {
         int var5 = (int)(var0 / 3600000L);
         int var6 = var5 / 24;
         var5 %= 24;
         String var7 = a(TimeUnit.DAYS, (long)var6);
         String var8 = a(TimeUnit.HOURS, (long)var5);
         if (var8.isEmpty()) {
            var8 = "0 hours";
         }

         String var9;
         if (var6 >= 7) {
            var9 = var7;
         } else {
            var9 = var7 + (var7.isEmpty() ? "" : " and ") + var8;
         }

         if (var9.trim().isEmpty()) {
            var9 = "a few hours";
         }

         return var9;
      }
   }

   private static String a(TimeUnit var0, long var1) {
      if (var1 == 0L) {
         return "";
      } else {
         String var6 = var0.name().toLowerCase();
         return (var1 == 1L ? "one" : var1) + " " + var6.substring(0, var6.length() - (var1 == 1L ? 1 : 0));
      }
   }
}
