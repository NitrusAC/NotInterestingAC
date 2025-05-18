package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerInfoAction;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.module.Module;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import java.util.List;
import org.bukkit.entity.Player;

public final class Unknown3 implements Module {
   private static final long a = 10000L;

   private void a(Unknown148 var1, PacketContainer var2) {
      PlayerInfoAction var3 = (PlayerInfoAction)var2.getPlayerInfoAction().read(0);
      if (var3 == PlayerInfoAction.UPDATE_LATENCY) {
         if (System.currentTimeMillis() - var1.u >= 10000L) {
            List var4 = (List)var2.getPlayerInfoDataLists().readSafely(0);
            this.a(var1, var4, var2);
         }

      }
   }

   private void a(Unknown148 var1, List var2, PacketContainer var3) {
      int var4 = var1.l();
      WrappedGameProfile var5 = var1.c();
      String var6 = var5.getName();
      WrappedChatComponent var7 = WrappedChatComponent.fromText(var6);
      PlayerInfoData var8 = new PlayerInfoData(var5, var4, var1.o(), var7);
      var2.add(var8);
      var3.getPlayerInfoDataLists().write(0, var2);
      var1.u = System.currentTimeMillis();
   }

   public Unknown3(IntavePlugin var1) {
      var1.b().b(this);
   }

   @PacketListener(
      g = {ServerPacket.PLAYER_INFO}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PacketContainer var6 = var1.getPacket();
      PlayerData var7 = PlayerDataManager.getPlayerData(var5);
      Unknown148 var8 = var7.getStorage().getPlayerHolder().b();
      if (var8 != null) {
         this.a(var8, var6);
      }
   }
}
