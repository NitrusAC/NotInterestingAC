package de.jpx3.intave.unknown;

import de.jpx3.intave.gn;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.engine.interact.Interactable;
import de.jpx3.intave.anticheat.engine.interact.impl.LevelInteractable;
import de.jpx3.intave.anticheat.util.MinecraftVersion;

public final class Unknown291 {
   private static Interactable a;

   public static Interactable a() {
      return a;
   }

   private static Object a(String var0) {
      try {
         return Class.forName(var0).newInstance();
      } catch (IllegalAccessException | ClassNotFoundException | InstantiationException var2) {
         throw new IntaveInternalException(var2);
      }
   }

   public static void b() {
      String var5 = "";
      String var4;
      if (MinecraftVersion.V_1_17_1.atOrAbove()) {
         var4 = "de.jpx3.intave.k6";
      } else if (MinecraftVersion.V_1_14.atOrAbove()) {
         var4 = "de.jpx3.intave.kw";
      } else if (MinecraftVersion.V_1_13.atOrAbove()) {
         var4 = "de.jpx3.intave.kP";
      } else if (MinecraftVersion.V_1_11.atOrAbove()) {
         var4 = "de.jpx3.intave.kb";
         var5 = "de.jpx3.intave.du";
      } else if (MinecraftVersion.V_1_9.atOrAbove()) {
         var4 = "de.jpx3.intave.kr";
         var5 = "de.jpx3.intave.co";
      } else {
         var4 = "de.jpx3.intave.unknown.Unknown224";
         var5 = "de.jpx3.intave.unknown.Unknown188";
      }

      ClassLoader var6 = IntavePlugin.class.getClassLoader();
      Unknown152.a(var6, var5);
      Unknown152.a(var6, var4);
      a = (Interactable)a(var4);
      if (MinecraftVersion.V_1_14.atOrAbove()) {
         a = new gn(a);
      }

      a = new Unknown236(a);
      a = new LevelInteractable(a);
      a = new Unknown256(a);
      a = new Unknown11(a);
   }
}
