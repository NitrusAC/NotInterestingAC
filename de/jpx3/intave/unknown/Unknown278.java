package de.jpx3.intave.unknown;

public interface Unknown278 {
   private boolean a(Unknown278 var1) {
      return this.a() && var1.a();
   }

   default Unknown278 c(Unknown278 var1) {
      return this::a;
   }

   boolean a();

   private boolean d(Unknown278 var1) {
      return this.a() || var1.a();
   }

   default Unknown278 b(Unknown278 var1) {
      return this::d;
   }
}
