package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import org.bukkit.block.Block;

public final class Unknown210 {
   public static Block a(PlayerData var0, Block var1) {
      return Unknown68.a(var0, var1.getWorld(), var1.getX(), var1.getY(), var1.getZ());
   }

   public static void a() {
      ClassLoader var3 = Unknown210.class.getClassLoader();
      Unknown152.a(var3, "de.jpx3.intave.unknown.Unknown68");
      if (MinecraftVersion.V_1_13.atOrAbove()) {
         Unknown152.a(var3, "de.jpx3.intave.eh");
      } else {
         Unknown152.a(var3, "de.jpx3.intave.unknown.Unknown153");
      }

   }
}
