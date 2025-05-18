package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown13;
import de.jpx3.intave.unknown.Unknown154;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown257;
import de.jpx3.intave.unknown.Unknown357;

public final class Asm29 extends Asm23 {
   private final boolean f;
   private final Unknown257 h;
   private final Unknown13 j;
   private Asm29 i;
   private final Asm29 e;
   private final int g;
   private int a;

   public static void a(int var0, Asm29[] var1, int var2, Unknown257 var3) {
      int var4 = 1 + 2 * var2;

      for(int var5 = 0; var5 < var2; ++var5) {
         Asm29 var6 = var1[var5];
         var4 += var6 == null ? 0 : var6.a(null) - 8;
      }

      var3.c(var0);
      var3.d(var4);
      var3.a(var2);

      for(int var9 = 0; var9 < var2; ++var9) {
         Asm29 var10 = var1[var9];
         Asm29 var7 = null;

         int var8;
         for(var8 = 0; var10 != null; var10 = var10.e) {
            var10.c();
            ++var8;
            var7 = var10;
         }

         var3.c(var8);

         for(Asm29 var11 = var7; var11 != null; var11 = var11.i) {
            var3.a(var11.h.b, 0, var11.h.c);
         }
      }

   }

   @Override
   public Asm23 a(String var1) {
      ++this.a;
      if (this.f) {
         this.h.c(this.j.g(var1));
      }

      this.h.b(91, 0);
      return new Asm29(this.j, false, this.h, null);
   }

   public static int a(Asm29 var0, Asm29 var1, Asm29 var2, Asm29 var3) {
      int var6 = 0;
      if (var0 != null) {
         var6 += var0.a("RuntimeVisibleAnnotations");
      }

      if (var1 != null) {
         var6 += var1.a("RuntimeInvisibleAnnotations");
      }

      if (var2 != null) {
         var6 += var2.a("RuntimeVisibleTypeAnnotations");
      }

      if (var3 != null) {
         var6 += var3.a("RuntimeInvisibleTypeAnnotations");
      }

      return var6;
   }

   public static int a(String var0, Asm29[] var1, int var2) {
      int var3 = 7 + 2 * var2;

      for(int var4 = 0; var4 < var2; ++var4) {
         Asm29 var5 = var1[var4];
         var3 += var5 == null ? 0 : var5.a(var0) - 8;
      }

      return var3;
   }

   @Override
   public void a(String var1, String var2, String var3) {
      ++this.a;
      if (this.f) {
         this.h.c(this.j.g(var1));
      }

      this.h.b(101, this.j.g(var2)).c(this.j.g(var3));
   }

   public void a(int var1, Unknown257 var2) {
      int var3 = 2;
      int var4 = 0;
      Asm29 var5 = this;

      Asm29 var6;
      for(var6 = null; var5 != null; var5 = var5.e) {
         var5.c();
         var3 += var5.h.c;
         ++var4;
         var6 = var5;
      }

      var2.c(var1);
      var2.d(var3);
      var2.c(var4);

      for(Asm29 var7 = var6; var7 != null; var7 = var7.i) {
         var2.a(var7.h.b, 0, var7.h.c);
      }

   }

   public static Asm29 a(Unknown13 var0, String var1, Asm29 var2) {
      Unknown257 var3 = new Unknown257();
      var3.c(var0.g(var1)).c(0);
      return new Asm29(var0, true, var3, var2);
   }

   @Override
   public Asm23 a(String var1, String var2) {
      ++this.a;
      if (this.f) {
         this.h.c(this.j.g(var1));
      }

      this.h.b(64, this.j.g(var2)).c(0);
      return new Asm29(this.j, true, this.h, null);
   }

   @Override
   public void c() {
      if (this.g != -1) {
         byte[] var1 = this.h.b;
         var1[this.g] = (byte)(this.a >>> 8);
         var1[this.g + 1] = (byte)this.a;
      }

   }

   public static Asm29 a(Unknown13 var0, int var1, Unknown186 var2, String var3, Asm29 var4) {
      Unknown257 var5 = new Unknown257();
      Asm30.a(var1, var5);
      Unknown186.a(var2, var5);
      var5.c(var0.g(var3)).c(0);
      return new Asm29(var0, true, var5, var4);
   }

   public static void a(Unknown13 var0, Asm29 var1, Asm29 var2, Asm29 var3, Asm29 var4, Unknown257 var5) {
      if (var1 != null) {
         var1.a(var0.g("RuntimeVisibleAnnotations"), var5);
      }

      if (var2 != null) {
         var2.a(var0.g("RuntimeInvisibleAnnotations"), var5);
      }

      if (var3 != null) {
         var3.a(var0.g("RuntimeVisibleTypeAnnotations"), var5);
      }

      if (var4 != null) {
         var4.a(var0.g("RuntimeInvisibleTypeAnnotations"), var5);
      }

   }

   @Override
   public void a(String var1, Object var2) {
      ++this.a;
      if (this.f) {
         this.h.c(this.j.g(var1));
      }

      if (var2 instanceof String) {
         this.h.b(115, this.j.g((String)var2));
      } else if (var2 instanceof Byte) {
         this.h.b(66, this.j.b((Byte)var2).index);
      } else if (var2 instanceof Boolean) {
         int var6 = (Boolean)var2 ? 1 : 0;
         this.h.b(90, this.j.b(var6).index);
      } else if (var2 instanceof Character) {
         this.h.b(67, this.j.b((Character)var2).index);
      } else if (var2 instanceof Short) {
         this.h.b(83, this.j.b((Short)var2).index);
      } else if (var2 instanceof Unknown357) {
         this.h.b(99, this.j.g(((Unknown357)var2).f()));
      } else if (var2 instanceof byte[]) {
         byte[] var12 = (byte[])var2;
         this.h.b(91, var12.length);

         for(byte var10 : var12) {
            this.h.b(66, this.j.b(var10).index);
         }
      } else if (var2 instanceof boolean[]) {
         boolean[] var13 = (boolean[])var2;
         this.h.b(91, var13.length);

         for(boolean var42 : var13) {
            this.h.b(90, this.j.b(var42 ? 1 : 0).index);
         }
      } else if (var2 instanceof short[]) {
         short[] var14 = (short[])var2;
         this.h.b(91, var14.length);

         for(short var43 : var14) {
            this.h.b(83, this.j.b(var43).index);
         }
      } else if (var2 instanceof char[]) {
         char[] var15 = (char[])var2;
         this.h.b(91, var15.length);

         for(char var44 : var15) {
            this.h.b(67, this.j.b(var44).index);
         }
      } else if (var2 instanceof int[]) {
         int[] var16 = (int[])var2;
         this.h.b(91, var16.length);

         for(int var45 : var16) {
            this.h.b(73, this.j.b(var45).index);
         }
      } else if (var2 instanceof long[]) {
         long[] var17 = (long[])var2;
         this.h.b(91, var17.length);

         for(long var46 : var17) {
            this.h.b(74, this.j.a(var46).index);
         }
      } else if (var2 instanceof float[]) {
         float[] var18 = (float[])var2;
         this.h.b(91, var18.length);

         for(float var47 : var18) {
            this.h.b(70, this.j.a(var47).index);
         }
      } else if (var2 instanceof double[]) {
         double[] var19 = (double[])var2;
         this.h.b(91, var19.length);

         for(double var48 : var19) {
            this.h.b(68, this.j.a(var48).index);
         }
      } else {
         Unknown154 var20 = this.j.a(var2);
         this.h.b(".s.IFJDCS".charAt(var20.tag), var20.index);
      }

   }

   public int a(String var1) {
      if (var1 != null) {
         this.j.g(var1);
      }

      int var2 = 8;

      for(Asm29 var3 = this; var3 != null; var3 = var3.e) {
         var2 += var3.h.c;
      }

      return var2;
   }

   public Asm29(Unknown13 var1, boolean var2, Unknown257 var3, Asm29 var4) {
      super(458752);
      this.j = var1;
      this.f = var2;
      this.h = var3;
      this.g = var3.c == 0 ? -1 : var3.c - 2;
      this.e = var4;
      if (var4 != null) {
         var4.i = this;
      }

   }
}
