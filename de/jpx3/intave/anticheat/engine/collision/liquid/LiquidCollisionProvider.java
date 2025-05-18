package de.jpx3.intave.anticheat.engine.collision.liquid;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.MaterialUtil;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.unknown.Unknown105;
import org.bukkit.Material;
import org.bukkit.World;

public abstract class LiquidCollisionProvider {
   public final Unknown105 a(PlayerData data, double x, double y, double z) {
      return this.a(data, MathUtil.floor(x), MathUtil.floor(y), MathUtil.floor(z));
   }

   public boolean collidesWater(PlayerData data, Box box) {
      World var6 = data.getPlayer().getWorld();
      BukkitEnginePlayer var7 = data.getStorage().getPhysicsHolder();
      Box var8 = box.shrink(0.001);
      int var9 = MathUtil.floor(var8.minX);
      int var10 = MathUtil.floor(var8.minY);
      int var11 = MathUtil.floor(var8.minZ);
      int var12 = MathUtil.ceil(var8.maxX);
      int var13 = MathUtil.ceil(var8.maxY);
      int var14 = MathUtil.ceil(var8.maxZ);
      boolean var15 = false;
      int var16 = 0;
      WrappedVec3d var17 = WrappedVec3d.c;
      double var18 = 0.0;

      for(int var20 = var9; var20 < var12; ++var20) {
         for(int var21 = var10; var21 < var13; ++var21) {
            for(int var22 = var11; var22 < var14; ++var22) {
               Material var23 = WorldUtil.getMaterialAt(data, var6, var20, var21, var22);
               Unknown105 var24 = this.a(data, var20, var21, var22);
               if (var24.c()) {
                  double var25 = (double)((float)var21 + var24.e());
                  if (var25 >= var8.minY) {
                     var15 = true;
                     var18 = Math.max(var25 - var8.minY, var18);
                     WrappedVec3d var27 = this.b(data, var20, var21, var22);
                     if (var18 < 0.4) {
                        var27 = var27.a(var18);
                     }

                     var17 = var17.b(var27);
                     ++var16;
                  }
               } else if (MaterialUtil.isWater(var23)) {
                  var15 = true;
               }
            }
         }
      }

      if (var17.sqrt() > 0.0) {
         if (var16 > 0) {
            var17 = var17.a(1.0 / (double)var16);
         }

         var17 = var17.f();
         double var29 = 0.014;
         var7.deltaX += var17.x * var29;
         var7.deltaY += var17.y * var29;
         var7.deltaZ += var17.z * var29;
         var7.at = 0;
      }

      return var15;
   }

   protected abstract WrappedVec3d b(PlayerData data, int x, int y, int z);

   public abstract Unknown105 a(PlayerData data, int x, int y, int z);
}
