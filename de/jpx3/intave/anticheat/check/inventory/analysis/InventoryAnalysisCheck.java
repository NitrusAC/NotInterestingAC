package de.jpx3.intave.anticheat.check.inventory.analysis;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.inventory.InventoryAnalysisCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.unknown.Unknown394;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public final class InventoryAnalysisCheck extends PartialConfigurableCheck {
   public InventoryAnalysisCheck(InventoryAnalysisCheckGroup group) {
      super(group, InventoryAnalysisStorage.class);
   }

   @PacketListener(
      packetTypes = {ClientPacket.FLYING, ClientPacket.POSITION, ClientPacket.LOOK, ClientPacket.POSITION_LOOK}
   )
   public void handleFlying(PacketEvent event) {
      Player var2 = event.getPlayer();
      ((InventoryAnalysisStorage)this.getStorage(var2)).last = System.currentTimeMillis();
   }

   @PacketListener(
      packetTypes = {ClientPacket.WINDOW_CLICK}
   )
   public void handleInventoryClick(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      InventoryAnalysisStorage var7 = (InventoryAnalysisStorage)this.getStorage(var5);
      long var8 = System.currentTimeMillis() - var7.last;
      double var10 = var6.getStorage().c().n();
      if (var8 < 15L && Math.abs(var10 - 50.0) < 10.0) {
         String var12 = ChatColor.RED + "[InvAnalysis] " + var5.getName() + " is clicking suspiciously on items: " + var8 + " pd, " + var10 + " md";
         Unknown394.c(var12);
      }

   }
}
