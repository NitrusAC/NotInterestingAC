package de.jpx3.intave.unknown;

import de.jpx3.intave.bL;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import org.bukkit.entity.Entity;

public final class Unknown364 {
   private static Unknown146 a;

   public static void a() {
      boolean var4 = MinecraftVersion.V_1_14.atOrAbove();
      String var5 = var4 ? "de.jpx3.intave.bL" : "de.jpx3.intave.unknown.Unknown222";
      Unknown152.a(IntavePlugin.class.getClassLoader(), var5);
      a = (Unknown146)(var4 ? new bL() : new Unknown222());
   }

   public static HitboxSize a(Object var0) {
      return a.a(var0);
   }

   public static HitboxSize a(Entity var0) {
      return a.a(var0);
   }
}
