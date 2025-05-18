package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.l;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.unknown.Unknown129;
import de.jpx3.intave.unknown.Unknown94;
import java.util.ConcurrentModificationException;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

@Relocate
public final class WorldUtil {
   public static l a(PlayerData data, Location location) {
      return c(data, location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
   }

   private static int floor(double value) {
      int var2 = (int)value;
      return value < (double)var2 ? var2 - 1 : var2;
   }

   public static int a(PlayerData data, World world, int x, int y, int z) {
      return !isChunkLoaded(world, x, z) && !Bukkit.isPrimaryThread() ? 0 : data.getWorld().a(x, y, z);
   }

   public static Material getMaterialAt(PlayerData data, World world, double x, double y, double z) {
      return getMaterialAt(data, world, floor(x), floor(y), floor(z));
   }

   public static Material getMaterialAt(PlayerData data, Location location) {
      return getMaterialAt(data, location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
   }

   private static Block getSpawnBlock(World world) {
      Location var1 = world.getSpawnLocation();
      if (!world.isChunkLoaded(var1.getBlockX(), var1.getBlockZ())) {
         try {
            Chunk[] var2 = world.getLoadedChunks();
            if (var2.length > 0) {
               Chunk var6 = var2[0];
               return world.getBlockAt(var6.getX() << 4, Unknown94.d - 1, var6.getZ() << 4);
            }
         } catch (ConcurrentModificationException var5) {
            Chunk[] var3 = world.getLoadedChunks();
            if (var3.length > 0) {
               Chunk var4 = var3[0];
               return world.getBlockAt(var4.getX() << 4, Unknown94.d - 1, var4.getZ() << 4);
            }
         }
      }

      return world.getBlockAt(var1.getBlockX(), Unknown94.d - 1, var1.getBlockZ());
   }

   public static Material getMaterialAt(PlayerData data, World world, IntaveVector vector) {
      return getMaterialAt(data, world, vector.getBlockX(), vector.getBlockY(), vector.getBlockZ());
   }

   public static Material getMaterialAt(PlayerData data, World world, int x, int y, int z) {
      return !isChunkLoaded(world, x, z) && !Bukkit.isPrimaryThread() ? Material.AIR : data.getWorld().getMaterialAt(x, y, z);
   }

   public static boolean isChunkLoaded(World world, int x, int z) {
      int var3 = x >> 4;
      int var4 = z >> 4;
      return world.isChunkLoaded(var3, var4) && world.isChunkInUse(var3, var4);
   }

   public static int a(PlayerData data, World world, double x, double y, double z) {
      return a(data, world, floor(x), floor(y), floor(z));
   }

   public static l c(PlayerData data, World world, int x, int y, int z) {
      Material var5 = getMaterialAt(data, world, x, y, z);
      int var6 = a(data, world, x, y, z);
      return Unknown129.b(var5, var6);
   }

   public static void a() {
   }

   public static Block getBlockAt(Location location) {
      return getBlockAt(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
   }

   public static l b(PlayerData data, World world, double x, double y, double z) {
      return c(data, world, floor(x), floor(y), floor(z));
   }

   public static Block getBlockAt(World world, BlockPos blockPos) {
      return getBlockAt(world, blockPos.x, blockPos.y, blockPos.z);
   }

   public static int c(PlayerData data, Location location) {
      return a(data, location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
   }

   public static Block getBlockAt(World world, int x, int y, int z) {
      if (!isChunkLoaded(world, x, z) && !Bukkit.isPrimaryThread()) {
         return getSpawnBlock(world);
      } else {
         try {
            return world.getBlockAt(x, y, z);
         } catch (IllegalStateException var5) {
            var5.printStackTrace();
            return getSpawnBlock(world);
         }
      }
   }

   public static Material getMaterialAt(PlayerData data, int x, int y, int z) {
      World var4 = data.getPlayer().getWorld();
      return getMaterialAt(data, var4, x, y, z);
   }

   public static Block getBlockAt(World world, double x, double y, double z) {
      return getBlockAt(world, floor(x), floor(y), floor(z));
   }

   public static int a(PlayerData var0, IntaveVector var1) {
      return a(var0, var0.getPlayer().getWorld(), var1.getBlockX(), var1.getBlockY(), var1.getBlockZ());
   }
}
