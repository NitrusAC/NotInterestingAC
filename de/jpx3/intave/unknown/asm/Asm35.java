package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown201;
import de.jpx3.intave.unknown.Unknown336;
import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.Unknown35;
import de.jpx3.intave.unknown.Unknown372;
import de.jpx3.intave.unknown.Unknown4;
import de.jpx3.intave.unknown.Unknown48;
import java.util.ArrayList;
import java.util.List;
import org.ow2.asm.RandomASMClass1;

public class Asm35 extends RandomASMClass1 {
   public List v = new ArrayList();
   public String g;
   public List j = new ArrayList();
   public List o;
   public String e;
   public List y;
   public int f;
   public String u;
   public String m;
   public List A;
   public List n = new ArrayList();
   public String s;
   public String w;
   public List d;
   public List x = new ArrayList();
   public List i;
   @Deprecated
   public List h;
   public Asm13 t;
   public String l;
   public List q;
   public String z;
   public int r;
   public String p;
   @Deprecated
   public List k;

   public void a(int var1) {
      if (var1 != 17301504 && this.k != null) {
         throw new Unknown4();
      } else if (var1 != 17301504 && this.h != null) {
         throw new Unknown4();
      } else if (var1 >= 458752 || this.g == null && this.q == null) {
         if (var1 < 393216 && this.t != null) {
            throw new Unknown4();
         } else {
            if (var1 < 327680) {
               if (this.d != null && !this.d.isEmpty()) {
                  throw new Unknown4();
               }

               if (this.o != null && !this.o.isEmpty()) {
                  throw new Unknown4();
               }
            }

            if (this.i != null) {
               for(int var6 = this.i.size() - 1; var6 >= 0; --var6) {
                  ((Unknown48)this.i.get(var6)).a(var1);
               }
            }

            if (this.y != null) {
               for(int var7 = this.y.size() - 1; var7 >= 0; --var7) {
                  ((Unknown48)this.y.get(var7)).a(var1);
               }
            }

            if (this.d != null) {
               for(int var8 = this.d.size() - 1; var8 >= 0; --var8) {
                  ((Asm22)this.d.get(var8)).a(var1);
               }
            }

            if (this.o != null) {
               for(int var9 = this.o.size() - 1; var9 >= 0; --var9) {
                  ((Asm22)this.o.get(var9)).a(var1);
               }
            }

            if (this.h != null) {
               for(int var10 = this.h.size() - 1; var10 >= 0; --var10) {
                  ((Asm10)this.h.get(var10)).a(var1);
               }
            }

            for(int var11 = this.n.size() - 1; var11 >= 0; --var11) {
               ((Asm27)this.n.get(var11)).a(var1);
            }

            for(int var12 = this.x.size() - 1; var12 >= 0; --var12) {
               ((Unknown336)this.x.get(var12)).b(var1);
            }

         }
      } else {
         throw new Unknown4();
      }
   }

   @Override
   public void c(String var1) {
      this.q = Unknown372.a(this.q, var1);
   }

   @Override
   public Asm23 a(String var1, boolean var2) {
      Unknown48 var6 = new Unknown48(var1);
      if (var2) {
         this.i = Unknown372.a(this.i, var6);
      } else {
         this.y = Unknown372.a(this.y, var6);
      }

      return var6;
   }

   @Override
   public void a(String var1, String var2, String var3) {
      this.s = var1;
      this.z = var2;
      this.u = var3;
   }

   @Override
   public Unknown338 a(int var1, String var2, String var3, String var4, String[] var5) {
      Unknown336 var6 = new Unknown336(var1, var2, var3, var4, var5);
      this.x.add(var6);
      return var6;
   }

   public Asm35(int var1) {
      super(var1);
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      Asm22 var8 = new Asm22(var1, var2, var3);
      if (var4) {
         this.d = Unknown372.a(this.d, var8);
      } else {
         this.o = Unknown372.a(this.o, var8);
      }

      return var8;
   }

   @Override
   public void a(String var1, String var2, String var3, int var4) {
      Unknown201 var5 = new Unknown201(var1, var2, var3, var4);
      this.j.add(var5);
   }

   private static void b(RandomASMClass1 var0, Asm10 var1) {
      var1.a(var0);
   }

   @Override
   public void a() {
   }

   public void a(RandomASMClass1 var1) {
      String[] var2 = new String[this.v.size()];
      this.v.toArray(var2);
      var1.a(this.r, this.f, this.m, this.p, this.e, var2);
      if (this.l != null || this.w != null) {
         var1.a(this.l, this.w);
      }

      if (this.t != null) {
         this.t.a(var1);
      }

      if (this.g != null) {
         var1.a(this.g);
      }

      if (this.s != null) {
         var1.a(this.s, this.z, this.u);
      }

      if (this.i != null) {
         for(Unknown48 var4 : this.i) {
            var4.a(var1.a(var4.e, true));
         }
      }

      if (this.y != null) {
         for(Unknown48 var12 : this.y) {
            var12.a(var1.a(var12.e, false));
         }
      }

      if (this.d != null) {
         for(Asm22 var13 : this.d) {
            var13.a(var1.a(var13.g, var13.f, var13.e, true));
         }
      }

      if (this.o != null) {
         for(Asm22 var14 : this.o) {
            var14.a(var1.a(var14.g, var14.f, var14.e, false));
         }
      }

      if (this.A != null) {
         this.A.forEach(var1::a);
      }

      if (this.q != null) {
         for(String var15 : this.q) {
            var1.c(var15);
         }
      }

      if (this.k != null) {
         this.k.forEach(var1::b);
      }

      int var9 = 0;

      for(int var16 = this.j.size(); var9 < var16; ++var9) {
         ((Unknown201)this.j.get(var9)).a(var1);
      }

      if (this.h != null) {
         this.h.forEach(Asm35::b);
      }

      var9 = 0;

      for(int var17 = this.n.size(); var9 < var17; ++var9) {
         ((Asm27)this.n.get(var9)).a(var1);
      }

      var9 = 0;

      for(int var18 = this.x.size(); var9 < var18; ++var9) {
         ((Unknown336)this.x.get(var9)).a(var1);
      }

      var1.a();
   }

   @Override
   public void a(int var1, int var2, String var3, String var4, String var5, String[] var6) {
      this.r = var1;
      this.f = var2;
      this.m = var3;
      this.p = var4;
      this.e = var5;
      this.v = Unknown372.a((Object[])var6);
   }

   @Override
   public void b(String var1) {
      this.k = Unknown372.a(this.k, var1);
   }

   @Override
   public void a(String var1) {
      this.g = var1;
   }

   @Override
   public Asm14 a(int var1, String var2, String var3, String var4) {
      Asm10 var5 = new Asm10(var1, var2, var3, var4);
      this.h = Unknown372.a(this.h, var5);
      return var5;
   }

   @Override
   public void a(String var1, String var2) {
      this.l = var1;
      this.w = var2;
   }

   @Override
   public Asm26 a(int var1, String var2, String var3, String var4, Object var5) {
      Asm27 var6 = new Asm27(var1, var2, var3, var4, var5);
      this.n.add(var6);
      return var6;
   }

   @Override
   public void a(Unknown35 var1) {
      this.A = Unknown372.a(this.A, var1);
   }

   @Override
   public Asm5 a(String var1, int var2, String var3) {
      this.t = new Asm13(var1, var2, var3);
      return this.t;
   }

   public Asm35() {
      this(458752);
      if (this.getClass() != Asm35.class) {
         throw new IllegalStateException();
      }
   }
}
