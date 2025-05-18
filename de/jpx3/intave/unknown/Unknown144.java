package de.jpx3.intave.unknown;

import de.jpx3.intave.access.check.MitigationStrategy;

// $FF: synthetic class
public class Unknown144 {
   public static final int[] a = new int[MitigationStrategy.values().length];

   static {
      try {
         a[MitigationStrategy.AGGRESSIVE.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[MitigationStrategy.CAREFUL.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[MitigationStrategy.LENIENT.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[MitigationStrategy.SILENT.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
