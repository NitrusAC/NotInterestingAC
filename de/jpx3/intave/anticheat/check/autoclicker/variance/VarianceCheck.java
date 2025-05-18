package de.jpx3.intave.anticheat.check.autoclicker.variance;

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
public final class VarianceCheck extends PartialConfigurableCheck {
   private static final int f = 50;
   private static final int e = 4000;

   public VarianceCheck(AutoClickerCheckGroup group) {
      super(group, VarianceStorage.class);
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
      VarianceStorage var6 = (VarianceStorage)this.getStorage(var5);
      long var7 = VarianceStorage.getLastTime(var6);
      long var9 = System.currentTimeMillis() - var7;
      VarianceStorage.setLastTime(var6, System.currentTimeMillis());
      Queue var11 = VarianceStorage.getQueue(var6);
      if (this.isExempt(var5, var9)) {
         var11.clear();
      } else {
         if (var11.isEmpty()) {
            VarianceStorage.setFirstTime(var6, System.currentTimeMillis());
         }

         var11.add(var9);
         if (var11.size() >= 50) {
            long var12 = System.currentTimeMillis() - VarianceStorage.getFirstTime(var6);
            double var14 = this.getStandardDeviation(var11);
            if (var14 < 166.0 && var12 < 4000L) {
               int var16 = var14 < 10.0 ? 2 : 1;
               VarianceStorage.setVariance(var6, VarianceStorage.getVariance(var6) + (double)var16);
               if (VarianceStorage.getVariance(var6) > 4.0) {
                  ((AutoClickerCheckGroup)this.getParent())
                     .flag(
                        var4,
                        "low variance",
                        "sd:" + MathUtil2.getStringRounded(var14, 3) + " t:" + MathUtil2.getStringRounded((double)var12 / 1000.0, 2),
                        VarianceStorage.getVariance(var6) > 8.0 ? 7.5 : 0.0
                     );
               }
            } else if (VarianceStorage.getVariance(var6) > 0.0) {
               VarianceStorage.setVariance(var6, VarianceStorage.getVariance(var6) - 0.2);
               VarianceStorage.setVariance(var6, VarianceStorage.getVariance(var6) * 0.98);
            }

            var11.clear();
         }

      }
   }
}
