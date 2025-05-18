package de.jpx3.intave.anticheat.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.threading.BackgroundThreadingPool;
import de.jpx3.intave.unknown.Unknown406;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;

public final class Bstats {
   private final Plugin j;
   private static boolean b;
   private final int c;
   public static final int B_STATS_VERSION = 1;
   private final ScheduledExecutorService h;
   private static boolean f;
   private final ThreadFactory a = de.jpx3.intave.anticheat.threading.ThreadFactory.b();
   private final List i;
   private final boolean k;
   private static boolean e;
   private static String g;
   private static final String d;

   private static void a(Plugin var0, JsonObject var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Data cannot be null!");
      } else if (Bukkit.isPrimaryThread()) {
         throw new IllegalAccessException("This method must not be called from the main thread!");
      } else {
         if (e) {
            var0.getLogger().info("Sending data to bStats: " + var1);
         }

         HttpsURLConnection var5 = (HttpsURLConnection)new URL("https:..bstats.org.submitData.bukkit").openConnection();
         byte[] var6 = a(var1.toString());
         var5.setRequestMethod("POST");
         var5.addRequestProperty("Accept", "application/json");
         var5.addRequestProperty("Connection", "close");
         var5.addRequestProperty("Content-Encoding", "gzip");
         var5.addRequestProperty("Content-Length", String.valueOf(var6.length));
         var5.setRequestProperty("Content-Type", "application/json");
         var5.setRequestProperty("User-Agent", "MC-Server/1");
         var5.connect();
         var5.setDoOutput(true);
         DataOutputStream var7 = new DataOutputStream(var5.getOutputStream());
         Throwable var8 = null;

         try {
            var7.write(var6);
         } catch (Throwable var31) {
            var8 = var31;
            throw var31;
         } finally {
            if (var7 != null) {
               if (var8 != null) {
                  try {
                     var7.close();
                  } catch (Throwable var30) {
                     var8.addSuppressed(var30);
                  }
               } else {
                  var7.close();
               }
            }

         }

         StringBuilder var35 = new StringBuilder();
         BufferedReader var36 = new BufferedReader(new InputStreamReader(var5.getInputStream()));
         Throwable var9 = null;

         try {
            String var10;
            try {
               while((var10 = var36.readLine()) != null) {
                  var35.append(var10);
               }
            } catch (Throwable var33) {
               var9 = var33;
               throw var33;
            }
         } finally {
            if (var36 != null) {
               if (var9 != null) {
                  try {
                     var36.close();
                  } catch (Throwable var29) {
                     var9.addSuppressed(var29);
                  }
               } else {
                  var36.close();
               }
            }

         }

         if (f) {
            var0.getLogger().info("Sent data to bStats and received response: " + var35);
         }

      }
   }

   public boolean d() {
      return this.k;
   }

   public static boolean e() {
      return b;
   }

   private static byte[] a(String var0) {
      if (var0 == null) {
         return null;
      } else {
         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         GZIPOutputStream var5 = new GZIPOutputStream(var4);
         Throwable var6 = null;

         try {
            var5.write(var0.getBytes(StandardCharsets.UTF_8));
         } catch (Throwable var15) {
            var6 = var15;
            throw var15;
         } finally {
            if (var5 != null) {
               if (var6 != null) {
                  try {
                     var5.close();
                  } catch (Throwable var14) {
                     var6.addSuppressed(var14);
                  }
               } else {
                  var5.close();
               }
            }

         }

         return var4.toByteArray();
      }
   }

   public Bstats(IntavePlugin var1, int var2) {
      this.h = Executors.newScheduledThreadPool(1, this.a);
      this.i = new ArrayList();
      if (var1 == null) {
         throw new IllegalArgumentException("Plugin cannot be null!");
      } else {
         this.j = var1;
         this.c = var2;
         File var6 = new File(var1.r().getParentFile(), "bStats");
         File var7 = new File(var6, "config.yml");
         YamlConfiguration var8 = YamlConfiguration.loadConfiguration(var7);
         if (!var8.isSet("serverUuid")) {
            var8.addDefault("enabled", true);
            var8.addDefault("serverUuid", UUID.randomUUID().toString());
            var8.addDefault("logFailedRequests", false);
            var8.addDefault("logSentData", false);
            var8.addDefault("logResponseStatusText", false);
            var8.options()
               .header(
                  "bStats collects some data for plugin authors like how many servers are using their plugins.\nTo honor their work, you should not disable it.\nThis has nearly no effect on the server performance!\nCheck out https:..bStats.org. to learn more :)"
               )
               .copyDefaults(true);

            try {
               var8.save(var7);
            } catch (IOException var13) {
            }
         }

         this.k = var8.getBoolean("enabled", true);
         g = var8.getString("serverUuid");
         b = var8.getBoolean("logFailedRequests", false);
         e = var8.getBoolean("logSentData", false);
         f = var8.getBoolean("logResponseStatusText", false);
         if (this.k) {
            boolean var9 = false;

            for(Class var11 : Bukkit.getServicesManager().getKnownServices()) {
               try {
                  String var10003 = qd.c(var11, "B_STATS_VERSION");
                  String var10002 = "B_STATS_VERSION";
                  var11.getField(var10003);
                  var9 = true;
                  break;
               } catch (NoSuchFieldException var14) {
               }
            }

            Bukkit.getServicesManager().register(Bstats.class, this, var1, ServicePriority.Normal);
            if (!var9) {
               this.c();
            }
         }

      }
   }

   private void f() {
      if (!this.j.isEnabled()) {
         this.h.shutdown();
      } else {
         Bukkit.getScheduler().runTask(this.j, this::a);
      }
   }

   private void a() {
      JsonObject var4 = this.b();
      JsonArray var5 = new JsonArray();

      for(Class var7 : Bukkit.getServicesManager().getKnownServices()) {
         try {
            String var10003 = qd.c(var7, "B_STATS_VERSION");
            String var10002 = "B_STATS_VERSION";
            var7.getField(var10003);

            for(RegisteredServiceProvider var9 : Bukkit.getServicesManager().getRegistrations(var7)) {
               try {
                  Class var10000 = var9.getService();
                  Class[] var18 = new Class[0];
                  Object var10 = var10000.getMethod(qd.b("getPluginData", var10000, var18), var18).invoke(var9.getProvider());
                  if (var10 instanceof JsonObject) {
                     var5.add((JsonObject)var10);
                  } else {
                     try {
                        Class var11 = Class.forName("org.json.simple.JSONObject");
                        if (var10.getClass().isAssignableFrom(var11)) {
                           Method var12 = var11.getDeclaredMethod("toJSONString");
                           var12.setAccessible(true);
                           String var13 = (String)var12.invoke(var10);
                           JsonObject var14 = new JsonParser().parse(var13).getAsJsonObject();
                           var5.add(var14);
                        }
                     } catch (ClassNotFoundException var15) {
                        if (b) {
                           this.j.getLogger().log(Level.SEVERE, "Encountered unexpected exception", var15);
                        }
                     }
                  }
               } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NullPointerException var16) {
               }
            }
         } catch (NoSuchFieldException var17) {
         }
      }

      var4.add("plugins", var5);
      BackgroundThreadingPool.submit(this::b);
   }

   private void b(JsonObject var1) {
      try {
         a(this.j, var1);
      } catch (Exception var5) {
         if (b) {
            this.j.getLogger().log(Level.WARNING, "Could not submit plugin stats of " + this.j.getName(), var5);
         }
      }

   }

   private JsonObject b() {
      int var4;
      try {
         Method var5 = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers");
         var4 = var5.getReturnType().equals(Collection.class)
            ? ((Collection)var5.invoke(Bukkit.getServer())).size()
            : ((Player[])((Player[])var5.invoke(Bukkit.getServer()))).length;
      } catch (Exception var14) {
         var4 = Bukkit.getOnlinePlayers().size();
      }

      int var15 = Bukkit.getOnlineMode() ? 1 : 0;
      String var6 = Bukkit.getVersion();
      String var7 = Bukkit.getName();
      String var8 = System.getProperty("java.version");
      String var9 = System.getProperty("os.name");
      String var10 = System.getProperty("os.arch");
      String var11 = System.getProperty("os.version");
      int var12 = Runtime.getRuntime().availableProcessors();
      JsonObject var13 = new JsonObject();
      var13.addProperty("serverUUID", g);
      var13.addProperty("playerAmount", var4);
      var13.addProperty("onlineMode", var15);
      var13.addProperty("bukkitVersion", var6);
      var13.addProperty("bukkitName", var7);
      var13.addProperty("javaVersion", var8);
      var13.addProperty("osName", var9);
      var13.addProperty("osArch", var10);
      var13.addProperty("osVersion", var11);
      var13.addProperty("coreCount", var12);
      return var13;
   }

   private void c() {
      Runnable var1 = this::f;
      long var2 = (long)(3.0 + Math.random() * 3.0);
      long var4 = (long)(Math.random() * 30.0);
      this.h.schedule(var1, var2, TimeUnit.MINUTES);
      this.h.scheduleAtFixedRate(var1, var2 + var4, 30L, TimeUnit.MINUTES);
   }

   public void a(Unknown406 var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Chart cannot be null!");
      } else {
         this.i.add(var1);
      }
   }

   public JsonObject getPluginData() {
      JsonObject var5 = new JsonObject();
      String var6 = this.j.getDescription().getName();
      String var7 = this.j.getDescription().getVersion();
      var5.addProperty("pluginName", var6);
      var5.addProperty("id", this.c);
      var5.addProperty("pluginVersion", var7);
      JsonArray var8 = new JsonArray();

      for(Unknown406 var10 : this.i) {
         JsonObject var11 = Unknown406.a(var10);
         if (var11 != null) {
            var8.add(var11);
         }
      }

      var5.add("customCharts", var8);
      return var5;
   }
}
