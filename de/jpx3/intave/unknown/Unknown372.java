package de.jpx3.intave.unknown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Unknown372 {
   static List a(long[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var4 = new ArrayList(var0.length);

         for(long var8 : var0) {
            var4.add(var8);
         }

         return var4;
      }
   }

   public static List a(int[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var4 = new ArrayList(var0.length);

         for(int var8 : var0) {
            var4.add(var8);
         }

         return var4;
      }
   }

   static List a(float[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var4 = new ArrayList(var0.length);

         for(float var8 : var0) {
            var4.add(var8);
         }

         return var4;
      }
   }

   public static List a(Object[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var1 = new ArrayList(var0.length);
         Collections.addAll(var1, var0);
         return var1;
      }
   }

   static List a(byte[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var4 = new ArrayList(var0.length);

         for(byte var8 : var0) {
            var4.add(var8);
         }

         return var4;
      }
   }

   public static List a(int var0) {
      ArrayList var4 = new ArrayList(var0);

      for(int var5 = 0; var5 < var0; ++var5) {
         var4.add(null);
      }

      return var4;
   }

   static List a(boolean[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var4 = new ArrayList(var0.length);

         for(boolean var8 : var0) {
            var4.add(var8);
         }

         return var4;
      }
   }

   static List a(char[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var4 = new ArrayList(var0.length);

         for(char var8 : var0) {
            var4.add(var8);
         }

         return var4;
      }
   }

   static List a(double[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var4 = new ArrayList(var0.length);

         for(double var8 : var0) {
            var4.add(var8);
         }

         return var4;
      }
   }

   public static List a(List var0, Object var1) {
      Object var2 = var0 == null ? new ArrayList(1) : var0;
      ((List)var2).add(var1);
      return (List)var2;
   }

   static List a(short[] var0) {
      if (var0 == null) {
         return new ArrayList();
      } else {
         ArrayList var4 = new ArrayList(var0.length);

         for(short var8 : var0) {
            var4.add(var8);
         }

         return var4;
      }
   }

   private Unknown372() {
   }

   public static List a(int var0, Object[] var1) {
      ArrayList var5 = new ArrayList(var0);

      for(int var6 = 0; var6 < var0; ++var6) {
         var5.add(var1[var6]);
      }

      return var5;
   }
}
