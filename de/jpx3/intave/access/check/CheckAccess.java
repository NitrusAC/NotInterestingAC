package de.jpx3.intave.access.check;

import java.util.Map;
import org.bukkit.entity.Player;

public interface CheckAccess {
   String name();

   Check enumCheck();

   boolean enabled();

   default double violationLevelOf(Player var1) {
      return this.violationLevelOf(var1, "thresholds");
   }

   double violationLevelOf(Player var1, String var2);

   default void addViolationPoints(Player var1, double var2) {
      this.addViolationPoints(var1, "thresholds", var2);
   }

   void addViolationPoints(Player var1, String var2, double var3);

   default void resetViolationLevel(Player var1) {
      this.resetViolationLevel(var1, "thresholds");
   }

   void resetViolationLevel(Player var1, String var2);

   default MitigationStrategy mitigationStrategy() {
      return MitigationStrategy.NOT_SUPPORTED;
   }

   default void setMitigationStrategy(MitigationStrategy var1) {
      throw new UnsupportedOperationException("Check " + this.name() + " does not support a mitigation strategy");
   }

   Map commandsOf(String var1);

   CheckStatisticsAccess statistics();
}
