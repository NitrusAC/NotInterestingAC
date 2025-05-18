package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.qd;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.unknown.Unknown244;
import de.jpx3.intave.unknown.Unknown357;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.bukkit.Bukkit;

public final class ReflectionUtil {
   private static final String craftBukkitVersion = Bukkit.getServer().getClass().getPackage().getName().substring(23);
   private static final String craftBukkitPath = "org.bukkit.craftbukkit." + craftBukkitVersion;

   public static Method getMethod(String var0, String var1, Class[] var2) {
      return a(var0, var1, var2, Void.TYPE);
   }

   private static String d(String var0) {
      return craftBukkitPath + "." + var0;
   }

   public static Method getMethod(String var0, String var1, Class var2) {
      return a(var0, var1, new Class[0], var2);
   }

   public static Method getMethod(String var0, String var1) {
      return Unknown244.f(var0, var1);
   }

   public static Method getMethod(String var0, String var1, Unknown357[] var2) {
      return getMethod(var0, var1 + Unknown357.a(Unknown357.b, var2));
   }

   public static Field getField(Class var0, String var1) {
      try {
         return var0.getDeclaredField(qd.c(var0, var1));
      } catch (NoSuchFieldException var3) {
         throw new IntaveInternalException(var3);
      }
   }

   public static Field getField(String var0, String var1) {
      return Unknown244.d(var0, var1);
   }

   public static Class b(String var0) {
      return classExists(d(var0));
   }

   private static Unknown357[] b(int var0) {
      return new Unknown357[var0];
   }

   public static Class getClazz(String var0) {
      return Unknown244.b(var0);
   }

   public static Method getMethod(String var0, String var1, Unknown357[] var2, Unknown357 var3) {
      return getMethod(var0, var1 + Unknown357.a(var3, var2));
   }

   private static Class classExists(String var0) {
      try {
         return Class.forName(qd.a(var0));
      } catch (ClassNotFoundException var2) {
         throw new IntaveInternalException(var2);
      }
   }

   public static String getCBVersion() {
      return craftBukkitVersion;
   }

   public static Method a(String var0, String var1, Class[] var2, Class var3) {
      Unknown357[] var8 = (Unknown357[])Arrays.stream(var2).map(Unknown357::c).toArray(ReflectionUtil::b);
      return getMethod(var0, var1 + Unknown357.a(Unknown357.c(var3), var8));
   }
}
