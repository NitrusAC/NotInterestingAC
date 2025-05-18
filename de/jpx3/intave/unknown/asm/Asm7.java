package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm7 extends Asm1 {
   public int y;

   @Override
   public void accept(Unknown338 var1) {
      var1.c(this.w, this.y);
      this.visit(var1);
   }

   @Override
   public int d() {
      return 1;
   }

   public Asm7(int var1, int var2) {
      super(var1);
      this.y = var2;
   }

   @Override
   public Asm1 a(Map var1) {
      return new Asm7(this.w, this.y).a(this);
   }

   public void a(int var1) {
      this.w = var1;
   }
}
