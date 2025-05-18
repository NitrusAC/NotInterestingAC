package de.jpx3.intave.unknown;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import de.jpx3.intave.anticheat.util.Direction;
import java.util.Iterator;
import java.util.Random;

public enum Unknown189 implements Predicate, Iterable {
   private static final String e;
   private static final Unknown189[] d = new Unknown189[]{Unknown189.a, Unknown189.b};
   public static final Unknown189 a = new Unknown189();
   public static final Unknown189 b = new Unknown189();

   public Direction[] a() {
      switch(Unknown377.b[this.ordinal()]) {
         case 1:
            return new Direction[]{Direction.c, Direction.f, Direction.d, Direction.e};
         case 2:
            return new Direction[]{Direction.b, Direction.a};
         default:
            throw new Error("Someone's been tampering with the universe!");
      }
   }

   public boolean a(Direction var1) {
      return var1 != null && var1.get().b() == this;
   }

   public Direction a(Random var1) {
      Direction[] var2 = this.a();
      return var2[var1.nextInt(var2.length)];
   }

   public Iterator iterator() {
      return Iterators.forArray(this.a());
   }

   public boolean apply(Object var1) {
      return this.a((Direction)var1);
   }
}
