package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown13;
import de.jpx3.intave.unknown.Unknown257;

public final class Asm15 extends Asm5 {
   private final Unknown257 h;
   private final Unknown257 r;
   private int d;
   private int l;
   private final int q;
   private int o;
   private final Unknown257 i;
   private final Unknown13 g;
   private int n;
   private final Unknown257 c;
   private final Unknown257 s;
   private final int k;
   private final int f;
   private final Unknown257 p;
   private int j;
   private int e;
   private int m;

   @Override
   public void c(String var1) {
      this.r.c(this.g.c(var1).index);
      ++this.e;
   }

   public Asm15(Unknown13 var1, int var2, int var3, int var4) {
      super(458752);
      this.g = var1;
      this.f = var2;
      this.k = var3;
      this.q = var4;
      this.i = new Unknown257();
      this.c = new Unknown257();
      this.p = new Unknown257();
      this.r = new Unknown257();
      this.s = new Unknown257();
      this.h = new Unknown257();
   }

   @Override
   public void a() {
   }

   public int a() {
      this.g.g("Module");
      int var3 = 22 + this.i.c + this.c.c + this.p.c + this.r.c + this.s.c;
      if (this.j > 0) {
         this.g.g("ModulePackages");
         var3 += 8 + this.h.c;
      }

      if (this.n > 0) {
         this.g.g("ModuleMainClass");
         var3 += 8;
      }

      return var3;
   }

   public int b() {
      return 1 + (this.j > 0 ? 1 : 0) + (this.n > 0 ? 1 : 0);
   }

   @Override
   public void a(String var1, String[] var2) {
      this.s.c(this.g.c(var1).index);
      this.s.c(var2.length);

      for(String var9 : var2) {
         this.s.c(this.g.c(var9).index);
      }

      ++this.o;
   }

   @Override
   public void b(String var1, int var2, String[] var3) {
      this.c.c(this.g.b(var1).index).c(var2);
      if (var3 == null) {
         this.c.c(0);
      } else {
         this.c.c(var3.length);

         for(String var10 : var3) {
            this.c.c(this.g.f(var10).index);
         }
      }

      ++this.d;
   }

   @Override
   public void a(String var1, int var2, String var3) {
      this.i.c(this.g.f(var1).index).c(var2).c(var3 == null ? 0 : this.g.g(var3));
      ++this.m;
   }

   public void a(Unknown257 var1) {
      int var4 = 16 + this.i.c + this.c.c + this.p.c + this.r.c + this.s.c;
      var1.c(this.g.g("Module"))
         .d(var4)
         .c(this.f)
         .c(this.k)
         .c(this.q)
         .c(this.m)
         .a(this.i.b, 0, this.i.c)
         .c(this.d)
         .a(this.c.b, 0, this.c.c)
         .c(this.l)
         .a(this.p.b, 0, this.p.c)
         .c(this.e)
         .a(this.r.b, 0, this.r.c)
         .c(this.o)
         .a(this.s.b, 0, this.s.c);
      if (this.j > 0) {
         var1.c(this.g.g("ModulePackages")).d(2 + this.h.c).c(this.j).a(this.h.b, 0, this.h.c);
      }

      if (this.n > 0) {
         var1.c(this.g.g("ModuleMainClass")).d(2).c(this.n);
      }

   }

   @Override
   public void a(String var1, int var2, String[] var3) {
      this.p.c(this.g.b(var1).index).c(var2);
      if (var3 == null) {
         this.p.c(0);
      } else {
         this.p.c(var3.length);

         for(String var10 : var3) {
            this.p.c(this.g.f(var10).index);
         }
      }

      ++this.l;
   }

   @Override
   public void a(String var1) {
      this.h.c(this.g.b(var1).index);
      ++this.j;
   }

   @Override
   public void b(String var1) {
      this.n = this.g.c(var1).index;
   }
}
