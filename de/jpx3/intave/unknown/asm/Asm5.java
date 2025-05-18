package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.oK;

public abstract class Asm5 {
   protected final int b;
   protected Asm5 a;
   private static final String v;

   public void b(String var1) {
      if (this.a != null) {
         this.a.b(var1);
      }

   }

   public void a(String var1, int var2, String[] var3) {
      if (this.a != null) {
         this.a.a(var1, var2, var3);
      }

   }

   public void a() {
      if (this.a != null) {
         this.a.a();
      }

   }

   public void b(String var1, int var2, String[] var3) {
      if (this.a != null) {
         this.a.b(var1, var2, var3);
      }

   }

   public Asm5(int var1) {
      this(var1, null);
   }

   public void a(String var1, int var2, String var3) {
      if (this.a != null) {
         this.a.a(var1, var2, var3);
      }

   }

   public Asm5(int var1, Asm5 var2) {
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

   public void a(String var1) {
      if (this.a != null) {
         this.a.a(var1);
      }

   }

   public void a(String var1, String[] var2) {
      if (this.a != null) {
         this.a.a(var1, var2);
      }

   }

   public void c(String var1) {
      if (this.a != null) {
         this.a.c(var1);
      }

   }
}
