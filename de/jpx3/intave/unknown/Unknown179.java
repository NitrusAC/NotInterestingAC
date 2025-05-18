package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.google.common.collect.Maps;
import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public enum Unknown179 {
   public static final Unknown179 a = new Unknown179(0);
   private static final Unknown179[] g = new Unknown179[]{a, Unknown179.b, Unknown179.c, Unknown179.d, Unknown179.e};
   private static final Method i;
   public static final Unknown179 d = new Unknown179(3);
   public static final Unknown179 e = new Unknown179(4);
   private static final Map f = Maps.newConcurrentMap();
   private final int j;
   public static final Unknown179 c = new Unknown179(2);
   private static final Class h = ReflectionUtil.getClazz("PacketPlayOutPosition$EnumPlayerTeleportFlags");
   public static final Unknown179 b = new Unknown179(1);

   private static Set b(int var0, Integer var1) {
      try {
         return (Set)i.invoke(null, var0);
      } catch (IllegalAccessException | InvocationTargetException var5) {
         throw new IllegalStateException("Something is wrong");
      }
   }

   private static int b(Set var0) {
      int var5 = 0;

      for(Unknown179 var7 : var0) {
         var5 |= var7.d();
      }

      return var5;
   }

   public static Set a(PacketContainer var0) {
      return (Set)var0.getSets(EnumWrappers.getGenericConverter(h, Unknown179.class)).read(0);
   }

   public static Set a() {
      return a(24);
   }

   public static Set a(int var0) {
      return (Set)f.computeIfAbsent(var0, Unknown179::b);
   }

   private boolean b(int var1) {
      return (var1 & this.d()) == this.d();
   }

   static {
      try {
         Class var10000 = h;
         Class[] var10003 = new Class[]{Integer.TYPE};
         i = var10000.getMethod(qd.b("a", var10000, var10003), var10003);
      } catch (NoSuchMethodException var12) {
         throw new IllegalStateException(var12);
      }
   }

   public static Set a(Set var0) {
      return a(b(var0));
   }

   public static Set b() {
      return a(31);
   }

   private Unknown179(int var3) {
      this.j = var3;
   }

   public static Set c() {
      return a(7);
   }

   private int d() {
      return 1 << this.j;
   }
}
