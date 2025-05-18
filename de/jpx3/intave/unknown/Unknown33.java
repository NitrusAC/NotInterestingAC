package de.jpx3.intave.unknown;

import de.jpx3.intave.pa;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.MinecraftVersion;

public final class Unknown33 {
   static Unknown226 a() {
      boolean var3 = MinecraftVersion.V_1_13.atOrAbove();
      String var4 = var3 ? "de.jpx3.intave.pa" : "de.jpx3.intave.unknown.Unknown271";
      Unknown152.a(IntavePlugin.class.getClassLoader(), var4);
      return (Unknown226)(var3 ? new pa() : new Unknown271());
   }
}
