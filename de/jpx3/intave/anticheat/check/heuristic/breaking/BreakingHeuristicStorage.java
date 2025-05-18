package de.jpx3.intave.anticheat.check.heuristic.breaking;

import de.jpx3.intave.anticheat.storage.Storable;

public final class BreakingHeuristicStorage extends Storable {
   private boolean destroying;

   static boolean setDestroying(BreakingHeuristicStorage storage, boolean value) {
      return storage.destroying = value;
   }

   static boolean isDestroying(BreakingHeuristicStorage storage) {
      return storage.destroying;
   }
}
