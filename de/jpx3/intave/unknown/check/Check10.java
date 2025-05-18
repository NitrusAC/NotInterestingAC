package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.unknown.Unknown171;
import de.jpx3.intave.unknown.Unknown22;
import de.jpx3.intave.unknown.Unknown354;
import de.jpx3.intave.unknown.unknown79;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class Check10 extends UnknownCheck {
   private static final long e = Check10.f / 4L;
   private static final long f = TimeUnit.SECONDS.toMillis(40L);
   private static final long a = 2000L;
   private static final boolean g = MinecraftVersion.V_1_17.atOrAbove();

   private void b(Player var1) {
      PlayerData var5 = this.getData(var1);
      unknown79 var6 = var5.getStorage().c();
      if (this.a(var5) > f && var6.n) {
         Logger.getLogger().severe(var1.getName() + " is not responding to any feedback packets");
         var5.error("Timed out");
         this.b();
      }

   }

   public PlayerData getData(Player player) {
      return PlayerDataManager.getPlayerData(player);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void a(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      unknown79 var7 = var6.getStorage().c();
      var7.n = true;
      if (this.a(var6) > 2000L || !var7.f().isEmpty() || System.currentTimeMillis() - var7.k < 250L) {
         event.setCancelled(true);
      }

   }

   private void c() {
      for(Player var5 : Bukkit.getOnlinePlayers()) {
         this.b(var5);
      }

   }

   private static void b(Thread var0, StackTraceElement[] var1) {
      if (var0.getName().contains("Netty")) {
         boolean var5 = false;

         for(StackTraceElement var9 : var1) {
            if (var9.getClassName().toLowerCase(Locale.ROOT).contains("intave")) {
               var5 = true;
               break;
            }
         }

         if (var5) {
            System.out.println("Thread: " + var0.getName());
            Exception var10 = new Exception();
            var10.setStackTrace(var1);
            var10.printStackTrace();
         }
      }

   }

   private void b() {
      Thread.getAllStackTraces().forEach(Check10::b);
   }

   private void a(PlayerData var1, Unknown171 var2) {
      Player var6 = var1.getPlayer();
      unknown79 var7 = var1.getStorage().c();
      var7.e = var2.a();
      var7.y = var2.b();
      Map var8 = var7.g();
      Queue var9 = (Queue)var8.get(var2.b());
      if (var9 != null && !var9.isEmpty()) {
         for(Unknown171 var11 : var9) {
            this.a(var6, var11);
         }

         var8.remove(var2.b());
      }

      this.a(var6, var2);
   }

   private void a(Player var1, Unknown171 var2) {
      try {
         var2.a(var1);
      } catch (Exception var4) {
      }

   }

   public long a(PlayerData var1) {
      unknown79 var5 = var1.getStorage().c();
      Map var6 = var5.m();
      long var7 = System.currentTimeMillis();

      for(Unknown171 var10 : var6.values()) {
         var7 = Math.min(var7, var10.a());
      }

      return System.currentTimeMillis() - var7;
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGHEST,
      packetTypes = {ClientPacket.BLOCK_DIG, ClientPacket.BLOCK_PLACE, ClientPacket.USE_ITEM}
   )
   public void c(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      var3.getStorage().c().n = true;
      if (this.a(var3) > 4000L) {
         event.setCancelled(true);
      }

   }

   public Check10(IntavePlugin plugin) {
      int var2 = plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, this::c, e, e);
      Unknown22.a(var2);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      packetTypes = {ClientPacket.TRANSACTION, ClientPacket.PONG}
   )
   public void b(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      if (var6.exists()) {
         unknown79 var7 = var6.getStorage().c();
         Map var8 = var7.h();
         Map var9 = var7.m();
         PacketContainer var10 = event.getPacket();
         short var11;
         if (g) {
            int var12 = var10.getIntegers().readSafely(0);
            if ((var12 & -65536) != -178978816) {
               return;
            }

            var11 = (short)(var12 & 65535);
         } else {
            short var24 = var10.getShorts().readSafely(0);
            if (var24 > -16370) {
               return;
            }

            var11 = var24;
         }

         Unknown171 var25 = (Unknown171)var9.get(var11);
         if (var25 != null) {
            long var13 = var7.y + 1L;
            long var15 = var25.b();
            if (var15 != var13) {
               long var17 = Math.min(var13, var15);
               long var19 = Math.max(var13, var15);

               for(long var21 = var17; var21 < var19; ++var21) {
                  Unknown171 var23 = (Unknown171)var8.remove(var21);
                  if (var23 != null) {
                     var9.remove(var23.g());
                     this.a(var6, var23);
                  }
               }

               var6.timeOut();
            }

            var9.remove(var11);
            var8.remove(var25.b());
            this.a(var6, var25);
            long var26 = var25.d();
            var7.a(var26);
            Unknown354.a(var26);
            event.setCancelled(true);
         }
      }
   }
}
