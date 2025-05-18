package de.jpx3.intave.unknown;

import de.jpx3.intave.e9;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.MinecraftVersion;

public final class Unknown40 {
   static Unknown226 a() {
      boolean var4 = MinecraftVersion.V_1_9.atOrAbove();
      String var5 = var4 ? "de.jpx3.intave.e9" : "de.jpx3.intave.unknown.Unknown18";
      Unknown152.a(IntavePlugin.class.getClassLoader(), var5);
      return (Unknown226)(var4 ? new e9() : new Unknown18());
   }
}
