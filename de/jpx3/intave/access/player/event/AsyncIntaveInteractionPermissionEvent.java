package de.jpx3.intave.access.player.event;

import de.jpx3.intave.access.IntaveEvent;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public final class AsyncIntaveInteractionPermissionEvent extends IntaveEvent implements Cancellable {
   private Player b;
   private Action g;
   private ItemStack d;
   private Block f;
   private BlockFace e;
   private boolean c;

   private AsyncIntaveInteractionPermissionEvent() {
   }

   public void copy(Player var1, Action var2, ItemStack var3, Block var4, BlockFace var5) {
      this.b = var1;
      this.g = var2;
      this.d = var3;
      this.f = var4;
      this.e = var5;
      this.c = false;
   }

   public Player player() {
      return this.b;
   }

   public Action action() {
      return this.g;
   }

   public ItemStack itemStack() {
      return this.d;
   }

   public Block block() {
      return this.f;
   }

   public BlockFace blockFace() {
      return this.e;
   }

   public boolean isCancelled() {
      return this.c;
   }

   public void setCancelled(boolean var1) {
      this.c = var1;
   }

   @Override
   public void referenceInvalidate() {
      this.b = null;
      this.f = null;
   }

   public static AsyncIntaveInteractionPermissionEvent empty() {
      return new AsyncIntaveInteractionPermissionEvent();
   }
}
