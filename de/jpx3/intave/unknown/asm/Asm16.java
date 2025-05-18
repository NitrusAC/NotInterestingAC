package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.Unknown372;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Asm16 extends Asm1 {
   public List y;
   public int A;
   public List z;

   public Asm16(int var1, int var2, Object[] var3, int var4, Object[] var5) {
      super(-1);
      this.A = var1;
      switch(var1) {
         case -1:
         case 0:
            this.z = Unknown372.a(var2, var3);
            this.y = Unknown372.a(var4, var5);
            break;
         case 1:
            this.z = Unknown372.a(var2, var3);
            break;
         case 2:
            this.z = Unknown372.a(var2);
         case 3:
            break;
         case 4:
            this.y = Unknown372.a(1, var5);
            break;
         default:
            throw new IllegalArgumentException();
      }

   }

   @Override
   public void accept(Unknown338 var1) {
      switch(this.A) {
         case -1:
         case 0:
            var1.a(this.A, this.z.size(), a(this.z), this.y.size(), a(this.y));
            break;
         case 1:
            var1.a(this.A, this.z.size(), a(this.z), 0, null);
            break;
         case 2:
            var1.a(this.A, this.z.size(), null, 0, null);
            break;
         case 3:
            var1.a(this.A, 0, null, 0, null);
            break;
         case 4:
            var1.a(this.A, 0, null, 1, a(this.y));
            break;
         default:
            throw new IllegalArgumentException();
      }

   }

   @Override
   public Asm1 a(Map var1) {
      Asm16 var5 = new Asm16();
      var5.A = this.A;
      if (this.z != null) {
         var5.z = new ArrayList();
         int var6 = 0;

         for(int var7 = this.z.size(); var6 < var7; ++var6) {
            Object var8 = this.z.get(var6);
            if (var8 instanceof Asm19) {
               var8 = var1.get(var8);
            }

            var5.z.add(var8);
         }
      }

      if (this.y != null) {
         var5.y = new ArrayList();
         int var9 = 0;

         for(int var10 = this.y.size(); var9 < var10; ++var9) {
            Object var11 = this.y.get(var9);
            if (var11 instanceof Asm19) {
               var11 = var1.get(var11);
            }

            var5.y.add(var11);
         }
      }

      return var5;
   }

   private static Object[] a(List var0) {
      Object[] var4 = new Object[var0.size()];
      int var5 = 0;

      for(int var6 = var4.length; var5 < var6; ++var5) {
         Object var7 = var0.get(var5);
         if (var7 instanceof Asm19) {
            var7 = ((Asm19)var7).a();
         }

         var4[var5] = var7;
      }

      return var4;
   }

   private Asm16() {
      super(-1);
   }

   @Override
   public int d() {
      return 14;
   }
}
