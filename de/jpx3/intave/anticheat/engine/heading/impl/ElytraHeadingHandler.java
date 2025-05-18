package de.jpx3.intave.anticheat.engine.heading.impl;

import de.jpx3.intave.anticheat.check.physics.PhysicsResult;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.EnginePlayer;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MotionContext;
import de.jpx3.intave.anticheat.engine.MovementConfiguration;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.move.MoveHandlerFactory;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.unknown.Unknown101;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public final class ElytraHeadingHandler extends VanillaHeadingHandler {
   private static final String f;

   @Override
   public String getName() {
      return "ELYTRA";
   }

   @Override
   public boolean e() {
      return false;
   }

   @Override
   public PhysicsResult moveWithHeaving(PlayerData data, Motion motion, EnginePlayer enginePlayer, MovementConfiguration moveConfig) {
      float var9 = enginePlayer.getPitch();
      Vector var10 = enginePlayer.getLookVector();
      double var11 = enginePlayer.getServerX();
      double var13 = enginePlayer.getServerY();
      double var15 = enginePlayer.getServerZ();
      float var17 = var9 * (float) (Math.PI / 180.0);
      double var18 = Math.sqrt(var10.getX() * var10.getX() + var10.getZ() * var10.getZ());
      double var20 = Math.sqrt(motion.motionX * motion.motionX + motion.motionZ * motion.motionZ);
      double var22 = Math.sqrt(var10.lengthSquared());
      float var24 = MathUtil.cos(var17);
      var24 = (float)((double)var24 * (double)var24 * Math.min(1.0, var22 / 0.4));
      motion.motionY += enginePlayer.y() * (-1.0 + (double)var24 * 0.75);
      if (motion.motionY < 0.0 && var18 > 0.0) {
         double var25 = motion.motionY * -0.1 * (double)var24;
         motion.motionY += var25;
         motion.motionX += var10.getX() * var25 / var18;
         motion.motionZ += var10.getZ() * var25 / var18;
      }

      if (var17 < 0.0F && var18 > 0.0) {
         double var28 = var20 * (double)(-MathUtil.sin(var17)) * 0.04;
         motion.motionY += var28 * 3.2;
         motion.motionX += -var10.getX() * var28 / var18;
         motion.motionZ += -var10.getZ() * var28 / var18;
      }

      if (var18 > 0.0) {
         motion.motionX += (var10.getX() / var18 * var20 - motion.motionX) * 0.1;
         motion.motionZ += (var10.getZ() / var18 * var20 - motion.motionZ) * 0.1;
      }

      motion.motionX *= 0.99F;
      motion.motionY *= 0.98F;
      motion.motionZ *= 0.99F;
      this.b(data, motion, enginePlayer);
      MotionContext var29 = MoveHandlerFactory.computeContext(data, motion, enginePlayer.isInWeb(), var11, var13, var15);
      this.a(data, var29);
      return PhysicsResult.of(data, moveConfig, var29);
   }

   private void b(PlayerData data, Motion motion, EnginePlayer enginePlayer) {
      Player var7 = data.getPlayer();
      BukkitEnginePlayer var8 = data.getStorage().getPhysicsHolder();
      float var9 = enginePlayer.getPitch();
      Vector var10 = enginePlayer.getLookVector();
      double var11 = enginePlayer.getServerX();
      double var13 = enginePlayer.getServerY();
      double var15 = enginePlayer.getServerZ();
      double var18 = enginePlayer.getMinimumMotion();
      double var20 = enginePlayer.getJumpBoostHeight();
      int var22 = 0;
      double var23 = motion.motionX;
      double var25 = motion.motionY;

      for(double var27 = motion.motionZ; var22 <= 2; ++var22) {
         Unknown101 var29 = MoveHandlerFactory.a(var7, var11, var13, var15, var23, var25, var27);
         var11 += var29.b();
         var13 += var29.g();
         var15 += var29.f();
         double var30 = var11 - enginePlayer.getServerX();
         double var32 = var13 - enginePlayer.getServerY();
         double var34 = var15 - enginePlayer.getServerZ();
         boolean var17 = var29.c();
         boolean var36 = var29.f() < var20;
         boolean var37 = var17 && Math.abs(var29.f() + var20 - enginePlayer.getMotionY()) < 1.0E-5 && var36;
         if (!this.is003(var30, var32, var34) && !var37) {
            break;
         }

         float var38 = var9 * (float) (Math.PI / 180.0);
         double var39 = Math.sqrt(var10.getX() * var10.getX() + var10.getZ() * var10.getZ());
         double var41 = Math.sqrt(motion.motionX * motion.motionX + motion.motionZ * motion.motionZ);
         double var43 = Math.sqrt(var10.lengthSquared());
         float var45 = MathUtil.cos(var38);
         var45 = (float)((double)var45 * (double)var45 * Math.min(1.0, var43 / 0.4));
         motion.motionY += enginePlayer.y() * (-1.0 + (double)var45 * 0.75);
         if (motion.motionY < 0.0 && var39 > 0.0) {
            double var46 = motion.motionY * -0.1 * (double)var45;
            motion.motionY += var46;
            motion.motionX += var10.getX() * var46 / var39;
            motion.motionZ += var10.getZ() * var46 / var39;
         }

         if (var38 < 0.0F && var39 > 0.0) {
            double var49 = var41 * (double)(-MathUtil.sin(var38)) * 0.04;
            motion.motionY += var49 * 3.2;
            motion.motionX += -var10.getX() * var49 / var39;
            motion.motionZ += -var10.getZ() * var49 / var39;
         }

         if (var39 > 0.0) {
            motion.motionX += (var10.getX() / var39 * var41 - motion.motionX) * 0.1;
            motion.motionZ += (var10.getZ() / var39 * var41 - motion.motionZ) * 0.1;
         }

         motion.motionX *= 0.99F;
         motion.motionY *= 0.98F;
         motion.motionZ *= 0.99F;
         if (Math.abs(var23) < var18) {
            var23 = 0.0;
         }

         if (Math.abs(var25) < var18) {
            var25 = 0.0;
         }

         if (Math.abs(var27) < var18) {
            var27 = 0.0;
         }
      }

      if (var22 != 0) {
         var8.o();
      }

   }
}
