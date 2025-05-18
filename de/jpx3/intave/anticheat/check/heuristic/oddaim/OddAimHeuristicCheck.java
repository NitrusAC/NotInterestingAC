package de.jpx3.intave.anticheat.check.heuristic.oddaim;

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
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.violate.Anomaly;
import java.util.List;
import org.bukkit.entity.Player;

public final class OddAimHeuristicCheck extends PartialConfigurableCheck {
   private double getMean(List values) {
      double var5 = 0.0;

      for(Number var8 : values) {
         var5 += var8.doubleValue();
      }

      return var5 == 0.0 ? 0.0 : var5 / (double)values.size();
   }

   private static double toDouble(Double value) {
      return value;
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.LOOK, ClientPacket.POSITION_LOOK}
   )
   public void handle(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      OddAimHeuristicStorage var7 = (OddAimHeuristicStorage)this.getStorage(var6);
      PlayerStorage var8 = var6.getStorage();
      PlayerHolder var9 = var8.getPlayerHolder();
      BukkitEnginePlayer var10 = var8.getPhysicsHolder();
      if (var9.hasAttacked(1000L)) {
         TrackedEntity var11 = var9.getAttacked();
         if (var11 != null) {
            double var12 = (double)MathUtil2.distanceBetweenAngles(var9.getHorizontalAngle(), var10.yaw);
            float var14 = MathUtil2.distanceBetweenAngles(var10.yaw, var10.lastYaw);
            if (OddAimHeuristicStorage.getDeltaYaws(var7).size() > 40) {
               double var15 = this.getMean(OddAimHeuristicStorage.getDeltaYaws(var7));
               double var17 = OddAimHeuristicStorage.getDeltaSamples(var7).stream().mapToDouble(OddAimHeuristicCheck::toDouble).max().orElse(0.0);
               List var19 = OddAimHeuristicStorage.getDeltaSamples(var7);
               double var20 = var15 / this.getMean(var19);
               double var22 = var17 / var15;
               if (var22 < 2.0 && var17 < 30.0) {
                  String var24 = "rotated suspiciously (" + MathUtil2.getStringRounded(var22, 4) + " / " + MathUtil2.getStringRounded(var17, 4) + ")";
                  byte var25 = 24;
                  Anomaly var26 = Anomaly.of("91", Certainty.MAYBE, CombatCheckType.KILLAURA, var24, var25);
                  ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var26);
               }

               if (var15 >= 3.5 && var17 <= 12.5 && var20 > 1.0) {
                  String var27 = "precise rotation yaw (" + MathUtil2.getStringRounded(var15, 4) + ")";
                  byte var28 = 20;
                  Anomaly var29 = Anomaly.of("92", Certainty.MAYBE, CombatCheckType.KILLAURA, var27, var28);
                  ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var29);
               }

               OddAimHeuristicStorage.getDeltaSamples(var7).clear();
               OddAimHeuristicStorage.getDeltaYaws(var7).clear();
            }

            if (var11.isDesyncOffsetLargerThan(0.05)) {
               OddAimHeuristicStorage.getDeltaSamples(var7).add(var12);
               OddAimHeuristicStorage.getDeltaYaws(var7).add((double)var14);
            }

         }
      }
   }

   public OddAimHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, OddAimHeuristicStorage.class);
   }
}
