package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown257;

public class Asm30 {
   public static final int f = 23;
   public static final int p = 69;
   public static final int w = 19;
   public static final int j = 65;
   public static final int t = 21;
   public static final int i = 75;
   public static final int b = 74;
   public static final int a = 1;
   public static final int r = 20;
   private final int v;
   public static final int k = 73;
   public static final int u = 66;
   public static final int g = 17;
   public static final int e = 67;
   public static final int l = 68;
   public static final int q = 0;
   public static final int m = 71;
   public static final int o = 70;
   public static final int d = 22;
   public static final int h = 72;
   public static final int n = 64;
   public static final int s = 18;
   public static final int c = 16;

   public static Asm30 a(int var0) {
      return new Asm30(var0 << 24);
   }

   public int h() {
      return (this.v & 16776960) >> 8;
   }

   public Asm30(int var1) {
      this.v = var1;
   }

   public int b() {
      return this.v >>> 24;
   }

   public static Asm30 d(int var0) {
      return new Asm30(385875968 | var0 << 8);
   }

   public static Asm30 a(int var0, int var1, int var2) {
      return new Asm30(var0 << 24 | var1 << 16 | var2 << 8);
   }

   public int d() {
      return (this.v & 0xFF0000) >> 16;
   }

   public static Asm30 c(int var0) {
      return new Asm30(1107296256 | var0 << 8);
   }

   public int e() {
      return (this.v & 0xFF0000) >> 16;
   }

   public static Asm30 e(int var0) {
      return new Asm30(369098752 | var0 << 16);
   }

   public int a() {
      return this.v & 0xFF;
   }

   public int g() {
      return (this.v & 16776960) >> 8;
   }

   public int f() {
      return (short)((this.v & 16776960) >> 8);
   }

   public int c() {
      return this.v;
   }

   static void a(int var0, Unknown257 var1) {
      switch(var0 >>> 24) {
         case 0:
         case 1:
         case 22:
            var1.c(var0 >>> 16);
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
         case 64:
         case 65:
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
            var1.b(var0 >>> 24, (var0 & 16776960) >> 8);
            break;
         case 19:
         case 20:
         case 21:
            var1.a(var0 >>> 24);
            break;
         case 71:
         case 72:
         case 73:
         case 74:
         case 75:
            var1.d(var0);
      }

   }

   public static Asm30 b(int var0) {
      return new Asm30(268435456 | (var0 & 65535) << 8);
   }

   public int i() {
      return (this.v & 0xFF00) >> 8;
   }

   public static Asm30 b(int var0, int var1) {
      return new Asm30(var0 << 24 | var1);
   }

   public static Asm30 a(int var0, int var1) {
      return new Asm30(var0 << 24 | var1 << 16);
   }
}
