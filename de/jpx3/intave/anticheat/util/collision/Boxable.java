package de.jpx3.intave.anticheat.util.collision;

import de.jpx3.intave.k3;
import de.jpx3.intave.anticheat.util.BlockRaytrace;
import de.jpx3.intave.anticheat.util.nms.Direction;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.util.List;

public interface Boxable {
   @k3
   BlockRaytrace raytrace(IntaveVector eyePosition, IntaveVector eyeLook);

   @Deprecated
   List b();

   double calculateOffset(Direction var1, Box var2, double var3);

   boolean isInside(Box other);

   boolean a();

   Boxable b(int var1, int var2, int var3);

   boolean c();

   double a(Direction var1);

   Boxable a(int var1, int var2, int var3);

   double b(Direction var1);
}
