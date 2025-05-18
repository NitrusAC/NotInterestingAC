package de.jpx3.intave.unknown;

import de.jpx3.intave.pP;
import de.jpx3.intave.qs;
import de.jpx3.intave.unknown.asm.Asm23;
import de.jpx3.intave.unknown.asm.Asm29;
import de.jpx3.intave.unknown.asm.Asm31;
import de.jpx3.intave.unknown.asm.Asm32;
import de.jpx3.intave.unknown.asm.Asm37;

public final class Unknown339 extends Unknown338 {
   private int aj;
   static final int N = 0;
   private final String r;
   private Asm29 m;
   private Unknown257 f;
   private int X;
   private int u;
   private final int Q;
   private static final int[] V = new int[]{
      0,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      2,
      2,
      1,
      1,
      1,
      2,
      2,
      1,
      1,
      1,
      0,
      0,
      1,
      2,
      1,
      2,
      1,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      -1,
      0,
      -1,
      0,
      -1,
      -1,
      -1,
      -1,
      -1,
      -2,
      -1,
      -2,
      -1,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      -3,
      -4,
      -3,
      -4,
      -3,
      -3,
      -3,
      -3,
      -1,
      -2,
      1,
      1,
      1,
      2,
      2,
      2,
      0,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      0,
      0,
      0,
      0,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -2,
      -1,
      -2,
      -1,
      -2,
      0,
      1,
      0,
      1,
      -1,
      -1,
      0,
      0,
      1,
      1,
      -1,
      0,
      -1,
      0,
      0,
      0,
      -3,
      -1,
      -1,
      -3,
      -3,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
      -2,
      -2,
      -2,
      -2,
      -2,
      -2,
      -2,
      -2,
      0,
      1,
      0,
      -1,
      -1,
      -1,
      -2,
      -1,
      -2,
      -1,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      1,
      0,
      0,
      0,
      0,
      0,
      0,
      -1,
      -1,
      0,
      0,
      -1,
      -1,
      0,
      0
   };
   private static final int s = 0;
   private Asm29 Z;
   private int[] K;
   private int L;
   private Asm29[] l;
   private Unknown257 p;
   private Unknown35 P;
   private int ad;
   private final Unknown13 t;
   private Unknown35 w;
   private Unknown246 O;
   private Unknown257 h;
   private int[] n;
   private int B;
   private int y;
   static final int F = 3;
   private final String H;
   private Asm29 aa;
   private int af;
   private final Unknown257 ak = new Unknown257();
   private final int j;
   private int C;
   private int A;
   private Asm29[] x;
   private int ac;
   private boolean M;
   private boolean o;
   private int ah;
   private Unknown246 Y;
   private Asm29 q;
   private Unknown257 G;
   static final int U = 1;
   static final int W = 4;
   private final int[] v;
   static final int e = 2;
   private int ag;
   private final int i;
   private int z;
   private Unknown326 E;
   private Unknown257 T;
   private final int g;
   private int ae;
   private Unknown326 ab;
   private int R;
   private final int S;
   private Unknown246 J;
   private final int k;
   private Unknown257 I;
   private Asm29 D;
   private Asm29 ai;

   boolean e() {
      return this.M;
   }

   Unknown339(Unknown13 var1, int var2, String var3, String var4, String var5, String[] var6, int var7) {
      super(458752);
      this.t = var1;
      this.S = "<init>".equals(var3) ? var2 | 262144 : var2;
      this.j = var1.g(var3);
      this.H = var3;
      this.i = var1.g(var4);
      this.r = var4;
      this.k = var5 == null ? 0 : var1.g(var5);
      if (var6 != null && var6.length > 0) {
         this.Q = var6.length;
         this.v = new int[this.Q];

         for(int var11 = 0; var11 < this.Q; ++var11) {
            this.v[var11] = var1.c(var6[var11]).index;
         }
      } else {
         this.Q = 0;
         this.v = null;
      }

      this.g = var7;
      if (var7 != 0) {
         int var12 = Unknown357.d(var4) >> 2;
         if ((var2 & 8) != 0) {
            --var12;
         }

         this.B = var12;
         this.X = var12;
         this.Y = new Unknown246();
         this.a(this.Y);
      }

   }

   public boolean a(Asm37 var1, boolean var2, boolean var3, int var4, int var5, int var6) {
      if (var1 == this.t.e() && var4 == this.i && var5 == this.k && var3 != ((this.S & 131072) == 0)) {
         boolean var7 = this.t.d() < 49 && (this.S & 4096) != 0;
         if (var2 != var7) {
            return false;
         } else if (var6 == 0) {
            return this.Q == 0;
         } else {
            if (var1.g(var6) == this.Q) {
               int var8 = var6 + 2;

               for(int var9 = 0; var9 < this.Q; ++var9) {
                  if (var1.g(var8) != this.v[var9]) {
                     return false;
                  }

                  var8 += 2;
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      return var4
         ? (this.aa = Asm29.a(this.t, var1 & -16776961 | this.y << 8, var2, var3, this.aa))
         : (this.D = Asm29.a(this.t, var1 & -16776961 | this.y << 8, var2, var3, this.D));
   }

   @Override
   public void e() {
   }

   @Override
   public void a(Object var1) {
      this.y = this.ak.c;
      Unknown154 var5 = this.t.a(var1);
      int var6 = var5.index;
      char var7;
      boolean var8 = var5.tag == 5 || var5.tag == 6 || var5.tag == 17 && ((var7 = var5.value.charAt(0)) == 'J' || var7 == 'D');
      if (var8) {
         this.ak.b(20, var6);
      } else if (var6 >= 256) {
         this.ak.b(19, var6);
      } else {
         this.ak.a(18, var6);
      }

      if (this.J != null) {
         if (this.g != 4 && this.g != 3) {
            int var9 = this.aj + (var8 ? 2 : 1);
            if (var9 > this.z) {
               this.z = var9;
            }

            this.aj = var9;
         } else {
            this.J.p.a(18, 0, var5, this.t);
         }
      }

   }

   int i() {
      if (this.u != 0) {
         return 6 + this.ag;
      } else {
         int var3 = 8;
         if (this.ak.c > 0) {
            if (this.ak.c > 65535) {
               throw new Asm31(this.t.c(), this.H, this.r, this.ak.c);
            }

            this.t.g("Code");
            var3 += 16 + this.ak.c + Unknown326.a(this.E);
            if (this.G != null) {
               boolean var4 = this.t.d() >= 50;
               this.t.g(var4 ? "StackMapTable" : "StackMap");
               var3 += 8 + this.G.c;
            }

            if (this.h != null) {
               this.t.g("LineNumberTable");
               var3 += 8 + this.h.c;
            }

            if (this.I != null) {
               this.t.g("LocalVariableTable");
               var3 += 8 + this.I.c;
            }

            if (this.T != null) {
               this.t.g("LocalVariableTypeTable");
               var3 += 8 + this.T.c;
            }

            if (this.aa != null) {
               var3 += this.aa.a("RuntimeVisibleTypeAnnotations");
            }

            if (this.D != null) {
               var3 += this.D.a("RuntimeInvisibleTypeAnnotations");
            }

            if (this.w != null) {
               var3 += this.w.a(this.t, this.ak.b, this.ak.c, this.ah, this.B);
            }
         }

         if (this.Q > 0) {
            this.t.g("Exceptions");
            var3 += 8 + 2 * this.Q;
         }

         var3 += Unknown35.a(this.t, this.S, this.k);
         var3 += Asm29.a(this.Z, this.m, this.ai, this.q);
         if (this.l != null) {
            var3 += Asm29.a("RuntimeVisibleParameterAnnotations", this.l, this.ac == 0 ? this.l.length : this.ac);
         }

         if (this.x != null) {
            var3 += Asm29.a("RuntimeInvisibleParameterAnnotations", this.x, this.C == 0 ? this.x.length : this.C);
         }

         if (this.p != null) {
            this.t.g("AnnotationDefault");
            var3 += 6 + this.p.c;
         }

         if (this.f != null) {
            this.t.g("MethodParameters");
            var3 += 7 + this.f.c;
         }

         if (this.P != null) {
            var3 += this.P.a(this.t);
         }

         return var3;
      }
   }

   @Override
   public void visit(int var1, String var2, String var3, String var4, boolean var5) {
      this.y = this.ak.c;
      Unknown154 var9 = this.t.a(var2, var3, var4, var5);
      if (var1 == 185) {
         this.ak.b(185, var9.index).a(var9.a() >> 2, 0);
      } else {
         this.ak.b(var1, var9.index);
      }

      if (this.J != null) {
         if (this.g != 4 && this.g != 3) {
            int var10 = var9.a();
            int var11 = (var10 & 3) - (var10 >> 2);
            int var12;
            if (var1 == 184) {
               var12 = this.aj + var11 + 1;
            } else {
               var12 = this.aj + var11;
            }

            if (var12 > this.z) {
               this.z = var12;
            }

            this.aj = var12;
         } else {
            this.J.p.a(var1, 0, var9, this.t);
         }
      }

   }

   @Override
   public void a(Unknown35 var1) {
      if (var1.d()) {
         var1.b = this.w;
         this.w = var1;
      } else {
         var1.b = this.P;
         this.P = var1;
      }

   }

   void a(Unknown257 var1) {
      boolean var4 = this.t.d() < 49;
      int var5 = var4 ? 4096 : 0;
      var1.c(this.S & ~var5).c(this.j).c(this.i);
      if (this.u != 0) {
         var1.a(this.t.e().k, this.u, this.ag);
      } else {
         int var6 = 0;
         if (this.ak.c > 0) {
            ++var6;
         }

         if (this.Q > 0) {
            ++var6;
         }

         if ((this.S & 4096) != 0 && var4) {
            ++var6;
         }

         if (this.k != 0) {
            ++var6;
         }

         if ((this.S & 131072) != 0) {
            ++var6;
         }

         if (this.Z != null) {
            ++var6;
         }

         if (this.m != null) {
            ++var6;
         }

         if (this.l != null) {
            ++var6;
         }

         if (this.x != null) {
            ++var6;
         }

         if (this.ai != null) {
            ++var6;
         }

         if (this.q != null) {
            ++var6;
         }

         if (this.p != null) {
            ++var6;
         }

         if (this.f != null) {
            ++var6;
         }

         if (this.P != null) {
            var6 += this.P.a();
         }

         var1.c(var6);
         if (this.ak.c > 0) {
            int var7 = 10 + this.ak.c + Unknown326.a(this.E);
            int var8 = 0;
            if (this.G != null) {
               var7 += 8 + this.G.c;
               ++var8;
            }

            if (this.h != null) {
               var7 += 8 + this.h.c;
               ++var8;
            }

            if (this.I != null) {
               var7 += 8 + this.I.c;
               ++var8;
            }

            if (this.T != null) {
               var7 += 8 + this.T.c;
               ++var8;
            }

            if (this.aa != null) {
               var7 += this.aa.a("RuntimeVisibleTypeAnnotations");
               ++var8;
            }

            if (this.D != null) {
               var7 += this.D.a("RuntimeInvisibleTypeAnnotations");
               ++var8;
            }

            if (this.w != null) {
               var7 += this.w.a(this.t, this.ak.b, this.ak.c, this.ah, this.B);
               var8 += this.w.a();
            }

            var1.c(this.t.g("Code")).d(var7).c(this.ah).c(this.B).d(this.ak.c).a(this.ak.b, 0, this.ak.c);
            Unknown326.a(this.E, var1);
            var1.c(var8);
            if (this.G != null) {
               boolean var9 = this.t.d() >= 50;
               var1.c(this.t.g(var9 ? "StackMapTable" : "StackMap")).d(2 + this.G.c).c(this.ad).a(this.G.b, 0, this.G.c);
            }

            if (this.h != null) {
               var1.c(this.t.g("LineNumberTable")).d(2 + this.h.c).c(this.R).a(this.h.b, 0, this.h.c);
            }

            if (this.I != null) {
               var1.c(this.t.g("LocalVariableTable")).d(2 + this.I.c).c(this.L).a(this.I.b, 0, this.I.c);
            }

            if (this.T != null) {
               var1.c(this.t.g("LocalVariableTypeTable")).d(2 + this.T.c).c(this.A).a(this.T.b, 0, this.T.c);
            }

            if (this.aa != null) {
               this.aa.a(this.t.g("RuntimeVisibleTypeAnnotations"), var1);
            }

            if (this.D != null) {
               this.D.a(this.t.g("RuntimeInvisibleTypeAnnotations"), var1);
            }

            if (this.w != null) {
               this.w.a(this.t, this.ak.b, this.ak.c, this.ah, this.B, var1);
            }
         }

         if (this.Q > 0) {
            var1.c(this.t.g("Exceptions")).d(2 + 2 * this.Q).c(this.Q);

            for(int var10 : this.v) {
               var1.c(var10);
            }
         }

         Unknown35.a(this.t, this.S, this.k, var1);
         Asm29.a(this.t, this.Z, this.m, this.ai, this.q, var1);
         if (this.l != null) {
            Asm29.a(this.t.g("RuntimeVisibleParameterAnnotations"), this.l, this.ac == 0 ? this.l.length : this.ac, var1);
         }

         if (this.x != null) {
            Asm29.a(this.t.g("RuntimeInvisibleParameterAnnotations"), this.x, this.C == 0 ? this.x.length : this.C, var1);
         }

         if (this.p != null) {
            var1.c(this.t.g("AnnotationDefault")).d(this.p.c).a(this.p.b, 0, this.p.c);
         }

         if (this.f != null) {
            var1.c(this.t.g("MethodParameters")).d(1 + this.f.c).a(this.af).a(this.f.b, 0, this.f.c);
         }

         if (this.P != null) {
            this.P.a(this.t, var1);
         }

      }
   }

   @Override
   public void b(int var1, Unknown246 var2) {
      if (this.h == null) {
         this.h = new Unknown257();
      }

      ++this.R;
      this.h.c(var2.f);
      this.h.c(var1);
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, Unknown246[] var3, Unknown246[] var4, int[] var5, String var6, boolean var7) {
      Unknown257 var11 = new Unknown257();
      var11.a(var1 >>> 24).c(var3.length);

      for(int var12 = 0; var12 < var3.length; ++var12) {
         var11.c(var3[var12].f).c(var4[var12].f - var3[var12].f).c(var5[var12]);
      }

      Unknown186.a(var2, var11);
      var11.c(this.t.g(var6)).c(0);
      return var7 ? (this.aa = new Asm29(this.t, true, var11, this.aa)) : (this.D = new Asm29(this.t, true, var11, this.D));
   }

   private void c(int var1, Unknown246 var2) {
      this.J.g = new Unknown88(var1, var2, this.J.g);
   }

   @Override
   public void b(String var1, int var2) {
      this.y = this.ak.c;
      Unknown154 var6 = this.t.c(var1);
      this.ak.b(197, var6.index).a(var2);
      if (this.J != null) {
         if (this.g != 4 && this.g != 3) {
            this.aj += 1 - var2;
         } else {
            this.J.p.a(197, var2, var6, this.t);
         }
      }

   }

   @Override
   public Asm23 c(int var1, Unknown186 var2, String var3, boolean var4) {
      return var4 ? (this.ai = Asm29.a(this.t, var1, var2, var3, this.ai)) : (this.q = Asm29.a(this.t, var1, var2, var3, this.q));
   }

   public void g() {
      if (this.K != null) {
         if (this.G == null) {
            this.G = new Unknown257();
         }

         this.b();
         ++this.ad;
      }

      this.K = this.n;
      this.n = null;
   }

   @Override
   public void a(int var1, int var2, Object[] var3, int var4, Object[] var5) {
      if (this.g != 4) {
         if (this.g == 3) {
            if (this.J.p == null) {
               this.J.p = new Unknown123(this.J);
               this.J.p.a(this.t, this.S, this.r, var2);
               this.J.p.a(this);
            } else {
               if (var1 == -1) {
                  this.J.p.a(this.t, var2, var3, var4, var5);
               }

               this.J.p.a(this);
            }
         } else if (var1 == -1) {
            if (this.K == null) {
               int var11 = Unknown357.d(this.r) >> 2;
               Asm32 var16 = new Asm32(new Unknown246());
               var16.a(this.t, this.S, this.r, var11);
               var16.a(this);
            }

            this.X = var2;
            int var12 = this.a(this.ak.c, var2, var4);

            for(int var17 = 0; var17 < var2; ++var17) {
               this.n[var12++] = Asm32.a(this.t, var3[var17]);
            }

            for(int var18 = 0; var18 < var4; ++var18) {
               this.n[var12++] = Asm32.a(this.t, var5[var18]);
            }

            this.g();
         } else {
            if (this.t.d() < 50) {
               throw new IllegalArgumentException("Class versions V1_5 or less must use F_NEW frames.");
            }

            int var9;
            if (this.G == null) {
               this.G = new Unknown257();
               var9 = this.ak.c;
            } else {
               var9 = this.ak.c - this.ae - 1;
               if (var9 < 0) {
                  if (var1 == 3) {
                     return;
                  }

                  throw new IllegalStateException();
               }
            }

            switch(var1) {
               case 0:
                  this.X = var2;
                  this.G.a(255).c(var9).c(var2);

                  for(int var14 = 0; var14 < var2; ++var14) {
                     this.b(var3[var14]);
                  }

                  this.G.c(var4);

                  for(int var15 = 0; var15 < var4; ++var15) {
                     this.b(var5[var15]);
                  }
                  break;
               case 1:
                  this.X += var2;
                  this.G.a(251 + var2).c(var9);

                  for(int var10 = 0; var10 < var2; ++var10) {
                     this.b(var3[var10]);
                  }
                  break;
               case 2:
                  this.X -= var2;
                  this.G.a(251 - var2).c(var9);
                  break;
               case 3:
                  if (var9 < 64) {
                     this.G.a(var9);
                  } else {
                     this.G.a(251).c(var9);
                  }
                  break;
               case 4:
                  if (var9 < 64) {
                     this.G.a(64 + var9);
                  } else {
                     this.G.a(247).c(var9);
                  }

                  this.b(var5[0]);
                  break;
               default:
                  throw new IllegalArgumentException();
            }

            this.ae = this.ak.c;
            ++this.ad;
         }

         if (this.g == 2) {
            this.aj = var4;

            for(int var13 = 0; var13 < var4; ++var13) {
               if (var5[var13] == qs.ad || var5[var13] == qs.a_) {
                  ++this.aj;
               }
            }

            if (this.aj > this.z) {
               this.z = this.aj;
            }
         }

         this.ah = Math.max(this.ah, var4);
         this.B = Math.max(this.B, this.X);
      }
   }

   @Override
   public void a(int var1, int var2, Unknown246 var3, Unknown246[] var4) {
      this.y = this.ak.c;
      this.ak.a(170).a(null, 0, (4 - this.ak.c % 4) % 4);
      var3.a(this.ak, this.y, true);
      this.ak.d(var1).d(var2);

      for(Unknown246 var11 : var4) {
         var11.a(this.ak, this.y, true);
      }

      this.a(var3, var4);
   }

   @Override
   public void a(int var1, boolean var2) {
      if (var2) {
         this.ac = var1;
      } else {
         this.C = var1;
      }

   }

   private void d() {
      for(Unknown326 var4 = this.E; var4 != null; var4 = var4.b) {
         String var5 = var4.d == null ? "java/lang/Throwable" : var4.d;
         int var6 = Asm32.b(this.t, var5);
         Unknown246 var7 = var4.e.b();
         var7.A = (short)(var7.A | 2);
         Unknown246 var8 = var4.c.b();

         for(Unknown246 var9 = var4.a.b(); var8 != var9; var8 = var8.s) {
            var8.g = new Unknown88(var6, var7, var8.g);
         }
      }

      Asm32 var13 = this.Y.p;
      var13.a(this.t, this.S, this.r, this.B);
      var13.a(this);
      Unknown246 var14 = this.Y;
      var14.l = Unknown246.w;
      int var15 = 0;

      while(var14 != Unknown246.w) {
         Unknown246 var16 = var14;
         var14 = var14.l;
         var16.l = null;
         var16.A = (short)(var16.A | 8);
         int var18 = var16.p.a() + var16.q;
         if (var18 > var15) {
            var15 = var18;
         }

         for(Unknown88 var10 = var16.g; var10 != null; var10 = var10.a) {
            Unknown246 var11 = var10.c.b();
            boolean var12 = var16.p.a(this.t, var11.p, var10.e);
            if (var12 && var11.l == null) {
               var11.l = var14;
               var14 = var11;
            }
         }
      }

      for(Unknown246 var17 = this.Y; var17 != null; var17 = var17.s) {
         if ((var17.A & 10) == 10) {
            var17.p.a(this);
         }

         if ((var17.A & 8) == 0) {
            Unknown246 var19 = var17.s;
            int var20 = var17.f;
            int var21 = (var19 == null ? this.ak.c : var19.f) - 1;
            if (var21 >= var20) {
               for(int var22 = var20; var22 < var21; ++var22) {
                  this.ak.b[var22] = 0;
               }

               this.ak.b[var21] = -65;
               int var23 = this.a(var20, 0, 1);
               this.n[var23] = Asm32.b(this.t, "java/lang/Throwable");
               this.g();
               this.E = Unknown326.a(this.E, var17, var19);
               var15 = Math.max(var15, 1);
            }
         }
      }

      this.ah = var15;
   }

   private void h() {
      for(Unknown326 var4 = this.E; var4 != null; var4 = var4.b) {
         Unknown246 var5 = var4.e;
         Unknown246 var6 = var4.c;

         for(Unknown246 var7 = var4.a; var6 != var7; var6 = var6.s) {
            if ((var6.A & 16) == 0) {
               var6.g = new Unknown88(Integer.MAX_VALUE, var5, var6.g);
            } else {
               var6.g.a.a = new Unknown88(Integer.MAX_VALUE, var5, var6.g.a.a);
            }
         }
      }

      if (this.o) {
         short var12 = 1;
         this.Y.a(var12);

         for(short var14 = 1; var14 <= var12; ++var14) {
            for(Unknown246 var17 = this.Y; var17 != null; var17 = var17.s) {
               if ((var17.A & 16) != 0 && var17.e == var14) {
                  Unknown246 var8 = var17.g.a.c;
                  if (var8.e == 0) {
                     var8.a(++var12);
                  }
               }
            }
         }

         for(Unknown246 var15 = this.Y; var15 != null; var15 = var15.s) {
            if ((var15.A & 16) != 0) {
               Unknown246 var18 = var15.g.a.c;
               var18.a(var15);
            }
         }
      }

      Unknown246 var13 = this.Y;
      var13.l = Unknown246.w;
      int var16 = this.ah;

      while(var13 != Unknown246.w) {
         Unknown246 var19 = var13;
         var13 = var13.l;
         short var20 = var19.y;
         int var9 = var20 + var19.q;
         if (var9 > var16) {
            var16 = var9;
         }

         Unknown88 var10 = var19.g;
         if ((var19.A & 16) != 0) {
            var10 = var10.a;
         }

         for(; var10 != null; var10 = var10.a) {
            Unknown246 var11 = var10.c;
            if (var11.l == null) {
               var11.y = (short)(var10.e == Integer.MAX_VALUE ? 1 : var20 + var10.e);
               var11.l = var13;
               var13 = var11;
            }
         }
      }

      this.ah = var16;
   }

   @Override
   public void a(int var1, int var2) {
      this.y = this.ak.c;
      if (var1 <= 255 && var2 <= 127 && var2 >= -128) {
         this.ak.a(132).a(var1, var2);
      } else {
         this.ak.a(196).b(132, var1).c(var2);
      }

      if (this.J != null && (this.g == 4 || this.g == 3)) {
         this.J.p.a(132, var1, null, null);
      }

      if (this.g != 0) {
         int var6 = var1 + 1;
         if (var6 > this.B) {
            this.B = var6;
         }
      }

   }

   @Override
   public void d(int var1, int var2) {
      this.y = this.ak.c;
      if (var2 < 4 && var1 != 169) {
         int var6;
         if (var1 < 54) {
            var6 = 26 + (var1 - 21 << 2) + var2;
         } else {
            var6 = 59 + (var1 - 54 << 2) + var2;
         }

         this.ak.a(var6);
      } else if (var2 >= 256) {
         this.ak.a(196).b(var1, var2);
      } else {
         this.ak.a(var1, var2);
      }

      if (this.J != null) {
         if (this.g == 4 || this.g == 3) {
            this.J.p.a(var1, var2, null, null);
         } else if (var1 == 169) {
            this.J.A = (short)(this.J.A | 64);
            this.J.a = (short)this.aj;
            this.f();
         } else {
            int var7 = this.aj + V[var1];
            if (var7 > this.z) {
               this.z = var7;
            }

            this.aj = var7;
         }
      }

      if (this.g != 0) {
         int var8;
         if (var1 != 22 && var1 != 24 && var1 != 55 && var1 != 57) {
            var8 = var2 + 1;
         } else {
            var8 = var2 + 2;
         }

         if (var8 > this.B) {
            this.B = var8;
         }
      }

      if (var1 >= 54 && this.g == 4 && this.E != null) {
         this.a(new Unknown246());
      }

   }

   @Override
   public Asm23 a(int var1, String var2, boolean var3) {
      if (var3) {
         if (this.l == null) {
            this.l = new Asm29[Unknown357.e(this.r).length];
         }

         return this.l[var1] = Asm29.a(this.t, var2, this.l[var1]);
      } else {
         if (this.x == null) {
            this.x = new Asm29[Unknown357.e(this.r).length];
         }

         return this.x[var1] = Asm29.a(this.t, var2, this.x[var1]);
      }
   }

   @Override
   public Asm23 a(String var1, boolean var2) {
      return var2 ? (this.Z = Asm29.a(this.t, var1, this.Z)) : (this.m = Asm29.a(this.t, var1, this.m));
   }

   @Override
   public void a(String var1, String var2, String var3, Unknown246 var4, Unknown246 var5, int var6) {
      if (var3 != null) {
         if (this.T == null) {
            this.T = new Unknown257();
         }

         ++this.A;
         this.T.c(var4.f).c(var5.f - var4.f).c(this.t.g(var1)).c(this.t.g(var3)).c(var6);
      }

      if (this.I == null) {
         this.I = new Unknown257();
      }

      ++this.L;
      this.I.c(var4.f).c(var5.f - var4.f).c(this.t.g(var1)).c(this.t.g(var2)).c(var6);
      if (this.g != 0) {
         char var10 = var2.charAt(0);
         int var11 = var6 + (var10 != 'J' && var10 != 'D' ? 1 : 2);
         if (var11 > this.B) {
            this.B = var11;
         }
      }

   }

   @Override
   public Asm23 d() {
      this.p = new Unknown257();
      return new Asm29(this.t, false, this.p, null);
   }

   @Override
   public void a(int var1, Unknown246 var2) {
      this.y = this.ak.c;
      int var6 = var1 >= 200 ? var1 - 33 : var1;
      boolean var7 = false;
      if ((var2.A & 4) != 0 && var2.f - this.ak.c < -32768) {
         if (var6 == 167) {
            this.ak.a(200);
         } else if (var6 == 168) {
            this.ak.a(201);
         } else {
            this.ak.a(var6 >= 198 ? var6 ^ 1 : (var6 + 1 ^ 1) - 1);
            this.ak.c(8);
            this.ak.a(220);
            this.M = true;
            var7 = true;
         }

         var2.a(this.ak, this.ak.c - 1, true);
      } else if (var6 != var1) {
         this.ak.a(var1);
         var2.a(this.ak, this.ak.c - 1, true);
      } else {
         this.ak.a(var6);
         var2.a(this.ak, this.ak.c - 1, false);
      }

      if (this.J != null) {
         Unknown246 var8 = null;
         if (this.g == 4) {
            this.J.p.a(var6, 0, null, null);
            Unknown246 var10000 = var2.b();
            var10000.A = (short)(var10000.A | 2);
            this.c(0, var2);
            if (var6 != 167) {
               var8 = new Unknown246();
            }
         } else if (this.g == 3) {
            this.J.p.a(var6, 0, null, null);
         } else if (this.g == 2) {
            this.aj += V[var6];
         } else if (var6 == 168) {
            if ((var2.A & 32) == 0) {
               var2.A = (short)(var2.A | 32);
               this.o = true;
            }

            this.J.A = (short)(this.J.A | 16);
            this.c(this.aj + 1, var2);
            var8 = new Unknown246();
         } else {
            this.aj += V[var6];
            this.c(this.aj, var2);
         }

         if (var8 != null) {
            if (var7) {
               var8.A = (short)(var8.A | 2);
            }

            this.a(var8);
         }

         if (var6 == 167) {
            this.f();
         }
      }

   }

   @Override
   public void a(Unknown246 var1, int[] var2, Unknown246[] var3) {
      this.y = this.ak.c;
      this.ak.a(171).a(null, 0, (4 - this.ak.c % 4) % 4);
      var1.a(this.ak, this.y, true);
      this.ak.d(var3.length);

      for(int var7 = 0; var7 < var3.length; ++var7) {
         this.ak.d(var2[var7]);
         var3[var7].a(this.ak, this.y, true);
      }

      this.a(var1, var3);
   }

   @Override
   public void a(Unknown246 var1, Unknown246 var2, Unknown246 var3, String var4) {
      Unknown326 var8 = new Unknown326(var1, var2, var3, var4 != null ? this.t.c(var4).index : 0, var4);
      if (this.E == null) {
         this.E = var8;
      } else {
         this.ab.b = var8;
      }

      this.ab = var8;
   }

   @Override
   public void a(Unknown246 var1) {
      this.M |= var1.a(this.ak.b, this.ak.c);
      if ((var1.A & 1) == 0) {
         if (this.g == 4) {
            if (this.J != null) {
               if (var1.f == this.J.f) {
                  this.J.A = (short)(this.J.A | var1.A & 2);
                  var1.p = this.J.p;
                  return;
               }

               this.c(0, var1);
            }

            if (this.O != null) {
               if (var1.f == this.O.f) {
                  this.O.A = (short)(this.O.A | var1.A & 2);
                  var1.p = this.O.p;
                  this.J = this.O;
                  return;
               }

               this.O.s = var1;
            }

            this.O = var1;
            this.J = var1;
            var1.p = new Asm32(var1);
         } else if (this.g == 3) {
            if (this.J == null) {
               this.J = var1;
            } else {
               this.J.p.w = var1;
            }
         } else if (this.g == 1) {
            if (this.J != null) {
               this.J.q = (short)this.z;
               this.c(this.aj, var1);
            }

            this.J = var1;
            this.aj = 0;
            this.z = 0;
            if (this.O != null) {
               this.O.s = var1;
            }

            this.O = var1;
         } else if (this.g == 2 && this.J == null) {
            this.J = var1;
         }

      }
   }

   public void f(int var1, int var2) {
      this.n[var1] = var2;
   }

   @Override
   public void a(int var1) {
      this.y = this.ak.c;
      this.ak.a(var1);
      if (this.J != null) {
         if (this.g != 4 && this.g != 3) {
            int var5 = this.aj + V[var1];
            if (var5 > this.z) {
               this.z = var5;
            }

            this.aj = var5;
         } else {
            this.J.p.a(var1, 0, null, null);
         }

         if (var1 >= 172 && var1 <= 177 || var1 == 191) {
            this.f();
         }
      }

   }

   @Override
   public Asm23 b(int var1, Unknown186 var2, String var3, boolean var4) {
      return var4 ? (this.aa = Asm29.a(this.t, var1, var2, var3, this.aa)) : (this.D = Asm29.a(this.t, var1, var2, var3, this.D));
   }

   private void b(Object var1) {
      if (var1 instanceof Integer) {
         this.G.a((Integer)var1);
      } else if (var1 instanceof String) {
         this.G.a(7).c(this.t.c((String)var1).index);
      } else {
         this.G.a(8).c(((Unknown246)var1).f);
      }

   }

   private void b() {
      int var4 = this.n[1];
      int var5 = this.n[2];
      if (this.t.d() < 50) {
         this.G.c(this.n[0]).c(var4);
         this.g(3, 3 + var4);
         this.G.c(var5);
         this.g(3 + var4, 3 + var4 + var5);
      } else {
         int var6 = this.ad == 0 ? this.n[0] : this.n[0] - this.K[0] - 1;
         int var7 = this.K[1];
         int var8 = var4 - var7;
         int var9 = 255;
         if (var5 == 0) {
            switch(var8) {
               case -3:
               case -2:
               case -1:
                  var9 = 248;
                  break;
               case 0:
                  var9 = var6 < 64 ? 0 : 251;
                  break;
               case 1:
               case 2:
               case 3:
                  var9 = 252;
            }
         } else if (var8 == 0 && var5 == 1) {
            var9 = var6 < 63 ? 64 : 247;
         }

         if (var9 != 255) {
            int var10 = 3;

            for(int var11 = 0; var11 < var7 && var11 < var4; ++var11) {
               if (this.n[var10] != this.K[var10]) {
                  var9 = 255;
                  break;
               }

               ++var10;
            }
         }

         switch(var9) {
            case 0:
               this.G.a(var6);
               break;
            case 64:
               this.G.a(64 + var6);
               this.g(3 + var4, 4 + var4);
               break;
            case 247:
               this.G.a(247).c(var6);
               this.g(3 + var4, 4 + var4);
               break;
            case 248:
               this.G.a(251 + var8).c(var6);
               break;
            case 251:
               this.G.a(251).c(var6);
               break;
            case 252:
               this.G.a(251 + var8).c(var6);
               this.g(3 + var7, 3 + var4);
               break;
            case 255:
            default:
               this.G.a(255).c(var6).c(var4);
               this.g(3, 3 + var4);
               this.G.c(var5);
               this.g(3 + var4, 3 + var4 + var5);
         }

      }
   }

   private void a(Unknown246 var1, Unknown246[] var2) {
      if (this.J != null) {
         if (this.g == 4) {
            this.J.p.a(171, 0, null, null);
            this.c(0, var1);
            Unknown246 var10000 = var1.b();
            var10000.A = (short)(var10000.A | 2);

            for(Unknown246 var13 : var2) {
               this.c(0, var13);
               var10000 = var13.b();
               var10000.A = (short)(var10000.A | 2);
            }
         } else if (this.g == 1) {
            --this.aj;
            this.c(this.aj, var1);

            for(Unknown246 var9 : var2) {
               this.c(this.aj, var9);
            }
         }

         this.f();
      }

   }

   @Override
   public void c() {
   }

   @Override
   public void b(int var1, String var2, String var3, String var4) {
      this.y = this.ak.c;
      Unknown154 var8 = this.t.a(var2, var3, var4);
      this.ak.b(var1, var8.index);
      if (this.J != null) {
         if (this.g != 4 && this.g != 3) {
            int var9;
            label77: {
               char var10 = var4.charAt(0);
               switch(var1) {
                  case 178:
                     var9 = this.aj + (var10 != 'D' && var10 != 'J' ? 1 : 2);
                     break label77;
                  case 179:
                     var9 = this.aj + (var10 != 'D' && var10 != 'J' ? -1 : -2);
                     break label77;
                  case 180:
                     var9 = this.aj + (var10 != 'D' && var10 != 'J' ? 0 : 1);
                     break label77;
                  case 181:
               }

               var9 = this.aj + (var10 != 'D' && var10 != 'J' ? -2 : -3);
            }

            if (var9 > this.z) {
               this.z = var9;
            }

            this.aj = var9;
         } else {
            this.J.p.a(var1, 0, var8, this.t);
         }
      }

   }

   @Override
   public void a(String var1, String var2, Unknown137 var3, Object[] var4) {
      this.y = this.ak.c;
      Unknown154 var8 = this.t.a(var1, var2, var3, var4);
      this.ak.b(186, var8.index);
      this.ak.c(0);
      if (this.J != null) {
         if (this.g != 4 && this.g != 3) {
            int var9 = var8.a();
            int var10 = (var9 & 3) - (var9 >> 2) + 1;
            int var11 = this.aj + var10;
            if (var11 > this.z) {
               this.z = var11;
            }

            this.aj = var11;
         } else {
            this.J.p.a(186, 0, var8, this.t);
         }
      }

   }

   private void f() {
      if (this.g == 4) {
         Unknown246 var4 = new Unknown246();
         var4.p = new Asm32(var4);
         var4.a(this.ak.b, this.ak.c);
         this.O.s = var4;
         this.O = var4;
         this.J = null;
      } else if (this.g == 1) {
         this.J.q = (short)this.z;
         this.J = null;
      }

   }

   @Override
   public void a(String var1, int var2) {
      if (this.f == null) {
         this.f = new Unknown257();
      }

      ++this.af;
      this.f.c(var1 == null ? 0 : this.t.g(var1)).c(var2);
   }

   @Override
   public void b(int var1, int var2) {
      if (this.g == 4) {
         this.d();
      } else if (this.g == 1) {
         this.h();
      } else if (this.g == 2) {
         this.ah = this.z;
      } else {
         this.ah = var1;
         this.B = var2;
      }

   }

   boolean a() {
      return this.ad > 0;
   }

   public void e(int var1, int var2) {
      this.u = var1 + 6;
      this.ag = var2 - 6;
   }

   final void a(pP var1) {
      var1.b(this.P);
      var1.b(this.w);
   }

   @Override
   public void a(int var1, String var2) {
      this.y = this.ak.c;
      Unknown154 var6 = this.t.c(var2);
      this.ak.b(var1, var6.index);
      if (this.J != null) {
         if (this.g == 4 || this.g == 3) {
            this.J.p.a(var1, this.y, var6, this.t);
         } else if (var1 == 187) {
            int var7 = this.aj + 1;
            if (var7 > this.z) {
               this.z = var7;
            }

            this.aj = var7;
         }
      }

   }

   public int a(int var1, int var2, int var3) {
      int var7 = 3 + var2 + var3;
      if (this.n == null || this.n.length < var7) {
         this.n = new int[var7];
      }

      this.n[0] = var1;
      this.n[1] = var2;
      this.n[2] = var3;
      return 3;
   }

   @Override
   public void c(int var1, int var2) {
      this.y = this.ak.c;
      if (var1 == 17) {
         this.ak.b(var1, var2);
      } else {
         this.ak.a(var1, var2);
      }

      if (this.J != null) {
         if (this.g == 4 || this.g == 3) {
            this.J.p.a(var1, var2, null, null);
         } else if (var1 != 188) {
            int var6 = this.aj + 1;
            if (var6 > this.z) {
               this.z = var6;
            }

            this.aj = var6;
         }
      }

   }

   private void g(int var1, int var2) {
      for(int var6 = var1; var6 < var2; ++var6) {
         Asm32.a(this.t, this.n[var6], this.G);
      }

   }
}
