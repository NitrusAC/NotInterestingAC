package de.jpx3.intave.anticheat.check.autoclicker.doubleclick;

import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.check.Check3;
import java.util.List;

public final class DoubleClickCheck extends Check3 {
   @Override
   public void handle(PlayerData data, List clicks) {
      DoubleClickStorage var6 = (DoubleClickStorage)this.getStorage(this.getPlayerData(data.getPlayer()));
      double var7 = this.getTickAverage(clicks);
      if (var7 > 15.0 && var6.f == 0) {
         String var9 = String.format("clicking too fast without double clicks %.2f", var7);
         Anomaly var10 = Anomaly.of("300", Certainty.NONE, CombatCheckType.AUTOCLICKER, var9);
         ((HeuristicCheckGroup)this.getParent()).logAnomaly(data.getPlayer(), var10);
      }

   }

   public DoubleClickCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, DoubleClickStorage.class, 60, false, false);
   }
}
