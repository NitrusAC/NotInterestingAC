package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.collision.liquid.LiquidCollisionProvider;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.collision.Box;
import org.bukkit.Location;

public final class Unknown360 {
   private static LiquidCollisionProvider a;

   public static boolean a(PlayerData data, Box box) {
      return a != null && a.collidesWater(data, box);
   }

   public static void a() {
      String var3;
      if (MinecraftVersion.V_1_18_2.atOrAbove()) {
         var3 = "de.jpx3.intave.n9";
      } else if (MinecraftVersion.V_1_16.atOrAbove()) {
         var3 = "de.jpx3.intave.nx";
      } else if (MinecraftVersion.V_1_14.atOrAbove()) {
         var3 = "de.jpx3.intave.ny";
      } else if (MinecraftVersion.V_1_13.atOrAbove()) {
         var3 = "de.jpx3.intave.nd";
      } else {
         var3 = "de.jpx3.intave.anticheat.engine.collision.liquid.impl.IntaveLiquidCollisionProvider";
      }

      Unknown152.a(IntavePlugin.class.getClassLoader(), var3);

      try {
         a = (LiquidCollisionProvider)Class.forName(var3).newInstance();
      } catch (Exception var5) {
         throw new IntaveInternalException(var5);
      }
   }

   public static Unknown105 a(PlayerData var0, double var1, double var3, double var5) {
      return a.a(var0, MathUtil.floor(var1), MathUtil.floor(var3), MathUtil.floor(var5));
   }

   public static Unknown105 a(PlayerData var0, Location var1) {
      return a(var0, var1.getX(), var1.getY(), var1.getZ());
   }

   public static Unknown105 a(PlayerData var0, int var1, int var2, int var3) {
      return a.a(var0, var1, var2, var3);
   }

   public static boolean b(PlayerData var0, double var1, double var3, double var5) {
      return a != null && a(var0, var1, var3, var5).f();
   }
}
