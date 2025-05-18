package de.jpx3.intave.anticheat.check.heuristic.modulo;

import de.jpx3.intave.anticheat.storage.Storable;

public final class HeuristicModuloStorage extends Storable {
   private boolean observingEntity;

   static boolean isObserving(HeuristicModuloStorage storage) {
      return storage.observingEntity;
   }

   static boolean setObserving(HeuristicModuloStorage storage, boolean value) {
      return storage.observingEntity = value;
   }
}
