package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.event.Event;
import de.jpx3.intave.anticheat.event.EventVisitor;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;

public final class Unknown401 extends EventVisitor {
   private final Unknown369 a;

   public Unknown401(Unknown369 var1) {
      this.a = var1;
   }

   @Override
   public void visit(Event event) {
      MoudleLoader.j().b().a(this.a, event);
   }
}
