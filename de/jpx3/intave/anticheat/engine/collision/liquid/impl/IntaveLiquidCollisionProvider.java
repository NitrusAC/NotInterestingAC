package de.jpx3.intave.anticheat.engine.collision.liquid.impl;

import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.collision.liquid.LiquidCollisionProvider;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.MaterialUtil;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.unknown.Unknown105;
import de.jpx3.intave.unknown.Unknown143;
import de.jpx3.intave.unknown.Unknown15;
import de.jpx3.intave.unknown.Unknown307;
import de.jpx3.intave.unknown.Unknown94;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

final class IntaveLiquidCollisionProvider extends LiquidCollisionProvider {
   @Override
   protected WrappedVec3d b(PlayerData var1, int var2, int var3, int var4) {
      return null;
   }

   @Override
   protected boolean collidesWater(PlayerData data, Box box) {
      Player var7 = data.getPlayer();
      World var8 = var7.getWorld();
      BukkitEnginePlayer var9 = data.getStorage().getPhysicsHolder();
      Box var10 = box.shrink(0.001);
      int var11 = MathUtil.floor(var10.minX);
      int var12 = MathUtil.floor(var10.minY);
      int var13 = MathUtil.floor(var10.minZ);
      int var14 = MathUtil.ceil(var10.maxX);
      int var15 = MathUtil.ceil(var10.maxY);
      int var16 = MathUtil.ceil(var10.maxZ);
      double var17 = 0.0;
      boolean var19 = false;
      WrappedVec3d var20 = new WrappedVec3d(0.0, 0.0, 0.0);
      int var21 = 0;

      for(int var22 = var11; var22 < var14; ++var22) {
         for(int var23 = var12; var23 < var15; ++var23) {
            for(int var24 = var13; var24 < var16; ++var24) {
               Block var25 = WorldUtil.getBlockAt(var8, var22, var23, var24);
               Material var26 = WorldUtil.getMaterialAt(data, var8, var22, var23, var24);
               boolean var27 = MaterialUtil.isWater(IntaveMaterial.parse(var25, var7));
               boolean var28 = MaterialUtil.isWater(var26);
               if (var27) {
                  double var29 = (double)(1.0F - Unknown143.a(Unknown15.b(var25)));
                  double var31 = (double)((float)var23) + var29;
                  if (var31 >= var10.minY) {
                     var19 = true;
                     var17 = Math.max(var31 - var10.minY, var17);
                     WrappedVec3d var33 = Unknown143.a(data, new BlockPos(var22, var23, var24), new WrappedVec3d(0.0, 0.0, 0.0));
                     if (var17 < 0.4) {
                        var33 = var33.a(var17);
                     }

                     var20 = var20.b(var33);
                     ++var21;
                  }
               } else if (var28) {
                  var19 = true;
               }
            }
         }
      }

      if (var20.sqrt() > 0.0) {
         if (var21 > 0) {
            var20 = var20.a(1.0 / (double)var21);
         }

         var20 = var20.f();
         double var35 = 0.014;
         var9.deltaX += var20.x * var35;
         var9.deltaY += var20.y * var35;
         var9.deltaZ += var20.z * var35;
         var9.at = 0;
      }

      return var19;
   }

   @Override
   protected Unknown105 a(PlayerData var1, int var2, int var3, int var4) {
      Player var8 = var1.getPlayer();
      Block var9 = WorldUtil.getBlockAt(var1.getPlayer().getWorld(), var2, var3, var4);
      if (var9.getY() < Unknown94.d) {
         return Unknown105.b();
      } else {
         float var10 = Unknown143.a(Unknown15.b(var9));
         Material var11 = IntaveMaterial.parse(var9, var8);
         Unknown307 var12 = Unknown307.c;
         if (MaterialUtil.isWater(var11)) {
            var12 = Unknown307.a;
         } else if (MaterialUtil.isLava(var11)) {
            var12 = Unknown307.b;
         }

         return Unknown105.a(var12, true, var10);
      }
   }
}
