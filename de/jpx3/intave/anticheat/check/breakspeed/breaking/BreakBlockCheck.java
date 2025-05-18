package de.jpx3.intave.anticheat.check.breakspeed.breaking;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.breakspeed.BreakSpeedCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown15;
import de.jpx3.intave.unknown.Unknown283;
import de.jpx3.intave.unknown.Unknown286;
import de.jpx3.intave.unknown.Unknown81;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public final class BreakBlockCheck extends PartialConfigurableCheck {
   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      packetTypes = {ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK, ClientPacket.FLYING, ClientPacket.VEHICLE_MOVE}
   )
   public void handleFlying(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = this.getPlayerData(var2);
      BreakBlockStorage var4 = (BreakBlockStorage)this.getStorage(var3);
      BreakBlockStorage.tickFlying(var4);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      packetTypes = {ClientPacket.BLOCK_DIG}
   )
   public void handleDig(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      BreakBlockStorage var7 = (BreakBlockStorage)this.getStorage(var6);
      VersionHolder var8 = var6.getStorage().getVersionHolder();
      PacketContainer var9 = event.getPacket();
      PlayerDigType var10 = (PlayerDigType)var9.getPlayerDigTypes().read(0);
      switch(Unknown81.a[var10.ordinal()]) {
         case 1:
            if (var8.isLegacy()) {
               int var18 = BreakBlockStorage.getFlyingTicks(var7) - BreakBlockStorage.f(var7);
               if (var18 < 5) {
                  String var12 = "started breaking too quickly";
                  String var13 = var18 == 1 ? "one tick" : var18 + " ticks";
                  Unknown286 var14 = MoudleLoader.violations();
                  Violation var15 = Violation.builder(BreakSpeedCheckGroup.class).player(var5).name(var12).description(var13).vl(5.0).build();
                  ImmutableViolation var16 = var14.dispatchViolation(var15);
                  if (var16.m()) {
                     event.setCancelled(true);
                     BreakBlockStorage.a(var7, true);
                  }
               }
            } else {
               long var19 = System.currentTimeMillis() - BreakBlockStorage.a(var7);
               if (var19 < 200L) {
                  if (BreakBlockStorage.h(var7) > 5.0) {
                     String var20 = "started breaking too quickly";
                     String var21 = var19 + "ms between";
                     Unknown286 var22 = MoudleLoader.violations();
                     Violation var23 = Violation.builder(BreakSpeedCheckGroup.class).player(var5).name(var20).description(var21).vl(1.0).build();
                     ImmutableViolation var17 = var22.dispatchViolation(var23);
                     if (var17.m()) {
                        event.setCancelled(true);
                        BreakBlockStorage.a(var7, true);
                     }

                     BreakBlockStorage.g(var7);
                  }
               } else if (BreakBlockStorage.b(var7) > 0.0) {
                  BreakBlockStorage.a(var7, BreakBlockStorage.b(var7) - 0.2);
               }
            }
            break;
         case 2:
            BreakBlockStorage.a(var7, BreakBlockStorage.getFlyingTicks(var7));
            BreakBlockStorage.a(var7, System.currentTimeMillis());
            if (BreakBlockStorage.c(var7)) {
               BreakBlockStorage.a(var7, false);
               event.setCancelled(true);
               BlockPosition var11 = (BlockPosition)event.getPacket().getModifier().withType(ReflectionUtil.getClazz("BlockPosition"), Unknown283.c()).read(0);
               this.b(var5, var11.toLocation(var5.getWorld()));
            }
      }

   }

   private void b(Player var1, Location var2) {
      IntaveScheduler.runTask(this::c);
   }

   public BreakBlockCheck(BreakSpeedCheckGroup group) {
      super(group, BreakBlockStorage.class);
   }

   private void c(Player player, Location location) {
      player.updateInventory();
      this.a(player, location);
   }

   private void a(Player player, Location location) {
      PacketContainer var6 = ProtocolLibrary.getProtocolManager().createPacket(Server.BLOCK_CHANGE);
      if (WorldUtil.isChunkLoaded(location.getWorld(), location.getBlockX(), location.getBlockZ())) {
         Block var7 = WorldUtil.getBlockAt(location);
         Object var8 = Unknown15.a(var7);
         WrappedBlockData var9 = WrappedBlockData.fromHandle(var8);
         var6.getBlockData().write(0, var9);
         BlockPosition var10 = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
         var6.getBlockPositionModifier().write(0, var10);
         ProtocolManager.sendPacket(player, var6);
      }
   }
}
