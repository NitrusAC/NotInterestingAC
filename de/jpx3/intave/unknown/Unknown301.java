package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.dT;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class Unknown301 extends UnknownCheck {
   private void b(Player var1, PacketContainer var2) {
      this.a(var1, var2);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      g = {ServerPacket.ABILITIES, ServerPacket.ATTACH_ENTITY, ServerPacket.CLOSE_WINDOW, ServerPacket.ENTITY_DESTROY, ServerPacket.ENTITY_LOOK, ServerPacket.ENTITY_METADATA, ServerPacket.ENTITY_MOVE_LOOK, ServerPacket.ENTITY_STATUS, ServerPacket.ENTITY_TELEPORT, ServerPacket.MOUNT, ServerPacket.NAMED_ENTITY_SPAWN, ServerPacket.OPEN_WINDOW, ServerPacket.PLAYER_INFO, ServerPacket.PLAYER_LIST_HEADER_FOOTER, ServerPacket.POSITION, ServerPacket.REL_ENTITY_MOVE, ServerPacket.REL_ENTITY_MOVE_LOOK, ServerPacket.REMOVE_ENTITY_EFFECT, ServerPacket.RESPAWN, ServerPacket.SPAWN_ENTITY, ServerPacket.SPAWN_ENTITY_LIVING, ServerPacket.WINDOW_ITEMS, ServerPacket.WORLD_BORDER}
   )
   public void a(PacketEvent var1) {
      if (!Bukkit.isPrimaryThread()) {
         var1.setCancelled(true);
         Player var5 = var1.getPlayer();
         PacketContainer var6 = var1.getPacket();
         IntaveScheduler.runTask(this::b);
         dT.b(var1.getPacketType());
      }

   }

   private void a(Player var1, PacketContainer var2) {
      ProtocolManager.sendPacket(var1, var2);
   }
}
