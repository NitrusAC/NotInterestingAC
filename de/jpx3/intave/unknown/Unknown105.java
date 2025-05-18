package de.jpx3.intave.unknown;

public final class Unknown105 {
   private final float a;
   private static final Unknown105 b = new Unknown105(Unknown307.c, true, 0.0F);
   private final Unknown307 f;
   private final boolean c;
   private final boolean e;

   public boolean c() {
      return this.a(Unknown307.a);
   }

   public static Unknown105 a(Unknown307 var0, boolean var1, float var2) {
      return var0 == Unknown307.c ? b : new Unknown105(var0, var1, var2);
   }

   private Unknown105(Unknown307 var1, boolean var2, float var3) {
      this.f = var1;
      this.c = var2;
      this.a = var3;
      this.e = var1 == Unknown307.c;
   }

   private boolean a(Unknown307 var1) {
      return !this.e && this.f == var1;
   }

   public float e() {
      return this.a;
   }

   public boolean f() {
      return this.e;
   }

   public boolean d() {
      return this.c;
   }

   public static Unknown105 b() {
      return b;
   }

   public boolean a() {
      return this.a(Unknown307.b);
   }
}
