package de.jpx3.intave.anticheat.check.network;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.unknown.Unknown22;
import de.jpx3.intave.unknown.unknown79;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class KeepAliveResponseCheck extends UnknownCheck {
   private static final long a = 30000L;

   private long getLastKeepAlive(PlayerData var1) {
      unknown79 var5 = var1.getStorage().c();
      Map var6 = var5.a();
      long var7 = System.currentTimeMillis();

      for(Long var10 : var6.values()) {
         var7 = Math.min(var10, var7);
      }

      return var7;
   }

   @Override
   public void refreshConfig() {
      int var1 = this.plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(this.plugin, this::tickServer, 0L, 300L);
      Unknown22.a(var1);
   }

   private void tickServer() {
      for(Player var5 : Bukkit.getOnlinePlayers()) {
         PlayerData var6 = PlayerDataManager.getPlayerData(var5);
         long var7 = System.currentTimeMillis() - this.getLastKeepAlive(var6);
         if (30000L < var7) {
            Logger.getLogger().print("[Intave] " + var5.getName() + " was not responding to keep-alive packets for at least 30 seconds");
            var6.error("Timed out");
            this.b();
         }
      }

   }

   private void b() {
      Thread.getAllStackTraces().forEach(KeepAliveResponseCheck::dumpNettyStackTrace);
   }

   private static void dumpNettyStackTrace(Thread thread, StackTraceElement[] stackTrace) {
      if (thread.getName().contains("Netty")) {
         boolean var5 = false;

         for(StackTraceElement var9 : stackTrace) {
            if (var9.getClassName().contains("Intave")) {
               var5 = true;
               break;
            }
         }

         System.out.println("Thread:" + thread.getName());
         Exception var11 = new Exception();
         var11.setStackTrace(stackTrace);
         var11.printStackTrace();
      }

   }

   @PacketListener(
      g = {ServerPacket.KEEP_ALIVE}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      long var8;
      if (var7.getLongs().size() > 0) {
         var8 = var7.getLongs().read(0);
      } else {
         var8 = (long)((Integer)var7.getIntegers().read(0)).intValue();
      }

      var6.getStorage().c().a().put(var8, System.currentTimeMillis());
   }

   @PacketListener(
      packetTypes = {ClientPacket.KEEP_ALIVE}
   )
   public void handleKeepAlive(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = event.getPacket();
      unknown79 var8 = var6.getStorage().c();
      Map var9 = var8.a();
      long var10;
      if (var7.getLongs().size() > 0) {
         var10 = var7.getLongs().read(0);
      } else {
         var10 = Long.valueOf((long)((Integer)var7.getIntegers().read(0)).intValue());
      }

      if (var10 == 0L) {
         event.setCancelled(true);
      } else if (!var9.containsKey(var10)) {
         Logger.getLogger().severe(var5.getName() + " sent keep-alive id " + var10 + ", but expected one of " + var9.keySet());
         var6.error("Unknown keep-alive identifier");
      } else {
         List var12 = var8.o();
         Long var13 = (Long)var9.remove(var10);
         long var14 = MathUtil2.a(0L, System.currentTimeMillis() - var13, 1000L);
         var8.c = (int)(((double)var8.c * 3.0 + (double)var14) / 4.0);
         long var16 = Math.abs(var14 - var8.p);
         byte var18 = 8;
         boolean var19 = var12.size() >= var18;
         if (var19) {
            var12.remove(0);
         }

         var12.add(var16);
         if (var19) {
            var6.getStorage().c().h = (int)var12.stream().mapToLong(KeepAliveResponseCheck::b).average().orElse(0.0);
         }

         this.plugin.o().b().a().a(var5, var8.c, (int)var16);
         var8.p = var14;
      }
   }

   private static long b(Long var0) {
      return var0;
   }
}
