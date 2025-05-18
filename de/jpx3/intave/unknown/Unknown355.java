package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.DamageHolder;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import java.lang.reflect.Field;
import org.bukkit.entity.Player;

public final class Unknown355 {
   private static boolean a = false;

   public static void a(PlayerData var0) {
      Player var4 = var0.getPlayer();
      DamageHolder var5 = var0.getStorage().getDamageHolder();
      if (var5.g != a(var4)) {
         var5.e = -1;
      } else {
         int var6 = var5.e;
         a(var4, var6);
         var5.e = -1;
      }
   }

   private static int a(int var0, int var1) {
      return Math.max(0, var0 + var1);
   }

   private static void b(PlayerData var0) {
      a(var0);
   }

   public static void a(Player var0, int var1, int var2) {
      if (!a) {
         PlayerData var6 = PlayerDataManager.getPlayerData(var0);
         DamageHolder var7 = var6.getStorage().getDamageHolder();
         if (var7.e == -1) {
            int var8 = a(var0);
            int var9 = a(var8, var2);
            var7.e = var8;
            var7.g = var9;
            a(var0, var9);
            IntaveScheduler.a(Unknown355::b, var1);
         }
      }
   }

   private static int a(Player var0) {
      try {
         Object var3 = Unknown134.b(var0);
         Field var4 = ReflectionUtil.getField("EntityLiving", "maxNoDamageTicks");
         return var4.get(var3);
      } catch (IllegalAccessException var5) {
         var5.printStackTrace();
         Logger.getLogger().severe("Intave has problems accessing an entity field");
         a = true;
         return -1;
      }
   }

   public static void a(Player var0, int var1) {
      try {
         Field var4 = ReflectionUtil.getField("EntityLiving", "maxNoDamageTicks");
         Object var5 = Unknown134.b(var0);
         var4.set(var5, var1);
      } catch (IllegalAccessException var6) {
         var6.printStackTrace();
         Logger.getLogger().severe("Intave has problems accessing an entity field");
         a = true;
      }

   }
}
