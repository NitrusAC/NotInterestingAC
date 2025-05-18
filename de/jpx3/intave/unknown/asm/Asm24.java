package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.pP;
import de.jpx3.intave.unknown.Unknown13;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown257;
import de.jpx3.intave.unknown.Unknown35;

public final class Asm24 extends Asm26 {
   private final Unknown13 c;
   private Asm29 d;
   private Asm29 m;
   private final int e;
   private final int i;
   private Unknown35 f;
   private int k;
   private int l;
   private Asm29 h;
   private Asm29 g;
   private final int j;

   public Asm24(Unknown13 var1, int var2, String var3, String var4, String var5, Object var6) {
      super(458752);
      this.c = var1;
      this.e = var2;
      this.i = var1.g(var3);
      this.j = var1.g(var4);
      if (var5 != null) {
         this.l = var1.g(var5);
      }

      if (var6 != null) {
         this.k = var1.a(var6).index;
      }

   }

   public int a() {
      int var3 = 8;
      if (this.k != 0) {
         this.c.g("ConstantValue");
         var3 += 8;
      }

      var3 += Unknown35.a(this.c, this.e, this.l);
      var3 += Asm29.a(this.g, this.h, this.d, this.m);
      if (this.f != null) {
         var3 += this.f.a(this.c);
      }

      return var3;
   }

   public void a(Unknown257 var1) {
      boolean var4 = this.c.d() < 49;
      int var5 = var4 ? 4096 : 0;
      var1.c(this.e & ~var5).c(this.i).c(this.j);
      int var6 = 0;
      if (this.k != 0) {
         ++var6;
      }

      if ((this.e & 4096) != 0 && var4) {
         ++var6;
      }

      if (this.l != 0) {
         ++var6;
      }

      if ((this.e & 131072) != 0) {
         ++var6;
      }

      if (this.g != null) {
         ++var6;
      }

      if (this.h != null) {
         ++var6;
      }

      if (this.d != null) {
         ++var6;
      }

      if (this.m != null) {
         ++var6;
      }

      if (this.f != null) {
         var6 += this.f.a();
      }

      var1.c(var6);
      if (this.k != 0) {
         var1.c(this.c.g("ConstantValue")).d(2).c(this.k);
      }

      Unknown35.a(this.c, this.e, this.l, var1);
      Asm29.a(this.c, this.g, this.h, this.d, this.m, var1);
      if (this.f != null) {
         this.f.a(this.c, var1);
      }

   }

   @Override
   public Asm23 a(String var1, boolean var2) {
      return var2 ? (this.g = Asm29.a(this.c, var1, this.g)) : (this.h = Asm29.a(this.c, var1, this.h));
   }

   @Override
   public void a() {
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      return var4 ? (this.d = Asm29.a(this.c, var1, var2, var3, this.d)) : (this.m = Asm29.a(this.c, var1, var2, var3, this.m));
   }

   public final void a(pP var1) {
      var1.b(this.f);
   }

   @Override
   public void a(Unknown35 var1) {
      var1.b = this.f;
      this.f = var1;
   }
}
