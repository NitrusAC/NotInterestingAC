package de.jpx3.intave.unknown;

import de.jpx3.intave.ix;

public final class Unknown328 {
   private final Unknown278 b;
   private final Unknown70 a;
   private final boolean c;

   private Unknown328(Unknown70 var1, Unknown278 var2, boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public static Unknown197 c() {
      return new Unknown197();
   }

   public boolean e() {
      return this.b.a();
   }

   public boolean b(Unknown70 var1) {
      return var1.equals(this.b());
   }

   public boolean a(Unknown70 var1) {
      return var1.equals(this.b()) && this.e();
   }

   public boolean a() {
      return this.c;
   }

   public static Unknown328 d() {
      return c().b();
   }

   Unknown328(Unknown70 var1, Unknown278 var2, boolean var3, ix var4) {
      this(var1, var2, var3);
   }

   public Unknown70 b() {
      return this.a;
   }
}
