package de.jpx3.intave.anticheat.check.scaffold;

import de.jpx3.intave.nW;
import de.jpx3.intave.nr;
import de.jpx3.intave.anticheat.storage.Storable;
import java.util.HashMap;
import java.util.Map;

public final class ScaffoldStorage extends Storable {
   double g;
   private final nW[] f;
   private int h;
   private int m;
   double k;
   private final nr[] n;
   private final double[] a;
   private int j;
   private int d;
   private int e;
   Map c = new HashMap();
   private int o;
   private int attackTicks;
   double l;

   static int j(ScaffoldStorage var0) {
      return var0.m;
   }

   static int f(ScaffoldStorage var0, int var1) {
      return var0.m = var1;
   }

   static nr[] k(ScaffoldStorage var0) {
      return var0.n;
   }

   static int a(ScaffoldStorage var0) {
      return var0.d;
   }

   static int c(ScaffoldStorage var0, int var1) {
      return var0.d = var1;
   }

   static int e(ScaffoldStorage var0, int var1) {
      return var0.o = var1;
   }

   static nW[] d(ScaffoldStorage var0) {
      return var0.f;
   }

   static int a(ScaffoldStorage var0, int var1) {
      return var0.h = var1;
   }

   static int h(ScaffoldStorage var0) {
      return var0.j;
   }

   static int setAttackTicks(ScaffoldStorage storage, int ticks) {
      return storage.attackTicks = ticks;
   }

   static int m(ScaffoldStorage var0) {
      return var0.e;
   }

   static int n(ScaffoldStorage var0) {
      return var0.j++;
   }

   static double[] f(ScaffoldStorage var0) {
      return var0.a;
   }

   static int i(ScaffoldStorage var0) {
      return var0.attackTicks;
   }

   static int g(ScaffoldStorage var0) {
      return var0.o;
   }

   static int e(ScaffoldStorage var0) {
      return var0.e++;
   }

   static int b(ScaffoldStorage var0) {
      return var0.h;
   }

   static int b(ScaffoldStorage var0, int var1) {
      return var0.e = var1;
   }

   static int l(ScaffoldStorage var0) {
      return var0.attackTicks++;
   }

   static int c(ScaffoldStorage var0) {
      return var0.m++;
   }

   public ScaffoldStorage() {
      this.n = new nr[2];
      this.a = new double[2];
      this.f = new nW[2];
   }
}
