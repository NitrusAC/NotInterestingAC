package de.jpx3.intave.anticheat.packet.adapter;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.unknown.Unknown173;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import org.bukkit.entity.Player;

public final class ForwardingPacketAdapter extends Unknown173 {
   private static final boolean a = Arrays.stream(PacketEvent.class.getMethods()).anyMatch(ForwardingPacketAdapter::b);
   private final Collection b;

   public void onPacketSending(PacketEvent var1) {
      if (!a || !var1.isPlayerTemporary()) {
         Player var5 = var1.getPlayer();
         if (var5 != null) {
            PlayerData var6 = PlayerDataManager.getPlayerData(var5);
            if (var6 != null) {
               if (!var6.m()) {
                  for(PacketAdapter var8 : this.b) {
                     var8.onPacketSending(var1);
                  }

               }
            }
         }
      }
   }

   private static boolean b(Method var0) {
      return var0.getName().equalsIgnoreCase("isPlayerTemporary");
   }

   public void onPacketReceiving(PacketEvent var1) {
      if (!a || !var1.isPlayerTemporary()) {
         PlayerData var5 = PlayerDataManager.getPlayerData(var1.getPlayer());
         if (var5 != null) {
            if (var5.v()) {
               var5.y();
            } else {
               for(PacketAdapter var7 : this.b) {
                  var7.onPacketReceiving(var1);
               }

            }
         }
      }
   }

   public String toString() {
      return "ForwardingPacketAdapter{targetList=" + this.b + '}';
   }

   public ForwardingPacketAdapter(IntavePlugin var1, PacketType var2, Collection var3) {
      super(var1, ListenerPriority.LOWEST, new PacketType[]{var2});
      this.b = var3;
   }
}
