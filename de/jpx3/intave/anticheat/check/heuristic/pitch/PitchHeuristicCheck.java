package de.jpx3.intave.anticheat.check.heuristic.pitch;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.violate.Anomaly;
import org.bukkit.entity.Player;

public final class PitchHeuristicCheck extends PartialConfigurableCheck {
   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.LOOK, ClientPacket.POSITION_LOOK}
   )
   public void handle(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      PlayerStorage var7 = var6.getStorage();
      BukkitEnginePlayer var8 = var7.getPhysicsHolder();
      PlayerHolder var9 = var7.getPlayerHolder();
      TrackedEntity var10 = var9.getAttacked();
      PitchHeuristicStorage var11 = (PitchHeuristicStorage)this.getStorage(var6);
      if (var8.teleportTicks >= 20) {
         if (var10 != null && var10.isDesyncOffsetLargerThan(0.05) && var9.hasAttacked(1000L)) {
            float var12 = Math.abs(var8.pitch - var8.lastPitch);
            float var13 = Math.abs(var8.pitch - var9.getDimensionalAngle());
            short var14 = 800;
            if ((double)var12 > 1.0) {
               if (var13 == 0.0F) {
                  var11.buffer += var14;
                  int var15 = var11.buffer / var14;
                  Certainty var16 = var15 <= 2 ? Certainty.PROBABLE : Certainty.LIKELY;
                  String var17 = "rotated pitch too precisely (0.0) vl:" + var15 + ", conf:" + var16.getLevel();
                  short var18 = 528;
                  Anomaly var19 = Anomaly.of("71", var16, CombatCheckType.KILLAURA, var17, var18);
                  ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var19);
               } else if (var11.buffer > 0) {
                  --var11.buffer;
               }
            }
         }

      }
   }

   public PitchHeuristicCheck(HeuristicCheckGroup heuristic) {
      super(heuristic, PitchHeuristicStorage.class);
   }
}
