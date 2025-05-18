package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.unknown.Unknown266;
import de.jpx3.intave.unknown.Unknown334;
import de.jpx3.intave.unknown.Unknown37;
import de.jpx3.intave.unknown.Unknown373;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public final class LogUtil {
   public static String a(Player var0, String var1, Unknown37 var2) {
      PlayerData var5 = PlayerDataManager.getPlayerData(var0);
      String var6 = Unknown334.a(var1, new Unknown373[]{Unknown334.a, Unknown334.b, var5.j(), var5.getPlayerIdentifier(), var2});
      var6 = ChatColor.translateAlternateColorCodes('&', var6);
      return var6.trim().replace("  ", " ");
   }

   public static String a(Player var0, Unknown373 var1) {
      String var5 = a("verbose");
      PlayerData var6 = PlayerDataManager.getPlayerData(var0);
      String var7 = Unknown334.a(var5, new Unknown373[]{Unknown334.a, Unknown334.b, var6.j(), var6.getPlayerIdentifier(), var1});
      var7 = ChatColor.translateAlternateColorCodes('&', var7);
      return var7.trim().replace("  ", " ");
   }

   public static String a(Unknown266 var0) {
      String var3 = a("notify");
      String var4 = Unknown334.a(var3, new Unknown373[]{Unknown334.a, Unknown334.b, var0});
      var4 = ChatColor.translateAlternateColorCodes('&', var4);
      return var4.trim().replace("  ", " ");
   }

   private static String a(String var0) {
      return IntavePlugin.getInstance().getConfig().getString("layout." + var0);
   }
}
