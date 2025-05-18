package de.jpx3.intave.anticheat.check.breakspeed.fastbreak;

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
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown15;
import de.jpx3.intave.unknown.Unknown158;
import de.jpx3.intave.unknown.Unknown232;
import de.jpx3.intave.unknown.Unknown270;
import de.jpx3.intave.unknown.Unknown283;
import de.jpx3.intave.unknown.Unknown286;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class FastBreakCheck extends PartialConfigurableCheck {
   private void run(Player var1, Location var2) {
      IntaveScheduler.runTask(this::unstuck);
   }

   public FastBreakCheck(BreakSpeedCheckGroup something) {
      super(something, FastBreakStorage.class);
   }

   private void fixBlock(Player var1, Location var2) {
      PacketContainer var6 = ProtocolLibrary.getProtocolManager().createPacket(Server.BLOCK_CHANGE);
      if (WorldUtil.isChunkLoaded(var2.getWorld(), var2.getBlockX(), var2.getBlockZ())) {
         Block var7 = WorldUtil.getBlockAt(var2);
         Object var8 = Unknown15.a(var7);
         WrappedBlockData var9 = WrappedBlockData.fromHandle(var8);
         var6.getBlockData().write(0, var9);
         BlockPosition var10 = new BlockPosition(var2.getBlockX(), var2.getBlockY(), var2.getBlockZ());
         var6.getBlockPositionModifier().write(0, var10);
         ProtocolManager.sendPacket(var1, var6);
      }
   }

   private long fixFloat(float var1) {
      if (var1 == 0.0F) {
         return 0L;
      } else {
         long var5 = 0L;
         float var7 = 0.0F;
         int var8 = 100;

         while(var7 < 1.0F) {
            var7 += var1;
            var5 += 50L;
            if (--var8 < 0) {
               break;
            }
         }

         return var5;
      }
   }

   private void unstuck(Player player, Location pos) {
      player.updateInventory();
      this.fixBlock(player, pos);
   }

   private float a(Player var1, ItemStack var2, BlockPosition var3) {
      boolean var4 = Unknown158.a(var1);
      Unknown158.a(var1, true);
      float var5 = Unknown232.a(var1, var2, var3);
      Unknown158.a(var1, var4);
      return var5;
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK, ClientPacket.FLYING, ClientPacket.VEHICLE_MOVE}
   )
   public void b(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      FastBreakStorage var7 = (FastBreakStorage)this.getStorage(var6);
      if (var7.a > 0.0 && !event.isCancelled()) {
         var7.a -= 0.005;
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.BLOCK_DIG}
   )
   public void handleBlockPacket(PacketEvent event) {
      Player var6 = event.getPlayer();
      PlayerData var7 = this.getPlayerData(var6);
      FastBreakStorage var8 = (FastBreakStorage)this.getStorage(var7);
      ItemHolder var9 = var7.getStorage().getItemHolder();
      ItemStack var10 = var9.getItemInHand();
      PacketContainer var11 = event.getPacket();
      BlockPosition var12 = (BlockPosition)event.getPacket().getModifier().withType(ReflectionUtil.getClazz("BlockPosition"), Unknown283.c()).read(0);
      PlayerDigType var13 = (PlayerDigType)var11.getPlayerDigTypes().read(0);
      switch(Unknown270.a[var13.ordinal()]) {
         case 1:
            float var25 = Unknown232.a(var6, var10, var12);
            var8.destroying = true;
            var8.lastInteractBlock = System.currentTimeMillis();
            var8.g = var25;
            var8.destroyingPosition = var12;
            var8.f = var25;
            break;
         case 2:
            long var14 = this.fixFloat(this.a(var6, var10, var12));
            long var16 = System.currentTimeMillis() - var8.lastInteractBlock;
            long var18 = Math.max(0L, var14 - var16);
            if (var18 > 100L && var8.a++ >= 2.0) {
               String var20 = "broke block too quickly";
               String var21 = MathUtil2.getStringRounded((double)var18 / 50.0, 2) + " ticks faster than expected";
               Unknown286 var22 = MoudleLoader.violations();
               Violation var23 = Violation.builder(BreakSpeedCheckGroup.class).player(var6).name(var20).description(var21).vl(10.0).build();
               ImmutableViolation var24 = var22.dispatchViolation(var23);
               if (var24.m()) {
                  event.setCancelled(true);
                  this.run(var6, var12.toLocation(var6.getWorld()));
               }
            }

            var8.lastInteractBlock = System.currentTimeMillis();
            var8.g = 0.0F;
            var8.destroyingPosition = null;
            var8.destroying = false;
            var8.f = Float.MIN_VALUE;
      }

   }
}
