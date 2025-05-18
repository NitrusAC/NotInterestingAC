package de.jpx3.intave.anticheat.check.autoclicker.invariant;

import de.jpx3.intave.anticheat.storage.Storable;
import java.util.ArrayDeque;
import java.util.Queue;

public class InvariantAutoclickerStorage extends Storable {
   private long lastTime;
   private double skewTotal;
   private final Queue clickQueue = new ArrayDeque();
   private long firstTime;

   static long setTime(InvariantAutoclickerStorage storage, long time) {
      return storage.lastTime = time;
   }

   static long getFirstTime(InvariantAutoclickerStorage storage) {
      return storage.firstTime;
   }

   static long setFirstTime(InvariantAutoclickerStorage storage, long time) {
      return storage.firstTime = time;
   }

   public InvariantAutoclickerStorage() {
      this.skewTotal = 0.0;
      this.lastTime = 0L;
      this.firstTime = System.currentTimeMillis();
   }

   static double getSkewTotal(InvariantAutoclickerStorage total) {
      return total.skewTotal;
   }

   static long getLastTime(InvariantAutoclickerStorage storage) {
      return storage.lastTime;
   }

   static double setSkewTotal(InvariantAutoclickerStorage storage, double total) {
      return storage.skewTotal = total;
   }

   static Queue getClickQueue(InvariantAutoclickerStorage storage) {
      return storage.clickQueue;
   }
}
