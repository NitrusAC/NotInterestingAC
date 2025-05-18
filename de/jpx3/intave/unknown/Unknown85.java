package de.jpx3.intave.unknown;

public class Unknown85 {
   private Object b;
   private long a;

   public Unknown85(Object var1) {
      this.b = var1;
      this.a = System.currentTimeMillis();
   }

   public Object b() {
      return this.b;
   }

   public void a(Object var1) {
      this.b = var1;
      this.a = System.currentTimeMillis();
   }

   public boolean a() {
      return System.currentTimeMillis() - this.a > Unknown128.a();
   }
}
