package de.jpx3.intave.anticheat.util;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class EnchantUtil {
   private static final Enchantment soulSpeedEnchant = Enchantment.getByName("SOUL_SPEED");
   public static final Enchantment riptideEnchant = Enchantment.getByName("RIPTIDE");
   private static final Enchantment depthStriderEnchant = Enchantment.getByName("DEPTH_STRIDER");

   private static int getEnchantLevel(Enchantment var0, ItemStack[] var1) {
      if (var1 != null && var1.length != 0) {
         int var5 = 0;

         for(ItemStack var9 : var1) {
            if (var9 != null) {
               int var10 = var9.getEnchantmentLevel(var0);
               if (var10 > var5) {
                  var5 = var10;
               }
            }
         }

         return var5;
      } else {
         return 0;
      }
   }

   public static int getRiptideLevel(ItemStack var0) {
      return riptideEnchant == null ? 0 : getEnchantLevelInternal(riptideEnchant, var0);
   }

   public static float getBootDepthStrider(Player var0) {
      return depthStriderEnchant == null ? 0.0F : (float)getEnchantLevel(depthStriderEnchant, var0.getInventory().getArmorContents());
   }

   private static int getEnchantLevelInternal(Enchantment var0, ItemStack var1) {
      return var1.getEnchantmentLevel(var0);
   }

   public static int getBootSoulSpeed(Player var0) {
      ItemStack var1 = var0.getInventory().getBoots();
      return soulSpeedEnchant != null && var1 != null ? getEnchantLevelInternal(soulSpeedEnchant, var1) : 0;
   }

   public static boolean hasRiptide(ItemStack var0) {
      return var0.getEnchantments().containsKey(riptideEnchant);
   }
}
