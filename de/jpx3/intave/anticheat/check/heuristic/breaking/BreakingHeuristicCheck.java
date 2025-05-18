package de.jpx3.intave.anticheat.check.heuristic.breaking;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import org.bukkit.entity.Player;

public final class BreakingHeuristicCheck extends PartialConfigurableCheck {
   @PacketListener(
      packetTypes = {ClientPacket.BLOCK_DIG}
   )
   public void handleBlockDig(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      BreakingHeuristicStorage var7 = (BreakingHeuristicStorage)this.getStorage(var6);
      PacketContainer var8 = event.getPacket();
      PlayerDigType var9 = (PlayerDigType)var8.getPlayerDigTypes().readSafely(0);
      if (var9 == PlayerDigType.START_DESTROY_BLOCK) {
         BreakingHeuristicStorage.setDestroying(var7, true);
      }

      if (var9 == PlayerDigType.STOP_DESTROY_BLOCK) {
         if (var6.getStorage().getVersionHolder().getVersionId() < VersionHolder.V_1_14 && !BreakingHeuristicStorage.isDestroying(var7)) {
            event.setCancelled(true);
         }

         BreakingHeuristicStorage.setDestroying(var7, false);
      }

   }

   public BreakingHeuristicCheck(HeuristicCheckGroup group) {
      super(group, BreakingHeuristicStorage.class);
   }
}
