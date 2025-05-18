package de.jpx3.intave.anticheat.check.protocol.pitch;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.PartialCheck;
import de.jpx3.intave.anticheat.check.protocol.ProtocolCheckGroup;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.violation.Violation;
import org.bukkit.entity.Player;

public final class InvalidPitchCheck extends PartialCheck {
   @PacketListener(
      packetTypes = {ClientPacket.LOOK, ClientPacket.POSITION_LOOK}
   )
   public void handle(PacketEvent event) {
      Player var5 = event.getPlayer();
      float var6 = event.getPacket().getFloat().read(1);
      if (Math.abs(var6) > 90.05F) {
         event.getPacket().getFloat().writeSafely(1, 0.0F);
         String var7 = "sent invalid rotation";
         String var8 = "pitch at " + MathUtil2.getStringRounded((double)var6, 4);
         Violation var9 = Violation.builder(ProtocolCheckGroup.class).player(var5).name(var7).description(var8).vl(100.0).build();
         MoudleLoader.violations().dispatchViolation(var9);
      }

   }

   public InvalidPitchCheck(ProtocolCheckGroup group) {
      super(group);
   }
}
