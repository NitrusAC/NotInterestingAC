package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.l;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.PotionHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.unknown.Unknown159;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

@Deprecated
public final class CollisionUtil {
   @Deprecated
   public static boolean collideLiquid(World world, PlayerData data, Box box) {
      int var6 = MathUtil.floor(box.minX);
      int var7 = MathUtil.floor(box.minY);
      int var8 = MathUtil.floor(box.minZ);
      int var9 = MathUtil.floor(box.maxX);
      int var10 = MathUtil.floor(box.maxY);
      int var11 = MathUtil.floor(box.maxZ);

      for(int var12 = var6; var12 <= var9; ++var12) {
         for(int var13 = var7; var13 <= var10; ++var13) {
            for(int var14 = var8; var14 <= var11; ++var14) {
               Material var15 = WorldUtil.getMaterialAt(data, world, var12, var13, var14);
               if (MaterialUtil.isLiquid(var15)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @Deprecated
   public static boolean collideLava(PlayerData data, World world, Box box) {
      int var6 = MathUtil.floor(box.minX);
      int var7 = MathUtil.floor(box.minY);
      int var8 = MathUtil.floor(box.minZ);
      int var9 = MathUtil.floor(box.maxX + 1.0);
      int var10 = MathUtil.floor(box.maxY + 1.0);
      int var11 = MathUtil.floor(box.maxZ + 1.0);

      for(int var12 = var6; var12 < var9; ++var12) {
         for(int var13 = var7; var13 < var10; ++var13) {
            for(int var14 = var8; var14 < var11; ++var14) {
               if (MaterialUtil.isLava(WorldUtil.getMaterialAt(data, world, var12, var13, var14))) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @Deprecated
   private static boolean getCollidingBoxes(Player player, Box box) {
      return de.jpx3.intave.anticheat.engine.util.CollisionUtil.isColliding(player, box)
         && !collideLiquid(player.getWorld(), PlayerDataManager.getPlayerData(player), box);
   }

   @Deprecated
   public static float a(PlayerData data, Location location) {
      Material var2 = WorldUtil.getMaterialAt(data, location);
      return BlockTypeUtil.getOrDefault(var2).getSliperiness() * 0.91F;
   }

   @Deprecated
   public static double getJumpBoost(Player player, float total) {
      PlayerData var5 = PlayerDataManager.getPlayerData(player);
      PotionHolder var6 = var5.getStorage().getPotionHolder();
      if (var6.jumpBoostEffectDuration > 0) {
         int var7 = var6.getJumpBoostAmplifier();
         total += (float)((double)(var7 + 1) * 0.1);
      }

      return (double)total;
   }

   @Deprecated
   public static boolean getCollidingBoxes(Player player, Box box, double expandX, double expandY, double expandZ) {
      return getCollidingBoxes(player, box.add(expandX, expandY, expandZ));
   }

   @Deprecated
   public static boolean collideLiquid(PlayerData data, World world, Box box) {
      int var6 = MathUtil.floor(box.minX);
      int var7 = MathUtil.floor(box.minY);
      int var8 = MathUtil.floor(box.minZ);
      int var9 = MathUtil.floor(box.maxX);
      int var10 = MathUtil.floor(box.maxY);
      int var11 = MathUtil.floor(box.maxZ);

      for(int var12 = var6; var12 <= var9; ++var12) {
         for(int var13 = var7; var13 <= var10; ++var13) {
            for(int var14 = var8; var14 <= var11; ++var14) {
               Material var15 = WorldUtil.getMaterialAt(data, world, var12, var13, var14);
               if (!MaterialUtil.isLiquid(var15)) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   @Deprecated
   private static boolean a(PlayerData data, double x, double y, double z) {
      l var10 = WorldUtil.b(data, data.getPlayer().getWorld(), x, y, z);
      boolean var11 = var10.a("open");
      if (var11) {
         Direction var12 = (Direction)var10.a(Direction.class, "facing");
         if (WorldUtil.getMaterialAt(data, data.getPlayer().getWorld(), x, y - 1.0, z) != Material.LADDER) {
            return false;
         } else {
            l var13 = WorldUtil.b(data, data.getPlayer().getWorld(), x, y - 1.0, z);
            Direction var14 = (Direction)var13.a(Direction.class, "facing");
            return var12 != null && var12 == var14;
         }
      } else {
         return false;
      }
   }

   @Deprecated
   public static float getAcceleration(PlayerData data, boolean sprint, double x, double y, double z) {
      BukkitEnginePlayer var11 = data.getStorage().getPhysicsHolder();
      World var12 = data.getPlayer().getWorld();
      float var13;
      if (var11.onGround) {
         float var14 = getFriction(data, var12, x, y - var11.getFrictionBlockRemove(), z);
         float var15 = var11.getFrictionMultiplier() / (var14 * var14 * var14);
         var13 = var11.getMovementSpeed(sprint) * var15;
      } else {
         var13 = var11.getJumpMoveFactor();
      }

      return var13;
   }

   @Deprecated
   public static float getFriction(PlayerData data, World world, double x, double y, double z) {
      Material var8 = WorldUtil.getMaterialAt(data, world, x, y, z);
      return BlockTypeUtil.getOrDefault(var8).getSliperiness() * 0.91F;
   }

   @Deprecated
   public static boolean b(PlayerData data, double x, double y, double z) {
      Player var10 = data.getPlayer();
      VersionHolder var11 = data.getStorage().getVersionHolder();
      Material var12 = WorldUtil.getMaterialAt(data, var10.getWorld(), MathUtil.floor(x), MathUtil.floor(y), MathUtil.floor(z));
      return var11.isNewerVersion() && Unknown159.a(var12) && a(data, x, y, z) ? true : BlockTypeUtil.getOrDefault(var12).d();
   }
}
