package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown137;
import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm2 extends Asm1 {
   public String z;
   public String A;
   public Object[] y;
   public Unknown137 B;

   @Override
   public void accept(Unknown338 var1) {
      var1.a(this.A, this.z, this.B, this.y);
      this.visit(var1);
   }

   public Asm2(String var1, String var2, Unknown137 var3, Object[] var4) {
      super(186);
      this.A = var1;
      this.z = var2;
      this.B = var3;
      this.y = var4;
   }

   @Override
   public int d() {
      return 6;
   }

   @Override
   public Asm1 a(Map var1) {
      return new Asm2(this.A, this.z, this.B, this.y).a(this);
   }
}
