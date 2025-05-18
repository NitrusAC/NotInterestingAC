package de.jpx3.intave.anticheat.check.place.time;

import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.a1;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.place.PlaceCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.PotionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BlockTimeCheck extends PartialConfigurableCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();
   private static final int h = 8;
   private static final int g = 5;

   public BlockTimeCheck(PlaceCheckGroup group) {
      super(group, a1.class);
   }

   @BukkitEventListener
   public void handle(BlockPlaceEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      a1 var7 = (a1)this.getStorage(var6);
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      PotionHolder var9 = var6.getStorage().getPotionHolder();
      Block var10 = event.getBlockPlaced();
      Block var11 = event.getBlockAgainst();
      if (this.isInsideBlock(var10, var5) && this.getBlockPush(var10) < 2) {
         List var12 = a1.b(var7);
         if (var12.size() >= 8) {
            var12.remove(0);
         }

         if (var10.getY() == var11.getY()) {
            var12.add(System.currentTimeMillis() - a1.a(var7));
            a1.a(var7, System.currentTimeMillis());
         } else {
            var12.add(System.currentTimeMillis() - a1.a(var7) + 1000L);
         }

         if (var12.size() >= 8) {
            double var13 = var12.stream().mapToDouble(BlockTimeCheck::toLong).average().orElse(500.0);
            boolean var15 = this.a(a1.c(var7));
            boolean var16 = System.currentTimeMillis() - a1.d(var7) > 8000L;
            boolean var17 = System.currentTimeMillis() - var8.af > 8000L;
            boolean var18 = System.currentTimeMillis() - var8.n < 750L;
            double var19 = (double)(var15 ? (var18 ? 450 : (var16 ? (var17 ? 500 : 300) : (var17 ? 350 : 200))) : 150);
            int var21 = var9.getSpeedAmplifier();
            var19 /= 0.15 * (double)var21 * (double)var21 + 1.0;
            if (var13 < var19) {
               Violation var22 = Violation.builder(PlaceCheckGroup.class)
                  .player(var5)
                  .thresholds()
                  .name("suspicious block-placement")
                  .description((int)var13 + "ms/block, limit at " + (int)var19 + "ms/block")
                  .thresholds()
                  .vl(var13 > 400.0 ? 3.0 : (var13 < 300.0 ? 5.0 : 4.0))
                  .build();
               ImmutableViolation var23 = MoudleLoader.violations().dispatchViolation(var22);
               if (var23.j() > 20.0) {
                  ((PlaceCheckGroup)this.getParent()).a(var6, "1");
               }
            }
         }
      }

      if (!event.isCancelled()) {
         List var24 = a1.c(var7);
         if (var24.size() >= 5) {
            var24.remove(0);
         }

         var24.add(var10.getLocation());
      }

   }

   private boolean isInsideBlock(Block block, Player player) {
      return block.getLocation().clone().add(0.0, 1.0, 0.0).distance(player.getLocation()) < 1.3;
   }

   private boolean a(List var1) {
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = true;

      for(Location var12 : var1) {
         if (!var10) {
            if ((double)var6 != var12.getY()) {
               return false;
            }

            if ((double)var5 == var12.getX()) {
               var8 = true;
            } else if (var8) {
               return false;
            }

            if ((double)var7 == var12.getZ()) {
               var9 = true;
            } else if (var9) {
               return false;
            }
         }

         var5 = var12.getBlockX();
         var6 = var12.getBlockY();
         var7 = var12.getBlockZ();
         var10 = false;
      }

      return var8 || var9;
   }

   private int getBlockPush(Block block) {
      int var5 = 0;
      if (!block.getRelative(BlockFace.SOUTH).getType().equals(Material.AIR)) {
         ++var5;
      }

      if (!block.getRelative(BlockFace.EAST).getType().equals(Material.AIR)) {
         ++var5;
      }

      if (!block.getRelative(BlockFace.NORTH).getType().equals(Material.AIR)) {
         ++var5;
      }

      if (!block.getRelative(BlockFace.WEST).getType().equals(Material.AIR)) {
         ++var5;
      }

      return var5;
   }

   @PacketListener(
      packetTypes = {ClientPacket.BLOCK_PLACE, ClientPacket.USE_ITEM}
   )
   public void handle(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      a1 var7 = (a1)this.getStorage(var6);
      PacketContainer var8 = event.getPacket();
      if (event.getPacketType() == Client.BLOCK_PLACE) {
         Integer var9 = (Integer)var8.getIntegers().readSafely(0);
         if (var9 == null) {
            var9 = 0;
         }

         if (var9 == 255) {
            a1.b(var7, System.currentTimeMillis());
         }
      }

   }

   private static double toLong(Long value) {
      return (double)value.longValue();
   }
}
