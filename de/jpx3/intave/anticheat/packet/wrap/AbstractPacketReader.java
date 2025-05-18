package de.jpx3.intave.anticheat.packet.wrap;

import com.comphenix.protocol.events.PacketContainer;

public abstract class AbstractPacketReader implements PacketReader {
   private PacketContainer packet;

   @Override
   public void read(PacketContainer packet) {
      this.packet = packet;
   }

   @Override
   public void reset() {
      this.packet = null;
   }

   public PacketContainer getPacket() {
      return this.packet;
   }
}
