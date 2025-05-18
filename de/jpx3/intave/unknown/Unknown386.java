package de.jpx3.intave.unknown;

import de.jpx3.intave.access.player.event.AsyncIntaveBukkitActionPermissionEvent;
import de.jpx3.intave.access.player.event.BucketAction;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class Unknown386 implements Unknown192 {
   private final IntavePlugin a;

   @Override
   public boolean a(Player var1, BucketAction var2, Block var3, BlockFace var4, Material var5, ItemStack var6) {
      AsyncIntaveBukkitActionPermissionEvent var10 = (AsyncIntaveBukkitActionPermissionEvent)MoudleLoader.n()
         .a(AsyncIntaveBukkitActionPermissionEvent.class, Unknown386::b);
      return !var10.isCancelled();
   }

   public Unknown386(IntavePlugin var1) {
      this.a = var1;
   }

   private static void b(Player var0, BucketAction var1, Block var2, BlockFace var3, Material var4, ItemStack var5, AsyncIntaveBukkitActionPermissionEvent var6) {
      var6.copy(var0, var1, var2, var3, var4, var5);
   }
}
