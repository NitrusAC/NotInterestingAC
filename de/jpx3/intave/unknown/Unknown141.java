package de.jpx3.intave.unknown;

import de.jpx3.intave.access.server.ServerAccess;
import de.jpx3.intave.anticheat.IntavePlugin;

public final class Unknown141 {
   private final Unknown87 b;
   private final IntavePlugin c;
   private ServerAccess a;

   public synchronized ServerAccess b() {
      if (this.a == null) {
         this.a = this.a();
      }

      return this.a;
   }

   private ServerAccess a() {
      return this.b::c;
   }

   public Unknown141(IntavePlugin var1) {
      this.c = var1;
      this.b = new Unknown87(var1);
   }
}
