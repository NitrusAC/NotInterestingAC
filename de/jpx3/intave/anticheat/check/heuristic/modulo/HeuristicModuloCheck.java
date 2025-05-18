package de.jpx3.intave.anticheat.check.heuristic.modulo;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.ReachUtil;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.reach.ReachResult;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class HeuristicModuloCheck extends PartialConfigurableCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   public HeuristicModuloCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, HeuristicModuloStorage.class);
   }

   @PacketListener(
      packetTypes = {ClientPacket.LOOK, ClientPacket.POSITION_LOOK}
   )
   public void handle(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      PlayerHolder var8 = var6.getStorage().getPlayerHolder();
      HeuristicModuloStorage var9 = (HeuristicModuloStorage)this.getStorage(var6);
      TrackedEntity var10 = var8.getAttacked();
      if (var10 != null && !var8.hasSwitchedTargets(5000L) && var7.teleportTicks >= 100) {
         float var11 = var7.yaw;
         float var12 = var7.lastYaw;
         if (HeuristicModuloStorage.isObserving(var9)) {
            if (this.isObserving(var6)) {
               float var17 = var7.lastYaw;
               if (var17 != 0.0F) {
                  String var18 = "possible rotation modulo clamp";
                  short var19 = 532;
                  Anomaly var16 = Anomaly.of("101", Certainty.PROBABLE, CombatCheckType.KILLAURA, var18, var19);
                  ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var16);
                  var6.a(Unknown227.HT_MEDIUM, "20");
               }
            }

            HeuristicModuloStorage.setObserving(var9, false);
         } else {
            if (var8.hasAttacked(1000L) && var8.getHitDistance() > 1.0) {
               float var13 = Math.abs(var11 - var12);
               boolean var14 = Math.abs(var11) <= 360.0F && Math.abs(var12) <= 360.0F;
               boolean var15 = var14 && var13 > 100.0F;
               if (var15 && this.isObserving(var6)) {
                  HeuristicModuloStorage.setObserving(var9, true);
               }
            }

         }
      }
   }

   private boolean isObserving(PlayerData data) {
      PlayerStorage var5 = data.getStorage();
      PlayerHolder var6 = var5.getPlayerHolder();
      BukkitEnginePlayer var7 = var5.getPhysicsHolder();
      VersionHolder var8 = var5.getVersionHolder();
      boolean var9 = var8.getVersionId() == VersionHolder.V_1_8_8;
      ReachResult var10 = ReachUtil.raytrace(data.getPlayer(), var6.getAttacked(), var9, var7.lastX, var7.lastY, var7.lastZ, var7.yaw, var7.pitch, 0.1F);
      return var10.getDistance() != 10.0;
   }
}
