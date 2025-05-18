package de.jpx3.intave.unknown;

public interface Unknown56 {
   void a(int var1, int var2, int var3);

   void a();

   default void b(int var1, int var2, int var3) {
      this.a(var1 + 1, var2, var3);
      this.a(var1 - 1, var2, var3);
      this.a(var1, var2, var3 + 1);
      this.a(var1, var2, var3 - 1);
      this.a(var1, var2 + 1, var3);
      this.a(var1, var2 - 1, var3);
      this.a(var1, var2, var3);
   }

   void b();
}
