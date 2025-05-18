package de.jpx3.intave.unknown;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

@Unknown61
class Unknown273 {
   static Object b(World var0) {
      return a(var0);
   }

   @Unknown61
   private static Object a(World var0) {
      return ((CraftWorld)var0).getHandle().chunkProviderServer;
   }
}
