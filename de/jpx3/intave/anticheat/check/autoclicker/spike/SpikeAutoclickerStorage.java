package de.jpx3.intave.anticheat.check.autoclicker.spike;

import de.jpx3.intave.anticheat.storage.Storable;
import java.util.ArrayDeque;
import java.util.Queue;

public class SpikeAutoclickerStorage extends Storable {
   private double buffer;
   private long last;
   private final Queue queue = new ArrayDeque();
   private double lastTotalDelay;
   private long first;

   static long setLast(SpikeAutoclickerStorage storage, long time) {
      return storage.last = time;
   }

   static double setBuffer(SpikeAutoclickerStorage storage, double buffer) {
      return storage.buffer = buffer;
   }

   public SpikeAutoclickerStorage() {
      this.buffer = 0.0;
      this.lastTotalDelay = 0.0;
      this.last = 0L;
      this.first = System.currentTimeMillis();
   }

   static double setLastTotalDelay(SpikeAutoclickerStorage storage, double lastTotalDelay) {
      return storage.lastTotalDelay = lastTotalDelay;
   }

   static long getLast(SpikeAutoclickerStorage storage) {
      return storage.last;
   }

   static Queue getQueue(SpikeAutoclickerStorage storage) {
      return storage.queue;
   }

   static double getBuffer(SpikeAutoclickerStorage storage) {
      return storage.buffer;
   }

   static double getLastTotalDelay(SpikeAutoclickerStorage storage) {
      return storage.lastTotalDelay;
   }

   static long setFirst(SpikeAutoclickerStorage storage, long time) {
      return storage.first = time;
   }

   static double increaseBuffer(SpikeAutoclickerStorage storage) {
      return ++storage.buffer;
   }
}
