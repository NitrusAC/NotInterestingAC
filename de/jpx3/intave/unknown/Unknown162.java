package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.util.HashMap;
import java.util.Map;

public final class Unknown162 {
   private static final Map a = new HashMap();

   public static void a(String var0, HTTPRequest var1) {
      a.put(var0, var1);
   }

   public static Map a() {
      return a;
   }
}
