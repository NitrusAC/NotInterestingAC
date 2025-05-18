package de.jpx3.intave.unknown;

public class Unknown257 {
   public int c;
   public static long a = System.currentTimeMillis();
   public byte[] b;

   public Unknown257 a(long var1) {
      int var6 = this.c;
      if (var6 + 8 > this.b.length) {
         this.b(8);
      }

      byte[] var7 = this.b;
      int var8 = (int)(var1 >>> 32);
      var7[var6++] = (byte)(var8 >>> 24);
      var7[var6++] = (byte)(var8 >>> 16);
      var7[var6++] = (byte)(var8 >>> 8);
      var7[var6++] = (byte)var8;
      var8 = (int)var1;
      var7[var6++] = (byte)(var8 >>> 24);
      var7[var6++] = (byte)(var8 >>> 16);
      var7[var6++] = (byte)(var8 >>> 8);
      var7[var6++] = (byte)var8;
      this.c = var6;
      return this;
   }

   public Unknown257 a(int var1) {
      int var2 = this.c;
      if (var2 + 1 > this.b.length) {
         this.b(1);
      }

      this.b[var2++] = (byte)var1;
      this.c = var2;
      return this;
   }

   public Unknown257(int var1) {
      this.b = new byte[var1];
   }

   final Unknown257 b(int var1, int var2, int var3) {
      int var4 = this.c;
      if (var4 + 5 > this.b.length) {
         this.b(5);
      }

      byte[] var5 = this.b;
      var5[var4++] = (byte)var1;
      var5[var4++] = (byte)(var2 >>> 8);
      var5[var4++] = (byte)var2;
      var5[var4++] = (byte)(var3 >>> 8);
      var5[var4++] = (byte)var3;
      this.c = var4;
      return this;
   }

   final Unknown257 a(int var1, int var2) {
      int var3 = this.c;
      if (var3 + 2 > this.b.length) {
         this.b(2);
      }

      byte[] var4 = this.b;
      var4[var3++] = (byte)var1;
      var4[var3++] = (byte)var2;
      this.c = var3;
      return this;
   }

   public Unknown257 d(int var1) {
      int var2 = this.c;
      if (var2 + 4 > this.b.length) {
         this.b(4);
      }

      byte[] var3 = this.b;
      var3[var2++] = (byte)(var1 >>> 24);
      var3[var2++] = (byte)(var1 >>> 16);
      var3[var2++] = (byte)(var1 >>> 8);
      var3[var2++] = (byte)var1;
      this.c = var2;
      return this;
   }

   public Unknown257 a(byte[] var1, int var2, int var3) {
      if (this.c + var3 > this.b.length) {
         this.b(var3);
      }

      if (var1 != null) {
         System.arraycopy(var1, var2, this.b, this.c, var3);
      }

      this.c += var3;
      return this;
   }

   public final Unknown257 b(int var1, int var2) {
      int var3 = this.c;
      if (var3 + 3 > this.b.length) {
         this.b(3);
      }

      byte[] var4 = this.b;
      var4[var3++] = (byte)var1;
      var4[var3++] = (byte)(var2 >>> 8);
      var4[var3++] = (byte)var2;
      this.c = var3;
      return this;
   }

   private void b(int var1) {
      int var2 = 2 * this.b.length;
      int var3 = this.c + var1;
      byte[] var4 = new byte[var2 > var3 ? var2 : var3];
      System.arraycopy(this.b, 0, var4, 0, this.c);
      this.b = var4;
   }

   final Unknown257 a(int var1, int var2, int var3) {
      int var4 = this.c;
      if (var4 + 4 > this.b.length) {
         this.b(4);
      }

      byte[] var5 = this.b;
      var5[var4++] = (byte)var1;
      var5[var4++] = (byte)var2;
      var5[var4++] = (byte)(var3 >>> 8);
      var5[var4++] = (byte)var3;
      this.c = var4;
      return this;
   }

   public Unknown257 a(String var1) {
      int var4 = var1.length();
      if (var4 > 65535) {
         throw new IllegalArgumentException("UTF8 string too large");
      } else {
         int var5 = this.c;
         if (var5 + 2 + var4 > this.b.length) {
            this.b(2 + var4);
         }

         byte[] var6 = this.b;
         var6[var5++] = (byte)(var4 >>> 8);
         var6[var5++] = (byte)var4;

         for(int var7 = 0; var7 < var4; ++var7) {
            char var8 = var1.charAt(var7);
            if (var8 < 1 || var8 > 127) {
               this.c = var5;
               return this.a(var1, var7, 65535);
            }

            var6[var5++] = (byte)var8;
         }

         this.c = var5;
         return this;
      }
   }

   Unknown257(byte[] var1) {
      this.b = var1;
      this.c = var1.length;
   }

   final Unknown257 a(String var1, int var2, int var3) {
      int var6 = var1.length();
      int var7 = var2;

      for(int var8 = var2; var8 < var6; ++var8) {
         char var9 = var1.charAt(var8);
         if (var9 >= 1 && var9 <= 127) {
            ++var7;
         } else if (var9 <= 2047) {
            var7 += 2;
         } else {
            var7 += 3;
         }
      }

      if (var7 > var3) {
         throw new IllegalArgumentException("UTF8 string too large");
      } else {
         int var12 = this.c - var2 - 2;
         if (var12 >= 0) {
            this.b[var12] = (byte)(var7 >>> 8);
            this.b[var12 + 1] = (byte)var7;
         }

         if (this.c + var7 - var2 > this.b.length) {
            this.b(var7 - var2);
         }

         int var13 = this.c;

         for(int var10 = var2; var10 < var6; ++var10) {
            char var11 = var1.charAt(var10);
            if (var11 >= 1 && var11 <= 127) {
               this.b[var13++] = (byte)var11;
            } else if (var11 <= 2047) {
               this.b[var13++] = (byte)(192 | var11 >> 6 & 31);
               this.b[var13++] = (byte)(128 | var11 & '?');
            } else {
               this.b[var13++] = (byte)(224 | var11 >> 12 & 15);
               this.b[var13++] = (byte)(128 | var11 >> 6 & 63);
               this.b[var13++] = (byte)(128 | var11 & '?');
            }
         }

         this.c = var13;
         return this;
      }
   }

   public Unknown257() {
      this.b = new byte[64];
   }

   public Unknown257 c(int var1) {
      int var2 = this.c;
      if (var2 + 2 > this.b.length) {
         this.b(2);
      }

      byte[] var3 = this.b;
      var3[var2++] = (byte)(var1 >>> 8);
      var3[var2++] = (byte)var1;
      this.c = var2;
      return this;
   }
}
