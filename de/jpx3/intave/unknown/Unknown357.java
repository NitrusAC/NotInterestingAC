package de.jpx3.intave.unknown;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class Unknown357 {
   public static final Unknown357 j = new Unknown357(7, "VZCBSIFJD", 7, 8);
   public static final int q = 7;
   private final int o;
   public static final int p = 5;
   public static final int d = 4;
   private final int g;
   public static final Unknown357 t = new Unknown357(6, "VZCBSIFJD", 6, 7);
   public static final Unknown357 m = new Unknown357(2, "VZCBSIFJD", 2, 3);
   public static final Unknown357 c = new Unknown357(1, "VZCBSIFJD", 1, 2);
   public static final int y = 6;
   public static final Unknown357 b = new Unknown357(0, "VZCBSIFJD", 0, 1);
   public static final int f = 10;
   public static final int r = 0;
   public static final Unknown357 i = new Unknown357(5, "VZCBSIFJD", 5, 6);
   public static final int l = 9;
   public static final Unknown357 a = new Unknown357(8, "VZCBSIFJD", 8, 9);
   public static final int s = 1;
   public static final Unknown357 x = new Unknown357(4, "VZCBSIFJD", 4, 5);
   public static final int z = 8;
   private final int u;
   private static final String e;
   public static final int k = 3;
   private final String v;
   public static final Unknown357 h = new Unknown357(3, "VZCBSIFJD", 3, 4);
   public static final int n = 2;
   public static final int A = 11;
   private static final int w = 12;

   public int k() {
      return this.g == 12 ? 10 : this.g;
   }

   public Unknown357 e() {
      int var1 = this.a();
      return a(this.v, this.u + var1, this.o);
   }

   public int i() {
      switch(this.g) {
         case 0:
            return 0;
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 9:
         case 10:
         case 12:
            return 1;
         case 7:
         case 8:
            return 2;
         case 11:
         default:
            throw new AssertionError();
      }
   }

   public int hashCode() {
      int var4 = 13 * (this.g == 12 ? 10 : this.g);
      if (this.g >= 9) {
         int var5 = this.u;

         for(int var6 = this.o; var5 < var6; ++var5) {
            var4 = 17 * (var4 + this.v.charAt(var5));
         }
      }

      return var4;
   }

   public static Unknown357 f(String var0) {
      return a(var0, g(var0), var0.length());
   }

   public String h() {
      return this.v.substring(this.u, this.o);
   }

   public static Unknown357 c(String var0) {
      return new Unknown357(var0.charAt(0) == '[' ? 9 : 12, var0, 0, var0.length());
   }

   public String f() {
      if (this.g == 10) {
         return this.v.substring(this.u - 1, this.o + 1);
      } else {
         return this.g == 12 ? 'L' + this.v.substring(this.u, this.o) + ';' : this.v.substring(this.u, this.o);
      }
   }

   public int g() {
      return d(this.f());
   }

   public String toString() {
      return this.f();
   }

   private Unknown357(int var1, String var2, int var3, int var4) {
      this.g = var1;
      this.v = var2;
      this.u = var3;
      this.o = var4;
   }

   public static String a(Unknown357 var0, Unknown357[] var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append('(');

      for(Unknown357 var6 : var1) {
         var6.a(var2);
      }

      var2.append(')');
      var0.a(var2);
      return var2.toString();
   }

   public Unknown357 a(int var1) {
      if (var1 == 0) {
         return this;
      } else {
         StringBuilder var2 = new StringBuilder();

         while(var1-- > 0) {
            var2.append("[");
         }

         String var3 = var2 + this.f();
         return a(var3, 0, var3.length());
      }
   }

   public String b() {
      switch(this.g) {
         case 0:
            return "void";
         case 1:
            return "boolean";
         case 2:
            return "char";
         case 3:
            return "byte";
         case 4:
            return "short";
         case 5:
            return "int";
         case 6:
            return "float";
         case 7:
            return "long";
         case 8:
            return "double";
         case 9:
            StringBuilder var4 = new StringBuilder(this.e().b());

            for(int var5 = this.a(); var5 > 0; --var5) {
               var4.append("[]");
            }

            return var4.toString();
         case 10:
         case 12:
            return this.v.substring(this.u, this.o).replace('/', '.');
         case 11:
         default:
            throw new AssertionError();
      }
   }

   public static int d(String var0) {
      int var4 = 1;
      int var5 = 1;

      for(char var6 = var0.charAt(var5); var6 != ')'; var6 = var0.charAt(var5)) {
         if (var6 != 'J' && var6 != 'D') {
            while(var0.charAt(var5) == '[') {
               ++var5;
            }

            if (var0.charAt(var5++) == 'L') {
               int var7 = var0.indexOf(59, var5);
               var5 = Math.max(var5, var7 + 1);
            }

            ++var4;
         } else {
            ++var5;
            var4 += 2;
         }
      }

      char var8 = var0.charAt(var5 + 1);
      if (var8 == 'V') {
         return var4 << 2;
      } else {
         int var9 = var8 != 'J' && var8 != 'D' ? 1 : 2;
         return var4 << 2 | var9;
      }
   }

   public Unknown357 j() {
      return f(this.f());
   }

   public static String a(Class var0) {
      return var0.getName().replace('.', '/');
   }

   private static void a(Class var0, StringBuilder var1) {
      Class var2;
      for(var2 = var0; var2.isArray(); var2 = var2.getComponentType()) {
         var1.append('[');
      }

      if (var2.isPrimitive()) {
         char var3;
         if (var2 == Integer.TYPE) {
            var3 = 'I';
         } else if (var2 == Void.TYPE) {
            var3 = 'V';
         } else if (var2 == Boolean.TYPE) {
            var3 = 'Z';
         } else if (var2 == Byte.TYPE) {
            var3 = 'B';
         } else if (var2 == Character.TYPE) {
            var3 = 'C';
         } else if (var2 == Short.TYPE) {
            var3 = 'S';
         } else if (var2 == Double.TYPE) {
            var3 = 'D';
         } else if (var2 == Float.TYPE) {
            var3 = 'F';
         } else {
            if (var2 != Long.TYPE) {
               throw new AssertionError();
            }

            var3 = 'J';
         }

         var1.append(var3);
      } else {
         var1.append('L').append(a(var2)).append(';');
      }

   }

   public Unknown357[] c() {
      return e(this.f());
   }

   public static Unknown357 a(String var0) {
      return a(var0, 0, var0.length());
   }

   public static Unknown357[] d(Method var0) {
      Class[] var4 = var0.getParameterTypes();
      Unknown357[] var5 = new Unknown357[var4.length];

      for(int var6 = var4.length - 1; var6 >= 0; --var6) {
         var5[var6] = c(var4[var6]);
      }

      return var5;
   }

   public static Unknown357 b(Method var0) {
      return a(a(var0));
   }

   public String d() {
      return this.b().replaceAll("\\.", "/");
   }

   public static Unknown357[] e(String var0) {
      int var1 = 0;

      for(int var2 = 1; var0.charAt(var2) != ')'; ++var1) {
         while(var0.charAt(var2) == '[') {
            ++var2;
         }

         if (var0.charAt(var2++) == 'L') {
            int var3 = var0.indexOf(59, var2);
            var2 = Math.max(var2, var3 + 1);
         }
      }

      Unknown357[] var8 = new Unknown357[var1];
      int var7 = 1;

      int var5;
      for(int var4 = 0; var0.charAt(var7) != ')'; var8[var4++] = a(var0, var5, var7)) {
         var5 = var7;

         while(var0.charAt(var7) == '[') {
            ++var7;
         }

         if (var0.charAt(var7++) == 'L') {
            int var6 = var0.indexOf(59, var7);
            var7 = Math.max(var7, var6 + 1);
         }
      }

      return var8;
   }

   public static int g(String var0) {
      int var1 = 1;

      while(var0.charAt(var1) != ')') {
         while(var0.charAt(var1) == '[') {
            ++var1;
         }

         if (var0.charAt(var1++) == 'L') {
            int var2 = var0.indexOf(59, var1);
            var1 = Math.max(var1, var2 + 1);
         }
      }

      return var1 + 1;
   }

   public int b(int var1) {
      if (var1 != 46 && var1 != 79) {
         switch(this.g) {
            case 0:
               if (var1 != 172) {
                  throw new UnsupportedOperationException();
               }

               return 177;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
               return var1;
            case 6:
               return var1 + 2;
            case 7:
               return var1 + 1;
            case 8:
               return var1 + 3;
            case 9:
            case 10:
            case 12:
               if (var1 != 21 && var1 != 54 && var1 != 172) {
                  throw new UnsupportedOperationException();
               }

               return var1 + 4;
            case 11:
               throw new UnsupportedOperationException();
            default:
               throw new AssertionError();
         }
      } else {
         switch(this.g) {
            case 0:
            case 11:
               throw new UnsupportedOperationException();
            case 1:
            case 3:
               return var1 + 5;
            case 2:
               return var1 + 6;
            case 4:
               return var1 + 7;
            case 5:
               return var1;
            case 6:
               return var1 + 2;
            case 7:
               return var1 + 1;
            case 8:
               return var1 + 3;
            case 9:
            case 10:
            case 12:
               return var1 + 4;
            default:
               throw new AssertionError();
         }
      }
   }

   public static Unknown357 b(Unknown357 var0, Unknown357[] var1) {
      return a(a(var0, var1));
   }

   private void a(StringBuilder var1) {
      if (this.g == 10) {
         var1.append(this.v, this.u - 1, this.o + 1);
      } else if (this.g == 12) {
         var1.append('L').append(this.v, this.u, this.o).append(';');
      } else {
         var1.append(this.v, this.u, this.o);
      }

   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Unknown357)) {
         return false;
      } else {
         Unknown357 var2 = (Unknown357)var1;
         if ((this.g == 12 ? 10 : this.g) != (var2.g == 12 ? 10 : var2.g)) {
            return false;
         } else {
            int var3 = this.u;
            int var4 = this.o;
            int var5 = var2.u;
            int var6 = var2.o;
            if (var4 - var3 != var6 - var5) {
               return false;
            } else {
               int var7 = var3;

               for(int var8 = var5; var7 < var4; ++var8) {
                  if (this.v.charAt(var7) != var2.v.charAt(var8)) {
                     return false;
                  }

                  ++var7;
               }

               return true;
            }
         }
      }
   }

   public static Unknown357 a(Constructor var0) {
      return a(b(var0));
   }

   public static String b(Class var0) {
      StringBuilder var1 = new StringBuilder();
      a(var0, var1);
      return var1.toString();
   }

   public static String a(Method var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append('(');
      Class[] var2 = var0.getParameterTypes();

      for(Class var6 : var2) {
         a(var6, var1);
      }

      var1.append(')');
      a(var0.getReturnType(), var1);
      return var1.toString();
   }

   public static Unknown357 c(Class var0) {
      if (var0.isPrimitive()) {
         if (var0 == Integer.TYPE) {
            return i;
         } else if (var0 == Void.TYPE) {
            return b;
         } else if (var0 == Boolean.TYPE) {
            return c;
         } else if (var0 == Byte.TYPE) {
            return h;
         } else if (var0 == Character.TYPE) {
            return m;
         } else if (var0 == Short.TYPE) {
            return x;
         } else if (var0 == Double.TYPE) {
            return a;
         } else if (var0 == Float.TYPE) {
            return t;
         } else if (var0 == Long.TYPE) {
            return j;
         } else {
            throw new AssertionError();
         }
      } else {
         return a(b(var0));
      }
   }

   public int a() {
      int var1 = 1;

      while(this.v.charAt(this.u + var1) == '[') {
         ++var1;
      }

      return var1;
   }

   public static String b(Constructor var0) {
      StringBuilder var4 = new StringBuilder();
      var4.append('(');
      Class[] var5 = var0.getParameterTypes();

      for(Class var9 : var5) {
         a(var9, var4);
      }

      return var4.append(")V").toString();
   }

   public static Unknown357 c(Method var0) {
      return c(var0.getReturnType());
   }

   public static Unknown357 b(String var0) {
      return new Unknown357(11, var0, 0, var0.length());
   }

   private static Unknown357 a(String var0, int var1, int var2) {
      switch(var0.charAt(var1)) {
         case '(':
            return new Unknown357(11, var0, var1, var2);
         case 'B':
            return h;
         case 'C':
            return m;
         case 'D':
            return a;
         case 'F':
            return t;
         case 'I':
            return i;
         case 'J':
            return j;
         case 'L':
            return new Unknown357(10, var0, var1 + 1, var2 - 1);
         case 'S':
            return x;
         case 'V':
            return b;
         case 'Z':
            return c;
         case '[':
            return new Unknown357(9, var0, var1, var2);
         default:
            throw new IllegalArgumentException("Unknown type identifier: " + var0.charAt(var1));
      }
   }
}
