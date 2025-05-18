package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.BlockPosition;
import de.jpx3.intave.anticheat.packet.wrap.AbstractPacketReader;
import org.bukkit.Material;

public final class Unknown214 extends AbstractPacketReader {
   public int b() {
      return this.getPacket().getIntegers().read(1);
   }

   public BlockPosition d() {
      return (BlockPosition)this.getPacket().getBlockPositionModifier().read(0);
   }

   public int a() {
      return this.getPacket().getIntegers().read(0);
   }

   public Material c() {
      return (Material)this.getPacket().getBlocks().read(0);
   }
}
