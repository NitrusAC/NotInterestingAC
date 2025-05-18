package de.jpx3.intave.anticheat.check.autoclicker.variance;

import de.jpx3.intave.anticheat.storage.Storable;
import de.jpx3.intave.unknown.Unknown4;
import java.util.ArrayDeque;
import java.util.Queue;

public class VarianceStorage extends Storable {
   private final Queue queue = new ArrayDeque();
   private double sum = 0.0;
   private long lastTime = 0L;
   private long firstTime = System.currentTimeMillis();

   static double setVariance(VarianceStorage storage, double variance) {
      return storage.sum = variance;
   }

   static long getFirstTime(VarianceStorage storage) {
      return storage.firstTime;
   }

   static double getVariance(VarianceStorage storage) {
      return storage.sum;
   }

   static long getLastTime(VarianceStorage storage) {
      return storage.lastTime;
   }

   private static Unknown4 a(Unknown4 var0) {
      return var0;
   }

   static long setFirstTime(VarianceStorage storage, long time) {
      return storage.firstTime = time;
   }

   static Queue getQueue(VarianceStorage storage) {
      return storage.queue;
   }

   static long setLastTime(VarianceStorage storage, long time) {
      return storage.lastTime = time;
   }
}
