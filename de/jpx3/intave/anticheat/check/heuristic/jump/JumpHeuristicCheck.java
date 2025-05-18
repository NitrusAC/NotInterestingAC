package de.jpx3.intave.anticheat.check.heuristic.jump;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.violate.Anomaly;
import org.bukkit.entity.Player;

public final class JumpHeuristicCheck extends PartialConfigurableCheck {
   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.POSITION, ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION_LOOK}
   )
   public void handle(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      if (var7.jumping) {
         double var8 = var7.getMotionY();
         double var10 = var8 - 0.42;
         if (Math.abs(var10) < 1.7E-14) {
            String var12 = "jumped with wrong motion";
            if (var7.velocityTicks == 0) {
               var12 = var12 + " and got velocity";
            }

            Anomaly var13 = Anomaly.of("200", Certainty.LIKELY, CombatCheckType.KILLAURA, var12, 64);
            ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var13);
         }
      }

   }

   public JumpHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, JumpHeuristicStorage.class);
   }
}
