package de.jpx3.intave.anticheat.packet;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.module.Module;

public interface IPacketHandler {
   void invoke(Module var1, PacketEvent var2);
}
