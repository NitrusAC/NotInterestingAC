package de.jpx3.intave.anticheat.event;

import de.jpx3.intave.gY;
import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import java.io.DataInput;
import java.io.DataOutput;

public final class EntityMoveEvent extends Event {
   private float h;
   private double k;
   private double e;
   private float j;
   private int c;
   private int i;
   private double g;
   private boolean f;
   private static final double d = 1.0E-9;

   public EntityMoveEvent(int var1, double var2, double var4, double var6, float var8, float var9) {
      this.i = var1;
      this.c = -1;
      this.e = var2;
      this.k = var4;
      this.g = var6;
      this.h = var8;
      this.j = var9;
   }

   public boolean a() {
      return this.f;
   }

   @Override
   public void read(ByteSerializer serializer, DataInput input) {
      this.i = input.readInt();
      this.c = input.readInt();
      this.e = this.a(input, gY.d);
      this.k = this.a(input, gY.c);
      this.g = this.a(input, gY.e);
      this.h = this.b(input, gY.b);
      this.j = this.b(input, gY.a);
      this.f = input.readBoolean();
   }

   public double k() {
      return this.k;
   }

   public double h() {
      return this.e;
   }

   public boolean e() {
      return (this.c & gY.c) != 0;
   }

   public String toString() {
      return "EntityMoveEvent(" + this.i + ", " + this.e + ", " + this.k + ", " + this.g + ", " + this.h + ", " + this.j + ", " + this.f + ")";
   }

   @Override
   public void write(ByteSerializer serializer, DataOutput output) {
      output.writeInt(this.i);
      output.writeInt(this.c);
      this.a(output, this.e, gY.d);
      this.a(output, this.k, gY.c);
      this.a(output, this.g, gY.e);
      this.a(output, this.h, gY.b);
      this.a(output, this.j, gY.a);
      output.writeBoolean(this.f);
   }

   public EntityMoveEvent() {
   }

   @Override
   public void accept(EventVisitor visitor) {
      visitor.visit(this);
   }

   private double a(DataInput var1, int var2) {
      return (this.c & var2) != 0 ? var1.readDouble() : 0.0;
   }

   private float b(DataInput var1, int var2) {
      return (this.c & var2) != 0 ? var1.readFloat() : 0.0F;
   }

   private void a(DataOutput var1, double var2, int var4) {
      if ((this.c & var4) != 0) {
         var1.writeDouble(var2);
      }

   }

   public EntityMoveEvent(
      int var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14, float var15, float var16, float var17
   ) {
      this.i = var1;
      if (Math.abs(var2 - var8) > 1.0E-9) {
         this.c |= gY.d;
      }

      if (Math.abs(var4 - var10) > 1.0E-9) {
         this.c |= gY.c;
      }

      if (Math.abs(var6 - var12) > 1.0E-9) {
         this.c |= gY.e;
      }

      if ((double)Math.abs(var14 - var16) > 1.0E-9) {
         this.c |= gY.b;
      }

      if ((double)Math.abs(var15 - var17) > 1.0E-9) {
         this.c |= gY.a;
      }

      this.e = var2;
      this.k = var4;
      this.g = var6;
      this.h = var14;
      this.j = var15;
   }

   public double l() {
      return this.g;
   }

   public boolean b() {
      return (this.c & gY.d) != 0;
   }

   private void a(DataOutput var1, float var2, int var3) {
      if ((this.c & var3) != 0) {
         var1.writeFloat(var2);
      }

   }

   public boolean c() {
      return (this.c & gY.a) != 0;
   }

   public boolean f() {
      return (this.c & gY.b) != 0;
   }

   public float j() {
      return this.j;
   }

   public boolean d() {
      return (this.c & gY.e) != 0;
   }

   public float g() {
      return this.h;
   }

   public int i() {
      return this.i;
   }
}
