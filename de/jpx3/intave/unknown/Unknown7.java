package de.jpx3.intave.unknown;

import java.util.function.BinaryOperator;

public enum Unknown7 {
   final BinaryOperator e;
   private static final Unknown7[] values = new Unknown7[]{Unknown7.AND, Unknown7.OR};
   final String f;
   public static final Unknown7 OR = new Unknown7(Unknown7::b, "||");
   public static final Unknown7 AND = new Unknown7(Unknown7::c, "&&");

   public BinaryOperator b() {
      return this.e;
   }

   public String a() {
      return this.f;
   }

   private static Boolean c(Boolean var0, Boolean var1) {
      return var0 && var1;
   }

   private Unknown7(BinaryOperator var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

   private static Boolean b(Boolean var0, Boolean var1) {
      return var0 || var1;
   }
}
