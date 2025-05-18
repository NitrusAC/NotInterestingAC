package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.collision.Box;
import net.minecraft.server.v1_8_R3.AxisAlignedBB;

@Unknown61
public final class Unknown271 implements Unknown226 {
   @Unknown61
   @Override
   public Object a(Object var1) {
      return this.a(var1);
   }

   @Unknown61
   public Box a(Object var1) {
      AxisAlignedBB var2 = (AxisAlignedBB)var1;
      return new Box(var2.a, var2.b, var2.c, var2.d, var2.e, var2.f);
   }
}
