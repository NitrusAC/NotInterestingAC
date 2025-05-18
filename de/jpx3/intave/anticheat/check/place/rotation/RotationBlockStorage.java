package de.jpx3.intave.anticheat.check.place.rotation;

import de.jpx3.intave.anticheat.storage.Storable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RotationBlockStorage extends Storable {
   private final List placedBlocks;
   private long lastPlace;
   private final List eyeDistances = new CopyOnWriteArrayList();

   public RotationBlockStorage() {
      this.placedBlocks = new CopyOnWriteArrayList();
   }

   static List getPlacedBlocks(RotationBlockStorage storage) {
      return storage.placedBlocks;
   }

   static long getLastPlace(RotationBlockStorage storage) {
      return storage.lastPlace;
   }

   static List getDistances(RotationBlockStorage storage) {
      return storage.eyeDistances;
   }

   static long setLastPlace(RotationBlockStorage storage, long time) {
      return storage.lastPlace = time;
   }
}
