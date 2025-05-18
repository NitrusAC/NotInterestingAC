package de.jpx3.intave.unknown;

import de.jpx3.intave.access.check.MitigationStrategy;
import de.jpx3.intave.access.check.event.IntaveCommandExecutionEvent;
import de.jpx3.intave.access.check.event.IntaveViolationEvent;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.LogUtil;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class Unknown286 extends UnknownCheck {
   private static final String a;
   private static final Unknown131 g = Unknown131.b;
   private static final double f = 1000.0;
   private static final Unknown131 e = Unknown131.a;

   private double a(String var1, Player var2) {
      return (double)this.plugin.c().a(var1 + ".prevention-activation", var2);
   }

   private static void a(Player var0, String var1, String var2, String var3, String var4, double var5, IntaveCommandExecutionEvent var7) {
      var7.copy(var0, var1, var2, var3, var4, var5, false);
   }

   private void h(ImmutableViolation var1) {
      if (!var1.a()) {
         Violation var5 = var1.l();
         Player var6 = (Player)var5.getPlayer().orElseThrow(IllegalStateException::new);
         PlayerData var7 = PlayerDataManager.getPlayerData(var6);
         String var8 = var5.getCheck().k().toLowerCase(Locale.ROOT);
         this.a(var6, var1);
         String var9 = var7.getTrustFactor().name().toLowerCase().replace("_", "");
         String var10 = MathUtil2.getStringRounded(var1.j() - var1.b(), 2);
         String var11 = MathUtil2.getStringRounded(var1.j(), 2);
         String var12 = var5.l().trim();
         String var13 = var5.h().isEmpty() ? "" : "(" + var5.h().trim() + ") ";
         String var14 = String.format("%s/%s %s %s(+%s -> %s on %s)", var6.getName(), var9, var12, var13, var10, var11, var8);
         this.plugin.getLogger().det(var14);
      }
   }

   private static Map e(String var0) {
      return new HashMap();
   }

   private static Double b(String var0) {
      return 0.0;
   }

   private Map a(Player var1) {
      return PlayerDataManager.getPlayerData(var1).getStorage().e().j;
   }

   private static Map c(String var0) {
      return new HashMap();
   }

   private static void b(Player var0, String var1) {
      var0.sendMessage(var1);
   }

   private void a(String var1, Player var2, String var3, Violation var4, ImmutableViolation var5) {
      boolean var9 = var1.startsWith("ban") || var1.startsWith("kick");
      if (var9) {
         MoudleLoader.o().getRejoinSpeed().store(var2.getAddress().getAddress(), var2.getUniqueId(), var3);
         this.plugin.i().a(var2, new Unknown351(var2.getUniqueId(), var3, var4.l(), var5.j()));
      }

      this.plugin.getLogger().c(var1);
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), var1);
   }

   private void c(ImmutableViolation var1) {
      if (!var1.a()) {
         Violation var5 = var1.l();
         Player var6 = (Player)var5.getPlayer().orElseThrow(IllegalStateException::new);
         PlayerData var7 = PlayerDataManager.getPlayerData(var6);
         Unknown187 var8 = var7.getStorage().e();
         if (System.currentTimeMillis() - var8.g > 10000L) {
            var8.e = 0;
            var8.g = System.currentTimeMillis();
         }

         if (var8.e++ > 300) {
            var7.error("You are sending too many packets :[");
         }

      }
   }

   private static void a(Player var0, String var1, String var2, String var3, double var4, double var6, IntaveViolationEvent var8) {
      var8.copy(var0, var1, var2, var3, var4, var6);
   }

   private void e(ImmutableViolation var1) {
      if (!var1.a()) {
         Violation var5 = var1.l();
         Player var6 = (Player)var5.getPlayer().orElseThrow(IllegalStateException::new);
         String var7 = var5.getCheck().k().toLowerCase(Locale.ROOT);
         String var8 = var5.g();
         double var9 = var5.b();
         double var11 = ((Map)this.a(var6).computeIfAbsent(var7, Unknown286::c)).computeIfAbsent(var8, Unknown286::b);
         double var13 = MathUtil2.clamp(0.0, var11 + var9, 1000.0);
         double var15 = this.a(var7, var6);
         var1.a(this.a(var13));
         var1.b(this.a(var11));
         var1.c(this.a(var15));
      }
   }

   private void f(ImmutableViolation var1) {
      if (!var1.a()) {
         Violation var5 = var1.l();
         if (!var5.a(Unknown255.a)) {
            Player var6 = (Player)var5.getPlayer().orElseThrow(IllegalStateException::new);
            PlayerData var7 = PlayerDataManager.getPlayerData(var6);
            AbstractCheck var8 = var5.getCheck();
            var8.a(var7, Unknown63::e);
         }
      }
   }

   private double a(double var1) {
      return (double)Math.round(var1 * 1000.0) / 1000.0;
   }

   private void d(ImmutableViolation var1) {
      if (!var1.a()) {
         Unknown300 var4 = (Unknown300)this.plugin.E().a(Unknown300.class);
         Violation var5 = var1.l();
         var4.a(var5.getCheck().k());
         Player var6 = (Player)var5.getPlayer().orElseThrow(IllegalStateException::new);
         PlayerData var7 = PlayerDataManager.getPlayerData(var6);
         Unknown16 var8 = (Unknown16)var7.b(Unknown16.class);
         var8.a(var1);
      }
   }

   private void g(ImmutableViolation var1) {
      if (!var1.a()) {
         try {
            Violation var5 = var1.l();
            Player var6 = (Player)var5.getPlayer().orElseThrow(IllegalStateException::new);
            String var7 = var5.getCheck().k().toLowerCase(Locale.ROOT);
            String var8 = var5.g();
            double var9 = var1.j();
            ((Map)this.a(var6).computeIfAbsent(var7, Unknown286::e)).put(var8, var9);
         } catch (Exception var11) {
         }

      }
   }

   private void a(ImmutableViolation var1) {
      if (!var1.a() && !var1.g().isEmpty()) {
         for(String var6 : var1.g()) {
            this.a(var1, var6);
         }

      }
   }

   private void b(ImmutableViolation var1) {
      if (!var1.a() && !var1.g().isEmpty()) {
         Violation var5 = var1.l();
         Player var6 = (Player)var5.getPlayer().orElseThrow(IllegalStateException::new);
         String var7 = var5.getCheck().k().toLowerCase(Locale.ROOT);
         String var8 = var5.l();
         String var9 = var5.h();
         double var10 = var1.j();
         ArrayList var12 = new ArrayList();

         for(String var14 : var1.g()) {
            Unknown37 var15 = var1.a(Unknown99.a);
            String var16 = LogUtil.a(var6, var14, var15);
            IntaveCommandExecutionEvent var17 = (IntaveCommandExecutionEvent)MoudleLoader.n().a(IntaveCommandExecutionEvent.class, Unknown286::a);
            if (!var17.isCancelled()) {
               var12.add(var17.command());
            }
         }

         var1.a(var12);
      }
   }

   private void i(ImmutableViolation var1) {
      if (!var1.a()) {
         Violation var5 = var1.l();
         AbstractCheck var6 = var5.getCheck();
         String var7 = var5.g();
         double var8 = var1.b();
         double var10 = var1.j();
         Map var12 = var6.b().b().h(var7);

         for(int var13 = (int)var8 + 1; (double)var13 <= var10; ++var13) {
            List var14 = (List)var12.get(var13);
            if (var14 != null) {
               var14.forEach(var1::b);
               var1.a(true);
            }
         }

      }
   }

   public ImmutableViolation dispatchViolation(Violation violation) {
      ImmutableViolation var5 = ImmutableViolation.a(violation);
      Optional var6 = violation.getPlayer();
      if (!var6.isPresent()) {
         return var5.c("Player is not present").h();
      } else {
         Player var7 = (Player)var6.get();
         PlayerData var8 = PlayerDataManager.getPlayerData(var7);
         if (var8.getTrustFactor().atLeast(TrustFactor.BYPASS)) {
            return var5.a("Player has the bypass trust-factor").h();
         } else {
            AbstractCheck var9 = violation.getCheck();
            if (!var9.isEnabled()) {
               return var5.a("Check is disabled").h();
            } else if (!var8.isRecentLogin() && var8.exists()) {
               this.e(var5);
               this.j(var5);
               this.c(var5);
               this.f(var5);
               this.h(var5);
               this.d(var5);
               this.g(var5);
               this.i(var5);
               this.b(var5);
               this.a(var5);
               if (!var5.a() && var5.e()) {
                  var5.c("Activation prevention reached");
               }

               return var5.h();
            } else {
               return violation.getCheck().getStrategy() == MitigationStrategy.SILENT
                  ? var5.a("Player just joined or is not reachable (silent mode)")
                  : var5.c("Player just joined or is not reachable").h();
            }
         }
      }
   }

   private void a(Player var1, String var2) {
      if (Bukkit.isPrimaryThread()) {
         var1.sendMessage(var2);
      } else {
         IntaveScheduler.runTask(Unknown286::b);
      }

   }

   private void j(ImmutableViolation var1) {
      if (!var1.a()) {
         Violation var5 = var1.l();
         Player var6 = (Player)var5.getPlayer().orElseThrow(IllegalStateException::new);
         String var7 = var5.getCheck().k().toLowerCase(Locale.ROOT);
         String var8 = var5.l();
         String var9 = var5.h();
         double var10 = var1.b();
         double var12 = var1.j();
         IntaveViolationEvent var14 = (IntaveViolationEvent)MoudleLoader.n().a(IntaveViolationEvent.class, Unknown286::a);
         if (var14.isCancelled()) {
            IntaveViolationEvent.Reaction var15 = var14.reaction();
            boolean var16 = var15 == IntaveViolationEvent.Reaction.INTERRUPT && var1.e();
            if (var16) {
               var1.c("Intave access requested it");
            } else {
               var1.a("Intave access requested it");
            }

            var1.h();
         }

      }
   }

   public void a(String var1) {
      Set var5 = Unknown390.c(g);
      if (!var5.isEmpty()) {
         String var6 = LogUtil.a(new Unknown266(var1));

         for(Player var8 : var5) {
            PlayerData var9 = PlayerDataManager.getPlayerData(var8);
            if (var9.a(g)) {
               this.a(var8, var6);
            }
         }

      }
   }

   public void a(Player var1, ImmutableViolation var2) {
      Set var6 = Unknown390.c(e);
      if (!var6.isEmpty()) {
         Unknown373 var7 = var2.l().e();
         Unknown37 var8 = var2.a(Unknown99.a);
         String var9 = LogUtil.a(var1, var7.a(var8));

         for(Player var11 : var6) {
            PlayerData var12 = PlayerDataManager.getPlayerData(var11);
            if (var12.a(e)) {
               Predicate var13 = var12.b(e);
               if (var13 == null || var13.test(var1)) {
                  this.a(var11, var9);
               }
            }
         }

      }
   }

   private void a(ImmutableViolation var1, String var2) {
      Violation var3 = var1.l();
      Player var4 = (Player)var3.getPlayer().orElseThrow(IllegalStateException::new);
      String var5 = var3.getCheck().k().toLowerCase(Locale.ROOT);
      IntaveScheduler.runTask(this::a);
   }
}
