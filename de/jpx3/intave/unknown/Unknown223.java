package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.engine.interact.Interactable;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import java.util.ArrayList;
import java.util.List;

abstract class Unknown223 implements Interactable {
   protected Boxable a(List var1, int var2, int var3, int var4) {
      if (var1.isEmpty()) {
         return Unknown121.a();
      } else {
         ArrayList var8 = new ArrayList();

         for(Object var10 : var1) {
            var8.add(Box.a(var10).add((double)var2, (double)var3, (double)var4));
         }

         return Unknown121.c(var8);
      }
   }

   protected Boxable a(List var1) {
      if (var1.isEmpty()) {
         return Unknown121.a();
      } else {
         ArrayList var5 = new ArrayList();

         for(Object var7 : var1) {
            var5.add(Unknown182.c(var7));
         }

         return Unknown121.c(var5);
      }
   }
}
