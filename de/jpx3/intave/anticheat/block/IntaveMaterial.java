package de.jpx3.intave.anticheat.block;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import de.jpx3.intave.unknown.Unknown150;
import de.jpx3.intave.unknown.Unknown402;
import de.jpx3.intave.unknown.Unknown410;
import de.jpx3.intave.unknown.Unknown6;
import de.jpx3.intave.unknown.Unknown83;
import de.jpx3.intave.unknown.what.What1;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@Relocate
public final class IntaveMaterial {
   private static final Unknown150 g = new Unknown6();
   public static final Material END_PORTAL = add(new String[]{"END_PORTAL_FRAME", "ENDER_PORTAL_FRAME"});
   public static final Material TRAP_DOOR = add(new String[]{"TRAP_DOOR", "LEGACY_TRAP_DOOR"});
   public static final Material SNOW = add(new String[]{"SNOW", "SNOW_LAYER"});
   public static final Material SKULL = add(new String[]{"SKULL", "LEGACY_SKULL"});
   public static final Material PORTAL = add(new String[]{"PORTAL", "NETHER_PORTAL"});
   private static final HTTPRequest b = Unknown83.a("https:..service.intave.de.bbm." + IntavePlugin.m(), "bbm", TimeUnit.DAYS.toMillis(14L));
   private static final Unknown402 e = (Unknown402)g.a(b);
   public static final Material WEB = add(new String[]{"COBWEB", "WEB"});

   @Deprecated
   public static Material parse(org.bukkit.block.Block var0, Player var1) {
      return var1 == null ? from(var0) : a(PlayerDataManager.getPlayerData(var1), from(var0));
   }

   private static Material add(String[] var0) {
      for(String var6 : var0) {
         Material var7 = Material.getMaterial(var6);
         if (var7 != null) {
            return var7;
         }

         var7 = Material.getMaterial("LEGACY_" + var6);
         if (var7 != null) {
            return var7;
         }
      }

      throw new IntaveInternalException("Unable to find block for " + Arrays.toString(var0));
   }

   @Deprecated
   public static Material from(org.bukkit.block.Block var0) {
      Material var1;
      try {
         What1.q.h();
         var1 = Unknown410.b().b(var0);
      } finally {
         What1.q.g();
      }

      return var1;
   }

   public static void a(PlayerData var0) {
      MinecraftVersion var1 = MinecraftVersion.getCurrentVersion();
      MinecraftVersion var2 = var0.getStorage().getVersionHolder().getVersion();
      var0.x();
      e.a(var1, var2).b().forEach(var0::a);
   }

   public static void a() {
   }

   private static Material a(PlayerData var0, Material var1) {
      Material var2 = var0.a(var1);
      return var2 == null ? var1 : var2;
   }

   public static boolean b(PlayerData var0, Material var1) {
      return var0.a(var1) != null;
   }
}
