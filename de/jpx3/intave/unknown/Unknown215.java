package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.MovingObjectPositionBlock;
import com.comphenix.protocol.wrappers.EnumWrappers.Direction;
import de.jpx3.intave.anticheat.util.MinecraftVersion;

public final class Unknown215 extends Unknown202 {
   private final boolean d = MinecraftVersion.V_1_14.atOrAbove();

   public int a() {
      if (this.d) {
         MovingObjectPositionBlock var5 = (MovingObjectPositionBlock)this.getPacket().getMovingBlockPositions().readSafely(0);
         return var5 == null ? 255 : var5.getDirection().ordinal();
      } else {
         Integer var4 = (Integer)this.getPacket().getIntegers().readSafely(0);
         return var4 == null ? ((Direction)this.getPacket().getDirections().readSafely(0)).ordinal() : var4;
      }
   }
}
