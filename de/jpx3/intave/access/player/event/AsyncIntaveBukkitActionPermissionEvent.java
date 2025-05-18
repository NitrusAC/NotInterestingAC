package de.jpx3.intave.access.player.event;

import de.jpx3.intave.access.IntaveEvent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

public final class AsyncIntaveBukkitActionPermissionEvent extends IntaveEvent implements Cancellable {
   private Player e;
   private BucketAction f;
   private Block d;
   private BlockFace b;
   private Material g;
   private ItemStack c;
   private boolean h;

   protected AsyncIntaveBukkitActionPermissionEvent() {
   }

   public void copy(Player var1, BucketAction var2, Block var3, BlockFace var4, Material var5, ItemStack var6) {
      this.e = var1;
      this.f = var2;
      this.d = var3;
      this.b = var4;
      this.g = var5;
      this.c = var6;
      this.h = false;
   }

   public Player player() {
      return this.e;
   }

   public BucketAction bucketAction() {
      return this.f;
   }

   public Block blockClicked() {
      return this.d;
   }

   public BlockFace blockFace() {
      return this.b;
   }

   public Material bucket() {
      return this.g;
   }

   public ItemStack itemInHand() {
      return this.c;
   }

   @Override
   public void referenceInvalidate() {
      this.e = null;
      this.d = null;
   }

   public boolean isCancelled() {
      return this.h;
   }

   public void setCancelled(boolean var1) {
      this.h = var1;
   }

   public static AsyncIntaveBukkitActionPermissionEvent empty() {
      return new AsyncIntaveBukkitActionPermissionEvent();
   }
}
