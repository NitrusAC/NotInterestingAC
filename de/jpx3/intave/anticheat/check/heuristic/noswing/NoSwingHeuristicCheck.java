package de.jpx3.intave.anticheat.check.heuristic.noswing;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class NoSwingHeuristicCheck extends PartialConfigurableCheck {
   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void handleSwing(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = this.getPlayerData(var2);
      NoSwingHeuristicStorage var4 = (NoSwingHeuristicStorage)this.getStorage(var3);
      ++var4.swings;
   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void handleAttack(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      NoSwingHeuristicStorage var7 = (NoSwingHeuristicStorage)this.getStorage(var6);
      PacketContainer var8 = event.getPacket();
      EntityUseAction var9 = (EntityUseAction)var8.getEntityUseActions().readSafely(0);
      if (var9 == null) {
         var9 = ((WrappedEnumEntityUseAction)var8.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var9 == EntityUseAction.ATTACK) {
         ++var7.attacks;
      }

   }

   private void reset(NoSwingHeuristicStorage storage) {
      storage.swings = 0;
      storage.attacks = 0;
   }

   public NoSwingHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, NoSwingHeuristicStorage.class);
   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.VEHICLE_MOVE}
   )
   public void handleFlying(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      NoSwingHeuristicStorage var8 = (NoSwingHeuristicStorage)this.getStorage(var6);
      if (var7.teleportTicks != 0) {
         if (!var6.getStorage().getVersionHolder().isRewindVersion()) {
            if (var8.attacks > 0 && var8.swings == 0) {
               String var9 = "missing swing packet on attack";
               Anomaly var10 = Anomaly.of("171", Certainty.NONE, CombatCheckType.KILLAURA, var9, 4);
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var10);
               var6.a(Unknown227.CANCEL, "26");
            }

            this.reset(var8);
         }
      }
   }
}
