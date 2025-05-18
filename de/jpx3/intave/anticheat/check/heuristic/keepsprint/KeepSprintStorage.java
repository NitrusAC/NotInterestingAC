package de.jpx3.intave.anticheat.check.heuristic.keepsprint;

import de.jpx3.intave.anticheat.storage.Storable;

public final class KeepSprintStorage extends Storable {
   public int sprintTicks;
   public double d;
   public int otherTicks;

   public void tickFlying() {
      this.sprintTicks = 0;
      this.otherTicks = 0;
   }
}
