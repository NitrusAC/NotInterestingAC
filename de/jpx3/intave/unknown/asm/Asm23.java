package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.oK;

public abstract class Asm23 {
   protected Asm23 c;
   private static final String m;
   protected final int d;

   public Asm23 a(String var1) {
      return this.c != null ? this.c.a(var1) : null;
   }

   public Asm23(int var1, Asm23 var2) {
      if (var1 != 458752 && var1 != 393216 && var1 != 327680 && var1 != 262144 && var1 != 17301504) {
         throw new IllegalArgumentException("Unsupported api " + var1);
      } else {
         if (var1 == 17301504) {
            oK.a(this);
         }

         this.d = var1;
         this.c = var2;
      }
   }

   public Asm23 a(String var1, String var2) {
      return this.c != null ? this.c.a(var1, var2) : null;
   }

   public Asm23(int var1) {
      this(var1, null);
   }

   public void c() {
      if (this.c != null) {
         this.c.c();
      }

   }

   public void a(String var1, String var2, String var3) {
      if (this.c != null) {
         this.c.a(var1, var2, var3);
      }

   }

   public void a(String var1, Object var2) {
      if (this.c != null) {
         this.c.a(var1, var2);
      }

   }
}
