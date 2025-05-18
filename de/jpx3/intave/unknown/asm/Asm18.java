package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm18 extends Asm1 {
   public Asm19 z;
   public int y;

   @Override
   public Asm1 a(Map var1) {
      return new Asm18(this.y, a(this.z, var1));
   }

   public Asm18(int var1, Asm19 var2) {
      super(-1);
      this.y = var1;
      this.z = var2;
   }

   @Override
   public int d() {
      return 15;
   }

   @Override
   public void accept(Unknown338 var1) {
      var1.b(this.y, this.z.a());
   }
}
