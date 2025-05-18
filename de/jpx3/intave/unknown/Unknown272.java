package de.jpx3.intave.unknown;

import de.jpx3.intave.access.player.event.AsyncIntaveBlockPlacePermissionEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class Unknown272 implements Unknown388 {
   private final IntavePlugin plugin;

   private static void b(
      Player var0, World var1, boolean var2, int var3, int var4, int var5, int var6, Material var7, int var8, AsyncIntaveBlockPlacePermissionEvent event
   ) {
      event.copy(var0, var1, var2, var3, var4, var5, var6, var7, var8);
   }

   @Override
   public boolean a(Player var1, World var2, boolean var3, int var4, int var5, int var6, int var7, Material var8, int var9) {
      AsyncIntaveBlockPlacePermissionEvent var14 = (AsyncIntaveBlockPlacePermissionEvent)MoudleLoader.n()
         .a(AsyncIntaveBlockPlacePermissionEvent.class, Unknown272::b);
      return !var14.isCancelled();
   }

   public Unknown272(IntavePlugin plugin) {
      this.plugin = plugin;
   }
}
