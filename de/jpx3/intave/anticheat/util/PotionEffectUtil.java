package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class PotionEffectUtil {
   public static final PotionEffectType LEVITATION = PotionEffectType.getByName("LEVITATION");
   private static final PotionEffectType DOLPHINS_GRACE = PotionEffectType.getByName("DOLPHINS_GRACE");
   private static final PotionEffectType SLOW_FALLING = PotionEffectType.getByName("SLOW_FALLING");

   public static boolean a(Player player) {
      PlayerData var4 = PlayerDataManager.getPlayerData(player);
      VersionHolder var5 = var4.getStorage().getVersionHolder();
      return DOLPHINS_GRACE != null && var5.getVersionId() >= VersionHolder.V_1_13 ? hasEffect(player, DOLPHINS_GRACE) : false;
   }

   public static int getAmplifier(Player player, PotionEffectType potionEffectType) {
      for(PotionEffect var6 : player.getActivePotionEffects()) {
         if (var6.getType().equals(potionEffectType)) {
            return var6.getAmplifier();
         }
      }

      return 0;
   }

   public static boolean hasEffect(Player player, PotionEffectType potionEffectType) {
      for(PotionEffect var6 : player.getActivePotionEffects()) {
         if (var6.getType().equals(potionEffectType)) {
            return true;
         }
      }

      return false;
   }

   public static boolean c(Player player) {
      PlayerData var4 = PlayerDataManager.getPlayerData(player);
      VersionHolder var5 = var4.getStorage().getVersionHolder();
      return SLOW_FALLING != null && var5.getVersionId() >= 393 ? hasEffect(player, SLOW_FALLING) : false;
   }

   public static boolean b(Player player) {
      PlayerData var4 = PlayerDataManager.getPlayerData(player);
      VersionHolder var5 = var4.getStorage().getVersionHolder();
      return LEVITATION != null && var5.getVersionId() >= 107 ? hasEffect(player, LEVITATION) : false;
   }
}
