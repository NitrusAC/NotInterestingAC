package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.oK;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown35;

public abstract class Asm26 {
   protected final int b;
   public Asm26 a;

   public Asm23 a(String var1, boolean var2) {
      return this.a != null ? this.a.a(var1, var2) : null;
   }

   public void a() {
      if (this.a != null) {
         this.a.a();
      }

   }

   public Asm26(int var1, Asm26 var2) {
      if (var1 != 458752 && var1 != 393216 && var1 != 327680 && var1 != 262144 && var1 != 17301504) {
         throw new IllegalArgumentException("Unsupported api " + var1);
      } else {
         if (var1 == 17301504) {
            oK.a(this);
         }

         this.b = var1;
         this.a = var2;
      }
   }

   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      if (this.b < 327680) {
         throw new UnsupportedOperationException("This feature requires ASM5");
      } else {
         return this.a != null ? this.a.a(var1, var2, var3, var4) : null;
      }
   }

   public Asm26(int var1) {
      this(var1, null);
   }

   public void a(Unknown35 var1) {
      if (this.a != null) {
         this.a.a(var1);
      }

   }
}
