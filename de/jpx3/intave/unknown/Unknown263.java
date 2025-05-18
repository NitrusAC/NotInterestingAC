package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public final class Unknown263 implements Unknown335 {
   private static final int h = 80;
   private long a;
   private long k;
   private long e;
   private long j;
   private long d;
   private long c;
   private long b;
   private long g;
   private long i;
   private long f;
   private static final String n;

   @Override
   public void a(ByteArrayDataInput var1) {
      int var6 = var1.readInt();
      this.d = var1.readLong();
      this.k = var1.readLong();
      this.b = var1.readLong();
      this.i = var1.readLong();
      this.f = var1.readLong();
      this.a = var1.readLong();
      this.j = var1.readLong();
      this.e = var1.readLong();
      this.g = var1.readLong();
      this.c = var1.readLong();
      int var7 = 80 - var6;
      if (var7 > 0) {
         var1.skipBytes(var7);
      } else if (var7 < 0) {
         throw new IllegalStateException("Byte order underflow");
      }

   }

   public void a(int var1) {
      ++this.b;
   }

   public void b(int var1) {
      ++this.k;
   }

   public void a() {
      ++this.d;
   }

   @Override
   public void a(ByteArrayDataOutput var1) {
      var1.writeInt(80);
      var1.writeLong(this.d);
      var1.writeLong(this.k);
      var1.writeLong(this.b);
      var1.writeLong(this.i);
      var1.writeLong(this.f);
      var1.writeLong(this.a);
      var1.writeLong(this.j);
      var1.writeLong(this.e);
      var1.writeLong(this.g);
      var1.writeLong(this.c);
   }
}
