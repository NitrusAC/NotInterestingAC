package de.jpx3.intave.unknown;

import de.jpx3.intave.bu;
import de.jpx3.intave.unknown.asm.Asm35;
import de.jpx3.intave.unknown.asm.Asm37;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;

final class Unknown206 {
   public static final String a;
   public static final String b = b(Unknown61.class.getName());

   private static void a(List var0) {
      for(Unknown336 var2 : var0) {
         c(var2);
      }

   }

   private static void b(Unknown336 var0) {
      Unknown52 var3 = Unknown52.b(var0);
      if (var3.a()) {
         if (!var3.c()) {
            throw new IllegalStateException("Custom translations not yet supported for parameters");
         } else {
            var0.B = null;
            var0.C = a(var0.C);
         }
      }
   }

   private static void c(Unknown336 var0) {
      b(var0);
      a(var0);
   }

   private static void c(Asm35 var0) {
      var0.e = a(var0.e);
      String[] var1 = (String[])var0.v.toArray(new String[0]);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         String var3 = a(var1[var2]);
         var1[var2] = var3;
      }

      var0.v = (List)Arrays.stream(var1).collect(Collectors.toList());
   }

   public static byte[] a(byte[] var0) {
      Asm35 var1 = b(var0);
      c(var1);
      a(b(var1));
      return a(var1);
   }

   private static List b(Asm35 var0) {
      return (List)var0.x.stream().filter(Unknown206::d).collect(Collectors.toList());
   }

   private static Unknown251 a(Unknown251 var0, Unknown52 var1) {
      bu var2 = var1.a(Unknown251.b(var0), Unknown251.a(var0), Unknown251.d(var0));
      if (var2 == null) {
         if (var1.c()) {
            String var3 = Unknown251.a(var0);
            if (Unknown251.c(var0) == Unknown184.b) {
               var3 = Unknown244.b(Unknown251.b(var0), var3);
            }

            if (Unknown251.c(var0) == Unknown184.a) {
               var3 = Unknown244.e(Unknown251.b(var0), var3, a(Unknown251.d(var0)));
            }

            return Unknown251.b(a(Unknown251.b(var0)), var3, a(Unknown251.d(var0)));
         } else {
            return var0;
         }
      } else {
         return Unknown251.a(var2);
      }
   }

   private static Unknown357 b(Unknown357[] var0, int var1) {
      return a(var0[var1]);
   }

   private static native boolean d(Unknown336 var0);

   private static String a(Unknown48 var0) {
      return b(Unknown357.a(var0.e).b());
   }

   private static String b(String var0) {
      return var0.replace('.', '/');
   }

   private static Asm35 b(byte[] var0) {
      Asm37 var1 = new Asm37(var0);
      Asm35 var2 = new Asm35();
      var1.a(var2, 4);
      return var2;
   }

   private static byte[] a(Asm35 var0) {
      Unknown177 var1 = new Unknown177(2);
      var0.a(var1);
      return var1.a();
   }

   private static String a(String var0) {
      if (var0.contains(".")) {
         throw new IllegalArgumentException("Input contains dot: " + var0);
      } else {
         String var3;
         if (var0.startsWith("L") && var0.endsWith(";")) {
            var3 = a(Unknown357.a(var0)).f();
         } else if (var0.startsWith("(") && var0.contains(")")) {
            Unknown357[] var7 = Unknown357.e(var0);
            Arrays.setAll(var7, Unknown206::b);
            Unknown357 var8 = a(Unknown357.f(var0));
            var3 = Unknown357.a(var8, var7);
         } else if (var0.contains("craftbukkit")) {
            int var4 = var0.indexOf("/v") + 1;
            int var5 = var0.indexOf("/", var4);
            if (var4 <= 0 || var5 <= 0) {
               return var0;
            }

            String var6 = var0.substring(var4, var5);
            var3 = var0.replace(var6, a);
         } else {
            var3 = Unknown244.a(var0);
         }

         return var3;
      }
   }

   private static Unknown357 a(Unknown357 var0) {
      int var1 = 0;
      if (var0.k() == 9) {
         var1 = var0.a();
         var0 = var0.e();
      }

      if (var0.k() == 10) {
         var0 = Unknown357.c(a(var0.h()));
      }

      return var0.a(var1);
   }

   private static native void a(Unknown336 var0);

   // $FF: Removed empty exception range
   static {
      String var11 = Bukkit.getServer().getClass().getPackage().getName();
      a = var11.substring(var11.lastIndexOf(".") + 1);
   }
}
