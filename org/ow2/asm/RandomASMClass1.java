package org.ow2.asm;

import de.jpx3.intave.oK;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.Unknown35;
import de.jpx3.intave.unknown.asm.Asm14;
import de.jpx3.intave.unknown.asm.Asm23;
import de.jpx3.intave.unknown.asm.Asm26;
import de.jpx3.intave.unknown.asm.Asm5;

public abstract class RandomASMClass1 {
   public static String a;
   protected final int c;
   protected RandomASMClass1 b;

   @Deprecated
   public void b(String var1) {
      if (this.c != 17301504) {
         throw new UnsupportedOperationException("This feature requires ASM8_EXPERIMENTAL");
      } else {
         if (this.b != null) {
            this.b.b(var1);
         }

      }
   }

   public void a(String var1) {
      if (this.c < 458752) {
         throw new UnsupportedOperationException("This feature requires ASM7");
      } else {
         if (this.b != null) {
            this.b.a(var1);
         }

      }
   }

   public Asm26 a(int var1, String var2, String var3, String var4, Object var5) {
      return this.b != null ? this.b.a(var1, var2, var3, var4, var5) : null;
   }

   public Unknown338 a(int var1, String var2, String var3, String var4, String[] var5) {
      return this.b != null ? this.b.a(var1, var2, var3, var4, var5) : null;
   }

   @Deprecated
   public Asm14 a(int var1, String var2, String var3, String var4) {
      if (this.c < 17301504) {
         throw new UnsupportedOperationException("This feature requires ASM8_EXPERIMENTAL");
      } else {
         return this.b != null ? this.b.a(var1, var2, var3, var4) : null;
      }
   }

   public void a(String var1, String var2, String var3, int var4) {
      if (this.b != null) {
         this.b.a(var1, var2, var3, var4);
      }

   }

   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      if (this.c < 327680) {
         throw new UnsupportedOperationException("This feature requires ASM5");
      } else {
         return this.b != null ? this.b.a(var1, var2, var3, var4) : null;
      }
   }

   public void a() {
      if (this.b != null) {
         this.b.a();
      }

   }

   public void a(Unknown35 var1) {
      if (this.b != null) {
         this.b.a(var1);
      }

   }

   public void a(String var1, String var2) {
      if (this.b != null) {
         this.b.a(var1, var2);
      }

   }

   public void c(String var1) {
      if (this.c < 458752) {
         throw new UnsupportedOperationException("This feature requires ASM7");
      } else {
         if (this.b != null) {
            this.b.c(var1);
         }

      }
   }

   public Asm5 a(String var1, int var2, String var3) {
      if (this.c < 393216) {
         throw new UnsupportedOperationException("This feature requires ASM6");
      } else {
         return this.b != null ? this.b.a(var1, var2, var3) : null;
      }
   }

   public Asm23 a(String var1, boolean var2) {
      return this.b != null ? this.b.a(var1, var2) : null;
   }

   public void a(int var1, int var2, String var3, String var4, String var5, String[] var6) {
      if (this.b != null) {
         this.b.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public RandomASMClass1(int var1) {
      this(var1, null);
   }

   public RandomASMClass1(int var1, RandomASMClass1 var2) {
      if (var1 != 458752 && var1 != 393216 && var1 != 327680 && var1 != 262144 && var1 != 17301504) {
         throw new IllegalArgumentException("Unsupported api " + var1);
      } else {
         if (var1 == 17301504) {
            oK.a(this);
         }

         this.c = var1;
         this.b = var2;
      }
   }

   public void a(String var1, String var2, String var3) {
      if (this.b != null) {
         this.b.a(var1, var2, var3);
      }

   }
}
