package de.jpx3.intave.unknown;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Predicate;
import org.bukkit.Material;

public final class Unknown253 {
   public static Set a(Predicate var0) {
      EnumSet var1 = EnumSet.noneOf(Material.class);

      for(Material var5 : Material.values()) {
         if (var0.test(var5)) {
            var1.add(var5);
         }
      }

      return var1;
   }

   private static boolean b(String var0, Material var1) {
      return var1.name().toLowerCase().contains(var0.toLowerCase());
   }

   public static Set a(String var0) {
      return a(Unknown253::b);
   }
}
