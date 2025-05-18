package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown246;
import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm19 extends Asm1 {
   private Unknown246 y;

   public Asm19(Unknown246 var1) {
      super(-1);
      this.y = var1;
   }

   public void b() {
      this.y = null;
   }

   public Unknown246 a() {
      if (this.y == null) {
         this.y = new Unknown246();
      }

      return this.y;
   }

   @Override
   public int d() {
      return 8;
   }

   public Asm19() {
      super(-1);
   }

   @Override
   public void accept(Unknown338 var1) {
      var1.a(this.a());
   }

   @Override
   public Asm1 a(Map var1) {
      return (Asm1)var1.get(this);
   }
}
