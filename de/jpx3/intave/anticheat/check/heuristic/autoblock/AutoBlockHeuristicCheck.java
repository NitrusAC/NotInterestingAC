package de.jpx3.intave.anticheat.check.heuristic.autoblock;

import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.pU;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.DamageHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class AutoBlockHeuristicCheck extends PartialConfigurableCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   private void a(Player player, PacketContainer packet) {
      this.getPlayerData(player).c();
      ProtocolManager.receivePacket(player, packet);
   }

   @PacketListener(
      packetTypes = {ClientPacket.BLOCK_PLACE, ClientPacket.BLOCK_DIG}
   )
   public void handleBlock(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      DamageHolder var7 = var6.getStorage().getDamageHolder();
      AutoBlockHeuristicStorage var8 = (AutoBlockHeuristicStorage)this.getStorage(var6);
      PacketContainer var9 = event.getPacket();
      if (var6.getStorage().getVersionHolder().isLegacy() && !var6.getStorage().getEntityHolder().isSpectator()) {
         if (var9.getType() == Client.BLOCK_DIG) {
            PlayerDigType var10 = (PlayerDigType)var9.getPlayerDigTypes().readSafely(0);
            if (var10 == PlayerDigType.RELEASE_USE_ITEM) {
               var8.swinging = true;
               var8.e = true;
               int var11 = var8.d;
               if (var11 == 0) {
                  String var12 = "unblocked too quickly (" + var11 + ")";
                  short var13 = 530;
                  Anomaly var14 = Anomaly.of("143", Certainty.MAYBE, CombatCheckType.KILLAURA, var12, var13);
                  ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var14);
                  var6.a(Unknown227.BLOCKING, "6");
                  var7.f = System.currentTimeMillis();
                  IntaveScheduler.runTask(AutoBlockHeuristicCheck::b);
               }
            }
         } else {
            ItemStack var16 = (ItemStack)var9.getItemModifier().readSafely(0);
            boolean var17 = var16 != null && var16.getType().name().endsWith("_SWORD");
            if (var8.swinging) {
               String var18 = "sent multiple blocking interactions per tick (" + (var16 == null ? "null" : var16.getType()) + ")";
               Anomaly var20 = Anomaly.of("141", Certainty.NONE, CombatCheckType.KILLAURA, var18);
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var20);
               var6.a(Unknown227.BLOCKING, "7");
            }

            int var19 = var8.g;
            Integer var21 = (Integer)var9.getIntegers().readSafely(0);
            if (var21 == null) {
               var21 = 0;
            }

            if (var21 == 255 && var8.e && var17) {
               var8.g = 0;
               var8.e = false;
               if (var19 == 0 && var8.h < 20) {
                  ++var8.h;
                  if (var8.h > 2) {
                     String var22 = "sent too few packets between block-toggle packets (vl: " + var8.h + ")";
                     Anomaly var15 = Anomaly.of("142", Certainty.NONE, CombatCheckType.KILLAURA, var22);
                     ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var15);
                     var6.a(Unknown227.BLOCKING, "8");
                  }
               } else if (var8.h > 1) {
                  var8.h -= 2;
               }
            }

            var8.d = 0;
         }

      }
   }

   @PacketListener(
      packetTypes = {ClientPacket.HELD_ITEM_SLOT}
   )
   public void a(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      AutoBlockHeuristicStorage var7 = (AutoBlockHeuristicStorage)this.getStorage(var5);
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      VersionHolder var9 = var6.getStorage().getVersionHolder();
      if (!var6.getStorage().getEntityHolder().isSpectator()) {
         ++var7.i;
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.FLYING, ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK, ClientPacket.VEHICLE_MOVE}
   )
   public void d(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      AutoBlockHeuristicStorage var7 = (AutoBlockHeuristicStorage)this.getStorage(var6);
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      VersionHolder var9 = var6.getStorage().getVersionHolder();
      if (var8.teleportTicks != 0) {
         if ((!var8.b(2) || var9.getVersionId() < VersionHolder.V_1_9) && var7.i > 0 && (AutoBlockHeuristicStorage.b(var7) == 0 || var7.i > 2)) {
            String var10 = "sent too many item operations (operations: " + var7.i + ")";
            var10 = var10 + " (version " + var6.getStorage().getVersionHolder().getVersionString() + ")";
            Anomaly var11 = Anomaly.of("144", Certainty.NONE, CombatCheckType.KILLAURA, var10, 0);
            ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var11);
            AutoBlockHeuristicStorage.a(var7).clear();
         }

         AutoBlockHeuristicStorage.a(var7, 0);
      }
   }

   public AutoBlockHeuristicCheck(HeuristicCheckGroup heuristic) {
      super(heuristic, AutoBlockHeuristicStorage.class);
   }

   private static void b(Player var0) {
      pU.a(var0, pU.e, false);
   }

   @PacketListener(
      packetTypes = {ClientPacket.ARM_ANIMATION, ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK}
   )
   public void c(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      AutoBlockHeuristicStorage var7 = (AutoBlockHeuristicStorage)this.getStorage(var6);
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      if (var8.teleportTicks != 0) {
         if (event.getPacketType() != Client.ARM_ANIMATION) {
            var7.swinging = false;
            ++var7.d;
         }

         if (var7.e) {
            ++var7.g;
         }

         var7.i = 0;
      }
   }

   @PacketListener(
      packetTypes = {ClientPacket.USE_ITEM}
   )
   public void e(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      VersionHolder var7 = var6.getStorage().getVersionHolder();
      AutoBlockHeuristicStorage var8 = (AutoBlockHeuristicStorage)this.getStorage(var5);
      if (var7.getVersionId() >= VersionHolder.V_1_9) {
         AutoBlockHeuristicStorage.c(var8);
      }

   }

   @PacketListener(
      packetTypes = {ClientPacket.BLOCK_PLACE}
   )
   public void b(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      AutoBlockHeuristicStorage var7 = (AutoBlockHeuristicStorage)this.getStorage(var5);
      VersionHolder var8 = var6.getStorage().getVersionHolder();
      if (var8.getVersionId() < VersionHolder.V_1_9) {
         AutoBlockHeuristicStorage.c(var7);
      }

   }
}
