package de.jpx3.intave.anticheat.check.heuristic.rounded;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class RoundedHeuristicCheck extends PartialConfigurableCheck {
   private final IntavePlugin plugin = IntavePlugin.getInstance();

   private static int digitsAfterComma(float value) {
      String var1 = Float.toString(value);
      var1 = var1.substring(var1.indexOf(".") + 1);
      return var1.length();
   }

   public RoundedHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, RoundedHeuristicStorage.class);
   }

   @PacketListener(
      packetTypes = {ClientPacket.LOOK, ClientPacket.POSITION_LOOK}
   )
   public void handle(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      RoundedHeuristicStorage var7 = (RoundedHeuristicStorage)this.getStorage(var6);
      PlayerHolder var8 = var6.getStorage().getPlayerHolder();
      BukkitEnginePlayer var9 = var6.getStorage().getPhysicsHolder();
      float var10 = var9.yaw;
      float var11 = var9.pitch;
      float var12 = Math.abs(var10 - var9.lastYaw);
      float var13 = Math.abs(var11 - var9.lastPitch);
      if (var9.teleportTicks >= 20) {
         if (var13 > 0.0F && var12 > 0.0F && var6.getStorage().getPlayerHolder().hasAttacked(16000L)) {
            int var14 = digitsAfterComma(var10);
            int var15 = digitsAfterComma(var11);
            if (var14 <= 3 && var15 <= 2) {
               RoundedHeuristicStorage.setDecimalBuffer(var7, RoundedHeuristicStorage.getDecimalBuffer(var7) + 4);
               if (RoundedHeuristicStorage.getDecimalBuffer(var7) > 80) {
                  RoundedHeuristicStorage.setDecimalBuffer(var7, 0);
                  ((HeuristicCheckGroup)this.getParent())
                     .logAnomaly(var5, Anomaly.of("111", Certainty.MAYBE, CombatCheckType.KILLAURA, "rotations have too few decimals", 82));
                  var6.a(Unknown227.HT_MEDIUM, "21");
               }
            } else if (RoundedHeuristicStorage.getDecimalBuffer(var7) > 0) {
               RoundedHeuristicStorage.decreaseDecimalBuffer(var7);
            }

            var14 = digitsAfterComma(var12);
            var15 = digitsAfterComma(var13);
            if (var14 < 3 && var15 < 3) {
               RoundedHeuristicStorage.setDigitsBuffer(var7, RoundedHeuristicStorage.getDigitsBuffer(var7) + 50);
               RoundedHeuristicStorage.setDigitsBuffer(var7, Math.min(RoundedHeuristicStorage.getDigitsBuffer(var7), 1000));
               if (RoundedHeuristicStorage.increaseDigitsBuffer(var7) > 200) {
                  double var16 = (double)RoundedHeuristicStorage.getDigitsBuffer(var7) / 200.0;
                  Anomaly var18 = Anomaly.of("113", Certainty.NONE, CombatCheckType.KILLAURA, "rotations have too few decimals, vl:" + var16, 82);
                  ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var18);
               }
            } else if (RoundedHeuristicStorage.getDigitsBuffer(var7) > 0) {
               RoundedHeuristicStorage.decreaseDigitsBuffer(var7);
            }
         }

         if (var8.hasAttacked(200L)) {
            this.evaluate(var5, var6);
         }

      }
   }

   private void evaluate(Player player, PlayerData data) {
      RoundedHeuristicStorage var6 = (RoundedHeuristicStorage)this.getStorage(data);
      BukkitEnginePlayer var7 = data.getStorage().getPhysicsHolder();
      float var8 = Math.abs(var7.pitch - var7.lastPitch);
      float var9 = RoundedHeuristicStorage.getLastPitchDelta(var6);
      if (var9 == 0.0F) {
         var9 = var8;
      }

      double var10 = (double)var9;
      double var12 = (double)var8;
      int var16 = 100;

      double var14;
      while((var14 = var10 % var12) > Math.max(var10, var12) * 0.001) {
         var10 = var12;
         var12 = var14;
         if (var16-- < 0) {
            break;
         }
      }

      float var17 = (float)var12;
      double var18 = (double)Math.abs(var17 - var9);
      RoundedHeuristicStorage.setLastPitchDelta(var6, var17);
      if (var18 > 0.001) {
         if ((double)var8 > 1.0) {
            RoundedHeuristicStorage.b(var6, RoundedHeuristicStorage.d(var6) + (var8 > 5.0F ? 10 : 5));
         }

         if ((int)Math.round((double)RoundedHeuristicStorage.d(var6) / 2.0) % 50 == 0 && RoundedHeuristicStorage.d(var6) > 0) {
            ((HeuristicCheckGroup)this.getParent())
               .logAnomaly(
                  player,
                  Anomaly.of(
                     "112",
                     RoundedHeuristicStorage.d(var6) >= 400 ? Certainty.PROBABLE : Certainty.NONE,
                     CombatCheckType.KILLAURA,
                     "rotations are out of sync (gcd vl:" + RoundedHeuristicStorage.d(var6) + ")",
                     18
                  )
               );
            if (RoundedHeuristicStorage.d(var6) > 300) {
               data.a(Unknown227.HT_MEDIUM, "22");
               RoundedHeuristicStorage.b(var6, 300);
            }
         }
      } else if (RoundedHeuristicStorage.d(var6) > 0) {
         RoundedHeuristicStorage.a(var6);
      }

   }
}
