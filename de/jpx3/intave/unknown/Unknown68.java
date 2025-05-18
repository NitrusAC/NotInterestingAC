package de.jpx3.intave.unknown;

import de.jpx3.intave.eh;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftChunk;

@Unknown61
public class Unknown68 {
   @Unknown61
   public static Block a(PlayerData var0, World var1, int var2, int var3, int var4) {
      if (MinecraftVersion.V_1_13.atOrAbove()) {
         return new eh(var0, var2, var3, var4);
      } else {
         CraftChunk var5 = (CraftChunk)var1.getChunkAt(var2 >> 4, var4 >> 4);
         return new Unknown153(var0, var5, var2, var3, var4);
      }
   }
}
