package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.packet.wrap.AbstractPacketReader;

public final class Unknown195 extends AbstractPacketReader implements Unknown64 {
   @Override
   public int[] b() {
      return (int[])((int[])this.getPacket().getIntegerArrays().read(0)).clone();
   }

   @Override
   public int[] a() {
      return (int[])((int[])this.getPacket().getIntegerArrays().read(1)).clone();
   }
}
