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

public final class ModernMoveHandler implements MoveHandler {
   @Override
   public MotionContext moveEntity(PlayerData data, Motion motion, double motionX, double motionY, double motionZ, boolean inWeb) {
      Player var14 = data.getPlayer();
      PlayerStorage var15 = data.getStorage();
      BukkitEnginePlayer var16 = var15.getPhysicsHolder();
      if (inWeb) {
         motion.motionX *= 0.25;
         motion.motionY *= 0.05F;
         motion.motionZ *= 0.25;
      }

      double var17 = motion.motionX;
      double var19 = motion.motionY;
      double var21 = motion.motionZ;
      boolean var23 = false;
      if (var16.isContextGround() && var16.isSneaking()) {
         Box var24 = var16.getBoundingBox();

         double var25;
         for(var25 = 0.05; motion.motionX != 0.0 && CollisionUtil.isColliding(var14, var24.add(motion.motionX, -1.0, 0.0)); var17 = motion.motionX) {
            if (motion.motionX < var25 && motion.motionX >= -var25) {
               motion.motionX = 0.0;
            } else if (motion.motionX > 0.0) {
               motion.motionX -= var25;
            } else {
               motion.motionX += var25;
            }
         }

         for(; motion.motionZ != 0.0 && CollisionUtil.isColliding(var14, var24.add(0.0, -1.0, motion.motionZ)); var21 = motion.motionZ) {
            if (motion.motionZ < var25 && motion.motionZ >= -var25) {
               motion.motionZ = 0.0;
            } else if (motion.motionZ > 0.0) {
               motion.motionZ -= var25;
            } else {
               motion.motionZ += var25;
            }
         }

         for(;
            motion.motionX != 0.0 && motion.motionZ != 0.0 && CollisionUtil.isColliding(var14, var24.add(motion.motionX, -1.0, motion.motionZ));
            var21 = motion.motionZ
         ) {
            if (motion.motionX < var25 && motion.motionX >= -var25) {
               motion.motionX = 0.0;
            } else if (motion.motionX > 0.0) {
               motion.motionX -= var25;
            } else {
               motion.motionX += var25;
            }

            var17 = motion.motionX;
            if (motion.motionZ < var25 && motion.motionZ >= -var25) {
               motion.motionZ = 0.0;
            } else if (motion.motionZ > 0.0) {
               motion.motionZ -= var25;
            } else {
               motion.motionZ += var25;
            }
         }
      }

      Boxable var55 = CollisionUtil.d(var14, var16.getBoundingBox().addCoord(motion.motionX, motion.motionY, motion.motionZ));
      Box var56 = var16.getBoundingBox();
      Box var26 = var16.getBoundingBox();
      motion.motionY = var55.calculateOffset(Direction.Y, var26, motion.motionY);
      var26 = var26.add(0.0, motion.motionY, 0.0);
      boolean var27 = var16.contextGround || var19 != motion.motionY && var19 < 0.0;
      motion.motionX = var55.calculateOffset(Direction.X, var26, motion.motionX);
      var26 = var26.add(motion.motionX, 0.0, 0.0);
      motion.motionZ = var55.calculateOffset(Direction.Z, var26, motion.motionZ);
      var26 = var26.add(0.0, 0.0, motion.motionZ);
      if (var27 && (var17 != motion.motionX || var21 != motion.motionZ)) {
         double var28 = motion.motionX;
         double var30 = motion.motionY;
         double var32 = motion.motionZ;
         Box var34 = var26;
         motion.motionY = (double)var16.width;
         Boxable var35 = CollisionUtil.d(var14, var56.addCoord(var17, motion.motionY, var21));
         Box var37 = var56.addCoord(var17, 0.0, var21);
         double var38 = motion.motionY;
         var38 = var35.calculateOffset(Direction.Y, var37, var38);
         Box var36 = var56.add(0.0, var38, 0.0);
         double var40 = var35.calculateOffset(Direction.X, var36, var17);
         var36 = var36.add(var40, 0.0, 0.0);
         double var42 = var35.calculateOffset(Direction.Z, var36, var21);
         var36 = var36.add(0.0, 0.0, var42);
         double var45 = motion.motionY;
         var45 = var35.calculateOffset(Direction.Y, var56, var45);
         Box var44 = var56.add(0.0, var45, 0.0);
         double var47 = var35.calculateOffset(Direction.X, var44, var17);
         var44 = var44.add(var47, 0.0, 0.0);
         double var49 = var35.calculateOffset(Direction.Z, var44, var21);
         var44 = var44.add(0.0, 0.0, var49);
         double var51 = var40 * var40 + var42 * var42;
         double var53 = var47 * var47 + var49 * var49;
         if (var51 > var53) {
            motion.motionX = var40;
            motion.motionZ = var42;
            motion.motionY = -var38;
            var26 = var36;
         } else {
            motion.motionX = var47;
            motion.motionZ = var49;
            motion.motionY = -var45;
            var26 = var44;
         }

         motion.motionY = var35.calculateOffset(Direction.Y, var26, motion.motionY);
         var26 = var26.add(0.0, motion.motionY, 0.0);
         if (var28 * var28 + var32 * var32 >= motion.motionX * motion.motionX + motion.motionZ * motion.motionZ) {
            motion.motionX = var28;
            motion.motionY = var30;
            motion.motionZ = var32;
            var26 = var34;
         } else {
            var23 = true;
         }
      }

      boolean var61 = var19 != motion.motionY;
      boolean var29 = var17 != motion.motionX || var21 != motion.motionZ;
      boolean var62 = var19 != motion.motionY && var19 < 0.0;
      boolean var31 = var17 != motion.motionX;
      boolean var63 = var21 != motion.motionZ;
      double var33 = (var26.minX + var26.maxX) / 2.0;
      double var64 = var26.minY;
      double var67 = (var26.minZ + var26.maxZ) / 2.0;
      motion.motionX = var33 - motionX;
      motion.motionY = var64 - motionY;
      motion.motionZ = var67 - motionZ;
      return new MotionContext(Motion.copy(motion), var62, var29, var61, var31, var63, var23);
   }
}
