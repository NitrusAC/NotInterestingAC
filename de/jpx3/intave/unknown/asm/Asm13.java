package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.b9;
import de.jpx3.intave.hM;
import de.jpx3.intave.iX;
import de.jpx3.intave.o_;
import de.jpx3.intave.unknown.Unknown372;
import java.util.ArrayList;
import java.util.List;
import org.ow2.asm.RandomASMClass1;

public class Asm13 extends Asm5 {
   public List l;
   public String d;
   public List c;
   public String k;
   public String f;
   public List j;
   public List i;
   public List h;
   public int e;
   public List g;

   @Override
   public void a() {
   }

   @Override
   public void a(String var1) {
      if (this.c == null) {
         this.c = new ArrayList(5);
      }

      this.c.add(var1);
   }

   public Asm13(String var1, int var2, String var3) {
      super(458752);
      if (this.getClass() != Asm13.class) {
         throw new IllegalStateException();
      } else {
         this.f = var1;
         this.e = var2;
         this.k = var3;
      }
   }

   @Override
   public void a(String var1, String[] var2) {
      if (this.j == null) {
         this.j = new ArrayList(5);
      }

      this.j.add(new o_(var1, Unknown372.a((Object[])var2)));
   }

   @Override
   public void b(String var1) {
      this.d = var1;
   }

   public Asm13(int var1, String var2, int var3, String var4, List var5, List var6, List var7, List var8, List var9) {
      super(var1);
      this.f = var2;
      this.e = var3;
      this.k = var4;
      this.l = var5;
      this.h = var6;
      this.g = var7;
      this.i = var8;
      this.j = var9;
   }

   @Override
   public void b(String var1, int var2, String[] var3) {
      if (this.h == null) {
         this.h = new ArrayList(5);
      }

      this.h.add(new iX(var1, var2, Unknown372.a((Object[])var3)));
   }

   @Override
   public void a(String var1, int var2, String var3) {
      if (this.l == null) {
         this.l = new ArrayList(5);
      }

      this.l.add(new b9(var1, var2, var3));
   }

   @Override
   public void a(String var1, int var2, String[] var3) {
      if (this.g == null) {
         this.g = new ArrayList(5);
      }

      this.g.add(new hM(var1, var2, Unknown372.a((Object[])var3)));
   }

   @Override
   public void c(String var1) {
      if (this.i == null) {
         this.i = new ArrayList(5);
      }

      this.i.add(var1);
   }

   public void a(RandomASMClass1 var1) {
      Asm5 var2 = var1.a(this.f, this.e, this.k);
      if (var2 != null) {
         if (this.d != null) {
            var2.b(this.d);
         }

         if (this.c != null) {
            int var3 = 0;

            for(int var4 = this.c.size(); var3 < var4; ++var3) {
               var2.a((String)this.c.get(var3));
            }
         }

         if (this.l != null) {
            int var5 = 0;

            for(int var10 = this.l.size(); var5 < var10; ++var5) {
               ((b9)this.l.get(var5)).a(var2);
            }
         }

         if (this.h != null) {
            int var6 = 0;

            for(int var11 = this.h.size(); var6 < var11; ++var6) {
               ((iX)this.h.get(var6)).a(var2);
            }
         }

         if (this.g != null) {
            int var7 = 0;

            for(int var12 = this.g.size(); var7 < var12; ++var7) {
               ((hM)this.g.get(var7)).a(var2);
            }
         }

         if (this.i != null) {
            int var8 = 0;

            for(int var13 = this.i.size(); var8 < var13; ++var8) {
               var2.c((String)this.i.get(var8));
            }
         }

         if (this.j != null) {
            int var9 = 0;

            for(int var14 = this.j.size(); var9 < var14; ++var9) {
               ((o_)this.j.get(var9)).a(var2);
            }
         }

      }
   }
}
