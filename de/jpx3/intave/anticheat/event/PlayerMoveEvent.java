package de.jpx3.intave.anticheat.event;

import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import de.jpx3.intave.unknown.Unknown379;
import java.io.DataInput;
import java.io.DataOutput;

public final class PlayerMoveEvent extends Event {
   private double y;
   private float yaw;
   private static final double i = 1.0E-9;
   private double z;
   private int flags;
   private float pitch;
   private double x;

   public void setX(double x) {
      this.x = x;
   }

   @Override
   public void write(ByteSerializer serializer, DataOutput output) {
      output.writeByte(this.flags);
      this.a(output, this.x, Unknown379.c);
      this.a(output, this.y, Unknown379.b);
      this.a(output, this.z, Unknown379.e);
      this.a(output, this.yaw, Unknown379.a);
      this.a(output, this.pitch, Unknown379.d);
   }

   public PlayerMoveEvent() {
   }

   public float getPitch() {
      return this.pitch;
   }

   public PlayerMoveEvent(double x, double y, double z, float yaw, float pitch) {
      this.flags = -1;
      this.x = x;
      this.y = y;
      this.z = z;
      this.yaw = yaw;
      this.pitch = pitch;
   }

   private float b(DataInput var1, int var2) {
      return (this.flags & var2) != 0 ? var1.readFloat() : 0.0F;
   }

   public boolean a() {
      return (this.flags & Unknown379.d) != 0;
   }

   public float getYaw() {
      return this.yaw;
   }

   public double getZ() {
      return this.z;
   }

   public boolean b() {
      return (this.flags & Unknown379.a) != 0;
   }

   public boolean c() {
      return (this.flags & Unknown379.c) != 0;
   }

   public void setY(double var1) {
      this.y = var1;
   }

   public PlayerMoveEvent(double var1, double var3, double var5, double x, double y, double z, float var13, float var14, float yaw, float pitch) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.yaw = yaw;
      this.pitch = pitch;
      int var21 = 0;
      if (Math.abs(x - var1) >= 1.0E-9) {
         var21 |= Unknown379.c;
      }

      if (Math.abs(y - var3) >= 1.0E-9) {
         var21 |= Unknown379.b;
      }

      if (Math.abs(z - var5) >= 1.0E-9) {
         var21 |= Unknown379.e;
      }

      if ((double)Math.abs(yaw - var13) >= 1.0E-9) {
         var21 |= Unknown379.a;
      }

      if ((double)Math.abs(pitch - var14) >= 1.0E-9) {
         var21 |= Unknown379.d;
      }

      this.flags = var21;
   }

   public static PlayerMoveEvent of(double var0, double var2, double var4, float var6, float var7) {
      return new PlayerMoveEvent(var0, var2, var4, var6, var7);
   }

   public static PlayerMoveEvent of(
      double var0, double var2, double var4, double var6, double var8, double var10, float var12, float var13, float var14, float var15
   ) {
      return new PlayerMoveEvent(var0, var2, var4, var6, var8, var10, var12, var13, var14, var15);
   }

   @Override
   public void read(ByteSerializer serializer, DataInput input) {
      this.flags = input.readByte();
      this.x = this.a(input, Unknown379.c);
      this.y = this.a(input, Unknown379.b);
      this.z = this.a(input, Unknown379.e);
      this.yaw = this.b(input, Unknown379.a);
      this.pitch = this.b(input, Unknown379.d);
   }

   public String toString() {
      return "PlayerMoveEvent{flags=" + this.flags + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", yaw=" + this.yaw + ", pitch=" + this.pitch + '}';
   }

   public double getY() {
      return this.y;
   }

   public boolean j() {
      return (this.flags & Unknown379.e) != 0;
   }

   private double a(DataInput var1, int var2) {
      return (this.flags & var2) != 0 ? var1.readDouble() : 0.0;
   }

   @Override
   public void accept(EventVisitor visitor) {
      visitor.visit(this);
   }

   private void a(DataOutput var1, float var2, int var3) {
      if ((this.flags & var3) != 0) {
         var1.writeFloat(var2);
      }

   }

   public void setYaw(float yaw) {
      this.yaw = yaw;
   }

   public boolean f() {
      return (this.flags & Unknown379.b) != 0;
   }

   private void a(DataOutput var1, double var2, int var4) {
      if ((this.flags & var4) != 0) {
         var1.writeDouble(var2);
      }

   }

   public void setPitch(float pitch) {
      this.pitch = pitch;
   }

   public void setZ(double z) {
      this.z = z;
   }

   public double getX() {
      return this.x;
   }
}
