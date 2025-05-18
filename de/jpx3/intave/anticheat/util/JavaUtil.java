package de.jpx3.intave.anticheat.util;

public final class JavaUtil {
   public static int getJavaVersion() {
      String var2 = System.getProperty("java.version");
      if (var2.startsWith("1.")) {
         var2 = var2.substring(2, 3);
      } else {
         int var3 = var2.indexOf(".");
         if (var3 != -1) {
            var2 = var2.substring(0, var3);
         }
      }

      return Integer.parseInt(var2);
   }
}
