package de.jpx3.intave.anticheat.check.breakspeed.breaking;

import de.jpx3.intave.anticheat.storage.Storable;

public final class BreakBlockStorage extends Storable {
   private long a;
   private double c;
   private int flyingTicks;
   private boolean d;
   private int e;

   static int getFlyingTicks(BreakBlockStorage storage) {
      return storage.flyingTicks;
   }

   static double h(BreakBlockStorage storage) {
      return (double)(storage.c++);
   }

   static int tickFlying(BreakBlockStorage storage) {
      return storage.flyingTicks++;
   }

   static double a(BreakBlockStorage var0, double var1) {
      return var0.c = var1;
   }

   static double b(BreakBlockStorage var0) {
      return var0.c;
   }

   static int f(BreakBlockStorage var0) {
      return var0.e;
   }

   static int a(BreakBlockStorage var0, int var1) {
      return var0.e = var1;
   }

   static long a(BreakBlockStorage var0) {
      return var0.a;
   }

   static boolean c(BreakBlockStorage var0) {
      return var0.d;
   }

   static long a(BreakBlockStorage var0, long var1) {
      return var0.a = var1;
   }

   static double g(BreakBlockStorage var0) {
      return (double)(var0.c--);
   }

   static boolean a(BreakBlockStorage var0, boolean var1) {
      return var0.d = var1;
   }
}
