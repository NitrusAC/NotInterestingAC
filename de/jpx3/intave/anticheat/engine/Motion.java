package de.jpx3.intave.anticheat.engine;

import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.util.MathUtil2;
import org.bukkit.util.Vector;

public final class Motion {
   public double motionX;
   public double motionY;
   public double motionZ;

   public void set(Motion other) {
      this.set(other.motionX, other.motionY, other.motionZ);
   }

   public Motion(double x, double y, double z) {
      this.motionX = x;
      this.motionY = y;
      this.motionZ = z;
   }

   public static Motion clone(Vector var0) {
      return new Motion(var0.getX(), var0.getY(), var0.getZ());
   }

   public Motion add(double x, double y, double z) {
      this.motionX += x;
      this.motionY += y;
      this.motionZ += z;
      return this;
   }

   public double getX() {
      return this.motionX;
   }

   public Motion copy() {
      return copy(this);
   }

   public static Motion copy(Motion other) {
      return new Motion(other.motionX, other.motionY, other.motionZ);
   }

   public void set(double x, double y, double z) {
      this.motionX = x;
      this.motionY = y;
      this.motionZ = z;
   }

   public Motion() {
      this(0.0, 0.0, 0.0);
   }

   public double a(Motion other) {
      return MathUtil2.getLength(this.motionX - other.motionX, this.motionY - other.motionY, this.motionZ - other.motionZ);
   }

   public void a(BukkitEnginePlayer physics) {
      this.set(physics.deltaX, physics.deltaY, physics.deltaZ);
   }

   public double getY() {
      return this.motionY;
   }

   public double deltaXZ(Motion other) {
      return AccurateMathUtil.deltaXZ(this.motionX - other.motionX, this.motionZ - other.motionZ);
   }

   public String toString() {
      return "Motion{x=" + this.motionX + ", y=" + this.motionY + ", z=" + this.motionZ + '}';
   }

   public double getLength() {
      return MathUtil2.getLength(this.motionX, this.motionY, this.motionZ);
   }

   public Vector toVector() {
      return new Vector(this.motionX, this.motionY, this.motionZ);
   }

   public static Motion ofEmpty() {
      return new Motion();
   }

   public double getZ() {
      return this.motionZ;
   }
}
