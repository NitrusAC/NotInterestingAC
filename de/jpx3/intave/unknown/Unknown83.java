package de.jpx3.intave.unknown;

import de.jpx3.intave.C;
import de.jpx3.intave.cc;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.function.Function;

public final class Unknown83 {
   private static int a = 0;

   private static native String b(URL var0, String var1, long var2);

   public static HTTPRequest a(File var0, HTTPRequest var1) {
      return new Unknown41(var0, var1);
   }

   public static HTTPRequest a(HTTPRequest var0) {
      return new Unknown107(var0);
   }

   private static native long d();

   public static HTTPRequest b(File var0) {
      return a(var0).a(var0).b(var0);
   }

   public static HTTPRequest c(File var0) {
      return a(var0).b(var0);
   }

   public static HTTPRequest b(HTTPRequest var0) {
      return var0;
   }

   public static native HTTPRequest a(URL var0, String var1, long var2);

   public static HTTPRequest a(String var0, String var1, long var2) {
      try {
         return a(new URL(var0), var1, var2);
      } catch (MalformedURLException var5) {
         throw new IllegalStateException(var5);
      }
   }

   static HTTPRequest b(File var0, HTTPRequest var1) {
      return new C(var1, var0);
   }

   public static HTTPRequest a(HTTPRequest var0, int var1) {
      return new Unknown285(var0, var1);
   }

   public static HTTPRequest a(URL var0) {
      return new Unknown333(var0);
   }

   private static File a(String var0) {
      String var3 = System.getProperty("os.name").toLowerCase(Locale.ROOT);
      String var5;
      if (var3.contains("win")) {
         var5 = System.getenv("APPDATA") + "/Intave/Cache/";
      } else {
         var5 = System.getProperty("user.home") + "..intave.cache.";
      }

      File var4 = new File(var5 + "/" + (var0.length() > 4 ? var0.substring(0, 4) : "????") + "/");
      if (!var4.exists()) {
         var4.mkdirs();
      }

      return new File(var4, var0.length() > 4 ? var0.substring(4) : var0);
   }

   static HTTPRequest a(File var0, Function var1, int var2) {
      return new Unknown42(var0, var1, var2);
   }

   public static HTTPRequest a(File var0) {
      return new Unknown387(var0);
   }

   public static HTTPRequest a(String var0, HTTPRequest var1) {
      HTTPRequest var5 = a(new File(var0 + ".hash"));
      return new cc(var0, var1, var5);
   }
}
