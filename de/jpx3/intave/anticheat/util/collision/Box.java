package de.jpx3.intave.anticheat.util.collision;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.BlockRaytrace;
import de.jpx3.intave.anticheat.util.HitResult;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import de.jpx3.intave.anticheat.util.nms.Direction;
import de.jpx3.intave.anticheat.util.nms.Direction$Values;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.unknown.Unknown182;
import de.jpx3.intave.unknown.Unknown361;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.bukkit.Location;

public final class Box extends Unknown361 implements Boxable {
   private static final double i = 1.0E-7;
   private static final double p = 1.0E-5;
   public final double maxX;
   private List cache;
   private boolean j;
   public final double minZ;
   public final double maxZ;
   private static final double e = 0.3;
   public final double minX;
   public final double minY;
   public final double maxY;
   private static final float l = 1.8F;

   public static Box a(PlayerData data, BlockPos var1) {
      return of(data, var1.x, var1.y, var1.z);
   }

   public Box merge(Box other) {
      double var2 = Math.min(this.minX, other.minX);
      double var4 = Math.min(this.minY, other.minY);
      double var6 = Math.min(this.minZ, other.minZ);
      double var8 = Math.max(this.maxX, other.maxX);
      double var10 = Math.max(this.maxY, other.maxY);
      double var12 = Math.max(this.maxZ, other.maxZ);
      return new Box(var2, var4, var6, var8, var10, var12);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         Box var5 = (Box)var1;
         if (Double.compare(var5.minX, this.minX) != 0) {
            return false;
         } else if (Double.compare(var5.minY, this.minY) != 0) {
            return false;
         } else if (Double.compare(var5.minZ, this.minZ) != 0) {
            return false;
         } else if (Double.compare(var5.maxX, this.maxX) != 0) {
            return false;
         } else if (Double.compare(var5.maxY, this.maxY) != 0) {
            return false;
         } else {
            return Double.compare(var5.maxZ, this.maxZ) == 0;
         }
      } else {
         return false;
      }
   }

   public static Box of(PlayerData data, Location var1) {
      return of(data, var1.getX(), var1.getY(), var1.getZ());
   }

   public static Box of(PlayerData var0, IntaveVector var1) {
      return of(var0, var1.getX(), var1.getY(), var1.getZ());
   }

   public static Box a(Object var0) {
      return Unknown182.c(var0);
   }

   @Override
   public Boxable b(int var1, int var2, int var3) {
      return this.d() ? this.add((double)var1, (double)var2, (double)var3) : this;
   }

   public double size3() {
      double var1 = this.maxX - this.minX;
      double var3 = this.maxY - this.minY;
      double var5 = this.maxZ - this.minZ;
      return (var1 + var3 + var5) / 3.0;
   }

   public boolean d() {
      return this.j;
   }

   public Box grow(double value) {
      return this.grow(value, value, value);
   }

   public Box copy() {
      return new Box(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
   }

   public Box(double aX, double aY, double aZ, double bX, double bY, double bZ) {
      this.minX = Math.min(aX, bX);
      this.minY = Math.min(aY, bY);
      this.minZ = Math.min(aZ, bZ);
      this.maxX = Math.max(aX, bX);
      this.maxY = Math.max(aY, bY);
      this.maxZ = Math.max(aZ, bZ);
   }

   public Box expand(double x, double y, double z) {
      double var7 = this.minX + x;
      double var9 = this.minY + y;
      double var11 = this.minZ + z;
      double var13 = this.maxX - x;
      double var15 = this.maxY - y;
      double var17 = this.maxZ - z;
      return new Box(var7, var9, var11, var13, var15, var17);
   }

   public void a() {
      this.j = true;
   }

   public Box shrink(double value) {
      return this.grow(-value);
   }

   public Box addCoord(double x, double y, double z) {
      double var10 = this.minX;
      double var12 = this.minY;
      double var14 = this.minZ;
      double var16 = this.maxX;
      double var18 = this.maxY;
      double var20 = this.maxZ;
      if (x < 0.0) {
         var10 += x;
      } else if (x > 0.0) {
         var16 += x;
      }

      if (y < 0.0) {
         var12 += y;
      } else if (y > 0.0) {
         var18 += y;
      }

      if (z < 0.0) {
         var14 += z;
      } else if (z > 0.0) {
         var20 += z;
      }

      Box var22 = new Box(var10, var12, var14, var16, var18, var20);
      if (this.d()) {
         var22.a();
      }

      return var22;
   }

   public static Box of(PlayerData data, double x, double y, double z) {
      BukkitEnginePlayer var10 = data.getStorage().getPhysicsHolder();
      VersionHolder var11 = data.getStorage().getVersionHolder();
      double var12 = var10.isTrackingAttacked() ? (double)(var10.jumpStep / 2.0F) : var10.roundedJumpStep;
      float var14 = var10.height;
      double var15;
      if (var11.isSub1_14()) {
         var15 = (double)Math.round((y + (double)var14) * 1.0E7) / 1.0E7;
      } else {
         var15 = (double)Math.round((y + (double)var14) * 1.0E1) / 1.0E1;
      }

      return new Box(x - var12, y, z - var12, x + var12, var15, z + var12);
   }

   @Override
   public double a(Direction var1) {
      switch(Direction$Values.values[var1.ordinal()]) {
         case 1:
            return this.minX;
         case 2:
            return this.minY;
         case 3:
            return this.minZ;
         default:
            return var1.a(this.minX, this.minY, this.minZ);
      }
   }

   public boolean isInside(double x, double y, double z) {
      return x >= this.minX && x < this.maxX && y >= this.minY && y < this.maxY && z >= this.minZ && z < this.maxZ;
   }

   public String serialize() {
      return ""
         + MathUtil2.getStringRounded(this.minX, 3)
         + ", "
         + MathUtil2.getStringRounded(this.minY, 3)
         + ", "
         + MathUtil2.getStringRounded(this.minZ, 3)
         + " -> "
         + MathUtil2.getStringRounded(this.maxX, 3)
         + ", "
         + MathUtil2.getStringRounded(this.maxY, 3)
         + ", "
         + MathUtil2.getStringRounded(this.maxZ, 3);
   }

   public Box add(double x, double y, double z) {
      return new Box(this.minX + x, this.minY + y, this.minZ + z, this.maxX + x, this.maxY + y, this.maxZ + z);
   }

   @Nullable
   private de.jpx3.intave.anticheat.util.Direction a(IntaveVector var1, double[] var2, double x, double y, double z) {
      double var12 = this.minX;
      double var14 = this.maxX;
      double var16 = this.minY;
      double var18 = this.maxY;
      double var20 = this.minZ;
      double var22 = this.maxZ;
      double var24 = var1.getX();
      double var26 = var1.getY();
      double var28 = var1.getZ();
      de.jpx3.intave.anticheat.util.Direction var30 = null;
      if (x > 1.0E-7) {
         var30 = a(var2, var30, x, y, z, var12, var16, var18, var20, var22, de.jpx3.intave.anticheat.util.Direction.e, var24, var26, var28);
      } else if (x < -1.0E-7) {
         var30 = a(var2, var30, x, y, z, var14, var16, var18, var20, var22, de.jpx3.intave.anticheat.util.Direction.f, var24, var26, var28);
      }

      if (y > 1.0E-7) {
         var30 = a(var2, var30, y, z, x, var16, var20, var22, var12, var14, de.jpx3.intave.anticheat.util.Direction.a, var26, var28, var24);
      } else if (y < -1.0E-7) {
         var30 = a(var2, var30, y, z, x, var18, var20, var22, var12, var14, de.jpx3.intave.anticheat.util.Direction.b, var26, var28, var24);
      }

      if (z > 1.0E-7) {
         var30 = a(var2, var30, z, x, y, var20, var12, var14, var16, var18, de.jpx3.intave.anticheat.util.Direction.c, var28, var24, var26);
      } else if (z < -1.0E-7) {
         var30 = a(var2, var30, z, x, y, var22, var12, var14, var16, var18, de.jpx3.intave.anticheat.util.Direction.d, var28, var24, var26);
      }

      return var30;
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
      if (0.0 < var28 && var28 < var0[0]) {
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
   public boolean c() {
      if (this.d()) {
         return this.minX == 0.0 && this.minY == 0.0 && this.minZ == 0.0 && this.maxX == 1.0 && this.maxY == 1.0 && this.maxZ == 1.0;
      } else {
         return Math.abs(this.maxX - this.minX - 1.0) < 1.0E-5
            && Math.abs(this.maxY - this.minY - 1.0) < 1.0E-5
            && Math.abs(this.maxZ - this.minZ - 1.0) < 1.0E-5;
      }
   }

   public HitResult intercept(WrappedVec3d var1, WrappedVec3d var2) {
      WrappedVec3d var6 = var1.b(var2, this.minX);
      WrappedVec3d var7 = var1.b(var2, this.maxX);
      WrappedVec3d var8 = var1.c(var2, this.minY);
      WrappedVec3d var9 = var1.c(var2, this.maxY);
      WrappedVec3d var10 = var1.a(var2, this.minZ);
      WrappedVec3d var11 = var1.a(var2, this.maxZ);
      if (!this.f(var6)) {
         var6 = null;
      }

      if (!this.f(var7)) {
         var7 = null;
      }

      if (!this.d(var8)) {
         var8 = null;
      }

      if (!this.d(var9)) {
         var9 = null;
      }

      if (!this.b(var10)) {
         var10 = null;
      }

      if (!this.b(var11)) {
         var11 = null;
      }

      WrappedVec3d var12 = null;
      if (var6 != null) {
         var12 = var6;
      }

      if (var7 != null && (var12 == null || var1.e(var7) < var1.e(var12))) {
         var12 = var7;
      }

      if (var8 != null && (var12 == null || var1.e(var8) < var1.e(var12))) {
         var12 = var8;
      }

      if (var9 != null && (var12 == null || var1.e(var9) < var1.e(var12))) {
         var12 = var9;
      }

      if (var10 != null && (var12 == null || var1.e(var10) < var1.e(var12))) {
         var12 = var10;
      }

      if (var11 != null && (var12 == null || var1.e(var11) < var1.e(var12))) {
         var12 = var11;
      }

      if (var12 == null) {
         return null;
      } else {
         de.jpx3.intave.anticheat.util.Direction var13;
         if (var12 == var6) {
            var13 = de.jpx3.intave.anticheat.util.Direction.e;
         } else if (var12 == var7) {
            var13 = de.jpx3.intave.anticheat.util.Direction.f;
         } else if (var12 == var8) {
            var13 = de.jpx3.intave.anticheat.util.Direction.a;
         } else if (var12 == var9) {
            var13 = de.jpx3.intave.anticheat.util.Direction.b;
         } else if (var12 == var10) {
            var13 = de.jpx3.intave.anticheat.util.Direction.c;
         } else {
            var13 = de.jpx3.intave.anticheat.util.Direction.d;
         }

         return new HitResult(var12, var13);
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   private WrappedVec3d a(WrappedVec3d var1) {
      double var5 = var1.x;
      double var7 = var1.y;
      double var9 = var1.z;
      double var11 = var5 > this.maxX ? this.maxX : Math.max(var5, this.minX);
      double var13 = var7 > this.minY ? this.minY : Math.max(var7, this.minY);
      double var15 = var9 > this.maxZ ? this.maxZ : Math.max(var9, this.minZ);
      return new WrappedVec3d(var11, var13, var15);
   }

   public boolean c(WrappedVec3d var1) {
      return var1.x > this.minX && var1.x < this.maxX && var1.y > this.minY && var1.y < this.maxY && var1.z > this.minZ && var1.z < this.maxZ;
   }

   @Override
   public double b(Direction var1) {
      switch(Direction$Values.values[var1.ordinal()]) {
         case 1:
            return this.maxX;
         case 2:
            return this.maxY;
         case 3:
            return this.maxZ;
         default:
            return var1.a(this.maxX, this.maxY, this.maxZ);
      }
   }

   public String toString() {
      return "Box{" + this.minX + ", " + this.minY + ", " + this.minZ + " -> " + this.maxX + ", " + this.maxY + ", " + this.maxZ + "}";
   }

   public static Box ofDouble(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = Math.min(var0, var6);
      double var14 = Math.min(var2, var8);
      double var16 = Math.min(var4, var10);
      double var18 = Math.max(var0, var6);
      double var20 = Math.max(var2, var8);
      double var22 = Math.max(var4, var10);
      return new Box(var12, var14, var16, var18, var20, var22);
   }

   @Override
   public double calculateOffset(Direction var1, Box var2, double var3) {
      boolean var8 = var1 == Direction.X || var2.maxX > this.minX && var2.minX < this.maxX;
      boolean var9 = var1 == Direction.Y || var8 && var2.maxY > this.minY && var2.minY < this.maxY;
      boolean var10 = var1 == Direction.Z || var9 && var2.maxZ > this.minZ && var2.minZ < this.maxZ;
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

   private boolean b(WrappedVec3d var1) {
      return var1 != null && var1.x >= this.minX && var1.x <= this.maxX && var1.y >= this.minY && var1.y <= this.maxY;
   }

   public static Box ofMerged(double ax, double ay, double az, double bx, double by, double bz) {
      double var12 = Math.min(ax, bx);
      double var14 = Math.min(ay, by);
      double var16 = Math.min(az, bz);
      double var18 = Math.max(ax, bx);
      double var20 = Math.max(ay, by);
      double var22 = Math.max(az, bz);
      Box var24 = new Box(var12, var14, var16, var18, var20, var22);
      var24.a();
      return var24;
   }

   public Box growUp(double value) {
      return new Box(this.minX, this.minY, this.minZ, this.maxX, this.maxY + value, this.maxZ);
   }

   public Box growHorizontal(double value) {
      return this.grow(value, 0.0, value);
   }

   public Box grow(double x, double y, double z) {
      double var7 = this.minX - x;
      double var9 = this.minY - y;
      double var11 = this.minZ - z;
      double var13 = this.maxX + x;
      double var15 = this.maxY + y;
      double var17 = this.maxZ + z;
      return new Box(var7, var9, var11, var13, var15, var17);
   }

   @Override
   public BlockRaytrace raytrace(IntaveVector eyePosition, IntaveVector eyeLook) {
      double[] var6 = new double[]{1.0};
      double var7 = eyePosition.getX() - eyeLook.getX();
      double var9 = eyePosition.getY() - eyeLook.getY();
      double var11 = eyePosition.getZ() - eyeLook.getZ();
      de.jpx3.intave.anticheat.util.Direction var13 = this.a(eyeLook, var6, var7, var9, var11);
      return var13 == null ? null : BlockRaytrace.of(var13, var6[0]);
   }

   public int hashCode() {
      long var6 = Double.doubleToLongBits(this.minX);
      int var5 = (int)(var6 ^ var6 >>> 32);
      var6 = Double.doubleToLongBits(this.minY);
      var5 = 31 * var5 + (int)(var6 ^ var6 >>> 32);
      var6 = Double.doubleToLongBits(this.minZ);
      var5 = 31 * var5 + (int)(var6 ^ var6 >>> 32);
      var6 = Double.doubleToLongBits(this.maxX);
      var5 = 31 * var5 + (int)(var6 ^ var6 >>> 32);
      var6 = Double.doubleToLongBits(this.maxY);
      var5 = 31 * var5 + (int)(var6 ^ var6 >>> 32);
      var6 = Double.doubleToLongBits(this.maxZ);
      return 31 * var5 + (int)(var6 ^ var6 >>> 32);
   }

   public static Box of(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = Math.min(var0, var6);
      double var14 = Math.min(var2, var8);
      double var16 = Math.min(var4, var10);
      double var18 = Math.max(var0, var6);
      double var20 = Math.max(var2, var8);
      double var22 = Math.max(var4, var10);
      Box var24 = new Box(var12 / 16.0, var14 / 16.0, var16 / 16.0, var18 / 16.0, var20 / 16.0, var22 / 16.0);
      var24.a();
      return var24;
   }

   @Deprecated
   public static Box f(double x, double y, double z) {
      return new Box(x - 0.3, y, z - 0.3, x + 0.3, y + 1.8F, z + 0.3);
   }

   private boolean d(WrappedVec3d var1) {
      return var1 != null && var1.x >= this.minX && var1.x <= this.maxX && var1.z >= this.minZ && var1.z <= this.maxZ;
   }

   public double e(WrappedVec3d var1) {
      WrappedVec3d var2 = this.a(var1);
      return var2.distanceSqrt(var1);
   }

   @Override
   public boolean isInside(Box other) {
      return other.maxX > this.minX
         && other.minX < this.maxX
         && other.maxY > this.minY
         && other.minY < this.maxY
         && other.maxZ > this.minZ
         && other.minZ < this.maxZ;
   }

   public boolean isNaN() {
      return Double.isNaN(this.minX)
         || Double.isNaN(this.minY)
         || Double.isNaN(this.minZ)
         || Double.isNaN(this.maxX)
         || Double.isNaN(this.maxY)
         || Double.isNaN(this.maxZ);
   }

   @Deprecated
   @Override
   public List b() {
      if (this.cache == null) {
         this.cache = Collections.singletonList(this);
      }

      return this.cache;
   }

   private boolean f(WrappedVec3d var1) {
      return var1 != null && var1.y >= this.minY && var1.y <= this.maxY && var1.z >= this.minZ && var1.z <= this.maxZ;
   }

   @Override
   public Boxable a(int var1, int var2, int var3) {
      Box var4 = this.add((double)(-var1), (double)(-var2), (double)(-var3));
      var4.a();
      return var4;
   }
}
