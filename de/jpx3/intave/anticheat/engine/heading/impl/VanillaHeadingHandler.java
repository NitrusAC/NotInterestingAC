package de.jpx3.intave.anticheat.engine.heading.impl;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.check.physics.PhysicsResult;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.EnginePlayer;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MotionContext;
import de.jpx3.intave.anticheat.engine.MovementConfiguration;
import de.jpx3.intave.anticheat.engine.block.collidable.CollidableManager;
import de.jpx3.intave.anticheat.engine.heading.HeadingHandler;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.move.MoveHandlerFactory;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.BlockTypeUtil;
import de.jpx3.intave.anticheat.util.CollisionUtil;
import de.jpx3.intave.anticheat.util.EnchantUtil;
import de.jpx3.intave.anticheat.util.MaterialUtil;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.PotionEffectUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.unknown.Unknown101;
import de.jpx3.intave.unknown.Unknown143;
import de.jpx3.intave.unknown.Unknown187;
import de.jpx3.intave.unknown.Unknown360;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@Relocate
public class VanillaHeadingHandler extends HeadingHandler {
   private static final double MINIMUM_DISTANCE = 9.0E-4;

   private void b(PlayerData data, Motion motion, Box boundingBox) {
      List var4 = data.getStorage().c().e();
      BukkitEnginePlayer var5 = data.getStorage().getPhysicsHolder();
      var5.bW = false;

      for(TrackedEntity var7 : var4) {
         if (var7.u() && var7.y && var7.getBoundingBox().isInside(boundingBox)) {
            this.collideTracked(data, motion, var7);
         }
      }

   }

   @Override
   public PhysicsResult moveWithHeaving(PlayerData data, Motion motion, EnginePlayer enginePlayer, MovementConfiguration moveConfig) {
      float var5 = (float)moveConfig.getForward();
      float var6 = (float)moveConfig.getStrafe();
      boolean var7 = moveConfig.isHandActive();
      boolean var8 = moveConfig.isAttackReduce();
      boolean var9 = moveConfig.isJump();
      boolean var10 = moveConfig.isSprint();
      PlayerStorage var11 = data.getStorage();
      BukkitEnginePlayer var12 = var11.getPhysicsHolder();
      VersionHolder var13 = var11.getVersionHolder();
      Pose var14 = enginePlayer.getPose();
      float var15 = enginePlayer.G();
      float var16 = enginePlayer.getRotationZ();
      double var17 = enginePlayer.getServerX();
      double var19 = enginePlayer.getServerY();
      double var21 = enginePlayer.getServerZ();
      boolean var23 = enginePlayer.isCollideWater();
      boolean var24 = enginePlayer.isCollideLava();
      boolean var25 = var14 == Pose.ELYTRA;
      boolean var26 = var14 == Pose.c;
      boolean var27 = var13.isNewCollision();
      var5 = (float)((int)var5) * 0.98F;
      var6 = (float)((int)var6) * 0.98F;
      if (var14 == Pose.SNEAKING || !var13.is1_15() && enginePlayer.isSneaking()) {
         var5 = (float)((double)var5 * 0.3);
         var6 = (float)((double)var6 * 0.3);
      }

      if (var7) {
         var5 *= 0.2F;
         var6 *= 0.2F;
      }

      if (var8) {
         motion.motionX *= 0.6;
         motion.motionZ *= 0.6;
      }

      if (var9) {
         boolean var28 = false;
         if (var13.isNewCollision() && var23) {
            IntaveVector var29 = enginePlayer.getIntaveVector();
            Material var30 = WorldUtil.getMaterialAt(data, data.getPlayer().getWorld(), var29);
            int var31 = WorldUtil.a(data, var29);
            float var32 = Unknown143.a(var31);
            if (enginePlayer.isContextGround()) {
               var32 = (float)((double)var32 + enginePlayer.getY() % 1.0);
               var28 = !MaterialUtil.isWater(var30) || (double)var32 > 0.5;
            }
         }

         if (var23 && !var28) {
            motion.motionY += 0.04F;
         } else if (var24) {
            motion.motionY += 0.04F;
         } else {
            motion.motionY = enginePlayer.getJumpBoostHeight();
            if (var10) {
               motion.motionX -= (double)(var15 * 0.2F);
               motion.motionZ += (double)(var16 * 0.2F);
            }
         }
      }

      if (var27 && var26) {
         double var35 = enginePlayer.getLookVector().getY();
         double var38 = var35 < -0.2 ? 0.085 : 0.06;
         boolean var40 = Unknown360.b(data, var17, var19 + 1.0 - 0.1, var21);
         if (var35 <= 0.0 || var9 || !var40) {
            motion.motionY += (var35 - motion.motionY) * var38;
         }
      }

      if (var23) {
         this.a(data, motion, enginePlayer, var10, var5, var6, var15, var16);
      } else if (var24) {
         this.a(data, motion, var5, var6, var15, var16);
      } else {
         this.a(data, motion, enginePlayer, var5, var6, var15, var16);
      }

      if (!var23 && !var25 && !var24) {
         this.a(data, motion, enginePlayer);
      }

      Vector var36 = enginePlayer.getMoveVector();
      if (var36 != null) {
         motion.motionX *= var36.getX();
         motion.motionY *= var36.getY();
         motion.motionZ *= var36.getZ();
         var12.deltaX = 0.0;
         var12.deltaY = 0.0;
         var12.deltaZ = 0.0;
      }

      MotionContext var37 = MoveHandlerFactory.computeContext(data, motion, enginePlayer.isInWeb(), var17, var19, var21);
      this.a(data, var37);
      return PhysicsResult.of(data, moveConfig, var37);
   }

   @Override
   public void moveEntityHandle(PlayerData data, double x, double y, double z, double motionX, double motionY, double motionZ) {
      Player var14 = data.getPlayer();
      World var15 = var14.getWorld();
      PlayerStorage var16 = data.getStorage();
      Unknown187 var17 = var16.e();
      BukkitEnginePlayer var18 = var16.getPhysicsHolder();
      VersionHolder var19 = var16.getVersionHolder();
      Motion var20 = var18.motion;
      var20.set(motionX, motionY, motionZ);
      Pose var21 = var18.getPose();
      boolean var22 = var21 == Pose.ELYTRA;
      boolean var23 = var18.isCollideWater();
      boolean var24 = var18.isCollideLava();
      boolean var25 = var18.collidedHorizontally;
      double var26 = var18.y();
      double var28;
      if (var18.isOnGround()) {
         double var30 = (double)MathUtil.floor(var18.serverX);
         double var32 = (double)MathUtil.floor(var18.serverY - var18.getFrictionBlockRemove());
         double var34 = (double)MathUtil.floor(var18.serverZ);
         var28 = (double)CollisionUtil.getFriction(data, var15, var30, var32, var34);
      } else {
         var28 = 0.91F;
      }

      Box var36 = Box.of(data, x, y, z);
      var18.setBoundingBox(var36);
      if (var18.inWeb) {
         var20.motionX = 0.0;
         var20.motionY = 0.0;
         var20.motionZ = 0.0;
         var18.inWeb = false;
      }

      if (var18.collidedX) {
         var20.motionX = 0.0;
      }

      if (var18.collidedZ) {
         var20.motionZ = 0.0;
      }

      var18.M();
      this.a(data, var20, var36);
      this.a(data, motionY, var18.contextGround);
      if (var23) {
         this.moveWater(data, var20, var36, var25, var26);
      } else if (var24) {
         this.moveLava(var14, data, var20, var36, var25);
      } else if (!var22) {
         this.a(data, var20, var26, var28);
      }

      if (var19.isNewerVersion() && MinecraftVersion.V_1_9.atOrAbove()) {
         this.b(data, var20, var36);
      }

      if (!var17.k) {
         if (var17.i) {
            var17.i = false;
         } else {
            var18.deltaX = var20.motionX;
            var18.deltaY = var20.motionY;
            var18.deltaZ = var20.motionZ;
         }
      }

      var18.n();
      ++var18.slowdownTicks;
      ++var18.at;
      if (var18.contextGround) {
         var18.aJ = 0;
      }

   }

   private void a(PlayerData var1, double var2, boolean var4) {
      BukkitEnginePlayer var5 = var1.getStorage().getPhysicsHolder();
      if (!var5.inWater) {
         this.getPhysicsCheck().a(var1);
      }

      if (var4) {
         this.getPhysicsCheck().computeFall(var1);
         var5.fallDistance = 0.0F;
      } else if (var2 < 0.0) {
         var5.fallDistance = (float)((double)var5.fallDistance + -var2);
      }

   }

   private void moveFlying(Motion motion, float friction, float rotationZ, float rotationX, float forward, float strafe) {
      float var7 = strafe * strafe + forward * forward;
      if (var7 >= 1.0E-4F) {
         var7 = (float)Math.sqrt((double)var7);
         var7 = friction / Math.max(1.0F, var7);
         strafe *= var7;
         forward *= var7;
         motion.motionX += (double)(strafe * rotationX - forward * rotationZ);
         motion.motionZ += (double)(forward * rotationX + strafe * rotationZ);
      }

   }

   boolean is003(double motionX, double motionY, double motionZ) {
      double var7 = motionX * motionX + motionY * motionY + motionZ * motionZ;
      return var7 <= 9.0E-4;
   }

   private void a(PlayerData data, Motion motion, Box boundingBox) {
      Player var6 = data.getPlayer();
      World var7 = var6.getWorld();
      PlayerStorage var8 = data.getStorage();
      BukkitEnginePlayer var9 = var8.getPhysicsHolder();
      VersionHolder var10 = var8.getVersionHolder();
      double var11 = var9.x;
      double var13 = var9.y;
      double var15 = var9.z;
      int var17 = MathUtil.floor(var11);
      int var18 = MathUtil.floor(var13 - 0.2F);
      int var19 = MathUtil.floor(var15);
      Material var20 = WorldUtil.getMaterialAt(data, var7, var17, var18, var19);
      if (var20 == Material.AIR) {
         Material var21 = WorldUtil.getMaterialAt(data, var7, var17, var18, var19);
         if (var21.name().contains("FENCE") || var21.name().contains("WALL")) {
            var20 = var21;
         }
      }

      CollidableManager.a(data, var20);
      if (var9.collidedVertically) {
         Motion var34 = CollidableManager.b(data, var20, motion.motionX, var9.deltaY, motion.motionZ);
         if (var34 != null) {
            motion.set(var34);
         } else {
            motion.motionY = 0.0;
         }
      }

      if (var9.contextGround && !var9.isSneaking) {
         Motion var35 = CollidableManager.a(data, var20, motion.motionX, motion.motionY, motion.motionZ);
         if (var35 != null) {
            motion.set(var35);
         }
      }

      var9.ap = false;
      int var36 = MathUtil.floor(boundingBox.minX + 0.001);
      int var22 = MathUtil.floor(boundingBox.minY + 0.001);
      int var23 = MathUtil.floor(boundingBox.minZ + 0.001);
      int var24 = MathUtil.floor(boundingBox.maxX - 0.001);
      int var25 = MathUtil.floor(boundingBox.maxY - 0.001);
      int var26 = MathUtil.floor(boundingBox.maxZ - 0.001);
      Location var27 = new Location(var7, var11, var13, var15);

      for(int var28 = var36; var28 <= var24; ++var28) {
         for(int var29 = var22; var29 <= var25; ++var29) {
            for(int var30 = var23; var30 <= var26; ++var30) {
               Location var31 = new Location(var7, (double)var28, (double)var29, (double)var30);
               Material var32 = WorldUtil.getMaterialAt(data, var7, var28, var29, var30);
               Motion var33 = CollidableManager.a(data, var32, var31, var27, motion.motionX, motion.motionY, motion.motionZ);
               if (var33 != null) {
                  motion.set(var33);
               }
            }
         }
      }

      if (var10.getVersionId() >= VersionHolder.V_1_14 && var9.getPose() != Pose.ELYTRA) {
         int var37 = EnchantUtil.getBootSoulSpeed(var6);
         if (var37 == 0 || !var9.i()) {
            Material var38 = WorldUtil.getMaterialAt(data, var7, var11, var13 - 0.5000001, var15);
            float var39 = BlockTypeUtil.getOrDefault(var38).f();
            motion.motionX *= (double)var39;
            motion.motionZ *= (double)var39;
         }
      }

   }

   private void a(PlayerData data, Motion motion, EnginePlayer engine, float moveForward, float moveStrafe, float rotationX, float rotationZ) {
      this.moveFlying(motion, engine.getAcceleration(), rotationX, rotationZ, moveForward, moveStrafe);
      if (CollisionUtil.b(data, engine.getServerX(), engine.getServerY(), engine.getServerZ())) {
         float var8 = 0.15F;
         motion.motionX = MathUtil.clamp(motion.motionX, (double)(-var8), (double)var8);
         motion.motionZ = MathUtil.clamp(motion.motionZ, (double)(-var8), (double)var8);
         if (motion.motionY < -0.15) {
            motion.motionY = -0.15;
         }

         if (engine.isSneaking() && motion.motionY < 0.0) {
            motion.motionY = 0.0;
         }
      }

   }

   private void a(PlayerData data, Motion motion, EnginePlayer engine) {
      Player var4 = data.getPlayer();
      BukkitEnginePlayer var5 = data.getStorage().getPhysicsHolder();
      double var6 = engine.getServerX();
      double var8 = engine.getServerY();
      double var10 = engine.getServerZ();
      double var13 = engine.isOnGround() ? (double)CollisionUtil.getFriction(data, var4.getWorld(), var6, var8, var10) : 0.91F;
      double var15 = engine.getMinimumMotion();
      double var17 = engine.getJumpBoostHeight();
      int var19 = 0;
      double var20 = motion.motionX;
      double var22 = motion.motionY;

      for(double var24 = motion.motionZ; var19 <= 2; ++var19) {
         Unknown101 var26 = MoveHandlerFactory.a(var4, var6, var8, var10, var20, var22, var24);
         var6 += var26.b();
         var8 += var26.g();
         var10 += var26.f();
         double var27 = var6 - engine.getServerX();
         double var29 = var8 - engine.getServerY();
         double var31 = var10 - engine.getServerZ();
         boolean var12 = var26.c();
         boolean var33 = var26.f() < var17;
         boolean var34 = var12 && Math.abs(var26.f() + var17 - engine.getMotionY()) < 1.0E-5 && var33;
         if (!this.is003(var27, var29, var31) && !var34) {
            break;
         }

         if (var34 && this.is003(var27 * 0.05, 0.0, var31 * 0.05) && !var5.F()) {
            motion.motionY = var17;
            var5.fallDistance = 0.0F;
            var5.aJ = 0;
            break;
         }

         if (engine.getMotionY() < 0.0) {
            double var35 = var20 * var13;
            double var37 = (var22 - 0.08) * 0.98F;
            double var39 = var24 * var13;
            if (Math.abs(var20) < var15) {
               var20 = 0.0;
            }

            if (Math.abs(var22) < var15) {
               var22 = 0.0;
            }

            if (Math.abs(var24) < var15) {
               var24 = 0.0;
            }

            this.a(var4, motion, var6, var8, var10, var35, var37, var39);
         }

         var20 *= var13;
         var22 -= engine.y();
         var22 *= 0.98F;
         var24 *= var13;
         if (Math.abs(var20) < var15) {
            var20 = 0.0;
         }

         if (Math.abs(var22) < var15) {
            var22 = 0.0;
         }

         if (Math.abs(var24) < var15) {
            var24 = 0.0;
         }
      }

      if (var19 != 0) {
         var5.o();
      }

   }

   private void a(PlayerData data, Motion motion, EnginePlayer engine, boolean sprinting, float var5, float var6, float var7, float var8) {
      Player var9 = data.getPlayer();
      float var10 = 0.02F;
      float var11 = EnchantUtil.getBootDepthStrider(var9);
      if (var11 > 3.0F) {
         var11 = 3.0F;
      }

      if (!engine.isOnGround()) {
         var11 *= 0.5F;
      }

      if (var11 > 0.0F) {
         var10 += (engine.getMovementSpeed(sprinting) - var10) * var11 / 3.0F;
      }

      this.moveFlying(motion, var10, var7, var8, var5, var6);
   }

   private void moveWater(PlayerData data, Motion motion, Box box, boolean var4, double var5) {
      Player var7 = data.getPlayer();
      PlayerStorage var8 = data.getStorage();
      BukkitEnginePlayer var9 = var8.getPhysicsHolder();
      VersionHolder var10 = var8.getVersionHolder();
      double var11 = var9.y;
      float var13;
      if (var10.isNewCollision()) {
         var13 = var9.sprinting ? 0.9F : 0.8F;
      } else {
         var13 = 0.8F;
      }

      float var14 = Math.min(3.0F, EnchantUtil.getBootDepthStrider(var7));
      if (!var9.onGround) {
         var14 *= 0.5F;
      }

      if (var14 > 0.0F) {
         var13 += (0.54600006F - var13) * var14 / 3.0F;
      }

      if (PotionEffectUtil.a(var7)) {
         var13 = 0.96F;
      }

      motion.motionX *= (double)var13;
      motion.motionY *= 0.8F;
      motion.motionZ *= (double)var13;
      if (!var10.isNewCollision()) {
         motion.motionY -= 0.02;
      }

      if (var10.isNewCollision() && !var9.sprinting) {
         if (motion.motionY <= 0.0 && Math.abs(motion.motionY - 0.005) >= 0.003 && Math.abs(motion.motionY - var5 / 16.0) < 0.003) {
            motion.motionY = -0.003;
         } else {
            motion.motionY -= var5 / 16.0;
         }
      }

   }

   private void a(PlayerData data, Motion motion, float var3, float var4, float var5, float var6) {
      float var7 = 0.02F;
      this.moveFlying(motion, var7, var5, var6, var3, var4);
   }

   private void a(PlayerData data, Motion motion, double var3, double var5) {
      Player var7 = data.getPlayer();
      if (PotionEffectUtil.b(var7)) {
         int var8 = PotionEffectUtil.getAmplifier(var7, PotionEffectUtil.LEVITATION);
         motion.motionY += (0.05 * (double)(var8 + 1) - motion.motionY) * 0.2;
         data.getStorage().getPhysicsHolder().fallDistance = 0.0F;
      } else {
         motion.motionY -= var3;
      }

      motion.motionX *= var5;
      motion.motionY *= 0.98F;
      motion.motionZ *= var5;
   }

   private void collideTracked(PlayerData data, Motion motion, TrackedEntity trackedEntity) {
      BukkitEnginePlayer var4 = data.getStorage().getPhysicsHolder();
      double var5 = var4.x - trackedEntity.position.posX;
      double var7 = var4.z - trackedEntity.position.posZ;
      double var9 = MathUtil.hypot(var5, var7);
      if (var9 >= 0.01F) {
         var9 = (double)MathUtil.sqrt(var9);
         var5 /= var9;
         var7 /= var9;
         double var11 = 1.0 / var9;
         if (var11 > 1.0) {
            var11 = 1.0;
         }

         var5 *= var11;
         var7 *= var11;
         var5 *= 0.05F;
         var7 *= 0.05F;
         if (!var4.isTrackingAttacked()) {
            var4.bW = true;
            motion.motionX += var5;
            motion.motionZ += var7;
         }
      }

   }

   void a(Player var1, Motion motion, double var3, double var5, double var7, double var9, double var11, double var13) {
      Unknown101 var15 = MoveHandlerFactory.a(var1, var3, var5, var7, var9, var11, var13);
      motion.motionX = var15.b();
      motion.motionY = var15.f();
      motion.motionZ = var15.g();
   }

   public void a(PlayerData data, MotionContext motionContext) {
      BukkitEnginePlayer var3 = data.getStorage().getPhysicsHolder();
      Motion var4 = motionContext.getMotion();
      if (this.is003(var4.motionX, var4.motionY, var4.motionZ)) {
         var3.o();
      }

   }

   @Override
   public void moveWithHeading(PlayerData data, double motionX, double motionY, double motionZ) {
      BukkitEnginePlayer var8 = data.getStorage().getPhysicsHolder();
      Unknown187 var9 = data.getStorage().e();
      Vector var10 = new Vector(motionX, motionY, motionZ);
      int var11 = var8.l <= 8 ? 8 : (var9.a > 50.0 ? 3 : 2);
      MoudleLoader.o().b().a(data.getPlayer(), var10, var11, var8.l > 16);
   }

   private void moveLava(Player player, PlayerData data, Motion motion, Box box, boolean var5) {
      BukkitEnginePlayer var6 = data.getStorage().getPhysicsHolder();
      double var7 = var6.y;
      motion.motionX *= 0.5;
      motion.motionY *= 0.5;
      motion.motionZ *= 0.5;
      motion.motionY -= 0.02;
      boolean var9 = CollisionUtil.getCollidingBoxes(player, box, motion.motionX, motion.motionY + 0.6F - var7 + var6.serverY, motion.motionZ);
      if (var5 && var9) {
         motion.motionY = 0.3F;
      }

   }
}
