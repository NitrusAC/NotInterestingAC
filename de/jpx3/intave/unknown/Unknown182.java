package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;

public final class Unknown182 {
   private static Unknown226 a;
   private static Unknown226 b;
   private static Unknown226 d;

   public static void c() {
      b = Unknown33.a();
      d = Unknown84.a();
      a = Unknown40.a();
   }

   public static Box c(Object var0) {
      return (Box)b.a(var0);
   }

   public static WrappedVec3d b(Object var0) {
      return (WrappedVec3d)a.a(var0);
   }

   public static BlockPos a(Object var0) {
      return (BlockPos)d.a(var0);
   }
}
