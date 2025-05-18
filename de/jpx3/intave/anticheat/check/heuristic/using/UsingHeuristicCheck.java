package de.jpx3.intave.anticheat.check.heuristic.using;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.Direction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ServerUtil;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class UsingHeuristicCheck extends PartialConfigurableCheck {
   private void releaseItem(PlayerData data) {
      Player var2 = data.getPlayer();
      if (!ServerUtil.getServerVersion().isAtLeast(MinecraftVersion.V_1_9)) {
         PacketContainer var3 = ProtocolLibrary.getProtocolManager().createPacket(Client.BLOCK_DIG);
         var3.getBlockPositionModifier().write(0, new BlockPosition(0, 0, 0));
         var3.getDirections().write(0, Direction.DOWN);
         var3.getPlayerDigTypes().write(0, PlayerDigType.RELEASE_USE_ITEM);
         this.getPlayerData(var2).c();
         ProtocolManager.receivePacket(var2, var3);
         this.resetPhysicsItem(var2);
         IntaveScheduler.runTask(var2::updateInventory);
      }
   }

   private void handle(PacketEvent event) {
      Player var4 = event.getPlayer();
      PlayerData var5 = this.getPlayerData(var4);
      if (var5.getStorage().getItemHolder().h()) {
         Anomaly var6 = Anomaly.of("162", Certainty.NONE, CombatCheckType.KILLAURA, "attacked whilst using an item");
         ((HeuristicCheckGroup)this.getParent()).logAnomaly(var4, var6);
         var5.a(Unknown227.BLOCKING, "28");
         this.releaseItem(var5);
      }

   }

   private void resetPhysicsItem(Player player) {
      PlayerData var2 = PlayerDataManager.getPlayerData(player);
      ItemHolder var3 = var2.getStorage().getItemHolder();
      var3.resetItem();
   }

   private void handle(Player player, PacketContainer packet) {
      PlayerData var6 = this.getPlayerData(player);
      PlayerHolder var7 = var6.getStorage().getPlayerHolder();
      VersionHolder var8 = var6.getStorage().getVersionHolder();
      TrackedEntity var9 = var7.getAttacked();
      if (var9 != null && var9.y && var9.r().e()) {
         if (var8.getVersionId() == VersionHolder.V_1_8_8) {
            EntityUseAction var10 = (EntityUseAction)packet.getEntityUseActions().readSafely(0);
            if (var10 == null) {
               var10 = ((WrappedEnumEntityUseAction)packet.getEnumEntityUseActions().read(0)).getAction();
            }

            if (var10 == EntityUseAction.ATTACK && var9.o) {
               String var11 = "attacked a dead entity " + var9.t();
               Anomaly var12 = Anomaly.of("161", Certainty.NONE, CombatCheckType.KILLAURA, var11);
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(player, var12);
            }

         }
      }
   }

   @PacketListener(
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void handleUseEntity(PacketEvent event) {
      Player var5 = event.getPlayer();
      PacketContainer var6 = event.getPacket();
      PlayerData var7 = this.getPlayerData(var5);
      VersionHolder var8 = var7.getStorage().getVersionHolder();
      EntityUseAction var9 = (EntityUseAction)var6.getEntityUseActions().readSafely(0);
      if (var9 == null) {
         var9 = ((WrappedEnumEntityUseAction)var6.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var9 == EntityUseAction.ATTACK) {
         if (var8.getVersionId() <= VersionHolder.V_1_8_8) {
            this.check(var5);
         }

         this.handle(var5, var6);
         this.handle(event);
      }
   }

   public UsingHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, UsingHeuristicStorage.class);
   }

   private void check(Player player) {
      PlayerData var4 = this.getPlayerData(player);
      UsingHeuristicStorage var5 = (UsingHeuristicStorage)this.getStorage(var4);
      VersionHolder var6 = var4.getStorage().getVersionHolder();
      EntityHolder var7 = var4.getStorage().getEntityHolder();
      float var8 = var7.playerMaxHealth;
      if (var8 <= 0.0F) {
         long var9 = System.currentTimeMillis();
         long var11 = var9 - var5.lastFlag;
         int var13 = var7.lastHealthUpdate;
         Certainty var14 = var11 > 1000L ? Certainty.PROBABLE : Certainty.NONE;
         String var15 = "attacked in gui screen (version " + var6.getVersionString() + ") | ";
         var15 = var15 + "lastHealthUpdate: " + var13 + ", ";
         var15 = var15 + "lastFlag " + var11 + " ms ago, ";
         var15 = var15 + "confidence " + var14.getLevel();
         Anomaly var16 = Anomaly.of("161", var14, CombatCheckType.KILLAURA, var15);
         ((HeuristicCheckGroup)this.getParent()).logAnomaly(player, var16);
         var5.lastFlag = var9;
      }

   }
}
