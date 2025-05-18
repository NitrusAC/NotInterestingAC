package de.jpx3.intave.unknown;

import de.jpx3.intave.Relocate;
import java.io.OutputStream;
import java.io.PrintStream;

@Relocate
public final class Unknown71 extends PrintStream {
   public static boolean a = false;
   private static final String c;

   public Unknown71(OutputStream var1) {
      super(var1);
   }

   public void println(String var1) {
      if (var1 != null && var1.startsWith("[Interceptor]")) {
         a = true;
      }

      super.println(var1);
   }
}
