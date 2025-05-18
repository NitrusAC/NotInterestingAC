package de.jpx3.intave.anticheat.check.physics;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.access.check.MitigationStrategy;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.api.config.CheckConfig;
import de.jpx3.intave.anticheat.check.api.config.CheckConfigValue;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MotionContext;
import de.jpx3.intave.anticheat.engine.heading.HeadingHandler;
import de.jpx3.intave.anticheat.engine.heading.Headings;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.move.MoveHandlerFactory;
import de.jpx3.intave.anticheat.engine.runner.EngineRunner;
import de.jpx3.intave.anticheat.engine.runner.IntaveEngineRunner;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.reflection.DamageSourceReflection;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown101;
import de.jpx3.intave.unknown.Unknown135;
import de.jpx3.intave.unknown.Unknown143;
import de.jpx3.intave.unknown.Unknown144;
import de.jpx3.intave.unknown.Unknown15;
import de.jpx3.intave.unknown.Unknown187;
import de.jpx3.intave.unknown.Unknown300;
import de.jpx3.intave.unknown.Unknown360;
import de.jpx3.intave.unknown.Unknown63;
import de.jpx3.intave.unknown.what.What1;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@Relocate
public final class PhysicsCheck extends AbstractCheck {
   private final CheckConfigValue config;
   private final boolean highTolerance;
   private final DamageSourceReflection damageSourceReflect;
   private final EngineRunner runner;
   private final PhysicsLeniencyHandler leniencyHandler;
   private final boolean refreshNearbyBlocks;
   private final boolean resetItemUsage;
   private static final int o = 41;
   private final boolean closeInventory;
   private static final double l = 6.0;
   private final IntavePlugin plugin;
   private static final double q = 0.05;

   public boolean isHighTolerance() {
      return this.highTolerance;
   }

   private void updateBlocks(List blocks, Player player) {
      for(IntaveVector var4 : blocks) {
         this.sendBlockUpdate(player, var4.toLocation(player.getWorld()));
      }

   }

   private void moveEntity(PlayerData data, double motionX, double motionY, double motionZ) {
      if (this.isRefreshNearbyblocks()) {
         Player var8 = data.getPlayer();
         Box var9 = Box.of(data, motionX, motionY, motionZ).grow(0.75);
         List var10 = (List)CollisionUtil.collectCollide(var8, var9, 8, Collectors.toList());
         IntaveScheduler.runTask(this::updateBlocks);
      }
   }

   public void i(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      double var3 = var2.deltaX;
      double var5 = var2.deltaY;
      double var7 = var2.deltaZ;
      if (Math.abs(var3) < var2.getMinimumMotion()) {
         var3 = 0.0;
      }

      if (Math.abs(var5) < var2.getMinimumMotion()) {
         var5 = 0.0;
      }

      if (Math.abs(var7) < var2.getMinimumMotion()) {
         var7 = 0.0;
      }

      double var9 = var3 * 0.91F;
      double var11 = (var5 - 0.08) * 0.98F;
      double var13 = var7 * 0.91F;
      Unknown101 var15 = MoveHandlerFactory.a(data.getPlayer(), var2.serverX, var2.serverY, var2.serverZ, var9, var11, var13);
      var2.contextGround = var15.c();
   }

   public void a(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      this.handleFall(data);
      var2.U();
   }

   private String getMaterialName(Material material) {
      return material.name().toLowerCase().replace("_", "").replace("block", "");
   }

   private void handleGravity(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      if (var2.velocityTicks == 0) {
         double var3 = var2.lastDeltaX * 0.91F;
         double var5 = (var2.lastDeltaY - 0.08) * 0.98F;
         double var7 = var2.lastDeltaZ * 0.91F;
         if (var3 != 0.0 && var5 != 0.0 && var7 != 0.0) {
            Unknown101 var9 = MoveHandlerFactory.a(data.getPlayer(), var2.serverX, var2.serverY, var2.serverZ, var3, var5, var7);
            var3 = var9.b();
            var5 = var9.f();
            var7 = var9.g();
            if (var9.c() || var2.contextGround) {
               double var10 = var3 * var3 + var5 * var5 + var7 * var7;
               if (var10 < 0.009) {
                  var2.bm = true;
                  var2.a(0);
               }
            }
         }

      }
   }

   public void a(PlayerData data, boolean var2) {
      BukkitEnginePlayer var3 = data.getStorage().getPhysicsHolder();
      double var4 = var3.getMotionX();
      double var6 = var3.getMotionY();
      double var8 = var3.getMotionZ();
      if (var2) {
         HeadingHandler var10 = var3.getHeadingHandler();
         if (var3.velocityTicks == 0) {
            if (var3.jumping && var3.isTakingVelocity()) {
               ++var3.Y;
            } else if (var3.Y > 0.0) {
               --var3.Y;
            }
         }

         var10.moveEntityHandle(data, var3.x, var3.y, var3.z, var4, var6, var8);
      }

   }

   @Override
   public boolean isEnabled() {
      return true;
   }

   private static String getStringKey(int moveForward, int moveStrafe) {
      String var2 = "";
      if (moveForward == 1) {
         var2 = var2 + "W";
      } else if (moveForward == -1) {
         var2 = var2 + "S";
      }

      if (moveStrafe == 1) {
         var2 = var2 + "A";
      } else if (moveStrafe == -1) {
         var2 = var2 + "D";
      }

      return var2;
   }

   private void sendBlockUpdate(Player player, Location location) {
      PacketContainer var3 = ProtocolLibrary.getProtocolManager().createPacket(Server.BLOCK_CHANGE);
      if (WorldUtil.isChunkLoaded(location.getWorld(), location.getBlockX(), location.getBlockZ())) {
         Block var4 = WorldUtil.getBlockAt(location);
         Object var5 = Unknown15.a(var4);
         WrappedBlockData var6 = WrappedBlockData.fromHandle(var5);
         BlockPosition var7 = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
         var3.getBlockData().write(0, var6);
         var3.getBlockPositionModifier().write(0, var7);
         ProtocolManager.sendPacket(player, var3);
      }
   }

   private void handleFall(PlayerData data) {
      PlayerStorage var2 = data.getStorage();
      VersionHolder var3 = var2.getVersionHolder();
      BukkitEnginePlayer var4 = var2.getPhysicsHolder();
      if (var3.isNewCollision()) {
         var4.inWater = Unknown360.a(data, var4.getBoundingBox());
      } else {
         Box var5 = var4.getBoundingBox();
         Box var6 = var5.grow(0.0, -0.4F, 0.0).expand(0.001, 0.001, 0.001);
         var4.inWater = Unknown143.a(data, var6);
      }

      if (var4.inWater) {
         var4.groundTicks = 0;
         var4.fallDistance = 0.0F;
      }

   }

   public boolean isRefreshNearbyblocks() {
      return this.refreshNearbyBlocks;
   }

   public void computeFall(PlayerData data) {
      if (data.exists()) {
         BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
         if (var2.fallDistance > 3.0F) {
            float var3 = var2.fallDistance;
            IntaveScheduler.runTask(this::b);
            var2.fallDistance = 0.0F;
         }

      }
   }

   @Override
   public boolean e() {
      return true;
   }

   private void sinkWater(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      var2.deltaY -= 0.04F;
   }

   private HeadingHandler getHeading(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      VersionHolder var3 = data.getStorage().getVersionHolder();
      boolean var4 = MinecraftVersion.V_1_9.atOrAbove() && var3.isNewerVersion();
      if (var2.isTrackingAttacked() && var4) {
         TrackedEntity var7 = var2.getTrackedEntity();
         int var8 = var7.r().g();
         return var8 == 41 ? Headings.BOAT : Headings.HORSE;
      } else {
         boolean var5 = var2.isCollideLava();
         boolean var6 = var2.isCollideWater();
         return var2.isElytraFlying && !var6 && !var5 ? Headings.ELYTRA : Headings.VANILLA;
      }
   }

   public boolean isCloseInventory() {
      return this.closeInventory;
   }

   private void setupHeadingHandlers() {
      for(HeadingHandler var2 : Headings.getHandlers()) {
         var2.setParent(this);
      }

   }

   private void handleMinimumMotion(PlayerData data) {
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      double var3 = var2.getMinimumMotion();
      if (Math.abs(var2.deltaX) < var3) {
         var2.deltaX = 0.0;
      }

      if (Math.abs(var2.deltaY) < var3) {
         var2.deltaY = 0.0;
      }

      if (Math.abs(var2.deltaZ) < var3) {
         var2.deltaZ = 0.0;
      }

   }

   private void b(PlayerData data, BukkitEnginePlayer engine, float var3) {
      Player var4 = data.getPlayer();
      engine.N = true;
      this.damageSourceReflect.getDamageSource(var4, var3);
      engine.N = false;
   }

   private void a(PlayerData data, PhysicsResult result) {
      Player var5 = data.getPlayer();
      PlayerStorage var6 = data.getStorage();
      boolean var7 = var5.getGameMode() == GameMode.SPECTATOR;
      BukkitEnginePlayer var8 = var6.getPhysicsHolder();
      VersionHolder var9 = var6.getVersionHolder();
      Unknown187 var10 = var6.e();
      EntityHolder var11 = var6.getEntityHolder();
      IntaveWorld var12 = data.getWorld();
      MotionContext var13 = result.getMotionContext();
      Motion var14 = var13.getMotion();
      int var15 = var8.moveForward;
      int var16 = var8.moveStrafe;
      boolean var17 = var11.canFly() || var11.d();
      String var18 = getStringKey(var15, var16);
      double var19 = var8.getMotionX();
      double var21 = var8.getMotionY();
      double var23 = var8.getMotionZ();
      double var25 = var14.motionX;
      double var27 = var14.motionY;
      double var29 = var14.motionZ;
      double var31 = var25 - var19;
      double var33 = var27 - var21;
      double var35 = var29 - var23;
      double var37 = MathUtil2.getLength(var31, var33, var35);
      double var39 = var8.x;
      double var41 = var8.y;
      double var43 = var8.z;
      double var45 = var8.serverX;
      double var47 = var8.serverY;
      double var49 = var8.serverZ;
      boolean var51 = de.jpx3.intave.anticheat.util.CollisionUtil.b(data, var45, var47, var49);
      boolean var52 = var51 | var8.bu;
      var8.bu = var51;
      boolean var53 = var8.e();
      boolean var54 = var37 <= 1.0E-5;
      double var55 = var54 ? 0.0 : this.leniencyHandler.getLenientHeight(data, var27, var52, var53);
      double var57 = var54 ? 0.0 : this.leniencyHandler.getLenientDistance(data, var25, var29, var52, var53);
      if (var52) {
         var8.fallDistance = 0.0F;
      }

      boolean var59 = false;
      boolean var60 = !var54 && var8.bg > 5 && !var8.inWater && !var8.e();
      if (var60 && var8.l < 10 && !var8.b(2) && var37 > 0.008 && !var52) {
         boolean var61 = var10.b++ >= 6.0;
         if (var61 || var37 > 0.01) {
            if (var61) {
               var57 = Math.max(2.0, var57);
               var59 = true;
            }

            var57 *= 10.0;
         }
      }

      boolean var95 = !data.getTrustFactor().atLeast(TrustFactor.YELLOW);
      if (var37 > 0.008 && var95 && var8.ab <= 8 && var57 > 0.1 && !var8.isSneaking()) {
         var57 = Math.max(100.0, var57 * 75.0);
      }

      if (var10.b > 10.0) {
         var10.b = 10.0;
      }

      if (var10.b > 0.0) {
         var10.b -= 0.005;
      }

      double var62 = var57 + var55;
      if (var8.getHeadingHandler() == Headings.HORSE) {
         var62 = 0.0;
      }

      if (var37 > 0.001) {
         var8.isMoving = true;

         for(Unknown135 var65 : var8.a()) {
            var65.c(0);
         }

         PhysicsResult var97 = this.runner.run(data, this.getHeading(data));
         Motion var99 = var97.getMotion();
         Vector var66 = var8.bR;
         if (var8.isSneaking() && !var8.isContextGround() && var66 != null) {
            var25 = Math.abs(var99.motionX) < 0.05 ? var99.motionX + MathUtil2.clamp(-0.05, var66.getX(), 0.05) : var99.motionX;
            var27 = var99.motionY;
            var29 = Math.abs(var99.motionZ) < 0.05 ? var99.motionZ + MathUtil2.clamp(-0.05, var66.getZ(), 0.05) : var99.motionZ;
            var8.bR = null;
         } else {
            var25 = var99.motionX;
            var27 = var99.motionY;
            var29 = var99.motionZ;
         }
      }

      if (var17 || var7) {
         var62 = 0.0;
      }

      if (var62 == 0.0 && var10.a > 0.0) {
         var10.a *= 0.99;
         var10.a -= 0.012;
      }

      Location var98 = var8.getLocation();
      Box var100 = Box.of(data, var98);
      Box var101 = Box.of(data, var39, var41, var43);
      boolean var67 = CollisionUtil.a(var5, var100);
      boolean var68 = CollisionUtil.a(var5, var101);
      boolean var69 = !var67 && var68;
      if (var68 && !var7) {
         List var70 = CollisionUtil.b(var5, var101);
         if (var69 && !var70.isEmpty()) {
            var8.aO = true;
            Box var71 = (Box)var70.get(0);
            double var72 = (var71.minX + var71.maxX) / 2.0;
            double var74 = (var71.minY + var71.maxY) / 2.0;
            double var76 = (var71.minZ + var71.maxZ) / 2.0;
            Block var78 = WorldUtil.getBlockAt(var5.getWorld(), var72, var74, var76);
            boolean var79 = var12.e(MathUtil.floor(var72), MathUtil.floor(var74), MathUtil.floor(var76));
            boolean var80 = IntaveMaterial.b(data, IntaveMaterial.from(var78));
            String var81;
            if (!CollisionUtil.isWorldBorder(var5.getWorld(), var72, var76)) {
               var81 = "world border";
            } else {
               String var82 = (var79 ? "emulated" : "") + " " + (var80 ? "altered" : "") + " ";
               Material var83 = WorldUtil.getMaterialAt(data, var78.getLocation());
               String var84 = this.getMaterialName(var83);
               var81 = var82 + var84 + " block";
            }

            String var113 = "moved into " + var81.trim();
            boolean var115 = var70.size() > 1;
            String var117 = (var115 ? var70.size() : "one") + " box" + (var115 ? "es" : "");
            var12.a();
            Violation var85 = Violation.builder(PhysicsCheck.class).player(var5).name(var113).description(var117).vl(0.0).build();
            MoudleLoader.violations().dispatchViolation(var85);
            Vector var86 = new Vector(var25, var27, var29);
            MoudleLoader.o().b().a(var5, var86, 2, true);
         }
      }

      if (!var68 && !var67) {
         var8.m = false;
      }

      if (var7 || var62 == 0.0 && !var68) {
         Location var102 = new Location(var5.getWorld(), var39, var41, var43, var8.yaw, var8.pitch);
         var8.setLocation(var102, "Movement validation (normal)");
      }

      if (var62 > 0.0) {
         boolean var103 = var8.groundTicks < 20 || var8.collidedHorizontally || var8.e() || var8.inWeb || var8.bC < 20;
         if (var103) {
            var62 /= 2.0;
         } else if (var9.isNewCollision()) {
            var62 /= 2.0;
         }

         double var96 = Math.min(200.0, var62);
         var62 = Math.max(1.0, var96);
         var10.a = MathUtil2.clamp(0.0, var10.a + var62, 200.0);
         ++var10.h;
         if (var10.a > 20.0) {
            var12.a();
         }

         this.a(data, Unknown63::d);
      } else {
         var10.h = 0.0;
         this.a(data, Unknown63::a);
      }

      if (!var7 && var10.a > 50.0 && var62 > 0.0) {
         String var104 = MathUtil2.roundVecToString(var19, var21, var23);
         String var106 = MathUtil2.roundVecToString(var25, var27, var29);
         String var108 = "moved incorrectly";
         String var73 = var104 + " est: " + var106;
         if (var59) {
            var73 = var73 + ", strict";
         }

         double var109 = var62 / (double)(this.isHighTolerance() ? 75 : (var10.a >= 100.0 ? 20 : 50));
         Violation var110 = Violation.builder(PhysicsCheck.class).player(var5).name(var108).description(var73).vl(var109).build();
         ImmutableViolation var77 = MoudleLoader.violations().dispatchViolation(var110);
         if (!var8.contextGround && !var8.collidedHorizontally && !var8.collidedVertically) {
            boolean var122 = true;
         } else {
            boolean var10000 = false;
         }

         boolean var111 = var8.contextGround;
         double var112 = MathUtil2.getLength(var8.getMotionX(), var8.getMotionY(), var8.getMotionZ());
         boolean var114 = var77.m();
         int var116 = this.flag("pa-override-threshold", var5);
         boolean var118 = var10.a > (double)var116;
         boolean var119 = var10.a >= (double)Math.max(var116, 150);
         double var120 = var77.b();
         double var88 = var77.j();
         MitigationStrategy var90 = this.getStrategy();
         boolean var91 = false;
         double var92 = 0.0;
         switch(Unknown144.a[var90.ordinal()]) {
            case 1:
               var91 = var114 || !this.isHighTolerance() && var118;
               var92 = 0.75;
               break;
            case 2:
               var91 = var114 || var118 && (var88 > 20.0 || var119 || !data.getTrustFactor().atLeast(TrustFactor.YELLOW) || data.isRecentLogin());
               if (var21 > Math.max(0.42F, var8.getJumpBoostHeight()) + 0.01) {
                  var91 = true;
               }

               var92 = 0.75;
               break;
            case 3:
               boolean var94 = var55 >= 100.0 && var27 < 0.0 && var88 > 30.0;
               var91 = (var112 > (var88 > 30.0 ? 0.4 : 0.6) || var88 > 200.0 || data.isRecentLogin() || var94) && var114 && (var119 || var88 > 100.0);
               var92 = 0.75;
               break;
            case 4:
               var91 = false;
               var92 = 1.25;
         }

         if (var37 > var92) {
            var91 = true;
         }

         if (data.getTrustFactor().atLeast(TrustFactor.BYPASS)) {
            var91 = false;
         }

         if (var91) {
            HeadingHandler var121 = data.getStorage().getPhysicsHolder().getHeadingHandler();
            var121.moveWithHeading(data, var25, var27, var29);
            this.moveEntity(data, var45, var47, var49);
            var8.aO = true;
         }
      }

      this.a(data, Unknown63::g);
      if (var62 == 0.0 && var10.a < 1.0) {
         this.config.a(data, 0.05);
      }

      var10.a = MathUtil2.clamp(0.0, var10.a, 100.0);
      Pose var105 = var8.getPose();
      if (var8.bu || var105 == Pose.ELYTRA || var17) {
         var8.fallDistance = 0.0F;
      }

      if (var8.isCollideLava()) {
         var8.fallDistance = (float)((double)var8.fallDistance * 0.5);
      }

      Unknown300 var107 = (Unknown300)this.plugin.E().a(Unknown300.class);
      var107.a(AccurateMathUtil.deltaXZ(var8.getMotionX(), var8.getMotionZ()));
   }

   public boolean isResetItemUsage() {
      return this.resetItemUsage;
   }

   public void run(PlayerData data) {
      PlayerStorage var4 = data.getStorage();
      BukkitEnginePlayer var5 = var4.getPhysicsHolder();
      VersionHolder var6 = var4.getVersionHolder();
      HeadingHandler var7 = this.getHeading(data);
      var5.setHeadingHandler(var7);
      var5.width = var7.getStepHeight();
      if (var6.isNewCollision() && var5.isSneaking && var5.inWater) {
         this.sinkWater(data);
      }

      this.a(data);
      this.handleMinimumMotion(data);
      What1.o.h();
      this.handleGravity(data);

      PhysicsResult var8;
      try {
         var8 = this.runner.execute(data, var5.getHeadingHandler());
      } catch (IllegalStateException var10) {
         data.error("Internal error, please contact the servers administrator.");
         var10.printStackTrace();
         return;
      }

      MotionContext var9 = var8.getMotionContext();
      var5.contextGround = var9.isOnGround();
      var5.collidedHorizontally = var9.isCollideHorizontal();
      var5.collidedVertically = var9.isCollideVertical();
      var5.collidedX = var9.isCollideX();
      var5.collidedZ = var9.isCollideZ();
      var5.stepped = var9.isStep();
      What1.o.g();
      What1.j.h();
      this.a(data, var8);
      What1.j.g();
      var5.lastPhysicsIteration = System.currentTimeMillis();
      var5.lastMoveStrafe = var5.moveStrafe;
      var5.lastMoveForward = var5.moveForward;
      ++var5.iteratedTick;
   }

   public PhysicsCheck(IntavePlugin plugin) {
      super("Physics", "physics");
      this.plugin = plugin;
      this.config = new CheckConfigValue(this, 1.0);
      CheckConfig var4 = this.b().b();
      this.highTolerance = var4.getBoolean("high-tolerance", false);
      if (var4.exists("on-detection")) {
         this.resetItemUsage = var4.getBoolean("on-detection.reset-item-usage", true);
         this.closeInventory = var4.getBoolean("on-detection.close-inventory", true);
         this.refreshNearbyBlocks = var4.getBoolean("on-detection.refresh-nearby-blocks", true);
      } else {
         this.resetItemUsage = var4.getBoolean("reset-item-usage", true);
         this.closeInventory = var4.getBoolean("close-inventory-on-detection", true);
         this.refreshNearbyBlocks = var4.getBoolean("refresh-nearby-blocks-on-detection", true);
      }

      this.runner = new IntaveEngineRunner(this.resetItemUsage);
      this.leniencyHandler = new PhysicsLeniencyHandler();
      this.setLegacyStrategy(MitigationStrategy.CAREFUL);
      this.damageSourceReflect = new DamageSourceReflection();
      this.setupHeadingHandlers();
   }
}
