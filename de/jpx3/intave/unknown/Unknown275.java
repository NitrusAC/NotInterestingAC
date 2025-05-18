package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.packet.wrap.modal.EntityAction;
import de.jpx3.intave.anticheat.util.nms.Direction;

// $FF: synthetic class
class Unknown275 {
   static final int[] b;
   static final int[] a = new int[Direction.values().length];

   static {
      try {
         a[Direction.X.ordinal()] = 1;
      } catch (NoSuchFieldError var10) {
      }

      try {
         a[Direction.Y.ordinal()] = 2;
      } catch (NoSuchFieldError var9) {
      }

      try {
         a[Direction.Z.ordinal()] = 3;
      } catch (NoSuchFieldError var8) {
      }

      b = new int[EntityAction.values().length];

      try {
         b[EntityAction.START_SPRINTING.ordinal()] = 1;
      } catch (NoSuchFieldError var7) {
      }

      try {
         b[EntityAction.STOP_SPRINTING.ordinal()] = 2;
      } catch (NoSuchFieldError var6) {
      }

      try {
         b[EntityAction.PRESS_SHIFT_KEY.ordinal()] = 3;
      } catch (NoSuchFieldError var5) {
      }

      try {
         b[EntityAction.START_SNEAKING.ordinal()] = 4;
      } catch (NoSuchFieldError var4) {
      }

      try {
         b[EntityAction.RELEASE_SHIFT_KEY.ordinal()] = 5;
      } catch (NoSuchFieldError var3) {
      }

      try {
         b[EntityAction.STOP_NSEAKING.ordinal()] = 6;
      } catch (NoSuchFieldError var2) {
      }

      try {
         b[EntityAction.START_FALL_FLYING.ordinal()] = 7;
      } catch (NoSuchFieldError var1) {
      }

   }
}
