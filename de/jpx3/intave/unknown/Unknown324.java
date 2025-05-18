package de.jpx3.intave.unknown;

import de.jpx3.intave.access.player.storage.EmptyStorageGateway;
import de.jpx3.intave.access.player.storage.StorageGateway;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.threading.BackgroundThreadingPool;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class Unknown324 extends UnknownCheck {
   private static final long f = TimeUnit.MINUTES.toMillis(20L);
   private StorageGateway a = new EmptyStorageGateway();

   public void a(StorageGateway var1) {
      this.a = var1;
   }

   private static void a(Consumer var0, UUID var1, ByteBuffer var2) {
      if (var2.array().length == 0) {
         var0.accept(null);
      } else {
         Unknown343 var6 = Unknown305.a(var1);
         var6.a(var2);
         var0.accept(var6);
      }
   }

   private void b() {
      Bukkit.getOnlinePlayers().forEach(this::a);
   }

   private void a(Player var1) {
      Unknown335 var2 = PlayerDataManager.getPlayerData(var1).k();
      UUID var3 = var1.getUniqueId();
      ByteBuffer var4 = var2.a();
      BackgroundThreadingPool.submit(this::b);
   }

   @BukkitEventListener(
      a = EventPriority.HIGHEST
   )
   public void a(PlayerJoinEvent var1) {
      this.b(var1.getPlayer());
   }

   private void b(UUID var1, ByteBuffer var2) {
      this.a.saveStorage(var1, var2);
   }

   private void a(UUID var1, Unknown335 var2) {
      this.a.requestStorage(var1, var2::a);
   }

   @Override
   public void refreshConfig() {
      Bukkit.getOnlinePlayers().forEach(this::b);
      int var5 = Bukkit.getScheduler().scheduleAsyncRepeatingTask(IntavePlugin.getInstance(), this::b, f / 50L, f / 50L);
      Unknown22.a(var5);
   }

   @Override
   public void e() {
      Bukkit.getOnlinePlayers().forEach(this::a);
   }

   private void b(Player var1) {
      Unknown335 var2 = PlayerDataManager.getPlayerData(var1).k();
      UUID var3 = var1.getUniqueId();
      BackgroundThreadingPool.submit(this::a);
   }

   public void b(UUID var1, Consumer var2) {
      IntaveScheduler.runTask(this::a);
   }

   @BukkitEventListener(
      a = EventPriority.LOWEST
   )
   public void a(PlayerQuitEvent var1) {
      this.a(var1.getPlayer());
   }

   private void c(UUID var1, Consumer var2) {
      this.a.requestStorage(var1, Unknown324::a);
   }

   private void a(UUID var1, Consumer var2) {
      BackgroundThreadingPool.submit(this::c);
   }

   public StorageGateway a() {
      return this.a;
   }
}
