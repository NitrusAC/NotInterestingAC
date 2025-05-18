package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.unknown.Unknown17;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;

public final class PermissionUtil {
   private static boolean covers(Permissible var0, String var1) {
      return var0.hasPermission(var1);
   }

   private static boolean hasPermission(Player var0, String var1) {
      if (!PlayerDataManager.isInjected(var0)) {
         return covers(var0, var1);
      } else {
         PlayerData var5 = PlayerDataManager.getPlayerData(var0);
         if (!var5.exists()) {
            return false;
         } else {
            Unknown17 var6 = var5.B();
            if (var6.b(var1)) {
               return var6.a(var1);
            } else {
               boolean var7 = covers(var0, var1);
               var6.a(var1, var7);
               return var7;
            }
         }
      }
   }

   public static native boolean b(Permissible var0, String var1);
}
