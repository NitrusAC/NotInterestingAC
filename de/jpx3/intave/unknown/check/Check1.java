package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.wrap.modal.EntityAction;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.nms.WrappedEntityAction;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown29;
import org.bukkit.entity.Player;

public final class Check1 extends PartialConfigurableCheck {
   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      Unknown29 var7 = (Unknown29)this.getStorage(var6);
      PacketContainer var8 = var1.getPacket();
      EntityUseAction var9 = (EntityUseAction)var8.getEntityUseActions().readSafely(0);
      if (var9 == null) {
         var9 = ((WrappedEnumEntityUseAction)var8.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var9 == EntityUseAction.ATTACK) {
         Unknown29.c(var7, 0);
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.ENTITY_ACTION}
   )
   public void b(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      Unknown29 var7 = (Unknown29)this.getStorage(var6);
      EntityAction var8 = WrappedEntityAction.readEntityAction(var1.getPacket());
      if (var8 == EntityAction.START_SPRINTING) {
         Unknown29.a(var7, true);
      } else if (var8 == EntityAction.STOP_SPRINTING) {
         Unknown29.b(var7, true);
      }

   }

   public Check1(HeuristicCheckGroup var1) {
      super(var1, Unknown29.class);
   }

   private void a(Unknown29 var1) {
      Unknown29.d(var1);
      Unknown29.a(var1, false);
      Unknown29.b(var1, false);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK, ClientPacket.FLYING}
   )
   public void c(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      Unknown29 var7 = (Unknown29)this.getStorage(var6);
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      if (var8.teleportTicks != 0) {
         if (Unknown29.b(var7) == 0) {
            Unknown29.a(var7);
            if (Unknown29.c(var7)) {
               Unknown29.g(var7);
            }
         }

         if (Unknown29.f(var7) > 10) {
            double var9 = (double)Unknown29.e(var7) / (double)Unknown29.f(var7);
            if (var9 > 0.9) {
               Anomaly var11 = Anomaly.of(
                  "200", Certainty.NONE, CombatCheckType.KILLAURA, "sprint-toggles aligned with attacks (" + MathUtil2.getStringRounded(var9, 2) + "%)", 64
               );
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var11);
            }

            Unknown29.b(var7, 0);
            Unknown29.a(var7, 0);
         }

         this.a(var7);
      }
   }
}
