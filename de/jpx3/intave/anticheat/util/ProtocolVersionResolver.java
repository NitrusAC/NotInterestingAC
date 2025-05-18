package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import de.jpx3.intave.unknown.Unknown208;
import de.jpx3.intave.unknown.Unknown314;
import de.jpx3.intave.unknown.Unknown83;
import java.util.concurrent.TimeUnit;

public final class ProtocolVersionResolver {
   private static final HTTPRequest a = Unknown83.a("https:..service.intave.de.protocolversions", "protocolversions", TimeUnit.DAYS.toMillis(14L));
   private static final Unknown208 b = new Unknown208();
   private static final Unknown314 c = (Unknown314)b.a(a);

   public static int a(String var0) {
      throw new UnsupportedOperationException("Not implemented yet");
   }

   public static String a(int var0) {
      return c.a(var0);
   }
}
