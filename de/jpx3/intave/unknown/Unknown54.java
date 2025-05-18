package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;

// $FF: synthetic class
public class Unknown54 {
   public static final int[] a = new int[Pose.values().length];

   static {
      try {
         a[Pose.c.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[Pose.ELYTRA.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[Pose.SLEEPING.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[Pose.SNEAKING.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
