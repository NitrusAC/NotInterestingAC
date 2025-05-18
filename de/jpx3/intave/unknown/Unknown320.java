package de.jpx3.intave.unknown;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import java.util.Collection;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;

public final class Unknown320 extends UnknownCheck {
   private static boolean a(Collection var0, Location var1, int var2) {
      for(BlockPosition var7 : var0) {
         if (a(var1, var7) < (double)var2) {
            return true;
         }
      }

      return false;
   }

   @PacketListener(
      e = Unknown5.b,
      g = {ServerPacket.MAP_CHUNK, ServerPacket.MAP_CHUNK_BULK}
   )
   public void c(PacketEvent var1) {
      PacketContainer var5 = var1.getPacket();
      Player var6 = var1.getPlayer();
      Unknown64 var7 = (Unknown64)PacketInterpreters.getInterpreter(var5);
      int[] var8 = var7.b();
      int[] var9 = var7.a();
      var7.reset();
      if (var8.length != var9.length) {
         throw new IllegalStateException();
      } else {
         MoudleLoader.m().a(var6, this::a, Unknown228.a | Unknown228.c);
      }
   }

   private void a(Player var1, int var2, int var3) {
      int var4 = var2 << 4;
      int var5 = var4 + 16;
      int var6 = var3 << 4;
      int var7 = var6 + 16;
      IntaveWorld var8 = PlayerDataManager.getPlayerData(var1).getWorld();
      var8.a(var4, var5, var6, var7);
   }

   private void a(int[] var1, Player var2, int[] var3, Player var4, Object var5) {
      for(int var9 = 0; var9 < var1.length; ++var9) {
         this.a(var2, var1[var9], var3[var9]);
      }

   }

   @PacketListener(
      g = {ServerPacket.BLOCK_BREAK, ServerPacket.BLOCK_CHANGE, ServerPacket.MULTI_BLOCK_CHANGE}
   )
   public void a(PacketEvent var1) {
      Player var6 = var1.getPlayer();
      PacketContainer var7 = var1.getPacket();
      Unknown398 var8 = (Unknown398)PacketInterpreters.getInterpreter(var7);
      List var9 = var8.a();
      List var10 = var8.b();
      var8.reset();
      World var11 = var6.getWorld();
      Unknown176 var12 = Unknown320::b;
      Location var13 = var6.getLocation();
      boolean var14 = a(var9, var13, 8);
      if (var14) {
         MoudleLoader.m().a(var6, var12, Unknown228.a);
      } else {
         var12.a(var6, null);
      }

   }

   private static void b(List var0, List var1, World var2, Player var3, Object var4) {
      PlayerData var8 = PlayerDataManager.getPlayerData(var3);
      IntaveWorld var9 = var8.getWorld();
      Location var10 = var8.getStorage().getPhysicsHolder().getLocation();

      for(int var11 = 0; var11 < var0.size(); ++var11) {
         BlockPosition var12 = (BlockPosition)var0.get(var11);
         WrappedBlockData var13 = (WrappedBlockData)var1.get(var11);
         if (a(var10, var12) < 2.0) {
            var8.getStorage().getPhysicsHolder().T = 0;
         }

         Material var14 = var13.getType();
         int var15 = Unknown15.a(var13);
         var9.a(var2, var12.getX(), var12.getY(), var12.getZ(), var14, var15);
         var9.b(var12.getX(), var12.getY(), var12.getZ());
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      packetTypes = {ClientPacket.BLOCK_DIG, ClientPacket.BLOCK_PLACE, ClientPacket.USE_ITEM}
   )
   public void b(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PacketType var6 = var1.getPacketType();
      PacketContainer var7 = var1.getPacket();
      Unknown202 var8 = (Unknown202)PacketInterpreters.getInterpreter(var7);
      boolean var9 = true;
      if (var6 == Client.BLOCK_DIG) {
         PlayerDigType var10 = (PlayerDigType)var7.getPlayerDigTypes().read(0);
         var9 = var10 == PlayerDigType.START_DESTROY_BLOCK || var10 == PlayerDigType.STOP_DESTROY_BLOCK || var10 == PlayerDigType.ABORT_DESTROY_BLOCK;
      } else if (var6 == Client.BLOCK_PLACE) {
         BlockPosition var15 = var8.a();
         if (var15 == null) {
            var8.reset();
            return;
         }

         Unknown215 var11 = (Unknown215)var8;
         if (var11.a() == 255 || var1.isCancelled()) {
            var9 = false;
         }
      }

      if (var9) {
         BlockPosition var16 = var8.a();
         if (var16 == null) {
            var8.reset();
            return;
         }

         Vector var17 = var16.toVector();
         PlayerData var12 = PlayerDataManager.getPlayerData(var5);
         BukkitEnginePlayer var13 = var12.getStorage().getPhysicsHolder();
         Vector var14 = new Vector(var13.lastX, var13.lastY, var13.lastZ);
         if (var14.distance(var17) > 16.0) {
            var1.setCancelled(true);
         }
      }

      var8.reset();
   }

   private static double a(Location var0, BlockPosition var1) {
      return Math.sqrt(
         NumberConversions.square((double)(var0.getBlockX() - var1.getX()))
            + NumberConversions.square((double)(var0.getBlockY() - var1.getY()))
            + NumberConversions.square((double)(var0.getBlockZ() - var1.getZ()))
      );
   }
}
