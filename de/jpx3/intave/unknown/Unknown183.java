package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.PacketListener;
import de.jpx3.intave.unknown.what.What1;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.RegisteredListener;

public final class Unknown183 extends RegisteredListener {
   private boolean c;
   private final IntavePlugin a;
   private final PacketListener f;
   private Unknown125 e;
   private final Class b;
   private final EventExecutor d;

   public void c() {
      this.c = !this.isIgnoringCancelled() && Cancellable.class.isAssignableFrom(this.b);
   }

   public void callEvent(Event var1) {
      if (this.b.isAssignableFrom(var1.getClass()) && (!this.c || !((Cancellable)var1).isCancelled())) {
         boolean var5 = !Bukkit.isPrimaryThread();
         if (!var5) {
            What1.i.h();
            if (this.e == null) {
               this.e = What1.a(var1);
            }

            this.e.h();
         }

         try {
            this.d.execute(this.f, var1);
         } catch (RuntimeException var7) {
            var7.printStackTrace();
         }

         if (!var5) {
            What1.i.g();
            this.e.g();
         }

      }
   }

   public Unknown183(IntavePlugin var1, PacketListener var2, EventExecutor var3, Class var4, BukkitEventListener var5) {
      super(var2, null, var5.a(), var1, true);
      this.a = var1;
      this.d = var3;
      this.b = var4;
      this.f = var2;
   }
}
