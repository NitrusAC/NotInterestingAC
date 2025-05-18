package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.api.config.CheckConfig;
import java.util.Map;

public final class Unknown115 {
   private final AbstractCheck a;
   private CheckConfig b;

   public Unknown115(AbstractCheck var1) {
      this.a = var1;
   }

   public void a(Map var1) {
      this.b = new CheckConfig(var1, this);
   }

   public AbstractCheck a() {
      return this.a;
   }

   public CheckConfig b() {
      return this.b;
   }
}
