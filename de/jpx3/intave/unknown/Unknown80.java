package de.jpx3.intave.unknown;

import java.util.function.Consumer;

public final class Unknown80 {
   private final Consumer e;
   private final Unknown227 b;
   private final long c;
   private long d;
   private final boolean a;

   public Unknown80(Unknown227 var1, long var2, Consumer var4, boolean var5) {
      this.b = var1;
      this.c = var2;
      this.e = var4;
      this.a = var5;
   }

   public boolean e() {
      return this.a;
   }

   public static Unknown227 a(Unknown80 var0) {
      return var0.b;
   }

   public Unknown80(Unknown227 var1, long var2, Consumer var4) {
      this(var1, var2, var4, false);
   }

   public void c() {
      this.d = System.currentTimeMillis();
   }

   public String a() {
      return this.b.a();
   }

   public boolean b() {
      return System.currentTimeMillis() - this.d < this.c;
   }

   public Consumer d() {
      return this.e;
   }
}
