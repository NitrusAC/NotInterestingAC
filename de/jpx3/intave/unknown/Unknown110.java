package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;

// $FF: synthetic class
public class Unknown110 {
   public static final int[] a = new int[IntaveListenerPriority.values().length];

   static {
      try {
         a[IntaveListenerPriority.LOWEST.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
      }

      try {
         a[IntaveListenerPriority.LOW.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
      }

      try {
         a[IntaveListenerPriority.NORMAL.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[IntaveListenerPriority.HIGH.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[IntaveListenerPriority.HIGHEST.ordinal()] = 5;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[IntaveListenerPriority.MONITOR.ordinal()] = 6;
      } catch (NoSuchFieldError var1) {
      }

   }
}
