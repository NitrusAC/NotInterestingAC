package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm9 extends Asm1 {
   public Asm9(int var1) {
      super(var1);
   }

   @Override
   public Asm1 a(Map var1) {
      return new Asm9(this.w).a(this);
   }

   @Override
   public void accept(Unknown338 var1) {
      var1.a(this.w);
      this.visit(var1);
   }

   @Override
   public int d() {
      return 0;
   }
}
