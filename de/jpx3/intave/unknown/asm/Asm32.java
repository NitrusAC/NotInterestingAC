package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.qs;
import de.jpx3.intave.unknown.Unknown13;
import de.jpx3.intave.unknown.Unknown154;
import de.jpx3.intave.unknown.Unknown246;
import de.jpx3.intave.unknown.Unknown257;
import de.jpx3.intave.unknown.Unknown339;
import de.jpx3.intave.unknown.Unknown357;

public class Asm32 {
   public Unknown246 w;
   private static final int ab = 20;
   private static final int n = -67108864;
   private static final int A = 20971520;
   private static final int u = 4;
   private static final int af = 4194313;
   private static final int W = 12582912;
   private static final int H = 2;
   private static final int J = 9;
   static final int G = 247;
   private int[] N;
   private static final int v = 1048576;
   private static final int d = 4194308;
   private static final int B = 67108864;
   static final int a = 248;
   private static final int ae = 16777216;
   private int[] ag;
   static final int s = 252;
   private static final int C = 4194307;
   private static final int P = 4194306;
   private int j;
   private static final int l = 4194309;
   private static final int p = 4194314;
   private static final int b = 1048575;
   static final int S = 8;
   private static final int q = -67108864;
   static final int Y = 2;
   static final int D = 251;
   static final int m = 128;
   private static final int V = 8388608;
   private static final int I = 4194310;
   static final int F = 0;
   static final int R = 255;
   static final int z = 0;
   static final int L = 1;
   private static final int x = 4194316;
   static final int ad = 6;
   static final int k = 7;
   private static final int i = 4194304;
   private int[] K;
   private static final int t = 22;
   static final int O = 4;
   private static final int U = 4194315;
   private static final int e = 26;
   private int[] E;
   static final int h = 5;
   static final int o = 3;
   private static final int Z = 12;
   private static final int r = 11;
   static final int ac = 64;
   private static final int f = 4194305;
   private static final int X = 10;
   private static final int c = 6;
   private int[] g;
   private short M;
   private static final int T = 62914560;
   private short y;
   private static final int Q = 20;
   private static final int aa = 4194304;
   public static final long x = 7075825047603142966L;

   private void a(String var1) {
      char var5 = var1.charAt(0);
      if (var5 == '(') {
         this.d((Unknown357.d(var1) >> 2) - 1);
      } else if (var5 != 'J' && var5 != 'D') {
         this.d(1);
      } else {
         this.d(2);
      }

   }

   private int b() {
      return this.M > 0 ? this.E[--this.M] : 20971520 | -(--this.y);
   }

   public static int a(Unknown13 var0, Object var1) {
      if (var1 instanceof Integer) {
         return 4194304 | (Integer)var1;
      } else if (var1 instanceof String) {
         String var5 = Unknown357.c((String)var1).f();
         return a(var0, var5, 0);
      } else {
         return 12582912 | var0.a("", ((Unknown246)var1).f);
      }
   }

   private void d(int var1) {
      if (this.M >= var1) {
         this.M = (short)(this.M - var1);
      } else {
         this.y = (short)(this.y - (var1 - this.M));
         this.M = 0;
      }

   }

   private int c(int var1) {
      if (this.K != null && var1 < this.K.length) {
         int var5 = this.K[var1];
         if (var5 == 0) {
            var5 = this.K[var1] = 16777216 | var1;
         }

         return var5;
      } else {
         return 16777216 | var1;
      }
   }

   private void a(int var1) {
      if (this.E == null) {
         this.E = new int[10];
      }

      int var5 = this.E.length;
      if (this.M >= var5) {
         int[] var6 = new int[Math.max(this.M + 1, 2 * var5)];
         System.arraycopy(this.E, 0, var6, 0, var5);
         this.E = var6;
      }

      this.E[this.M++] = var1;
      short var7 = (short)(this.y + this.M);
      if (var7 > this.w.q) {
         this.w.q = var7;
      }

   }

   private void b(int var1) {
      if (this.ag == null) {
         this.ag = new int[2];
      }

      int var5 = this.ag.length;
      if (this.j >= var5) {
         int[] var6 = new int[Math.max(this.j + 1, 2 * var5)];
         System.arraycopy(this.ag, 0, var6, 0, var5);
         this.ag = var6;
      }

      this.ag[this.j++] = var1;
   }

   private int a(Unknown13 var1, int var2) {
      if (var2 == 4194310 || (var2 & -4194304) == 12582912) {
         for(int var6 = 0; var6 < this.j; ++var6) {
            int var7 = this.ag[var6];
            int var8 = var7 & -67108864;
            int var9 = var7 & 62914560;
            int var10 = var7 & 1048575;
            if (var9 == 16777216) {
               var7 = var8 + this.g[var10];
            } else if (var9 == 20971520) {
               var7 = var8 + this.N[this.N.length - var10];
            }

            if (var2 == var7) {
               if (var2 == 4194310) {
                  return 8388608 | var1.e(var1.c());
               }

               return 8388608 | var1.e(var1.c(var2 & 1048575).value);
            }
         }
      }

      return var2;
   }

   public final int a() {
      return this.N.length;
   }

   public final boolean a(Unknown13 var1, Asm32 var2, int var3) {
      boolean var7 = false;
      int var8 = this.g.length;
      int var9 = this.N.length;
      if (var2.g == null) {
         var2.g = new int[var8];
         var7 = true;
      }

      for(int var10 = 0; var10 < var8; ++var10) {
         int var11;
         if (this.K != null && var10 < this.K.length) {
            int var12 = this.K[var10];
            if (var12 == 0) {
               var11 = this.g[var10];
            } else {
               var11 = this.a(var12, var9);
            }
         } else {
            var11 = this.g[var10];
         }

         if (this.ag != null) {
            var11 = this.a(var1, var11);
         }

         var7 |= a(var1, var11, var2.g, var10);
      }

      if (var3 <= 0) {
         int var15 = this.N.length + this.y;
         if (var2.N == null) {
            var2.N = new int[var15 + this.M];
            var7 = true;
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            int var18 = this.N[var16];
            if (this.ag != null) {
               var18 = this.a(var1, var18);
            }

            var7 |= a(var1, var18, var2.N, var16);
         }

         for(int var17 = 0; var17 < this.M; ++var17) {
            int var19 = this.E[var17];
            int var13 = this.a(var19, var9);
            if (this.ag != null) {
               var13 = this.a(var1, var13);
            }

            var7 |= a(var1, var13, var2.N, var15 + var17);
         }

         return var7;
      } else {
         for(int var14 = 0; var14 < var8; ++var14) {
            var7 |= a(var1, this.g[var14], var2.g, var14);
         }

         if (var2.N == null) {
            var2.N = new int[1];
            var7 = true;
         }

         return var7 | a(var1, var3, var2.N, 0);
      }
   }

   public final void a(Asm32 var1) {
      this.g = var1.g;
      this.N = var1.N;
      this.y = 0;
      this.K = var1.K;
      this.E = var1.E;
      this.M = var1.M;
      this.j = var1.j;
      this.ag = var1.ag;
   }

   private static int a(Unknown13 var0, String var1, int var2) {
      switch(var1.charAt(var2)) {
         case 'B':
         case 'C':
         case 'I':
         case 'S':
         case 'Z':
            return 4194305;
         case 'D':
            return 4194307;
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
         case 'W':
         case 'X':
         case 'Y':
         default:
            throw new IllegalArgumentException();
         case 'F':
            return 4194306;
         case 'J':
            return 4194308;
         case 'L':
            String var9 = var1.substring(var2 + 1, var1.length() - 1);
            return 8388608 | var0.e(var9);
         case 'V':
            return 0;
         case '[':
            int var7 = var2 + 1;

            while(var1.charAt(var7) == '[') {
               ++var7;
            }

            int var8;
            switch(var1.charAt(var7)) {
               case 'B':
                  var8 = 4194314;
                  break;
               case 'C':
                  var8 = 4194315;
                  break;
               case 'D':
                  var8 = 4194307;
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
                  throw new IllegalArgumentException();
               case 'F':
                  var8 = 4194306;
                  break;
               case 'I':
                  var8 = 4194305;
                  break;
               case 'J':
                  var8 = 4194308;
                  break;
               case 'L':
                  String var6 = var1.substring(var7 + 1, var1.length() - 1);
                  var8 = 8388608 | var0.e(var6);
                  break;
               case 'S':
                  var8 = 4194316;
                  break;
               case 'Z':
                  var8 = 4194313;
            }

            return var7 - var2 << 26 | var8;
      }
   }

   private void a(Unknown13 var1, String var2) {
      int var6 = var2.charAt(0) == '(' ? Unknown357.g(var2) : 0;
      int var7 = a(var1, var2, var6);
      if (var7 != 0) {
         this.a(var7);
         if (var7 == 4194308 || var7 == 4194307) {
            this.a(4194304);
         }
      }

   }

   public static void a(Unknown13 var0, int var1, Unknown257 var2) {
      int var6 = (var1 & -67108864) >> 26;
      if (var6 == 0) {
         int var7 = var1 & 1048575;
         switch(var1 & 62914560) {
            case 4194304:
               var2.a(var7);
               break;
            case 8388608:
               var2.a(7).c(var0.c(var0.c(var7).value).index);
               break;
            case 12582912:
               var2.a(8).c((int)var0.c(var7).data);
               break;
            default:
               throw new AssertionError();
         }
      } else {
         StringBuilder var8 = new StringBuilder();

         while(var6-- > 0) {
            var8.append('[');
         }

         if ((var1 & 62914560) == 8388608) {
            var8.append('L').append(var0.c(var1 & 1048575).value).append(';');
         } else {
            switch(var1 & 1048575) {
               case 1:
                  var8.append('I');
                  break;
               case 2:
                  var8.append('F');
                  break;
               case 3:
                  var8.append('D');
                  break;
               case 4:
                  var8.append('J');
                  break;
               case 5:
               case 6:
               case 7:
               case 8:
               default:
                  throw new AssertionError();
               case 9:
                  var8.append('Z');
                  break;
               case 10:
                  var8.append('B');
                  break;
               case 11:
                  var8.append('C');
                  break;
               case 12:
                  var8.append('S');
            }
         }

         var2.a(7).c(var0.c(var8.toString()).index);
      }

   }

   public Asm32(Unknown246 var1) {
      this.w = var1;
   }

   private int a(int var1, int var2) {
      int var6 = var1 & -67108864;
      int var7 = var1 & 62914560;
      if (var7 == 16777216) {
         int var9 = var6 + this.g[var1 & 1048575];
         if ((var1 & 1048576) != 0 && (var9 == 4194308 || var9 == 4194307)) {
            var9 = 4194304;
         }

         return var9;
      } else if (var7 != 20971520) {
         return var1;
      } else {
         int var8 = var6 + this.N[var2 - (var1 & 1048575)];
         if ((var1 & 1048576) != 0 && (var8 == 4194308 || var8 == 4194307)) {
            var8 = 4194304;
         }

         return var8;
      }
   }

   public static int b(Unknown13 var0, String var1) {
      return 8388608 | var0.e(var1);
   }

   private static boolean a(Unknown13 var0, int var1, int[] var2, int var3) {
      int var7 = var2[var3];
      if (var7 == var1) {
         return false;
      } else {
         int var8 = var1;
         if ((var1 & 67108863) == 4194309) {
            if (var7 == 4194309) {
               return false;
            }

            var8 = 4194309;
         }

         if (var7 == 0) {
            var2[var3] = var8;
            return true;
         } else {
            int var9;
            if ((var7 & -67108864) == 0 && (var7 & 62914560) != 8388608) {
               if (var7 == 4194309) {
                  var9 = (var8 & -67108864) == 0 && (var8 & 62914560) != 8388608 ? 4194304 : var8;
               } else {
                  var9 = 4194304;
               }
            } else {
               if (var8 == 4194309) {
                  return false;
               }

               if ((var8 & -4194304) == (var7 & -4194304)) {
                  if ((var7 & 62914560) == 8388608) {
                     var9 = var8 & -67108864 | 8388608 | var0.c(var8 & 1048575, var7 & 1048575);
                  } else {
                     int var10 = -67108864 + (var8 & -67108864);
                     var9 = var10 | 8388608 | var0.e("java/lang/Object");
                  }
               } else if ((var8 & -67108864) == 0 && (var8 & 62914560) != 8388608) {
                  var9 = 4194304;
               } else {
                  int var12 = var8 & -67108864;
                  if (var12 != 0 && (var8 & 62914560) != 8388608) {
                     var12 += -67108864;
                  }

                  int var11 = var7 & -67108864;
                  if (var11 != 0 && (var7 & 62914560) != 8388608) {
                     var11 += -67108864;
                  }

                  var9 = Math.min(var12, var11) | 8388608 | var0.e("java/lang/Object");
               }
            }

            if (var9 != var7) {
               var2[var3] = var9;
               return true;
            } else {
               return false;
            }
         }
      }
   }

   public void a(int var1, int var2, Unknown154 var3, Unknown13 var4) {
      switch(var1) {
         case 0:
         case 116:
         case 117:
         case 118:
         case 119:
         case 145:
         case 146:
         case 147:
         case 167:
         case 177:
            break;
         case 1:
            this.a(4194309);
            break;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 16:
         case 17:
         case 21:
            this.a(4194305);
            break;
         case 9:
         case 10:
         case 22:
            this.a(4194308);
            this.a(4194304);
            break;
         case 11:
         case 12:
         case 13:
         case 23:
            this.a(4194306);
            break;
         case 14:
         case 15:
         case 24:
            this.a(4194307);
            this.a(4194304);
            break;
         case 18:
            switch(var3.tag) {
               case 3:
                  this.a(4194305);
                  return;
               case 4:
                  this.a(4194306);
                  return;
               case 5:
                  this.a(4194308);
                  this.a(4194304);
                  return;
               case 6:
                  this.a(4194307);
                  this.a(4194304);
                  return;
               case 7:
                  this.a(8388608 | var4.e("java/lang/Class"));
                  return;
               case 8:
                  this.a(8388608 | var4.e("java/lang/String"));
                  return;
               case 9:
               case 10:
               case 11:
               case 12:
               case 13:
               case 14:
               default:
                  throw new AssertionError();
               case 15:
                  this.a(8388608 | var4.e("java/lang/invoke/MethodHandle"));
                  return;
               case 16:
                  this.a(8388608 | var4.e("java/lang/invoke/MethodType"));
                  return;
               case 17:
                  this.a(var4, var3.value);
                  return;
            }
         case 19:
         case 20:
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
         case 196:
         default:
            throw new IllegalArgumentException();
         case 25:
            this.a(this.c(var2));
            break;
         case 46:
         case 51:
         case 52:
         case 53:
         case 96:
         case 100:
         case 104:
         case 108:
         case 112:
         case 120:
         case 122:
         case 124:
         case 126:
         case 128:
         case 130:
         case 136:
         case 142:
         case 149:
         case 150:
            this.d(2);
            this.a(4194305);
            break;
         case 47:
         case 143:
            this.d(2);
            this.a(4194308);
            this.a(4194304);
            break;
         case 48:
         case 98:
         case 102:
         case 106:
         case 110:
         case 114:
         case 137:
         case 144:
            this.d(2);
            this.a(4194306);
            break;
         case 49:
         case 138:
            this.d(2);
            this.a(4194307);
            this.a(4194304);
            break;
         case 50:
            this.d(1);
            int var23 = this.b();
            this.a(var23 == 4194309 ? var23 : -67108864 + var23);
            break;
         case 54:
         case 56:
         case 58:
            int var22 = this.b();
            this.b(var2, var22);
            if (var2 > 0) {
               int var32 = this.c(var2 - 1);
               if (var32 != 4194308 && var32 != 4194307) {
                  if ((var32 & 62914560) == 16777216 || (var32 & 62914560) == 20971520) {
                     this.b(var2 - 1, var32 | 1048576);
                  }
               } else {
                  this.b(var2 - 1, 4194304);
               }
            }
            break;
         case 55:
         case 57:
            this.d(1);
            int var21 = this.b();
            this.b(var2, var21);
            this.b(var2 + 1, 4194304);
            if (var2 > 0) {
               int var31 = this.c(var2 - 1);
               if (var31 != 4194308 && var31 != 4194307) {
                  if ((var31 & 62914560) == 16777216 || (var31 & 62914560) == 20971520) {
                     this.b(var2 - 1, var31 | 1048576);
                  }
               } else {
                  this.b(var2 - 1, 4194304);
               }
            }
            break;
         case 79:
         case 81:
         case 83:
         case 84:
         case 85:
         case 86:
            this.d(3);
            break;
         case 80:
         case 82:
            this.d(4);
            break;
         case 87:
         case 153:
         case 154:
         case 155:
         case 156:
         case 157:
         case 158:
         case 170:
         case 171:
         case 172:
         case 174:
         case 176:
         case 191:
         case 194:
         case 195:
         case 198:
         case 199:
            this.d(1);
            break;
         case 88:
         case 159:
         case 160:
         case 161:
         case 162:
         case 163:
         case 164:
         case 165:
         case 166:
         case 173:
         case 175:
            this.d(2);
            break;
         case 89:
            int var20 = this.b();
            this.a(var20);
            this.a(var20);
            break;
         case 90:
            int var19 = this.b();
            int var28 = this.b();
            this.a(var19);
            this.a(var28);
            this.a(var19);
            break;
         case 91:
            int var18 = this.b();
            int var27 = this.b();
            int var30 = this.b();
            this.a(var18);
            this.a(var30);
            this.a(var27);
            this.a(var18);
            break;
         case 92:
            int var17 = this.b();
            int var26 = this.b();
            this.a(var26);
            this.a(var17);
            this.a(var26);
            this.a(var17);
            break;
         case 93:
            int var16 = this.b();
            int var25 = this.b();
            int var29 = this.b();
            this.a(var25);
            this.a(var16);
            this.a(var29);
            this.a(var25);
            this.a(var16);
            break;
         case 94:
            int var15 = this.b();
            int var24 = this.b();
            int var10 = this.b();
            int var11 = this.b();
            this.a(var24);
            this.a(var15);
            this.a(var11);
            this.a(var10);
            this.a(var24);
            this.a(var15);
            break;
         case 95:
            int var14 = this.b();
            int var9 = this.b();
            this.a(var14);
            this.a(var9);
            break;
         case 97:
         case 101:
         case 105:
         case 109:
         case 113:
         case 127:
         case 129:
         case 131:
            this.d(4);
            this.a(4194308);
            this.a(4194304);
            break;
         case 99:
         case 103:
         case 107:
         case 111:
         case 115:
            this.d(4);
            this.a(4194307);
            this.a(4194304);
            break;
         case 121:
         case 123:
         case 125:
            this.d(3);
            this.a(4194308);
            this.a(4194304);
            break;
         case 132:
            this.b(var2, 4194305);
            break;
         case 133:
         case 140:
            this.d(1);
            this.a(4194308);
            this.a(4194304);
            break;
         case 134:
            this.d(1);
            this.a(4194306);
            break;
         case 135:
         case 141:
            this.d(1);
            this.a(4194307);
            this.a(4194304);
            break;
         case 139:
         case 190:
         case 193:
            this.d(1);
            this.a(4194305);
            break;
         case 148:
         case 151:
         case 152:
            this.d(4);
            this.a(4194305);
            break;
         case 168:
         case 169:
            throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
         case 178:
            this.a(var4, var3.value);
            break;
         case 179:
            this.a(var3.value);
            break;
         case 180:
            this.d(1);
            this.a(var4, var3.value);
            break;
         case 181:
            this.a(var3.value);
            this.b();
            break;
         case 182:
         case 183:
         case 184:
         case 185:
            this.a(var3.value);
            if (var1 != 184) {
               int var8 = this.b();
               if (var1 == 183 && var3.name.charAt(0) == '<') {
                  this.b(var8);
               }
            }

            this.a(var4, var3.value);
            break;
         case 186:
            this.a(var3.value);
            this.a(var4, var3.value);
            break;
         case 187:
            this.a(12582912 | var4.a(var3.value, var2));
            break;
         case 188:
            this.b();
            switch(var2) {
               case 4:
                  this.a(71303177);
                  return;
               case 5:
                  this.a(71303179);
                  return;
               case 6:
                  this.a(71303170);
                  return;
               case 7:
                  this.a(71303171);
                  return;
               case 8:
                  this.a(71303178);
                  return;
               case 9:
                  this.a(71303180);
                  return;
               case 10:
                  this.a(71303169);
                  return;
               case 11:
                  this.a(71303172);
                  return;
               default:
                  throw new IllegalArgumentException();
            }
         case 189:
            String var12 = var3.value;
            this.b();
            if (var12.charAt(0) == '[') {
               this.a(var4, '[' + var12);
            } else {
               this.a(75497472 | var4.e(var12));
            }
            break;
         case 192:
            String var13 = var3.value;
            this.b();
            if (var13.charAt(0) == '[') {
               this.a(var4, var13);
            } else {
               this.a(8388608 | var4.e(var13));
            }
            break;
         case 197:
            this.d(var2);
            this.a(var4, var3.value);
      }

   }

   public final void a(Unknown339 var1) {
      int[] var5 = this.g;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;

      while(var8 < var5.length) {
         int var9 = var5[var8];
         var8 += var9 != 4194308 && var9 != 4194307 ? 1 : 2;
         if (var9 == 4194304) {
            ++var7;
         } else {
            var6 += var7 + 1;
            var7 = 0;
         }
      }

      int[] var16 = this.N;
      int var10 = 0;

      for(int var13 = 0; var13 < var16.length; ++var10) {
         int var11 = var16[var13];
         var13 += var11 != 4194308 && var11 != 4194307 ? 1 : 2;
      }

      int var17 = var1.a(this.w.f, var6, var10);
      var8 = 0;

      while(var6-- > 0) {
         int var12 = var5[var8];
         var8 += var12 != 4194308 && var12 != 4194307 ? 1 : 2;
         var1.f(var17++, var12);
      }

      var8 = 0;

      while(var10-- > 0) {
         int var18 = var16[var8];
         var8 += var18 != 4194308 && var18 != 4194307 ? 1 : 2;
         var1.f(var17++, var18);
      }

      var1.g();
   }

   public final void a(Unknown13 var1, int var2, Object[] var3, int var4, Object[] var5) {
      int var9 = 0;

      for(int var10 = 0; var10 < var2; ++var10) {
         this.g[var9++] = a(var1, var3[var10]);
         if (var3[var10] == qs.ad || var3[var10] == qs.a_) {
            this.g[var9++] = 4194304;
         }
      }

      while(var9 < this.g.length) {
         this.g[var9++] = 4194304;
      }

      int var13 = 0;

      for(int var11 = 0; var11 < var4; ++var11) {
         if (var5[var11] == qs.ad || var5[var11] == qs.a_) {
            ++var13;
         }
      }

      this.N = new int[var4 + var13];
      int var14 = 0;

      for(int var12 = 0; var12 < var4; ++var12) {
         this.N[var14++] = a(var1, var5[var12]);
         if (var5[var12] == qs.ad || var5[var12] == qs.a_) {
            this.N[var14++] = 4194304;
         }
      }

      this.M = 0;
      this.j = 0;
   }

   private void b(int var1, int var2) {
      if (this.K == null) {
         this.K = new int[10];
      }

      int var6 = this.K.length;
      if (var1 >= var6) {
         int[] var7 = new int[Math.max(var1 + 1, 2 * var6)];
         System.arraycopy(this.K, 0, var7, 0, var6);
         this.K = var7;
      }

      this.K[var1] = var2;
   }

   public final void a(Unknown13 var1, int var2, String var3, int var4) {
      this.g = new int[var4];
      this.N = new int[0];
      int var8 = 0;
      if ((var2 & 8) == 0) {
         if ((var2 & 262144) == 0) {
            this.g[var8++] = 8388608 | var1.e(var1.c());
         } else {
            this.g[var8++] = 4194310;
         }
      }

      for(Unknown357 var12 : Unknown357.e(var3)) {
         int var13 = a(var1, var12.f(), 0);
         this.g[var8++] = var13;
         if (var13 == 4194308 || var13 == 4194307) {
            this.g[var8++] = 4194304;
         }
      }

      while(var8 < var4) {
         this.g[var8++] = 4194304;
      }

   }
}
