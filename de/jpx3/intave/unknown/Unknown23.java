package de.jpx3.intave.unknown;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class Unknown23 {
   private static final String d;
   private static final List a = Lists.newArrayList();

   public static Class a(
      ClassLoader var0, Class var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, boolean var9, boolean var10
   ) {
      return Unknown78.a(var0, var2, a(), var1, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   private static synchronized String a() {
      String var3;
      do {
         var3 = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase(Locale.ROOT).substring(0, 8);
      } while(a.contains(var3));

      a.add(var3);
      return "de/jpx3/intave/irx0x000000000054" + var3;
   }
}
