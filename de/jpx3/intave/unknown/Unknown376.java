package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.BlockRaytrace;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.nms.Direction;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

final class Unknown376 extends Unknown361 implements Boxable {
   private static final Reference a = new WeakReference(null);
   private static final String k;
   private final int i;
   private static final double h = 1.0E-7;
   private Reference f = a;
   private final int e;
   private final int g;

   @Override
   public double a(Direction var1) {
      return (double)var1.a(this.i, this.e, this.g);
   }

   public String toString() {
      return String.format("Cube{%d, %d, %d}", this.i, this.e, this.g);
   }

   @Override
   public BlockRaytrace raytrace(IntaveVector eyePosition, IntaveVector eyeLook) {
      double[] var3 = new double[]{1.0};
      double var4 = eyePosition.getX() - eyeLook.getX();
      double var6 = eyePosition.getY() - eyeLook.getY();
      double var8 = eyePosition.getZ() - eyeLook.getZ();
      de.jpx3.intave.anticheat.util.Direction var10 = this.a(eyeLook, var3, var4, var6, var8);
      return var10 == null ? BlockRaytrace.getDefaultRaytrace() : new BlockRaytrace(var10, var3[0]);
   }

   Unknown376(int var1, int var2, int var3) {
      this.i = var1;
      this.e = var2;
      this.g = var3;
   }

   @Override
   public double calculateOffset(Direction var1, Box var2, double var3) {
      boolean var8 = var1 == Direction.X || var2.b(Direction.X) > this.a(Direction.X) && var2.a(Direction.X) < this.b(Direction.X);
      boolean var9 = var1 == Direction.Y || var8 && var2.b(Direction.Y) > this.a(Direction.Y) && var2.a(Direction.Y) < this.b(Direction.Y);
      boolean var10 = var1 == Direction.Z || var9 && var2.b(Direction.Z) > this.a(Direction.Z) && var2.a(Direction.Z) < this.b(Direction.Z);
      if (var8 && var9 && var10) {
         if (var3 > 0.0 && var2.b(var1) <= this.a(var1)) {
            double var13 = this.a(var1) - var2.b(var1);
            if (var13 < var3) {
               var3 = var13;
            }
         } else if (var3 < 0.0 && var2.a(var1) >= this.b(var1)) {
            double var11 = this.b(var1) - var2.a(var1);
            if (var11 > var3) {
               var3 = var11;
            }
         }
      }

      return var3;
   }

   @Override
   public double b(Direction var1) {
      return (double)(var1.a(this.i, this.e, this.g) + 1);
   }

   @Override
   public boolean c() {
      return true;
   }

   @Nullable
   private static de.jpx3.intave.anticheat.util.Direction a(
      double[] var0,
      @Nullable de.jpx3.intave.anticheat.util.Direction var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      de.jpx3.intave.anticheat.util.Direction var18,
      double var19,
      double var21,
      double var23
   ) {
      double var28 = (var8 - var19) / var2;
      if (var28 > 0.0 && var28 < var0[0]) {
         double var30 = var21 + var28 * var4;
         double var32 = var23 + var28 * var6;
         if (var10 - 1.0E-7 < var30 && var30 < var12 + 1.0E-7 && var14 - 1.0E-7 < var32 && var32 < var16 + 1.0E-7) {
            var0[0] = var28;
            return var18;
         }
      }

      return var1;
   }

   @Override
   public List b() {
      List var4 = (List)this.f.get();
      if (var4 == null) {
         var4 = Collections.singletonList(
            new Box((double)this.i, (double)this.e, (double)this.g, (double)(this.i + 1), (double)(this.e + 1), (double)(this.g + 1))
         );
         this.f = new WeakReference(var4);
      }

      return var4;
   }

   @Override
   public Boxable a(int var1, int var2, int var3) {
      return new Unknown376(this.i - var1, this.e - var2, this.g - var3);
   }

   @Nullable
   private de.jpx3.intave.anticheat.util.Direction a(IntaveVector var1, double[] var2, double var3, double var5, double var7) {
      double var12 = this.a(Direction.X);
      double var14 = this.b(Direction.X);
      double var16 = this.a(Direction.Y);
      double var18 = this.b(Direction.Y);
      double var20 = this.a(Direction.Z);
      double var22 = this.b(Direction.Z);
      double var24 = var1.getX();
      double var26 = var1.getY();
      double var28 = var1.getZ();
      de.jpx3.intave.anticheat.util.Direction var30 = null;
      if (var3 > 1.0E-7) {
         var30 = a(var2, var30, var3, var5, var7, var12, var16, var18, var20, var22, de.jpx3.intave.anticheat.util.Direction.e, var24, var26, var28);
      } else if (var3 < -1.0E-7) {
         var30 = a(var2, var30, var3, var5, var7, var14, var16, var18, var20, var22, de.jpx3.intave.anticheat.util.Direction.f, var24, var26, var28);
      }

      if (var5 > 1.0E-7) {
         var30 = a(var2, var30, var5, var7, var3, var16, var20, var22, var12, var14, de.jpx3.intave.anticheat.util.Direction.a, var26, var28, var24);
      } else if (var5 < -1.0E-7) {
         var30 = a(var2, var30, var5, var7, var3, var18, var20, var22, var12, var14, de.jpx3.intave.anticheat.util.Direction.b, var26, var28, var24);
      }

      if (var7 > 1.0E-7) {
         var30 = a(var2, var30, var7, var3, var5, var20, var12, var14, var16, var18, de.jpx3.intave.anticheat.util.Direction.c, var28, var24, var26);
      } else if (var7 < -1.0E-7) {
         var30 = a(var2, var30, var7, var3, var5, var22, var12, var14, var16, var18, de.jpx3.intave.anticheat.util.Direction.d, var28, var24, var26);
      }

      return var30;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public Boxable b(int var1, int var2, int var3) {
      return new Unknown376(this.i + var1, this.e + var2, this.g + var3);
   }

   @Override
   public boolean isInside(Box other) {
      return other.maxX > this.a(Direction.X)
         && other.minX < this.b(Direction.X)
         && other.maxY > this.a(Direction.Y)
         && other.minY < this.b(Direction.Y)
         && other.maxZ > this.a(Direction.Z)
         && other.minZ < this.b(Direction.Z);
   }
}
