package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class Unknown334 {
   public static final Unknown82 b = new Unknown82();
   public static final Unknown231 a = new Unknown231();
   private static final String d;

   public static Unknown373 a(Unknown373[] var0) {
      HashMap var4 = Maps.newHashMap();

      for(Unknown373 var8 : var0) {
         if (var8 != null) {
            var4.putAll(var8.build());
         }
      }

      ImmutableMap var9 = ImmutableMap.copyOf(var4);
      return Unknown334::b;
   }

   public static String a(String var0, Unknown373[] var1) {
      return a(var0, a(var1).build());
   }

   private static String a(String var0, Map var1) {
      if (var0 != null && !var0.isEmpty()) {
         for(Entry var6 : var1.entrySet()) {
            String var7 = (String)var6.getValue();
            var0 = var0.replaceAll("\\{" + (String)var6.getKey() + "}", var7);
            var0 = var0.replaceAll("%" + (String)var6.getKey() + "%", var7);
         }

         return var0;
      } else {
         return "";
      }
   }

   private Unknown334() {
      throw new IllegalStateException();
   }

   private static Map b(Map var0) {
      return var0;
   }

   public static String a(String var0, Collection var1) {
      return a(var0, (Unknown373[])var1.toArray(new Unknown373[0]));
   }
}
