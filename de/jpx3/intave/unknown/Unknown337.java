package de.jpx3.intave.unknown;

public abstract class Unknown337 {
   public static Unknown337 b(int var0) {
      return new Unknown331(var0);
   }

   public Unknown337 b(Unknown337 var1) {
      return a(Unknown7.OR, new Unknown337[]{this, var1});
   }

   private static Unknown337 a(Unknown7 var0, Unknown337[] var1) {
      return new Unknown330(var1, var0);
   }

   public static Unknown337 a(int var0, int var1) {
      return new Unknown329(var0, var1);
   }

   public abstract boolean a(int var1);

   public Unknown337 a(Unknown337 var1) {
      return a(Unknown7.AND, new Unknown337[]{this, var1});
   }

   public static Unknown337 a() {
      return a(Integer.MIN_VALUE, Integer.MAX_VALUE);
   }
}
