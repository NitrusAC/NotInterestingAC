package de.jpx3.intave.access.player;

import de.jpx3.intave.access.check.Check;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;

public interface PlayerAccess {
   int protocolVersion();

   void setProtocolVersion(int var1);

   default double violationLevel(Check var1) {
      return this.violationLevel(var1, "thresholds");
   }

   default double violationLevel(String var1) {
      return this.violationLevel(var1, "thresholds");
   }

   default double violationLevel(Check var1, String var2) {
      return this.violationLevel(var1.typeName(), var2);
   }

   double violationLevel(String var1, String var2);

   default void addViolationPoints(Check var1, double var2) {
      this.addViolationPoints(var1, "thresholds", var2);
   }

   default void addViolationPoints(String var1, double var2) {
      this.addViolationPoints(var1, "thresholds", var2);
   }

   default void addViolationPoints(Check var1, String var2, double var3) {
      this.addViolationPoints(var1.typeName(), var2, var3);
   }

   void addViolationPoints(String var1, String var2, double var3);

   default void resetViolationLevel(Check var1) {
      this.resetViolationLevel(var1, "thresholds");
   }

   default void resetViolationLevel(String var1) {
      this.resetViolationLevel(var1, "thresholds");
   }

   default void resetViolationLevel(Check var1, String var2) {
      this.resetViolationLevel(var1.typeName(), var2);
   }

   void resetViolationLevel(String var1, String var2);

   TrustFactor trustFactor();

   @Deprecated
   void setTrustFactor(TrustFactor var1);

   PlayerClicks clicks();

   PlayerConnection connection();
}
