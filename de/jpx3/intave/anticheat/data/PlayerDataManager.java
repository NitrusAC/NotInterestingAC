package de.jpx3.intave.anticheat.data;

import de.jpx3.intave.unknown.Unknown250;
import de.jpx3.intave.unknown.Unknown355;
import de.jpx3.intave.unknown.Unknown86;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PlayerDataManager {
   private static final PlayerData NULL_DATA = PlayerDataManager$Provider.ofEmpty();
   private static boolean a;
   private static final Map cache = (Map)Unknown250.a("users", new ConcurrentHashMap());

   @NotNull
   public static PlayerData getPlayerData(@Nullable Player player) {
      if (player == null) {
         return NULL_DATA;
      } else {
         PlayerData var4 = (PlayerData)cache.get(player.getUniqueId());
         return var4 != null ? var4 : NULL_DATA;
      }
   }

   private static void start() {
      for(UUID var4 : cache.keySet()) {
         Player var5 = Bukkit.getPlayer(var4);
         if (var5 != null) {
            inject(var5);
         }
      }

   }

   public static boolean isInjected(Player var0) {
      return cache.containsKey(var0.getUniqueId());
   }

   public static void kill() {
      a = true;
      start();
      cache.clear();
   }

   public static void inject(Player var0) {
      if (isInjected(var0)) {
         PlayerData var4 = getPlayerData(var0);
         var4.l();
      }

      cache.remove(var0.getUniqueId());
   }

   public static void a(Player var0) {
      cache.put(var0.getUniqueId(), PlayerDataManager$Provider.ofPLayer(var0));
      Unknown355.a(var0, 20);
   }

   public static void shutdown() {
      Unknown86.b(PlayerDataManager::kill);
   }
}
