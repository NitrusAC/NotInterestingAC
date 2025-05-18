package de.jpx3.intave.anticheat.check.autoclicker.relative;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.autoclicker.AutoClickerCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import java.util.Collection;
import java.util.Deque;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Relocate
public final class RelativeAutoclickerCheck extends PartialConfigurableCheck {
   private static final int f = 4000;
   private static final int e = 25;

   @PacketListener(
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void handleArmAnimation(PacketEvent event) {
      Player var4 = event.getPlayer();
      PlayerData var5 = this.getPlayerData(var4);
      RelativeAutoclickerStorage var6 = (RelativeAutoclickerStorage)this.getStorage(var5);
      long var7 = RelativeAutoclickerStorage.b(var6);
      long var9 = System.currentTimeMillis() - var7;
      RelativeAutoclickerStorage.a(var6, System.currentTimeMillis());
      Deque var11 = RelativeAutoclickerStorage.c(var6);
      if (this.a(var5, var9)) {
         var11.clear();
      } else {
         var11.offerFirst(var9);
         if (var11.size() >= 25) {
            double var12 = this.getKurtosis(var11) / 1000.0;
            if (var12 < 13.0) {
               if (RelativeAutoclickerStorage.a(var6) > 20.0) {
                  ((AutoClickerCheckGroup)this.getParent())
                     .flag(var4, "low relative variance", "h:" + (int)var12, RelativeAutoclickerStorage.d(var6) > 24.0 ? 5.0 : 2.5);
                  var11.clear();
               }
            } else if (RelativeAutoclickerStorage.d(var6) > 0.0) {
               RelativeAutoclickerStorage.a(var6, RelativeAutoclickerStorage.d(var6) - 0.1);
               RelativeAutoclickerStorage.a(var6, RelativeAutoclickerStorage.d(var6) * 0.98);
            }

            if (!var11.isEmpty()) {
               var11.removeLast();
            }
         }

      }
   }

   private boolean a(PlayerData data, long var2) {
      PlayerHolder var4 = data.getStorage().getPlayerHolder();
      ItemStack var5 = data.getStorage().getItemHolder().getItemInHand();
      return var2 > 4000L || var4.digging || System.currentTimeMillis() - var4.lastDig < 3000L || var5 != null && var5.getType() == Material.FISHING_ROD;
   }

   public RelativeAutoclickerCheck(AutoClickerCheckGroup group) {
      super(group, RelativeAutoclickerStorage.class);
   }

   private double getKurtosis(Collection values) {
      double var2 = 0.0;
      int var4 = 0;

      for(Number var6 : values) {
         var2 += var6.doubleValue();
         ++var4;
      }

      if ((double)var4 < 3.0) {
         return 0.0;
      } else {
         double var17 = (double)var4 * ((double)var4 + 1.0) / (((double)var4 - 1.0) * ((double)var4 - 2.0) * ((double)var4 - 3.0));
         double var7 = 3.0 * Math.pow((double)var4 - 1.0, 2.0) / (((double)var4 - 2.0) * ((double)var4 - 3.0));
         double var9 = var2 / (double)var4;
         double var11 = 0.0;
         double var13 = 0.0;

         for(Number var16 : values) {
            var11 += Math.pow(var9 - var16.doubleValue(), 2.0);
            var13 += Math.pow(var9 - var16.doubleValue(), 4.0);
         }

         return var17 * (var13 / Math.pow(var11 / var2, 2.0)) - var7;
      }
   }
}
