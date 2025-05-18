package de.jpx3.intave.unknown;

import de.jpx3.intave.access.player.event.AsyncIntaveBlockBreakPermissionEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public final class Unknown310 implements Unknown174 {
   private final IntavePlugin a;

   public Unknown310(IntavePlugin var1) {
      this.a = var1;
   }

   private static void b(Player var0, Block var1, AsyncIntaveBlockBreakPermissionEvent var2) {
      var2.copy(var0, var1);
   }

   @Override
   public boolean a(Player var1, Block var2) {
      AsyncIntaveBlockBreakPermissionEvent var6 = (AsyncIntaveBlockBreakPermissionEvent)MoudleLoader.n()
         .a(AsyncIntaveBlockBreakPermissionEvent.class, Unknown310::b);
      return !var6.isCancelled();
   }
}
