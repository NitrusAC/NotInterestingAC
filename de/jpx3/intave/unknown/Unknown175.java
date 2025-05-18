package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.module.impl.VelocityModule;

public final class Unknown175 {
   private VelocityModule a;
   private final IntavePlugin b;

   public VelocityModule b() {
      return this.a;
   }

   public Unknown175(IntavePlugin var1) {
      this.b = var1;
   }

   public void a() {
      new Unknown3(this.b);
      this.a = new VelocityModule(this.b);
   }

   static {
      String var6 = "de.jpx3.intave.unknown.Unknown325";
      Unknown152.a(IntavePlugin.class.getClassLoader(), var6);
   }
}
