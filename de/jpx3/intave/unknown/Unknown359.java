package de.jpx3.intave.unknown;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class Unknown359 implements Unknown69 {
   private Method a;
   private Object b;

   @Override
   public int b(Player var1) {
      try {
         return this.a.invoke(this.b, var1.getUniqueId());
      } catch (Exception var5) {
         throw new IllegalStateException("Unable to resolve player version", var5);
      }
   }

   @Override
   public boolean a(String var1) {
      return var1.startsWith("3");
   }

   @Override
   public String b() {
      return Bukkit.getPluginManager().getPlugin("ViaVersion").getDescription().getVersion();
   }

   @Override
   public void c() {
      try {
         Class var3 = Class.forName("us.myles.ViaVersion.api.Via");
         this.b = var3.getMethod("getAPI").invoke(null);
         this.a = Class.forName("us.myles.ViaVersion.api.ViaAPI").getMethod("getPlayerVersion", UUID.class);
      } catch (Exception var4) {
         throw new IllegalStateException("Invalid ViaVersion linkage", var4);
      }
   }

   @Override
   public boolean a(Player var1) {
      return false;
   }

   @Override
   public void a() {
      try {
         Class var4 = Class.forName("us.myles.ViaVersion.ViaVersionPlugin");
         Object var5 = var4.getMethod("getConfigurationProvider").invoke(Bukkit.getPluginManager().getPlugin("ViaVersion"));
         Class var6 = Class.forName("us.myles.ViaVersion.AbstractViaConfig");
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
}
