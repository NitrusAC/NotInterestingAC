package de.jpx3.intave.unknown;

import de.jpx3.intave.pP;
import de.jpx3.intave.qd;
import de.jpx3.intave.unknown.asm.Asm12;
import de.jpx3.intave.unknown.asm.Asm14;
import de.jpx3.intave.unknown.asm.Asm15;
import de.jpx3.intave.unknown.asm.Asm23;
import de.jpx3.intave.unknown.asm.Asm24;
import de.jpx3.intave.unknown.asm.Asm26;
import de.jpx3.intave.unknown.asm.Asm29;
import de.jpx3.intave.unknown.asm.Asm36;
import de.jpx3.intave.unknown.asm.Asm37;
import de.jpx3.intave.unknown.asm.Asm5;
import org.ow2.asm.RandomASMClass1;

public class Unknown177 extends RandomASMClass1 {
   private Unknown257 f;
   private int q;
   private int v;
   private int j;
   private int d;
   private int o;
   private Asm15 r;
   private Unknown257 D;
   private int F;
   private int y;
   private Asm24 i;
   private Asm24 I;
   private Asm12 C;
   private int p;
   public static final int J = 1;
   private Unknown257 u;
   private Asm29 K;
   private Asm29 k;
   public final Unknown13 m;
   private int E;
   private Asm29 l;
   private Asm12 x;
   private int n;
   private int B;
   private int A;
   private int[] H;
   private Unknown35 t;
   private int z;
   public static final int g = 2;
   private Unknown257 w;
   private Unknown339 e;
   private Asm29 G;
   private Unknown339 h;
   private int s;

   @Deprecated
   public int a(int var1, String var2, String var3, String var4) {
      return this.a(var1, var2, var3, var4, var1 == 9);
   }

   @Override
   public final void b(String var1) {
      if (this.D == null) {
         this.D = new Unknown257();
      }

      ++this.E;
      this.D.c(this.m.c(var1).index);
   }

   @Override
   public final void a(String var1, String var2) {
      if (var1 != null) {
         this.q = this.m.g(var1);
      }

      if (var2 != null) {
         this.u = new Unknown257().a(var2, 0, Integer.MAX_VALUE);
      }

   }

   @Override
   public final Unknown338 a(int var1, String var2, String var3, String var4, String[] var5) {
      Unknown339 var9 = new Unknown339(this.m, var1, var2, var3, var4, var5, this.A);
      if (this.h == null) {
         this.h = var9;
      } else {
         this.e.b = var9;
      }

      return this.e = var9;
   }

   @Override
   public final Asm23 a(String var1, boolean var2) {
      return var2 ? (this.K = Asm29.a(this.m, var1, this.K)) : (this.G = Asm29.a(this.m, var1, this.G));
   }

   public int b(String var1) {
      return this.m.g(var1);
   }

   public Unknown177(Asm37 var1, int var2) {
      super(458752);
      this.m = var1 == null ? new Unknown13(this) : new Unknown13(this, var1);
      if ((var2 & 2) != 0) {
         this.A = 4;
      } else if ((var2 & 1) != 0) {
         this.A = 1;
      } else {
         this.A = 0;
      }

   }

   @Override
   public final void a(Unknown35 var1) {
      var1.b = this.t;
      this.t = var1;
   }

   public int a(String var1, String var2, String var3) {
      return this.m.a(var1, var2, var3).index;
   }

   public int a(String var1, String var2) {
      return this.m.a(var1, var2);
   }

   public int a(Object var1) {
      return this.m.a(var1).index;
   }

   protected ClassLoader b() {
      return this.getClass().getClassLoader();
   }

   private Unknown35[] c() {
      pP var1 = new pP();
      var1.b(this.t);

      for(Asm24 var2 = this.i; var2 != null; var2 = (Asm24)var2.a) {
         var2.a(var1);
      }

      for(Unknown339 var3 = this.h; var3 != null; var3 = (Unknown339)var3.b) {
         var3.a(var1);
      }

      for(Asm12 var4 = this.C; var4 != null; var4 = (Asm12)var4.a) {
         var4.a(var1);
      }

      return var1.a();
   }

   public int d(String var1) {
      return this.m.f(var1).index;
   }

   @Override
   public final Asm26 a(int var1, String var2, String var3, String var4, Object var5) {
      Asm24 var9 = new Asm24(this.m, var1, var2, var3, var4, var5);
      if (this.i == null) {
         this.i = var9;
      } else {
         this.I.a = var9;
      }

      return this.I = var9;
   }

   @Override
   public final void a(String var1, String var2, String var3) {
      this.n = this.m.c(var1).index;
      if (var2 != null && var3 != null) {
         this.z = this.m.a(var2, var3);
      }

   }

   @Override
   public final Asm5 a(String var1, int var2, String var3) {
      return this.r = new Asm15(this.m, this.m.f(var1).index, var2, var3 == null ? 0 : this.m.g(var3));
   }

   public int a(String var1, String var2, Unknown137 var3, Object[] var4) {
      return this.m.a(var1, var2, var3, var4).index;
   }

   public byte[] a() {
      int var3 = 24 + 2 * this.d;
      int var4 = 0;

      for(Asm24 var5 = this.i; var5 != null; var5 = (Asm24)var5.a) {
         ++var4;
         var3 += var5.a();
      }

      int var6 = 0;

      for(Unknown339 var7 = this.h; var7 != null; var7 = (Unknown339)var7.b) {
         ++var6;
         var3 += var7.i();
      }

      int var8 = 0;
      if (this.f != null) {
         ++var8;
         var3 += 8 + this.f.c;
         this.m.g("InnerClasses");
      }

      if (this.n != 0) {
         ++var8;
         var3 += 10;
         this.m.g("EnclosingMethod");
      }

      if ((this.s & 4096) != 0 && (this.B & 65535) < 49) {
         ++var8;
         var3 += 6;
         this.m.g("Synthetic");
      }

      if (this.o != 0) {
         ++var8;
         var3 += 8;
         this.m.g("Signature");
      }

      if (this.q != 0) {
         ++var8;
         var3 += 8;
         this.m.g("SourceFile");
      }

      if (this.u != null) {
         ++var8;
         var3 += 6 + this.u.c;
         this.m.g("SourceDebugExtension");
      }

      if ((this.s & 131072) != 0) {
         ++var8;
         var3 += 6;
         this.m.g("Deprecated");
      }

      if (this.K != null) {
         ++var8;
         var3 += this.K.a("RuntimeVisibleAnnotations");
      }

      if (this.G != null) {
         ++var8;
         var3 += this.G.a("RuntimeInvisibleAnnotations");
      }

      if (this.l != null) {
         ++var8;
         var3 += this.l.a("RuntimeVisibleTypeAnnotations");
      }

      if (this.k != null) {
         ++var8;
         var3 += this.k.a("RuntimeInvisibleTypeAnnotations");
      }

      if (this.m.f() > 0) {
         ++var8;
         var3 += this.m.f();
      }

      if (this.r != null) {
         var8 += this.r.b();
         var3 += this.r.a();
      }

      if (this.p != 0) {
         ++var8;
         var3 += 8;
         this.m.g("NestHost");
      }

      if (this.w != null) {
         ++var8;
         var3 += 8 + this.w.c;
         this.m.g("NestMembers");
      }

      if (this.D != null) {
         ++var8;
         var3 += 8 + this.D.c;
         this.m.g("PermittedSubtypes");
      }

      int var9 = 0;
      int var10 = 0;
      if (this.C != null) {
         for(Asm12 var11 = this.C; var11 != null; var11 = (Asm12)var11.a) {
            ++var9;
            var10 += var11.a();
         }

         ++var8;
         var3 += 8 + var10;
         this.m.g("Record");
      }

      if (this.t != null) {
         var8 += this.t.a();
         var3 += this.t.a(this.m);
      }

      var3 += this.m.a();
      int var20 = this.m.b();
      if (var20 > 65535) {
         throw new Asm36(this.m.c(), var20);
      } else {
         Unknown257 var12 = new Unknown257(var3);
         var12.d(-889275714).d(this.B);
         this.m.a(var12);
         int var13 = (this.B & 65535) < 49 ? 4096 : 0;
         var12.c(this.s & ~var13).c(this.v).c(this.j);
         var12.c(this.d);

         for(int var14 = 0; var14 < this.d; ++var14) {
            var12.c(this.H[var14]);
         }

         var12.c(var4);

         for(Asm24 var18 = this.i; var18 != null; var18 = (Asm24)var18.a) {
            var18.a(var12);
         }

         var12.c(var6);
         boolean var21 = false;
         boolean var15 = false;

         for(Unknown339 var19 = this.h; var19 != null; var19 = (Unknown339)var19.b) {
            var21 |= var19.a();
            var15 |= var19.e();
            var19.a(var12);
         }

         var12.c(var8);
         if (this.f != null) {
            var12.c(this.m.g("InnerClasses")).d(this.f.c + 2).c(this.F).a(this.f.b, 0, this.f.c);
         }

         if (this.n != 0) {
            var12.c(this.m.g("EnclosingMethod")).d(4).c(this.n).c(this.z);
         }

         if ((this.s & 4096) != 0 && (this.B & 65535) < 49) {
            var12.c(this.m.g("Synthetic")).d(0);
         }

         if (this.o != 0) {
            var12.c(this.m.g("Signature")).d(2).c(this.o);
         }

         if (this.q != 0) {
            var12.c(this.m.g("SourceFile")).d(2).c(this.q);
         }

         if (this.u != null) {
            int var16 = this.u.c;
            var12.c(this.m.g("SourceDebugExtension")).d(var16).a(this.u.b, 0, var16);
         }

         if ((this.s & 131072) != 0) {
            var12.c(this.m.g("Deprecated")).d(0);
         }

         Asm29.a(this.m, this.K, this.G, this.l, this.k, var12);
         this.m.b(var12);
         if (this.r != null) {
            this.r.a(var12);
         }

         if (this.p != 0) {
            var12.c(this.m.g("NestHost")).d(2).c(this.p);
         }

         if (this.w != null) {
            var12.c(this.m.g("NestMembers")).d(this.w.c + 2).c(this.y).a(this.w.b, 0, this.w.c);
         }

         if (this.D != null) {
            var12.c(this.m.g("PermittedSubtypes")).d(this.D.c + 2).c(this.E).a(this.D.b, 0, this.D.c);
         }

         if (this.C != null) {
            var12.c(this.m.g("Record")).d(var10 + 2).c(var9);

            for(Asm12 var22 = this.C; var22 != null; var22 = (Asm12)var22.a) {
               var22.a(var12);
            }
         }

         if (this.t != null) {
            this.t.a(this.m, var12);
         }

         return var15 ? this.a(var12.b, var21) : var12.b;
      }
   }

   @Override
   public final void a() {
   }

   protected String b(String var1, String var2) {
      ClassLoader var6 = this.b();

      Class var7;
      try {
         String var10001 = var1.replace('/', '.');
         boolean var10003 = false;
         var7 = Class.forName(qd.a(var10001), false, var6);
      } catch (ClassNotFoundException var11) {
         return "java/lang/Object";
      }

      Class var8;
      try {
         String var12 = var2.replace('/', '.');
         boolean var13 = false;
         var8 = Class.forName(qd.a(var12), false, var6);
      } catch (ClassNotFoundException var10) {
         return "java/lang/Object";
      }

      if (var7.isAssignableFrom(var8)) {
         return var1;
      } else if (var8.isAssignableFrom(var7)) {
         return var2;
      } else if (!var7.isInterface() && !var8.isInterface()) {
         do {
            var7 = var7.getSuperclass();
         } while(!var7.isAssignableFrom(var8));

         return var7.getName().replace('.', '/');
      } else {
         return "java/lang/Object";
      }
   }

   @Override
   public final void a(String var1) {
      this.p = this.m.c(var1).index;
   }

   public int c(String var1) {
      return this.m.c(var1).index;
   }

   @Override
   public final void a(int var1, int var2, String var3, String var4, String var5, String[] var6) {
      this.B = var1;
      this.s = var2;
      this.v = this.m.a(var1 & 65535, var3);
      if (var4 != null) {
         this.o = this.m.g(var4);
      }

      this.j = var5 == null ? 0 : this.m.c(var5).index;
      if (var6 != null && var6.length > 0) {
         this.d = var6.length;
         this.H = new int[this.d];

         for(int var10 = 0; var10 < this.d; ++var10) {
            this.H[var10] = this.m.c(var6[var10]).index;
         }
      }

      if (this.A == 1 && (var1 & 65535) >= 51) {
         this.A = 2;
      }

   }

   @Override
   public final void c(String var1) {
      if (this.w == null) {
         this.w = new Unknown257();
      }

      ++this.y;
      this.w.c(this.m.c(var1).index);
   }

   @Override
   public final void a(String var1, String var2, String var3, int var4) {
      if (this.f == null) {
         this.f = new Unknown257();
      }

      Unknown154 var8 = this.m.c(var1);
      if (var8.info == 0) {
         ++this.F;
         this.f.c(var8.index);
         this.f.c(var2 == null ? 0 : this.m.c(var2).index);
         this.f.c(var3 == null ? 0 : this.m.g(var3));
         this.f.c(var4);
         var8.info = this.F;
      }

   }

   private byte[] a(byte[] var1, boolean var2) {
      Unknown35[] var3 = this.c();
      this.i = null;
      this.I = null;
      this.h = null;
      this.e = null;
      this.K = null;
      this.G = null;
      this.l = null;
      this.k = null;
      this.r = null;
      this.p = 0;
      this.y = 0;
      this.w = null;
      this.E = 0;
      this.D = null;
      this.C = null;
      this.x = null;
      this.t = null;
      this.A = var2 ? 3 : 0;
      new Asm37(var1, 0, false).a(this, var3, (var2 ? 8 : 0) | 256);
      return this.a();
   }

   public Unknown177(int var1) {
      this(null, var1);
   }

   public int b(String var1, String var2, Unknown137 var3, Object[] var4) {
      return this.m.b(var1, var2, var3, var4).index;
   }

   public int e(String var1) {
      return this.m.d(var1).index;
   }

   public int a(String var1, String var2, String var3, boolean var4) {
      return this.m.a(var1, var2, var3, var4).index;
   }

   public int a(int var1, String var2, String var3, String var4, boolean var5) {
      return this.m.a(var1, var2, var3, var4, var5).index;
   }

   @Override
   public final Asm14 a(int var1, String var2, String var3, String var4) {
      Asm12 var8 = new Asm12(this.m, var1, var2, var3, var4);
      if (this.C == null) {
         this.C = var8;
      } else {
         this.x.a = var8;
      }

      return this.x = var8;
   }

   public int a(String var1) {
      return this.m.b(var1).index;
   }

   @Override
   public final Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      return var4 ? (this.l = Asm29.a(this.m, var1, var2, var3, this.l)) : (this.k = Asm29.a(this.m, var1, var2, var3, this.k));
   }
}
