package de.jpx3.intave.anticheat.check.heuristic.swing;

import de.jpx3.intave.anticheat.storage.Storable;

public final class SwingHeuristicStorage extends Storable {
   private boolean swinging;

   static boolean isSwinging(SwingHeuristicStorage storage) {
      return storage.swinging;
   }

   static boolean setSwung(SwingHeuristicStorage storage, boolean swinging) {
      return storage.swinging = swinging;
   }
}
