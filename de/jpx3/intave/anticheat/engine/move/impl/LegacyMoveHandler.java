package de.jpx3.intave.anticheat.engine.move.impl;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MotionContext;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.move.MoveHandler;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.nms.Direction;
import org.bukkit.entity.Player;

public final class LegacyMoveHandler implements MoveHandler {
   @Override
   public MotionContext moveEntity(PlayerData data, Motion motion, double motionX, double motionY, double motionZ, boolean inWeb) {
      Player var13 = data.getPlayer();
      PlayerStorage var14 = data.getStorage();
      BukkitEnginePlayer var15 = var14.getPhysicsHolder();
      if (inWeb) {
         motion.motionX *= 0.25;
         motion.motionY *= 0.05F;
         motion.motionZ *= 0.25;
      }

      if (var15.isContextGround() && var15.isSneaking()) {
         this.collide(data, (double)var15.width, motion);
      }

      double var16 = motion.getX();
      double var18 = motion.getY();
      double var20 = motion.getZ();
      boolean var22 = false;
      Boxable var23 = CollisionUtil.d(var13, var15.getBoundingBox().addCoord(motion.motionX, motion.motionY, motion.motionZ));
      Box var24 = var15.getBoundingBox();
      Box var25 = var15.getBoundingBox();
      if (motion.motionY != 0.0) {
         motion.motionY = var23.calculateOffset(Direction.Y, var25, motion.motionY);
         if (motion.motionY != 0.0) {
            var25 = var25.add(0.0, motion.motionY, 0.0);
         }
      }

      boolean var26 = Math.abs(motion.motionX) < Math.abs(motion.motionZ);
      if (var26 && motion.motionZ != 0.0) {
         motion.motionZ = var23.calculateOffset(Direction.Z, var25, motion.motionZ);
         if (motion.motionZ != 0.0) {
            var25 = var25.add(0.0, 0.0, motion.motionZ);
         }
      }

      if (motion.motionX != 0.0) {
         motion.motionX = var23.calculateOffset(Direction.X, var25, motion.motionX);
         if (motion.motionX != 0.0) {
            var25 = var25.add(motion.motionX, 0.0, 0.0);
         }
      }

      if (!var26 && motion.motionZ != 0.0) {
         motion.motionZ = var23.calculateOffset(Direction.Z, var25, motion.motionZ);
         if (motion.motionZ != 0.0) {
            var25 = var25.add(0.0, 0.0, motion.motionZ);
         }
      }

      boolean var27 = var15.contextGround || var18 != motion.motionY && var18 < 0.0;
      if (var27 && (var16 != motion.motionX || var20 != motion.motionZ)) {
         double var28 = motion.motionX;
         double var30 = motion.motionY;
         double var32 = motion.motionZ;
         Box var34 = var25;
         motion.motionY = (double)var15.width;
         Boxable var35 = CollisionUtil.d(var13, var24.addCoord(var16, motion.motionY, var20));
         Box var37 = var24.addCoord(var16, 0.0, var20);
         double var38 = motion.motionY;
         var38 = var35.calculateOffset(Direction.Y, var37, var38);
         Box var36 = var24.add(0.0, var38, 0.0);
         double var40 = var35.calculateOffset(Direction.Z, var36, var20);
         var36 = var36.add(0.0, 0.0, var40);
         double var42 = var35.calculateOffset(Direction.X, var36, var16);
         var36 = var36.add(var42, 0.0, 0.0);
         double var45 = motion.motionY;
         var45 = var35.calculateOffset(Direction.Y, var24, var45);
         Box var44 = var24.add(0.0, var45, 0.0);
         double var47 = var35.calculateOffset(Direction.X, var44, var16);
         var44 = var44.add(var47, 0.0, 0.0);
         double var49 = var35.calculateOffset(Direction.Z, var44, var20);
         var44 = var44.add(0.0, 0.0, var49);
         double var51 = var42 * var42 + var40 * var40;
         double var53 = var47 * var47 + var49 * var49;
         if (var51 > var53) {
            motion.motionX = var42;
            motion.motionZ = var40;
            motion.motionY = -var38;
            var25 = var36;
         } else {
            motion.motionX = var47;
            motion.motionZ = var49;
            motion.motionY = -var45;
            var25 = var44;
         }

         motion.motionY = var35.calculateOffset(Direction.Y, var25, motion.motionY);
         var25 = var25.add(0.0, motion.motionY, 0.0);
         if (var28 * var28 + var32 * var32 >= motion.motionX * motion.motionX + motion.motionZ * motion.motionZ) {
            motion.motionX = var28;
            motion.motionY = var30;
            motion.motionZ = var32;
            var25 = var34;
         } else {
            var22 = true;
         }
      }

      boolean var56 = var18 != motion.motionY;
      boolean var29 = var16 != motion.motionX || var20 != motion.motionZ;
      boolean var57 = var18 != motion.motionY && var18 < 0.0;
      boolean var31 = var16 != motion.motionX;
      boolean var58 = var20 != motion.motionZ;
      double var33 = (var25.minX + var25.maxX) / 2.0;
      double var59 = var25.minY;
      double var62 = (var25.minZ + var25.maxZ) / 2.0;
      motion.motionX = var33 - motionX;
      motion.motionY = var59 - motionY;
      motion.motionZ = var62 - motionZ;
      return new MotionContext(Motion.copy(motion), var57, var29, var56, var31, var58, var22);
   }

   private void collide(PlayerData data, double offset, Motion motion) {
      Player var8 = data.getPlayer();
      BukkitEnginePlayer var9 = data.getStorage().getPhysicsHolder();
      Box var10 = var9.getBoundingBox();
      double var11 = motion.motionX;
      double var13 = motion.motionZ;

      while(var11 != 0.0 && CollisionUtil.isColliding(var8, var10.add(var11, -offset, 0.0))) {
         if (var11 < 0.05 && var11 >= -0.05) {
            var11 = 0.0;
         } else if (var11 > 0.0) {
            var11 -= 0.05;
         } else {
            var11 += 0.05;
         }
      }

      while(var13 != 0.0 && CollisionUtil.isColliding(var8, var10.add(0.0, -offset, var13))) {
         if (var13 < 0.05 && var13 >= -0.05) {
            var13 = 0.0;
         } else if (var13 > 0.0) {
            var13 -= 0.05;
         } else {
            var13 += 0.05;
         }
      }

      while(var11 != 0.0 && var13 != 0.0 && CollisionUtil.isColliding(var8, var10.add(var11, -offset, var13))) {
         if (var11 < 0.05 && var11 >= -0.05) {
            var11 = 0.0;
         } else if (var11 > 0.0) {
            var11 -= 0.05;
         } else {
            var11 += 0.05;
         }

         if (var13 < 0.05 && var13 >= -0.05) {
            var13 = 0.0;
         } else if (var13 > 0.0) {
            var13 -= 0.05;
         } else {
            var13 += 0.05;
         }
      }

      motion.motionX = var11;
      motion.motionZ = var13;
   }
}
