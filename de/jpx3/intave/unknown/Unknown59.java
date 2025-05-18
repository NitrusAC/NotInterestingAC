package de.jpx3.intave.unknown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.bukkit.command.CommandSender;

public final class Unknown59 {
   private static final Map a = new HashMap();

   public static List b(CommandSender var0, Class var1, String var2, String var3) {
      if (!var1.isEnum()) {
         Unknown405 var13 = (Unknown405)a.get(var1);
         return var13 == null ? Collections.emptyList() : var13.a(var0);
      } else {
         Enum[] var7 = (Enum[])var1.getEnumConstants();
         ArrayList var8 = new ArrayList();

         for(Enum var12 : var7) {
            var8.add(a(var12.name()));
         }

         return var8;
      }
   }

   private static String a(String var0) {
      return b(var0.toLowerCase(Locale.ROOT).replace("_", ""));
   }

   private static String b(String var0) {
      return var0.substring(0, 1).toUpperCase(Locale.ROOT) + var0.substring(1).toLowerCase(Locale.ROOT);
   }

   private static String b(Enum var0) {
      return a(var0.name());
   }

   public static Object a(CommandSender var0, Class var1, String var2, String var3) {
      if (!var1.isEnum()) {
         Unknown405 var12 = (Unknown405)a.get(var1);
         return var12 == null ? "Invalid type: " + var1 : var12.a(var0, var2, var3);
      } else {
         Enum[] var7 = (Enum[])var1.getEnumConstants();

         for(Enum var11 : var7) {
            if (var11.name().equalsIgnoreCase(var2) || a(var11.name()).equalsIgnoreCase(var2)) {
               return var11;
            }
         }

         List var13 = (List)Arrays.stream(var7).map(Unknown59::b).collect(Collectors.toList());
         return "Unknown element \"" + var2 + "\": Expected " + a(var13);
      }
   }

   private static String a(List var0) {
      int var4 = var0.size();
      if (var4 == 0) {
         return "nothing";
      } else {
         return var4 == 1 ? "only " + (String)var0.get(0) : "either " + String.join(", ", var0.subList(0, var4 - 1)) + " or " + (String)var0.get(var4 - 1);
      }
   }

   static {
      a(Unknown404.class);
      a(Unknown382.class);
      a(Unknown341.class);
      a(Unknown381.class);
      a(Unknown385.class);
   }

   private static void a(Class var0) {
      Unknown405 var1;
      try {
         var1 = (Unknown405)var0.newInstance();
      } catch (IllegalAccessException | InstantiationException var3) {
         throw new IllegalStateException(var3);
      }

      a.put(var1.a(), var1);
   }
}
