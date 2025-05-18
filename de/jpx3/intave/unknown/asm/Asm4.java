package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.unknown.Unknown338;
import java.util.Map;

public class Asm4 extends Asm1 {
   private static final String D;
   public String y;
   public String A;
   public String z;

   @Override
   public Asm1 a(Map var1) {
      return new Asm4(this.w, this.z, this.A, this.y).a(this);
   }

   @Override
   public void accept(Unknown338 var1) {
      try {
         var1.b(this.w, this.z, this.A, this.y);
      } catch (Exception var5) {
         Logger.getLogger().print("Occurred in " + this.z + " " + this.A + " " + this.y);
         var5.printStackTrace();
      }

      this.visit(var1);
   }

   @Override
   public int d() {
      return 4;
   }

   public Asm4(int var1, String var2, String var3, String var4) {
      super(var1);
      this.z = var2;
      this.A = var3;
      this.y = var4;
   }

   public void a(int var1) {
      this.w = var1;
   }
}
