package de.jpx3.intave.anticheat.check.place.invalid;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.PartialCheck;
import de.jpx3.intave.anticheat.check.place.PlaceCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class InvalidPlaceCheck extends PartialCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   public InvalidPlaceCheck(PlaceCheckGroup group) {
      super(group);
   }

   private boolean isUse(PacketContainer packet) {
      Integer var5 = (Integer)packet.getIntegers().readSafely(0);
      return var5 != null && var5 == 255;
   }

   @PacketListener(
      packetTypes = {ClientPacket.BLOCK_PLACE}
   )
   public void a(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      PacketContainer var7 = event.getPacket();
      if (!this.isUse(var7)) {
         StructureModifier var8 = var7.getFloat();
         if (var8.size() >= 3) {
            float var9 = var8.read(0);
            float var10 = var8.read(1);
            float var11 = var8.read(2);
            if (var9 < 0.0F || var10 < 0.0F || var11 < 0.0F || var9 > 1.0F || var10 > 1.0F || var11 > 1.0F) {
               Violation var12 = Violation.builder(PlaceCheckGroup.class).player(var5).name("suspicious block-placement").vl(5.0).build();
               MoudleLoader.violations().dispatchViolation(var12);
               var6.a(Unknown227.CANCEL_FIRST, "14");
               var6.a(Unknown227.HT_MEDIUM, "14");
            }

         }
      }
   }
}
