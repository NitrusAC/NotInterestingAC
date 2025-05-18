package de.jpx3.intave.anticheat.engine.util;

public final class AccurateMathUtil {
   private static final double a = Double.longBitsToDouble(1229482698272145408L);
   private static final double d = Double.longBitsToDouble(6633802251116740608L);
   private static final double c = Double.longBitsToDouble(7984882139327889408L);
   private static final double b = Double.longBitsToDouble(2580562586483294208L);

   public static double deltaXZ(double x, double z) {
      x = Math.abs(x);
      z = Math.abs(z);
      if (z < x) {
         double var8 = x;
         x = z;
         z = var8;
      } else if (!(z >= x)) {
         if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
         }

         return Double.NaN;
      }

      if (z - x == z) {
         return z;
      } else {
         double var12;
         if (x > d) {
            x *= a;
            z *= a;
            var12 = c;
         } else if (z < b) {
            x *= c;
            z *= c;
            var12 = a;
         } else {
            var12 = 1.0;
         }

         return var12 * Math.sqrt(x * x + z * z);
      }
   }

   public static double b(double var0, double var2) {
      if (Double.isInfinite(var0) || Double.isInfinite(var2)) {
         return Double.POSITIVE_INFINITY;
      } else if (!Double.isNaN(var0) && !Double.isNaN(var2)) {
         var0 = Math.abs(var0);
         var2 = Math.abs(var2);
         if (var0 < var2) {
            double var7 = var0;
            var0 = var2;
            var2 = var7;
         }

         int var26 = Math.getExponent(var0);
         int var8 = Math.getExponent(var2);
         if (var26 > var8 + 27) {
            return var0;
         } else {
            int var9 = 0;
            if (var26 > 510 || var26 < -511) {
               var9 = var26;
               var0 = Math.scalb(var0, -var26);
               var2 = Math.scalb(var2, -var26);
            }

            double var10 = 0.0;
            if (var0 > 2.0 * var2) {
               double var12 = Double.longBitsToDouble(Double.doubleToLongBits(var0) & -4294967296L);
               double var14 = var0 - var12;
               var10 = Math.sqrt(var12 * var12 + var2 * var2 + var14 * (var0 + var12));
            } else {
               double var28 = 2.0 * var0;
               double var29 = Double.longBitsToDouble(Double.doubleToLongBits(var28) & -4294967296L);
               double var16 = var28 - var29;
               double var18 = Double.longBitsToDouble(Double.doubleToLongBits(var2) & -4294967296L);
               double var20 = var2 - var18;
               double var22 = var0 - var2;
               var10 = Math.sqrt(var29 * var18 + var22 * var22 + var29 * var20 + var16 * var2);
            }

            return var9 == 0 ? var10 : Math.scalb(var10, var9);
         }
      } else {
         return Double.NaN;
      }
   }
}
