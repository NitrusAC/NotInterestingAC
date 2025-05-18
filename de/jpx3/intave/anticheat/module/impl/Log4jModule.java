package de.jpx3.intave.anticheat.module.impl;

import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.unknown.Unknown254;
import java.util.regex.Pattern;
import org.bukkit.entity.Player;

public final class Log4jModule extends Unknown254 {
   private final IntavePlugin d;
   private static final Pattern e = Pattern.compile(
      "\\$\\{(jndi|log4j|sys|env|main|marker|java|base64|lower|upper|web|docker|kubernetes|spring|jvmrunargs|date|ctx):.*}", 2
   );

   @PacketListener(
      packetTypes = {ClientPacket.CHAT}
   )
   public void a(PacketEvent var1) {
      PacketContainer var5 = var1.getPacket();
      Player var6 = var1.getPlayer();
      PlayerData var7 = PlayerDataManager.getPlayerData(var6);
      String var8 = (String)var5.getStrings().read(0);
      if (a(var8)) {
         var5 = new PacketContainer(Client.CHAT);
         var1.setPacket(var5);
         var1.setCancelled(true);
         var7.error("Invalid message");
      }

   }

   public static boolean a(String var0) {
      return var0 == null ? false : e.matcher(var0).find();
   }

   public Log4jModule(IntavePlugin var1) {
      super("");
      this.d = var1;
   }

   @Override
   protected boolean c() {
      return true;
   }
}
