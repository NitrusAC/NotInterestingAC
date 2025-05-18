package de.jpx3.intave.anticheat.check.heuristic.accuracy;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import java.util.List;
import org.bukkit.entity.Player;

public final class AccuracyHeuristicCheck extends PartialConfigurableCheck {
   private double getMean(List values) {
      double var5 = 0.0;

      for(Number var8 : values) {
         var5 += var8.doubleValue();
      }

      return var5 == 0.0 ? 0.0 : var5 / (double)values.size();
   }

   @PacketListener(
      packetTypes = {ClientPacket.USE_ENTITY, ClientPacket.ARM_ANIMATION}
   )
   public void handleSwing(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      PlayerHolder var7 = var6.getStorage().getPlayerHolder();
      AccuracyHeuristicStorage var8 = (AccuracyHeuristicStorage)this.getStorage(var6);
      PacketType var9 = event.getPacketType();
      PacketContainer var10 = event.getPacket();
      TrackedEntity var11 = var7.getAttacked();
      if (var11 == null || var11.isDesyncOffsetLargerThan(0.05)) {
         if (var7.hasAttacked(500L) && !var7.hasSwitchedTargets(1000L)) {
            if (var9 == Client.ARM_ANIMATION) {
               ++var8.armTicks;
            } else {
               EntityUseAction var12 = (EntityUseAction)var10.getEntityUseActions().readSafely(0);
               if (var12 == null) {
                  var12 = ((WrappedEnumEntityUseAction)var10.getEnumEntityUseActions().read(0)).getAction();
               }

               if (var12 == EntityUseAction.ATTACK) {
                  ++var8.attackTicks;
                  --var8.armTicks;
               }
            }

         }
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.POSITION_LOOK, ClientPacket.LOOK}
   )
   public void handleLook(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      PlayerHolder var7 = var6.getStorage().getPlayerHolder();
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      AccuracyHeuristicStorage var9 = (AccuracyHeuristicStorage)this.getStorage(var6);
      if (var7.hasAttacked(1000L) && !var7.hasSwitchedTargets(500L) && !(var7.getHitDistance() < 1.0)) {
         float var10 = MathUtil2.distanceBetweenAngles(var7.getHorizontalAngle(), var8.yaw);
         float var11 = MathUtil2.distanceBetweenAngles(var8.yaw, var8.lastYaw);
         float var12 = MathUtil2.distanceBetweenAngles(var8.pitch, var8.lastPitch);
         if (var9.entityOffsets.size() > 20) {
            double var13 = this.getMean(var9.entityOffsets);
            double var15 = this.getMean(var9.lookOffsets);
            double var17 = var9.armTicks / var9.attackTicks * 100.0;
            if (var17 < 5.0 && (var15 > 10.0 || var13 > 10.0)) {
               ++var9.buffer;
               String var19 = "maintains high attack accuracy whilst aiming at hitbox corners (fail:"
                  + MathUtil2.getStringRounded(var17, 2)
                  + "%, r:"
                  + MathUtil2.getStringRounded(var15, 2)
                  + ", d:"
                  + MathUtil2.getStringRounded(var13, 2)
                  + ") vl:"
                  + MathUtil2.getStringRounded(var9.buffer, 2);
               byte var20 = 84;
               Anomaly var21 = Anomaly.of("51", Certainty.MAYBE, CombatCheckType.KILLAURA, var19, var20);
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var21);
               if (var9.buffer >= 2.0) {
                  var6.a(Unknown227.HT_MEDIUM, "13");
                  var6.a(Unknown227.DMG_MEDIUM, "13");
               }
            } else if (var9.buffer > 0.0) {
               var9.buffer -= 0.2;
            }

            var9.attackTicks = 0.0;
            var9.armTicks = 0.0;
            var9.entityOffsets.clear();
            var9.lookOffsets.clear();
         }

         if (var11 > 5.0F && var7.hasAttacked(60L)) {
            var9.entityOffsets.add(var10);
            var9.lookOffsets.add(var11 + var12);
         }

      }
   }

   public AccuracyHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, AccuracyHeuristicStorage.class);
   }
}
