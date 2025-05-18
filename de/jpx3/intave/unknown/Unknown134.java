package de.jpx3.intave.unknown;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;

@Unknown61
@Deprecated
public final class Unknown134 {
   @Unknown61
   public static Object b(Entity var0) {
      return ((CraftEntity)var0).getHandle();
   }

   @Unknown61
   public static Object a(World var0) {
      return ((CraftWorld)var0).getHandle();
   }

   @Unknown61
   public static Object a(Entity var0) {
      return ((EntityPlayer)b(var0)).playerConnection;
   }
}
