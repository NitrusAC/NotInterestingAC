package de.jpx3.intave.anticheat.engine.heading.impl;

import de.jpx3.intave.pf;
import de.jpx3.intave.anticheat.check.physics.PhysicsResult;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.engine.EnginePlayer;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MotionContext;
import de.jpx3.intave.anticheat.engine.MovementConfiguration;
import de.jpx3.intave.anticheat.engine.heading.HeadingHandler;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.move.MoveHandlerFactory;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.BlockTypeUtil;
import de.jpx3.intave.anticheat.util.MathHelperTable;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.unknown.Unknown105;
import de.jpx3.intave.unknown.Unknown187;
import de.jpx3.intave.unknown.Unknown242;
import de.jpx3.intave.unknown.Unknown360;
import javax.annotation.Nullable;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class BoatHeadingHandler extends HeadingHandler {
   private static final String d;

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void moveInternal(PlayerData data, Motion motion) {
      PlayerStorage var6 = data.getStorage();
      BukkitEnginePlayer var7 = var6.getPhysicsHolder();
      double var8 = -0.04F;
      double var10 = 0.0;
      var7.U = 0.05F;
      if (var7.H == Unknown242.e && var7.q != Unknown242.e && var7.q != Unknown242.d) {
         motion.motionY = 0.0;
         var7.q = Unknown242.a;
      } else {
         switch(pf.a[var7.q.ordinal()]) {
            case 1:
               var10 = (var7.an - var7.serverY) / (double)var7.height;
               var7.U = 0.9F;
               break;
            case 2:
               var8 = -7.0E-4;
               var7.U = 0.9F;
               break;
            case 3:
               var10 = 0.01F;
               var7.U = 0.45F;
               break;
            case 4:
               var7.U = 0.9F;
               break;
            case 5:
               var7.U = var7.aU;
               var7.aU /= 2.0F;
         }

         motion.motionX *= (double)var7.U;
         motion.motionY += var8;
         motion.motionZ *= (double)var7.U;
         if (var10 > 0.0) {
            motion.motionY = (motion.motionY + var10 * 0.06153846016296973) * 0.75;
         }
      }

   }

   @Override
   public PhysicsResult moveWithHeaving(PlayerData data, Motion motion, EnginePlayer enginePlayer, MovementConfiguration moveConfig) {
      BukkitEnginePlayer var8 = data.getStorage().getPhysicsHolder();
      var8.H = var8.q;
      var8.q = this.c(data);
      var8.aU = this.a(data);
      this.moveInternal(data, motion);
      this.b(data, motion);
      MotionContext var9 = MoveHandlerFactory.computeContext(data, motion, var8.inWeb, var8.serverX, var8.serverY, var8.serverZ);
      return PhysicsResult.of(data, moveConfig, var9);
   }

   private float a(PlayerData var1) {
      Player var5 = var1.getPlayer();
      Box var6 = Box.of(var1, var1.getStorage().getPhysicsHolder().D());
      Box var7 = new Box(var6.minX, var6.minY - 0.001, var6.minZ, var6.maxX, var6.minY, var6.maxZ);
      int var8 = MathUtil.floor(var7.minX) - 1;
      int var9 = MathUtil.ceil(var7.maxX) + 1;
      int var10 = MathUtil.floor(var7.minY) - 1;
      int var11 = MathUtil.ceil(var7.maxY) + 1;
      int var12 = MathUtil.floor(var7.minZ) - 1;
      int var13 = MathUtil.ceil(var7.maxZ) + 1;
      float var14 = 0.0F;
      int var15 = 0;

      for(int var16 = var8; var16 < var9; ++var16) {
         for(int var17 = var12; var17 < var13; ++var17) {
            int var18 = (var16 != var8 && var16 != var9 - 1 ? 0 : 1) + (var17 != var12 && var17 != var13 - 1 ? 0 : 1);
            if (var18 != 2) {
               for(int var19 = var10; var19 < var11; ++var19) {
                  if (var18 <= 0 || var19 != var10 && var19 != var11 - 1) {
                     Box var20 = new Box((double)var16, (double)var19, (double)var17, (double)(var16 + 1), (double)(var19 + 1), (double)(var17 + 1));
                     if (CollisionUtil.a(var5, var20)) {
                        Material var21 = WorldUtil.getMaterialAt(var1, var16, var19, var17);
                        var14 += BlockTypeUtil.getOrDefault(var21).getSliperiness();
                        ++var15;
                     }
                  }
               }
            }
         }
      }

      return var14 / (float)var15;
   }

   @Override
   public float getStepHeight() {
      return 0.0F;
   }

   private void b(PlayerData data, Motion motion) {
      BukkitEnginePlayer var6 = data.getStorage().getPhysicsHolder();
      int var7 = var6.G;
      int var8 = var6.D;
      boolean var9 = var7 == 1;
      boolean var10 = var7 == -1;
      boolean var11 = var8 == -1;
      boolean var12 = var8 == 1;
      float var13 = 0.0F;
      if (var11 != var12 && !var9 && !var10) {
         var13 += 0.005F;
      }

      if (var9) {
         var13 += 0.04F;
      }

      if (var10) {
         var13 -= 0.005F;
      }

      float var14 = var6.yaw;
      motion.motionX += (double)(MathHelperTable.sin(-var14 * (float) (Math.PI / 180.0), false) * var13);
      motion.motionZ += (double)(MathHelperTable.cos(var14 * (float) (Math.PI / 180.0), false) * var13);
   }

   @Override
   public String getName() {
      return "BOAT";
   }

   @Override
   public void moveWithHeading(PlayerData data, double motionX, double motionY, double motionZ) {
      Player var8 = data.getPlayer();
      IntaveScheduler.runTask(var8::leaveVehicle);
      data.getStorage().getPhysicsHolder().clearTrackedEntity();
   }

   @Override
   public void moveEntityHandle(PlayerData data, double x, double y, double z, double motionX, double motionY, double motionZ) {
      BukkitEnginePlayer var17 = data.getStorage().getPhysicsHolder();
      Motion var18 = var17.getMotion();
      var18.set(motionX, motionY, motionZ);
      Unknown187 var19 = data.getStorage().e();
      Box var20 = Box.of(data, x, y, z);
      var17.setBoundingBox(var20);
      if (!var19.k) {
         var17.deltaX = var18.motionX;
         var17.deltaY = var18.motionY;
         var17.deltaZ = var18.motionZ;
      }

   }

   @Nullable
   private Unknown242 d(PlayerData data) {
      BukkitEnginePlayer var5 = data.getStorage().getPhysicsHolder();
      Box var6 = var5.getBoundingBox();
      double var7 = var6.maxY + 0.001;
      int var9 = MathUtil.floor(var6.minX);
      int var10 = MathUtil.ceil(var6.maxX);
      int var11 = MathUtil.floor(var6.maxY);
      int var12 = MathUtil.ceil(var7);
      int var13 = MathUtil.floor(var6.minZ);
      int var14 = MathUtil.ceil(var6.maxZ);
      boolean var15 = false;

      for(int var16 = var9; var16 < var10; ++var16) {
         for(int var17 = var11; var17 < var12; ++var17) {
            for(int var18 = var13; var18 < var14; ++var18) {
               Unknown105 var19 = Unknown360.a(data, var16, var17, var18);
               if (var19.c() && var7 < (double)((float)var17 + var19.e())) {
                  if (!var19.d()) {
                     return Unknown242.c;
                  }

                  var15 = true;
               }
            }
         }
      }

      return var15 ? Unknown242.b : null;
   }

   private boolean b(PlayerData data) {
      BukkitEnginePlayer var5 = data.getStorage().getPhysicsHolder();
      Box var6 = var5.getBoundingBox();
      int var7 = MathUtil.floor(var6.minX);
      int var8 = MathUtil.ceil(var6.maxX);
      int var9 = MathUtil.floor(var6.minY);
      int var10 = MathUtil.ceil(var6.minY + 0.001);
      int var11 = MathUtil.floor(var6.minZ);
      int var12 = MathUtil.ceil(var6.maxZ);
      boolean var13 = false;
      var5.an = Double.MIN_VALUE;

      for(int var14 = var7; var14 < var8; ++var14) {
         for(int var15 = var9; var15 < var10; ++var15) {
            for(int var16 = var11; var16 < var12; ++var16) {
               Unknown105 var17 = Unknown360.a(data, var14, var15, var16);
               if (var17.c()) {
                  float var18 = (float)var15 + var17.e();
                  var5.an = Math.max((double)var18, var5.an);
                  var13 |= var6.minY < (double)var18;
               }
            }
         }
      }

      return var13;
   }

   private Unknown242 c(PlayerData data) {
      BukkitEnginePlayer var5 = data.getStorage().getPhysicsHolder();
      Unknown242 var6 = this.d(data);
      if (var6 != null) {
         var5.an = var5.getBoundingBox().maxY;
         return var6;
      } else if (this.b(data)) {
         return Unknown242.a;
      } else {
         float var7 = this.a(data);
         if (var7 > 0.0F) {
            var5.aU = var7;
            return Unknown242.d;
         } else {
            return Unknown242.e;
         }
      }
   }
}
