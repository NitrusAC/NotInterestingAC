package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import io.netty.channel.Channel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginDisableEvent;

class Unknown196 implements Listener {
   final Unknown349 this$0;

   @EventHandler(
      priority = EventPriority.LOWEST
   )
   public void a(PlayerJoinEvent var1) {
      if (!this.this$0.v) {
         IntaveScheduler.runTask(this::b);
      }
   }

   private void b(PlayerJoinEvent var1) {
      Channel var5 = this.this$0.a(var1.getPlayer());
      if (!Unknown349.c(this.this$0).contains(var5)) {
         this.this$0.c(var1.getPlayer());
      }

   }

   Unknown196(Unknown349 var1) {
      this.this$0 = var1;
   }

   @EventHandler
   public void a(PluginDisableEvent var1) {
      if (var1.getPlugin().equals(this.this$0.c)) {
         this.this$0.a();
      }

   }
}
