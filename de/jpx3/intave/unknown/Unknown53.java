package de.jpx3.intave.unknown;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

class Unknown53 extends PlayerTeleportEvent {
   final Unknown313 this$0;

   public void setCancelled(boolean var1) {
      super.setCancelled(var1);
   }

   Unknown53(Unknown313 var1, Player var2, Location var3, Location var4, TeleportCause var5) {
      super(var2, var3, var4, var5);
      this.this$0 = var1;
   }
}
