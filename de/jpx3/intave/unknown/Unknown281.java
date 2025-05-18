package de.jpx3.intave.unknown;

import java.util.HashMap;

final class Unknown281 {
   private static final String b;

   public static int a(CharSequence var0, CharSequence var1, int var2, int var3, int var4, int var5) {
      if (2 * var5 < var3 + var2) {
         throw new IllegalArgumentException("Unsupported cost assignment");
      } else if (var0.length() == 0) {
         return var1.length() * var3;
      } else if (var1.length() == 0) {
         return var0.length() * var2;
      } else {
         int[][] var9 = new int[var0.length()][var1.length()];
         HashMap var10 = new HashMap();
         if (var0.charAt(0) != var1.charAt(0)) {
            var9[0][0] = Math.min(var4, var2 + var3);
         }

         var10.put(var0.charAt(0), 0);

         for(int var11 = 1; var11 < var0.length(); ++var11) {
            int var12 = var9[var11 - 1][0] + var2;
            int var13 = (var11 + 1) * var2 + var3;
            int var14 = var11 * var2 + (var0.charAt(var11) == var1.charAt(0) ? 0 : var4);
            var9[var11][0] = Math.min(Math.min(var12, var13), var14);
         }

         for(int var22 = 1; var22 < var1.length(); ++var22) {
            int var24 = (var22 + 1) * var3 + var2;
            int var26 = var9[0][var22 - 1] + var3;
            int var28 = var22 * var3 + (var0.charAt(0) == var1.charAt(var22) ? 0 : var4);
            var9[0][var22] = Math.min(Math.min(var24, var26), var28);
         }

         for(int var23 = 1; var23 < var0.length(); ++var23) {
            int var25 = var0.charAt(var23) == var1.charAt(0) ? 0 : -1;

            for(int var27 = 1; var27 < var1.length(); ++var27) {
               Integer var29 = (Integer)var10.get(var1.charAt(var27));
               int var15 = var25;
               int var16 = var9[var23 - 1][var27] + var2;
               int var17 = var9[var23][var27 - 1] + var3;
               int var18 = var9[var23 - 1][var27 - 1];
               if (var0.charAt(var23) != var1.charAt(var27)) {
                  var18 += var4;
               } else {
                  var25 = var27;
               }

               int var19;
               if (var29 != null && var15 != -1) {
                  int var20 = var29;
                  int var21;
                  if (var20 == 0 && var15 == 0) {
                     var21 = 0;
                  } else {
                     var21 = var9[Math.max(0, var20 - 1)][Math.max(0, var15 - 1)];
                  }

                  var19 = var21 + (var23 - var20 - 1) * var2 + (var27 - var15 - 1) * var3 + var5;
               } else {
                  var19 = Integer.MAX_VALUE;
               }

               var9[var23][var27] = Math.min(Math.min(Math.min(var16, var17), var18), var19);
            }

            var10.put(var0.charAt(var23), var23);
         }

         return var9[var0.length() - 1][var1.length() - 1];
      }
   }

   public static int a(CharSequence var0, CharSequence var1) {
      return a(var0, var1, 1, 1, 1, 1);
   }
}
