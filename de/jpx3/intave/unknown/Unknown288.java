package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public final class Unknown288 extends UnknownCheck {
   private static final String f;
   private static final double a = 1.7999999999999998;

   private boolean a(EntityType var1) {
      return var1 == EntityType.BOAT;
   }

   @BukkitEventListener
   public void a(PlayerMoveEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      List var7 = var5.getNearbyEntities(5.0, 5.0, 5.0);
      this.a(var6, var7);
      if (!var6.exists()) {
         var6.error("Please reconnect");
      }

   }

   private void a(PlayerData var1, List var2) {
      BukkitEnginePlayer var6 = var1.getStorage().getPhysicsHolder();
      boolean var7 = false;

      for(Entity var9 : var2) {
         if (this.a(var9.getType())) {
            Location var10 = var9.getLocation();
            double var11 = var6.getDistance(var10);
            if (var11 < 1.7999999999999998) {
               var6.b = var10;
               var7 = true;
            }
         }
      }

      if (!var7) {
         var6.b = null;
      }

   }
}
