package de.jpx3.intave.unknown;

import de.jpx3.intave.b7;
import de.jpx3.intave.oK;
import de.jpx3.intave.unknown.asm.Asm23;

public abstract class Unknown338 {
   private static final String d;
   protected final int a;
   protected Unknown338 b;

   public void e() {
      if (this.b != null) {
         this.b.e();
      }

   }

   public void a(int var1, boolean var2) {
      if (this.b != null) {
         this.b.a(var1, var2);
      }

   }

   @Deprecated
   public void a(int var1, String var2, String var3, String var4) {
      int var5 = var1 | (this.a < 327680 ? 256 : 0);
      this.visit(var5, var2, var3, var4, var1 == 185);
   }

   public void a(Object var1) {
      if (this.a >= 327680 || !(var1 instanceof Unknown137) && (!(var1 instanceof Unknown357) || ((Unknown357)var1).k() != 11)) {
         if (this.a < 458752 && var1 instanceof b7) {
            throw new UnsupportedOperationException("This feature requires ASM7");
         } else {
            if (this.b != null) {
               this.b.a(var1);
            }

         }
      } else {
         throw new UnsupportedOperationException("This feature requires ASM5");
      }
   }

   public void a(int var1) {
      if (this.b != null) {
         this.b.a(var1);
      }

   }

   public Asm23 a(int var1, Unknown186 var2, Unknown246[] var3, Unknown246[] var4, int[] var5, String var6, boolean var7) {
      if (this.a < 327680) {
         throw new UnsupportedOperationException("This feature requires ASM5");
      } else {
         return this.b != null ? this.b.a(var1, var2, var3, var4, var5, var6, var7) : null;
      }
   }

   public Unknown338(int var1) {
      this(var1, null);
   }

   public void a(int var1, int var2) {
      if (this.b != null) {
         this.b.a(var1, var2);
      }

   }

   public void a(int var1, int var2, Object[] var3, int var4, Object[] var5) {
      if (this.b != null) {
         this.b.a(var1, var2, var3, var4, var5);
      }

   }

   public Asm23 a(int var1, String var2, boolean var3) {
      return this.b != null ? this.b.a(var1, var2, var3) : null;
   }

   public void d(int var1, int var2) {
      if (this.b != null) {
         this.b.d(var1, var2);
      }

   }

   public void a(String var1, String var2, String var3, Unknown246 var4, Unknown246 var5, int var6) {
      if (this.b != null) {
         this.b.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public Asm23 a(String var1, boolean var2) {
      return this.b != null ? this.b.a(var1, var2) : null;
   }

   public void c(int var1, int var2) {
      if (this.b != null) {
         this.b.c(var1, var2);
      }

   }

   public Unknown338(int var1, Unknown338 var2) {
      if (var1 != 458752 && var1 != 393216 && var1 != 327680 && var1 != 262144 && var1 != 17301504) {
         throw new IllegalArgumentException("Unsupported api " + var1);
      } else {
         if (var1 == 17301504) {
            oK.a(this);
         }

         this.a = var1;
         this.b = var2;
      }
   }

   public void b(String var1, int var2) {
      if (this.b != null) {
         this.b.b(var1, var2);
      }

   }

   public void a(Unknown246 var1) {
      if (this.b != null) {
         this.b.a(var1);
      }

   }

   public void a(int var1, Unknown246 var2) {
      if (this.b != null) {
         this.b.a(var1, var2);
      }

   }

   public void b(int var1, Unknown246 var2) {
      if (this.b != null) {
         this.b.b(var1, var2);
      }

   }

   public void a(int var1, int var2, Unknown246 var3, Unknown246[] var4) {
      if (this.b != null) {
         this.b.a(var1, var2, var3, var4);
      }

   }

   public void a(Unknown246 var1, int[] var2, Unknown246[] var3) {
      if (this.b != null) {
         this.b.a(var1, var2, var3);
      }

   }

   public void visit(int var1, String var2, String var3, String var4, boolean var5) {
      if (this.a < 327680 && (var1 & 256) == 0) {
         if (var5 != (var1 == 185)) {
            throw new UnsupportedOperationException("INVOKESPECIAL/STATIC on interfaces requires ASM5");
         } else {
            this.a(var1, var2, var3, var4);
         }
      } else {
         if (this.b != null) {
            this.b.visit(var1 & -257, var2, var3, var4, var5);
         }

      }
   }

   public Asm23 b(int var1, Unknown186 var2, String var3, boolean var4) {
      if (this.a < 327680) {
         throw new UnsupportedOperationException("This feature requires ASM5");
      } else {
         return this.b != null ? this.b.b(var1, var2, var3, var4) : null;
      }
   }

   public void c() {
      if (this.b != null) {
         this.b.c();
      }

   }

   public void a(String var1, int var2) {
      if (this.a < 327680) {
         throw new UnsupportedOperationException("This feature requires ASM5");
      } else {
         if (this.b != null) {
            this.b.a(var1, var2);
         }

      }
   }

   public void a(String var1, String var2, Unknown137 var3, Object[] var4) {
      if (this.a < 327680) {
         throw new UnsupportedOperationException("This feature requires ASM5");
      } else {
         if (this.b != null) {
            this.b.a(var1, var2, var3, var4);
         }

      }
   }

   public void a(Unknown35 var1) {
      if (this.b != null) {
         this.b.a(var1);
      }

   }

   public void b(int var1, String var2, String var3, String var4) {
      if (this.b != null) {
         this.b.b(var1, var2, var3, var4);
      }

   }

   public void a(int var1, String var2) {
      if (this.b != null) {
         this.b.a(var1, var2);
      }

   }

   public Asm23 a(int var1, Unknown186 var2, String var3, boolean var4) {
      if (this.a < 327680) {
         throw new UnsupportedOperationException("This feature requires ASM5");
      } else {
         return this.b != null ? this.b.a(var1, var2, var3, var4) : null;
      }
   }

   public void b(int var1, int var2) {
      if (this.b != null) {
         this.b.b(var1, var2);
      }

   }

   public void a(Unknown246 var1, Unknown246 var2, Unknown246 var3, String var4) {
      if (this.b != null) {
         this.b.a(var1, var2, var3, var4);
      }

   }

   public Asm23 c(int var1, Unknown186 var2, String var3, boolean var4) {
      if (this.a < 327680) {
         throw new UnsupportedOperationException("This feature requires ASM5");
      } else {
         return this.b != null ? this.b.c(var1, var2, var3, var4) : null;
      }
   }

   public Asm23 d() {
      return this.b != null ? this.b.d() : null;
   }
}
