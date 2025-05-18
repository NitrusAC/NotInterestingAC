package de.jpx3.intave.unknown;

import de.jpx3.intave.Relocate;
import java.io.PrintStream;

@Relocate
public final class Unknown21 {
   private static PrintStream a;
   private static final String c;

   public static void b() {
      a = System.out;
      System.setOut(new Unknown71(a));
   }

   public static void a() {
      if (System.out instanceof Unknown71) {
         System.setOut(a);
         a = null;
      } else {
         System.out.println("[Intave] Invalid print-stream usage: Please contact support");
      }

   }
}
