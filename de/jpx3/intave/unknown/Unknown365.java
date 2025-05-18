package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.PacketListener;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public final class Unknown365 implements PacketListener {
   private final Unknown383 c;
   private final IntavePlugin d;
   private final Unknown344 e;

   public Unknown344 d() {
      return this.e;
   }

   public native boolean b(Player var1);

   public Unknown383 a() {
      return this.c;
   }

   public void a(Player var1, Entity var2, boolean var3) {
      Unknown97 var4 = new Unknown97();
      var4.setAttacker(var1.getUniqueId());
      var4.setAttackedPosition(var2.getLocation().toVector());
      var4.setDamage(var3);
      this.a(var4);
   }

   public Unknown365(IntavePlugin var1) {
      this.d = var1;
      this.c = new Unknown383(var1);
      this.e = new Unknown344(this.c);
      this.d.d().b(this);
      this.b();
   }

   private static Unknown4 a(Unknown4 var0) {
      return var0;
   }

   public native void a(Player var1);

   public native void a(Unknown95 var1);

   private void b(PlayerJoinEvent var1) {
      this.a(var1.getPlayer());
   }

   private native void b();

   @BukkitEventListener
   public void a(PlayerJoinEvent var1) {
      IntaveScheduler.a(this::b, 20);
   }
}
