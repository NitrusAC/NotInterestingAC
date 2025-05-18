package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm11 extends Asm1 {
   public int y;
   public String z;

   @Override
   public void accept(Unknown338 var1) {
      var1.b(this.z, this.y);
      this.visit(var1);
   }

   @Override
   public int d() {
      return 13;
   }

   public Asm11(String var1, int var2) {
      super(197);
      this.z = var1;
      this.y = var2;
   }

   @Override
   public Asm1 a(Map var1) {
      return new Asm11(this.z, this.y).a(this);
   }
}
