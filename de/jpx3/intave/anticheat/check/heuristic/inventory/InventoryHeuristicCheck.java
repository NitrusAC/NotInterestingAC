package de.jpx3.intave.anticheat.check.heuristic.inventory;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.ClientCommand;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class InventoryHeuristicCheck extends PartialConfigurableCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.FLYING, ClientPacket.LOOK}
   )
   public void c(PacketEvent event) {
      Player var6 = event.getPlayer();
      PlayerData var7 = this.getPlayerData(var6);
      InventoryHeuristicStorage var8 = (InventoryHeuristicStorage)this.getStorage(var7);
      PacketContainer var9 = event.getPacket();
      boolean var10 = var9.getBooleans().read(2);
      ItemHolder var11 = var7.getStorage().getItemHolder();
      BukkitEnginePlayer var12 = var7.getStorage().getPhysicsHolder();
      VersionHolder var13 = var7.getStorage().getVersionHolder();
      if (var13.isLegacy() && !var12.isTrackingAttacked()) {
         boolean var14 = var11.j();
         if (!var14) {
            InventoryHeuristicStorage.setInventoryOpen(var8, false);
         }

         if (var14 && var10 && var12.teleportTicks > 20 && !var6.isInsideVehicle() && InventoryHeuristicStorage.increaseRotations(var8) > 1) {
            short var15 = 144;
            String var16 = "sent rotations in inventory (" + InventoryHeuristicStorage.getRotations(var8) + " rotations)";
            Anomaly var17 = Anomaly.of("132", Certainty.NONE, CombatCheckType.KILLAURA, var16, var15);
            ((HeuristicCheckGroup)this.getParent()).logAnomaly(var6, var17);
            var7.a(Unknown227.HT_LIGHT, "10");
         }

         if (!var14) {
            InventoryHeuristicStorage.reset(var8);
         }

         if (InventoryHeuristicStorage.isInventoryOpen(var8)) {
            InventoryHeuristicStorage.increaseOpenTicks(var8);
         } else {
            InventoryHeuristicStorage.setInventoryOpenTicks(var8, 0);
         }

      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.CLIENT_COMMAND}
   )
   public void handleClientCommand(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = this.getPlayerData(var2);
      ClientCommand var4 = (ClientCommand)event.getPacket().getClientCommands().read(0);
      if (var4 == ClientCommand.OPEN_INVENTORY_ACHIEVEMENT) {
         InventoryHeuristicStorage var5 = (InventoryHeuristicStorage)this.getStorage(var3);
         InventoryHeuristicStorage.setInventoryOpen(var5, true);
         InventoryHeuristicStorage.setInventoryOpenTicks(var5, 0);
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.CLOSE_WINDOW}
   )
   public void handleCloseInventory(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      InventoryHeuristicStorage var7 = (InventoryHeuristicStorage)this.getStorage(var6);
      VersionHolder var8 = var6.getStorage().getVersionHolder();
      EntityHolder var9 = var6.getStorage().getEntityHolder();
      if (!var9.isSpectator()) {
         if (var8.isLegacy() && InventoryHeuristicStorage.getInventoryOpenTicks(var7) == 0 && InventoryHeuristicStorage.isInventoryOpen(var7)) {
            short var10 = 530;
            String var11 = "closed inventory too quickly (" + InventoryHeuristicStorage.getInventoryOpenTicks(var7) + ")";
            Anomaly var12 = Anomaly.of("131", Certainty.NONE, CombatCheckType.KILLAURA, var11, var10);
            ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var12);
         }

      }
   }

   public InventoryHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, InventoryHeuristicStorage.class);
   }
}
