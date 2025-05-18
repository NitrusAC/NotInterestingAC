package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;

// $FF: synthetic class
public class Unknown81 {
   public static final int[] a = new int[PlayerDigType.values().length];

   static {
      try {
         a[PlayerDigType.START_DESTROY_BLOCK.ordinal()] = 1;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[PlayerDigType.STOP_DESTROY_BLOCK.ordinal()] = 2;
      } catch (NoSuchFieldError var1) {
      }

   }
}
