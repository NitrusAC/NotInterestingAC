package de.jpx3.intave.anticheat.check.heuristic.keepsprint;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.pU;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.DamageHolder;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.wrap.modal.EntityAction;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.nms.WrappedEntityAction;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class KeepSprintCheck extends PartialConfigurableCheck {
   private boolean flag;
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   @PacketListener(
      packetTypes = {ClientPacket.ENTITY_ACTION}
   )
   public void handleEntityAction(PacketEvent event) {
      Player var6 = event.getPlayer();
      PlayerData var7 = this.getPlayerData(var6);
      PlayerStorage var8 = var7.getStorage();
      BukkitEnginePlayer var9 = var8.getPhysicsHolder();
      EntityHolder var10 = var8.getEntityHolder();
      VersionHolder var11 = var8.getVersionHolder();
      DamageHolder var12 = var7.getStorage().getDamageHolder();
      KeepSprintStorage var13 = (KeepSprintStorage)this.getStorage(var7);
      PacketContainer var14 = event.getPacket();
      EntityAction var15 = WrappedEntityAction.readEntityAction(var14);
      boolean var16 = var15 == EntityAction.START_SPRINTING || var15 == EntityAction.STOP_SPRINTING;
      boolean var17 = var15.isSneak();
      if (var16 || var17) {
         if (var10.isSpectator()) {
            var13.tickFlying();
         } else {
            boolean var18 = var16 ? var13.sprintTicks++ >= 1 : var13.otherTicks++ >= 1;
            if (var18) {
               boolean var19 = var11.isLegacy();
               boolean var20 = var19 || !var9.b(20);
               if (var20) {
                  String var21 = var16
                     ? "sent too many sprint toggles per tick (" + var13.sprintTicks + ")"
                     : "sent too many sneak toggles per tick (" + var13.otherTicks + ")";
                  if (!var19) {
                     var21 = var21 + " (last flying: " + var9.l() + ")";
                  }

                  if (this.flag) {
                     Certainty var22 = var19 ? Certainty.PROBABLE : Certainty.MAYBE;
                     short var23 = 548;
                     Anomaly var24 = Anomaly.of("41", var22, CombatCheckType.KILLAURA, var21, var23);
                     ((HeuristicCheckGroup)this.getParent()).logAnomaly(var6, var24);
                  }

                  boolean var25 = var19 || AccurateMathUtil.deltaXZ(var9.getMotionX(), var9.getMotionZ()) > 0.1 && var13.d++ > 3.0;
                  if (var25) {
                     if (var16) {
                        var7.a(Unknown227.CANCEL, "12");
                     } else {
                        var12.b = System.currentTimeMillis();
                        IntaveScheduler.runTask(KeepSprintCheck::b);
                     }
                  }
               }
            } else if (var13.d > 0.0) {
               var13.d -= 0.01;
            }

         }
      }
   }

   @Override
   public boolean isEnabled() {
      this.flag = super.isEnabled();
      return true;
   }

   public KeepSprintCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, KeepSprintStorage.class);
   }

   @PacketListener(
      packetTypes = {ClientPacket.FLYING, ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK}
   )
   public void handleFlying(PacketEvent event) {
      Player var2 = event.getPlayer();
      KeepSprintStorage var3 = (KeepSprintStorage)this.getStorage(var2);
      var3.tickFlying();
   }

   private static void b(Player var0) {
      pU.a(var0, 1, false);
   }
}
