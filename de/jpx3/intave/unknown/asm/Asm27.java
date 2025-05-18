package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown35;
import de.jpx3.intave.unknown.Unknown372;
import de.jpx3.intave.unknown.Unknown4;
import de.jpx3.intave.unknown.Unknown48;
import java.util.List;
import org.ow2.asm.RandomASMClass1;

public class Asm27 extends Asm26 {
   public Object d;
   public int j;
   public List c;
   public String f;
   public String h;
   public List e;
   public String g;
   public List i;
   public List l;
   public List k;

   public Asm27(int var1, int var2, String var3, String var4, String var5, Object var6) {
      super(var1);
      this.j = var2;
      this.g = var3;
      this.f = var4;
      this.h = var5;
      this.d = var6;
   }

   public Asm27(int var1, String var2, String var3, String var4, Object var5) {
      this(458752, var1, var2, var3, var4, var5);
      if (this.getClass() != Asm27.class) {
         throw new IllegalStateException();
      }
   }

   @Override
   public void a(Unknown35 var1) {
      this.c = Unknown372.a(this.c, var1);
   }

   @Override
   public void a() {
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      Asm22 var8 = new Asm22(var1, var2, var3);
      if (var4) {
         this.k = Unknown372.a(this.k, var8);
      } else {
         this.e = Unknown372.a(this.e, var8);
      }

      return var8;
   }

   @Override
   public Asm23 a(String var1, boolean var2) {
      Unknown48 var6 = new Unknown48(var1);
      if (var2) {
         this.i = Unknown372.a(this.i, var6);
      } else {
         this.l = Unknown372.a(this.l, var6);
      }

      return var6;
   }

   public void a(RandomASMClass1 var1) {
      Asm26 var2 = var1.a(this.j, this.g, this.f, this.h, this.d);
      if (var2 != null) {
         if (this.i != null) {
            int var3 = 0;

            for(int var4 = this.i.size(); var3 < var4; ++var3) {
               Unknown48 var5 = (Unknown48)this.i.get(var3);
               var5.a(var2.a(var5.e, true));
            }
         }

         if (this.l != null) {
            int var6 = 0;

            for(int var10 = this.l.size(); var6 < var10; ++var6) {
               Unknown48 var14 = (Unknown48)this.l.get(var6);
               var14.a(var2.a(var14.e, false));
            }
         }

         if (this.k != null) {
            int var7 = 0;

            for(int var11 = this.k.size(); var7 < var11; ++var7) {
               Asm22 var15 = (Asm22)this.k.get(var7);
               var15.a(var2.a(var15.g, var15.f, var15.e, true));
            }
         }

         if (this.e != null) {
            int var8 = 0;

            for(int var12 = this.e.size(); var8 < var12; ++var8) {
               Asm22 var16 = (Asm22)this.e.get(var8);
               var16.a(var2.a(var16.g, var16.f, var16.e, false));
            }
         }

         if (this.c != null) {
            int var9 = 0;

            for(int var13 = this.c.size(); var9 < var13; ++var9) {
               var2.a((Unknown35)this.c.get(var9));
            }
         }

         var2.a();
      }
   }

   public void a(int var1) {
      if (var1 == 262144) {
         if (this.k != null && !this.k.isEmpty()) {
            throw new Unknown4();
         }

         if (this.e != null && !this.e.isEmpty()) {
            throw new Unknown4();
         }
      }

   }
}
