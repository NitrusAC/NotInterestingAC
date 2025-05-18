package de.jpx3.intave.anticheat.check.place.suspicious;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.place.PlaceCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import java.util.List;
import org.bukkit.entity.Player;

public final class SuspiciousBlockCheck extends PartialConfigurableCheck {
   private static final String g;
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   @PacketListener(
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK}
   )
   public void handleFlying(PacketEvent event) {
      Player var2 = event.getPlayer();
      ((SuspiciousBlockStorage)this.getStorage(var2)).lastFlying = System.currentTimeMillis();
   }

   private double getMean(List values) {
      double var5 = 0.0;

      for(Number var8 : values) {
         var5 += var8.doubleValue();
      }

      return var5 == 0.0 ? 0.0 : var5 / (double)values.size();
   }

   public SuspiciousBlockCheck(PlaceCheckGroup group) {
      super(group, SuspiciousBlockStorage.class);
   }

   @PacketListener(
      packetTypes = {ClientPacket.BLOCK_PLACE}
   )
   public void handleBlockPlace(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      PacketContainer var7 = event.getPacket();
      SuspiciousBlockStorage var8 = (SuspiciousBlockStorage)this.getStorage(var5);
      long var9 = System.currentTimeMillis();
      if (!this.isUse(var7) && !var6.getStorage().getVersionHolder().isNewerVersion()) {
         long var11 = var9 - var8.lastFlying;
         var8.deltas.add(var11);
         if (var8.deltas.size() == 4) {
            double var13 = this.getMean(var8.deltas);
            if (var13 < 20.0) {
               long var15 = var9 - var8.lastFlag;
               if (var15 > 20L) {
                  if (var8.buffer++ >= 2.0) {
                     Violation var17 = Violation.builder(PlaceCheckGroup.class).player(var5).name("suspicious block-placement").vl(2.0).build();
                     ImmutableViolation var18 = MoudleLoader.violations().dispatchViolation(var17);
                     if (var18.j() > 5.0) {
                        ((PlaceCheckGroup)this.getParent()).a(var6, "2");
                     }
                  }

                  var8.lastFlag = var9;
               }
            } else if (var8.buffer >= 0.0) {
               --var8.buffer;
            }

            var8.deltas.clear();
         }

      }
   }

   private boolean isUse(PacketContainer packet) {
      Integer var5 = (Integer)packet.getIntegers().readSafely(0);
      return var5 != null && var5 == 255;
   }
}
