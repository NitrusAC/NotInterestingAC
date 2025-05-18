package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm20 extends Asm1 {
   public int y;

   public Asm20(int var1, int var2) {
      super(var1);
      this.y = var2;
   }

   @Override
   public Asm1 a(Map var1) {
      return new Asm20(this.w, this.y).a(this);
   }

   @Override
   public int d() {
      return 2;
   }

   public void a(int var1) {
      this.w = var1;
   }

   @Override
   public void accept(Unknown338 var1) {
      var1.d(this.w, this.y);
      this.visit(var1);
   }
}
