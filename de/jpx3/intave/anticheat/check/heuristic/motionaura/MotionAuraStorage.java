package de.jpx3.intave.anticheat.check.heuristic.motionaura;

import de.jpx3.intave.anticheat.storage.Storable;

public final class MotionAuraStorage extends Storable {
   private double buffer;

   static double increaseBuffer(MotionAuraStorage storage) {
      return (double)(storage.buffer++);
   }

   static double getBuffer(MotionAuraStorage storage) {
      return storage.buffer;
   }

   static double setBuffer(MotionAuraStorage storage, double buffer) {
      return storage.buffer = buffer;
   }
}
