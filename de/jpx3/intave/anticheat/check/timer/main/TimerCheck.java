package de.jpx3.intave.anticheat.check.timer.main;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.api.config.CheckConfigValue;
import de.jpx3.intave.anticheat.check.timer.TimerCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown187;
import de.jpx3.intave.unknown.Unknown25;
import de.jpx3.intave.unknown.Unknown63;
import java.util.Map;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.util.Vector;

public final class TimerCheck extends PartialConfigurableCheck {
   private static final long f = 2000L;
   private final CheckConfigValue h;
   private final boolean e;
   private static final long g = 5L;

   private void a(Player var1, Cancellable var2, long var3, long var5) {
      PlayerData var10 = this.getPlayerData(var1);
      Unknown25 var11 = (Unknown25)this.getStorage(var10);
      long var12 = var11.f;
      long var14 = System.currentTimeMillis() - var12;
      Unknown187 var16 = var10.getStorage().e();
      Map var17 = var16.j;
      String var18 = this.a().toLowerCase();
      if (var17.containsKey(var18)) {
         Map var19 = (Map)var17.get(var18);
         if (var19.get("thresholds") > (double)var3 && var14 < var5) {
            var2.setCancelled(true);
            var1.updateInventory();
         }

      }
   }

   @BukkitEventListener
   public void handleItemEvent(PlayerItemConsumeEvent var1) {
      Player var2 = var1.getPlayer();
      this.a(var2, var1);
   }

   private void a(Player var1, Cancellable var2) {
      this.a(var1, var2, 2000L, 5L);
   }

   @BukkitEventListener
   public void handleDamageEvent(EntityDamageByEntityEvent var1) {
      Entity var4 = var1.getEntity();
      if (var4 instanceof Player && var1.getCause() == DamageCause.ENTITY_ATTACK) {
         Player var5 = (Player)var4;
         int var6 = this.flag("act", var5);
         int var7 = this.flag("acl", var5);
         this.a(var5, var1, (long)var6, (long)var7);
      }

   }

   private static void a(Unknown25 var0, Player var1, Object var2) {
      var0.a = Math.max(0.0, var0.a);
   }

   public TimerCheck(TimerCheckGroup var1) {
      super(var1, Unknown25.class);
      this.h = var1.d();
      this.e = ((TimerCheckGroup)this.getParent()).isHighTolerance();
   }

   @BukkitEventListener
   public void handleHealEvent(EntityRegainHealthEvent var1) {
      Entity var2 = var1.getEntity();
      if (var2 instanceof Player) {
         this.a((Player)var2, var1);
      }

   }

   @PacketListener(
      g = {ServerPacket.RESPAWN}
   )
   public void a(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ((Unknown25)this.getStorage(var2)).h = System.currentTimeMillis();
      Unknown25 var10000 = (Unknown25)this.getStorage(var2);
      var10000.a -= 20.0;
   }

   public void b(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      if (var5 != null) {
         PlayerData var6 = this.getPlayerData(var5);
         PlayerStorage var7 = var6.getStorage();
         Unknown25 var8 = (Unknown25)this.getStorage(var6);
         long var9 = System.currentTimeMillis();
         long var11 = var9 - var8.c;
         var8.c = System.currentTimeMillis();
         var8.a -= (double)var11 / 5.0;
         var8.a += 10.0;
         int var13 = this.flag("buffer-size", var5);
         if (this.e || var7.getEntityHolder().canFly()) {
            var13 = (int)((double)var13 * 1.5);
         }

         if (System.currentTimeMillis() - var8.h < 6000L) {
            var13 = Math.max(var13, 8000);
         }

         if (System.currentTimeMillis() - var8.d < 12000L && !this.e) {
            var13 = Math.max(var13 / 2, 500);
         }

         double var14 = (double)var13 / 1000.0 * -200.0;
         var8.a = MathUtil2.clamp(var14, var8.a, 200.0);
         if (var11 > 500L) {
            var8.d = System.currentTimeMillis();
            IntaveScheduler.runTask(TimerCheck::b);
         }

         if (var8.a < -50.0 && System.currentTimeMillis() - var8.d > 500L) {
            int var16 = var8.a < -400.0 ? 9 : 3;
            var8.a += (double)var16;
         }

         this.a(var6, Unknown63::g);
         int var22 = this.e ? 150 : 20;
         if (var8.a > (double)var22 && !var6.getStorage().getPhysicsHolder().isTrackingAttacked()) {
            String var17 = MathUtil2.getStringRounded(var8.a / 10.0, 2);
            this.a(var6, Unknown63::d);
            Violation var18 = Violation.builder(TimerCheckGroup.class)
               .player(var5)
               .name("moved too frequently")
               .description(var17 + " ticks ahead")
               .vl(0.5)
               .build();
            ImmutableViolation var19 = MoudleLoader.violations().dispatchViolation(var18);
            if (var19.m()) {
               BukkitEnginePlayer var20 = var6.getStorage().getPhysicsHolder();
               var20.aO = true;
               Vector var21 = new Vector(var20.deltaX, var20.deltaY, var20.deltaZ);
               MoudleLoader.o().b().a(var5, var21, 12, false);
            }

            var8.f = System.currentTimeMillis();
            var8.a -= !this.e && !(var8.a > (double)var22) ? 0.5 : 2.5;
         } else {
            this.a(var6, Unknown63::a);
            if (var8.a > 0.0) {
               var8.a -= this.e ? 0.075 : 0.025;
            }

            if (System.currentTimeMillis() - var8.f > 10000L) {
               this.h.a(var6, 0.01);
            }
         }

      }
   }

   @BukkitEventListener
   public void handleShootBowEvent(EntityShootBowEvent var1) {
      LivingEntity var2 = var1.getEntity();
      if (var2 instanceof Player) {
         this.a((Player)var2, var1);
      }

   }

   @PacketListener(
      g = {ServerPacket.POSITION}
   )
   public void c(PacketEvent var1) {
      PlayerData var6 = this.getPlayerData(var1.getPlayer());
      double var7 = var6.getStorage().e().k ? 2.0 : 12.5;
      Unknown25 var9 = (Unknown25)this.getStorage(var6);
      var9.a -= var7;
      var9.c = System.currentTimeMillis();
   }

   private static void b(Player var0, Unknown25 var1) {
      MoudleLoader.m().a(var0, TimerCheck::a);
   }
}
