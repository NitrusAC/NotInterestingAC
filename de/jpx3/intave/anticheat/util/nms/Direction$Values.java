package de.jpx3.intave.anticheat.util.nms;

// $FF: synthetic class
public class Direction$Values {
   public static final int[] values = new int[Direction.values().length];

   static {
      try {
         values[Direction.X.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
      }

      try {
         values[Direction.Y.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
      }

      try {
         values[Direction.Z.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
      }

   }
}
