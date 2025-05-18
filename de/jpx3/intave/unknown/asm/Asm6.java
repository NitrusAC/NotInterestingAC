package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown246;
import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.Unknown372;
import java.util.List;
import java.util.Map;

public class Asm6 extends Asm1 {
   public Asm19 z;
   public List y;
   public List A;

   @Override
   public int d() {
      return 12;
   }

   @Override
   public void accept(Unknown338 var1) {
      int[] var5 = new int[this.y.size()];
      int var6 = 0;

      for(int var7 = var5.length; var6 < var7; ++var6) {
         var5[var6] = this.y.get(var6);
      }

      Unknown246[] var9 = new Unknown246[this.A.size()];
      int var10 = 0;

      for(int var8 = var9.length; var10 < var8; ++var10) {
         var9[var10] = ((Asm19)this.A.get(var10)).a();
      }

      var1.a(this.z.a(), var5, var9);
      this.visit(var1);
   }

   @Override
   public Asm1 a(Map var1) {
      Asm6 var2 = new Asm6(a(this.z, var1), null, a(this.A, var1));
      var2.y.addAll(this.y);
      return var2.a(this);
   }

   public Asm6(Asm19 var1, int[] var2, Asm19[] var3) {
      super(171);
      this.z = var1;
      this.y = Unknown372.a(var2);
      this.A = Unknown372.a((Object[])var3);
   }
}
