package de.jpx3.intave.anticheat.util;

import com.google.common.collect.Maps;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.unknown.Unknown377;
import de.jpx3.intave.unknown.Unknown8;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public enum Direction {
   private final de.jpx3.intave.anticheat.util.nms.Direction l;
   private final Unknown8 n;
   public static final Direction a = new Direction(
      0, 1, -1, "down", Unknown8.NEGATIVE, de.jpx3.intave.anticheat.util.nms.Direction.Y, new WrappedVec3d(0.0, -1.0, 0.0)
   );
   public static final Direction f = new Direction(
      5, 4, 3, "east", Unknown8.POSITIVE, de.jpx3.intave.anticheat.util.nms.Direction.X, new WrappedVec3d(1.0, 0.0, 0.0)
   );
   private final int p;
   private final int q;
   private static final Direction[] h = new Direction[6];
   public static final Direction b = new Direction(
      1, 0, -1, "up", Unknown8.POSITIVE, de.jpx3.intave.anticheat.util.nms.Direction.Y, new WrappedVec3d(0.0, 1.0, 0.0)
   );
   private final int o;
   public static final Direction d = new Direction(
      3, 2, 0, "south", Unknown8.POSITIVE, de.jpx3.intave.anticheat.util.nms.Direction.Z, new WrappedVec3d(0.0, 0.0, 1.0)
   );
   private static final Direction[] s = new Direction[]{a, b, Direction.c, d, Direction.e, f};
   private static final Map r = Maps.newHashMap();
   public static final Direction c = new Direction(
      2, 3, 2, "north", Unknown8.NEGATIVE, de.jpx3.intave.anticheat.util.nms.Direction.Z, new WrappedVec3d(0.0, 0.0, -1.0)
   );
   public static final Direction e = new Direction(
      4, 5, 1, "west", Unknown8.NEGATIVE, de.jpx3.intave.anticheat.util.nms.Direction.X, new WrappedVec3d(-1.0, 0.0, 0.0)
   );
   private static final Direction[] k = new Direction[4];
   private final String m;
   private final WrappedVec3d j;

   public int c() {
      return this.l == de.jpx3.intave.anticheat.util.nms.Direction.Z ? this.n.a() : 0;
   }

   public static Direction a(Random var0) {
      return values()[var0.nextInt(values().length)];
   }

   public int q() {
      return this.l == de.jpx3.intave.anticheat.util.nms.Direction.Z ? this.n.a() : 0;
   }

   public Unknown8 t() {
      return this.n;
   }

   public String g() {
      return this.m;
   }

   public static Direction parse(int var0) {
      return k[Math.abs(var0 % k.length)];
   }

   private Direction(int var3, int var4, int var5, String var6, Unknown8 var7, de.jpx3.intave.anticheat.util.nms.Direction var8, WrappedVec3d var9) {
      this.q = var3;
      this.o = var5;
      this.p = var4;
      this.m = var6;
      this.l = var8;
      this.n = var7;
      this.j = var9;
   }

   public Direction u() {
      return a(this.p);
   }

   public static Direction a(String var0) {
      return var0 == null ? null : (Direction)r.get(var0.toLowerCase());
   }

   private Direction n() {
      switch(Unknown377.c[this.ordinal()]) {
         case 2:
            return a;
         case 3:
         default:
            throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
         case 4:
            return b;
         case 5:
            return f;
         case 6:
            return e;
      }
   }

   public int e() {
      return this.l == de.jpx3.intave.anticheat.util.nms.Direction.X ? this.n.a() : 0;
   }

   public int i() {
      return this.o;
   }

   public int s() {
      return this.l == de.jpx3.intave.anticheat.util.nms.Direction.Y ? this.n.a() : 0;
   }

   public WrappedVec3d p() {
      return this.j;
   }

   public de.jpx3.intave.anticheat.util.nms.Direction get() {
      return this.l;
   }

   public int r() {
      return this.l == de.jpx3.intave.anticheat.util.nms.Direction.Y ? this.n.a() : 0;
   }

   public int o() {
      return this.q;
   }

   public String toString() {
      return this.m.toUpperCase(Locale.ROOT);
   }

   static {
      for(Direction var14 : values()) {
         h[var14.q] = var14;
         if (var14.get().a()) {
            k[var14.o] = var14;
         }

         r.put(var14.g().toLowerCase(), var14);
      }

   }

   public Direction k() {
      switch(Unknown377.c[this.ordinal()]) {
         case 1:
            return f;
         case 2:
            return d;
         case 3:
            return e;
         case 4:
            return c;
         default:
            throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
      }
   }

   public static Direction a(int var0) {
      return h[MathUtil.a(var0 % h.length)];
   }

   public static Direction a(double var0) {
      return parse(MathUtil.floor(var0 / 90.0 + 0.5) & 3);
   }

   public int a() {
      return this.l == de.jpx3.intave.anticheat.util.nms.Direction.X ? this.n.a() : 0;
   }

   public static Direction a(de.jpx3.intave.anticheat.util.nms.Direction var0, Unknown8 var1) {
      switch(Unknown377.a[var0.ordinal()]) {
         case 1:
            return var1 == Unknown8.POSITIVE ? f : e;
         case 2:
            return var1 == Unknown8.POSITIVE ? b : a;
         case 3:
         default:
            return var1 == Unknown8.POSITIVE ? d : c;
      }
   }

   public Direction a(de.jpx3.intave.anticheat.util.nms.Direction var1) {
      switch(Unknown377.a[var1.ordinal()]) {
         case 1:
            if (this != e && this != f) {
               return this.m();
            }

            return this;
         case 2:
            if (this != b && this != a) {
               return this.k();
            }

            return this;
         case 3:
            if (this != c && this != d) {
               return this.n();
            }

            return this;
         default:
            throw new IllegalStateException("Unable to get CW facing for axis " + var1);
      }
   }

   public static Direction a(Unknown8 var0, de.jpx3.intave.anticheat.util.nms.Direction var1) {
      for(Direction var8 : values()) {
         if (var8.t() == var0 && var8.get() == var1) {
            return var8;
         }
      }

      throw new IllegalArgumentException("No such direction: " + var0 + " " + var1);
   }

   public com.comphenix.protocol.wrappers.EnumWrappers.Direction d() {
      return com.comphenix.protocol.wrappers.EnumWrappers.Direction.values()[this.o()];
   }

   private Direction m() {
      switch(Unknown377.c[this.ordinal()]) {
         case 1:
            return a;
         case 2:
         case 4:
         default:
            throw new IllegalStateException("Unable to get X-rotated facing of " + this);
         case 3:
            return b;
         case 5:
            return c;
         case 6:
            return d;
      }
   }

   public Direction f() {
      switch(Unknown377.c[this.ordinal()]) {
         case 1:
            return e;
         case 2:
            return c;
         case 3:
            return f;
         case 4:
            return d;
         default:
            throw new IllegalStateException("Unable to get CCW facing of " + this);
      }
   }

   public static Direction a(float var0, float var1, float var2) {
      Direction var6 = c;
      float var7 = Float.MIN_VALUE;

      for(Direction var11 : values()) {
         float var12 = var0 * (float)var11.j.x + var1 * (float)var11.j.y + var2 * (float)var11.j.z;
         if (var12 > var7) {
            var7 = var12;
            var6 = var11;
         }
      }

      return var6;
   }

   public String h() {
      return this.m;
   }
}
