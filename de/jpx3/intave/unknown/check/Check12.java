package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.EnumWrappers.ClientCommand;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class Check12 extends UnknownCheck {
   private static final String e;

   private void b(Player var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var1);
      ItemHolder var3 = var2.getStorage().getItemHolder();
      var3.b(false);
   }

   private void b(Player var1, Object var2) {
      this.b(var1);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.CLOSE_WINDOW},
      c = false
   )
   public void c(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      MoudleLoader.m().a(var2, null, this::b);
   }

   private void a(Player var1, Object var2) {
      this.a(var1);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.CLOSE_WINDOW}
   )
   public void a(PacketEvent var1) {
      this.b(var1.getPlayer());
   }

   private void a(Player var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var1);
      ItemHolder var3 = var2.getStorage().getItemHolder();
      if (!this.a(var2)) {
         var3.b(true);
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.OPEN_WINDOW},
      c = false
   )
   public void d(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      ItemHolder var7 = var6.getStorage().getItemHolder();
      PacketContainer var8 = var1.getPacket();
      WrappedChatComponent var9 = (WrappedChatComponent)var8.getChatComponents().read(0);
      String var10 = var9.getJson();
      boolean var11 = var10.contains("container.beacon");
      if (!var11) {
         MoudleLoader.m().a(var5, null, this::a);
         var7.d = true;
      } else {
         var7.d = false;
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.RESPAWN},
      c = false
   )
   public void e(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      ItemHolder var4 = var3.getStorage().getItemHolder();
      var4.b(false);
   }

   private boolean a(PlayerData var1) {
      World var2 = var1.getPlayer().getWorld();
      BukkitEnginePlayer var3 = var1.getStorage().getPhysicsHolder();
      return CollisionUtil.a(var2, var3.getBoundingBox(), IntaveMaterial.PORTAL);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.CLIENT_COMMAND}
   )
   public void b(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ClientCommand var3 = (ClientCommand)var1.getPacket().getClientCommands().read(0);
      if (var3 == ClientCommand.OPEN_INVENTORY_ACHIEVEMENT) {
         this.a(var2);
      }

   }
}
