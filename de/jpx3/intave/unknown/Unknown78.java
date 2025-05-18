package de.jpx3.intave.unknown;

import de.jpx3.intave.qd;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;

final class Unknown78 {
   private static ClassLoader a() {
      return IntavePlugin.class.getClassLoader();
   }

   private static int a(Unknown357 var0, int var1) {
      return var0.b(var1);
   }

   private static Class a(ClassLoader var0, String var1, byte[] var2) {
      a(var0, var2);
      return b(var1);
   }

   private static Class b(String var0) {
      try {
         String var10000 = var0.replaceAll("/", ".");
         ClassLoader var10004 = a();
         boolean var10003 = false;
         return Class.forName(qd.a(var10000), false, var10004);
      } catch (ClassNotFoundException var2) {
         throw new IntaveInternalException(var2);
      }
   }

   private static byte[] b(Unknown177 var0) {
      var0.a();
      return var0.a();
   }

   private static void a(ClassLoader var0, byte[] var1) {
      de.jpx3.classloader.ClassLoader.classLoad(var1);
   }

   private static Unknown357 a(String var0) {
      return Unknown357.f(var0);
   }

   private static void a(Unknown177 var0, String var1, String var2, String var3, String var4, String var5, String var6, boolean var7, boolean var8) {
      Unknown338 var12 = var0.a(4097, var1, var2, null, null);
      var12.c();
      Unknown246 var13 = new Unknown246();
      var12.a(var13);
      Unknown357[] var14 = c(var2);
      Unknown357[] var15 = c(var3);
      int var16 = var14.length;
      Unknown357 var17 = a(var2);
      int var18 = 0;

      for(Unknown357 var22 : var14) {
         Unknown357 var23 = var15[var18];
         int var24 = a(var22, 21);
         var12.d(var24, ++var18);
         if (!var23.equals(var22)) {
            String var25 = var23.b().replaceAll("\\.", "/");
            var12.a(192, var25);
         }
      }

      int var26 = var7 ? 184 : (var8 ? 185 : 182);
      var12.visit(var26, var4, var5, var6, false);
      var12.a(a(var17, 172));
      Unknown246 var27 = new Unknown246();
      var12.a(var27);
      var12.b(var16, var16 + 1);
      var12.e();
   }

   private static void a(Unknown177 var0, String var1, String var2, Class var3) {
      byte var7 = 52;
      byte var8 = 49;
      String var9;
      boolean var10;
      if (var3 == null) {
         var9 = "java/lang/Object";
         var10 = false;
      } else {
         var9 = var3.getCanonicalName().replaceAll("\\.", "/");
         var10 = var3.isInterface();
      }

      if (var10) {
         var0.a(var7, var8, var1, null, "java/lang/Object", new String[]{var9});
      } else {
         var0.a(var7, var8, var1, null, var9, null);
      }

      var0.a(var2, null);
   }

   private static void a(Unknown177 var0) {
      Unknown338 var3 = var0.a(1, "<init>", "()V", null, null);
      var3.c();
      Unknown246 var4 = new Unknown246();
      var3.a(var4);
      var3.d(25, 0);
      var3.visit(183, "java/lang/Object", "<init>", "()V", false);
      var3.a(177);
      Unknown246 var5 = new Unknown246();
      var3.a(var5);
      var3.b(1, 1);
      var3.e();
   }

   private static byte[] a(
      String var0, String var1, Class var2, String var3, String var4, String var5, String var6, String var7, String var8, boolean var9, boolean var10
   ) {
      Unknown177 var11 = new Unknown177(0);
      a(var11, var0, var1, var2);
      a(var11);
      a(var11, var3, var4, var5, var6, var7, var8, var9, var10);
      return b(var11);
   }

   static Class a(
      ClassLoader var0,
      String var1,
      String var2,
      Class var3,
      String var4,
      String var5,
      String var6,
      String var7,
      String var8,
      String var9,
      boolean var10,
      boolean var11
   ) {
      byte[] var16 = a(var2, var1, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      return a(var0, var2, var16);
   }

   private static Unknown357[] c(String var0) {
      return Unknown357.e(var0);
   }
}
