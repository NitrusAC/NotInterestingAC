package de.jpx3.intave.anticheat.util;

import java.util.Random;
import java.util.UUID;
import java.util.function.IntPredicate;

public final class MathUtil {
   private static final int[] a = new int[]{
      0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9
   };

   public static int c(int var0, int var1) {
      return var0 < 0 ? -((-var0 - 1) / var1) - 1 : var0 / var1;
   }

   public static float f(float var0) {
      return var0 * (float) Math.PI / 180.0F;
   }

   public static double a(long[] var0) {
      long var4 = 0L;

      for(long var9 : var0) {
         var4 += var9;
      }

      return (double)var4 / (double)var0.length;
   }

   private static int c(int var0) {
      var0 = b(var0) ? var0 : e(var0);
      return a[(int)((long)var0 * 125613361L >> 27) & 31];
   }

   public static int e(int var0) {
      int var1 = var0 - 1;
      var1 |= var1 >> 1;
      var1 |= var1 >> 2;
      var1 |= var1 >> 4;
      var1 |= var1 >> 8;
      var1 |= var1 >> 16;
      return var1 + 1;
   }

   public static long a(int var0, int var1, int var2) {
      long var3 = (long)var0 * 3129871L ^ (long)var2 * 116129781L ^ (long)var1;
      var3 = var3 * var3 * 42317861L + var3 * 11L;
      return var3 >> 16;
   }

   public static int d(int var0) {
      return c(var0) - (b(var0) ? 0 : 1);
   }

   public static int c(float var0, float var1, float var2) {
      int var6 = (int)(var0 * 6.0F) % 6;
      float var7 = var0 * 6.0F - (float)var6;
      float var8 = var2 * (1.0F - var1);
      float var9 = var2 * (1.0F - var7 * var1);
      float var10 = var2 * (1.0F - (1.0F - var7) * var1);
      float var11;
      float var12;
      float var13;
      switch(var6) {
         case 0:
            var11 = var2;
            var12 = var10;
            var13 = var8;
            break;
         case 1:
            var11 = var9;
            var12 = var2;
            var13 = var8;
            break;
         case 2:
            var11 = var8;
            var12 = var2;
            var13 = var10;
            break;
         case 3:
            var11 = var8;
            var12 = var9;
            var13 = var2;
            break;
         case 4:
            var11 = var10;
            var12 = var8;
            var13 = var2;
            break;
         case 5:
            var11 = var2;
            var12 = var8;
            var13 = var9;
            break;
         default:
            throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + var0 + ", " + var1 + ", " + var2);
      }

      int var14 = c((int)(var11 * 255.0F), 0, 255);
      int var15 = c((int)(var12 * 255.0F), 0, 255);
      int var16 = c((int)(var13 * 255.0F), 0, 255);
      return var14 << 16 | var15 << 8 | var16;
   }

   public static int a(String var0, int var1, int var2) {
      return Math.max(var2, a(var0, var1));
   }

   public static float a(Random var0, float var1, float var2) {
      return var1 >= var2 ? var1 : var0.nextFloat() * (var2 - var1) + var1;
   }

   public static float cos(float var0) {
      return MathHelperTable.cos(var0, false);
   }

   public static double a(String var0, double var1, double var3) {
      return Math.max(var3, a(var0, var1));
   }

   public static int c(double var0) {
      return (int)(var0 >= 0.0 ? var0 : -var0 + 1.0);
   }

   public static int floor(double value) {
      int var5 = (int)value;
      return value < (double)var5 ? var5 - 1 : var5;
   }

   public static int b(float var0, float var1, float var2) {
      return b(e(var0 * 255.0F), e(var1 * 255.0F), e(var2 * 255.0F));
   }

   public static float sin(float var0) {
      return MathHelperTable.sin(var0, false);
   }

   public static int e(float var0) {
      int var4 = (int)var0;
      return var0 < (float)var4 ? var4 - 1 : var4;
   }

   public static int c(int var0, int var1, int var2) {
      return var0 < var1 ? var1 : Math.min(var0, var2);
   }

   public static float sqrt(double var0) {
      return (float)Math.sqrt(var0);
   }

   public static UUID a(Random var0) {
      long var1 = var0.nextLong() & -61441L | 16384L;
      long var3 = var0.nextLong() & 4611686018427387903L | Long.MIN_VALUE;
      return new UUID(var1, var3);
   }

   public static int a(String var0, int var1) {
      try {
         return Integer.parseInt(var0);
      } catch (Throwable var3) {
         return var1;
      }
   }

   public static boolean a(float var0, float var1) {
      return a(var1 - var0) < 1.0E-5F;
   }

   private static boolean b(int var0) {
      return var0 != 0 && (var0 & var0 - 1) == 0;
   }

   public static double a(Random var0, double var1, double var3) {
      return var1 >= var3 ? var1 : var0.nextDouble() * (var3 - var1) + var1;
   }

   public static double i(double var0) {
      double var2 = 0.5 * var0;
      long var4 = Double.doubleToRawLongBits(var0);
      var4 = 6910469410427058090L - (var4 >> 1);
      var0 = Double.longBitsToDouble(var4);
      return var0 * (1.5 - var2 * var0 * var0);
   }

   public static int a(int var0, int var1, IntPredicate var2) {
      int var6 = var1 - var0;

      while(var6 > 0) {
         int var7 = var6 / 2;
         int var8 = var0 + var7;
         if (var2.test(var8)) {
            var6 = var7;
         } else {
            var0 = var8 + 1;
            var6 -= var7 + 1;
         }
      }

      return var0;
   }

   public static double clamp(double var0, double var2, double var4) {
      return var0 < var2 ? var2 : Math.min(var0, var4);
   }

   public static double hypot(double var0, double var2) {
      return Math.max(Math.abs(var0), Math.abs(var2));
   }

   public static float a(float var0, float var1, float var2) {
      return var0 < var1 ? var1 : Math.min(var0, var2);
   }

   public static float h(float var0) {
      return (float)Math.sqrt((double)var0);
   }

   public static double j(double var0) {
      return var0 - Math.floor(var0);
   }

   public static int a(int var0, int var1) {
      return (var0 % var1 + var1) % var1;
   }

   public static float d(float var0) {
      var0 %= 360.0F;
      if (var0 >= 180.0F) {
         var0 -= 360.0F;
      }

      if (var0 < -180.0F) {
         var0 += 360.0F;
      }

      return var0;
   }

   public static long a(double var0) {
      long var2 = (long)var0;
      return var0 < (double)var2 ? var2 - 1L : var2;
   }

   public static double b(double var0, double var2, double var4) {
      return (var0 - var2) / (var4 - var2);
   }

   public static int ceil(double var0) {
      int var5 = (int)var0;
      return var0 > (double)var5 ? var5 + 1 : var5;
   }

   public static int b(int var0, int var1, int var2) {
      int var3 = (var0 << 8) + var1;
      return (var3 << 8) + var2;
   }

   public static double f(double var0) {
      var0 %= 360.0;
      if (var0 >= 180.0) {
         var0 -= 360.0;
      }

      if (var0 < -180.0) {
         var0 += 360.0;
      }

      return var0;
   }

   public static float a(float var0) {
      return var0 >= 0.0F ? var0 : -var0;
   }

   public static double a(String var0, double var1) {
      try {
         return Double.parseDouble(var0);
      } catch (Throwable var4) {
         return var1;
      }
   }

   public static double a(double var0, double var2, double var4) {
      return var4 < 0.0 ? var0 : (var4 > 1.0 ? var2 : var0 + (var2 - var0) * var4);
   }

   public static long e(double var0) {
      return a(var0 * 4096.0);
   }

   public static int b(int var0, int var1) {
      if (var1 == 0) {
         return 0;
      } else if (var0 == 0) {
         return var1;
      } else {
         if (var0 < 0) {
            var1 *= -1;
         }

         int var5 = var0 % var1;
         return var5 == 0 ? var0 : var0 + var1 - var5;
      }
   }

   public static int d(int var0, int var1) {
      int var2 = (var0 & 0xFF0000) >> 16;
      int var3 = (var1 & 0xFF0000) >> 16;
      int var4 = (var0 & 0xFF00) >> 8;
      int var5 = (var1 & 0xFF00) >> 8;
      int var6 = (var0 & 0xFF) >> 0;
      int var7 = (var1 & 0xFF) >> 0;
      int var8 = (int)((float)var2 * (float)var3 / 255.0F);
      int var9 = (int)((float)var4 * (float)var5 / 255.0F);
      int var10 = (int)((float)var6 * (float)var7 / 255.0F);
      return var0 & 0xFF000000 | var8 << 16 | var9 << 8 | var10;
   }

   public static int a(Random var0, int var1, int var2) {
      return var1 >= var2 ? var1 : var0.nextInt(var2 - var1 + 1) + var1;
   }

   public static int b(float var0) {
      int var4 = (int)var0;
      return var0 > (float)var4 ? var4 + 1 : var4;
   }

   public static int g(double var0) {
      return (int)(var0 + 1024.0) - 1024;
   }

   public static int a(int var0) {
      return var0 >= 0 ? var0 : -var0;
   }
}
