package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.api.PartialCheck;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.unknown.check.Check8;
import java.util.Collection;
import java.util.function.Consumer;

public final class Unknown248 {
   private void a(Collection var1, Consumer var2) {
      for(AbstractCheck var7 : var1) {
         if (var7.e()) {
            var2.accept(var7);
         }

         for(PartialCheck var9 : var7.getChildren()) {
            if (var9.isEnabled()) {
               var2.accept(var9);
            }
         }
      }

   }

   public void a(Collection var1) {
      Check8 var2 = MoudleLoader.j().a();
      this.a(var1, var2::b);
   }

   public void f(Collection var1) {
      Unknown294 var2 = MoudleLoader.j().b();
      this.a(var1, var2::b);
   }

   public void c(Collection var1) {
      Check8 var2 = MoudleLoader.j().a();
      this.a(var1, var2::a);
   }

   public void b(Collection var1) {
      Unknown294 var2 = MoudleLoader.j().b();
      this.a(var1, var2::a);
   }

   public void d(Collection var1) {
      Unknown297 var2 = MoudleLoader.j().c();
      this.a(var1, var2::c);
   }

   public void e(Collection var1) {
      Unknown297 var2 = MoudleLoader.j().c();
      this.a(var1, var2::b);
   }
}
