package de.jpx3.intave.unknown;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public class Unknown194 implements Unknown335 {
   private String a;
   private long b;
   private String d;
   private String e;
   private int c;

   public long c() {
      return this.b;
   }

   public void a(long var1) {
      this.b = var1;
   }

   public void a(int var1) {
      this.c = var1;
   }

   public int f() {
      return this.c;
   }

   public long b() {
      return System.currentTimeMillis() - this.b;
   }

   public String e() {
      return this.e;
   }

   public String a() {
      return this.d;
   }

   public String d() {
      return this.a;
   }

   public Unknown194(String var1, String var2, String var3, int var4, long var5) {
      this.e = var1;
      this.a = var2;
      this.d = var3;
      this.c = var4;
      this.b = var5;
   }

   public Unknown194() {
   }

   @Override
   public void a(ByteArrayDataInput var1) {
      this.e = var1.readUTF();
      this.a = var1.readUTF();
      this.d = var1.readUTF();
      this.c = var1.readInt();
      this.b = var1.readLong();
   }

   @Override
   public void a(ByteArrayDataOutput var1) {
      var1.writeUTF(this.e);
      var1.writeUTF(this.a);
      var1.writeUTF(this.d);
      var1.writeInt(this.c);
      var1.writeLong(this.b);
   }
}
