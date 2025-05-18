package de.jpx3.intave.unknown;

import de.jpx3.intave.aA;
import de.jpx3.intave.b7;
import de.jpx3.intave.jV;
import de.jpx3.intave.nC;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.unknown.asm.Asm1;
import de.jpx3.intave.unknown.asm.Asm11;
import de.jpx3.intave.unknown.asm.Asm16;
import de.jpx3.intave.unknown.asm.Asm17;
import de.jpx3.intave.unknown.asm.Asm18;
import de.jpx3.intave.unknown.asm.Asm19;
import de.jpx3.intave.unknown.asm.Asm2;
import de.jpx3.intave.unknown.asm.Asm20;
import de.jpx3.intave.unknown.asm.Asm21;
import de.jpx3.intave.unknown.asm.Asm22;
import de.jpx3.intave.unknown.asm.Asm23;
import de.jpx3.intave.unknown.asm.Asm25;
import de.jpx3.intave.unknown.asm.Asm28;
import de.jpx3.intave.unknown.asm.Asm3;
import de.jpx3.intave.unknown.asm.Asm4;
import de.jpx3.intave.unknown.asm.Asm6;
import de.jpx3.intave.unknown.asm.Asm7;
import de.jpx3.intave.unknown.asm.Asm8;
import de.jpx3.intave.unknown.asm.Asm9;
import java.util.ArrayList;
import java.util.List;
import org.ow2.asm.MethodInsnNode;
import org.ow2.asm.RandomASMClass1;

public class Unknown336 extends Unknown338 {
   public int w;
   public List y;
   public List[] s;
   public Object v;
   private static final String jb;
   public int p;
   public List n;
   public List l;
   public Asm28 x;
   public String C;
   private boolean r;
   public List o;
   public int k;
   public int e;
   public List i;
   public boolean j = false;
   public List u;
   public String t;
   public List q;
   public int z;
   public List f;
   public List A;
   public String B;
   public List[] h;
   public List m;
   public List g;

   @Override
   public void a(Unknown246 var1, int[] var2, Unknown246[] var3) {
      this.x.a(new Asm6(this.a(var1), var2, this.a(var3)));
   }

   @Override
   public void a(int var1, int var2) {
      this.x.a(new Asm8(var1, var2));
   }

   @Override
   public void a(int var1) {
      this.x.a(new Asm9(var1));
   }

   @Override
   public void b(String var1, int var2) {
      this.x.a(new Asm11(var1, var2));
   }

   public Unknown336(int var1, int var2, String var3, String var4, String var5, String[] var6) {
      super(var1);
      this.z = var2;
      this.t = var3;
      this.C = var4;
      this.B = var5;
      this.i = Unknown372.a((Object[])var6);
      if ((var2 & 1024) == 0) {
         this.n = new ArrayList(5);
      }

      this.u = new ArrayList();
      this.x = new Asm28();
   }

   public Unknown336(int var1, String var2, String var3, String var4, String[] var5) {
      this(458752, var1, var2, var3, var4, var5);
      if (this.getClass() != Unknown336.class) {
         throw new IllegalStateException();
      }
   }

   public Unknown336() {
      this(458752);
      if (this.getClass() != Unknown336.class) {
         throw new IllegalStateException();
      }
   }

   @Override
   public void a(String var1, String var2, Unknown137 var3, Object[] var4) {
      this.x.a(new Asm2(var1, var2, var3, var4));
   }

   public Unknown336(int var1) {
      super(var1);
      this.x = new Asm28();
   }

   @Override
   public void a(Unknown246 var1) {
      this.x.a(this.a(var1));
   }

   @Override
   public void b(int var1, int var2) {
      this.k = var1;
      this.w = var2;
   }

   @Override
   public void d(int var1, int var2) {
      this.x.a(new Asm20(var1, var2));
   }

   @Override
   public Asm23 a(int var1, String var2, boolean var3) {
      Unknown48 var7 = new Unknown48(var2);
      if (var3) {
         if (this.s == null) {
            int var8 = Unknown357.e(this.C).length;
            this.s = new List[var8];
         }

         this.s[var1] = Unknown372.a(this.s[var1], var7);
      } else {
         if (this.h == null) {
            int var9 = Unknown357.e(this.C).length;
            this.h = new List[var9];
         }

         this.h[var1] = Unknown372.a(this.h[var1], var7);
      }

      return var7;
   }

   @Override
   public void a(int var1, boolean var2) {
      if (var2) {
         this.e = var1;
      } else {
         this.p = var1;
      }

   }

   @Override
   public void b(int var1, String var2, String var3, String var4) {
      this.x.a(new Asm4(var1, var2, var3, var4));
   }

   @Override
   public Asm23 d() {
      return new Unknown48(new aA(this, 0));
   }

   @Override
   public void b(int var1, Unknown246 var2) {
      this.x.a(new Asm18(var1, this.a(var2)));
   }

   public void a(Unknown338 var1) {
      if (this.y != null) {
         int var2 = 0;

         for(int var3 = this.y.size(); var2 < var3; ++var2) {
            ((nC)this.y.get(var2)).a(var1);
         }
      }

      if (this.v != null) {
         Asm23 var7 = var1.d();
         Unknown48.a(var7, null, this.v);
         if (var7 != null) {
            var7.c();
         }
      }

      if (this.q != null) {
         for(Unknown48 var19 : this.q) {
            var19.a(var1.a(var19.e, true));
         }
      }

      if (this.o != null) {
         for(Unknown48 var20 : this.o) {
            var20.a(var1.a(var20.e, false));
         }
      }

      if (this.f != null) {
         for(Asm22 var21 : this.f) {
            var21.a(var1.c(var21.g, var21.f, var21.e, true));
         }
      }

      if (this.m != null) {
         for(Asm22 var22 : this.m) {
            var22.a(var1.c(var22.g, var22.f, var22.e, false));
         }
      }

      if (this.e > 0) {
         var1.a(this.e, true);
      }

      if (this.s != null) {
         int var12 = 0;

         for(int var23 = this.s.length; var12 < var23; ++var12) {
            List var4 = this.s[var12];
            if (var4 != null) {
               for(Unknown48 var6 : var4) {
                  var6.a(var1.a(var12, var6.e, true));
               }
            }
         }
      }

      if (this.p > 0) {
         var1.a(this.p, false);
      }

      if (this.h != null) {
         int var13 = 0;

         for(int var24 = this.h.length; var13 < var24; ++var13) {
            List var30 = this.h[var13];
            if (var30 != null) {
               for(Unknown48 var32 : var30) {
                  var32.a(var1.a(var13, var32.e, false));
               }
            }
         }
      }

      if (this.r) {
         this.x.b();
      }

      if (this.g != null) {
         for(Unknown35 var25 : this.g) {
            var1.a(var25);
         }
      }

      if (this.x.g() > 0) {
         var1.c();
         if (this.u != null) {
            int var15 = 0;

            for(int var26 = this.u.size(); var15 < var26; ++var15) {
               ((Asm25)this.u.get(var15)).a(var15);
               ((Asm25)this.u.get(var15)).a(var1);
            }
         }

         this.x.a(var1);
         if (this.n != null) {
            for(jV var27 : this.n) {
               var27.a(var1);
            }
         }

         if (this.A != null) {
            for(Asm21 var28 : this.A) {
               var28.a(var1, true);
            }
         }

         if (this.l != null) {
            for(Asm21 var29 : this.l) {
               var29.a(var1, false);
            }
         }

         var1.b(this.k, this.w);
         this.r = true;
      }

      var1.e();
   }

   @Override
   public void a(String var1, String var2, String var3, Unknown246 var4, Unknown246 var5, int var6) {
      jV var7 = new jV(var1, var2, var3, this.a(var4), this.a(var5), var6);
      this.n = Unknown372.a(this.n, var7);
   }

   @Override
   public void c() {
   }

   private Object[] a(Object[] var1) {
      Object[] var5 = new Object[var1.length];
      int var6 = 0;

      for(int var7 = var1.length; var6 < var7; ++var6) {
         Object var8 = var1[var6];
         if (var8 instanceof Unknown246) {
            var8 = this.a((Unknown246)var8);
         }

         var5[var6] = var8;
      }

      return var5;
   }

   @Override
   public void a(int var1, int var2, Object[] var3, int var4, Object[] var5) {
      this.x.a(new Asm16(var1, var2, var3 == null ? null : this.a(var3), var4, var5 == null ? null : this.a(var5)));
   }

   @Override
   public void e() {
   }

   public void a(RandomASMClass1 var1) {
      String[] var4 = this.i == null ? null : (String[])this.i.toArray(new String[0]);
      Unknown338 var5 = var1.a(this.z, this.t, this.C, this.B, var4);
      if (var5 != null) {
         try {
            this.a(var5);
         } catch (Exception var7) {
            Logger.getLogger().print("Exception in method " + this.t + " " + this.C);
            var7.printStackTrace();
         }
      }

   }

   public void b(int var1) {
      if (var1 == 262144) {
         if (this.y != null && !this.y.isEmpty()) {
            throw new Unknown4();
         }

         if (this.f != null && !this.f.isEmpty()) {
            throw new Unknown4();
         }

         if (this.m != null && !this.m.isEmpty()) {
            throw new Unknown4();
         }

         if (this.u != null) {
            for(int var5 = this.u.size() - 1; var5 >= 0; --var5) {
               Asm25 var6 = (Asm25)this.u.get(var5);
               if (var6.a != null && !var6.a.isEmpty()) {
                  throw new Unknown4();
               }

               if (var6.f != null && !var6.f.isEmpty()) {
                  throw new Unknown4();
               }
            }
         }

         for(int var8 = this.x.g() - 1; var8 >= 0; --var8) {
            Asm1 var10 = this.x.a(var8);
            if (var10.b != null && !var10.b.isEmpty()) {
               throw new Unknown4();
            }

            if (var10.c != null && !var10.c.isEmpty()) {
               throw new Unknown4();
            }

            if (var10 instanceof MethodInsnNode) {
               boolean var7 = ((MethodInsnNode)var10).itf;
               if (var7 != (var10.w == 185)) {
                  throw new Unknown4();
               }
            } else if (var10 instanceof Asm3) {
               Object var12 = ((Asm3)var10).y;
               if (var12 instanceof Unknown137 || var12 instanceof Unknown357 && ((Unknown357)var12).k() == 11) {
                  throw new Unknown4();
               }
            }
         }

         if (this.A != null && !this.A.isEmpty()) {
            throw new Unknown4();
         }

         if (this.l != null && !this.l.isEmpty()) {
            throw new Unknown4();
         }
      }

      if (var1 < 458752) {
         for(int var9 = this.x.g() - 1; var9 >= 0; --var9) {
            Asm1 var11 = this.x.a(var9);
            if (var11 instanceof Asm3) {
               Object var13 = ((Asm3)var11).y;
               if (var13 instanceof b7) {
                  throw new Unknown4();
               }
            }
         }
      }

   }

   @Override
   public void c(int var1, int var2) {
      this.x.a(new Asm7(var1, var2));
   }

   @Override
   public void a(Object var1) {
      this.x.a(new Asm3(var1));
   }

   @Override
   public void a(Unknown246 var1, Unknown246 var2, Unknown246 var3, String var4) {
      Asm25 var5 = new Asm25(this.a(var1), this.a(var2), this.a(var3), var4);
      this.u = Unknown372.a(this.u, var5);
   }

   protected Asm19 a(Unknown246 var1) {
      if (!(var1.o instanceof Asm19)) {
         var1.o = new Asm19();
      }

      return (Asm19)var1.o;
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      Asm1 var8 = this.x.d();

      while(var8.g() == -1) {
         var8 = var8.c();
      }

      Asm22 var9 = new Asm22(var1, var2, var3);
      if (var4) {
         var8.b = Unknown372.a(var8.b, var9);
      } else {
         var8.c = Unknown372.a(var8.c, var9);
      }

      return var9;
   }

   @Override
   public void visit(int var1, String var2, String var3, String var4, boolean var5) {
      if (this.a < 327680 && (var1 & 256) == 0) {
         super.visit(var1, var2, var3, var4, var5);
      } else {
         int var9 = var1 & -257;
         this.x.a(new MethodInsnNode(var9, var2, var3, var4, var5));
      }
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, Unknown246[] var3, Unknown246[] var4, int[] var5, String var6, boolean var7) {
      Asm21 var11 = new Asm21(var1, var2, this.a(var3), this.a(var4), var5, var6);
      if (var7) {
         this.A = Unknown372.a(this.A, var11);
      } else {
         this.l = Unknown372.a(this.l, var11);
      }

      return var11;
   }

   @Override
   public void a(int var1, String var2) {
      this.x.a(new Unknown30(var1, var2));
   }

   @Override
   public Asm23 a(String var1, boolean var2) {
      Unknown48 var6 = new Unknown48(var1);
      if (var2) {
         this.q = Unknown372.a(this.q, var6);
      } else {
         this.o = Unknown372.a(this.o, var6);
      }

      return var6;
   }

   @Override
   public void a(Unknown35 var1) {
      this.g = Unknown372.a(this.g, var1);
   }

   @Override
   public Asm23 c(int var1, Unknown186 var2, String var3, boolean var4) {
      Asm22 var8 = new Asm22(var1, var2, var3);
      if (var4) {
         this.f = Unknown372.a(this.f, var8);
      } else {
         this.m = Unknown372.a(this.m, var8);
      }

      return var8;
   }

   @Override
   public void a(String var1, int var2) {
      if (this.y == null) {
         this.y = new ArrayList(5);
      }

      this.y.add(new nC(var1, var2));
   }

   @Override
   public void a(int var1, Unknown246 var2) {
      this.x.a(new Unknown32(var1, this.a(var2)));
   }

   @Override
   public void a(int var1, int var2, Unknown246 var3, Unknown246[] var4) {
      this.x.a(new Asm17(var1, var2, this.a(var3), this.a(var4)));
   }

   @Override
   public Asm23 b(int var1, Unknown186 var2, String var3, boolean var4) {
      Asm25 var8 = (Asm25)this.u.get((var1 & 16776960) >> 8);
      Asm22 var9 = new Asm22(var1, var2, var3);
      if (var4) {
         var8.a = Unknown372.a(var8.a, var9);
      } else {
         var8.f = Unknown372.a(var8.f, var9);
      }

      return var9;
   }

   private Asm19[] a(Unknown246[] var1) {
      Asm19[] var5 = new Asm19[var1.length];
      int var6 = 0;

      for(int var7 = var1.length; var6 < var7; ++var6) {
         var5[var6] = this.a(var1[var6]);
      }

      return var5;
   }
}
