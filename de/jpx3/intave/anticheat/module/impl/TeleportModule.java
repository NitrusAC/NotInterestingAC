package de.jpx3.intave.anticheat.module.impl;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.module.Module;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.unknown.Unknown179;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.util.Vector;

public final class TeleportModule implements Module {
   private static final boolean b = MinecraftVersion.V_1_9.atOrAbove();
   private static final boolean a = false;

   private void c(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      if (var7.teleporting && var7.P-- < 0) {
         IntaveScheduler.runTask(TeleportModule::a);
      }

   }

   private static void b(Player var0) {
      Bukkit.broadcastMessage("[Intave] " + var0.getName() + " did not accept the teleport request");
   }

   private void c(Player var1) {
      PlayerData var5 = PlayerDataManager.getPlayerData(var1);
      BukkitEnginePlayer var6 = var5.getStorage().getPhysicsHolder();
      double var7 = var6.x;
      double var9 = var6.y;
      double var11 = var6.z;
      Location var13 = var6.aB;
      boolean var14;
      if (b && var6.W && var6.ah) {
         var7 = var13.getX();
         var9 = var13.getY();
         var11 = var13.getZ();
         var14 = true;
      } else {
         double var15 = MathUtil2.a(var7, var9, var11, var13.getX(), var13.getY(), var13.getZ());
         boolean var17 = var15 < 1.0E-5 && var6.ah;
         if (var17) {
         }

         var14 = var17;
      }

      if (var14) {
         this.d(var1);
         this.a(var1, var7, var9, var11);
         double var18 = MathUtil2.a(var6.lastX, var6.lastZ, var13.getX(), var13.getZ());
         if (var18 > 20.0) {
            var6.bU = 0;
         }
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.TELEPORT_ACCEPT}
   )
   public void d(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      PacketContainer var8 = var1.getPacket();
      Integer var9 = (Integer)var8.getIntegers().read(0);
      if (var7.r == var9) {
         var7.W = true;
      }

   }

   private static void a(BukkitEnginePlayer var0, Player var1, Object var2) {
      var0.ah = true;
   }

   private void a(Player var1, double var2, double var4, double var6) {
      PlayerData var8 = PlayerDataManager.getPlayerData(var1);
      BukkitEnginePlayer var9 = var8.getStorage().getPhysicsHolder();
      var9.x = var2;
      var9.y = var4;
      var9.z = var6;
      var9.serverX = var2;
      var9.serverY = var4;
      var9.serverZ = var6;
      var9.deltaX = 0.0;
      var9.deltaY = 0.0;
      var9.deltaZ = 0.0;
      var9.onGround = false;
      var9.setBoundingBox(Box.of(var8, var9.aB));
   }

   private static void a(BukkitEnginePlayer var0, Player var1) {
      Location var2 = var0.aB;
      var1.teleport(var2, TeleportCause.NETHER_PORTAL);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      g = {ServerPacket.POSITION}
   )
   public void b(PacketEvent var1) {
      Player var6 = var1.getPlayer();
      PacketContainer var7 = var1.getPacket();
      PlayerData var8 = PlayerDataManager.getPlayerData(var6);
      BukkitEnginePlayer var9 = var8.getStorage().getPhysicsHolder();
      StructureModifier var10 = var7.getDoubles();
      Double var11 = (Double)var10.read(0);
      Double var12 = (Double)var10.read(1);
      Double var13 = (Double)var10.read(2);
      Set var14 = Unknown179.a(var7);
      boolean var15 = var14.contains(Unknown179.a);
      boolean var16 = var14.contains(Unknown179.b);
      boolean var17 = var14.contains(Unknown179.c);
      if (var15 || var16 || var17) {
         Vector var18 = new Vector(var11, var12, var13);
         if (var18.length() == 0.0) {
            return;
         }
      }

      Location var19 = new Location(var6.getWorld(), var11, var12, var13);
      var9.aB = var19;
      var9.setLocation(var19.clone(), "Teleportation (new)");
      if (b) {
         var9.r = var7.getIntegers().read(0);
      } else {
         var9.teleportTicks = 0;
      }

      if (!var8.getStorage().getVersionHolder().isRewindVersion()) {
         MoudleLoader.m().a(var6, var1, null, TeleportModule::a, TeleportModule::b);
      } else {
         var9.ah = true;
      }

      var9.teleporting = true;
      var9.V = false;
      var9.P = 20;
      var9.bG = false;
   }

   private static void a(Player var0) {
      Bukkit.broadcastMessage("[Intave] " + var0.getName() + " accepted teleport request (release lock)");
   }

   public void a() {
      MoudleLoader.j().a().b(this);
   }

   private void d(Player var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var1);
      BukkitEnginePlayer var3 = var2.getStorage().getPhysicsHolder();
      var3.teleporting = false;
      var3.ah = false;
      var3.bG = true;
   }

   private static void a(Player var0, String var1) {
      Bukkit.broadcastMessage("[Intave] Checking potential teleport accept of " + var0.getName() + " on " + var1);
   }

   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      this.c(var1);
      if (var7.teleporting && (!b || var7.W)) {
         this.c(var5);
      }

   }

   private static void b(BukkitEnginePlayer var0, Player var1, Object var2) {
      var0.ah = false;
   }
}
