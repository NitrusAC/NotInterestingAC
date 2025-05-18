package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.BlockRaytrace;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.nms.Direction;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.util.Collections;
import java.util.List;

final class Unknown245 implements Boxable {
   private static final String b;

   @Override
   public double b(Direction var1) {
      return 0.0;
   }

   @Override
   public double a(Direction var1) {
      return 0.0;
   }

   @Override
   public BlockRaytrace raytrace(IntaveVector eyePosition, IntaveVector eyeLook) {
      return BlockRaytrace.getDefaultRaytrace();
   }

   @Override
   public List b() {
      return Collections.emptyList();
   }

   public String toString() {
      return "Empty";
   }

   @Override
   public Boxable a(int var1, int var2, int var3) {
      return this;
   }

   @Override
   public Boxable b(int var1, int var2, int var3) {
      return this;
   }

   @Override
   public double calculateOffset(Direction var1, Box var2, double var3) {
      return var3;
   }

   @Override
   public boolean c() {
      return false;
   }

   @Override
   public boolean isInside(Box other) {
      return false;
   }

   @Override
   public boolean a() {
      return true;
   }
}
