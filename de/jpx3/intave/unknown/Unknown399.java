package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.nms.BlockPos;
import net.minecraft.server.v1_8_R3.BlockPosition;

@Unknown61
public final class Unknown399 implements Unknown226 {
   @Unknown61
   @Override
   public Object a(Object var1) {
      return this.a(var1);
   }

   @Unknown61
   public BlockPos a(Object var1) {
      BlockPosition var2 = (BlockPosition)var1;
      return new BlockPos(var2.getX(), var2.getY(), var2.getZ());
   }
}
