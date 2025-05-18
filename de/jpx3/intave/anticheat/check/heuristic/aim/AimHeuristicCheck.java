package de.jpx3.intave.anticheat.check.heuristic.aim;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class AimHeuristicCheck extends PartialConfigurableCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   public AimHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, AimHeuristicStorage.class);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.POSITION_LOOK, ClientPacket.LOOK}
   )
   public void handle(PacketEvent event) {
      Player var6 = event.getPlayer();
      PlayerData var7 = this.getPlayerData(var6);
      PlayerStorage var8 = var7.getStorage();
      BukkitEnginePlayer var9 = var8.getPhysicsHolder();
      PlayerHolder var10 = var8.getPlayerHolder();
      AimHeuristicStorage var11 = (AimHeuristicStorage)this.getStorage(var6);
      TrackedEntity var12 = var10.getAttacked();
      float var13 = var9.yaw;
      float var14 = var10.getHorizontalAngle();
      float var15 = MathUtil2.distanceBetweenAngles(var13, var9.lastYaw);
      float var16 = MathUtil2.distanceBetweenAngles(var14, var13);
      if (var12 != null && var9.teleportTicks >= 5) {
         if (var10.hasAttacked(150L) && var15 > 1001.0F && var10.getHitDistance() > 1.0 && !var10.hasSwitchedTargets(200L)) {
            if (AimHeuristicStorage.increaseSecondBuffer(var11) > 0.0) {
               String var17 = "suspicious rotation snap (" + var15 + ")";
               byte var18 = 20;
               Anomaly var19 = Anomaly.of("86", Certainty.PROBABLE, CombatCheckType.KILLAURA, var17, var18);
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(var6, var19);
               var7.a(Unknown227.HT_MEDIUM, "16");
            }
         } else if (AimHeuristicStorage.getSecondBuffer(var11) > 0.0) {
            AimHeuristicStorage.setSecondBuffer(var11, AimHeuristicStorage.getSecondBuffer(var11) - 0.1);
         }

         if (var12.isDesyncOffsetLargerThan(0.05) && var10.hasAttacked(1000L) && (double)var15 > 1.0) {
            if ((double)var15 > 3.0) {
               double var28 = MathUtil2.clamp(-2.5, (2.2 - (double)var16) * (double)Math.min(6.0F, var15), 2.0);
               AimHeuristicStorage.getOffsetSum(var11, AimHeuristicStorage.setOffsetSum(var11) + var28);
               if (AimHeuristicStorage.setOffsetSum(var11) < 0.0) {
                  AimHeuristicStorage.getOffsetSum(var11, 0.0);
               }

               if (AimHeuristicStorage.setOffsetSum(var11) > 25.0) {
                  String var36 = "follows entity movement too precisely";
                  short var20 = 276;
                  Anomaly var21 = Anomaly.of("81", Certainty.MAYBE, CombatCheckType.KILLAURA, var36, var20);
                  ((HeuristicCheckGroup)this.getParent()).logAnomaly(var6, var21);
                  AimHeuristicStorage.getOffsetSum(var11, AimHeuristicStorage.setOffsetSum(var11) - 7.0);
               }
            }

            if (var16 == 0.0F) {
               String var29 = "rotated yaw too precise (0.0)";
               short var33 = 530;
               Anomaly var37 = Anomaly.of("82", Certainty.PROBABLE, CombatCheckType.KILLAURA, var29, var33);
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(var6, var37);
               var7.a(Unknown227.HT_MEDIUM, "17");
            }

            if ((double)var15 > 3.0) {
               double var30 = 2.0;
               AimHeuristicStorage.setOffsetAvg(var11, AimHeuristicStorage.getOffsetAvg(var11) + (var30 - (double)var16 / 0.8));
               AimHeuristicStorage.setOffsetAvg(var11, Math.max(0.0, AimHeuristicStorage.getOffsetAvg(var11)));
               int var38 = (int)AimHeuristicStorage.getOffsetAvg(var11);
               if (var38 > 8) {
                  if (AimHeuristicStorage.increaseBuffer(var11) > 3.0) {
                     String var41 = "high accuracy rotation yaw vl:" + var38;
                     short var43 = 146;
                     Anomaly var22 = Anomaly.of("83", Certainty.PROBABLE, CombatCheckType.KILLAURA, var41, var43);
                     ((HeuristicCheckGroup)this.getParent()).logAnomaly(var6, var22);
                     var7.a(Unknown227.HT_MEDIUM, "18");
                  }
               } else if (AimHeuristicStorage.getBuffer(var11) > 0.0) {
                  AimHeuristicStorage.setBuffer(var11, AimHeuristicStorage.getBuffer(var11) - 0.005);
               }
            }

            if ((double)var16 > 4.0) {
               AimHeuristicStorage.setRotationsBuffer(var11, 0.0);
            } else if (AimHeuristicStorage.increaseRotationsBuffer(var11) > 50.0) {
               String var31 = "keeps high yaw accuracy in " + (int)AimHeuristicStorage.getRotations(var11) + " rotations";
               short var34 = 146;
               Anomaly var39 = Anomaly.of("84", Certainty.MAYBE, CombatCheckType.KILLAURA, var31, var34);
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(var6, var39);
               AimHeuristicStorage.setRotationsBuffer(var11, 0.0);
               var7.a(Unknown227.HT_LIGHT, "19");
            }
         }

         if (!(AccurateMathUtil.deltaXZ(var9.getMotionX(), var9.getMotionZ()) < 0.05)
            && !(var10.getHitDistance() < 1.0)
            && var12.isDesyncOffsetLargerThan(0.05)) {
            int var32 = var14 > var13 ? 1 : 0;
            boolean var35 = AimHeuristicStorage.getOnTarget(var11) == var32;
            if (!var35) {
               AimHeuristicStorage.setTicks(var11, 0);
            } else if (var15 > 3.0F) {
               float var40 = MathUtil2.distanceBetweenAngles(AimHeuristicStorage.getDistance(var11), var16);
               double var42 = MathUtil2.clamp(-0.2, (double)((1.0F - var40) * 4.0F), 4.0);
               AimHeuristicStorage.setTicks(var11, (int)MathUtil2.clamp(0.0, (double)AimHeuristicStorage.getTicks(var11) + var42, 100.0));
               if (AimHeuristicStorage.getTicks(var11) > 30) {
                  long var44 = System.currentTimeMillis() - AimHeuristicStorage.getLastFlag(var11);
                  byte var24 = 82;
                  Certainty var25 = Certainty.PROBABLE;
                  Anomaly var26 = Anomaly.of("85", var25, CombatCheckType.KILLAURA, "high accuracy rotation yaw on hit-box corners", var24);
                  ((HeuristicCheckGroup)this.getParent()).logAnomaly(var6, var26);
                  AimHeuristicStorage.setTicks(var11, AimHeuristicStorage.getTicks(var11) - 20);
                  AimHeuristicStorage.setLastFlag(var11, System.currentTimeMillis());
               }
            }

            AimHeuristicStorage.setOnTarget(var11, var32);
            AimHeuristicStorage.setDistance(var11, var16);
         }
      }
   }
}
