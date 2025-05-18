package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.Check;

public class Unknown254 implements Check {
   private final boolean a;
   private final String c;
   private static final String h;

   public Unknown254(String var1) {
      this.c = var1;
      this.a = IntavePlugin.getInstance().getConfig().getBoolean("filter." + var1);
   }

   protected boolean c() {
      return this.a;
   }
}
