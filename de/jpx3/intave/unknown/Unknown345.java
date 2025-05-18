package de.jpx3.intave.unknown;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class Unknown345 implements Unknown69 {
   private Object a;
   private Method c;

   @Override
   public boolean a(Player var1) {
      return false;
   }

   @Override
   public void c() {
      try {
         Class var3 = Class.forName("com.viaversion.viaversion.api.Via");
         this.a = var3.getMethod("getAPI").invoke(null);
         this.c = Class.forName("com.viaversion.viaversion.api.ViaAPI").getMethod("getPlayerVersion", UUID.class);
      } catch (Exception var4) {
         throw new IllegalStateException("Invalid ViaVersion linkage", var4);
      }
   }

   @Override
   public String b() {
      return Bukkit.getPluginManager().getPlugin("ViaVersion").getDescription().getVersion();
   }

   @Override
   public int b(Player var1) {
      try {
         return this.c.invoke(this.a, var1.getUniqueId());
      } catch (Exception var5) {
         throw new IllegalStateException("Unable to resolve player version", var5);
      }
   }

   @Override
   public void a() {
      try {
         Class var4 = Class.forName("com.viaversion.viaversion.ViaVersionPlugin");
         Object var5 = var4.getMethod("getConfigurationProvider").invoke(Bukkit.getPluginManager().getPlugin("ViaVersion"));
         Class var6 = Class.forName("com.viaversion.viaversion.configuration.AbstractViaConfig");
         Field var7 = var6.getDeclaredField("warningPPS");
         if (!var7.isAccessible()) {
            var7.setAccessible(true);
         }

         int var8 = var7.getInt(var5);
         var7.set(var5, Math.max(var8, 300));
      } catch (Exception var9) {
         throw new IllegalStateException("Failed to alter ViaVersion configuration", var9);
      }
   }

   @Override
   public boolean a(String var1) {
      return var1.startsWith("4");
   }
}
