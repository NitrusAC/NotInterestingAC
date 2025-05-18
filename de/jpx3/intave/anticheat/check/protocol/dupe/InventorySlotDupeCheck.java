package de.jpx3.intave.anticheat.check.protocol.dupe;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.inventory.dupe.InventorySlotDupeStorage;
import de.jpx3.intave.anticheat.check.protocol.ProtocolCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.violation.Violation;
import org.bukkit.entity.Player;

public final class InventorySlotDupeCheck extends PartialConfigurableCheck {
   private final int increase;

   @PacketListener(
      packetTypes = {ClientPacket.HELD_ITEM_SLOT}
   )
   public void handleSlot(PacketEvent event) {
      Player var5 = event.getPlayer();
      PacketContainer var6 = event.getPacket();
      PlayerData var7 = this.getPlayerData(var5);
      InventorySlotDupeStorage var8 = (InventorySlotDupeStorage)this.getStorage(var7);
      int var9 = var6.getIntegers().read(0);
      if (var8.lastSlot == var9 && var9 > 0) {
         Violation var10 = Violation.builder(ProtocolCheckGroup.class)
            .player(var5)
            .name("sent slot twice")
            .description("slot " + var9)
            .vl(var8.ticks > 4 ? (double)this.increase : 0.0)
            .build();
         MoudleLoader.violations().dispatchViolation(var10);
      }

      var8.lastSlot = var9;
      ++var8.ticks;
   }

   public InventorySlotDupeCheck(ProtocolCheckGroup group) {
      super(group, InventorySlotDupeStorage.class);
      this.increase = group.b().b().a("check_sent_slot_twice_vl", 100);
   }

   @Override
   public boolean isEnabled() {
      return super.isEnabled() && this.increase != 0;
   }
}
