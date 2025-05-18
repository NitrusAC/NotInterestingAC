package de.jpx3.intave.unknown;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.packet.PacketRegistry;
import de.jpx3.intave.mG;
import de.jpx3.intave.anticheat.IntavePlugin;
import io.netty.channel.Channel;
import java.util.Collection;
import org.bukkit.entity.Player;

@mG
public final class Unknown374 extends Unknown349 {
   private final Unknown233 x;

   public Unknown374(IntavePlugin var1, Unknown233 var2) {
      super(var1);
      this.x = var2;
   }

   private static void b(PacketEvent var0, Unknown172 var1) {
      var1.onPacketSending(var0);
   }

   @Override
   public Object a(Player var1, Channel var2, Object var3) {
      PacketType var4 = PacketRegistry.getPacketType(var3.getClass());
      if (var4 != null) {
         Collection var5 = this.x.a(var4);
         if (var5 != null && !var5.isEmpty()) {
            PacketEvent var6 = PacketEvent.fromServer(var3, PacketContainer.fromPacket(var3), var1);
            var5.forEach(Unknown374::b);
            var3 = var6.getPacket().getHandle();
            if (var6.isCancelled()) {
               return null;
            }
         }
      }

      return super.a(var1, var2, var3);
   }
}
