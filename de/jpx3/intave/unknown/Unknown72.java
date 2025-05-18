package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.block.height.Heightable;
import de.jpx3.intave.anticheat.engine.block.height.impl.CarpetHeightable;
import de.jpx3.intave.anticheat.engine.block.height.impl.ScaffoldingHeightable;
import de.jpx3.intave.anticheat.engine.block.height.impl.ShulkerHeightable;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Material;

public final class Unknown72 {
   private static final String c;
   private static final Map a = new ConcurrentHashMap();

   public static boolean a(Material var0) {
      return a.containsKey(var0);
   }

   public static void a() {
      a(ScaffoldingHeightable.class);
      a(CarpetHeightable.class);
      a(ShulkerHeightable.class);
   }

   public static Boxable a(Material var0, PlayerData var1, Box var2, int var3, int var4, int var5, Boxable var6) {
      return ((Heightable)a.get(var0)).collide(var1, var2, var3, var4, var5, var6);
   }

   private static void a(Class var0) {
      Heightable var4;
      try {
         var4 = (Heightable)var0.newInstance();
      } catch (IllegalAccessException | Error | InstantiationException var9) {
         throw new IllegalStateException("Unable to load collision modifier " + var0, var9);
      }

      for(Material var8 : Material.values()) {
         if (var4.isMaterial(var8)) {
            a.put(var8, var4);
         }
      }

   }
}
