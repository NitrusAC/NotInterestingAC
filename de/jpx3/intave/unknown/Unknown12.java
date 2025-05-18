package de.jpx3.intave.unknown;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import org.bukkit.Bukkit;

public final class Unknown12 {
   private static String encryptionKey = "";
   private static final String VERSION = "14.4.4";
   private static final String URL_TARGET_LAYOUT = "https://service.intave.de/relocate/download?id=%s";
   private static String licenseName = "";
   private static File integrityRuntimeFolder;

   private static void log(String var0) {
      Bukkit.getLogger().log(Level.INFO, "[Intave/Setup] " + var0);
   }

   private static native String e();

   private static native boolean b();

   private static native String j(File var0);

   public static native void i();

   private static native void d() throws Exception;

   public static native void a();

   public static native File h(String var0, String var1);

   private static native File f();

   private static native void c() throws Exception;

   public static native InputStream g(String var0);
}
