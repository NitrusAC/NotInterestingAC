package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm8 extends Asm1 {
   public int y;
   public int z;

   @Override
   public void accept(Unknown338 var1) {
      var1.a(this.y, this.z);
      this.visit(var1);
   }

   @Override
   public int d() {
      return 10;
   }

   public Asm8(int var1, int var2) {
      super(132);
      this.y = var1;
      this.z = var2;
   }

   @Override
   public Asm1 a(Map var1) {
      return new Asm8(this.y, this.z).a(this);
   }
}
