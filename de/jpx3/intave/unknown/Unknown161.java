package de.jpx3.intave.unknown;

import de.jpx3.intave.gA;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.collision.EntityHitbox;
import de.jpx3.intave.anticheat.util.reach.ReachEntityType;

public final class Unknown161 {
   private static final boolean a = MinecraftVersion.V_1_14.atOrAbove();
   private static Unknown346 b;
   private static final String d;

   public static void a() {
      if (a) {
         Unknown152.a(IntavePlugin.class.getClassLoader(), "de.jpx3.intave.gA");
         b = new gA();
      } else {
         b = new EntityHitbox();
      }

   }

   public static ReachEntityType a(int var0, boolean var1) {
      return b.a(var0, var1);
   }
}
