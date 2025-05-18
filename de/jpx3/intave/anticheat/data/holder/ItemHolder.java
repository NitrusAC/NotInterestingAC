package de.jpx3.intave.anticheat.data.holder;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.k3;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.EnchantUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.unknown.Unknown159;
import de.jpx3.intave.unknown.Unknown279;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Relocate
public final class ItemHolder {
   public int l;
   private final List k = new ArrayList();
   public boolean o;
   public Unknown279 f;
   public int p;
   private boolean j;
   private boolean n;
   private int heldItemSlot;
   public int b;
   public int g;
   private final Player player;
   public long q;
   public Material materialInHand;
   public boolean r;
   private Material material;
   private boolean h;
   public boolean d;
   public int m;

   public void b(boolean var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(this.player);
      VersionHolder var3 = var2.getStorage().getVersionHolder();
      if (!var1 && var3.isSub_1_11_1()) {
         this.d = true;
      }

      this.resetItem();
      this.n = var1;
   }

   @k3
   public ItemStack getItemInOffHand() {
      if (!MinecraftVersion.V_1_9.atOrAbove()) {
         return null;
      } else {
         return this.player == null ? null : this.player.getInventory().getItemInOffHand();
      }
   }

   public boolean b() {
      return this.j;
   }

   public boolean a(String var1) {
      return this.k.contains(var1);
   }

   public void setHeldItemSlot(int slot) {
      this.heldItemSlot = slot;
   }

   public void e() {
      this.h = true;
      this.j = Unknown159.b(this.player, this.getMaterialInHand());
      this.b = 0;
      this.p = 0;
      this.material = this.getMaterialInHand();
   }

   public ItemHolder(Player player) {
      this.l = 100;
      this.d = true;
      this.o = false;
      this.r = false;
      this.materialInHand = Material.AIR;
      this.player = player;
      if (player != null) {
         this.heldItemSlot = player.getInventory().getHeldItemSlot();
      }

      this.material = Material.AIR;
   }

   public boolean h() {
      return this.h;
   }

   public Material getMaterial() {
      return this.material;
   }

   @k3
   public ItemStack getItemInHand() {
      return this.player == null ? null : this.player.getInventory().getItem(this.heldItemSlot);
   }

   public int getHeldItemSlot() {
      return this.heldItemSlot;
   }

   public void resetItem() {
      PlayerData var1 = PlayerDataManager.getPlayerData(this.player);
      BukkitEnginePlayer var2 = var1.getStorage().getPhysicsHolder();
      ItemStack var3 = this.getItemInHand();
      if (var3 != null && EnchantUtil.hasRiptide(var3)) {
         var2.iteratedTick = 0;
      }

      this.h = false;
      this.b = 0;
      this.p = 0;
      this.material = Material.AIR;
   }

   public boolean j() {
      return this.n;
   }

   public void a(boolean var1) {
      this.h = var1;
   }

   public void g() {
      this.r = true;
      this.materialInHand = this.getMaterialInHand();
   }

   @k3
   public Material getMaterialInOffHand() {
      ItemStack var1 = this.getItemInOffHand();
      return var1 == null ? null : var1.getType();
   }

   public void b(String var1) {
      if (!this.k.contains(var1)) {
         this.k.add(var1);
      }

   }

   public Material getMaterialInHand() {
      ItemStack var1 = this.getItemInHand();
      return var1 != null && var1.getAmount() != 0 ? var1.getType() : Material.AIR;
   }
}
