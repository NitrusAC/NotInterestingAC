package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.google.gson.JsonElement;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import org.bukkit.entity.Player;

public final class Unknown344 {
   private final Unknown383 a;

   private native void a(Player var1, String var2, JsonElement var3);

   public Unknown344(Unknown383 var1) {
      this.a = var1;
   }

   private native boolean a(Player var1);

   public native void a(Player var1, Unknown95 var2);

   private static void b(Player var0, PacketContainer var1) {
      ProtocolManager.sendPacket(var0, var1);
   }
}
