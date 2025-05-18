package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.unknown.Unknown167;
import org.bukkit.Material;

public final class MaterialUtil {
   private static final Material STATIONARY_LAVA = Material.getMaterial("STATIONARY_LAVA");
   private static final Material STATIONARY_WATER = Material.getMaterial("STATIONARY_WATER");

   public static boolean isLiquid(Material var0) {
      return isLava(var0) || isWater(var0);
   }

   public static boolean canBeInsideBB(Material var0) {
      if (isLiquid(var0)) {
         return false;
      } else if (var0 == IntaveMaterial.WEB) {
         return false;
      } else {
         return !isWeirdBlock(var0) && !isTraversable(var0);
      }
   }

   public static boolean canTraverse(Material var0) {
      if (!isLiquid(var0) && !var0.isTransparent()) {
         return !isWeirdBlock(var0) && !isTraversable(var0);
      } else {
         return false;
      }
   }

   private static boolean isTraversable(Material var0) {
      switch(Unknown167.a[var0.ordinal()]) {
         case 25:
         case 26:
            return true;
         default:
            return false;
      }
   }

   public static boolean isLava(Material material) {
      return STATIONARY_LAVA != null && material == STATIONARY_LAVA || material == Material.LAVA;
   }

   public static boolean isWater(Material material) {
      return STATIONARY_WATER != null && material == STATIONARY_WATER || material == Material.WATER;
   }

   private static boolean isWeirdBlock(Material material) {
      switch(Unknown167.a[material.ordinal()]) {
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
            return true;
         default:
            return false;
      }
   }
}
