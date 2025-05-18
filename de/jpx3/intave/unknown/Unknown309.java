package de.jpx3.intave.unknown;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class Unknown309 extends UnknownCheck {
   public static final short l = -16370;
   private static final Object e = new Object();
   private final ProtocolManager g;
   public static final int f = -178978816;
   public static final short k = -32768;
   private final boolean a = MinecraftVersion.V_1_17.atOrAbove();
   private static final long j = 100L;
   private static final long i = 20L;

   private static long a(PlayerData var0) {
      return (long)var0.getStorage().c().m().size();
   }

   private void a(Player var1, PacketContainer var2) {
      de.jpx3.intave.anticheat.packet.ProtocolManager.sendPacket(var1, var2);
   }

   private void a(Player var1, PacketContainer var2, Object var3, Unknown176 var4, Unknown176 var5, Unknown340 var6, Unknown340 var7, int var8) {
      this.b(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void a(Player var1, PacketEvent var2, Object var3, Unknown176 var4, Unknown176 var5, Unknown340 var6, Unknown340 var7) {
      this.a(var1, var2, var3, var4, var5, var6, var7, 0);
   }

   public void a(Player var1, Unknown176 var2, int var3) {
      this.b(var1, null, var2, null, var3);
   }

   public void b(Player var1, Object var2, Unknown176 var3, Unknown340 var4, int var5) {
      if (!Bukkit.isPrimaryThread()) {
         if (Unknown228.a(Unknown228.c, var5)) {
            IntaveScheduler.runTask(this::a);
         } else {
            Logger.getLogger().severe("Can't perform tick-validation off main thread");
            Logger.getLogger().severe("Please check if you sent a packet / performed a bukkit player action asynchronously in the following trace:");
            Thread.dumpStack();
            var3.a(var1, var2);
         }

      } else {
         PlayerData var9 = PlayerDataManager.getPlayerData(var1);
         if (var9 != null && var9.exists()) {
            boolean var10 = false;
            if (Unknown228.a(Unknown228.a, var5)) {
               boolean var11 = a(this.b(var1)) > 20L;
               boolean var12 = var9.getStorage().c().u > 100L;
               var10 = var11 || var12;
            }

            if (Unknown228.a(Unknown228.b, var5)) {
               var10 = true;
            }

            if (var10) {
               this.b(var1, var2, var3);
            } else {
               this.a(var1);
               Unknown171 var13 = this.b(var1, var2, var3, var4);
               this.a(var1, var13);
            }
         }
      }
   }

   public void a(Player var1, Object var2, Unknown176 var3, int var4) {
      this.b(var1, var2, var3, null, var4);
   }

   private PlayerData b(Player var1) {
      return PlayerDataManager.getPlayerData(var1);
   }

   public void a(Player var1, PacketEvent var2, Object var3, Unknown176 var4, Unknown176 var5, Unknown340 var6, Unknown340 var7, int var8) {
      this.b(var1, var2.getPacket(), var3, var4, var5, var6, var7, var8);
      if (var2.isReadOnly()) {
         var2.setReadOnly(false);
      }

      var2.setCancelled(true);
   }

   private void a(Player var1, Unknown171 var2) {
      if (var2 != null) {
         short var6 = var2.g();
         PacketContainer var7;
         if (this.a) {
            var7 = this.g.createPacket(Server.PING);
            var7.getIntegers().write(0, -178978816 | var6);
         } else {
            var7 = this.g.createPacket(Server.TRANSACTION);
            var7.getIntegers().write(0, 0);
            var7.getShorts().write(0, var6);
            var7.getBooleans().write(0, false);
         }

         this.a(var1, var7);
         var2.e();
      }
   }

   private void a(Player var1, Object var2, Unknown176 var3, Unknown340 var4, int var5) {
      this.b(var1, var2, var3, var4, var5);
   }

   private Unknown171 b(Player var1, Object var2, Unknown176 var3, Unknown340 var4) {
      PlayerData var8 = PlayerDataManager.getPlayerData(var1);
      unknown79 var9 = var8.getStorage().c();
      if (var2 == null) {
         var2 = e;
      }

      short var10 = this.c(var1);
      long var11 = (long)(var9.D++);
      Unknown171 var13 = new Unknown171(var3, var4, var2, var10, var11);
      var9.m().put(var10, var13);
      var9.h().put(var11, var13);
      return var13;
   }

   private short c(Player var1) {
      PlayerData var5 = PlayerDataManager.getPlayerData(var1);
      unknown79 var6 = var5.getStorage().c();
      Map var7 = var6.m();
      int var8 = 1000;
      int var9 = this.a ? 13 : -32768;
      int var10 = var7.size();
      if (var10 > 500) {
         var9 = (short)(var9 + var10);
      }

      while(var7.containsKey(Short.valueOf((short)var9)) && var8-- > 0) {
         var9 = (short)(var9 + 1);
      }

      return (short)var9;
   }

   public void a(Player var1, PacketEvent var2, Object var3, Unknown176 var4, Unknown176 var5) {
      this.a(var1, var2, var3, var4, var5, null, null);
   }

   public void a(Player var1, PacketContainer var2, Object var3, Unknown176 var4, Unknown176 var5) {
      this.b(var1, var2, var3, var4, var5, null, null, 0);
   }

   private void b(Player var1, Object var2, Unknown176 var3) {
      PlayerData var7 = PlayerDataManager.getPlayerData(var1);
      if (var7.exists()) {
         unknown79 var8 = var7.getStorage().c();
         Queue var9 = (Queue)var8.g().computeIfAbsent(var8.D, Unknown309::b);
         if (var2 == null) {
            var2 = e;
         }

         var9.add(new Unknown171(var3, null, var2, (short)-1, -1L));
      }
   }

   public void a(Player var1, Unknown176 var2) {
      this.b(var1, null, var2, null, 0);
   }

   public Unknown309() {
      this.g = ProtocolLibrary.getProtocolManager();
   }

   public void a(Player var1, Object var2, Unknown176 var3) {
      this.a(var1, var2, var3, 0);
   }

   public void a(Player var1, Object var2, Unknown176 var3, Unknown340 var4) {
      this.b(var1, var2, var3, var4, 0);
   }

   private static Queue b(Long var0) {
      return new LinkedBlockingDeque();
   }

   public void b(Player var1, PacketContainer var2, Object var3, Unknown176 var4, Unknown176 var5, Unknown340 var6, Unknown340 var7, int var8) {
      if (!Bukkit.isPrimaryThread()) {
         if (Unknown228.a(Unknown228.c, var8)) {
            IntaveScheduler.runTask(this::a);
         } else {
            Logger.getLogger().severe("Can't perform tick-validation off main thread");
            Logger.getLogger().severe("Please check if you sent a packet / performed a bukkit player action asynchronously in the following trace:");
            Thread.dumpStack();
            var4.a(var1, var3);
            var5.a(var1, var3);
         }

      } else {
         PlayerData var12 = PlayerDataManager.getPlayerData(var1);
         if (var12 != null && var12.exists()) {
            this.b(var1, var3, var4, var6, var8);
            var12.D();
            this.a(var1, var2);
            var12.q();
            this.b(var1, var3, var5, var7, var8);
         }
      }
   }

   private void a(Player var1) {
      PlayerData var5 = this.b(var1);
      unknown79 var6 = var5.getStorage().c();
      ++var6.u;
      if (System.currentTimeMillis() - var6.f > 3000L) {
         var6.u = 0L;
         var6.f = System.currentTimeMillis();
      }

   }
}
