package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.b7;
import de.jpx3.intave.qs;
import de.jpx3.intave.unknown.Unknown137;
import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown246;
import de.jpx3.intave.unknown.Unknown289;
import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.Unknown339;
import de.jpx3.intave.unknown.Unknown35;
import de.jpx3.intave.unknown.Unknown357;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.ow2.asm.RandomASMClass1;

@Relocate
public class Asm37 {
   private final String[] f;
   private final b7[] g;
   private final int[] n;
   public static final int m = 1;
   public final byte[] k;
   public static final int i = 2;
   public final int j;
   private final int h;
   public static final int l = 8;
   private static final int d = 4096;
   private final int[] a;
   @Deprecated
   public final byte[] e;
   static final int c = 256;
   public static final int b = 4;

   public String g(int var1, char[] var2) {
      return this.h(var1, var2);
   }

   public int f(int var1) {
      return this.n[var1];
   }

   public final String e(int var1, char[] var2) {
      String var3 = this.f[var1];
      if (var3 != null) {
         return var3;
      } else {
         int var4 = this.n[var1];
         return this.f[var1] = this.a(var4 + 2, this.g(var4), var2);
      }
   }

   private Unknown35 a(Unknown35[] var1, String var2, int var3, int var4, char[] var5, int var6, Unknown246[] var7) {
      for(Unknown35 var11 : var1) {
         if (var11.a.equals(var2)) {
            return var11.a(this, var3, var4, var5, var6, var7);
         }
      }

      return new Unknown35(var2).a(this, var3, var4, null, -1, null);
   }

   private void a(RandomASMClass1 var1, Unknown289 var2, int var3, int var4, String var5) {
      char[] var6 = var2.f;
      String var8 = this.g(var3, var6);
      int var9 = this.g(var3 + 2);
      String var10 = this.f(var3 + 4, var6);
      int var7 = var3 + 6;
      Asm5 var11 = var1.a(var8, var9, var10);
      if (var11 != null) {
         if (var5 != null) {
            var11.b(var5);
         }

         if (var4 != 0) {
            int var12 = this.g(var4);

            for(int var13 = var4 + 2; var12-- > 0; var13 += 2) {
               var11.a(this.c(var13, var6));
            }
         }

         int var26 = this.g(var7);
         var7 += 2;

         while(var26-- > 0) {
            String var27 = this.g(var7, var6);
            int var14 = this.g(var7 + 2);
            String var15 = this.f(var7 + 4, var6);
            var7 += 6;
            var11.a(var27, var14, var15);
         }

         int var28 = this.g(var7);

         String[] var17;
         String var29;
         int var31;
         for(var7 += 2; var28-- > 0; var11.b(var29, var31, var17)) {
            var29 = this.c(var7, var6);
            var31 = this.g(var7 + 2);
            int var16 = this.g(var7 + 4);
            var7 += 6;
            var17 = null;
            if (var16 != 0) {
               var17 = new String[var16];

               for(int var18 = 0; var18 < var16; ++var18) {
                  var17[var18] = this.g(var7, var6);
                  var7 += 2;
               }
            }
         }

         int var30 = this.g(var7);

         int var34;
         String[] var38;
         for(var7 += 2; var30-- > 0; var11.a(var32, var34, var38)) {
            var32 = this.c(var7, var6);
            var34 = this.g(var7 + 2);
            int var36 = this.g(var7 + 4);
            var7 += 6;
            var38 = null;
            if (var36 != 0) {
               var38 = new String[var36];

               for(int var19 = 0; var19 < var36; ++var19) {
                  var38[var19] = this.g(var7, var6);
                  var7 += 2;
               }
            }
         }

         var31 = this.g(var7);

         for(var7 += 2; var31-- > 0; var7 += 2) {
            var11.c(this.b(var7, var6));
         }

         var34 = this.g(var7);
         var7 += 2;

         while(var34-- > 0) {
            var17 = this.b(var7, var6);
            int var39 = this.g(var7 + 2);
            var7 += 4;
            String[] var40 = new String[var39];

            for(int var20 = 0; var20 < var39; ++var20) {
               var40[var20] = this.b(var7, var6);
               var7 += 2;
            }

            var11.a(var17, var40);
         }

         var11.a();
      }
   }

   private int[] a(Unknown338 var1, Unknown289 var2, int var3, boolean var4) {
      char[] var5 = var2.f;
      int[] var7 = new int[this.g(var3)];
      int var6 = var3 + 2;

      for(int var8 = 0; var8 < var7.length; ++var8) {
         var7[var8] = var6;
         int var9 = this.e(var6);
         switch(var9 >>> 24) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            default:
               throw new IllegalArgumentException();
            case 16:
            case 17:
            case 18:
            case 23:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
               var6 += 3;
               break;
            case 64:
            case 65:
               int var10 = this.g(var6 + 1);
               var6 += 3;

               while(var10-- > 0) {
                  int var11 = this.g(var6);
                  int var12 = this.g(var6 + 2);
                  var6 += 6;
                  this.a(var11, var2.g);
                  this.a(var11 + var12, var2.g);
               }
               break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
               var6 += 4;
         }

         int var17 = this.c(var6);
         if (var9 >>> 24 == 66) {
            Unknown186 var18 = var17 == 0 ? null : new Unknown186(this.k, var6);
            var6 += 1 + 2 * var17;
            String var19 = this.f(var6, var5);
            var6 += 2;
            var6 = this.a(var1.b(var9 & -256, var18, var19, var4), var6, true, var5);
         } else {
            var6 += 3 + 2 * var17;
            var6 = this.a(null, var6, true, var5);
         }
      }

      return var7;
   }

   private String h(int var1, char[] var2) {
      return this.f(this.n[this.g(var1)], var2);
   }

   private int c(RandomASMClass1 var1, Unknown289 var2, int var3) {
      char[] var6 = var2.f;
      String var8 = this.f(var3, var6);
      String var9 = this.f(var3 + 2, var6);
      int var7 = var3 + 4;
      int var10 = 0;
      String var11 = null;
      int var12 = 0;
      int var13 = 0;
      int var14 = 0;
      int var15 = 0;
      Unknown35 var16 = null;
      int var17 = this.g(var7);

      int var19;
      for(var7 += 2; var17-- > 0; var7 += var19) {
         String var18 = this.f(var7, var6);
         var19 = this.e(var7 + 2);
         var7 += 6;
         if ("Signature".equals(var18)) {
            var11 = this.f(var7, var6);
         } else if ("Deprecated".equals(var18)) {
            var10 |= 131072;
         } else if ("RuntimeVisibleAnnotations".equals(var18)) {
            var12 = var7;
         } else if ("RuntimeVisibleTypeAnnotations".equals(var18)) {
            var14 = var7;
         } else if ("RuntimeInvisibleAnnotations".equals(var18)) {
            var13 = var7;
         } else if ("RuntimeInvisibleTypeAnnotations".equals(var18)) {
            var15 = var7;
         } else {
            Unknown35 var20 = this.a(var2.p, var18, var7, var19, var6, -1, null);
            var20.b = var16;
            var16 = var20;
         }
      }

      Asm14 var24 = var1.a(var10, var8, var9, var11);
      if (var24 == null) {
         return var7;
      } else {
         if (var12 != 0) {
            var19 = this.g(var12);

            String var21;
            int var31;
            for(var31 = var12 + 2; var19-- > 0; var31 = this.a(var24.a(var21, true), var31, true, var6)) {
               var21 = this.f(var31, var6);
               var31 += 2;
            }
         }

         if (var13 != 0) {
            var19 = this.g(var13);

            int var33;
            String var40;
            for(var33 = var13 + 2; var19-- > 0; var33 = this.a(var24.a(var40, false), var33, true, var6)) {
               var40 = this.f(var33, var6);
               var33 += 2;
            }
         }

         if (var14 != 0) {
            var19 = this.g(var14);

            int var36;
            String var41;
            for(var36 = var14 + 2; var19-- > 0; var36 = this.a(var24.a(var2.s, var2.e, var41, true), var36, true, var6)) {
               var36 = this.a(var2, var36);
               var41 = this.f(var36, var6);
               var36 += 2;
            }
         }

         if (var15 != 0) {
            var19 = this.g(var15);

            int var39;
            String var42;
            for(var39 = var15 + 2; var19-- > 0; var39 = this.a(var24.a(var2.s, var2.e, var42, false), var39, true, var6)) {
               var39 = this.a(var2, var39);
               var42 = this.f(var39, var6);
               var39 += 2;
            }
         }

         while(var16 != null) {
            Unknown35 var29 = var16.b;
            var16.b = null;
            var24.a(var16);
            var16 = var29;
         }

         var24.b();
         return var7;
      }
   }

   private int a(int var1, boolean var2, boolean var3, Unknown289 var4) {
      int var5 = var1;
      char[] var6 = var4.f;
      Unknown246[] var7 = var4.g;
      int var8;
      if (var2) {
         var5 = var1 + 1;
         var8 = this.k[var1] & 255;
      } else {
         var8 = 255;
         var4.d = -1;
      }

      var4.m = 0;
      int var9;
      if (var8 < 64) {
         var9 = var8;
         var4.i = 3;
         var4.r = 0;
      } else if (var8 < 128) {
         var9 = var8 - 64;
         var5 = this.a(var5, var4.o, 0, var6, var7);
         var4.i = 4;
         var4.r = 1;
      } else {
         if (var8 < 247) {
            throw new IllegalArgumentException();
         }

         var9 = this.g(var5);
         var5 += 2;
         if (var8 == 247) {
            var5 = this.a(var5, var4.o, 0, var6, var7);
            var4.i = 4;
            var4.r = 1;
         } else if (var8 >= 248 && var8 < 251) {
            var4.i = 2;
            var4.m = 251 - var8;
            var4.c -= var4.m;
            var4.r = 0;
         } else if (var8 == 251) {
            var4.i = 3;
            var4.r = 0;
         } else if (var8 < 255) {
            int var10 = var3 ? var4.c : 0;

            for(int var11 = var8 - 251; var11 > 0; --var11) {
               var5 = this.a(var5, var4.q, var10++, var6, var7);
            }

            var4.i = 1;
            var4.m = var8 - 251;
            var4.c += var4.m;
            var4.r = 0;
         } else {
            int var14 = this.g(var5);
            var5 += 2;
            var4.i = 0;
            var4.m = var14;
            var4.c = var14;

            for(int var15 = 0; var15 < var14; ++var15) {
               var5 = this.a(var5, var4.q, var15, var6, var7);
            }

            int var16 = this.g(var5);
            var5 += 2;
            var4.r = var16;

            for(int var12 = 0; var12 < var16; ++var12) {
               var5 = this.a(var5, var4.o, var12, var6, var7);
            }
         }
      }

      var4.d += var9 + 1;
      this.a(var4.d, var7);
      return var5;
   }

   private int a(Asm23 var1, int var2, boolean var3, char[] var4) {
      int var6 = this.g(var2);
      int var5 = var2 + 2;
      if (var3) {
         while(var6-- > 0) {
            String var7 = this.f(var5, var4);
            var5 = this.a(var1, var5 + 2, var7, var4);
         }
      } else {
         while(var6-- > 0) {
            var5 = this.a(var1, var5, null, var4);
         }
      }

      if (var1 != null) {
         var1.c();
      }

      return var5;
   }

   public String g() {
      return this.b(this.j + 2, new char[this.h]);
   }

   public Asm37(byte[] var1, int var2, boolean var3) {
      this.k = var1;
      this.e = var1;
      if (var3 && this.b(var2 + 6) > 58) {
         throw new IllegalArgumentException("Unsupported class file major version " + this.b(var2 + 6));
      } else {
         int var6 = this.g(var2 + 8);
         this.n = new int[var6];
         this.f = new String[var6];
         int var7 = 1;
         int var8 = var2 + 10;
         int var9 = 0;
         boolean var10 = false;

         boolean var11;
         int var12;
         for(var11 = false; var7 < var6; var8 += var12) {
            this.n[var7++] = var8 + 1;
            switch(var1[var8]) {
               case 1:
                  var12 = 3 + this.g(var8 + 1);
                  if (var12 > var9) {
                     var9 = var12;
                  }
                  break;
               case 2:
               case 13:
               case 14:
               default:
                  throw new IllegalArgumentException();
               case 3:
               case 4:
               case 9:
               case 10:
               case 11:
               case 12:
                  var12 = 5;
                  break;
               case 5:
               case 6:
                  var12 = 9;
                  ++var7;
                  break;
               case 7:
               case 8:
               case 16:
               case 19:
               case 20:
                  var12 = 3;
                  break;
               case 15:
                  var12 = 4;
                  break;
               case 17:
                  var12 = 5;
                  var10 = true;
                  var11 = true;
                  break;
               case 18:
                  var12 = 5;
                  var10 = true;
            }
         }

         this.h = var9;
         this.j = var8;
         this.g = var11 ? new b7[var6] : null;
         this.a = var10 ? this.d(var9) : null;
      }
   }

   public long a(int var1) {
      long var2 = (long)this.e(var1);
      long var4 = (long)this.e(var1 + 4) & 4294967295L;
      return var2 << 32 | var4;
   }

   private int[] d(int var1) {
      char[] var4 = new char[var1];
      int var5 = this.c();
      Object var6 = null;

      for(int var7 = this.g(var5 - 2); var7 > 0; --var7) {
         String var8 = this.f(var5, var4);
         int var9 = this.e(var5 + 2);
         var5 += 6;
         if ("BootstrapMethods".equals(var8)) {
            int[] var13 = new int[this.g(var5)];
            int var10 = var5 + 2;

            for(int var11 = 0; var11 < var13.length; ++var11) {
               var13[var11] = var10;
               var10 += 4 + this.g(var10 + 2) * 2;
            }

            return var13;
         }

         var5 += var9;
      }

      throw new IllegalArgumentException();
   }

   public Asm37(InputStream var1) {
      this(a(var1, false));
   }

   public String b(int var1, char[] var2) {
      return this.h(var1, var2);
   }

   private int a(int var1, Object[] var2, int var3, char[] var4, Unknown246[] var5) {
      int var6 = var1 + 1;
      int var7 = this.k[var1] & 255;
      switch(var7) {
         case 0:
            var2[var3] = qs.bP;
            break;
         case 1:
            var2[var3] = qs.h;
            break;
         case 2:
            var2[var3] = qs.bc;
            break;
         case 3:
            var2[var3] = qs.a_;
            break;
         case 4:
            var2[var3] = qs.ad;
            break;
         case 5:
            var2[var3] = qs.cv;
            break;
         case 6:
            var2[var3] = qs.bg;
            break;
         case 7:
            var2[var3] = this.b(var6, var4);
            var6 += 2;
            break;
         case 8:
            var2[var3] = this.a(this.g(var6), var5);
            var6 += 2;
            break;
         default:
            throw new IllegalArgumentException();
      }

      return var6;
   }

   public int b() {
      return this.n.length;
   }

   public int a() {
      return this.h;
   }

   public void a(RandomASMClass1 var1, int var2) {
      this.a(var1, new Unknown35[0], var2);
   }

   private void b(int var1, Unknown246[] var2) {
      if (var2[var1] == null) {
         Unknown246 var10000 = this.c(var1, var2);
         var10000.A = (short)(var10000.A | 1);
      }

   }

   private Unknown246 a(int var1, Unknown246[] var2) {
      Unknown246 var3 = this.c(var1, var2);
      var3.A = (short)(var3.A & -2);
      return var3;
   }

   private int a(RandomASMClass1 var1, Unknown289 var2, int var3) {
      char[] var6 = var2.f;
      var2.j = this.g(var3);
      var2.l = this.f(var3 + 2, var6);
      var2.k = this.f(var3 + 4, var6);
      int var7 = var3 + 6;
      int var8 = 0;
      int var9 = 0;
      String[] var10 = null;
      boolean var11 = false;
      int var12 = 0;
      int var13 = 0;
      int var14 = 0;
      int var15 = 0;
      int var16 = 0;
      int var17 = 0;
      int var18 = 0;
      int var19 = 0;
      int var20 = 0;
      Unknown35 var21 = null;
      int var22 = this.g(var7);

      int var24;
      for(var7 += 2; var22-- > 0; var7 += var24) {
         String var23 = this.f(var7, var6);
         var24 = this.e(var7 + 2);
         var7 += 6;
         if ("Code".equals(var23)) {
            if ((var2.h & 1) == 0) {
               var8 = var7;
            }
         } else if ("Exceptions".equals(var23)) {
            var9 = var7;
            var10 = new String[this.g(var7)];
            int var38 = var7 + 2;

            for(int var26 = 0; var26 < var10.length; ++var26) {
               var10[var26] = this.b(var38, var6);
               var38 += 2;
            }
         } else if ("Signature".equals(var23)) {
            var12 = this.g(var7);
         } else if ("Deprecated".equals(var23)) {
            var2.j |= 131072;
         } else if ("RuntimeVisibleAnnotations".equals(var23)) {
            var13 = var7;
         } else if ("RuntimeVisibleTypeAnnotations".equals(var23)) {
            var17 = var7;
         } else if ("AnnotationDefault".equals(var23)) {
            var19 = var7;
         } else if ("Synthetic".equals(var23)) {
            var11 = true;
            var2.j |= 4096;
         } else if ("RuntimeInvisibleAnnotations".equals(var23)) {
            var14 = var7;
         } else if ("RuntimeInvisibleTypeAnnotations".equals(var23)) {
            var18 = var7;
         } else if ("RuntimeVisibleParameterAnnotations".equals(var23)) {
            var15 = var7;
         } else if ("RuntimeInvisibleParameterAnnotations".equals(var23)) {
            var16 = var7;
         } else if ("MethodParameters".equals(var23)) {
            var20 = var7;
         } else {
            Unknown35 var25 = this.a(var2.p, var23, var7, var24, var6, -1, null);
            var25.b = var21;
            var21 = var25;
         }
      }

      Unknown338 var29 = var1.a(var2.j, var2.l, var2.k, var12 == 0 ? null : this.e(var12, var6), var10);
      if (var29 == null) {
         return var7;
      } else {
         if (var29 instanceof Unknown339) {
            Unknown339 var30 = (Unknown339)var29;
            if (var30.a(this, var11, (var2.j & 131072) != 0, this.g(var3 + 4), var12, var9)) {
               var30.e(var3, var7 - var3);
               return var7;
            }
         }

         if (var20 != 0 && (var2.h & 2) == 0) {
            var24 = this.c(var20);

            for(int var39 = var20 + 1; var24-- > 0; var39 += 4) {
               var29.a(this.f(var39, var6), this.g(var39 + 2));
            }
         }

         if (var19 != 0) {
            Asm23 var32 = var29.d();
            this.a(var32, var19, null, var6);
            if (var32 != null) {
               var32.c();
            }
         }

         if (var13 != 0) {
            var24 = this.g(var13);

            int var41;
            String var50;
            for(var41 = var13 + 2; var24-- > 0; var41 = this.a(var29.a(var50, true), var41, true, var6)) {
               var50 = this.f(var41, var6);
               var41 += 2;
            }
         }

         if (var14 != 0) {
            var24 = this.g(var14);

            int var43;
            String var51;
            for(var43 = var14 + 2; var24-- > 0; var43 = this.a(var29.a(var51, false), var43, true, var6)) {
               var51 = this.f(var43, var6);
               var43 += 2;
            }
         }

         if (var17 != 0) {
            var24 = this.g(var17);

            int var46;
            String var52;
            for(var46 = var17 + 2; var24-- > 0; var46 = this.a(var29.c(var2.s, var2.e, var52, true), var46, true, var6)) {
               var46 = this.a(var2, var46);
               var52 = this.f(var46, var6);
               var46 += 2;
            }
         }

         if (var18 != 0) {
            var24 = this.g(var18);

            int var49;
            String var53;
            for(var49 = var18 + 2; var24-- > 0; var49 = this.a(var29.c(var2.s, var2.e, var53, false), var49, true, var6)) {
               var49 = this.a(var2, var49);
               var53 = this.f(var49, var6);
               var49 += 2;
            }
         }

         if (var15 != 0) {
            this.b(var29, var2, var15, true);
         }

         if (var16 != 0) {
            this.b(var29, var2, var16, false);
         }

         while(var21 != null) {
            Unknown35 var37 = var21.b;
            var21.b = null;
            var29.a(var21);
            var21 = var37;
         }

         if (var8 != 0) {
            var29.c();
            this.a(var29, var2, var8);
         }

         var29.e();
         return var7;
      }
   }

   private void a(Unknown338 var1, Unknown289 var2, int var3) {
      byte[] var7 = this.k;
      char[] var8 = var2.f;
      int var9 = this.g(var3);
      int var10 = this.g(var3 + 2);
      int var11 = this.e(var3 + 4);
      int var6 = var3 + 8;
      int var12 = var6;
      int var13 = var6 + var11;
      Unknown246[] var14 = var2.g = new Unknown246[var11 + 1];

      while(var6 < var13) {
         int var15 = var6 - var12;
         int var16 = var7[var6] & 255;
         switch(var16) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 190:
            case 191:
            case 194:
            case 195:
               ++var6;
               break;
            case 16:
            case 18:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 169:
            case 188:
               var6 += 2;
               break;
            case 17:
            case 19:
            case 20:
            case 132:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 187:
            case 189:
            case 192:
            case 193:
               var6 += 3;
               break;
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 198:
            case 199:
               this.a(var15 + this.b(var6 + 1), var14);
               var6 += 3;
               break;
            case 170:
               var6 += 4 - (var15 & 3);
               this.a(var15 + this.e(var6), var14);
               int var17 = this.e(var6 + 8) - this.e(var6 + 4) + 1;

               for(var6 += 12; var17-- > 0; var6 += 4) {
                  this.a(var15 + this.e(var6), var14);
               }
               break label1;
            case 171:
               var6 += 4 - (var15 & 3);
               this.a(var15 + this.e(var6), var14);
               int var18 = this.e(var6 + 4);

               for(var6 += 8; var18-- > 0; var6 += 8) {
                  this.a(var15 + this.e(var6 + 4), var14);
               }
               break label1;
            case 185:
            case 186:
               var6 += 5;
               break;
            case 196:
               switch(var7[var6 + 1] & 0xFF) {
                  case 21:
                  case 22:
                  case 23:
                  case 24:
                  case 25:
                  case 54:
                  case 55:
                  case 56:
                  case 57:
                  case 58:
                  case 169:
                     var6 += 4;
                     continue;
                  case 132:
                     var6 += 6;
                     continue;
                  default:
                     throw new IllegalArgumentException();
               }
            case 197:
               var6 += 4;
               break;
            case 200:
            case 201:
            case 220:
               this.a(var15 + this.e(var6 + 1), var14);
               var6 += 5;
               break;
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
            case 216:
            case 217:
            case 218:
            case 219:
               this.a(var15 + this.g(var6 + 1), var14);
               var6 += 3;
               break;
            default:
               throw new IllegalArgumentException();
         }
      }

      int var57 = this.g(var6);
      var6 += 2;

      while(var57-- > 0) {
         Unknown246 var58 = this.a(this.g(var6), var14);
         Unknown246 var60 = this.a(this.g(var6 + 2), var14);
         Unknown246 var62 = this.a(this.g(var6 + 4), var14);
         String var19 = this.f(this.n[this.g(var6 + 6)], var8);
         var6 += 8;
         var1.a(var58, var60, var62, var19);
      }

      int var59 = 0;
      int var61 = 0;
      boolean var63 = true;
      int var64 = 0;
      int var20 = 0;
      int[] var21 = null;
      int[] var22 = null;
      Unknown35 var23 = null;
      int var24 = this.g(var6);

      int var26;
      for(var6 += 2; var24-- > 0; var6 += var26) {
         String var25 = this.f(var6, var8);
         var26 = this.e(var6 + 2);
         var6 += 6;
         if ("LocalVariableTable".equals(var25)) {
            if ((var2.h & 2) == 0) {
               var64 = var6;
               int var72 = this.g(var6);

               for(int var69 = var6 + 2; var72-- > 0; var69 += 10) {
                  int var74 = this.g(var69);
                  this.b(var74, var14);
                  int var76 = this.g(var69 + 2);
                  this.b(var74 + var76, var14);
               }
            }
         } else if ("LocalVariableTypeTable".equals(var25)) {
            var20 = var6;
         } else if ("LineNumberTable".equals(var25)) {
            if ((var2.h & 2) == 0) {
               int var28 = this.g(var6);
               int var68 = var6 + 2;

               while(var28-- > 0) {
                  int var29 = this.g(var68);
                  int var30 = this.g(var68 + 2);
                  var68 += 4;
                  this.b(var29, var14);
                  var14[var29].a(var30);
               }
            }
         } else if ("RuntimeVisibleTypeAnnotations".equals(var25)) {
            var21 = this.a(var1, var2, var6, true);
         } else if ("RuntimeInvisibleTypeAnnotations".equals(var25)) {
            var22 = this.a(var1, var2, var6, false);
         } else if ("StackMapTable".equals(var25)) {
            if ((var2.h & 4) == 0) {
               var59 = var6 + 2;
               var61 = var6 + var26;
            }
         } else if ("StackMap".equals(var25)) {
            if ((var2.h & 4) == 0) {
               var59 = var6 + 2;
               var61 = var6 + var26;
               var63 = false;
            }
         } else {
            Unknown35 var27 = this.a(var2.p, var25, var6, var26, var8, var3, var14);
            var27.b = var23;
            var23 = var27;
         }
      }

      boolean var65 = (var2.h & 8) != 0;
      if (var59 != 0) {
         var2.d = -1;
         var2.i = 0;
         var2.c = 0;
         var2.m = 0;
         var2.q = new Object[var10];
         var2.r = 0;
         var2.o = new Object[var9];
         if (var65) {
            this.a(var2);
         }

         for(int var66 = var59; var66 < var61 - 2; ++var66) {
            if (var7[var66] == 8) {
               int var70 = this.g(var66 + 1);
               if (var70 >= 0 && var70 < var11 && (var7[var12 + var70] & 255) == 187) {
                  this.a(var70, var14);
               }
            }
         }
      }

      if (var65 && (var2.h & 256) != 0) {
         var1.a(-1, var10, null, 0, null);
      }

      var26 = 0;
      int var71 = this.a(var21, 0);
      int var73 = 0;
      int var75 = this.a(var22, 0);
      boolean var77 = false;
      int var31 = (var2.h & 256) == 0 ? 33 : 0;
      var6 = var12;

      while(var6 < var13) {
         int var32 = var6 - var12;
         Unknown246 var33 = var14[var32];
         if (var33 != null) {
            var33.a(var1, (var2.h & 2) == 0);
         }

         while(var59 != 0 && (var2.d == var32 || var2.d == -1)) {
            if (var2.d != -1) {
               if (var63 && !var65) {
                  var1.a(var2.i, var2.m, var2.q, var2.r, var2.o);
               } else {
                  var1.a(-1, var2.c, var2.q, var2.r, var2.o);
               }

               var77 = false;
            }

            if (var59 < var61) {
               var59 = this.a(var59, var63, var65, var2);
            } else {
               var59 = 0;
            }
         }

         if (var77) {
            if ((var2.h & 8) != 0) {
               var1.a(256, 0, null, 0, null);
            }

            var77 = false;
         }

         int var34 = var7[var6] & 255;
         switch(var34) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 190:
            case 191:
            case 194:
            case 195:
               var1.a(var34);
               ++var6;
               break;
            case 16:
            case 188:
               var1.c(var34, var7[var6 + 1]);
               var6 += 2;
               break;
            case 17:
               var1.c(var34, this.b(var6 + 1));
               var6 += 3;
               break;
            case 18:
               var1.a(this.d(var7[var6 + 1] & 255, var8));
               var6 += 2;
               break;
            case 19:
            case 20:
               var1.a(this.d(this.g(var6 + 1), var8));
               var6 += 3;
               break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 169:
               var1.d(var34, var7[var6 + 1] & 255);
               var6 += 2;
               break;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
               var34 -= 26;
               var1.d(21 + (var34 >> 2), var34 & 3);
               ++var6;
               break;
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
               var34 -= 59;
               var1.d(54 + (var34 >> 2), var34 & 3);
               ++var6;
               break;
            case 132:
               var1.a(var7[var6 + 1] & 255, var7[var6 + 2]);
               var6 += 3;
               break;
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 198:
            case 199:
               var1.a(var34, var14[var32 + this.b(var6 + 1)]);
               var6 += 3;
               break;
            case 170:
               var6 += 4 - (var32 & 3);
               Unknown246 var99 = var14[var32 + this.e(var6)];
               int var110 = this.e(var6 + 4);
               int var118 = this.e(var6 + 8);
               var6 += 12;
               Unknown246[] var124 = new Unknown246[var118 - var110 + 1];

               for(int var129 = 0; var129 < var124.length; ++var129) {
                  var124[var129] = var14[var32 + this.e(var6)];
                  var6 += 4;
               }

               var1.a(var110, var118, var99, var124);
               break;
            case 171:
               var6 += 4 - (var32 & 3);
               Unknown246 var98 = var14[var32 + this.e(var6)];
               int var109 = this.e(var6 + 4);
               var6 += 8;
               int[] var117 = new int[var109];
               Unknown246[] var123 = new Unknown246[var109];

               for(int var128 = 0; var128 < var109; ++var128) {
                  var117[var128] = this.e(var6);
                  var123[var128] = var14[var32 + this.e(var6 + 4)];
                  var6 += 8;
               }

               var1.a(var98, var117, var123);
               break;
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
               int var97 = this.n[this.g(var6 + 1)];
               int var108 = this.n[this.g(var97 + 2)];
               String var116 = this.b(var97, var8);
               String var122 = this.f(var108, var8);
               String var127 = this.f(var108 + 2, var8);
               if (var34 < 182) {
                  var1.b(var34, var116, var122, var127);
               } else {
                  boolean var131 = var7[var97 - 1] == 11;
                  var1.visit(var34, var116, var122, var127, var131);
               }

               if (var34 == 185) {
                  var6 += 5;
               } else {
                  var6 += 3;
               }
               break;
            case 186:
               int var96 = this.n[this.g(var6 + 1)];
               int var107 = this.n[this.g(var96 + 2)];
               String var37 = this.f(var107, var8);
               String var38 = this.f(var107 + 2, var8);
               int var39 = this.a[this.g(var96)];
               Unknown137 var40 = (Unknown137)this.d(this.g(var39), var8);
               Object[] var41 = new Object[this.g(var39 + 2)];
               var39 += 4;

               for(int var42 = 0; var42 < var41.length; ++var42) {
                  var41[var42] = this.d(this.g(var39), var8);
                  var39 += 2;
               }

               var1.a(var37, var38, var40, var41);
               var6 += 5;
               break;
            case 187:
            case 189:
            case 192:
            case 193:
               var1.a(var34, this.b(var6 + 1, var8));
               var6 += 3;
               break;
            case 196:
               var34 = var7[var6 + 1] & 255;
               if (var34 == 132) {
                  var1.a(this.g(var6 + 2), this.b(var6 + 4));
                  var6 += 6;
               } else {
                  var1.d(var34, this.g(var6 + 2));
                  var6 += 4;
               }
               break;
            case 197:
               var1.b(this.b(var6 + 1, var8), var7[var6 + 3] & 255);
               var6 += 4;
               break;
            case 200:
            case 201:
               var1.a(var34 - var31, var14[var32 + this.e(var6 + 1)]);
               var6 += 5;
               break;
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
            case 216:
            case 217:
            case 218:
            case 219:
               var34 = var34 < 218 ? var34 - 49 : var34 - 20;
               Unknown246 var35 = var14[var32 + this.g(var6 + 1)];
               if (var34 != 167 && var34 != 168) {
                  var34 = var34 < 167 ? (var34 + 1 ^ 1) - 1 : var34 ^ 1;
                  Unknown246 var36 = this.a(var32 + 3, var14);
                  var1.a(var34, var36);
                  var1.a(200, var35);
                  var77 = true;
               } else {
                  var1.a(var34 + 33, var35);
               }

               var6 += 3;
               break;
            case 220:
               var1.a(200, var14[var32 + this.e(var6 + 1)]);
               var77 = true;
               var6 += 5;
               break;
            default:
               throw new AssertionError();
         }

         for(; var21 != null && var26 < var21.length && var71 <= var32; var71 = this.a(var21, ++var26)) {
            if (var71 == var32) {
               int var100 = this.a(var2, var21[var26]);
               String var111 = this.f(var100, var8);
               var100 += 2;
               this.a(var1.a(var2.s, var2.e, var111, true), var100, true, var8);
            }
         }

         for(; var22 != null && var73 < var22.length && var75 <= var32; var75 = this.a(var22, ++var73)) {
            if (var75 == var32) {
               int var102 = this.a(var2, var22[var73]);
               String var112 = this.f(var102, var8);
               var102 += 2;
               this.a(var1.a(var2.s, var2.e, var112, false), var102, true, var8);
            }
         }
      }

      if (var14[var11] != null) {
         var1.a(var14[var11]);
      }

      if (var64 != 0 && (var2.h & 2) == 0) {
         int[] var78 = null;
         if (var20 != 0) {
            var78 = new int[this.g(var20) * 3];
            var6 = var20 + 2;

            for(int var82 = var78.length; var82 > 0; var6 += 10) {
               --var82;
               var78[var82] = var6 + 6;
               --var82;
               var78[var82] = this.g(var6 + 8);
               --var82;
               var78[var82] = this.g(var6);
            }
         }

         int var85 = this.g(var64);

         int var93;
         int var104;
         String var113;
         String var119;
         int var125;
         String var130;
         for(int var52 = var64 + 2; var85-- > 0; var1.a(var113, var119, var130, var14[var93], var14[var93 + var104], var125)) {
            var93 = this.g(var52);
            var104 = this.g(var52 + 2);
            var113 = this.f(var52 + 4, var8);
            var119 = this.f(var52 + 6, var8);
            var125 = this.g(var52 + 8);
            var52 += 10;
            var130 = null;
            if (var78 != null) {
               for(int var132 = 0; var132 < var78.length; var132 += 3) {
                  if (var78[var132] == var93 && var78[var132 + 1] == var125) {
                     var130 = this.f(var78[var132 + 2], var8);
                     break;
                  }
               }
            }
         }
      }

      if (var21 != null) {
         for(int var105 : var21) {
            int var114 = this.c(var105);
            if (var114 == 64 || var114 == 65) {
               var6 = this.a(var2, var105);
               String var120 = this.f(var6, var8);
               var6 += 2;
               this.a(var1.a(var2.s, var2.e, var2.b, var2.a, var2.n, var120, true), var6, true, var8);
            }
         }
      }

      if (var22 != null) {
         for(int var106 : var22) {
            int var115 = this.c(var106);
            if (var115 == 64 || var115 == 65) {
               var6 = this.a(var2, var106);
               String var121 = this.f(var6, var8);
               var6 += 2;
               this.a(var1.a(var2.s, var2.e, var2.b, var2.a, var2.n, var121, false), var6, true, var8);
            }
         }
      }

      while(var23 != null) {
         Unknown35 var81 = var23.b;
         var23.b = null;
         var1.a(var23);
         var23 = var81;
      }

      var1.b(var9, var10);
   }

   public Asm37(String var1) {
      this(a(ClassLoader.getSystemResourceAsStream(var1.replace('.', '/') + ".class"), true));
   }

   public int c(int var1) {
      return this.k[var1] & 0xFF;
   }

   public int g(int var1) {
      byte[] var2 = this.k;
      return (var2[var1] & 0xFF) << 8 | var2[var1 + 1] & 0xFF;
   }

   public String e() {
      return this.b(this.j + 4, new char[this.h]);
   }

   private int a(int[] var1, int var2) {
      return var1 != null && var2 < var1.length && this.c(var1[var2]) >= 67 ? this.g(var1[var2] + 1) : -1;
   }

   public Asm37(byte[] var1, int var2, int var3) {
      this(var1, var2, true);
   }

   public String c(int var1, char[] var2) {
      return this.h(var1, var2);
   }

   public void a(RandomASMClass1 var1, Unknown35[] var2, int var3) {
      Unknown289 var6 = new Unknown289();
      var6.p = var2;
      var6.h = var3;
      var6.f = new char[this.h];
      char[] var7 = var6.f;
      int var8 = this.j;
      int var9 = this.g(var8);
      String var10 = this.b(var8 + 2, var7);
      String var11 = this.b(var8 + 4, var7);
      String[] var12 = new String[this.g(var8 + 6)];
      var8 += 8;

      for(int var13 = 0; var13 < var12.length; ++var13) {
         var12[var13] = this.b(var8, var7);
         var8 += 2;
      }

      int var38 = 0;
      int var14 = 0;
      String var15 = null;
      String var16 = null;
      String var17 = null;
      int var18 = 0;
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      int var23 = 0;
      String var24 = null;
      String var25 = null;
      int var26 = 0;
      int var27 = 0;
      int var28 = 0;
      Unknown35 var29 = null;
      int var30 = this.c();

      for(int var31 = this.g(var30 - 2); var31 > 0; --var31) {
         String var32 = this.f(var30, var7);
         int var33 = this.e(var30 + 2);
         var30 += 6;
         if ("SourceFile".equals(var32)) {
            var16 = this.f(var30, var7);
         } else if ("InnerClasses".equals(var32)) {
            var38 = var30;
         } else if ("EnclosingMethod".equals(var32)) {
            var14 = var30;
         } else if ("NestHost".equals(var32)) {
            var25 = this.b(var30, var7);
         } else if ("NestMembers".equals(var32)) {
            var26 = var30;
         } else if ("PermittedSubtypes".equals(var32)) {
            var27 = var30;
         } else if ("Signature".equals(var32)) {
            var15 = this.f(var30, var7);
         } else if ("RuntimeVisibleAnnotations".equals(var32)) {
            var18 = var30;
         } else if ("RuntimeVisibleTypeAnnotations".equals(var32)) {
            var20 = var30;
         } else if ("Deprecated".equals(var32)) {
            var9 |= 131072;
         } else if ("Synthetic".equals(var32)) {
            var9 |= 4096;
         } else if ("SourceDebugExtension".equals(var32)) {
            var17 = this.a(var30, var33, new char[var33]);
         } else if ("RuntimeInvisibleAnnotations".equals(var32)) {
            var19 = var30;
         } else if ("RuntimeInvisibleTypeAnnotations".equals(var32)) {
            var21 = var30;
         } else if ("Record".equals(var32)) {
            var28 = var30;
         } else if ("Module".equals(var32)) {
            var22 = var30;
         } else if ("ModuleMainClass".equals(var32)) {
            var24 = this.b(var30, var7);
         } else if ("ModulePackages".equals(var32)) {
            var23 = var30;
         } else if (!"BootstrapMethods".equals(var32)) {
            Unknown35 var34 = this.a(var2, var32, var30, var33, var7, -1, null);
            var34.b = var29;
            var29 = var34;
         }

         var30 += var33;
      }

      var1.a(this.e(this.n[1] - 7), var9, var10, var15, var11, var12);
      if ((var3 & 2) == 0 && (var16 != null || var17 != null)) {
         var1.a(var16, var17);
      }

      if (var22 != 0) {
         this.a(var1, var6, var22, var23, var24);
      }

      if (var25 != null) {
         var1.a(var25);
      }

      if (var14 != 0) {
         String var41 = this.b(var14, var7);
         int var52 = this.g(var14 + 2);
         String var67 = var52 == 0 ? null : this.f(this.n[var52], var7);
         String var72 = var52 == 0 ? null : this.f(this.n[var52] + 2, var7);
         var1.a(var41, var67, var72);
      }

      if (var18 != 0) {
         int var42 = this.g(var18);

         int var54;
         String var68;
         for(var54 = var18 + 2; var42-- > 0; var54 = this.a(var1.a(var68, true), var54, true, var7)) {
            var68 = this.f(var54, var7);
            var54 += 2;
         }
      }

      if (var19 != 0) {
         int var43 = this.g(var19);

         int var56;
         String var69;
         for(var56 = var19 + 2; var43-- > 0; var56 = this.a(var1.a(var69, false), var56, true, var7)) {
            var69 = this.f(var56, var7);
            var56 += 2;
         }
      }

      if (var20 != 0) {
         int var44 = this.g(var20);

         int var59;
         String var70;
         for(var59 = var20 + 2; var44-- > 0; var59 = this.a(var1.a(var6.s, var6.e, var70, true), var59, true, var7)) {
            var59 = this.a(var6, var59);
            var70 = this.f(var59, var7);
            var59 += 2;
         }
      }

      if (var21 != 0) {
         int var45 = this.g(var21);

         int var62;
         String var71;
         for(var62 = var21 + 2; var45-- > 0; var62 = this.a(var1.a(var6.s, var6.e, var71, false), var62, true, var7)) {
            var62 = this.a(var6, var62);
            var71 = this.f(var62, var7);
            var62 += 2;
         }
      }

      while(var29 != null) {
         Unknown35 var46 = var29.b;
         var29.b = null;
         var1.a(var29);
         var29 = var46;
      }

      if (var26 != 0) {
         int var47 = this.g(var26);

         for(int var63 = var26 + 2; var47-- > 0; var63 += 2) {
            var1.c(this.b(var63, var7));
         }
      }

      if (var27 != 0) {
         int var48 = this.g(var27);

         for(int var64 = var27 + 2; var48-- > 0; var64 += 2) {
            var1.b(this.b(var64, var7));
         }
      }

      if (var38 != 0) {
         int var49 = this.g(var38);

         for(int var65 = var38 + 2; var49-- > 0; var65 += 8) {
            var1.a(this.b(var65, var7), this.b(var65 + 2, var7), this.f(var65 + 4, var7), this.g(var65 + 6));
         }
      }

      if (var28 != 0) {
         int var50 = this.g(var28);
         var28 += 2;

         while(var50-- > 0) {
            var28 = this.c(var1, var6, var28);
         }
      }

      int var51 = this.g(var8);
      var8 += 2;

      while(var51-- > 0) {
         var8 = this.b(var1, var6, var8);
      }

      int var66 = this.g(var8);
      var8 += 2;

      while(var66-- > 0) {
         var8 = this.a(var1, var6, var8);
      }

      var1.a();
   }

   public String f(int var1, char[] var2) {
      int var3 = this.g(var1);
      return var1 != 0 && var3 != 0 ? this.e(var3, var2) : null;
   }

   private int a(Asm23 var1, int var2, String var3, char[] var4) {
      if (var1 == null) {
         switch(this.k[var2] & 0xFF) {
            case 64:
               return this.a(null, var2 + 3, true, var4);
            case 91:
               return this.a(null, var2 + 1, false, var4);
            case 101:
               return var2 + 5;
            default:
               return var2 + 3;
         }
      } else {
         int var5 = var2 + 1;
         switch(this.k[var2] & 0xFF) {
            case 64:
               var5 = this.a(var1.a(var3, this.f(var5, var4)), var5 + 2, true, var4);
               break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            default:
               throw new IllegalArgumentException();
            case 66:
               var1.a(var3, (byte)this.e(this.n[this.g(var5)]));
               var5 += 2;
               break;
            case 67:
               var1.a(var3, (char)this.e(this.n[this.g(var5)]));
               var5 += 2;
               break;
            case 68:
            case 70:
            case 73:
            case 74:
               var1.a(var3, this.d(this.g(var5), var4));
               var5 += 2;
               break;
            case 83:
               var1.a(var3, (short)this.e(this.n[this.g(var5)]));
               var5 += 2;
               break;
            case 90:
               var1.a(var3, this.e(this.n[this.g(var5)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
               var5 += 2;
               break;
            case 91:
               int var6 = this.g(var5);
               var5 += 2;
               if (var6 == 0) {
                  return this.a(var1.a(var3), var5 - 2, false, var4);
               }

               switch(this.k[var5] & 0xFF) {
                  case 66:
                     byte[] var7 = new byte[var6];

                     for(int var17 = 0; var17 < var6; ++var17) {
                        var7[var17] = (byte)this.e(this.n[this.g(var5 + 1)]);
                        var5 += 3;
                     }

                     var1.a(var3, var7);
                     return var5;
                  case 67:
                     char[] var19 = new char[var6];

                     for(int var20 = 0; var20 < var6; ++var20) {
                        var19[var20] = (char)this.e(this.n[this.g(var5 + 1)]);
                        var5 += 3;
                     }

                     var1.a(var3, var19);
                     return var5;
                  case 68:
                     double[] var23 = new double[var6];

                     for(int var15 = 0; var15 < var6; ++var15) {
                        var23[var15] = Double.longBitsToDouble(this.a(this.n[this.g(var5 + 1)]));
                        var5 += 3;
                     }

                     var1.a(var3, var23);
                     return var5;
                  case 69:
                  case 71:
                  case 72:
                  case 75:
                  case 76:
                  case 77:
                  case 78:
                  case 79:
                  case 80:
                  case 81:
                  case 82:
                  case 84:
                  case 85:
                  case 86:
                  case 87:
                  case 88:
                  case 89:
                  default:
                     var5 = this.a(var1.a(var3), var5 - 2, false, var4);
                     return var5;
                  case 70:
                     float[] var22 = new float[var6];

                     for(int var14 = 0; var14 < var6; ++var14) {
                        var22[var14] = Float.intBitsToFloat(this.e(this.n[this.g(var5 + 1)]));
                        var5 += 3;
                     }

                     var1.a(var3, var22);
                     return var5;
                  case 73:
                     int[] var11 = new int[var6];

                     for(int var21 = 0; var21 < var6; ++var21) {
                        var11[var21] = this.e(this.n[this.g(var5 + 1)]);
                        var5 += 3;
                     }

                     var1.a(var3, var11);
                     return var5;
                  case 74:
                     long[] var12 = new long[var6];

                     for(int var13 = 0; var13 < var6; ++var13) {
                        var12[var13] = this.a(this.n[this.g(var5 + 1)]);
                        var5 += 3;
                     }

                     var1.a(var3, var12);
                     return var5;
                  case 83:
                     short[] var18 = new short[var6];

                     for(int var10 = 0; var10 < var6; ++var10) {
                        var18[var10] = (short)this.e(this.n[this.g(var5 + 1)]);
                        var5 += 3;
                     }

                     var1.a(var3, var18);
                     return var5;
                  case 90:
                     boolean[] var8 = new boolean[var6];

                     for(int var9 = 0; var9 < var6; ++var9) {
                        var8[var9] = this.e(this.n[this.g(var5 + 1)]) != 0;
                        var5 += 3;
                     }

                     var1.a(var3, var8);
                     return var5;
               }
            case 99:
               var1.a(var3, Unknown357.a(this.f(var5, var4)));
               var5 += 2;
               break;
            case 101:
               var1.a(var3, this.f(var5, var4), this.f(var5 + 2, var4));
               var5 += 4;
               break;
            case 115:
               var1.a(var3, this.f(var5, var4));
               var5 += 2;
         }

         return var5;
      }
   }

   private int b(RandomASMClass1 var1, Unknown289 var2, int var3) {
      char[] var6 = var2.f;
      int var8 = this.g(var3);
      String var9 = this.f(var3 + 2, var6);
      String var10 = this.f(var3 + 4, var6);
      int var7 = var3 + 6;
      Object var11 = null;
      String var12 = null;
      int var13 = 0;
      int var14 = 0;
      int var15 = 0;
      int var16 = 0;
      Unknown35 var17 = null;
      int var18 = this.g(var7);

      int var20;
      for(var7 += 2; var18-- > 0; var7 += var20) {
         String var19 = this.f(var7, var6);
         var20 = this.e(var7 + 2);
         var7 += 6;
         if ("ConstantValue".equals(var19)) {
            int var21 = this.g(var7);
            var11 = var21 == 0 ? null : this.d(var21, var6);
         } else if ("Signature".equals(var19)) {
            var12 = this.f(var7, var6);
         } else if ("Deprecated".equals(var19)) {
            var8 |= 131072;
         } else if ("Synthetic".equals(var19)) {
            var8 |= 4096;
         } else if ("RuntimeVisibleAnnotations".equals(var19)) {
            var13 = var7;
         } else if ("RuntimeVisibleTypeAnnotations".equals(var19)) {
            var15 = var7;
         } else if ("RuntimeInvisibleAnnotations".equals(var19)) {
            var14 = var7;
         } else if ("RuntimeInvisibleTypeAnnotations".equals(var19)) {
            var16 = var7;
         } else {
            Unknown35 var31 = this.a(var2.p, var19, var7, var20, var6, -1, null);
            var31.b = var17;
            var17 = var31;
         }
      }

      Asm26 var25 = var1.a(var8, var9, var10, var12, var11);
      if (var25 == null) {
         return var7;
      } else {
         if (var13 != 0) {
            var20 = this.g(var13);

            String var22;
            int var33;
            for(var33 = var13 + 2; var20-- > 0; var33 = this.a(var25.a(var22, true), var33, true, var6)) {
               var22 = this.f(var33, var6);
               var33 += 2;
            }
         }

         if (var14 != 0) {
            var20 = this.g(var14);

            int var35;
            String var42;
            for(var35 = var14 + 2; var20-- > 0; var35 = this.a(var25.a(var42, false), var35, true, var6)) {
               var42 = this.f(var35, var6);
               var35 += 2;
            }
         }

         if (var15 != 0) {
            var20 = this.g(var15);

            int var38;
            String var43;
            for(var38 = var15 + 2; var20-- > 0; var38 = this.a(var25.a(var2.s, var2.e, var43, true), var38, true, var6)) {
               var38 = this.a(var2, var38);
               var43 = this.f(var38, var6);
               var38 += 2;
            }
         }

         if (var16 != 0) {
            var20 = this.g(var16);

            int var41;
            String var44;
            for(var41 = var16 + 2; var20-- > 0; var41 = this.a(var25.a(var2.s, var2.e, var44, false), var41, true, var6)) {
               var41 = this.a(var2, var41);
               var44 = this.f(var41, var6);
               var41 += 2;
            }
         }

         while(var17 != null) {
            Unknown35 var30 = var17.b;
            var17.b = null;
            var25.a(var17);
            var17 = var30;
         }

         var25.a();
         return var7;
      }
   }

   private void a(Unknown289 var1) {
      String var4 = var1.k;
      Object[] var5 = var1.q;
      int var6 = 0;
      if ((var1.j & 8) == 0) {
         if ("<init>".equals(var1.l)) {
            var5[var6++] = qs.bg;
         } else {
            var5[var6++] = this.b(this.j + 2, var1.f);
         }
      }

      int var7 = 1;

      while(true) {
         int var8 = var7;
         switch(var4.charAt(var7++)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
               var5[var6++] = qs.h;
               break;
            case 'D':
               var5[var6++] = qs.a_;
               break;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            default:
               var1.c = var6;
               return;
            case 'F':
               var5[var6++] = qs.bc;
               break;
            case 'J':
               var5[var6++] = qs.ad;
               break;
            case 'L':
               while(var4.charAt(var7) != ';') {
                  ++var7;
               }

               var5[var6++] = var4.substring(var8 + 1, var7++);
               break;
            case '[':
               while(var4.charAt(var7) == '[') {
                  ++var7;
               }

               if (var4.charAt(var7) == 'L') {
                  ++var7;

                  while(var4.charAt(var7) != ';') {
                     ++var7;
                  }
               }

               var5[var6++] = var4.substring(var8, ++var7);
         }
      }
   }

   public String[] f() {
      int var1 = this.j + 6;
      int var2 = this.g(var1);
      String[] var3 = new String[var2];
      if (var2 > 0) {
         char[] var4 = new char[this.h];

         for(int var5 = 0; var5 < var2; ++var5) {
            var1 += 2;
            var3[var5] = this.b(var1, var4);
         }
      }

      return var3;
   }

   public int e(int var1) {
      byte[] var2 = this.k;
      return (var2[var1] & 0xFF) << 24 | (var2[var1 + 1] & 0xFF) << 16 | (var2[var1 + 2] & 0xFF) << 8 | var2[var1 + 3] & 0xFF;
   }

   private static byte[] a(InputStream var0, boolean var1) {
      if (var0 == null) {
         throw new IOException("Class not found");
      } else {
         byte[] var8;
         try {
            ByteArrayOutputStream var4 = new ByteArrayOutputStream();
            Throwable var5 = null;

            try {
               byte[] var6 = new byte[4096];

               int var7;
               while((var7 = var0.read(var6, 0, var6.length)) != -1) {
                  var4.write(var6, 0, var7);
               }

               var4.flush();
               var8 = var4.toByteArray();
            } catch (Throwable var24) {
               var5 = var24;
               throw var24;
            } finally {
               if (var4 != null) {
                  if (var5 != null) {
                     try {
                        var4.close();
                     } catch (Throwable var23) {
                        var5.addSuppressed(var23);
                     }
                  } else {
                     var4.close();
                  }
               }

            }
         } finally {
            if (var1) {
               var0.close();
            }

         }

         return var8;
      }
   }

   public short b(int var1) {
      byte[] var2 = this.k;
      return (short)((var2[var1] & 255) << 8 | var2[var1 + 1] & 255);
   }

   public int d() {
      return this.g(this.j);
   }

   public final int c() {
      int var1 = this.j + 8 + this.g(this.j + 6) * 2;
      int var2 = this.g(var1);
      var1 += 2;

      while(var2-- > 0) {
         int var3 = this.g(var1 + 6);
         var1 += 8;

         while(var3-- > 0) {
            var1 += 6 + this.e(var1 + 2);
         }
      }

      int var7 = this.g(var1);
      var1 += 2;

      while(var7-- > 0) {
         int var4 = this.g(var1 + 6);
         var1 += 8;

         while(var4-- > 0) {
            var1 += 6 + this.e(var1 + 2);
         }
      }

      return var1 + 2;
   }

   private void b(Unknown338 var1, Unknown289 var2, int var3, boolean var4) {
      int var5 = var3 + 1;
      int var6 = this.k[var3] & 255;
      var1.a(var6, var4);
      char[] var7 = var2.f;

      for(int var8 = 0; var8 < var6; ++var8) {
         int var9 = this.g(var5);

         String var10;
         for(var5 += 2; var9-- > 0; var5 = this.a(var1.a(var8, var10, var4), var5, true, var7)) {
            var10 = this.f(var5, var7);
            var5 += 2;
         }
      }

   }

   public Object d(int var1, char[] var2) {
      int var3 = this.n[var1];
      switch(this.k[var3 - 1]) {
         case 3:
            return this.e(var3);
         case 4:
            return Float.intBitsToFloat(this.e(var3));
         case 5:
            return this.a(var3);
         case 6:
            return Double.longBitsToDouble(this.a(var3));
         case 7:
            return Unknown357.c(this.f(var3, var2));
         case 8:
            return this.f(var3, var2);
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         default:
            throw new IllegalArgumentException();
         case 15:
            int var4 = this.c(var3);
            int var5 = this.n[this.g(var3 + 1)];
            int var6 = this.n[this.g(var5 + 2)];
            String var7 = this.b(var5, var2);
            String var8 = this.f(var6, var2);
            String var9 = this.f(var6 + 2, var2);
            boolean var10 = this.k[var5 - 1] == 11;
            return new Unknown137(var4, var7, var8, var9, var10);
         case 16:
            return Unknown357.b(this.f(var3, var2));
         case 17:
            return this.a(var1, var2);
      }
   }

   public Asm37(byte[] var1) {
      this(var1, 0, var1.length);
   }

   protected Unknown246 c(int var1, Unknown246[] var2) {
      if (var2[var1] == null) {
         var2[var1] = new Unknown246();
      }

      return var2[var1];
   }

   private String a(int var1, int var2, char[] var3) {
      int var4 = var1;
      int var5 = var1 + var2;
      int var6 = 0;
      byte[] var7 = this.k;

      while(var4 < var5) {
         byte var8 = var7[var4++];
         if ((var8 & 128) == 0) {
            var3[var6++] = (char)(var8 & 127);
         } else if ((var8 & 224) == 192) {
            var3[var6++] = (char)(((var8 & 31) << 6) + (var7[var4++] & 63));
         } else {
            var3[var6++] = (char)(((var8 & 15) << 12) + ((var7[var4++] & 63) << 6) + (var7[var4++] & 63));
         }
      }

      return new String(var3, 0, var6);
   }

   private int a(Unknown289 var1, int var2) {
      int var4 = this.e(var2);
      int var3;
      switch(var4 >>> 24) {
         case 0:
         case 1:
         case 22:
            var4 &= -65536;
            var3 = var2 + 2;
            break;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 32:
         case 33:
         case 34:
         case 35:
         case 36:
         case 37:
         case 38:
         case 39:
         case 40:
         case 41:
         case 42:
         case 43:
         case 44:
         case 45:
         case 46:
         case 47:
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
         case 58:
         case 59:
         case 60:
         case 61:
         case 62:
         case 63:
         default:
            throw new IllegalArgumentException();
         case 16:
         case 17:
         case 18:
         case 23:
         case 66:
            var4 &= -256;
            var3 = var2 + 3;
            break;
         case 19:
         case 20:
         case 21:
            var4 &= -16777216;
            var3 = var2 + 1;
            break;
         case 64:
         case 65:
            var4 &= -16777216;
            int var5 = this.g(var2 + 1);
            var3 = var2 + 3;
            var1.b = new Unknown246[var5];
            var1.a = new Unknown246[var5];
            var1.n = new int[var5];

            for(int var6 = 0; var6 < var5; ++var6) {
               int var7 = this.g(var3);
               int var8 = this.g(var3 + 2);
               int var9 = this.g(var3 + 4);
               var3 += 6;
               var1.b[var6] = this.a(var7, var1.g);
               var1.a[var6] = this.a(var7 + var8, var1.g);
               var1.n[var6] = var9;
            }
            break;
         case 67:
         case 68:
         case 69:
         case 70:
            var4 &= -16777216;
            var3 = var2 + 3;
            break;
         case 71:
         case 72:
         case 73:
         case 74:
         case 75:
            var4 &= -16776961;
            var3 = var2 + 4;
      }

      var1.s = var4;
      int var11 = this.c(var3);
      var1.e = var11 == 0 ? null : new Unknown186(this.k, var3);
      return var3 + 1 + 2 * var11;
   }

   private b7 a(int var1, char[] var2) {
      b7 var3 = this.g[var1];
      if (var3 != null) {
         return var3;
      } else {
         int var4 = this.n[var1];
         int var5 = this.n[this.g(var4 + 2)];
         String var6 = this.f(var5, var2);
         String var7 = this.f(var5 + 2, var2);
         int var8 = this.a[this.g(var4)];
         Unknown137 var9 = (Unknown137)this.d(this.g(var8), var2);
         Object[] var10 = new Object[this.g(var8 + 2)];
         var8 += 4;

         for(int var11 = 0; var11 < var10.length; ++var11) {
            var10[var11] = this.d(this.g(var8), var2);
            var8 += 2;
         }

         return this.g[var1] = new b7(var6, var7, var9, var10);
      }
   }
}
