package de.jpx3.intave.unknown;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.entity.Player;

public final class Unknown390 {
   private static final Map b = new ConcurrentHashMap();
   private static final Set a = Unknown19.a(new HashSet());

   private static Set b(Unknown131 var0) {
      return new HashSet();
   }

   public static void a(Player var0, Unknown131 var1, boolean var2) {
      Set var7 = c(var1);
      if (var2) {
         var7.add(var0);
      } else {
         var7.remove(var0);
      }

   }

   public static Set c(Unknown131 var0) {
      return (Set)b.computeIfAbsent(var0, Unknown390::b);
   }

   public static Collection c() {
      return a;
   }

   public static void a(Player var0, boolean var1) {
      if (var1) {
         a.add(var0);
      } else {
         a.remove(var0);
      }

   }
}
