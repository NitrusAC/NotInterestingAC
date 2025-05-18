package de.jpx3.intave.anticheat.check.physics;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.heading.Headings;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.unknown.Unknown187;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@Relocate
public final class PhysicsLeniencyHandler {
   private static final double MAX_REACH = 3.005;
   private static final double d = 0.11760600328445435;
   private static final double c = 0.05;
   private static final double a = 2.5;

   public double getLenientHeight(PlayerData data, double delta, boolean bool1, boolean bool2) {
      Player var6 = data.getPlayer();
      PlayerStorage var7 = data.getStorage();
      VersionHolder var8 = var7.getVersionHolder();
      BukkitEnginePlayer var9 = var7.getPhysicsHolder();
      double var10 = MathUtil2.a(var9.x, var9.z, var9.serverX, var9.serverZ);
      Pose var12 = var9.getPose();
      double var13 = var9.getMotionX();
      double var15 = var9.getMotionY();
      double var17 = var9.getMotionZ();
      double var19 = Math.abs(var15 - delta);
      boolean var21 = var9.b(2);
      double var22 = var21 ? 0.01 : 1.0E-5;
      if (var21
         && var9.T == 0
         && Math.abs(var9.getMotionX()) < 0.05
         && Math.abs(var9.getMotionZ()) < 0.05
         && var9.getMotionY() < 0.0
         && var9.getMotionY() > -0.4) {
         var22 = 0.15;
      }

      if (var12.getHeight(data) < 1.0F && var15 <= 0.0 && var21) {
         var22 = Math.max(var22, 0.1);
      }

      boolean var24 = var12 == Pose.c || var12 == Pose.ELYTRA;
      if (var24) {
         var22 = Math.max(var22, 0.001);
      }

      if ((var9.at < 10 || var9.isCollideLava()) && var10 < 0.2) {
         var22 = Math.max(var22, 0.02);
      }

      if (var9.iteratedTick < 2) {
         var22 = this.a(var9);
      }

      if (var9.ba < 10) {
         var22 = Math.max(var22, 1.0);
      } else if (var9.ba < 30) {
         var22 = Math.max(var22, 0.5);
      }

      if (var9.b5 > 0 && Math.abs(var15) < 0.09) {
         var22 = Math.max(var22, 0.2);
      }

      if (var8.iss1_14()) {
         double var25 = (double)(1.0F - data.getHitboxSize(Pose.SNEAKING).getHeight() % 1.0F);
         double var27 = (double)(1.0F - data.getHitboxSize(Pose.a).getHeight() % 1.0F);
         boolean var29 = false;
         if (Math.abs(var15 - var25) < 0.01 || Math.abs(var15 - var27) < 0.01) {
            var29 = true;
         } else if (Math.abs(var15 - var9.getJumpBoostHeight()) < 0.01 && Math.abs(var15 - var25) < 0.1) {
            var29 = true;
         } else if (Math.abs(Math.abs(var15 - var25) - var9.getJumpBoostHeight()) < 0.01) {
            var29 = true;
         }

         boolean var30 = CollisionUtil.a(var6, Box.of(data, var9.x, var9.y, var9.z).addCoord(var9.getMotionX(), var15 + 0.1, var9.getMotionZ()));
         if (var29 && var30) {
            var19 = 0.0;
         }
      }

      if (var9.b(3) && var19 > 0.001) {
         boolean var34 = var9.groundTicks <= 10 || var9.isCollideLava();
         int var26 = AccurateMathUtil.deltaXZ(var9.getMotionX(), var9.getMotionZ()) < 0.03 ? 3 : 1;
         if (var34 || var9.aJ++ <= var26) {
            var22 = Math.max(var22, var34 ? 0.1 : 0.03);
         }
      }

      if (var9.bm) {
         double var35 = var9.velocity.getY();
         var22 = Math.max(var22, var35 * 1.2 - var19);
      }

      if (bool2 && !var9.isTrackingAttacked() && var9.getMotionY() < 0.605) {
         if (var9.bd) {
            if (var9.getMotionY() < 0.1) {
               var22 = Math.max(var22, 10.0);
            }

            var9.bd = false;
         } else if (var9.deltaY < 0.0) {
            var22 = Math.max(var22, 10.0);
            if (var9.getMotionY() > var9.getJumpBoostHeight()) {
               var9.bd = true;
            }
         }
      }

      boolean var36 = var15 > -0.01 && var9.bg < 10 && !var9.inWater && !var9.isCollideLava() && var9.y % 1.0 > 0.1 && var9.l != 0;
      if (var9.inWeb) {
         var22 = Math.max(var22, var36 ? 1.0E-6 : 0.13);
      }

      if (var9.bg < 10 && !var9.inWeb && var19 < 0.1) {
         var22 = Math.max(var22, 0.1);
      }

      if (var9.b(1) && var9.l <= 4) {
         var22 = Math.max(var22, 0.03);
      }

      var22 = Math.max(var22, var9.P());
      if (var9.groundTicks <= 3) {
         double var37;
         if (var8.isNewCollision()) {
            var37 = var15 + 0.6F - var9.y + var9.serverY;
         } else {
            var37 = var15 + 0.3F;
         }

         boolean var28 = de.jpx3.intave.anticheat.util.CollisionUtil.getCollidingBoxes(var6, var9.getBoundingBox(), var13, var37, var17);
         boolean var40 = CollisionUtil.a(var6.getWorld(), var9.getBoundingBox().grow(0.2));
         if (var40 && var28 && var15 < 0.4) {
            var22 = Math.max(var22, 0.7F);
         }
      }

      double var38 = Math.max(0.0, var19 - var22);
      boolean var39 = var24 || var9.isCollideLava() || var9.isTrackingAttacked();
      double var41;
      if (var38 > 0.1 && !var39) {
         var41 = 5000.0;
      } else if (var38 > 0.009 && !var39) {
         var38 = Math.max(var38, 0.1);
         var41 = 500.0;
      } else {
         var41 = 100.0;
      }

      if (var12 == Pose.ELYTRA) {
         if (!var9.inWater && var9.groundTicks <= 2 && Math.abs(var15) < 0.1) {
            var41 *= 0.01;
         } else if (var9.getMotionY() >= 0.0 && var9.contextGround) {
            var41 *= 0.1;
         } else {
            var41 *= 0.25;
         }
      } else if (var9.bC < 4 && var9.getMotionY() < var9.getJumpBoostHeight()) {
         var41 *= 0.1;
      }

      if (var36) {
         var41 *= 40.0;
      }

      if (bool1 && var9.getMotionY() <= 0.11760600328445435) {
         var38 = 0.0;
      }

      if (var9.bU <= 10 && var9.getMotionY() < -0.097 && var9.getMotionY() > -0.099) {
         double var31 = AccurateMathUtil.deltaXZ(var13, var17);
         if (var31 < 0.2) {
            var38 = 0.0;
         }
      }

      return var38 * var41;
   }

   public double getLenientDistance(PlayerData data, double deltaX, double deltaZ, boolean var6, boolean var7) {
      Player var8 = data.getPlayer();
      PlayerStorage var9 = data.getStorage();
      Unknown187 var10 = var9.e();
      BukkitEnginePlayer var11 = var9.getPhysicsHolder();
      double var12 = var11.getMotionX();
      double var14 = var11.getMotionZ();
      double var16 = MathUtil2.a(var11.x, var11.z, var11.serverX, var11.serverZ);
      double var18 = AccurateMathUtil.deltaXZ(deltaX, deltaZ);
      if (var11.getHeadingHandler() == Headings.HORSE && var16 < var18) {
         return 0.0;
      } else {
         double var20 = MathUtil2.a(deltaX, deltaZ, var12, var14);
         boolean var22 = var11.at <= 20;
         double var23;
         if (var11.slowdownTicks <= 1) {
            var23 = 0.01;
         } else {
            var23 = 7.0E-4;
            if (var20 > 7.0E-4) {
               boolean var25 = CollisionUtil.a(var8.getWorld(), var11.getBoundingBox().growHorizontal(0.001));
               if (var25) {
                  var23 = var16 < 0.04 ? 0.04 : 0.002;
               }
            }
         }

         if (var11.A > 0 || var11.bS > 0) {
            var23 = Math.max(var23, 0.3);
         }

         if (var11.b5 > 0) {
            var23 = Math.max(var23, 0.1);
         }

         if (var11.collidedHorizontally && var11.velocityTicks < 20) {
            var23 = Math.max(var23, 0.027);
         }

         if (var22) {
            var23 = Math.max(var23, 0.018);
         }

         if (var11.m && var18 < var16 * 1.3) {
            var23 = Math.max(var23, var18);
         }

         if (var11.ba < 30) {
            var23 = Math.max(var23, 3.0);
         }

         if (var11.b(2)) {
            if (var11.contextGround) {
               boolean var38 = var16 <= var18 + 0.02;
               var23 = Math.max(var23, var38 ? 0.115 : 0.005);
            } else {
               var23 = Math.max(var23, 0.05);
            }

            if (var11.T == 0) {
               var23 = Math.max(var23, 0.05);
            }
         }

         if (var11.iteratedTick < 2) {
            var23 = Math.max(var23, this.a(var11));
         }

         var23 = Math.max(var23, var11.P());
         boolean var39 = var11.b(2);
         double var26 = var11.L();
         boolean var28 = var11.groundTicks < 20 && var11.at > 5 || var11.isCollideLava();
         if (var39) {
            boolean var29 = var16 <= var18;
            double var30 = var28 ? 0.3 : (!var11.sprinting ? 0.5 : 0.7);
            boolean var32 = var11.ab > 9 || !var11.isContextGround();
            if (var32 && (var29 || var16 < var26 * var30)) {
               var23 = Math.max(var23, var26 * 0.7);
            }
         }

         if (var6 && (var16 < var18 || var16 < (var11.getMotionY() < 0.0 ? 0.4 : 0.2))) {
            var23 = Math.max(var16, 0.2);
         }

         if (var7) {
            var23 = Math.max(var23, 0.4);
         }

         if (var11.bm) {
            Vector var40 = var11.velocity;
            double var42 = AccurateMathUtil.deltaXZ(var40.getX(), var40.getZ());
            var20 -= var42;
            var23 = Math.max(var23, var42 * 1.2 - var16);
         }

         if ((var11.isSneaking || var11.X) && (Math.abs(var11.getMotionX()) < 0.05 || Math.abs(var11.getMotionZ()) < 0.05)) {
            var23 = Math.max(var23, 0.1);
         }

         if (var11.bW) {
            var23 = Math.max(var23, 0.05);
         }

         double var41 = Math.max(0.0, var20 - var23);
         boolean var31 = var16 > var18 * 1.0005 && var41 > 0.0;
         if (var28) {
            var31 = var31 && var16 > var26;
         }

         Pose var43 = var11.getPose();
         boolean var33 = var11.bC <= 3;
         if (var43 == Pose.ELYTRA) {
            if (!var11.inWater && var11.groundTicks <= 2 && var20 < 0.3) {
               var41 *= 0.2;
            } else if (var11.getMotionY() >= 0.0 && var11.contextGround) {
               var41 *= 0.3;
            } else {
               var41 *= 0.6;
            }
         } else if (var33) {
            var41 *= 0.1;
         }

         boolean var34 = (var16 > 0.3 || var10.h >= 8.0) && !var33;
         if (var31 && var34 && !var11.bm) {
            return var41 > 0.2 ? 1000.0 : Math.max(30.0, var41 * 300.0);
         } else {
            double var35 = var41 > 0.1 ? 20.0 : 10.0;
            return var41 * var35;
         }
      }
   }

   private double a(BukkitEnginePlayer engine) {
      double var2;
      if (engine.contextGround) {
         var2 = engine.iteratedTick == 0 ? 3.005 : 2.5;
      } else {
         var2 = engine.iteratedTick == 0 ? 3.005 : 0.05;
      }

      return var2;
   }
}
