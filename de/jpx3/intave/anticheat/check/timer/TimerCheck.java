package de.jpx3.intave.anticheat.check.timer;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.aF;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.threading.ThreadFactory;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown228;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public final class TimerCheck extends PartialConfigurableCheck {
   private final ScheduledExecutorService f = Executors.newSingleThreadScheduledExecutor(ThreadFactory.b());
   private static final String h;

   @PacketListener(
      packetTypes = {ClientPacket.POSITION_LOOK, ClientPacket.POSITION, ClientPacket.FLYING, ClientPacket.LOOK}
   )
   public void b(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = this.getPlayerData(var2);
      aF var4 = (aF)this.getStorage(var3);
      --var4.c;
   }

   private void a() {
      Bukkit.getOnlinePlayers().forEach(this::a);
   }

   private void c() {
      Runnable var1 = this::a;
      this.f.scheduleAtFixedRate(var1, 20L, 50L, TimeUnit.MILLISECONDS);
   }

   @PacketListener(
      g = {ServerPacket.POSITION}
   )
   public void a(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      aF var4 = (aF)this.getStorage(var3);
      ++var4.c;
   }

   private void b(Player var1, Object var2) {
      this.a(this.getPlayerData(var1));
   }

   private void a(PlayerData var1) {
      Player var5 = var1.getPlayer();
      aF var6 = (aF)this.getStorage(var1);
      ++var6.c;
      if (var1.isRecentLogin()) {
         var6.c = 1;
      }

      ChatColor var7 = var6.c < 0 ? ChatColor.RED : ChatColor.GRAY;
      var6.a = var6.c;
      if (var6.c < 0) {
         Violation var8 = Violation.builder(TimerCheckGroup.class).player(var5).name("moved too frequently").vl(0.5).build();
         ImmutableViolation var9 = MoudleLoader.violations().dispatchViolation(var8);
         if (var9.m()) {
            BukkitEnginePlayer var10 = var1.getStorage().getPhysicsHolder();
            var10.aO = true;
            Vector var11 = new Vector(var10.deltaX, var10.deltaY, var10.deltaZ);
            MoudleLoader.o().b().a(var5, var11, 12, false);
         }

         this.b(var1);
      }

   }

   private void a(Player var1) {
      MoudleLoader.m().a(var1, this::b, Unknown228.c);
   }

   public TimerCheck(TimerCheckGroup var1) {
      super(var1, aF.class);
      this.c();
   }

   public void b(PlayerData var1) {
      ((aF)this.getStorage(var1)).c = 0;
   }
}
