package de.jpx3.intave.anticheat.module.impl;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.event.ArmSwingEvent;
import de.jpx3.intave.anticheat.event.EntityAttackEntityEvent;
import de.jpx3.intave.anticheat.event.PlayerMoveEvent;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.module.Module;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.anticheat.packet.wrap.impl.CPacketUseEntity;
import java.util.function.BiConsumer;
import org.bukkit.entity.Player;

public final class AutoclickerCheckGroup implements Module {
   private final BiConsumer consumer;

   @PacketListener(
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void handleArmAnimation(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      ArmSwingEvent var4 = ArmSwingEvent.ofEmpty();
      this.consumer.accept(var3, var4::accept);
   }

   @PacketListener(
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void handleUseEntity(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = event.getPacket();
      CPacketUseEntity var8 = (CPacketUseEntity)PacketInterpreters.getInterpreter(var7);
      if (var8.getAction() == EntityUseAction.ATTACK) {
         int var9 = var5.getEntityId();
         int var10 = var8.getEntityId();
         EntityAttackEntityEvent var11 = EntityAttackEntityEvent.of(var9, var10);
         this.consumer.accept(var6, var11::accept);
      }

      var8.reset();
   }

   public AutoclickerCheckGroup(BiConsumer consumer) {
      this.consumer = consumer;
   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.VEHICLE_MOVE}
   )
   public void handleFlying(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      double var8 = var7.x;
      double var10 = var7.y;
      double var12 = var7.z;
      double var14 = var7.lastX;
      double var16 = var7.lastY;
      double var18 = var7.lastZ;
      float var20 = var7.yaw;
      float var21 = var7.pitch;
      float var22 = var7.lastYaw;
      float var23 = var7.lastPitch;
      PlayerMoveEvent var24;
      if (var7.flyingClickGroupTicks++ % 200L == 0L) {
         var24 = PlayerMoveEvent.of(var8, var10, var12, var20, var21);
      } else {
         var24 = PlayerMoveEvent.of(var8, var10, var12, var14, var16, var18, var20, var21, var22, var23);
      }

      this.consumer.accept(var6, var24::accept);
   }
}
