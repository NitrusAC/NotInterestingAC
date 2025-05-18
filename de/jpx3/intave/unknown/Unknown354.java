package de.jpx3.intave.unknown;

import java.util.concurrent.TimeUnit;

public final class Unknown354 {
   private static long c;
   private static final long a = TimeUnit.SECONDS.toMillis(5L);
   private static double f;
   private static long g;
   private static long d;
   private static long e;
   private static long b;

   public static void a(short var0) {
      e += (long)var0;
      ++g;
      if (e > 1073741823L) {
         e /= 2L;
         g /= 2L;
      }

   }

   public static double b() {
      return e == 0L ? 0.0 : (double)e / (double)g;
   }

   public static long c() {
      return c == 0L ? 0L : c / d;
   }

   public static double d() {
      if (System.currentTimeMillis() - b > a) {
         f = b();
         b = System.currentTimeMillis();
      }

      return f;
   }

   public static void a(long var0) {
      c += Math.min(var0, 1000L);
      ++d;
      if (c > 1073741823L) {
         c /= 2L;
         d /= 2L;
      }

   }
}
