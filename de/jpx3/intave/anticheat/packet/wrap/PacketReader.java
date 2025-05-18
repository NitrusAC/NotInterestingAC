package de.jpx3.intave.anticheat.packet.wrap;

import com.comphenix.protocol.events.PacketContainer;

public interface PacketReader {
   void read(PacketContainer packet);

   void reset();
}
