package de.jpx3.intave.unknown;

import de.jpx3.intave.bu;

class Unknown251 {
   private final Unknown184 d;
   private final String a;
   private final String b;
   private final String c;

   public static Unknown251 b(String var0, String var1, String var2) {
      return new Unknown251(Unknown184.a, var0, var1, var2);
   }

   static String d(Unknown251 var0) {
      return var0.a;
   }

   private Unknown251(Unknown184 var1, String var2, String var3, String var4) {
      this.d = var1;
      this.b = var2;
      this.c = var3;
      this.a = var4;
   }

   public boolean a() {
      return this.d == Unknown184.a;
   }

   public int hashCode() {
      int var1 = this.d.hashCode();
      var1 = 31 * var1 + this.b.hashCode();
      var1 = 31 * var1 + this.c.hashCode();
      return 31 * var1 + this.a.hashCode();
   }

   public Unknown184 c() {
      return this.d;
   }

   static String a(Unknown251 var0) {
      return var0.c;
   }

   public static Unknown251 a(bu var0) {
      return b(var0.b(), var0.d(), var0.c());
   }

   static Unknown184 c(Unknown251 var0) {
      return var0.d;
   }

   static String b(Unknown251 var0) {
      return var0.b;
   }

   public static Unknown251 a(String var0, String var1, String var2) {
      return new Unknown251(Unknown184.b, var0, var1, var2);
   }

   public boolean b() {
      return this.d == Unknown184.b;
   }

   public String toString() {
      return "InstructionTarget{type=" + this.d + ", name=" + this.b + "#" + this.c + this.a + '}';
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         Unknown251 var5 = (Unknown251)var1;
         if (this.d != var5.d) {
            return false;
         } else if (!this.b.equals(var5.b)) {
            return false;
         } else {
            return !this.c.equals(var5.c) ? false : this.a.equals(var5.a);
         }
      } else {
         return false;
      }
   }
}
