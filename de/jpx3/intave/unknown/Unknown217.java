package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public final class Unknown217 implements Unknown335 {
   private long a;
   private int c;
   private boolean b;

   public boolean a() {
      return this.b;
   }

   public void a(int var1) {
      this.c = var1;
      this.a = System.currentTimeMillis();
   }

   public long c() {
      return this.a;
   }

   public void e() {
      this.b = true;
   }

   public void d() {
      this.c = 0;
      this.a = 0L;
   }

   @Override
   public void a(ByteArrayDataOutput var1) {
      var1.writeInt(this.c);
      var1.writeLong(this.a);
   }

   public int b() {
      return this.c;
   }

   @Override
   public void a(ByteArrayDataInput var1) {
      this.c = var1.readInt();
      this.a = var1.readLong();
   }
}
