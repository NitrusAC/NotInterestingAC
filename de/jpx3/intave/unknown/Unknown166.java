package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveBootFailureException;
import de.jpx3.intave.anticheat.IntavePlugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Locale;
import java.util.UUID;
import org.bukkit.configuration.file.YamlConfiguration;

public final class Unknown166 {
   private final String b;
   private final Unknown133 a = new Unknown133("configuration-states", true);
   private static final String c = "x";
   private YamlConfiguration e;
   private static final String f;

   public void a(String var1, boolean var2) {
      if (var1 != null && !var1.equals("")) {
         var1 = var1.replace('\\', '/');
         InputStream var6 = this.c(var1);
         if (var6 == null) {
            throw new IllegalArgumentException("The embedded resource '" + var1 + "' cannot be found");
         } else {
            File var7 = IntavePlugin.getInstance().r();
            File var8 = new File(var7, var1);
            int var9 = var1.lastIndexOf(47);
            File var10 = new File(var7, var1.substring(0, Math.max(var9, 0)));
            if (!var10.exists()) {
               var10.mkdirs();
            }

            try {
               if (!var8.exists() || var2) {
                  OutputStream var11 = Files.newOutputStream(var8.toPath());
                  byte[] var12 = new byte[1024];

                  int var13;
                  while((var13 = var6.read(var12)) != -1) {
                     var11.write(var12, 0, var13);
                  }

                  var11.close();
                  var6.close();
               }
            } catch (IOException var14) {
            }

         }
      } else {
         throw new IllegalArgumentException("ResourcePath cannot be null or empty");
      }
   }

   public void i() {
      YamlConfiguration var4;
      if (!this.c()) {
         var4 = this.a();
         if (var4 == null) {
            try {
               var4 = (YamlConfiguration)this.j();
            } catch (IllegalStateException var6) {
               throw new IllegalStateException("Unable to prepare configuration");
            }
         } else {
            this.a(var4);
         }
      } else {
         try {
            var4 = (YamlConfiguration)this.j();
         } catch (IllegalStateException var7) {
            var4 = this.a();
            if (var4 == null) {
               throw var7;
            }

            this.a(var4);
         }
      }

      this.e = var4;
   }

   public Unknown166(String var1) {
      this.b = var1;
   }

   public native void b();

   private File h() {
      String var5 = System.getProperty("os.name").toLowerCase(Locale.ROOT);
      File var4;
      if (var5.contains("win")) {
         var4 = new File(System.getenv("APPDATA") + "/Intave");
      } else {
         var4 = new File(System.getProperty("user.home") + "..intave.");
      }

      if (!var4.exists()) {
         var4.mkdir();
      }

      return var4;
   }

   public native void a(int var1);

   public YamlConfiguration k() {
      return this.e;
   }

   private YamlConfiguration a() {
      try {
         boolean var5 = "file".equalsIgnoreCase(this.b);
         Object var4;
         if (var5) {
            IntavePlugin var6 = IntavePlugin.getInstance();
            File var7 = new File(var6.r(), "settings.yml");
            if (!var7.exists()) {
               if (var6.getResource("settings.yml") == null) {
                  throw new IntaveBootFailureException("Please download Intave again to use file configurations");
               }

               this.a("settings.yml", false);
            }

            var4 = new FileInputStream(var7);
         } else {
            URL var9 = new URL("https:..service.intave.de.settings.download");
            URLConnection var10 = var9.openConnection();
            var10.addRequestProperty("User-Agent", "Intave/" + IntavePlugin.m());
            var10.addRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
            var10.setUseCaches(false);
            var10.addRequestProperty("Pragma", "no-cache");
            var10.addRequestProperty("Identifier", Unknown60.b());
            var10.addRequestProperty("ConfigKey", this.b);
            var10.setConnectTimeout(3000);
            var10.setReadTimeout(3000);
            var10.connect();
            var4 = var10.getInputStream();
         }

         return YamlConfiguration.loadConfiguration(new InputStreamReader((InputStream)var4));
      } catch (Exception var8) {
         return null;
      }
   }

   private native void a(Object var1);

   public native int e();

   private static void b(StringBuilder var0, String var1, Integer var2) {
      var0.append(var1).append(":").append(var2).append("\r\n");
   }

   public boolean c() {
      return this.g().exists();
   }

   public void f() {
      this.g().delete();
   }

   public InputStream c(String var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Filename cannot be null");
      } else {
         try {
            URL var5 = this.getClass().getClassLoader().getResource(var1);
            if (var5 == null) {
               return null;
            } else {
               URLConnection var6 = var5.openConnection();
               var6.setUseCaches(false);
               return var6.getInputStream();
            }
         } catch (IOException var7) {
            return null;
         }
      }
   }

   public File g() {
      String var5 = new UUID((long)this.b.length() << 8 | (long)(this.b.hashCode() >>> 1), (long)(~this.b.hashCode())).toString();
      var5 = var5 + "x";
      return new File(this.h(), var5);
   }

   private native Object j();
}
