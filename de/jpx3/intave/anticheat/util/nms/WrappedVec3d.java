package de.jpx3.intave.anticheat.util.nms;

import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.unknown.Unknown182;
import java.lang.reflect.InvocationTargetException;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class WrappedVec3d {
   public final double y;
   public final double x;
   public final double z;
   public static final WrappedVec3d c = new WrappedVec3d(0.0, 0.0, 0.0);

   public Vector toVector() {
      return new Vector(this.x, this.y, this.z);
   }

   public double distanceSqrt(WrappedVec3d other) {
      double var2 = other.x - this.x;
      double var4 = other.y - this.y;
      double var6 = other.z - this.z;
      return (double)MathUtil.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public WrappedVec3d a(WrappedVec3d var1, double var2) {
      double var7 = var1.x - this.x;
      double var9 = var1.y - this.y;
      double var11 = var1.z - this.z;
      if (var11 * var11 < 1.0E-7F) {
         return null;
      } else {
         double var13 = (var2 - this.z) / var11;
         return var13 >= 0.0 && var13 <= 1.0 ? new WrappedVec3d(this.x + var7 * var13, this.y + var9 * var13, this.z + var11 * var13) : null;
      }
   }

   public WrappedVec3d a(double var1) {
      return new WrappedVec3d(this.x * var1, this.y * var1, this.z * var1);
   }

   public double distanceSqrt() {
      return (double)MathUtil.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
   }

   public WrappedVec3d f() {
      double var1 = (double)MathUtil.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
      return var1 < 1.0E-4 ? new WrappedVec3d(0.0, 0.0, 0.0) : new WrappedVec3d(this.x / var1, this.y / var1, this.z / var1);
   }

   public double d(WrappedVec3d other) {
      return this.x * other.x + this.y * other.y + this.z * other.z;
   }

   public WrappedVec3d(double x, double y, double z) {
      if (x == -0.0) {
         x = 0.0;
      }

      if (y == -0.0) {
         y = 0.0;
      }

      if (z == -0.0) {
         z = 0.0;
      }

      this.x = x;
      this.y = y;
      this.z = z;
   }

   public double a(Box box) {
      double var2 = MathUtil2.clamp(0.0, box.minX - this.x, this.x - box.maxX);
      double var4 = MathUtil2.clamp(0.0, box.minY - this.y, this.y - box.maxY);
      double var6 = MathUtil2.clamp(0.0, box.minZ - this.z, this.z - box.maxZ);
      return this.distanceSqrt(new WrappedVec3d(var2, var4, var6));
   }

   public double a(Vector other) {
      double var2 = other.getX() - this.x;
      double var4 = other.getY() - this.y;
      double var6 = other.getZ() - this.z;
      return (double)MathUtil.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public WrappedVec3d f(WrappedVec3d var1) {
      return new WrappedVec3d(this.y * var1.z - this.z * var1.y, this.z * var1.x - this.x * var1.z, this.x * var1.y - this.y * var1.x);
   }

   public WrappedVec3d g(WrappedVec3d var1) {
      return new WrappedVec3d(var1.x - this.x, var1.y - this.y, var1.z - this.z);
   }

   public double sqrt() {
      return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
   }

   public static WrappedVec3d a(Object var0) {
      return Unknown182.b(var0);
   }

   public WrappedVec3d c(WrappedVec3d var1, double var2) {
      double var7 = var1.x - this.x;
      double var9 = var1.y - this.y;
      double var11 = var1.z - this.z;
      if (var9 * var9 < 1.0E-7F) {
         return null;
      } else {
         double var13 = (var2 - this.y) / var9;
         return var13 >= 0.0 && var13 <= 1.0 ? new WrappedVec3d(this.x + var7 * var13, this.y + var9 * var13, this.z + var11 * var13) : null;
      }
   }

   public WrappedVec3d add(double x, double y, double z) {
      return new WrappedVec3d(this.x + x, this.y + y, this.z + z);
   }

   public IntaveVector copy() {
      return new IntaveVector(this.x, this.y, this.z);
   }

   public Object g() {
      try {
         return ReflectionUtil.getClazz("Vec3D").getConstructor(Double.TYPE, Double.TYPE, Double.TYPE).newInstance(this.x, this.y, this.z);
      } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException var4) {
         throw new IllegalStateException(var4);
      }
   }

   public WrappedVec3d b(WrappedVec3d var1) {
      return this.add(var1.x, var1.y, var1.z);
   }

   public double e(WrappedVec3d var1) {
      double var2 = var1.x - this.x;
      double var4 = var1.y - this.y;
      double var6 = var1.z - this.z;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public String toString() {
      return "(" + this.x + ", " + this.y + ", " + this.z + ")";
   }

   public WrappedVec3d a(double var1, double var3, double var5) {
      return new WrappedVec3d(this.x + var1, this.y + var3, this.z + var5);
   }

   public WrappedVec3d c(double var1, double var3, double var5) {
      return this.add(-var1, -var3, -var5);
   }

   public WrappedVec3d c(WrappedVec3d var1) {
      return this.c(var1.x, var1.y, var1.z);
   }

   public Location a(World var1) {
      return new Location(var1, this.x, this.y, this.z);
   }

   public WrappedVec3d b(WrappedVec3d var1, double var2) {
      double var7 = var1.x - this.x;
      double var9 = var1.y - this.y;
      double var11 = var1.z - this.z;
      if (var7 * var7 < 1.0E-7F) {
         return null;
      } else {
         double var13 = (var2 - this.x) / var7;
         return var13 >= 0.0 && var13 <= 1.0 ? new WrappedVec3d(this.x + var7 * var13, this.y + var9 * var13, this.z + var11 * var13) : null;
      }
   }
}
