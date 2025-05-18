package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.MovingObjectPositionBlock;
import de.jpx3.intave.anticheat.packet.wrap.AbstractPacketReader;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;

public class Unknown202 extends AbstractPacketReader {
   private static final String g;
   private final boolean a = MinecraftVersion.V_1_14.atOrAbove();

   public BlockPosition a() {
      if (this.a) {
         MovingObjectPositionBlock var4 = (MovingObjectPositionBlock)this.getPacket().getMovingBlockPositions().readSafely(0);
         return var4 == null ? null : var4.getBlockPosition();
      } else {
         return (BlockPosition)this.getPacket().getModifier().withType(ReflectionUtil.getClazz("BlockPosition"), Unknown283.c()).readSafely(0);
      }
   }
}
