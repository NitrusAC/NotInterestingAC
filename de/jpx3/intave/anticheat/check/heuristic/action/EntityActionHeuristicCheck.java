package de.jpx3.intave.anticheat.check.heuristic.action;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.wrap.modal.EntityAction;
import de.jpx3.intave.anticheat.util.nms.WrappedEntityAction;
import de.jpx3.intave.anticheat.violate.Anomaly;
import org.bukkit.entity.Player;

public final class EntityActionHeuristicCheck extends PartialConfigurableCheck {
   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.ENTITY_ACTION}
   )
   public void handleEntityAction(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      EntityAction var8 = WrappedEntityAction.readEntityAction(event.getPacket());
      VersionHolder var9 = var6.getStorage().getVersionHolder();
      EntityActionHeuristicStorage var10 = (EntityActionHeuristicStorage)this.getStorage(var6);
      String var11 = null;
      if (var8 == EntityAction.START_SNEAKING) {
         if (EntityActionHeuristicStorage.sentSneak(var10) != null && EntityActionHeuristicStorage.sentSneak(var10)) {
            var11 = "sent start_sneak packet twice";
         }

         EntityActionHeuristicStorage.setSneak(var10, true);
      }

      if (var8 == EntityAction.STOP_NSEAKING) {
         if (EntityActionHeuristicStorage.sentSneak(var10) != null && !EntityActionHeuristicStorage.sentSneak(var10)) {
            var11 = "sent stop_sneak packet twice";
         }

         EntityActionHeuristicStorage.setSneak(var10, false);
      }

      if (var8 == EntityAction.START_SPRINTING) {
         if (EntityActionHeuristicStorage.sentSprint(var10) != null && EntityActionHeuristicStorage.sentSprint(var10)) {
            var11 = "sent start_sprint packet twice";
         }

         EntityActionHeuristicStorage.setSprint(var10, true);
      }

      if (var8 == EntityAction.STOP_SPRINTING) {
         if (EntityActionHeuristicStorage.sentSprint(var10) != null && !EntityActionHeuristicStorage.sentSprint(var10)) {
            var11 = "sent stop_sprint packet twice";
         }

         EntityActionHeuristicStorage.setSprint(var10, false);
      }

      if (var11 != null && var10.count > 10) {
         var11 = var11 + " " + var9.getVersionId();
         Anomaly var12 = Anomaly.of("190", Certainty.NONE, CombatCheckType.KILLAURA, var11, 64);
         ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var12);
      }

   }

   @PacketListener(
      packetTypes = {ClientPacket.POSITION, ClientPacket.POSITION_LOOK}
   )
   public void handlePos(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = this.getPlayerData(var2);
      EntityActionHeuristicStorage var4 = (EntityActionHeuristicStorage)this.getStorage(var3);
      ++var4.count;
   }

   public EntityActionHeuristicCheck(HeuristicCheckGroup heuristic) {
      super(heuristic, EntityActionHeuristicStorage.class);
   }
}
