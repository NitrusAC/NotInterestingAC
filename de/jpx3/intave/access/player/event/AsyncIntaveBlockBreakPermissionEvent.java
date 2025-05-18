package de.jpx3.intave.access.player.event;

import de.jpx3.intave.access.IntaveEvent;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public final class AsyncIntaveBlockBreakPermissionEvent extends IntaveEvent implements Cancellable {
   private Player player;
   private Block block;
   private boolean cancelled;

   private AsyncIntaveBlockBreakPermissionEvent() {
   }

   public Player player() {
      return this.player;
   }

   public Block block() {
      return this.block;
   }

   public void copy(Player var1, Block var2) {
      this.player = var1;
      this.block = var2;
      this.cancelled = false;
   }

   @Override
   public void referenceInvalidate() {
      this.player = null;
      this.block = null;
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCancelled(boolean var1) {
      this.cancelled = var1;
   }

   public static AsyncIntaveBlockBreakPermissionEvent empty() {
      return new AsyncIntaveBlockBreakPermissionEvent();
   }
}
