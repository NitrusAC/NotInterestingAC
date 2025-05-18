package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import net.minecraft.server.v1_8_R3.Vec3D;

@Unknown61
public final class Unknown18 implements Unknown226 {
   @Unknown61
   @Override
   public Object a(Object var1) {
      return this.a(var1);
   }

   @Unknown61
   public WrappedVec3d a(Object var1) {
      Vec3D var2 = (Vec3D)var1;
      return new WrappedVec3d(var2.a, var2.b, var2.c);
   }
}
