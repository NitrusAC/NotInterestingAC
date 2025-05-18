package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public final class MathUtil2 {
   public static double a(double var0, double var2, double var4, double var6, double var8, double var10) {
      return getLength(var0 - var6, var2 - var8, var4 - var10);
   }

   public static double clamp(double max, double value, double min) {
      return Math.max(max, Math.min(value, min));
   }

   public static String intVecToString(double var0, double var2, double var4) {
      return (int)var0 + "," + (int)var2 + "," + (int)var4;
   }

   public static long a(long var0, long var2, long var4) {
      return Math.max(var0, Math.min(var2, var4));
   }

   public static String roundVecToString(double var0, double var2, double var4) {
      return getStringRounded(var0, 3) + ", " + getStringRounded(var2, 4) + ", " + getStringRounded(var4, 3);
   }

   public static double a(List var0) {
      double var4 = 0.0;

      for(Number var7 : var0) {
         var4 = Math.max(var4, var7.doubleValue());
      }

      return var4;
   }

   public static double a(double var0, double var2, double var4, double var6, double var8) {
      return (var0 - var2) / (var4 - var2) * (var8 - var6) + var6;
   }

   public static String toString(Location var0) {
      return roundVecToString(var0.getX(), var0.getY(), var0.getZ());
   }

   public static double a(Motion var0, Motion var1) {
      return a(var0.motionX, var0.motionY, var0.motionZ, var1.motionX, var1.motionY, var1.motionZ);
   }

   public static double a(Motion var0, double var1, double var3, double var5) {
      return a(var0.motionX, var0.motionY, var0.motionZ, var1, var3, var5);
   }

   public static String getStringRounded(double value, int round) {
      if (Double.isNaN(value)) {
         return "NaN";
      } else {
         return Double.isInfinite(value) ? "Infinite" : new BigDecimal(value).setScale(round, RoundingMode.HALF_UP).toPlainString();
      }
   }

   public static float deltaYaw(float yawA, float yawB) {
      float var5 = yawA - yawB % 360.0F;
      if (var5 > 180.0F) {
         var5 = 360.0F - var5;
      }

      if (var5 < -180.0F) {
         var5 += 360.0F;
      }

      return var5;
   }

   public static double a(double var0, double var2, double var4, double var6) {
      return AccurateMathUtil.deltaXZ(var0 - var4, var2 - var6);
   }

   public static int a(int var0, int var1, int var2) {
      return Math.max(var0, Math.min(var1, var2));
   }

   public static double getLength(double x, double y, double z) {
      return Math.sqrt(x * x + y * y + z * z);
   }

   public static float distanceBetweenAngles(float var0, float var1) {
      float var5 = Math.abs(var1 - var0) % 360.0F;
      return var5 > 180.0F ? 360.0F - var5 : var5;
   }

   public static double a(double var0, double var2) {
      return Math.abs(var0 - var2);
   }

   public static double b(List var0) {
      double var4 = 1000.0;

      for(Number var7 : var0) {
         var4 = Math.min(var4, var7.doubleValue());
      }

      return var4;
   }

   public static String a(Vector var0) {
      return roundVecToString(var0.getX(), var0.getY(), var0.getZ());
   }
}
