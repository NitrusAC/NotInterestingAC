package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.threading.BackgroundThreadingPool;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.Consumer;

public final class Unknown250 {
   public static Map a = new WeakHashMap();

   private static void b(Consumer var0) {
      HashMap var1 = new HashMap();
      HashSet var2 = new HashSet();
      a.forEach(Unknown250::a);
      var2.clear();
      var0.accept(var1);
   }

   public static Object a(String var0, Object var1) {
      if (a()) {
         a.put(var0, var1);
      }

      return var1;
   }

   public static long a(Object var0, Collection var1) {
      String var5 = var0.getClass().getName();
      if (!var1.contains(var0) && !var5.contains("org.bukkit") && !var5.contains("craftbukkit") && !var5.contains("net.minecraft")) {
         var1.add(var0);
         long var6 = Unknown147.b().getObjectSize(var0);
         if (var0 instanceof Map) {
            for(Object var9 : ((Map)var0).keySet()) {
               var6 += a(var9, var1);
            }

            for(Object var17 : ((Map)var0).values()) {
               var6 += a(var17, var1);
            }
         }

         if (var0 instanceof Iterable) {
            for(Object var10 : (Iterable)var0) {
               var6 += a(var10, var1);
            }
         }

         for(Field var11 : var0.getClass().getDeclaredFields()) {
            try {
               var11.setAccessible(true);
               var6 += a(var11.get(var0), var1);
            } catch (Exception var13) {
            }
         }

         return var6;
      } else {
         return 0L;
      }
   }

   public static long a(Object var0, Map var1, Collection var2) {
      String var6 = var0.getClass().getName();
      if (!var2.contains(var0) && !var6.contains("org.bukkit") && !var6.contains("craftbukkit") && !var6.contains("net.minecraft")) {
         var2.add(var0);
         long var7 = Unknown147.b().getObjectSize(var0);

         for(Field var12 : var0.getClass().getDeclaredFields()) {
            try {
               if (!var12.isAccessible()) {
                  var12.setAccessible(true);
               }

               var7 += a(var12.get(var0), var1, var2);
            } catch (Exception var14) {
            }
         }

         var1.put(var6, var7);
         return var7;
      } else {
         return 0L;
      }
   }

   public static void c(Consumer var0) {
      if (a()) {
         BackgroundThreadingPool.submit(Unknown250::b);
      }
   }

   public static boolean a() {
      return Unknown147.a();
   }

   private static void a(Map var0, Set var1, String var2, Object var3) {
      Long var10000 = (Long)var0.put(var2, a(var3, var1));
   }
}
