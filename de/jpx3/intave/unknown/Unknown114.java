package de.jpx3.intave.unknown;

import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.logger.Logger;
import java.lang.reflect.Method;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Unknown114 implements Unknown69 {
   private Method a;
   private Object b;

   @Override
   public boolean a(String var1) {
      return var1.startsWith("2");
   }

   @Override
   public int b(Player var1) {
      try {
         return this.a.invoke(this.b, var1.getUniqueId());
      } catch (Exception var5) {
         throw new IllegalStateException("Unable to resolve player version", var5);
      }
   }

   @Override
   public void a() {
      try {
         Class var5 = Class.forName("us.myles.ViaVersion.ViaVersionPlugin");
         Object var6 = var5.getMethod("getConfigurationProvider").invoke(Bukkit.getPluginManager().getPlugin("ViaVersion"));
         Class var7 = Class.forName("us.myles.ViaVersion.api.configuration.ConfigurationProvider");
         var7.getMethod("set", String.class, Object.class).invoke(var6, "tracking-warning-pps", 300);
      } catch (Exception var8) {
         throw new IllegalStateException("Failed to alter ViaVersion configuration", var8);
      }
   }

   @Override
   public void c() {
      try {
         Class var3 = Class.forName("us.myles.ViaVersion.api.ViaVersion");
         this.b = var3.getMethod("getInstance").invoke(null);
         Class var10001 = this.b.getClass();
         Class[] var10004 = new Class[]{UUID.class};
         this.a = var10001.getMethod(qd.b("getPlayerVersion", var10001, var10004), var10004);
      } catch (Exception var4) {
         throw new IllegalStateException("Invalid ViaVersion linkage", var4);
      }

      Logger.getLogger().info("You are running a very old, outdated version of ViaVersion");
   }

   @Override
   public String b() {
      return ((JavaPlugin)this.b).getDescription().getVersion();
   }

   @Override
   public boolean a(Player var1) {
      return false;
   }
}
