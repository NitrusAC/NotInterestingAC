package de.jpx3.intave.unknown;

import com.comphenix.protocol.ProtocolLibrary;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import de.jpx3.intave.anticheat.IntavePlugin;
import java.io.IOException;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;

public final class Unknown407 {
   private final IntavePlugin intavePlugin;
   private final Map a = Maps.newHashMap();

   public void c() {
      this.b(Unknown292.class);
      this.b(Unknown300.class);
      this.b(Unknown295.class);
      Unknown86.a(this::b);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this.intavePlugin, this::b, 432000L);
   }

   private void b() {
      JsonObject var4 = new JsonObject();
      var4.addProperty("name", "Analytics report from Intave");
      JsonObject var5 = new JsonObject();
      var5.addProperty("version", this.intavePlugin.getDescription().getVersion());
      var4.add("intave", var5);
      JsonObject var6 = new JsonObject();
      Server var7 = this.intavePlugin.getServer();
      var6.addProperty("name", var7.getName());
      var6.addProperty("version", var7.getVersion());
      var6.addProperty("port", var7.getPort());
      var6.addProperty("onlinemode", var7.getOnlineMode());
      var6.addProperty("maxplayers", var7.getMaxPlayers());
      var6.addProperty("whitelist", var7.hasWhitelist());
      var4.add("server", var6);
      JsonObject var8 = new JsonObject();
      JsonObject var9 = new JsonObject();
      var9.addProperty("present", "true");
      var9.addProperty("version", ProtocolLibrary.getPlugin().getDescription().getVersion());
      var9.addProperty("protocol-manager", ProtocolLibrary.getProtocolManager().getClass().getName());
      var9.addProperty("async-manager", ProtocolLibrary.getProtocolManager().getAsynchronousManager().getClass().toString());
      var9.addProperty("listeners", ProtocolLibrary.getProtocolManager().getPacketListeners().toString());
      var8.add("protocollib", var9);
      JsonObject var10 = new JsonObject();
      var10.addProperty("present", Unknown241.b() + "");
      if (Unknown241.b()) {
         var10.addProperty("version", Unknown241.getVersion());
      }

      var8.add("viaversion", var10);
      var4.add("addons", var8);
      JsonObject var11 = new JsonObject();

      for(Unknown312 var13 : this.a.values()) {
         if ((!var13.e() || this.e()) && (!var13.h() || this.d())) {
            var11.add(var13.a(), var13.serialize());
            var13.g();
         }
      }

      var4.add("data", var11);

      try {
         long var15 = System.currentTimeMillis() / 1000L / 60L / 60L % 24L;
         this.intavePlugin.D().a("analytics-" + var15, var4.toString());
      } catch (IOException var14) {
         System.out.println("[Intave] Unable to upload analytics data");
         var14.printStackTrace();
      }

   }

   private void b(Class var1) {
      Unknown312 var2 = null;

      try {
         var2 = (Unknown312)var1.newInstance();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      this.a.put(var1, var2);
   }

   public Unknown312 a(Class var1) {
      return (Unknown312)this.a.get(var1);
   }

   private FileConfiguration getAnalyticsConfig() {
      return this.intavePlugin.getConfig();
   }

   public boolean d() {
      return this.getAnalyticsConfig().getBoolean("analytics.errorReporting", true);
   }

   public boolean e() {
      return this.getAnalyticsConfig().getBoolean("analytics.usageReporting", true);
   }

   public Unknown407(IntavePlugin var1) {
      this.intavePlugin = var1;
   }
}
