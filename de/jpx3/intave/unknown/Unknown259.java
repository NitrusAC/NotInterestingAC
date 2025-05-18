package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import java.util.EventListener;
import org.bukkit.entity.Player;

public final class Unknown259 implements EventListener {
   private int h;
   private int c;
   private int d;
   private int b;
   private final IntavePlugin a;
   private int f = 22657;
   private int e;
   private int g;

   private native void a(Player var1);

   @PacketListener(
      packetTypes = {ClientPacket.CUSTOM_PAYLOAD}
   )
   public native void a(PacketEvent var1);

   private static Unknown4 a(Unknown4 var0) {
      return var0;
   }

   private void b() {
      this.a(null);
   }

   public Unknown259(IntavePlugin var1) {
      this.h = 51352;
      this.g = 43753;
      this.e = 51436;
      this.d = 72454;
      this.b = 86543;
      this.c = 12366;
      Unknown262.a(this::b);
      this.a = var1;
   }
}
