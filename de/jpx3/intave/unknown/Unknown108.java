package de.jpx3.intave.unknown;

public class Unknown108 implements Cloneable {
   private long a;
   private long b;

   public Object clone() {
      return this.c();
   }

   public void d() {
      this.b(this.a() + 1L);
   }

   public void a(long var1) {
      this.c(this.b() + var1);
   }

   private void c(long var1) {
      this.b = var1;
   }

   public long b() {
      return this.b;
   }

   private void b(long var1) {
      this.a = var1;
   }

   public long a() {
      return this.a;
   }

   public Unknown108 c() {
      try {
         return (Unknown108)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new Error(var2);
      }
   }
}
