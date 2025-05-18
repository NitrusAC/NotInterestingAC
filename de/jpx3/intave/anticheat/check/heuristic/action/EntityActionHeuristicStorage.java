package de.jpx3.intave.anticheat.check.heuristic.action;

import de.jpx3.intave.anticheat.storage.Storable;

public class EntityActionHeuristicStorage extends Storable {
   private Boolean sneaking;
   private Boolean sprinting = null;
   int count;

   public EntityActionHeuristicStorage() {
      this.sneaking = null;
      this.count = 0;
   }

   static Boolean setSprint(EntityActionHeuristicStorage storage, Boolean sprinting) {
      return storage.sprinting = sprinting;
   }

   static Boolean setSneak(EntityActionHeuristicStorage storage, Boolean sneaking) {
      return storage.sneaking = sneaking;
   }

   static Boolean sentSneak(EntityActionHeuristicStorage storage) {
      return storage.sneaking;
   }

   static Boolean sentSprint(EntityActionHeuristicStorage storage) {
      return storage.sprinting;
   }
}
