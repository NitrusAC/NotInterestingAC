package de.jpx3.intave.anticheat.util.nms;

import com.google.common.collect.Maps;
import de.jpx3.intave.unknown.Unknown156;
import de.jpx3.intave.unknown.Unknown160;
import de.jpx3.intave.unknown.Unknown165;
import de.jpx3.intave.unknown.Unknown189;
import de.jpx3.intave.unknown.Unknown377;
import java.util.Map;

public enum Direction {
   private final String f;
   private static final Map cache = Maps.newHashMap();
   public static final Direction Z = new Unknown156("z", Unknown189.a);
   private static final Direction[] values = new Direction[]{Direction.X, Direction.Y, Z};
   private final Unknown189 e;
   public static final Direction Y = new Unknown165("y", Unknown189.b);
   public static final Direction X = new Unknown160("x", Unknown189.a);

   static {
      for(Direction var3 : values()) {
         cache.put(var3.d().toLowerCase(), var3);
      }

   }

   public boolean e() {
      return this.e == Unknown189.b;
   }

   public String d() {
      return this.f;
   }

   public boolean a(de.jpx3.intave.anticheat.util.Direction var1) {
      return var1 != null && var1.get() == this;
   }

   public abstract double a(double var1, double var3, double var5);

   public boolean a() {
      return this.e == Unknown189.a;
   }

   public String toString() {
      return this.f;
   }

   public Unknown189 b() {
      return this.e;
   }

   public String c() {
      return this.f;
   }

   private Direction(String var3, Unknown189 var4) {
      this.f = var3;
      this.e = var4;
   }

   public Direction(String var3, Unknown189 var4, Unknown377 var5) {
      this(var3, var4);
   }

   public static Direction a(String var0) {
      return var0 == null ? null : (Direction)cache.get(var0.toLowerCase());
   }

   public abstract int a(int var1, int var2, int var3);
}
