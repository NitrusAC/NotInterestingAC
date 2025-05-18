package de.jpx3.intave.anticheat.check.reach.attack;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.check.api.BaseCheck;
import de.jpx3.intave.anticheat.check.api.config.CheckConfigValue;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.DamageHolder;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.ReachUtil;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.reach.DestroyedReachEntity;
import de.jpx3.intave.anticheat.util.reach.ReachPosition;
import de.jpx3.intave.anticheat.util.reach.ReachResult;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown10;
import de.jpx3.intave.unknown.Unknown142;
import de.jpx3.intave.unknown.Unknown187;
import de.jpx3.intave.unknown.Unknown227;
import de.jpx3.intave.unknown.Unknown255;
import de.jpx3.intave.unknown.Unknown354;
import de.jpx3.intave.unknown.Unknown38;
import de.jpx3.intave.unknown.Unknown394;
import de.jpx3.intave.unknown.Unknown63;
import de.jpx3.intave.unknown.check.Check15;
import java.util.List;
import java.util.Locale;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@Relocate
public final class AttackRaytraceCheck extends BaseCheck {
   private final double expand = 0.125;
   private final CheckConfigValue thresholdReach;
   private final IntavePlugin plugin;
   private static final char[] randomString = "aeiou".toCharArray();
   private final CheckConfigValue thresholdHitbox;

   public AttackRaytraceCheck(IntavePlugin plugin) {
      super("AttackRaytrace", "attackraytrace", AttackRaytraceStorage.class);
      this.plugin = plugin;
      this.thresholdHitbox = new CheckConfigValue(this, "applicable-thresholds.hitbox", 0.0625);
      this.thresholdReach = new CheckConfigValue(this, "applicable-thresholds.reach", 0.25);
   }

   private boolean b(PlayerData data, TrackedEntity entity) {
      Player var5 = data.getPlayer();
      int var6 = this.flag("pending-allowance", var5) + (int)MathUtil2.clamp(0.0, Unknown354.d(), 20.0);
      long var7 = entity.b();
      boolean var9 = var7 < (long)var6;
      if (!var9 && entity.y) {
         return true;
      } else {
         double var10 = this.a(data, entity, false, true);
         double var12 = (double)ReachUtil.getReach(var5);
         return var10 > var12;
      }
   }

   private boolean a(PlayerData data, TrackedEntity entity) {
      BukkitEnginePlayer var5 = data.getStorage().getPhysicsHolder();
      Player var6 = data.getPlayer();
      double var7 = (double)ReachUtil.getReach(var6);
      float var9 = var5.yaw % 360.0F;
      int var10 = this.flag("pending-allowance", var6) + (int)MathUtil2.clamp(0.0, Unknown354.d(), 20.0);
      long var11 = entity.b();
      boolean var13 = var11 < (long)var10;
      if (!var13 && entity.y) {
         return true;
      } else {
         ReachResult var14 = ReachUtil.raytrace(var6, entity, true, var5.x, var5.y, var5.z, var9, var9, var5.pitch, 0.1F, false);
         return var14.getDistance() > var7;
      }
   }

   private int a(Unknown10 var1, ReachResult result, TrackedEntity entity, PlayerData data, double speed) {
      AttackRaytraceStorage var7 = (AttackRaytraceStorage)this.getStorage(data);
      BukkitEnginePlayer var8 = data.getStorage().getPhysicsHolder();
      int var9 = 0;
      switch(Unknown38.a[var1.ordinal()]) {
         case 1:
            if (!entity.r().e()) {
               var9 = 0;
            } else {
               var9 = 4;
            }
            break;
         case 2:
            var9 = 20;
      }

      if (speed > 0.1F) {
         var9 /= 2;
      } else if (entity.f) {
         var9 = (int)((double)var9 * 1.25);
      }

      if (var8.isTrackingAttacked()) {
         var9 = 0;
      } else if (result.getHitPos() != null && var7.c != null && result.getHitPos().distance(var7.c) == 0.0) {
         var9 = 0;
      }

      return var9;
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void a(PacketEvent event) {
      PacketContainer var2 = event.getPacket();
      Player var3 = event.getPlayer();
      PlayerData var4 = this.getData(var3);
      AttackRaytraceStorage var5 = (AttackRaytraceStorage)this.getStorage(var3);
      PlayerStorage var6 = var4.getStorage();
      Unknown187 var7 = var6.e();
      BukkitEnginePlayer var8 = var6.getPhysicsHolder();
      VersionHolder var9 = var6.getVersionHolder();
      EntityHolder var10 = var6.getEntityHolder();
      EntityUseAction var11 = (EntityUseAction)var2.getEntityUseActions().readSafely(0);
      if (var11 == null) {
         var11 = ((WrappedEnumEntityUseAction)var2.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var11 == EntityUseAction.ATTACK) {
         PacketContainer var12 = var2.deepClone();
         int var13 = var2.getIntegers().read(0);
         TrackedEntity var14 = Check15.a(var4, var13);
         float var16 = var10.playerHealth;
         boolean var15;
         if (var14 == null || var14 instanceof DestroyedReachEntity || var16 <= 0.0F) {
            var15 = true;
         } else if (var8.teleportTicks != 0 && !var7.k) {
            if ((!var14.y || var8.b(2) || var5.d <= 1) && var9.getVersionId() != VersionHolder.V_1_8_8) {
               var15 = this.b(var4, var14);
            } else {
               var15 = this.a(var4, var14);
            }
         } else {
            var15 = true;
         }

         if (var15) {
            if (event.isReadOnly()) {
               event.setReadOnly(false);
            }

            event.setCancelled(true);
         }

         Unknown142 var17 = new Unknown142(var12, var13, var15);
         List var18 = var5.a;
         if (var18.size() < 4) {
            var18.add(var17);
         }
      }

   }

   private boolean raytrace(Player player, TrackedEntity entity, double distanceChecked) {
      PlayerData var7 = this.getData(player);
      PlayerStorage var8 = var7.getStorage();
      AttackRaytraceStorage var9 = (AttackRaytraceStorage)this.getStorage(var7);
      PlayerHolder var10 = var8.getPlayerHolder();
      BukkitEnginePlayer var11 = var8.getPhysicsHolder();
      VersionHolder var12 = var8.getVersionHolder();
      DamageHolder var13 = var8.getDamageHolder();
      double var14 = (double)ReachUtil.getReach(var8);
      boolean var16 = var12.getVersionId() == VersionHolder.V_1_8_8;
      boolean var17 = var12.getVersionId() >= 314;
      float var18 = var11.yaw % 360.0F;
      float var19 = var11.lastYaw % 360.0F;
      ReachResult var20 = ReachUtil.raytrace(player, entity, var16, var11.lastX, var11.lastY, var11.lastZ, var19, var18, var11.pitch, distanceChecked, !var17);
      var10.setHitDistance(var20.getDistance());
      Unknown10 var25 = Unknown10.a(var20.getDistance(), var14);
      int var26 = this.a(var25, var20, entity, var7, distanceChecked);
      String var27 = entity.t();
      double var28 = 0.0;
      String var21;
      String var22;
      String var23;
      String var24;
      switch(Unknown38.a[var25.ordinal()]) {
         case 1:
            var21 = "attacked " + this.a(var27) + " " + var27.toLowerCase() + " out of sight";
            var22 = "";
            var23 = "applicable-thresholds.hitbox";
            var24 = ChatColor.RED + "[R] " + player.getName() + " missed hit on " + var27.toLowerCase();
            var28 = -1.0;
            break;
         case 2:
            String var30 = MathUtil2.getStringRounded(var20.getDistance(), 4);
            var21 = "attacked " + this.a(var27) + " " + var27.toLowerCase() + " from too far away";
            var22 = var30 + " blocks";
            var23 = "applicable-thresholds.reach";
            var24 = ChatColor.RED + "[R] " + player.getName() + " attacked " + var27.toLowerCase() + " from " + var30;
            var28 = var20.getDistance();
            break;
         default:
            this.thresholdHitbox.a(var7, 0.125);
            this.thresholdReach.a(var7, 0.125);
            if (!var13.a(Unknown227.CANCEL_FIRST).b()) {
               return false;
            }

            double var34 = AccurateMathUtil.deltaXZ(var11.getMotionX(), var11.getMotionZ());
            return var34 > 0.1 && var20.getDistance() > 2.8;
      }

      Unknown394.c(var24);
      var9.c = var20.getHitPos();
      Violation var33 = Violation.builder(AttackRaytraceCheck.class)
         .player(player)
         .name(var21)
         .description(var22)
         .subcheck(var23)
         .vl((double)var26)
         .a("reach", MathUtil2.getStringRounded(var28, 4))
         .build();
      ImmutableViolation var31 = MoudleLoader.violations().dispatchViolation(var33);
      if (var31.j() > 50.0) {
         var7.a(Unknown227.DMG_MEDIUM, "3");
      }

      return true;
   }

   private String a(String var1) {
      char var4 = var1.trim().toLowerCase(Locale.ROOT).toCharArray()[0];
      boolean var5 = false;

      for(char var9 : randomString) {
         if (var9 == var4) {
            var5 = true;
            break;
         }
      }

      return var5 ? "an" : "a";
   }

   private void a(Player var1, PacketContainer var2) {
      this.getData(var1).c();
      ProtocolManager.receivePacket(var1, var2);
   }

   private boolean a(Player player, TrackedEntity entity) {
      PlayerData var5 = this.getData(player);
      PlayerStorage var6 = var5.getStorage();
      BukkitEnginePlayer var7 = var6.getPhysicsHolder();
      VersionHolder var8 = var5.getStorage().getVersionHolder();
      double var9 = (double)ReachUtil.getReach(var6);
      boolean var11 = var8.getVersionId() >= 314;
      double var12 = this.a(var5, entity, var11, false);
      if (var12 > var9) {
         String var14 = entity.t();
         String var15 = this.a(var14) + " " + var14.toLowerCase();
         String var16;
         String var17;
         String var18;
         if (var12 == 10.0) {
            var17 = "attacked " + var15 + " out of sight";
            var18 = "estimated";
            var16 = "applicable-thresholds.hitbox";
         } else {
            String var19 = MathUtil2.getStringRounded(var12, 4) + " blocks";
            var17 = "attacked " + var15 + " from too far away";
            var18 = var19 + " at best, estimated";
            var16 = "applicable-thresholds.reach";
         }

         if (var7.isTrackingAttacked()) {
            var17 = var17 + " (vehicle)";
         }

         Violation var20 = Violation.builder(AttackRaytraceCheck.class)
            .player(player)
            .name(var17)
            .description(var18)
            .subcheck(var16)
            .vl(0.0)
            .b(Unknown255.a)
            .build();
         MoudleLoader.violations().dispatchViolation(var20);
         return true;
      } else {
         this.thresholdHitbox.a(var5, 0.125);
         this.thresholdReach.a(var5, 0.125);
         return false;
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK}
   )
   public void b(PacketEvent event) {
      Player var4 = event.getPlayer();
      PlayerData var5 = this.getData(var4);
      AttackRaytraceStorage var6 = (AttackRaytraceStorage)this.getStorage(var5);
      PacketContainer var7 = event.getPacket();
      PlayerStorage var8 = var5.getStorage();
      VersionHolder var9 = var8.getVersionHolder();
      BukkitEnginePlayer var10 = var8.getPhysicsHolder();
      Unknown187 var11 = var8.e();
      if (var10.teleportTicks == 0) {
         var6.a.clear();
      } else {
         int var12 = this.flag("pending-allowance", var4) + (int)MathUtil2.clamp(0.0, Unknown354.d(), 20.0);
         List var13 = var6.a;

         for(Unknown142 var15 : var13) {
            this.a(var5, Unknown63::g);
            TrackedEntity var16 = Check15.a(var5, var15.b());
            Boolean var17 = null;
            EntityHolder var18 = var5.getStorage().getEntityHolder();
            float var19 = var18.playerHealth;
            if (var16 == null) {
               Unknown394.c(ChatColor.RED + "[R] " + var4.getName() + " attacked a null entity");
            } else {
               long var20 = var16.b();
               Unknown354.a((short)((int)var20));
               boolean var22 = var19 > 0.0F && !(var16 instanceof DestroyedReachEntity);
               boolean var23 = var20 < (long)var12;
               long var24 = var5.getStorage().c().b();
               double var26 = (double)var24 / 50.0;
               int var28 = (int)((Unknown354.d() + var26 + 1.0) * 0.9);
               boolean var29 = var24 > 0L && var20 > (long)var28;
               boolean var30 = !var5.getTrustFactor().atLeast(TrustFactor.ORANGE);
               if (var29) {
                  Unknown394.c(
                     ChatColor.RED
                        + "[R] "
                        + var4.getName()
                        + " attack latency ("
                        + (var30 ? "blocked, " : "")
                        + var20
                        + "/"
                        + var28
                        + "p with "
                        + var24
                        + "ms tra-ping, "
                        + var16.o()
                        + " dist)"
                  );
                  if (var30) {
                     var23 = false;
                  }
               }

               if (var22 && var23) {
                  if (var16.getParent() == null && !var4.isInsideVehicle() && var16.r().e() && !var18.isSpectator()) {
                     if (!var9.isLegacy()) {
                        if (var16.y && !var10.b(2) && var6.d > 1) {
                           var17 = this.raytrace(var4, var16, 0.1F);
                        } else {
                           var17 = this.a(var4, var16);
                        }
                     } else if (!var16.y) {
                        var17 = this.a(var4, var16);
                     } else if (var6.d > 1) {
                        var17 = this.raytrace(var4, var16, 0.1F);
                     } else {
                        var17 = this.raytrace(var4, var16, 0.13F);
                     }

                     if (var17) {
                        this.a(var5, Unknown63::d);
                     }
                  }
               } else {
                  var17 = true;
               }
            }

            if (var17 == null || !var17 || var5.getTrustFactor().atLeast(TrustFactor.BYPASS)) {
               if (!var11.k && Unknown142.a(var15)) {
                  this.a(var4, Unknown142.b(var15));
               }

               this.a(var5, Unknown63::a);
            }
         }

         var13.clear();
         boolean var31 = var7.getBooleans().read(1);
         if (!var31) {
            var6.d = 0;
         } else {
            ++var6.d;
         }

      }
   }

   private double a(PlayerData data, TrackedEntity entity, boolean var3, boolean var4) {
      Player var7 = data.getPlayer();
      PlayerStorage var8 = data.getStorage();
      VersionHolder var9 = var8.getVersionHolder();
      boolean var10 = var9.getVersionId() == VersionHolder.V_1_8_8;
      BukkitEnginePlayer var11 = var8.getPhysicsHolder();
      float var12 = var11.yaw % 360.0F;
      float var13 = var11.lastYaw % 360.0F;
      float var14 = var11.pitch;
      double var15 = var11.x;
      double var17 = var11.y;
      double var19 = var11.z;
      double var21 = var11.lastX;
      double var23 = var11.lastY;
      double var25 = var11.lastZ;
      double var27 = (double)ReachUtil.getReach(var8);
      int var29 = this.flag("pending-allowance", var7) + (int)MathUtil2.clamp(0.0, Unknown354.d(), 20.0);
      double var30 = 10.0;
      TrackedEntity var32 = entity.copy();
      boolean var33 = entity.r().e();
      List var34 = var32.potentials;
      int var35 = var34.size() - 1;

      for(int var36 = var35; var36 >= 0; --var36) {
         if (var35 - var36 <= var29) {
            ReachPosition var37 = (ReachPosition)var34.get(var36);
            var32.position = var37.copy();
            ReachResult var38 = ReachUtil.raytrace(var7, var32, var10, var21, var23, var25, var13, var12, var14, 0.13F, !var3);
            double var39 = var38.getDistance();
            if (var4 && var38.getDistance() < var27) {
               return var38.getDistance();
            }

            ReachResult var42;
            for(int var41 = 5; var32.position.ticks > 0 && var33 && var41-- > 0; var39 = Math.min(var39, var42.getDistance())) {
               var32.update();
               var42 = ReachUtil.raytrace(var7, var32, var10, var21, var23, var25, var13, var12, var14, 0.13F, !var3);
               if (var4 && var42.getDistance() < var27) {
                  return var42.getDistance();
               }
            }

            var30 = Math.min(var30, var39);
         }
      }

      if (var11.b(1) && data.getStorage().getVersionHolder().getVersionId() >= VersionHolder.V_1_9) {
         List var45 = entity.potentials;
         var35 = var45.size() - 1;

         for(int var46 = var35; var46 >= 0; --var46) {
            if (var35 - var46 <= var29) {
               ReachPosition var47 = (ReachPosition)var45.get(var46);
               var32.position = var47.copy();
               ReachResult var48 = ReachUtil.raytrace(var7, var32, false, var15, var17, var19, var12, var12, var14, 0.13F, false);
               if (var4 && var48.getDistance() < var27) {
                  return var48.getDistance();
               }

               double var40 = var48.getDistance();

               ReachResult var43;
               for(int var49 = 5; var32.position.ticks > 0 && var33 && var49-- > 0; var40 = Math.min(var40, var43.getDistance())) {
                  var32.update();
                  var43 = ReachUtil.raytrace(var7, var32, false, var15, var17, var11.z, var12, var12, var14, 0.13F, false);
                  if (var4 && var43.getDistance() < var27) {
                     return var43.getDistance();
                  }
               }

               var30 = Math.min(var30, var40);
            }
         }
      }

      return var30;
   }
}
