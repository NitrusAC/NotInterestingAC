package de.jpx3.intave.unknown;

import de.jpx3.intave.b7;
import de.jpx3.intave.anticheat.unknown.Entry;
import de.jpx3.intave.unknown.asm.Asm37;

public final class Unknown13 {
   private Entry[] k;
   private int a;
   private final Asm37 h;
   private String e;
   public Unknown257 b;
   private int j;
   private int l;
   private Unknown257 d;
   private int f;
   final Unknown177 i;
   public Entry[] g;
   private int c;

   Unknown154 b(String var1, String var2, Unknown137 var3, Object[] var4) {
      Unknown154 var5 = this.a(var3, var4);
      return this.a(17, var1, var2, var5.index);
   }

   Unknown13(Unknown177 var1) {
      this.i = var1;
      this.h = null;
      this.g = new Entry[256];
      this.c = 1;
      this.b = new Unknown257();
   }

   private static int a(int var0, String var1, int var2) {
      return 2147483647 & var0 + var1.hashCode() + var2;
   }

   public Unknown154 b(int var1) {
      return this.a(3, var1);
   }

   Unknown154 a(String var1, String var2, Unknown137 var3, Object[] var4) {
      Unknown154 var5 = this.a(var3, var4);
      return this.a(18, var1, var2, var5.index);
   }

   public Unknown154 a(float var1) {
      return this.a(4, Float.floatToRawIntBits(var1));
   }

   int a(int var1, String var2) {
      this.l = var1;
      this.e = var2;
      return this.c(var2).index;
   }

   private static int b(int var0, int var1) {
      return 2147483647 & var0 + var1;
   }

   private void b(int var1, int var2, String var3, String var4, String var5) {
      this.a(new Entry(var1, var2, var3, var4, var5, 0L, b(var2, var3, var4, var5)));
   }

   private Unknown154 c(int var1, String var2) {
      int var6 = d(var1, var2);

      for(Entry var7 = this.a(var6); var7 != null; var7 = var7.D) {
         if (var7.tag == var1 && var7.C == var6 && var7.value.equals(var2)) {
            return var7;
         }
      }

      this.b.b(var1, this.g(var2));
      return this.c(new Entry(this.c++, var1, var2, var6));
   }

   public int d() {
      return this.l;
   }

   private int b(Entry var1) {
      if (this.k == null) {
         this.k = new Entry[16];
      }

      if (this.f == this.k.length) {
         Entry[] var5 = new Entry[2 * this.k.length];
         System.arraycopy(this.k, 0, var5, 0, this.k.length);
         this.k = var5;
      }

      this.k[this.f++] = var1;
      return this.c(var1).index;
   }

   private static int b(int var0, String var1, String var2, int var3) {
      return 2147483647 & var0 + var1.hashCode() * var2.hashCode() * (var3 + 1);
   }

   private void a(int var1, int var2, String var3) {
      this.a(new Entry(var1, var2, var3, d(var2, var3)));
   }

   private void a(int var1, int var2, String var3, String var4, int var5) {
      int var6 = b(var1, var3, var4, var5);
      this.a(new Entry(var2, var1, null, var3, var4, (long)var5, var6));
   }

   public String c() {
      return this.e;
   }

   public Unknown154 b(String var1) {
      return this.c(20, var1);
   }

   private static int a(int var0, long var1) {
      return 2147483647 & var0 + (int)var1 + (int)(var1 >>> 32);
   }

   Unknown154 a(String var1, String var2, String var3, boolean var4) {
      int var8 = var4 ? 11 : 10;
      return this.a(var8, var1, var2, var3);
   }

   private static int b(int var0, String var1, String var2, String var3) {
      return 2147483647 & var0 + var1.hashCode() * var2.hashCode() * var3.hashCode();
   }

   int b() {
      return this.c;
   }

   private void a(Entry var1) {
      ++this.a;
      int var2 = var1.C % this.g.length;
      var1.D = this.g[var2];
      this.g[var2] = var1;
   }

   public Unknown154 a(long var1) {
      return this.b(5, var1);
   }

   private void a(int var1, int var2, long var3) {
      this.a(new Entry(var1, var2, var3, a(var2, var3)));
   }

   private void b(int var1, int var2, int var3) {
      this.a(new Entry(var1, var2, (long)var3, b(var2, var3)));
   }

   private Entry c(Entry var1) {
      if (this.a > this.g.length * 3 / 4) {
         int var2 = this.g.length;
         int var3 = var2 * 2 + 1;
         Entry[] var4 = new Entry[var3];

         Entry var8;
         for(int var5 = var2 - 1; var5 >= 0; --var5) {
            for(Entry var6 = this.g[var5]; var6 != null; var6 = var8) {
               int var7 = var6.C % var3;
               var8 = var6.D;
               var6.D = var4[var7];
               var4[var7] = var6;
            }
         }

         this.g = var4;
      }

      ++this.a;
      int var9 = var1.C % this.g.length;
      var1.D = this.g[var9];
      return this.g[var9] = var1;
   }

   public Unknown154 f(String var1) {
      return this.c(19, var1);
   }

   public Unknown154 c(int var1) {
      return this.k[var1];
   }

   private Unknown154 b(int var1, long var2) {
      int var7 = a(var1, var2);

      for(Entry var8 = this.a(var7); var8 != null; var8 = var8.D) {
         if (var8.tag == var1 && var8.C == var7 && var8.data == var2) {
            return var8;
         }
      }

      int var9 = this.c;
      this.b.a(var1).a(var2);
      this.c += 2;
      return this.c(new Entry(var9, var1, var2, var7));
   }

   int f() {
      if (this.d != null) {
         this.g("BootstrapMethods");
         return 8 + this.d.c;
      } else {
         return 0;
      }
   }

   public int g(String var1) {
      int var2 = d(1, var1);

      for(Entry var3 = this.a(var2); var3 != null; var3 = var3.D) {
         if (var3.tag == 1 && var3.C == var2 && var3.value.equals(var1)) {
            return var3.index;
         }
      }

      this.b.a(1).a(var1);
      return this.c(new Entry(this.c++, 1, var1, var2)).index;
   }

   void b(Unknown257 var1) {
      if (this.d != null) {
         var1.c(this.g("BootstrapMethods")).d(this.d.c + 2).c(this.j).a(this.d.b, 0, this.d.c);
      }

   }

   private static int d(int var0, String var1) {
      return 2147483647 & var0 + var1.hashCode();
   }

   private static int a(int var0, String var1, String var2) {
      return 2147483647 & var0 + var1.hashCode() * var2.hashCode();
   }

   private static int a(int var0, String var1, String var2, String var3, int var4) {
      return 2147483647 & var0 + var1.hashCode() * var2.hashCode() * var3.hashCode() * var4;
   }

   public Unknown154 c(String var1) {
      return this.c(7, var1);
   }

   private void b(int var1, String var2, String var3) {
      boolean var4 = true;
      this.a(new Entry(var1, 12, var2, var3, a(12, var2, var3)));
   }

   private Unknown154 a(int var1, String var2, String var3, int var4) {
      int var8 = b(var1, var2, var3, var4);

      for(Entry var9 = this.a(var8); var9 != null; var9 = var9.D) {
         if (var9.tag == var1 && var9.C == var8 && var9.data == (long)var4 && var9.name.equals(var2) && var9.value.equals(var3)) {
            return var9;
         }
      }

      this.b.b(var1, var4, this.a(var2, var3));
      return this.c(new Entry(this.c++, var1, null, var2, var3, (long)var4, var8));
   }

   Unknown154 a(int var1, String var2, String var3, String var4, boolean var5) {
      boolean var9 = true;
      int var10 = a(15, var2, var3, var4, var1);

      for(Entry var11 = this.a(var10); var11 != null; var11 = var11.D) {
         if (var11.tag == 15 && var11.C == var10 && var11.data == (long)var1 && var11.owner.equals(var2) && var11.name.equals(var3) && var11.value.equals(var4)
            )
          {
            return var11;
         }
      }

      if (var1 <= 4) {
         this.b.a(15, var1, this.a(var2, var3, var4).index);
      } else {
         this.b.a(15, var1, this.a(var2, var3, var4, var5).index);
      }

      return this.c(new Entry(this.c++, 15, var2, var3, var4, (long)var1, var10));
   }

   private Entry a(int var1, String var2, String var3, String var4) {
      int var8 = b(var1, var2, var3, var4);

      for(Entry var9 = this.a(var8); var9 != null; var9 = var9.D) {
         if (var9.tag == var1 && var9.C == var8 && var9.owner.equals(var2) && var9.name.equals(var3) && var9.value.equals(var4)) {
            return var9;
         }
      }

      this.b.b(var1, this.c(var2).index, this.a(var3, var4));
      return this.c(new Entry(this.c++, var1, var2, var3, var4, 0L, var8));
   }

   int a(String var1, String var2) {
      boolean var6 = true;
      int var7 = a(12, var1, var2);

      for(Entry var8 = this.a(var7); var8 != null; var8 = var8.D) {
         if (var8.tag == 12 && var8.C == var7 && var8.name.equals(var1) && var8.value.equals(var2)) {
            return var8.index;
         }
      }

      this.b.b(12, this.g(var1), this.g(var2));
      return this.c(new Entry(this.c++, 12, var1, var2, var7)).index;
   }

   private void a(Asm37 var1, char[] var2) {
      byte[] var5 = var1.k;
      int var6 = var1.c();

      for(int var7 = var1.g(var6 - 2); var7 > 0; --var7) {
         String var8 = var1.f(var6, var2);
         if ("BootstrapMethods".equals(var8)) {
            this.j = var1.g(var6 + 6);
            break;
         }

         var6 += 6 + var1.e(var6 + 2);
      }

      if (this.j > 0) {
         int var16 = var6 + 8;
         int var17 = var1.e(var6 + 2) - 2;
         this.d = new Unknown257(var17);
         this.d.a(var5, var16, var17);
         int var9 = var16;

         for(int var10 = 0; var10 < this.j; ++var10) {
            int var11 = var9 - var16;
            int var12 = var1.g(var9);
            var9 += 2;
            int var13 = var1.g(var9);
            var9 += 2;

            int var14;
            int var15;
            for(var14 = var1.d(var12, var2).hashCode(); var13-- > 0; var14 ^= var1.d(var15, var2).hashCode()) {
               var15 = var1.g(var9);
               var9 += 2;
            }

            this.a(new Entry(var10, 64, (long)var11, var14 & 2147483647));
         }
      }

   }

   Unknown154 a(String var1) {
      return this.c(8, var1);
   }

   private Unknown154 a(int var1, int var2) {
      int var6 = b(var1, var2);

      for(Entry var7 = this.a(var6); var7 != null; var7 = var7.D) {
         if (var7.tag == var1 && var7.C == var6 && var7.data == (long)var2) {
            return var7;
         }
      }

      this.b.a(var1).d(var2);
      return this.c(new Entry(this.c++, var1, (long)var2, var6));
   }

   Unknown154 a(String var1, String var2, String var3) {
      return this.a(9, var1, var2, var3);
   }

   Unknown154 d(String var1) {
      return this.c(16, var1);
   }

   Unknown13(Unknown177 var1, Asm37 var2) {
      this.i = var1;
      this.h = var2;
      byte[] var3 = var2.k;
      int var4 = var2.f(1) - 1;
      int var5 = var2.j - var4;
      this.c = var2.b();
      this.b = new Unknown257(var5);
      this.b.a(var3, var4, var5);
      this.g = new Entry[this.c * 2];
      char[] var6 = new char[var2.a()];
      boolean var7 = false;

      byte var10;
      for(int var8 = 1; var8 < this.c; var8 += var10 != 5 && var10 != 6 ? 1 : 2) {
         int var9 = var2.f(var8);
         var10 = var3[var9 - 1];
         switch(var10) {
            case 1:
               this.b(var8, var2.e(var8, var6));
               break;
            case 2:
            case 13:
            case 14:
            default:
               throw new IllegalArgumentException();
            case 3:
            case 4:
               this.b(var8, var10, var2.e(var9));
               break;
            case 5:
            case 6:
               this.a(var8, var10, var2.a(var9));
               break;
            case 7:
            case 8:
            case 16:
            case 19:
            case 20:
               this.a(var8, var10, var2.f(var9, var6));
               break;
            case 9:
            case 10:
            case 11:
               int var14 = var2.f(var2.g(var9 + 2));
               this.b(var8, var10, var2.b(var9, var6), var2.f(var14, var6), var2.f(var14 + 2, var6));
               break;
            case 12:
               this.b(var8, var2.f(var9, var6), var2.f(var9 + 2, var6));
               break;
            case 15:
               int var12 = var2.f(var2.g(var9 + 1));
               int var13 = var2.f(var2.g(var12 + 2));
               this.a(var8, var2.c(var9), var2.b(var12, var6), var2.f(var13, var6), var2.f(var13 + 2, var6));
               break;
            case 17:
            case 18:
               var7 = true;
               int var11 = var2.f(var2.g(var9 + 2));
               this.a(var10, var8, var2.f(var11, var6), var2.f(var11 + 2, var6), var2.g(var9));
         }
      }

      if (var7) {
         this.a(var2, var6);
      }

   }

   public Unknown154 a(double var1) {
      return this.b(6, Double.doubleToRawLongBits(var1));
   }

   void a(Unknown257 var1) {
      var1.c(this.c).a(this.b.b, 0, this.b.c);
   }

   public int c(int var1, int var2) {
      long var6 = var1 < var2 ? (long)var1 | (long)var2 << 32 : (long)var2 | (long)var1 << 32;
      int var8 = b(130, var1 + var2);

      for(Entry var9 = this.a(var8); var9 != null; var9 = var9.D) {
         if (var9.tag == 130 && var9.C == var8 && var9.data == var6) {
            return var9.info;
         }
      }

      String var10 = this.k[var1].value;
      String var11 = this.k[var2].value;
      int var12 = this.e(this.i.b(var10, var11));
      this.c(new Entry(this.f, 130, var6, var8)).info = var12;
      return var12;
   }

   private void b(int var1, String var2) {
      this.a(new Entry(var1, 1, var2, d(1, var2)));
   }

   private void a(int var1, int var2, String var3, String var4, String var5) {
      boolean var6 = true;
      int var7 = a(15, var3, var4, var5, var2);
      this.a(new Entry(var1, 15, var3, var4, var5, (long)var2, var7));
   }

   int a() {
      return this.b.c;
   }

   Unknown154 a(Unknown137 var1, Object[] var2) {
      Unknown257 var7 = this.d;
      if (var7 == null) {
         var7 = this.d = new Unknown257();
      }

      for(Object var11 : var2) {
         this.a(var11);
      }

      int var16 = var7.c;
      var7.c(this.a(var1.c(), var1.b(), var1.a(), var1.d(), var1.e()).index);
      int var17 = var2.length;
      var7.c(var17);

      for(Object var13 : var2) {
         var7.c(this.a(var13).index);
      }

      int var19 = var7.c - var16;
      int var21 = var1.hashCode();

      for(Object var15 : var2) {
         var21 ^= var15.hashCode();
      }

      var21 &= Integer.MAX_VALUE;
      return this.a(var16, var19, var21);
   }

   public Unknown154 a(Object var1) {
      if (var1 instanceof Integer) {
         return this.b((Integer)var1);
      } else if (var1 instanceof Byte) {
         return this.b(((Byte)var1).intValue());
      } else if (var1 instanceof Character) {
         return this.b((Character)var1);
      } else if (var1 instanceof Short) {
         return this.b(((Short)var1).intValue());
      } else if (var1 instanceof Boolean) {
         return this.b((Boolean)var1 ? 1 : 0);
      } else if (var1 instanceof Float) {
         return this.a((Float)var1);
      } else if (var1 instanceof Long) {
         return this.a((Long)var1);
      } else if (var1 instanceof Double) {
         return this.a((Double)var1);
      } else if (var1 instanceof String) {
         return this.a((String)var1);
      } else if (var1 instanceof Unknown357) {
         Unknown357 var8 = (Unknown357)var1;
         int var6 = var8.k();
         if (var6 == 10) {
            return this.c(var8.h());
         } else {
            return var6 == 11 ? this.d(var8.f()) : this.c(var8.f());
         }
      } else if (var1 instanceof Unknown137) {
         Unknown137 var7 = (Unknown137)var1;
         return this.a(var7.c(), var7.b(), var7.a(), var7.d(), var7.e());
      } else if (var1 instanceof b7) {
         b7 var5 = (b7)var1;
         return this.b(var5.c(), var5.b(), var5.d(), var5.a());
      } else {
         throw new IllegalArgumentException("value " + var1);
      }
   }

   private Unknown154 a(int var1, int var2, int var3) {
      byte[] var7 = this.d.b;

      for(Entry var8 = this.a(var3); var8 != null; var8 = var8.D) {
         if (var8.tag == 64 && var8.C == var3) {
            int var9 = (int)var8.data;
            boolean var10 = true;

            for(int var11 = 0; var11 < var2; ++var11) {
               if (var7[var1 + var11] != var7[var9 + var11]) {
                  var10 = false;
                  break;
               }
            }

            if (var10) {
               this.d.c = var1;
               return var8;
            }
         }
      }

      return this.c(new Entry(this.j++, 64, (long)var1, var3));
   }

   Asm37 e() {
      return this.h;
   }

   public int a(String var1, int var2) {
      int var6 = a(129, var1, var2);

      for(Entry var7 = this.a(var6); var7 != null; var7 = var7.D) {
         if (var7.tag == 129 && var7.C == var6 && var7.data == (long)var2 && var7.value.equals(var1)) {
            return var7.index;
         }
      }

      return this.b(new Entry(this.f, 129, var1, (long)var2, var6));
   }

   public int e(String var1) {
      int var5 = d(128, var1);

      for(Entry var6 = this.a(var5); var6 != null; var6 = var6.D) {
         if (var6.tag == 128 && var6.C == var5 && var6.value.equals(var1)) {
            return var6.index;
         }
      }

      return this.b(new Entry(this.f, 128, var1, var5));
   }

   private Entry a(int var1) {
      return this.g[var1 % this.g.length];
   }
}
