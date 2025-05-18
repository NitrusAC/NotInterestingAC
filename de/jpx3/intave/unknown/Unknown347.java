package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;

// $FF: synthetic class
class Unknown347 {
   static final int[] a = new int[PlayerDigType.values().length];

   static {
      try {
         a[PlayerDigType.RELEASE_USE_ITEM.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[PlayerDigType.DROP_ALL_ITEMS.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[PlayerDigType.DROP_ITEM.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
      }

   }
}
