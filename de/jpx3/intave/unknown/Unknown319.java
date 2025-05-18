package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.impl.FallbackUser;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class Unknown319 extends UnknownCheck {
   @Override
   public void refreshConfig() {
      for(Player var5 : Bukkit.getOnlinePlayers()) {
         if (PlayerDataManager.getPlayerData(var5) instanceof FallbackUser) {
            PlayerDataManager.a(var5);
         }

         PlayerData var6 = PlayerDataManager.getPlayerData(var5);
         var6.p();
      }

   }

   @BukkitEventListener(
      a = EventPriority.LOWEST
   )
   public void a(PlayerJoinEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerDataManager.a(var5);
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      IntaveScheduler.a(var6::p, 20);
   }

   @BukkitEventListener(
      a = EventPriority.HIGHEST
   )
   public void a(PlayerQuitEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerDataManager.inject(var2);
   }
}
