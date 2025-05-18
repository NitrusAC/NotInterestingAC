package de.jpx3.intave.unknown;

import de.jpx3.intave.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;

final class Unknown282 {
   private static final String d = Bukkit.getServer().getClass().getPackage().getName();
   private static final String a = d.replace("org.bukkit.craftbukkit", "").replace(".", "");
   private static final String b = d.replace("org.bukkit.craftbukkit", "net.minecraft.server");
   private static final Pattern c = Pattern.compile("\\{([^}]+)}");

   public static Unknown46 a(String var0, Class var1, int var2) {
      return a(a(var0), var1, var2);
   }

   public static Unknown46 a(Class var0, String var1, Class var2) {
      return a(var0, var1, var2, 0);
   }

   public static Unknown269 a(String var0, String var1, Class[] var2) {
      return a(a(var0), var1, null, var2);
   }

   public static Unknown46 a(Class var0, Class var1, int var2) {
      return a(var0, null, var1, var2);
   }

   public static Unknown46 a(String var0, String var1, Class var2) {
      return a(a(var0), var1, var2, 0);
   }

   private static Object b(Constructor var0, Object[] var1) {
      try {
         return var0.newInstance(var1);
      } catch (Exception var5) {
         throw new RuntimeException("Cannot invoke constructor " + var0, var5);
      }
   }

   public static Class e(String var0) {
      return a(var0);
   }

   private Unknown282() {
   }

   public static m a(String var0, Class[] var1) {
      return a(a(var0), var1);
   }

   private static String f(String var0) {
      StringBuffer var3 = new StringBuffer();

      Matcher var4;
      String var7;
      for(var4 = c.matcher(var0); var4.find(); var4.appendReplacement(var3, Matcher.quoteReplacement(var7))) {
         String var5 = var4.group(1);
         var7 = "";
         if ("nms".equalsIgnoreCase(var5)) {
            var7 = b;
         } else if ("obc".equalsIgnoreCase(var5)) {
            var7 = d;
         } else {
            if (!"version".equalsIgnoreCase(var5)) {
               throw new IllegalArgumentException("Unknown variable: " + var5);
            }

            var7 = a;
         }

         if (var7.length() > 0 && var4.end() < var0.length() && var0.charAt(var4.end()) != '.') {
            var7 = var7 + ".";
         }
      }

      var4.appendTail(var3);
      return var3.toString();
   }

   private static Unknown46 a(Class var0, String var1, Class var2, int var3) {
      for(Field var9 : var0.getDeclaredFields()) {
         if ((var1 == null || var9.getName().equals(var1)) && var2.isAssignableFrom(var9.getType()) && var3-- <= 0) {
            var9.setAccessible(true);
            return new Unknown276(var9);
         }
      }

      if (var0.getSuperclass() != null) {
         return a(var0.getSuperclass(), var1, var2, var3);
      } else {
         throw new IllegalArgumentException("Cannot find field " + var1 + " with type " + var2 + " in " + var0);
      }
   }

   public static Unknown269 a(Class var0, String var1, Class[] var2) {
      return a(var0, var1, null, var2);
   }

   public static Class a(String var0) {
      return b(f(var0));
   }

   private static Class b(String var0) {
      return Unknown244.c(var0);
   }

   public static Class c(String var0) {
      return b(d + "." + var0);
   }

   private static Object a(Method var0, Object var1, Object[] var2) {
      try {
         return var0.invoke(var1, var2);
      } catch (Exception var6) {
         throw new RuntimeException("Cannot invoke method " + var0, var6);
      }
   }

   public static Class d(String var0) {
      return Unknown244.b(var0);
   }

   public static m a(Class var0, Class[] var1) {
      for(Constructor var8 : var0.getDeclaredConstructors()) {
         if (Arrays.equals(var8.getParameterTypes(), var1)) {
            var8.setAccessible(true);
            return Unknown282::b;
         }
      }

      throw new IllegalStateException(String.format("Unable to find constructor for %s (%s).", var0, Arrays.asList(var1)));
   }

   public static Unknown269 a(Class var0, String var1, Class var2, Class[] var3) {
      for(Method var9 : var0.getDeclaredMethods()) {
         if ((var1 == null || var9.getName().equals(var1))
            && (var2 == null || var9.getReturnType().equals(var2))
            && Arrays.equals(var9.getParameterTypes(), var3)) {
            var9.setAccessible(true);
            return Unknown282::a;
         }
      }

      if (var0.getSuperclass() != null) {
         return a(var0.getSuperclass(), var1, var3);
      } else {
         throw new IllegalStateException(String.format("Unable to find method %s (%s).", var1, Arrays.asList(var3)));
      }
   }
}
