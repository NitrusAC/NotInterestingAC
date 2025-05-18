package de.jpx3.intave.anticheat.check.heuristic.attack;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.ReachUtil;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.reach.ReachResult;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class AttackHeuristicCheck extends PartialConfigurableCheck {
   private final IntavePlugin plugin = IntavePlugin.getInstance();

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.HELD_ITEM_SLOT}
   )
   public void handleBlock(PacketEvent event) {
      Player var5 = event.getPlayer();
      AttackHeuristicStorage var6 = (AttackHeuristicStorage)this.getStorage(var5);
      PacketContainer var7 = event.getPacket();
      Integer var8 = (Integer)var7.getIntegers().read(0);
      ItemStack var9 = var5.getInventory().getItem(var8);
      if (var9 != null) {
         var6.c = 0;
      }
   }

   private boolean check(Player player, PlayerData data, TrackedEntity entity) {
      PlayerStorage var7 = data.getStorage();
      BukkitEnginePlayer var8 = var7.getPhysicsHolder();
      VersionHolder var9 = var7.getVersionHolder();
      float var10 = 0.25F;
      double var11 = (double)(this.getReach(player.getGameMode() == GameMode.CREATIVE) + 1.0F);
      float var13 = var8.lastYaw % 360.0F;
      float var14 = var8.yaw % 360.0F;
      boolean var15 = var9.getVersionId() == VersionHolder.V_1_8_8;
      boolean var16 = var9.getVersionId() >= 314;
      ReachResult var17 = ReachUtil.getResult(player, entity, var15, var8.lastX, var8.lastY, var8.lastZ, var14, var8.pitch, (double)var10);
      if (var17.getDistance() > var11) {
         return false;
      } else {
         if (!var16) {
            var17 = ReachUtil.getResult(player, entity, true, var8.lastX, var8.lastY, var8.lastZ, var13, var8.pitch, (double)var10);
         }

         return var17.getDistance() <= var11;
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void handleUseEntity(PacketEvent event) {
      Player var5 = event.getPlayer();
      PacketContainer var6 = event.getPacket();
      EntityUseAction var7 = (EntityUseAction)var6.getEntityUseActions().readSafely(0);
      if (var7 == null) {
         var7 = ((WrappedEnumEntityUseAction)var6.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var7 == EntityUseAction.ATTACK) {
         ((AttackHeuristicStorage)this.getStorage(var5)).attacked = true;
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.VEHICLE_MOVE}
   )
   public void handleFlying(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      VersionHolder var7 = var6.getStorage().getVersionHolder();
      PlayerHolder var8 = var6.getStorage().getPlayerHolder();
      BukkitEnginePlayer var9 = var6.getStorage().getPhysicsHolder();
      TrackedEntity var10 = var8.getAttacked();
      if (var10 != null && var10.y && var9.teleportTicks >= 5) {
         if (!var7.isRewindVersion()) {
            boolean var11 = var10.h || var10.o;
            if (!var11) {
               AttackHeuristicStorage var12 = (AttackHeuristicStorage)this.getStorage(var5);

               try {
                  if (var10.isDesyncOffsetLargerThan(0.1) && !(var8.getHitDistance() < 1.0) && var10.w >= 200) {
                     boolean var13 = var12.c < 5;
                     if (!var13 && var12.a && !var12.attacked) {
                        boolean var14 = this.check(var5, var6, var10);
                        if (var14) {
                           ++var12.f;
                        }
                     }

                     if (var12.attacked) {
                        ++var12.e;
                     }

                     if (var12.e < 100) {
                        return;
                     }

                     if (var12.f < 4) {
                        boolean var21 = var7.getVersionId() == VersionHolder.V_1_8_8;
                        String var15 = "attacks seem automated (" + var12.f + "f) | " + var7.getVersionString();
                        Certainty var16;
                        if (var21) {
                           var16 = var12.f == 0 ? Certainty.LIKELY : Certainty.PROBABLE;
                        } else {
                           var16 = Certainty.NONE;
                        }

                        Anomaly var17 = Anomaly.of("231", var16, CombatCheckType.KILLAURA, var15, 4);
                        ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var17);
                        var6.a(Unknown227.DMG_MEDIUM, "231");
                     }

                     var12.e = 0;
                     var12.f = 0;
                     return;
                  }
               } finally {
                  ++var12.c;
                  var12.attacked = false;
                  var12.a = false;
               }

            }
         }
      }
   }

   private float getReach(boolean isCreative) {
      return (isCreative ? 5.0F : 3.0F) - 0.005F;
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void b(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = this.getPlayerData(var2);
      ((AttackHeuristicStorage)this.getStorage(var3)).a = true;
   }

   public AttackHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, AttackHeuristicStorage.class);
   }
}
