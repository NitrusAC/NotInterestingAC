package de.jpx3.intave.unknown;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import org.bukkit.plugin.Plugin;

public abstract class Unknown173 extends PacketAdapter {
   public void a() {
      this.plugin = null;
   }

   public Unknown173(Plugin var1, PacketType[] var2) {
      super(var1, var2);
   }

   public Unknown173(Plugin var1, ListenerPriority var2, PacketType[] var3) {
      super(var1, var2, var3);
   }

   public Unknown173(Plugin var1, ListenerPriority var2, Iterable var3) {
      super(var1, var2, var3);
   }
}
