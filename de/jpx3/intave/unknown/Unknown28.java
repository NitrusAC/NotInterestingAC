package de.jpx3.intave.unknown;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class Unknown28 {
   private static Map a(Collection var0, String var1, int var2) {
      HashMap var6 = new HashMap();

      for(String var8 : var0) {
         int var9 = a(var8, var1.substring(0, Math.min(var1.length(), var8.length())));
         if (var9 < var2) {
            var6.put(var8, var9);
         }
      }

      return var6;
   }

   public static Unknown2 a(Collection var0, String var1) {
      Map var5 = a(var0, var1, 4);
      if (!var5.isEmpty()) {
         for(String var7 : var5.keySet()) {
            if (var1.equalsIgnoreCase(var7)) {
               return new Unknown2(Unknown73.a, Collections.singletonList(var7));
            }
         }

         if (var5.size() == 1) {
            String var11 = (String)var5.keySet().iterator().next();
            Integer var13 = (Integer)var5.values().iterator().next();
            return new Unknown2(var13 == 0 ? Unknown73.a : Unknown73.c, Collections.singletonList(var11));
         } else {
            Map var10 = a(var5);
            int var12 = var10.values().iterator().next();
            ArrayList var8 = new ArrayList();
            var10.forEach(Unknown28::b);
            Unknown73 var9 = var8.size() > 1 ? Unknown73.b : (var12 < 1 ? Unknown73.a : Unknown73.c);
            return new Unknown2(var9, var8);
         }
      } else {
         return Unknown2.b();
      }
   }

   private static int a(String var0, String var1) {
      return Unknown281.a(var0, var1, 0, 1, 2, 1);
   }

   private static Map a(Map var0) {
      ArrayList var4 = new ArrayList(var0.keySet());
      ArrayList var5 = new ArrayList(var0.values());
      Collections.sort(var5);
      Collections.sort(var4);
      LinkedHashMap var6 = new LinkedHashMap();

      for(Comparable var8 : var5) {
         Iterator var9 = var4.iterator();

         while(var9.hasNext()) {
            Comparable var10 = (Comparable)var9.next();
            if (((Comparable)var0.get(var10)).equals(var8)) {
               var9.remove();
               var6.put(var10, var8);
               break;
            }
         }
      }

      return var6;
   }

   private static void b(int var0, List var1, String var2, Integer var3) {
      if (var3 == var0 && var1.size() < 4) {
         var1.add(var2);
      }

   }
}
