package de.jpx3.intave.unknown;

import org.bukkit.Material;

// $FF: synthetic class
public class Unknown104 {
   public static final int[] a = new int[Material.values().length];

   static {
      try {
         a[Material.AIR.ordinal()] = 1;
      } catch (NoSuchFieldError var5) {
      }

      try {
         a[Material.SIGN.ordinal()] = 2;
      } catch (NoSuchFieldError var4) {
      }

      try {
         a[Material.SIGN_POST.ordinal()] = 3;
      } catch (NoSuchFieldError var3) {
      }

      try {
         a[Material.WALL_SIGN.ordinal()] = 4;
      } catch (NoSuchFieldError var2) {
      }

      try {
         a[Material.LEVER.ordinal()] = 5;
      } catch (NoSuchFieldError var1) {
      }

   }
}
