package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.oK;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown35;

@Deprecated
public abstract class Asm14 {
   protected final int b;
   private static final String o;
   public Asm14 a;

   @Deprecated
   public void b() {
      if (this.a != null) {
         this.a.b();
      }

   }

   @Deprecated
   public Asm14 a() {
      return this.a;
   }

   @Deprecated
   public Asm14(int var1) {
      this(var1, null);
   }

   @Deprecated
   public Asm14(int var1, Asm14 var2) {
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

   @Deprecated
   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      return this.a != null ? this.a.a(var1, var2, var3, var4) : null;
   }

   @Deprecated
   public Asm23 a(String var1, boolean var2) {
      return this.a != null ? this.a.a(var1, var2) : null;
   }

   @Deprecated
   public void a(Unknown35 var1) {
      if (this.a != null) {
         this.a.a(var1);
      }

   }
}
