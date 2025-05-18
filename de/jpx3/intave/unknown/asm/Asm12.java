package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.pP;
import de.jpx3.intave.unknown.Unknown13;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown257;
import de.jpx3.intave.unknown.Unknown35;

public final class Asm12 extends Asm14 {
   private final int f;
   private final int e;
   private Asm29 d;
   private Unknown35 j;
   private Asm29 g;
   private int h;
   private Asm29 k;
   private Asm29 c;
   private final Unknown13 l;
   private final int i;

   public Asm12(Unknown13 var1, int var2, String var3, String var4, String var5) {
      super(458752);
      this.l = var1;
      this.i = var2;
      this.f = var1.g(var3);
      this.e = var1.g(var4);
      if (var5 != null) {
         this.h = var1.g(var5);
      }

   }

   public final void a(pP var1) {
      var1.b(this.j);
   }

   public int a() {
      int var1 = 6;
      var1 += Unknown35.a(this.l, this.i & 131072, this.h);
      var1 += Asm29.a(this.k, this.c, this.d, this.g);
      if (this.j != null) {
         var1 += this.j.a(this.l);
      }

      return var1;
   }

   @Override
   public Asm23 a(String var1, boolean var2) {
      return var2 ? (this.k = Asm29.a(this.l, var1, this.k)) : (this.c = Asm29.a(this.l, var1, this.c));
   }

   @Override
   public void a(Unknown35 var1) {
      var1.b = this.j;
      this.j = var1;
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      return var4 ? (this.d = Asm29.a(this.l, var1, var2, var3, this.d)) : (this.g = Asm29.a(this.l, var1, var2, var3, this.g));
   }

   public void a(Unknown257 var1) {
      var1.c(this.f).c(this.e);
      int var2 = 0;
      if (this.h != 0) {
         ++var2;
      }

      if ((this.i & 131072) != 0) {
         ++var2;
      }

      if (this.k != null) {
         ++var2;
      }

      if (this.c != null) {
         ++var2;
      }

      if (this.d != null) {
         ++var2;
      }

      if (this.g != null) {
         ++var2;
      }

      if (this.j != null) {
         var2 += this.j.a();
      }

      var1.c(var2);
      Unknown35.a(this.l, this.i, this.h, var1);
      Asm29.a(this.l, this.k, this.c, this.d, this.g, var1);
      if (this.j != null) {
         this.j.a(this.l, var1);
      }

   }

   @Override
   public void b() {
   }
}
