package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown48;

public class Asm22 extends Unknown48 {
   public int g;
   public Unknown186 f;

   public Asm22(int var1, int var2, Unknown186 var3, String var4) {
      super(var1, var4);
      this.g = var2;
      this.f = var3;
   }

   public Asm22(int var1, Unknown186 var2, String var3) {
      this(458752, var1, var2, var3);
      if (this.getClass() != Asm22.class) {
         throw new IllegalStateException();
      }
   }
}
