package de.jpx3.intave.anticheat.check.autoclicker.spike;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.autoclicker.AutoClickerCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.MathUtil2;
import java.util.Collection;
import java.util.Queue;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Relocate
public final class SpikeAutoclickerCheck extends PartialConfigurableCheck {
   private static final int e = 4000;
   private static final int f = 10;

   private double getSum(Collection values) {
      double var2 = 0.0;

      for(Number var5 : values) {
         var2 += var5.doubleValue();
      }

      return var2;
   }

   private double getStandardDeviation(Collection values) {
      double var2 = 0.0;
      double var4 = 0.0;

      for(Number var7 : values) {
         var2 += var7.doubleValue();
      }

      double var10 = var2 / (double)values.size();

      for(Number var9 : values) {
         var4 += (var9.doubleValue() - var10) * (var9.doubleValue() - var10);
      }

      return Math.sqrt(var4 / (double)values.size());
   }

   private double getTotalDelay(Collection values) {
      return 20.0 / this.getSum(values) * 50.0;
   }

   public SpikeAutoclickerCheck(AutoClickerCheckGroup group) {
      super(group, SpikeAutoclickerStorage.class);
   }

   private boolean isExempt(PlayerData data, long delay) {
      PlayerHolder var4 = data.getStorage().getPlayerHolder();
      ItemStack var5 = data.getStorage().getItemHolder().getItemInHand();
      return delay > 4000L || var4.digging || System.currentTimeMillis() - var4.lastDig < 3000L || var5 != null && var5.getType() == Material.FISHING_ROD;
   }

   @PacketListener(
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void handle(PacketEvent event) {
      Player var4 = event.getPlayer();
      PlayerData var5 = this.getPlayerData(var4);
      SpikeAutoclickerStorage var6 = (SpikeAutoclickerStorage)this.getStorage(var5);
      long var7 = SpikeAutoclickerStorage.getLast(var6);
      long var9 = System.currentTimeMillis() - var7;
      SpikeAutoclickerStorage.setLast(var6, System.currentTimeMillis());
      Queue var11 = SpikeAutoclickerStorage.getQueue(var6);
      if (this.isExempt(var5, var9)) {
         var11.clear();
      } else {
         if (var11.isEmpty()) {
            SpikeAutoclickerStorage.setFirst(var6, System.currentTimeMillis());
         }

         var11.add(var9);
         if (var11.size() >= 10) {
            double var12 = this.getTotalDelay(var11);
            if (SpikeAutoclickerStorage.getLastTotalDelay(var6) > 0.0) {
               double var14 = Math.abs(var12 - SpikeAutoclickerStorage.getLastTotalDelay(var6));
               double var16 = (SpikeAutoclickerStorage.getLastTotalDelay(var6) - var12) / 2.0;
               if (var16 > 9.25 && var14 > 2.8) {
                  if (SpikeAutoclickerStorage.increaseBuffer(var6) > 0.0) {
                     ((AutoClickerCheckGroup)this.getParent())
                        .flag(
                           var4,
                           "spike",
                           "k:" + MathUtil2.getStringRounded(var16, 3) + " f:" + MathUtil2.getStringRounded(var14, 3),
                           SpikeAutoclickerStorage.getBuffer(var6) > 8.0 ? 1.0 : 0.0
                        );
                  }
               } else if (SpikeAutoclickerStorage.getBuffer(var6) > 0.0) {
                  SpikeAutoclickerStorage.setBuffer(var6, SpikeAutoclickerStorage.getBuffer(var6) - 0.2);
                  SpikeAutoclickerStorage.setBuffer(var6, SpikeAutoclickerStorage.getBuffer(var6) * 0.98);
               }
            }

            SpikeAutoclickerStorage.setLastTotalDelay(var6, var12);
            var11.clear();
         }

      }
   }
}
