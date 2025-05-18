package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.IntaveState;

// $FF: synthetic class
class Unknown366 {
   static final int[] a = new int[IntaveState.values().length];

   static {
      try {
         a[IntaveState.LATEST.ordinal()] = 1;
      } catch (NoSuchFieldError var5) {
      }

      try {
         a[IntaveState.STABLE.ordinal()] = 2;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[IntaveState.OUTDATED.ordinal()] = 3;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[IntaveState.DISABLED.ordinal()] = 4;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[IntaveState.e.ordinal()] = 5;
      } catch (NoSuchFieldError var1) {
      }

   }
}
