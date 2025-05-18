package de.jpx3.intave.unknown;

import de.jpx3.intave.unknown.asm.Asm1;
import de.jpx3.intave.unknown.asm.Asm19;
import java.util.Map;

public class Unknown32 extends Asm1 {
   public Asm19 y;

   @Override
   public int d() {
      return 7;
   }

   public Unknown32(int var1, Asm19 var2) {
      super(var1);
      this.y = var2;
   }

   @Override
   public Asm1 a(Map var1) {
      return new Unknown32(this.w, a(this.y, var1)).a(this);
   }

   @Override
   public void accept(Unknown338 var1) {
      var1.a(this.w, this.y.a());
      this.visit(var1);
   }

   public void a(int var1) {
      this.w = var1;
   }
}
