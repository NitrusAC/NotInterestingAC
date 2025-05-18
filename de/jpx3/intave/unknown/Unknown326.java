package de.jpx3.intave.unknown;

final class Unknown326 {
   final int f;
   final Unknown246 e;
   final String d;
   final Unknown246 a;
   Unknown326 b;
   final Unknown246 c;

   static int a(Unknown326 var0) {
      return 2 + 8 * b(var0);
   }

   Unknown326(Unknown246 var1, Unknown246 var2, Unknown246 var3, int var4, String var5) {
      this.c = var1;
      this.a = var2;
      this.e = var3;
      this.f = var4;
      this.d = var5;
   }

   Unknown326(Unknown326 var1, Unknown246 var2, Unknown246 var3) {
      this(var2, var3, var1.e, var1.f, var1.d);
      this.b = var1.b;
   }

   static void a(Unknown326 var0, Unknown257 var1) {
      var1.c(b(var0));

      for(Unknown326 var2 = var0; var2 != null; var2 = var2.b) {
         var1.c(var2.c.f).c(var2.a.f).c(var2.e.f).c(var2.f);
      }

   }

   static int b(Unknown326 var0) {
      int var1 = 0;

      for(Unknown326 var2 = var0; var2 != null; var2 = var2.b) {
         ++var1;
      }

      return var1;
   }

   static Unknown326 a(Unknown326 var0, Unknown246 var1, Unknown246 var2) {
      if (var0 == null) {
         return null;
      } else {
         var0.b = a(var0.b, var1, var2);
         int var6 = var0.c.f;
         int var7 = var0.a.f;
         int var8 = var1.f;
         int var9 = var2 == null ? Integer.MAX_VALUE : var2.f;
         if (var8 >= var7 || var9 <= var6) {
            return var0;
         } else if (var8 <= var6) {
            return var9 >= var7 ? var0.b : new Unknown326(var0, var2, var0.a);
         } else if (var9 >= var7) {
            return new Unknown326(var0, var0.c, var1);
         } else {
            var0.b = new Unknown326(var0, var2, var0.a);
            return new Unknown326(var0, var0.c, var1);
         }
      }
   }
}
