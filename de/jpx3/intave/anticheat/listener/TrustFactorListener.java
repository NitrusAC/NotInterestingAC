package de.jpx3.intave.anticheat.listener;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.access.player.trust.DefaultForwardingPermissionTrustFactorResolver;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactorResolver;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.threading.BackgroundThreadingPool;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.unknown.Unknown237;
import de.jpx3.intave.unknown.Unknown348;
import de.jpx3.intave.unknown.Unknown89;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;

public final class TrustFactorListener implements PacketListener {
   private static final TrustFactorResolver DEFAULT_RESOLVER = new DefaultForwardingPermissionTrustFactorResolver(new Unknown89());
   private TrustFactor trustFactor = TrustFactor.ORANGE;
   private final IntavePlugin intavePlugin;
   private TrustFactorResolver resolver;
   private Unknown237 e;

   public TrustFactor g() {
      return this.trustFactor;
   }

   public void setTrustFactor(TrustFactor var1) {
      this.trustFactor = var1;
   }

   private void f() {
      for(Player var5 : Bukkit.getOnlinePlayers()) {
         this.resolve(var5);
      }

   }

   private void e() {
      BackgroundThreadingPool.submit(this::f);
   }

   @BukkitEventListener(
      a = EventPriority.NORMAL
   )
   public void onJoin(PlayerJoinEvent var1) {
      Player var2 = var1.getPlayer();
      BackgroundThreadingPool.submit(this::check);
   }

   private void check(Player var1) {
      this.resolve(var1);
   }

   public Unknown237 c() {
      return this.e;
   }

   public void setResolver(TrustFactorResolver var1) {
      this.resolver = var1;
   }

   public TrustFactorListener(IntavePlugin var1) {
      this.intavePlugin = var1;
   }

   public TrustFactorResolver getResolver() {
      return this.resolver;
   }

   private static void b(PlayerData var0, TrustFactor var1) {
      String var5 = var1.chatColor() + "" + var1 + IntavePlugin.l();
      IntavePlugin.getInstance().getLogger().info("Assigned trust factor " + var5 + " to " + (var0.exists() ? var0.getPlayer().getName() : "null"));
      var0.setTrustFactor(var1);
   }

   public void a() {
      Unknown348 var3 = new Unknown348();
      this.e = var3.a();
      this.resolver = DEFAULT_RESOLVER;
      this.intavePlugin.d().b(this);
      IntaveScheduler.runTask(this::e);
   }

   private void resolve(Player var1) {
      PlayerData var5 = PlayerDataManager.getPlayerData(var1);
      var5.setTrustFactor(this.trustFactor);
      if (this.resolver == null) {
         this.resolver = DEFAULT_RESOLVER;
      }

      this.resolver.resolve(var1, TrustFactorListener::b);
   }

   public int a(String var1, Player var2) {
      return this.e.a(var1, PlayerDataManager.getPlayerData(var2).getTrustFactor());
   }
}
