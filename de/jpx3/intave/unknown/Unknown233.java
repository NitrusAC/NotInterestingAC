package de.jpx3.intave.unknown;

import com.comphenix.protocol.PacketType;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.Check;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class Unknown233 implements Check {
   private final IntavePlugin c;
   private final Unknown349 d;
   private final Map e = new ConcurrentHashMap();

   @BukkitEventListener
   public void a(PlayerJoinEvent var1) {
      this.b(var1.getPlayer());
   }

   @BukkitEventListener
   public void a(PlayerQuitEvent var1) {
      this.a(var1.getPlayer());
   }

   public void e() {
      Bukkit.getOnlinePlayers().forEach(this::b);
   }

   public void b(Player var1) {
      if (!this.d.b(var1)) {
         this.d.c(var1);
      }

   }

   public void a(Player var1) {
   }

   public void a(PacketType var1, Collection var2) {
      this.e.put(var1, var2);
   }

   public void c() {
      this.e.clear();
   }

   public void d() {
      Bukkit.getOnlinePlayers().forEach(this::a);
   }

   public Unknown233(IntavePlugin var1) {
      this.c = var1;
      this.d = new Unknown374(var1, this);
      this.e();
      this.c.d().b(this);
   }

   protected Collection a(PacketType var1) {
      return (Collection)this.e.get(var1);
   }
}
