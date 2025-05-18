package de.jpx3.intave.unknown;

import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.reflection.ClassLocation;
import de.jpx3.intave.anticheat.reflection.FieldLocation;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class Unknown244 {
   private static final Unknown117 e = Unknown244.b.b();
   private static final Map c = new ConcurrentHashMap();
   private static final Map g = new ConcurrentHashMap();
   private static final Map h = new ConcurrentHashMap();
   private static final Unknown264 b = ((Unknown264)Unknown43.a().a(Unknown244.d)).d();
   private static final HTTPRequest d = Unknown83.a("https:..service.intave.de.locate." + IntavePlugin.m(), "locate", TimeUnit.DAYS.toMillis(14L));
   private static final Unknown238 f = b.a();
   private static final Unknown9 a = b.c();

   public static Field d(String var0, String var1) {
      String var2 = var0 + "." + var1;
      FieldLocation var3 = (FieldLocation)g.computeIfAbsent(var2, Unknown244::a);
      return var3.a();
   }

   public static String e(String var0, String var1, String var2) {
      var0 = var0.replace("/", ".");
      String var5;
      if (var0.startsWith("net.minecraft.server.v")) {
         var5 = a(var0.split("\\.")[4], var1 + var2);
      } else if (var0.startsWith("net.minecraft")) {
         String[] var6 = var0.split("\\.");
         String var7 = var6[var6.length - 1];
         var5 = a(var7, var1 + var2);
      } else {
         var5 = var1;
      }

      return var5;
   }

   public static String e(String var0, String var1) {
      String var2 = var0 + "." + var1;
      FieldLocation var3 = (FieldLocation)g.computeIfAbsent(var2, Unknown244::c);
      return var3.c();
   }

   public static void b() {
      h.clear();
      c.clear();
      g.clear();
   }

   private static Unknown98 h(String var0, String var1) {
      return Unknown98.a(var0, var1);
   }

   public static String a(String var0, String var1) {
      String var2 = var0 + "." + var1;
      Unknown98 var3 = (Unknown98)c.computeIfAbsent(var2, Unknown244::b);
      return var3.a();
   }

   private static FieldLocation a(String var0, String var1, String var2) {
      return c(var0, var1);
   }

   private static FieldLocation c(String var0, String var1, String var2) {
      return c(var0, var1);
   }

   private static Unknown98 d(String var0, String var1, String var2) {
      return g(var0, var1);
   }

   public static void a() {
      Unknown86.b(Unknown244::b);
   }

   private static FieldLocation c(String var0, String var1) {
      return (FieldLocation)e.b(var0).a(var1).c().findAny().orElseGet(Unknown244::i);
   }

   public static Class c(String var0) {
      if (var0.startsWith("net.minecraft.server.v")) {
         return b(var0.split("\\.")[4]);
      } else {
         try {
            return Class.forName(qd.a(var0));
         } catch (ClassNotFoundException var4) {
            throw new IllegalArgumentException("Unsupported class " + var0);
         }
      }
   }

   public static Method f(String var0, String var1) {
      String var2 = var0 + "." + var1;
      Unknown98 var3 = (Unknown98)c.computeIfAbsent(var2, Unknown244::d);
      return var3.g();
   }

   private static Unknown98 b(String var0, String var1, String var2) {
      return g(var0, var1);
   }

   public static String b(String var0, String var1) {
      var0 = var0.replace("/", ".");
      String var4;
      if (var0.startsWith("net.minecraft.server.v")) {
         var4 = e(var0.split("\\.")[4], var1);
      } else {
         var4 = var1;
      }

      return var4;
   }

   private static ClassLocation e(String var0) {
      return f.a(var0).a(Unknown244::f);
   }

   public static String g(String var0) {
      return d(var0).a();
   }

   public static Class b(String var0) {
      return d(var0).c();
   }

   public static String a(String var0) {
      var0 = var0.replace("/", ".");
      String var3;
      if (var0.startsWith("net.minecraft.server.v")) {
         var3 = g(var0.split("\\.")[4]);
      } else {
         var3 = var0;
      }

      return var3.replace(".", "/");
   }

   private static FieldLocation i(String var0, String var1) {
      return FieldLocation.a(var0, var1);
   }

   private static ClassLocation d(String var0) {
      return (ClassLocation)h.computeIfAbsent(var0, Unknown244::e);
   }

   private static ClassLocation f(String var0) {
      return ClassLocation.a(var0);
   }

   private static Unknown98 g(String var0, String var1) {
      return a.a(var0).b(var1).a(Unknown244::h);
   }
}
