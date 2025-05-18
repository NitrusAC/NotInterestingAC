package de.jpx3.intave.unknown.asm;

public final class Asm36 extends IndexOutOfBoundsException {
   private static final long serialVersionUID = 160715609518896765L;
   private static final String d;
   private final String a;
   private final int b;

   public Asm36(String var1, int var2) {
      super("Class too large: " + var1);
      this.a = var1;
      this.b = var2;
   }

   public String a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }
}
