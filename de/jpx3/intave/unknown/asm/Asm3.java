package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm3 extends Asm1 {
   public Object y;

   @Override
   public int d() {
      return 9;
   }

   public Asm3(Object var1) {
      super(18);
      this.y = var1;
   }

   @Override
   public void accept(Unknown338 var1) {
      var1.a(this.y);
      this.visit(var1);
   }

   @Override
   public Asm1 a(Map var1) {
      return new Asm3(this.y).a(this);
   }
}
