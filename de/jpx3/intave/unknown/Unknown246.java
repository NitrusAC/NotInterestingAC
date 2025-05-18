package de.jpx3.intave.unknown;

import de.jpx3.intave.unknown.asm.Asm32;

public class Unknown246 {
   static final int B = 2;
   static final int m = 268435455;
   static final int x = 6;
   Unknown88 g;
   short y;
   Asm32 p;
   public short q;
   Unknown246 l;
   public short A;
   short a;
   static final int j = 268435456;
   private int[] h;
   short e;
   static final int k = 64;
   static final int n = 8;
   static final int i = -268435456;
   static final int d = 4;
   private short v;
   static final int r = 4;
   public int f;
   static final Unknown246 w = new Unknown246();
   static final int t = 1;
   static final int u = 32;
   static final int z = 16;
   private int[] b;
   private static final String D;
   public Object o;
   Unknown246 s;
   static final int c = 536870912;

   public final void a(int var1) {
      if (this.v == 0) {
         this.v = (short)var1;
      } else {
         if (this.h == null) {
            this.h = new int[4];
         }

         int var2 = ++this.h[0];
         if (var2 >= this.h.length) {
            int[] var3 = new int[this.h.length + 4];
            System.arraycopy(this.h, 0, var3, 0, this.h.length);
            this.h = var3;
         }

         this.h[var2] = var1;
      }

   }

   private void a(int var1, int var2, int var3) {
      if (this.b == null) {
         this.b = new int[6];
      }

      int var7 = this.b[0];
      if (var7 + 2 >= this.b.length) {
         int[] var8 = new int[this.b.length + 6];
         System.arraycopy(this.b, 0, var8, 0, this.b.length);
         this.b = var8;
      }

      ++var7;
      this.b[var7] = var1;
      ++var7;
      this.b[var7] = var2 | var3;
      this.b[0] = var7;
   }

   public final void a(Unknown338 var1, boolean var2) {
      var1.a(this);
      if (var2 && this.v != 0) {
         var1.b(this.v & '\uffff', this);
         if (this.h != null) {
            for(int var3 = 1; var3 <= this.h[0]; ++var3) {
               var1.b(this.h[var3], this);
            }
         }
      }

   }

   public int a() {
      if ((this.A & 4) == 0) {
         throw new IllegalStateException("Label offset position has not been resolved yet");
      } else {
         return this.f;
      }
   }

   final void a(Unknown246 var1) {
      Unknown246 var5 = w;
      Unknown246 var6 = this;

      for(this.l = w; var6 != w; var6 = var6.b(var6)) {
         var6 = var6.l;
         var6.l = var5;
         var5 = var6;
         if ((var6.A & 64) != 0 && var6.e != var1.e) {
            var6.g = new Unknown88(var6.a, var1.g.c, var6.g);
         }
      }

      while(var5 != w) {
         Unknown246 var9 = var5.l;
         var5.l = null;
         var5 = var9;
      }

   }

   final boolean a(byte[] var1, int var2) {
      this.A = (short)(this.A | 4);
      this.f = var2;
      if (this.b == null) {
         return false;
      } else {
         boolean var6 = false;

         for(int var7 = this.b[0]; var7 > 0; var7 -= 2) {
            int var8 = this.b[var7 - 1];
            int var9 = this.b[var7];
            int var10 = var2 - var8;
            int var11 = var9 & 268435455;
            if ((var9 & -268435456) != 268435456) {
               var1[var11++] = (byte)(var10 >>> 24);
               var1[var11++] = (byte)(var10 >>> 16);
               var1[var11++] = (byte)(var10 >>> 8);
               var1[var11] = (byte)var10;
            } else {
               if (var10 < -32768 || var10 > 32767) {
                  int var12 = var1[var8] & 255;
                  if (var12 < 198) {
                     var1[var8] = (byte)(var12 + 49);
                  } else {
                     var1[var8] = (byte)(var12 + 20);
                  }

                  var6 = true;
               }

               var1[var11++] = (byte)(var10 >>> 8);
               var1[var11] = (byte)var10;
            }
         }

         return var6;
      }
   }

   final Unknown246 b() {
      return this.p == null ? this : this.p.w;
   }

   final void a(Unknown257 var1, int var2, boolean var3) {
      if ((this.A & 4) == 0) {
         if (var3) {
            this.a(var2, 536870912, var1.c);
            var1.d(-1);
         } else {
            this.a(var2, 268435456, var1.c);
            var1.c(-1);
         }
      } else if (var3) {
         var1.d(this.f - var2);
      } else {
         var1.c(this.f - var2);
      }

   }

   public String toString() {
      return "L" + System.identityHashCode(this);
   }

   private Unknown246 b(Unknown246 var1) {
      Unknown246 var5 = var1;

      for(Unknown88 var6 = this.g; var6 != null; var6 = var6.a) {
         boolean var7 = (this.A & 16) != 0 && var6 == this.g.a;
         if (!var7 && var6.c.l == null) {
            var6.c.l = var5;
            var5 = var6.c;
         }
      }

      return var5;
   }

   final void a(short var1) {
      Unknown246 var5 = this;
      this.l = w;

      while(var5 != w) {
         Unknown246 var6 = var5;
         var5 = var5.l;
         var6.l = null;
         if (var6.e == 0) {
            var6.e = var1;
            var5 = var6.b(var5);
         }
      }

   }
}
