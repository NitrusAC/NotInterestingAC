package de.jpx3.intave.unknown;

import com.comphenix.protocol.ProtocolLibrary;
import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.logger.Logger;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class Unknown241 {
   private static Unknown69 a;
   private static final List b = Lists.newArrayList();

   public static void d() {
      PluginManager var3 = Bukkit.getServer().getPluginManager();
      Plugin var4 = var3.getPlugin("ViaVersion");
      if (var4 != null) {
         String var5 = var4.getDescription().getVersion();
         a = (Unknown69)b.stream().filter(Unknown241::b).findFirst().orElse(null);
         b.clear();
         if (a != null) {
            a.c();
         } else {
            Logger.getLogger().severe("Unknown ViaVersion version, linkage failed (ViaVersion version: " + var5 + ")");
         }

      }
   }

   private static boolean b(String var0, Unknown69 var1) {
      return var1.a(var0);
   }

   public static void c() {
      if (b()) {
         a.a();
      }

   }

   public static boolean b() {
      return a != null;
   }

   public static String getVersion() {
      return a != null ? a.b() : "unknown";
   }

   public static boolean a(Player var0) {
      return b() && a.a(var0);
   }

   public static int b(Player var0) {
      return b() ? a.b(var0) : ProtocolLibrary.getProtocolManager().getProtocolVersion(var0);
   }

   static {
      b.add(new Unknown114());
      b.add(new Unknown359());
      b.add(new Unknown345());
   }
}
