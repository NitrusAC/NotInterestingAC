package de.jpx3.intave.unknown;

final class Unknown331 extends Unknown337 {
   private final int a;
   private static final String d;

   public String toString() {
      return "({value} == " + this.a + ")";
   }

   public Unknown331(int var1) {
      this.a = var1;
   }

   @Override
   public boolean a(int var1) {
      return var1 == this.a;
   }
}
