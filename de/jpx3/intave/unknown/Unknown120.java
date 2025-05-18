package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.packet.wrap.modal.EntityAction;

// $FF: synthetic class
public class Unknown120 {
   public static final int[] a = new int[EntityAction.values().length];

   static {
      try {
         a[EntityAction.STOP_NSEAKING.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[EntityAction.START_SNEAKING.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[EntityAction.PRESS_SHIFT_KEY.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[EntityAction.RELEASE_SHIFT_KEY.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
