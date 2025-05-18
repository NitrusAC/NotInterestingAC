package de.jpx3.intave.anticheat.check.autoclicker.invariant;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.autoclicker.AutoClickerCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.MathUtil2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Relocate
public final class InvariantAutoclickerCheck extends PartialConfigurableCheck {
   private static final int e = 50;
   private static final int g = 4000;
   private static final double f = -0.01;

   @PacketListener(
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void handle(PacketEvent event) {
      Player var4 = event.getPlayer();
      PlayerData var5 = this.getPlayerData(var4);
      InvariantAutoclickerStorage var6 = (InvariantAutoclickerStorage)this.getStorage(var5);
      long var7 = InvariantAutoclickerStorage.getLastTime(var6);
      long var9 = System.currentTimeMillis() - var7;
      InvariantAutoclickerStorage.setTime(var6, System.currentTimeMillis());
      Queue var11 = InvariantAutoclickerStorage.getClickQueue(var6);
      if (this.isExempt(var5, var9)) {
         var11.clear();
      } else {
         if (var11.isEmpty()) {
            InvariantAutoclickerStorage.setFirstTime(var6, System.currentTimeMillis());
         }

         var11.add(var9);
         if (var11.size() >= 50) {
            long var12 = System.currentTimeMillis() - InvariantAutoclickerStorage.getFirstTime(var6);
            double var14 = this.getSkewness(var11);
            if (var14 < -0.01 && var12 < 6000L) {
               int var16 = Math.abs(var14) < 0.1 ? 2 : 1;
               InvariantAutoclickerStorage.setSkewTotal(var6, InvariantAutoclickerStorage.getSkewTotal(var6) + (double)var16);
               if (InvariantAutoclickerStorage.getSkewTotal(var6) > 4.0) {
                  ((AutoClickerCheckGroup)this.getParent())
                     .flag(var4, "invariant", "s:" + MathUtil2.getStringRounded(var14, 3) + " t:" + MathUtil2.getStringRounded((double)var12 / 1000.0, 2), 0.0);
               }
            } else if (InvariantAutoclickerStorage.getSkewTotal(var6) > 0.0) {
               InvariantAutoclickerStorage.setSkewTotal(var6, InvariantAutoclickerStorage.getSkewTotal(var6) - 0.2);
               InvariantAutoclickerStorage.setSkewTotal(var6, InvariantAutoclickerStorage.getSkewTotal(var6) * 0.98);
            }

            var11.clear();
         }

      }
   }

   public InvariantAutoclickerCheck(AutoClickerCheckGroup group) {
      super(group, InvariantAutoclickerStorage.class);
   }

   private double getSkewness(Collection values) {
      double var2 = 0.0;
      int var4 = 0;
      ArrayList var5 = new ArrayList();

      for(Number var7 : values) {
         double var8 = var7.doubleValue();
         var2 += var8;
         ++var4;
         var5.add(var8);
      }

      if (var4 == 0) {
         return 0.0;
      } else {
         var5.sort(Double::compareTo);
         double var12 = var2 / (double)var4;
         double var13 = var5.get((var4 % 2 != 0 ? var4 : var4 - 1) / 2);
         double var10 = this.getStandardVariation(var5);
         return 3.0 * (var12 - var13) / var10;
      }
   }

   private double getStandardVariation(Collection values) {
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
}
