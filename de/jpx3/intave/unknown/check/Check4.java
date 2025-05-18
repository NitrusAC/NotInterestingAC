package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.unknown.Unknown254;
import java.util.Collections;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public final class Check4 extends Unknown254 {
   private final IntavePlugin d;

   @PacketListener(
      g = {ServerPacket.ENTITY_EQUIPMENT}
   )
   public void a(PacketEvent var1) {
      PacketContainer var2 = var1.getPacket();
   }

   public Check4(IntavePlugin var1) {
      super("equipmentdata");
      this.d = var1;
   }

   private ItemStack a(ItemStack var1) {
      var1.setAmount(1);
      var1.setDurability((short)1337);
      if (var1.hasItemMeta()) {
         ItemMeta var5 = var1.getItemMeta();
         if (var5.hasEnchants()) {
            for(Enchantment var7 : var1.getEnchantments().keySet()) {
               var1.removeEnchantment(var7);
            }

            var1.addUnsafeEnchantment(Enchantment.LURE, 1);
         }

         if (var5 instanceof BookMeta) {
            BookMeta var11 = (BookMeta)var5;
            var11.setTitle(null);
            var11.setPages(Collections.emptyList());
            var11.setAuthor(null);
         } else if (!(var5 instanceof EnchantmentStorageMeta)) {
            if (var5 instanceof FireworkEffectMeta) {
               ((FireworkEffectMeta)var5).setEffect(null);
            } else if (var5 instanceof FireworkMeta) {
               FireworkMeta var10 = (FireworkMeta)var5;
               var10.clearEffects();
               var10.setPower(0);
            }
         } else {
            EnchantmentStorageMeta var9 = (EnchantmentStorageMeta)var5;
            if (var9.hasStoredEnchants()) {
               for(Enchantment var8 : var9.getStoredEnchants().keySet()) {
                  var9.removeStoredEnchant(var8);
               }

               var9.addStoredEnchant(Enchantment.THORNS, 1, true);
            }
         }

         var5.setDisplayName("Intave");
         var5.setLore(Collections.singletonList("Intave"));
         var5.removeItemFlags((ItemFlag[])var5.getItemFlags().toArray(new ItemFlag[0]));
      }

      return var1;
   }

   @Override
   protected boolean c() {
      return false;
   }
}
