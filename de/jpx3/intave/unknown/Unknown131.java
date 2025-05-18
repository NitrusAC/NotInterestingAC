package de.jpx3.intave.unknown;

public enum Unknown131 {
   private static final Unknown131[] d = new Unknown131[]{Unknown131.a, Unknown131.b};
   final String e;
   public static final Unknown131 b = new Unknown131("intave.command.notify", true);
   public static final Unknown131 a = new Unknown131("intave.command.verbose", false);
   public final boolean f;

   private Unknown131(String var3, boolean var4) {
      this.e = var3;
      this.f = var4;
   }

   public boolean b() {
      return this.f;
   }

   public String a() {
      return this.e;
   }
}
