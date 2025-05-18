package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown246;
import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.Unknown372;
import java.util.List;
import java.util.Map;

public class Asm17 extends Asm1 {
   public int y;
   public Asm19 z;
   public List A;
   public int B;

   @Override
   public int d() {
      return 11;
   }

   @Override
   public void accept(Unknown338 var1) {
      Unknown246[] var5 = new Unknown246[this.A.size()];
      int var6 = 0;

      for(int var7 = var5.length; var6 < var7; ++var6) {
         var5[var6] = ((Asm19)this.A.get(var6)).a();
      }

      var1.a(this.y, this.B, this.z.a(), var5);
      this.visit(var1);
   }

   @Override
   public Asm1 a(Map var1) {
      return new Asm17(this.y, this.B, a(this.z, var1), a(this.A, var1)).a(this);
   }

   public Asm17(int var1, int var2, Asm19 var3, Asm19[] var4) {
      super(170);
      this.y = var1;
      this.B = var2;
      this.z = var3;
      this.A = Unknown372.a((Object[])var4);
   }
}
