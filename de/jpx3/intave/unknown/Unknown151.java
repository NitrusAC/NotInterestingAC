package de.jpx3.intave.unknown;

public class Unknown151 {
   private long c;
   private boolean a;
   private final long b;

   public long b() {
      return this.c;
   }

   public boolean c() {
      return this.a;
   }

   public void a(boolean var1) {
      this.a = var1;
      this.c = System.currentTimeMillis();
   }

   public Unknown151(long var1) {
      this.b = var1;
   }

   public boolean a() {
      return System.currentTimeMillis() - this.c > this.b;
   }
}
