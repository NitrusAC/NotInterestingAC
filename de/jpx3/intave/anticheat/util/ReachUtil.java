package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.anticheat.util.reach.ReachResult;
import de.jpx3.intave.anticheat.util.reach.ReachType;
import de.jpx3.intave.unknown.Unknown140;
import de.jpx3.intave.unknown.Unknown152;
import de.jpx3.intave.unknown.what.What1;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class ReachUtil {
   private static Unknown140 c;
   private static final boolean[] vars = new boolean[]{false, true};

   private static double getEyeHeight(Player player) {
      PlayerData var1 = PlayerDataManager.getPlayerData(player);
      return (double)var1.getStorage().getPhysicsHolder().getEyeHeight();
   }

   public static float getReach(PlayerStorage storage) {
      return storage.getEntityHolder().isGameMode(GameMode.CREATIVE) ? 5.0F : 3.0F;
   }

   public static float getReach(PlayerData data) {
      return getReach(data.getStorage());
   }

   public static ReachResult getResult(
      Player var0, TrackedEntity var1, boolean var2, double var3, double var5, double var7, float var9, float var10, double var11
   ) {
      return raytrace(
         var0, var1.getBoundingBox(), var2 ? var1.nextPosition.posY - var1.position.posY : 0.0, var3, var5, var7, var9, var10, var11, ReachType.ENTITY
      );
   }

   public static HitResult raytrace(World var0, Player var1, WrappedVec3d var2, WrappedVec3d var3) {
      HitResult var4;
      try {
         What1.p.h();
         var4 = c.a(var0, var1, var2, var3);
      } finally {
         What1.p.g();
      }

      return var4;
   }

   public static HitResult b(World var0, Player var1, WrappedVec3d var2, WrappedVec3d var3) {
      HitResult var4;
      try {
         What1.p.h();
         var4 = c.a(var0, var1, var2, var3);
      } finally {
         What1.p.g();
      }

      return var4;
   }

   public static void a() {
      String var3;
      if (MinecraftVersion.V_1_14.atOrAbove()) {
         var3 = "de.jpx3.intave.kk";
      } else if (MinecraftVersion.V_1_13.atOrAbove()) {
         var3 = "de.jpx3.intave.di";
      } else if (MinecraftVersion.V_1_9.atOrAbove()) {
         var3 = "de.jpx3.intave.jG";
      } else {
         var3 = "de.jpx3.intave.unknown.handler.Handler1";
      }

      Unknown152.a(ReachUtil.class.getClassLoader(), var3);
      c = (Unknown140)instanze(var3);
   }

   public static ReachResult raytrace(
      Player player, TrackedEntity trackedEntity, boolean posY, double x, double y, double z, float yaw, float pitch, double distance
   ) {
      return raytrace(
         player,
         trackedEntity.getBoundingBox(),
         posY ? trackedEntity.nextPosition.posY - trackedEntity.position.posY : 0.0,
         x,
         y,
         z,
         yaw,
         pitch,
         distance,
         ReachType.BLOCK
      );
   }

   private static Object instanze(String var0) {
      try {
         return Class.forName(var0).newInstance();
      } catch (Exception var2) {
         throw new IllegalStateException(var2);
      }
   }

   public static HitResult a(Player var0, Location var1, double var2) {
      double var4 = getBlockReach(var0.getGameMode());
      double var6 = getEyeHeight(var0);
      return raytrace(var0, var1, var1, var4, var6, 1.0F);
   }

   public static WrappedVec3d interpolateLocation(Location from, Location to, double bonusY, float partialTicks) {
      double var5 = from.getX();
      double var7 = from.getY();
      double var9 = from.getZ();
      if (partialTicks == 1.0F) {
         return new WrappedVec3d(var5, var7 + bonusY, var9);
      } else {
         double var11 = to.getX();
         double var13 = to.getY();
         double var15 = to.getZ();
         double var17 = var11 + (var5 - var11) * (double)partialTicks;
         double var19 = var13 + (var7 - var13) * (double)partialTicks + bonusY;
         double var21 = var15 + (var9 - var15) * (double)partialTicks;
         return new WrappedVec3d(var17, var19, var21);
      }
   }

   public static HitResult a(Player var0, Location var1) {
      double var2 = getBlockReach(var0.getGameMode());
      double var4 = getEyeHeight(var0);
      return raytrace(var0, var1, var1, var2, var4, 1.0F);
   }

   private static double getBlockReach(GameMode var0) {
      return var0 == GameMode.CREATIVE ? 5.0 : 4.5;
   }

   public static HitResult b(Player var0, Location var1, Location var2, double var3, double var5, float var7) {
      WrappedVec3d var8 = interpolateLocation(var1, var2, var5, var7);
      WrappedVec3d var9 = interpolateLook(var1, var2, var7);
      WrappedVec3d var10 = var8.add(var9.x * var3, var9.y * var3, var9.z * var3);
      return b(var1.getWorld(), var0, var8, var10);
   }

   private static WrappedVec3d getEyeVector(Player player, double x, double y, double z) {
      return new WrappedVec3d(x, y + getEyeHeight(player), z);
   }

   public static ReachResult raytrace(
      Player var0, TrackedEntity var1, boolean var2, double var3, double var5, double var7, float var9, float var10, float var11, double var12, boolean var14
   ) {
      double var18 = (double)getReach(var0);
      ReachResult var20 = getResult(var0, var1, var2, var3, var5, var7, var10, var11, var12);
      if (var14 && var20.getDistance() > var18 && var10 != var9) {
         var20 = getResult(var0, var1, var2, var3, var5, var7, var9, var11, var12);
      }

      return var20;
   }

   public static ReachResult raytrace(
      Player player, Box box, double bonusY, double x, double y, double z, float yaw, float pitch, double expand, ReachType reachType
   ) {
      What1.b.h();
      WrappedVec3d var19 = getEyeVector(player, x, y, z);
      double var20 = 6.0;
      double var22 = (double)getReach(player);
      double var24 = 10.0;
      WrappedVec3d var26 = null;

      for(boolean var30 : vars) {
         if (var24 < var22) {
            break;
         }

         WrappedVec3d var31 = getVectorForRotation(pitch, yaw, var30);
         WrappedVec3d var32 = var19.add(var31.x * var20, var31.y * var20, var31.z * var20);
         Box var33 = box.grow(expand, expand, expand);
         if (bonusY != 0.0) {
            var33 = var33.growUp(bonusY);
         }

         HitResult var34 = var33.intercept(var19, var32);
         if (var33.c(var19)) {
            var24 = 0.0;
            var26 = null;
         } else if (var34 != null) {
            double var35 = var19.distanceSqrt(var34.pos);
            double var37;
            if (reachType != ReachType.ENTITY) {
               var37 = var35;
            } else {
               HitResult var39 = raytrace(player.getWorld(), player, var19, var32);
               double var40 = var39 != null && var39.pos != null ? var19.distanceSqrt(var39.pos) : 10.0;
               var37 = var40 < var35 ? 10.0 : var35;
            }

            if (var37 < var24) {
               var24 = var37;
               var26 = var34.pos;
            }
         }
      }

      What1.b.g();
      return ReachResult.of(var19, var26, var24);
   }

   private static WrappedVec3d getVectorForRotation(float pitch, float yaw, boolean fastMath) {
      float var3 = MathHelperTable.cos(-yaw * (float) (Math.PI / 180.0) - (float) Math.PI, fastMath);
      float var4 = MathHelperTable.sin(-yaw * (float) (Math.PI / 180.0) - (float) Math.PI, fastMath);
      float var5 = -MathHelperTable.cos(-pitch * (float) (Math.PI / 180.0), fastMath);
      float var6 = MathHelperTable.sin(-pitch * (float) (Math.PI / 180.0), fastMath);
      return new WrappedVec3d((double)(var4 * var5), (double)var6, (double)(var3 * var5));
   }

   private static WrappedVec3d interpolateLook(Location from, Location to, float partialTicks) {
      float var6 = from.getYaw();
      float var7 = from.getPitch();
      if (partialTicks == 1.0F) {
         return getVectorForRotation(var7, var6);
      } else {
         float var8 = to.getYaw();
         float var9 = to.getPitch();
         float var10 = var9 + (var7 - var9) * partialTicks;
         float var11 = var8 + (var6 - var8) * partialTicks;
         return getVectorForRotation(var10, var11);
      }
   }

   private static WrappedVec3d getVectorForRotation(float pitch, float yaw) {
      float var2 = MathHelperTable.cos(-yaw * (float) (Math.PI / 180.0) - (float) Math.PI, false);
      float var3 = MathHelperTable.sin(-yaw * (float) (Math.PI / 180.0) - (float) Math.PI, false);
      float var4 = -MathHelperTable.cos(-pitch * (float) (Math.PI / 180.0), false);
      float var5 = MathHelperTable.sin(-pitch * (float) (Math.PI / 180.0), false);
      return new WrappedVec3d((double)(var3 * var4), (double)var5, (double)(var2 * var4));
   }

   public static HitResult raytrace(Player player, Location from, Location to, double multiplier, double bonusY, float partialTicks) {
      WrappedVec3d var11 = interpolateLocation(from, to, bonusY, partialTicks);
      WrappedVec3d var12 = interpolateLook(from, to, partialTicks);
      WrappedVec3d var13 = var11.add(var12.x * multiplier, var12.y * multiplier, var12.z * multiplier);
      return raytrace(from.getWorld(), player, var11, var13);
   }

   public static float getReach(Player player) {
      return getReach(PlayerDataManager.getPlayerData(player));
   }
}
