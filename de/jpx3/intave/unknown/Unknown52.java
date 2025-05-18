package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.bu;
import de.jpx3.intave.cl;
import de.jpx3.intave.jQ;
import de.jpx3.intave.lN;
import de.jpx3.intave.unknown.asm.Asm35;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class Unknown52 {
   static final String f = b(Unknown66.class.getName());
   static final String b = b(Unknown55.class.getName());
   private boolean j;
   static final String i = b(Unknown213.class.getName());
   static final String a = b(Unknown61.class.getName());
   static final String c = b(Unknown380.class.getName());
   private List e;
   private static final String d;
   private List g;
   static final String h = b(Unknown96.class.getName());
   private boolean k = false;

   private static String b(String var0) {
      return var0.replace('.', '/');
   }

   public List b() {
      return this.e;
   }

   private static void b(Unknown52 var0, Unknown48 var1) {
      a(var0, var1);
   }

   static Map a(List var0) {
      if (var0 == null) {
         return ImmutableMap.of();
      } else {
         HashMap var4 = new HashMap();

         for(int var5 = 0; var5 < var0.size(); var5 += 2) {
            var4.put((String)var0.get(var5), var0.get(var5 + 1));
         }

         return ImmutableMap.copyOf(var4);
      }
   }

   public static Unknown52 a(Asm35 var0) {
      Unknown52 var1 = new Unknown52();
      var0.i.forEach(Unknown52::c);
      return var1;
   }

   public List d() {
      return this.g;
   }

   static String a(Unknown48 var0) {
      return b(Unknown357.a(var0.e).b());
   }

   private static void c(Unknown52 var0, Unknown48 var1) {
      a(var0, var1);
   }

   public static Unknown52 b(Unknown336 var0) {
      Unknown52 var1 = new Unknown52();
      a(var0).forEach(Unknown52::b);
      var1.g = ImmutableList.copyOf(var1.g);
      var1.e = ImmutableList.copyOf(var1.e);
      return var1;
   }

   public bu a(String var1, String var2, String var3) {
      cl var4 = null;
      bu var5 = null;

      for(cl var7 : this.g) {
         for(bu var9 : var7.a()) {
            if (var9.a(var1, var2, var3)) {
               var5 = var9;
               var4 = var7;
               break;
            }
         }
      }

      return var4 == null ? null : var4.a(var5);
   }

   public boolean a() {
      return this.j;
   }

   private static void a(Unknown52 var0, Unknown48 var1) {
      String var5 = a(var1);
      if (var5.equals(a)) {
         var0.k = true;
      } else if (var5.equals(b)) {
         var0.g.add(cl.a(var1));
      } else if (var5.equals(f)) {
         var0.e.add(jQ.a(var1));
      }

      if (var5.equals(i)) {
         var0.j = true;
      }

   }

   private static List a(Unknown336 var0) {
      ArrayList var1 = new ArrayList();
      var1.addAll(var0.q == null ? Collections.emptyList() : var0.q);
      var1.addAll(var0.f == null ? Collections.emptyList() : var0.f);
      return var1;
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   static String a(cl var0, bu var1) {
      String var4 = Unknown206.a;
      String var5 = null;
      ArrayList var6 = new ArrayList();

      for(bu var8 : var0.a()) {
         var6.add(var8.a());
      }

      var6.sort(Comparator.comparingInt(Unknown52::a).reversed());
      boolean var10 = var6.contains(var4);
      switch(lN.a[var0.b().ordinal()]) {
         case 1:
            if (!var10) {
               return var1.a();
            }

            var5 = var4;
            break;
         case 2:
            if (!var10) {
               throw new Unknown145("Unable to find translation for version " + var4 + " when referring to " + var1.b() + "#" + var1.d() + var1.a());
            }

            var5 = var4;
            break;
         case 3:
            for(String var13 : var6) {
               if (var5 == null || a(var5, var13) && !a(var13, var4)) {
                  var5 = var13;
               }
            }

            if (var5 == null) {
               throw new IllegalStateException("Something went a bit wrong here");
            }
            break;
         case 4:
            for(String var9 : var6) {
               if ((var5 == null || a(var5, var9)) && var5 == null || !a(var5, var4)) {
                  var5 = var9;
               }
            }

            if (var5 == null) {
               throw new IllegalStateException("Something went a bit wrong here");
            }
      }

      return var5;
   }

   Unknown52() {
      this.j = false;
      this.g = new ArrayList();
      this.e = new ArrayList();
   }

   public boolean c() {
      return this.k;
   }

   private static int a(String var0) {
      String var3 = var0.replaceAll("[^\\d.]", "");
      return Integer.parseInt(var3);
   }

   private static boolean a(String var0, String var1) {
      return a(var0) < a(var1);
   }
}
