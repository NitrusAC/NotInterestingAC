package de.jpx3.intave.unknown.asm;

public final class Asm31 extends IndexOutOfBoundsException {
   private static final long serialVersionUID = 6807380416709738314L;
   private final String c;
   private static final String f;
   private final String d;
   private final String a;
   private final int b;

   public String a() {
      return this.c;
   }

   public int c() {
      return this.b;
   }

   public String b() {
      return this.a;
   }

   public Asm31(String var1, String var2, String var3, int var4) {
      super("Method too large: " + var1 + "." + var2 + " " + var3);
      this.d = var1;
      this.c = var2;
      this.a = var3;
      this.b = var4;
   }

   public String d() {
      return this.d;
   }
}
