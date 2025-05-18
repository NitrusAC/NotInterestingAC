package de.jpx3.intave.anticheat.check.autoclicker.relative;

import de.jpx3.intave.anticheat.storage.Storable;
import java.util.ArrayDeque;
import java.util.Deque;

public class RelativeAutoclickerStorage extends Storable {
   private long c;
   private final Deque d = new ArrayDeque();
   private double a = 0.0;

   static double d(RelativeAutoclickerStorage var0) {
      return var0.a;
   }

   static long b(RelativeAutoclickerStorage var0) {
      return var0.c;
   }

   public RelativeAutoclickerStorage() {
      this.c = 0L;
   }

   static double a(RelativeAutoclickerStorage var0, double var1) {
      return var0.a = var1;
   }

   static double a(RelativeAutoclickerStorage var0) {
      return ++var0.a;
   }

   static long a(RelativeAutoclickerStorage var0, long var1) {
      return var0.c = var1;
   }

   static Deque c(RelativeAutoclickerStorage var0) {
      return var0.d;
   }
}
