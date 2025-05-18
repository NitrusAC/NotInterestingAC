package de.jpx3.intave.anticheat.check.autoclicker.deviation;

import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown26;
import de.jpx3.intave.unknown.check.Check3;
import java.util.List;

public final class LowDeviationCheck extends Check3 {
   @Override
   public void handle(PlayerData data, List clicks) {
      Unknown26 var6 = (Unknown26)this.getStorage(this.getPlayerData(data.getPlayer()));
      double var7 = this.getStandardDeviation(clicks);
      if (var7 < 0.45) {
         if (++var6.k >= 3.0) {
            String var9 = String.format("clicking with a low deviation %.2f", var7);
            Anomaly var10 = Anomaly.of("310", Certainty.NONE, CombatCheckType.AUTOCLICKER, var9);
            ((HeuristicCheckGroup)this.getParent()).logAnomaly(data.getPlayer(), var10);
         }
      } else {
         var6.k = Math.max(0.0, var6.k - 0.5);
      }

   }

   public LowDeviationCheck(HeuristicCheckGroup var1) {
      super(var1, Unknown26.class, 100, true, false);
   }
}
