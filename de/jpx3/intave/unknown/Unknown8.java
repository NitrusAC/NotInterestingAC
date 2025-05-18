package de.jpx3.intave.unknown;

public enum Unknown8 {
   private static final Unknown8[] e = new Unknown8[]{Unknown8.POSITIVE, Unknown8.NEGATIVE};
   private final String c;
   private final int d;
   public static final Unknown8 NEGATIVE = new Unknown8(-1, "Towards negative");
   public static final Unknown8 POSITIVE = new Unknown8(1, "Towards positive");

   public int a() {
      return this.d;
   }

   private Unknown8(int var3, String var4) {
      this.d = var3;
      this.c = var4;
   }

   public String toString() {
      return this.c;
   }
}
