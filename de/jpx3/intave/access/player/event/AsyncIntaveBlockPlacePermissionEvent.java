package de.jpx3.intave.access.player.event;

import de.jpx3.intave.access.IntaveEvent;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public final class AsyncIntaveBlockPlacePermissionEvent extends IntaveEvent implements Cancellable {
   private Player k;
   private World b;
   private boolean c;
   private int e;
   private int i;
   private int d;
   private int f;
   private Material h;
   private int g;
   private boolean j;

   protected AsyncIntaveBlockPlacePermissionEvent() {
   }

   public void copy(Player var1, World var2, boolean var3, int var4, int var5, int var6, int var7, Material var8, int var9) {
      this.k = var1;
      this.b = var2;
      this.c = var3;
      this.e = var4;
      this.i = var5;
      this.d = var6;
      this.f = var7;
      this.h = var8;
      this.g = var9;
      this.j = false;
   }

   public Player player() {
      return this.k;
   }

   public World world() {
      return this.b;
   }

   public boolean isMainHand() {
      return this.c;
   }

   public int blockX() {
      return this.e;
   }

   public int blockY() {
      return this.i;
   }

   public int blockZ() {
      return this.d;
   }

   public int enumDirection() {
      return this.f;
   }

   public Material type() {
      return this.h;
   }

   public int variant() {
      return this.g;
   }

   public boolean isCancelled() {
      return this.j;
   }

   public void setCancelled(boolean var1) {
      this.j = var1;
   }

   @Override
   public void referenceInvalidate() {
      this.k = null;
      this.b = null;
   }

   public static AsyncIntaveBlockPlacePermissionEvent empty() {
      return new AsyncIntaveBlockPlacePermissionEvent();
   }
}
