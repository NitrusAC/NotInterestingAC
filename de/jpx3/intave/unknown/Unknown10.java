package de.jpx3.intave.unknown;

public enum Unknown10 {
   public static final Unknown10 c = new Unknown10();
   private static final Unknown10[] e = new Unknown10[]{Unknown10.a, Unknown10.b, c};
   public static final Unknown10 a = new Unknown10();
   public static final Unknown10 b = new Unknown10();

   public static Unknown10 a(double var0, double var2) {
      if (var0 == 10.0) {
         return c;
      } else {
         return var0 > var2 ? b : a;
      }
   }
}
