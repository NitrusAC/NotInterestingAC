package de.jpx3.intave.unknown;

import de.jpx3.intave.unknown.asm.Asm1;
import java.util.Map;

public class Unknown30 extends Asm1 {
   public String y;

   public void a(int var1) {
      this.w = var1;
   }

   @Override
   public void accept(Unknown338 var1) {
      var1.a(this.w, this.y);
      this.visit(var1);
   }

   @Override
   public Asm1 a(Map var1) {
      return new Unknown30(this.w, this.y).a(this);
   }

   @Override
   public int d() {
      return 3;
   }

   public Unknown30(int var1, String var2) {
      super(var1);
      this.y = var2;
   }
}
