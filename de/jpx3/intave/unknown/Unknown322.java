package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Unknown322 extends UnknownCheck {
   @PacketListener(
      packetTypes = {ClientPacket.UPDATE_SIGN}
   )
   public void c(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      WrappedChatComponent[] var8 = (WrappedChatComponent[])var7.getChatComponentArrays().readSafely(0);
      if (var8 != null) {
         for(WrappedChatComponent var12 : var8) {
            if (var12.getJson().length() > 500) {
               var1.setCancelled(true);
               var6.error("Too many characters in sign update packet");
               return;
            }
         }
      }

   }

   private void a(PlayerData var1, ItemStack var2) {
      ItemHolder var3 = var1.getStorage().getItemHolder();
      String var4 = this.a(var2);
      if (var4 != null) {
         var3.b(var4);
      }

   }

   private String a(ItemStack var1) {
      ItemMeta var2 = var1.getItemMeta();
      return var2 instanceof SkullMeta ? this.a((SkullMeta)var2) : null;
   }

   @PacketListener(
      packetTypes = {ClientPacket.WINDOW_CLICK}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      ItemHolder var7 = var6.getStorage().getItemHolder();
      if (System.currentTimeMillis() - var7.q > 10000L) {
         var7.m = 0;
         var7.q = System.currentTimeMillis();
      }

      PacketContainer var8 = var1.getPacket();
      ItemStack var9 = (ItemStack)var8.getItemModifier().readSafely(0);
      String var10 = this.a(var9);
      if (var10 != null && (var10.length() > 128 || !var7.a(var10))) {
         var7.m = 1000;
         var6.error("Forbidden skull request");
         var1.setCancelled(true);
      }

      if (var7.m++ > 500) {
         var6.error("Too many inventory interactions");
         var1.setCancelled(true);
      }

   }

   @PacketListener(
      g = {ServerPacket.WINDOW_ITEMS, ServerPacket.SET_SLOT}
   )
   public void b(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      ItemStack var8 = (ItemStack)var7.getItemModifier().readSafely(0);
      if (var8 != null) {
         this.a(var6, var8);
      }

      ItemStack[] var9 = (ItemStack[])var7.getItemArrayModifier().readSafely(0);
      if (var9 != null && var9.length != 0) {
         for(ItemStack var13 : var9) {
            if (var13 != null) {
               this.a(var6, var13);
            }
         }
      }

      List var14 = (List)var7.getItemListModifier().readSafely(0);
      if (var14 != null) {
         for(ItemStack var16 : var14) {
            if (var16 != null) {
               this.a(var6, var16);
            }
         }
      }

   }

   private String a(SkullMeta var1) {
      return var1.getOwner();
   }
}
