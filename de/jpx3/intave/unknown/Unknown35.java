package de.jpx3.intave.unknown;

import de.jpx3.intave.unknown.asm.Asm37;

public class Unknown35 {
   private byte[] c;
   public final String a;
   public Unknown35 b;

   public final void a(Unknown13 var1, Unknown257 var2) {
      Object var3 = null;
      boolean var4 = false;
      boolean var5 = true;
      boolean var6 = true;
      this.a(var1, (byte[])var3, 0, -1, -1, var2);
   }

   public static void a(Unknown13 var0, int var1, int var2, Unknown257 var3) {
      if ((var1 & 4096) != 0 && var0.d() < 49) {
         var3.c(var0.g("Synthetic")).d(0);
      }

      if (var2 != 0) {
         var3.c(var0.g("Signature")).d(2).c(var2);
      }

      if ((var1 & 131072) != 0) {
         var3.c(var0.g("Deprecated")).d(0);
      }

   }

   public Unknown35 a(Asm37 var1, int var2, int var3, char[] var4, int var5, Unknown246[] var6) {
      Unknown35 var7 = new Unknown35(this.a);
      var7.c = new byte[var3];
      System.arraycopy(var1.k, var2, var7.c, 0, var3);
      return var7;
   }

   protected Unknown246[] b() {
      return new Unknown246[0];
   }

   public boolean d() {
      return false;
   }

   public final int a(Unknown13 var1) {
      Object var2 = null;
      boolean var3 = false;
      boolean var4 = true;
      boolean var5 = true;
      return this.a(var1, (byte[])var2, 0, -1, -1);
   }

   public boolean c() {
      return true;
   }

   final void a(Unknown13 var1, byte[] var2, int var3, int var4, int var5, Unknown257 var6) {
      Unknown177 var7 = var1.i;

      for(Unknown35 var8 = this; var8 != null; var8 = var8.b) {
         Unknown257 var9 = var8.a(var7, var2, var3, var4, var5);
         var6.c(var1.g(var8.a)).d(var9.c);
         var6.a(var9.b, 0, var9.c);
      }

   }

   public Unknown35(String var1) {
      this.a = var1;
   }

   protected Unknown257 a(Unknown177 var1, byte[] var2, int var3, int var4, int var5) {
      return new Unknown257(this.c);
   }

   public final int a() {
      int var1 = 0;

      for(Unknown35 var2 = this; var2 != null; var2 = var2.b) {
         ++var1;
      }

      return var1;
   }

   public static int a(Unknown13 var0, int var1, int var2) {
      int var5 = 0;
      if ((var1 & 4096) != 0 && var0.d() < 49) {
         var0.g("Synthetic");
         var5 += 6;
      }

      if (var2 != 0) {
         var0.g("Signature");
         var5 += 8;
      }

      if ((var1 & 131072) != 0) {
         var0.g("Deprecated");
         var5 += 6;
      }

      return var5;
   }

   final int a(Unknown13 var1, byte[] var2, int var3, int var4, int var5) {
      Unknown177 var6 = var1.i;
      int var7 = 0;

      for(Unknown35 var8 = this; var8 != null; var8 = var8.b) {
         var1.g(var8.a);
         var7 += 6 + var8.a(var6, var2, var3, var4, var5).c;
      }

      return var7;
   }
}
