package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public final class Unknown284 extends UnknownCheck {
   private void b() {
      Bukkit.getOnlinePlayers().forEach(this::a);
   }

   @Override
   public void refreshConfig() {
      int var1 = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this.plugin, this::b, 3600L, 3600L);
      Unknown22.a(var1);
   }

   private void a(Player var1) {
      PlayerData var5 = PlayerDataManager.getPlayerData(var1);
      Unknown292 var6 = (Unknown292)this.plugin.E().a(Unknown292.class);
      Unknown263 var7 = (Unknown263)var5.b(Unknown263.class);
      if (System.currentTimeMillis() - var5.getStorage().getPhysicsHolder().lastPhysicsIteration > 120000L) {
         var7.a(3);
         var6.b(3L);
      } else {
         var7.b(3);
         var6.a(3L);
      }

   }

   @BukkitEventListener
   public void a(PlayerQuitEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      Unknown263 var4 = (Unknown263)var3.b(Unknown263.class);
      var4.a();
   }
}
