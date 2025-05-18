package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.command.impl.IntaveCommand;
import de.jpx3.intave.anticheat.module.impl.Log4jModule;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.unknown.check.Check4;
import de.jpx3.intave.unknown.check.Check5;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public final class Unknown299 extends UnknownCheck {
   private final List a = new ArrayList();
   private static final String f;

   private void b() {
      for(Unknown254 var5 : this.a) {
         if (var5.c()) {
            MoudleLoader.j().c().b(var5);
            MoudleLoader.j().a().b(var5);
         }
      }

   }

   private void a(Class var1) {
      try {
         Constructor var4 = var1.getConstructor(IntavePlugin.class);
         this.a.add(var4.newInstance(this.plugin));
      } catch (Exception var5) {
         throw new IntaveInternalException("Something went wrong setting up a filter", var5);
      }
   }

   @Override
   public void refreshConfig() {
      this.a(Check4.class);
      this.a(Check5.class);
      this.a(Unknown243.class);
      this.a(IntaveCommand.class);
      this.a(Log4jModule.class);
      this.b();
   }
}
