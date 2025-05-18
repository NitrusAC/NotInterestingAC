package de.jpx3.intave.anticheat.config;

import de.jpx3.intave.access.IntaveBootFailureException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.unknown.Unknown166;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public final class ConfigLoader {
   private final Unknown166 c;
   private final String b;
   private final IntavePlugin a;

   public InputStream b(String var1) {
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

   public void a(String var1, boolean var2) {
      if (var1 != null && !var1.equals("")) {
         var1 = var1.replace('\\', '/');
         InputStream var6 = this.b(var1);
         if (var6 == null) {
            throw new IllegalArgumentException("The embedded resource '" + var1 + "' cannot be found");
         } else {
            File var7 = new File(this.a.r(), var1);
            int var8 = var1.lastIndexOf(47);
            File var9 = new File(this.a.r(), var1.substring(0, Math.max(var8, 0)));
            if (!var9.exists()) {
               var9.mkdirs();
            }

            try {
               if (!var7.exists() || var2) {
                  FileOutputStream var10 = new FileOutputStream(var7);
                  byte[] var11 = new byte[1024];

                  int var12;
                  while((var12 = var6.read(var11)) != -1) {
                     var10.write(var11, 0, var12);
                  }

                  var10.close();
                  var6.close();
               }
            } catch (IOException var13) {
            }

         }
      } else {
         throw new IllegalArgumentException("ResourcePath cannot be null or empty");
      }
   }

   private String a() {
      File var4 = this.a.r();
      if (!var4.exists()) {
         var4.mkdirs();
      }

      File var5 = new File(var4, "config.yml");
      if (!var5.exists()) {
         this.a("config.yml", false);
      }

      try {
         FileInputStream var6 = new FileInputStream(var5);
         YamlConfiguration var7 = new YamlConfiguration();
         InputStreamReader var8 = new InputStreamReader(var6);
         var7.load(var8);
         var6.close();
         var8.close();
         String var9 = var7.getString("config-identifier");
         if (var9 == null) {
            throw new IntaveBootFailureException("It seems like you are using an old/invalid configuration");
         } else {
            return var9;
         }
      } catch (FileNotFoundException var10) {
         throw new IntaveBootFailureException("It seems like we are unable to create the default configuration file");
      } catch (IOException | InvalidConfigurationException var11) {
         throw new IntaveBootFailureException("It seems like your configuration is invalid", var11);
      }
   }

   public ConfigLoader(IntavePlugin var1) {
      this.a = var1;
      this.b = this.a();
      this.c = new Unknown166(this.b);
   }

   public YamlConfiguration e() {
      return this.c.k();
   }

   public Unknown166 d() {
      return this.c;
   }

   public String b() {
      return this.b;
   }

   public void c() {
      this.c.f();
   }

   public void a(String var1) {
      boolean var5 = this.b.equalsIgnoreCase("file");
      boolean var6 = System.currentTimeMillis() - this.d().g().lastModified() > 7200000L;
      if (!var5 && !var6) {
         int var7 = this.d().e();
         if (!var1.equals("") && !var1.equalsIgnoreCase(String.valueOf(var7))) {
            this.c.b();
         } else {
            this.c.i();
         }

      } else {
         this.c.b();
      }
   }
}
