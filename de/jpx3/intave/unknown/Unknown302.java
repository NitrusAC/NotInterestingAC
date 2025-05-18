package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import java.util.Optional;

public final class Unknown302 extends UnknownCheck {
   private static final int a = MinecraftVersion.V_1_13.atOrAbove() ? (MinecraftVersion.V_1_17.atOrAbove() ? 1 : 2) : 5;
   private static final String h;
   private static final boolean e = MinecraftVersion.V_1_17.atOrAbove();
   private static final boolean f = MinecraftVersion.V_1_9.atOrAbove();

   @PacketListener(
      priority = IntaveListenerPriority.HIGHEST,
      g = {ServerPacket.SCOREBOARD_TEAM}
   )
   public void a(PacketEvent var1) {
      if (f) {
         PacketContainer var5 = var1.getPacket();
         if (e) {
            if (var5.getSpecificModifier(Optional.class).read(0) != null) {
               Optional var6 = (Optional)var5.getOptionalStructures().read(0);
               if (var6.isPresent()) {
                  InternalStructure var7 = (InternalStructure)var6.get();
                  StructureModifier var8 = var7.getStrings();
                  this.a(var8);
               }
            }
         } else {
            this.a(var5.getStrings());
         }

      }
   }

   private void a(StructureModifier var1) {
      var1.write(a, "never");
   }
}
