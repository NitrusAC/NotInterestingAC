package de.jpx3.intave.unknown;

final class Unknown329 extends Unknown337 {
   private final int c;
   private final int a;
   private static final String e;

   public String toString() {
      return "(" + this.c + " <= {value} <= " + this.a + ")";
   }

   public Unknown329(int var1, int var2) {
      this.c = Math.min(var1, var2);
      this.a = Math.max(var1, var2);
   }

   @Override
   public boolean a(int var1) {
      return this.c <= var1 && var1 <= this.a;
   }
}
