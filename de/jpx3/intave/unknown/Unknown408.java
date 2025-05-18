package de.jpx3.intave.unknown;

import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.util.BlockRaytrace;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.nms.Direction;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.util.ArrayList;
import java.util.List;

final class Unknown408 implements Boxable {
   private static final String d;
   private final Boxable a;
   private final Boxable b;

   @Override
   public Boxable a(int var1, int var2, int var3) {
      return new Unknown408(this.b.a(var1, var2, var3), this.a.a(var1, var2, var3));
   }

   @Override
   public boolean isInside(Box other) {
      return this.b.isInside(other) || this.a.isInside(other);
   }

   @Override
   public boolean a() {
      return this.b.a() && this.a.a();
   }

   @Override
   public boolean c() {
      return this.b.c() && this.a.a() || this.a.c() && this.b.a();
   }

   @Override
   public double b(Direction var1) {
      return Math.max(this.b.b(var1), this.a.b(var1));
   }

   @Override
   public double a(Direction var1) {
      return Math.min(this.b.a(var1), this.a.a(var1));
   }

   Unknown408(Boxable var1, Boxable var2) {
      this.b = var1;
      this.a = var2;
   }

   public String toString() {
      return this.b + " and " + this.a;
   }

   @Override
   public double calculateOffset(Direction var1, Box var2, double var3) {
      return this.b.calculateOffset(var1, var2, this.a.calculateOffset(var1, var2, var3));
   }

   @Override
   public List b() {
      if (this.b.a()) {
         return this.a.b();
      } else if (this.a.a()) {
         return this.b.b();
      } else {
         ArrayList var4 = Lists.newArrayList(this.b.b());
         var4.addAll(this.a.b());
         return var4;
      }
   }

   @Override
   public BlockRaytrace raytrace(IntaveVector eyePosition, IntaveVector eyeLook) {
      BlockRaytrace var6 = this.b.raytrace(eyePosition, eyeLook);
      BlockRaytrace var7 = this.a.raytrace(eyePosition, eyeLook);
      if (var6 == null) {
         return var7;
      } else {
         return var7 == null ? var6 : var6.a(var7);
      }
   }

   @Override
   public Boxable b(int var1, int var2, int var3) {
      return new Unknown408(this.b.b(var1, var2, var3), this.a.b(var1, var2, var3));
   }
}
