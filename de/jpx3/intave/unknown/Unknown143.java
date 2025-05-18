package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.Direction;
import de.jpx3.intave.anticheat.util.MaterialUtil;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class Unknown143 {
   private static int b(PlayerData var0, BlockPos var1) {
      World var5 = var0.getPlayer().getWorld();
      Material var6 = WorldUtil.getMaterialAt(var0, var5, var1.x, var1.y, var1.z);
      return MaterialUtil.isWater(var6) ? WorldUtil.a(var0, var5, var1.x, var1.y, var1.z) : -1;
   }

   private static boolean a(PlayerData var0, BlockPos var1) {
      Material var2 = WorldUtil.getMaterialAt(var0, var0.getPlayer().getWorld(), var1.x, var1.y, var1.z);
      return MaterialUtil.canBeInsideBB(var2);
   }

   private static int c(PlayerData var0, BlockPos var1) {
      int var5 = b(var0, var1);
      return var5 >= 8 ? 0 : var5;
   }

   public static boolean a(PlayerData var0, Box var1) {
      Player var5 = var0.getPlayer();
      World var6 = var5.getWorld();
      BukkitEnginePlayer var7 = var0.getStorage().getPhysicsHolder();
      int var8 = MathUtil.floor(var1.minX);
      int var9 = MathUtil.floor(var1.minY);
      int var10 = MathUtil.floor(var1.minZ);
      int var11 = MathUtil.floor(var1.maxX + 1.0);
      int var12 = MathUtil.floor(var1.maxY + 1.0);
      int var13 = MathUtil.floor(var1.maxZ + 1.0);
      boolean var14 = false;
      WrappedVec3d var15 = null;

      for(int var16 = var8; var16 < var11; ++var16) {
         for(int var17 = var9; var17 < var12; ++var17) {
            for(int var18 = var10; var18 < var13; ++var18) {
               Material var19 = WorldUtil.getMaterialAt(var0, var6, var16, var17, var18);
               if (MaterialUtil.isWater(var19)) {
                  int var20 = WorldUtil.a(var0, var6, var16, var17, var18);
                  double var21 = (double)((float)(var17 + 1) - a(var20));
                  if ((double)var12 >= var21) {
                     var14 = true;
                     if (var15 == null) {
                        var15 = new WrappedVec3d(0.0, 0.0, 0.0);
                     }

                     var15 = a(var0, new BlockPos(var16, var17, var18), var15);
                  }
               }
            }
         }
      }

      if (var14 && var15 != null && var15.distanceSqrt() > 0.0) {
         var15 = var15.f();
         double var24 = 0.014;
         var7.deltaX += var15.x * var24;
         var7.deltaY += var15.y * var24;
         var7.deltaZ += var15.z * var24;
         var7.at = 0;
      }

      return var14;
   }

   public static WrappedVec3d a(PlayerData var0, BlockPos var1, WrappedVec3d var2) {
      return var2.b(d(var0, var1));
   }

   public static float a(int var0) {
      if (var0 >= 8) {
         var0 = 0;
      }

      return (float)(var0 + 1) / 9.0F;
   }

   private static WrappedVec3d d(PlayerData var0, BlockPos var1) {
      WrappedVec3d var5 = new WrappedVec3d(0.0, 0.0, 0.0);
      int var6 = c(var0, var1);

      for(Direction var8 : Unknown189.a) {
         BlockPos var9 = var1.b(var8);
         int var10 = c(var0, var9);
         if (var10 < 0) {
            if (!a(var0, var1)) {
               var10 = c(var0, var9.g());
               if (var10 >= 0) {
                  int var11 = var10 - (var6 - 8);
                  var5 = var5.add((var9.x - var1.x) * (double)var11, (var9.y - var1.y) * (double)var11, (var9.z - var1.z) * (double)var11);
               }
            }
         } else {
            int var16 = var10 - var6;
            var5 = var5.add((var9.x - var1.x) * (double)var16, (var9.y - var1.y) * (double)var16, (var9.z - var1.z) * (double)var16);
         }
      }

      if (b(var0, var1) >= 8) {
         for(Direction var13 : Unknown189.a) {
            BlockPos var14 = var1.b(var13);
            if (a(var0, var14, var13) || a(var0, var14.a(), var13)) {
               var5 = var5.f().add(0.0, -6.0, 0.0);
               break;
            }
         }
      }

      return var5.f();
   }

   private static boolean a(PlayerData var0, BlockPos var1, Direction var2) {
      World var6 = var0.getPlayer().getWorld();
      Material var7 = WorldUtil.getMaterialAt(var0, var6, var1.x, var1.y, var1.z);
      return !MaterialUtil.isLiquid(var7) && (var2 == Direction.b || var7 != Material.ICE && MaterialUtil.canTraverse(var7));
   }
}
