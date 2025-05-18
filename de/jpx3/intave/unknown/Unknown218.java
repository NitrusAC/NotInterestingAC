package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.packet.wrap.AbstractPacketReader;

public final class Unknown218 extends AbstractPacketReader implements Unknown64 {
   @Override
   public int[] b() {
      return new int[]{this.getPacket().getIntegers().read(0)};
   }

   @Override
   public int[] a() {
      return new int[]{this.getPacket().getIntegers().read(1)};
   }
}
