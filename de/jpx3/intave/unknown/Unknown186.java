package de.jpx3.intave.unknown;

public final class Unknown186 {
   public static final int c = 0;
   public static final int f = 2;
   private final byte[] d;
   private final int a;
   public static final int e = 3;
   public static final int b = 1;

   public int a(int var1) {
      return this.d[this.a + 2 * var1 + 1];
   }

   public int b(int var1) {
      return this.d[this.a + 2 * var1 + 2];
   }

   public int a() {
      return this.d[this.a];
   }

   public static void a(Unknown186 var0, Unknown257 var1) {
      if (var0 == null) {
         var1.a(0);
      } else {
         int var5 = var0.d[var0.a] * 2 + 1;
         var1.a(var0.d, var0.a, var5);
      }

   }

   public Unknown186(byte[] var1, int var2) {
      this.d = var1;
      this.a = var2;
   }

   public String toString() {
      int var4 = this.a();
      StringBuilder var5 = new StringBuilder(var4 * 2);

      for(int var6 = 0; var6 < var4; ++var6) {
         switch(this.a(var6)) {
            case 0:
               var5.append('[');
               break;
            case 1:
               var5.append('.');
               break;
            case 2:
               var5.append('*');
               break;
            case 3:
               var5.append(this.b(var6)).append(';');
               break;
            default:
               throw new AssertionError();
         }
      }

      return var5.toString();
   }

   public static Unknown186 a(String var0) {
      if (var0 != null && var0.length() != 0) {
         int var4 = var0.length();
         Unknown257 var5 = new Unknown257(var4);
         var5.a(0);
         int var6 = 0;

         while(var6 < var4) {
            char var7 = var0.charAt(var6++);
            if (var7 == '[') {
               var5.a(0, 0);
            } else if (var7 == '.') {
               var5.a(1, 0);
            } else if (var7 != '*') {
               if (var7 < '0' || var7 > '9') {
                  throw new IllegalArgumentException();
               }

               int var8;
               for(var8 = var7 - '0'; var6 < var4; var8 = var8 * 10 + var7 - 48) {
                  var7 = var0.charAt(var6++);
                  if (var7 < '0' || var7 > '9') {
                     if (var7 != ';') {
                        throw new IllegalArgumentException();
                     }
                     break;
                  }
               }

               var5.a(3, var8);
            } else {
               var5.a(2, 0);
            }
         }

         var5.b[0] = (byte)(var5.c / 2);
         return new Unknown186(var5.b, 0);
      } else {
         return null;
      }
   }
}
