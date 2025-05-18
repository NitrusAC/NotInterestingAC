package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown35;
import de.jpx3.intave.unknown.Unknown372;
import de.jpx3.intave.unknown.Unknown4;
import de.jpx3.intave.unknown.Unknown48;
import java.util.List;
import org.ow2.asm.RandomASMClass1;

@Deprecated
public class Asm10 extends Asm14 {
   public List k;
   public String c;
   public List g;
   public int d;
   public List h;
   public List j;
   public String e;
   public String f;
   public List i;

   public void a(RandomASMClass1 var1) {
      Asm14 var5 = var1.a(this.d, this.c, this.e, this.f);
      if (var5 != null) {
         if (this.j != null) {
            int var6 = 0;

            for(int var7 = this.j.size(); var6 < var7; ++var6) {
               Unknown48 var8 = (Unknown48)this.j.get(var6);
               var8.a(var5.a(var8.e, true));
            }
         }

         if (this.g != null) {
            int var9 = 0;

            for(int var13 = this.g.size(); var9 < var13; ++var9) {
               Unknown48 var17 = (Unknown48)this.g.get(var9);
               var17.a(var5.a(var17.e, false));
            }
         }

         if (this.k != null) {
            int var10 = 0;

            for(int var14 = this.k.size(); var10 < var14; ++var10) {
               Asm22 var18 = (Asm22)this.k.get(var10);
               var18.a(var5.a(var18.g, var18.f, var18.e, true));
            }
         }

         if (this.h != null) {
            int var11 = 0;

            for(int var15 = this.h.size(); var11 < var15; ++var11) {
               Asm22 var19 = (Asm22)this.h.get(var11);
               var19.a(var5.a(var19.g, var19.f, var19.e, false));
            }
         }

         if (this.i != null) {
            int var12 = 0;

            for(int var16 = this.i.size(); var12 < var16; ++var12) {
               var5.a((Unknown35)this.i.get(var12));
            }
         }

         var5.b();
      }
   }

   public void a(int var1) {
      if (var1 != 17301504) {
         throw new Unknown4();
      }
   }

   @Override
   public void b() {
   }

   @Deprecated
   public Asm10(int var1, int var2, String var3, String var4, String var5) {
      super(var1);
      this.d = var2;
      this.c = var3;
      this.e = var4;
      this.f = var5;
   }

   @Override
   public void a(Unknown35 var1) {
      this.i = Unknown372.a(this.i, var1);
   }

   @Override
   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      Asm22 var8 = new Asm22(var1, var2, var3);
      if (var4) {
         this.k = Unknown372.a(this.k, var8);
      } else {
         this.h = Unknown372.a(this.h, var8);
      }

      return var8;
   }

   @Deprecated
   public Asm10(int var1, String var2, String var3, String var4) {
      this(458752, var1, var2, var3, var4);
      if (this.getClass() != Asm10.class) {
         throw new IllegalStateException();
      }
   }

   @Override
   public Asm23 a(String var1, boolean var2) {
      Unknown48 var6 = new Unknown48(var1);
      if (var2) {
         this.j = Unknown372.a(this.j, var6);
      } else {
         this.g = Unknown372.a(this.g, var6);
      }

      return var6;
   }
}
