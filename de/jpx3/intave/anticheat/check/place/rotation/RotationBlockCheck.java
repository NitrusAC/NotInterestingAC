package de.jpx3.intave.anticheat.check.place.rotation;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.place.PlaceCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.violation.Violation;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.util.Vector;

public final class RotationBlockCheck extends PartialConfigurableCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   private boolean isBelowPlayer(PlayerData data, Block block) {
      Vector var6 = block.getLocation().toVector();

      for(Vector var9 : RotationBlockStorage.getPlacedBlocks((RotationBlockStorage)this.getStorage(data))) {
         if (var9.distance(var6) == 0.0) {
            return true;
         }
      }

      return false;
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.POSITION_LOOK, ClientPacket.LOOK}
   )
   public void handleFlying(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      RotationBlockStorage var8 = (RotationBlockStorage)this.getStorage(var6);
      float var9 = Math.min(MathUtil2.distanceBetweenAngles(var7.yaw, var7.lastYaw), 360.0F);
      if (System.currentTimeMillis() - RotationBlockStorage.getLastPlace(var8) <= 2000L && var7.teleportTicks > 5) {
         List var10 = RotationBlockStorage.getDistances(var8);
         if (var10.size() > 100) {
            var10.remove(0);
         }

         var10.add(var9);
      }
   }

   public RotationBlockCheck(PlaceCheckGroup group) {
      super(group, RotationBlockStorage.class);
   }

   @BukkitEventListener
   public void handleBlockPlace(BlockPlaceEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      RotationBlockStorage var7 = (RotationBlockStorage)this.getStorage(var6);
      RotationBlockStorage.setLastPlace(var7, System.currentTimeMillis());
      if (event.getBlock().getY() < var5.getLocation().getBlockY() && this.isBelowPlayer(var6, event.getBlockAgainst())) {
         List var8 = RotationBlockStorage.getDistances(var7);
         double var9 = 0.0;

         for(Float var12 : var8) {
            double var13 = (double)var12.floatValue();
            var9 += var13;
         }

         if (var9 > 3000.0) {
            Violation var15 = Violation.builder(PlaceCheckGroup.class)
               .player(var5)
               .thresholds()
               .name("suspicious block-placement")
               .description("high rotation activity while placing blocks")
               .thresholds()
               .vl(0.0)
               .build();
            MoudleLoader.violations().dispatchViolation(var15);
            event.setCancelled(true);
         }
      }

      if (!event.isCancelled()) {
         if (RotationBlockStorage.getPlacedBlocks(var7).size() > 10) {
            RotationBlockStorage.getPlacedBlocks(var7).remove(0);
         }

         RotationBlockStorage.getPlacedBlocks(var7).add(event.getBlock().getLocation().toVector());
      }
   }
}
