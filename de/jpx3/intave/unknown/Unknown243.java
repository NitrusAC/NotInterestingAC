package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerInfoAction;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public final class Unknown243 extends Unknown254 {
   private final IntavePlugin d;

   public Unknown243(IntavePlugin var1) {
      super("");
      this.d = var1;
   }

   private boolean a(OfflinePlayer var1) {
      return var1 != null && (var1.isOnline() || Bukkit.getPlayer(var1.getUniqueId()) != null);
   }

   @PacketListener(
      g = {ServerPacket.PLAYER_INFO}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PacketContainer var6 = var1.getPacket();
      PlayerInfoAction var7 = (PlayerInfoAction)var6.getPlayerInfoAction().read(0);
      if (var7 == PlayerInfoAction.UPDATE_LATENCY) {
         List var8 = (List)var6.getLists(Unknown225.f()).read(0);
         var8.removeIf(this::b);
         Collections.shuffle(var8);
      }

   }

   private boolean b(Player var1, PlayerInfoData var2) {
      UUID var6 = var2.getProfile().getUUID();
      OfflinePlayer var7 = Bukkit.getOfflinePlayer(var6);
      if (this.a(var7)) {
         Player var8 = var7.getPlayer();
         return !var1.canSee(var8);
      } else {
         return false;
      }
   }

   @Override
   protected boolean c() {
      return true;
   }
}
